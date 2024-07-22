package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface ServiceWorkerContainer extends Interface {
  public static final Interface.Manager<ServiceWorkerContainer, Proxy> MANAGER =
      ServiceWorkerContainer_Internal.MANAGER;

  public interface Proxy extends ServiceWorkerContainer, Interface.Proxy {}

  void countFeature(int i);

  void postMessageToClient(
      ServiceWorkerObjectInfo serviceWorkerObjectInfo, TransferableMessage transferableMessage);

  void setController(ControllerServiceWorkerInfo controllerServiceWorkerInfo, boolean z);
}
