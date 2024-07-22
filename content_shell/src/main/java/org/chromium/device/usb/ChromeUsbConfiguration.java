package org.chromium.device.usb;

import android.hardware.usb.UsbConfiguration;
import android.hardware.usb.UsbInterface;
import org.chromium.base.Log;
import org.chromium.components.crash.PureJavaExceptionReporter;
import org.jni_zero.JNINamespace;

@JNINamespace(PureJavaExceptionReporter.DEVICE)
final class ChromeUsbConfiguration {
  private static final String TAG = "Usb";
  final UsbConfiguration mConfiguration;

  private ChromeUsbConfiguration(UsbConfiguration configuration) {
    this.mConfiguration = configuration;
    Log.v(TAG, "ChromeUsbConfiguration created.", new Object[0]);
  }

  private static ChromeUsbConfiguration create(UsbConfiguration configuration) {
    return new ChromeUsbConfiguration(configuration);
  }

  private int getConfigurationValue() {
    return this.mConfiguration.getId();
  }

  private boolean isSelfPowered() {
    return this.mConfiguration.isSelfPowered();
  }

  private boolean isRemoteWakeup() {
    return this.mConfiguration.isRemoteWakeup();
  }

  private int getMaxPower() {
    return this.mConfiguration.getMaxPower();
  }

  private UsbInterface[] getInterfaces() {
    int count = this.mConfiguration.getInterfaceCount();
    UsbInterface[] interfaces = new UsbInterface[count];
    for (int i = 0; i < count; i++) {
      interfaces[i] = this.mConfiguration.getInterface(i);
    }
    return interfaces;
  }
}
