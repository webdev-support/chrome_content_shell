package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface SubresourceLoaderUpdater extends Interface {
  public static final Interface.Manager<SubresourceLoaderUpdater, Proxy> MANAGER =
      SubresourceLoaderUpdater_Internal.MANAGER;

  public interface Proxy extends SubresourceLoaderUpdater, Interface.Proxy {}

  void updateSubresourceLoaderFactories(UrlLoaderFactoryBundle urlLoaderFactoryBundle);
}
