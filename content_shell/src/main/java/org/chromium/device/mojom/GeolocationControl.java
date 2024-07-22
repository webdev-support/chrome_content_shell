package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;

public interface GeolocationControl extends Interface {
  public static final Interface.Manager<GeolocationControl, Proxy> MANAGER =
      GeolocationControl_Internal.MANAGER;

  public interface Proxy extends GeolocationControl, Interface.Proxy {}

  void userDidOptIntoLocationServices();
}
