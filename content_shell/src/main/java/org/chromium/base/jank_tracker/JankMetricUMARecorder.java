package org.chromium.base.jank_tracker;

import org.jni_zero.JNINamespace;

@JNINamespace("base::android")
public class JankMetricUMARecorder {

  public interface Natives {
    void recordJankMetrics(long[] jArr, int[] iArr, long j, long j2, int i);
  }

  public static void recordJankMetricsToUMA(
      JankMetrics metric,
      long reportingIntervalStartTime,
      long reportingIntervalDuration,
      int scenario) {
    if (metric == null) {
      return;
    }
    JankMetricUMARecorderJni.get()
        .recordJankMetrics(
            metric.durationsNs,
            metric.missedVsyncs,
            reportingIntervalStartTime,
            reportingIntervalDuration,
            scenario);
  }
}
