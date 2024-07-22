package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface RemoteObjectGateway extends Interface {
  public static final Interface.Manager<RemoteObjectGateway, Proxy> MANAGER =
      RemoteObjectGateway_Internal.MANAGER;

  public interface Proxy extends RemoteObjectGateway, Interface.Proxy {}

  void addNamedObject(String str, int i);

  void removeNamedObject(String str);
}
