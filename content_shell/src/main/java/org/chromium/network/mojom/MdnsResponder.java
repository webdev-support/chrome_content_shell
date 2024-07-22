package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;

public interface MdnsResponder extends Interface {
  public static final Interface.Manager<MdnsResponder, Proxy> MANAGER =
      MdnsResponder_Internal.MANAGER;

  public interface CreateNameForAddress_Response {
    void call(String str, boolean z);
  }

  public interface Proxy extends MdnsResponder, Interface.Proxy {}

  public interface RemoveNameForAddress_Response {
    void call(boolean z, boolean z2);
  }

  void createNameForAddress(
      IpAddress ipAddress, CreateNameForAddress_Response createNameForAddress_Response);

  void removeNameForAddress(
      IpAddress ipAddress, RemoveNameForAddress_Response removeNameForAddress_Response);
}
