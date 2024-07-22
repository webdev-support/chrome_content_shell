package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.network.mojom.CrossOriginEmbedderPolicy;
import org.chromium.network.mojom.CrossOriginEmbedderPolicyReporter;

public interface ControllerServiceWorker extends Interface {
  public static final Interface.Manager<ControllerServiceWorker, Proxy> MANAGER =
      ControllerServiceWorker_Internal.MANAGER;

  public interface DispatchFetchEventForSubresource_Response {
    void call(int i);
  }

  public interface Proxy extends ControllerServiceWorker, Interface.Proxy {}

  void clone(
      InterfaceRequest<ControllerServiceWorker> interfaceRequest,
      CrossOriginEmbedderPolicy crossOriginEmbedderPolicy,
      CrossOriginEmbedderPolicyReporter crossOriginEmbedderPolicyReporter);

  void dispatchFetchEventForSubresource(
      DispatchFetchEventParams dispatchFetchEventParams,
      ServiceWorkerFetchResponseCallback serviceWorkerFetchResponseCallback,
      DispatchFetchEventForSubresource_Response dispatchFetchEventForSubresource_Response);
}
