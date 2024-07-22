package org.chromium.blink.mojom;

import org.chromium.device.mojom.Geolocation;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

public interface GeolocationService extends Interface {
  public static final Interface.Manager<GeolocationService, Proxy> MANAGER =
      GeolocationService_Internal.MANAGER;

  public interface CreateGeolocation_Response {
    void call(int i);
  }

  public interface Proxy extends GeolocationService, Interface.Proxy {}

  void createGeolocation(
      InterfaceRequest<Geolocation> interfaceRequest,
      boolean z,
      CreateGeolocation_Response createGeolocation_Response);
}
