package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;

public interface HostResolver extends Interface {
  public static final Interface.Manager<HostResolver, Proxy> MANAGER =
      HostResolver_Internal.MANAGER;

  public interface MdnsListen_Response {
    void call(int i);
  }

  public interface Proxy extends HostResolver, Interface.Proxy {}

  void mdnsListen(
      HostPortPair hostPortPair,
      int i,
      MdnsListenClient mdnsListenClient,
      MdnsListen_Response mdnsListen_Response);

  void resolveHost(
      HostResolverHost hostResolverHost,
      NetworkAnonymizationKey networkAnonymizationKey,
      ResolveHostParameters resolveHostParameters,
      ResolveHostClient resolveHostClient);
}
