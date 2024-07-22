package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;

public interface Geolocation extends Interface {
  public static final Interface.Manager<Geolocation, Proxy> MANAGER = Geolocation_Internal.MANAGER;

  public interface Proxy extends Geolocation, Interface.Proxy {}

  public interface QueryNextPosition_Response {
    void call(GeopositionResult geopositionResult);
  }

  void queryNextPosition(QueryNextPosition_Response queryNextPosition_Response);

  void setHighAccuracy(boolean z);
}
