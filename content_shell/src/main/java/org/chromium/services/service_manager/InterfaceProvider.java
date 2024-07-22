package org.chromium.services.service_manager;

import org.chromium.mojo.bindings.ConnectionErrorHandler;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.system.Core;
import org.chromium.mojo.system.MessagePipeHandle;
import org.chromium.mojo.system.MojoException;
import org.chromium.mojo.system.Pair;

public class InterfaceProvider implements ConnectionErrorHandler {
  private Core mCore;
  private org.chromium.service_manager.mojom.InterfaceProvider.Proxy mInterfaceProvider;

  public InterfaceProvider(MessagePipeHandle pipe) {
    this.mCore = pipe.getCore();
    org.chromium.service_manager.mojom.InterfaceProvider.Proxy attachProxy =
        org.chromium.service_manager.mojom.InterfaceProvider.MANAGER.attachProxy(pipe, 0);
    this.mInterfaceProvider = attachProxy;
    attachProxy.getProxyHandler().setErrorHandler(this);
  }

  public <I extends Interface> void getInterface(
      Interface.Manager<I, ? extends Interface.Proxy> manager, InterfaceRequest<I> request) {
    this.mInterfaceProvider.getInterface(manager.getName(), request.passHandle());
  }

  public <I extends Interface, P extends Interface.Proxy> P getInterface(
      Interface.Manager<I, P> manager) {
    Pair<P, InterfaceRequest<I>> result = manager.getInterfaceRequest(this.mCore);
    getInterface(manager, result.second);
    return result.first;
  }

  @Override
  public void onConnectionError(MojoException e) {
    this.mInterfaceProvider.close();
  }
}
