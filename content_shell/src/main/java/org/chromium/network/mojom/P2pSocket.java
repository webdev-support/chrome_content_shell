package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.ReadOnlyBuffer;

public interface P2pSocket extends Interface {
  public static final Interface.Manager<P2pSocket, Proxy> MANAGER = P2pSocket_Internal.MANAGER;

  public interface Proxy extends P2pSocket, Interface.Proxy {}

  void send(ReadOnlyBuffer readOnlyBuffer, P2pPacketInfo p2pPacketInfo);

  void sendBatch(P2pSendPacket[] p2pSendPacketArr);

  void setOption(int i, int i2);
}
