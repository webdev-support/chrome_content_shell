package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.system.DataPipe;

public interface TcpConnectedSocket extends Interface {
  public static final Interface.Manager<TcpConnectedSocket, Proxy> MANAGER =
      TcpConnectedSocket_Internal.MANAGER;

  public interface Proxy extends TcpConnectedSocket, Interface.Proxy {}

  public interface SetKeepAlive_Response {
    void call(boolean z);
  }

  public interface SetNoDelay_Response {
    void call(boolean z);
  }

  public interface SetReceiveBufferSize_Response {
    void call(int i);
  }

  public interface SetSendBufferSize_Response {
    void call(int i);
  }

  public interface UpgradeToTls_Response {
    void call(
        int i,
        DataPipe.ConsumerHandle consumerHandle,
        DataPipe.ProducerHandle producerHandle,
        SslInfo sslInfo);
  }

  void setKeepAlive(boolean z, int i, SetKeepAlive_Response setKeepAlive_Response);

  void setNoDelay(boolean z, SetNoDelay_Response setNoDelay_Response);

  void setReceiveBufferSize(int i, SetReceiveBufferSize_Response setReceiveBufferSize_Response);

  void setSendBufferSize(int i, SetSendBufferSize_Response setSendBufferSize_Response);

  void upgradeToTls(
      HostPortPair hostPortPair,
      TlsClientSocketOptions tlsClientSocketOptions,
      MutableNetworkTrafficAnnotationTag mutableNetworkTrafficAnnotationTag,
      InterfaceRequest<TlsClientSocket> interfaceRequest,
      SocketObserver socketObserver,
      UpgradeToTls_Response upgradeToTls_Response);
}
