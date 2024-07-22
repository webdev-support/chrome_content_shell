package org.chromium.service_manager.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.system.MessagePipeHandle;

public interface InterfaceProvider extends Interface {
  public static final Interface.Manager<InterfaceProvider, Proxy> MANAGER =
      InterfaceProvider_Internal.MANAGER;

  public interface Proxy extends InterfaceProvider, Interface.Proxy {}

  void getInterface(String str, MessagePipeHandle messagePipeHandle);
}
