package org.chromium.base.task;

public class ThreadPoolTaskExecutor implements TaskExecutor {
  private static final int TRAITS_COUNT = 6;
  private final TaskRunner[] mTraitsToRunnerMap = new TaskRunner[6];

  public ThreadPoolTaskExecutor() {
    for (int i = 0; i < 6; i++) {
      this.mTraitsToRunnerMap[i] = createTaskRunner(i + 0);
    }
  }

  @Override
  public TaskRunner createTaskRunner(int taskTraits) {
    return new TaskRunnerImpl(taskTraits);
  }

  @Override
  public SequencedTaskRunner createSequencedTaskRunner(int taskTraits) {
    return new SequencedTaskRunnerImpl(taskTraits);
  }

  @Override
  public SingleThreadTaskRunner createSingleThreadTaskRunner(int taskTraits) {
    return new SingleThreadTaskRunnerImpl(null, taskTraits);
  }

  @Override
  public void postDelayedTask(int taskTraits, Runnable task, long delay) {
    int index = taskTraits + 0;
    this.mTraitsToRunnerMap[index].postDelayedTask(task, delay);
  }

  @Override
  public boolean canRunTaskImmediately(int traits) {
    return false;
  }
}
