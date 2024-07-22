package org.chromium.device.bluetooth;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class ChromeBluetoothRemoteGattCharacteristicJni
    implements ChromeBluetoothRemoteGattCharacteristic.Natives {

  public static final JniStaticTestMocker<ChromeBluetoothRemoteGattCharacteristic.Natives>
      TEST_HOOKS =
          new JniStaticTestMocker<ChromeBluetoothRemoteGattCharacteristic.Natives>() {
            @Override
            public void setInstanceForTesting(
                ChromeBluetoothRemoteGattCharacteristic.Natives instance) {
              if (!GEN_JNI.TESTING_ENABLED) {
                throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
              }
              ChromeBluetoothRemoteGattCharacteristicJni.testInstance = instance;
            }
          };
  private static ChromeBluetoothRemoteGattCharacteristic.Natives testInstance;

  ChromeBluetoothRemoteGattCharacteristicJni() {}

  @Override
  public void createGattRemoteDescriptor(
      long nativeBluetoothRemoteGattCharacteristicAndroid,
      ChromeBluetoothRemoteGattCharacteristic caller,
      String instanceId,
      Wrappers.BluetoothGattDescriptorWrapper descriptorWrapper,
      ChromeBluetoothDevice chromeBluetoothDevice) {
    if (nativeBluetoothRemoteGattCharacteristicAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI
        .org_chromium_device_bluetooth_ChromeBluetoothRemoteGattCharacteristic_createGattRemoteDescriptor(
            nativeBluetoothRemoteGattCharacteristicAndroid,
            caller,
            instanceId,
            descriptorWrapper,
            chromeBluetoothDevice);
  }

  @Override
  public void onChanged(
      long nativeBluetoothRemoteGattCharacteristicAndroid,
      ChromeBluetoothRemoteGattCharacteristic caller,
      byte[] value) {
    if (nativeBluetoothRemoteGattCharacteristicAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_device_bluetooth_ChromeBluetoothRemoteGattCharacteristic_onChanged(
        nativeBluetoothRemoteGattCharacteristicAndroid, caller, value);
  }

  @Override
  public void onRead(
      long nativeBluetoothRemoteGattCharacteristicAndroid,
      ChromeBluetoothRemoteGattCharacteristic caller,
      int status,
      byte[] value) {
    if (nativeBluetoothRemoteGattCharacteristicAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_device_bluetooth_ChromeBluetoothRemoteGattCharacteristic_onRead(
        nativeBluetoothRemoteGattCharacteristicAndroid, caller, status, value);
  }

  @Override
  public void onWrite(
      long nativeBluetoothRemoteGattCharacteristicAndroid,
      ChromeBluetoothRemoteGattCharacteristic caller,
      int status) {
    if (nativeBluetoothRemoteGattCharacteristicAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_device_bluetooth_ChromeBluetoothRemoteGattCharacteristic_onWrite(
        nativeBluetoothRemoteGattCharacteristicAndroid, caller, status);
  }

  public static ChromeBluetoothRemoteGattCharacteristic.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      ChromeBluetoothRemoteGattCharacteristic.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of ChromeBluetoothRemoteGattCharacteristic.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new ChromeBluetoothRemoteGattCharacteristicJni();
  }
}
