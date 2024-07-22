package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;

public interface HidConnectionWatcher extends Interface {
  public static final Interface.Manager<HidConnectionWatcher, Proxy> MANAGER =
      HidConnectionWatcher_Internal.MANAGER;

  public interface Proxy extends HidConnectionWatcher, Interface.Proxy {}
}
