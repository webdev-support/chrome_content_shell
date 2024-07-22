package org.chromium.base.task;

import android.os.Handler;
import org.jni_zero.JNINamespace;

@JNINamespace("base")
public class SingleThreadTaskRunnerImpl extends TaskRunnerImpl implements SingleThreadTaskRunner {

  private final Handler mHandler;

  public SingleThreadTaskRunnerImpl(Handler handler, int traits) {
    super(traits, "SingleThreadTaskRunnerImpl", 2);
    this.mHandler = handler;
  }

  @Override
  public boolean belongsToCurrentThread() {
    Boolean belongs = belongsToCurrentThreadInternal();
    if (belongs != null) {
      return belongs.booleanValue();
    }
    Handler handler = this.mHandler;
    if (handler != null) {
      return handler.getLooper().getThread() == Thread.currentThread();
    }
    throw new AssertionError();
  }

  @Override
  public void schedulePreNativeTask() {
    Handler handler = this.mHandler;
    if (handler == null) {
      return;
    }
    handler.post(this.mRunPreNativeTaskClosure);
  }

  @Override
  protected boolean schedulePreNativeDelayedTask(Runnable task, long delay) {
    Handler handler = this.mHandler;
    if (handler == null) {
      return false;
    }
    handler.postDelayed(task, delay);
    return true;
  }
}
