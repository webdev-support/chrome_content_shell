package org.chromium.net;

import android.net.TrafficStats;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ThreadStatsUid {
  private static final Method sClearThreadStatsUid;
  private static final Method sSetThreadStatsUid;

  static {
    try {
      sSetThreadStatsUid = TrafficStats.class.getMethod("setThreadStatsUid", Integer.TYPE);
      sClearThreadStatsUid = TrafficStats.class.getMethod("clearThreadStatsUid", new Class[0]);
    } catch (NoSuchMethodException | SecurityException e) {
      throw new RuntimeException("Unable to get TrafficStats methods", e);
    }
  }

  public static void set(int uid) {
    try {
      sSetThreadStatsUid.invoke(null, Integer.valueOf(uid));
    } catch (IllegalAccessException e) {
      throw new RuntimeException("TrafficStats.setThreadStatsUid failed", e);
    } catch (InvocationTargetException e2) {
      throw new RuntimeException("TrafficStats.setThreadStatsUid failed", e2);
    }
  }

  public static void clear() {
    try {
      sClearThreadStatsUid.invoke(null, new Object[0]);
    } catch (IllegalAccessException e) {
      throw new RuntimeException("TrafficStats.clearThreadStatsUid failed", e);
    } catch (InvocationTargetException e2) {
      throw new RuntimeException("TrafficStats.clearThreadStatsUid failed", e2);
    }
  }
}
