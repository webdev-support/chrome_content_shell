package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Size;
import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
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
import org.chromium.mojo_base.mojom.UnsafeSharedMemoryRegion;

class VideoEncodeAccelerator_Internal {
  private static final int ENCODE_ORDINAL = 1;
  private static final int FLUSH_ORDINAL = 6;
  private static final int INITIALIZE_ORDINAL = 0;
  private static final int IS_FLUSH_SUPPORTED_ORDINAL = 5;
  public static final Interface.Manager<VideoEncodeAccelerator, VideoEncodeAccelerator.Proxy>
      MANAGER =
          new Interface.Manager<VideoEncodeAccelerator, VideoEncodeAccelerator.Proxy>() {
            @Override
            public String getName() {
              return "media.mojom.VideoEncodeAccelerator";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public VideoEncodeAccelerator.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, VideoEncodeAccelerator impl) {
              return new Stub(core, impl);
            }

            @Override
            public VideoEncodeAccelerator[] buildArray(int size) {
              return new VideoEncodeAccelerator[size];
            }
          };
  private static final int REQUEST_ENCODING_PARAMETERS_CHANGE_WITH_BITRATE_ORDINAL = 4;
  private static final int REQUEST_ENCODING_PARAMETERS_CHANGE_WITH_LAYERS_ORDINAL = 3;
  private static final int USE_OUTPUT_BITSTREAM_BUFFER_ORDINAL = 2;

