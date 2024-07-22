package org.chromium.device.mojom;

import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

public interface HidManager extends Interface {
  public static final Interface.Manager<HidManager, Proxy> MANAGER = HidManager_Internal.MANAGER;

  public interface Connect_Response {
    void call(HidConnection hidConnection);
  }

  public interface GetDevicesAndSetClient_Response {
    void call(HidDeviceInfo[] hidDeviceInfoArr);
  }

  public interface GetDevices_Response {
    void call(HidDeviceInfo[] hidDeviceInfoArr);
  }

  public interface Proxy extends HidManager, Interface.Proxy {}

  void addReceiver(InterfaceRequest<HidManager> interfaceRequest);

  void connect(
      String str,
      HidConnectionClient hidConnectionClient,
      HidConnectionWatcher hidConnectionWatcher,
      boolean z,
      boolean z2,
      Connect_Response connect_Response);

  void getDevices(GetDevices_Response getDevices_Response);

  void getDevicesAndSetClient(
      AssociatedInterfaceNotSupported associatedInterfaceNotSupported,
      GetDevicesAndSetClient_Response getDevicesAndSetClient_Response);
}
