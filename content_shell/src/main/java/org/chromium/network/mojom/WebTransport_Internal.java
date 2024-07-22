package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceControlMessagesHelper;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.MessageReceiverWithResponder;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;
import org.chromium.mojo.system.DataPipe;
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.InvalidHandle;
import org.chromium.mojo_base.mojom.ReadOnlyBuffer;
import org.chromium.mojo_base.mojom.TimeDelta;

class WebTransport_Internal {
  private static final int ABORT_STREAM_ORDINAL = 5;
  private static final int ACCEPT_BIDIRECTIONAL_STREAM_ORDINAL = 2;
  private static final int ACCEPT_UNIDIRECTIONAL_STREAM_ORDINAL = 3;
  private static final int CLOSE_ORDINAL = 9;
  private static final int CREATE_STREAM_ORDINAL = 1;
  private static final int GET_STATS_ORDINAL = 8;
  public static final Interface.Manager<WebTransport, WebTransport.Proxy> MANAGER =
      new Interface.Manager<WebTransport, WebTransport.Proxy>() {
        @Override
        public String getName() {
          return "network.mojom.WebTransport";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public WebTransport.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, WebTransport impl) {
          return new Stub(core, impl);
        }

        @Override
        public WebTransport[] buildArray(int size) {
          return new WebTransport[size];
        }
      };
  private static final int SEND_DATAGRAM_ORDINAL = 0;
  private static final int SEND_FIN_ORDINAL = 4;
  private static final int SET_OUTGOING_DATAGRAM_EXPIRATION_DURATION_ORDINAL = 7;
  private static final int STOP_SENDING_ORDINAL = 6;

