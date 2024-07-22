package org.chromium.content.browser.selection;

import android.graphics.Rect;
import android.view.AttachedSurfaceControl;
import android.view.SurfaceControl;
import android.view.View;
import android.widget.Magnifier;
import org.chromium.content.browser.webcontents.WebContentsImpl;
import org.jni_zero.JNINamespace;

@JNINamespace("content")
public class MagnifierSurfaceControl implements MagnifierWrapper {
  private static final int BOTTOM_SHADOW_HEIGHT_DP = 6;
  private static final int BOTTOM_SHADOW_WIDTH_REDUCTION_DP = 3;
  private static final int TOP_SHADOW_HEIGHT_DP = 3;
  private int mHeightPx;
  private long mNativeMagnifierSurfaceControl;
  private SurfaceControl mSurfaceControl;
  private SurfaceControl.Transaction mTransaction;
  private int mVerticalOffsetPx;
  private View mView;
  private final SelectionPopupControllerImpl.ReadbackViewCallback mViewCallback;
  private final WebContentsImpl mWebContents;
  private int mWidthPx;

  public interface Natives {
    void childLocalSurfaceIdChanged(long j);

    long create(
        WebContentsImpl webContentsImpl,
        SurfaceControl surfaceControl,
        float f,
        int i,
        int i2,
        float f2,
        float f3,
        int i3,
        int i4,
        int i5);

    void destroy(long j);

    void setReadbackOrigin(long j, float f, float f2);
  }

  public MagnifierSurfaceControl(
      WebContentsImpl webContents, SelectionPopupControllerImpl.ReadbackViewCallback callback) {
    this.mWebContents = webContents;
    this.mViewCallback = callback;
  }

  @Override
  public void show(float x, float y) {
    Rect localVisibleRect = new Rect();
    if (!getView().getLocalVisibleRect(localVisibleRect)) {
      dismiss();
      return;
    }
    createNativeIfNeeded();
    if (this.mSurfaceControl != null) {
      float x2 = x - (this.mWidthPx / 2);
      float y2 = y - (this.mHeightPx / 2);
      float y3 = (y2 + this.mVerticalOffsetPx) - scaleByDeviceFactor(3);
      float x3 = Math.max(x2, localVisibleRect.left);
      float y4 = Math.max(y3, localVisibleRect.top);
      float x4 = Math.min(x3, localVisibleRect.right - this.mWidthPx);
      float y5 = Math.min(y4, localVisibleRect.bottom - this.mHeightPx);
      float readback_y = y2 - this.mWebContents.getRenderCoordinates().getContentOffsetYPix();
      MagnifierSurfaceControlJni.get()
          .setReadbackOrigin(this.mNativeMagnifierSurfaceControl, x4, readback_y);
      int[] viewOriginInSurface = new int[2];
      getView().getLocationInSurface(viewOriginInSurface);
      this.mTransaction.setPosition(
          this.mSurfaceControl, viewOriginInSurface[0] + x4, viewOriginInSurface[1] + y5);
      this.mTransaction.apply();
    }
  }

  @Override
  public void dismiss() {
    destroyNativeIfNeeded();
  }

  @Override
  public boolean isAvailable() {
    return this.mViewCallback.getReadbackView() != null;
  }

  @Override
  public void childLocalSurfaceIdChanged() {
    if (this.mNativeMagnifierSurfaceControl == 0) {
      return;
    }
    MagnifierSurfaceControlJni.get()
        .childLocalSurfaceIdChanged(this.mNativeMagnifierSurfaceControl);
  }

  private void createNativeIfNeeded() {
    AttachedSurfaceControl attachedSurfaceControl;
    if (this.mNativeMagnifierSurfaceControl != 0
        || getView() == null
        || (attachedSurfaceControl = getView().getRootSurfaceControl()) == null) {
      return;
    }
    SurfaceControl surfaceControl = new SurfaceControl.Builder().setName("cr_magnifier").build();
    SurfaceControl.Transaction attachTransaction =
        attachedSurfaceControl.buildReparentTransaction(surfaceControl);
    if (attachTransaction == null) {
      surfaceControl.release();
      return;
    }
    attachTransaction.setVisibility(surfaceControl, true);
    Magnifier androidMagnifier = new Magnifier(getView());
    this.mWidthPx = androidMagnifier.getWidth();
    this.mHeightPx = androidMagnifier.getHeight();
    this.mVerticalOffsetPx = androidMagnifier.getDefaultVerticalSourceToMagnifierOffset();
    float cornerRadius = androidMagnifier.getCornerRadius();
    float zoom = androidMagnifier.getZoom();
    androidMagnifier.dismiss();
    float density = getView().getResources().getDisplayMetrics().density;
    this.mNativeMagnifierSurfaceControl =
        MagnifierSurfaceControlJni.get()
            .create(
                this.mWebContents,
                surfaceControl,
                density,
                this.mWidthPx,
                this.mHeightPx,
                cornerRadius,
                zoom,
                scaleByDeviceFactor(3),
                scaleByDeviceFactor(6),
                scaleByDeviceFactor(3));
    this.mSurfaceControl = surfaceControl;
    this.mTransaction = attachTransaction;
  }

  private void destroyNativeIfNeeded() {
    if (this.mNativeMagnifierSurfaceControl != 0) {
      MagnifierSurfaceControlJni.get().destroy(this.mNativeMagnifierSurfaceControl);
    }
    this.mNativeMagnifierSurfaceControl = 0L;
    SurfaceControl surfaceControl = this.mSurfaceControl;
    if (surfaceControl != null) {
      this.mTransaction.reparent(surfaceControl, null);
      this.mTransaction.apply();
      this.mTransaction.close();
      this.mSurfaceControl.release();
    }
    this.mSurfaceControl = null;
    this.mTransaction = null;
    this.mView = null;
  }

  private View getView() {
    if (this.mView == null) {
      this.mView = this.mViewCallback.getReadbackView();
    }
    return this.mView;
  }

  private int scaleByDeviceFactor(int value) {
    return (int) (value * this.mWebContents.getRenderCoordinates().getDeviceScaleFactor());
  }
}
