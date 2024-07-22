package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;

public interface GeolocationConfig extends Interface {
  public static final Interface.Manager<GeolocationConfig, Proxy> MANAGER =
      GeolocationConfig_Internal.MANAGER;

  public interface IsHighAccuracyLocationBeingCaptured_Response {
    void call(boolean z);
  }

  public interface Proxy extends GeolocationConfig, Interface.Proxy {}

  void isHighAccuracyLocationBeingCaptured(
      IsHighAccuracyLocationBeingCaptured_Response isHighAccuracyLocationBeingCaptured_Response);
}
