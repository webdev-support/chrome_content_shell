package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface DevicePostureProvider extends Interface {
  public static final Interface.Manager<DevicePostureProvider, Proxy> MANAGER =
      DevicePostureProvider_Internal.MANAGER;

  public interface AddListenerAndGetCurrentPosture_Response {
    void call(int i);
  }

  public interface Proxy extends DevicePostureProvider, Interface.Proxy {}

  void addListenerAndGetCurrentPosture(
      DevicePostureClient devicePostureClient,
      AddListenerAndGetCurrentPosture_Response addListenerAndGetCurrentPosture_Response);

  void disableDevicePostureOverrideForEmulation();

  void overrideDevicePostureForEmulation(int i);
}
