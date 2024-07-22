package org.chromium.device.usb;

import android.hardware.usb.UsbEndpoint;
import org.chromium.base.Log;
import org.chromium.components.crash.PureJavaExceptionReporter;
import org.jni_zero.JNINamespace;

@JNINamespace(PureJavaExceptionReporter.DEVICE)
final class ChromeUsbEndpoint {
  private static final String TAG = "Usb";
  final UsbEndpoint mEndpoint;

  private ChromeUsbEndpoint(UsbEndpoint endpoint) {
    this.mEndpoint = endpoint;
    Log.v(TAG, "ChromeUsbEndpoint created.", new Object[0]);
  }

  private static ChromeUsbEndpoint create(UsbEndpoint endpoint) {
    return new ChromeUsbEndpoint(endpoint);
  }

  private int getAddress() {
    return this.mEndpoint.getAddress();
  }

  private int getMaxPacketSize() {
    return this.mEndpoint.getMaxPacketSize();
  }

  private int getAttributes() {
    return this.mEndpoint.getAttributes();
  }

  private int getInterval() {
    return this.mEndpoint.getInterval();
  }
}
