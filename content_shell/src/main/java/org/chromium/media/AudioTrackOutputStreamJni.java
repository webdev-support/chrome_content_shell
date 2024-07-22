package org.chromium.media;

import java.nio.ByteBuffer;
import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class AudioTrackOutputStreamJni implements AudioTrackOutputStream.Natives {

  public static final JniStaticTestMocker<AudioTrackOutputStream.Natives> TEST_HOOKS =
      new JniStaticTestMocker<AudioTrackOutputStream.Natives>() {
        @Override
        public void setInstanceForTesting(AudioTrackOutputStream.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          AudioTrackOutputStreamJni.testInstance = instance;
        }
      };
  private static AudioTrackOutputStream.Natives testInstance;

  AudioTrackOutputStreamJni() {}

  @Override
  public long getAddress(
      long nativeAudioTrackOutputStream, AudioTrackOutputStream caller, ByteBuffer byteBuffer) {
    if (nativeAudioTrackOutputStream == 0) {
      throw new AssertionError();
    }
    return GEN_JNI.org_chromium_media_AudioTrackOutputStream_getAddress(
        nativeAudioTrackOutputStream, caller, byteBuffer);
  }

  @Override
  public void onError(long nativeAudioTrackOutputStream, AudioTrackOutputStream caller) {
    if (nativeAudioTrackOutputStream == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_media_AudioTrackOutputStream_onError(nativeAudioTrackOutputStream, caller);
  }

  @Override
  public AudioTrackOutputStream.AudioBufferInfo onMoreData(
      long nativeAudioTrackOutputStream,
      AudioTrackOutputStream caller,
      ByteBuffer audioData,
      long delayInFrames) {
    if (nativeAudioTrackOutputStream == 0) {
      throw new AssertionError();
    }
    return (AudioTrackOutputStream.AudioBufferInfo)
        GEN_JNI.org_chromium_media_AudioTrackOutputStream_onMoreData(
            nativeAudioTrackOutputStream, caller, audioData, delayInFrames);
  }

  public static AudioTrackOutputStream.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      AudioTrackOutputStream.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of AudioTrackOutputStream.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new AudioTrackOutputStreamJni();
  }
}
