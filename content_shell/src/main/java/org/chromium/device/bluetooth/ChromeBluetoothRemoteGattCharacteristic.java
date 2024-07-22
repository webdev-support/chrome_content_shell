package org.chromium.device.bluetooth;

import java.util.List;
import org.chromium.base.Log;
import org.chromium.components.crash.PureJavaExceptionReporter;
import org.jni_zero.JNINamespace;

@JNINamespace(PureJavaExceptionReporter.DEVICE)
public final class ChromeBluetoothRemoteGattCharacteristic {
  private static final String TAG = "Bluetooth";
  final Wrappers.BluetoothGattCharacteristicWrapper mCharacteristic;
  final ChromeBluetoothDevice mChromeDevice;
  final String mInstanceId;
  private long mNativeBluetoothRemoteGattCharacteristicAndroid;

  public interface Natives {
    void createGattRemoteDescriptor(
        long j,
        ChromeBluetoothRemoteGattCharacteristic chromeBluetoothRemoteGattCharacteristic,
        String str,
        Wrappers.BluetoothGattDescriptorWrapper bluetoothGattDescriptorWrapper,
        ChromeBluetoothDevice chromeBluetoothDevice);

    void onChanged(
        long j,
        ChromeBluetoothRemoteGattCharacteristic chromeBluetoothRemoteGattCharacteristic,
        byte[] bArr);

    void onRead(
        long j,
        ChromeBluetoothRemoteGattCharacteristic chromeBluetoothRemoteGattCharacteristic,
        int i,
        byte[] bArr);

    void onWrite(
        long j,
        ChromeBluetoothRemoteGattCharacteristic chromeBluetoothRemoteGattCharacteristic,
        int i);
  }

  private ChromeBluetoothRemoteGattCharacteristic(
      long nativeBluetoothRemoteGattCharacteristicAndroid,
      Wrappers.BluetoothGattCharacteristicWrapper characteristicWrapper,
      String instanceId,
      ChromeBluetoothDevice chromeDevice) {
    this.mNativeBluetoothRemoteGattCharacteristicAndroid =
        nativeBluetoothRemoteGattCharacteristicAndroid;
    this.mCharacteristic = characteristicWrapper;
    this.mInstanceId = instanceId;
    this.mChromeDevice = chromeDevice;
    chromeDevice.mWrapperToChromeCharacteristicsMap.put(characteristicWrapper, this);
    Log.v(TAG, "ChromeBluetoothRemoteGattCharacteristic created.", new Object[0]);
  }

  private void onBluetoothRemoteGattCharacteristicAndroidDestruction() {
    Log.v(TAG, "ChromeBluetoothRemoteGattCharacteristic Destroyed.", new Object[0]);
    if (this.mChromeDevice.mBluetoothGatt != null) {
      this.mChromeDevice.mBluetoothGatt.setCharacteristicNotification(this.mCharacteristic, false);
    }
    this.mNativeBluetoothRemoteGattCharacteristicAndroid = 0L;
    this.mChromeDevice.mWrapperToChromeCharacteristicsMap.remove(this.mCharacteristic);
  }

  public void onCharacteristicChanged(byte[] value) {
    Log.i(TAG, "onCharacteristicChanged");
    if (this.mNativeBluetoothRemoteGattCharacteristicAndroid != 0) {
      ChromeBluetoothRemoteGattCharacteristicJni.get()
          .onChanged(this.mNativeBluetoothRemoteGattCharacteristicAndroid, this, value);
    }
  }

  public void onCharacteristicRead(int status) {
    Log.i(
        TAG,
        "onCharacteristicRead status:%d==%s",
        Integer.valueOf(status),
        status == 0 ? "OK" : "Error");
    if (this.mNativeBluetoothRemoteGattCharacteristicAndroid != 0) {
      ChromeBluetoothRemoteGattCharacteristicJni.get()
          .onRead(
              this.mNativeBluetoothRemoteGattCharacteristicAndroid,
              this,
              status,
              this.mCharacteristic.getValue());
    }
  }

  public void onCharacteristicWrite(int status) {
    Log.i(
        TAG,
        "onCharacteristicWrite status:%d==%s",
        Integer.valueOf(status),
        status == 0 ? "OK" : "Error");
    if (this.mNativeBluetoothRemoteGattCharacteristicAndroid != 0) {
      ChromeBluetoothRemoteGattCharacteristicJni.get()
          .onWrite(this.mNativeBluetoothRemoteGattCharacteristicAndroid, this, status);
    }
  }

  private static ChromeBluetoothRemoteGattCharacteristic create(
      long nativeBluetoothRemoteGattCharacteristicAndroid,
      Wrappers.BluetoothGattCharacteristicWrapper characteristicWrapper,
      String instanceId,
      ChromeBluetoothDevice chromeDevice) {
    return new ChromeBluetoothRemoteGattCharacteristic(
        nativeBluetoothRemoteGattCharacteristicAndroid,
        characteristicWrapper,
        instanceId,
        chromeDevice);
  }

  private String getUUID() {
    return this.mCharacteristic.getUuid().toString();
  }

  private int getProperties() {
    return this.mCharacteristic.getProperties();
  }

  private boolean readRemoteCharacteristic() {
    if (!this.mChromeDevice.mBluetoothGatt.readCharacteristic(this.mCharacteristic)) {
      Log.i(TAG, "readRemoteCharacteristic readCharacteristic failed.");
      return false;
    }
    return true;
  }

  private boolean writeRemoteCharacteristic(byte[] value, int writeType) {
    if (!this.mCharacteristic.setValue(value)) {
      Log.i(TAG, "writeRemoteCharacteristic setValue failed.");
      return false;
    }
    if (writeType != 0) {
      this.mCharacteristic.setWriteType(writeType);
    }
    if (!this.mChromeDevice.mBluetoothGatt.writeCharacteristic(this.mCharacteristic)) {
      Log.i(TAG, "writeRemoteCharacteristic writeCharacteristic failed.");
      return false;
    }
    return true;
  }

  private boolean setCharacteristicNotification(boolean enabled) {
    return this.mChromeDevice.mBluetoothGatt.setCharacteristicNotification(
        this.mCharacteristic, enabled);
  }

  private void createDescriptors() {
    List<Wrappers.BluetoothGattDescriptorWrapper> descriptors =
        this.mCharacteristic.getDescriptors();
    int instanceIdCounter = 0;
    for (Wrappers.BluetoothGattDescriptorWrapper descriptor : descriptors) {
      int instanceIdCounter2 = instanceIdCounter + 1;
      String descriptorInstanceId =
          this.mInstanceId + "/" + descriptor.getUuid().toString() + ";" + instanceIdCounter;
      ChromeBluetoothRemoteGattCharacteristicJni.get()
          .createGattRemoteDescriptor(
              this.mNativeBluetoothRemoteGattCharacteristicAndroid,
              this,
              descriptorInstanceId,
              descriptor,
              this.mChromeDevice);
      instanceIdCounter = instanceIdCounter2;
    }
  }
}
