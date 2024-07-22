package org.chromium.ui.resources;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.ContextThemeWrapper;
import com.example.chromium_content_view.R;
import org.chromium.base.ApiCompatibilityUtils;
import org.chromium.base.ContextUtils;
import org.jni_zero.JNINamespace;

@JNINamespace("ui")
public class HandleViewResources {

  private static final float HANDLE_HORIZONTAL_PADDING_RATIO = 0.25f;
  private static final int[] LEFT_HANDLE_ATTRS = {16843461};
  private static final int[] CENTER_HANDLE_ATTRS = {16843463};
  private static final int[] RIGHT_HANDLE_ATTRS = {16843462};

  public static Drawable getLeftHandleDrawable(Context context) {
    return getHandleDrawable(context, LEFT_HANDLE_ATTRS);
  }

  public static Drawable getCenterHandleDrawable(Context context) {
    return getHandleDrawable(context, CENTER_HANDLE_ATTRS);
  }

  public static Drawable getRightHandleDrawable(Context context) {
    return getHandleDrawable(context, RIGHT_HANDLE_ATTRS);
  }

  private static Drawable getHandleDrawable(Context context, int[] attrs) {
    TypedArray a = context.getTheme().obtainStyledAttributes(attrs);
    Drawable drawable = a.getDrawable(0);
    if (drawable == null) {
      try {
        drawable = ApiCompatibilityUtils.getDrawable(context.getResources(), a.getResourceId(0, 0));
      } catch (Resources.NotFoundException e) {
      }
    }
    a.recycle();
    return drawable;
  }

  private static Bitmap getHandleBitmap(Context activityContext, int[] attrs) {
    Context context;
    Bitmap bitmap;
    if (activityContext == null) {
      context = ContextUtils.getApplicationContext();
    } else {
      context = activityContext;
    }
    ContextThemeWrapper context2 =
        new ContextThemeWrapper(context, R.style.ThemeOverlay_UI_SelectionHandle);
    TypedArray a = context2.getTheme().obtainStyledAttributes(attrs);
    int resId = a.getResourceId(a.getIndex(0), 0);
    Resources res = a.getResources();
    a.recycle();
    Bitmap.Config config = Bitmap.Config.ARGB_8888;
    BitmapFactory.Options options = new BitmapFactory.Options();
    options.inJustDecodeBounds = false;
    options.inPreferredConfig = config;
    Bitmap bitmap2 = BitmapFactory.decodeResource(res, resId, options);
    if (bitmap2 != null) {
      return bitmap2;
    }
    if (res == context2.getResources()
        || (bitmap = BitmapFactory.decodeResource(context2.getResources(), resId, options))
            == null) {
      Drawable drawable = getHandleDrawable(context2, attrs);
      if (drawable == null) {
        throw new AssertionError();
      }
      int width = drawable.getIntrinsicWidth();
      int height = drawable.getIntrinsicHeight();
      Bitmap canvasBitmap = Bitmap.createBitmap(width, height, config);
      Canvas canvas = new Canvas(canvasBitmap);
      drawable.setBounds(0, 0, width, height);
      drawable.draw(canvas);
      return canvasBitmap;
    }
    return bitmap;
  }

  public static float getHandleHorizontalPaddingRatio() {
    return HANDLE_HORIZONTAL_PADDING_RATIO;
  }

  private static Bitmap getLeftHandleBitmap(Context context) {
    return getHandleBitmap(context, LEFT_HANDLE_ATTRS);
  }

  private static Bitmap getCenterHandleBitmap(Context context) {
    return getHandleBitmap(context, CENTER_HANDLE_ATTRS);
  }

  private static Bitmap getRightHandleBitmap(Context context) {
    return getHandleBitmap(context, RIGHT_HANDLE_ATTRS);
  }
}
