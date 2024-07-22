package org.chromium.content.browser;

import android.view.Surface;
import org.chromium.base.UnguessableToken;
import org.chromium.content.common.SurfaceWrapper;
import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class GpuProcessCallbackJni implements GpuProcessCallback.Natives {
  public static final JniStaticTestMocker<GpuProcessCallback.Natives> TEST_HOOKS =
      new JniStaticTestMocker<GpuProcessCallback.Natives>() {
        @Override
        public void setInstanceForTesting(GpuProcessCallback.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          GpuProcessCallbackJni.testInstance = instance;
        }
      };
  private static GpuProcessCallback.Natives testInstance;

  GpuProcessCallbackJni() {}

  @Override
  public void completeScopedSurfaceRequest(UnguessableToken requestToken, Surface surface) {
    GEN_JNI.org_chromium_content_browser_GpuProcessCallback_completeScopedSurfaceRequest(
        requestToken, surface);
  }

  @Override
  public SurfaceWrapper getViewSurface(int surfaceId) {
    return (SurfaceWrapper)
        GEN_JNI.org_chromium_content_browser_GpuProcessCallback_getViewSurface(surfaceId);
  }

  public static GpuProcessCallback.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      GpuProcessCallback.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of GpuProcessCallback.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new GpuProcessCallbackJni();
  }
}
