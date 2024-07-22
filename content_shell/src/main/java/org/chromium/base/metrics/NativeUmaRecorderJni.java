package org.chromium.base.metrics;

import org.chromium.base.Callback;
import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class NativeUmaRecorderJni implements NativeUmaRecorder.Natives {
  public static final JniStaticTestMocker<NativeUmaRecorder.Natives> TEST_HOOKS =
      new JniStaticTestMocker<NativeUmaRecorder.Natives>() {
        @Override
        public void setInstanceForTesting(NativeUmaRecorder.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          NativeUmaRecorderJni.testInstance = instance;
        }
      };
  private static NativeUmaRecorder.Natives testInstance;

  @Override
  public long addActionCallbackForTesting(Callback callback) {
    return GEN_JNI.org_chromium_base_metrics_NativeUmaRecorder_addActionCallbackForTesting(
        callback);
  }

  @Override
  public long createHistogramSnapshotForTesting() {
    return GEN_JNI.org_chromium_base_metrics_NativeUmaRecorder_createHistogramSnapshotForTesting();
  }

  @Override
  public void destroyHistogramSnapshotForTesting(long snapshotPtr) {
    GEN_JNI.org_chromium_base_metrics_NativeUmaRecorder_destroyHistogramSnapshotForTesting(
        snapshotPtr);
  }

  @Override
  public long[] getHistogramSamplesForTesting(String name) {
    return GEN_JNI.org_chromium_base_metrics_NativeUmaRecorder_getHistogramSamplesForTesting(name);
  }

  @Override
  public int getHistogramTotalCountForTesting(String name, long snapshotPtr) {
    return GEN_JNI.org_chromium_base_metrics_NativeUmaRecorder_getHistogramTotalCountForTesting(
        name, snapshotPtr);
  }

  @Override
  public int getHistogramValueCountForTesting(String name, int sample, long snapshotPtr) {
    return GEN_JNI.org_chromium_base_metrics_NativeUmaRecorder_getHistogramValueCountForTesting(
        name, sample, snapshotPtr);
  }

  @Override
  public long recordBooleanHistogram(String name, long nativeHint, boolean sample) {
    return GEN_JNI.org_chromium_base_metrics_NativeUmaRecorder_recordBooleanHistogram(
        name, nativeHint, sample);
  }

  @Override
  public long recordExponentialHistogram(
      String name, long nativeHint, int sample, int min, int max, int numBuckets) {
    return GEN_JNI.org_chromium_base_metrics_NativeUmaRecorder_recordExponentialHistogram(
        name, nativeHint, sample, min, max, numBuckets);
  }

  @Override
  public long recordLinearHistogram(
      String name, long nativeHint, int sample, int min, int max, int numBuckets) {
    return GEN_JNI.org_chromium_base_metrics_NativeUmaRecorder_recordLinearHistogram(
        name, nativeHint, sample, min, max, numBuckets);
  }

  @Override
  public long recordSparseHistogram(String name, long nativeHint, int sample) {
    return GEN_JNI.org_chromium_base_metrics_NativeUmaRecorder_recordSparseHistogram(
        name, nativeHint, sample);
  }

  @Override
  public void recordUserAction(String name, long millisSinceEvent) {
    GEN_JNI.org_chromium_base_metrics_NativeUmaRecorder_recordUserAction(name, millisSinceEvent);
  }

  @Override
  public void removeActionCallbackForTesting(long callbackId) {
    GEN_JNI.org_chromium_base_metrics_NativeUmaRecorder_removeActionCallbackForTesting(callbackId);
  }

  public static NativeUmaRecorder.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      NativeUmaRecorder.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of NativeUmaRecorder.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new NativeUmaRecorderJni();
  }
}
