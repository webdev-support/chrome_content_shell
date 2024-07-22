package org.chromium.ui.gl;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class SurfaceTextureListenerJni implements SurfaceTextureListener.Natives {

  public static final JniStaticTestMocker<SurfaceTextureListener.Natives> TEST_HOOKS =
      new JniStaticTestMocker<SurfaceTextureListener.Natives>() {
        @Override
        public void setInstanceForTesting(SurfaceTextureListener.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          SurfaceTextureListenerJni.testInstance = instance;
        }
      };
  private static SurfaceTextureListener.Natives testInstance;

  SurfaceTextureListenerJni() {}

  @Override
  public void destroy(long nativeSurfaceTextureListener, SurfaceTextureListener caller) {
    if (nativeSurfaceTextureListener == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_ui_gl_SurfaceTextureListener_destroy(nativeSurfaceTextureListener, caller);
  }

  @Override
  public void frameAvailable(long nativeSurfaceTextureListener, SurfaceTextureListener caller) {
    if (nativeSurfaceTextureListener == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_ui_gl_SurfaceTextureListener_frameAvailable(
        nativeSurfaceTextureListener, caller);
  }

  public static SurfaceTextureListener.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      SurfaceTextureListener.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of SurfaceTextureListener.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new SurfaceTextureListenerJni();
  }
}
