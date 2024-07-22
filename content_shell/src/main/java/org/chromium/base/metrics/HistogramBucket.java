package org.chromium.base.metrics;

public class HistogramBucket {
  public final int mCount;
  public final long mMax;
  public final int mMin;

  public HistogramBucket(int min, long max, int count) {
    this.mMin = min;
    this.mMax = max;
    this.mCount = count;
  }

  public boolean contains(int value) {
    return value >= this.mMin && ((long) value) < this.mMax;
  }
}
