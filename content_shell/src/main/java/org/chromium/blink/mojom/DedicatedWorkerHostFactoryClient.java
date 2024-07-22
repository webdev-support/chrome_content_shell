package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

public interface DedicatedWorkerHostFactoryClient extends Interface {
  public static final Interface.Manager<DedicatedWorkerHostFactoryClient, Proxy> MANAGER =
      DedicatedWorkerHostFactoryClient_Internal.MANAGER;

  public interface Proxy extends DedicatedWorkerHostFactoryClient, Interface.Proxy {}

  void onScriptLoadStartFailed();

  void onScriptLoadStarted(
      ServiceWorkerContainerInfoForClient serviceWorkerContainerInfoForClient,
      WorkerMainScriptLoadParams workerMainScriptLoadParams,
      UrlLoaderFactoryBundle urlLoaderFactoryBundle,
      InterfaceRequest<SubresourceLoaderUpdater> interfaceRequest,
      ControllerServiceWorkerInfo controllerServiceWorkerInfo,
      BackForwardCacheControllerHost backForwardCacheControllerHost);

  void onWorkerHostCreated(
      BrowserInterfaceBroker browserInterfaceBroker, DedicatedWorkerHost dedicatedWorkerHost);
}
