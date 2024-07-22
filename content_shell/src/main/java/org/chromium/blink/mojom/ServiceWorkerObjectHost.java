package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface ServiceWorkerObjectHost extends Interface {
  public static final Interface.Manager<ServiceWorkerObjectHost, Proxy> MANAGER =
      ServiceWorkerObjectHost_Internal.MANAGER;

  public interface Proxy extends ServiceWorkerObjectHost, Interface.Proxy {}

  public interface TerminateForTesting_Response {
    void call();
  }

  void postMessageToServiceWorker(TransferableMessage transferableMessage);

  void terminateForTesting(TerminateForTesting_Response terminateForTesting_Response);
}
