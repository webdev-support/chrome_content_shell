package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

public interface CookieAccessObserver extends Interface {
  public static final Interface.Manager<CookieAccessObserver, Proxy> MANAGER =
      CookieAccessObserver_Internal.MANAGER;

  public interface Proxy extends CookieAccessObserver, Interface.Proxy {}

  void clone(InterfaceRequest<CookieAccessObserver> interfaceRequest);

  void onCookiesAccessed(CookieAccessDetails[] cookieAccessDetailsArr);
}
