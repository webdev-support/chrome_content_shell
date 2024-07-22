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
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;

class MediaStreamDeviceObserver_Internal {
  public static final Interface.Manager<MediaStreamDeviceObserver, MediaStreamDeviceObserver.Proxy>
      MANAGER =
          new Interface.Manager<MediaStreamDeviceObserver, MediaStreamDeviceObserver.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.MediaStreamDeviceObserver";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public MediaStreamDeviceObserver.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, MediaStreamDeviceObserver impl) {
              return new Stub(core, impl);
            }

            @Override
            public MediaStreamDeviceObserver[] buildArray(int size) {
              return new MediaStreamDeviceObserver[size];
            }
          };
  private static final int ON_DEVICE_CAPTURE_CONFIGURATION_CHANGE_ORDINAL = 3;
  private static final int ON_DEVICE_CAPTURE_HANDLE_CHANGE_ORDINAL = 4;
  private static final int ON_DEVICE_CHANGED_ORDINAL = 1;
  private static final int ON_DEVICE_REQUEST_STATE_CHANGE_ORDINAL = 2;
  private static final int ON_DEVICE_STOPPED_ORDINAL = 0;
  private static final int ON_ZOOM_LEVEL_CHANGE_ORDINAL = 5;

  MediaStreamDeviceObserver_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements MediaStreamDeviceObserver.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onDeviceStopped(String label, MediaStreamDevice device) {
      MediaStreamDeviceObserverOnDeviceStoppedParams _message =
          new MediaStreamDeviceObserverOnDeviceStoppedParams();
      _message.label = label;
      _message.device = device;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void onDeviceChanged(
        String label, MediaStreamDevice oldDevice, MediaStreamDevice newDevice) {
      MediaStreamDeviceObserverOnDeviceChangedParams _message =
          new MediaStreamDeviceObserverOnDeviceChangedParams();
      _message.label = label;
      _message.oldDevice = oldDevice;
      _message.newDevice = newDevice;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void onDeviceRequestStateChange(String label, MediaStreamDevice device, int newState) {
      MediaStreamDeviceObserverOnDeviceRequestStateChangeParams _message =
          new MediaStreamDeviceObserverOnDeviceRequestStateChangeParams();
      _message.label = label;
      _message.device = device;
      _message.newState = newState;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void onDeviceCaptureConfigurationChange(String label, MediaStreamDevice device) {
      MediaStreamDeviceObserverOnDeviceCaptureConfigurationChangeParams _message =
          new MediaStreamDeviceObserverOnDeviceCaptureConfigurationChangeParams();
      _message.label = label;
      _message.device = device;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }

    @Override
    public void onDeviceCaptureHandleChange(String label, MediaStreamDevice device) {
      MediaStreamDeviceObserverOnDeviceCaptureHandleChangeParams _message =
          new MediaStreamDeviceObserverOnDeviceCaptureHandleChangeParams();
      _message.label = label;
      _message.device = device;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
    }

    @Override
    public void onZoomLevelChange(String label, MediaStreamDevice device, int zoomLevel) {
      MediaStreamDeviceObserverOnZoomLevelChangeParams _message =
          new MediaStreamDeviceObserverOnZoomLevelChangeParams();
      _message.label = label;
      _message.device = device;
      _message.zoomLevel = zoomLevel;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5)));
    }
  }

  public static final class Stub extends Interface.Stub<MediaStreamDeviceObserver> {
    Stub(Core core, MediaStreamDeviceObserver impl) {
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
                MediaStreamDeviceObserver_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            MediaStreamDeviceObserverOnDeviceStoppedParams data =
                MediaStreamDeviceObserverOnDeviceStoppedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onDeviceStopped(data.label, data.device);
            return true;
          case 1:
            MediaStreamDeviceObserverOnDeviceChangedParams data2 =
                MediaStreamDeviceObserverOnDeviceChangedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onDeviceChanged(data2.label, data2.oldDevice, data2.newDevice);
            return true;
          case 2:
            MediaStreamDeviceObserverOnDeviceRequestStateChangeParams data3 =
                MediaStreamDeviceObserverOnDeviceRequestStateChangeParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onDeviceRequestStateChange(data3.label, data3.device, data3.newState);
            return true;
          case 3:
            MediaStreamDeviceObserverOnDeviceCaptureConfigurationChangeParams data4 =
                MediaStreamDeviceObserverOnDeviceCaptureConfigurationChangeParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onDeviceCaptureConfigurationChange(data4.label, data4.device);
            return true;
          case 4:
            MediaStreamDeviceObserverOnDeviceCaptureHandleChangeParams data5 =
                MediaStreamDeviceObserverOnDeviceCaptureHandleChangeParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onDeviceCaptureHandleChange(data5.label, data5.device);
            return true;
          case 5:
            MediaStreamDeviceObserverOnZoomLevelChangeParams data6 =
                MediaStreamDeviceObserverOnZoomLevelChangeParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onZoomLevelChange(data6.label, data6.device, data6.zoomLevel);
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
                getCore(), MediaStreamDeviceObserver_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class MediaStreamDeviceObserverOnDeviceStoppedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public MediaStreamDevice device;
    public String label;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private MediaStreamDeviceObserverOnDeviceStoppedParams(int version) {
      super(24, version);
    }

    public MediaStreamDeviceObserverOnDeviceStoppedParams() {
      this(0);
    }

    public static MediaStreamDeviceObserverOnDeviceStoppedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static MediaStreamDeviceObserverOnDeviceStoppedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static MediaStreamDeviceObserverOnDeviceStoppedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        MediaStreamDeviceObserverOnDeviceStoppedParams result =
            new MediaStreamDeviceObserverOnDeviceStoppedParams(elementsOrVersion);
        result.label = decoder0.readString(8, false);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.device = MediaStreamDevice.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.label, 8, false);
      encoder0.encode((Struct) this.device, 16, false);
    }
  }

  static final class MediaStreamDeviceObserverOnDeviceChangedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public String label;
    public MediaStreamDevice newDevice;
    public MediaStreamDevice oldDevice;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private MediaStreamDeviceObserverOnDeviceChangedParams(int version) {
      super(32, version);
    }

    public MediaStreamDeviceObserverOnDeviceChangedParams() {
      this(0);
    }

    public static MediaStreamDeviceObserverOnDeviceChangedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static MediaStreamDeviceObserverOnDeviceChangedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static MediaStreamDeviceObserverOnDeviceChangedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        MediaStreamDeviceObserverOnDeviceChangedParams result =
            new MediaStreamDeviceObserverOnDeviceChangedParams(elementsOrVersion);
        result.label = decoder0.readString(8, false);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.oldDevice = MediaStreamDevice.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(24, false);
        result.newDevice = MediaStreamDevice.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.label, 8, false);
      encoder0.encode((Struct) this.oldDevice, 16, false);
      encoder0.encode((Struct) this.newDevice, 24, false);
    }
  }

  static final class MediaStreamDeviceObserverOnDeviceRequestStateChangeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public MediaStreamDevice device;
    public String label;
    public int newState;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private MediaStreamDeviceObserverOnDeviceRequestStateChangeParams(int version) {
      super(32, version);
    }

    public MediaStreamDeviceObserverOnDeviceRequestStateChangeParams() {
      this(0);
    }

    public static MediaStreamDeviceObserverOnDeviceRequestStateChangeParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static MediaStreamDeviceObserverOnDeviceRequestStateChangeParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static MediaStreamDeviceObserverOnDeviceRequestStateChangeParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        MediaStreamDeviceObserverOnDeviceRequestStateChangeParams result =
            new MediaStreamDeviceObserverOnDeviceRequestStateChangeParams(elementsOrVersion);
        result.label = decoder0.readString(8, false);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.device = MediaStreamDevice.decode(decoder1);
        int readInt = decoder0.readInt(24);
        result.newState = readInt;
        MediaStreamStateChange.validate(readInt);
        result.newState = MediaStreamStateChange.toKnownValue(result.newState);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.label, 8, false);
      encoder0.encode((Struct) this.device, 16, false);
      encoder0.encode(this.newState, 24);
    }
  }

  static final class MediaStreamDeviceObserverOnDeviceCaptureConfigurationChangeParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public MediaStreamDevice device;
    public String label;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private MediaStreamDeviceObserverOnDeviceCaptureConfigurationChangeParams(int version) {
      super(24, version);
    }

    public MediaStreamDeviceObserverOnDeviceCaptureConfigurationChangeParams() {
      this(0);
    }

    public static MediaStreamDeviceObserverOnDeviceCaptureConfigurationChangeParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static MediaStreamDeviceObserverOnDeviceCaptureConfigurationChangeParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static MediaStreamDeviceObserverOnDeviceCaptureConfigurationChangeParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        MediaStreamDeviceObserverOnDeviceCaptureConfigurationChangeParams result =
            new MediaStreamDeviceObserverOnDeviceCaptureConfigurationChangeParams(
                elementsOrVersion);
        result.label = decoder0.readString(8, false);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.device = MediaStreamDevice.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.label, 8, false);
      encoder0.encode((Struct) this.device, 16, false);
    }
  }

  static final class MediaStreamDeviceObserverOnDeviceCaptureHandleChangeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public MediaStreamDevice device;
    public String label;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private MediaStreamDeviceObserverOnDeviceCaptureHandleChangeParams(int version) {
      super(24, version);
    }

    public MediaStreamDeviceObserverOnDeviceCaptureHandleChangeParams() {
      this(0);
    }

    public static MediaStreamDeviceObserverOnDeviceCaptureHandleChangeParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static MediaStreamDeviceObserverOnDeviceCaptureHandleChangeParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static MediaStreamDeviceObserverOnDeviceCaptureHandleChangeParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        MediaStreamDeviceObserverOnDeviceCaptureHandleChangeParams result =
            new MediaStreamDeviceObserverOnDeviceCaptureHandleChangeParams(elementsOrVersion);
        result.label = decoder0.readString(8, false);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.device = MediaStreamDevice.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.label, 8, false);
      encoder0.encode((Struct) this.device, 16, false);
    }
  }

  static final class MediaStreamDeviceObserverOnZoomLevelChangeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public MediaStreamDevice device;
    public String label;
    public int zoomLevel;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private MediaStreamDeviceObserverOnZoomLevelChangeParams(int version) {
      super(32, version);
    }

    public MediaStreamDeviceObserverOnZoomLevelChangeParams() {
      this(0);
    }

    public static MediaStreamDeviceObserverOnZoomLevelChangeParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static MediaStreamDeviceObserverOnZoomLevelChangeParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static MediaStreamDeviceObserverOnZoomLevelChangeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        MediaStreamDeviceObserverOnZoomLevelChangeParams result =
            new MediaStreamDeviceObserverOnZoomLevelChangeParams(elementsOrVersion);
        result.label = decoder0.readString(8, false);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.device = MediaStreamDevice.decode(decoder1);
        result.zoomLevel = decoder0.readInt(24);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.label, 8, false);
      encoder0.encode((Struct) this.device, 16, false);
      encoder0.encode(this.zoomLevel, 24);
    }
  }
}
