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

class ProxyConfigClient_Internal {
  private static final int FLUSH_PROXY_CONFIG_ORDINAL = 1;
  public static final Interface.Manager<ProxyConfigClient, ProxyConfigClient.Proxy> MANAGER =
      new Interface.Manager<ProxyConfigClient, ProxyConfigClient.Proxy>() {
        @Override
        public String getName() {
          return "network.mojom.ProxyConfigClient";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public ProxyConfigClient.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, ProxyConfigClient impl) {
          return new Stub(core, impl);
        }

        @Override
        public ProxyConfigClient[] buildArray(int size) {
          return new ProxyConfigClient[size];
        }
      };
  private static final int ON_PROXY_CONFIG_UPDATED_ORDINAL = 0;

  ProxyConfigClient_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements ProxyConfigClient.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onProxyConfigUpdated(ProxyConfigWithAnnotation proxyConfig) {
      ProxyConfigClientOnProxyConfigUpdatedParams _message =
          new ProxyConfigClientOnProxyConfigUpdatedParams();
      _message.proxyConfig = proxyConfig;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void flushProxyConfig(ProxyConfigClient.FlushProxyConfig_Response callback) {
      ProxyConfigClientFlushProxyConfigParams _message =
          new ProxyConfigClientFlushProxyConfigParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new ProxyConfigClientFlushProxyConfigResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<ProxyConfigClient> {
    Stub(Core core, ProxyConfigClient impl) {
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
                ProxyConfigClient_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            ProxyConfigClientOnProxyConfigUpdatedParams data =
                ProxyConfigClientOnProxyConfigUpdatedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onProxyConfigUpdated(data.proxyConfig);
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
                getCore(), ProxyConfigClient_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
          default:
            return false;
          case 1:
            ProxyConfigClientFlushProxyConfigParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .flushProxyConfig(
                    new ProxyConfigClientFlushProxyConfigResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class ProxyConfigClientOnProxyConfigUpdatedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public ProxyConfigWithAnnotation proxyConfig;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ProxyConfigClientOnProxyConfigUpdatedParams(int version) {
      super(16, version);
    }

    public ProxyConfigClientOnProxyConfigUpdatedParams() {
      this(0);
    }

    public static ProxyConfigClientOnProxyConfigUpdatedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ProxyConfigClientOnProxyConfigUpdatedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ProxyConfigClientOnProxyConfigUpdatedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ProxyConfigClientOnProxyConfigUpdatedParams result =
            new ProxyConfigClientOnProxyConfigUpdatedParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.proxyConfig = ProxyConfigWithAnnotation.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.proxyConfig, 8, false);
    }
  }

  static final class ProxyConfigClientFlushProxyConfigParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ProxyConfigClientFlushProxyConfigParams(int version) {
      super(8, version);
    }

    public ProxyConfigClientFlushProxyConfigParams() {
      this(0);
    }

    public static ProxyConfigClientFlushProxyConfigParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ProxyConfigClientFlushProxyConfigParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ProxyConfigClientFlushProxyConfigParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ProxyConfigClientFlushProxyConfigParams result =
            new ProxyConfigClientFlushProxyConfigParams(elementsOrVersion);
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

  static final class ProxyConfigClientFlushProxyConfigResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ProxyConfigClientFlushProxyConfigResponseParams(int version) {
      super(8, version);
    }

    public ProxyConfigClientFlushProxyConfigResponseParams() {
      this(0);
    }

    public static ProxyConfigClientFlushProxyConfigResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ProxyConfigClientFlushProxyConfigResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ProxyConfigClientFlushProxyConfigResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ProxyConfigClientFlushProxyConfigResponseParams result =
            new ProxyConfigClientFlushProxyConfigResponseParams(elementsOrVersion);
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

  static class ProxyConfigClientFlushProxyConfigResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ProxyConfigClient.FlushProxyConfig_Response mCallback;

    ProxyConfigClientFlushProxyConfigResponseParamsForwardToCallback(
        ProxyConfigClient.FlushProxyConfig_Response callback) {
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
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ProxyConfigClientFlushProxyConfigResponseParamsProxyToResponder
      implements ProxyConfigClient.FlushProxyConfig_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ProxyConfigClientFlushProxyConfigResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      ProxyConfigClientFlushProxyConfigResponseParams _response =
          new ProxyConfigClientFlushProxyConfigResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
