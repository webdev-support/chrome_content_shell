package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.system.DataPipe;

public interface TcpServerSocket extends Interface {
  public static final Interface.Manager<TcpServerSocket, Proxy> MANAGER =
      TcpServerSocket_Internal.MANAGER;

  public interface Accept_Response {
    void call(
        int i,
        IpEndPoint ipEndPoint,
        TcpConnectedSocket tcpConnectedSocket,
        DataPipe.ConsumerHandle consumerHandle,
        DataPipe.ProducerHandle producerHandle);
  }

  public interface Proxy extends TcpServerSocket, Interface.Proxy {}

  void accept(SocketObserver socketObserver, Accept_Response accept_Response);
}
