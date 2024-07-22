package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface ColorChooserClient extends Interface {
  public static final Interface.Manager<ColorChooserClient, Proxy> MANAGER =
      ColorChooserClient_Internal.MANAGER;

  public interface Proxy extends ColorChooserClient, Interface.Proxy {}

  void didChooseColor(int i);
}
