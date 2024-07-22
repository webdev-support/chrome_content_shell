package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

public interface HttpCacheBackendFileOperationsFactory extends Interface {
  public static final Interface.Manager<HttpCacheBackendFileOperationsFactory, Proxy> MANAGER =
      HttpCacheBackendFileOperationsFactory_Internal.MANAGER;

  public interface Proxy extends HttpCacheBackendFileOperationsFactory, Interface.Proxy {}

  void create(InterfaceRequest<HttpCacheBackendFileOperations> interfaceRequest);
}
