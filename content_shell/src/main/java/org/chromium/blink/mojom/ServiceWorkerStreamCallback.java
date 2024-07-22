package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface ServiceWorkerStreamCallback extends Interface {
  public static final Interface.Manager<ServiceWorkerStreamCallback, Proxy> MANAGER =
      ServiceWorkerStreamCallback_Internal.MANAGER;

  public interface Proxy extends ServiceWorkerStreamCallback, Interface.Proxy {}

  void onAborted();

  void onCompleted();
}
