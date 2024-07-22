package org.chromium.device.battery;

import org.chromium.base.Log;
import org.chromium.device.mojom.BatteryMonitor;
import org.chromium.device.mojom.BatteryStatus;
import org.chromium.mojo.system.MojoException;

public class BatteryMonitorImpl implements BatteryMonitor {
  private static final String TAG = "BatteryMonitorImpl";
  private BatteryMonitor.QueryNextStatus_Response mCallback;
  private final BatteryMonitorFactory mFactory;
  private BatteryStatus mStatus;
  private boolean mHasStatusToReport = false;
  private boolean mSubscribed = true;

  public BatteryMonitorImpl(BatteryMonitorFactory batteryMonitorFactory) {
    this.mFactory = batteryMonitorFactory;
  }

  private void unsubscribe() {
    if (this.mSubscribed) {
      this.mFactory.unsubscribe(this);
      this.mSubscribed = false;
    }
  }

  @Override
  public void close() {
    unsubscribe();
  }

  @Override
  public void onConnectionError(MojoException e) {
    unsubscribe();
  }

  @Override
  public void queryNextStatus(BatteryMonitor.QueryNextStatus_Response callback) {
    if (this.mCallback != null) {
      Log.e(TAG, "Overlapped call to queryNextStatus!");
      unsubscribe();
      return;
    }
    this.mCallback = callback;
    if (this.mHasStatusToReport) {
      reportStatus();
    }
  }

  public void didChange(BatteryStatus batteryStatus) {
    this.mStatus = batteryStatus;
    this.mHasStatusToReport = true;
    if (this.mCallback != null) {
      reportStatus();
    }
  }

  void reportStatus() {
    this.mCallback.call(this.mStatus);
    this.mCallback = null;
    this.mHasStatusToReport = false;
  }
}
