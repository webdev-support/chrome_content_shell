package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface ServiceWorkerInstalledScriptsManager extends Interface {
  public static final Interface.Manager<ServiceWorkerInstalledScriptsManager, Proxy> MANAGER =
      ServiceWorkerInstalledScriptsManager_Internal.MANAGER;

  public interface Proxy extends ServiceWorkerInstalledScriptsManager, Interface.Proxy {}

  void transferInstalledScript(ServiceWorkerScriptInfo serviceWorkerScriptInfo);
}
