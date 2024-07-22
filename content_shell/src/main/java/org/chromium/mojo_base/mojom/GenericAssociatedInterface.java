package org.chromium.mojo_base.mojom;

import org.chromium.mojo.bindings.Interface;

public interface GenericAssociatedInterface extends Interface {
  public static final Interface.Manager<GenericAssociatedInterface, Proxy> MANAGER =
      GenericAssociatedInterface_Internal.MANAGER;

  public interface Proxy extends GenericAssociatedInterface, Interface.Proxy {}
}
