package org.chromium.base;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class SysUtilsJni implements SysUtils.Natives {
  public static final JniStaticTestMocker<SysUtils.Natives> TEST_HOOKS =
      new JniStaticTestMocker<SysUtils.Natives>() {
        @Override
        public void setInstanceForTesting(SysUtils.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          SysUtilsJni.testInstance = instance;
        }
      };
  private static SysUtils.Natives testInstance;

  SysUtilsJni() {}

  @Override
  public void logPageFaultCountToTracing() {
    GEN_JNI.org_chromium_base_SysUtils_logPageFaultCountToTracing();
  }

  public static SysUtils.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      SysUtils.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of SysUtils.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new SysUtilsJni();
  }
}
