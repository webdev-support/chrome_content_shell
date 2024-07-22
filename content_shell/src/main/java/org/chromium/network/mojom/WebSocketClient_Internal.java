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

class WebSocketClient_Internal {
  public static final Interface.Manager<WebSocketClient, WebSocketClient.Proxy> MANAGER =
      new Interface.Manager<WebSocketClient, WebSocketClient.Proxy>() {
        @Override
        public String getName() {
          return "network.mojom.WebSocketClient";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public WebSocketClient.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, WebSocketClient impl) {
          return new Stub(core, impl);
        }

        @Override
        public WebSocketClient[] buildArray(int size) {
          return new WebSocketClient[size];
        }
      };
  private static final int ON_CLOSING_HANDSHAKE_ORDINAL = 2;
  private static final int ON_DATA_FRAME_ORDINAL = 0;
  private static final int ON_DROP_CHANNEL_ORDINAL = 1;

  WebSocketClient_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements WebSocketClient.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onDataFrame(boolean fin, int type, long dataLength) {
      WebSocketClientOnDataFrameParams _message = new WebSocketClientOnDataFrameParams();
      _message.fin = fin;
      _message.type = type;
      _message.dataLength = dataLength;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void onDropChannel(boolean wasClean, short code, String reason) {
      WebSocketClientOnDropChannelParams _message = new WebSocketClientOnDropChannelParams();
      _message.wasClean = wasClean;
      _message.code = code;
      _message.reason = reason;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void onClosingHandshake() {
      WebSocketClientOnClosingHandshakeParams _message =
          new WebSocketClientOnClosingHandshakeParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }
  }

  public static final class Stub extends Interface.Stub<WebSocketClient> {
    Stub(Core core, WebSocketClient impl) {
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
                WebSocketClient_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            WebSocketClientOnDataFrameParams data =
                WebSocketClientOnDataFrameParams.deserialize(messageWithHeader.getPayload());
            getImpl().onDataFrame(data.fin, data.type, data.dataLength);
            return true;
          case 1:
            WebSocketClientOnDropChannelParams data2 =
                WebSocketClientOnDropChannelParams.deserialize(messageWithHeader.getPayload());
            getImpl().onDropChannel(data2.wasClean, data2.code, data2.reason);
            return true;
          case 2:
            WebSocketClientOnClosingHandshakeParams.deserialize(messageWithHeader.getPayload());
            getImpl().onClosingHandshake();
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
                getCore(), WebSocketClient_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class WebSocketClientOnDataFrameParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public long dataLength;
    public boolean fin;
    public int type;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebSocketClientOnDataFrameParams(int version) {
      super(24, version);
    }

    public WebSocketClientOnDataFrameParams() {
      this(0);
    }

    public static WebSocketClientOnDataFrameParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WebSocketClientOnDataFrameParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebSocketClientOnDataFrameParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebSocketClientOnDataFrameParams result =
            new WebSocketClientOnDataFrameParams(elementsOrVersion);
        result.fin = decoder0.readBoolean(8, 0);
        int readInt = decoder0.readInt(12);
        result.type = readInt;
        WebSocketMessageType.validate(readInt);
        result.type = WebSocketMessageType.toKnownValue(result.type);
        result.dataLength = decoder0.readLong(16);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.fin, 8, 0);
      encoder0.encode(this.type, 12);
      encoder0.encode(this.dataLength, 16);
    }
  }

  static final class WebSocketClientOnDropChannelParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public short code;
    public String reason;
    public boolean wasClean;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebSocketClientOnDropChannelParams(int version) {
      super(24, version);
    }

    public WebSocketClientOnDropChannelParams() {
      this(0);
    }

    public static WebSocketClientOnDropChannelParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WebSocketClientOnDropChannelParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebSocketClientOnDropChannelParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebSocketClientOnDropChannelParams result =
            new WebSocketClientOnDropChannelParams(elementsOrVersion);
        result.wasClean = decoder0.readBoolean(8, 0);
        result.code = decoder0.readShort(10);
        result.reason = decoder0.readString(16, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.wasClean, 8, 0);
      encoder0.encode(this.code, 10);
      encoder0.encode(this.reason, 16, false);
    }
  }

  static final class WebSocketClientOnClosingHandshakeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebSocketClientOnClosingHandshakeParams(int version) {
      super(8, version);
    }

    public WebSocketClientOnClosingHandshakeParams() {
      this(0);
    }

    public static WebSocketClientOnClosingHandshakeParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WebSocketClientOnClosingHandshakeParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebSocketClientOnClosingHandshakeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebSocketClientOnClosingHandshakeParams result =
            new WebSocketClientOnClosingHandshakeParams(elementsOrVersion);
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
}
