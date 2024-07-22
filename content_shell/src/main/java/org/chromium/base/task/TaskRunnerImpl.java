package org.chromium.base.task;

import android.os.Process;
import android.util.Pair;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.chromium.base.TraceEvent;
import org.jni_zero.JNINamespace;

@JNINamespace("base")
public class TaskRunnerImpl implements TaskRunner {

  private boolean mDidOneTimeInitialization;
  private volatile long mNativeTaskRunnerAndroid;
  private List<Pair<Runnable, Long>> mPreNativeDelayedTasks;
  private final Object mPreNativeTaskLock;
  private LinkedList<Runnable> mPreNativeTasks;
  protected final Runnable mRunPreNativeTaskClosure;
  private final int mTaskRunnerType;
  private final int mTaskTraits;
  private final String mTraceEvent;
  private static final ReferenceQueue<Object> sQueue = new ReferenceQueue<>();
  private static final Set<TaskRunnerCleaner> sCleaners = new HashSet();

  public interface Natives {
    boolean belongsToCurrentThread(long j);

    void destroy(long j);

    long init(int i, int i2);

    void postDelayedTask(long j, Runnable runnable, long j2, String str);
  }

  public int clearTaskQueueForTesting() {
    int taskCount = 0;
    synchronized (this.mPreNativeTaskLock) {
      LinkedList<Runnable> linkedList = this.mPreNativeTasks;
      if (linkedList != null) {
        taskCount = linkedList.size() + this.mPreNativeDelayedTasks.size();
        this.mPreNativeTasks.clear();
        this.mPreNativeDelayedTasks.clear();
      }
    }
    return taskCount;
  }

  public static class TaskRunnerCleaner extends WeakReference<TaskRunnerImpl> {
    final long mNativePtr;

    TaskRunnerCleaner(TaskRunnerImpl runner) {
      super(runner, TaskRunnerImpl.sQueue);
      this.mNativePtr = runner.mNativeTaskRunnerAndroid;
    }

    void destroy() {
      TaskRunnerImplJni.get().destroy(this.mNativePtr);
    }
  }

  private static void destroyGarbageCollectedTaskRunners() {
    while (true) {
      TaskRunnerCleaner cleaner = (TaskRunnerCleaner) sQueue.poll();
      if (cleaner == null) {
        return;
      }
      cleaner.destroy();
      Set<TaskRunnerCleaner> set = sCleaners;
      synchronized (set) {
        set.remove(cleaner);
      }
    }
  }

  public TaskRunnerImpl(int traits) {
    this(traits, "TaskRunnerImpl", 0);
    destroyGarbageCollectedTaskRunners();
  }

  public TaskRunnerImpl(int traits, String traceCategory, int taskRunnerType) {
    this.mRunPreNativeTaskClosure =
        new Runnable() {
          @Override
          public final void run() {
            TaskRunnerImpl.this.runPreNativeTask();
          }
        };
    this.mPreNativeTaskLock = new Object();
    this.mTaskTraits = traits;
    this.mTraceEvent = traceCategory + ".PreNativeTask.run";
    this.mTaskRunnerType = taskRunnerType;
  }

  @Override
  public void postTask(Runnable task) {
    postDelayedTask(task, 0L);
  }

  @Override
  public void postDelayedTask(Runnable task, long delay) {
    if (this.mNativeTaskRunnerAndroid != 0) {
      TaskRunnerImplJni.get()
          .postDelayedTask(this.mNativeTaskRunnerAndroid, task, delay, task.getClass().getName());
      return;
    }
    synchronized (this.mPreNativeTaskLock) {
      oneTimeInitialization();
      if (this.mNativeTaskRunnerAndroid != 0) {
        TaskRunnerImplJni.get()
            .postDelayedTask(this.mNativeTaskRunnerAndroid, task, delay, task.getClass().getName());
        return;
      }
      if (delay == 0) {
        this.mPreNativeTasks.add(task);
        schedulePreNativeTask();
      } else if (!schedulePreNativeDelayedTask(task, delay)) {
        Pair<Runnable, Long> preNativeDelayedTask = new Pair<>(task, Long.valueOf(delay));
        this.mPreNativeDelayedTasks.add(preNativeDelayedTask);
      }
    }
  }

