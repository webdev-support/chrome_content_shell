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
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;

class PaymentHandlerResponseCallback_Internal {
  public static final Interface.Manager<
          PaymentHandlerResponseCallback, PaymentHandlerResponseCallback.Proxy>
      MANAGER =
          new Interface.Manager<
              PaymentHandlerResponseCallback, PaymentHandlerResponseCallback.Proxy>() {
            @Override
            public String getName() {
              return "payments.mojom.PaymentHandlerResponseCallback";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public PaymentHandlerResponseCallback.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, PaymentHandlerResponseCallback impl) {
              return new Stub(core, impl);
            }

            @Override
            public PaymentHandlerResponseCallback[] buildArray(int size) {
              return new PaymentHandlerResponseCallback[size];
            }
          };
  private static final int ON_RESPONSE_FOR_ABORT_PAYMENT_ORDINAL = 0;
  private static final int ON_RESPONSE_FOR_CAN_MAKE_PAYMENT_ORDINAL = 1;
  private static final int ON_RESPONSE_FOR_PAYMENT_REQUEST_ORDINAL = 2;

  PaymentHandlerResponseCallback_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements PaymentHandlerResponseCallback.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onResponseForAbortPayment(boolean paymentAborted) {
      PaymentHandlerResponseCallbackOnResponseForAbortPaymentParams _message =
          new PaymentHandlerResponseCallbackOnResponseForAbortPaymentParams();
      _message.paymentAborted = paymentAborted;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void onResponseForCanMakePayment(CanMakePaymentResponse response) {
      PaymentHandlerResponseCallbackOnResponseForCanMakePaymentParams _message =
          new PaymentHandlerResponseCallbackOnResponseForCanMakePaymentParams();
      _message.response = response;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void onResponseForPaymentRequest(PaymentHandlerResponse response) {
      PaymentHandlerResponseCallbackOnResponseForPaymentRequestParams _message =
          new PaymentHandlerResponseCallbackOnResponseForPaymentRequestParams();
      _message.response = response;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }
  }

  public static final class Stub extends Interface.Stub<PaymentHandlerResponseCallback> {
    Stub(Core core, PaymentHandlerResponseCallback impl) {
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
                PaymentHandlerResponseCallback_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            PaymentHandlerResponseCallbackOnResponseForAbortPaymentParams data =
                PaymentHandlerResponseCallbackOnResponseForAbortPaymentParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onResponseForAbortPayment(data.paymentAborted);
            return true;
          case 1:
            PaymentHandlerResponseCallbackOnResponseForCanMakePaymentParams data2 =
                PaymentHandlerResponseCallbackOnResponseForCanMakePaymentParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onResponseForCanMakePayment(data2.response);
            return true;
          case 2:
            PaymentHandlerResponseCallbackOnResponseForPaymentRequestParams data3 =
                PaymentHandlerResponseCallbackOnResponseForPaymentRequestParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onResponseForPaymentRequest(data3.response);
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
                PaymentHandlerResponseCallback_Internal.MANAGER,
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

  static final class PaymentHandlerResponseCallbackOnResponseForAbortPaymentParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean paymentAborted;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PaymentHandlerResponseCallbackOnResponseForAbortPaymentParams(int version) {
      super(16, version);
    }

    public PaymentHandlerResponseCallbackOnResponseForAbortPaymentParams() {
      this(0);
    }

    public static PaymentHandlerResponseCallbackOnResponseForAbortPaymentParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static PaymentHandlerResponseCallbackOnResponseForAbortPaymentParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PaymentHandlerResponseCallbackOnResponseForAbortPaymentParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PaymentHandlerResponseCallbackOnResponseForAbortPaymentParams result =
            new PaymentHandlerResponseCallbackOnResponseForAbortPaymentParams(elementsOrVersion);
        result.paymentAborted = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.paymentAborted, 8, 0);
    }
  }

  static final class PaymentHandlerResponseCallbackOnResponseForCanMakePaymentParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public CanMakePaymentResponse response;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PaymentHandlerResponseCallbackOnResponseForCanMakePaymentParams(int version) {
      super(16, version);
    }

    public PaymentHandlerResponseCallbackOnResponseForCanMakePaymentParams() {
      this(0);
    }

    public static PaymentHandlerResponseCallbackOnResponseForCanMakePaymentParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static PaymentHandlerResponseCallbackOnResponseForCanMakePaymentParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PaymentHandlerResponseCallbackOnResponseForCanMakePaymentParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PaymentHandlerResponseCallbackOnResponseForCanMakePaymentParams result =
            new PaymentHandlerResponseCallbackOnResponseForCanMakePaymentParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.response = CanMakePaymentResponse.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.response, 8, false);
    }
  }

  static final class PaymentHandlerResponseCallbackOnResponseForPaymentRequestParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public PaymentHandlerResponse response;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PaymentHandlerResponseCallbackOnResponseForPaymentRequestParams(int version) {
      super(16, version);
    }

    public PaymentHandlerResponseCallbackOnResponseForPaymentRequestParams() {
      this(0);
    }

    public static PaymentHandlerResponseCallbackOnResponseForPaymentRequestParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static PaymentHandlerResponseCallbackOnResponseForPaymentRequestParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PaymentHandlerResponseCallbackOnResponseForPaymentRequestParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PaymentHandlerResponseCallbackOnResponseForPaymentRequestParams result =
            new PaymentHandlerResponseCallbackOnResponseForPaymentRequestParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.response = PaymentHandlerResponse.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.response, 8, false);
    }
  }
}
