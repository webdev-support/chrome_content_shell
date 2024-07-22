package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;

public interface SocketBroker extends Interface {
  public static final Interface.Manager<SocketBroker, Proxy> MANAGER =
      SocketBroker_Internal.MANAGER;

  public interface CreateTcpSocket_Response {
    void call(TransferableSocket transferableSocket, int i);
  }

  public interface CreateUdpSocket_Response {
    void call(TransferableSocket transferableSocket, int i);
  }

  public interface Proxy extends SocketBroker, Interface.Proxy {}

  void createTcpSocket(int i, CreateTcpSocket_Response createTcpSocket_Response);

  void createUdpSocket(int i, CreateUdpSocket_Response createUdpSocket_Response);
}
