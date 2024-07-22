package org.chromium.media.stable.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
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

class StableVideoDecoder_Internal {
  private static final int CONSTRUCT_ORDINAL = 1;
  private static final int DECODE_ORDINAL = 3;
  private static final int GET_SUPPORTED_CONFIGS_ORDINAL = 0;
  private static final int INITIALIZE_ORDINAL = 2;
  public static final Interface.Manager<StableVideoDecoder, StableVideoDecoder.Proxy> MANAGER =
      new Interface.Manager<StableVideoDecoder, StableVideoDecoder.Proxy>() {
        @Override
        public String getName() {
          return "media.stable.mojom.StableVideoDecoder";
        }

        @Override
        public int getVersion() {
          return 1;
        }

        @Override
        public StableVideoDecoder.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, StableVideoDecoder impl) {
          return new Stub(core, impl);
        }

        @Override
        public StableVideoDecoder[] buildArray(int size) {
          return new StableVideoDecoder[size];
        }
      };
  private static final int RESET_ORDINAL = 4;

  StableVideoDecoder_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements StableVideoDecoder.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void getSupportedConfigs(GetSupportedConfigs_Response callback) {
      StableVideoDecoderGetSupportedConfigsParams _message =
          new StableVideoDecoderGetSupportedConfigsParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new StableVideoDecoderGetSupportedConfigsResponseParamsForwardToCallback(callback));
    }

    @Override
    public void construct(
        AssociatedInterfaceNotSupported client,
        MediaLog mediaLog,
        InterfaceRequest<VideoFrameHandleReleaser> videoFrameHandleReleaser,
        DataPipe.ConsumerHandle decoderBufferPipe,
        ColorSpace targetColorSpace) {
      StableVideoDecoderConstructParams _message = new StableVideoDecoderConstructParams();
      _message.client = client;
      _message.mediaLog = mediaLog;
      _message.videoFrameHandleReleaser = videoFrameHandleReleaser;
      _message.decoderBufferPipe = decoderBufferPipe;
      _message.targetColorSpace = targetColorSpace;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void initialize(
        VideoDecoderConfig config,
        boolean lowDelay,
        StableCdmContext cdmContext,
        Initialize_Response callback) {
      StableVideoDecoderInitializeParams _message = new StableVideoDecoderInitializeParams();
      _message.config = config;
      _message.lowDelay = lowDelay;
      _message.cdmContext = cdmContext;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new StableVideoDecoderInitializeResponseParamsForwardToCallback(callback));
    }

    @Override
    public void decode(DecoderBuffer buffer, Decode_Response callback) {
      StableVideoDecoderDecodeParams _message = new StableVideoDecoderDecodeParams();
      _message.buffer = buffer;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)),
              new StableVideoDecoderDecodeResponseParamsForwardToCallback(callback));
    }

    @Override
    public void reset(Reset_Response callback) {
      StableVideoDecoderResetParams _message = new StableVideoDecoderResetParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)),
              new StableVideoDecoderResetResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<StableVideoDecoder> {
    Stub(Core core, StableVideoDecoder impl) {
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
                StableVideoDecoder_Internal.MANAGER, messageWithHeader);
          case 1:
            StableVideoDecoderConstructParams data =
                StableVideoDecoderConstructParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .construct(
                    data.client,
                    data.mediaLog,
                    data.videoFrameHandleReleaser,
                    data.decoderBufferPipe,
                    data.targetColorSpace);
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
                getCore(), StableVideoDecoder_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            StableVideoDecoderGetSupportedConfigsParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .getSupportedConfigs(
                    new StableVideoDecoderGetSupportedConfigsResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
          default:
            return false;
          case 2:
            StableVideoDecoderInitializeParams data =
                StableVideoDecoderInitializeParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .initialize(
                    data.config,
                    data.lowDelay,
                    data.cdmContext,
                    new StableVideoDecoderInitializeResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 3:
            getImpl()
                .decode(
                    StableVideoDecoderDecodeParams.deserialize(messageWithHeader.getPayload())
                        .buffer,
                    new StableVideoDecoderDecodeResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 4:
            StableVideoDecoderResetParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .reset(
                    new StableVideoDecoderResetResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class StableVideoDecoderGetSupportedConfigsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private StableVideoDecoderGetSupportedConfigsParams(int version) {
      super(8, version);
    }

    public StableVideoDecoderGetSupportedConfigsParams() {
      this(0);
    }

    public static StableVideoDecoderGetSupportedConfigsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static StableVideoDecoderGetSupportedConfigsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static StableVideoDecoderGetSupportedConfigsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        StableVideoDecoderGetSupportedConfigsParams result =
            new StableVideoDecoderGetSupportedConfigsParams(elementsOrVersion);
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

  static final class StableVideoDecoderGetSupportedConfigsResponseParams extends Struct {
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

    private StableVideoDecoderGetSupportedConfigsResponseParams(int version) {
      super(24, version);
    }

    public StableVideoDecoderGetSupportedConfigsResponseParams() {
      this(0);
    }

    public static StableVideoDecoderGetSupportedConfigsResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static StableVideoDecoderGetSupportedConfigsResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static StableVideoDecoderGetSupportedConfigsResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        StableVideoDecoderGetSupportedConfigsResponseParams result =
            new StableVideoDecoderGetSupportedConfigsResponseParams(elementsOrVersion);
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

  static class StableVideoDecoderGetSupportedConfigsResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final StableVideoDecoder.GetSupportedConfigs_Response mCallback;

    StableVideoDecoderGetSupportedConfigsResponseParamsForwardToCallback(
        StableVideoDecoder.GetSupportedConfigs_Response callback) {
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
        StableVideoDecoderGetSupportedConfigsResponseParams response =
            StableVideoDecoderGetSupportedConfigsResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.supportedConfigs, response.decoderType);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class StableVideoDecoderGetSupportedConfigsResponseParamsProxyToResponder
      implements StableVideoDecoder.GetSupportedConfigs_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    StableVideoDecoderGetSupportedConfigsResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(SupportedVideoDecoderConfig[] supportedConfigs, int decoderType) {
      StableVideoDecoderGetSupportedConfigsResponseParams _response =
          new StableVideoDecoderGetSupportedConfigsResponseParams();
      _response.supportedConfigs = supportedConfigs;
      _response.decoderType = decoderType;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class StableVideoDecoderConstructParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public AssociatedInterfaceNotSupported client;
    public DataPipe.ConsumerHandle decoderBufferPipe;
    public MediaLog mediaLog;
    public ColorSpace targetColorSpace;
    public InterfaceRequest<VideoFrameHandleReleaser> videoFrameHandleReleaser;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private StableVideoDecoderConstructParams(int version) {
      super(40, version);
      this.decoderBufferPipe = InvalidHandle.INSTANCE;
    }

    public StableVideoDecoderConstructParams() {
      this(0);
    }

    public static StableVideoDecoderConstructParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static StableVideoDecoderConstructParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static StableVideoDecoderConstructParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        StableVideoDecoderConstructParams result =
            new StableVideoDecoderConstructParams(elementsOrVersion);
        result.client = decoder0.readAssociatedServiceInterfaceNotSupported(8, false);
        result.mediaLog = (MediaLog) decoder0.readServiceInterface(16, false, MediaLog.MANAGER);
        result.videoFrameHandleReleaser = decoder0.readInterfaceRequest(24, false);
        result.decoderBufferPipe = decoder0.readConsumerHandle(28, false);
        Decoder decoder1 = decoder0.readPointer(32, false);
        result.targetColorSpace = ColorSpace.decode(decoder1);
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
      encoder0.encode((Struct) this.targetColorSpace, 32, false);
    }
  }

  static final class StableVideoDecoderInitializeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public StableCdmContext cdmContext;
    public VideoDecoderConfig config;
    public boolean lowDelay;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private StableVideoDecoderInitializeParams(int version) {
      super(32, version);
    }

    public StableVideoDecoderInitializeParams() {
      this(0);
    }

    public static StableVideoDecoderInitializeParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static StableVideoDecoderInitializeParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static StableVideoDecoderInitializeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        StableVideoDecoderInitializeParams result =
            new StableVideoDecoderInitializeParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.config = VideoDecoderConfig.decode(decoder1);
        result.lowDelay = decoder0.readBoolean(16, 0);
        result.cdmContext =
            (StableCdmContext) decoder0.readServiceInterface(20, true, StableCdmContext.MANAGER);
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
      encoder0.encode(this.cdmContext, 20, true, StableCdmContext.MANAGER);
    }
  }

  static final class StableVideoDecoderInitializeResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public int decoderType;
    public int maxDecodeRequests;
    public boolean needsBitstreamConversion;
    public boolean needsTranscryption;
    public Status status;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0), new DataHeader(32, 1)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[1];
    }

    private StableVideoDecoderInitializeResponseParams(int version) {
      super(32, version);
    }

    public StableVideoDecoderInitializeResponseParams() {
      this(1);
    }

    public static StableVideoDecoderInitializeResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static StableVideoDecoderInitializeResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static StableVideoDecoderInitializeResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        StableVideoDecoderInitializeResponseParams result =
            new StableVideoDecoderInitializeResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.status = Status.decode(decoder1);
        result.needsBitstreamConversion = decoder0.readBoolean(16, 0);
        if (elementsOrVersion >= 1) {
          result.needsTranscryption = decoder0.readBoolean(16, 1);
        }
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
      encoder0.encode(this.needsTranscryption, 16, 1);
      encoder0.encode(this.maxDecodeRequests, 20);
      encoder0.encode(this.decoderType, 24);
    }
  }

  static class StableVideoDecoderInitializeResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final StableVideoDecoder.Initialize_Response mCallback;

    StableVideoDecoderInitializeResponseParamsForwardToCallback(
        StableVideoDecoder.Initialize_Response callback) {
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
        StableVideoDecoderInitializeResponseParams response =
            StableVideoDecoderInitializeResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(
            response.status,
            response.needsBitstreamConversion,
            response.maxDecodeRequests,
            response.decoderType,
            response.needsTranscryption);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class StableVideoDecoderInitializeResponseParamsProxyToResponder
      implements StableVideoDecoder.Initialize_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    StableVideoDecoderInitializeResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(
        Status status,
        boolean needsBitstreamConversion,
        int maxDecodeRequests,
        int decoderType,
        boolean needsTranscryption) {
      StableVideoDecoderInitializeResponseParams _response =
          new StableVideoDecoderInitializeResponseParams();
      _response.status = status;
      _response.needsBitstreamConversion = needsBitstreamConversion;
      _response.maxDecodeRequests = maxDecodeRequests;
      _response.decoderType = decoderType;
      _response.needsTranscryption = needsTranscryption;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class StableVideoDecoderDecodeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public DecoderBuffer buffer;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private StableVideoDecoderDecodeParams(int version) {
      super(16, version);
    }

    public StableVideoDecoderDecodeParams() {
      this(0);
    }

    public static StableVideoDecoderDecodeParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static StableVideoDecoderDecodeParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static StableVideoDecoderDecodeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        StableVideoDecoderDecodeParams result =
            new StableVideoDecoderDecodeParams(elementsOrVersion);
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

  static final class StableVideoDecoderDecodeResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Status status;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private StableVideoDecoderDecodeResponseParams(int version) {
      super(16, version);
    }

    public StableVideoDecoderDecodeResponseParams() {
      this(0);
    }

    public static StableVideoDecoderDecodeResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static StableVideoDecoderDecodeResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static StableVideoDecoderDecodeResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        StableVideoDecoderDecodeResponseParams result =
            new StableVideoDecoderDecodeResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.status = Status.decode(decoder1);
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

  static class StableVideoDecoderDecodeResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final StableVideoDecoder.Decode_Response mCallback;

    StableVideoDecoderDecodeResponseParamsForwardToCallback(
        StableVideoDecoder.Decode_Response callback) {
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
        StableVideoDecoderDecodeResponseParams response =
            StableVideoDecoderDecodeResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.status);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class StableVideoDecoderDecodeResponseParamsProxyToResponder
      implements StableVideoDecoder.Decode_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    StableVideoDecoderDecodeResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(Status status) {
      StableVideoDecoderDecodeResponseParams _response =
          new StableVideoDecoderDecodeResponseParams();
      _response.status = status;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class StableVideoDecoderResetParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private StableVideoDecoderResetParams(int version) {
      super(8, version);
    }

    public StableVideoDecoderResetParams() {
      this(0);
    }

    public static StableVideoDecoderResetParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static StableVideoDecoderResetParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static StableVideoDecoderResetParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        StableVideoDecoderResetParams result = new StableVideoDecoderResetParams(elementsOrVersion);
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

  static final class StableVideoDecoderResetResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private StableVideoDecoderResetResponseParams(int version) {
      super(8, version);
    }

    public StableVideoDecoderResetResponseParams() {
      this(0);
    }

    public static StableVideoDecoderResetResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static StableVideoDecoderResetResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static StableVideoDecoderResetResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        StableVideoDecoderResetResponseParams result =
            new StableVideoDecoderResetResponseParams(elementsOrVersion);
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

  static class StableVideoDecoderResetResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final StableVideoDecoder.Reset_Response mCallback;

    StableVideoDecoderResetResponseParamsForwardToCallback(
        StableVideoDecoder.Reset_Response callback) {
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

  static class StableVideoDecoderResetResponseParamsProxyToResponder
      implements StableVideoDecoder.Reset_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    StableVideoDecoderResetResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      StableVideoDecoderResetResponseParams _response = new StableVideoDecoderResetResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
