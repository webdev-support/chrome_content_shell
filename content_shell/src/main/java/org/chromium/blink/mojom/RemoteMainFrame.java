package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface RemoteMainFrame extends Interface {
  public static final Interface.Manager<RemoteMainFrame, Proxy> MANAGER =
      RemoteMainFrame_Internal.MANAGER;

  public interface Proxy extends RemoteMainFrame, Interface.Proxy {}

  void updateTextAutosizerPageInfo(TextAutosizerPageInfo textAutosizerPageInfo);
}
