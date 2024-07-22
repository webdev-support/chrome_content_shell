package org.chromium.content_shell;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class ShellManagerJni implements ShellManager.Natives {
  public static final JniStaticTestMocker<ShellManager.Natives> TEST_HOOKS =
      new JniStaticTestMocker<ShellManager.Natives>() {
        @Override
        public void setInstanceForTesting(ShellManager.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          ShellManagerJni.testInstance = instance;
        }
      };
  private static ShellManager.Natives testInstance;

  ShellManagerJni() {}

  @Override
  public void init(Object shellManagerInstance) {
    GEN_JNI.org_chromium_content_1shell_ShellManager_init(shellManagerInstance);
  }

  @Override
  public void launchShell(String url) {
    GEN_JNI.org_chromium_content_1shell_ShellManager_launchShell(url);
  }

  public static ShellManager.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      ShellManager.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of ShellManager.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new ShellManagerJni();
  }
}
