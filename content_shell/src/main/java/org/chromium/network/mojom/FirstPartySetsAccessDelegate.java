package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;

public interface FirstPartySetsAccessDelegate extends Interface {
  public static final Interface.Manager<FirstPartySetsAccessDelegate, Proxy> MANAGER =
      FirstPartySetsAccessDelegate_Internal.MANAGER;

  public interface Proxy extends FirstPartySetsAccessDelegate, Interface.Proxy {}

  void notifyReady(FirstPartySetsReadyEvent firstPartySetsReadyEvent);

  void setEnabled(boolean z);
}
