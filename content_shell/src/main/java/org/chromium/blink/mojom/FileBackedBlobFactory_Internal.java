package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
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

class FileBackedBlobFactory_Internal {
  public static final Interface.Manager<FileBackedBlobFactory, FileBackedBlobFactory.Proxy>
      MANAGER =
          new Interface.Manager<FileBackedBlobFactory, FileBackedBlobFactory.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.FileBackedBlobFactory";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public FileBackedBlobFactory.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, FileBackedBlobFactory impl) {
              return new Stub(core, impl);
            }

            @Override
            public FileBackedBlobFactory[] buildArray(int size) {
              return new FileBackedBlobFactory[size];
            }
          };
  private static final int REGISTER_BLOB_ORDINAL = 0;
  private static final int REGISTER_BLOB_SYNC_ORDINAL = 1;

  FileBackedBlobFactory_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements FileBackedBlobFactory.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void registerBlob(
        InterfaceRequest<Blob> blob, String uuid, String contentType, DataElementFile file) {
      FileBackedBlobFactoryRegisterBlobParams _message =
          new FileBackedBlobFactoryRegisterBlobParams();
      _message.blob = blob;
      _message.uuid = uuid;
      _message.contentType = contentType;
      _message.file = file;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void registerBlobSync(
        InterfaceRequest<Blob> blob,
        String uuid,
        String contentType,
        DataElementFile file,
        RegisterBlobSync_Response callback) {
      FileBackedBlobFactoryRegisterBlobSyncParams _message =
          new FileBackedBlobFactoryRegisterBlobSyncParams();
      _message.blob = blob;
      _message.uuid = uuid;
      _message.contentType = contentType;
      _message.file = file;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new FileBackedBlobFactoryRegisterBlobSyncResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<FileBackedBlobFactory> {
    Stub(Core core, FileBackedBlobFactory impl) {
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
                FileBackedBlobFactory_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            FileBackedBlobFactoryRegisterBlobParams data =
                FileBackedBlobFactoryRegisterBlobParams.deserialize(messageWithHeader.getPayload());
            getImpl().registerBlob(data.blob, data.uuid, data.contentType, data.file);
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
                getCore(), FileBackedBlobFactory_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
          default:
            return false;
          case 1:
            FileBackedBlobFactoryRegisterBlobSyncParams data =
                FileBackedBlobFactoryRegisterBlobSyncParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .registerBlobSync(
                    data.blob,
                    data.uuid,
                    data.contentType,
                    data.file,
                    new FileBackedBlobFactoryRegisterBlobSyncResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class FileBackedBlobFactoryRegisterBlobParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<Blob> blob;
    public String contentType;
    public DataElementFile file;
    public String uuid;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileBackedBlobFactoryRegisterBlobParams(int version) {
      super(40, version);
    }

    public FileBackedBlobFactoryRegisterBlobParams() {
      this(0);
    }

    public static FileBackedBlobFactoryRegisterBlobParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileBackedBlobFactoryRegisterBlobParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileBackedBlobFactoryRegisterBlobParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileBackedBlobFactoryRegisterBlobParams result =
            new FileBackedBlobFactoryRegisterBlobParams(elementsOrVersion);
        result.blob = decoder0.readInterfaceRequest(8, false);
        result.uuid = decoder0.readString(16, false);
        result.contentType = decoder0.readString(24, false);
        Decoder decoder1 = decoder0.readPointer(32, false);
        result.file = DataElementFile.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.blob, 8, false);
      encoder0.encode(this.uuid, 16, false);
      encoder0.encode(this.contentType, 24, false);
      encoder0.encode((Struct) this.file, 32, false);
    }
  }

  static final class FileBackedBlobFactoryRegisterBlobSyncParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<Blob> blob;
    public String contentType;
    public DataElementFile file;
    public String uuid;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileBackedBlobFactoryRegisterBlobSyncParams(int version) {
      super(40, version);
    }

    public FileBackedBlobFactoryRegisterBlobSyncParams() {
      this(0);
    }

    public static FileBackedBlobFactoryRegisterBlobSyncParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileBackedBlobFactoryRegisterBlobSyncParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileBackedBlobFactoryRegisterBlobSyncParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileBackedBlobFactoryRegisterBlobSyncParams result =
            new FileBackedBlobFactoryRegisterBlobSyncParams(elementsOrVersion);
        result.blob = decoder0.readInterfaceRequest(8, false);
        result.uuid = decoder0.readString(16, false);
        result.contentType = decoder0.readString(24, false);
        Decoder decoder1 = decoder0.readPointer(32, false);
        result.file = DataElementFile.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.blob, 8, false);
      encoder0.encode(this.uuid, 16, false);
      encoder0.encode(this.contentType, 24, false);
      encoder0.encode((Struct) this.file, 32, false);
    }
  }

  static final class FileBackedBlobFactoryRegisterBlobSyncResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileBackedBlobFactoryRegisterBlobSyncResponseParams(int version) {
      super(8, version);
    }

    public FileBackedBlobFactoryRegisterBlobSyncResponseParams() {
      this(0);
    }

    public static FileBackedBlobFactoryRegisterBlobSyncResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileBackedBlobFactoryRegisterBlobSyncResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileBackedBlobFactoryRegisterBlobSyncResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileBackedBlobFactoryRegisterBlobSyncResponseParams result =
            new FileBackedBlobFactoryRegisterBlobSyncResponseParams(elementsOrVersion);
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

  static class FileBackedBlobFactoryRegisterBlobSyncResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FileBackedBlobFactory.RegisterBlobSync_Response mCallback;

    FileBackedBlobFactoryRegisterBlobSyncResponseParamsForwardToCallback(
        FileBackedBlobFactory.RegisterBlobSync_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(1, 6)) {
          return false;
        }
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FileBackedBlobFactoryRegisterBlobSyncResponseParamsProxyToResponder
      implements FileBackedBlobFactory.RegisterBlobSync_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FileBackedBlobFactoryRegisterBlobSyncResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      FileBackedBlobFactoryRegisterBlobSyncResponseParams _response =
          new FileBackedBlobFactoryRegisterBlobSyncResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
