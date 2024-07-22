package org.chromium.base.jank_tracker;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class JankMetricUMARecorderJni implements JankMetricUMARecorder.Natives {
  public static final JniStaticTestMocker<JankMetricUMARecorder.Natives> TEST_HOOKS =
      new JniStaticTestMocker<JankMetricUMARecorder.Natives>() {
        @Override
        public void setInstanceForTesting(JankMetricUMARecorder.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          JankMetricUMARecorderJni.testInstance = instance;
        }
      };
  private static JankMetricUMARecorder.Natives testInstance;

  @Override
  public void recordJankMetrics(
      long[] durationsNs,
      int[] missedVsyncs,
      long reportingIntervalStartTime,
      long reportingIntervalDuration,
      int scenario) {
    GEN_JNI.org_chromium_base_jank_1tracker_JankMetricUMARecorder_recordJankMetrics(
        durationsNs, missedVsyncs, reportingIntervalStartTime, reportingIntervalDuration, scenario);
  }

  public static JankMetricUMARecorder.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      JankMetricUMARecorder.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of JankMetricUMARecorder.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new JankMetricUMARecorderJni();
  }
}
