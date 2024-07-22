package org.chromium.proxy_resolver.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.network.mojom.IpAddress;

public interface HostResolverRequestClient extends Interface {
  public static final Interface.Manager<HostResolverRequestClient, Proxy> MANAGER =
      HostResolverRequestClient_Internal.MANAGER;

  public interface Proxy extends HostResolverRequestClient, Interface.Proxy {}

  void reportResult(int i, IpAddress[] ipAddressArr);
}
