package org.chromium.media;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class MediaPlayerBridgeJni implements MediaPlayerBridge.Natives {

  public static final JniStaticTestMocker<MediaPlayerBridge.Natives> TEST_HOOKS =
      new JniStaticTestMocker<MediaPlayerBridge.Natives>() {
        @Override
        public void setInstanceForTesting(MediaPlayerBridge.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          MediaPlayerBridgeJni.testInstance = instance;
        }
      };
  private static MediaPlayerBridge.Natives testInstance;

  MediaPlayerBridgeJni() {}

  @Override
  public void onDidSetDataUriDataSource(
      long nativeMediaPlayerBridge, MediaPlayerBridge caller, boolean success) {
    if (nativeMediaPlayerBridge == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_media_MediaPlayerBridge_onDidSetDataUriDataSource(
        nativeMediaPlayerBridge, caller, success);
  }

  public static MediaPlayerBridge.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      MediaPlayerBridge.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of MediaPlayerBridge.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new MediaPlayerBridgeJni();
  }
}
