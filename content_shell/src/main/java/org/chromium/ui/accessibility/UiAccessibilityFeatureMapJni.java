package org.chromium.ui.accessibility;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class UiAccessibilityFeatureMapJni implements UiAccessibilityFeatureMap.Natives {
  public static final JniStaticTestMocker<UiAccessibilityFeatureMap.Natives> TEST_HOOKS =
      new JniStaticTestMocker<UiAccessibilityFeatureMap.Natives>() {
        @Override
        public void setInstanceForTesting(UiAccessibilityFeatureMap.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          UiAccessibilityFeatureMapJni.testInstance = instance;
        }
      };
  private static UiAccessibilityFeatureMap.Natives testInstance;

  @Override
  public long getNativeMap() {
    return GEN_JNI.org_chromium_ui_accessibility_UiAccessibilityFeatureMap_getNativeMap();
  }

  public static UiAccessibilityFeatureMap.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      UiAccessibilityFeatureMap.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of UiAccessibilityFeatureMap.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new UiAccessibilityFeatureMapJni();
  }
}
