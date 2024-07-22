package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.device.mojom.SensorCreationResult;
import org.chromium.device.mojom.SensorInitParams;
import org.chromium.device.mojom.SensorType;
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

class WebSensorProvider_Internal {
  private static final int GET_SENSOR_ORDINAL = 0;
  public static final Interface.Manager<WebSensorProvider, WebSensorProvider.Proxy> MANAGER =
      new Interface.Manager<WebSensorProvider, WebSensorProvider.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.WebSensorProvider";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public WebSensorProvider.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, WebSensorProvider impl) {
          return new Stub(core, impl);
        }

        @Override
        public WebSensorProvider[] buildArray(int size) {
          return new WebSensorProvider[size];
        }
      };

  WebSensorProvider_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements WebSensorProvider.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void getSensor(int type, GetSensor_Response callback) {
      WebSensorProviderGetSensorParams _message = new WebSensorProviderGetSensorParams();
      _message.type = type;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new WebSensorProviderGetSensorResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<WebSensorProvider> {
    Stub(Core core, WebSensorProvider impl) {
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
                WebSensorProvider_Internal.MANAGER, messageWithHeader);
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
                getCore(), WebSensorProvider_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            WebSensorProviderGetSensorParams data =
                WebSensorProviderGetSensorParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .getSensor(
                    data.type,
                    new WebSensorProviderGetSensorResponseParamsProxyToResponder(
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

  static final class WebSensorProviderGetSensorParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int type;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebSensorProviderGetSensorParams(int version) {
      super(16, version);
    }

    public WebSensorProviderGetSensorParams() {
      this(0);
    }

    public static WebSensorProviderGetSensorParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WebSensorProviderGetSensorParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebSensorProviderGetSensorParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebSensorProviderGetSensorParams result =
            new WebSensorProviderGetSensorParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.type = readInt;
        SensorType.validate(readInt);
        result.type = SensorType.toKnownValue(result.type);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.type, 8);
    }
  }

  static final class WebSensorProviderGetSensorResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public SensorInitParams initParams;
    public int result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebSensorProviderGetSensorResponseParams(int version) {
      super(24, version);
    }

    public WebSensorProviderGetSensorResponseParams() {
      this(0);
    }

    public static WebSensorProviderGetSensorResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WebSensorProviderGetSensorResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebSensorProviderGetSensorResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebSensorProviderGetSensorResponseParams result =
            new WebSensorProviderGetSensorResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.result = readInt;
        SensorCreationResult.validate(readInt);
        result.result = SensorCreationResult.toKnownValue(result.result);
        Decoder decoder1 = decoder0.readPointer(16, true);
        result.initParams = SensorInitParams.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.result, 8);
      encoder0.encode((Struct) this.initParams, 16, true);
    }
  }

  static class WebSensorProviderGetSensorResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final WebSensorProvider.GetSensor_Response mCallback;

    WebSensorProviderGetSensorResponseParamsForwardToCallback(
        WebSensorProvider.GetSensor_Response callback) {
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
        WebSensorProviderGetSensorResponseParams response =
            WebSensorProviderGetSensorResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.result, response.initParams);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class WebSensorProviderGetSensorResponseParamsProxyToResponder
      implements WebSensorProvider.GetSensor_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    WebSensorProviderGetSensorResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int result, SensorInitParams initParams) {
      WebSensorProviderGetSensorResponseParams _response =
          new WebSensorProviderGetSensorResponseParams();
      _response.result = result;
      _response.initParams = initParams;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
