package org.chromium.device.usb;

import android.hardware.usb.UsbDeviceConnection;
import org.chromium.base.Log;
import org.chromium.components.crash.PureJavaExceptionReporter;
import org.jni_zero.JNINamespace;

@JNINamespace(PureJavaExceptionReporter.DEVICE)
class ChromeUsbConnection {
  private static final String TAG = "Usb";
  final UsbDeviceConnection mConnection;

  private ChromeUsbConnection(UsbDeviceConnection connection) {
    this.mConnection = connection;
    Log.v(TAG, "ChromeUsbConnection created.", new Object[0]);
  }

  private static ChromeUsbConnection create(UsbDeviceConnection connection) {
    return new ChromeUsbConnection(connection);
  }

  private int getFileDescriptor() {
    return this.mConnection.getFileDescriptor();
  }

  private void close() {
    this.mConnection.close();
  }
}
