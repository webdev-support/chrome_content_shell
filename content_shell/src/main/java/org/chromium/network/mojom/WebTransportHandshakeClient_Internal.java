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

class WebTransportHandshakeClient_Internal {
  public static final Interface.Manager<
          WebTransportHandshakeClient, WebTransportHandshakeClient.Proxy>
      MANAGER =
          new Interface.Manager<WebTransportHandshakeClient, WebTransportHandshakeClient.Proxy>() {
            @Override
            public String getName() {
              return "network.mojom.WebTransportHandshakeClient";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public WebTransportHandshakeClient.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, WebTransportHandshakeClient impl) {
              return new Stub(core, impl);
            }

            @Override
            public WebTransportHandshakeClient[] buildArray(int size) {
              return new WebTransportHandshakeClient[size];
            }
          };
  private static final int ON_CONNECTION_ESTABLISHED_ORDINAL = 0;
  private static final int ON_HANDSHAKE_FAILED_ORDINAL = 1;

  WebTransportHandshakeClient_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements WebTransportHandshakeClient.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onConnectionEstablished(
        WebTransport transport,
        InterfaceRequest<WebTransportClient> client,
        HttpResponseHeaders responseHeaders,
        WebTransportStats initialStats) {
      WebTransportHandshakeClientOnConnectionEstablishedParams _message =
          new WebTransportHandshakeClientOnConnectionEstablishedParams();
      _message.transport = transport;
      _message.client = client;
      _message.responseHeaders = responseHeaders;
      _message.initialStats = initialStats;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void onHandshakeFailed(WebTransportError error) {
      WebTransportHandshakeClientOnHandshakeFailedParams _message =
          new WebTransportHandshakeClientOnHandshakeFailedParams();
      _message.error = error;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }
  }

  public static final class Stub extends Interface.Stub<WebTransportHandshakeClient> {
    Stub(Core core, WebTransportHandshakeClient impl) {
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
                WebTransportHandshakeClient_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            WebTransportHandshakeClientOnConnectionEstablishedParams data =
                WebTransportHandshakeClientOnConnectionEstablishedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .onConnectionEstablished(
                    data.transport, data.client, data.responseHeaders, data.initialStats);
            return true;
          case 1:
            getImpl()
                .onHandshakeFailed(
                    WebTransportHandshakeClientOnHandshakeFailedParams.deserialize(
                            messageWithHeader.getPayload())
                        .error);
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
                getCore(),
                WebTransportHandshakeClient_Internal.MANAGER,
                messageWithHeader,
                receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class WebTransportHandshakeClientOnConnectionEstablishedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<WebTransportClient> client;
    public WebTransportStats initialStats;
    public HttpResponseHeaders responseHeaders;
    public WebTransport transport;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebTransportHandshakeClientOnConnectionEstablishedParams(int version) {
      super(40, version);
    }

    public WebTransportHandshakeClientOnConnectionEstablishedParams() {
      this(0);
    }

    public static WebTransportHandshakeClientOnConnectionEstablishedParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static WebTransportHandshakeClientOnConnectionEstablishedParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebTransportHandshakeClientOnConnectionEstablishedParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebTransportHandshakeClientOnConnectionEstablishedParams result =
            new WebTransportHandshakeClientOnConnectionEstablishedParams(elementsOrVersion);
        result.transport =
            (WebTransport) decoder0.readServiceInterface(8, false, WebTransport.MANAGER);
        result.client = decoder0.readInterfaceRequest(16, false);
        Decoder decoder1 = decoder0.readPointer(24, false);
        result.responseHeaders = HttpResponseHeaders.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(32, false);
        result.initialStats = WebTransportStats.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.transport, 8, false, WebTransport.MANAGER);
      encoder0.encode((InterfaceRequest) this.client, 16, false);
      encoder0.encode((Struct) this.responseHeaders, 24, false);
      encoder0.encode((Struct) this.initialStats, 32, false);
    }
  }

  static final class WebTransportHandshakeClientOnHandshakeFailedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public WebTransportError error;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebTransportHandshakeClientOnHandshakeFailedParams(int version) {
      super(16, version);
    }

    public WebTransportHandshakeClientOnHandshakeFailedParams() {
      this(0);
    }

    public static WebTransportHandshakeClientOnHandshakeFailedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WebTransportHandshakeClientOnHandshakeFailedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebTransportHandshakeClientOnHandshakeFailedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebTransportHandshakeClientOnHandshakeFailedParams result =
            new WebTransportHandshakeClientOnHandshakeFailedParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.error = WebTransportError.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.error, 8, true);
    }
  }
}
