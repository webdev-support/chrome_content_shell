package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;

public interface SocketConnectionTracker extends Interface {
  public static final Interface.Manager<SocketConnectionTracker, Proxy> MANAGER =
      SocketConnectionTracker_Internal.MANAGER;

  public interface Proxy extends SocketConnectionTracker, Interface.Proxy {}
}
