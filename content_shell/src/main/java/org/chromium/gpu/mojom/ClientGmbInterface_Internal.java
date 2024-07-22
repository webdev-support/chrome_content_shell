package org.chromium.gpu.mojom;

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

class ClientGmbInterface_Internal {
  private static final int COPY_GPU_MEMORY_BUFFER_ORDINAL = 2;
  private static final int CREATE_GPU_MEMORY_BUFFER_ORDINAL = 0;
  private static final int DESTROY_GPU_MEMORY_BUFFER_ORDINAL = 1;
  public static final Interface.Manager<ClientGmbInterface, ClientGmbInterface.Proxy> MANAGER =
      new Interface.Manager<ClientGmbInterface, ClientGmbInterface.Proxy>() {
        @Override
        public String getName() {
          return "gpu.mojom.ClientGmbInterface";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public ClientGmbInterface.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, ClientGmbInterface impl) {
          return new Stub(core, impl);
        }

        @Override
        public ClientGmbInterface[] buildArray(int size) {
          return new ClientGmbInterface[size];
        }
      };

  ClientGmbInterface_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements ClientGmbInterface.Proxy {
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
        SurfaceHandle surfaceHandle,
        CreateGpuMemoryBuffer_Response callback) {
      ClientGmbInterfaceCreateGpuMemoryBufferParams _message =
          new ClientGmbInterfaceCreateGpuMemoryBufferParams();
      _message.id = id;
      _message.size = size;
      _message.format = format;
      _message.usage = usage;
      _message.surfaceHandle = surfaceHandle;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new ClientGmbInterfaceCreateGpuMemoryBufferResponseParamsForwardToCallback(callback));
    }

    @Override
    public void destroyGpuMemoryBuffer(GpuMemoryBufferId id) {
      ClientGmbInterfaceDestroyGpuMemoryBufferParams _message =
          new ClientGmbInterfaceDestroyGpuMemoryBufferParams();
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
      ClientGmbInterfaceCopyGpuMemoryBufferParams _message =
          new ClientGmbInterfaceCopyGpuMemoryBufferParams();
      _message.bufferHandle = bufferHandle;
      _message.sharedMemory = sharedMemory;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new ClientGmbInterfaceCopyGpuMemoryBufferResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<ClientGmbInterface> {
    Stub(Core core, ClientGmbInterface impl) {
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
                ClientGmbInterface_Internal.MANAGER, messageWithHeader);
          case 1:
            ClientGmbInterfaceDestroyGpuMemoryBufferParams data =
                ClientGmbInterfaceDestroyGpuMemoryBufferParams.deserialize(
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
                getCore(), ClientGmbInterface_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            ClientGmbInterfaceCreateGpuMemoryBufferParams data =
                ClientGmbInterfaceCreateGpuMemoryBufferParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .createGpuMemoryBuffer(
                    data.id,
                    data.size,
                    data.format,
                    data.usage,
                    data.surfaceHandle,
                    new ClientGmbInterfaceCreateGpuMemoryBufferResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
          default:
            return false;
          case 2:
            ClientGmbInterfaceCopyGpuMemoryBufferParams data2 =
                ClientGmbInterfaceCopyGpuMemoryBufferParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .copyGpuMemoryBuffer(
                    data2.bufferHandle,
                    data2.sharedMemory,
                    new ClientGmbInterfaceCopyGpuMemoryBufferResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class ClientGmbInterfaceCreateGpuMemoryBufferParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public int format;
    public GpuMemoryBufferId id;
    public Size size;
    public SurfaceHandle surfaceHandle;
    public int usage;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ClientGmbInterfaceCreateGpuMemoryBufferParams(int version) {
      super(40, version);
    }

    public ClientGmbInterfaceCreateGpuMemoryBufferParams() {
      this(0);
    }

    public static ClientGmbInterfaceCreateGpuMemoryBufferParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ClientGmbInterfaceCreateGpuMemoryBufferParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ClientGmbInterfaceCreateGpuMemoryBufferParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ClientGmbInterfaceCreateGpuMemoryBufferParams result =
            new ClientGmbInterfaceCreateGpuMemoryBufferParams(elementsOrVersion);
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
        Decoder decoder13 = decoder0.readPointer(32, false);
        result.surfaceHandle = SurfaceHandle.decode(decoder13);
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
      encoder0.encode((Struct) this.surfaceHandle, 32, false);
    }
  }

  static final class ClientGmbInterfaceCreateGpuMemoryBufferResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public GpuMemoryBufferHandle bufferHandle;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ClientGmbInterfaceCreateGpuMemoryBufferResponseParams(int version) {
      super(16, version);
    }

    public ClientGmbInterfaceCreateGpuMemoryBufferResponseParams() {
      this(0);
    }

    public static ClientGmbInterfaceCreateGpuMemoryBufferResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ClientGmbInterfaceCreateGpuMemoryBufferResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ClientGmbInterfaceCreateGpuMemoryBufferResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ClientGmbInterfaceCreateGpuMemoryBufferResponseParams result =
            new ClientGmbInterfaceCreateGpuMemoryBufferResponseParams(elementsOrVersion);
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

  static class ClientGmbInterfaceCreateGpuMemoryBufferResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ClientGmbInterface.CreateGpuMemoryBuffer_Response mCallback;

    ClientGmbInterfaceCreateGpuMemoryBufferResponseParamsForwardToCallback(
        ClientGmbInterface.CreateGpuMemoryBuffer_Response callback) {
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
        ClientGmbInterfaceCreateGpuMemoryBufferResponseParams response =
            ClientGmbInterfaceCreateGpuMemoryBufferResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.bufferHandle);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ClientGmbInterfaceCreateGpuMemoryBufferResponseParamsProxyToResponder
      implements ClientGmbInterface.CreateGpuMemoryBuffer_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ClientGmbInterfaceCreateGpuMemoryBufferResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(GpuMemoryBufferHandle bufferHandle) {
      ClientGmbInterfaceCreateGpuMemoryBufferResponseParams _response =
          new ClientGmbInterfaceCreateGpuMemoryBufferResponseParams();
      _response.bufferHandle = bufferHandle;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ClientGmbInterfaceDestroyGpuMemoryBufferParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public GpuMemoryBufferId id;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ClientGmbInterfaceDestroyGpuMemoryBufferParams(int version) {
      super(16, version);
    }

    public ClientGmbInterfaceDestroyGpuMemoryBufferParams() {
      this(0);
    }

    public static ClientGmbInterfaceDestroyGpuMemoryBufferParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ClientGmbInterfaceDestroyGpuMemoryBufferParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ClientGmbInterfaceDestroyGpuMemoryBufferParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ClientGmbInterfaceDestroyGpuMemoryBufferParams result =
            new ClientGmbInterfaceDestroyGpuMemoryBufferParams(elementsOrVersion);
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

  static final class ClientGmbInterfaceCopyGpuMemoryBufferParams extends Struct {
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

    private ClientGmbInterfaceCopyGpuMemoryBufferParams(int version) {
      super(24, version);
    }

    public ClientGmbInterfaceCopyGpuMemoryBufferParams() {
      this(0);
    }

    public static ClientGmbInterfaceCopyGpuMemoryBufferParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ClientGmbInterfaceCopyGpuMemoryBufferParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ClientGmbInterfaceCopyGpuMemoryBufferParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ClientGmbInterfaceCopyGpuMemoryBufferParams result =
            new ClientGmbInterfaceCopyGpuMemoryBufferParams(elementsOrVersion);
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

  static final class ClientGmbInterfaceCopyGpuMemoryBufferResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean success;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ClientGmbInterfaceCopyGpuMemoryBufferResponseParams(int version) {
      super(16, version);
    }

    public ClientGmbInterfaceCopyGpuMemoryBufferResponseParams() {
      this(0);
    }

    public static ClientGmbInterfaceCopyGpuMemoryBufferResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ClientGmbInterfaceCopyGpuMemoryBufferResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ClientGmbInterfaceCopyGpuMemoryBufferResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ClientGmbInterfaceCopyGpuMemoryBufferResponseParams result =
            new ClientGmbInterfaceCopyGpuMemoryBufferResponseParams(elementsOrVersion);
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

  static class ClientGmbInterfaceCopyGpuMemoryBufferResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ClientGmbInterface.CopyGpuMemoryBuffer_Response mCallback;

    ClientGmbInterfaceCopyGpuMemoryBufferResponseParamsForwardToCallback(
        ClientGmbInterface.CopyGpuMemoryBuffer_Response callback) {
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
        ClientGmbInterfaceCopyGpuMemoryBufferResponseParams response =
            ClientGmbInterfaceCopyGpuMemoryBufferResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.success);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ClientGmbInterfaceCopyGpuMemoryBufferResponseParamsProxyToResponder
      implements ClientGmbInterface.CopyGpuMemoryBuffer_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ClientGmbInterfaceCopyGpuMemoryBufferResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean success) {
      ClientGmbInterfaceCopyGpuMemoryBufferResponseParams _response =
          new ClientGmbInterfaceCopyGpuMemoryBufferResponseParams();
      _response.success = success;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
