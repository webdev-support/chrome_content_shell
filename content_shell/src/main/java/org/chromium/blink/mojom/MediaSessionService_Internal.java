package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.media_session.mojom.CameraState;
import org.chromium.media_session.mojom.MediaPosition;
import org.chromium.media_session.mojom.MediaSessionAction;
import org.chromium.media_session.mojom.MicrophoneState;
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

class MediaSessionService_Internal {
  private static final int DISABLE_ACTION_ORDINAL = 7;
  private static final int ENABLE_ACTION_ORDINAL = 6;
  public static final Interface.Manager<MediaSessionService, MediaSessionService.Proxy> MANAGER =
      new Interface.Manager<MediaSessionService, MediaSessionService.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.MediaSessionService";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public MediaSessionService.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, MediaSessionService impl) {
          return new Stub(core, impl);
        }

        @Override
        public MediaSessionService[] buildArray(int size) {
          return new MediaSessionService[size];
        }
      };
  private static final int SET_CAMERA_STATE_ORDINAL = 5;
  private static final int SET_CLIENT_ORDINAL = 0;
  private static final int SET_METADATA_ORDINAL = 3;
  private static final int SET_MICROPHONE_STATE_ORDINAL = 4;
  private static final int SET_PLAYBACK_STATE_ORDINAL = 1;
  private static final int SET_POSITION_STATE_ORDINAL = 2;

  MediaSessionService_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements MediaSessionService.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void setClient(MediaSessionClient client) {
      MediaSessionServiceSetClientParams _message = new MediaSessionServiceSetClientParams();
      _message.client = client;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void setPlaybackState(int state) {
      MediaSessionServiceSetPlaybackStateParams _message =
          new MediaSessionServiceSetPlaybackStateParams();
      _message.state = state;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void setPositionState(MediaPosition position) {
      MediaSessionServiceSetPositionStateParams _message =
          new MediaSessionServiceSetPositionStateParams();
      _message.position = position;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void setMetadata(SpecMediaMetadata metadata) {
      MediaSessionServiceSetMetadataParams _message = new MediaSessionServiceSetMetadataParams();
      _message.metadata = metadata;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }

    @Override
    public void setMicrophoneState(int microphoneState) {
      MediaSessionServiceSetMicrophoneStateParams _message =
          new MediaSessionServiceSetMicrophoneStateParams();
      _message.microphoneState = microphoneState;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
    }

    @Override
    public void setCameraState(int cameraState) {
      MediaSessionServiceSetCameraStateParams _message =
          new MediaSessionServiceSetCameraStateParams();
      _message.cameraState = cameraState;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5)));
    }

    @Override
    public void enableAction(int action) {
      MediaSessionServiceEnableActionParams _message = new MediaSessionServiceEnableActionParams();
      _message.action = action;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(6)));
    }

    @Override
    public void disableAction(int action) {
      MediaSessionServiceDisableActionParams _message =
          new MediaSessionServiceDisableActionParams();
      _message.action = action;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(7)));
    }
  }

  public static final class Stub extends Interface.Stub<MediaSessionService> {
    Stub(Core core, MediaSessionService impl) {
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
                MediaSessionService_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            MediaSessionServiceSetClientParams data =
                MediaSessionServiceSetClientParams.deserialize(messageWithHeader.getPayload());
            getImpl().setClient(data.client);
            return true;
          case 1:
            MediaSessionServiceSetPlaybackStateParams data2 =
                MediaSessionServiceSetPlaybackStateParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().setPlaybackState(data2.state);
            return true;
          case 2:
            MediaSessionServiceSetPositionStateParams data3 =
                MediaSessionServiceSetPositionStateParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().setPositionState(data3.position);
            return true;
          case 3:
            MediaSessionServiceSetMetadataParams data4 =
                MediaSessionServiceSetMetadataParams.deserialize(messageWithHeader.getPayload());
            getImpl().setMetadata(data4.metadata);
            return true;
          case 4:
            MediaSessionServiceSetMicrophoneStateParams data5 =
                MediaSessionServiceSetMicrophoneStateParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().setMicrophoneState(data5.microphoneState);
            return true;
          case 5:
            MediaSessionServiceSetCameraStateParams data6 =
                MediaSessionServiceSetCameraStateParams.deserialize(messageWithHeader.getPayload());
            getImpl().setCameraState(data6.cameraState);
            return true;
          case 6:
            MediaSessionServiceEnableActionParams data7 =
                MediaSessionServiceEnableActionParams.deserialize(messageWithHeader.getPayload());
            getImpl().enableAction(data7.action);
            return true;
          case 7:
            MediaSessionServiceDisableActionParams data8 =
                MediaSessionServiceDisableActionParams.deserialize(messageWithHeader.getPayload());
            getImpl().disableAction(data8.action);
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
                getCore(), MediaSessionService_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class MediaSessionServiceSetClientParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public MediaSessionClient client;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private MediaSessionServiceSetClientParams(int version) {
      super(16, version);
    }

    public MediaSessionServiceSetClientParams() {
      this(0);
    }

    public static MediaSessionServiceSetClientParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static MediaSessionServiceSetClientParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static MediaSessionServiceSetClientParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        MediaSessionServiceSetClientParams result =
            new MediaSessionServiceSetClientParams(elementsOrVersion);
        result.client =
            (MediaSessionClient)
                decoder0.readServiceInterface(8, false, MediaSessionClient.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.client, 8, false, MediaSessionClient.MANAGER);
    }
  }

  static final class MediaSessionServiceSetPlaybackStateParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int state;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private MediaSessionServiceSetPlaybackStateParams(int version) {
      super(16, version);
    }

    public MediaSessionServiceSetPlaybackStateParams() {
      this(0);
    }

    public static MediaSessionServiceSetPlaybackStateParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static MediaSessionServiceSetPlaybackStateParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static MediaSessionServiceSetPlaybackStateParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        MediaSessionServiceSetPlaybackStateParams result =
            new MediaSessionServiceSetPlaybackStateParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.state = readInt;
        MediaSessionPlaybackState.validate(readInt);
        result.state = MediaSessionPlaybackState.toKnownValue(result.state);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.state, 8);
    }
  }

  static final class MediaSessionServiceSetPositionStateParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public MediaPosition position;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private MediaSessionServiceSetPositionStateParams(int version) {
      super(16, version);
    }

    public MediaSessionServiceSetPositionStateParams() {
      this(0);
    }

    public static MediaSessionServiceSetPositionStateParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static MediaSessionServiceSetPositionStateParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static MediaSessionServiceSetPositionStateParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        MediaSessionServiceSetPositionStateParams result =
            new MediaSessionServiceSetPositionStateParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.position = MediaPosition.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.position, 8, true);
    }
  }

  static final class MediaSessionServiceSetMetadataParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public SpecMediaMetadata metadata;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private MediaSessionServiceSetMetadataParams(int version) {
      super(16, version);
    }

    public MediaSessionServiceSetMetadataParams() {
      this(0);
    }

    public static MediaSessionServiceSetMetadataParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static MediaSessionServiceSetMetadataParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static MediaSessionServiceSetMetadataParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        MediaSessionServiceSetMetadataParams result =
            new MediaSessionServiceSetMetadataParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.metadata = SpecMediaMetadata.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.metadata, 8, true);
    }
  }

  static final class MediaSessionServiceSetMicrophoneStateParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int microphoneState;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private MediaSessionServiceSetMicrophoneStateParams(int version) {
      super(16, version);
    }

    public MediaSessionServiceSetMicrophoneStateParams() {
      this(0);
    }

    public static MediaSessionServiceSetMicrophoneStateParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static MediaSessionServiceSetMicrophoneStateParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static MediaSessionServiceSetMicrophoneStateParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        MediaSessionServiceSetMicrophoneStateParams result =
            new MediaSessionServiceSetMicrophoneStateParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.microphoneState = readInt;
        MicrophoneState.validate(readInt);
        result.microphoneState = MicrophoneState.toKnownValue(result.microphoneState);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.microphoneState, 8);
    }
  }

  static final class MediaSessionServiceSetCameraStateParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int cameraState;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private MediaSessionServiceSetCameraStateParams(int version) {
      super(16, version);
    }

    public MediaSessionServiceSetCameraStateParams() {
      this(0);
    }

    public static MediaSessionServiceSetCameraStateParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static MediaSessionServiceSetCameraStateParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static MediaSessionServiceSetCameraStateParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        MediaSessionServiceSetCameraStateParams result =
            new MediaSessionServiceSetCameraStateParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.cameraState = readInt;
        CameraState.validate(readInt);
        result.cameraState = CameraState.toKnownValue(result.cameraState);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.cameraState, 8);
    }
  }

  static final class MediaSessionServiceEnableActionParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int action;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private MediaSessionServiceEnableActionParams(int version) {
      super(16, version);
    }

    public MediaSessionServiceEnableActionParams() {
      this(0);
    }

    public static MediaSessionServiceEnableActionParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static MediaSessionServiceEnableActionParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static MediaSessionServiceEnableActionParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        MediaSessionServiceEnableActionParams result =
            new MediaSessionServiceEnableActionParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.action = readInt;
        MediaSessionAction.validate(readInt);
        result.action = MediaSessionAction.toKnownValue(result.action);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.action, 8);
    }
  }

  static final class MediaSessionServiceDisableActionParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int action;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private MediaSessionServiceDisableActionParams(int version) {
      super(16, version);
    }

    public MediaSessionServiceDisableActionParams() {
      this(0);
    }

    public static MediaSessionServiceDisableActionParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static MediaSessionServiceDisableActionParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static MediaSessionServiceDisableActionParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        MediaSessionServiceDisableActionParams result =
            new MediaSessionServiceDisableActionParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.action = readInt;
        MediaSessionAction.validate(readInt);
        result.action = MediaSessionAction.toKnownValue(result.action);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.action, 8);
    }
  }
}
