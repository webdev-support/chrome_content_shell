package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.network.mojom.CrossOriginEmbedderPolicy;
import org.chromium.url.mojom.Url;

public interface DedicatedWorkerHostFactory extends Interface {
  public static final Interface.Manager<DedicatedWorkerHostFactory, Proxy> MANAGER =
      DedicatedWorkerHostFactory_Internal.MANAGER;

  public interface CreateWorkerHost_Response {
    void call(
        CrossOriginEmbedderPolicy crossOriginEmbedderPolicy,
        BackForwardCacheControllerHost backForwardCacheControllerHost);
  }

  public interface Proxy extends DedicatedWorkerHostFactory, Interface.Proxy {}

  void createWorkerHost(
      DedicatedWorkerToken dedicatedWorkerToken,
      Url url,
      InterfaceRequest<BrowserInterfaceBroker> interfaceRequest,
      InterfaceRequest<DedicatedWorkerHost> interfaceRequest2,
      CreateWorkerHost_Response createWorkerHost_Response);

  void createWorkerHostAndStartScriptLoad(
      DedicatedWorkerToken dedicatedWorkerToken,
      Url url,
      int i,
      FetchClientSettingsObject fetchClientSettingsObject,
      BlobUrlToken blobUrlToken,
      DedicatedWorkerHostFactoryClient dedicatedWorkerHostFactoryClient,
      boolean z);
}
