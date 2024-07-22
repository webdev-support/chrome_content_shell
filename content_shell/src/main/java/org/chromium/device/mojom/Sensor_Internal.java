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
import org.chromium.mojo.system.Core;

class Sensor_Internal {
  private static final int ADD_CONFIGURATION_ORDINAL = 1;
  private static final int CONFIGURE_READING_CHANGE_NOTIFICATIONS_ORDINAL = 5;
  private static final int GET_DEFAULT_CONFIGURATION_ORDINAL = 0;
  public static final Interface.Manager<Sensor, Sensor.Proxy> MANAGER =
      new Interface.Manager<Sensor, Sensor.Proxy>() {
        @Override
        public String getName() {
          return "device.mojom.Sensor";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public Sensor.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, Sensor impl) {
          return new Stub(core, impl);
        }

        @Override
        public Sensor[] buildArray(int size) {
          return new Sensor[size];
        }
      };
  private static final int REMOVE_CONFIGURATION_ORDINAL = 2;
  private static final int RESUME_ORDINAL = 4;
  private static final int SUSPEND_ORDINAL = 3;

  Sensor_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements Sensor.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void getDefaultConfiguration(GetDefaultConfiguration_Response callback) {
      SensorGetDefaultConfigurationParams _message = new SensorGetDefaultConfigurationParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new SensorGetDefaultConfigurationResponseParamsForwardToCallback(callback));
    }

    @Override
    public void addConfiguration(
        SensorConfiguration configuration, AddConfiguration_Response callback) {
      SensorAddConfigurationParams _message = new SensorAddConfigurationParams();
      _message.configuration = configuration;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new SensorAddConfigurationResponseParamsForwardToCallback(callback));
    }

    @Override
    public void removeConfiguration(SensorConfiguration configuration) {
      SensorRemoveConfigurationParams _message = new SensorRemoveConfigurationParams();
      _message.configuration = configuration;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void suspend() {
      SensorSuspendParams _message = new SensorSuspendParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }

    @Override
    public void resume() {
      SensorResumeParams _message = new SensorResumeParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
    }

    @Override
    public void configureReadingChangeNotifications(boolean enabled) {
      SensorConfigureReadingChangeNotificationsParams _message =
          new SensorConfigureReadingChangeNotificationsParams();
      _message.enabled = enabled;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5)));
    }
  }

  public static final class Stub extends Interface.Stub<Sensor> {
    Stub(Core core, Sensor impl) {
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
                Sensor_Internal.MANAGER, messageWithHeader);
          case -1:
          case 0:
          case 1:
          default:
            return false;
          case 2:
            SensorRemoveConfigurationParams data =
                SensorRemoveConfigurationParams.deserialize(messageWithHeader.getPayload());
            getImpl().removeConfiguration(data.configuration);
            return true;
          case 3:
            SensorSuspendParams.deserialize(messageWithHeader.getPayload());
            getImpl().suspend();
            return true;
          case 4:
            SensorResumeParams.deserialize(messageWithHeader.getPayload());
            getImpl().resume();
            return true;
          case 5:
            SensorConfigureReadingChangeNotificationsParams data2 =
                SensorConfigureReadingChangeNotificationsParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().configureReadingChangeNotifications(data2.enabled);
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
                getCore(), Sensor_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            SensorGetDefaultConfigurationParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .getDefaultConfiguration(
                    new SensorGetDefaultConfigurationResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
            SensorAddConfigurationParams data =
                SensorAddConfigurationParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .addConfiguration(
                    data.configuration,
                    new SensorAddConfigurationResponseParamsProxyToResponder(
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

  static final class SensorGetDefaultConfigurationParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SensorGetDefaultConfigurationParams(int version) {
      super(8, version);
    }

    public SensorGetDefaultConfigurationParams() {
      this(0);
    }

    public static SensorGetDefaultConfigurationParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SensorGetDefaultConfigurationParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SensorGetDefaultConfigurationParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SensorGetDefaultConfigurationParams result =
            new SensorGetDefaultConfigurationParams(elementsOrVersion);
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

  static final class SensorGetDefaultConfigurationResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public SensorConfiguration configuration;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SensorGetDefaultConfigurationResponseParams(int version) {
      super(16, version);
    }

    public SensorGetDefaultConfigurationResponseParams() {
      this(0);
    }

    public static SensorGetDefaultConfigurationResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SensorGetDefaultConfigurationResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SensorGetDefaultConfigurationResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SensorGetDefaultConfigurationResponseParams result =
            new SensorGetDefaultConfigurationResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.configuration = SensorConfiguration.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.configuration, 8, false);
    }
  }

  static class SensorGetDefaultConfigurationResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final Sensor.GetDefaultConfiguration_Response mCallback;

    SensorGetDefaultConfigurationResponseParamsForwardToCallback(
        Sensor.GetDefaultConfiguration_Response callback) {
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
        SensorGetDefaultConfigurationResponseParams response =
            SensorGetDefaultConfigurationResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.configuration);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class SensorGetDefaultConfigurationResponseParamsProxyToResponder
      implements Sensor.GetDefaultConfiguration_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    SensorGetDefaultConfigurationResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(SensorConfiguration configuration) {
      SensorGetDefaultConfigurationResponseParams _response =
          new SensorGetDefaultConfigurationResponseParams();
      _response.configuration = configuration;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class SensorAddConfigurationParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public SensorConfiguration configuration;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SensorAddConfigurationParams(int version) {
      super(16, version);
    }

    public SensorAddConfigurationParams() {
      this(0);
    }

    public static SensorAddConfigurationParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SensorAddConfigurationParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SensorAddConfigurationParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SensorAddConfigurationParams result = new SensorAddConfigurationParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.configuration = SensorConfiguration.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.configuration, 8, false);
    }
  }

  static final class SensorAddConfigurationResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean success;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SensorAddConfigurationResponseParams(int version) {
      super(16, version);
    }

    public SensorAddConfigurationResponseParams() {
      this(0);
    }

    public static SensorAddConfigurationResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SensorAddConfigurationResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SensorAddConfigurationResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SensorAddConfigurationResponseParams result =
            new SensorAddConfigurationResponseParams(elementsOrVersion);
        result.success = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.success, 8, 0);
    }
  }

  static class SensorAddConfigurationResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final Sensor.AddConfiguration_Response mCallback;

    SensorAddConfigurationResponseParamsForwardToCallback(
        Sensor.AddConfiguration_Response callback) {
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
        SensorAddConfigurationResponseParams response =
            SensorAddConfigurationResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.success);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class SensorAddConfigurationResponseParamsProxyToResponder
      implements Sensor.AddConfiguration_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    SensorAddConfigurationResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean success) {
      SensorAddConfigurationResponseParams _response = new SensorAddConfigurationResponseParams();
      _response.success = success;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class SensorRemoveConfigurationParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public SensorConfiguration configuration;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SensorRemoveConfigurationParams(int version) {
      super(16, version);
    }

    public SensorRemoveConfigurationParams() {
      this(0);
    }

    public static SensorRemoveConfigurationParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SensorRemoveConfigurationParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SensorRemoveConfigurationParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SensorRemoveConfigurationParams result =
            new SensorRemoveConfigurationParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.configuration = SensorConfiguration.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.configuration, 8, false);
    }
  }

  static final class SensorSuspendParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SensorSuspendParams(int version) {
      super(8, version);
    }

    public SensorSuspendParams() {
      this(0);
    }

    public static SensorSuspendParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SensorSuspendParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SensorSuspendParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SensorSuspendParams result = new SensorSuspendParams(elementsOrVersion);
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

  static final class SensorResumeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SensorResumeParams(int version) {
      super(8, version);
    }

    public SensorResumeParams() {
      this(0);
    }

    public static SensorResumeParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SensorResumeParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SensorResumeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SensorResumeParams result = new SensorResumeParams(elementsOrVersion);
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

  static final class SensorConfigureReadingChangeNotificationsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean enabled;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SensorConfigureReadingChangeNotificationsParams(int version) {
      super(16, version);
    }

    public SensorConfigureReadingChangeNotificationsParams() {
      this(0);
    }

    public static SensorConfigureReadingChangeNotificationsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SensorConfigureReadingChangeNotificationsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SensorConfigureReadingChangeNotificationsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SensorConfigureReadingChangeNotificationsParams result =
            new SensorConfigureReadingChangeNotificationsParams(elementsOrVersion);
        result.enabled = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.enabled, 8, 0);
    }
  }
}
