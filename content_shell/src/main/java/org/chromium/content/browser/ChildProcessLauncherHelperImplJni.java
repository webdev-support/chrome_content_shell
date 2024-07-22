package org.chromium.content.browser;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class ChildProcessLauncherHelperImplJni implements ChildProcessLauncherHelperImpl.Natives {

  public static final JniStaticTestMocker<ChildProcessLauncherHelperImpl.Natives> TEST_HOOKS =
      new JniStaticTestMocker<ChildProcessLauncherHelperImpl.Natives>() {
        @Override
        public void setInstanceForTesting(ChildProcessLauncherHelperImpl.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          ChildProcessLauncherHelperImplJni.testInstance = instance;
        }
      };
  private static ChildProcessLauncherHelperImpl.Natives testInstance;

  ChildProcessLauncherHelperImplJni() {}

  @Override
  public void onChildProcessStarted(long nativeChildProcessLauncherHelper, int pid) {
    if (nativeChildProcessLauncherHelper == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_ChildProcessLauncherHelperImpl_onChildProcessStarted(
        nativeChildProcessLauncherHelper, pid);
  }

  @Override
  public boolean serviceGroupImportanceEnabled() {
    return GEN_JNI
        .org_chromium_content_browser_ChildProcessLauncherHelperImpl_serviceGroupImportanceEnabled();
  }

  @Override
  public void setTerminationInfo(
      long termiantionInfoPtr,
      int bindingState,
      boolean killedByUs,
      boolean cleanExit,
      boolean exceptionDuringInit) {
    GEN_JNI.org_chromium_content_browser_ChildProcessLauncherHelperImpl_setTerminationInfo(
        termiantionInfoPtr, bindingState, killedByUs, cleanExit, exceptionDuringInit);
  }

  public static ChildProcessLauncherHelperImpl.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      ChildProcessLauncherHelperImpl.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of ChildProcessLauncherHelperImpl.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new ChildProcessLauncherHelperImplJni();
  }
}
