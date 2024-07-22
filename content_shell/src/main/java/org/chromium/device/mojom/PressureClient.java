package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;

public interface PressureClient extends Interface {
  public static final Interface.Manager<PressureClient, Proxy> MANAGER =
      PressureClient_Internal.MANAGER;

  public interface Proxy extends PressureClient, Interface.Proxy {}

  void onPressureUpdated(PressureUpdate pressureUpdate);
}
