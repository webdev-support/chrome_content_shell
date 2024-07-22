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
import org.chromium.url.mojom.Url;

class PaymentRequestClient_Internal {
  private static final int ALLOW_CONNECT_TO_SOURCE_ORDINAL = 11;
  public static final Interface.Manager<PaymentRequestClient, PaymentRequestClient.Proxy> MANAGER =
      new Interface.Manager<PaymentRequestClient, PaymentRequestClient.Proxy>() {
        @Override
        public String getName() {
          return "payments.mojom.PaymentRequestClient";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public PaymentRequestClient.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, PaymentRequestClient impl) {
          return new Stub(core, impl);
        }

        @Override
        public PaymentRequestClient[] buildArray(int size) {
          return new PaymentRequestClient[size];
        }
      };
  private static final int ON_ABORT_ORDINAL = 7;
  private static final int ON_CAN_MAKE_PAYMENT_ORDINAL = 8;
  private static final int ON_COMPLETE_ORDINAL = 6;
  private static final int ON_ERROR_ORDINAL = 5;
  private static final int ON_HAS_ENROLLED_INSTRUMENT_ORDINAL = 9;
  private static final int ON_PAYER_DETAIL_CHANGE_ORDINAL = 3;
  private static final int ON_PAYMENT_METHOD_CHANGE_ORDINAL = 0;
  private static final int ON_PAYMENT_RESPONSE_ORDINAL = 4;
  private static final int ON_SHIPPING_ADDRESS_CHANGE_ORDINAL = 1;
  private static final int ON_SHIPPING_OPTION_CHANGE_ORDINAL = 2;
  private static final int WARN_NO_FAVICON_ORDINAL = 10;

  PaymentRequestClient_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements PaymentRequestClient.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onPaymentMethodChange(String methodName, String stringifiedDetails) {
      PaymentRequestClientOnPaymentMethodChangeParams _message =
          new PaymentRequestClientOnPaymentMethodChangeParams();
      _message.methodName = methodName;
      _message.stringifiedDetails = stringifiedDetails;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void onShippingAddressChange(PaymentAddress address) {
      PaymentRequestClientOnShippingAddressChangeParams _message =
          new PaymentRequestClientOnShippingAddressChangeParams();
      _message.address = address;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void onShippingOptionChange(String shippingOptionId) {
      PaymentRequestClientOnShippingOptionChangeParams _message =
          new PaymentRequestClientOnShippingOptionChangeParams();
      _message.shippingOptionId = shippingOptionId;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void onPayerDetailChange(PayerDetail detail) {
      PaymentRequestClientOnPayerDetailChangeParams _message =
          new PaymentRequestClientOnPayerDetailChangeParams();
      _message.detail = detail;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }

    @Override
    public void onPaymentResponse(PaymentResponse response) {
      PaymentRequestClientOnPaymentResponseParams _message =
          new PaymentRequestClientOnPaymentResponseParams();
      _message.response = response;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
    }

    @Override
    public void onError(int error, String errorMessage) {
      PaymentRequestClientOnErrorParams _message = new PaymentRequestClientOnErrorParams();
      _message.error = error;
      _message.errorMessage = errorMessage;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5)));
    }

