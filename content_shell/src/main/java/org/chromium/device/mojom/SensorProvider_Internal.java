package org.chromium.device.mojom;

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
import org.chromium.mojo.bindings.Union;
import org.chromium.mojo.system.Core;

class SensorProvider_Internal {
  private static final int CREATE_VIRTUAL_SENSOR_ORDINAL = 1;
  private static final int GET_SENSOR_ORDINAL = 0;
  private static final int GET_VIRTUAL_SENSOR_INFORMATION_ORDINAL = 4;
  public static final Interface.Manager<SensorProvider, SensorProvider.Proxy> MANAGER =
      new Interface.Manager<SensorProvider, SensorProvider.Proxy>() {
        @Override
        public String getName() {
          return "device.mojom.SensorProvider";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public SensorProvider.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, SensorProvider impl) {
          return new Stub(core, impl);
        }

        @Override
        public SensorProvider[] buildArray(int size) {
          return new SensorProvider[size];
        }
      };
  private static final int REMOVE_VIRTUAL_SENSOR_ORDINAL = 3;
  private static final int UPDATE_VIRTUAL_SENSOR_ORDINAL = 2;

  SensorProvider_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements SensorProvider.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void getSensor(int type, GetSensor_Response callback) {
      SensorProviderGetSensorParams _message = new SensorProviderGetSensorParams();
      _message.type = type;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new SensorProviderGetSensorResponseParamsForwardToCallback(callback));
    }

    @Override
    public void createVirtualSensor(
        int type, VirtualSensorMetadata metadata, CreateVirtualSensor_Response callback) {
      SensorProviderCreateVirtualSensorParams _message =
          new SensorProviderCreateVirtualSensorParams();
      _message.type = type;
      _message.metadata = metadata;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new SensorProviderCreateVirtualSensorResponseParamsForwardToCallback(callback));
    }

    @Override
    public void updateVirtualSensor(
        int type, SensorReadingRaw reading, UpdateVirtualSensor_Response callback) {
      SensorProviderUpdateVirtualSensorParams _message =
          new SensorProviderUpdateVirtualSensorParams();
      _message.type = type;
      _message.reading = reading;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new SensorProviderUpdateVirtualSensorResponseParamsForwardToCallback(callback));
    }

    @Override
    public void removeVirtualSensor(int type, RemoveVirtualSensor_Response callback) {
      SensorProviderRemoveVirtualSensorParams _message =
          new SensorProviderRemoveVirtualSensorParams();
      _message.type = type;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)),
              new SensorProviderRemoveVirtualSensorResponseParamsForwardToCallback(callback));
    }

    @Override
    public void getVirtualSensorInformation(
        int type, GetVirtualSensorInformation_Response callback) {
      SensorProviderGetVirtualSensorInformationParams _message =
          new SensorProviderGetVirtualSensorInformationParams();
      _message.type = type;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)),
              new SensorProviderGetVirtualSensorInformationResponseParamsForwardToCallback(
                  callback));
    }
  }

  public static final class Stub extends Interface.Stub<SensorProvider> {
    Stub(Core core, SensorProvider impl) {
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
                SensorProvider_Internal.MANAGER, messageWithHeader);
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
                getCore(), SensorProvider_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            getImpl()
                .getSensor(
                    SensorProviderGetSensorParams.deserialize(messageWithHeader.getPayload()).type,
                    new SensorProviderGetSensorResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
            SensorProviderCreateVirtualSensorParams data =
                SensorProviderCreateVirtualSensorParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .createVirtualSensor(
                    data.type,
                    data.metadata,
                    new SensorProviderCreateVirtualSensorResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 2:
            SensorProviderUpdateVirtualSensorParams data2 =
                SensorProviderUpdateVirtualSensorParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .updateVirtualSensor(
                    data2.type,
                    data2.reading,
                    new SensorProviderUpdateVirtualSensorResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 3:
            SensorProviderRemoveVirtualSensorParams data3 =
                SensorProviderRemoveVirtualSensorParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .removeVirtualSensor(
                    data3.type,
                    new SensorProviderRemoveVirtualSensorResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 4:
            SensorProviderGetVirtualSensorInformationParams data4 =
                SensorProviderGetVirtualSensorInformationParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .getVirtualSensorInformation(
                    data4.type,
                    new SensorProviderGetVirtualSensorInformationResponseParamsProxyToResponder(
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

  static final class SensorProviderGetSensorParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int type;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SensorProviderGetSensorParams(int version) {
      super(16, version);
    }

    public SensorProviderGetSensorParams() {
      this(0);
    }

    public static SensorProviderGetSensorParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SensorProviderGetSensorParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SensorProviderGetSensorParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SensorProviderGetSensorParams result = new SensorProviderGetSensorParams(elementsOrVersion);
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

  static final class SensorProviderGetSensorResponseParams extends Struct {
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

    private SensorProviderGetSensorResponseParams(int version) {
      super(24, version);
    }

    public SensorProviderGetSensorResponseParams() {
      this(0);
    }

    public static SensorProviderGetSensorResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SensorProviderGetSensorResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SensorProviderGetSensorResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SensorProviderGetSensorResponseParams result =
            new SensorProviderGetSensorResponseParams(elementsOrVersion);
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

  static class SensorProviderGetSensorResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final SensorProvider.GetSensor_Response mCallback;

    SensorProviderGetSensorResponseParamsForwardToCallback(
        SensorProvider.GetSensor_Response callback) {
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
        SensorProviderGetSensorResponseParams response =
            SensorProviderGetSensorResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.result, response.initParams);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class SensorProviderGetSensorResponseParamsProxyToResponder
      implements SensorProvider.GetSensor_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    SensorProviderGetSensorResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int result, SensorInitParams initParams) {
      SensorProviderGetSensorResponseParams _response = new SensorProviderGetSensorResponseParams();
      _response.result = result;
      _response.initParams = initParams;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class SensorProviderCreateVirtualSensorParams extends Struct {
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

    private SensorProviderCreateVirtualSensorParams(int version) {
      super(24, version);
    }

    public SensorProviderCreateVirtualSensorParams() {
      this(0);
    }

    public static SensorProviderCreateVirtualSensorParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SensorProviderCreateVirtualSensorParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SensorProviderCreateVirtualSensorParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SensorProviderCreateVirtualSensorParams result =
            new SensorProviderCreateVirtualSensorParams(elementsOrVersion);
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

  static final class SensorProviderCreateVirtualSensorResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SensorProviderCreateVirtualSensorResponseParams(int version) {
      super(16, version);
    }

    public SensorProviderCreateVirtualSensorResponseParams() {
      this(0);
    }

    public static SensorProviderCreateVirtualSensorResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SensorProviderCreateVirtualSensorResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SensorProviderCreateVirtualSensorResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SensorProviderCreateVirtualSensorResponseParams result =
            new SensorProviderCreateVirtualSensorResponseParams(elementsOrVersion);
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

  static class SensorProviderCreateVirtualSensorResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final SensorProvider.CreateVirtualSensor_Response mCallback;

    SensorProviderCreateVirtualSensorResponseParamsForwardToCallback(
        SensorProvider.CreateVirtualSensor_Response callback) {
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
        SensorProviderCreateVirtualSensorResponseParams response =
            SensorProviderCreateVirtualSensorResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class SensorProviderCreateVirtualSensorResponseParamsProxyToResponder
      implements SensorProvider.CreateVirtualSensor_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    SensorProviderCreateVirtualSensorResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int result) {
      SensorProviderCreateVirtualSensorResponseParams _response =
          new SensorProviderCreateVirtualSensorResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class SensorProviderUpdateVirtualSensorParams extends Struct {
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

    private SensorProviderUpdateVirtualSensorParams(int version) {
      super(24, version);
    }

    public SensorProviderUpdateVirtualSensorParams() {
      this(0);
    }

    public static SensorProviderUpdateVirtualSensorParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SensorProviderUpdateVirtualSensorParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SensorProviderUpdateVirtualSensorParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SensorProviderUpdateVirtualSensorParams result =
            new SensorProviderUpdateVirtualSensorParams(elementsOrVersion);
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

  static final class SensorProviderUpdateVirtualSensorResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SensorProviderUpdateVirtualSensorResponseParams(int version) {
      super(16, version);
    }

    public SensorProviderUpdateVirtualSensorResponseParams() {
      this(0);
    }

    public static SensorProviderUpdateVirtualSensorResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SensorProviderUpdateVirtualSensorResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SensorProviderUpdateVirtualSensorResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SensorProviderUpdateVirtualSensorResponseParams result =
            new SensorProviderUpdateVirtualSensorResponseParams(elementsOrVersion);
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

  static class SensorProviderUpdateVirtualSensorResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final SensorProvider.UpdateVirtualSensor_Response mCallback;

    SensorProviderUpdateVirtualSensorResponseParamsForwardToCallback(
        SensorProvider.UpdateVirtualSensor_Response callback) {
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
        SensorProviderUpdateVirtualSensorResponseParams response =
            SensorProviderUpdateVirtualSensorResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class SensorProviderUpdateVirtualSensorResponseParamsProxyToResponder
      implements SensorProvider.UpdateVirtualSensor_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    SensorProviderUpdateVirtualSensorResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int result) {
      SensorProviderUpdateVirtualSensorResponseParams _response =
          new SensorProviderUpdateVirtualSensorResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class SensorProviderRemoveVirtualSensorParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int type;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SensorProviderRemoveVirtualSensorParams(int version) {
      super(16, version);
    }

    public SensorProviderRemoveVirtualSensorParams() {
      this(0);
    }

    public static SensorProviderRemoveVirtualSensorParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SensorProviderRemoveVirtualSensorParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SensorProviderRemoveVirtualSensorParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SensorProviderRemoveVirtualSensorParams result =
            new SensorProviderRemoveVirtualSensorParams(elementsOrVersion);
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

  static final class SensorProviderRemoveVirtualSensorResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SensorProviderRemoveVirtualSensorResponseParams(int version) {
      super(8, version);
    }

    public SensorProviderRemoveVirtualSensorResponseParams() {
      this(0);
    }

    public static SensorProviderRemoveVirtualSensorResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SensorProviderRemoveVirtualSensorResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SensorProviderRemoveVirtualSensorResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SensorProviderRemoveVirtualSensorResponseParams result =
            new SensorProviderRemoveVirtualSensorResponseParams(elementsOrVersion);
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

  static class SensorProviderRemoveVirtualSensorResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final SensorProvider.RemoveVirtualSensor_Response mCallback;

    SensorProviderRemoveVirtualSensorResponseParamsForwardToCallback(
        SensorProvider.RemoveVirtualSensor_Response callback) {
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
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class SensorProviderRemoveVirtualSensorResponseParamsProxyToResponder
      implements SensorProvider.RemoveVirtualSensor_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    SensorProviderRemoveVirtualSensorResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      SensorProviderRemoveVirtualSensorResponseParams _response =
          new SensorProviderRemoveVirtualSensorResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class SensorProviderGetVirtualSensorInformationParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int type;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SensorProviderGetVirtualSensorInformationParams(int version) {
      super(16, version);
    }

    public SensorProviderGetVirtualSensorInformationParams() {
      this(0);
    }

    public static SensorProviderGetVirtualSensorInformationParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SensorProviderGetVirtualSensorInformationParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SensorProviderGetVirtualSensorInformationParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SensorProviderGetVirtualSensorInformationParams result =
            new SensorProviderGetVirtualSensorInformationParams(elementsOrVersion);
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

  static final class SensorProviderGetVirtualSensorInformationResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public GetVirtualSensorInformationResult result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SensorProviderGetVirtualSensorInformationResponseParams(int version) {
      super(24, version);
    }

    public SensorProviderGetVirtualSensorInformationResponseParams() {
      this(0);
    }

    public static SensorProviderGetVirtualSensorInformationResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static SensorProviderGetVirtualSensorInformationResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SensorProviderGetVirtualSensorInformationResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SensorProviderGetVirtualSensorInformationResponseParams result =
            new SensorProviderGetVirtualSensorInformationResponseParams(elementsOrVersion);
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

  static class SensorProviderGetVirtualSensorInformationResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final SensorProvider.GetVirtualSensorInformation_Response mCallback;

    SensorProviderGetVirtualSensorInformationResponseParamsForwardToCallback(
        SensorProvider.GetVirtualSensorInformation_Response callback) {
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
        SensorProviderGetVirtualSensorInformationResponseParams response =
            SensorProviderGetVirtualSensorInformationResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class SensorProviderGetVirtualSensorInformationResponseParamsProxyToResponder
      implements SensorProvider.GetVirtualSensorInformation_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    SensorProviderGetVirtualSensorInformationResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(GetVirtualSensorInformationResult result) {
      SensorProviderGetVirtualSensorInformationResponseParams _response =
          new SensorProviderGetVirtualSensorInformationResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
