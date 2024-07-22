package org.chromium.media.mojom;

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
import org.chromium.mojo_base.mojom.TimeDelta;

class MediaPlayer_Internal {
  public static final Interface.Manager<MediaPlayer, MediaPlayer.Proxy> MANAGER =
      new Interface.Manager<MediaPlayer, MediaPlayer.Proxy>() {
        @Override
        public String getName() {
          return "media.mojom.MediaPlayer";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public MediaPlayer.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, MediaPlayer impl) {
          return new Stub(core, impl);
        }

        @Override
        public MediaPlayer[] buildArray(int size) {
          return new MediaPlayer[size];
        }
      };
  private static final int REQUEST_ENTER_PICTURE_IN_PICTURE_ORDINAL = 5;
  private static final int REQUEST_MEDIA_REMOTING_ORDINAL = 12;
  private static final int REQUEST_MUTE_ORDINAL = 6;
  private static final int REQUEST_PAUSE_ORDINAL = 1;
  private static final int REQUEST_PLAY_ORDINAL = 0;
  private static final int REQUEST_SEEK_BACKWARD_ORDINAL = 3;
  private static final int REQUEST_SEEK_FORWARD_ORDINAL = 2;
  private static final int REQUEST_SEEK_TO_ORDINAL = 4;
  private static final int SET_AUDIO_SINK_ID_ORDINAL = 10;
  private static final int SET_PERSISTENT_STATE_ORDINAL = 8;
  private static final int SET_POWER_EXPERIMENT_STATE_ORDINAL = 9;
  private static final int SET_VOLUME_MULTIPLIER_ORDINAL = 7;
  private static final int SUSPEND_FOR_FRAME_CLOSED_ORDINAL = 11;

  MediaPlayer_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements MediaPlayer.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void requestPlay() {
      MediaPlayerRequestPlayParams _message = new MediaPlayerRequestPlayParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void requestPause(boolean triggeredByUser) {
      MediaPlayerRequestPauseParams _message = new MediaPlayerRequestPauseParams();
      _message.triggeredByUser = triggeredByUser;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void requestSeekForward(TimeDelta seekTime) {
      MediaPlayerRequestSeekForwardParams _message = new MediaPlayerRequestSeekForwardParams();
      _message.seekTime = seekTime;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void requestSeekBackward(TimeDelta seekTime) {
      MediaPlayerRequestSeekBackwardParams _message = new MediaPlayerRequestSeekBackwardParams();
      _message.seekTime = seekTime;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }

    @Override
    public void requestSeekTo(TimeDelta seekTime) {
      MediaPlayerRequestSeekToParams _message = new MediaPlayerRequestSeekToParams();
      _message.seekTime = seekTime;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
    }

    @Override
    public void requestEnterPictureInPicture() {
      MediaPlayerRequestEnterPictureInPictureParams _message =
          new MediaPlayerRequestEnterPictureInPictureParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5)));
    }

