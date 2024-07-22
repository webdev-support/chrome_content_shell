package org.chromium.device.bluetooth;

import android.bluetooth.le.ScanFilter;
import android.os.ParcelUuid;
import org.chromium.components.crash.PureJavaExceptionReporter;
import org.jni_zero.JNINamespace;

@JNINamespace(PureJavaExceptionReporter.DEVICE)
final class ChromeBluetoothScanFilterBuilder {
  private ScanFilter.Builder mBuilder = new ScanFilter.Builder();

  private static ChromeBluetoothScanFilterBuilder create() {
    return new ChromeBluetoothScanFilterBuilder();
  }

  private void setServiceUuid(String uuid) {
    if (uuid != null) {
      this.mBuilder.setServiceUuid(ParcelUuid.fromString(uuid));
    }
  }

  private void setDeviceName(String deviceName) {
    if (deviceName != null) {
      this.mBuilder.setDeviceName(deviceName);
    }
  }

  public ScanFilter build() {
    return this.mBuilder.build();
  }
}
