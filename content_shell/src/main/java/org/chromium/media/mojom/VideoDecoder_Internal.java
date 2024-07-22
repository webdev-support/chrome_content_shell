package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.ColorSpace;
import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceControlMessagesHelper;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.MessageReceiverWithResponder;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;
import org.chromium.mojo.system.DataPipe;
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.InvalidHandle;
import org.chromium.mojo_base.mojom.UnguessableToken;

class VideoDecoder_Internal {
  private static final int CONSTRUCT_ORDINAL = 1;
  private static final int DECODE_ORDINAL = 3;
  private static final int GET_SUPPORTED_CONFIGS_ORDINAL = 0;
  private static final int INITIALIZE_ORDINAL = 2;
  public static final Interface.Manager<VideoDecoder, VideoDecoder.Proxy> MANAGER =
      new Interface.Manager<VideoDecoder, VideoDecoder.Proxy>() {
        @Override
        public String getName() {
          return "media.mojom.VideoDecoder";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public VideoDecoder.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, VideoDecoder impl) {
          return new Stub(core, impl);
        }

        @Override
        public VideoDecoder[] buildArray(int size) {
          return new VideoDecoder[size];
        }
      };
  private static final int ON_OVERLAY_INFO_CHANGED_ORDINAL = 5;
  private static final int RESET_ORDINAL = 4;

