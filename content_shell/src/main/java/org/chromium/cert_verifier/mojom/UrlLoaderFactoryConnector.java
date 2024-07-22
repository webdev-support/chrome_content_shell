package org.chromium.cert_verifier.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.network.mojom.UrlLoaderFactory;

public interface UrlLoaderFactoryConnector extends Interface {
  public static final Interface.Manager<UrlLoaderFactoryConnector, Proxy> MANAGER =
      UrlLoaderFactoryConnector_Internal.MANAGER;

  public interface Proxy extends UrlLoaderFactoryConnector, Interface.Proxy {}

  void createUrlLoaderFactory(InterfaceRequest<UrlLoaderFactory> interfaceRequest);
}
