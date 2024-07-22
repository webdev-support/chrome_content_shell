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
import org.chromium.url.internal.mojom.Origin;

class TrustTokenQueryAnswerer_Internal {
  private static final int HAS_REDEMPTION_RECORD_ORDINAL = 1;
  private static final int HAS_TRUST_TOKENS_ORDINAL = 0;
  public static final Interface.Manager<TrustTokenQueryAnswerer, TrustTokenQueryAnswerer.Proxy>
      MANAGER =
          new Interface.Manager<TrustTokenQueryAnswerer, TrustTokenQueryAnswerer.Proxy>() {
            @Override
            public String getName() {
              return "network.mojom.TrustTokenQueryAnswerer";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public TrustTokenQueryAnswerer.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, TrustTokenQueryAnswerer impl) {
              return new Stub(core, impl);
            }

            @Override
            public TrustTokenQueryAnswerer[] buildArray(int size) {
              return new TrustTokenQueryAnswerer[size];
            }
          };

  TrustTokenQueryAnswerer_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements TrustTokenQueryAnswerer.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void hasTrustTokens(
        Origin issuer, TrustTokenQueryAnswerer.HasTrustTokens_Response callback) {
      TrustTokenQueryAnswererHasTrustTokensParams _message =
          new TrustTokenQueryAnswererHasTrustTokensParams();
      _message.issuer = issuer;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new TrustTokenQueryAnswererHasTrustTokensResponseParamsForwardToCallback(callback));
    }

    @Override
    public void hasRedemptionRecord(
        Origin issuer, TrustTokenQueryAnswerer.HasRedemptionRecord_Response callback) {
      TrustTokenQueryAnswererHasRedemptionRecordParams _message =
          new TrustTokenQueryAnswererHasRedemptionRecordParams();
      _message.issuer = issuer;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new TrustTokenQueryAnswererHasRedemptionRecordResponseParamsForwardToCallback(
                  callback));
    }
  }

  public static final class Stub extends Interface.Stub<TrustTokenQueryAnswerer> {
    Stub(Core core, TrustTokenQueryAnswerer impl) {
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
                TrustTokenQueryAnswerer_Internal.MANAGER, messageWithHeader);
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
                getCore(), TrustTokenQueryAnswerer_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            TrustTokenQueryAnswererHasTrustTokensParams data =
                TrustTokenQueryAnswererHasTrustTokensParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .hasTrustTokens(
                    data.issuer,
                    new TrustTokenQueryAnswererHasTrustTokensResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
            TrustTokenQueryAnswererHasRedemptionRecordParams data2 =
                TrustTokenQueryAnswererHasRedemptionRecordParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .hasRedemptionRecord(
                    data2.issuer,
                    new TrustTokenQueryAnswererHasRedemptionRecordResponseParamsProxyToResponder(
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

  static final class TrustTokenQueryAnswererHasTrustTokensParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Origin issuer;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private TrustTokenQueryAnswererHasTrustTokensParams(int version) {
      super(16, version);
    }

    public TrustTokenQueryAnswererHasTrustTokensParams() {
      this(0);
    }

    public static TrustTokenQueryAnswererHasTrustTokensParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static TrustTokenQueryAnswererHasTrustTokensParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static TrustTokenQueryAnswererHasTrustTokensParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        TrustTokenQueryAnswererHasTrustTokensParams result =
            new TrustTokenQueryAnswererHasTrustTokensParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.issuer = Origin.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.issuer, 8, false);
    }
  }

  static final class TrustTokenQueryAnswererHasTrustTokensResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public HasTrustTokensResult result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private TrustTokenQueryAnswererHasTrustTokensResponseParams(int version) {
      super(16, version);
    }

    public TrustTokenQueryAnswererHasTrustTokensResponseParams() {
      this(0);
    }

    public static TrustTokenQueryAnswererHasTrustTokensResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static TrustTokenQueryAnswererHasTrustTokensResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static TrustTokenQueryAnswererHasTrustTokensResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        TrustTokenQueryAnswererHasTrustTokensResponseParams result =
            new TrustTokenQueryAnswererHasTrustTokensResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.result = HasTrustTokensResult.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.result, 8, false);
    }
  }

  static class TrustTokenQueryAnswererHasTrustTokensResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final TrustTokenQueryAnswerer.HasTrustTokens_Response mCallback;

    TrustTokenQueryAnswererHasTrustTokensResponseParamsForwardToCallback(
        TrustTokenQueryAnswerer.HasTrustTokens_Response callback) {
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
        TrustTokenQueryAnswererHasTrustTokensResponseParams response =
            TrustTokenQueryAnswererHasTrustTokensResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class TrustTokenQueryAnswererHasTrustTokensResponseParamsProxyToResponder
      implements TrustTokenQueryAnswerer.HasTrustTokens_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    TrustTokenQueryAnswererHasTrustTokensResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(HasTrustTokensResult result) {
      TrustTokenQueryAnswererHasTrustTokensResponseParams _response =
          new TrustTokenQueryAnswererHasTrustTokensResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class TrustTokenQueryAnswererHasRedemptionRecordParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Origin issuer;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private TrustTokenQueryAnswererHasRedemptionRecordParams(int version) {
      super(16, version);
    }

    public TrustTokenQueryAnswererHasRedemptionRecordParams() {
      this(0);
    }

    public static TrustTokenQueryAnswererHasRedemptionRecordParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static TrustTokenQueryAnswererHasRedemptionRecordParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static TrustTokenQueryAnswererHasRedemptionRecordParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        TrustTokenQueryAnswererHasRedemptionRecordParams result =
            new TrustTokenQueryAnswererHasRedemptionRecordParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.issuer = Origin.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.issuer, 8, false);
    }
  }

  static final class TrustTokenQueryAnswererHasRedemptionRecordResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public HasRedemptionRecordResult result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private TrustTokenQueryAnswererHasRedemptionRecordResponseParams(int version) {
      super(16, version);
    }

    public TrustTokenQueryAnswererHasRedemptionRecordResponseParams() {
      this(0);
    }

    public static TrustTokenQueryAnswererHasRedemptionRecordResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static TrustTokenQueryAnswererHasRedemptionRecordResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static TrustTokenQueryAnswererHasRedemptionRecordResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        TrustTokenQueryAnswererHasRedemptionRecordResponseParams result =
            new TrustTokenQueryAnswererHasRedemptionRecordResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.result = HasRedemptionRecordResult.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.result, 8, false);
    }
  }

  static class TrustTokenQueryAnswererHasRedemptionRecordResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final TrustTokenQueryAnswerer.HasRedemptionRecord_Response mCallback;

    TrustTokenQueryAnswererHasRedemptionRecordResponseParamsForwardToCallback(
        TrustTokenQueryAnswerer.HasRedemptionRecord_Response callback) {
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
        TrustTokenQueryAnswererHasRedemptionRecordResponseParams response =
            TrustTokenQueryAnswererHasRedemptionRecordResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class TrustTokenQueryAnswererHasRedemptionRecordResponseParamsProxyToResponder
      implements TrustTokenQueryAnswerer.HasRedemptionRecord_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    TrustTokenQueryAnswererHasRedemptionRecordResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(HasRedemptionRecordResult result) {
      TrustTokenQueryAnswererHasRedemptionRecordResponseParams _response =
          new TrustTokenQueryAnswererHasRedemptionRecordResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
