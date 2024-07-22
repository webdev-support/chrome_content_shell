package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
import org.chromium.mojo.bindings.Interface;

public interface DevToolsFrontend extends Interface {
  public static final Interface.Manager<DevToolsFrontend, Proxy> MANAGER =
      DevToolsFrontend_Internal.MANAGER;

  public interface Proxy extends DevToolsFrontend, Interface.Proxy {}

  void setupDevToolsExtensionApi(String str);

  void setupDevToolsFrontend(
      String str, AssociatedInterfaceNotSupported associatedInterfaceNotSupported);
}
