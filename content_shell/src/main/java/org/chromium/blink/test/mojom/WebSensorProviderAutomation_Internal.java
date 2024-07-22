package org.chromium.blink.test.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.device.mojom.CreateVirtualSensorResult;
import org.chromium.device.mojom.GetVirtualSensorInformationResult;
import org.chromium.device.mojom.SensorReadingRaw;
import org.chromium.device.mojom.SensorType;
import org.chromium.device.mojom.UpdateVirtualSensorResult;
import org.chromium.device.mojom.VirtualSensorMetadata;
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
import org.chromium.mojo.bindings.Union;
import org.chromium.mojo.system.Core;

class WebSensorProviderAutomation_Internal {
  private static final int CREATE_VIRTUAL_SENSOR_ORDINAL = 0;
  private static final int GET_VIRTUAL_SENSOR_INFORMATION_ORDINAL = 3;
  public static final Interface.Manager<
          WebSensorProviderAutomation, WebSensorProviderAutomation.Proxy>
      MANAGER =
          new Interface.Manager<WebSensorProviderAutomation, WebSensorProviderAutomation.Proxy>() {
            @Override
            public String getName() {
              return "blink.test.mojom.WebSensorProviderAutomation";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public WebSensorProviderAutomation.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, WebSensorProviderAutomation impl) {
              return new Stub(core, impl);
            }

            @Override
            public WebSensorProviderAutomation[] buildArray(int size) {
              return new WebSensorProviderAutomation[size];
            }
          };
  private static final int REMOVE_VIRTUAL_SENSOR_ORDINAL = 2;
  private static final int UPDATE_VIRTUAL_SENSOR_ORDINAL = 1;

