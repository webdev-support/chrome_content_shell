package org.chromium.base.memory;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.chromium.base.ContextUtils;
import org.chromium.base.ThreadUtils;
import org.chromium.base.metrics.RecordHistogram;

public class MemoryPressureUma implements ComponentCallbacks2 {

  private static MemoryPressureUma sInstance;
  private final String mHistogramName;

  @Retention(RetentionPolicy.SOURCE)
  private @interface Notification {
    public static final int NUM_ENTRIES = 9;
    public static final int ON_LOW_MEMORY = 8;
    public static final int TRIM_MEMORY_BACKGROUND = 3;
    public static final int TRIM_MEMORY_COMPLETE = 1;
    public static final int TRIM_MEMORY_MODERATE = 2;
    public static final int TRIM_MEMORY_RUNNING_CRITICAL = 5;
    public static final int TRIM_MEMORY_RUNNING_LOW = 6;
    public static final int TRIM_MEMORY_RUNNING_MODERATE = 7;
    public static final int TRIM_MEMORY_UI_HIDDEN = 4;
    public static final int UNKNOWN_TRIM_LEVEL = 0;
  }

  public static void initializeForBrowser() {
    initializeInstance("Browser");
  }

  public static void initializeForChildService() {
    initializeInstance("ChildService");
  }

  private static void initializeInstance(String processType) {
    ThreadUtils.assertOnUiThread();
    if (sInstance != null) {
      throw new AssertionError();
    }
    sInstance = new MemoryPressureUma(processType);
    ContextUtils.getApplicationContext().registerComponentCallbacks(sInstance);
  }

  private MemoryPressureUma(String processType) {
    this.mHistogramName = "Android.MemoryPressureNotification." + processType;
  }

  @Override
  public void onLowMemory() {
    record(8);
  }

  @Override
  public void onTrimMemory(int level) {
    switch (level) {
      case 5:
        record(7);
        return;
      case 10:
        record(6);
        return;
      case 15:
        record(5);
        return;
      case 20:
        record(4);
        return;
      case 40:
        record(3);
        return;
      case 60:
        record(2);
        return;
      case 80:
        record(1);
        return;
      default:
        record(0);
        return;
    }
  }

  @Override
  public void onConfigurationChanged(Configuration configuration) {}

  private void record(int notification) {
    RecordHistogram.recordEnumeratedHistogram(this.mHistogramName, notification, 9);
  }
}
