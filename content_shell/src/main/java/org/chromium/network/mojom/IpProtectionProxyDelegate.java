package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.Time;

public interface IpProtectionProxyDelegate extends Interface {
  public static final Interface.Manager<IpProtectionProxyDelegate, Proxy> MANAGER =
      IpProtectionProxyDelegate_Internal.MANAGER;

  public interface IsIpProtectionEnabledForTesting_Response {
    void call(boolean z);
  }

  public interface Proxy extends IpProtectionProxyDelegate, Interface.Proxy {}

  public interface VerifyIpProtectionConfigGetterForTesting_Response {
    void call(BlindSignedAuthToken blindSignedAuthToken, Time time);
  }

  void invalidateIpProtectionConfigCacheTryAgainAfterTime();

  void isIpProtectionEnabledForTesting(
      IsIpProtectionEnabledForTesting_Response isIpProtectionEnabledForTesting_Response);

  void setIpProtectionEnabled(boolean z);

  void verifyIpProtectionConfigGetterForTesting(
      VerifyIpProtectionConfigGetterForTesting_Response
          verifyIpProtectionConfigGetterForTesting_Response);
}
