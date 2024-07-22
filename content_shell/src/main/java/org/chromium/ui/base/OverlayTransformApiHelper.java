package org.chromium.ui.base;

import android.os.Handler;
import android.os.Looper;
import android.view.AttachedSurfaceControl;
import android.view.FrameMetrics;
import android.view.Window;
import java.lang.ref.WeakReference;

public final class OverlayTransformApiHelper
    implements AttachedSurfaceControl.OnBufferTransformHintChangedListener,
        Window.OnFrameMetricsAvailableListener {
  private boolean mBufferTransformListenerAdded;
  private boolean mFrameMetricsListenerAdded;
  private final WeakReference<Window> mWindow;
  private final WindowAndroid mWindowAndroid;

  public static OverlayTransformApiHelper create(WindowAndroid windowAndroid) {
    if (windowAndroid.getWindow() == null) {
      return null;
    }
    return new OverlayTransformApiHelper(windowAndroid);
  }

  private OverlayTransformApiHelper(WindowAndroid windowAndroid) {
    this.mWindowAndroid = windowAndroid;
    this.mWindow = new WeakReference<>(windowAndroid.getWindow());
    addOnBufferTransformHintChangedListener();
  }

  public void destroy() {
    removeOnFrameMetricsAvailableListener();
    removeOnBufferTransformHintChangedListener();
  }

  private void addOnBufferTransformHintChangedListener() {
    Window window = this.mWindow.get();
    if (window == null) {
      return;
    }
    AttachedSurfaceControl surfacecontrol = window.getRootSurfaceControl();
    if (surfacecontrol == null) {
      addOnFrameMetricsAvailableListener();
    } else {
      doAddOnBufferTransformHintChangedListener();
    }
  }

  @Override // android.view.AttachedSurfaceControl.OnBufferTransformHintChangedListener
  public void onBufferTransformHintChanged(int hint) {
    this.mWindowAndroid.onOverlayTransformUpdated();
  }

  private void doAddOnBufferTransformHintChangedListener() {
    Window window;
    AttachedSurfaceControl surfacecontrol;
    if (!this.mBufferTransformListenerAdded
        && (window = this.mWindow.get()) != null
        && (surfacecontrol = window.getRootSurfaceControl()) != null) {
      surfacecontrol.addOnBufferTransformHintChangedListener(this);
      this.mBufferTransformListenerAdded = true;
    }
  }

  private void removeOnBufferTransformHintChangedListener() {
    Window window;
    AttachedSurfaceControl surfacecontrol;
    if (this.mBufferTransformListenerAdded
        && (window = this.mWindow.get()) != null
        && (surfacecontrol = window.getRootSurfaceControl()) != null) {
      surfacecontrol.removeOnBufferTransformHintChangedListener(this);
      this.mBufferTransformListenerAdded = false;
    }
  }

  @Override // android.view.Window.OnFrameMetricsAvailableListener
  public void onFrameMetricsAvailable(Window window, FrameMetrics frameMetrics, int dropCount) {
    AttachedSurfaceControl surfaceControl = window.getRootSurfaceControl();
    if (surfaceControl != null) {
      removeOnFrameMetricsAvailableListener();
      doAddOnBufferTransformHintChangedListener();
    }
  }

  private void addOnFrameMetricsAvailableListener() {
    Window window;
    if (this.mFrameMetricsListenerAdded || (window = this.mWindow.get()) == null) {
      return;
    }
    window.addOnFrameMetricsAvailableListener(this, new Handler(Looper.myLooper()));
    this.mFrameMetricsListenerAdded = true;
  }

  private void removeOnFrameMetricsAvailableListener() {
    Window window;
    if (this.mFrameMetricsListenerAdded && (window = this.mWindow.get()) != null) {
      window.removeOnFrameMetricsAvailableListener(this);
      this.mFrameMetricsListenerAdded = false;
    }
  }

  public int getOverlayTransform() {
    AttachedSurfaceControl surfacecontrol;
    Window window = this.mWindow.get();
    if (window == null || (surfacecontrol = window.getRootSurfaceControl()) == null) {
      return 0;
    }
    try {
      int bufferTransform = surfacecontrol.getBufferTransformHint();
      return toOverlayTransform(bufferTransform);
    } catch (IllegalStateException | NullPointerException e) {
      return 0;
    }
  }

  private static int toOverlayTransform(int bufferTransform) {
    switch (bufferTransform) {
      case 0:
        return 1;
      case 1:
        return 2;
      case 2:
        return 3;
      case 3:
        return 5;
      case 4:
        return 4;
      case 5:
      case 6:
      default:
        return 0;
      case 7:
        return 6;
    }
  }
}
