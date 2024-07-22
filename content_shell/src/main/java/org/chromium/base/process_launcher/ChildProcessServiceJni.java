package org.chromium.base.process_launcher;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class ChildProcessServiceJni implements ChildProcessService.Natives {
  public static final JniStaticTestMocker<ChildProcessService.Natives> TEST_HOOKS =
      new JniStaticTestMocker<ChildProcessService.Natives>() {
        @Override
        public void setInstanceForTesting(ChildProcessService.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          ChildProcessServiceJni.testInstance = instance;
        }
      };
  private static ChildProcessService.Natives testInstance;

  ChildProcessServiceJni() {}

  @Override
  public void dumpProcessStack() {
    GEN_JNI.org_chromium_base_process_1launcher_ChildProcessService_dumpProcessStack();
  }

  @Override
  public void exitChildProcess() {
    GEN_JNI.org_chromium_base_process_1launcher_ChildProcessService_exitChildProcess();
  }

  @Override
  public void registerFileDescriptors(
      String[] keys, int[] id, int[] fd, long[] offset, long[] size) {
    GEN_JNI.org_chromium_base_process_1launcher_ChildProcessService_registerFileDescriptors(
        keys, id, fd, offset, size);
  }

  public static ChildProcessService.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      ChildProcessService.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of ChildProcessService.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new ChildProcessServiceJni();
  }
}
