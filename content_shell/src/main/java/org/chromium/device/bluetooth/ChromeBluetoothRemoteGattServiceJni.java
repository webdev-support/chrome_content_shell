package org.chromium.device.bluetooth;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class ChromeBluetoothRemoteGattServiceJni
    implements ChromeBluetoothRemoteGattService.Natives {

  public static final JniStaticTestMocker<ChromeBluetoothRemoteGattService.Natives> TEST_HOOKS =
      new JniStaticTestMocker<ChromeBluetoothRemoteGattService.Natives>() {
        @Override
        public void setInstanceForTesting(ChromeBluetoothRemoteGattService.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          ChromeBluetoothRemoteGattServiceJni.testInstance = instance;
        }
      };
  private static ChromeBluetoothRemoteGattService.Natives testInstance;

  ChromeBluetoothRemoteGattServiceJni() {}

  @Override
  public void createGattRemoteCharacteristic(
      long nativeBluetoothRemoteGattServiceAndroid,
      ChromeBluetoothRemoteGattService caller,
      String instanceId,
      Wrappers.BluetoothGattCharacteristicWrapper characteristicWrapper,
      ChromeBluetoothDevice chromeBluetoothDevice) {
    if (nativeBluetoothRemoteGattServiceAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI
        .org_chromium_device_bluetooth_ChromeBluetoothRemoteGattService_createGattRemoteCharacteristic(
            nativeBluetoothRemoteGattServiceAndroid,
            caller,
            instanceId,
            characteristicWrapper,
            chromeBluetoothDevice);
  }

  public static ChromeBluetoothRemoteGattService.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      ChromeBluetoothRemoteGattService.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of ChromeBluetoothRemoteGattService.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new ChromeBluetoothRemoteGattServiceJni();
  }
}
