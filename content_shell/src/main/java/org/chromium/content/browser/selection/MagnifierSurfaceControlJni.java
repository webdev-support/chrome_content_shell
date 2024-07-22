package org.chromium.content.browser.selection;

import android.view.SurfaceControl;
import org.chromium.content.browser.webcontents.WebContentsImpl;
import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class MagnifierSurfaceControlJni implements MagnifierSurfaceControl.Natives {

  public static final JniStaticTestMocker<MagnifierSurfaceControl.Natives> TEST_HOOKS =
      new JniStaticTestMocker<MagnifierSurfaceControl.Natives>() {
        @Override
        public void setInstanceForTesting(MagnifierSurfaceControl.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          MagnifierSurfaceControlJni.testInstance = instance;
        }
      };
  private static MagnifierSurfaceControl.Natives testInstance;

  MagnifierSurfaceControlJni() {}

  @Override
  public void childLocalSurfaceIdChanged(long nativeMagnifierSurfaceControl) {
    if (nativeMagnifierSurfaceControl == 0) {
      throw new AssertionError();
    }
    GEN_JNI
        .org_chromium_content_browser_selection_MagnifierSurfaceControl_childLocalSurfaceIdChanged(
            nativeMagnifierSurfaceControl);
  }

  @Override
  public long create(
      WebContentsImpl webContents,
      SurfaceControl surfaceControl,
      float deviceScale,
      int width,
      int height,
      float cornerRadius,
      float zoom,
      int topShadowHeight,
      int bottomShadowHeight,
      int bottomShadowWidthReduction) {
    return GEN_JNI.org_chromium_content_browser_selection_MagnifierSurfaceControl_create(
        webContents,
        surfaceControl,
        deviceScale,
        width,
        height,
        cornerRadius,
        zoom,
        topShadowHeight,
        bottomShadowHeight,
        bottomShadowWidthReduction);
  }

  @Override
  public void destroy(long magnifierSurfaceControl) {
    GEN_JNI.org_chromium_content_browser_selection_MagnifierSurfaceControl_destroy(
        magnifierSurfaceControl);
  }

  @Override
  public void setReadbackOrigin(long nativeMagnifierSurfaceControl, float x, float y) {
    if (nativeMagnifierSurfaceControl == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_selection_MagnifierSurfaceControl_setReadbackOrigin(
        nativeMagnifierSurfaceControl, x, y);
  }

  public static MagnifierSurfaceControl.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      MagnifierSurfaceControl.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of MagnifierSurfaceControl.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new MagnifierSurfaceControlJni();
  }
}
