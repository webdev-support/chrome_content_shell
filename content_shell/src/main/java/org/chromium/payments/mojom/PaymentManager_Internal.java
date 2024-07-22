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

class PaymentManager_Internal {
  private static final int CLEAR_PAYMENT_INSTRUMENTS_ORDINAL = 6;
  private static final int DELETE_PAYMENT_INSTRUMENT_ORDINAL = 1;
  private static final int ENABLE_DELEGATIONS_ORDINAL = 8;
  private static final int GET_PAYMENT_INSTRUMENT_ORDINAL = 2;
  private static final int HAS_PAYMENT_INSTRUMENT_ORDINAL = 4;
  private static final int INIT_ORDINAL = 0;
  private static final int KEYS_OF_PAYMENT_INSTRUMENTS_ORDINAL = 3;
  public static final Interface.Manager<PaymentManager, PaymentManager.Proxy> MANAGER =
      new Interface.Manager<PaymentManager, PaymentManager.Proxy>() {
        @Override
        public String getName() {
          return "payments.mojom.PaymentManager";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public PaymentManager.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, PaymentManager impl) {
          return new Stub(core, impl);
        }

        @Override
        public PaymentManager[] buildArray(int size) {
          return new PaymentManager[size];
        }
      };
  private static final int SET_PAYMENT_INSTRUMENT_ORDINAL = 5;
  private static final int SET_USER_HINT_ORDINAL = 7;

  PaymentManager_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements PaymentManager.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void init(Url contextUrl, String serviceWorkerScope) {
      PaymentManagerInitParams _message = new PaymentManagerInitParams();
      _message.contextUrl = contextUrl;
      _message.serviceWorkerScope = serviceWorkerScope;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void deletePaymentInstrument(
        String instrumentKey, DeletePaymentInstrument_Response callback) {
      PaymentManagerDeletePaymentInstrumentParams _message =
          new PaymentManagerDeletePaymentInstrumentParams();
      _message.instrumentKey = instrumentKey;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new PaymentManagerDeletePaymentInstrumentResponseParamsForwardToCallback(callback));
    }

