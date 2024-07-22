package org.chromium.midi;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class MidiManagerAndroidJni implements MidiManagerAndroid.Natives {

  public static final JniStaticTestMocker<MidiManagerAndroid.Natives> TEST_HOOKS =
      new JniStaticTestMocker<MidiManagerAndroid.Natives>() {
        @Override
        public void setInstanceForTesting(MidiManagerAndroid.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          MidiManagerAndroidJni.testInstance = instance;
        }
      };
  private static MidiManagerAndroid.Natives testInstance;

  MidiManagerAndroidJni() {}

  @Override
  public void onAttached(long nativeMidiManagerAndroid, MidiDeviceAndroid device) {
    if (nativeMidiManagerAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_midi_MidiManagerAndroid_onAttached(nativeMidiManagerAndroid, device);
  }

  @Override
  public void onDetached(long nativeMidiManagerAndroid, MidiDeviceAndroid device) {
    if (nativeMidiManagerAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_midi_MidiManagerAndroid_onDetached(nativeMidiManagerAndroid, device);
  }

  @Override
  public void onInitializationFailed(long nativeMidiManagerAndroid) {
    if (nativeMidiManagerAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_midi_MidiManagerAndroid_onInitializationFailed(nativeMidiManagerAndroid);
  }

  @Override
  public void onInitialized(long nativeMidiManagerAndroid, MidiDeviceAndroid[] devices) {
    if (nativeMidiManagerAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_midi_MidiManagerAndroid_onInitialized(nativeMidiManagerAndroid, devices);
  }

  public static MidiManagerAndroid.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      MidiManagerAndroid.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of MidiManagerAndroid.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new MidiManagerAndroidJni();
  }
}
