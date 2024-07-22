package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
import org.chromium.mojo.bindings.AssociatedInterfaceRequestNotSupported;
import org.chromium.mojo.bindings.Interface;

public interface BroadcastChannelProvider extends Interface {
  public static final Interface.Manager<BroadcastChannelProvider, Proxy> MANAGER =
      BroadcastChannelProvider_Internal.MANAGER;

  public interface Proxy extends BroadcastChannelProvider, Interface.Proxy {}

  void connectToChannel(
      String str,
      AssociatedInterfaceNotSupported associatedInterfaceNotSupported,
      AssociatedInterfaceRequestNotSupported associatedInterfaceRequestNotSupported);
}
