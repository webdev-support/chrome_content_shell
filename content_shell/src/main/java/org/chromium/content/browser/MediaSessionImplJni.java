package org.chromium.content.browser;

import org.chromium.content_public.browser.WebContents;
import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class MediaSessionImplJni implements MediaSessionImpl.Natives {

  public static final JniStaticTestMocker<MediaSessionImpl.Natives> TEST_HOOKS =
      new JniStaticTestMocker<MediaSessionImpl.Natives>() {
        @Override
        public void setInstanceForTesting(MediaSessionImpl.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          MediaSessionImplJni.testInstance = instance;
        }
      };
  private static MediaSessionImpl.Natives testInstance;

  MediaSessionImplJni() {}

  @Override
  public void didReceiveAction(
      long nativeMediaSessionAndroid, MediaSessionImpl caller, int action) {
    if (nativeMediaSessionAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_MediaSessionImpl_didReceiveAction(
        nativeMediaSessionAndroid, caller, action);
  }

  @Override
  public MediaSessionImpl getMediaSessionFromWebContents(WebContents contents) {
    return (MediaSessionImpl)
        GEN_JNI.org_chromium_content_browser_MediaSessionImpl_getMediaSessionFromWebContents(
            contents);
  }

  @Override
  public void requestSystemAudioFocus(long nativeMediaSessionAndroid, MediaSessionImpl caller) {
    if (nativeMediaSessionAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_MediaSessionImpl_requestSystemAudioFocus(
        nativeMediaSessionAndroid, caller);
  }

  @Override
  public void resume(long nativeMediaSessionAndroid, MediaSessionImpl caller) {
    if (nativeMediaSessionAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_MediaSessionImpl_resume(nativeMediaSessionAndroid, caller);
  }

  @Override
  public void seek(long nativeMediaSessionAndroid, MediaSessionImpl caller, long millis) {
    if (nativeMediaSessionAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_MediaSessionImpl_seek(
        nativeMediaSessionAndroid, caller, millis);
  }

  @Override
  public void seekTo(long nativeMediaSessionAndroid, MediaSessionImpl caller, long millis) {
    if (nativeMediaSessionAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_MediaSessionImpl_seekTo(
        nativeMediaSessionAndroid, caller, millis);
  }

  @Override
  public void stop(long nativeMediaSessionAndroid, MediaSessionImpl caller) {
    if (nativeMediaSessionAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_MediaSessionImpl_stop(nativeMediaSessionAndroid, caller);
  }

  @Override
  public void suspend(long nativeMediaSessionAndroid, MediaSessionImpl caller) {
    if (nativeMediaSessionAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_MediaSessionImpl_suspend(
        nativeMediaSessionAndroid, caller);
  }

  public static MediaSessionImpl.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      MediaSessionImpl.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of MediaSessionImpl.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new MediaSessionImplJni();
  }
}
