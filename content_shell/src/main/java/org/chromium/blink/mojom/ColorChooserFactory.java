package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

public interface ColorChooserFactory extends Interface {
  public static final Interface.Manager<ColorChooserFactory, Proxy> MANAGER =
      ColorChooserFactory_Internal.MANAGER;

  public interface Proxy extends ColorChooserFactory, Interface.Proxy {}

  void openColorChooser(
      InterfaceRequest<ColorChooser> interfaceRequest,
      ColorChooserClient colorChooserClient,
      int i,
      ColorSuggestion[] colorSuggestionArr);
}
