package org.chromium.base;

import android.os.SystemClock;

public class TimeUtils {
  public static final long MILLISECONDS_PER_MINUTE = 60000;
  public static final long NANOSECONDS_PER_MICROSECOND = 1000;
  public static final long NANOSECONDS_PER_MILLISECOND = 1000000;
  public static final long SECONDS_PER_DAY = 86400;
  public static final long SECONDS_PER_HOUR = 3600;
  public static final long SECONDS_PER_MINUTE = 60;
  static FakeClock sFakeClock;

  public interface FakeClock {
    long currentThreadTimeMillis();

    long currentTimeMillis();

    long elapsedRealtimeNanos();

    long uptimeMillis();
  }

  public static class UptimeMillisTimer {
    private final long mStart = TimeUtils.uptimeMillis();

    public long getElapsedMillis() {
      return TimeUtils.uptimeMillis() - this.mStart;
    }
  }

  public static class ElapsedRealtimeMillisTimer {
    private final long mStart = TimeUtils.elapsedRealtimeMillis();

    public long getElapsedMillis() {
      return TimeUtils.elapsedRealtimeMillis() - this.mStart;
    }
  }

  public static class ElapsedRealtimeNanosTimer {
    private final long mStart = TimeUtils.elapsedRealtimeNanos();

    public long getElapsedNanos() {
      return TimeUtils.elapsedRealtimeNanos() - this.mStart;
    }
  }

  public static class CurrentThreadTimeMillisTimer {
    private final long mStart = TimeUtils.currentThreadTimeMillis();

    public long getElapsedMillis() {
      return TimeUtils.currentThreadTimeMillis() - this.mStart;
    }
  }

  private TimeUtils() {}

  public static long currentTimeMillis() {
    FakeClock fakeClock = sFakeClock;
    if (fakeClock != null) {
      return fakeClock.currentTimeMillis();
    }
    return System.currentTimeMillis();
  }

  public static long uptimeMillis() {
    FakeClock fakeClock = sFakeClock;
    if (fakeClock != null) {
      return fakeClock.uptimeMillis();
    }
    return SystemClock.uptimeMillis();
  }

  public static long elapsedRealtimeNanos() {
    FakeClock fakeClock = sFakeClock;
    if (fakeClock != null) {
      return fakeClock.elapsedRealtimeNanos();
    }
    return SystemClock.elapsedRealtimeNanos();
  }

  public static long elapsedRealtimeMillis() {
    FakeClock fakeClock = sFakeClock;
    if (fakeClock != null) {
      return fakeClock.elapsedRealtimeNanos() / NANOSECONDS_PER_MILLISECOND;
    }
    return SystemClock.elapsedRealtime();
  }

  public static long currentThreadTimeMillis() {
    FakeClock fakeClock = sFakeClock;
    if (fakeClock != null) {
      return fakeClock.currentThreadTimeMillis();
    }
    return SystemClock.currentThreadTimeMillis();
  }
}
