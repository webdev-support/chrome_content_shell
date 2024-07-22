package org.chromium.payments.mojom;

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

class PaymentCredential_Internal {
  public static final Interface.Manager<PaymentCredential, PaymentCredential.Proxy> MANAGER =
      new Interface.Manager<PaymentCredential, PaymentCredential.Proxy>() {
        @Override
        public String getName() {
          return "payments.mojom.PaymentCredential";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public PaymentCredential.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, PaymentCredential impl) {
          return new Stub(core, impl);
        }

        @Override
        public PaymentCredential[] buildArray(int size) {
          return new PaymentCredential[size];
        }
      };
  private static final int STORE_PAYMENT_CREDENTIAL_ORDINAL = 0;

  PaymentCredential_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements PaymentCredential.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void storePaymentCredential(
        byte[] credentialId, String rpId, byte[] userId, StorePaymentCredential_Response callback) {
      PaymentCredentialStorePaymentCredentialParams _message =
          new PaymentCredentialStorePaymentCredentialParams();
      _message.credentialId = credentialId;
      _message.rpId = rpId;
      _message.userId = userId;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new PaymentCredentialStorePaymentCredentialResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<PaymentCredential> {
    Stub(Core core, PaymentCredential impl) {
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
                PaymentCredential_Internal.MANAGER, messageWithHeader);
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
                getCore(), PaymentCredential_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            PaymentCredentialStorePaymentCredentialParams data =
                PaymentCredentialStorePaymentCredentialParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .storePaymentCredential(
                    data.credentialId,
                    data.rpId,
                    data.userId,
                    new PaymentCredentialStorePaymentCredentialResponseParamsProxyToResponder(
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

  static final class PaymentCredentialStorePaymentCredentialParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public byte[] credentialId;
    public String rpId;
    public byte[] userId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PaymentCredentialStorePaymentCredentialParams(int version) {
      super(32, version);
    }

    public PaymentCredentialStorePaymentCredentialParams() {
      this(0);
    }

    public static PaymentCredentialStorePaymentCredentialParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PaymentCredentialStorePaymentCredentialParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PaymentCredentialStorePaymentCredentialParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PaymentCredentialStorePaymentCredentialParams result =
            new PaymentCredentialStorePaymentCredentialParams(elementsOrVersion);
        result.credentialId = decoder0.readBytes(8, 0, -1);
        result.rpId = decoder0.readString(16, false);
        result.userId = decoder0.readBytes(24, 0, -1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.credentialId, 8, 0, -1);
      encoder0.encode(this.rpId, 16, false);
      encoder0.encode(this.userId, 24, 0, -1);
    }
  }

  static final class PaymentCredentialStorePaymentCredentialResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int status;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PaymentCredentialStorePaymentCredentialResponseParams(int version) {
      super(16, version);
    }

    public PaymentCredentialStorePaymentCredentialResponseParams() {
      this(0);
    }

    public static PaymentCredentialStorePaymentCredentialResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static PaymentCredentialStorePaymentCredentialResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PaymentCredentialStorePaymentCredentialResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PaymentCredentialStorePaymentCredentialResponseParams result =
            new PaymentCredentialStorePaymentCredentialResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.status = readInt;
        PaymentCredentialStorageStatus.validate(readInt);
        result.status = PaymentCredentialStorageStatus.toKnownValue(result.status);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.status, 8);
    }
  }

  static class PaymentCredentialStorePaymentCredentialResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final PaymentCredential.StorePaymentCredential_Response mCallback;

    PaymentCredentialStorePaymentCredentialResponseParamsForwardToCallback(
        PaymentCredential.StorePaymentCredential_Response callback) {
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
        PaymentCredentialStorePaymentCredentialResponseParams response =
            PaymentCredentialStorePaymentCredentialResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.status);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class PaymentCredentialStorePaymentCredentialResponseParamsProxyToResponder
      implements PaymentCredential.StorePaymentCredential_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    PaymentCredentialStorePaymentCredentialResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int status) {
      PaymentCredentialStorePaymentCredentialResponseParams _response =
          new PaymentCredentialStorePaymentCredentialResponseParams();
      _response.status = status;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
