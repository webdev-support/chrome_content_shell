package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Size;
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

class PlaybackEventsRecorder_Internal {
  public static final Interface.Manager<PlaybackEventsRecorder, PlaybackEventsRecorder.Proxy>
      MANAGER =
          new Interface.Manager<PlaybackEventsRecorder, PlaybackEventsRecorder.Proxy>() {
            @Override
            public String getName() {
              return "media.mojom.PlaybackEventsRecorder";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public PlaybackEventsRecorder.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, PlaybackEventsRecorder impl) {
              return new Stub(core, impl);
            }

            @Override
            public PlaybackEventsRecorder[] buildArray(int size) {
              return new PlaybackEventsRecorder[size];
            }
          };
  private static final int ON_BUFFERING_COMPLETE_ORDINAL = 6;
  private static final int ON_BUFFERING_ORDINAL = 5;
  private static final int ON_ENDED_ORDINAL = 3;
  private static final int ON_ERROR_ORDINAL = 4;
  private static final int ON_NATURAL_SIZE_CHANGED_ORDINAL = 7;
  private static final int ON_PAUSED_ORDINAL = 1;
  private static final int ON_PIPELINE_STATISTICS_ORDINAL = 8;
  private static final int ON_PLAYING_ORDINAL = 0;
  private static final int ON_SEEKING_ORDINAL = 2;

  PlaybackEventsRecorder_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements PlaybackEventsRecorder.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onPlaying() {
      PlaybackEventsRecorderOnPlayingParams _message = new PlaybackEventsRecorderOnPlayingParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void onPaused() {
      PlaybackEventsRecorderOnPausedParams _message = new PlaybackEventsRecorderOnPausedParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void onSeeking() {
      PlaybackEventsRecorderOnSeekingParams _message = new PlaybackEventsRecorderOnSeekingParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void onEnded() {
      PlaybackEventsRecorderOnEndedParams _message = new PlaybackEventsRecorderOnEndedParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }

    @Override
    public void onError(PipelineStatus status) {
      PlaybackEventsRecorderOnErrorParams _message = new PlaybackEventsRecorderOnErrorParams();
      _message.status = status;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
    }

    @Override
    public void onBuffering() {
      PlaybackEventsRecorderOnBufferingParams _message =
          new PlaybackEventsRecorderOnBufferingParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5)));
    }

