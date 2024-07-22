package org.chromium.viz.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.BufferFormat;
import org.chromium.gfx.mojom.BufferUsage;
import org.chromium.gfx.mojom.GpuMemoryBufferHandle;
import org.chromium.gfx.mojom.GpuMemoryBufferId;
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
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;
import org.chromium.mojo_base.mojom.UnsafeSharedMemoryRegion;

class GpuMemoryBufferFactory_Internal {
  private static final int COPY_GPU_MEMORY_BUFFER_ORDINAL = 2;
  private static final int CREATE_GPU_MEMORY_BUFFER_ORDINAL = 0;
  private static final int DESTROY_GPU_MEMORY_BUFFER_ORDINAL = 1;
  public static final Interface.Manager<GpuMemoryBufferFactory, GpuMemoryBufferFactory.Proxy>
      MANAGER =
          new Interface.Manager<GpuMemoryBufferFactory, GpuMemoryBufferFactory.Proxy>() {
            @Override
            public String getName() {
              return "viz.mojom.GpuMemoryBufferFactory";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public GpuMemoryBufferFactory.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, GpuMemoryBufferFactory impl) {
              return new Stub(core, impl);
            }

            @Override
            public GpuMemoryBufferFactory[] buildArray(int size) {
              return new GpuMemoryBufferFactory[size];
            }
          };

  GpuMemoryBufferFactory_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements GpuMemoryBufferFactory.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void createGpuMemoryBuffer(
        GpuMemoryBufferId id,
        Size size,
        int format,
        int usage,
        CreateGpuMemoryBuffer_Response callback) {
      GpuMemoryBufferFactoryCreateGpuMemoryBufferParams _message =
          new GpuMemoryBufferFactoryCreateGpuMemoryBufferParams();
      _message.id = id;
      _message.size = size;
      _message.format = format;
      _message.usage = usage;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new GpuMemoryBufferFactoryCreateGpuMemoryBufferResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void destroyGpuMemoryBuffer(GpuMemoryBufferId id) {
      GpuMemoryBufferFactoryDestroyGpuMemoryBufferParams _message =
          new GpuMemoryBufferFactoryDestroyGpuMemoryBufferParams();
      _message.id = id;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void copyGpuMemoryBuffer(
        GpuMemoryBufferHandle bufferHandle,
        UnsafeSharedMemoryRegion sharedMemory,
        CopyGpuMemoryBuffer_Response callback) {
      GpuMemoryBufferFactoryCopyGpuMemoryBufferParams _message =
          new GpuMemoryBufferFactoryCopyGpuMemoryBufferParams();
      _message.bufferHandle = bufferHandle;
      _message.sharedMemory = sharedMemory;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new GpuMemoryBufferFactoryCopyGpuMemoryBufferResponseParamsForwardToCallback(
                  callback));
    }
  }

  public static final class Stub extends Interface.Stub<GpuMemoryBufferFactory> {
    Stub(Core core, GpuMemoryBufferFactory impl) {
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
                GpuMemoryBufferFactory_Internal.MANAGER, messageWithHeader);
          case 1:
            GpuMemoryBufferFactoryDestroyGpuMemoryBufferParams data =
                GpuMemoryBufferFactoryDestroyGpuMemoryBufferParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().destroyGpuMemoryBuffer(data.id);
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
                getCore(), GpuMemoryBufferFactory_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            GpuMemoryBufferFactoryCreateGpuMemoryBufferParams data =
                GpuMemoryBufferFactoryCreateGpuMemoryBufferParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .createGpuMemoryBuffer(
                    data.id,
                    data.size,
                    data.format,
                    data.usage,
                    new GpuMemoryBufferFactoryCreateGpuMemoryBufferResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
          default:
            return false;
          case 2:
            GpuMemoryBufferFactoryCopyGpuMemoryBufferParams data2 =
                GpuMemoryBufferFactoryCopyGpuMemoryBufferParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .copyGpuMemoryBuffer(
                    data2.bufferHandle,
                    data2.sharedMemory,
                    new GpuMemoryBufferFactoryCopyGpuMemoryBufferResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class GpuMemoryBufferFactoryCreateGpuMemoryBufferParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public int format;
    public GpuMemoryBufferId id;
    public Size size;
    public int usage;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private GpuMemoryBufferFactoryCreateGpuMemoryBufferParams(int version) {
      super(32, version);
    }

    public GpuMemoryBufferFactoryCreateGpuMemoryBufferParams() {
      this(0);
    }

    public static GpuMemoryBufferFactoryCreateGpuMemoryBufferParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static GpuMemoryBufferFactoryCreateGpuMemoryBufferParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static GpuMemoryBufferFactoryCreateGpuMemoryBufferParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        GpuMemoryBufferFactoryCreateGpuMemoryBufferParams result =
            new GpuMemoryBufferFactoryCreateGpuMemoryBufferParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.id = GpuMemoryBufferId.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.size = Size.decode(decoder12);
        int readInt = decoder0.readInt(24);
        result.format = readInt;
        BufferFormat.validate(readInt);
        result.format = BufferFormat.toKnownValue(result.format);
        int readInt2 = decoder0.readInt(28);
        result.usage = readInt2;
        BufferUsage.validate(readInt2);
        result.usage = BufferUsage.toKnownValue(result.usage);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.id, 8, false);
      encoder0.encode((Struct) this.size, 16, false);
      encoder0.encode(this.format, 24);
      encoder0.encode(this.usage, 28);
    }
  }

  static final class GpuMemoryBufferFactoryCreateGpuMemoryBufferResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public GpuMemoryBufferHandle bufferHandle;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private GpuMemoryBufferFactoryCreateGpuMemoryBufferResponseParams(int version) {
      super(16, version);
    }

