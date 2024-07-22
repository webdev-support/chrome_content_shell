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

class WebSocket_Internal {
  public static final Interface.Manager<WebSocket, WebSocket.Proxy> MANAGER =
      new Interface.Manager<WebSocket, WebSocket.Proxy>() {
        @Override
        public String getName() {
          return "network.mojom.WebSocket";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public WebSocket.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, WebSocket impl) {
          return new Stub(core, impl);
        }

        @Override
        public WebSocket[] buildArray(int size) {
          return new WebSocket[size];
        }
      };
  private static final int SEND_MESSAGE_ORDINAL = 0;
  private static final int START_CLOSING_HANDSHAKE_ORDINAL = 2;
  private static final int START_RECEIVING_ORDINAL = 1;

  WebSocket_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements WebSocket.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void sendMessage(int type, long dataLength) {
      WebSocketSendMessageParams _message = new WebSocketSendMessageParams();
      _message.type = type;
      _message.dataLength = dataLength;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void startReceiving() {
      WebSocketStartReceivingParams _message = new WebSocketStartReceivingParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void startClosingHandshake(short code, String reason) {
      WebSocketStartClosingHandshakeParams _message = new WebSocketStartClosingHandshakeParams();
      _message.code = code;
      _message.reason = reason;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }
  }

  public static final class Stub extends Interface.Stub<WebSocket> {
    Stub(Core core, WebSocket impl) {
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
                WebSocket_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            WebSocketSendMessageParams data =
                WebSocketSendMessageParams.deserialize(messageWithHeader.getPayload());
            getImpl().sendMessage(data.type, data.dataLength);
            return true;
          case 1:
            WebSocketStartReceivingParams.deserialize(messageWithHeader.getPayload());
            getImpl().startReceiving();
            return true;
          case 2:
            WebSocketStartClosingHandshakeParams data2 =
                WebSocketStartClosingHandshakeParams.deserialize(messageWithHeader.getPayload());
            getImpl().startClosingHandshake(data2.code, data2.reason);
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
                getCore(), WebSocket_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class WebSocketSendMessageParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public long dataLength;
    public int type;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebSocketSendMessageParams(int version) {
      super(24, version);
    }

    public WebSocketSendMessageParams() {
      this(0);
    }

    public static WebSocketSendMessageParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WebSocketSendMessageParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebSocketSendMessageParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebSocketSendMessageParams result = new WebSocketSendMessageParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
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
      encoder0.encode(this.type, 8);
      encoder0.encode(this.dataLength, 16);
    }
  }

  static final class WebSocketStartReceivingParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebSocketStartReceivingParams(int version) {
      super(8, version);
    }

    public WebSocketStartReceivingParams() {
      this(0);
    }

    public static WebSocketStartReceivingParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WebSocketStartReceivingParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebSocketStartReceivingParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebSocketStartReceivingParams result = new WebSocketStartReceivingParams(elementsOrVersion);
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

  static final class WebSocketStartClosingHandshakeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public short code;
    public String reason;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebSocketStartClosingHandshakeParams(int version) {
      super(24, version);
    }

    public WebSocketStartClosingHandshakeParams() {
      this(0);
    }

    public static WebSocketStartClosingHandshakeParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WebSocketStartClosingHandshakeParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebSocketStartClosingHandshakeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebSocketStartClosingHandshakeParams result =
            new WebSocketStartClosingHandshakeParams(elementsOrVersion);
        result.code = decoder0.readShort(8);
        result.reason = decoder0.readString(16, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.code, 8);
      encoder0.encode(this.reason, 16, false);
    }
  }
}
