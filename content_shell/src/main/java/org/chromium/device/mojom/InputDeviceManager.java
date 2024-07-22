package org.chromium.device.mojom;

import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
import org.chromium.mojo.bindings.Interface;

public interface InputDeviceManager extends Interface {
  public static final Interface.Manager<InputDeviceManager, Proxy> MANAGER =
      InputDeviceManager_Internal.MANAGER;

  public interface GetDevicesAndSetClient_Response {
    void call(InputDeviceInfo[] inputDeviceInfoArr);
  }

  public interface GetDevices_Response {
    void call(InputDeviceInfo[] inputDeviceInfoArr);
  }

  public interface Proxy extends InputDeviceManager, Interface.Proxy {}

  void getDevices(GetDevices_Response getDevices_Response);

  void getDevicesAndSetClient(
      AssociatedInterfaceNotSupported associatedInterfaceNotSupported,
      GetDevicesAndSetClient_Response getDevicesAndSetClient_Response);
}
