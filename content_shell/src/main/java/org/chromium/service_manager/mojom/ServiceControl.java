package org.chromium.service_manager.mojom;

import org.chromium.mojo.bindings.Interface;

public interface ServiceControl extends Interface {
  public static final Interface.Manager<ServiceControl, Proxy> MANAGER =
      ServiceControl_Internal.MANAGER;

  public interface Proxy extends ServiceControl, Interface.Proxy {}

  void requestQuit();
}