    @Override
    public void onBufferingComplete() {
      PlaybackEventsRecorderOnBufferingCompleteParams _message =
          new PlaybackEventsRecorderOnBufferingCompleteParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(6)));
    }

    @Override
    public void onNaturalSizeChanged(Size size) {
      PlaybackEventsRecorderOnNaturalSizeChangedParams _message =
          new PlaybackEventsRecorderOnNaturalSizeChangedParams();
      _message.size = size;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(7)));
    }

    @Override
    public void onPipelineStatistics(PipelineStatistics stats) {
      PlaybackEventsRecorderOnPipelineStatisticsParams _message =
          new PlaybackEventsRecorderOnPipelineStatisticsParams();
      _message.stats = stats;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(8)));
    }
  }

  public static final class Stub extends Interface.Stub<PlaybackEventsRecorder> {
    Stub(Core core, PlaybackEventsRecorder impl) {
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
                PlaybackEventsRecorder_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            PlaybackEventsRecorderOnPlayingParams.deserialize(messageWithHeader.getPayload());
            getImpl().onPlaying();
            return true;
          case 1:
            PlaybackEventsRecorderOnPausedParams.deserialize(messageWithHeader.getPayload());
            getImpl().onPaused();
            return true;
          case 2:
            PlaybackEventsRecorderOnSeekingParams.deserialize(messageWithHeader.getPayload());
            getImpl().onSeeking();
            return true;
          case 3:
            PlaybackEventsRecorderOnEndedParams.deserialize(messageWithHeader.getPayload());
            getImpl().onEnded();
            return true;
          case 4:
            PlaybackEventsRecorderOnErrorParams data =
                PlaybackEventsRecorderOnErrorParams.deserialize(messageWithHeader.getPayload());
            getImpl().onError(data.status);
            return true;
          case 5:
            PlaybackEventsRecorderOnBufferingParams.deserialize(messageWithHeader.getPayload());
            getImpl().onBuffering();
            return true;
          case 6:
            PlaybackEventsRecorderOnBufferingCompleteParams.deserialize(
                messageWithHeader.getPayload());
            getImpl().onBufferingComplete();
            return true;
          case 7:
            PlaybackEventsRecorderOnNaturalSizeChangedParams data2 =
                PlaybackEventsRecorderOnNaturalSizeChangedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onNaturalSizeChanged(data2.size);
            return true;
          case 8:
            PlaybackEventsRecorderOnPipelineStatisticsParams data3 =
                PlaybackEventsRecorderOnPipelineStatisticsParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onPipelineStatistics(data3.stats);
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
                getCore(), PlaybackEventsRecorder_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class PlaybackEventsRecorderOnPlayingParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PlaybackEventsRecorderOnPlayingParams(int version) {
      super(8, version);
    }

    public PlaybackEventsRecorderOnPlayingParams() {
      this(0);
    }

    public static PlaybackEventsRecorderOnPlayingParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PlaybackEventsRecorderOnPlayingParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PlaybackEventsRecorderOnPlayingParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PlaybackEventsRecorderOnPlayingParams result =
            new PlaybackEventsRecorderOnPlayingParams(elementsOrVersion);
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

  static final class PlaybackEventsRecorderOnPausedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PlaybackEventsRecorderOnPausedParams(int version) {
      super(8, version);
    }

    public PlaybackEventsRecorderOnPausedParams() {
      this(0);
    }

    public static PlaybackEventsRecorderOnPausedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PlaybackEventsRecorderOnPausedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PlaybackEventsRecorderOnPausedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PlaybackEventsRecorderOnPausedParams result =
            new PlaybackEventsRecorderOnPausedParams(elementsOrVersion);
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

  static final class PlaybackEventsRecorderOnSeekingParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PlaybackEventsRecorderOnSeekingParams(int version) {
      super(8, version);
    }

    public PlaybackEventsRecorderOnSeekingParams() {
      this(0);
    }

    public static PlaybackEventsRecorderOnSeekingParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PlaybackEventsRecorderOnSeekingParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PlaybackEventsRecorderOnSeekingParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PlaybackEventsRecorderOnSeekingParams result =
            new PlaybackEventsRecorderOnSeekingParams(elementsOrVersion);
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

  static final class PlaybackEventsRecorderOnEndedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PlaybackEventsRecorderOnEndedParams(int version) {
      super(8, version);
    }

    public PlaybackEventsRecorderOnEndedParams() {
      this(0);
    }

    public static PlaybackEventsRecorderOnEndedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PlaybackEventsRecorderOnEndedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PlaybackEventsRecorderOnEndedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PlaybackEventsRecorderOnEndedParams result =
            new PlaybackEventsRecorderOnEndedParams(elementsOrVersion);
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

  static final class PlaybackEventsRecorderOnErrorParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public PipelineStatus status;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PlaybackEventsRecorderOnErrorParams(int version) {
      super(16, version);
    }

    public PlaybackEventsRecorderOnErrorParams() {
      this(0);
    }

    public static PlaybackEventsRecorderOnErrorParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PlaybackEventsRecorderOnErrorParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PlaybackEventsRecorderOnErrorParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PlaybackEventsRecorderOnErrorParams result =
            new PlaybackEventsRecorderOnErrorParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.status = PipelineStatus.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.status, 8, false);
    }
  }

  static final class PlaybackEventsRecorderOnBufferingParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PlaybackEventsRecorderOnBufferingParams(int version) {
      super(8, version);
    }

    public PlaybackEventsRecorderOnBufferingParams() {
      this(0);
    }

    public static PlaybackEventsRecorderOnBufferingParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PlaybackEventsRecorderOnBufferingParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PlaybackEventsRecorderOnBufferingParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PlaybackEventsRecorderOnBufferingParams result =
            new PlaybackEventsRecorderOnBufferingParams(elementsOrVersion);
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

  static final class PlaybackEventsRecorderOnBufferingCompleteParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PlaybackEventsRecorderOnBufferingCompleteParams(int version) {
      super(8, version);
    }

    public PlaybackEventsRecorderOnBufferingCompleteParams() {
      this(0);
    }

    public static PlaybackEventsRecorderOnBufferingCompleteParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PlaybackEventsRecorderOnBufferingCompleteParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PlaybackEventsRecorderOnBufferingCompleteParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PlaybackEventsRecorderOnBufferingCompleteParams result =
            new PlaybackEventsRecorderOnBufferingCompleteParams(elementsOrVersion);
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

  static final class PlaybackEventsRecorderOnNaturalSizeChangedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Size size;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PlaybackEventsRecorderOnNaturalSizeChangedParams(int version) {
      super(16, version);
    }

    public PlaybackEventsRecorderOnNaturalSizeChangedParams() {
      this(0);
    }

    public static PlaybackEventsRecorderOnNaturalSizeChangedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PlaybackEventsRecorderOnNaturalSizeChangedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PlaybackEventsRecorderOnNaturalSizeChangedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PlaybackEventsRecorderOnNaturalSizeChangedParams result =
            new PlaybackEventsRecorderOnNaturalSizeChangedParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.size = Size.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.size, 8, false);
    }
  }

  static final class PlaybackEventsRecorderOnPipelineStatisticsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public PipelineStatistics stats;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PlaybackEventsRecorderOnPipelineStatisticsParams(int version) {
      super(16, version);
    }

    public PlaybackEventsRecorderOnPipelineStatisticsParams() {
      this(0);
    }

    public static PlaybackEventsRecorderOnPipelineStatisticsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PlaybackEventsRecorderOnPipelineStatisticsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PlaybackEventsRecorderOnPipelineStatisticsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PlaybackEventsRecorderOnPipelineStatisticsParams result =
            new PlaybackEventsRecorderOnPipelineStatisticsParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.stats = PipelineStatistics.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.stats, 8, false);
    }
  }
}
