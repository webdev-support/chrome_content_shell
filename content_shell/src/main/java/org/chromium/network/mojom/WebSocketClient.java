package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;

public interface WebSocketClient extends Interface {
  public static final Interface.Manager<WebSocketClient, Proxy> MANAGER =
      WebSocketClient_Internal.MANAGER;

  public interface Proxy extends WebSocketClient, Interface.Proxy {}

  void onClosingHandshake();

  void onDataFrame(boolean z, int i, long j);

  void onDropChannel(boolean z, short s, String str);
}
