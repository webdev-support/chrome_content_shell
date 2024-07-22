package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface BroadcastChannelClient extends Interface {
  public static final Interface.Manager<BroadcastChannelClient, Proxy> MANAGER =
      BroadcastChannelClient_Internal.MANAGER;

  public interface Proxy extends BroadcastChannelClient, Interface.Proxy {}

  void onMessage(CloneableMessage cloneableMessage);
}
