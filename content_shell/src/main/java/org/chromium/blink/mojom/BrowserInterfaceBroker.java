package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.GenericPendingReceiver;

public interface BrowserInterfaceBroker extends Interface {
  public static final Interface.Manager<BrowserInterfaceBroker, Proxy> MANAGER =
      BrowserInterfaceBroker_Internal.MANAGER;

  public interface Proxy extends BrowserInterfaceBroker, Interface.Proxy {}

  void getInterface(GenericPendingReceiver genericPendingReceiver);
}
