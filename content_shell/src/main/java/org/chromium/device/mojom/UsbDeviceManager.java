package org.chromium.device.mojom;

import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

public interface UsbDeviceManager extends Interface {
  public static final Interface.Manager<UsbDeviceManager, Proxy> MANAGER =
      UsbDeviceManager_Internal.MANAGER;

  public interface EnumerateDevicesAndSetClient_Response {
    void call(UsbDeviceInfo[] usbDeviceInfoArr);
  }

  public interface GetDevices_Response {
    void call(UsbDeviceInfo[] usbDeviceInfoArr);
  }

  public interface Proxy extends UsbDeviceManager, Interface.Proxy {}

  public interface RefreshDeviceInfo_Response {
    void call(UsbDeviceInfo usbDeviceInfo);
  }

  void enumerateDevicesAndSetClient(
      AssociatedInterfaceNotSupported associatedInterfaceNotSupported,
      EnumerateDevicesAndSetClient_Response enumerateDevicesAndSetClient_Response);

  void getDevice(
      String str,
      byte[] bArr,
      InterfaceRequest<UsbDevice> interfaceRequest,
      UsbDeviceClient usbDeviceClient);

  void getDevices(
      UsbEnumerationOptions usbEnumerationOptions, GetDevices_Response getDevices_Response);

  void getSecurityKeyDevice(
      String str, InterfaceRequest<UsbDevice> interfaceRequest, UsbDeviceClient usbDeviceClient);

  void refreshDeviceInfo(String str, RefreshDeviceInfo_Response refreshDeviceInfo_Response);

  void setClient(AssociatedInterfaceNotSupported associatedInterfaceNotSupported);
}