  VideoEncodeAccelerator_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements VideoEncodeAccelerator.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void initialize(
        VideoEncodeAcceleratorConfig config,
        AssociatedInterfaceNotSupported client,
        MediaLog mediaLog,
        Initialize_Response callback) {
      VideoEncodeAcceleratorInitializeParams _message =
          new VideoEncodeAcceleratorInitializeParams();
      _message.config = config;
      _message.client = client;
      _message.mediaLog = mediaLog;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new VideoEncodeAcceleratorInitializeResponseParamsForwardToCallback(callback));
    }

    @Override
    public void encode(VideoFrame frame, VideoEncodeOptions options, Encode_Response callback) {
      VideoEncodeAcceleratorEncodeParams _message = new VideoEncodeAcceleratorEncodeParams();
      _message.frame = frame;
      _message.options = options;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new VideoEncodeAcceleratorEncodeResponseParamsForwardToCallback(callback));
    }

    @Override
    public void useOutputBitstreamBuffer(int bitstreamBufferId, UnsafeSharedMemoryRegion region) {
      VideoEncodeAcceleratorUseOutputBitstreamBufferParams _message =
          new VideoEncodeAcceleratorUseOutputBitstreamBufferParams();
      _message.bitstreamBufferId = bitstreamBufferId;
      _message.region = region;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void requestEncodingParametersChangeWithLayers(
        VideoBitrateAllocation bitrateAllocation, int framerate, Size size) {
      VideoEncodeAcceleratorRequestEncodingParametersChangeWithLayersParams _message =
          new VideoEncodeAcceleratorRequestEncodingParametersChangeWithLayersParams();
      _message.bitrateAllocation = bitrateAllocation;
      _message.framerate = framerate;
      _message.size = size;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }

    @Override
    public void requestEncodingParametersChangeWithBitrate(
        Bitrate bitrate, int framerate, Size size) {
      VideoEncodeAcceleratorRequestEncodingParametersChangeWithBitrateParams _message =
          new VideoEncodeAcceleratorRequestEncodingParametersChangeWithBitrateParams();
      _message.bitrate = bitrate;
      _message.framerate = framerate;
      _message.size = size;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
    }

    @Override
    public void isFlushSupported(IsFlushSupported_Response callback) {
      VideoEncodeAcceleratorIsFlushSupportedParams _message =
          new VideoEncodeAcceleratorIsFlushSupportedParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(5, 1, 0L)),
              new VideoEncodeAcceleratorIsFlushSupportedResponseParamsForwardToCallback(callback));
    }

    @Override
    public void flush(Flush_Response callback) {
      VideoEncodeAcceleratorFlushParams _message = new VideoEncodeAcceleratorFlushParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(6, 1, 0L)),
              new VideoEncodeAcceleratorFlushResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<VideoEncodeAccelerator> {
    Stub(Core core, VideoEncodeAccelerator impl) {
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
                VideoEncodeAccelerator_Internal.MANAGER, messageWithHeader);
          case -1:
          case 0:
          case 1:
          default:
            return false;
          case 2:
            VideoEncodeAcceleratorUseOutputBitstreamBufferParams data =
                VideoEncodeAcceleratorUseOutputBitstreamBufferParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().useOutputBitstreamBuffer(data.bitstreamBufferId, data.region);
            return true;
          case 3:
            VideoEncodeAcceleratorRequestEncodingParametersChangeWithLayersParams data2 =
                VideoEncodeAcceleratorRequestEncodingParametersChangeWithLayersParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .requestEncodingParametersChangeWithLayers(
                    data2.bitrateAllocation, data2.framerate, data2.size);
            return true;
          case 4:
            VideoEncodeAcceleratorRequestEncodingParametersChangeWithBitrateParams data3 =
                VideoEncodeAcceleratorRequestEncodingParametersChangeWithBitrateParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .requestEncodingParametersChangeWithBitrate(
                    data3.bitrate, data3.framerate, data3.size);
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
                getCore(), VideoEncodeAccelerator_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            VideoEncodeAcceleratorInitializeParams data =
                VideoEncodeAcceleratorInitializeParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .initialize(
                    data.config,
                    data.client,
                    data.mediaLog,
                    new VideoEncodeAcceleratorInitializeResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
            VideoEncodeAcceleratorEncodeParams data2 =
                VideoEncodeAcceleratorEncodeParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .encode(
                    data2.frame,
                    data2.options,
                    new VideoEncodeAcceleratorEncodeResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 2:
          case 3:
          case 4:
          default:
            return false;
          case 5:
            VideoEncodeAcceleratorIsFlushSupportedParams.deserialize(
                messageWithHeader.getPayload());
            getImpl()
                .isFlushSupported(
                    new VideoEncodeAcceleratorIsFlushSupportedResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 6:
            VideoEncodeAcceleratorFlushParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .flush(
                    new VideoEncodeAcceleratorFlushResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class VideoEncodeAcceleratorInitializeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public AssociatedInterfaceNotSupported client;
    public VideoEncodeAcceleratorConfig config;
    public MediaLog mediaLog;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VideoEncodeAcceleratorInitializeParams(int version) {
      super(32, version);
    }

    public VideoEncodeAcceleratorInitializeParams() {
      this(0);
    }

    public static VideoEncodeAcceleratorInitializeParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static VideoEncodeAcceleratorInitializeParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VideoEncodeAcceleratorInitializeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VideoEncodeAcceleratorInitializeParams result =
            new VideoEncodeAcceleratorInitializeParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.config = VideoEncodeAcceleratorConfig.decode(decoder1);
        result.client = decoder0.readAssociatedServiceInterfaceNotSupported(16, false);
        result.mediaLog = (MediaLog) decoder0.readServiceInterface(24, false, MediaLog.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.config, 8, false);
      encoder0.encode(this.client, 16, false);
      encoder0.encode(this.mediaLog, 24, false, MediaLog.MANAGER);
    }
  }

  static final class VideoEncodeAcceleratorInitializeResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VideoEncodeAcceleratorInitializeResponseParams(int version) {
      super(16, version);
    }

    public VideoEncodeAcceleratorInitializeResponseParams() {
      this(0);
    }

    public static VideoEncodeAcceleratorInitializeResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static VideoEncodeAcceleratorInitializeResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VideoEncodeAcceleratorInitializeResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VideoEncodeAcceleratorInitializeResponseParams result =
            new VideoEncodeAcceleratorInitializeResponseParams(elementsOrVersion);
        result.result = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.result, 8, 0);
    }
  }

  static class VideoEncodeAcceleratorInitializeResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final VideoEncodeAccelerator.Initialize_Response mCallback;

    VideoEncodeAcceleratorInitializeResponseParamsForwardToCallback(
        VideoEncodeAccelerator.Initialize_Response callback) {
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
        VideoEncodeAcceleratorInitializeResponseParams response =
            VideoEncodeAcceleratorInitializeResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class VideoEncodeAcceleratorInitializeResponseParamsProxyToResponder
      implements VideoEncodeAccelerator.Initialize_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    VideoEncodeAcceleratorInitializeResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean result) {
      VideoEncodeAcceleratorInitializeResponseParams _response =
          new VideoEncodeAcceleratorInitializeResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class VideoEncodeAcceleratorEncodeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public VideoFrame frame;
    public VideoEncodeOptions options;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VideoEncodeAcceleratorEncodeParams(int version) {
      super(24, version);
    }

    public VideoEncodeAcceleratorEncodeParams() {
      this(0);
    }

    public static VideoEncodeAcceleratorEncodeParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static VideoEncodeAcceleratorEncodeParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VideoEncodeAcceleratorEncodeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VideoEncodeAcceleratorEncodeParams result =
            new VideoEncodeAcceleratorEncodeParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.frame = VideoFrame.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.options = VideoEncodeOptions.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.frame, 8, false);
      encoder0.encode((Struct) this.options, 16, false);
    }
  }

  static final class VideoEncodeAcceleratorEncodeResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VideoEncodeAcceleratorEncodeResponseParams(int version) {
      super(8, version);
    }

    public VideoEncodeAcceleratorEncodeResponseParams() {
      this(0);
    }

    public static VideoEncodeAcceleratorEncodeResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static VideoEncodeAcceleratorEncodeResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VideoEncodeAcceleratorEncodeResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VideoEncodeAcceleratorEncodeResponseParams result =
            new VideoEncodeAcceleratorEncodeResponseParams(elementsOrVersion);
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

  static class VideoEncodeAcceleratorEncodeResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final VideoEncodeAccelerator.Encode_Response mCallback;

    VideoEncodeAcceleratorEncodeResponseParamsForwardToCallback(
        VideoEncodeAccelerator.Encode_Response callback) {
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
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class VideoEncodeAcceleratorEncodeResponseParamsProxyToResponder
      implements VideoEncodeAccelerator.Encode_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    VideoEncodeAcceleratorEncodeResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      VideoEncodeAcceleratorEncodeResponseParams _response =
          new VideoEncodeAcceleratorEncodeResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class VideoEncodeAcceleratorUseOutputBitstreamBufferParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int bitstreamBufferId;
    public UnsafeSharedMemoryRegion region;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VideoEncodeAcceleratorUseOutputBitstreamBufferParams(int version) {
      super(24, version);
    }

    public VideoEncodeAcceleratorUseOutputBitstreamBufferParams() {
      this(0);
    }

    public static VideoEncodeAcceleratorUseOutputBitstreamBufferParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static VideoEncodeAcceleratorUseOutputBitstreamBufferParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VideoEncodeAcceleratorUseOutputBitstreamBufferParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VideoEncodeAcceleratorUseOutputBitstreamBufferParams result =
            new VideoEncodeAcceleratorUseOutputBitstreamBufferParams(elementsOrVersion);
        result.bitstreamBufferId = decoder0.readInt(8);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.region = UnsafeSharedMemoryRegion.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.bitstreamBufferId, 8);
      encoder0.encode((Struct) this.region, 16, false);
    }
  }

  static final class VideoEncodeAcceleratorRequestEncodingParametersChangeWithLayersParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public VideoBitrateAllocation bitrateAllocation;
    public int framerate;
    public Size size;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VideoEncodeAcceleratorRequestEncodingParametersChangeWithLayersParams(int version) {
      super(32, version);
    }

    public VideoEncodeAcceleratorRequestEncodingParametersChangeWithLayersParams() {
      this(0);
    }

    public static VideoEncodeAcceleratorRequestEncodingParametersChangeWithLayersParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static VideoEncodeAcceleratorRequestEncodingParametersChangeWithLayersParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VideoEncodeAcceleratorRequestEncodingParametersChangeWithLayersParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VideoEncodeAcceleratorRequestEncodingParametersChangeWithLayersParams result =
            new VideoEncodeAcceleratorRequestEncodingParametersChangeWithLayersParams(
                elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.bitrateAllocation = VideoBitrateAllocation.decode(decoder1);
        result.framerate = decoder0.readInt(16);
        Decoder decoder12 = decoder0.readPointer(24, true);
        result.size = Size.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.bitrateAllocation, 8, false);
      encoder0.encode(this.framerate, 16);
      encoder0.encode((Struct) this.size, 24, true);
    }
  }

  static final class VideoEncodeAcceleratorRequestEncodingParametersChangeWithBitrateParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public Bitrate bitrate;
    public int framerate;
    public Size size;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VideoEncodeAcceleratorRequestEncodingParametersChangeWithBitrateParams(int version) {
      super(40, version);
    }

    public VideoEncodeAcceleratorRequestEncodingParametersChangeWithBitrateParams() {
      this(0);
    }

    public static VideoEncodeAcceleratorRequestEncodingParametersChangeWithBitrateParams
        deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static VideoEncodeAcceleratorRequestEncodingParametersChangeWithBitrateParams
        deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VideoEncodeAcceleratorRequestEncodingParametersChangeWithBitrateParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VideoEncodeAcceleratorRequestEncodingParametersChangeWithBitrateParams result =
            new VideoEncodeAcceleratorRequestEncodingParametersChangeWithBitrateParams(
                elementsOrVersion);
        result.bitrate = Bitrate.decode(decoder0, 8);
        result.framerate = decoder0.readInt(24);
        Decoder decoder1 = decoder0.readPointer(32, true);
        result.size = Size.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Union) this.bitrate, 8, false);
      encoder0.encode(this.framerate, 24);
      encoder0.encode((Struct) this.size, 32, true);
    }
  }

  static final class VideoEncodeAcceleratorIsFlushSupportedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VideoEncodeAcceleratorIsFlushSupportedParams(int version) {
      super(8, version);
    }

    public VideoEncodeAcceleratorIsFlushSupportedParams() {
      this(0);
    }

    public static VideoEncodeAcceleratorIsFlushSupportedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static VideoEncodeAcceleratorIsFlushSupportedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VideoEncodeAcceleratorIsFlushSupportedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VideoEncodeAcceleratorIsFlushSupportedParams result =
            new VideoEncodeAcceleratorIsFlushSupportedParams(elementsOrVersion);
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

  static final class VideoEncodeAcceleratorIsFlushSupportedResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VideoEncodeAcceleratorIsFlushSupportedResponseParams(int version) {
      super(16, version);
    }

    public VideoEncodeAcceleratorIsFlushSupportedResponseParams() {
      this(0);
    }

    public static VideoEncodeAcceleratorIsFlushSupportedResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static VideoEncodeAcceleratorIsFlushSupportedResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VideoEncodeAcceleratorIsFlushSupportedResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VideoEncodeAcceleratorIsFlushSupportedResponseParams result =
            new VideoEncodeAcceleratorIsFlushSupportedResponseParams(elementsOrVersion);
        result.result = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.result, 8, 0);
    }
  }

  static class VideoEncodeAcceleratorIsFlushSupportedResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final VideoEncodeAccelerator.IsFlushSupported_Response mCallback;

    VideoEncodeAcceleratorIsFlushSupportedResponseParamsForwardToCallback(
        VideoEncodeAccelerator.IsFlushSupported_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(5, 6)) {
          return false;
        }
        VideoEncodeAcceleratorIsFlushSupportedResponseParams response =
            VideoEncodeAcceleratorIsFlushSupportedResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class VideoEncodeAcceleratorIsFlushSupportedResponseParamsProxyToResponder
      implements VideoEncodeAccelerator.IsFlushSupported_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    VideoEncodeAcceleratorIsFlushSupportedResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean result) {
      VideoEncodeAcceleratorIsFlushSupportedResponseParams _response =
          new VideoEncodeAcceleratorIsFlushSupportedResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(5, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class VideoEncodeAcceleratorFlushParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VideoEncodeAcceleratorFlushParams(int version) {
      super(8, version);
    }

    public VideoEncodeAcceleratorFlushParams() {
      this(0);
    }

    public static VideoEncodeAcceleratorFlushParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static VideoEncodeAcceleratorFlushParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VideoEncodeAcceleratorFlushParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VideoEncodeAcceleratorFlushParams result =
            new VideoEncodeAcceleratorFlushParams(elementsOrVersion);
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

  static final class VideoEncodeAcceleratorFlushResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VideoEncodeAcceleratorFlushResponseParams(int version) {
      super(16, version);
    }

    public VideoEncodeAcceleratorFlushResponseParams() {
      this(0);
    }

    public static VideoEncodeAcceleratorFlushResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static VideoEncodeAcceleratorFlushResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VideoEncodeAcceleratorFlushResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VideoEncodeAcceleratorFlushResponseParams result =
            new VideoEncodeAcceleratorFlushResponseParams(elementsOrVersion);
        result.result = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.result, 8, 0);
    }
  }

  static class VideoEncodeAcceleratorFlushResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final VideoEncodeAccelerator.Flush_Response mCallback;

    VideoEncodeAcceleratorFlushResponseParamsForwardToCallback(
        VideoEncodeAccelerator.Flush_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(6, 2)) {
          return false;
        }
        VideoEncodeAcceleratorFlushResponseParams response =
            VideoEncodeAcceleratorFlushResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class VideoEncodeAcceleratorFlushResponseParamsProxyToResponder
      implements VideoEncodeAccelerator.Flush_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    VideoEncodeAcceleratorFlushResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean result) {
      VideoEncodeAcceleratorFlushResponseParams _response =
          new VideoEncodeAcceleratorFlushResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(6, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
