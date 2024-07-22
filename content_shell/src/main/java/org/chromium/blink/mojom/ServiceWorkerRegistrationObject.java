package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface ServiceWorkerRegistrationObject extends Interface {
  public static final Interface.Manager<ServiceWorkerRegistrationObject, Proxy> MANAGER =
      ServiceWorkerRegistrationObject_Internal.MANAGER;

  public interface Proxy extends ServiceWorkerRegistrationObject, Interface.Proxy {}

  void setServiceWorkerObjects(
      ChangedServiceWorkerObjectsMask changedServiceWorkerObjectsMask,
      ServiceWorkerObjectInfo serviceWorkerObjectInfo,
      ServiceWorkerObjectInfo serviceWorkerObjectInfo2,
      ServiceWorkerObjectInfo serviceWorkerObjectInfo3);

  void setUpdateViaCache(int i);

  void updateFound();
}
