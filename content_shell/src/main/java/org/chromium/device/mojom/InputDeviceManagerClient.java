package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;

public interface InputDeviceManagerClient extends Interface {
  public static final Interface.Manager<InputDeviceManagerClient, Proxy> MANAGER =
      InputDeviceManagerClient_Internal.MANAGER;

  public interface Proxy extends InputDeviceManagerClient, Interface.Proxy {}

  void inputDeviceAdded(InputDeviceInfo inputDeviceInfo);

  void inputDeviceRemoved(String str);
}
