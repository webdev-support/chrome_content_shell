package org.chromium.ui.gl;

import android.graphics.SurfaceTexture;
import org.jni_zero.JNINamespace;

@JNINamespace("gl")
class SurfaceTextureListener implements SurfaceTexture.OnFrameAvailableListener {

  private final long mNativeSurfaceTextureListener;

  public interface Natives {
    void destroy(long j, SurfaceTextureListener surfaceTextureListener);

    void frameAvailable(long j, SurfaceTextureListener surfaceTextureListener);
  }

  public SurfaceTextureListener(long nativeSurfaceTextureListener) {
    if (nativeSurfaceTextureListener == 0) {
      throw new AssertionError();
    }
    this.mNativeSurfaceTextureListener = nativeSurfaceTextureListener;
  }

  @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
  public void onFrameAvailable(SurfaceTexture surfaceTexture) {
    SurfaceTextureListenerJni.get().frameAvailable(this.mNativeSurfaceTextureListener, this);
  }

  protected void finalize() throws Throwable {
    try {
      SurfaceTextureListenerJni.get().destroy(this.mNativeSurfaceTextureListener, this);
    } finally {
      super.finalize();
    }
  }
}
