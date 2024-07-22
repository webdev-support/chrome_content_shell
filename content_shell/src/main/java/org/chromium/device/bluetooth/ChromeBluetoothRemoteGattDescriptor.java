package org.chromium.device.bluetooth;

import org.chromium.base.Log;
import org.chromium.components.crash.PureJavaExceptionReporter;
import org.jni_zero.JNINamespace;

@JNINamespace(PureJavaExceptionReporter.DEVICE)
public final class ChromeBluetoothRemoteGattDescriptor {
  private static final String TAG = "Bluetooth";
  final ChromeBluetoothDevice mChromeDevice;
  final Wrappers.BluetoothGattDescriptorWrapper mDescriptor;
  private long mNativeBluetoothRemoteGattDescriptorAndroid;

  public interface Natives {
    void onRead(
        long j,
        ChromeBluetoothRemoteGattDescriptor chromeBluetoothRemoteGattDescriptor,
        int i,
        byte[] bArr);

    void onWrite(
        long j, ChromeBluetoothRemoteGattDescriptor chromeBluetoothRemoteGattDescriptor, int i);
  }

  private ChromeBluetoothRemoteGattDescriptor(
      long nativeBluetoothRemoteGattDescriptorAndroid,
      Wrappers.BluetoothGattDescriptorWrapper descriptorWrapper,
      ChromeBluetoothDevice chromeDevice) {
    this.mNativeBluetoothRemoteGattDescriptorAndroid = nativeBluetoothRemoteGattDescriptorAndroid;
    this.mDescriptor = descriptorWrapper;
    this.mChromeDevice = chromeDevice;
    chromeDevice.mWrapperToChromeDescriptorsMap.put(descriptorWrapper, this);
    Log.v(TAG, "ChromeBluetoothRemoteGattDescriptor created.", new Object[0]);
  }

  private void onBluetoothRemoteGattDescriptorAndroidDestruction() {
    Log.v(TAG, "ChromeBluetoothRemoteGattDescriptor Destroyed.", new Object[0]);
    this.mNativeBluetoothRemoteGattDescriptorAndroid = 0L;
    this.mChromeDevice.mWrapperToChromeDescriptorsMap.remove(this.mDescriptor);
  }

  public void onDescriptorRead(int status) {
    Log.i(
        TAG,
        "onDescriptorRead status:%d==%s",
        Integer.valueOf(status),
        status == 0 ? "OK" : "Error");
    if (this.mNativeBluetoothRemoteGattDescriptorAndroid != 0) {
      ChromeBluetoothRemoteGattDescriptorJni.get()
          .onRead(
              this.mNativeBluetoothRemoteGattDescriptorAndroid,
              this,
              status,
              this.mDescriptor.getValue());
    }
  }

  public void onDescriptorWrite(int status) {
    Log.i(
        TAG,
        "onDescriptorWrite status:%d==%s",
        Integer.valueOf(status),
        status == 0 ? "OK" : "Error");
    if (this.mNativeBluetoothRemoteGattDescriptorAndroid != 0) {
      ChromeBluetoothRemoteGattDescriptorJni.get()
          .onWrite(this.mNativeBluetoothRemoteGattDescriptorAndroid, this, status);
    }
  }

  private static ChromeBluetoothRemoteGattDescriptor create(
      long nativeBluetoothRemoteGattDescriptorAndroid,
      Wrappers.BluetoothGattDescriptorWrapper descriptorWrapper,
      ChromeBluetoothDevice chromeDevice) {
    return new ChromeBluetoothRemoteGattDescriptor(
        nativeBluetoothRemoteGattDescriptorAndroid, descriptorWrapper, chromeDevice);
  }

  private String getUUID() {
    return this.mDescriptor.getUuid().toString();
  }

  private boolean readRemoteDescriptor() {
    if (!this.mChromeDevice.mBluetoothGatt.readDescriptor(this.mDescriptor)) {
      Log.i(TAG, "readRemoteDescriptor readDescriptor failed.");
      return false;
    }
    return true;
  }

  private boolean writeRemoteDescriptor(byte[] value) {
    if (!this.mDescriptor.setValue(value)) {
      Log.i(TAG, "writeRemoteDescriptor setValue failed.");
      return false;
    } else if (!this.mChromeDevice.mBluetoothGatt.writeDescriptor(this.mDescriptor)) {
      Log.i(TAG, "writeRemoteDescriptor writeDescriptor failed.");
      return false;
    } else {
      return true;
    }
  }
}
