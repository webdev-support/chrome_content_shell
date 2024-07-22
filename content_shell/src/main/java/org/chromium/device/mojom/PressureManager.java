package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;

public interface PressureManager extends Interface {
  public static final Interface.Manager<PressureManager, Proxy> MANAGER =
      PressureManager_Internal.MANAGER;

  public interface AddClient_Response {
    void call(int i);
  }

  public interface Proxy extends PressureManager, Interface.Proxy {}

  void addClient(PressureClient pressureClient, int i, AddClient_Response addClient_Response);
}
