package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.url.mojom.Url;

public interface TrustedHeaderClient extends Interface {
  public static final Interface.Manager<TrustedHeaderClient, Proxy> MANAGER =
      TrustedHeaderClient_Internal.MANAGER;

  public interface OnBeforeSendHeaders_Response {
    void call(int i, HttpRequestHeaders httpRequestHeaders);
  }

  public interface OnHeadersReceived_Response {
    void call(int i, String str, Url url);
  }

  public interface Proxy extends TrustedHeaderClient, Interface.Proxy {}

  void onBeforeSendHeaders(
      HttpRequestHeaders httpRequestHeaders,
      OnBeforeSendHeaders_Response onBeforeSendHeaders_Response);

  void onHeadersReceived(
      String str, IpEndPoint ipEndPoint, OnHeadersReceived_Response onHeadersReceived_Response);
}
