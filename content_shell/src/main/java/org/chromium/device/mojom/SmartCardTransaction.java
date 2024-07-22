package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;

public interface SmartCardTransaction extends Interface {
  public static final Interface.Manager<SmartCardTransaction, Proxy> MANAGER =
      SmartCardTransaction_Internal.MANAGER;

  public interface EndTransaction_Response {
    void call(SmartCardResult smartCardResult);
  }

  public interface Proxy extends SmartCardTransaction, Interface.Proxy {}

  void endTransaction(int i, EndTransaction_Response endTransaction_Response);
}
