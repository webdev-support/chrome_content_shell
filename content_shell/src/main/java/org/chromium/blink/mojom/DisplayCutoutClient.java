package org.chromium.blink.mojom;

import org.chromium.gfx.mojom.Insets;
import org.chromium.mojo.bindings.Interface;

public interface DisplayCutoutClient extends Interface {
  public static final Interface.Manager<DisplayCutoutClient, Proxy> MANAGER =
      DisplayCutoutClient_Internal.MANAGER;

  public interface Proxy extends DisplayCutoutClient, Interface.Proxy {}

  void setSafeArea(Insets insets);
}
