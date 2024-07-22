package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.url.mojom.Url;

public interface PendingBeaconHost extends Interface {
  public static final Interface.Manager<PendingBeaconHost, Proxy> MANAGER =
      PendingBeaconHost_Internal.MANAGER;

  public interface Proxy extends PendingBeaconHost, Interface.Proxy {}

  void createBeacon(InterfaceRequest<PendingBeacon> interfaceRequest, Url url, int i);
}
