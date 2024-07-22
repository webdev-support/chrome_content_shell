package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface SessionStorageNamespace extends Interface {
  public static final Interface.Manager<SessionStorageNamespace, Proxy> MANAGER =
      SessionStorageNamespace_Internal.MANAGER;

  public interface Proxy extends SessionStorageNamespace, Interface.Proxy {}

  void clone(String str);
}
