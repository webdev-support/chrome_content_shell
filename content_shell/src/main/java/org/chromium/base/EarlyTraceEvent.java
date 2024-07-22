package org.chromium.base;

import android.os.Process;
import android.os.StrictMode;
import android.os.SystemClock;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.jni_zero.JNINamespace;

@JNINamespace("base::android")
public class EarlyTraceEvent {

  private static final String BACKGROUND_STARTUP_TRACING_ENABLED_KEY = "bg_startup_tracing";
  static final int STATE_DISABLED = 0;
  static final int STATE_ENABLED = 1;
  static final int STATE_FINISHED = 2;
  private static final String TRACE_CONFIG_FILENAME = "/data/local/chrome-trace-config.json";
  public static final String TRACE_EARLY_JAVA_IN_CHILD_SWITCH = "trace-early-java-in-child";
  private static final String TRACE_STARTUP_SWITCH = "trace-startup";
  static List<AsyncEvent> sAsyncEvents;
  private static boolean sCachedBackgroundStartupTracingFlag;
  private static volatile boolean sEnabledInChildProcessBeforeCommandLine;
  static List<Event> sEvents;
  static volatile int sState = 0;
  static final Object sLock = new Object();
  static final List<ActivityStartupEvent> sActivityStartupEvents = new ArrayList();
  static final List<ActivityLaunchCauseEvent> sActivityLaunchCauseEvents = new ArrayList();

  public interface Natives {
    void recordEarlyAsyncBeginEvent(String str, long j, long j2);

    void recordEarlyAsyncEndEvent(long j, long j2);

    void recordEarlyBeginEvent(String str, long j, int i, long j2);

    void recordEarlyEndEvent(String str, long j, int i, long j2);

    void recordEarlyToplevelBeginEvent(String str, long j, int i, long j2);

    void recordEarlyToplevelEndEvent(String str, long j, int i, long j2);
  }

  public static final class Event {
    final boolean mIsStart;
    final boolean mIsToplevel;
    final String mName;
    final int mThreadId = Process.myTid();
    final long mTimeNanos = System.nanoTime();
    final long mThreadTimeMillis = SystemClock.currentThreadTimeMillis();

    Event(String name, boolean isStart, boolean isToplevel) {
      this.mIsStart = isStart;
      this.mIsToplevel = isToplevel;
      this.mName = name;
    }
  }

  public static final class AsyncEvent {
    final long mId;
    final boolean mIsStart;
    final String mName;
    final long mTimeNanos = System.nanoTime();

    AsyncEvent(String name, long id, boolean isStart) {
      this.mName = name;
      this.mId = id;
      this.mIsStart = isStart;
    }
  }

  public static final class ActivityStartupEvent {
    final long mId;
    final long mTimeMs;

    ActivityStartupEvent(long id, long timeMs) {
      this.mId = id;
      this.mTimeMs = timeMs;
    }
  }

  public static final class ActivityLaunchCauseEvent {
    final long mId;
    final int mLaunchCause;
    final long mTimeMs = SystemClock.uptimeMillis();

    ActivityLaunchCauseEvent(long id, int launchCause) {
      this.mId = id;
      this.mLaunchCause = launchCause;
    }
  }

  public static void maybeEnableInBrowserProcess() {
    ThreadUtils.assertOnUiThread();
    if (sEnabledInChildProcessBeforeCommandLine) {
      throw new AssertionError("Should not have been initialized in a child process");
    }
    if (sState != 0) {
      return;
    }
    boolean shouldEnable = false;
    StrictMode.ThreadPolicy oldPolicy = StrictMode.allowThreadDiskReads();
    try {
      if (CommandLine.getInstance().hasSwitch(TRACE_STARTUP_SWITCH)) {
        shouldEnable = true;
      } else {
        try {
          shouldEnable = new File(TRACE_CONFIG_FILENAME).exists();
        } catch (SecurityException e) {
        }
      }
      if (ContextUtils.getAppSharedPreferences()
          .getBoolean(BACKGROUND_STARTUP_TRACING_ENABLED_KEY, false)) {
        if (shouldEnable) {
          setBackgroundStartupTracingFlag(false);
          sCachedBackgroundStartupTracingFlag = false;
        } else {
          sCachedBackgroundStartupTracingFlag = true;
          shouldEnable = true;
        }
      }
      if (shouldEnable) {
        enable();
      }
    } finally {
      StrictMode.setThreadPolicy(oldPolicy);
    }
  }

  public static void earlyEnableInChildWithoutCommandLine() {
    sEnabledInChildProcessBeforeCommandLine = true;
    if (sState != 0) {
      throw new AssertionError();
    }
    enable();
  }

  public static void onCommandLineAvailableInChildProcess() {
    if (sEnabledInChildProcessBeforeCommandLine) {
      synchronized (sLock) {
        if (!CommandLine.getInstance().hasSwitch(TRACE_EARLY_JAVA_IN_CHILD_SWITCH)) {
          reset();
          return;
        }
        if (sState == 0) {
          enable();
        }
      }
    }
  }

  static void enable() {
    synchronized (sLock) {
      if (sState != 0) {
        return;
      }
      sEvents = new ArrayList();
      sAsyncEvents = new ArrayList();
      sState = 1;
    }
  }

