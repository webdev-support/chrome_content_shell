package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

public interface TrustTokenAccessObserver extends Interface {
  public static final Interface.Manager<TrustTokenAccessObserver, Proxy> MANAGER =
      TrustTokenAccessObserver_Internal.MANAGER;

  public interface Proxy extends TrustTokenAccessObserver, Interface.Proxy {}

  void clone(InterfaceRequest<TrustTokenAccessObserver> interfaceRequest);

  void onTrustTokensAccessed(TrustTokenAccessDetails trustTokenAccessDetails);
}
