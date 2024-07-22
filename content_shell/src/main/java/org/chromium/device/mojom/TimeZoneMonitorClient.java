package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;

public interface TimeZoneMonitorClient extends Interface {
  public static final Interface.Manager<TimeZoneMonitorClient, Proxy> MANAGER =
      TimeZoneMonitorClient_Internal.MANAGER;

  public interface Proxy extends TimeZoneMonitorClient, Interface.Proxy {}

  void onTimeZoneChange(String str);
}
