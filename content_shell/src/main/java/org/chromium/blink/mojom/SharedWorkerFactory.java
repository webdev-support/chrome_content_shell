package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo_base.mojom.UnguessableToken;

public interface SharedWorkerFactory extends Interface {
  public static final Interface.Manager<SharedWorkerFactory, Proxy> MANAGER =
      SharedWorkerFactory_Internal.MANAGER;

  public interface Proxy extends SharedWorkerFactory, Interface.Proxy {}

  void createSharedWorker(
      SharedWorkerInfo sharedWorkerInfo,
      SharedWorkerToken sharedWorkerToken,
      StorageKey storageKey,
      boolean z,
      String str,
      UserAgentMetadata userAgentMetadata,
      boolean z2,
      UnguessableToken unguessableToken,
      RendererPreferences rendererPreferences,
      InterfaceRequest<RendererPreferenceWatcher> interfaceRequest,
      WorkerContentSettingsProxy workerContentSettingsProxy,
      ServiceWorkerContainerInfoForClient serviceWorkerContainerInfoForClient,
      WorkerMainScriptLoadParams workerMainScriptLoadParams,
      UrlLoaderFactoryBundle urlLoaderFactoryBundle,
      ControllerServiceWorkerInfo controllerServiceWorkerInfo,
      PolicyContainer policyContainer,
      SharedWorkerHost sharedWorkerHost,
      InterfaceRequest<SharedWorker> interfaceRequest2,
      BrowserInterfaceBroker browserInterfaceBroker,
      long j,
      boolean z3);
}
