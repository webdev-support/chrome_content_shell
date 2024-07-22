package org.chromium.base;

import java.util.Locale;

public class Log {
  public static final int ASSERT = 7;
  public static final int DEBUG = 3;
  public static final int ERROR = 6;
  public static final int INFO = 4;
  public static final int VERBOSE = 2;
  public static final int WARN = 5;

  private Log() {}

  private static String formatLog(String messageTemplate, Throwable tr, Object... params) {
    if (params != null) {
      if ((tr == null && params.length > 0) || params.length > 1) {
        return String.format(Locale.US, messageTemplate, params);
      }
      return messageTemplate;
    }
    return messageTemplate;
  }

  public static String normalizeTag(String tag) {
    return "cr_" + tag;
  }

  private static String formatLogWithStack(String messageTemplate, Throwable tr, Object... params) {
    String callOrigin = getCallOrigin();
    return "[" + callOrigin + "] " + formatLog(messageTemplate, tr, params);
  }

  private static boolean isDebug() {
    return true;
  }

  public static boolean isLoggable(String tag, int level) {
    if (!isDebug() && level <= 4) {
      return false;
    }
    return android.util.Log.isLoggable(tag, level);
  }

  public static void v(String tag, String messageTemplate, Object... args) {
    if (isDebug()) {
      Throwable tr = getThrowableToLog(args);
      String message = formatLogWithStack(messageTemplate, tr, args);
      String tag2 = normalizeTag(tag);
      if (tr != null) {
        android.util.Log.v(tag2, message, tr);
      } else {
        android.util.Log.v(tag2, message);
      }
    }
  }

  public static void d(String tag, String messageTemplate, Object... args) {
    if (isDebug()) {
      Throwable tr = getThrowableToLog(args);
      String message = formatLogWithStack(messageTemplate, tr, args);
      String tag2 = normalizeTag(tag);
      if (tr != null) {
        android.util.Log.d(tag2, message, tr);
      } else {
        android.util.Log.d(tag2, message);
      }
    }
  }

  public static void i(String tag, String messageTemplate, Object... args) {
    Throwable tr = getThrowableToLog(args);
    String message = formatLog(messageTemplate, tr, args);
    String tag2 = normalizeTag(tag);
    if (tr != null) {
      android.util.Log.i(tag2, message, tr);
    } else {
      android.util.Log.i(tag2, message);
    }
  }

  public static void i(String tag, String message) {
    android.util.Log.i(normalizeTag(tag), message);
  }

  public static void i(String tag, String message, Throwable t) {
    android.util.Log.i(normalizeTag(tag), message, t);
  }

  public static void i(String tag, String messageTemplate, Object param1) {
    android.util.Log.i(normalizeTag(tag), String.format(Locale.US, messageTemplate, param1));
  }

  public static void i(String tag, String messageTemplate, Object param1, Throwable t) {
    android.util.Log.i(normalizeTag(tag), String.format(Locale.US, messageTemplate, param1), t);
  }

  public static void i(String tag, String messageTemplate, Object param1, Object param2) {
    android.util.Log.i(
        normalizeTag(tag), String.format(Locale.US, messageTemplate, param1, param2));
  }

  public static void i(
      String tag, String messageTemplate, Object param1, Object param2, Throwable t) {
    android.util.Log.i(
        normalizeTag(tag), String.format(Locale.US, messageTemplate, param1, param2), t);
  }

  public static void i(
      String tag, String messageTemplate, Object param1, Object param2, Object param3) {
    android.util.Log.i(
        normalizeTag(tag), String.format(Locale.US, messageTemplate, param1, param2, param3));
  }

  public static void i(
      String tag,
      String messageTemplate,
      Object param1,
      Object param2,
      Object param3,
      Throwable t) {
    android.util.Log.i(
        normalizeTag(tag), String.format(Locale.US, messageTemplate, param1, param2, param3), t);
  }

  public static void i(
      String tag,
      String messageTemplate,
      Object param1,
      Object param2,
      Object param3,
      Object param4) {
    android.util.Log.i(
        normalizeTag(tag),
        String.format(Locale.US, messageTemplate, param1, param2, param3, param4));
  }

  public static void i(
      String tag,
      String messageTemplate,
      Object param1,
      Object param2,
      Object param3,
      Object param4,
      Throwable t) {
    android.util.Log.i(
        normalizeTag(tag),
        String.format(Locale.US, messageTemplate, param1, param2, param3, param4),
        t);
  }

