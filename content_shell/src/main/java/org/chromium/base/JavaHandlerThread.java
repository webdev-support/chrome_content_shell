package org.chromium.base;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import org.jni_zero.JNINamespace;

@JNINamespace("base::android")
public class JavaHandlerThread {

  private final HandlerThread mThread;
  private Throwable mUnhandledException;

  public interface Natives {
    void initializeThread(long j, long j2);

    void onLooperStopped(long j);
  }

  public JavaHandlerThread(String name, int priority) {
    this.mThread = new HandlerThread(name, priority);
  }

  private static JavaHandlerThread create(String name, int priority) {
    return new JavaHandlerThread(name, priority);
  }

  public Looper getLooper() {
    if (!hasStarted()) {
      throw new AssertionError();
    }
    return this.mThread.getLooper();
  }

  public void maybeStart() {
    if (hasStarted()) {
      return;
    }
    this.mThread.start();
  }

  private void startAndInitialize(final long nativeThread, final long nativeEvent) {
    maybeStart();
    new Handler(this.mThread.getLooper())
        .post(
            new Runnable() {
              @Override
              public void run() {
                JavaHandlerThreadJni.get().initializeThread(nativeThread, nativeEvent);
              }
            });
  }

  private void quitThreadSafely(final long nativeThread) {
    new Handler(this.mThread.getLooper())
        .post(
            new Runnable() {
              @Override
              public void run() {
                JavaHandlerThread.this.mThread.quit();
                JavaHandlerThreadJni.get().onLooperStopped(nativeThread);
              }
            });
    this.mThread.getLooper().quitSafely();
  }

  private void joinThread() {
    boolean joined = false;
    while (!joined) {
      try {
        this.mThread.join();
        joined = true;
      } catch (InterruptedException e) {
      }
    }
  }

  private boolean hasStarted() {
    return this.mThread.getState() != Thread.State.NEW;
  }

  private boolean isAlive() {
    return this.mThread.isAlive();
  }

  private void listenForUncaughtExceptionsForTesting() {
    this.mThread.setUncaughtExceptionHandler(
        new Thread.UncaughtExceptionHandler() {
          @Override
          public void uncaughtException(Thread t, Throwable e) {
            JavaHandlerThread.this.mUnhandledException = e;
          }
        });
  }

  private Throwable getUncaughtExceptionIfAny() {
    return this.mUnhandledException;
  }
}
