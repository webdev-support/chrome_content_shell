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

class CustomProxyConnectionObserver_Internal {
  public static final Interface.Manager<
          CustomProxyConnectionObserver, CustomProxyConnectionObserver.Proxy>
      MANAGER =
          new Interface.Manager<
              CustomProxyConnectionObserver, CustomProxyConnectionObserver.Proxy>() {
            @Override
            public String getName() {
              return "network.mojom.CustomProxyConnectionObserver";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public CustomProxyConnectionObserver.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, CustomProxyConnectionObserver impl) {
              return new Stub(core, impl);
            }

            @Override
            public CustomProxyConnectionObserver[] buildArray(int size) {
              return new CustomProxyConnectionObserver[size];
            }
          };
  private static final int ON_FALLBACK_ORDINAL = 0;
  private static final int ON_TUNNEL_HEADERS_RECEIVED_ORDINAL = 1;

  CustomProxyConnectionObserver_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements CustomProxyConnectionObserver.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onFallback(ProxyChain badChain, int netError) {
      CustomProxyConnectionObserverOnFallbackParams _message =
          new CustomProxyConnectionObserverOnFallbackParams();
      _message.badChain = badChain;
      _message.netError = netError;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void onTunnelHeadersReceived(
        ProxyChain proxyChain, long chainIndex, HttpResponseHeaders responseHeaders) {
      CustomProxyConnectionObserverOnTunnelHeadersReceivedParams _message =
          new CustomProxyConnectionObserverOnTunnelHeadersReceivedParams();
      _message.proxyChain = proxyChain;
      _message.chainIndex = chainIndex;
      _message.responseHeaders = responseHeaders;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }
  }

  public static final class Stub extends Interface.Stub<CustomProxyConnectionObserver> {
    Stub(Core core, CustomProxyConnectionObserver impl) {
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
                CustomProxyConnectionObserver_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            CustomProxyConnectionObserverOnFallbackParams data =
                CustomProxyConnectionObserverOnFallbackParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onFallback(data.badChain, data.netError);
            return true;
          case 1:
            CustomProxyConnectionObserverOnTunnelHeadersReceivedParams data2 =
                CustomProxyConnectionObserverOnTunnelHeadersReceivedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .onTunnelHeadersReceived(data2.proxyChain, data2.chainIndex, data2.responseHeaders);
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
                CustomProxyConnectionObserver_Internal.MANAGER,
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

  static final class CustomProxyConnectionObserverOnFallbackParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public ProxyChain badChain;
    public int netError;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CustomProxyConnectionObserverOnFallbackParams(int version) {
      super(24, version);
    }

    public CustomProxyConnectionObserverOnFallbackParams() {
      this(0);
    }

    public static CustomProxyConnectionObserverOnFallbackParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CustomProxyConnectionObserverOnFallbackParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CustomProxyConnectionObserverOnFallbackParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CustomProxyConnectionObserverOnFallbackParams result =
            new CustomProxyConnectionObserverOnFallbackParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.badChain = ProxyChain.decode(decoder1);
        result.netError = decoder0.readInt(16);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.badChain, 8, false);
      encoder0.encode(this.netError, 16);
    }
  }

  static final class CustomProxyConnectionObserverOnTunnelHeadersReceivedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public long chainIndex;
    public ProxyChain proxyChain;
    public HttpResponseHeaders responseHeaders;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CustomProxyConnectionObserverOnTunnelHeadersReceivedParams(int version) {
      super(32, version);
    }

    public CustomProxyConnectionObserverOnTunnelHeadersReceivedParams() {
      this(0);
    }

    public static CustomProxyConnectionObserverOnTunnelHeadersReceivedParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static CustomProxyConnectionObserverOnTunnelHeadersReceivedParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CustomProxyConnectionObserverOnTunnelHeadersReceivedParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CustomProxyConnectionObserverOnTunnelHeadersReceivedParams result =
            new CustomProxyConnectionObserverOnTunnelHeadersReceivedParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.proxyChain = ProxyChain.decode(decoder1);
        result.chainIndex = decoder0.readLong(16);
        Decoder decoder12 = decoder0.readPointer(24, false);
        result.responseHeaders = HttpResponseHeaders.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.proxyChain, 8, false);
      encoder0.encode(this.chainIndex, 16);
      encoder0.encode((Struct) this.responseHeaders, 24, false);
    }
  }
}