  public static void i(
      String tag,
      String messageTemplate,
      Object param1,
      Object param2,
      Object param3,
      Object param4,
      Object param5) {
    android.util.Log.i(
        normalizeTag(tag),
        String.format(Locale.US, messageTemplate, param1, param2, param3, param4, param5));
  }

  public static void i(
      String tag,
      String messageTemplate,
      Object param1,
      Object param2,
      Object param3,
      Object param4,
      Object param5,
      Throwable t) {
    android.util.Log.i(
        normalizeTag(tag),
        String.format(Locale.US, messageTemplate, param1, param2, param3, param4, param5),
        t);
  }

  public static void i(
      String tag,
      String messageTemplate,
      Object param1,
      Object param2,
      Object param3,
      Object param4,
      Object param5,
      Object param6) {
    android.util.Log.i(
        normalizeTag(tag),
        String.format(Locale.US, messageTemplate, param1, param2, param3, param4, param5, param6));
  }

  public static void i(
      String tag,
      String messageTemplate,
      Object param1,
      Object param2,
      Object param3,
      Object param4,
      Object param5,
      Object param6,
      Throwable t) {
    android.util.Log.i(
        normalizeTag(tag),
        String.format(Locale.US, messageTemplate, param1, param2, param3, param4, param5, param6),
        t);
  }

  public static void w(String tag, String messageTemplate, Object... args) {
    Throwable tr = getThrowableToLog(args);
    String message = formatLog(messageTemplate, tr, args);
    String tag2 = normalizeTag(tag);
    if (tr != null) {
      android.util.Log.w(tag2, message, tr);
    } else {
      android.util.Log.w(tag2, message);
    }
  }

  public static void w(String tag, String message) {
    android.util.Log.w(normalizeTag(tag), message);
  }

  public static void w(String tag, String message, Throwable t) {
    android.util.Log.w(normalizeTag(tag), message, t);
  }

  public static void w(String tag, String messageTemplate, Object param1) {
    android.util.Log.w(normalizeTag(tag), String.format(Locale.US, messageTemplate, param1));
  }

  public static void w(String tag, String messageTemplate, Object param1, Throwable t) {
    android.util.Log.w(normalizeTag(tag), String.format(Locale.US, messageTemplate, param1), t);
  }

  public static void w(String tag, String messageTemplate, Object param1, Object param2) {
    android.util.Log.w(
        normalizeTag(tag), String.format(Locale.US, messageTemplate, param1, param2));
  }

  public static void w(
      String tag, String messageTemplate, Object param1, Object param2, Throwable t) {
    android.util.Log.w(
        normalizeTag(tag), String.format(Locale.US, messageTemplate, param1, param2), t);
  }

  public static void w(
      String tag, String messageTemplate, Object param1, Object param2, Object param3) {
    android.util.Log.w(
        normalizeTag(tag), String.format(Locale.US, messageTemplate, param1, param2, param3));
  }

  public static void w(
      String tag,
      String messageTemplate,
      Object param1,
      Object param2,
      Object param3,
      Throwable t) {
    android.util.Log.w(
        normalizeTag(tag), String.format(Locale.US, messageTemplate, param1, param2, param3), t);
  }

  public static void w(
      String tag,
      String messageTemplate,
      Object param1,
      Object param2,
      Object param3,
      Object param4) {
    android.util.Log.w(
        normalizeTag(tag),
        String.format(Locale.US, messageTemplate, param1, param2, param3, param4));
  }

  public static void w(
      String tag,
      String messageTemplate,
      Object param1,
      Object param2,
      Object param3,
      Object param4,
      Throwable t) {
    android.util.Log.w(
        normalizeTag(tag),
        String.format(Locale.US, messageTemplate, param1, param2, param3, param4),
        t);
  }

  public static void w(
      String tag,
      String messageTemplate,
      Object param1,
      Object param2,
      Object param3,
      Object param4,
      Object param5) {
    android.util.Log.w(
        normalizeTag(tag),
        String.format(Locale.US, messageTemplate, param1, param2, param3, param4, param5));
  }

  public static void w(
      String tag,
      String messageTemplate,
      Object param1,
      Object param2,
      Object param3,
      Object param4,
      Object param5,
      Throwable t) {
    android.util.Log.w(
        normalizeTag(tag),
        String.format(Locale.US, messageTemplate, param1, param2, param3, param4, param5),
        t);
  }

  public static void w(
      String tag,
      String messageTemplate,
      Object param1,
      Object param2,
      Object param3,
      Object param4,
      Object param5,
      Object param6) {
    android.util.Log.w(
        normalizeTag(tag),
        String.format(Locale.US, messageTemplate, param1, param2, param3, param4, param5, param6));
  }

