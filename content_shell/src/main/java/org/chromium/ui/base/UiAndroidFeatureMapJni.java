package org.chromium.ui.base;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class UiAndroidFeatureMapJni implements UiAndroidFeatureMap.Natives {
  public static final JniStaticTestMocker<UiAndroidFeatureMap.Natives> TEST_HOOKS =
      new JniStaticTestMocker<UiAndroidFeatureMap.Natives>() {
        @Override
        public void setInstanceForTesting(UiAndroidFeatureMap.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          UiAndroidFeatureMapJni.testInstance = instance;
        }
      };
  private static UiAndroidFeatureMap.Natives testInstance;

  @Override
  public long getNativeMap() {
    return GEN_JNI.org_chromium_ui_base_UiAndroidFeatureMap_getNativeMap();
  }

  public static UiAndroidFeatureMap.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      UiAndroidFeatureMap.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of UiAndroidFeatureMap.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new UiAndroidFeatureMapJni();
  }
}
