package org.chromium.ui;

import android.os.Build;
import android.view.MotionEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.chromium.base.TimeUtils;
import org.chromium.base.TraceEvent;

public class MotionEventUtils {
  private static boolean sFailedDoubleReflection;
  private static boolean sFailedReflection;
  private static Method sGetHistoricalEventTimeNanoMethod;
  private static Method sGetTimeNanoMethod;

  public static long getEventTimeNanos(MotionEvent event) {
    if (Build.VERSION.SDK_INT >= 34) {
      return event.getEventTimeNanos();
    }
    if (sFailedReflection) {
      return event.getEventTime() * TimeUtils.NANOSECONDS_PER_MILLISECOND;
    }
    try {
      if (sGetTimeNanoMethod == null) {
        sGetTimeNanoMethod = MotionEvent.class.getMethod("getEventTimeNano", new Class[0]);
      }
      long timeNs = ((Long) sGetTimeNanoMethod.invoke(event, new Object[0])).longValue();
      return timeNs;
    } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
      TraceEvent.instant("MotionEventUtils::getEventTimeNano error", e.toString());
      sFailedReflection = true;
      long timeNs2 = TimeUtils.NANOSECONDS_PER_MILLISECOND * event.getEventTime();
      return timeNs2;
    }
  }

  private static long approximateNanosFromEvent(MotionEvent event, int pos) {
    return event.getHistoricalEventTime(pos) * TimeUtils.NANOSECONDS_PER_MILLISECOND;
  }

  public static long getHistoricalEventTimeNanos(MotionEvent event, int pos) {
    if (Build.VERSION.SDK_INT >= 34) {
      return event.getHistoricalEventTimeNanos(pos);
    }
    if (sFailedDoubleReflection) {
      return approximateNanosFromEvent(event, pos);
    }
    try {
      if (sGetHistoricalEventTimeNanoMethod == null) {
        Method getDeclaredMethod =
            Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
        Class[] cArg = {Integer.TYPE};
        Method method =
            (Method) getDeclaredMethod.invoke(event.getClass(), "getHistoricalEventTimeNano", cArg);
        method.setAccessible(true);
        sGetHistoricalEventTimeNanoMethod = method;
      }
      Method getDeclaredMethod2 = sGetHistoricalEventTimeNanoMethod;
      return ((Long) getDeclaredMethod2.invoke(event, Integer.valueOf(pos))).longValue();
    } catch (Exception e) {
      TraceEvent.instant("MotionEventUtils::getHistoricalEventTimeNanos error", e.toString());
      sFailedDoubleReflection = true;
      return approximateNanosFromEvent(event, pos);
    }
  }
}
