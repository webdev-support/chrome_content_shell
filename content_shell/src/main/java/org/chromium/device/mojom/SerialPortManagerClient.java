package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;

public interface SerialPortManagerClient extends Interface {
  public static final Interface.Manager<SerialPortManagerClient, Proxy> MANAGER =
      SerialPortManagerClient_Internal.MANAGER;

  public interface Proxy extends SerialPortManagerClient, Interface.Proxy {}

  void onPortAdded(SerialPortInfo serialPortInfo);

  void onPortRemoved(SerialPortInfo serialPortInfo);
}
