package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.url.mojom.Url;

public interface NonAssociatedLocalFrameHost extends Interface {
  public static final Interface.Manager<NonAssociatedLocalFrameHost, Proxy> MANAGER =
      NonAssociatedLocalFrameHost_Internal.MANAGER;

  public interface Proxy extends NonAssociatedLocalFrameHost, Interface.Proxy {}

  void maybeStartOutermostMainFrameNavigation(Url[] urlArr);
}
