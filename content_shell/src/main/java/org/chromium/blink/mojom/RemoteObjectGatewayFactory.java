package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

public interface RemoteObjectGatewayFactory extends Interface {
  public static final Interface.Manager<RemoteObjectGatewayFactory, Proxy> MANAGER =
      RemoteObjectGatewayFactory_Internal.MANAGER;

  public interface Proxy extends RemoteObjectGatewayFactory, Interface.Proxy {}

  void createRemoteObjectGateway(
      RemoteObjectHost remoteObjectHost, InterfaceRequest<RemoteObjectGateway> interfaceRequest);
}
