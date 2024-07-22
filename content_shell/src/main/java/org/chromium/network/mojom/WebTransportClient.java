package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.ReadOnlyBuffer;

public interface WebTransportClient extends Interface {
  public static final Interface.Manager<WebTransportClient, Proxy> MANAGER =
      WebTransportClient_Internal.MANAGER;

  public interface Proxy extends WebTransportClient, Interface.Proxy {}

  void onClosed(WebTransportCloseInfo webTransportCloseInfo, WebTransportStats webTransportStats);

  void onDatagramReceived(ReadOnlyBuffer readOnlyBuffer);

  void onIncomingStreamClosed(int i, boolean z);

  void onOutgoingStreamClosed(int i);

  void onReceivedResetStream(int i, int i2);

  void onReceivedStopSending(int i, int i2);
}
