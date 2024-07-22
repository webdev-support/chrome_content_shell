package org.chromium.blink.mojom;

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
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;
import org.chromium.mojo_base.mojom.UnguessableToken;

class BlobUrlToken_Internal {
  private static final int CLONE_ORDINAL = 0;
  private static final int GET_TOKEN_ORDINAL = 1;
  public static final Interface.Manager<BlobUrlToken, BlobUrlToken.Proxy> MANAGER =
      new Interface.Manager<BlobUrlToken, BlobUrlToken.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.BlobURLToken";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public BlobUrlToken.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, BlobUrlToken impl) {
          return new Stub(core, impl);
        }

        @Override
        public BlobUrlToken[] buildArray(int size) {
          return new BlobUrlToken[size];
        }
      };

  BlobUrlToken_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements BlobUrlToken.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void clone(InterfaceRequest<BlobUrlToken> token) {
      BlobUrlTokenCloneParams _message = new BlobUrlTokenCloneParams();
      _message.token = token;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void getToken(GetToken_Response callback) {
      BlobUrlTokenGetTokenParams _message = new BlobUrlTokenGetTokenParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new BlobUrlTokenGetTokenResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<BlobUrlToken> {
    Stub(Core core, BlobUrlToken impl) {
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
                BlobUrlToken_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            BlobUrlTokenCloneParams data =
                BlobUrlTokenCloneParams.deserialize(messageWithHeader.getPayload());
            getImpl().clone(data.token);
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
                getCore(), BlobUrlToken_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
          default:
            return false;
          case 1:
            BlobUrlTokenGetTokenParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .getToken(
                    new BlobUrlTokenGetTokenResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class BlobUrlTokenCloneParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<BlobUrlToken> token;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private BlobUrlTokenCloneParams(int version) {
      super(16, version);
    }

    public BlobUrlTokenCloneParams() {
      this(0);
    }

    public static BlobUrlTokenCloneParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static BlobUrlTokenCloneParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static BlobUrlTokenCloneParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        BlobUrlTokenCloneParams result = new BlobUrlTokenCloneParams(elementsOrVersion);
        result.token = decoder0.readInterfaceRequest(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.token, 8, false);
    }
  }

  static final class BlobUrlTokenGetTokenParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private BlobUrlTokenGetTokenParams(int version) {
      super(8, version);
    }

    public BlobUrlTokenGetTokenParams() {
      this(0);
    }

    public static BlobUrlTokenGetTokenParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static BlobUrlTokenGetTokenParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static BlobUrlTokenGetTokenParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        BlobUrlTokenGetTokenParams result = new BlobUrlTokenGetTokenParams(elementsOrVersion);
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

  static final class BlobUrlTokenGetTokenResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public UnguessableToken token;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private BlobUrlTokenGetTokenResponseParams(int version) {
      super(16, version);
    }

    public BlobUrlTokenGetTokenResponseParams() {
      this(0);
    }

    public static BlobUrlTokenGetTokenResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static BlobUrlTokenGetTokenResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static BlobUrlTokenGetTokenResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        BlobUrlTokenGetTokenResponseParams result =
            new BlobUrlTokenGetTokenResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.token = UnguessableToken.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.token, 8, false);
    }
  }

  static class BlobUrlTokenGetTokenResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final BlobUrlToken.GetToken_Response mCallback;

    BlobUrlTokenGetTokenResponseParamsForwardToCallback(BlobUrlToken.GetToken_Response callback) {
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
        BlobUrlTokenGetTokenResponseParams response =
            BlobUrlTokenGetTokenResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.token);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class BlobUrlTokenGetTokenResponseParamsProxyToResponder
      implements BlobUrlToken.GetToken_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    BlobUrlTokenGetTokenResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(UnguessableToken token) {
      BlobUrlTokenGetTokenResponseParams _response = new BlobUrlTokenGetTokenResponseParams();
      _response.token = token;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
