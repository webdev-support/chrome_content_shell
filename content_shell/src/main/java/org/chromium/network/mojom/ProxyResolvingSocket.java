package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.system.DataPipe;

public interface ProxyResolvingSocket extends Interface {
  public static final Interface.Manager<ProxyResolvingSocket, Proxy> MANAGER =
      ProxyResolvingSocket_Internal.MANAGER;

  public interface Proxy extends ProxyResolvingSocket, Interface.Proxy {}

  public interface UpgradeToTls_Response {
    void call(
        int i, DataPipe.ConsumerHandle consumerHandle, DataPipe.ProducerHandle producerHandle);
  }

  void upgradeToTls(
      HostPortPair hostPortPair,
      MutableNetworkTrafficAnnotationTag mutableNetworkTrafficAnnotationTag,
      InterfaceRequest<TlsClientSocket> interfaceRequest,
      SocketObserver socketObserver,
      UpgradeToTls_Response upgradeToTls_Response);
}
