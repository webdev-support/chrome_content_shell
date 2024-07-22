package org.chromium.content.browser;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class AudioFocusDelegateJni implements AudioFocusDelegate.Natives {

  public static final JniStaticTestMocker<AudioFocusDelegate.Natives> TEST_HOOKS =
      new JniStaticTestMocker<AudioFocusDelegate.Natives>() {
        @Override
        public void setInstanceForTesting(AudioFocusDelegate.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          AudioFocusDelegateJni.testInstance = instance;
        }
      };
  private static AudioFocusDelegate.Natives testInstance;

  AudioFocusDelegateJni() {}

  @Override
  public void onResume(long nativeAudioFocusDelegateAndroid, AudioFocusDelegate caller) {
    if (nativeAudioFocusDelegateAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_AudioFocusDelegate_onResume(
        nativeAudioFocusDelegateAndroid, caller);
  }

  @Override
  public void onStartDucking(long nativeAudioFocusDelegateAndroid, AudioFocusDelegate caller) {
    if (nativeAudioFocusDelegateAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_AudioFocusDelegate_onStartDucking(
        nativeAudioFocusDelegateAndroid, caller);
  }

  @Override
  public void onStopDucking(long nativeAudioFocusDelegateAndroid, AudioFocusDelegate caller) {
    if (nativeAudioFocusDelegateAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_AudioFocusDelegate_onStopDucking(
        nativeAudioFocusDelegateAndroid, caller);
  }

  @Override
  public void onSuspend(long nativeAudioFocusDelegateAndroid, AudioFocusDelegate caller) {
    if (nativeAudioFocusDelegateAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_AudioFocusDelegate_onSuspend(
        nativeAudioFocusDelegateAndroid, caller);
  }

  @Override
  public void recordSessionDuck(long nativeAudioFocusDelegateAndroid, AudioFocusDelegate caller) {
    if (nativeAudioFocusDelegateAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_AudioFocusDelegate_recordSessionDuck(
        nativeAudioFocusDelegateAndroid, caller);
  }

  public static AudioFocusDelegate.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      AudioFocusDelegate.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of AudioFocusDelegate.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new AudioFocusDelegateJni();
  }
}