  public Boolean belongsToCurrentThreadInternal() {
    if (getClass().equals(TaskRunnerImpl.class)) {
      throw new AssertionError();
    }
    synchronized (this.mPreNativeTaskLock) {
      oneTimeInitialization();
    }
    if (this.mNativeTaskRunnerAndroid == 0) {
      return null;
    }
    return Boolean.valueOf(
        TaskRunnerImplJni.get().belongsToCurrentThread(this.mNativeTaskRunnerAndroid));
  }

  private void oneTimeInitialization() {
    if (this.mDidOneTimeInitialization) {
      return;
    }
    this.mDidOneTimeInitialization = true;
    if (!PostTask.registerPreNativeTaskRunner(this)) {
      initNativeTaskRunner();
      return;
    }
    this.mPreNativeTasks = new LinkedList<>();
    this.mPreNativeDelayedTasks = new ArrayList();
  }

  public void schedulePreNativeTask() {
    PostTask.getPrenativeThreadPoolExecutor().execute(this.mRunPreNativeTaskClosure);
  }

  protected boolean schedulePreNativeDelayedTask(Runnable task, long delay) {
    return false;
  }

  public void runPreNativeTask() {
    TraceEvent te = TraceEvent.scoped(this.mTraceEvent);
    try {
      synchronized (this.mPreNativeTaskLock) {
        LinkedList<Runnable> linkedList = this.mPreNativeTasks;
        if (linkedList != null) {
          Runnable task = linkedList.poll();
          switch (this.mTaskTraits) {
            case 0:
            case 1:
              Process.setThreadPriority(10);
              break;
            case 2:
            case 3:
              Process.setThreadPriority(0);
              break;
            case 4:
            case 5:
              Process.setThreadPriority(-1);
              break;
          }
          task.run();
          if (te != null) {
            te.close();
          }
        } else if (te != null) {
          te.close();
        }
      }
    } catch (Throwable th) {
      if (te != null) {
        try {
          te.close();
        } catch (Throwable th2) {
          th.addSuppressed(th2);
        }
      }
      throw th;
    }
  }

  public void initNativeTaskRunner() {
    long nativeTaskRunnerAndroid =
        TaskRunnerImplJni.get().init(this.mTaskRunnerType, this.mTaskTraits);
    synchronized (this.mPreNativeTaskLock) {
      LinkedList<Runnable> linkedList = this.mPreNativeTasks;
      if (linkedList != null) {
        Iterator<Runnable> it = linkedList.iterator();
        while (it.hasNext()) {
          Runnable task = it.next();
          TaskRunnerImplJni.get()
              .postDelayedTask(nativeTaskRunnerAndroid, task, 0L, task.getClass().getName());
        }
        this.mPreNativeTasks = null;
      }
      List<Pair<Runnable, Long>> list = this.mPreNativeDelayedTasks;
      if (list != null) {
        for (Pair<Runnable, Long> task2 : list) {
          TaskRunnerImplJni.get()
              .postDelayedTask(
                  nativeTaskRunnerAndroid,
                  (Runnable) task2.first,
                  ((Long) task2.second).longValue(),
                  task2.getClass().getName());
        }
        this.mPreNativeDelayedTasks = null;
      }
      if (this.mNativeTaskRunnerAndroid != 0) {
        throw new AssertionError();
      }
      this.mNativeTaskRunnerAndroid = nativeTaskRunnerAndroid;
    }
    Set<TaskRunnerCleaner> set = sCleaners;
    synchronized (set) {
      set.add(new TaskRunnerCleaner(this));
    }
    destroyGarbageCollectedTaskRunners();
  }
}
