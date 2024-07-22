package org.chromium.base;

public final class JniAndroid {
  private static final String TAG = "JniAndroid";
  static boolean sSimulateOomInSanitizedStacktraceForTesting;

  private JniAndroid() {}

  private static String sanitizedStacktraceForUnhandledException(Throwable throwable) {
    if (sSimulateOomInSanitizedStacktraceForTesting) {
      return null;
    }
    try {
      return PiiElider.sanitizeStacktrace(Log.getStackTraceString(throwable));
    } catch (OutOfMemoryError e) {
      return null;
    } catch (Throwable stacktraceThrowable) {
      try {
        return "Error while getting stack trace: " + Log.getStackTraceString(stacktraceThrowable);
      } catch (OutOfMemoryError e2) {
        return null;
      }
    }
  }

  public static class UncaughtExceptionException extends RuntimeException {
    public UncaughtExceptionException(String nativeStackTrace, Throwable uncaughtException) {
      super("Native stack trace:" + System.lineSeparator() + nativeStackTrace, uncaughtException);
    }
  }

  private static Throwable handleException(Throwable throwable, String nativeStackTrace) {
    try {
      Log.e(TAG, "Handling uncaught Java exception", throwable);
      UncaughtExceptionException wrappedThrowable =
          new UncaughtExceptionException(nativeStackTrace, throwable);
      Thread.getDefaultUncaughtExceptionHandler()
          .uncaughtException(Thread.currentThread(), wrappedThrowable);
      Log.e(TAG, "Global uncaught exception handler did not terminate the process.");
      return null;
    } catch (OutOfMemoryError e) {
      return null;
    } catch (Throwable e2) {
      Log.e(TAG, "Exception in uncaught exception handler.", e2);
      return e2;
    }
  }
}
