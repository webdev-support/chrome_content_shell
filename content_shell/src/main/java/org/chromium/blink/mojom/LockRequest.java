package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
import org.chromium.mojo.bindings.Interface;

public interface LockRequest extends Interface {
  public static final Interface.Manager<LockRequest, Proxy> MANAGER = LockRequest_Internal.MANAGER;

  public interface Proxy extends LockRequest, Interface.Proxy {}

  void failed();

  void granted(AssociatedInterfaceNotSupported associatedInterfaceNotSupported);
}
