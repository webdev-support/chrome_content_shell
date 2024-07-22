package org.chromium.viz.mojom;

import org.chromium.mojo.bindings.Interface;

public interface CompositingModeWatcher extends Interface {
  public static final Interface.Manager<CompositingModeWatcher, Proxy> MANAGER =
      CompositingModeWatcher_Internal.MANAGER;

  public interface Proxy extends CompositingModeWatcher, Interface.Proxy {}

  void compositingModeFallbackToSoftware();
}
