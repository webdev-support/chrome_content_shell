package org.chromium.ui.accessibility;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class AccessibilityFeaturesMapJni implements AccessibilityFeaturesMap.Natives {
  public static final JniStaticTestMocker<AccessibilityFeaturesMap.Natives> TEST_HOOKS =
      new JniStaticTestMocker<AccessibilityFeaturesMap.Natives>() {
        @Override
        public void setInstanceForTesting(AccessibilityFeaturesMap.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          AccessibilityFeaturesMapJni.testInstance = instance;
        }
      };
  private static AccessibilityFeaturesMap.Natives testInstance;

  @Override
  public long getNativeMap() {
    return GEN_JNI.org_chromium_ui_accessibility_AccessibilityFeaturesMap_getNativeMap();
  }

  public static AccessibilityFeaturesMap.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      AccessibilityFeaturesMap.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of AccessibilityFeaturesMap.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new AccessibilityFeaturesMapJni();
  }
}
