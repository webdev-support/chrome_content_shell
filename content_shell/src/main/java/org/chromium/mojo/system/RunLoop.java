package org.chromium.mojo.system;

import java.io.Closeable;

public interface RunLoop extends Closeable {
  @Override   void close();

  void postDelayedTask(Runnable runnable, long j);

  void run();

  void runUntilIdle();
}
