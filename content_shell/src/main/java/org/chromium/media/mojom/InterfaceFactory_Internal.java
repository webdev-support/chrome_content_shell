package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.media.stable.mojom.StableVideoDecoder;
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

class InterfaceFactory_Internal {
  private static final int CREATE_AUDIO_DECODER_ORDINAL = 0;
  private static final int CREATE_AUDIO_ENCODER_ORDINAL = 2;
  private static final int CREATE_CDM_ORDINAL = 6;
  private static final int CREATE_DEFAULT_RENDERER_ORDINAL = 3;
  private static final int CREATE_FLINGING_RENDERER_ORDINAL = 5;
  private static final int CREATE_MEDIA_PLAYER_RENDERER_ORDINAL = 4;
  private static final int CREATE_VIDEO_DECODER_ORDINAL = 1;
  public static final Interface.Manager<InterfaceFactory, InterfaceFactory.Proxy> MANAGER =
      new Interface.Manager<InterfaceFactory, InterfaceFactory.Proxy>() {
        @Override
        public String getName() {
          return "media.mojom.InterfaceFactory";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public InterfaceFactory.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, InterfaceFactory impl) {
          return new Stub(core, impl);
        }

        @Override
        public InterfaceFactory[] buildArray(int size) {
          return new InterfaceFactory[size];
        }
      };

  InterfaceFactory_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements InterfaceFactory.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void createAudioDecoder(InterfaceRequest<AudioDecoder> audioDecoder) {
      InterfaceFactoryCreateAudioDecoderParams _message =
          new InterfaceFactoryCreateAudioDecoderParams();
      _message.audioDecoder = audioDecoder;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void createVideoDecoder(
        InterfaceRequest<VideoDecoder> videoDecoder, StableVideoDecoder dstVideoDecoder) {
      InterfaceFactoryCreateVideoDecoderParams _message =
          new InterfaceFactoryCreateVideoDecoderParams();
      _message.videoDecoder = videoDecoder;
      _message.dstVideoDecoder = dstVideoDecoder;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void createAudioEncoder(InterfaceRequest<AudioEncoder> audioEncoder) {
      InterfaceFactoryCreateAudioEncoderParams _message =
          new InterfaceFactoryCreateAudioEncoderParams();
      _message.audioEncoder = audioEncoder;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void createDefaultRenderer(String audioDeviceId, InterfaceRequest<Renderer> renderer) {
      InterfaceFactoryCreateDefaultRendererParams _message =
          new InterfaceFactoryCreateDefaultRendererParams();
      _message.audioDeviceId = audioDeviceId;
      _message.renderer = renderer;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }

    @Override
    public void createMediaPlayerRenderer(
        MediaPlayerRendererClientExtension clientExtension,
        InterfaceRequest<Renderer> renderer,
        InterfaceRequest<MediaPlayerRendererExtension> rendererExtension) {
      InterfaceFactoryCreateMediaPlayerRendererParams _message =
          new InterfaceFactoryCreateMediaPlayerRendererParams();
      _message.clientExtension = clientExtension;
      _message.renderer = renderer;
      _message.rendererExtension = rendererExtension;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
    }

    @Override
    public void createFlingingRenderer(
        String presentationId,
        FlingingRendererClientExtension clientExtension,
        InterfaceRequest<Renderer> renderer) {
      InterfaceFactoryCreateFlingingRendererParams _message =
          new InterfaceFactoryCreateFlingingRendererParams();
      _message.presentationId = presentationId;
      _message.clientExtension = clientExtension;
      _message.renderer = renderer;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5)));
    }

