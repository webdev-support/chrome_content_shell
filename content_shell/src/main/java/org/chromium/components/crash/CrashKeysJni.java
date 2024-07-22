package org.chromium.components.crash;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class CrashKeysJni implements CrashKeys.Natives {
  public static final JniStaticTestMocker<CrashKeys.Natives> TEST_HOOKS =
      new JniStaticTestMocker<CrashKeys.Natives>() {
        @Override
        public void setInstanceForTesting(CrashKeys.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          CrashKeysJni.testInstance = instance;
        }
      };
  private static CrashKeys.Natives testInstance;

  CrashKeysJni() {}

  @Override
  public void set(CrashKeys caller, int key, String value) {
    GEN_JNI.org_chromium_components_crash_CrashKeys_set(caller, key, value);
  }

  public static CrashKeys.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      CrashKeys.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of CrashKeys.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new CrashKeysJni();
  }
}
