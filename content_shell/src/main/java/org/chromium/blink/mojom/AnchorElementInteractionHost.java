package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.url.mojom.Url;

public interface AnchorElementInteractionHost extends Interface {
  public static final Interface.Manager<AnchorElementInteractionHost, Proxy> MANAGER =
      AnchorElementInteractionHost_Internal.MANAGER;

  public interface Proxy extends AnchorElementInteractionHost, Interface.Proxy {}

  void onPointerDown(Url url);

  void onPointerHover(Url url, AnchorElementPointerData anchorElementPointerData);
}
