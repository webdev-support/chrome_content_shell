package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.url.mojom.Url;

public interface ServiceWorkerInstalledScriptsManagerHost extends Interface {
  public static final Interface.Manager<ServiceWorkerInstalledScriptsManagerHost, Proxy> MANAGER =
      ServiceWorkerInstalledScriptsManagerHost_Internal.MANAGER;

  public interface Proxy extends ServiceWorkerInstalledScriptsManagerHost, Interface.Proxy {}

  void requestInstalledScript(Url url);
}
