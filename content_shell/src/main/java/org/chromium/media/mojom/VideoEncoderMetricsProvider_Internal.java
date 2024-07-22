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

class VideoEncoderMetricsProvider_Internal {
  private static final int COMPLETE_ORDINAL = 3;
  private static final int INITIALIZE_ORDINAL = 0;
  public static final Interface.Manager<
          VideoEncoderMetricsProvider, VideoEncoderMetricsProvider.Proxy>
      MANAGER =
          new Interface.Manager<VideoEncoderMetricsProvider, VideoEncoderMetricsProvider.Proxy>() {
            @Override
            public String getName() {
              return "media.mojom.VideoEncoderMetricsProvider";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public VideoEncoderMetricsProvider.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, VideoEncoderMetricsProvider impl) {
              return new Stub(core, impl);
            }

            @Override
            public VideoEncoderMetricsProvider[] buildArray(int size) {
              return new VideoEncoderMetricsProvider[size];
            }
          };
  private static final int SET_ENCODED_FRAME_COUNT_ORDINAL = 1;
  private static final int SET_ERROR_ORDINAL = 2;

  VideoEncoderMetricsProvider_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements VideoEncoderMetricsProvider.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void initialize(
        long encoderId,
        int encoderUseCase,
        int profile,
        Size encodeSize,
        boolean isHardwareEncoder,
        int svcMode) {
      VideoEncoderMetricsProviderInitializeParams _message =
          new VideoEncoderMetricsProviderInitializeParams();
      _message.encoderId = encoderId;
      _message.encoderUseCase = encoderUseCase;
      _message.profile = profile;
      _message.encodeSize = encodeSize;
      _message.isHardwareEncoder = isHardwareEncoder;
      _message.svcMode = svcMode;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void setEncodedFrameCount(long encoderId, long numEncodedFrames) {
      VideoEncoderMetricsProviderSetEncodedFrameCountParams _message =
          new VideoEncoderMetricsProviderSetEncodedFrameCountParams();
      _message.encoderId = encoderId;
      _message.numEncodedFrames = numEncodedFrames;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void setError(long encoderId, EncoderStatus status) {
      VideoEncoderMetricsProviderSetErrorParams _message =
          new VideoEncoderMetricsProviderSetErrorParams();
      _message.encoderId = encoderId;
      _message.status = status;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void complete(long encoderId) {
      VideoEncoderMetricsProviderCompleteParams _message =
          new VideoEncoderMetricsProviderCompleteParams();
      _message.encoderId = encoderId;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }
  }

  public static final class Stub extends Interface.Stub<VideoEncoderMetricsProvider> {
    Stub(Core core, VideoEncoderMetricsProvider impl) {
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
                VideoEncoderMetricsProvider_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            VideoEncoderMetricsProviderInitializeParams data =
                VideoEncoderMetricsProviderInitializeParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .initialize(
                    data.encoderId,
                    data.encoderUseCase,
                    data.profile,
                    data.encodeSize,
                    data.isHardwareEncoder,
                    data.svcMode);
            return true;
          case 1:
            VideoEncoderMetricsProviderSetEncodedFrameCountParams data2 =
                VideoEncoderMetricsProviderSetEncodedFrameCountParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().setEncodedFrameCount(data2.encoderId, data2.numEncodedFrames);
            return true;
          case 2:
            VideoEncoderMetricsProviderSetErrorParams data3 =
                VideoEncoderMetricsProviderSetErrorParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().setError(data3.encoderId, data3.status);
            return true;
          case 3:
            getImpl()
                .complete(
                    VideoEncoderMetricsProviderCompleteParams.deserialize(
                            messageWithHeader.getPayload())
                        .encoderId);
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
                getCore(),
                VideoEncoderMetricsProvider_Internal.MANAGER,
                messageWithHeader,
                receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class VideoEncoderMetricsProviderInitializeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public Size encodeSize;
    public long encoderId;
    public int encoderUseCase;
    public boolean isHardwareEncoder;
    public int profile;
    public int svcMode;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VideoEncoderMetricsProviderInitializeParams(int version) {
      super(40, version);
    }

    public VideoEncoderMetricsProviderInitializeParams() {
      this(0);
    }

    public static VideoEncoderMetricsProviderInitializeParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static VideoEncoderMetricsProviderInitializeParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VideoEncoderMetricsProviderInitializeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VideoEncoderMetricsProviderInitializeParams result =
            new VideoEncoderMetricsProviderInitializeParams(elementsOrVersion);
        result.encoderId = decoder0.readLong(8);
        int readInt = decoder0.readInt(16);
        result.encoderUseCase = readInt;
        VideoEncoderUseCase.validate(readInt);
        result.encoderUseCase = VideoEncoderUseCase.toKnownValue(result.encoderUseCase);
        int readInt2 = decoder0.readInt(20);
        result.profile = readInt2;
        VideoCodecProfile.validate(readInt2);
        result.profile = VideoCodecProfile.toKnownValue(result.profile);
        Decoder decoder1 = decoder0.readPointer(24, false);
        result.encodeSize = Size.decode(decoder1);
        result.isHardwareEncoder = decoder0.readBoolean(32, 0);
        int readInt3 = decoder0.readInt(36);
        result.svcMode = readInt3;
        SvcScalabilityMode.validate(readInt3);
        result.svcMode = SvcScalabilityMode.toKnownValue(result.svcMode);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.encoderId, 8);
      encoder0.encode(this.encoderUseCase, 16);
      encoder0.encode(this.profile, 20);
      encoder0.encode((Struct) this.encodeSize, 24, false);
      encoder0.encode(this.isHardwareEncoder, 32, 0);
      encoder0.encode(this.svcMode, 36);
    }
  }

  static final class VideoEncoderMetricsProviderSetEncodedFrameCountParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public long encoderId;
    public long numEncodedFrames;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VideoEncoderMetricsProviderSetEncodedFrameCountParams(int version) {
      super(24, version);
    }

    public VideoEncoderMetricsProviderSetEncodedFrameCountParams() {
      this(0);
    }

    public static VideoEncoderMetricsProviderSetEncodedFrameCountParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static VideoEncoderMetricsProviderSetEncodedFrameCountParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VideoEncoderMetricsProviderSetEncodedFrameCountParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VideoEncoderMetricsProviderSetEncodedFrameCountParams result =
            new VideoEncoderMetricsProviderSetEncodedFrameCountParams(elementsOrVersion);
        result.encoderId = decoder0.readLong(8);
        result.numEncodedFrames = decoder0.readLong(16);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.encoderId, 8);
      encoder0.encode(this.numEncodedFrames, 16);
    }
  }

  static final class VideoEncoderMetricsProviderSetErrorParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public long encoderId;
    public EncoderStatus status;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VideoEncoderMetricsProviderSetErrorParams(int version) {
      super(24, version);
    }

    public VideoEncoderMetricsProviderSetErrorParams() {
      this(0);
    }

    public static VideoEncoderMetricsProviderSetErrorParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static VideoEncoderMetricsProviderSetErrorParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VideoEncoderMetricsProviderSetErrorParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VideoEncoderMetricsProviderSetErrorParams result =
            new VideoEncoderMetricsProviderSetErrorParams(elementsOrVersion);
        result.encoderId = decoder0.readLong(8);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.status = EncoderStatus.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.encoderId, 8);
      encoder0.encode((Struct) this.status, 16, false);
    }
  }

  static final class VideoEncoderMetricsProviderCompleteParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public long encoderId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VideoEncoderMetricsProviderCompleteParams(int version) {
      super(16, version);
    }

    public VideoEncoderMetricsProviderCompleteParams() {
      this(0);
    }

    public static VideoEncoderMetricsProviderCompleteParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static VideoEncoderMetricsProviderCompleteParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VideoEncoderMetricsProviderCompleteParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VideoEncoderMetricsProviderCompleteParams result =
            new VideoEncoderMetricsProviderCompleteParams(elementsOrVersion);
        result.encoderId = decoder0.readLong(8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.encoderId, 8);
    }
  }
}
