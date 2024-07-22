package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

public interface KeepAliveHandleFactory extends Interface {
  public static final Interface.Manager<KeepAliveHandleFactory, Proxy> MANAGER =
      KeepAliveHandleFactory_Internal.MANAGER;

  public interface Proxy extends KeepAliveHandleFactory, Interface.Proxy {}

  void issueKeepAliveHandle(InterfaceRequest<KeepAliveHandle> interfaceRequest);
}
