package org.chromium.device.usb;

import android.hardware.usb.UsbConfiguration;
import android.hardware.usb.UsbDevice;
import org.chromium.base.Log;
import org.chromium.components.crash.PureJavaExceptionReporter;
import org.jni_zero.JNINamespace;

@JNINamespace(PureJavaExceptionReporter.DEVICE)
final class ChromeUsbDevice {

  private static final String TAG = "Usb";
  final UsbDevice mDevice;

  private ChromeUsbDevice(UsbDevice device) {
    this.mDevice = device;
    Log.v(TAG, "ChromeUsbDevice created.", new Object[0]);
  }

  public UsbDevice getDevice() {
    return this.mDevice;
  }

  private static ChromeUsbDevice create(UsbDevice device) {
    return new ChromeUsbDevice(device);
  }

  private int getDeviceId() {
    return this.mDevice.getDeviceId();
  }

  private int getDeviceClass() {
    return this.mDevice.getDeviceClass();
  }

  private int getDeviceSubclass() {
    return this.mDevice.getDeviceSubclass();
  }

  private int getDeviceProtocol() {
    return this.mDevice.getDeviceProtocol();
  }

  private int getVendorId() {
    return this.mDevice.getVendorId();
  }

  private int getProductId() {
    return this.mDevice.getProductId();
  }

  private int getDeviceVersion() {
    String[] parts = this.mDevice.getVersion().split("\\.");
    if (parts.length != 2) {
      throw new AssertionError();
    }
    return (Integer.parseInt(parts[0]) << 8) | Integer.parseInt(parts[1]);
  }

  private String getManufacturerName() {
    return this.mDevice.getManufacturerName();
  }

  private String getProductName() {
    return this.mDevice.getProductName();
  }

  private String getSerialNumber() {
    return this.mDevice.getSerialNumber();
  }

  private UsbConfiguration[] getConfigurations() {
    int count = this.mDevice.getConfigurationCount();
    UsbConfiguration[] configurations = new UsbConfiguration[count];
    for (int i = 0; i < count; i++) {
      configurations[i] = this.mDevice.getConfiguration(i);
    }
    return configurations;
  }
}
