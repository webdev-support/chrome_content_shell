package org.chromium.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.example.chromium_content_view.BuildConfig;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import org.chromium.base.task.PostTask;

public class ThreadUtils {

  private static final Object sLock = new Object();
  private static boolean sThreadAssertsDisabledForTesting;
  private static volatile Handler sUiThreadHandler;
  private static volatile boolean sWillOverride;

  public static class ThreadChecker {

    private long mThreadId;

    public ThreadChecker() {
      resetThreadId();
    }

    public void resetThreadId() {
      this.mThreadId = BuildConfig.ENABLE_ASSERTS ? Process.myTid() : 0L;
    }

    public void assertOnValidThread() {
      if (!ThreadUtils.sThreadAssertsDisabledForTesting && this.mThreadId != Process.myTid()) {
        throw new AssertionError("Must only be used on a single thread.");
      }
    }
  }

  public static void setWillOverrideUiThread() {
    sWillOverride = true;
    if (sUiThreadHandler != null) {
      throw new AssertionError();
    }
  }

  public static void clearUiThreadForTesting() {
    sWillOverride = false;
    PostTask.resetUiThreadForTesting();
    sUiThreadHandler = null;
  }

  public static void setUiThread(Looper looper) {
    if (looper == null) {
      throw new AssertionError();
    }
    synchronized (sLock) {
      if (sUiThreadHandler == null) {
        Handler uiThreadHandler = new Handler(looper);
        PostTask.onUiThreadReady(uiThreadHandler);
        sUiThreadHandler = uiThreadHandler;
        TraceEvent.onUiThreadReady();
      } else if (sUiThreadHandler.getLooper() != looper) {
        Looper looper2 = sUiThreadHandler.getLooper();
        throw new RuntimeException(
            "UI thread looper is already set to "
                + looper2
                + " (Main thread looper is "
                + Looper.getMainLooper()
                + "), cannot set to new looper "
                + looper);
      }
    }
  }

  public static Handler getUiThreadHandler() {
    if (sUiThreadHandler != null) {
      return sUiThreadHandler;
    }
    if (sWillOverride) {
      throw new RuntimeException("Did not yet override the UI thread");
    }
    setUiThread(Looper.getMainLooper());
    return sUiThreadHandler;
  }

  public static void runOnUiThreadBlocking(Runnable r) {
    PostTask.runSynchronously(7, r);
  }

  public static <T> T runOnUiThreadBlockingNoException(Callable<T> c) {
    try {
      return (T) runOnUiThreadBlocking(c);
    } catch (ExecutionException e) {
      throw new RuntimeException("Error occurred waiting for callable", e);
    }
  }

  public static <T> T runOnUiThreadBlocking(Callable<T> c) throws ExecutionException {
    return (T) PostTask.runSynchronously(7, c);
  }

  public static <T> FutureTask<T> runOnUiThread(FutureTask<T> task) {
    PostTask.runOrPostTask(7, task);
    return task;
  }

  public static <T> FutureTask<T> runOnUiThread(Callable<T> c) {
    return runOnUiThread(new FutureTask(c));
  }

  public static void runOnUiThread(Runnable r) {
    PostTask.runOrPostTask(7, r);
  }

  public static <T> FutureTask<T> postOnUiThread(FutureTask<T> task) {
    PostTask.postTask(7, task);
    return task;
  }

  public static void postOnUiThread(Runnable r) {
    PostTask.postTask(7, r);
  }

  public static void postOnUiThreadDelayed(Runnable r, long delayMillis) {
    PostTask.postDelayedTask(7, r, delayMillis);
  }

  public static void assertOnUiThread() {
    if (!sThreadAssertsDisabledForTesting && !runningOnUiThread()) {
      throw new AssertionError("Must be called on the UI thread.");
    }
  }

  public static void checkUiThread() {
    if (!sThreadAssertsDisabledForTesting && !runningOnUiThread()) {
      throw new IllegalStateException("Must be called on the UI thread.");
    }
  }

  public static void assertOnBackgroundThread() {
    if (!sThreadAssertsDisabledForTesting && runningOnUiThread()) {
      throw new AssertionError("Must be called on a thread other than UI.");
    }
  }

  public static void setThreadAssertsDisabledForTesting(boolean disabled) {
    sThreadAssertsDisabledForTesting = disabled;
    ResettersForTesting.register(
        new Runnable() {
          @Override
          public final void run() {
            ThreadUtils.sThreadAssertsDisabledForTesting = false;
          }
        });
  }

  public static boolean runningOnUiThread() {
    return getUiThreadHandler().getLooper() == Looper.myLooper();
  }

  public static Looper getUiThreadLooper() {
    return getUiThreadHandler().getLooper();
  }

  public static void setThreadPriorityAudio(int tid) {
    Process.setThreadPriority(tid, -16);
  }

  private static boolean isThreadPriorityAudio(int tid) {
    return Process.getThreadPriority(tid) == -16;
  }
}
