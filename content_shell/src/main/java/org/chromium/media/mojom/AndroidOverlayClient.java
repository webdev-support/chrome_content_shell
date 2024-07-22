package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;

public interface AndroidOverlayClient extends Interface {
  public static final Manager<AndroidOverlayClient, Proxy> MANAGER =
      AndroidOverlayClient_Internal.MANAGER;

  public interface OnSynchronouslyDestroyed_Response {
    void call();
  }

  public interface Proxy extends AndroidOverlayClient, Interface.Proxy {}

  void onDestroyed();

  void onPowerEfficientState(boolean z);

  void onSurfaceReady(long j);

  void onSynchronouslyDestroyed(
      OnSynchronouslyDestroyed_Response onSynchronouslyDestroyed_Response);
}
