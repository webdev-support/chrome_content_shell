package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;

public interface DnsConfigChangeManager extends Interface {
  public static final Interface.Manager<DnsConfigChangeManager, Proxy> MANAGER =
      DnsConfigChangeManager_Internal.MANAGER;

  public interface Proxy extends DnsConfigChangeManager, Interface.Proxy {}

  void requestNotifications(DnsConfigChangeManagerClient dnsConfigChangeManagerClient);
}
