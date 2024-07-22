package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;

public interface ResolveHostClient extends Interface {
  public static final Interface.Manager<ResolveHostClient, Proxy> MANAGER =
      ResolveHostClient_Internal.MANAGER;

  public interface Proxy extends ResolveHostClient, Interface.Proxy {}

  void onComplete(
      int i,
      ResolveErrorInfo resolveErrorInfo,
      AddressList addressList,
      HostResolverEndpointResult[] hostResolverEndpointResultArr);

  void onHostnameResults(HostPortPair[] hostPortPairArr);

  void onTextResults(String[] strArr);
}
