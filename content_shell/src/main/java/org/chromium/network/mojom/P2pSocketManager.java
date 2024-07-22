package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo_base.mojom.UnguessableToken;

public interface P2pSocketManager extends Interface {
  public static final Interface.Manager<P2pSocketManager, Proxy> MANAGER =
      P2pSocketManager_Internal.MANAGER;

  public interface GetHostAddressWithFamily_Response {
    void call(IpAddress[] ipAddressArr);
  }

  public interface GetHostAddress_Response {
    void call(IpAddress[] ipAddressArr);
  }

  public interface Proxy extends P2pSocketManager, Interface.Proxy {}

  void createSocket(
      int i,
      IpEndPoint ipEndPoint,
      P2pPortRange p2pPortRange,
      P2pHostAndIpEndPoint p2pHostAndIpEndPoint,
      MutableNetworkTrafficAnnotationTag mutableNetworkTrafficAnnotationTag,
      UnguessableToken unguessableToken,
      P2pSocketClient p2pSocketClient,
      InterfaceRequest<P2pSocket> interfaceRequest);

  void getHostAddress(String str, boolean z, GetHostAddress_Response getHostAddress_Response);

  void getHostAddressWithFamily(
      String str,
      int i,
      boolean z,
      GetHostAddressWithFamily_Response getHostAddressWithFamily_Response);

  void startNetworkNotifications(P2pNetworkNotificationClient p2pNetworkNotificationClient);
}
