package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface ControllerServiceWorkerConnector extends Interface {
  public static final Interface.Manager<ControllerServiceWorkerConnector, Proxy> MANAGER =
      ControllerServiceWorkerConnector_Internal.MANAGER;

  public interface Proxy extends ControllerServiceWorkerConnector, Interface.Proxy {}

  void updateController(ControllerServiceWorker controllerServiceWorker);
}
