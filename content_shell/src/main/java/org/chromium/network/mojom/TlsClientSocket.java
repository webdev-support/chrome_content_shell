package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;

public interface TlsClientSocket extends Interface {
  public static final Interface.Manager<TlsClientSocket, Proxy> MANAGER =
      TlsClientSocket_Internal.MANAGER;

  public interface Proxy extends TlsClientSocket, Interface.Proxy {}
}
