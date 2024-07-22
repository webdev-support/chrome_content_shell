package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface ServiceWorkerObject extends Interface {
  public static final Interface.Manager<ServiceWorkerObject, Proxy> MANAGER =
      ServiceWorkerObject_Internal.MANAGER;

  public interface Proxy extends ServiceWorkerObject, Interface.Proxy {}

  void stateChanged(int i);
}
