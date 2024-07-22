package org.chromium.device.bluetooth;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class ChromeBluetoothRemoteGattDescriptorJni
    implements ChromeBluetoothRemoteGattDescriptor.Natives {

  public static final JniStaticTestMocker<ChromeBluetoothRemoteGattDescriptor.Natives> TEST_HOOKS =
      new JniStaticTestMocker<ChromeBluetoothRemoteGattDescriptor.Natives>() {
        @Override
        public void setInstanceForTesting(ChromeBluetoothRemoteGattDescriptor.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          ChromeBluetoothRemoteGattDescriptorJni.testInstance = instance;
        }
      };
  private static ChromeBluetoothRemoteGattDescriptor.Natives testInstance;

  ChromeBluetoothRemoteGattDescriptorJni() {}

  @Override
  public void onRead(
      long nativeBluetoothRemoteGattDescriptorAndroid,
      ChromeBluetoothRemoteGattDescriptor caller,
      int status,
      byte[] value) {
    if (nativeBluetoothRemoteGattDescriptorAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_device_bluetooth_ChromeBluetoothRemoteGattDescriptor_onRead(
        nativeBluetoothRemoteGattDescriptorAndroid, caller, status, value);
  }

  @Override
  public void onWrite(
      long nativeBluetoothRemoteGattDescriptorAndroid,
      ChromeBluetoothRemoteGattDescriptor caller,
      int status) {
    if (nativeBluetoothRemoteGattDescriptorAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_device_bluetooth_ChromeBluetoothRemoteGattDescriptor_onWrite(
        nativeBluetoothRemoteGattDescriptorAndroid, caller, status);
  }

  public static ChromeBluetoothRemoteGattDescriptor.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      ChromeBluetoothRemoteGattDescriptor.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of ChromeBluetoothRemoteGattDescriptor.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new ChromeBluetoothRemoteGattDescriptorJni();
  }
}
