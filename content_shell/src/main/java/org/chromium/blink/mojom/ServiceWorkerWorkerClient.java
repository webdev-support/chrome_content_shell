package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface ServiceWorkerWorkerClient extends Interface {
  public static final Interface.Manager<ServiceWorkerWorkerClient, Proxy> MANAGER =
      ServiceWorkerWorkerClient_Internal.MANAGER;

  public interface Proxy extends ServiceWorkerWorkerClient, Interface.Proxy {}

  void onControllerChanged(int i);
}
