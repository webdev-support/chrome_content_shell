package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.system.DataPipe;

public interface WebSocketHandshakeClient extends Interface {
  public static final Interface.Manager<WebSocketHandshakeClient, Proxy> MANAGER =
      WebSocketHandshakeClient_Internal.MANAGER;

  public interface Proxy extends WebSocketHandshakeClient, Interface.Proxy {}

  void onConnectionEstablished(
      WebSocket webSocket,
      InterfaceRequest<WebSocketClient> interfaceRequest,
      WebSocketHandshakeResponse webSocketHandshakeResponse,
      DataPipe.ConsumerHandle consumerHandle,
      DataPipe.ProducerHandle producerHandle);

  void onFailure(String str, int i, int i2);

  void onOpeningHandshakeStarted(WebSocketHandshakeRequest webSocketHandshakeRequest);
}
