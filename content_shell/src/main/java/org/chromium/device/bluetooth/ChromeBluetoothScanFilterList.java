package org.chromium.device.bluetooth;

import android.bluetooth.le.ScanFilter;
import java.util.ArrayList;
import org.chromium.components.crash.PureJavaExceptionReporter;
import org.jni_zero.JNINamespace;

@JNINamespace(PureJavaExceptionReporter.DEVICE)
final class ChromeBluetoothScanFilterList {
  ArrayList<ScanFilter> mFilters = new ArrayList<>();

  private static ChromeBluetoothScanFilterList create() {
    return new ChromeBluetoothScanFilterList();
  }

  private void addFilter(ScanFilter filter) {
    this.mFilters.add(filter);
  }

  public ArrayList<ScanFilter> getList() {
    return this.mFilters;
  }
}
