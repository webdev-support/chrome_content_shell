package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.url.mojom.Url;

public interface ContextMenuClient extends Interface {
  public static final Interface.Manager<ContextMenuClient, Proxy> MANAGER =
      ContextMenuClient_Internal.MANAGER;

  public interface Proxy extends ContextMenuClient, Interface.Proxy {}

  void contextMenuClosed(Url url);

  void customContextMenuAction(int i);
}
