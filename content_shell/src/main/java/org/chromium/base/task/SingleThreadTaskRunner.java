package org.chromium.base.task;

public interface SingleThreadTaskRunner extends SequencedTaskRunner {
  boolean belongsToCurrentThread();
}
