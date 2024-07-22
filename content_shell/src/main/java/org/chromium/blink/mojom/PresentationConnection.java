package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface PresentationConnection extends Interface {
  public static final Interface.Manager<PresentationConnection, Proxy> MANAGER =
      PresentationConnection_Internal.MANAGER;

  public interface Proxy extends PresentationConnection, Interface.Proxy {}

  void didChangeState(int i);

  void didClose(int i);

  void onMessage(PresentationConnectionMessage presentationConnectionMessage);
}
