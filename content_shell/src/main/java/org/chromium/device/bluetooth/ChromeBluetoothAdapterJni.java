package org.chromium.device.bluetooth;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class ChromeBluetoothAdapterJni implements ChromeBluetoothAdapter.Natives {

  public static final JniStaticTestMocker<ChromeBluetoothAdapter.Natives> TEST_HOOKS =
      new JniStaticTestMocker<ChromeBluetoothAdapter.Natives>() {
        @Override
        public void setInstanceForTesting(ChromeBluetoothAdapter.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          ChromeBluetoothAdapterJni.testInstance = instance;
        }
      };
  private static ChromeBluetoothAdapter.Natives testInstance;

  ChromeBluetoothAdapterJni() {}

  @Override
  public void createOrUpdateDeviceOnScan(
      long nativeBluetoothAdapterAndroid,
      ChromeBluetoothAdapter caller,
      String address,
      Wrappers.BluetoothDeviceWrapper deviceWrapper,
      String localName,
      int rssi,
      String[] advertisedUuids,
      int txPower,
      String[] serviceDataKeys,
      Object[] serviceDataValues,
      int[] manufacturerDataKeys,
      Object[] manufacturerDataValues,
      int advertiseFlags) {
    if (nativeBluetoothAdapterAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_device_bluetooth_ChromeBluetoothAdapter_createOrUpdateDeviceOnScan(
        nativeBluetoothAdapterAndroid,
        caller,
        address,
        deviceWrapper,
        localName,
        rssi,
        advertisedUuids,
        txPower,
        serviceDataKeys,
        serviceDataValues,
        manufacturerDataKeys,
        manufacturerDataValues,
        advertiseFlags);
  }

  @Override
  public void onAdapterStateChanged(
      long nativeBluetoothAdapterAndroid, ChromeBluetoothAdapter caller, boolean powered) {
    if (nativeBluetoothAdapterAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_device_bluetooth_ChromeBluetoothAdapter_onAdapterStateChanged(
        nativeBluetoothAdapterAndroid, caller, powered);
  }

  @Override
  public void onScanFailed(long nativeBluetoothAdapterAndroid, ChromeBluetoothAdapter caller) {
    if (nativeBluetoothAdapterAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_device_bluetooth_ChromeBluetoothAdapter_onScanFailed(
        nativeBluetoothAdapterAndroid, caller);
  }

  public static ChromeBluetoothAdapter.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      ChromeBluetoothAdapter.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of ChromeBluetoothAdapter.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new ChromeBluetoothAdapterJni();
  }
}
