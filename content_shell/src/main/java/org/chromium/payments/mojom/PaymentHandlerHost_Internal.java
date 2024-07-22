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

class PaymentHandlerHost_Internal {
  private static final int CHANGE_PAYMENT_METHOD_ORDINAL = 0;
  private static final int CHANGE_SHIPPING_ADDRESS_ORDINAL = 2;
  private static final int CHANGE_SHIPPING_OPTION_ORDINAL = 1;
  public static final Interface.Manager<PaymentHandlerHost, PaymentHandlerHost.Proxy> MANAGER =
      new Interface.Manager<PaymentHandlerHost, PaymentHandlerHost.Proxy>() {
        @Override
        public String getName() {
          return "payments.mojom.PaymentHandlerHost";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public PaymentHandlerHost.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, PaymentHandlerHost impl) {
          return new Stub(core, impl);
        }

        @Override
        public PaymentHandlerHost[] buildArray(int size) {
          return new PaymentHandlerHost[size];
        }
      };

  PaymentHandlerHost_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements PaymentHandlerHost.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void changePaymentMethod(
        PaymentHandlerMethodData methodData, ChangePaymentMethod_Response callback) {
      PaymentHandlerHostChangePaymentMethodParams _message =
          new PaymentHandlerHostChangePaymentMethodParams();
      _message.methodData = methodData;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new PaymentHandlerHostChangePaymentMethodResponseParamsForwardToCallback(callback));
    }

    @Override
    public void changeShippingOption(
        String shippingOptionId, ChangeShippingOption_Response callback) {
      PaymentHandlerHostChangeShippingOptionParams _message =
          new PaymentHandlerHostChangeShippingOptionParams();
      _message.shippingOptionId = shippingOptionId;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new PaymentHandlerHostChangeShippingOptionResponseParamsForwardToCallback(callback));
    }

    @Override
    public void changeShippingAddress(
        PaymentAddress shippingAddress, ChangeShippingAddress_Response callback) {
      PaymentHandlerHostChangeShippingAddressParams _message =
          new PaymentHandlerHostChangeShippingAddressParams();
      _message.shippingAddress = shippingAddress;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new PaymentHandlerHostChangeShippingAddressResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<PaymentHandlerHost> {
    Stub(Core core, PaymentHandlerHost impl) {
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
                PaymentHandlerHost_Internal.MANAGER, messageWithHeader);
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
                getCore(), PaymentHandlerHost_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            PaymentHandlerHostChangePaymentMethodParams data =
                PaymentHandlerHostChangePaymentMethodParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .changePaymentMethod(
                    data.methodData,
                    new PaymentHandlerHostChangePaymentMethodResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
            PaymentHandlerHostChangeShippingOptionParams data2 =
                PaymentHandlerHostChangeShippingOptionParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .changeShippingOption(
                    data2.shippingOptionId,
                    new PaymentHandlerHostChangeShippingOptionResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 2:
            PaymentHandlerHostChangeShippingAddressParams data3 =
                PaymentHandlerHostChangeShippingAddressParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .changeShippingAddress(
                    data3.shippingAddress,
                    new PaymentHandlerHostChangeShippingAddressResponseParamsProxyToResponder(
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

  static final class PaymentHandlerHostChangePaymentMethodParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public PaymentHandlerMethodData methodData;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PaymentHandlerHostChangePaymentMethodParams(int version) {
      super(16, version);
    }

    public PaymentHandlerHostChangePaymentMethodParams() {
      this(0);
    }

    public static PaymentHandlerHostChangePaymentMethodParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PaymentHandlerHostChangePaymentMethodParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PaymentHandlerHostChangePaymentMethodParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PaymentHandlerHostChangePaymentMethodParams result =
            new PaymentHandlerHostChangePaymentMethodParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.methodData = PaymentHandlerMethodData.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.methodData, 8, false);
    }
  }

  static final class PaymentHandlerHostChangePaymentMethodResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public PaymentRequestDetailsUpdate responseData;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PaymentHandlerHostChangePaymentMethodResponseParams(int version) {
      super(16, version);
    }

    public PaymentHandlerHostChangePaymentMethodResponseParams() {
      this(0);
    }

    public static PaymentHandlerHostChangePaymentMethodResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PaymentHandlerHostChangePaymentMethodResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PaymentHandlerHostChangePaymentMethodResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PaymentHandlerHostChangePaymentMethodResponseParams result =
            new PaymentHandlerHostChangePaymentMethodResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.responseData = PaymentRequestDetailsUpdate.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.responseData, 8, false);
    }
  }

  static class PaymentHandlerHostChangePaymentMethodResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final PaymentHandlerHost.ChangePaymentMethod_Response mCallback;

    PaymentHandlerHostChangePaymentMethodResponseParamsForwardToCallback(
        PaymentHandlerHost.ChangePaymentMethod_Response callback) {
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
        PaymentHandlerHostChangePaymentMethodResponseParams response =
            PaymentHandlerHostChangePaymentMethodResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.responseData);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class PaymentHandlerHostChangePaymentMethodResponseParamsProxyToResponder
      implements PaymentHandlerHost.ChangePaymentMethod_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    PaymentHandlerHostChangePaymentMethodResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(PaymentRequestDetailsUpdate responseData) {
      PaymentHandlerHostChangePaymentMethodResponseParams _response =
          new PaymentHandlerHostChangePaymentMethodResponseParams();
      _response.responseData = responseData;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class PaymentHandlerHostChangeShippingOptionParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String shippingOptionId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PaymentHandlerHostChangeShippingOptionParams(int version) {
      super(16, version);
    }

    public PaymentHandlerHostChangeShippingOptionParams() {
      this(0);
    }

    public static PaymentHandlerHostChangeShippingOptionParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PaymentHandlerHostChangeShippingOptionParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PaymentHandlerHostChangeShippingOptionParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PaymentHandlerHostChangeShippingOptionParams result =
            new PaymentHandlerHostChangeShippingOptionParams(elementsOrVersion);
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

  static final class PaymentHandlerHostChangeShippingOptionResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public PaymentRequestDetailsUpdate responseData;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PaymentHandlerHostChangeShippingOptionResponseParams(int version) {
      super(16, version);
    }

    public PaymentHandlerHostChangeShippingOptionResponseParams() {
      this(0);
    }

    public static PaymentHandlerHostChangeShippingOptionResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static PaymentHandlerHostChangeShippingOptionResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PaymentHandlerHostChangeShippingOptionResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PaymentHandlerHostChangeShippingOptionResponseParams result =
            new PaymentHandlerHostChangeShippingOptionResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.responseData = PaymentRequestDetailsUpdate.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.responseData, 8, false);
    }
  }

  static class PaymentHandlerHostChangeShippingOptionResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final PaymentHandlerHost.ChangeShippingOption_Response mCallback;

    PaymentHandlerHostChangeShippingOptionResponseParamsForwardToCallback(
        PaymentHandlerHost.ChangeShippingOption_Response callback) {
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
        PaymentHandlerHostChangeShippingOptionResponseParams response =
            PaymentHandlerHostChangeShippingOptionResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.responseData);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class PaymentHandlerHostChangeShippingOptionResponseParamsProxyToResponder
      implements PaymentHandlerHost.ChangeShippingOption_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    PaymentHandlerHostChangeShippingOptionResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(PaymentRequestDetailsUpdate responseData) {
      PaymentHandlerHostChangeShippingOptionResponseParams _response =
          new PaymentHandlerHostChangeShippingOptionResponseParams();
      _response.responseData = responseData;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class PaymentHandlerHostChangeShippingAddressParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public PaymentAddress shippingAddress;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PaymentHandlerHostChangeShippingAddressParams(int version) {
      super(16, version);
    }

    public PaymentHandlerHostChangeShippingAddressParams() {
      this(0);
    }

    public static PaymentHandlerHostChangeShippingAddressParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PaymentHandlerHostChangeShippingAddressParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PaymentHandlerHostChangeShippingAddressParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PaymentHandlerHostChangeShippingAddressParams result =
            new PaymentHandlerHostChangeShippingAddressParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.shippingAddress = PaymentAddress.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.shippingAddress, 8, false);
    }
  }

  static final class PaymentHandlerHostChangeShippingAddressResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public PaymentRequestDetailsUpdate responseData;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PaymentHandlerHostChangeShippingAddressResponseParams(int version) {
      super(16, version);
    }

    public PaymentHandlerHostChangeShippingAddressResponseParams() {
      this(0);
    }

    public static PaymentHandlerHostChangeShippingAddressResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static PaymentHandlerHostChangeShippingAddressResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PaymentHandlerHostChangeShippingAddressResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PaymentHandlerHostChangeShippingAddressResponseParams result =
            new PaymentHandlerHostChangeShippingAddressResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.responseData = PaymentRequestDetailsUpdate.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.responseData, 8, false);
    }
  }

  static class PaymentHandlerHostChangeShippingAddressResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final PaymentHandlerHost.ChangeShippingAddress_Response mCallback;

    PaymentHandlerHostChangeShippingAddressResponseParamsForwardToCallback(
        PaymentHandlerHost.ChangeShippingAddress_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(2, 2)) {
          return false;
        }
        PaymentHandlerHostChangeShippingAddressResponseParams response =
            PaymentHandlerHostChangeShippingAddressResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.responseData);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class PaymentHandlerHostChangeShippingAddressResponseParamsProxyToResponder
      implements PaymentHandlerHost.ChangeShippingAddress_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    PaymentHandlerHostChangeShippingAddressResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(PaymentRequestDetailsUpdate responseData) {
      PaymentHandlerHostChangeShippingAddressResponseParams _response =
          new PaymentHandlerHostChangeShippingAddressResponseParams();
      _response.responseData = responseData;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
