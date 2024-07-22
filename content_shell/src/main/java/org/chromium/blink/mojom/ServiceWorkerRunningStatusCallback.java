package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface ServiceWorkerRunningStatusCallback extends Interface {
  public static final Interface.Manager<ServiceWorkerRunningStatusCallback, Proxy> MANAGER =
      ServiceWorkerRunningStatusCallback_Internal.MANAGER;

  public interface Proxy extends ServiceWorkerRunningStatusCallback, Interface.Proxy {}

  void onStatusChanged(int i);
}
