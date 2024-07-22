package org.chromium.midi;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class MidiInputPortAndroidJni implements MidiInputPortAndroid.Natives {

  public static final JniStaticTestMocker<MidiInputPortAndroid.Natives> TEST_HOOKS =
      new JniStaticTestMocker<MidiInputPortAndroid.Natives>() {
        @Override
        public void setInstanceForTesting(MidiInputPortAndroid.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          MidiInputPortAndroidJni.testInstance = instance;
        }
      };
  private static MidiInputPortAndroid.Natives testInstance;

  MidiInputPortAndroidJni() {}

  @Override
  public void onData(
      long nativeMidiInputPortAndroid, byte[] bs, int offset, int count, long timestamp) {
    if (nativeMidiInputPortAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_midi_MidiInputPortAndroid_onData(
        nativeMidiInputPortAndroid, bs, offset, count, timestamp);
  }

  public static MidiInputPortAndroid.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      MidiInputPortAndroid.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of MidiInputPortAndroid.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new MidiInputPortAndroidJni();
  }
}
