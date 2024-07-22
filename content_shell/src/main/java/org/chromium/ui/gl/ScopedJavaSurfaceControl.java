package org.chromium.ui.gl;

import android.view.SurfaceControl;
import org.jni_zero.JNINamespace;

@JNINamespace("gl")
class ScopedJavaSurfaceControl {
  ScopedJavaSurfaceControl() {}

  private static void releaseSurfaceControl(SurfaceControl surfaceControl) {
    surfaceControl.release();
  }
}
