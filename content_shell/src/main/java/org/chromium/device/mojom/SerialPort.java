package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.system.DataPipe;

public interface SerialPort extends Interface {
  public static final Interface.Manager<SerialPort, Proxy> MANAGER = SerialPort_Internal.MANAGER;

  public interface Close_Response {
    void call();
  }

  public interface ConfigurePort_Response {
    void call(boolean z);
  }

  public interface Drain_Response {
    void call();
  }

  public interface Flush_Response {
    void call();
  }

  public interface GetControlSignals_Response {
    void call(SerialPortControlSignals serialPortControlSignals);
  }

  public interface GetPortInfo_Response {
    void call(SerialConnectionInfo serialConnectionInfo);
  }

  public interface Proxy extends SerialPort, Interface.Proxy {}

  public interface SetControlSignals_Response {
    void call(boolean z);
  }

  void close(boolean z, Close_Response close_Response);

  void configurePort(
      SerialConnectionOptions serialConnectionOptions,
      ConfigurePort_Response configurePort_Response);

  void drain(Drain_Response drain_Response);

  void flush(int i, Flush_Response flush_Response);

  void getControlSignals(GetControlSignals_Response getControlSignals_Response);

  void getPortInfo(GetPortInfo_Response getPortInfo_Response);

  void setControlSignals(
      SerialHostControlSignals serialHostControlSignals,
      SetControlSignals_Response setControlSignals_Response);

  void startReading(DataPipe.ProducerHandle producerHandle);

  void startWriting(DataPipe.ConsumerHandle consumerHandle);
}
