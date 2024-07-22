package org.chromium.base.task;

import android.os.Handler;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import org.chromium.base.Log;
import org.chromium.base.ResettersForTesting;
import org.chromium.base.ThreadUtils;
import org.jni_zero.JNINamespace;

@JNINamespace("base")
public class PostTask {

  private static final String TAG = "PostTask";
  private static volatile boolean sNativeInitialized;
  private static volatile Executor sPrenativeThreadPoolExecutorForTesting;
  static int sTestIterationForTesting;
  private static UiThreadTaskExecutor sUiThreadTaskExecutor;
  private static final Object sPreNativeTaskRunnerLock = new Object();
  private static List<TaskRunnerImpl> sPreNativeTaskRunners = new ArrayList();
  private static ChromeThreadPoolExecutor sPrenativeThreadPoolExecutor =
      new ChromeThreadPoolExecutor();
  private static final ThreadPoolTaskExecutor sThreadPoolTaskExecutor =
      new ThreadPoolTaskExecutor();

  public static TaskRunner createTaskRunner(int taskTraits) {
    return getTaskExecutorForTraits(taskTraits).createTaskRunner(taskTraits);
  }

  public static SequencedTaskRunner createSequencedTaskRunner(int taskTraits) {
    return getTaskExecutorForTraits(taskTraits).createSequencedTaskRunner(taskTraits);
  }

  public static SingleThreadTaskRunner createSingleThreadTaskRunner(int taskTraits) {
    return getTaskExecutorForTraits(taskTraits).createSingleThreadTaskRunner(taskTraits);
  }

  public static void postTask(int taskTraits, Runnable task) {
    postDelayedTask(taskTraits, task, 0L);
  }

  public static void postDelayedTask(int taskTraits, Runnable task, long delay) {
    getTaskExecutorForTraits(taskTraits).postDelayedTask(taskTraits, task, delay);
  }

  public static void runOrPostTask(int taskTraits, Runnable task) {
    if (getTaskExecutorForTraits(taskTraits).canRunTaskImmediately(taskTraits)) {
      task.run();
    } else {
      postTask(taskTraits, task);
    }
  }

  public static boolean canRunTaskImmediately(int taskTraits) {
    return getTaskExecutorForTraits(taskTraits).canRunTaskImmediately(taskTraits);
  }

  @Deprecated
  public static <T> T runSynchronously(int taskTraits, Callable<T> c) {
    return (T) runSynchronouslyInternal(taskTraits, new FutureTask(c));
  }

  @Deprecated
  public static void runSynchronously(int taskTraits, Runnable r) {
    runSynchronouslyInternal(taskTraits, new FutureTask(r, null));
  }

  private static <T> T runSynchronouslyInternal(int taskTraits, FutureTask<T> task) {
    runOrPostTask(taskTraits, task);
    try {
      return task.get();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public static void setPrenativeThreadPoolExecutorForTesting(Executor executor) {
    sPrenativeThreadPoolExecutorForTesting = executor;
    ResettersForTesting.register(
        new Runnable() {
          @Override
          public final void run() {
            PostTask.sPrenativeThreadPoolExecutorForTesting = null;
          }
        });
  }

  public static Executor getPrenativeThreadPoolExecutor() {
    if (sPrenativeThreadPoolExecutorForTesting != null) {
      return sPrenativeThreadPoolExecutorForTesting;
    }
    return sPrenativeThreadPoolExecutor;
  }

  public static boolean registerPreNativeTaskRunner(TaskRunnerImpl taskRunner) {
    synchronized (sPreNativeTaskRunnerLock) {
      List<TaskRunnerImpl> list = sPreNativeTaskRunners;
      if (list == null) {
        return false;
      }
      list.add(taskRunner);
      return true;
    }
  }

  private static TaskExecutor getTaskExecutorForTraits(int traits) {
    if (traits >= 6) {
      if (sUiThreadTaskExecutor == null) {
        ThreadUtils.getUiThreadHandler();
      }
      return sUiThreadTaskExecutor;
    }
    return sThreadPoolTaskExecutor;
  }

  private static void onNativeSchedulerReady() {
    List<TaskRunnerImpl> preNativeTaskRunners;
    if (sNativeInitialized) {
      return;
    }
    sNativeInitialized = true;
    synchronized (sPreNativeTaskRunnerLock) {
      preNativeTaskRunners = sPreNativeTaskRunners;
      sPreNativeTaskRunners = null;
    }
    for (TaskRunnerImpl taskRunner : preNativeTaskRunners) {
      taskRunner.initNativeTaskRunner();
    }
  }

  public static void flushJobsAndResetForTesting() throws InterruptedException {
    ChromeThreadPoolExecutor executor = sPrenativeThreadPoolExecutor;
    int taskCount = executor.getQueue().size() + executor.getActiveCount();
    if (taskCount > 0) {
      executor.shutdownNow();
      executor.awaitTermination(1L, TimeUnit.SECONDS);
      sPrenativeThreadPoolExecutor = new ChromeThreadPoolExecutor();
    }
    synchronized (sPreNativeTaskRunnerLock) {
      List<TaskRunnerImpl> list = sPreNativeTaskRunners;
      if (list != null) {
        for (TaskRunnerImpl taskRunner : list) {
          taskCount += taskRunner.clearTaskQueueForTesting();
        }
      }
      sTestIterationForTesting++;
    }
    sPrenativeThreadPoolExecutorForTesting = null;
    if (taskCount > 0) {
      Log.w(TAG, "%d background task(s) existed after test finished.", Integer.valueOf(taskCount));
    }
  }

  public static void onUiThreadReady(Handler uiThreadHandler) {
    if (sUiThreadTaskExecutor != null) {
      throw new AssertionError();
    }
    sUiThreadTaskExecutor = new UiThreadTaskExecutor(uiThreadHandler);
  }

  public static void resetUiThreadForTesting() {
    if (sNativeInitialized) {
      throw new AssertionError();
    }
    sUiThreadTaskExecutor = null;
  }
}
