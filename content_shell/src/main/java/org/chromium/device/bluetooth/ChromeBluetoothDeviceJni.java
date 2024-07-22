package org.chromium.device.bluetooth;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class ChromeBluetoothDeviceJni implements ChromeBluetoothDevice.Natives {

  public static final JniStaticTestMocker<ChromeBluetoothDevice.Natives> TEST_HOOKS =
      new JniStaticTestMocker<ChromeBluetoothDevice.Natives>() {
        @Override
        public void setInstanceForTesting(ChromeBluetoothDevice.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          ChromeBluetoothDeviceJni.testInstance = instance;
        }
      };
  private static ChromeBluetoothDevice.Natives testInstance;

  ChromeBluetoothDeviceJni() {}

  @Override
  public void createGattRemoteService(
      long nativeBluetoothDeviceAndroid,
      ChromeBluetoothDevice caller,
      String instanceId,
      Wrappers.BluetoothGattServiceWrapper serviceWrapper) {
    if (nativeBluetoothDeviceAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_device_bluetooth_ChromeBluetoothDevice_createGattRemoteService(
        nativeBluetoothDeviceAndroid, caller, instanceId, serviceWrapper);
  }

  @Override
  public void onConnectionStateChange(
      long nativeBluetoothDeviceAndroid,
      ChromeBluetoothDevice caller,
      int status,
      boolean connected) {
    if (nativeBluetoothDeviceAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_device_bluetooth_ChromeBluetoothDevice_onConnectionStateChange(
        nativeBluetoothDeviceAndroid, caller, status, connected);
  }

  @Override
  public void onGattServicesDiscovered(
      long nativeBluetoothDeviceAndroid, ChromeBluetoothDevice caller) {
    if (nativeBluetoothDeviceAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_device_bluetooth_ChromeBluetoothDevice_onGattServicesDiscovered(
        nativeBluetoothDeviceAndroid, caller);
  }

  public static ChromeBluetoothDevice.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      ChromeBluetoothDevice.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of ChromeBluetoothDevice.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new ChromeBluetoothDeviceJni();
  }
}
