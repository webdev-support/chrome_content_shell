package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface PopupMenuClient extends Interface {
  public static final Interface.Manager<PopupMenuClient, Proxy> MANAGER =
      PopupMenuClient_Internal.MANAGER;

  public interface Proxy extends PopupMenuClient, Interface.Proxy {}

  void didAcceptIndices(int[] iArr);

  void didCancel();
}
