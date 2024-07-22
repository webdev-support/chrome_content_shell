package org.chromium.base;

import org.jni_zero.JNINamespace;

@JNINamespace("base::android")
public class JavaExceptionReporter implements Thread.UncaughtExceptionHandler {

  private final boolean mCrashAfterReport;
  private boolean mHandlingException;
  private final Thread.UncaughtExceptionHandler mParent;

  public interface Natives {
    void reportJavaException(boolean z, Throwable th);

    void reportJavaStackTrace(String str);
  }

  private JavaExceptionReporter(Thread.UncaughtExceptionHandler parent, boolean crashAfterReport) {
    this.mParent = parent;
    this.mCrashAfterReport = crashAfterReport;
  }

  @Override   public void uncaughtException(Thread t, Throwable e) {
    if (!this.mHandlingException) {
      this.mHandlingException = true;
      JavaExceptionReporterJni.get()
          .reportJavaException(
              this.mCrashAfterReport,
              e instanceof JniAndroid.UncaughtExceptionException ? e.getCause() : e);
    }
    Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.mParent;
    if (uncaughtExceptionHandler != null) {
      uncaughtExceptionHandler.uncaughtException(t, e);
    }
  }

  public static void reportStackTrace(String stackTrace) {
    if (!ThreadUtils.runningOnUiThread()) {
      throw new AssertionError();
    }
    JavaExceptionReporterJni.get().reportJavaStackTrace(PiiElider.sanitizeStacktrace(stackTrace));
  }

  public static void reportException(Throwable exception) {
    if (!ThreadUtils.runningOnUiThread()) {
      throw new AssertionError();
    }
    JavaExceptionReporterJni.get().reportJavaException(false, exception);
  }

  private static void installHandler(boolean crashAfterReport) {
    Thread.setDefaultUncaughtExceptionHandler(
        new JavaExceptionReporter(Thread.getDefaultUncaughtExceptionHandler(), crashAfterReport));
  }
}
