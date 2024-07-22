package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.url.internal.mojom.Origin;

public interface AcceptChFrameObserver extends Interface {
  public static final Interface.Manager<AcceptChFrameObserver, Proxy> MANAGER =
      AcceptChFrameObserver_Internal.MANAGER;

  public interface OnAcceptChFrameReceived_Response {
    void call(int i);
  }

  public interface Proxy extends AcceptChFrameObserver, Interface.Proxy {}

  void clone(InterfaceRequest<AcceptChFrameObserver> interfaceRequest);

  void onAcceptChFrameReceived(
      Origin origin, int[] iArr, OnAcceptChFrameReceived_Response onAcceptChFrameReceived_Response);
}
