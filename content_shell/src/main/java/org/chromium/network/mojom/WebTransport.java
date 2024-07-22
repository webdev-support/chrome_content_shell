package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.system.DataPipe;
import org.chromium.mojo_base.mojom.ReadOnlyBuffer;
import org.chromium.mojo_base.mojom.TimeDelta;

public interface WebTransport extends Interface {
  public static final Interface.Manager<WebTransport, Proxy> MANAGER =
      WebTransport_Internal.MANAGER;

  public interface AcceptBidirectionalStream_Response {
    void call(
        int i, DataPipe.ConsumerHandle consumerHandle, DataPipe.ProducerHandle producerHandle);
  }

  public interface AcceptUnidirectionalStream_Response {
    void call(int i, DataPipe.ConsumerHandle consumerHandle);
  }

  public interface CreateStream_Response {
    void call(boolean z, int i);
  }

  public interface GetStats_Response {
    void call(WebTransportStats webTransportStats);
  }

  public interface Proxy extends WebTransport, Interface.Proxy {}

  public interface SendDatagram_Response {
    void call(boolean z);
  }

  void abortStream(int i, byte b);

  void acceptBidirectionalStream(
      AcceptBidirectionalStream_Response acceptBidirectionalStream_Response);

  void acceptUnidirectionalStream(
      AcceptUnidirectionalStream_Response acceptUnidirectionalStream_Response);

  void close(WebTransportCloseInfo webTransportCloseInfo);

  void createStream(
      DataPipe.ConsumerHandle consumerHandle,
      DataPipe.ProducerHandle producerHandle,
      CreateStream_Response createStream_Response);

  void getStats(GetStats_Response getStats_Response);

  void sendDatagram(ReadOnlyBuffer readOnlyBuffer, SendDatagram_Response sendDatagram_Response);

  void sendFin(int i);

  void setOutgoingDatagramExpirationDuration(TimeDelta timeDelta);

  void stopSending(int i, byte b);
}
