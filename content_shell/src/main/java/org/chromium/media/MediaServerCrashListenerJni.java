package org.chromium.media;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class MediaServerCrashListenerJni implements MediaServerCrashListener.Natives {

  public static final JniStaticTestMocker<MediaServerCrashListener.Natives> TEST_HOOKS =
      new JniStaticTestMocker<MediaServerCrashListener.Natives>() {
        @Override
        public void setInstanceForTesting(MediaServerCrashListener.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          MediaServerCrashListenerJni.testInstance = instance;
        }
      };
  private static MediaServerCrashListener.Natives testInstance;

  MediaServerCrashListenerJni() {}

  @Override
  public void onMediaServerCrashDetected(
      long nativeMediaServerCrashListener,
      MediaServerCrashListener caller,
      boolean watchdogNeedsRelease) {
    if (nativeMediaServerCrashListener == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_media_MediaServerCrashListener_onMediaServerCrashDetected(
        nativeMediaServerCrashListener, caller, watchdogNeedsRelease);
  }

  public static MediaServerCrashListener.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      MediaServerCrashListener.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of MediaServerCrashListener.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new MediaServerCrashListenerJni();
  }
}
