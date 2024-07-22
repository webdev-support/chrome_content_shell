package org.chromium.mojo_base.mojom;

import org.chromium.mojo.bindings.Interface;

public interface Binder extends Interface {
  public static final Interface.Manager<Binder, Proxy> MANAGER = Binder_Internal.MANAGER;

  public interface Proxy extends Binder, Interface.Proxy {}

  void bind(GenericPendingReceiver genericPendingReceiver);
}
