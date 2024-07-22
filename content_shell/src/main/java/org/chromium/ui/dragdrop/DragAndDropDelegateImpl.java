package org.chromium.ui.dragdrop;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.DragAndDropPermissions;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import com.example.chromium_content_view.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.chromium.base.ContextUtils;
import org.chromium.base.MathUtils;
import org.chromium.base.metrics.RecordHistogram;
import org.chromium.ui.accessibility.AccessibilityState;
import org.chromium.ui.base.MimeTypeUtils;

public class DragAndDropDelegateImpl implements DragAndDropDelegate, DragStateTracker {

  private DragAndDropBrowserDelegate mDragAndDropBrowserDelegate;
  private long mDragStartSystemElapsedTime;
  private float mDragStartXDp;
  private float mDragStartYDp;
  private int mDragTargetType;
  private boolean mIsDragStarted;
  private boolean mIsDropOnView;
  private int mShadowHeight;
  private int mShadowWidth;

  @Retention(RetentionPolicy.SOURCE)
  @interface DragTargetType {
    public static final int BROWSER_CONTENT = 4;
    public static final int IMAGE = 2;
    public static final int INVALID = 0;
    public static final int LINK = 3;
    public static final int NUM_ENTRIES = 5;
    public static final int TEXT = 1;
  }

  @Override
  public boolean startDragAndDrop(
      View containerView,
      Bitmap shadowImage,
      DropDataAndroid dropData,
      int cursorOffsetX,
      int cursorOffsetY,
      int dragObjRectWidth,
      int dragObjRectHeight) {
    if (isA11yStateEnabled()) {
      return false;
    }
    int windowWidth = containerView.getRootView().getWidth();
    int windowHeight = containerView.getRootView().getHeight();
    View.DragShadowBuilder dragShadowBuilder =
        createDragShadowBuilder(
            containerView,
            shadowImage,
            dropData.hasImage(),
            windowWidth,
            windowHeight,
            cursorOffsetX,
            cursorOffsetY,
            dragObjRectWidth,
            dragObjRectHeight);
    return startDragAndDropInternal(containerView, dragShadowBuilder, dropData);
  }

  @Override
  public boolean startDragAndDrop(
      View containerView, View.DragShadowBuilder dragShadowBuilder, DropDataAndroid dropData) {
    if (isA11yStateEnabled()) {
      return false;
    }
    return startDragAndDropInternal(containerView, dragShadowBuilder, dropData);
  }

  private static boolean isA11yStateEnabled() {
    return AccessibilityState.isTouchExplorationEnabled()
        || AccessibilityState.isPerformGesturesEnabled();
  }

  private boolean startDragAndDropInternal(
      View containerView, View.DragShadowBuilder dragShadowBuilder, DropDataAndroid dropData) {
    ClipData clipdata = buildClipData(dropData);
    if (clipdata == null) {
      return false;
    }
    this.mIsDragStarted = true;
    this.mDragStartSystemElapsedTime = SystemClock.elapsedRealtime();
    this.mDragTargetType = getDragTargetType(dropData);
    Object myLocalState = null;
    DragAndDropBrowserDelegate dragAndDropBrowserDelegate = this.mDragAndDropBrowserDelegate;
    if (dragAndDropBrowserDelegate != null && dragAndDropBrowserDelegate.getSupportDropInChrome()) {
      myLocalState = dropData;
    }
    return containerView.startDragAndDrop(
        clipdata, dragShadowBuilder, myLocalState, buildFlags(dropData));
  }

  @Override
  public void setDragAndDropBrowserDelegate(DragAndDropBrowserDelegate delegate) {
    this.mDragAndDropBrowserDelegate = delegate;
  }

  @Override
  public boolean isDragStarted() {
    return this.mIsDragStarted;
  }

  @Override
  public int getDragShadowWidth() {
    return this.mShadowWidth;
  }

  @Override
  public int getDragShadowHeight() {
    return this.mShadowHeight;
  }

  @Override
  public void destroy() {
    reset();
    this.mDragAndDropBrowserDelegate = null;
  }

  @Override // android.view.View.OnDragListener
  public boolean onDrag(View view, DragEvent dragEvent) {
    if (!this.mIsDragStarted) {
      DragAndDropBrowserDelegate dragAndDropBrowserDelegate = this.mDragAndDropBrowserDelegate;
      if (dragAndDropBrowserDelegate != null
          && dragAndDropBrowserDelegate.getSupportDropInChrome()
          && dragEvent.getAction() == 3) {
        onDropFromOutside(dragEvent);
      }
      return false;
    }
    switch (dragEvent.getAction()) {
      case 1:
        onDragStarted(dragEvent);
        break;
      case 3:
        onDrop(dragEvent);
        break;
      case 4:
        onDragEnd(dragEvent);
        reset();
        break;
    }
    return false;
  }

