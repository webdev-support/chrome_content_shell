package org.chromium.media;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class MediaPlayerListenerJni implements MediaPlayerListener.Natives {

  public static final JniStaticTestMocker<MediaPlayerListener.Natives> TEST_HOOKS =
      new JniStaticTestMocker<MediaPlayerListener.Natives>() {
        @Override
        public void setInstanceForTesting(MediaPlayerListener.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          MediaPlayerListenerJni.testInstance = instance;
        }
      };
  private static MediaPlayerListener.Natives testInstance;

  MediaPlayerListenerJni() {}

  @Override
  public void onMediaError(
      long nativeMediaPlayerListener, MediaPlayerListener caller, int errorType) {
    if (nativeMediaPlayerListener == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_media_MediaPlayerListener_onMediaError(
        nativeMediaPlayerListener, caller, errorType);
  }

  @Override
  public void onMediaPrepared(long nativeMediaPlayerListener, MediaPlayerListener caller) {
    if (nativeMediaPlayerListener == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_media_MediaPlayerListener_onMediaPrepared(
        nativeMediaPlayerListener, caller);
  }

  @Override
  public void onPlaybackComplete(long nativeMediaPlayerListener, MediaPlayerListener caller) {
    if (nativeMediaPlayerListener == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_media_MediaPlayerListener_onPlaybackComplete(
        nativeMediaPlayerListener, caller);
  }

  @Override
  public void onVideoSizeChanged(
      long nativeMediaPlayerListener, MediaPlayerListener caller, int width, int height) {
    if (nativeMediaPlayerListener == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_media_MediaPlayerListener_onVideoSizeChanged(
        nativeMediaPlayerListener, caller, width, height);
  }

  public static MediaPlayerListener.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      MediaPlayerListener.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of MediaPlayerListener.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new MediaPlayerListenerJni();
  }
}
