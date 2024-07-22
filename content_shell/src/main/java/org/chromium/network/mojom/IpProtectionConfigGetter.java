package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.Time;

public interface IpProtectionConfigGetter extends Interface {
  public static final Interface.Manager<IpProtectionConfigGetter, Proxy> MANAGER =
      IpProtectionConfigGetter_Internal.MANAGER;

  public interface GetProxyList_Response {
    void call(ProxyChain[] proxyChainArr);
  }

  public interface Proxy extends IpProtectionConfigGetter, Interface.Proxy {}

  public interface TryGetAuthTokens_Response {
    void call(BlindSignedAuthToken[] blindSignedAuthTokenArr, Time time);
  }

  void getProxyList(GetProxyList_Response getProxyList_Response);

  void tryGetAuthTokens(int i, int i2, TryGetAuthTokens_Response tryGetAuthTokens_Response);
}
