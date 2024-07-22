package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;

public interface PowerMonitorClient extends Interface {
  public static final Interface.Manager<PowerMonitorClient, Proxy> MANAGER =
      PowerMonitorClient_Internal.MANAGER;

  public interface Proxy extends PowerMonitorClient, Interface.Proxy {}

  void powerStateChange(boolean z);

  void resume();

  void suspend();
}
