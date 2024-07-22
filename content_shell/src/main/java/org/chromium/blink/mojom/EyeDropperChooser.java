package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface EyeDropperChooser extends Interface {
  public static final Interface.Manager<EyeDropperChooser, Proxy> MANAGER =
      EyeDropperChooser_Internal.MANAGER;

  public interface Choose_Response {
    void call(boolean z, int i);
  }

  public interface Proxy extends EyeDropperChooser, Interface.Proxy {}

  void choose(Choose_Response choose_Response);
}
