package org.chromium.base.metrics;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.chromium.base.TimeUtils;

public class TimingMetric implements AutoCloseable {
  private final String mMetricName;
  private long mStartTime;
  private final int mTimerType;

  @Retention(RetentionPolicy.SOURCE)
  private @interface TimerType {
    public static final int MEDIUM_UPTIME = 1;
    public static final int SHORT_THREAD_TIME = 2;
    public static final int SHORT_UPTIME = 0;
  }

  public static TimingMetric shortUptime(String metricName) {
    TimingMetric ret = new TimingMetric(metricName, 0);
    ret.mStartTime = TimeUtils.uptimeMillis();
    return ret;
  }

  public static TimingMetric mediumUptime(String metricName) {
    TimingMetric ret = new TimingMetric(metricName, 1);
    ret.mStartTime = TimeUtils.uptimeMillis();
    return ret;
  }

  public static TimingMetric shortThreadTime(String metricName) {
    TimingMetric ret = new TimingMetric(metricName, 2);
    ret.mStartTime = TimeUtils.currentThreadTimeMillis();
    return ret;
  }

  private TimingMetric(String metricName, int timerType) {
    this.mMetricName = metricName;
    this.mTimerType = timerType;
  }

  @Override   public void close() {
    String metricName = this.mMetricName;
    long startTime = this.mStartTime;
    if (startTime == 0) {
      return;
    }
    this.mStartTime = 0L;
    switch (this.mTimerType) {
      case 0:
        RecordHistogram.recordTimesHistogram(metricName, TimeUtils.uptimeMillis() - startTime);
        return;
      case 1:
        RecordHistogram.recordMediumTimesHistogram(
            metricName, TimeUtils.uptimeMillis() - startTime);
        return;
      case 2:
        RecordHistogram.recordTimesHistogram(
            metricName, TimeUtils.currentThreadTimeMillis() - startTime);
        return;
      default:
        return;
    }
  }
}