    @Override
    public void createCdm(CdmConfig cdmConfig, CreateCdm_Response callback) {
      InterfaceFactoryCreateCdmParams _message = new InterfaceFactoryCreateCdmParams();
      _message.cdmConfig = cdmConfig;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(6, 1, 0L)),
              new InterfaceFactoryCreateCdmResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<InterfaceFactory> {
    Stub(Core core, InterfaceFactory impl) {
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
                InterfaceFactory_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            getImpl()
                .createAudioDecoder(
                    InterfaceFactoryCreateAudioDecoderParams.deserialize(
                            messageWithHeader.getPayload())
                        .audioDecoder);
            return true;
          case 1:
            InterfaceFactoryCreateVideoDecoderParams data =
                InterfaceFactoryCreateVideoDecoderParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().createVideoDecoder(data.videoDecoder, data.dstVideoDecoder);
            return true;
          case 2:
            InterfaceFactoryCreateAudioEncoderParams data2 =
                InterfaceFactoryCreateAudioEncoderParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().createAudioEncoder(data2.audioEncoder);
            return true;
          case 3:
            InterfaceFactoryCreateDefaultRendererParams data3 =
                InterfaceFactoryCreateDefaultRendererParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().createDefaultRenderer(data3.audioDeviceId, data3.renderer);
            return true;
          case 4:
            InterfaceFactoryCreateMediaPlayerRendererParams data4 =
                InterfaceFactoryCreateMediaPlayerRendererParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .createMediaPlayerRenderer(
                    data4.clientExtension, data4.renderer, data4.rendererExtension);
            return true;
          case 5:
            InterfaceFactoryCreateFlingingRendererParams data5 =
                InterfaceFactoryCreateFlingingRendererParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .createFlingingRenderer(
                    data5.presentationId, data5.clientExtension, data5.renderer);
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
                getCore(), InterfaceFactory_Internal.MANAGER, messageWithHeader, receiver);
          case 6:
            InterfaceFactoryCreateCdmParams data =
                InterfaceFactoryCreateCdmParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .createCdm(
                    data.cdmConfig,
                    new InterfaceFactoryCreateCdmResponseParamsProxyToResponder(
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

  static final class InterfaceFactoryCreateAudioDecoderParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<AudioDecoder> audioDecoder;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private InterfaceFactoryCreateAudioDecoderParams(int version) {
      super(16, version);
    }

    public InterfaceFactoryCreateAudioDecoderParams() {
      this(0);
    }

    public static InterfaceFactoryCreateAudioDecoderParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static InterfaceFactoryCreateAudioDecoderParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static InterfaceFactoryCreateAudioDecoderParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        InterfaceFactoryCreateAudioDecoderParams result =
            new InterfaceFactoryCreateAudioDecoderParams(elementsOrVersion);
        result.audioDecoder = decoder0.readInterfaceRequest(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.audioDecoder, 8, false);
    }
  }

  static final class InterfaceFactoryCreateVideoDecoderParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public StableVideoDecoder dstVideoDecoder;
    public InterfaceRequest<VideoDecoder> videoDecoder;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private InterfaceFactoryCreateVideoDecoderParams(int version) {
      super(24, version);
    }

    public InterfaceFactoryCreateVideoDecoderParams() {
      this(0);
    }

    public static InterfaceFactoryCreateVideoDecoderParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static InterfaceFactoryCreateVideoDecoderParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static InterfaceFactoryCreateVideoDecoderParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        InterfaceFactoryCreateVideoDecoderParams result =
            new InterfaceFactoryCreateVideoDecoderParams(elementsOrVersion);
        result.videoDecoder = decoder0.readInterfaceRequest(8, false);
        result.dstVideoDecoder =
            (StableVideoDecoder)
                decoder0.readServiceInterface(12, true, StableVideoDecoder.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.videoDecoder, 8, false);
      encoder0.encode(this.dstVideoDecoder, 12, true, StableVideoDecoder.MANAGER);
    }
  }

  static final class InterfaceFactoryCreateAudioEncoderParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<AudioEncoder> audioEncoder;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private InterfaceFactoryCreateAudioEncoderParams(int version) {
      super(16, version);
    }

    public InterfaceFactoryCreateAudioEncoderParams() {
      this(0);
    }

    public static InterfaceFactoryCreateAudioEncoderParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static InterfaceFactoryCreateAudioEncoderParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static InterfaceFactoryCreateAudioEncoderParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        InterfaceFactoryCreateAudioEncoderParams result =
            new InterfaceFactoryCreateAudioEncoderParams(elementsOrVersion);
        result.audioEncoder = decoder0.readInterfaceRequest(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.audioEncoder, 8, false);
    }
  }

  static final class InterfaceFactoryCreateDefaultRendererParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public String audioDeviceId;
    public InterfaceRequest<Renderer> renderer;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private InterfaceFactoryCreateDefaultRendererParams(int version) {
      super(24, version);
    }

    public InterfaceFactoryCreateDefaultRendererParams() {
      this(0);
    }

    public static InterfaceFactoryCreateDefaultRendererParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static InterfaceFactoryCreateDefaultRendererParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static InterfaceFactoryCreateDefaultRendererParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        InterfaceFactoryCreateDefaultRendererParams result =
            new InterfaceFactoryCreateDefaultRendererParams(elementsOrVersion);
        result.audioDeviceId = decoder0.readString(8, false);
        result.renderer = decoder0.readInterfaceRequest(16, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.audioDeviceId, 8, false);
      encoder0.encode((InterfaceRequest) this.renderer, 16, false);
    }
  }

  static final class InterfaceFactoryCreateMediaPlayerRendererParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public MediaPlayerRendererClientExtension clientExtension;
    public InterfaceRequest<Renderer> renderer;
    public InterfaceRequest<MediaPlayerRendererExtension> rendererExtension;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private InterfaceFactoryCreateMediaPlayerRendererParams(int version) {
      super(24, version);
    }

    public InterfaceFactoryCreateMediaPlayerRendererParams() {
      this(0);
    }

    public static InterfaceFactoryCreateMediaPlayerRendererParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static InterfaceFactoryCreateMediaPlayerRendererParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static InterfaceFactoryCreateMediaPlayerRendererParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        InterfaceFactoryCreateMediaPlayerRendererParams result =
            new InterfaceFactoryCreateMediaPlayerRendererParams(elementsOrVersion);
        result.clientExtension =
            (MediaPlayerRendererClientExtension)
                decoder0.readServiceInterface(8, false, MediaPlayerRendererClientExtension.MANAGER);
        result.renderer = decoder0.readInterfaceRequest(16, false);
        result.rendererExtension = decoder0.readInterfaceRequest(20, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.clientExtension, 8, false, MediaPlayerRendererClientExtension.MANAGER);
      encoder0.encode((InterfaceRequest) this.renderer, 16, false);
      encoder0.encode((InterfaceRequest) this.rendererExtension, 20, false);
    }
  }

  static final class InterfaceFactoryCreateFlingingRendererParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public FlingingRendererClientExtension clientExtension;
    public String presentationId;
    public InterfaceRequest<Renderer> renderer;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private InterfaceFactoryCreateFlingingRendererParams(int version) {
      super(32, version);
    }

    public InterfaceFactoryCreateFlingingRendererParams() {
      this(0);
    }

    public static InterfaceFactoryCreateFlingingRendererParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static InterfaceFactoryCreateFlingingRendererParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static InterfaceFactoryCreateFlingingRendererParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        InterfaceFactoryCreateFlingingRendererParams result =
            new InterfaceFactoryCreateFlingingRendererParams(elementsOrVersion);
        result.presentationId = decoder0.readString(8, false);
        result.clientExtension =
            (FlingingRendererClientExtension)
                decoder0.readServiceInterface(16, false, FlingingRendererClientExtension.MANAGER);
        result.renderer = decoder0.readInterfaceRequest(24, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.presentationId, 8, false);
      encoder0.encode(this.clientExtension, 16, false, FlingingRendererClientExtension.MANAGER);
      encoder0.encode((InterfaceRequest) this.renderer, 24, false);
    }
  }

  static final class InterfaceFactoryCreateCdmParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public CdmConfig cdmConfig;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private InterfaceFactoryCreateCdmParams(int version) {
      super(16, version);
    }

    public InterfaceFactoryCreateCdmParams() {
      this(0);
    }

    public static InterfaceFactoryCreateCdmParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static InterfaceFactoryCreateCdmParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static InterfaceFactoryCreateCdmParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        InterfaceFactoryCreateCdmParams result =
            new InterfaceFactoryCreateCdmParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.cdmConfig = CdmConfig.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.cdmConfig, 8, false);
    }
  }

  static final class InterfaceFactoryCreateCdmResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public ContentDecryptionModule cdm;
    public CdmContext cdmContext;
    public String errorMessage;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private InterfaceFactoryCreateCdmResponseParams(int version) {
      super(32, version);
    }

    public InterfaceFactoryCreateCdmResponseParams() {
      this(0);
    }

    public static InterfaceFactoryCreateCdmResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static InterfaceFactoryCreateCdmResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static InterfaceFactoryCreateCdmResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        InterfaceFactoryCreateCdmResponseParams result =
            new InterfaceFactoryCreateCdmResponseParams(elementsOrVersion);
        result.cdm =
            (ContentDecryptionModule)
                decoder0.readServiceInterface(8, true, ContentDecryptionModule.MANAGER);
        Decoder decoder1 = decoder0.readPointer(16, true);
        result.cdmContext = CdmContext.decode(decoder1);
        result.errorMessage = decoder0.readString(24, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.cdm, 8, true, ContentDecryptionModule.MANAGER);
      encoder0.encode((Struct) this.cdmContext, 16, true);
      encoder0.encode(this.errorMessage, 24, false);
    }
  }

  static class InterfaceFactoryCreateCdmResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final InterfaceFactory.CreateCdm_Response mCallback;

    InterfaceFactoryCreateCdmResponseParamsForwardToCallback(
        InterfaceFactory.CreateCdm_Response callback) {
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
        InterfaceFactoryCreateCdmResponseParams response =
            InterfaceFactoryCreateCdmResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.cdm, response.cdmContext, response.errorMessage);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class InterfaceFactoryCreateCdmResponseParamsProxyToResponder
      implements InterfaceFactory.CreateCdm_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    InterfaceFactoryCreateCdmResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(ContentDecryptionModule cdm, CdmContext cdmContext, String errorMessage) {
      InterfaceFactoryCreateCdmResponseParams _response =
          new InterfaceFactoryCreateCdmResponseParams();
      _response.cdm = cdm;
      _response.cdmContext = cdmContext;
      _response.errorMessage = errorMessage;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(6, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
