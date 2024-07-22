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
import org.chromium.os_crypt_async.mojom.Encryptor;

class CookieEncryptionProvider_Internal {
  private static final int GET_ENCRYPTOR_ORDINAL = 0;
  public static final Interface.Manager<CookieEncryptionProvider, CookieEncryptionProvider.Proxy>
      MANAGER =
          new Interface.Manager<CookieEncryptionProvider, CookieEncryptionProvider.Proxy>() {
            @Override
            public String getName() {
              return "network.mojom.CookieEncryptionProvider";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public CookieEncryptionProvider.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, CookieEncryptionProvider impl) {
              return new Stub(core, impl);
            }

            @Override
            public CookieEncryptionProvider[] buildArray(int size) {
              return new CookieEncryptionProvider[size];
            }
          };

  CookieEncryptionProvider_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements CookieEncryptionProvider.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void getEncryptor(CookieEncryptionProvider.GetEncryptor_Response callback) {
      CookieEncryptionProviderGetEncryptorParams _message =
          new CookieEncryptionProviderGetEncryptorParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new CookieEncryptionProviderGetEncryptorResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<CookieEncryptionProvider> {
    Stub(Core core, CookieEncryptionProvider impl) {
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
                CookieEncryptionProvider_Internal.MANAGER, messageWithHeader);
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
                getCore(), CookieEncryptionProvider_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            CookieEncryptionProviderGetEncryptorParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .getEncryptor(
                    new CookieEncryptionProviderGetEncryptorResponseParamsProxyToResponder(
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

  static final class CookieEncryptionProviderGetEncryptorParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CookieEncryptionProviderGetEncryptorParams(int version) {
      super(8, version);
    }

    public CookieEncryptionProviderGetEncryptorParams() {
      this(0);
    }

    public static CookieEncryptionProviderGetEncryptorParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CookieEncryptionProviderGetEncryptorParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CookieEncryptionProviderGetEncryptorParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CookieEncryptionProviderGetEncryptorParams result =
            new CookieEncryptionProviderGetEncryptorParams(elementsOrVersion);
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

  static final class CookieEncryptionProviderGetEncryptorResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Encryptor encryptor;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CookieEncryptionProviderGetEncryptorResponseParams(int version) {
      super(16, version);
    }

    public CookieEncryptionProviderGetEncryptorResponseParams() {
      this(0);
    }

    public static CookieEncryptionProviderGetEncryptorResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CookieEncryptionProviderGetEncryptorResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CookieEncryptionProviderGetEncryptorResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CookieEncryptionProviderGetEncryptorResponseParams result =
            new CookieEncryptionProviderGetEncryptorResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.encryptor = Encryptor.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.encryptor, 8, false);
    }
  }

  static class CookieEncryptionProviderGetEncryptorResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final CookieEncryptionProvider.GetEncryptor_Response mCallback;

    CookieEncryptionProviderGetEncryptorResponseParamsForwardToCallback(
        CookieEncryptionProvider.GetEncryptor_Response callback) {
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
        CookieEncryptionProviderGetEncryptorResponseParams response =
            CookieEncryptionProviderGetEncryptorResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.encryptor);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class CookieEncryptionProviderGetEncryptorResponseParamsProxyToResponder
      implements CookieEncryptionProvider.GetEncryptor_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    CookieEncryptionProviderGetEncryptorResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(Encryptor encryptor) {
      CookieEncryptionProviderGetEncryptorResponseParams _response =
          new CookieEncryptionProviderGetEncryptorResponseParams();
      _response.encryptor = encryptor;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