  protected ClipData buildClipData(DropDataAndroid dropData) {
    Intent intent;
    int type = getDragTargetType(dropData);
    switch (type) {
      case 0:
        return null;
      case 1:
        return new ClipData(
            null,
            new String[] {MimeTypeUtils.TEXT_MIME_TYPE, MimeTypeUtils.CHROME_MIMETYPE_TEXT},
            new ClipData.Item(dropData.text));
      case 2:
        Uri cachedUri = DropDataProviderUtils.cacheImageData(dropData);
        if (cachedUri == null) {
          return null;
        }
        ClipData clipData =
            ClipData.newUri(
                ContextUtils.getApplicationContext().getContentResolver(), null, cachedUri);
        if (dropData.hasLink()) {
          clipData.addItem(
              ContextUtils.getApplicationContext().getContentResolver(),
              new ClipData.Item(dropData.gurl.getSpec()));
        }
        return clipData;
      case 3:
        DragAndDropBrowserDelegate dragAndDropBrowserDelegate = this.mDragAndDropBrowserDelegate;
        if (dragAndDropBrowserDelegate != null
            && (intent = dragAndDropBrowserDelegate.createUrlIntent(dropData.gurl.getSpec(), 1))
                != null) {
          return new ClipData(
              null,
              new String[] {
                MimeTypeUtils.TEXT_MIME_TYPE,
                "text/vnd.android.intent",
                MimeTypeUtils.CHROME_MIMETYPE_LINK
              },
              new ClipData.Item(getTextForLinkData(dropData), intent, null));
        }
        return ClipData.newPlainText(null, getTextForLinkData(dropData));
      case 4:
        return this.mDragAndDropBrowserDelegate.buildClipData(dropData);
      default:
        throw new AssertionError("Should not be reached!");
    }
  }

  protected int buildFlags(DropDataAndroid dropData) {
    if (dropData.hasBrowserContent()) {
      return 768;
    }
    int flag = 0;
    if (dropData.isPlainText() || dropData.hasLink()) {
      flag = 0 | 256;
    }
    if (dropData.hasImage()) {
      int flag2 = flag | 257;
      DragAndDropBrowserDelegate dragAndDropBrowserDelegate = this.mDragAndDropBrowserDelegate;
      if (dragAndDropBrowserDelegate != null
          && dragAndDropBrowserDelegate.getSupportAnimatedImageDragShadow()) {
        return flag2 | 512;
      }
      return flag2;
    }
    return flag;
  }

  protected View.DragShadowBuilder createDragShadowBuilder(
      View containerView,
      Bitmap shadowImage,
      boolean isImage,
      int windowWidth,
      int windowHeight,
      int cursorOffsetX,
      int cursorOffsetY,
      int dragObjRectWidth,
      int dragObjRectHeight) {
    Context context = containerView.getContext();
    ImageView imageView = new ImageView(context);
    if (!isImage) {
      this.mShadowWidth = shadowImage.getWidth();
      this.mShadowHeight = shadowImage.getHeight();
      imageView.setImageBitmap(shadowImage);
    } else if (shadowImage.getHeight() <= 1 && shadowImage.getWidth() <= 1) {
      Drawable globeIcon = AppCompatResources.getDrawable(context, R.drawable.ic_globe_24dp);
      if (globeIcon == null) {
        throw new AssertionError();
      }
      int minSize = AnimatedImageDragShadowBuilder.getDragShadowMinSize(context.getResources());
      this.mShadowWidth = minSize;
      this.mShadowHeight = minSize;
      imageView.setLayoutParams(new ViewGroup.LayoutParams(minSize, minSize));
      imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      imageView.setImageDrawable(globeIcon);
    } else {
      AnimatedImageDragShadowBuilder.DragShadowSpec dragShadowSpec =
          AnimatedImageDragShadowBuilder.getDragShadowSpec(
              context, shadowImage.getWidth(), shadowImage.getHeight(), windowWidth, windowHeight);
      updateShadowSizeWithBorder(context, dragShadowSpec.targetWidth, dragShadowSpec.targetHeight);
      DragAndDropBrowserDelegate dragAndDropBrowserDelegate = this.mDragAndDropBrowserDelegate;
      if (dragAndDropBrowserDelegate != null
          && dragAndDropBrowserDelegate.getSupportAnimatedImageDragShadow()) {
        if (dragObjRectWidth != 0) {
          if (dragObjRectHeight != 0) {
            AnimatedImageDragShadowBuilder.CursorOffset cursorOffset =
                AnimatedImageDragShadowBuilder.adjustCursorOffset(
                    cursorOffsetX,
                    cursorOffsetY,
                    dragObjRectWidth,
                    dragObjRectHeight,
                    dragShadowSpec);
            return new AnimatedImageDragShadowBuilder(
                containerView, shadowImage, cursorOffset.x, cursorOffset.y, dragShadowSpec);
          }
          throw new AssertionError();
        }
        throw new AssertionError();
      }
      updateShadowImage(
          context, shadowImage, imageView, dragShadowSpec.targetWidth, dragShadowSpec.targetHeight);
    }
    imageView.layout(0, 0, this.mShadowWidth, this.mShadowHeight);
    return new View.DragShadowBuilder(imageView);
  }