  WebSensorProviderAutomation_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements WebSensorProviderAutomation.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void createVirtualSensor(
        int type, VirtualSensorMetadata metadata, CreateVirtualSensor_Response callback) {
      WebSensorProviderAutomationCreateVirtualSensorParams _message =
          new WebSensorProviderAutomationCreateVirtualSensorParams();
      _message.type = type;
      _message.metadata = metadata;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new WebSensorProviderAutomationCreateVirtualSensorResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void updateVirtualSensor(
        int type, SensorReadingRaw reading, UpdateVirtualSensor_Response callback) {
      WebSensorProviderAutomationUpdateVirtualSensorParams _message =
          new WebSensorProviderAutomationUpdateVirtualSensorParams();
      _message.type = type;
      _message.reading = reading;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new WebSensorProviderAutomationUpdateVirtualSensorResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void removeVirtualSensor(int type, RemoveVirtualSensor_Response callback) {
      WebSensorProviderAutomationRemoveVirtualSensorParams _message =
          new WebSensorProviderAutomationRemoveVirtualSensorParams();
      _message.type = type;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new WebSensorProviderAutomationRemoveVirtualSensorResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void getVirtualSensorInformation(
        int type, GetVirtualSensorInformation_Response callback) {
      WebSensorProviderAutomationGetVirtualSensorInformationParams _message =
          new WebSensorProviderAutomationGetVirtualSensorInformationParams();
      _message.type = type;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)),
              new WebSensorProviderAutomationGetVirtualSensorInformationResponseParamsForwardToCallback(
                  callback));
    }
  }

  public static final class Stub extends Interface.Stub<WebSensorProviderAutomation> {
    Stub(Core core, WebSensorProviderAutomation impl) {
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
                WebSensorProviderAutomation_Internal.MANAGER, messageWithHeader);
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
                getCore(),
                WebSensorProviderAutomation_Internal.MANAGER,
                messageWithHeader,
                receiver);
          case 0:
            WebSensorProviderAutomationCreateVirtualSensorParams data =
                WebSensorProviderAutomationCreateVirtualSensorParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .createVirtualSensor(
                    data.type,
                    data.metadata,
                    new WebSensorProviderAutomationCreateVirtualSensorResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
            WebSensorProviderAutomationUpdateVirtualSensorParams data2 =
                WebSensorProviderAutomationUpdateVirtualSensorParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .updateVirtualSensor(
                    data2.type,
                    data2.reading,
                    new WebSensorProviderAutomationUpdateVirtualSensorResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 2:
            getImpl()
                .removeVirtualSensor(
                    WebSensorProviderAutomationRemoveVirtualSensorParams.deserialize(
                            messageWithHeader.getPayload())
                        .type,
                    new WebSensorProviderAutomationRemoveVirtualSensorResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 3:
            getImpl()
                .getVirtualSensorInformation(
                    WebSensorProviderAutomationGetVirtualSensorInformationParams.deserialize(
                            messageWithHeader.getPayload())
                        .type,
                    new WebSensorProviderAutomationGetVirtualSensorInformationResponseParamsProxyToResponder(
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

  static final class WebSensorProviderAutomationCreateVirtualSensorParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public VirtualSensorMetadata metadata;
    public int type;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebSensorProviderAutomationCreateVirtualSensorParams(int version) {
      super(24, version);
    }

    public WebSensorProviderAutomationCreateVirtualSensorParams() {
      this(0);
    }

    public static WebSensorProviderAutomationCreateVirtualSensorParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static WebSensorProviderAutomationCreateVirtualSensorParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebSensorProviderAutomationCreateVirtualSensorParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebSensorProviderAutomationCreateVirtualSensorParams result =
            new WebSensorProviderAutomationCreateVirtualSensorParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.type = readInt;
        SensorType.validate(readInt);
        result.type = SensorType.toKnownValue(result.type);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.metadata = VirtualSensorMetadata.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.type, 8);
      encoder0.encode((Struct) this.metadata, 16, false);
    }
  }

  static final class WebSensorProviderAutomationCreateVirtualSensorResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebSensorProviderAutomationCreateVirtualSensorResponseParams(int version) {
      super(16, version);
    }

    public WebSensorProviderAutomationCreateVirtualSensorResponseParams() {
      this(0);
    }

    public static WebSensorProviderAutomationCreateVirtualSensorResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static WebSensorProviderAutomationCreateVirtualSensorResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebSensorProviderAutomationCreateVirtualSensorResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebSensorProviderAutomationCreateVirtualSensorResponseParams result =
            new WebSensorProviderAutomationCreateVirtualSensorResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.result = readInt;
        CreateVirtualSensorResult.validate(readInt);
        result.result = CreateVirtualSensorResult.toKnownValue(result.result);
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

  static class WebSensorProviderAutomationCreateVirtualSensorResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final WebSensorProviderAutomation.CreateVirtualSensor_Response mCallback;

    WebSensorProviderAutomationCreateVirtualSensorResponseParamsForwardToCallback(
        WebSensorProviderAutomation.CreateVirtualSensor_Response callback) {
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
        WebSensorProviderAutomationCreateVirtualSensorResponseParams response =
            WebSensorProviderAutomationCreateVirtualSensorResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class WebSensorProviderAutomationCreateVirtualSensorResponseParamsProxyToResponder
      implements WebSensorProviderAutomation.CreateVirtualSensor_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    WebSensorProviderAutomationCreateVirtualSensorResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int result) {
      WebSensorProviderAutomationCreateVirtualSensorResponseParams _response =
          new WebSensorProviderAutomationCreateVirtualSensorResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class WebSensorProviderAutomationUpdateVirtualSensorParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public SensorReadingRaw reading;
    public int type;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebSensorProviderAutomationUpdateVirtualSensorParams(int version) {
      super(24, version);
    }

    public WebSensorProviderAutomationUpdateVirtualSensorParams() {
      this(0);
    }

    public static WebSensorProviderAutomationUpdateVirtualSensorParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static WebSensorProviderAutomationUpdateVirtualSensorParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebSensorProviderAutomationUpdateVirtualSensorParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebSensorProviderAutomationUpdateVirtualSensorParams result =
            new WebSensorProviderAutomationUpdateVirtualSensorParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.type = readInt;
        SensorType.validate(readInt);
        result.type = SensorType.toKnownValue(result.type);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.reading = SensorReadingRaw.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.type, 8);
      encoder0.encode((Struct) this.reading, 16, false);
    }
  }

  static final class WebSensorProviderAutomationUpdateVirtualSensorResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebSensorProviderAutomationUpdateVirtualSensorResponseParams(int version) {
      super(16, version);
    }

    public WebSensorProviderAutomationUpdateVirtualSensorResponseParams() {
      this(0);
    }

    public static WebSensorProviderAutomationUpdateVirtualSensorResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static WebSensorProviderAutomationUpdateVirtualSensorResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebSensorProviderAutomationUpdateVirtualSensorResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebSensorProviderAutomationUpdateVirtualSensorResponseParams result =
            new WebSensorProviderAutomationUpdateVirtualSensorResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.result = readInt;
        UpdateVirtualSensorResult.validate(readInt);
        result.result = UpdateVirtualSensorResult.toKnownValue(result.result);
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

  static class WebSensorProviderAutomationUpdateVirtualSensorResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final WebSensorProviderAutomation.UpdateVirtualSensor_Response mCallback;

    WebSensorProviderAutomationUpdateVirtualSensorResponseParamsForwardToCallback(
        WebSensorProviderAutomation.UpdateVirtualSensor_Response callback) {
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
        WebSensorProviderAutomationUpdateVirtualSensorResponseParams response =
            WebSensorProviderAutomationUpdateVirtualSensorResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class WebSensorProviderAutomationUpdateVirtualSensorResponseParamsProxyToResponder
      implements WebSensorProviderAutomation.UpdateVirtualSensor_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    WebSensorProviderAutomationUpdateVirtualSensorResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int result) {
      WebSensorProviderAutomationUpdateVirtualSensorResponseParams _response =
          new WebSensorProviderAutomationUpdateVirtualSensorResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class WebSensorProviderAutomationRemoveVirtualSensorParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int type;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebSensorProviderAutomationRemoveVirtualSensorParams(int version) {
      super(16, version);
    }

    public WebSensorProviderAutomationRemoveVirtualSensorParams() {
      this(0);
    }

    public static WebSensorProviderAutomationRemoveVirtualSensorParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static WebSensorProviderAutomationRemoveVirtualSensorParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebSensorProviderAutomationRemoveVirtualSensorParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebSensorProviderAutomationRemoveVirtualSensorParams result =
            new WebSensorProviderAutomationRemoveVirtualSensorParams(elementsOrVersion);
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

  static final class WebSensorProviderAutomationRemoveVirtualSensorResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebSensorProviderAutomationRemoveVirtualSensorResponseParams(int version) {
      super(8, version);
    }

    public WebSensorProviderAutomationRemoveVirtualSensorResponseParams() {
      this(0);
    }

    public static WebSensorProviderAutomationRemoveVirtualSensorResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static WebSensorProviderAutomationRemoveVirtualSensorResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebSensorProviderAutomationRemoveVirtualSensorResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebSensorProviderAutomationRemoveVirtualSensorResponseParams result =
            new WebSensorProviderAutomationRemoveVirtualSensorResponseParams(elementsOrVersion);
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

  static class WebSensorProviderAutomationRemoveVirtualSensorResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final WebSensorProviderAutomation.RemoveVirtualSensor_Response mCallback;

    WebSensorProviderAutomationRemoveVirtualSensorResponseParamsForwardToCallback(
        WebSensorProviderAutomation.RemoveVirtualSensor_Response callback) {
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
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class WebSensorProviderAutomationRemoveVirtualSensorResponseParamsProxyToResponder
      implements WebSensorProviderAutomation.RemoveVirtualSensor_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    WebSensorProviderAutomationRemoveVirtualSensorResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      WebSensorProviderAutomationRemoveVirtualSensorResponseParams _response =
          new WebSensorProviderAutomationRemoveVirtualSensorResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class WebSensorProviderAutomationGetVirtualSensorInformationParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int type;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebSensorProviderAutomationGetVirtualSensorInformationParams(int version) {
      super(16, version);
    }

    public WebSensorProviderAutomationGetVirtualSensorInformationParams() {
      this(0);
    }

    public static WebSensorProviderAutomationGetVirtualSensorInformationParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static WebSensorProviderAutomationGetVirtualSensorInformationParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebSensorProviderAutomationGetVirtualSensorInformationParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebSensorProviderAutomationGetVirtualSensorInformationParams result =
            new WebSensorProviderAutomationGetVirtualSensorInformationParams(elementsOrVersion);
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

  static final class WebSensorProviderAutomationGetVirtualSensorInformationResponseParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public GetVirtualSensorInformationResult result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebSensorProviderAutomationGetVirtualSensorInformationResponseParams(int version) {
      super(24, version);
    }

    public WebSensorProviderAutomationGetVirtualSensorInformationResponseParams() {
      this(0);
    }

    public static WebSensorProviderAutomationGetVirtualSensorInformationResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static WebSensorProviderAutomationGetVirtualSensorInformationResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebSensorProviderAutomationGetVirtualSensorInformationResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebSensorProviderAutomationGetVirtualSensorInformationResponseParams result =
            new WebSensorProviderAutomationGetVirtualSensorInformationResponseParams(
                elementsOrVersion);
        result.result = GetVirtualSensorInformationResult.decode(decoder0, 8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Union) this.result, 8, false);
    }
  }

  static class WebSensorProviderAutomationGetVirtualSensorInformationResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final WebSensorProviderAutomation.GetVirtualSensorInformation_Response mCallback;

    WebSensorProviderAutomationGetVirtualSensorInformationResponseParamsForwardToCallback(
        WebSensorProviderAutomation.GetVirtualSensorInformation_Response callback) {
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
        WebSensorProviderAutomationGetVirtualSensorInformationResponseParams response =
            WebSensorProviderAutomationGetVirtualSensorInformationResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class WebSensorProviderAutomationGetVirtualSensorInformationResponseParamsProxyToResponder
      implements WebSensorProviderAutomation.GetVirtualSensorInformation_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    WebSensorProviderAutomationGetVirtualSensorInformationResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(GetVirtualSensorInformationResult result) {
      WebSensorProviderAutomationGetVirtualSensorInformationResponseParams _response =
          new WebSensorProviderAutomationGetVirtualSensorInformationResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
