package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.url.mojom.Url;

public interface PresentationController extends Interface {
  public static final Interface.Manager<PresentationController, Proxy> MANAGER =
      PresentationController_Internal.MANAGER;

  public interface Proxy extends PresentationController, Interface.Proxy {}

  void onConnectionClosed(PresentationInfo presentationInfo, int i, String str);

  void onConnectionStateChanged(PresentationInfo presentationInfo, int i);

  void onDefaultPresentationStarted(PresentationConnectionResult presentationConnectionResult);

  void onScreenAvailabilityUpdated(Url url, int i);
}
