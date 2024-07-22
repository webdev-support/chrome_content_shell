package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.ReadOnlyBuffer;

public interface RestrictedUdpSocket extends Interface {
  public static final Interface.Manager<RestrictedUdpSocket, Proxy> MANAGER =
      RestrictedUdpSocket_Internal.MANAGER;

  public interface Proxy extends RestrictedUdpSocket, Interface.Proxy {}

  public interface SendTo_Response {
    void call(int i);
  }

  public interface Send_Response {
    void call(int i);
  }

  void receiveMore(int i);

  void send(ReadOnlyBuffer readOnlyBuffer, Send_Response send_Response);

  void sendTo(
      ReadOnlyBuffer readOnlyBuffer,
      HostPortPair hostPortPair,
      int i,
      SendTo_Response sendTo_Response);
}
