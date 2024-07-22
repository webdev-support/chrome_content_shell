package org.chromium.viz.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gpu.mojom.ClientGmbInterface;
import org.chromium.gpu.mojom.GpuFeatureInfo;
import org.chromium.gpu.mojom.GpuInfo;
import org.chromium.gpu.mojom.SharedImageCapabilities;
import org.chromium.media.mojom.VideoEncodeAcceleratorProvider;
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
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.InvalidHandle;
import org.chromium.mojo.system.MessagePipeHandle;

class Gpu_Internal {
  private static final int CREATE_CLIENT_GPU_MEMORY_BUFFER_FACTORY_ORDINAL = 1;
  private static final int CREATE_GPU_MEMORY_BUFFER_FACTORY_ORDINAL = 0;
  private static final int CREATE_VIDEO_ENCODE_ACCELERATOR_PROVIDER_ORDINAL = 3;
  private static final int ESTABLISH_GPU_CHANNEL_ORDINAL = 2;
  public static final Interface.Manager<Gpu, Gpu.Proxy> MANAGER =
      new Interface.Manager<Gpu, Gpu.Proxy>() {
        @Override
        public String getName() {
          return "viz.mojom.Gpu";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public Gpu.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, Gpu impl) {
          return new Stub(core, impl);
        }

        @Override
        public Gpu[] buildArray(int size) {
          return new Gpu[size];
        }
      };

  Gpu_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements Gpu.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void createGpuMemoryBufferFactory(InterfaceRequest<GpuMemoryBufferFactory> receiver) {
      GpuCreateGpuMemoryBufferFactoryParams _message = new GpuCreateGpuMemoryBufferFactoryParams();
      _message.receiver = receiver;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void createClientGpuMemoryBufferFactory(InterfaceRequest<ClientGmbInterface> receiver) {
      GpuCreateClientGpuMemoryBufferFactoryParams _message =
          new GpuCreateClientGpuMemoryBufferFactoryParams();
      _message.receiver = receiver;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void establishGpuChannel(EstablishGpuChannel_Response callback) {
      GpuEstablishGpuChannelParams _message = new GpuEstablishGpuChannelParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new GpuEstablishGpuChannelResponseParamsForwardToCallback(callback));
    }

    @Override
    public void createVideoEncodeAcceleratorProvider(
        InterfaceRequest<VideoEncodeAcceleratorProvider> veaProvider) {
      GpuCreateVideoEncodeAcceleratorProviderParams _message =
          new GpuCreateVideoEncodeAcceleratorProviderParams();
      _message.veaProvider = veaProvider;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }
  }

  public static final class Stub extends Interface.Stub<Gpu> {
    Stub(Core core, Gpu impl) {
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
                Gpu_Internal.MANAGER, messageWithHeader);
          case -1:
          case 2:
          default:
            return false;
          case 0:
            GpuCreateGpuMemoryBufferFactoryParams data =
                GpuCreateGpuMemoryBufferFactoryParams.deserialize(messageWithHeader.getPayload());
            getImpl().createGpuMemoryBufferFactory(data.receiver);
            return true;
          case 1:
            GpuCreateClientGpuMemoryBufferFactoryParams data2 =
                GpuCreateClientGpuMemoryBufferFactoryParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().createClientGpuMemoryBufferFactory(data2.receiver);
            return true;
          case 3:
            GpuCreateVideoEncodeAcceleratorProviderParams data3 =
                GpuCreateVideoEncodeAcceleratorProviderParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().createVideoEncodeAcceleratorProvider(data3.veaProvider);
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
                getCore(), Gpu_Internal.MANAGER, messageWithHeader, receiver);
          case 2:
            GpuEstablishGpuChannelParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .establishGpuChannel(
                    new GpuEstablishGpuChannelResponseParamsProxyToResponder(
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

  static final class GpuCreateGpuMemoryBufferFactoryParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<GpuMemoryBufferFactory> receiver;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private GpuCreateGpuMemoryBufferFactoryParams(int version) {
      super(16, version);
    }

    public GpuCreateGpuMemoryBufferFactoryParams() {
      this(0);
    }

    public static GpuCreateGpuMemoryBufferFactoryParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static GpuCreateGpuMemoryBufferFactoryParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static GpuCreateGpuMemoryBufferFactoryParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        GpuCreateGpuMemoryBufferFactoryParams result =
            new GpuCreateGpuMemoryBufferFactoryParams(elementsOrVersion);
        result.receiver = decoder0.readInterfaceRequest(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.receiver, 8, false);
    }
  }

  static final class GpuCreateClientGpuMemoryBufferFactoryParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<ClientGmbInterface> receiver;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private GpuCreateClientGpuMemoryBufferFactoryParams(int version) {
      super(16, version);
    }

