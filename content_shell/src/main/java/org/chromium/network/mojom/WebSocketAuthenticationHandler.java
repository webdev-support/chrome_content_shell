package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;

public interface WebSocketAuthenticationHandler extends Interface {
  public static final Interface.Manager<WebSocketAuthenticationHandler, Proxy> MANAGER =
      WebSocketAuthenticationHandler_Internal.MANAGER;

  public interface OnAuthRequired_Response {
    void call(AuthCredentials authCredentials);
  }

  public interface Proxy extends WebSocketAuthenticationHandler, Interface.Proxy {}

  void onAuthRequired(
      AuthChallengeInfo authChallengeInfo,
      HttpResponseHeaders httpResponseHeaders,
      IpEndPoint ipEndPoint,
      OnAuthRequired_Response onAuthRequired_Response);
}
