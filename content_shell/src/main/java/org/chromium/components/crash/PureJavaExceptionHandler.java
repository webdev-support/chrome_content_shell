package org.chromium.components.crash;

public class PureJavaExceptionHandler implements Thread.UncaughtExceptionHandler {
  private static boolean sIsEnabled = true;
  private boolean mHandlingException;
  private final Thread.UncaughtExceptionHandler mParent;
  private JavaExceptionReporterFactory mReporterFactory;

  public interface JavaExceptionReporter {
    void createAndUploadReport(Throwable th);
  }

  public interface JavaExceptionReporterFactory {
    JavaExceptionReporter createJavaExceptionReporter();
  }

  private PureJavaExceptionHandler(
      Thread.UncaughtExceptionHandler parent, JavaExceptionReporterFactory reporterFactory) {
    this.mParent = parent;
    this.mReporterFactory = reporterFactory;
  }

  @Override   public void uncaughtException(Thread t, Throwable e) {
    if (!this.mHandlingException && sIsEnabled) {
      this.mHandlingException = true;
      reportJavaException(e);
    }
    Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.mParent;
    if (uncaughtExceptionHandler != null) {
      uncaughtExceptionHandler.uncaughtException(t, e);
    }
  }

  public static void installHandler(JavaExceptionReporterFactory reporterFactory) {
    if (sIsEnabled) {
      Thread.setDefaultUncaughtExceptionHandler(
          new PureJavaExceptionHandler(
              Thread.getDefaultUncaughtExceptionHandler(), reporterFactory));
    }
  }

  private static void uninstallHandler() {
    sIsEnabled = false;
    CrashKeys.getInstance().flushToNative();
  }

  private void reportJavaException(Throwable e) {
    JavaExceptionReporter reporter = this.mReporterFactory.createJavaExceptionReporter();
    reporter.createAndUploadReport(e);
  }

  public static boolean isEnabled() {
    return sIsEnabled;
  }
}
