package org.chromium.blink.mojom;

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

class DevicePostureProvider_Internal {
  private static final int ADD_LISTENER_AND_GET_CURRENT_POSTURE_ORDINAL = 0;
  private static final int DISABLE_DEVICE_POSTURE_OVERRIDE_FOR_EMULATION_ORDINAL = 2;
  public static final Interface.Manager<DevicePostureProvider, DevicePostureProvider.Proxy>
      MANAGER =
          new Interface.Manager<DevicePostureProvider, DevicePostureProvider.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.DevicePostureProvider";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public DevicePostureProvider.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, DevicePostureProvider impl) {
              return new Stub(core, impl);
            }

            @Override
            public DevicePostureProvider[] buildArray(int size) {
              return new DevicePostureProvider[size];
            }
          };
  private static final int OVERRIDE_DEVICE_POSTURE_FOR_EMULATION_ORDINAL = 1;

  DevicePostureProvider_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements DevicePostureProvider.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void addListenerAndGetCurrentPosture(
        DevicePostureClient client, AddListenerAndGetCurrentPosture_Response callback) {
      DevicePostureProviderAddListenerAndGetCurrentPostureParams _message =
          new DevicePostureProviderAddListenerAndGetCurrentPostureParams();
      _message.client = client;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new DevicePostureProviderAddListenerAndGetCurrentPostureResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void overrideDevicePostureForEmulation(int posture) {
      DevicePostureProviderOverrideDevicePostureForEmulationParams _message =
          new DevicePostureProviderOverrideDevicePostureForEmulationParams();
      _message.posture = posture;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void disableDevicePostureOverrideForEmulation() {
      DevicePostureProviderDisableDevicePostureOverrideForEmulationParams _message =
          new DevicePostureProviderDisableDevicePostureOverrideForEmulationParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }
  }

  public static final class Stub extends Interface.Stub<DevicePostureProvider> {
    Stub(Core core, DevicePostureProvider impl) {
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
                DevicePostureProvider_Internal.MANAGER, messageWithHeader);
          case -1:
          case 0:
          default:
            return false;
          case 1:
            DevicePostureProviderOverrideDevicePostureForEmulationParams data =
                DevicePostureProviderOverrideDevicePostureForEmulationParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().overrideDevicePostureForEmulation(data.posture);
            return true;
          case 2:
            DevicePostureProviderDisableDevicePostureOverrideForEmulationParams.deserialize(
                messageWithHeader.getPayload());
            getImpl().disableDevicePostureOverrideForEmulation();
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
                getCore(), DevicePostureProvider_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            DevicePostureProviderAddListenerAndGetCurrentPostureParams data =
                DevicePostureProviderAddListenerAndGetCurrentPostureParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .addListenerAndGetCurrentPosture(
                    data.client,
                    new DevicePostureProviderAddListenerAndGetCurrentPostureResponseParamsProxyToResponder(
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

  static final class DevicePostureProviderAddListenerAndGetCurrentPostureParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public DevicePostureClient client;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DevicePostureProviderAddListenerAndGetCurrentPostureParams(int version) {
      super(16, version);
    }

    public DevicePostureProviderAddListenerAndGetCurrentPostureParams() {
      this(0);
    }

    public static DevicePostureProviderAddListenerAndGetCurrentPostureParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static DevicePostureProviderAddListenerAndGetCurrentPostureParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DevicePostureProviderAddListenerAndGetCurrentPostureParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DevicePostureProviderAddListenerAndGetCurrentPostureParams result =
            new DevicePostureProviderAddListenerAndGetCurrentPostureParams(elementsOrVersion);
        result.client =
            (DevicePostureClient)
                decoder0.readServiceInterface(8, false, DevicePostureClient.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.client, 8, false, DevicePostureClient.MANAGER);
    }
  }

  static final class DevicePostureProviderAddListenerAndGetCurrentPostureResponseParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int posture;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DevicePostureProviderAddListenerAndGetCurrentPostureResponseParams(int version) {
      super(16, version);
    }

    public DevicePostureProviderAddListenerAndGetCurrentPostureResponseParams() {
      this(0);
    }

    public static DevicePostureProviderAddListenerAndGetCurrentPostureResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static DevicePostureProviderAddListenerAndGetCurrentPostureResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DevicePostureProviderAddListenerAndGetCurrentPostureResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DevicePostureProviderAddListenerAndGetCurrentPostureResponseParams result =
            new DevicePostureProviderAddListenerAndGetCurrentPostureResponseParams(
                elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.posture = readInt;
        DevicePostureType.validate(readInt);
        result.posture = DevicePostureType.toKnownValue(result.posture);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.posture, 8);
    }
  }

  static class DevicePostureProviderAddListenerAndGetCurrentPostureResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final DevicePostureProvider.AddListenerAndGetCurrentPosture_Response mCallback;

    DevicePostureProviderAddListenerAndGetCurrentPostureResponseParamsForwardToCallback(
        DevicePostureProvider.AddListenerAndGetCurrentPosture_Response callback) {
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
        DevicePostureProviderAddListenerAndGetCurrentPostureResponseParams response =
            DevicePostureProviderAddListenerAndGetCurrentPostureResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.posture);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class DevicePostureProviderAddListenerAndGetCurrentPostureResponseParamsProxyToResponder
      implements DevicePostureProvider.AddListenerAndGetCurrentPosture_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    DevicePostureProviderAddListenerAndGetCurrentPostureResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int posture) {
      DevicePostureProviderAddListenerAndGetCurrentPostureResponseParams _response =
          new DevicePostureProviderAddListenerAndGetCurrentPostureResponseParams();
      _response.posture = posture;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class DevicePostureProviderOverrideDevicePostureForEmulationParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int posture;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DevicePostureProviderOverrideDevicePostureForEmulationParams(int version) {
      super(16, version);
    }

    public DevicePostureProviderOverrideDevicePostureForEmulationParams() {
      this(0);
    }

    public static DevicePostureProviderOverrideDevicePostureForEmulationParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static DevicePostureProviderOverrideDevicePostureForEmulationParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DevicePostureProviderOverrideDevicePostureForEmulationParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DevicePostureProviderOverrideDevicePostureForEmulationParams result =
            new DevicePostureProviderOverrideDevicePostureForEmulationParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.posture = readInt;
        DevicePostureType.validate(readInt);
        result.posture = DevicePostureType.toKnownValue(result.posture);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.posture, 8);
    }
  }

  static final class DevicePostureProviderDisableDevicePostureOverrideForEmulationParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DevicePostureProviderDisableDevicePostureOverrideForEmulationParams(int version) {
      super(8, version);
    }

    public DevicePostureProviderDisableDevicePostureOverrideForEmulationParams() {
      this(0);
    }

    public static DevicePostureProviderDisableDevicePostureOverrideForEmulationParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static DevicePostureProviderDisableDevicePostureOverrideForEmulationParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DevicePostureProviderDisableDevicePostureOverrideForEmulationParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DevicePostureProviderDisableDevicePostureOverrideForEmulationParams result =
            new DevicePostureProviderDisableDevicePostureOverrideForEmulationParams(
                elementsOrVersion);
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
