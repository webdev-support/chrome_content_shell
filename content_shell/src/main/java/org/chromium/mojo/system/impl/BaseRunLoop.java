package org.chromium.mojo.system.impl;

import org.chromium.mojo.system.RunLoop;
import org.jni_zero.JNINamespace;

@JNINamespace("mojo::android")
public class BaseRunLoop implements RunLoop {

  private final CoreImpl mCore;
  private long mRunLoopID = BaseRunLoopJni.get().createBaseRunLoop(this);

  public interface Natives {
    long createBaseRunLoop(BaseRunLoop baseRunLoop);

    void deleteMessageLoop(BaseRunLoop baseRunLoop, long j);

    void postDelayedTask(BaseRunLoop baseRunLoop, long j, Runnable runnable, long j2);

    void run(BaseRunLoop baseRunLoop);

    void runUntilIdle(BaseRunLoop baseRunLoop);
  }

  public BaseRunLoop(CoreImpl core) {
    this.mCore = core;
  }

  @Override
  public void run() {
    if (this.mRunLoopID == 0) {
      throw new AssertionError("The run loop cannot run once closed");
    }
    BaseRunLoopJni.get().run(this);
  }

  @Override
  public void runUntilIdle() {
    if (this.mRunLoopID == 0) {
      throw new AssertionError("The run loop cannot run once closed");
    }
    BaseRunLoopJni.get().runUntilIdle(this);
  }

  @Override
  public void postDelayedTask(Runnable runnable, long delay) {
    if (this.mRunLoopID == 0) {
      throw new AssertionError("The run loop cannot run tasks once closed");
    }
    BaseRunLoopJni.get().postDelayedTask(this, this.mRunLoopID, runnable, delay);
  }

  @Override
  public void close() {
    if (this.mRunLoopID == 0) {
      return;
    }
    if (this.mCore.getCurrentRunLoop() != this) {
      throw new AssertionError("Only the current run loop can be closed");
    }
    this.mCore.clearCurrentRunLoop();
    BaseRunLoopJni.get().deleteMessageLoop(this, this.mRunLoopID);
    this.mRunLoopID = 0L;
  }

  private static void runRunnable(Runnable runnable) {
    runnable.run();
  }
}
