package org.chromium.device.battery;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.chromium.base.Log;
import org.chromium.base.ThreadUtils;
import org.chromium.device.mojom.BatteryMonitor;
import org.chromium.device.mojom.BatteryStatus;
import org.chromium.services.service_manager.InterfaceFactory;

public class BatteryMonitorFactory implements InterfaceFactory<BatteryMonitor> {

  private static final String TAG = "BattMonitorFactory";
  private BatteryStatus mBatteryStatus;
  private final BatteryStatusManager.BatteryStatusCallback mCallback;
  private boolean mHasStatusUpdate;
  private final BatteryStatusManager mManager;
  private final HashSet<BatteryMonitorImpl> mSubscribedMonitors = new HashSet<>();

  public BatteryMonitorFactory() {
    BatteryStatusManager.BatteryStatusCallback batteryStatusCallback =
        new BatteryStatusManager.BatteryStatusCallback() {
          @Override
          public void onBatteryStatusChanged(BatteryStatus batteryStatus) {
            ThreadUtils.assertOnUiThread();
            BatteryMonitorFactory.this.mHasStatusUpdate = true;
            BatteryMonitorFactory.this.mBatteryStatus = batteryStatus;
            List<BatteryMonitorImpl> monitors =
                new ArrayList<>(BatteryMonitorFactory.this.mSubscribedMonitors);
            for (BatteryMonitorImpl monitor : monitors) {
              monitor.didChange(batteryStatus);
            }
          }
        };
    this.mCallback = batteryStatusCallback;
    this.mHasStatusUpdate = false;
    this.mManager = new BatteryStatusManager(batteryStatusCallback);
  }

  @Override
  public BatteryMonitor createImpl() {
    ThreadUtils.assertOnUiThread();
    if (this.mSubscribedMonitors.isEmpty() && !this.mManager.start()) {
      Log.e(TAG, "BatteryStatusManager failed to start.");
    }
    BatteryMonitorImpl monitor = new BatteryMonitorImpl(this);
    if (this.mHasStatusUpdate) {
      monitor.didChange(this.mBatteryStatus);
    }
    this.mSubscribedMonitors.add(monitor);
    return monitor;
  }

  public void unsubscribe(BatteryMonitorImpl monitor) {
    ThreadUtils.assertOnUiThread();
    if (!this.mSubscribedMonitors.contains(monitor)) {
      throw new AssertionError();
    }
    this.mSubscribedMonitors.remove(monitor);
    if (this.mSubscribedMonitors.isEmpty()) {
      this.mManager.stop();
      this.mHasStatusUpdate = false;
    }
  }
}
