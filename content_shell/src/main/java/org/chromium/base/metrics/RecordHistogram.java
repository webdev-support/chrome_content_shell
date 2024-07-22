package org.chromium.base.metrics;

import java.util.List;
import kotlin.time.DurationKt;
import org.chromium.blink.mojom.WebFeature;

public class RecordHistogram {
  public static void recordBooleanHistogram(String name, boolean sample) {
    UmaRecorderHolder.get().recordBooleanHistogram(name, sample);
  }

  public static void recordEnumeratedHistogram(String name, int sample, int max) {
    recordExactLinearHistogram(name, sample, max);
  }

  public static void recordCount1MHistogram(String name, int sample) {
    UmaRecorderHolder.get()
        .recordExponentialHistogram(name, sample, 1, DurationKt.NANOS_IN_MILLIS, 50);
  }

  public static void recordCount100Histogram(String name, int sample) {
    UmaRecorderHolder.get().recordExponentialHistogram(name, sample, 1, 100, 50);
  }

  public static void recordCount1000Histogram(String name, int sample) {
    UmaRecorderHolder.get().recordExponentialHistogram(name, sample, 1, 1000, 50);
  }

  public static void recordCount100000Histogram(String name, int sample) {
    UmaRecorderHolder.get().recordExponentialHistogram(name, sample, 1, 100000, 50);
  }

  public static void recordCustomCountHistogram(
      String name, int sample, int min, int max, int numBuckets) {
    UmaRecorderHolder.get().recordExponentialHistogram(name, sample, min, max, numBuckets);
  }

  public static void recordLinearCountHistogram(
      String name, int sample, int min, int max, int numBuckets) {
    UmaRecorderHolder.get().recordLinearHistogram(name, sample, min, max, numBuckets);
  }

  public static void recordPercentageHistogram(String name, int sample) {
    recordExactLinearHistogram(name, sample, 101);
  }

  public static void recordSparseHistogram(String name, int sample) {
    UmaRecorderHolder.get().recordSparseHistogram(name, sample);
  }

  public static void recordTimesHistogram(String name, long durationMs) {
    recordCustomTimesHistogramMilliseconds(name, durationMs, 1L, 10000L, 50);
  }

  public static void recordMediumTimesHistogram(String name, long durationMs) {
    recordCustomTimesHistogramMilliseconds(name, durationMs, 10L, 180000L, 50);
  }

  public static void recordLongTimesHistogram(String name, long durationMs) {
    recordCustomTimesHistogramMilliseconds(name, durationMs, 1L, 3600000L, 50);
  }

  public static void recordLongTimesHistogram100(String name, long durationMs) {
    recordCustomTimesHistogramMilliseconds(name, durationMs, 1L, 3600000L, 100);
  }

  public static void recordCustomTimesHistogram(
      String name, long durationMs, long min, long max, int numBuckets) {
    recordCustomTimesHistogramMilliseconds(name, durationMs, min, max, numBuckets);
  }

  public static void recordMemoryKBHistogram(String name, int sizeInKB) {
    UmaRecorderHolder.get().recordExponentialHistogram(name, sizeInKB, 1000, 500000, 50);
  }

  public static void recordMemoryMediumMBHistogram(String name, int sizeInMB) {
    UmaRecorderHolder.get()
        .recordExponentialHistogram(
            name, sizeInMB, 1, WebFeature.CANVAS_RENDERING_CONTEXT2_D_RESET, 100);
  }

  public static void recordExactLinearHistogram(String name, int sample, int max) {
    int numBuckets = max + 1;
    UmaRecorderHolder.get().recordLinearHistogram(name, sample, 1, max, numBuckets);
  }

  private static int clampToInt(long value) {
    if (value > 2147483647L) {
      return Integer.MAX_VALUE;
    }
    if (value < -2147483648L) {
      return Integer.MIN_VALUE;
    }
    return (int) value;
  }

  private static void recordCustomTimesHistogramMilliseconds(
      String name, long duration, long min, long max, int numBuckets) {
    UmaRecorderHolder.get()
        .recordExponentialHistogram(
            name, clampToInt(duration), clampToInt(min), clampToInt(max), numBuckets);
  }

  @Deprecated
  public static int getHistogramValueCountForTesting(String name, int sample) {
    return UmaRecorderHolder.get().getHistogramValueCountForTesting(name, sample);
  }

  @Deprecated
  public static int getHistogramTotalCountForTesting(String name) {
    return UmaRecorderHolder.get().getHistogramTotalCountForTesting(name);
  }

  public static List<HistogramBucket> getHistogramSamplesForTesting(String name) {
    return UmaRecorderHolder.get().getHistogramSamplesForTesting(name);
  }
}
