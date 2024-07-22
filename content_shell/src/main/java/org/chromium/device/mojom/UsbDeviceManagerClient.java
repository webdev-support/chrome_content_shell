package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;

public interface UsbDeviceManagerClient extends Interface {
  public static final Interface.Manager<UsbDeviceManagerClient, Proxy> MANAGER =
      UsbDeviceManagerClient_Internal.MANAGER;

  public interface Proxy extends UsbDeviceManagerClient, Interface.Proxy {}

  void onDeviceAdded(UsbDeviceInfo usbDeviceInfo);

  void onDeviceRemoved(UsbDeviceInfo usbDeviceInfo);
}
