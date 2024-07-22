package org.chromium.device.bluetooth;

import java.util.List;
import org.chromium.base.Log;
import org.chromium.components.crash.PureJavaExceptionReporter;
import org.jni_zero.JNINamespace;

@JNINamespace(PureJavaExceptionReporter.DEVICE)
final class ChromeBluetoothRemoteGattService {
  private static final String TAG = "Bluetooth";
  ChromeBluetoothDevice mChromeDevice;
  final String mInstanceId;
  private long mNativeBluetoothRemoteGattServiceAndroid;
  final Wrappers.BluetoothGattServiceWrapper mService;

  public interface Natives {
    void createGattRemoteCharacteristic(
        long j,
        ChromeBluetoothRemoteGattService chromeBluetoothRemoteGattService,
        String str,
        Wrappers.BluetoothGattCharacteristicWrapper bluetoothGattCharacteristicWrapper,
        ChromeBluetoothDevice chromeBluetoothDevice);
  }

  private ChromeBluetoothRemoteGattService(
      long nativeBluetoothRemoteGattServiceAndroid,
      Wrappers.BluetoothGattServiceWrapper serviceWrapper,
      String instanceId,
      ChromeBluetoothDevice chromeDevice) {
    this.mNativeBluetoothRemoteGattServiceAndroid = nativeBluetoothRemoteGattServiceAndroid;
    this.mService = serviceWrapper;
    this.mInstanceId = instanceId;
    this.mChromeDevice = chromeDevice;
    Log.v(TAG, "ChromeBluetoothRemoteGattService created.", new Object[0]);
  }

  private void onBluetoothRemoteGattServiceAndroidDestruction() {
    this.mNativeBluetoothRemoteGattServiceAndroid = 0L;
  }

  private static ChromeBluetoothRemoteGattService create(
      long nativeBluetoothRemoteGattServiceAndroid,
      Wrappers.BluetoothGattServiceWrapper serviceWrapper,
      String instanceId,
      ChromeBluetoothDevice chromeDevice) {
    return new ChromeBluetoothRemoteGattService(
        nativeBluetoothRemoteGattServiceAndroid, serviceWrapper, instanceId, chromeDevice);
  }

  private String getUUID() {
    return this.mService.getUuid().toString();
  }

  private void createCharacteristics() {
    List<Wrappers.BluetoothGattCharacteristicWrapper> characteristics =
        this.mService.getCharacteristics();
    for (Wrappers.BluetoothGattCharacteristicWrapper characteristic : characteristics) {
      String characteristicInstanceId =
          this.mInstanceId
              + "/"
              + characteristic.getUuid().toString()
              + ","
              + characteristic.getInstanceId();
      ChromeBluetoothRemoteGattServiceJni.get()
          .createGattRemoteCharacteristic(
              this.mNativeBluetoothRemoteGattServiceAndroid,
              this,
              characteristicInstanceId,
              characteristic,
              this.mChromeDevice);
    }
  }
}
