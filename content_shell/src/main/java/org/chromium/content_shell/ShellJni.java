package org.chromium.content_shell;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class ShellJni implements Shell.Natives {
  public static final JniStaticTestMocker<Shell.Natives> TEST_HOOKS =
      new JniStaticTestMocker<Shell.Natives>() {
        @Override
        public void setInstanceForTesting(Shell.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          ShellJni.testInstance = instance;
        }
      };
  private static Shell.Natives testInstance;

  ShellJni() {}

  @Override
  public void closeShell(long shellPtr) {
    GEN_JNI.org_chromium_content_1shell_Shell_closeShell(shellPtr);
  }

  public static Shell.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      Shell.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of Shell.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new ShellJni();
  }
}
