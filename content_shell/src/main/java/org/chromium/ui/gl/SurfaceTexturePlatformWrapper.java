package org.chromium.ui.gl;

import android.graphics.SurfaceTexture;
import android.util.Log;
import org.jni_zero.JNINamespace;

@JNINamespace("gl")
class SurfaceTexturePlatformWrapper {
  private static final String TAG = "SurfaceTexturePlatformWrapper";

  SurfaceTexturePlatformWrapper() {}

  private static SurfaceTexture create(int textureId) {
    return new SurfaceTexture(textureId);
  }

  private static void destroy(SurfaceTexture surfaceTexture) {
    surfaceTexture.setOnFrameAvailableListener(null);
    surfaceTexture.release();
  }

  private static void setFrameAvailableCallback(
      SurfaceTexture surfaceTexture, long nativeSurfaceTextureListener) {
    surfaceTexture.setOnFrameAvailableListener(
        new SurfaceTextureListener(nativeSurfaceTextureListener));
  }

  private static void updateTexImage(SurfaceTexture surfaceTexture) {
    try {
      surfaceTexture.updateTexImage();
    } catch (RuntimeException e) {
      Log.e(TAG, "Error calling updateTexImage", e);
    }
  }

  private static void getTransformMatrix(SurfaceTexture surfaceTexture, float[] matrix) {
    surfaceTexture.getTransformMatrix(matrix);
  }

  private static void attachToGLContext(SurfaceTexture surfaceTexture, int texName) {
    surfaceTexture.attachToGLContext(texName);
  }

  private static void detachFromGLContext(SurfaceTexture surfaceTexture) {
    surfaceTexture.detachFromGLContext();
  }

  private static void release(SurfaceTexture surfaceTexture) {
    surfaceTexture.release();
  }

  private static void setDefaultBufferSize(SurfaceTexture surfaceTexture, int width, int height) {
    surfaceTexture.setDefaultBufferSize(width, height);
  }
}