  public static void disable() {
    synchronized (sLock) {
      if (enabled()) {
        if (!sEvents.isEmpty()) {
          dumpEvents(sEvents);
          sEvents.clear();
        }
        if (!sAsyncEvents.isEmpty()) {
          dumpAsyncEvents(sAsyncEvents);
          sAsyncEvents.clear();
        }
        sState = 2;
        sEvents = null;
        sAsyncEvents = null;
      }
    }
  }

  static void reset() {
    synchronized (sLock) {
      sState = 0;
      sEvents = null;
      sAsyncEvents = null;
    }
  }

  public static boolean enabled() {
    return sState == 1;
  }

  static void setBackgroundStartupTracingFlag(boolean enabled) {
    StrictModeContext ignored = StrictModeContext.allowDiskWrites();
    try {
      ContextUtils.getAppSharedPreferences()
          .edit()
          .putBoolean(BACKGROUND_STARTUP_TRACING_ENABLED_KEY, enabled)
          .apply();
      if (ignored != null) {
        ignored.close();
      }
    } catch (Throwable th) {
      if (ignored != null) {
        try {
          ignored.close();
        } catch (Throwable th2) {
          th.addSuppressed(th2);
        }
      }
      throw th;
    }
  }

  public static boolean getBackgroundStartupTracingFlag() {
    return sCachedBackgroundStartupTracingFlag;
  }

  public static void begin(String name, boolean isToplevel) {
    if (enabled()) {
      Event event = new Event(name, true, isToplevel);
      synchronized (sLock) {
        if (enabled()) {
          sEvents.add(event);
        }
      }
    }
  }

  public static void end(String name, boolean isToplevel) {
    if (enabled()) {
      Event event = new Event(name, false, isToplevel);
      synchronized (sLock) {
        if (enabled()) {
          sEvents.add(event);
        }
      }
    }
  }

  public static void startAsync(String name, long id) {
    if (enabled()) {
      AsyncEvent event = new AsyncEvent(name, id, true);
      synchronized (sLock) {
        if (enabled()) {
          sAsyncEvents.add(event);
        }
      }
    }
  }

  public static void finishAsync(String name, long id) {
    if (enabled()) {
      AsyncEvent event = new AsyncEvent(name, id, false);
      synchronized (sLock) {
        if (enabled()) {
          sAsyncEvents.add(event);
        }
      }
    }
  }

  public static void startupActivityStart(long activityId, long startTimeMs) {
    ActivityStartupEvent event = new ActivityStartupEvent(activityId, startTimeMs);
    synchronized (sLock) {
      sActivityStartupEvents.add(event);
    }
  }

  public static void startupLaunchCause(long activityId, int launchCause) {
    ActivityLaunchCauseEvent event = new ActivityLaunchCauseEvent(activityId, launchCause);
    synchronized (sLock) {
      sActivityLaunchCauseEvents.add(event);
    }
  }

  static List<Event> getMatchingCompletedEventsForTesting(String eventName) {
    List<Event> matchingEvents;
    synchronized (sLock) {
      matchingEvents = new ArrayList<>();
      for (Event evt : sEvents) {
        if (evt.mName.equals(eventName)) {
          matchingEvents.add(evt);
        }
      }
    }
    return matchingEvents;
  }

  private static void dumpEvents(List<Event> events) {
    for (Event e : events) {
      if (e.mIsStart) {
        if (e.mIsToplevel) {
          EarlyTraceEventJni.get()
              .recordEarlyToplevelBeginEvent(
                  e.mName, e.mTimeNanos, e.mThreadId, e.mThreadTimeMillis);
        } else {
          EarlyTraceEventJni.get()
              .recordEarlyBeginEvent(e.mName, e.mTimeNanos, e.mThreadId, e.mThreadTimeMillis);
        }
      } else if (e.mIsToplevel) {
        EarlyTraceEventJni.get()
            .recordEarlyToplevelEndEvent(e.mName, e.mTimeNanos, e.mThreadId, e.mThreadTimeMillis);
      } else {
        EarlyTraceEventJni.get()
            .recordEarlyEndEvent(e.mName, e.mTimeNanos, e.mThreadId, e.mThreadTimeMillis);
      }
    }
  }

  private static void dumpAsyncEvents(List<AsyncEvent> events) {
    for (AsyncEvent e : events) {
      if (e.mIsStart) {
        EarlyTraceEventJni.get().recordEarlyAsyncBeginEvent(e.mName, e.mId, e.mTimeNanos);
      } else {
        EarlyTraceEventJni.get().recordEarlyAsyncEndEvent(e.mId, e.mTimeNanos);
      }
    }
  }

  public static void dumpActivityStartupEvents() {
    synchronized (sLock) {
      List<ActivityStartupEvent> list = sActivityStartupEvents;
      if (!list.isEmpty()) {
        for (ActivityStartupEvent e : list) {
          TraceEventJni.get().startupActivityStart(e.mId, e.mTimeMs);
        }
        sActivityStartupEvents.clear();
      }
      List<ActivityLaunchCauseEvent> list2 = sActivityLaunchCauseEvents;
      if (!list2.isEmpty()) {
        for (ActivityLaunchCauseEvent e2 : list2) {
          TraceEventJni.get().startupLaunchCause(e2.mId, e2.mTimeMs, e2.mLaunchCause);
        }
        sActivityLaunchCauseEvents.clear();
      }
    }
  }
}
