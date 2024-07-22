package org.chromium.base;

import com.example.chromium_content_view.BuildConfig;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class ResettersForTesting {

  private static LinkedHashSet<Runnable> sClassResetters;
  private static boolean sIsFlushing;
  private static LinkedHashSet<Runnable> sMethodResetters;
  private static final Object sLock = new Object();
  private static int sState = 0;

  @Retention(RetentionPolicy.SOURCE)
  public @interface State {
    public static final int BETWEEN_CLASSES = 1;
    public static final int BETWEEN_METHODS = 3;
    public static final int CLASS_SCOPED = 2;
    public static final int METHOD_SCOPED = 4;
    public static final int NOT_ENABLED = 0;
  }

  public static void register(Runnable runnable) {
    if (!BuildConfig.IS_FOR_TEST) {
      return;
    }
    synchronized (sLock) {
      if (sIsFlushing) {
        throw new IllegalStateException(
            "ResettersForTesting.register() called from within a resetting callback.");
      }
      switch (sState) {
        case 1:
          sClassResetters.add(runnable);
          break;
        case 2:
          sClassResetters.add(runnable);
          break;
        case 3:
          sMethodResetters.add(runnable);
          break;
        case 4:
          sMethodResetters.add(runnable);
          break;
      }
    }
  }

  private static void flushResetters(LinkedHashSet<Runnable> activeSet) {
    if (sIsFlushing) {
      throw new AssertionError("Re-entrancy detected in ResettersForTesting");
    }
    ArrayList<Runnable> resetters = new ArrayList<>(activeSet);
    activeSet.clear();
    Collections.reverse(resetters);
    sIsFlushing = true;
    try {
      Iterator<Runnable> it = resetters.iterator();
      while (it.hasNext()) {
        Runnable resetter = it.next();
        resetter.run();
      }
    } finally {
      sIsFlushing = false;
    }
  }

  public static void beforeClassHooksWillExecute() {
    synchronized (sLock) {
      if (sState != 1) {
        throw new AssertionError("Invalid state transition from state " + sState);
      } else {
        sState = 2;
        flushResetters(sClassResetters);
      }
    }
  }

  public static void beforeHooksWillExecute() {
    synchronized (sLock) {
      int i = sState;
      if (i != 2 && i != 3) {
        throw new AssertionError("Invalid state transition from state " + sState);
      }
      sState = 4;
      flushResetters(sMethodResetters);
    }
  }

  public static void afterHooksDidExecute() {
    synchronized (sLock) {
      if (sState != 4) {
        throw new AssertionError("Invalid state transition from state " + sState);
      } else {
        sState = 3;
        flushResetters(sMethodResetters);
      }
    }
  }

  public static void afterClassHooksDidExecute() {
    synchronized (sLock) {
      int i = sState;
      if (i != 2 && i != 3) {
        throw new AssertionError("Invalid state transition from state " + sState);
      }
      sState = 1;
      flushResetters(sMethodResetters);
      flushResetters(sClassResetters);
    }
  }

  public static void enable() {
    if (!BuildConfig.IS_FOR_TEST) {
      throw new AssertionError();
    }
    synchronized (sLock) {
      if (sState != 0) {
        throw new AssertionError();
      }
      sState = 1;
      sMethodResetters = new LinkedHashSet<>();
      sClassResetters = new LinkedHashSet<>();
    }
  }
}
