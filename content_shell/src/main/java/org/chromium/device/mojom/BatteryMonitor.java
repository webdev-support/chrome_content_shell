package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;

public interface BatteryMonitor extends Interface {
  public static final Interface.Manager<BatteryMonitor, Proxy> MANAGER =
      BatteryMonitor_Internal.MANAGER;

  public interface Proxy extends BatteryMonitor, Interface.Proxy {}

  public interface QueryNextStatus_Response {
    void call(BatteryStatus batteryStatus);
  }

  void queryNextStatus(QueryNextStatus_Response queryNextStatus_Response);
}
