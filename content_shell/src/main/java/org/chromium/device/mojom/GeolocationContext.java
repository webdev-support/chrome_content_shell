package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.url.internal.mojom.Origin;
import org.chromium.url.mojom.Url;

public interface GeolocationContext extends Interface {
  public static final Interface.Manager<GeolocationContext, Proxy> MANAGER =
      GeolocationContext_Internal.MANAGER;

  public interface Proxy extends GeolocationContext, Interface.Proxy {}

  void bindGeolocation(InterfaceRequest<Geolocation> interfaceRequest, Url url);

  void clearOverride();

  void onPermissionRevoked(Origin origin);

  void setOverride(GeopositionResult geopositionResult);
}
