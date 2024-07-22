package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;

public interface UsbDeviceClient extends Interface {
  public static final Interface.Manager<UsbDeviceClient, Proxy> MANAGER =
      UsbDeviceClient_Internal.MANAGER;

  public interface Proxy extends UsbDeviceClient, Interface.Proxy {}

  void onDeviceClosed();

  void onDeviceOpened();
}
