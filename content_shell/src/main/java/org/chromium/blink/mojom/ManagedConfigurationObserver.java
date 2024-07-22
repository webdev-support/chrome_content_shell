package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface ManagedConfigurationObserver extends Interface {
  public static final Interface.Manager<ManagedConfigurationObserver, Proxy> MANAGER =
      ManagedConfigurationObserver_Internal.MANAGER;

  public interface Proxy extends ManagedConfigurationObserver, Interface.Proxy {}

  void onConfigurationChanged();
}
