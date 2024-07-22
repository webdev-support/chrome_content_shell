package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.system.DataPipe;

public interface TcpBoundSocket extends Interface {
  public static final Interface.Manager<TcpBoundSocket, Proxy> MANAGER =
      TcpBoundSocket_Internal.MANAGER;

  public interface Connect_Response {
    void call(
        int i,
        IpEndPoint ipEndPoint,
        IpEndPoint ipEndPoint2,
        DataPipe.ConsumerHandle consumerHandle,
        DataPipe.ProducerHandle producerHandle);
  }

  public interface Listen_Response {
    void call(int i);
  }

  public interface Proxy extends TcpBoundSocket, Interface.Proxy {}

  void connect(
      AddressList addressList,
      TcpConnectedSocketOptions tcpConnectedSocketOptions,
      InterfaceRequest<TcpConnectedSocket> interfaceRequest,
      SocketObserver socketObserver,
      Connect_Response connect_Response);

  void listen(
      int i, InterfaceRequest<TcpServerSocket> interfaceRequest, Listen_Response listen_Response);
}
