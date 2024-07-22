package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;

public interface SerialPortConnectionWatcher extends Interface {
  public static final Interface.Manager<SerialPortConnectionWatcher, Proxy> MANAGER =
      SerialPortConnectionWatcher_Internal.MANAGER;

  public interface Proxy extends SerialPortConnectionWatcher, Interface.Proxy {}
}
