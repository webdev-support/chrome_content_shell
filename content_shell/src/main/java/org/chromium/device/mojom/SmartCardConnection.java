package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;

public interface SmartCardConnection extends Interface {
  public static final Interface.Manager<SmartCardConnection, Proxy> MANAGER =
      SmartCardConnection_Internal.MANAGER;

  public interface BeginTransaction_Response {
    void call(SmartCardTransactionResult smartCardTransactionResult);
  }

  public interface Control_Response {
    void call(SmartCardDataResult smartCardDataResult);
  }

  public interface Disconnect_Response {
    void call(SmartCardResult smartCardResult);
  }

  public interface GetAttrib_Response {
    void call(SmartCardDataResult smartCardDataResult);
  }

  public interface Proxy extends SmartCardConnection, Interface.Proxy {}

  public interface SetAttrib_Response {
    void call(SmartCardResult smartCardResult);
  }

  public interface Status_Response {
    void call(SmartCardStatusResult smartCardStatusResult);
  }

  public interface Transmit_Response {
    void call(SmartCardDataResult smartCardDataResult);
  }

  void beginTransaction(BeginTransaction_Response beginTransaction_Response);

  void control(int i, byte[] bArr, Control_Response control_Response);

  void disconnect(int i, Disconnect_Response disconnect_Response);

  void getAttrib(int i, GetAttrib_Response getAttrib_Response);

  void setAttrib(int i, byte[] bArr, SetAttrib_Response setAttrib_Response);

  void status(Status_Response status_Response);

  void transmit(int i, byte[] bArr, Transmit_Response transmit_Response);
}