    @Override
    public void getPaymentInstrument(String instrumentKey, GetPaymentInstrument_Response callback) {
      PaymentManagerGetPaymentInstrumentParams _message =
          new PaymentManagerGetPaymentInstrumentParams();
      _message.instrumentKey = instrumentKey;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new PaymentManagerGetPaymentInstrumentResponseParamsForwardToCallback(callback));
    }

    @Override
    public void keysOfPaymentInstruments(KeysOfPaymentInstruments_Response callback) {
      PaymentManagerKeysOfPaymentInstrumentsParams _message =
          new PaymentManagerKeysOfPaymentInstrumentsParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)),
              new PaymentManagerKeysOfPaymentInstrumentsResponseParamsForwardToCallback(callback));
    }

    @Override
    public void hasPaymentInstrument(String instrumentKey, HasPaymentInstrument_Response callback) {
      PaymentManagerHasPaymentInstrumentParams _message =
          new PaymentManagerHasPaymentInstrumentParams();
      _message.instrumentKey = instrumentKey;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)),
              new PaymentManagerHasPaymentInstrumentResponseParamsForwardToCallback(callback));
    }

    @Override
    public void setPaymentInstrument(
        String instrumentKey,
        PaymentInstrument instrument,
        SetPaymentInstrument_Response callback) {
      PaymentManagerSetPaymentInstrumentParams _message =
          new PaymentManagerSetPaymentInstrumentParams();
      _message.instrumentKey = instrumentKey;
      _message.instrument = instrument;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(5, 1, 0L)),
              new PaymentManagerSetPaymentInstrumentResponseParamsForwardToCallback(callback));
    }

    @Override
    public void clearPaymentInstruments(ClearPaymentInstruments_Response callback) {
      PaymentManagerClearPaymentInstrumentsParams _message =
          new PaymentManagerClearPaymentInstrumentsParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(6, 1, 0L)),
              new PaymentManagerClearPaymentInstrumentsResponseParamsForwardToCallback(callback));
    }

    @Override
    public void setUserHint(String userHint) {
      PaymentManagerSetUserHintParams _message = new PaymentManagerSetUserHintParams();
      _message.userHint = userHint;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(7)));
    }

    @Override
    public void enableDelegations(int[] delegations, EnableDelegations_Response callback) {
      PaymentManagerEnableDelegationsParams _message = new PaymentManagerEnableDelegationsParams();
      _message.delegations = delegations;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(8, 1, 0L)),
              new PaymentManagerEnableDelegationsResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<PaymentManager> {
    Stub(Core core, PaymentManager impl) {
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
                PaymentManager_Internal.MANAGER, messageWithHeader);
          case 0:
            PaymentManagerInitParams data =
                PaymentManagerInitParams.deserialize(messageWithHeader.getPayload());
            getImpl().init(data.contextUrl, data.serviceWorkerScope);
            return true;
          case 7:
            getImpl()
                .setUserHint(
                    PaymentManagerSetUserHintParams.deserialize(messageWithHeader.getPayload())
                        .userHint);
            return true;
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
                getCore(), PaymentManager_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
          case 7:
          default:
            return false;
          case 1:
            PaymentManagerDeletePaymentInstrumentParams data =
                PaymentManagerDeletePaymentInstrumentParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .deletePaymentInstrument(
                    data.instrumentKey,
                    new PaymentManagerDeletePaymentInstrumentResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 2:
            PaymentManagerGetPaymentInstrumentParams data2 =
                PaymentManagerGetPaymentInstrumentParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .getPaymentInstrument(
                    data2.instrumentKey,
                    new PaymentManagerGetPaymentInstrumentResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 3:
            PaymentManagerKeysOfPaymentInstrumentsParams.deserialize(
                messageWithHeader.getPayload());
            getImpl()
                .keysOfPaymentInstruments(
                    new PaymentManagerKeysOfPaymentInstrumentsResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 4:
            PaymentManagerHasPaymentInstrumentParams data3 =
                PaymentManagerHasPaymentInstrumentParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .hasPaymentInstrument(
                    data3.instrumentKey,
                    new PaymentManagerHasPaymentInstrumentResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 5:
            PaymentManagerSetPaymentInstrumentParams data4 =
                PaymentManagerSetPaymentInstrumentParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .setPaymentInstrument(
                    data4.instrumentKey,
                    data4.instrument,
                    new PaymentManagerSetPaymentInstrumentResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 6:
            PaymentManagerClearPaymentInstrumentsParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .clearPaymentInstruments(
                    new PaymentManagerClearPaymentInstrumentsResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 8:
            PaymentManagerEnableDelegationsParams data5 =
                PaymentManagerEnableDelegationsParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .enableDelegations(
                    data5.delegations,
                    new PaymentManagerEnableDelegationsResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class PaymentManagerInitParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public Url contextUrl;
    public String serviceWorkerScope;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PaymentManagerInitParams(int version) {
      super(24, version);
    }

    public PaymentManagerInitParams() {
      this(0);
    }

    public static PaymentManagerInitParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PaymentManagerInitParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PaymentManagerInitParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PaymentManagerInitParams result = new PaymentManagerInitParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.contextUrl = Url.decode(decoder1);
        result.serviceWorkerScope = decoder0.readString(16, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.contextUrl, 8, false);
      encoder0.encode(this.serviceWorkerScope, 16, false);
    }
  }

  static final class PaymentManagerDeletePaymentInstrumentParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String instrumentKey;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PaymentManagerDeletePaymentInstrumentParams(int version) {
      super(16, version);
    }

    public PaymentManagerDeletePaymentInstrumentParams() {
      this(0);
    }

    public static PaymentManagerDeletePaymentInstrumentParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PaymentManagerDeletePaymentInstrumentParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PaymentManagerDeletePaymentInstrumentParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PaymentManagerDeletePaymentInstrumentParams result =
            new PaymentManagerDeletePaymentInstrumentParams(elementsOrVersion);
        result.instrumentKey = decoder0.readString(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.instrumentKey, 8, false);
    }
  }

  static final class PaymentManagerDeletePaymentInstrumentResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int status;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PaymentManagerDeletePaymentInstrumentResponseParams(int version) {
      super(16, version);
    }

    public PaymentManagerDeletePaymentInstrumentResponseParams() {
      this(0);
    }

    public static PaymentManagerDeletePaymentInstrumentResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PaymentManagerDeletePaymentInstrumentResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PaymentManagerDeletePaymentInstrumentResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PaymentManagerDeletePaymentInstrumentResponseParams result =
            new PaymentManagerDeletePaymentInstrumentResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.status = readInt;
        PaymentHandlerStatus.validate(readInt);
        result.status = PaymentHandlerStatus.toKnownValue(result.status);
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

  static class PaymentManagerDeletePaymentInstrumentResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final PaymentManager.DeletePaymentInstrument_Response mCallback;

    PaymentManagerDeletePaymentInstrumentResponseParamsForwardToCallback(
        PaymentManager.DeletePaymentInstrument_Response callback) {
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
        PaymentManagerDeletePaymentInstrumentResponseParams response =
            PaymentManagerDeletePaymentInstrumentResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.status);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class PaymentManagerDeletePaymentInstrumentResponseParamsProxyToResponder
      implements PaymentManager.DeletePaymentInstrument_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    PaymentManagerDeletePaymentInstrumentResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int status) {
      PaymentManagerDeletePaymentInstrumentResponseParams _response =
          new PaymentManagerDeletePaymentInstrumentResponseParams();
      _response.status = status;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class PaymentManagerGetPaymentInstrumentParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String instrumentKey;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PaymentManagerGetPaymentInstrumentParams(int version) {
      super(16, version);
    }

    public PaymentManagerGetPaymentInstrumentParams() {
      this(0);
    }

    public static PaymentManagerGetPaymentInstrumentParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PaymentManagerGetPaymentInstrumentParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PaymentManagerGetPaymentInstrumentParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PaymentManagerGetPaymentInstrumentParams result =
            new PaymentManagerGetPaymentInstrumentParams(elementsOrVersion);
        result.instrumentKey = decoder0.readString(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.instrumentKey, 8, false);
    }
  }

  static final class PaymentManagerGetPaymentInstrumentResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public PaymentInstrument instrument;
    public int status;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PaymentManagerGetPaymentInstrumentResponseParams(int version) {
      super(24, version);
    }

    public PaymentManagerGetPaymentInstrumentResponseParams() {
      this(0);
    }

    public static PaymentManagerGetPaymentInstrumentResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PaymentManagerGetPaymentInstrumentResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PaymentManagerGetPaymentInstrumentResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PaymentManagerGetPaymentInstrumentResponseParams result =
            new PaymentManagerGetPaymentInstrumentResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.instrument = PaymentInstrument.decode(decoder1);
        int readInt = decoder0.readInt(16);
        result.status = readInt;
        PaymentHandlerStatus.validate(readInt);
        result.status = PaymentHandlerStatus.toKnownValue(result.status);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.instrument, 8, false);
      encoder0.encode(this.status, 16);
    }
  }

  static class PaymentManagerGetPaymentInstrumentResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final PaymentManager.GetPaymentInstrument_Response mCallback;

    PaymentManagerGetPaymentInstrumentResponseParamsForwardToCallback(
        PaymentManager.GetPaymentInstrument_Response callback) {
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
        PaymentManagerGetPaymentInstrumentResponseParams response =
            PaymentManagerGetPaymentInstrumentResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.instrument, response.status);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class PaymentManagerGetPaymentInstrumentResponseParamsProxyToResponder
      implements PaymentManager.GetPaymentInstrument_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    PaymentManagerGetPaymentInstrumentResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(PaymentInstrument instrument, int status) {
      PaymentManagerGetPaymentInstrumentResponseParams _response =
          new PaymentManagerGetPaymentInstrumentResponseParams();
      _response.instrument = instrument;
      _response.status = status;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class PaymentManagerKeysOfPaymentInstrumentsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PaymentManagerKeysOfPaymentInstrumentsParams(int version) {
      super(8, version);
    }

    public PaymentManagerKeysOfPaymentInstrumentsParams() {
      this(0);
    }

    public static PaymentManagerKeysOfPaymentInstrumentsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PaymentManagerKeysOfPaymentInstrumentsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PaymentManagerKeysOfPaymentInstrumentsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PaymentManagerKeysOfPaymentInstrumentsParams result =
            new PaymentManagerKeysOfPaymentInstrumentsParams(elementsOrVersion);
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

  static final class PaymentManagerKeysOfPaymentInstrumentsResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public String[] keys;
    public int status;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PaymentManagerKeysOfPaymentInstrumentsResponseParams(int version) {
      super(24, version);
    }

    public PaymentManagerKeysOfPaymentInstrumentsResponseParams() {
      this(0);
    }

    public static PaymentManagerKeysOfPaymentInstrumentsResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static PaymentManagerKeysOfPaymentInstrumentsResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PaymentManagerKeysOfPaymentInstrumentsResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PaymentManagerKeysOfPaymentInstrumentsResponseParams result =
            new PaymentManagerKeysOfPaymentInstrumentsResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.keys = new String[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          result.keys[i1] = decoder1.readString((i1 * 8) + 8, false);
        }
        int readInt = decoder0.readInt(16);
        result.status = readInt;
        PaymentHandlerStatus.validate(readInt);
        result.status = PaymentHandlerStatus.toKnownValue(result.status);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      String[] strArr = this.keys;
      if (strArr == null) {
        encoder0.encodeNullPointer(8, false);
      } else {
        Encoder encoder1 = encoder0.encodePointerArray(strArr.length, 8, -1);
        int i0 = 0;
        while (true) {
          String[] strArr2 = this.keys;
          if (i0 >= strArr2.length) {
            break;
          }
          encoder1.encode(strArr2[i0], (i0 * 8) + 8, false);
          i0++;
        }
      }
      encoder0.encode(this.status, 16);
    }
  }

  static class PaymentManagerKeysOfPaymentInstrumentsResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final PaymentManager.KeysOfPaymentInstruments_Response mCallback;

    PaymentManagerKeysOfPaymentInstrumentsResponseParamsForwardToCallback(
        PaymentManager.KeysOfPaymentInstruments_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(3, 2)) {
          return false;
        }
        PaymentManagerKeysOfPaymentInstrumentsResponseParams response =
            PaymentManagerKeysOfPaymentInstrumentsResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.keys, response.status);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class PaymentManagerKeysOfPaymentInstrumentsResponseParamsProxyToResponder
      implements PaymentManager.KeysOfPaymentInstruments_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    PaymentManagerKeysOfPaymentInstrumentsResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(String[] keys, int status) {
      PaymentManagerKeysOfPaymentInstrumentsResponseParams _response =
          new PaymentManagerKeysOfPaymentInstrumentsResponseParams();
      _response.keys = keys;
      _response.status = status;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class PaymentManagerHasPaymentInstrumentParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String instrumentKey;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PaymentManagerHasPaymentInstrumentParams(int version) {
      super(16, version);
    }

    public PaymentManagerHasPaymentInstrumentParams() {
      this(0);
    }

    public static PaymentManagerHasPaymentInstrumentParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PaymentManagerHasPaymentInstrumentParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PaymentManagerHasPaymentInstrumentParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PaymentManagerHasPaymentInstrumentParams result =
            new PaymentManagerHasPaymentInstrumentParams(elementsOrVersion);
        result.instrumentKey = decoder0.readString(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.instrumentKey, 8, false);
    }
  }

  static final class PaymentManagerHasPaymentInstrumentResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int status;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PaymentManagerHasPaymentInstrumentResponseParams(int version) {
      super(16, version);
    }

    public PaymentManagerHasPaymentInstrumentResponseParams() {
      this(0);
    }

    public static PaymentManagerHasPaymentInstrumentResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PaymentManagerHasPaymentInstrumentResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PaymentManagerHasPaymentInstrumentResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PaymentManagerHasPaymentInstrumentResponseParams result =
            new PaymentManagerHasPaymentInstrumentResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.status = readInt;
        PaymentHandlerStatus.validate(readInt);
        result.status = PaymentHandlerStatus.toKnownValue(result.status);
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

  static class PaymentManagerHasPaymentInstrumentResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final PaymentManager.HasPaymentInstrument_Response mCallback;

    PaymentManagerHasPaymentInstrumentResponseParamsForwardToCallback(
        PaymentManager.HasPaymentInstrument_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(4, 2)) {
          return false;
        }
        PaymentManagerHasPaymentInstrumentResponseParams response =
            PaymentManagerHasPaymentInstrumentResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.status);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class PaymentManagerHasPaymentInstrumentResponseParamsProxyToResponder
      implements PaymentManager.HasPaymentInstrument_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    PaymentManagerHasPaymentInstrumentResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int status) {
      PaymentManagerHasPaymentInstrumentResponseParams _response =
          new PaymentManagerHasPaymentInstrumentResponseParams();
      _response.status = status;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class PaymentManagerSetPaymentInstrumentParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public PaymentInstrument instrument;
    public String instrumentKey;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PaymentManagerSetPaymentInstrumentParams(int version) {
      super(24, version);
    }

    public PaymentManagerSetPaymentInstrumentParams() {
      this(0);
    }

    public static PaymentManagerSetPaymentInstrumentParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PaymentManagerSetPaymentInstrumentParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PaymentManagerSetPaymentInstrumentParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PaymentManagerSetPaymentInstrumentParams result =
            new PaymentManagerSetPaymentInstrumentParams(elementsOrVersion);
        result.instrumentKey = decoder0.readString(8, false);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.instrument = PaymentInstrument.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.instrumentKey, 8, false);
      encoder0.encode((Struct) this.instrument, 16, false);
    }
  }

  static final class PaymentManagerSetPaymentInstrumentResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int status;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PaymentManagerSetPaymentInstrumentResponseParams(int version) {
      super(16, version);
    }

    public PaymentManagerSetPaymentInstrumentResponseParams() {
      this(0);
    }

    public static PaymentManagerSetPaymentInstrumentResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PaymentManagerSetPaymentInstrumentResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PaymentManagerSetPaymentInstrumentResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PaymentManagerSetPaymentInstrumentResponseParams result =
            new PaymentManagerSetPaymentInstrumentResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.status = readInt;
        PaymentHandlerStatus.validate(readInt);
        result.status = PaymentHandlerStatus.toKnownValue(result.status);
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

  static class PaymentManagerSetPaymentInstrumentResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final PaymentManager.SetPaymentInstrument_Response mCallback;

    PaymentManagerSetPaymentInstrumentResponseParamsForwardToCallback(
        PaymentManager.SetPaymentInstrument_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(5, 2)) {
          return false;
        }
        PaymentManagerSetPaymentInstrumentResponseParams response =
            PaymentManagerSetPaymentInstrumentResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.status);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class PaymentManagerSetPaymentInstrumentResponseParamsProxyToResponder
      implements PaymentManager.SetPaymentInstrument_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    PaymentManagerSetPaymentInstrumentResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int status) {
      PaymentManagerSetPaymentInstrumentResponseParams _response =
          new PaymentManagerSetPaymentInstrumentResponseParams();
      _response.status = status;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(5, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class PaymentManagerClearPaymentInstrumentsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PaymentManagerClearPaymentInstrumentsParams(int version) {
      super(8, version);
    }

    public PaymentManagerClearPaymentInstrumentsParams() {
      this(0);
    }

    public static PaymentManagerClearPaymentInstrumentsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PaymentManagerClearPaymentInstrumentsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PaymentManagerClearPaymentInstrumentsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PaymentManagerClearPaymentInstrumentsParams result =
            new PaymentManagerClearPaymentInstrumentsParams(elementsOrVersion);
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

  static final class PaymentManagerClearPaymentInstrumentsResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int status;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PaymentManagerClearPaymentInstrumentsResponseParams(int version) {
      super(16, version);
    }

    public PaymentManagerClearPaymentInstrumentsResponseParams() {
      this(0);
    }

    public static PaymentManagerClearPaymentInstrumentsResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PaymentManagerClearPaymentInstrumentsResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PaymentManagerClearPaymentInstrumentsResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PaymentManagerClearPaymentInstrumentsResponseParams result =
            new PaymentManagerClearPaymentInstrumentsResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.status = readInt;
        PaymentHandlerStatus.validate(readInt);
        result.status = PaymentHandlerStatus.toKnownValue(result.status);
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

  static class PaymentManagerClearPaymentInstrumentsResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final PaymentManager.ClearPaymentInstruments_Response mCallback;

    PaymentManagerClearPaymentInstrumentsResponseParamsForwardToCallback(
        PaymentManager.ClearPaymentInstruments_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(6, 2)) {
          return false;
        }
        PaymentManagerClearPaymentInstrumentsResponseParams response =
            PaymentManagerClearPaymentInstrumentsResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.status);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class PaymentManagerClearPaymentInstrumentsResponseParamsProxyToResponder
      implements PaymentManager.ClearPaymentInstruments_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    PaymentManagerClearPaymentInstrumentsResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int status) {
      PaymentManagerClearPaymentInstrumentsResponseParams _response =
          new PaymentManagerClearPaymentInstrumentsResponseParams();
      _response.status = status;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(6, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class PaymentManagerSetUserHintParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String userHint;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PaymentManagerSetUserHintParams(int version) {
      super(16, version);
    }

    public PaymentManagerSetUserHintParams() {
      this(0);
    }

    public static PaymentManagerSetUserHintParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PaymentManagerSetUserHintParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PaymentManagerSetUserHintParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PaymentManagerSetUserHintParams result =
            new PaymentManagerSetUserHintParams(elementsOrVersion);
        result.userHint = decoder0.readString(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.userHint, 8, false);
    }
  }

  static final class PaymentManagerEnableDelegationsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int[] delegations;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PaymentManagerEnableDelegationsParams(int version) {
      super(16, version);
    }

    public PaymentManagerEnableDelegationsParams() {
      this(0);
    }

    public static PaymentManagerEnableDelegationsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PaymentManagerEnableDelegationsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PaymentManagerEnableDelegationsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PaymentManagerEnableDelegationsParams result =
            new PaymentManagerEnableDelegationsParams(elementsOrVersion);
        result.delegations = decoder0.readInts(8, 0, -1);
        int i1 = 0;
        while (true) {
          int[] iArr = result.delegations;
          if (i1 < iArr.length) {
            PaymentDelegation.validate(iArr[i1]);
            i1++;
          } else {
            return result;
          }
        }
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.delegations, 8, 0, -1);
    }
  }

  static final class PaymentManagerEnableDelegationsResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int status;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PaymentManagerEnableDelegationsResponseParams(int version) {
      super(16, version);
    }

    public PaymentManagerEnableDelegationsResponseParams() {
      this(0);
    }

    public static PaymentManagerEnableDelegationsResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PaymentManagerEnableDelegationsResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PaymentManagerEnableDelegationsResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PaymentManagerEnableDelegationsResponseParams result =
            new PaymentManagerEnableDelegationsResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.status = readInt;
        PaymentHandlerStatus.validate(readInt);
        result.status = PaymentHandlerStatus.toKnownValue(result.status);
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

  static class PaymentManagerEnableDelegationsResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final PaymentManager.EnableDelegations_Response mCallback;

    PaymentManagerEnableDelegationsResponseParamsForwardToCallback(
        PaymentManager.EnableDelegations_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(8, 2)) {
          return false;
        }
        PaymentManagerEnableDelegationsResponseParams response =
            PaymentManagerEnableDelegationsResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.status);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class PaymentManagerEnableDelegationsResponseParamsProxyToResponder
      implements PaymentManager.EnableDelegations_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    PaymentManagerEnableDelegationsResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int status) {
      PaymentManagerEnableDelegationsResponseParams _response =
          new PaymentManagerEnableDelegationsResponseParams();
      _response.status = status;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(8, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
