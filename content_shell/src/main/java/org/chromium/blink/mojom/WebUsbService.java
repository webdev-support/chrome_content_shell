package org.chromium.blink.mojom;

import org.chromium.device.mojom.UsbDevice;
import org.chromium.device.mojom.UsbDeviceInfo;
import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

public interface WebUsbService extends Interface {
  public static final Interface.Manager<WebUsbService, Proxy> MANAGER =
      WebUsbService_Internal.MANAGER;

  public interface ForgetDevice_Response {
    void call();
  }

  public interface GetDevices_Response {
    void call(UsbDeviceInfo[] usbDeviceInfoArr);
  }

  public interface GetPermission_Response {
    void call(UsbDeviceInfo usbDeviceInfo);
  }

  public interface Proxy extends WebUsbService, Interface.Proxy {}

  void forgetDevice(String str, ForgetDevice_Response forgetDevice_Response);

  void getDevice(String str, InterfaceRequest<UsbDevice> interfaceRequest);

  void getDevices(GetDevices_Response getDevices_Response);

  void getPermission(
      WebUsbRequestDeviceOptions webUsbRequestDeviceOptions,
      GetPermission_Response getPermission_Response);

  void setClient(AssociatedInterfaceNotSupported associatedInterfaceNotSupported);
}
