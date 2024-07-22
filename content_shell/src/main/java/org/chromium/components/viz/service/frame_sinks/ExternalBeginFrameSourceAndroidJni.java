package org.chromium.components.viz.service.frame_sinks;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class ExternalBeginFrameSourceAndroidJni implements ExternalBeginFrameSourceAndroid.Natives {

  public static final JniStaticTestMocker<ExternalBeginFrameSourceAndroid.Natives> TEST_HOOKS =
      new JniStaticTestMocker<ExternalBeginFrameSourceAndroid.Natives>() {
        @Override
        public void setInstanceForTesting(ExternalBeginFrameSourceAndroid.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          ExternalBeginFrameSourceAndroidJni.testInstance = instance;
        }
      };
  private static ExternalBeginFrameSourceAndroid.Natives testInstance;

  ExternalBeginFrameSourceAndroidJni() {}

  @Override
  public void onVSync(
      long nativeExternalBeginFrameSourceAndroid,
      ExternalBeginFrameSourceAndroid caller,
      long vsyncTimeMicros,
      long vsyncPeriodMicros) {
    if (nativeExternalBeginFrameSourceAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI
        .org_chromium_components_viz_service_frame_1sinks_ExternalBeginFrameSourceAndroid_onVSync(
            nativeExternalBeginFrameSourceAndroid, caller, vsyncTimeMicros, vsyncPeriodMicros);
  }

  public static ExternalBeginFrameSourceAndroid.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      ExternalBeginFrameSourceAndroid.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of ExternalBeginFrameSourceAndroid.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new ExternalBeginFrameSourceAndroidJni();
  }
}
