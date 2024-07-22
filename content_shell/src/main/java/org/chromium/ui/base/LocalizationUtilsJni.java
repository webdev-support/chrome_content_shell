package org.chromium.ui.base;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class LocalizationUtilsJni implements LocalizationUtils.Natives {
  public static final JniStaticTestMocker<LocalizationUtils.Natives> TEST_HOOKS =
      new JniStaticTestMocker<LocalizationUtils.Natives>() {
        @Override
        public void setInstanceForTesting(LocalizationUtils.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          LocalizationUtilsJni.testInstance = instance;
        }
      };
  private static LocalizationUtils.Natives testInstance;

  LocalizationUtilsJni() {}

  @Override
  public int getFirstStrongCharacterDirection(String string) {
    return GEN_JNI.org_chromium_ui_base_LocalizationUtils_getFirstStrongCharacterDirection(string);
  }

  @Override
  public String getNativeUiLocale() {
    return GEN_JNI.org_chromium_ui_base_LocalizationUtils_getNativeUiLocale();
  }

  public static LocalizationUtils.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      LocalizationUtils.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of LocalizationUtils.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new LocalizationUtilsJni();
  }
}
