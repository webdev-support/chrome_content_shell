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
import org.chromium.mojo_base.mojom.Time;

class IpProtectionConfigGetter_Internal {
  private static final int GET_PROXY_LIST_ORDINAL = 1;
  public static final Interface.Manager<IpProtectionConfigGetter, IpProtectionConfigGetter.Proxy>
      MANAGER =
          new Interface.Manager<IpProtectionConfigGetter, IpProtectionConfigGetter.Proxy>() {
            @Override
            public String getName() {
              return "network.mojom.IpProtectionConfigGetter";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public IpProtectionConfigGetter.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, IpProtectionConfigGetter impl) {
              return new Stub(core, impl);
            }

            @Override
            public IpProtectionConfigGetter[] buildArray(int size) {
              return new IpProtectionConfigGetter[size];
            }
          };
  private static final int TRY_GET_AUTH_TOKENS_ORDINAL = 0;

  IpProtectionConfigGetter_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements IpProtectionConfigGetter.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void tryGetAuthTokens(
        int batchSize,
        int proxyLayer,
        IpProtectionConfigGetter.TryGetAuthTokens_Response callback) {
      IpProtectionConfigGetterTryGetAuthTokensParams _message =
          new IpProtectionConfigGetterTryGetAuthTokensParams();
      _message.batchSize = batchSize;
      _message.proxyLayer = proxyLayer;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new IpProtectionConfigGetterTryGetAuthTokensResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void getProxyList(IpProtectionConfigGetter.GetProxyList_Response callback) {
      IpProtectionConfigGetterGetProxyListParams _message =
          new IpProtectionConfigGetterGetProxyListParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new IpProtectionConfigGetterGetProxyListResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<IpProtectionConfigGetter> {
    Stub(Core core, IpProtectionConfigGetter impl) {
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
                IpProtectionConfigGetter_Internal.MANAGER, messageWithHeader);
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
                getCore(), IpProtectionConfigGetter_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            IpProtectionConfigGetterTryGetAuthTokensParams data =
                IpProtectionConfigGetterTryGetAuthTokensParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .tryGetAuthTokens(
                    data.batchSize,
                    data.proxyLayer,
                    new IpProtectionConfigGetterTryGetAuthTokensResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
            IpProtectionConfigGetterGetProxyListParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .getProxyList(
                    new IpProtectionConfigGetterGetProxyListResponseParamsProxyToResponder(
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

  static final class IpProtectionConfigGetterTryGetAuthTokensParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int batchSize;
    public int proxyLayer;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private IpProtectionConfigGetterTryGetAuthTokensParams(int version) {
      super(16, version);
    }

    public IpProtectionConfigGetterTryGetAuthTokensParams() {
      this(0);
    }

    public static IpProtectionConfigGetterTryGetAuthTokensParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static IpProtectionConfigGetterTryGetAuthTokensParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static IpProtectionConfigGetterTryGetAuthTokensParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        IpProtectionConfigGetterTryGetAuthTokensParams result =
            new IpProtectionConfigGetterTryGetAuthTokensParams(elementsOrVersion);
        result.batchSize = decoder0.readInt(8);
        int readInt = decoder0.readInt(12);
        result.proxyLayer = readInt;
        IpProtectionProxyLayer.validate(readInt);
        result.proxyLayer = IpProtectionProxyLayer.toKnownValue(result.proxyLayer);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.batchSize, 8);
      encoder0.encode(this.proxyLayer, 12);
    }
  }

  static final class IpProtectionConfigGetterTryGetAuthTokensResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public BlindSignedAuthToken[] bsaTokens;
    public Time tryAgainAfter;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private IpProtectionConfigGetterTryGetAuthTokensResponseParams(int version) {
      super(24, version);
    }

    public IpProtectionConfigGetterTryGetAuthTokensResponseParams() {
      this(0);
    }

    public static IpProtectionConfigGetterTryGetAuthTokensResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static IpProtectionConfigGetterTryGetAuthTokensResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static IpProtectionConfigGetterTryGetAuthTokensResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        IpProtectionConfigGetterTryGetAuthTokensResponseParams result =
            new IpProtectionConfigGetterTryGetAuthTokensResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        if (decoder1 == null) {
          result.bsaTokens = null;
        } else {
          DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
          result.bsaTokens = new BlindSignedAuthToken[si1.elementsOrVersion];
          for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
            Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
            result.bsaTokens[i1] = BlindSignedAuthToken.decode(decoder2);
          }
        }
        result.tryAgainAfter = Time.decode(decoder0.readPointer(16, true));
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      BlindSignedAuthToken[] blindSignedAuthTokenArr = this.bsaTokens;
      if (blindSignedAuthTokenArr == null) {
        encoder0.encodeNullPointer(8, true);
      } else {
        Encoder encoder1 = encoder0.encodePointerArray(blindSignedAuthTokenArr.length, 8, -1);
        int i0 = 0;
        while (true) {
          BlindSignedAuthToken[] blindSignedAuthTokenArr2 = this.bsaTokens;
          if (i0 >= blindSignedAuthTokenArr2.length) {
            break;
          }
          encoder1.encode((Struct) blindSignedAuthTokenArr2[i0], (i0 * 8) + 8, false);
          i0++;
        }
      }
      encoder0.encode((Struct) this.tryAgainAfter, 16, true);
    }
  }

