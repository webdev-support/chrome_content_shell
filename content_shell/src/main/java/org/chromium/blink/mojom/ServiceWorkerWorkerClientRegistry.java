package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

public interface ServiceWorkerWorkerClientRegistry extends Interface {
  public static final Interface.Manager<ServiceWorkerWorkerClientRegistry, Proxy> MANAGER =
      ServiceWorkerWorkerClientRegistry_Internal.MANAGER;

  public interface Proxy extends ServiceWorkerWorkerClientRegistry, Interface.Proxy {}

  void cloneWorkerClientRegistry(
      InterfaceRequest<ServiceWorkerWorkerClientRegistry> interfaceRequest);

  void registerWorkerClient(ServiceWorkerWorkerClient serviceWorkerWorkerClient);
}
