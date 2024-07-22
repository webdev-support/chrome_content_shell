package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;

public interface PowerMonitor extends Interface {
  public static final Manager<PowerMonitor, Proxy> MANAGER = PowerMonitor_Internal.MANAGER;

  public interface Proxy extends PowerMonitor, Interface.Proxy {}

  void addClient(PowerMonitorClient powerMonitorClient);
}
