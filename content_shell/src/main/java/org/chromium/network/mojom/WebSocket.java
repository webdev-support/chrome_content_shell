package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;

public interface WebSocket extends Interface {
  public static final Interface.Manager<WebSocket, Proxy> MANAGER = WebSocket_Internal.MANAGER;

  public interface Proxy extends WebSocket, Interface.Proxy {}

  void sendMessage(int i, long j);

  void startClosingHandshake(short s, String str);

  void startReceiving();
}
