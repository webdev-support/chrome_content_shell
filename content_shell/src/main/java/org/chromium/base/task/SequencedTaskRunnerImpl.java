package org.chromium.base.task;

import java.util.concurrent.atomic.AtomicInteger;

public class SequencedTaskRunnerImpl extends TaskRunnerImpl implements SequencedTaskRunner {
  private AtomicInteger mPendingTasks;
  private volatile boolean mReadyToCreateNativeTaskRunner;

  public SequencedTaskRunnerImpl(int traits) {
    super(traits, "SequencedTaskRunnerImpl", 1);
    this.mPendingTasks = new AtomicInteger();
  }

  @Override
  public void schedulePreNativeTask() {
    if (this.mPendingTasks.getAndIncrement() == 0) {
      super.schedulePreNativeTask();
    }
  }

  @Override
  public void runPreNativeTask() {
    super.runPreNativeTask();
    if (this.mPendingTasks.decrementAndGet() > 0) {
      if (!this.mReadyToCreateNativeTaskRunner) {
        super.schedulePreNativeTask();
      } else {
        super.initNativeTaskRunner();
      }
    }
  }

  @Override
  public void initNativeTaskRunner() {
    this.mReadyToCreateNativeTaskRunner = true;
    if (this.mPendingTasks.getAndIncrement() == 0) {
      super.initNativeTaskRunner();
    }
  }
}