  public static void w(
      String tag,
      String messageTemplate,
      Object param1,
      Object param2,
      Object param3,
      Object param4,
      Object param5,
      Object param6,
      Throwable t) {
    android.util.Log.w(
        normalizeTag(tag),
        String.format(Locale.US, messageTemplate, param1, param2, param3, param4, param5, param6),
        t);
  }

  public static void e(String tag, String messageTemplate, Object... args) {
    Throwable tr = getThrowableToLog(args);
    String message = formatLog(messageTemplate, tr, args);
    String tag2 = normalizeTag(tag);
    if (tr != null) {
      android.util.Log.e(tag2, message, tr);
    } else {
      android.util.Log.e(tag2, message);
    }
  }

  public static void e(String tag, String message) {
    android.util.Log.e(normalizeTag(tag), message);
  }

  public static void e(String tag, String message, Throwable t) {
    android.util.Log.e(normalizeTag(tag), message, t);
  }

  public static void e(String tag, String messageTemplate, Object param1) {
    android.util.Log.e(normalizeTag(tag), String.format(Locale.US, messageTemplate, param1));
  }

  public static void e(String tag, String messageTemplate, Object param1, Throwable t) {
    android.util.Log.e(normalizeTag(tag), String.format(Locale.US, messageTemplate, param1), t);
  }

  public static void e(String tag, String messageTemplate, Object param1, Object param2) {
    android.util.Log.e(
        normalizeTag(tag), String.format(Locale.US, messageTemplate, param1, param2));
  }

  public static void e(
      String tag, String messageTemplate, Object param1, Object param2, Throwable t) {
    android.util.Log.e(
        normalizeTag(tag), String.format(Locale.US, messageTemplate, param1, param2), t);
  }

  public static void e(
      String tag, String messageTemplate, Object param1, Object param2, Object param3) {
    android.util.Log.e(
        normalizeTag(tag), String.format(Locale.US, messageTemplate, param1, param2, param3));
  }

  public static void e(
      String tag,
      String messageTemplate,
      Object param1,
      Object param2,
      Object param3,
      Throwable t) {
    android.util.Log.e(
        normalizeTag(tag), String.format(Locale.US, messageTemplate, param1, param2, param3), t);
  }

  public static void e(
      String tag,
      String messageTemplate,
      Object param1,
      Object param2,
      Object param3,
      Object param4) {
    android.util.Log.e(
        normalizeTag(tag),
        String.format(Locale.US, messageTemplate, param1, param2, param3, param4));
  }

  public static void e(
      String tag,
      String messageTemplate,
      Object param1,
      Object param2,
      Object param3,
      Object param4,
      Throwable t) {
    android.util.Log.e(
        normalizeTag(tag),
        String.format(Locale.US, messageTemplate, param1, param2, param3, param4),
        t);
  }

  public static void e(
      String tag,
      String messageTemplate,
      Object param1,
      Object param2,
      Object param3,
      Object param4,
      Object param5) {
    android.util.Log.e(
        normalizeTag(tag),
        String.format(Locale.US, messageTemplate, param1, param2, param3, param4, param5));
  }

  public static void e(
      String tag,
      String messageTemplate,
      Object param1,
      Object param2,
      Object param3,
      Object param4,
      Object param5,
      Throwable t) {
    android.util.Log.e(
        normalizeTag(tag),
        String.format(Locale.US, messageTemplate, param1, param2, param3, param4, param5),
        t);
  }

  public static void e(
      String tag,
      String messageTemplate,
      Object param1,
      Object param2,
      Object param3,
      Object param4,
      Object param5,
      Object param6) {
    android.util.Log.e(
        normalizeTag(tag),
        String.format(Locale.US, messageTemplate, param1, param2, param3, param4, param5, param6));
  }

  public static void e(
      String tag,
      String messageTemplate,
      Object param1,
      Object param2,
      Object param3,
      Object param4,
      Object param5,
      Object param6,
      Throwable t) {
    android.util.Log.e(
        normalizeTag(tag),
        String.format(Locale.US, messageTemplate, param1, param2, param3, param4, param5, param6),
        t);
  }

  public static void wtf(String tag, String messageTemplate, Object... args) {
    Throwable tr = getThrowableToLog(args);
    String message = formatLog(messageTemplate, tr, args);
    String tag2 = normalizeTag(tag);
    if (tr != null) {
      android.util.Log.wtf(tag2, message, tr);
    } else {
      android.util.Log.wtf(tag2, message);
    }
  }

