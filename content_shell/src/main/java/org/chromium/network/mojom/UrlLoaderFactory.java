package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

public interface UrlLoaderFactory extends Interface {
  public static final Interface.Manager<UrlLoaderFactory, Proxy> MANAGER =
      UrlLoaderFactory_Internal.MANAGER;

  public interface Proxy extends UrlLoaderFactory, Interface.Proxy {}

  void clone(InterfaceRequest<UrlLoaderFactory> interfaceRequest);

  void createLoaderAndStart(
      InterfaceRequest<UrlLoader> interfaceRequest,
      int i,
      int i2,
      UrlRequest urlRequest,
      UrlLoaderClient urlLoaderClient,
      MutableNetworkTrafficAnnotationTag mutableNetworkTrafficAnnotationTag);
}
