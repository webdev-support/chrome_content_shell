package org.chromium.viz.mojom;

import org.chromium.mojo.bindings.Interface;

public interface CompositingModeReporter extends Interface {
  public static final Interface.Manager<CompositingModeReporter, Proxy> MANAGER =
      CompositingModeReporter_Internal.MANAGER;

  public interface Proxy extends CompositingModeReporter, Interface.Proxy {}

  void addCompositingModeWatcher(CompositingModeWatcher compositingModeWatcher);
}
