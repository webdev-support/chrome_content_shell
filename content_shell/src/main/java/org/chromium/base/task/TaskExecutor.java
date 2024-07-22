package org.chromium.base.task;

public interface TaskExecutor {
  boolean canRunTaskImmediately(int i);

  SequencedTaskRunner createSequencedTaskRunner(int i);

  SingleThreadTaskRunner createSingleThreadTaskRunner(int i);

  TaskRunner createTaskRunner(int i);

  void postDelayedTask(int i, Runnable runnable, long j);
}
