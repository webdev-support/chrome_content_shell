package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface InstallationService extends Interface {
  public static final Interface.Manager<InstallationService, Proxy> MANAGER =
      InstallationService_Internal.MANAGER;

  public interface Proxy extends InstallationService, Interface.Proxy {}

  void onInstall();
}
