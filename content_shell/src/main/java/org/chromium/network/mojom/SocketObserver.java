package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;

public interface SocketObserver extends Interface {
  public static final Interface.Manager<SocketObserver, Proxy> MANAGER =
      SocketObserver_Internal.MANAGER;

  public interface Proxy extends SocketObserver, Interface.Proxy {}

  void onReadError(int i);

  void onWriteError(int i);
}
