package org.chromium.device.usb;

import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import org.chromium.base.Log;
import org.chromium.components.crash.PureJavaExceptionReporter;
import org.jni_zero.JNINamespace;

@JNINamespace(PureJavaExceptionReporter.DEVICE)
final class ChromeUsbInterface {
  private static final String TAG = "Usb";
  final UsbInterface mInterface;

  private ChromeUsbInterface(UsbInterface iface) {
    this.mInterface = iface;
    Log.v(TAG, "ChromeUsbInterface created.", new Object[0]);
  }

  private static ChromeUsbInterface create(UsbInterface iface) {
    return new ChromeUsbInterface(iface);
  }

  private int getInterfaceNumber() {
    return this.mInterface.getId();
  }

  private int getAlternateSetting() {
    return this.mInterface.getAlternateSetting();
  }

  private int getInterfaceClass() {
    return this.mInterface.getInterfaceClass();
  }

  private int getInterfaceSubclass() {
    return this.mInterface.getInterfaceSubclass();
  }

  private int getInterfaceProtocol() {
    return this.mInterface.getInterfaceProtocol();
  }

  private UsbEndpoint[] getEndpoints() {
    int count = this.mInterface.getEndpointCount();
    UsbEndpoint[] endpoints = new UsbEndpoint[count];
    for (int i = 0; i < count; i++) {
      endpoints[i] = this.mInterface.getEndpoint(i);
    }
    return endpoints;
  }
}