    @Override
    public void requestMute(boolean mute) {
      MediaPlayerRequestMuteParams _message = new MediaPlayerRequestMuteParams();
      _message.mute = mute;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(6)));
    }

    @Override
    public void setVolumeMultiplier(double multiplier) {
      MediaPlayerSetVolumeMultiplierParams _message = new MediaPlayerSetVolumeMultiplierParams();
      _message.multiplier = multiplier;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(7)));
    }

    @Override
    public void setPersistentState(boolean persistent) {
      MediaPlayerSetPersistentStateParams _message = new MediaPlayerSetPersistentStateParams();
      _message.persistent = persistent;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(8)));
    }

    @Override
    public void setPowerExperimentState(boolean enabled) {
      MediaPlayerSetPowerExperimentStateParams _message =
          new MediaPlayerSetPowerExperimentStateParams();
      _message.enabled = enabled;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(9)));
    }

    @Override
    public void setAudioSinkId(String sinkId) {
      MediaPlayerSetAudioSinkIdParams _message = new MediaPlayerSetAudioSinkIdParams();
      _message.sinkId = sinkId;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(10)));
    }

    @Override
    public void suspendForFrameClosed() {
      MediaPlayerSuspendForFrameClosedParams _message =
          new MediaPlayerSuspendForFrameClosedParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(11)));
    }

    @Override
    public void requestMediaRemoting() {
      MediaPlayerRequestMediaRemotingParams _message = new MediaPlayerRequestMediaRemotingParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(12)));
    }
  }

  public static final class Stub extends Interface.Stub<MediaPlayer> {
    Stub(Core core, MediaPlayer impl) {
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
                MediaPlayer_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            MediaPlayerRequestPlayParams.deserialize(messageWithHeader.getPayload());
            getImpl().requestPlay();
            return true;
          case 1:
            MediaPlayerRequestPauseParams data =
                MediaPlayerRequestPauseParams.deserialize(messageWithHeader.getPayload());
            getImpl().requestPause(data.triggeredByUser);
            return true;
          case 2:
            MediaPlayerRequestSeekForwardParams data2 =
                MediaPlayerRequestSeekForwardParams.deserialize(messageWithHeader.getPayload());
            getImpl().requestSeekForward(data2.seekTime);
            return true;
          case 3:
            MediaPlayerRequestSeekBackwardParams data3 =
                MediaPlayerRequestSeekBackwardParams.deserialize(messageWithHeader.getPayload());
            getImpl().requestSeekBackward(data3.seekTime);
            return true;
          case 4:
            MediaPlayerRequestSeekToParams data4 =
                MediaPlayerRequestSeekToParams.deserialize(messageWithHeader.getPayload());
            getImpl().requestSeekTo(data4.seekTime);
            return true;
          case 5:
            MediaPlayerRequestEnterPictureInPictureParams.deserialize(
                messageWithHeader.getPayload());
            getImpl().requestEnterPictureInPicture();
            return true;
          case 6:
            MediaPlayerRequestMuteParams data5 =
                MediaPlayerRequestMuteParams.deserialize(messageWithHeader.getPayload());
            getImpl().requestMute(data5.mute);
            return true;
          case 7:
            MediaPlayerSetVolumeMultiplierParams data6 =
                MediaPlayerSetVolumeMultiplierParams.deserialize(messageWithHeader.getPayload());
            getImpl().setVolumeMultiplier(data6.multiplier);
            return true;
          case 8:
            MediaPlayerSetPersistentStateParams data7 =
                MediaPlayerSetPersistentStateParams.deserialize(messageWithHeader.getPayload());
            getImpl().setPersistentState(data7.persistent);
            return true;
          case 9:
            MediaPlayerSetPowerExperimentStateParams data8 =
                MediaPlayerSetPowerExperimentStateParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().setPowerExperimentState(data8.enabled);
            return true;
          case 10:
            MediaPlayerSetAudioSinkIdParams data9 =
                MediaPlayerSetAudioSinkIdParams.deserialize(messageWithHeader.getPayload());
            getImpl().setAudioSinkId(data9.sinkId);
            return true;
          case 11:
            MediaPlayerSuspendForFrameClosedParams.deserialize(messageWithHeader.getPayload());
            getImpl().suspendForFrameClosed();
            return true;
          case 12:
            MediaPlayerRequestMediaRemotingParams.deserialize(messageWithHeader.getPayload());
            getImpl().requestMediaRemoting();
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
                getCore(), MediaPlayer_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class MediaPlayerRequestPlayParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private MediaPlayerRequestPlayParams(int version) {
      super(8, version);
    }

    public MediaPlayerRequestPlayParams() {
      this(0);
    }

    public static MediaPlayerRequestPlayParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static MediaPlayerRequestPlayParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static MediaPlayerRequestPlayParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        MediaPlayerRequestPlayParams result = new MediaPlayerRequestPlayParams(elementsOrVersion);
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

  static final class MediaPlayerRequestPauseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean triggeredByUser;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private MediaPlayerRequestPauseParams(int version) {
      super(16, version);
    }

    public MediaPlayerRequestPauseParams() {
      this(0);
    }

    public static MediaPlayerRequestPauseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static MediaPlayerRequestPauseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static MediaPlayerRequestPauseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        MediaPlayerRequestPauseParams result = new MediaPlayerRequestPauseParams(elementsOrVersion);
        result.triggeredByUser = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.triggeredByUser, 8, 0);
    }
  }

  static final class MediaPlayerRequestSeekForwardParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public TimeDelta seekTime;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private MediaPlayerRequestSeekForwardParams(int version) {
      super(16, version);
    }

    public MediaPlayerRequestSeekForwardParams() {
      this(0);
    }

    public static MediaPlayerRequestSeekForwardParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static MediaPlayerRequestSeekForwardParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static MediaPlayerRequestSeekForwardParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        MediaPlayerRequestSeekForwardParams result =
            new MediaPlayerRequestSeekForwardParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.seekTime = TimeDelta.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.seekTime, 8, false);
    }
  }

  static final class MediaPlayerRequestSeekBackwardParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public TimeDelta seekTime;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private MediaPlayerRequestSeekBackwardParams(int version) {
      super(16, version);
    }

    public MediaPlayerRequestSeekBackwardParams() {
      this(0);
    }

    public static MediaPlayerRequestSeekBackwardParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static MediaPlayerRequestSeekBackwardParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static MediaPlayerRequestSeekBackwardParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        MediaPlayerRequestSeekBackwardParams result =
            new MediaPlayerRequestSeekBackwardParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.seekTime = TimeDelta.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.seekTime, 8, false);
    }
  }

  static final class MediaPlayerRequestSeekToParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public TimeDelta seekTime;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private MediaPlayerRequestSeekToParams(int version) {
      super(16, version);
    }

    public MediaPlayerRequestSeekToParams() {
      this(0);
    }

    public static MediaPlayerRequestSeekToParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static MediaPlayerRequestSeekToParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static MediaPlayerRequestSeekToParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        MediaPlayerRequestSeekToParams result =
            new MediaPlayerRequestSeekToParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.seekTime = TimeDelta.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.seekTime, 8, false);
    }
  }

  static final class MediaPlayerRequestEnterPictureInPictureParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private MediaPlayerRequestEnterPictureInPictureParams(int version) {
      super(8, version);
    }

    public MediaPlayerRequestEnterPictureInPictureParams() {
      this(0);
    }

    public static MediaPlayerRequestEnterPictureInPictureParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static MediaPlayerRequestEnterPictureInPictureParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static MediaPlayerRequestEnterPictureInPictureParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        MediaPlayerRequestEnterPictureInPictureParams result =
            new MediaPlayerRequestEnterPictureInPictureParams(elementsOrVersion);
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

  static final class MediaPlayerRequestMuteParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean mute;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private MediaPlayerRequestMuteParams(int version) {
      super(16, version);
    }

    public MediaPlayerRequestMuteParams() {
      this(0);
    }

    public static MediaPlayerRequestMuteParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static MediaPlayerRequestMuteParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static MediaPlayerRequestMuteParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        MediaPlayerRequestMuteParams result = new MediaPlayerRequestMuteParams(elementsOrVersion);
        result.mute = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.mute, 8, 0);
    }
  }

  static final class MediaPlayerSetVolumeMultiplierParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public double multiplier;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private MediaPlayerSetVolumeMultiplierParams(int version) {
      super(16, version);
    }

    public MediaPlayerSetVolumeMultiplierParams() {
      this(0);
    }

    public static MediaPlayerSetVolumeMultiplierParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static MediaPlayerSetVolumeMultiplierParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static MediaPlayerSetVolumeMultiplierParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        MediaPlayerSetVolumeMultiplierParams result =
            new MediaPlayerSetVolumeMultiplierParams(elementsOrVersion);
        result.multiplier = decoder0.readDouble(8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.multiplier, 8);
    }
  }

  static final class MediaPlayerSetPersistentStateParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean persistent;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private MediaPlayerSetPersistentStateParams(int version) {
      super(16, version);
    }

    public MediaPlayerSetPersistentStateParams() {
      this(0);
    }

    public static MediaPlayerSetPersistentStateParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static MediaPlayerSetPersistentStateParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static MediaPlayerSetPersistentStateParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        MediaPlayerSetPersistentStateParams result =
            new MediaPlayerSetPersistentStateParams(elementsOrVersion);
        result.persistent = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.persistent, 8, 0);
    }
  }

  static final class MediaPlayerSetPowerExperimentStateParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean enabled;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private MediaPlayerSetPowerExperimentStateParams(int version) {
      super(16, version);
    }

    public MediaPlayerSetPowerExperimentStateParams() {
      this(0);
    }

    public static MediaPlayerSetPowerExperimentStateParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static MediaPlayerSetPowerExperimentStateParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static MediaPlayerSetPowerExperimentStateParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        MediaPlayerSetPowerExperimentStateParams result =
            new MediaPlayerSetPowerExperimentStateParams(elementsOrVersion);
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

  static final class MediaPlayerSetAudioSinkIdParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String sinkId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private MediaPlayerSetAudioSinkIdParams(int version) {
      super(16, version);
    }

    public MediaPlayerSetAudioSinkIdParams() {
      this(0);
    }

    public static MediaPlayerSetAudioSinkIdParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static MediaPlayerSetAudioSinkIdParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static MediaPlayerSetAudioSinkIdParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        MediaPlayerSetAudioSinkIdParams result =
            new MediaPlayerSetAudioSinkIdParams(elementsOrVersion);
        result.sinkId = decoder0.readString(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.sinkId, 8, false);
    }
  }

  static final class MediaPlayerSuspendForFrameClosedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private MediaPlayerSuspendForFrameClosedParams(int version) {
      super(8, version);
    }

    public MediaPlayerSuspendForFrameClosedParams() {
      this(0);
    }

    public static MediaPlayerSuspendForFrameClosedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static MediaPlayerSuspendForFrameClosedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static MediaPlayerSuspendForFrameClosedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        MediaPlayerSuspendForFrameClosedParams result =
            new MediaPlayerSuspendForFrameClosedParams(elementsOrVersion);
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

  static final class MediaPlayerRequestMediaRemotingParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private MediaPlayerRequestMediaRemotingParams(int version) {
      super(8, version);
    }

    public MediaPlayerRequestMediaRemotingParams() {
      this(0);
    }

    public static MediaPlayerRequestMediaRemotingParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static MediaPlayerRequestMediaRemotingParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static MediaPlayerRequestMediaRemotingParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        MediaPlayerRequestMediaRemotingParams result =
            new MediaPlayerRequestMediaRemotingParams(elementsOrVersion);
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
