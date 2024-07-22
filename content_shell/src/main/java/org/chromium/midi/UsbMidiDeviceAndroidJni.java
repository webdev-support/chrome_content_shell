package org.chromium.midi;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class UsbMidiDeviceAndroidJni implements UsbMidiDeviceAndroid.Natives {

  public static final JniStaticTestMocker<UsbMidiDeviceAndroid.Natives> TEST_HOOKS =
      new JniStaticTestMocker<UsbMidiDeviceAndroid.Natives>() {
        @Override
        public void setInstanceForTesting(UsbMidiDeviceAndroid.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          UsbMidiDeviceAndroidJni.testInstance = instance;
        }
      };
  private static UsbMidiDeviceAndroid.Natives testInstance;

  UsbMidiDeviceAndroidJni() {}

  @Override
  public void onData(long nativeUsbMidiDeviceAndroid, int endpointNumber, byte[] data) {
    if (nativeUsbMidiDeviceAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_midi_UsbMidiDeviceAndroid_onData(
        nativeUsbMidiDeviceAndroid, endpointNumber, data);
  }

  public static UsbMidiDeviceAndroid.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      UsbMidiDeviceAndroid.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of UsbMidiDeviceAndroid.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new UsbMidiDeviceAndroidJni();
  }
}
