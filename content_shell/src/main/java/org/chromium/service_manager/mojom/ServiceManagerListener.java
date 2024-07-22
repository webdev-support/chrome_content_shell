package org.chromium.service_manager.mojom;

import org.chromium.mojo.bindings.Interface;

public interface ServiceManagerListener extends Interface {
  public static final Interface.Manager<ServiceManagerListener, Proxy> MANAGER =
      ServiceManagerListener_Internal.MANAGER;

  public interface Proxy extends ServiceManagerListener, Interface.Proxy {}

  void onInit(RunningServiceInfo[] runningServiceInfoArr);

  void onServiceCreated(RunningServiceInfo runningServiceInfo);

  void onServiceFailedToStart(Identity identity);

  void onServicePidReceived(Identity identity, int i);

  void onServiceStarted(Identity identity, int i);

  void onServiceStopped(Identity identity);
}
