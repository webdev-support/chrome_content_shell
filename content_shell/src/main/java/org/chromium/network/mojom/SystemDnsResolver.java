package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;

public interface SystemDnsResolver extends Interface {
  public static final Interface.Manager<SystemDnsResolver, Proxy> MANAGER =
      SystemDnsResolver_Internal.MANAGER;

  public interface Proxy extends SystemDnsResolver, Interface.Proxy {}

  public interface Resolve_Response {
    void call(AddressList addressList, int i, int i2);
  }

  void resolve(String str, int i, int i2, long j, Resolve_Response resolve_Response);
}
