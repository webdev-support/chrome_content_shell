package org.chromium.base.task;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class TaskRunnerImplJni implements TaskRunnerImpl.Natives {

  public static final JniStaticTestMocker<TaskRunnerImpl.Natives> TEST_HOOKS =
      new JniStaticTestMocker<TaskRunnerImpl.Natives>() {
        @Override
        public void setInstanceForTesting(TaskRunnerImpl.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          TaskRunnerImplJni.testInstance = instance;
        }
      };
  private static TaskRunnerImpl.Natives testInstance;

  TaskRunnerImplJni() {}

  @Override
  public boolean belongsToCurrentThread(long nativeTaskRunnerAndroid) {
    if (nativeTaskRunnerAndroid == 0) {
      throw new AssertionError();
    }
    return GEN_JNI.org_chromium_base_task_TaskRunnerImpl_belongsToCurrentThread(
        nativeTaskRunnerAndroid);
  }

  @Override
  public void destroy(long nativeTaskRunnerAndroid) {
    if (nativeTaskRunnerAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_base_task_TaskRunnerImpl_destroy(nativeTaskRunnerAndroid);
  }

  @Override
  public long init(int taskRunnerType, int taskTraits) {
    return GEN_JNI.org_chromium_base_task_TaskRunnerImpl_init(taskRunnerType, taskTraits);
  }

  @Override
  public void postDelayedTask(
      long nativeTaskRunnerAndroid, Runnable task, long delay, String runnableClassName) {
    if (nativeTaskRunnerAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_base_task_TaskRunnerImpl_postDelayedTask(
        nativeTaskRunnerAndroid, task, delay, runnableClassName);
  }

  public static TaskRunnerImpl.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      TaskRunnerImpl.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of TaskRunnerImpl.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new TaskRunnerImplJni();
  }
}
