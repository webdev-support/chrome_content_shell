package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;

public interface CookieChangeListener extends Interface {
  public static final Interface.Manager<CookieChangeListener, Proxy> MANAGER =
      CookieChangeListener_Internal.MANAGER;

  public interface Proxy extends CookieChangeListener, Interface.Proxy {}

  void onCookieChange(CookieChangeInfo cookieChangeInfo);
}