    public GpuMemoryBufferFactoryCreateGpuMemoryBufferResponseParams() {
      this(0);
    }

    public static GpuMemoryBufferFactoryCreateGpuMemoryBufferResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static GpuMemoryBufferFactoryCreateGpuMemoryBufferResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static GpuMemoryBufferFactoryCreateGpuMemoryBufferResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        GpuMemoryBufferFactoryCreateGpuMemoryBufferResponseParams result =
            new GpuMemoryBufferFactoryCreateGpuMemoryBufferResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.bufferHandle = GpuMemoryBufferHandle.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.bufferHandle, 8, false);
    }
  }

  static class GpuMemoryBufferFactoryCreateGpuMemoryBufferResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final GpuMemoryBufferFactory.CreateGpuMemoryBuffer_Response mCallback;

    GpuMemoryBufferFactoryCreateGpuMemoryBufferResponseParamsForwardToCallback(
        GpuMemoryBufferFactory.CreateGpuMemoryBuffer_Response callback) {
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
        GpuMemoryBufferFactoryCreateGpuMemoryBufferResponseParams response =
            GpuMemoryBufferFactoryCreateGpuMemoryBufferResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.bufferHandle);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class GpuMemoryBufferFactoryCreateGpuMemoryBufferResponseParamsProxyToResponder
      implements GpuMemoryBufferFactory.CreateGpuMemoryBuffer_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    GpuMemoryBufferFactoryCreateGpuMemoryBufferResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(GpuMemoryBufferHandle bufferHandle) {
      GpuMemoryBufferFactoryCreateGpuMemoryBufferResponseParams _response =
          new GpuMemoryBufferFactoryCreateGpuMemoryBufferResponseParams();
      _response.bufferHandle = bufferHandle;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class GpuMemoryBufferFactoryDestroyGpuMemoryBufferParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public GpuMemoryBufferId id;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private GpuMemoryBufferFactoryDestroyGpuMemoryBufferParams(int version) {
      super(16, version);
    }

    public GpuMemoryBufferFactoryDestroyGpuMemoryBufferParams() {
      this(0);
    }

    public static GpuMemoryBufferFactoryDestroyGpuMemoryBufferParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static GpuMemoryBufferFactoryDestroyGpuMemoryBufferParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static GpuMemoryBufferFactoryDestroyGpuMemoryBufferParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        GpuMemoryBufferFactoryDestroyGpuMemoryBufferParams result =
            new GpuMemoryBufferFactoryDestroyGpuMemoryBufferParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.id = GpuMemoryBufferId.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.id, 8, false);
    }
  }

  static final class GpuMemoryBufferFactoryCopyGpuMemoryBufferParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public GpuMemoryBufferHandle bufferHandle;
    public UnsafeSharedMemoryRegion sharedMemory;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private GpuMemoryBufferFactoryCopyGpuMemoryBufferParams(int version) {
      super(24, version);
    }

    public GpuMemoryBufferFactoryCopyGpuMemoryBufferParams() {
      this(0);
    }

    public static GpuMemoryBufferFactoryCopyGpuMemoryBufferParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static GpuMemoryBufferFactoryCopyGpuMemoryBufferParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static GpuMemoryBufferFactoryCopyGpuMemoryBufferParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        GpuMemoryBufferFactoryCopyGpuMemoryBufferParams result =
            new GpuMemoryBufferFactoryCopyGpuMemoryBufferParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.bufferHandle = GpuMemoryBufferHandle.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.sharedMemory = UnsafeSharedMemoryRegion.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.bufferHandle, 8, false);
      encoder0.encode((Struct) this.sharedMemory, 16, false);
    }
  }

  static final class GpuMemoryBufferFactoryCopyGpuMemoryBufferResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean success;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private GpuMemoryBufferFactoryCopyGpuMemoryBufferResponseParams(int version) {
      super(16, version);
    }

    public GpuMemoryBufferFactoryCopyGpuMemoryBufferResponseParams() {
      this(0);
    }

    public static GpuMemoryBufferFactoryCopyGpuMemoryBufferResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static GpuMemoryBufferFactoryCopyGpuMemoryBufferResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static GpuMemoryBufferFactoryCopyGpuMemoryBufferResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        GpuMemoryBufferFactoryCopyGpuMemoryBufferResponseParams result =
            new GpuMemoryBufferFactoryCopyGpuMemoryBufferResponseParams(elementsOrVersion);
        result.success = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.success, 8, 0);
    }
  }

  static class GpuMemoryBufferFactoryCopyGpuMemoryBufferResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final GpuMemoryBufferFactory.CopyGpuMemoryBuffer_Response mCallback;

    GpuMemoryBufferFactoryCopyGpuMemoryBufferResponseParamsForwardToCallback(
        GpuMemoryBufferFactory.CopyGpuMemoryBuffer_Response callback) {
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
        GpuMemoryBufferFactoryCopyGpuMemoryBufferResponseParams response =
            GpuMemoryBufferFactoryCopyGpuMemoryBufferResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.success);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class GpuMemoryBufferFactoryCopyGpuMemoryBufferResponseParamsProxyToResponder
      implements GpuMemoryBufferFactory.CopyGpuMemoryBuffer_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    GpuMemoryBufferFactoryCopyGpuMemoryBufferResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean success) {
      GpuMemoryBufferFactoryCopyGpuMemoryBufferResponseParams _response =
          new GpuMemoryBufferFactoryCopyGpuMemoryBufferResponseParams();
      _response.success = success;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
