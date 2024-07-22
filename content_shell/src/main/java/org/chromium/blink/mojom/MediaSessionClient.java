package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface MediaSessionClient extends Interface {
  public static final Interface.Manager<MediaSessionClient, Proxy> MANAGER =
      MediaSessionClient_Internal.MANAGER;

  public interface Proxy extends MediaSessionClient, Interface.Proxy {}

  void didReceiveAction(int i, MediaSessionActionDetails mediaSessionActionDetails);
}
