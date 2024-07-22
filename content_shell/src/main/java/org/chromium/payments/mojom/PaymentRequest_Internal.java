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

class PaymentRequest_Internal {
  private static final int ABORT_ORDINAL = 4;
  private static final int CAN_MAKE_PAYMENT_ORDINAL = 7;
  private static final int COMPLETE_ORDINAL = 5;
  private static final int HAS_ENROLLED_INSTRUMENT_ORDINAL = 8;
  private static final int INIT_ORDINAL = 0;
  public static final Interface.Manager<PaymentRequest, PaymentRequest.Proxy> MANAGER =
      new Interface.Manager<PaymentRequest, PaymentRequest.Proxy>() {
        @Override
        public String getName() {
          return "payments.mojom.PaymentRequest";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public PaymentRequest.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, PaymentRequest impl) {
          return new Stub(core, impl);
        }

        @Override
        public PaymentRequest[] buildArray(int size) {
          return new PaymentRequest[size];
        }
      };
  private static final int ON_PAYMENT_DETAILS_NOT_UPDATED_ORDINAL = 3;
  private static final int RETRY_ORDINAL = 6;
  private static final int SHOW_ORDINAL = 1;
  private static final int UPDATE_WITH_ORDINAL = 2;

  PaymentRequest_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements PaymentRequest.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void init(
        PaymentRequestClient client,
        PaymentMethodData[] methodData,
        PaymentDetails details,
        PaymentOptions options) {
      PaymentRequestInitParams _message = new PaymentRequestInitParams();
      _message.client = client;
      _message.methodData = methodData;
      _message.details = details;
      _message.options = options;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void show(boolean waitForUpdatedDetails, boolean hadUserActivation) {
      PaymentRequestShowParams _message = new PaymentRequestShowParams();
      _message.waitForUpdatedDetails = waitForUpdatedDetails;
      _message.hadUserActivation = hadUserActivation;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void updateWith(PaymentDetails details) {
      PaymentRequestUpdateWithParams _message = new PaymentRequestUpdateWithParams();
      _message.details = details;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void onPaymentDetailsNotUpdated() {
      PaymentRequestOnPaymentDetailsNotUpdatedParams _message =
          new PaymentRequestOnPaymentDetailsNotUpdatedParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }

    @Override
    public void abort() {
      PaymentRequestAbortParams _message = new PaymentRequestAbortParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
    }

    @Override
    public void complete(int result) {
      PaymentRequestCompleteParams _message = new PaymentRequestCompleteParams();
      _message.result = result;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5)));
    }