  public static void wtf(String tag, String message) {
    android.util.Log.wtf(normalizeTag(tag), message);
  }

  public static void wtf(String tag, String message, Throwable t) {
    android.util.Log.wtf(normalizeTag(tag), message, t);
  }

  public static void wtf(String tag, String messageTemplate, Object param1) {
    android.util.Log.wtf(normalizeTag(tag), String.format(Locale.US, messageTemplate, param1));
  }

  public static void wtf(String tag, String messageTemplate, Object param1, Throwable t) {
    android.util.Log.wtf(normalizeTag(tag), String.format(Locale.US, messageTemplate, param1), t);
  }

  public static void wtf(String tag, String messageTemplate, Object param1, Object param2) {
    android.util.Log.wtf(
        normalizeTag(tag), String.format(Locale.US, messageTemplate, param1, param2));
  }

  public static void wtf(
      String tag, String messageTemplate, Object param1, Object param2, Throwable t) {
    android.util.Log.wtf(
        normalizeTag(tag), String.format(Locale.US, messageTemplate, param1, param2), t);
  }

  public static void wtf(
      String tag, String messageTemplate, Object param1, Object param2, Object param3) {
    android.util.Log.wtf(
        normalizeTag(tag), String.format(Locale.US, messageTemplate, param1, param2, param3));
  }

  public static void wtf(
      String tag,
      String messageTemplate,
      Object param1,
      Object param2,
      Object param3,
      Throwable t) {
    android.util.Log.wtf(
        normalizeTag(tag), String.format(Locale.US, messageTemplate, param1, param2, param3), t);
  }

  public static void wtf(
      String tag,
      String messageTemplate,
      Object param1,
      Object param2,
      Object param3,
      Object param4) {
    android.util.Log.wtf(
        normalizeTag(tag),
        String.format(Locale.US, messageTemplate, param1, param2, param3, param4));
  }

  public static void wtf(
      String tag,
      String messageTemplate,
      Object param1,
      Object param2,
      Object param3,
      Object param4,
      Throwable t) {
    android.util.Log.wtf(
        normalizeTag(tag),
        String.format(Locale.US, messageTemplate, param1, param2, param3, param4),
        t);
  }

  public static void wtf(
      String tag,
      String messageTemplate,
      Object param1,
      Object param2,
      Object param3,
      Object param4,
      Object param5) {
    android.util.Log.wtf(
        normalizeTag(tag),
        String.format(Locale.US, messageTemplate, param1, param2, param3, param4, param5));
  }

  public static void wtf(
      String tag,
      String messageTemplate,
      Object param1,
      Object param2,
      Object param3,
      Object param4,
      Object param5,
      Throwable t) {
    android.util.Log.wtf(
        normalizeTag(tag),
        String.format(Locale.US, messageTemplate, param1, param2, param3, param4, param5),
        t);
  }

  public static void wtf(
      String tag,
      String messageTemplate,
      Object param1,
      Object param2,
      Object param3,
      Object param4,
      Object param5,
      Object param6) {
    android.util.Log.wtf(
        normalizeTag(tag),
        String.format(Locale.US, messageTemplate, param1, param2, param3, param4, param5, param6));
  }

  public static void wtf(
      String tag,
      String messageTemplate,
      Object param1,
      Object param2,
      Object param3,
      Object param4,
      Object param5,
      Object param6,
      Throwable t) {
    android.util.Log.wtf(
        normalizeTag(tag),
        String.format(Locale.US, messageTemplate, param1, param2, param3, param4, param5, param6),
        t);
  }

  public static String getStackTraceString(Throwable tr) {
    return android.util.Log.getStackTraceString(tr);
  }

  private static Throwable getThrowableToLog(Object[] args) {
    if (args == null || args.length == 0) {
      return null;
    }
    Object lastArg = args[args.length - 1];
    if (!(lastArg instanceof Throwable)) {
      return null;
    }
    return (Throwable) lastArg;
  }

  private static String getCallOrigin() {
    StackTraceElement[] st = Thread.currentThread().getStackTrace();
    String logClassName = Log.class.getName();
    int callerStackIndex = 0;
    while (true) {
      if (callerStackIndex >= st.length) {
        break;
      } else if (!st[callerStackIndex].getClassName().equals(logClassName)) {
        callerStackIndex++;
      } else {
        callerStackIndex += 3;
        break;
      }
    }
    String fileName = st[callerStackIndex].getFileName();
    return fileName + ":" + st[callerStackIndex].getLineNumber();
  }
}
