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

class SslPrivateKey_Internal {
  public static final Interface.Manager<SslPrivateKey, SslPrivateKey.Proxy> MANAGER =
      new Interface.Manager<SslPrivateKey, SslPrivateKey.Proxy>() {
        @Override
        public String getName() {
          return "network.mojom.SSLPrivateKey";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public SslPrivateKey.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, SslPrivateKey impl) {
          return new Stub(core, impl);
        }

        @Override
        public SslPrivateKey[] buildArray(int size) {
          return new SslPrivateKey[size];
        }
      };
  private static final int SIGN_ORDINAL = 0;

  SslPrivateKey_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements SslPrivateKey.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void sign(short algorithm, byte[] input, SslPrivateKey.Sign_Response callback) {
      SslPrivateKeySignParams _message = new SslPrivateKeySignParams();
      _message.algorithm = algorithm;
      _message.input = input;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new SslPrivateKeySignResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<SslPrivateKey> {
    Stub(Core core, SslPrivateKey impl) {
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
                SslPrivateKey_Internal.MANAGER, messageWithHeader);
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
                getCore(), SslPrivateKey_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            SslPrivateKeySignParams data =
                SslPrivateKeySignParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .sign(
                    data.algorithm,
                    data.input,
                    new SslPrivateKeySignResponseParamsProxyToResponder(
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

  static final class SslPrivateKeySignParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public short algorithm;
    public byte[] input;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SslPrivateKeySignParams(int version) {
      super(24, version);
    }

    public SslPrivateKeySignParams() {
      this(0);
    }

    public static SslPrivateKeySignParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SslPrivateKeySignParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SslPrivateKeySignParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SslPrivateKeySignParams result = new SslPrivateKeySignParams(elementsOrVersion);
        result.algorithm = decoder0.readShort(8);
        result.input = decoder0.readBytes(16, 0, -1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.algorithm, 8);
      encoder0.encode(this.input, 16, 0, -1);
    }
  }

  static final class SslPrivateKeySignResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int netError;
    public byte[] signature;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SslPrivateKeySignResponseParams(int version) {
      super(24, version);
    }

    public SslPrivateKeySignResponseParams() {
      this(0);
    }

    public static SslPrivateKeySignResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SslPrivateKeySignResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SslPrivateKeySignResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SslPrivateKeySignResponseParams result =
            new SslPrivateKeySignResponseParams(elementsOrVersion);
        result.netError = decoder0.readInt(8);
        result.signature = decoder0.readBytes(16, 0, -1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.netError, 8);
      encoder0.encode(this.signature, 16, 0, -1);
    }
  }

  static class SslPrivateKeySignResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final SslPrivateKey.Sign_Response mCallback;

    SslPrivateKeySignResponseParamsForwardToCallback(SslPrivateKey.Sign_Response callback) {
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
        SslPrivateKeySignResponseParams response =
            SslPrivateKeySignResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.netError, response.signature);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class SslPrivateKeySignResponseParamsProxyToResponder
      implements SslPrivateKey.Sign_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    SslPrivateKeySignResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int netError, byte[] signature) {
      SslPrivateKeySignResponseParams _response = new SslPrivateKeySignResponseParams();
      _response.netError = netError;
      _response.signature = signature;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