  VideoDecoder_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements VideoDecoder.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void getSupportedConfigs(GetSupportedConfigs_Response callback) {
      VideoDecoderGetSupportedConfigsParams _message = new VideoDecoderGetSupportedConfigsParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new VideoDecoderGetSupportedConfigsResponseParamsForwardToCallback(callback));
    }

    @Override
    public void construct(
        AssociatedInterfaceNotSupported client,
        MediaLog mediaLog,
        InterfaceRequest<VideoFrameHandleReleaser> videoFrameHandleReleaser,
        DataPipe.ConsumerHandle decoderBufferPipe,
        CommandBufferId commandBufferId,
        ColorSpace targetColorSpace) {
      VideoDecoderConstructParams _message = new VideoDecoderConstructParams();
      _message.client = client;
      _message.mediaLog = mediaLog;
      _message.videoFrameHandleReleaser = videoFrameHandleReleaser;
      _message.decoderBufferPipe = decoderBufferPipe;
      _message.commandBufferId = commandBufferId;
      _message.targetColorSpace = targetColorSpace;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void initialize(
        VideoDecoderConfig config,
        boolean lowDelay,
        UnguessableToken cdmId,
        Initialize_Response callback) {
      VideoDecoderInitializeParams _message = new VideoDecoderInitializeParams();
      _message.config = config;
      _message.lowDelay = lowDelay;
      _message.cdmId = cdmId;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new VideoDecoderInitializeResponseParamsForwardToCallback(callback));
    }

    @Override
    public void decode(DecoderBuffer buffer, Decode_Response callback) {
      VideoDecoderDecodeParams _message = new VideoDecoderDecodeParams();
      _message.buffer = buffer;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)),
              new VideoDecoderDecodeResponseParamsForwardToCallback(callback));
    }

    @Override
    public void reset(Reset_Response callback) {
      VideoDecoderResetParams _message = new VideoDecoderResetParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)),
              new VideoDecoderResetResponseParamsForwardToCallback(callback));
    }

    @Override
    public void onOverlayInfoChanged(OverlayInfo overlayInfo) {
      VideoDecoderOnOverlayInfoChangedParams _message =
          new VideoDecoderOnOverlayInfoChangedParams();
      _message.overlayInfo = overlayInfo;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5)));
    }
  }

  public static final class Stub extends Interface.Stub<VideoDecoder> {
    Stub(Core core, VideoDecoder impl) {
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
                VideoDecoder_Internal.MANAGER, messageWithHeader);
          case 1:
            VideoDecoderConstructParams data =
                VideoDecoderConstructParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .construct(
                    data.client,
                    data.mediaLog,
                    data.videoFrameHandleReleaser,
                    data.decoderBufferPipe,
                    data.commandBufferId,
                    data.targetColorSpace);
            return true;
          case 5:
            getImpl()
                .onOverlayInfoChanged(
                    VideoDecoderOnOverlayInfoChangedParams.deserialize(
                            messageWithHeader.getPayload())
                        .overlayInfo);
            return true;
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
                getCore(), VideoDecoder_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            VideoDecoderGetSupportedConfigsParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .getSupportedConfigs(
                    new VideoDecoderGetSupportedConfigsResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
          default:
            return false;
          case 2:
            VideoDecoderInitializeParams data =
                VideoDecoderInitializeParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .initialize(
                    data.config,
                    data.lowDelay,
                    data.cdmId,
                    new VideoDecoderInitializeResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 3:
            getImpl()
                .decode(
                    VideoDecoderDecodeParams.deserialize(messageWithHeader.getPayload()).buffer,
                    new VideoDecoderDecodeResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 4:
            VideoDecoderResetParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .reset(
                    new VideoDecoderResetResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class VideoDecoderGetSupportedConfigsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VideoDecoderGetSupportedConfigsParams(int version) {
      super(8, version);
    }

    public VideoDecoderGetSupportedConfigsParams() {
      this(0);
    }

    public static VideoDecoderGetSupportedConfigsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static VideoDecoderGetSupportedConfigsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VideoDecoderGetSupportedConfigsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VideoDecoderGetSupportedConfigsParams result =
            new VideoDecoderGetSupportedConfigsParams(elementsOrVersion);
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

  static final class VideoDecoderGetSupportedConfigsResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int decoderType;
    public SupportedVideoDecoderConfig[] supportedConfigs;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VideoDecoderGetSupportedConfigsResponseParams(int version) {
      super(24, version);
    }

    public VideoDecoderGetSupportedConfigsResponseParams() {
      this(0);
    }

    public static VideoDecoderGetSupportedConfigsResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static VideoDecoderGetSupportedConfigsResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VideoDecoderGetSupportedConfigsResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VideoDecoderGetSupportedConfigsResponseParams result =
            new VideoDecoderGetSupportedConfigsResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.supportedConfigs = new SupportedVideoDecoderConfig[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.supportedConfigs[i1] = SupportedVideoDecoderConfig.decode(decoder2);
        }
        int readInt = decoder0.readInt(16);
        result.decoderType = readInt;
        VideoDecoderType.validate(readInt);
        result.decoderType = VideoDecoderType.toKnownValue(result.decoderType);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      SupportedVideoDecoderConfig[] supportedVideoDecoderConfigArr = this.supportedConfigs;
      if (supportedVideoDecoderConfigArr == null) {
        encoder0.encodeNullPointer(8, false);
      } else {
        Encoder encoder1 =
            encoder0.encodePointerArray(supportedVideoDecoderConfigArr.length, 8, -1);
        int i0 = 0;
        while (true) {
          SupportedVideoDecoderConfig[] supportedVideoDecoderConfigArr2 = this.supportedConfigs;
          if (i0 >= supportedVideoDecoderConfigArr2.length) {
            break;
          }
          encoder1.encode((Struct) supportedVideoDecoderConfigArr2[i0], (i0 * 8) + 8, false);
          i0++;
        }
      }
      encoder0.encode(this.decoderType, 16);
    }
  }

  static class VideoDecoderGetSupportedConfigsResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final VideoDecoder.GetSupportedConfigs_Response mCallback;

    VideoDecoderGetSupportedConfigsResponseParamsForwardToCallback(
        VideoDecoder.GetSupportedConfigs_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(0, 6)) {
          return false;
        }
        VideoDecoderGetSupportedConfigsResponseParams response =
            VideoDecoderGetSupportedConfigsResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.supportedConfigs, response.decoderType);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class VideoDecoderGetSupportedConfigsResponseParamsProxyToResponder
      implements VideoDecoder.GetSupportedConfigs_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    VideoDecoderGetSupportedConfigsResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(SupportedVideoDecoderConfig[] supportedConfigs, int decoderType) {
      VideoDecoderGetSupportedConfigsResponseParams _response =
          new VideoDecoderGetSupportedConfigsResponseParams();
      _response.supportedConfigs = supportedConfigs;
      _response.decoderType = decoderType;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class VideoDecoderConstructParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 48;
    private static final DataHeader[] VERSION_ARRAY;
    public AssociatedInterfaceNotSupported client;
    public CommandBufferId commandBufferId;
    public DataPipe.ConsumerHandle decoderBufferPipe;
    public MediaLog mediaLog;
    public ColorSpace targetColorSpace;
    public InterfaceRequest<VideoFrameHandleReleaser> videoFrameHandleReleaser;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(48, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VideoDecoderConstructParams(int version) {
      super(48, version);
      this.decoderBufferPipe = InvalidHandle.INSTANCE;
    }

    public VideoDecoderConstructParams() {
      this(0);
    }

    public static VideoDecoderConstructParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static VideoDecoderConstructParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VideoDecoderConstructParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VideoDecoderConstructParams result = new VideoDecoderConstructParams(elementsOrVersion);
        result.client = decoder0.readAssociatedServiceInterfaceNotSupported(8, false);
        result.mediaLog = (MediaLog) decoder0.readServiceInterface(16, false, MediaLog.MANAGER);
        result.videoFrameHandleReleaser = decoder0.readInterfaceRequest(24, false);
        result.decoderBufferPipe = decoder0.readConsumerHandle(28, false);
        Decoder decoder1 = decoder0.readPointer(32, true);
        result.commandBufferId = CommandBufferId.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(40, false);
        result.targetColorSpace = ColorSpace.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.client, 8, false);
      encoder0.encode(this.mediaLog, 16, false, MediaLog.MANAGER);
      encoder0.encode((InterfaceRequest) this.videoFrameHandleReleaser, 24, false);
      encoder0.encode((Handle) this.decoderBufferPipe, 28, false);
      encoder0.encode((Struct) this.commandBufferId, 32, true);
      encoder0.encode((Struct) this.targetColorSpace, 40, false);
    }
  }

  static final class VideoDecoderInitializeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public UnguessableToken cdmId;
    public VideoDecoderConfig config;
    public boolean lowDelay;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VideoDecoderInitializeParams(int version) {
      super(32, version);
    }

    public VideoDecoderInitializeParams() {
      this(0);
    }

    public static VideoDecoderInitializeParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static VideoDecoderInitializeParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VideoDecoderInitializeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VideoDecoderInitializeParams result = new VideoDecoderInitializeParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.config = VideoDecoderConfig.decode(decoder1);
        result.lowDelay = decoder0.readBoolean(16, 0);
        Decoder decoder12 = decoder0.readPointer(24, true);
        result.cdmId = UnguessableToken.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.config, 8, false);
      encoder0.encode(this.lowDelay, 16, 0);
      encoder0.encode((Struct) this.cdmId, 24, true);
    }
  }

  static final class VideoDecoderInitializeResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public int decoderType;
    public int maxDecodeRequests;
    public boolean needsBitstreamConversion;
    public DecoderStatus status;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VideoDecoderInitializeResponseParams(int version) {
      super(32, version);
    }

    public VideoDecoderInitializeResponseParams() {
      this(0);
    }

    public static VideoDecoderInitializeResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static VideoDecoderInitializeResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VideoDecoderInitializeResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VideoDecoderInitializeResponseParams result =
            new VideoDecoderInitializeResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.status = DecoderStatus.decode(decoder1);
        result.needsBitstreamConversion = decoder0.readBoolean(16, 0);
        result.maxDecodeRequests = decoder0.readInt(20);
        int readInt = decoder0.readInt(24);
        result.decoderType = readInt;
        VideoDecoderType.validate(readInt);
        result.decoderType = VideoDecoderType.toKnownValue(result.decoderType);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.status, 8, false);
      encoder0.encode(this.needsBitstreamConversion, 16, 0);
      encoder0.encode(this.maxDecodeRequests, 20);
      encoder0.encode(this.decoderType, 24);
    }
  }

  static class VideoDecoderInitializeResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final VideoDecoder.Initialize_Response mCallback;

    VideoDecoderInitializeResponseParamsForwardToCallback(
        VideoDecoder.Initialize_Response callback) {
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
        VideoDecoderInitializeResponseParams response =
            VideoDecoderInitializeResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(
            response.status,
            response.needsBitstreamConversion,
            response.maxDecodeRequests,
            response.decoderType);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class VideoDecoderInitializeResponseParamsProxyToResponder
      implements VideoDecoder.Initialize_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    VideoDecoderInitializeResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(
        DecoderStatus status,
        boolean needsBitstreamConversion,
        int maxDecodeRequests,
        int decoderType) {
      VideoDecoderInitializeResponseParams _response = new VideoDecoderInitializeResponseParams();
      _response.status = status;
      _response.needsBitstreamConversion = needsBitstreamConversion;
      _response.maxDecodeRequests = maxDecodeRequests;
      _response.decoderType = decoderType;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class VideoDecoderDecodeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public DecoderBuffer buffer;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VideoDecoderDecodeParams(int version) {
      super(16, version);
    }

    public VideoDecoderDecodeParams() {
      this(0);
    }

    public static VideoDecoderDecodeParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static VideoDecoderDecodeParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VideoDecoderDecodeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VideoDecoderDecodeParams result = new VideoDecoderDecodeParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.buffer = DecoderBuffer.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.buffer, 8, false);
    }
  }

  static final class VideoDecoderDecodeResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public DecoderStatus status;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VideoDecoderDecodeResponseParams(int version) {
      super(16, version);
    }

    public VideoDecoderDecodeResponseParams() {
      this(0);
    }

    public static VideoDecoderDecodeResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static VideoDecoderDecodeResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VideoDecoderDecodeResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VideoDecoderDecodeResponseParams result =
            new VideoDecoderDecodeResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.status = DecoderStatus.decode(decoder1);
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

  static class VideoDecoderDecodeResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final VideoDecoder.Decode_Response mCallback;

    VideoDecoderDecodeResponseParamsForwardToCallback(VideoDecoder.Decode_Response callback) {
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
        VideoDecoderDecodeResponseParams response =
            VideoDecoderDecodeResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.status);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class VideoDecoderDecodeResponseParamsProxyToResponder
      implements VideoDecoder.Decode_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    VideoDecoderDecodeResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(DecoderStatus status) {
      VideoDecoderDecodeResponseParams _response = new VideoDecoderDecodeResponseParams();
      _response.status = status;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class VideoDecoderResetParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VideoDecoderResetParams(int version) {
      super(8, version);
    }

    public VideoDecoderResetParams() {
      this(0);
    }

    public static VideoDecoderResetParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static VideoDecoderResetParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VideoDecoderResetParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VideoDecoderResetParams result = new VideoDecoderResetParams(elementsOrVersion);
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

  static final class VideoDecoderResetResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VideoDecoderResetResponseParams(int version) {
      super(8, version);
    }

    public VideoDecoderResetResponseParams() {
      this(0);
    }

    public static VideoDecoderResetResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static VideoDecoderResetResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VideoDecoderResetResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VideoDecoderResetResponseParams result =
            new VideoDecoderResetResponseParams(elementsOrVersion);
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

  static class VideoDecoderResetResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final VideoDecoder.Reset_Response mCallback;

    VideoDecoderResetResponseParamsForwardToCallback(VideoDecoder.Reset_Response callback) {
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
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class VideoDecoderResetResponseParamsProxyToResponder
      implements VideoDecoder.Reset_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    VideoDecoderResetResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      VideoDecoderResetResponseParams _response = new VideoDecoderResetResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class VideoDecoderOnOverlayInfoChangedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public OverlayInfo overlayInfo;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VideoDecoderOnOverlayInfoChangedParams(int version) {
      super(16, version);
    }

    public VideoDecoderOnOverlayInfoChangedParams() {
      this(0);
    }

    public static VideoDecoderOnOverlayInfoChangedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static VideoDecoderOnOverlayInfoChangedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VideoDecoderOnOverlayInfoChangedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VideoDecoderOnOverlayInfoChangedParams result =
            new VideoDecoderOnOverlayInfoChangedParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.overlayInfo = OverlayInfo.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.overlayInfo, 8, false);
    }
  }
}