  WebTransport_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements WebTransport.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void sendDatagram(ReadOnlyBuffer data, WebTransport.SendDatagram_Response callback) {
      WebTransportSendDatagramParams _message = new WebTransportSendDatagramParams();
      _message.data = data;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new WebTransportSendDatagramResponseParamsForwardToCallback(callback));
    }

    @Override
    public void createStream(
        DataPipe.ConsumerHandle readable,
        DataPipe.ProducerHandle writable,
        WebTransport.CreateStream_Response callback) {
      WebTransportCreateStreamParams _message = new WebTransportCreateStreamParams();
      _message.readable = readable;
      _message.writable = writable;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new WebTransportCreateStreamResponseParamsForwardToCallback(callback));
    }

    @Override
    public void acceptBidirectionalStream(
        WebTransport.AcceptBidirectionalStream_Response callback) {
      WebTransportAcceptBidirectionalStreamParams _message =
          new WebTransportAcceptBidirectionalStreamParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new WebTransportAcceptBidirectionalStreamResponseParamsForwardToCallback(callback));
    }

    @Override
    public void acceptUnidirectionalStream(
        WebTransport.AcceptUnidirectionalStream_Response callback) {
      WebTransportAcceptUnidirectionalStreamParams _message =
          new WebTransportAcceptUnidirectionalStreamParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)),
              new WebTransportAcceptUnidirectionalStreamResponseParamsForwardToCallback(callback));
    }

    @Override
    public void sendFin(int streamId) {
      WebTransportSendFinParams _message = new WebTransportSendFinParams();
      _message.streamId = streamId;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
    }

    @Override
    public void abortStream(int streamId, byte code) {
      WebTransportAbortStreamParams _message = new WebTransportAbortStreamParams();
      _message.streamId = streamId;
      _message.code = code;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5)));
    }

    @Override
    public void stopSending(int streamId, byte code) {
      WebTransportStopSendingParams _message = new WebTransportStopSendingParams();
      _message.streamId = streamId;
      _message.code = code;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(6)));
    }

    @Override
    public void setOutgoingDatagramExpirationDuration(TimeDelta duration) {
      WebTransportSetOutgoingDatagramExpirationDurationParams _message =
          new WebTransportSetOutgoingDatagramExpirationDurationParams();
      _message.duration = duration;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(7)));
    }

    @Override
    public void getStats(WebTransport.GetStats_Response callback) {
      WebTransportGetStatsParams _message = new WebTransportGetStatsParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(8, 1, 0L)),
              new WebTransportGetStatsResponseParamsForwardToCallback(callback));
    }

    @Override
    public void close(WebTransportCloseInfo closeInfo) {
      WebTransportCloseParams _message = new WebTransportCloseParams();
      _message.closeInfo = closeInfo;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(9)));
    }
  }

  public static final class Stub extends Interface.Stub<WebTransport> {
    Stub(Core core, WebTransport impl) {
      super(core, impl);
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        int flags = 0;
        if (header.hasFlag(4)) {
          flags = 0 | 4;
        }
        if (!header.validateHeader(flags)) {
          return false;
        }
        switch (header.getType()) {
          case -2:
            return InterfaceControlMessagesHelper.handleRunOrClosePipe(
                WebTransport_Internal.MANAGER, messageWithHeader);
          case 4:
            getImpl()
                .sendFin(
                    WebTransportSendFinParams.deserialize(messageWithHeader.getPayload()).streamId);
            return true;
          case 5:
            WebTransportAbortStreamParams data =
                WebTransportAbortStreamParams.deserialize(messageWithHeader.getPayload());
            getImpl().abortStream(data.streamId, data.code);
            return true;
          case 6:
            WebTransportStopSendingParams data2 =
                WebTransportStopSendingParams.deserialize(messageWithHeader.getPayload());
            getImpl().stopSending(data2.streamId, data2.code);
            return true;
          case 7:
            WebTransportSetOutgoingDatagramExpirationDurationParams data3 =
                WebTransportSetOutgoingDatagramExpirationDurationParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().setOutgoingDatagramExpirationDuration(data3.duration);
            return true;
          case 9:
            WebTransportCloseParams data4 =
                WebTransportCloseParams.deserialize(messageWithHeader.getPayload());
            getImpl().close(data4.closeInfo);
            return true;
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }

    @Override
    public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        int flags = 1;
        if (header.hasFlag(4)) {
          flags = 1 | 4;
        }
        if (!header.validateHeader(flags)) {
          return false;
        }
        switch (header.getType()) {
          case -1:
            return InterfaceControlMessagesHelper.handleRun(
                getCore(), WebTransport_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            getImpl()
                .sendDatagram(
                    WebTransportSendDatagramParams.deserialize(messageWithHeader.getPayload()).data,
                    new WebTransportSendDatagramResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
            WebTransportCreateStreamParams data =
                WebTransportCreateStreamParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .createStream(
                    data.readable,
                    data.writable,
                    new WebTransportCreateStreamResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 2:
            WebTransportAcceptBidirectionalStreamParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .acceptBidirectionalStream(
                    new WebTransportAcceptBidirectionalStreamResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 3:
            WebTransportAcceptUnidirectionalStreamParams.deserialize(
                messageWithHeader.getPayload());
            getImpl()
                .acceptUnidirectionalStream(
                    new WebTransportAcceptUnidirectionalStreamResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 4:
          case 5:
          case 6:
          case 7:
          default:
            return false;
          case 8:
            WebTransportGetStatsParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .getStats(
                    new WebTransportGetStatsResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class WebTransportSendDatagramParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public ReadOnlyBuffer data;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebTransportSendDatagramParams(int version) {
      super(16, version);
    }

    public WebTransportSendDatagramParams() {
      this(0);
    }

    public static WebTransportSendDatagramParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WebTransportSendDatagramParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebTransportSendDatagramParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebTransportSendDatagramParams result =
            new WebTransportSendDatagramParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.data = ReadOnlyBuffer.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.data, 8, false);
    }
  }

  static final class WebTransportSendDatagramResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebTransportSendDatagramResponseParams(int version) {
      super(16, version);
    }

    public WebTransportSendDatagramResponseParams() {
      this(0);
    }

    public static WebTransportSendDatagramResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WebTransportSendDatagramResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebTransportSendDatagramResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebTransportSendDatagramResponseParams result =
            new WebTransportSendDatagramResponseParams(elementsOrVersion);
        result.result = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.result, 8, 0);
    }
  }

  static class WebTransportSendDatagramResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final WebTransport.SendDatagram_Response mCallback;

    WebTransportSendDatagramResponseParamsForwardToCallback(
        WebTransport.SendDatagram_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(0, 2)) {
          return false;
        }
        WebTransportSendDatagramResponseParams response =
            WebTransportSendDatagramResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class WebTransportSendDatagramResponseParamsProxyToResponder
      implements WebTransport.SendDatagram_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    WebTransportSendDatagramResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean result) {
      WebTransportSendDatagramResponseParams _response =
          new WebTransportSendDatagramResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class WebTransportCreateStreamParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public DataPipe.ConsumerHandle readable;
    public DataPipe.ProducerHandle writable;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebTransportCreateStreamParams(int version) {
      super(16, version);
      this.readable = InvalidHandle.INSTANCE;
      this.writable = InvalidHandle.INSTANCE;
    }

    public WebTransportCreateStreamParams() {
      this(0);
    }

    public static WebTransportCreateStreamParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WebTransportCreateStreamParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebTransportCreateStreamParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebTransportCreateStreamParams result =
            new WebTransportCreateStreamParams(elementsOrVersion);
        result.readable = decoder0.readConsumerHandle(8, false);
        result.writable = decoder0.readProducerHandle(12, true);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Handle) this.readable, 8, false);
      encoder0.encode((Handle) this.writable, 12, true);
    }
  }

  static final class WebTransportCreateStreamResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int streamId;
    public boolean succeeded;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebTransportCreateStreamResponseParams(int version) {
      super(16, version);
    }

    public WebTransportCreateStreamResponseParams() {
      this(0);
    }

    public static WebTransportCreateStreamResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WebTransportCreateStreamResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebTransportCreateStreamResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebTransportCreateStreamResponseParams result =
            new WebTransportCreateStreamResponseParams(elementsOrVersion);
        result.succeeded = decoder0.readBoolean(8, 0);
        result.streamId = decoder0.readInt(12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.succeeded, 8, 0);
      encoder0.encode(this.streamId, 12);
    }
  }

  static class WebTransportCreateStreamResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final WebTransport.CreateStream_Response mCallback;

    WebTransportCreateStreamResponseParamsForwardToCallback(
        WebTransport.CreateStream_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(1, 2)) {
          return false;
        }
        WebTransportCreateStreamResponseParams response =
            WebTransportCreateStreamResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.succeeded, response.streamId);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class WebTransportCreateStreamResponseParamsProxyToResponder
      implements WebTransport.CreateStream_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    WebTransportCreateStreamResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean succeeded, int streamId) {
      WebTransportCreateStreamResponseParams _response =
          new WebTransportCreateStreamResponseParams();
      _response.succeeded = succeeded;
      _response.streamId = streamId;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class WebTransportAcceptBidirectionalStreamParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebTransportAcceptBidirectionalStreamParams(int version) {
      super(8, version);
    }

    public WebTransportAcceptBidirectionalStreamParams() {
      this(0);
    }

    public static WebTransportAcceptBidirectionalStreamParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WebTransportAcceptBidirectionalStreamParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebTransportAcceptBidirectionalStreamParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebTransportAcceptBidirectionalStreamParams result =
            new WebTransportAcceptBidirectionalStreamParams(elementsOrVersion);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    }
  }

  static final class WebTransportAcceptBidirectionalStreamResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public DataPipe.ConsumerHandle readable;
    public int streamId;
    public DataPipe.ProducerHandle writable;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebTransportAcceptBidirectionalStreamResponseParams(int version) {
      super(24, version);
      this.readable = InvalidHandle.INSTANCE;
      this.writable = InvalidHandle.INSTANCE;
    }

    public WebTransportAcceptBidirectionalStreamResponseParams() {
      this(0);
    }

    public static WebTransportAcceptBidirectionalStreamResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WebTransportAcceptBidirectionalStreamResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebTransportAcceptBidirectionalStreamResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebTransportAcceptBidirectionalStreamResponseParams result =
            new WebTransportAcceptBidirectionalStreamResponseParams(elementsOrVersion);
        result.streamId = decoder0.readInt(8);
        result.readable = decoder0.readConsumerHandle(12, false);
        result.writable = decoder0.readProducerHandle(16, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.streamId, 8);
      encoder0.encode((Handle) this.readable, 12, false);
      encoder0.encode((Handle) this.writable, 16, false);
    }
  }

  static class WebTransportAcceptBidirectionalStreamResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final WebTransport.AcceptBidirectionalStream_Response mCallback;

    WebTransportAcceptBidirectionalStreamResponseParamsForwardToCallback(
        WebTransport.AcceptBidirectionalStream_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(2, 2)) {
          return false;
        }
        WebTransportAcceptBidirectionalStreamResponseParams response =
            WebTransportAcceptBidirectionalStreamResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.streamId, response.readable, response.writable);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class WebTransportAcceptBidirectionalStreamResponseParamsProxyToResponder
      implements WebTransport.AcceptBidirectionalStream_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    WebTransportAcceptBidirectionalStreamResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(
        int streamId, DataPipe.ConsumerHandle readable, DataPipe.ProducerHandle writable) {
      WebTransportAcceptBidirectionalStreamResponseParams _response =
          new WebTransportAcceptBidirectionalStreamResponseParams();
      _response.streamId = streamId;
      _response.readable = readable;
      _response.writable = writable;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class WebTransportAcceptUnidirectionalStreamParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebTransportAcceptUnidirectionalStreamParams(int version) {
      super(8, version);
    }

    public WebTransportAcceptUnidirectionalStreamParams() {
      this(0);
    }

    public static WebTransportAcceptUnidirectionalStreamParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WebTransportAcceptUnidirectionalStreamParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebTransportAcceptUnidirectionalStreamParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebTransportAcceptUnidirectionalStreamParams result =
            new WebTransportAcceptUnidirectionalStreamParams(elementsOrVersion);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    }
  }

  static final class WebTransportAcceptUnidirectionalStreamResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public DataPipe.ConsumerHandle readable;
    public int streamId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebTransportAcceptUnidirectionalStreamResponseParams(int version) {
      super(16, version);
      this.readable = InvalidHandle.INSTANCE;
    }

    public WebTransportAcceptUnidirectionalStreamResponseParams() {
      this(0);
    }

    public static WebTransportAcceptUnidirectionalStreamResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static WebTransportAcceptUnidirectionalStreamResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebTransportAcceptUnidirectionalStreamResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebTransportAcceptUnidirectionalStreamResponseParams result =
            new WebTransportAcceptUnidirectionalStreamResponseParams(elementsOrVersion);
        result.streamId = decoder0.readInt(8);
        result.readable = decoder0.readConsumerHandle(12, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.streamId, 8);
      encoder0.encode((Handle) this.readable, 12, false);
    }
  }

  static class WebTransportAcceptUnidirectionalStreamResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final WebTransport.AcceptUnidirectionalStream_Response mCallback;

    WebTransportAcceptUnidirectionalStreamResponseParamsForwardToCallback(
        WebTransport.AcceptUnidirectionalStream_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(3, 2)) {
          return false;
        }
        WebTransportAcceptUnidirectionalStreamResponseParams response =
            WebTransportAcceptUnidirectionalStreamResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.streamId, response.readable);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class WebTransportAcceptUnidirectionalStreamResponseParamsProxyToResponder
      implements WebTransport.AcceptUnidirectionalStream_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    WebTransportAcceptUnidirectionalStreamResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int streamId, DataPipe.ConsumerHandle readable) {
      WebTransportAcceptUnidirectionalStreamResponseParams _response =
          new WebTransportAcceptUnidirectionalStreamResponseParams();
      _response.streamId = streamId;
      _response.readable = readable;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class WebTransportSendFinParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int streamId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebTransportSendFinParams(int version) {
      super(16, version);
    }

    public WebTransportSendFinParams() {
      this(0);
    }

    public static WebTransportSendFinParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WebTransportSendFinParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebTransportSendFinParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebTransportSendFinParams result = new WebTransportSendFinParams(elementsOrVersion);
        result.streamId = decoder0.readInt(8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.streamId, 8);
    }
  }

  static final class WebTransportAbortStreamParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public byte code;
    public int streamId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebTransportAbortStreamParams(int version) {
      super(16, version);
    }

    public WebTransportAbortStreamParams() {
      this(0);
    }

    public static WebTransportAbortStreamParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WebTransportAbortStreamParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebTransportAbortStreamParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebTransportAbortStreamParams result = new WebTransportAbortStreamParams(elementsOrVersion);
        result.streamId = decoder0.readInt(8);
        result.code = decoder0.readByte(12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.streamId, 8);
      encoder0.encode(this.code, 12);
    }
  }

  static final class WebTransportStopSendingParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public byte code;
    public int streamId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebTransportStopSendingParams(int version) {
      super(16, version);
    }

    public WebTransportStopSendingParams() {
      this(0);
    }

    public static WebTransportStopSendingParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WebTransportStopSendingParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebTransportStopSendingParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebTransportStopSendingParams result = new WebTransportStopSendingParams(elementsOrVersion);
        result.streamId = decoder0.readInt(8);
        result.code = decoder0.readByte(12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.streamId, 8);
      encoder0.encode(this.code, 12);
    }
  }

  static final class WebTransportSetOutgoingDatagramExpirationDurationParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public TimeDelta duration;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebTransportSetOutgoingDatagramExpirationDurationParams(int version) {
      super(16, version);
    }

    public WebTransportSetOutgoingDatagramExpirationDurationParams() {
      this(0);
    }

    public static WebTransportSetOutgoingDatagramExpirationDurationParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static WebTransportSetOutgoingDatagramExpirationDurationParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebTransportSetOutgoingDatagramExpirationDurationParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebTransportSetOutgoingDatagramExpirationDurationParams result =
            new WebTransportSetOutgoingDatagramExpirationDurationParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.duration = TimeDelta.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.duration, 8, false);
    }
  }

  static final class WebTransportGetStatsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebTransportGetStatsParams(int version) {
      super(8, version);
    }

    public WebTransportGetStatsParams() {
      this(0);
    }

    public static WebTransportGetStatsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WebTransportGetStatsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebTransportGetStatsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebTransportGetStatsParams result = new WebTransportGetStatsParams(elementsOrVersion);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    }
  }

  static final class WebTransportGetStatsResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public WebTransportStats stats;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebTransportGetStatsResponseParams(int version) {
      super(16, version);
    }

    public WebTransportGetStatsResponseParams() {
      this(0);
    }

    public static WebTransportGetStatsResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WebTransportGetStatsResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebTransportGetStatsResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebTransportGetStatsResponseParams result =
            new WebTransportGetStatsResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.stats = WebTransportStats.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.stats, 8, true);
    }
  }

  static class WebTransportGetStatsResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final WebTransport.GetStats_Response mCallback;

    WebTransportGetStatsResponseParamsForwardToCallback(WebTransport.GetStats_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(8, 2)) {
          return false;
        }
        WebTransportGetStatsResponseParams response =
            WebTransportGetStatsResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.stats);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class WebTransportGetStatsResponseParamsProxyToResponder
      implements WebTransport.GetStats_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    WebTransportGetStatsResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(WebTransportStats stats) {
      WebTransportGetStatsResponseParams _response = new WebTransportGetStatsResponseParams();
      _response.stats = stats;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(8, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class WebTransportCloseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public WebTransportCloseInfo closeInfo;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebTransportCloseParams(int version) {
      super(16, version);
    }

    public WebTransportCloseParams() {
      this(0);
    }

    public static WebTransportCloseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WebTransportCloseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebTransportCloseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebTransportCloseParams result = new WebTransportCloseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.closeInfo = WebTransportCloseInfo.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.closeInfo, 8, true);
    }
  }
}
