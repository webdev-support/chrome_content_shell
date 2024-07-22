package org.chromium.blink.mojom;

import org.chromium.device.mojom.HidConnection;
import org.chromium.device.mojom.HidConnectionClient;
import org.chromium.device.mojom.HidDeviceInfo;
import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
import org.chromium.mojo.bindings.Interface;

public interface HidService extends Interface {
  public static final Interface.Manager<HidService, Proxy> MANAGER = HidService_Internal.MANAGER;

  public interface Connect_Response {
    void call(HidConnection hidConnection);
  }

  public interface Forget_Response {
    void call();
  }

  public interface GetDevices_Response {
    void call(HidDeviceInfo[] hidDeviceInfoArr);
  }

  public interface Proxy extends HidService, Interface.Proxy {}

  public interface RequestDevice_Response {
    void call(HidDeviceInfo[] hidDeviceInfoArr);
  }

  void connect(
      String str, HidConnectionClient hidConnectionClient, Connect_Response connect_Response);

  void forget(HidDeviceInfo hidDeviceInfo, Forget_Response forget_Response);

  void getDevices(GetDevices_Response getDevices_Response);

  void registerClient(AssociatedInterfaceNotSupported associatedInterfaceNotSupported);

  void requestDevice(
      HidDeviceFilter[] hidDeviceFilterArr,
      HidDeviceFilter[] hidDeviceFilterArr2,
      RequestDevice_Response requestDevice_Response);
}