    public GpuCreateClientGpuMemoryBufferFactoryParams() {
      this(0);
    }

    public static GpuCreateClientGpuMemoryBufferFactoryParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static GpuCreateClientGpuMemoryBufferFactoryParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static GpuCreateClientGpuMemoryBufferFactoryParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        GpuCreateClientGpuMemoryBufferFactoryParams result =
            new GpuCreateClientGpuMemoryBufferFactoryParams(elementsOrVersion);
        result.receiver = decoder0.readInterfaceRequest(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.receiver, 8, false);
    }
  }

  static final class GpuEstablishGpuChannelParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private GpuEstablishGpuChannelParams(int version) {
      super(8, version);
    }

    public GpuEstablishGpuChannelParams() {
      this(0);
    }

    public static GpuEstablishGpuChannelParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static GpuEstablishGpuChannelParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static GpuEstablishGpuChannelParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        GpuEstablishGpuChannelParams result = new GpuEstablishGpuChannelParams(elementsOrVersion);
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

  static final class GpuEstablishGpuChannelResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public MessagePipeHandle channelHandle;
    public int clientId;
    public GpuFeatureInfo gpuFeatureInfo;
    public GpuInfo gpuInfo;
    public SharedImageCapabilities sharedImageCapabilities;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private GpuEstablishGpuChannelResponseParams(int version) {
      super(40, version);
      this.channelHandle = InvalidHandle.INSTANCE;
    }

    public GpuEstablishGpuChannelResponseParams() {
      this(0);
    }

    public static GpuEstablishGpuChannelResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static GpuEstablishGpuChannelResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static GpuEstablishGpuChannelResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        GpuEstablishGpuChannelResponseParams result =
            new GpuEstablishGpuChannelResponseParams(elementsOrVersion);
        result.clientId = decoder0.readInt(8);
        result.channelHandle = decoder0.readMessagePipeHandle(12, true);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.gpuInfo = GpuInfo.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(24, false);
        result.gpuFeatureInfo = GpuFeatureInfo.decode(decoder12);
        Decoder decoder13 = decoder0.readPointer(32, false);
        result.sharedImageCapabilities = SharedImageCapabilities.decode(decoder13);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.clientId, 8);
      encoder0.encode((Handle) this.channelHandle, 12, true);
      encoder0.encode((Struct) this.gpuInfo, 16, false);
      encoder0.encode((Struct) this.gpuFeatureInfo, 24, false);
      encoder0.encode((Struct) this.sharedImageCapabilities, 32, false);
    }
  }

  static class GpuEstablishGpuChannelResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final Gpu.EstablishGpuChannel_Response mCallback;

    GpuEstablishGpuChannelResponseParamsForwardToCallback(
        Gpu.EstablishGpuChannel_Response callback) {
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
        GpuEstablishGpuChannelResponseParams response =
            GpuEstablishGpuChannelResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(
            response.clientId,
            response.channelHandle,
            response.gpuInfo,
            response.gpuFeatureInfo,
            response.sharedImageCapabilities);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class GpuEstablishGpuChannelResponseParamsProxyToResponder
      implements Gpu.EstablishGpuChannel_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    GpuEstablishGpuChannelResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(
        int clientId,
        MessagePipeHandle channelHandle,
        GpuInfo gpuInfo,
        GpuFeatureInfo gpuFeatureInfo,
        SharedImageCapabilities sharedImageCapabilities) {
      GpuEstablishGpuChannelResponseParams _response = new GpuEstablishGpuChannelResponseParams();
      _response.clientId = clientId;
      _response.channelHandle = channelHandle;
      _response.gpuInfo = gpuInfo;
      _response.gpuFeatureInfo = gpuFeatureInfo;
      _response.sharedImageCapabilities = sharedImageCapabilities;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class GpuCreateVideoEncodeAcceleratorProviderParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<VideoEncodeAcceleratorProvider> veaProvider;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private GpuCreateVideoEncodeAcceleratorProviderParams(int version) {
      super(16, version);
    }

    public GpuCreateVideoEncodeAcceleratorProviderParams() {
      this(0);
    }

    public static GpuCreateVideoEncodeAcceleratorProviderParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static GpuCreateVideoEncodeAcceleratorProviderParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static GpuCreateVideoEncodeAcceleratorProviderParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        GpuCreateVideoEncodeAcceleratorProviderParams result =
            new GpuCreateVideoEncodeAcceleratorProviderParams(elementsOrVersion);
        result.veaProvider = decoder0.readInterfaceRequest(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.veaProvider, 8, false);
    }
  }
}
