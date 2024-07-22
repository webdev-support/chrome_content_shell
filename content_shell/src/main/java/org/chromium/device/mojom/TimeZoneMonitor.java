package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;

public interface TimeZoneMonitor extends Interface {
  public static final Interface.Manager<TimeZoneMonitor, Proxy> MANAGER =
      TimeZoneMonitor_Internal.MANAGER;

  public interface Proxy extends TimeZoneMonitor, Interface.Proxy {}

  void addClient(TimeZoneMonitorClient timeZoneMonitorClient);
}