    @Override
    public void onComplete() {
      PaymentRequestClientOnCompleteParams _message = new PaymentRequestClientOnCompleteParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(6)));
    }

    @Override
    public void onAbort(boolean abortedSuccessfully) {
      PaymentRequestClientOnAbortParams _message = new PaymentRequestClientOnAbortParams();
      _message.abortedSuccessfully = abortedSuccessfully;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(7)));
    }

    @Override
    public void onCanMakePayment(int result) {
      PaymentRequestClientOnCanMakePaymentParams _message =
          new PaymentRequestClientOnCanMakePaymentParams();
      _message.result = result;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(8)));
    }

    @Override
    public void onHasEnrolledInstrument(int result) {
      PaymentRequestClientOnHasEnrolledInstrumentParams _message =
          new PaymentRequestClientOnHasEnrolledInstrumentParams();
      _message.result = result;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(9)));
    }

    @Override
    public void warnNoFavicon() {
      PaymentRequestClientWarnNoFaviconParams _message =
          new PaymentRequestClientWarnNoFaviconParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(10)));
    }

    @Override
    public void allowConnectToSource(
        Url url,
        Url urlBeforeRedirects,
        boolean didFollowRedirect,
        AllowConnectToSource_Response callback) {
      PaymentRequestClientAllowConnectToSourceParams _message =
          new PaymentRequestClientAllowConnectToSourceParams();
      _message.url = url;
      _message.urlBeforeRedirects = urlBeforeRedirects;
      _message.didFollowRedirect = didFollowRedirect;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(11, 1, 0L)),
              new PaymentRequestClientAllowConnectToSourceResponseParamsForwardToCallback(
                  callback));
    }
  }

  public static final class Stub extends Interface.Stub<PaymentRequestClient> {
    Stub(Core core, PaymentRequestClient impl) {
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
                PaymentRequestClient_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            PaymentRequestClientOnPaymentMethodChangeParams data =
                PaymentRequestClientOnPaymentMethodChangeParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onPaymentMethodChange(data.methodName, data.stringifiedDetails);
            return true;
          case 1:
            getImpl()
                .onShippingAddressChange(
                    PaymentRequestClientOnShippingAddressChangeParams.deserialize(
                            messageWithHeader.getPayload())
                        .address);
            return true;
          case 2:
            getImpl()
                .onShippingOptionChange(
                    PaymentRequestClientOnShippingOptionChangeParams.deserialize(
                            messageWithHeader.getPayload())
                        .shippingOptionId);
            return true;
          case 3:
            getImpl()
                .onPayerDetailChange(
                    PaymentRequestClientOnPayerDetailChangeParams.deserialize(
                            messageWithHeader.getPayload())
                        .detail);
            return true;
          case 4:
            getImpl()
                .onPaymentResponse(
                    PaymentRequestClientOnPaymentResponseParams.deserialize(
                            messageWithHeader.getPayload())
                        .response);
            return true;
          case 5:
            PaymentRequestClientOnErrorParams data2 =
                PaymentRequestClientOnErrorParams.deserialize(messageWithHeader.getPayload());
            getImpl().onError(data2.error, data2.errorMessage);
            return true;
          case 6:
            PaymentRequestClientOnCompleteParams.deserialize(messageWithHeader.getPayload());
            getImpl().onComplete();
            return true;
          case 7:
            getImpl()
                .onAbort(
                    PaymentRequestClientOnAbortParams.deserialize(messageWithHeader.getPayload())
                        .abortedSuccessfully);
            return true;
          case 8:
            getImpl()
                .onCanMakePayment(
                    PaymentRequestClientOnCanMakePaymentParams.deserialize(
                            messageWithHeader.getPayload())
                        .result);
            return true;
          case 9:
            getImpl()
                .onHasEnrolledInstrument(
                    PaymentRequestClientOnHasEnrolledInstrumentParams.deserialize(
                            messageWithHeader.getPayload())
                        .result);
            return true;
          case 10:
            PaymentRequestClientWarnNoFaviconParams.deserialize(messageWithHeader.getPayload());
            getImpl().warnNoFavicon();
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
                getCore(), PaymentRequestClient_Internal.MANAGER, messageWithHeader, receiver);
          case 11:
            PaymentRequestClientAllowConnectToSourceParams data =
                PaymentRequestClientAllowConnectToSourceParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .allowConnectToSource(
                    data.url,
                    data.urlBeforeRedirects,
                    data.didFollowRedirect,
                    new PaymentRequestClientAllowConnectToSourceResponseParamsProxyToResponder(
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

  static final class PaymentRequestClientOnPaymentMethodChangeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public String methodName;
    public String stringifiedDetails;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PaymentRequestClientOnPaymentMethodChangeParams(int version) {
      super(24, version);
    }

    public PaymentRequestClientOnPaymentMethodChangeParams() {
      this(0);
    }

    public static PaymentRequestClientOnPaymentMethodChangeParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PaymentRequestClientOnPaymentMethodChangeParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PaymentRequestClientOnPaymentMethodChangeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PaymentRequestClientOnPaymentMethodChangeParams result =
            new PaymentRequestClientOnPaymentMethodChangeParams(elementsOrVersion);
        result.methodName = decoder0.readString(8, false);
        result.stringifiedDetails = decoder0.readString(16, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.methodName, 8, false);
      encoder0.encode(this.stringifiedDetails, 16, false);
    }
  }

  static final class PaymentRequestClientOnShippingAddressChangeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public PaymentAddress address;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PaymentRequestClientOnShippingAddressChangeParams(int version) {
      super(16, version);
    }

    public PaymentRequestClientOnShippingAddressChangeParams() {
      this(0);
    }

    public static PaymentRequestClientOnShippingAddressChangeParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PaymentRequestClientOnShippingAddressChangeParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PaymentRequestClientOnShippingAddressChangeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PaymentRequestClientOnShippingAddressChangeParams result =
            new PaymentRequestClientOnShippingAddressChangeParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.address = PaymentAddress.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.address, 8, false);
    }
  }

  static final class PaymentRequestClientOnShippingOptionChangeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String shippingOptionId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PaymentRequestClientOnShippingOptionChangeParams(int version) {
      super(16, version);
    }

    public PaymentRequestClientOnShippingOptionChangeParams() {
      this(0);
    }

    public static PaymentRequestClientOnShippingOptionChangeParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PaymentRequestClientOnShippingOptionChangeParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PaymentRequestClientOnShippingOptionChangeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PaymentRequestClientOnShippingOptionChangeParams result =
            new PaymentRequestClientOnShippingOptionChangeParams(elementsOrVersion);
        result.shippingOptionId = decoder0.readString(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.shippingOptionId, 8, false);
    }
  }

  static final class PaymentRequestClientOnPayerDetailChangeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public PayerDetail detail;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PaymentRequestClientOnPayerDetailChangeParams(int version) {
      super(16, version);
    }

    public PaymentRequestClientOnPayerDetailChangeParams() {
      this(0);
    }

    public static PaymentRequestClientOnPayerDetailChangeParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PaymentRequestClientOnPayerDetailChangeParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PaymentRequestClientOnPayerDetailChangeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PaymentRequestClientOnPayerDetailChangeParams result =
            new PaymentRequestClientOnPayerDetailChangeParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.detail = PayerDetail.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.detail, 8, false);
    }
  }

  static final class PaymentRequestClientOnPaymentResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public PaymentResponse response;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PaymentRequestClientOnPaymentResponseParams(int version) {
      super(16, version);
    }

    public PaymentRequestClientOnPaymentResponseParams() {
      this(0);
    }

    public static PaymentRequestClientOnPaymentResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PaymentRequestClientOnPaymentResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PaymentRequestClientOnPaymentResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PaymentRequestClientOnPaymentResponseParams result =
            new PaymentRequestClientOnPaymentResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.response = PaymentResponse.decode(decoder1);
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

  static final class PaymentRequestClientOnErrorParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int error;
    public String errorMessage;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PaymentRequestClientOnErrorParams(int version) {
      super(24, version);
    }

    public PaymentRequestClientOnErrorParams() {
      this(0);
    }

    public static PaymentRequestClientOnErrorParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PaymentRequestClientOnErrorParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PaymentRequestClientOnErrorParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PaymentRequestClientOnErrorParams result =
            new PaymentRequestClientOnErrorParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.error = readInt;
        PaymentErrorReason.validate(readInt);
        result.error = PaymentErrorReason.toKnownValue(result.error);
        result.errorMessage = decoder0.readString(16, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.error, 8);
      encoder0.encode(this.errorMessage, 16, false);
    }
  }

  static final class PaymentRequestClientOnCompleteParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PaymentRequestClientOnCompleteParams(int version) {
      super(8, version);
    }

    public PaymentRequestClientOnCompleteParams() {
      this(0);
    }

    public static PaymentRequestClientOnCompleteParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PaymentRequestClientOnCompleteParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PaymentRequestClientOnCompleteParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PaymentRequestClientOnCompleteParams result =
            new PaymentRequestClientOnCompleteParams(elementsOrVersion);
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

  static final class PaymentRequestClientOnAbortParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean abortedSuccessfully;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PaymentRequestClientOnAbortParams(int version) {
      super(16, version);
    }

    public PaymentRequestClientOnAbortParams() {
      this(0);
    }

    public static PaymentRequestClientOnAbortParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PaymentRequestClientOnAbortParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PaymentRequestClientOnAbortParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PaymentRequestClientOnAbortParams result =
            new PaymentRequestClientOnAbortParams(elementsOrVersion);
        result.abortedSuccessfully = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.abortedSuccessfully, 8, 0);
    }
  }

  static final class PaymentRequestClientOnCanMakePaymentParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PaymentRequestClientOnCanMakePaymentParams(int version) {
      super(16, version);
    }

    public PaymentRequestClientOnCanMakePaymentParams() {
      this(0);
    }

    public static PaymentRequestClientOnCanMakePaymentParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PaymentRequestClientOnCanMakePaymentParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PaymentRequestClientOnCanMakePaymentParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PaymentRequestClientOnCanMakePaymentParams result =
            new PaymentRequestClientOnCanMakePaymentParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.result = readInt;
        CanMakePaymentQueryResult.validate(readInt);
        result.result = CanMakePaymentQueryResult.toKnownValue(result.result);
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

  static final class PaymentRequestClientOnHasEnrolledInstrumentParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PaymentRequestClientOnHasEnrolledInstrumentParams(int version) {
      super(16, version);
    }

    public PaymentRequestClientOnHasEnrolledInstrumentParams() {
      this(0);
    }

    public static PaymentRequestClientOnHasEnrolledInstrumentParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PaymentRequestClientOnHasEnrolledInstrumentParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PaymentRequestClientOnHasEnrolledInstrumentParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PaymentRequestClientOnHasEnrolledInstrumentParams result =
            new PaymentRequestClientOnHasEnrolledInstrumentParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.result = readInt;
        HasEnrolledInstrumentQueryResult.validate(readInt);
        result.result = HasEnrolledInstrumentQueryResult.toKnownValue(result.result);
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

  static final class PaymentRequestClientWarnNoFaviconParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PaymentRequestClientWarnNoFaviconParams(int version) {
      super(8, version);
    }

    public PaymentRequestClientWarnNoFaviconParams() {
      this(0);
    }

    public static PaymentRequestClientWarnNoFaviconParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PaymentRequestClientWarnNoFaviconParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PaymentRequestClientWarnNoFaviconParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PaymentRequestClientWarnNoFaviconParams result =
            new PaymentRequestClientWarnNoFaviconParams(elementsOrVersion);
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

  static final class PaymentRequestClientAllowConnectToSourceParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean didFollowRedirect;
    public Url url;
    public Url urlBeforeRedirects;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PaymentRequestClientAllowConnectToSourceParams(int version) {
      super(32, version);
    }

    public PaymentRequestClientAllowConnectToSourceParams() {
      this(0);
    }

    public static PaymentRequestClientAllowConnectToSourceParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PaymentRequestClientAllowConnectToSourceParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PaymentRequestClientAllowConnectToSourceParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PaymentRequestClientAllowConnectToSourceParams result =
            new PaymentRequestClientAllowConnectToSourceParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.url = Url.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.urlBeforeRedirects = Url.decode(decoder12);
        result.didFollowRedirect = decoder0.readBoolean(24, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.url, 8, false);
      encoder0.encode((Struct) this.urlBeforeRedirects, 16, false);
      encoder0.encode(this.didFollowRedirect, 24, 0);
    }
  }

  static final class PaymentRequestClientAllowConnectToSourceResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean allow;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PaymentRequestClientAllowConnectToSourceResponseParams(int version) {
      super(16, version);
    }

    public PaymentRequestClientAllowConnectToSourceResponseParams() {
      this(0);
    }

    public static PaymentRequestClientAllowConnectToSourceResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static PaymentRequestClientAllowConnectToSourceResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PaymentRequestClientAllowConnectToSourceResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PaymentRequestClientAllowConnectToSourceResponseParams result =
            new PaymentRequestClientAllowConnectToSourceResponseParams(elementsOrVersion);
        result.allow = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.allow, 8, 0);
    }
  }

  static class PaymentRequestClientAllowConnectToSourceResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final PaymentRequestClient.AllowConnectToSource_Response mCallback;

    PaymentRequestClientAllowConnectToSourceResponseParamsForwardToCallback(
        PaymentRequestClient.AllowConnectToSource_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(11, 2)) {
          return false;
        }
        PaymentRequestClientAllowConnectToSourceResponseParams response =
            PaymentRequestClientAllowConnectToSourceResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.allow);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class PaymentRequestClientAllowConnectToSourceResponseParamsProxyToResponder
      implements PaymentRequestClient.AllowConnectToSource_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    PaymentRequestClientAllowConnectToSourceResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean allow) {
      PaymentRequestClientAllowConnectToSourceResponseParams _response =
          new PaymentRequestClientAllowConnectToSourceResponseParams();
      _response.allow = allow;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(11, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
