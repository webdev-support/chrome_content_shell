package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface BackForwardCacheControllerHost extends Interface {
  public static final Interface.Manager<BackForwardCacheControllerHost, Proxy> MANAGER =
      BackForwardCacheControllerHost_Internal.MANAGER;

  public interface Proxy extends BackForwardCacheControllerHost, Interface.Proxy {}

  void didChangeBackForwardCacheDisablingFeatures(BlockingDetails[] blockingDetailsArr);

  void evictFromBackForwardCache(int i, BlockingDetails blockingDetails);
}
