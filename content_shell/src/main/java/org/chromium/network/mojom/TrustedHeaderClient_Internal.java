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
import org.chromium.url.mojom.Url;

class TrustedHeaderClient_Internal {
  public static final Interface.Manager<TrustedHeaderClient, TrustedHeaderClient.Proxy> MANAGER =
      new Interface.Manager<TrustedHeaderClient, TrustedHeaderClient.Proxy>() {
        @Override
        public String getName() {
          return "network.mojom.TrustedHeaderClient";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public TrustedHeaderClient.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, TrustedHeaderClient impl) {
          return new Stub(core, impl);
        }

        @Override
        public TrustedHeaderClient[] buildArray(int size) {
          return new TrustedHeaderClient[size];
        }
      };
  private static final int ON_BEFORE_SEND_HEADERS_ORDINAL = 0;
  private static final int ON_HEADERS_RECEIVED_ORDINAL = 1;

  TrustedHeaderClient_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements TrustedHeaderClient.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onBeforeSendHeaders(
        HttpRequestHeaders headers, TrustedHeaderClient.OnBeforeSendHeaders_Response callback) {
      TrustedHeaderClientOnBeforeSendHeadersParams _message =
          new TrustedHeaderClientOnBeforeSendHeadersParams();
      _message.headers = headers;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new TrustedHeaderClientOnBeforeSendHeadersResponseParamsForwardToCallback(callback));
    }

    @Override
    public void onHeadersReceived(
        String headers,
        IpEndPoint remoteEndpoint,
        TrustedHeaderClient.OnHeadersReceived_Response callback) {
      TrustedHeaderClientOnHeadersReceivedParams _message =
          new TrustedHeaderClientOnHeadersReceivedParams();
      _message.headers = headers;
      _message.remoteEndpoint = remoteEndpoint;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new TrustedHeaderClientOnHeadersReceivedResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<TrustedHeaderClient> {
    Stub(Core core, TrustedHeaderClient impl) {
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
                TrustedHeaderClient_Internal.MANAGER, messageWithHeader);
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
                getCore(), TrustedHeaderClient_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            getImpl()
                .onBeforeSendHeaders(
                    TrustedHeaderClientOnBeforeSendHeadersParams.deserialize(
                            messageWithHeader.getPayload())
                        .headers,
                    new TrustedHeaderClientOnBeforeSendHeadersResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
            TrustedHeaderClientOnHeadersReceivedParams data =
                TrustedHeaderClientOnHeadersReceivedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .onHeadersReceived(
                    data.headers,
                    data.remoteEndpoint,
                    new TrustedHeaderClientOnHeadersReceivedResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class TrustedHeaderClientOnBeforeSendHeadersParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public HttpRequestHeaders headers;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private TrustedHeaderClientOnBeforeSendHeadersParams(int version) {
      super(16, version);
    }

    public TrustedHeaderClientOnBeforeSendHeadersParams() {
      this(0);
    }

    public static TrustedHeaderClientOnBeforeSendHeadersParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static TrustedHeaderClientOnBeforeSendHeadersParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static TrustedHeaderClientOnBeforeSendHeadersParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        TrustedHeaderClientOnBeforeSendHeadersParams result =
            new TrustedHeaderClientOnBeforeSendHeadersParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.headers = HttpRequestHeaders.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.headers, 8, false);
    }
  }

  static final class TrustedHeaderClientOnBeforeSendHeadersResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public HttpRequestHeaders headers;
    public int result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private TrustedHeaderClientOnBeforeSendHeadersResponseParams(int version) {
      super(24, version);
    }

    public TrustedHeaderClientOnBeforeSendHeadersResponseParams() {
      this(0);
    }

    public static TrustedHeaderClientOnBeforeSendHeadersResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static TrustedHeaderClientOnBeforeSendHeadersResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static TrustedHeaderClientOnBeforeSendHeadersResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        TrustedHeaderClientOnBeforeSendHeadersResponseParams result =
            new TrustedHeaderClientOnBeforeSendHeadersResponseParams(elementsOrVersion);
        result.result = decoder0.readInt(8);
        Decoder decoder1 = decoder0.readPointer(16, true);
        result.headers = HttpRequestHeaders.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.result, 8);
      encoder0.encode((Struct) this.headers, 16, true);
    }
  }

  static class TrustedHeaderClientOnBeforeSendHeadersResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final TrustedHeaderClient.OnBeforeSendHeaders_Response mCallback;

    TrustedHeaderClientOnBeforeSendHeadersResponseParamsForwardToCallback(
        TrustedHeaderClient.OnBeforeSendHeaders_Response callback) {
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
        TrustedHeaderClientOnBeforeSendHeadersResponseParams response =
            TrustedHeaderClientOnBeforeSendHeadersResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result, response.headers);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class TrustedHeaderClientOnBeforeSendHeadersResponseParamsProxyToResponder
      implements TrustedHeaderClient.OnBeforeSendHeaders_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    TrustedHeaderClientOnBeforeSendHeadersResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int result, HttpRequestHeaders headers) {
      TrustedHeaderClientOnBeforeSendHeadersResponseParams _response =
          new TrustedHeaderClientOnBeforeSendHeadersResponseParams();
      _response.result = result;
      _response.headers = headers;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class TrustedHeaderClientOnHeadersReceivedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public String headers;
    public IpEndPoint remoteEndpoint;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private TrustedHeaderClientOnHeadersReceivedParams(int version) {
      super(24, version);
    }

    public TrustedHeaderClientOnHeadersReceivedParams() {
      this(0);
    }

    public static TrustedHeaderClientOnHeadersReceivedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static TrustedHeaderClientOnHeadersReceivedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static TrustedHeaderClientOnHeadersReceivedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        TrustedHeaderClientOnHeadersReceivedParams result =
            new TrustedHeaderClientOnHeadersReceivedParams(elementsOrVersion);
        result.headers = decoder0.readString(8, false);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.remoteEndpoint = IpEndPoint.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.headers, 8, false);
      encoder0.encode((Struct) this.remoteEndpoint, 16, false);
    }
  }

  static final class TrustedHeaderClientOnHeadersReceivedResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public String headers;
    public Url preserveFragmentOnRedirectUrl;
    public int result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private TrustedHeaderClientOnHeadersReceivedResponseParams(int version) {
      super(32, version);
    }

    public TrustedHeaderClientOnHeadersReceivedResponseParams() {
      this(0);
    }

    public static TrustedHeaderClientOnHeadersReceivedResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static TrustedHeaderClientOnHeadersReceivedResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static TrustedHeaderClientOnHeadersReceivedResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        TrustedHeaderClientOnHeadersReceivedResponseParams result =
            new TrustedHeaderClientOnHeadersReceivedResponseParams(elementsOrVersion);
        result.result = decoder0.readInt(8);
        result.headers = decoder0.readString(16, true);
        Decoder decoder1 = decoder0.readPointer(24, true);
        result.preserveFragmentOnRedirectUrl = Url.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.result, 8);
      encoder0.encode(this.headers, 16, true);
      encoder0.encode((Struct) this.preserveFragmentOnRedirectUrl, 24, true);
    }
  }

  static class TrustedHeaderClientOnHeadersReceivedResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final TrustedHeaderClient.OnHeadersReceived_Response mCallback;

    TrustedHeaderClientOnHeadersReceivedResponseParamsForwardToCallback(
        TrustedHeaderClient.OnHeadersReceived_Response callback) {
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
        TrustedHeaderClientOnHeadersReceivedResponseParams response =
            TrustedHeaderClientOnHeadersReceivedResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(
            response.result, response.headers, response.preserveFragmentOnRedirectUrl);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class TrustedHeaderClientOnHeadersReceivedResponseParamsProxyToResponder
      implements TrustedHeaderClient.OnHeadersReceived_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    TrustedHeaderClientOnHeadersReceivedResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int result, String headers, Url preserveFragmentOnRedirectUrl) {
      TrustedHeaderClientOnHeadersReceivedResponseParams _response =
          new TrustedHeaderClientOnHeadersReceivedResponseParams();
      _response.result = result;
      _response.headers = headers;
      _response.preserveFragmentOnRedirectUrl = preserveFragmentOnRedirectUrl;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
