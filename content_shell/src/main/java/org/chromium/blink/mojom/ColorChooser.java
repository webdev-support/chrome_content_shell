package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface ColorChooser extends Interface {
  public static final Interface.Manager<ColorChooser, Proxy> MANAGER =
      ColorChooser_Internal.MANAGER;

  public interface Proxy extends ColorChooser, Interface.Proxy {}

  void setSelectedColor(int i);
}
