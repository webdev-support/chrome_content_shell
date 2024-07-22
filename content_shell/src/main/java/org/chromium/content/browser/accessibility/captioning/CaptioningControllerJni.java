package org.chromium.content.browser.accessibility.captioning;

import org.chromium.content_public.browser.WebContents;
import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class CaptioningControllerJni implements CaptioningController.Natives {

  public static final JniStaticTestMocker<CaptioningController.Natives> TEST_HOOKS =
      new JniStaticTestMocker<CaptioningController.Natives>() {
        @Override
        public void setInstanceForTesting(CaptioningController.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          CaptioningControllerJni.testInstance = instance;
        }
      };
  private static CaptioningController.Natives testInstance;

  CaptioningControllerJni() {}

  @Override
  public long init(CaptioningController caller, WebContents webContents) {
    return GEN_JNI.org_chromium_content_browser_accessibility_captioning_CaptioningController_init(
        caller, webContents);
  }

  @Override
  public void setTextTrackSettings(
      long nativeCaptioningController,
      CaptioningController caller,
      boolean textTracksEnabled,
      String textTrackBackgroundColor,
      String textTrackFontFamily,
      String textTrackFontStyle,
      String textTrackFontVariant,
      String textTrackTextColor,
      String textTrackTextShadow,
      String textTrackTextSize) {
    if (nativeCaptioningController == 0) {
      throw new AssertionError();
    }
    GEN_JNI
        .org_chromium_content_browser_accessibility_captioning_CaptioningController_setTextTrackSettings(
            nativeCaptioningController,
            caller,
            textTracksEnabled,
            textTrackBackgroundColor,
            textTrackFontFamily,
            textTrackFontStyle,
            textTrackFontVariant,
            textTrackTextColor,
            textTrackTextShadow,
            textTrackTextSize);
  }

  public static CaptioningController.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      CaptioningController.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of CaptioningController.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new CaptioningControllerJni();
  }
}
