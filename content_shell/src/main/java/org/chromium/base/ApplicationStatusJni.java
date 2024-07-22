package org.chromium.base;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class ApplicationStatusJni implements ApplicationStatus.Natives {
  public static final JniStaticTestMocker<ApplicationStatus.Natives> TEST_HOOKS =
      new JniStaticTestMocker<ApplicationStatus.Natives>() {
        @Override
        public void setInstanceForTesting(ApplicationStatus.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          ApplicationStatusJni.testInstance = instance;
        }
      };
  private static ApplicationStatus.Natives testInstance;

  ApplicationStatusJni() {}

  @Override
  public void onApplicationStateChange(int newState) {
    GEN_JNI.org_chromium_base_ApplicationStatus_onApplicationStateChange(newState);
  }

  public static ApplicationStatus.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      ApplicationStatus.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of ApplicationStatus.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new ApplicationStatusJni();
  }
}