  private void updateShadowImage(
      Context context, Bitmap shadowImage, ImageView imageView, int targetWidth, int targetHeight) {
    Resources res = context.getResources();
    RoundedBitmapDrawable drawable =
        RoundedBitmapDrawableFactory.create(
            res, ThumbnailUtils.extractThumbnail(shadowImage, targetWidth, targetHeight, 2));
    drawable.setCornerRadius(res.getDimensionPixelSize(R.dimen.drag_shadow_border_corner_radius));
    imageView.setImageDrawable(drawable);
    imageView.setBackgroundResource(R.drawable.drag_shadow_background);
    int borderSize = res.getDimensionPixelSize(R.dimen.drag_shadow_border_size);
    imageView.setPadding(borderSize, borderSize, borderSize, borderSize);
  }

  private void updateShadowSizeWithBorder(Context context, int targetWidth, int targetHeight) {
    Resources res = context.getResources();
    int borderSize = res.getDimensionPixelSize(R.dimen.drag_shadow_border_size);
    this.mShadowWidth = (borderSize * 2) + targetWidth;
    this.mShadowHeight = (borderSize * 2) + targetHeight;
  }

  private void onDragStarted(DragEvent dragStartEvent) {
    this.mDragStartXDp = dragStartEvent.getX();
    this.mDragStartYDp = dragStartEvent.getY();
  }

  private void onDrop(DragEvent dropEvent) {
    this.mIsDropOnView = true;
    int dropDistance =
        Math.round(
            MathUtils.distance(
                this.mDragStartXDp, this.mDragStartYDp, dropEvent.getX(), dropEvent.getY()));
    RecordHistogram.recordExactLinearHistogram(
        "Android.DragDrop.FromWebContent.DropInWebContent.DistanceDip", dropDistance, 51);
    long dropDuration = SystemClock.elapsedRealtime() - this.mDragStartSystemElapsedTime;
    RecordHistogram.recordMediumTimesHistogram(
        "Android.DragDrop.FromWebContent.DropInWebContent.Duration", dropDuration);
  }

  private void onDropFromOutside(DragEvent dropEvent) {
    DragAndDropPermissions dragAndDropPermissions;
    DragAndDropBrowserDelegate dragAndDropBrowserDelegate = this.mDragAndDropBrowserDelegate;
    if (dragAndDropBrowserDelegate == null
        || (dragAndDropPermissions =
                dragAndDropBrowserDelegate.getDragAndDropPermissions(dropEvent))
            == null) {
      return;
    }
    dragAndDropPermissions.release();
  }

  private void onDragEnd(DragEvent dragEndEvent) {
    boolean dragResult = dragEndEvent.getResult();
    if (!this.mIsDropOnView) {
      if (this.mDragStartSystemElapsedTime <= 0) {
        throw new AssertionError();
      }
      if (this.mDragTargetType == 0) {
        throw new AssertionError();
      }
      long dragDuration = SystemClock.elapsedRealtime() - this.mDragStartSystemElapsedTime;
      recordDragDurationAndResult(dragDuration, dragResult);
      recordDragTargetType(this.mDragTargetType);
    }
    DropDataProviderUtils.clearImageCache(!this.mIsDropOnView && dragResult);
  }

  static int getDragTargetType(DropDataAndroid dropDataAndroid) {
    if (dropDataAndroid.hasBrowserContent()) {
      return 4;
    }
    if (dropDataAndroid.isPlainText()) {
      return 1;
    }
    if (dropDataAndroid.hasImage()) {
      return 2;
    }
    if (dropDataAndroid.hasLink()) {
      return 3;
    }
    return 0;
  }

  static String getTextForLinkData(DropDataAndroid dropData) {
    if (!dropData.hasLink()) {
      throw new AssertionError();
    }
    if (TextUtils.isEmpty(dropData.text)) {
      return dropData.gurl.getSpec();
    }
    String str = dropData.text;
    return str + "\n" + dropData.gurl.getSpec();
  }

  private void reset() {
    this.mShadowHeight = 0;
    this.mShadowWidth = 0;
    this.mDragTargetType = 0;
    this.mIsDragStarted = false;
    this.mIsDropOnView = false;
    this.mDragStartSystemElapsedTime = -1L;
  }

  private void recordDragTargetType(int type) {
    RecordHistogram.recordEnumeratedHistogram(
        "Android.DragDrop.FromWebContent.TargetType", type, 5);
  }

  private void recordDragDurationAndResult(long duration, boolean result) {
    String suffix = result ? "Success" : "Canceled";
    RecordHistogram.recordMediumTimesHistogram(
        "Android.DragDrop.FromWebContent.Duration." + suffix, duration);
  }

  float getDragStartXDp() {
    return this.mDragStartXDp;
  }

  float getDragStartYDp() {
    return this.mDragStartYDp;
  }
}
