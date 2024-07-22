package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface DevicePostureClient extends Interface {
  public static final Interface.Manager<DevicePostureClient, Proxy> MANAGER =
      DevicePostureClient_Internal.MANAGER;

  public interface Proxy extends DevicePostureClient, Interface.Proxy {}

  void onPostureChanged(int i);
}
