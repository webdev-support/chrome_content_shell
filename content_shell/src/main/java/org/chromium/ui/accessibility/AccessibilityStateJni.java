package org.chromium.ui.accessibility;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class AccessibilityStateJni implements AccessibilityState.Natives {
  public static final JniStaticTestMocker<AccessibilityState.Natives> TEST_HOOKS =
      new JniStaticTestMocker<AccessibilityState.Natives>() {
        @Override
        public void setInstanceForTesting(AccessibilityState.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          AccessibilityStateJni.testInstance = instance;
        }
      };
  private static AccessibilityState.Natives testInstance;

  AccessibilityStateJni() {}

  @Override
  public void onAnimatorDurationScaleChanged() {
    GEN_JNI.org_chromium_ui_accessibility_AccessibilityState_onAnimatorDurationScaleChanged();
  }

  @Override
  public void onContrastLevelChanged(boolean highContrastEnabled) {
    GEN_JNI.org_chromium_ui_accessibility_AccessibilityState_onContrastLevelChanged(
        highContrastEnabled);
  }

  @Override
  public void onDisplayInversionEnabledChanged(boolean enabled) {
    GEN_JNI.org_chromium_ui_accessibility_AccessibilityState_onDisplayInversionEnabledChanged(
        enabled);
  }

  @Override
  public void recordAccessibilityServiceInfoHistograms() {
    GEN_JNI
        .org_chromium_ui_accessibility_AccessibilityState_recordAccessibilityServiceInfoHistograms();
  }

  public static AccessibilityState.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      AccessibilityState.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of AccessibilityState.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new AccessibilityStateJni();
  }
}
