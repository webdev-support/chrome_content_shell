package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.TimeDelta;

public interface SmartCardContext extends Interface {
  public static final Interface.Manager<SmartCardContext, Proxy> MANAGER =
      SmartCardContext_Internal.MANAGER;

  public interface Cancel_Response {
    void call(SmartCardResult smartCardResult);
  }

  public interface Connect_Response {
    void call(SmartCardConnectResult smartCardConnectResult);
  }

  public interface GetStatusChange_Response {
    void call(SmartCardStatusChangeResult smartCardStatusChangeResult);
  }

  public interface ListReaders_Response {
    void call(SmartCardListReadersResult smartCardListReadersResult);
  }

  public interface Proxy extends SmartCardContext, Interface.Proxy {}

  void cancel(Cancel_Response cancel_Response);

  void connect(
      String str, int i, SmartCardProtocols smartCardProtocols, Connect_Response connect_Response);

  void getStatusChange(
      TimeDelta timeDelta,
      SmartCardReaderStateIn[] smartCardReaderStateInArr,
      GetStatusChange_Response getStatusChange_Response);

  void listReaders(ListReaders_Response listReaders_Response);
}
