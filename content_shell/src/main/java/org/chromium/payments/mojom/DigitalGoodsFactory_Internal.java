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

class DigitalGoodsFactory_Internal {
  private static final int CREATE_DIGITAL_GOODS_ORDINAL = 0;
  public static final Interface.Manager<DigitalGoodsFactory, DigitalGoodsFactory.Proxy> MANAGER =
      new Interface.Manager<DigitalGoodsFactory, DigitalGoodsFactory.Proxy>() {
        @Override
        public String getName() {
          return "payments.mojom.DigitalGoodsFactory";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public DigitalGoodsFactory.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, DigitalGoodsFactory impl) {
          return new Stub(core, impl);
        }

        @Override
        public DigitalGoodsFactory[] buildArray(int size) {
          return new DigitalGoodsFactory[size];
        }
      };

  DigitalGoodsFactory_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements DigitalGoodsFactory.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void createDigitalGoods(String paymentMethod, CreateDigitalGoods_Response callback) {
      DigitalGoodsFactoryCreateDigitalGoodsParams _message =
          new DigitalGoodsFactoryCreateDigitalGoodsParams();
      _message.paymentMethod = paymentMethod;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new DigitalGoodsFactoryCreateDigitalGoodsResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<DigitalGoodsFactory> {
    Stub(Core core, DigitalGoodsFactory impl) {
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
                DigitalGoodsFactory_Internal.MANAGER, messageWithHeader);
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
                getCore(), DigitalGoodsFactory_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            DigitalGoodsFactoryCreateDigitalGoodsParams data =
                DigitalGoodsFactoryCreateDigitalGoodsParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .createDigitalGoods(
                    data.paymentMethod,
                    new DigitalGoodsFactoryCreateDigitalGoodsResponseParamsProxyToResponder(
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

  static final class DigitalGoodsFactoryCreateDigitalGoodsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String paymentMethod;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DigitalGoodsFactoryCreateDigitalGoodsParams(int version) {
      super(16, version);
    }

    public DigitalGoodsFactoryCreateDigitalGoodsParams() {
      this(0);
    }

    public static DigitalGoodsFactoryCreateDigitalGoodsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static DigitalGoodsFactoryCreateDigitalGoodsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DigitalGoodsFactoryCreateDigitalGoodsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DigitalGoodsFactoryCreateDigitalGoodsParams result =
            new DigitalGoodsFactoryCreateDigitalGoodsParams(elementsOrVersion);
        result.paymentMethod = decoder0.readString(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.paymentMethod, 8, false);
    }
  }

  static final class DigitalGoodsFactoryCreateDigitalGoodsResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int code;
    public DigitalGoods digitalGoods;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DigitalGoodsFactoryCreateDigitalGoodsResponseParams(int version) {
      super(24, version);
    }

    public DigitalGoodsFactoryCreateDigitalGoodsResponseParams() {
      this(0);
    }

    public static DigitalGoodsFactoryCreateDigitalGoodsResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static DigitalGoodsFactoryCreateDigitalGoodsResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DigitalGoodsFactoryCreateDigitalGoodsResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DigitalGoodsFactoryCreateDigitalGoodsResponseParams result =
            new DigitalGoodsFactoryCreateDigitalGoodsResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.code = readInt;
        CreateDigitalGoodsResponseCode.validate(readInt);
        result.code = CreateDigitalGoodsResponseCode.toKnownValue(result.code);
        result.digitalGoods =
            (DigitalGoods) decoder0.readServiceInterface(12, true, DigitalGoods.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.code, 8);
      encoder0.encode(this.digitalGoods, 12, true, DigitalGoods.MANAGER);
    }
  }

  static class DigitalGoodsFactoryCreateDigitalGoodsResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final DigitalGoodsFactory.CreateDigitalGoods_Response mCallback;

    DigitalGoodsFactoryCreateDigitalGoodsResponseParamsForwardToCallback(
        DigitalGoodsFactory.CreateDigitalGoods_Response callback) {
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
        DigitalGoodsFactoryCreateDigitalGoodsResponseParams response =
            DigitalGoodsFactoryCreateDigitalGoodsResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.code, response.digitalGoods);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class DigitalGoodsFactoryCreateDigitalGoodsResponseParamsProxyToResponder
      implements DigitalGoodsFactory.CreateDigitalGoods_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    DigitalGoodsFactoryCreateDigitalGoodsResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int code, DigitalGoods digitalGoods) {
      DigitalGoodsFactoryCreateDigitalGoodsResponseParams _response =
          new DigitalGoodsFactoryCreateDigitalGoodsResponseParams();
      _response.code = code;
      _response.digitalGoods = digitalGoods;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
