package org.chromium.media;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class MediaCodecBridgeJni implements MediaCodecBridge.Natives {

  public static final JniStaticTestMocker<MediaCodecBridge.Natives> TEST_HOOKS =
      new JniStaticTestMocker<MediaCodecBridge.Natives>() {
        @Override
        public void setInstanceForTesting(MediaCodecBridge.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          MediaCodecBridgeJni.testInstance = instance;
        }
      };
  private static MediaCodecBridge.Natives testInstance;

  MediaCodecBridgeJni() {}

  @Override
  public void onBuffersAvailable(long nativeMediaCodecBridge, MediaCodecBridge caller) {
    if (nativeMediaCodecBridge == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_media_MediaCodecBridge_onBuffersAvailable(nativeMediaCodecBridge, caller);
  }

  public static MediaCodecBridge.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      MediaCodecBridge.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of MediaCodecBridge.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new MediaCodecBridgeJni();
  }
}