    @Override
    public void retry(PaymentValidationErrors errors) {
      PaymentRequestRetryParams _message = new PaymentRequestRetryParams();
      _message.errors = errors;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(6)));
    }

    @Override
    public void canMakePayment() {
      PaymentRequestCanMakePaymentParams _message = new PaymentRequestCanMakePaymentParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(7)));
    }

    @Override
    public void hasEnrolledInstrument() {
      PaymentRequestHasEnrolledInstrumentParams _message =
          new PaymentRequestHasEnrolledInstrumentParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(8)));
    }
  }

  public static final class Stub extends Interface.Stub<PaymentRequest> {
    Stub(Core core, PaymentRequest impl) {
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
                PaymentRequest_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            PaymentRequestInitParams data =
                PaymentRequestInitParams.deserialize(messageWithHeader.getPayload());
            getImpl().init(data.client, data.methodData, data.details, data.options);
            return true;
          case 1:
            PaymentRequestShowParams data2 =
                PaymentRequestShowParams.deserialize(messageWithHeader.getPayload());
            getImpl().show(data2.waitForUpdatedDetails, data2.hadUserActivation);
            return true;
          case 2:
            getImpl()
                .updateWith(
                    PaymentRequestUpdateWithParams.deserialize(messageWithHeader.getPayload())
                        .details);
            return true;
          case 3:
            PaymentRequestOnPaymentDetailsNotUpdatedParams.deserialize(
                messageWithHeader.getPayload());
            getImpl().onPaymentDetailsNotUpdated();
            return true;
          case 4:
            PaymentRequestAbortParams.deserialize(messageWithHeader.getPayload());
            getImpl().abort();
            return true;
          case 5:
            getImpl()
                .complete(
                    PaymentRequestCompleteParams.deserialize(messageWithHeader.getPayload())
                        .result);
            return true;
          case 6:
            getImpl()
                .retry(
                    PaymentRequestRetryParams.deserialize(messageWithHeader.getPayload()).errors);
            return true;
          case 7:
            PaymentRequestCanMakePaymentParams.deserialize(messageWithHeader.getPayload());
            getImpl().canMakePayment();
            return true;
          case 8:
            PaymentRequestHasEnrolledInstrumentParams.deserialize(messageWithHeader.getPayload());
            getImpl().hasEnrolledInstrument();
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
                getCore(), PaymentRequest_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class PaymentRequestInitParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public PaymentRequestClient client;
    public PaymentDetails details;
    public PaymentMethodData[] methodData;
    public PaymentOptions options;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PaymentRequestInitParams(int version) {
      super(40, version);
    }

    public PaymentRequestInitParams() {
      this(0);
    }

    public static PaymentRequestInitParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PaymentRequestInitParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PaymentRequestInitParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PaymentRequestInitParams result = new PaymentRequestInitParams(elementsOrVersion);
        result.client =
            (PaymentRequestClient)
                decoder0.readServiceInterface(8, false, PaymentRequestClient.MANAGER);
        Decoder decoder1 = decoder0.readPointer(16, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.methodData = new PaymentMethodData[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.methodData[i1] = PaymentMethodData.decode(decoder2);
        }
        result.details = PaymentDetails.decode(decoder0.readPointer(24, false));
        result.options = PaymentOptions.decode(decoder0.readPointer(32, false));
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.client, 8, false, PaymentRequestClient.MANAGER);
      PaymentMethodData[] paymentMethodDataArr = this.methodData;
      if (paymentMethodDataArr == null) {
        encoder0.encodeNullPointer(16, false);
      } else {
        Encoder encoder1 = encoder0.encodePointerArray(paymentMethodDataArr.length, 16, -1);
        int i0 = 0;
        while (true) {
          PaymentMethodData[] paymentMethodDataArr2 = this.methodData;
          if (i0 >= paymentMethodDataArr2.length) {
            break;
          }
          encoder1.encode((Struct) paymentMethodDataArr2[i0], (i0 * 8) + 8, false);
          i0++;
        }
      }
      encoder0.encode((Struct) this.details, 24, false);
      encoder0.encode((Struct) this.options, 32, false);
    }
  }

  static final class PaymentRequestShowParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean hadUserActivation;
    public boolean waitForUpdatedDetails;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PaymentRequestShowParams(int version) {
      super(16, version);
    }

    public PaymentRequestShowParams() {
      this(0);
    }

    public static PaymentRequestShowParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PaymentRequestShowParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PaymentRequestShowParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PaymentRequestShowParams result = new PaymentRequestShowParams(elementsOrVersion);
        result.waitForUpdatedDetails = decoder0.readBoolean(8, 0);
        result.hadUserActivation = decoder0.readBoolean(8, 1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.waitForUpdatedDetails, 8, 0);
      encoder0.encode(this.hadUserActivation, 8, 1);
    }
  }

  static final class PaymentRequestUpdateWithParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public PaymentDetails details;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PaymentRequestUpdateWithParams(int version) {
      super(16, version);
    }

    public PaymentRequestUpdateWithParams() {
      this(0);
    }

    public static PaymentRequestUpdateWithParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PaymentRequestUpdateWithParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PaymentRequestUpdateWithParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PaymentRequestUpdateWithParams result =
            new PaymentRequestUpdateWithParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.details = PaymentDetails.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.details, 8, false);
    }
  }

  static final class PaymentRequestOnPaymentDetailsNotUpdatedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PaymentRequestOnPaymentDetailsNotUpdatedParams(int version) {
      super(8, version);
    }

    public PaymentRequestOnPaymentDetailsNotUpdatedParams() {
      this(0);
    }

    public static PaymentRequestOnPaymentDetailsNotUpdatedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PaymentRequestOnPaymentDetailsNotUpdatedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PaymentRequestOnPaymentDetailsNotUpdatedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PaymentRequestOnPaymentDetailsNotUpdatedParams result =
            new PaymentRequestOnPaymentDetailsNotUpdatedParams(elementsOrVersion);
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

  static final class PaymentRequestAbortParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PaymentRequestAbortParams(int version) {
      super(8, version);
    }

    public PaymentRequestAbortParams() {
      this(0);
    }

    public static PaymentRequestAbortParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PaymentRequestAbortParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PaymentRequestAbortParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PaymentRequestAbortParams result = new PaymentRequestAbortParams(elementsOrVersion);
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

  static final class PaymentRequestCompleteParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PaymentRequestCompleteParams(int version) {
      super(16, version);
    }

    public PaymentRequestCompleteParams() {
      this(0);
    }

    public static PaymentRequestCompleteParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PaymentRequestCompleteParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PaymentRequestCompleteParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PaymentRequestCompleteParams result = new PaymentRequestCompleteParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.result = readInt;
        PaymentComplete.validate(readInt);
        result.result = PaymentComplete.toKnownValue(result.result);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.result, 8);
    }
  }

  static final class PaymentRequestRetryParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public PaymentValidationErrors errors;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PaymentRequestRetryParams(int version) {
      super(16, version);
    }

    public PaymentRequestRetryParams() {
      this(0);
    }

    public static PaymentRequestRetryParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PaymentRequestRetryParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PaymentRequestRetryParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PaymentRequestRetryParams result = new PaymentRequestRetryParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.errors = PaymentValidationErrors.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.errors, 8, false);
    }
  }

  static final class PaymentRequestCanMakePaymentParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PaymentRequestCanMakePaymentParams(int version) {
      super(8, version);
    }

    public PaymentRequestCanMakePaymentParams() {
      this(0);
    }

    public static PaymentRequestCanMakePaymentParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PaymentRequestCanMakePaymentParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PaymentRequestCanMakePaymentParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PaymentRequestCanMakePaymentParams result =
            new PaymentRequestCanMakePaymentParams(elementsOrVersion);
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

  static final class PaymentRequestHasEnrolledInstrumentParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PaymentRequestHasEnrolledInstrumentParams(int version) {
      super(8, version);
    }

    public PaymentRequestHasEnrolledInstrumentParams() {
      this(0);
    }

    public static PaymentRequestHasEnrolledInstrumentParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PaymentRequestHasEnrolledInstrumentParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PaymentRequestHasEnrolledInstrumentParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PaymentRequestHasEnrolledInstrumentParams result =
            new PaymentRequestHasEnrolledInstrumentParams(elementsOrVersion);
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
}
