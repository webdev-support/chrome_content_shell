package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.UnguessableToken;

public interface SerialPortManager extends Interface {
  public static final Interface.Manager<SerialPortManager, Proxy> MANAGER =
      SerialPortManager_Internal.MANAGER;

  public interface GetDevices_Response {
    void call(SerialPortInfo[] serialPortInfoArr);
  }

  public interface OpenPort_Response {
    void call(SerialPort serialPort);
  }

  public interface Proxy extends SerialPortManager, Interface.Proxy {}

  void getDevices(GetDevices_Response getDevices_Response);

  void openPort(
      UnguessableToken unguessableToken,
      boolean z,
      SerialConnectionOptions serialConnectionOptions,
      SerialPortClient serialPortClient,
      SerialPortConnectionWatcher serialPortConnectionWatcher,
      OpenPort_Response openPort_Response);

  void setClient(SerialPortManagerClient serialPortManagerClient);
}
