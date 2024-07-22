package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.system.DataPipe;
import org.chromium.url.mojom.Url;

public interface ProxyResolvingSocketFactory extends Interface {
  public static final Interface.Manager<ProxyResolvingSocketFactory, Proxy> MANAGER =
      ProxyResolvingSocketFactory_Internal.MANAGER;

  public interface CreateProxyResolvingSocket_Response {
    void call(
        int i,
        IpEndPoint ipEndPoint,
        IpEndPoint ipEndPoint2,
        DataPipe.ConsumerHandle consumerHandle,
        DataPipe.ProducerHandle producerHandle);
  }

  public interface Proxy extends ProxyResolvingSocketFactory, Interface.Proxy {}

  void createProxyResolvingSocket(
      Url url,
      NetworkAnonymizationKey networkAnonymizationKey,
      ProxyResolvingSocketOptions proxyResolvingSocketOptions,
      MutableNetworkTrafficAnnotationTag mutableNetworkTrafficAnnotationTag,
      InterfaceRequest<ProxyResolvingSocket> interfaceRequest,
      SocketObserver socketObserver,
      CreateProxyResolvingSocket_Response createProxyResolvingSocket_Response);
}
