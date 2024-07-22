package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;

public interface HidManagerClient extends Interface {
  public static final Interface.Manager<HidManagerClient, Proxy> MANAGER =
      HidManagerClient_Internal.MANAGER;

  public interface Proxy extends HidManagerClient, Interface.Proxy {}

  void deviceAdded(HidDeviceInfo hidDeviceInfo);

  void deviceChanged(HidDeviceInfo hidDeviceInfo);

  void deviceRemoved(HidDeviceInfo hidDeviceInfo);
}
