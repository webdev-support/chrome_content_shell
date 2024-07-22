package org.chromium.service_manager.mojom;

import org.chromium.mojo.bindings.Interface;

public interface ServiceManager extends Interface {
  public static final Interface.Manager<ServiceManager, Proxy> MANAGER =
      ServiceManager_Internal.MANAGER;

  public interface Proxy extends ServiceManager, Interface.Proxy {}

  void addListener(ServiceManagerListener serviceManagerListener);
}
