package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.AssociatedInterfaceRequestNotSupported;
import org.chromium.mojo.bindings.Interface;

public interface AssociatedInterfaceProvider extends Interface {
  public static final Interface.Manager<AssociatedInterfaceProvider, Proxy> MANAGER =
      AssociatedInterfaceProvider_Internal.MANAGER;

  public interface Proxy extends AssociatedInterfaceProvider, Interface.Proxy {}

  void getAssociatedInterface(
      String str, AssociatedInterfaceRequestNotSupported associatedInterfaceRequestNotSupported);
}