  static class IpProtectionConfigGetterTryGetAuthTokensResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final IpProtectionConfigGetter.TryGetAuthTokens_Response mCallback;

    IpProtectionConfigGetterTryGetAuthTokensResponseParamsForwardToCallback(
        IpProtectionConfigGetter.TryGetAuthTokens_Response callback) {
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
        IpProtectionConfigGetterTryGetAuthTokensResponseParams response =
            IpProtectionConfigGetterTryGetAuthTokensResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.bsaTokens, response.tryAgainAfter);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class IpProtectionConfigGetterTryGetAuthTokensResponseParamsProxyToResponder
      implements IpProtectionConfigGetter.TryGetAuthTokens_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    IpProtectionConfigGetterTryGetAuthTokensResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(BlindSignedAuthToken[] bsaTokens, Time tryAgainAfter) {
      IpProtectionConfigGetterTryGetAuthTokensResponseParams _response =
          new IpProtectionConfigGetterTryGetAuthTokensResponseParams();
      _response.bsaTokens = bsaTokens;
      _response.tryAgainAfter = tryAgainAfter;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class IpProtectionConfigGetterGetProxyListParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private IpProtectionConfigGetterGetProxyListParams(int version) {
      super(8, version);
    }

    public IpProtectionConfigGetterGetProxyListParams() {
      this(0);
    }

    public static IpProtectionConfigGetterGetProxyListParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static IpProtectionConfigGetterGetProxyListParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static IpProtectionConfigGetterGetProxyListParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        IpProtectionConfigGetterGetProxyListParams result =
            new IpProtectionConfigGetterGetProxyListParams(elementsOrVersion);
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

  static final class IpProtectionConfigGetterGetProxyListResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public ProxyChain[] proxyList;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private IpProtectionConfigGetterGetProxyListResponseParams(int version) {
      super(16, version);
    }

    public IpProtectionConfigGetterGetProxyListResponseParams() {
      this(0);
    }

    public static IpProtectionConfigGetterGetProxyListResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static IpProtectionConfigGetterGetProxyListResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static IpProtectionConfigGetterGetProxyListResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        IpProtectionConfigGetterGetProxyListResponseParams result =
            new IpProtectionConfigGetterGetProxyListResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        if (decoder1 == null) {
          result.proxyList = null;
        } else {
          DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
          result.proxyList = new ProxyChain[si1.elementsOrVersion];
          for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
            Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
            result.proxyList[i1] = ProxyChain.decode(decoder2);
          }
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      ProxyChain[] proxyChainArr = this.proxyList;
      if (proxyChainArr == null) {
        encoder0.encodeNullPointer(8, true);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(proxyChainArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        ProxyChain[] proxyChainArr2 = this.proxyList;
        if (i0 < proxyChainArr2.length) {
          encoder1.encode((Struct) proxyChainArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static class IpProtectionConfigGetterGetProxyListResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final IpProtectionConfigGetter.GetProxyList_Response mCallback;

    IpProtectionConfigGetterGetProxyListResponseParamsForwardToCallback(
        IpProtectionConfigGetter.GetProxyList_Response callback) {
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
        IpProtectionConfigGetterGetProxyListResponseParams response =
            IpProtectionConfigGetterGetProxyListResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.proxyList);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class IpProtectionConfigGetterGetProxyListResponseParamsProxyToResponder
      implements IpProtectionConfigGetter.GetProxyList_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    IpProtectionConfigGetterGetProxyListResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(ProxyChain[] proxyList) {
      IpProtectionConfigGetterGetProxyListResponseParams _response =
          new IpProtectionConfigGetterGetProxyListResponseParams();
      _response.proxyList = proxyList;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
