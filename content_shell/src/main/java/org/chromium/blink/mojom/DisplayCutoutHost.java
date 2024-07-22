package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface DisplayCutoutHost extends Interface {
  public static final Interface.Manager<DisplayCutoutHost, Proxy> MANAGER =
      DisplayCutoutHost_Internal.MANAGER;

  public interface Proxy extends DisplayCutoutHost, Interface.Proxy {}

  void notifyViewportFitChanged(int i);
}
