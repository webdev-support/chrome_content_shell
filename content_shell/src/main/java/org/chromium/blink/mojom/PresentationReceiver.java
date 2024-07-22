package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface PresentationReceiver extends Interface {
  public static final Interface.Manager<PresentationReceiver, Proxy> MANAGER =
      PresentationReceiver_Internal.MANAGER;

  public interface Proxy extends PresentationReceiver, Interface.Proxy {}

  void onReceiverConnectionAvailable(PresentationConnectionResult presentationConnectionResult);
}
