package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceControlMessagesHelper;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.MessageReceiverWithResponder;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;
import org.chromium.mojo.system.DataPipe;
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.InvalidHandle;

class WebSocketHandshakeClient_Internal {
  public static final Interface.Manager<WebSocketHandshakeClient, WebSocketHandshakeClient.Proxy>
      MANAGER =
          new Interface.Manager<WebSocketHandshakeClient, WebSocketHandshakeClient.Proxy>() {
            @Override
            public String getName() {
              return "network.mojom.WebSocketHandshakeClient";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public WebSocketHandshakeClient.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, WebSocketHandshakeClient impl) {
              return new Stub(core, impl);
            }

            @Override
            public WebSocketHandshakeClient[] buildArray(int size) {
              return new WebSocketHandshakeClient[size];
            }
          };
  private static final int ON_CONNECTION_ESTABLISHED_ORDINAL = 2;
  private static final int ON_FAILURE_ORDINAL = 1;
  private static final int ON_OPENING_HANDSHAKE_STARTED_ORDINAL = 0;

  WebSocketHandshakeClient_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements WebSocketHandshakeClient.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onOpeningHandshakeStarted(WebSocketHandshakeRequest request) {
      WebSocketHandshakeClientOnOpeningHandshakeStartedParams _message =
          new WebSocketHandshakeClientOnOpeningHandshakeStartedParams();
      _message.request = request;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void onFailure(String message, int netError, int responseCode) {
      WebSocketHandshakeClientOnFailureParams _message =
          new WebSocketHandshakeClientOnFailureParams();
      _message.message = message;
      _message.netError = netError;
      _message.responseCode = responseCode;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void onConnectionEstablished(
        WebSocket socket,
        InterfaceRequest<WebSocketClient> clientReceiver,
        WebSocketHandshakeResponse response,
        DataPipe.ConsumerHandle readable,
        DataPipe.ProducerHandle writable) {
      WebSocketHandshakeClientOnConnectionEstablishedParams _message =
          new WebSocketHandshakeClientOnConnectionEstablishedParams();
      _message.socket = socket;
      _message.clientReceiver = clientReceiver;
      _message.response = response;
      _message.readable = readable;
      _message.writable = writable;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }
  }

  public static final class Stub extends Interface.Stub<WebSocketHandshakeClient> {
    Stub(Core core, WebSocketHandshakeClient impl) {
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
                WebSocketHandshakeClient_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            getImpl()
                .onOpeningHandshakeStarted(
                    WebSocketHandshakeClientOnOpeningHandshakeStartedParams.deserialize(
                            messageWithHeader.getPayload())
                        .request);
            return true;
          case 1:
            WebSocketHandshakeClientOnFailureParams data =
                WebSocketHandshakeClientOnFailureParams.deserialize(messageWithHeader.getPayload());
            getImpl().onFailure(data.message, data.netError, data.responseCode);
            return true;
          case 2:
            WebSocketHandshakeClientOnConnectionEstablishedParams data2 =
                WebSocketHandshakeClientOnConnectionEstablishedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .onConnectionEstablished(
                    data2.socket,
                    data2.clientReceiver,
                    data2.response,
                    data2.readable,
                    data2.writable);
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
                getCore(), WebSocketHandshakeClient_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class WebSocketHandshakeClientOnOpeningHandshakeStartedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public WebSocketHandshakeRequest request;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebSocketHandshakeClientOnOpeningHandshakeStartedParams(int version) {
      super(16, version);
    }

    public WebSocketHandshakeClientOnOpeningHandshakeStartedParams() {
      this(0);
    }

    public static WebSocketHandshakeClientOnOpeningHandshakeStartedParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static WebSocketHandshakeClientOnOpeningHandshakeStartedParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebSocketHandshakeClientOnOpeningHandshakeStartedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebSocketHandshakeClientOnOpeningHandshakeStartedParams result =
            new WebSocketHandshakeClientOnOpeningHandshakeStartedParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.request = WebSocketHandshakeRequest.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.request, 8, false);
    }
  }

  static final class WebSocketHandshakeClientOnFailureParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public String message;
    public int netError;
    public int responseCode;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebSocketHandshakeClientOnFailureParams(int version) {
      super(24, version);
    }

    public WebSocketHandshakeClientOnFailureParams() {
      this(0);
    }

    public static WebSocketHandshakeClientOnFailureParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WebSocketHandshakeClientOnFailureParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebSocketHandshakeClientOnFailureParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebSocketHandshakeClientOnFailureParams result =
            new WebSocketHandshakeClientOnFailureParams(elementsOrVersion);
        result.message = decoder0.readString(8, false);
        result.netError = decoder0.readInt(16);
        result.responseCode = decoder0.readInt(20);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.message, 8, false);
      encoder0.encode(this.netError, 16);
      encoder0.encode(this.responseCode, 20);
    }
  }

  static final class WebSocketHandshakeClientOnConnectionEstablishedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<WebSocketClient> clientReceiver;
    public DataPipe.ConsumerHandle readable;
    public WebSocketHandshakeResponse response;
    public WebSocket socket;
    public DataPipe.ProducerHandle writable;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebSocketHandshakeClientOnConnectionEstablishedParams(int version) {
      super(40, version);
      this.readable = InvalidHandle.INSTANCE;
      this.writable = InvalidHandle.INSTANCE;
    }

    public WebSocketHandshakeClientOnConnectionEstablishedParams() {
      this(0);
    }

    public static WebSocketHandshakeClientOnConnectionEstablishedParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static WebSocketHandshakeClientOnConnectionEstablishedParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebSocketHandshakeClientOnConnectionEstablishedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebSocketHandshakeClientOnConnectionEstablishedParams result =
            new WebSocketHandshakeClientOnConnectionEstablishedParams(elementsOrVersion);
        result.socket = (WebSocket) decoder0.readServiceInterface(8, false, WebSocket.MANAGER);
        result.clientReceiver = decoder0.readInterfaceRequest(16, false);
        result.readable = decoder0.readConsumerHandle(20, false);
        Decoder decoder1 = decoder0.readPointer(24, false);
        result.response = WebSocketHandshakeResponse.decode(decoder1);
        result.writable = decoder0.readProducerHandle(32, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.socket, 8, false, WebSocket.MANAGER);
      encoder0.encode((InterfaceRequest) this.clientReceiver, 16, false);
      encoder0.encode((Handle) this.readable, 20, false);
      encoder0.encode((Struct) this.response, 24, false);
      encoder0.encode((Handle) this.writable, 32, false);
    }
  }
}
