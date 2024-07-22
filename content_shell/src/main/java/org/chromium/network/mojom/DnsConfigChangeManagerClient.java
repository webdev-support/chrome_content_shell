package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;

public interface DnsConfigChangeManagerClient extends Interface {
  public static final Interface.Manager<DnsConfigChangeManagerClient, Proxy> MANAGER =
      DnsConfigChangeManagerClient_Internal.MANAGER;

  public interface Proxy extends DnsConfigChangeManagerClient, Interface.Proxy {}

  void onDnsConfigChanged();
}
