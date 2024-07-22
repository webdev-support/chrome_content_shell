package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;

public interface P2pSocketClient extends Interface {
  public static final Interface.Manager<P2pSocketClient, Proxy> MANAGER =
      P2pSocketClient_Internal.MANAGER;

  public interface Proxy extends P2pSocketClient, Interface.Proxy {}

  void dataReceived(P2pReceivedPacket[] p2pReceivedPacketArr);

  void sendBatchComplete(P2pSendPacketMetrics[] p2pSendPacketMetricsArr);

  void sendComplete(P2pSendPacketMetrics p2pSendPacketMetrics);

  void socketCreated(IpEndPoint ipEndPoint, IpEndPoint ipEndPoint2);
}
