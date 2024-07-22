package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

public interface RemoteObjectHost extends Interface {
  public static final Interface.Manager<RemoteObjectHost, Proxy> MANAGER =
      RemoteObjectHost_Internal.MANAGER;

  public interface Proxy extends RemoteObjectHost, Interface.Proxy {}

  void acquireObject(int i);

  void getObject(int i, InterfaceRequest<RemoteObject> interfaceRequest);

  void releaseObject(int i);
}
