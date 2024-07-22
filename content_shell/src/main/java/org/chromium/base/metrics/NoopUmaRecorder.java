package org.chromium.base.metrics;

import java.util.Collections;
import java.util.List;
import org.chromium.base.Callback;

class NoopUmaRecorder implements UmaRecorder {
  NoopUmaRecorder() {}

  @Override
  public void recordBooleanHistogram(String name, boolean sample) {}

  @Override
  public void recordExponentialHistogram(
      String name, int sample, int min, int max, int numBuckets) {}

  @Override
  public void recordLinearHistogram(String name, int sample, int min, int max, int numBuckets) {}

  @Override
  public void recordSparseHistogram(String name, int sample) {}

  @Override
  public void recordUserAction(String name, long elapsedRealtimeMillis) {}

  @Override
  public int getHistogramValueCountForTesting(String name, int sample) {
    return 0;
  }

  @Override
  public int getHistogramTotalCountForTesting(String name) {
    return 0;
  }

  @Override
  public List<HistogramBucket> getHistogramSamplesForTesting(String name) {
    return Collections.emptyList();
  }

  @Override
  public void addUserActionCallbackForTesting(Callback<String> callback) {}

  @Override
  public void removeUserActionCallbackForTesting(Callback<String> callback) {}
}
