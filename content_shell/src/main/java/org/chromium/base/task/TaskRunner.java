package org.chromium.base.task;

public interface TaskRunner {
  void postDelayedTask(Runnable runnable, long j);

  void postTask(Runnable runnable);
}
