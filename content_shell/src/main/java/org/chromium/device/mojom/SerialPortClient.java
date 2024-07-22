package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;

public interface SerialPortClient extends Interface {
  public static final Interface.Manager<SerialPortClient, Proxy> MANAGER =
      SerialPortClient_Internal.MANAGER;

  public interface Proxy extends SerialPortClient, Interface.Proxy {}

  void onReadError(int i);

  void onSendError(int i);
}
