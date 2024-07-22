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
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;
import org.chromium.mojo_base.mojom.ReadOnlyBuffer;

class WebTransportClient_Internal {
  public static final Interface.Manager<WebTransportClient, WebTransportClient.Proxy> MANAGER =
      new Interface.Manager<WebTransportClient, WebTransportClient.Proxy>() {
        @Override
        public String getName() {
          return "network.mojom.WebTransportClient";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public WebTransportClient.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, WebTransportClient impl) {
          return new Stub(core, impl);
        }

        @Override
        public WebTransportClient[] buildArray(int size) {
          return new WebTransportClient[size];
        }
      };
  private static final int ON_CLOSED_ORDINAL = 5;
  private static final int ON_DATAGRAM_RECEIVED_ORDINAL = 0;
  private static final int ON_INCOMING_STREAM_CLOSED_ORDINAL = 1;
  private static final int ON_OUTGOING_STREAM_CLOSED_ORDINAL = 2;
  private static final int ON_RECEIVED_RESET_STREAM_ORDINAL = 4;
  private static final int ON_RECEIVED_STOP_SENDING_ORDINAL = 3;

  WebTransportClient_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements WebTransportClient.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onDatagramReceived(ReadOnlyBuffer data) {
      WebTransportClientOnDatagramReceivedParams _message =
          new WebTransportClientOnDatagramReceivedParams();
      _message.data = data;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void onIncomingStreamClosed(int streamId, boolean finReceived) {
      WebTransportClientOnIncomingStreamClosedParams _message =
          new WebTransportClientOnIncomingStreamClosedParams();
      _message.streamId = streamId;
      _message.finReceived = finReceived;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void onOutgoingStreamClosed(int streamId) {
      WebTransportClientOnOutgoingStreamClosedParams _message =
          new WebTransportClientOnOutgoingStreamClosedParams();
      _message.streamId = streamId;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void onReceivedStopSending(int streamId, int streamErrorCode) {
      WebTransportClientOnReceivedStopSendingParams _message =
          new WebTransportClientOnReceivedStopSendingParams();
      _message.streamId = streamId;
      _message.streamErrorCode = streamErrorCode;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }

    @Override
    public void onReceivedResetStream(int streamId, int streamErrorCode) {
      WebTransportClientOnReceivedResetStreamParams _message =
          new WebTransportClientOnReceivedResetStreamParams();
      _message.streamId = streamId;
      _message.streamErrorCode = streamErrorCode;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
    }

    @Override
    public void onClosed(WebTransportCloseInfo closeInfo, WebTransportStats finalStats) {
      WebTransportClientOnClosedParams _message = new WebTransportClientOnClosedParams();
      _message.closeInfo = closeInfo;
      _message.finalStats = finalStats;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5)));
    }
  }

  public static final class Stub extends Interface.Stub<WebTransportClient> {
    Stub(Core core, WebTransportClient impl) {
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
                WebTransportClient_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            getImpl()
                .onDatagramReceived(
                    WebTransportClientOnDatagramReceivedParams.deserialize(
                            messageWithHeader.getPayload())
                        .data);
            return true;
          case 1:
            WebTransportClientOnIncomingStreamClosedParams data =
                WebTransportClientOnIncomingStreamClosedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onIncomingStreamClosed(data.streamId, data.finReceived);
            return true;
          case 2:
            WebTransportClientOnOutgoingStreamClosedParams data2 =
                WebTransportClientOnOutgoingStreamClosedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onOutgoingStreamClosed(data2.streamId);
            return true;
          case 3:
            WebTransportClientOnReceivedStopSendingParams data3 =
                WebTransportClientOnReceivedStopSendingParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onReceivedStopSending(data3.streamId, data3.streamErrorCode);
            return true;
          case 4:
            WebTransportClientOnReceivedResetStreamParams data4 =
                WebTransportClientOnReceivedResetStreamParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onReceivedResetStream(data4.streamId, data4.streamErrorCode);
            return true;
          case 5:
            WebTransportClientOnClosedParams data5 =
                WebTransportClientOnClosedParams.deserialize(messageWithHeader.getPayload());
            getImpl().onClosed(data5.closeInfo, data5.finalStats);
            return true;
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
                getCore(), WebTransportClient_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class WebTransportClientOnDatagramReceivedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public ReadOnlyBuffer data;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebTransportClientOnDatagramReceivedParams(int version) {
      super(16, version);
    }

    public WebTransportClientOnDatagramReceivedParams() {
      this(0);
    }

    public static WebTransportClientOnDatagramReceivedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WebTransportClientOnDatagramReceivedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebTransportClientOnDatagramReceivedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebTransportClientOnDatagramReceivedParams result =
            new WebTransportClientOnDatagramReceivedParams(elementsOrVersion);
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

  static final class WebTransportClientOnIncomingStreamClosedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean finReceived;
    public int streamId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebTransportClientOnIncomingStreamClosedParams(int version) {
      super(16, version);
    }

    public WebTransportClientOnIncomingStreamClosedParams() {
      this(0);
    }

    public static WebTransportClientOnIncomingStreamClosedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WebTransportClientOnIncomingStreamClosedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebTransportClientOnIncomingStreamClosedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebTransportClientOnIncomingStreamClosedParams result =
            new WebTransportClientOnIncomingStreamClosedParams(elementsOrVersion);
        result.streamId = decoder0.readInt(8);
        result.finReceived = decoder0.readBoolean(12, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.streamId, 8);
      encoder0.encode(this.finReceived, 12, 0);
    }
  }

  static final class WebTransportClientOnOutgoingStreamClosedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int streamId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebTransportClientOnOutgoingStreamClosedParams(int version) {
      super(16, version);
    }

    public WebTransportClientOnOutgoingStreamClosedParams() {
      this(0);
    }

    public static WebTransportClientOnOutgoingStreamClosedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WebTransportClientOnOutgoingStreamClosedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebTransportClientOnOutgoingStreamClosedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebTransportClientOnOutgoingStreamClosedParams result =
            new WebTransportClientOnOutgoingStreamClosedParams(elementsOrVersion);
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

  static final class WebTransportClientOnReceivedStopSendingParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int streamErrorCode;
    public int streamId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebTransportClientOnReceivedStopSendingParams(int version) {
      super(16, version);
    }

    public WebTransportClientOnReceivedStopSendingParams() {
      this(0);
    }

    public static WebTransportClientOnReceivedStopSendingParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WebTransportClientOnReceivedStopSendingParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebTransportClientOnReceivedStopSendingParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebTransportClientOnReceivedStopSendingParams result =
            new WebTransportClientOnReceivedStopSendingParams(elementsOrVersion);
        result.streamId = decoder0.readInt(8);
        result.streamErrorCode = decoder0.readInt(12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.streamId, 8);
      encoder0.encode(this.streamErrorCode, 12);
    }
  }

  static final class WebTransportClientOnReceivedResetStreamParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int streamErrorCode;
    public int streamId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebTransportClientOnReceivedResetStreamParams(int version) {
      super(16, version);
    }

    public WebTransportClientOnReceivedResetStreamParams() {
      this(0);
    }

    public static WebTransportClientOnReceivedResetStreamParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WebTransportClientOnReceivedResetStreamParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebTransportClientOnReceivedResetStreamParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebTransportClientOnReceivedResetStreamParams result =
            new WebTransportClientOnReceivedResetStreamParams(elementsOrVersion);
        result.streamId = decoder0.readInt(8);
        result.streamErrorCode = decoder0.readInt(12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.streamId, 8);
      encoder0.encode(this.streamErrorCode, 12);
    }
  }

  static final class WebTransportClientOnClosedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public WebTransportCloseInfo closeInfo;
    public WebTransportStats finalStats;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebTransportClientOnClosedParams(int version) {
      super(24, version);
    }

    public WebTransportClientOnClosedParams() {
      this(0);
    }

    public static WebTransportClientOnClosedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WebTransportClientOnClosedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebTransportClientOnClosedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebTransportClientOnClosedParams result =
            new WebTransportClientOnClosedParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.closeInfo = WebTransportCloseInfo.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.finalStats = WebTransportStats.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.closeInfo, 8, true);
      encoder0.encode((Struct) this.finalStats, 16, false);
    }
  }
}
