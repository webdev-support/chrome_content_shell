package org.chromium.ui.display;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class DisplayAndroidManagerJni implements DisplayAndroidManager.Natives {

  public static final JniStaticTestMocker<DisplayAndroidManager.Natives> TEST_HOOKS =
      new JniStaticTestMocker<DisplayAndroidManager.Natives>() {
        @Override
        public void setInstanceForTesting(DisplayAndroidManager.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          DisplayAndroidManagerJni.testInstance = instance;
        }
      };
  private static DisplayAndroidManager.Natives testInstance;

  DisplayAndroidManagerJni() {}

  @Override
  public void removeDisplay(
      long nativeDisplayAndroidManager, DisplayAndroidManager caller, int sdkDisplayId) {
    if (nativeDisplayAndroidManager == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_ui_display_DisplayAndroidManager_removeDisplay(
        nativeDisplayAndroidManager, caller, sdkDisplayId);
  }

  @Override
  public void setPrimaryDisplayId(
      long nativeDisplayAndroidManager, DisplayAndroidManager caller, int sdkDisplayId) {
    if (nativeDisplayAndroidManager == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_ui_display_DisplayAndroidManager_setPrimaryDisplayId(
        nativeDisplayAndroidManager, caller, sdkDisplayId);
  }

  @Override
  public void updateDisplay(
      long nativeDisplayAndroidManager,
      DisplayAndroidManager caller,
      int sdkDisplayId,
      int width,
      int height,
      float dipScale,
      int rotationDegrees,
      int bitsPerPixel,
      int bitsPerComponent,
      boolean isWideColorGamut,
      boolean isHdr,
      float hdrMaxLuminanceRatio) {
    if (nativeDisplayAndroidManager == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_ui_display_DisplayAndroidManager_updateDisplay(
        nativeDisplayAndroidManager,
        caller,
        sdkDisplayId,
        width,
        height,
        dipScale,
        rotationDegrees,
        bitsPerPixel,
        bitsPerComponent,
        isWideColorGamut,
        isHdr,
        hdrMaxLuminanceRatio);
  }

  public static DisplayAndroidManager.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      DisplayAndroidManager.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of DisplayAndroidManager.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new DisplayAndroidManagerJni();
  }
}
