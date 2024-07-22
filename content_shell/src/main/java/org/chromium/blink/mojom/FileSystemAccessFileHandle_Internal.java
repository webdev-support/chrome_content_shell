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
import org.chromium.mojo.bindings.Union;
import org.chromium.mojo.system.Core;
import org.chromium.mojo_base.mojom.FileInfo;

class FileSystemAccessFileHandle_Internal {
  private static final int AS_BLOB_ORDINAL = 2;
  private static final int CREATE_FILE_WRITER_ORDINAL = 3;
  private static final int GET_CLOUD_IDENTIFIERS_ORDINAL = 11;
  private static final int GET_PERMISSION_STATUS_ORDINAL = 0;
  private static final int GET_UNIQUE_ID_ORDINAL = 10;
  private static final int IS_SAME_ENTRY_ORDINAL = 8;
  public static final Interface.Manager<
          FileSystemAccessFileHandle, FileSystemAccessFileHandle.Proxy>
      MANAGER =
          new Interface.Manager<FileSystemAccessFileHandle, FileSystemAccessFileHandle.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.FileSystemAccessFileHandle";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public FileSystemAccessFileHandle.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, FileSystemAccessFileHandle impl) {
              return new Stub(core, impl);
            }

            @Override
            public FileSystemAccessFileHandle[] buildArray(int size) {
              return new FileSystemAccessFileHandle[size];
            }
          };
  private static final int MOVE_ORDINAL = 5;
  private static final int OPEN_ACCESS_HANDLE_ORDINAL = 7;
  private static final int REMOVE_ORDINAL = 6;
  private static final int RENAME_ORDINAL = 4;
  private static final int REQUEST_PERMISSION_ORDINAL = 1;
  private static final int TRANSFER_ORDINAL = 9;

  FileSystemAccessFileHandle_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements FileSystemAccessFileHandle.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void getPermissionStatus(boolean writable, GetPermissionStatus_Response callback) {
      FileSystemAccessFileHandleGetPermissionStatusParams _message =
          new FileSystemAccessFileHandleGetPermissionStatusParams();
      _message.writable = writable;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new FileSystemAccessFileHandleGetPermissionStatusResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void requestPermission(boolean writable, RequestPermission_Response callback) {
      FileSystemAccessFileHandleRequestPermissionParams _message =
          new FileSystemAccessFileHandleRequestPermissionParams();
      _message.writable = writable;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new FileSystemAccessFileHandleRequestPermissionResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void asBlob(AsBlob_Response callback) {
      FileSystemAccessFileHandleAsBlobParams _message =
          new FileSystemAccessFileHandleAsBlobParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new FileSystemAccessFileHandleAsBlobResponseParamsForwardToCallback(callback));
    }

    @Override
    public void createFileWriter(
        boolean keepExistingData, boolean autoClose, int mode, CreateFileWriter_Response callback) {
      FileSystemAccessFileHandleCreateFileWriterParams _message =
          new FileSystemAccessFileHandleCreateFileWriterParams();
      _message.keepExistingData = keepExistingData;
      _message.autoClose = autoClose;
      _message.mode = mode;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)),
              new FileSystemAccessFileHandleCreateFileWriterResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void rename(String newEntryName, Rename_Response callback) {
      FileSystemAccessFileHandleRenameParams _message =
          new FileSystemAccessFileHandleRenameParams();
      _message.newEntryName = newEntryName;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)),
              new FileSystemAccessFileHandleRenameResponseParamsForwardToCallback(callback));
    }

    @Override
    public void move(
        FileSystemAccessTransferToken destinationDirectory,
        String newEntryName,
        Move_Response callback) {
      FileSystemAccessFileHandleMoveParams _message = new FileSystemAccessFileHandleMoveParams();
      _message.destinationDirectory = destinationDirectory;
      _message.newEntryName = newEntryName;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(5, 1, 0L)),
              new FileSystemAccessFileHandleMoveResponseParamsForwardToCallback(callback));
    }

    @Override
    public void remove(Remove_Response callback) {
      FileSystemAccessFileHandleRemoveParams _message =
          new FileSystemAccessFileHandleRemoveParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(6, 1, 0L)),
              new FileSystemAccessFileHandleRemoveResponseParamsForwardToCallback(callback));
    }

    @Override
    public void openAccessHandle(int mode, OpenAccessHandle_Response callback) {
      FileSystemAccessFileHandleOpenAccessHandleParams _message =
          new FileSystemAccessFileHandleOpenAccessHandleParams();
      _message.mode = mode;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(7, 1, 0L)),
              new FileSystemAccessFileHandleOpenAccessHandleResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void isSameEntry(FileSystemAccessTransferToken other, IsSameEntry_Response callback) {
      FileSystemAccessFileHandleIsSameEntryParams _message =
          new FileSystemAccessFileHandleIsSameEntryParams();
      _message.other = other;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(8, 1, 0L)),
              new FileSystemAccessFileHandleIsSameEntryResponseParamsForwardToCallback(callback));
    }

    @Override
    public void transfer(InterfaceRequest<FileSystemAccessTransferToken> token) {
      FileSystemAccessFileHandleTransferParams _message =
          new FileSystemAccessFileHandleTransferParams();
      _message.token = token;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(9)));
    }

    @Override
    public void getUniqueId(GetUniqueId_Response callback) {
      FileSystemAccessFileHandleGetUniqueIdParams _message =
          new FileSystemAccessFileHandleGetUniqueIdParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(10, 1, 0L)),
              new FileSystemAccessFileHandleGetUniqueIdResponseParamsForwardToCallback(callback));
    }

    @Override
    public void getCloudIdentifiers(GetCloudIdentifiers_Response callback) {
      FileSystemAccessFileHandleGetCloudIdentifiersParams _message =
          new FileSystemAccessFileHandleGetCloudIdentifiersParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(11, 1, 0L)),
              new FileSystemAccessFileHandleGetCloudIdentifiersResponseParamsForwardToCallback(
                  callback));
    }
  }

  public static final class Stub extends Interface.Stub<FileSystemAccessFileHandle> {
    Stub(Core core, FileSystemAccessFileHandle impl) {
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
                FileSystemAccessFileHandle_Internal.MANAGER, messageWithHeader);
          case 9:
            FileSystemAccessFileHandleTransferParams data =
                FileSystemAccessFileHandleTransferParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().transfer(data.token);
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
                getCore(),
                FileSystemAccessFileHandle_Internal.MANAGER,
                messageWithHeader,
                receiver);
          case 0:
            FileSystemAccessFileHandleGetPermissionStatusParams data =
                FileSystemAccessFileHandleGetPermissionStatusParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .getPermissionStatus(
                    data.writable,
                    new FileSystemAccessFileHandleGetPermissionStatusResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
            FileSystemAccessFileHandleRequestPermissionParams data2 =
                FileSystemAccessFileHandleRequestPermissionParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .requestPermission(
                    data2.writable,
                    new FileSystemAccessFileHandleRequestPermissionResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 2:
            FileSystemAccessFileHandleAsBlobParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .asBlob(
                    new FileSystemAccessFileHandleAsBlobResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 3:
            FileSystemAccessFileHandleCreateFileWriterParams data3 =
                FileSystemAccessFileHandleCreateFileWriterParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .createFileWriter(
                    data3.keepExistingData,
                    data3.autoClose,
                    data3.mode,
                    new FileSystemAccessFileHandleCreateFileWriterResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 4:
            FileSystemAccessFileHandleRenameParams data4 =
                FileSystemAccessFileHandleRenameParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .rename(
                    data4.newEntryName,
                    new FileSystemAccessFileHandleRenameResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 5:
            FileSystemAccessFileHandleMoveParams data5 =
                FileSystemAccessFileHandleMoveParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .move(
                    data5.destinationDirectory,
                    data5.newEntryName,
                    new FileSystemAccessFileHandleMoveResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 6:
            FileSystemAccessFileHandleRemoveParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .remove(
                    new FileSystemAccessFileHandleRemoveResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 7:
            FileSystemAccessFileHandleOpenAccessHandleParams data6 =
                FileSystemAccessFileHandleOpenAccessHandleParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .openAccessHandle(
                    data6.mode,
                    new FileSystemAccessFileHandleOpenAccessHandleResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 8:
            FileSystemAccessFileHandleIsSameEntryParams data7 =
                FileSystemAccessFileHandleIsSameEntryParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .isSameEntry(
                    data7.other,
                    new FileSystemAccessFileHandleIsSameEntryResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 9:
          default:
            return false;
          case 10:
            FileSystemAccessFileHandleGetUniqueIdParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .getUniqueId(
                    new FileSystemAccessFileHandleGetUniqueIdResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 11:
            FileSystemAccessFileHandleGetCloudIdentifiersParams.deserialize(
                messageWithHeader.getPayload());
            getImpl()
                .getCloudIdentifiers(
                    new FileSystemAccessFileHandleGetCloudIdentifiersResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class FileSystemAccessFileHandleGetPermissionStatusParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean writable;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessFileHandleGetPermissionStatusParams(int version) {
      super(16, version);
    }

    public FileSystemAccessFileHandleGetPermissionStatusParams() {
      this(0);
    }

    public static FileSystemAccessFileHandleGetPermissionStatusParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessFileHandleGetPermissionStatusParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessFileHandleGetPermissionStatusParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessFileHandleGetPermissionStatusParams result =
            new FileSystemAccessFileHandleGetPermissionStatusParams(elementsOrVersion);
        result.writable = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.writable, 8, 0);
    }
  }

  static final class FileSystemAccessFileHandleGetPermissionStatusResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int status;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessFileHandleGetPermissionStatusResponseParams(int version) {
      super(16, version);
    }

    public FileSystemAccessFileHandleGetPermissionStatusResponseParams() {
      this(0);
    }

    public static FileSystemAccessFileHandleGetPermissionStatusResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessFileHandleGetPermissionStatusResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessFileHandleGetPermissionStatusResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessFileHandleGetPermissionStatusResponseParams result =
            new FileSystemAccessFileHandleGetPermissionStatusResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.status = readInt;
        PermissionStatus.validate(readInt);
        result.status = PermissionStatus.toKnownValue(result.status);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.status, 8);
    }
  }

  static class FileSystemAccessFileHandleGetPermissionStatusResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FileSystemAccessFileHandle.GetPermissionStatus_Response mCallback;

    FileSystemAccessFileHandleGetPermissionStatusResponseParamsForwardToCallback(
        FileSystemAccessFileHandle.GetPermissionStatus_Response callback) {
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
        FileSystemAccessFileHandleGetPermissionStatusResponseParams response =
            FileSystemAccessFileHandleGetPermissionStatusResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.status);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FileSystemAccessFileHandleGetPermissionStatusResponseParamsProxyToResponder
      implements FileSystemAccessFileHandle.GetPermissionStatus_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FileSystemAccessFileHandleGetPermissionStatusResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int status) {
      FileSystemAccessFileHandleGetPermissionStatusResponseParams _response =
          new FileSystemAccessFileHandleGetPermissionStatusResponseParams();
      _response.status = status;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FileSystemAccessFileHandleRequestPermissionParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean writable;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessFileHandleRequestPermissionParams(int version) {
      super(16, version);
    }

    public FileSystemAccessFileHandleRequestPermissionParams() {
      this(0);
    }

    public static FileSystemAccessFileHandleRequestPermissionParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessFileHandleRequestPermissionParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessFileHandleRequestPermissionParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessFileHandleRequestPermissionParams result =
            new FileSystemAccessFileHandleRequestPermissionParams(elementsOrVersion);
        result.writable = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.writable, 8, 0);
    }
  }

  static final class FileSystemAccessFileHandleRequestPermissionResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public FileSystemAccessError result;
    public int status;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessFileHandleRequestPermissionResponseParams(int version) {
      super(24, version);
    }

    public FileSystemAccessFileHandleRequestPermissionResponseParams() {
      this(0);
    }

    public static FileSystemAccessFileHandleRequestPermissionResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessFileHandleRequestPermissionResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessFileHandleRequestPermissionResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessFileHandleRequestPermissionResponseParams result =
            new FileSystemAccessFileHandleRequestPermissionResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.result = FileSystemAccessError.decode(decoder1);
        int readInt = decoder0.readInt(16);
        result.status = readInt;
        PermissionStatus.validate(readInt);
        result.status = PermissionStatus.toKnownValue(result.status);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.result, 8, false);
      encoder0.encode(this.status, 16);
    }
  }

  static class FileSystemAccessFileHandleRequestPermissionResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FileSystemAccessFileHandle.RequestPermission_Response mCallback;

    FileSystemAccessFileHandleRequestPermissionResponseParamsForwardToCallback(
        FileSystemAccessFileHandle.RequestPermission_Response callback) {
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
        FileSystemAccessFileHandleRequestPermissionResponseParams response =
            FileSystemAccessFileHandleRequestPermissionResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result, response.status);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FileSystemAccessFileHandleRequestPermissionResponseParamsProxyToResponder
      implements FileSystemAccessFileHandle.RequestPermission_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FileSystemAccessFileHandleRequestPermissionResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(FileSystemAccessError result, int status) {
      FileSystemAccessFileHandleRequestPermissionResponseParams _response =
          new FileSystemAccessFileHandleRequestPermissionResponseParams();
      _response.result = result;
      _response.status = status;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FileSystemAccessFileHandleAsBlobParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessFileHandleAsBlobParams(int version) {
      super(8, version);
    }

    public FileSystemAccessFileHandleAsBlobParams() {
      this(0);
    }

    public static FileSystemAccessFileHandleAsBlobParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessFileHandleAsBlobParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessFileHandleAsBlobParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessFileHandleAsBlobParams result =
            new FileSystemAccessFileHandleAsBlobParams(elementsOrVersion);
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

  static final class FileSystemAccessFileHandleAsBlobResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public SerializedBlob blob;
    public FileInfo info;
    public FileSystemAccessError result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessFileHandleAsBlobResponseParams(int version) {
      super(32, version);
    }

    public FileSystemAccessFileHandleAsBlobResponseParams() {
      this(0);
    }

    public static FileSystemAccessFileHandleAsBlobResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessFileHandleAsBlobResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessFileHandleAsBlobResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessFileHandleAsBlobResponseParams result =
            new FileSystemAccessFileHandleAsBlobResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.result = FileSystemAccessError.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.info = FileInfo.decode(decoder12);
        Decoder decoder13 = decoder0.readPointer(24, true);
        result.blob = SerializedBlob.decode(decoder13);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.result, 8, false);
      encoder0.encode((Struct) this.info, 16, false);
      encoder0.encode((Struct) this.blob, 24, true);
    }
  }

  static class FileSystemAccessFileHandleAsBlobResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FileSystemAccessFileHandle.AsBlob_Response mCallback;

    FileSystemAccessFileHandleAsBlobResponseParamsForwardToCallback(
        FileSystemAccessFileHandle.AsBlob_Response callback) {
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
        FileSystemAccessFileHandleAsBlobResponseParams response =
            FileSystemAccessFileHandleAsBlobResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result, response.info, response.blob);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FileSystemAccessFileHandleAsBlobResponseParamsProxyToResponder
      implements FileSystemAccessFileHandle.AsBlob_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FileSystemAccessFileHandleAsBlobResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(FileSystemAccessError result, FileInfo info, SerializedBlob blob) {
      FileSystemAccessFileHandleAsBlobResponseParams _response =
          new FileSystemAccessFileHandleAsBlobResponseParams();
      _response.result = result;
      _response.info = info;
      _response.blob = blob;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FileSystemAccessFileHandleCreateFileWriterParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean autoClose;
    public boolean keepExistingData;
    public int mode;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessFileHandleCreateFileWriterParams(int version) {
      super(16, version);
    }

    public FileSystemAccessFileHandleCreateFileWriterParams() {
      this(0);
    }

    public static FileSystemAccessFileHandleCreateFileWriterParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessFileHandleCreateFileWriterParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessFileHandleCreateFileWriterParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessFileHandleCreateFileWriterParams result =
            new FileSystemAccessFileHandleCreateFileWriterParams(elementsOrVersion);
        result.keepExistingData = decoder0.readBoolean(8, 0);
        result.autoClose = decoder0.readBoolean(8, 1);
        int readInt = decoder0.readInt(12);
        result.mode = readInt;
        FileSystemAccessWritableFileStreamLockMode.validate(readInt);
        result.mode = FileSystemAccessWritableFileStreamLockMode.toKnownValue(result.mode);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.keepExistingData, 8, 0);
      encoder0.encode(this.autoClose, 8, 1);
      encoder0.encode(this.mode, 12);
    }
  }

  static final class FileSystemAccessFileHandleCreateFileWriterResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public FileSystemAccessError result;
    public FileSystemAccessFileWriter writer;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessFileHandleCreateFileWriterResponseParams(int version) {
      super(24, version);
    }

    public FileSystemAccessFileHandleCreateFileWriterResponseParams() {
      this(0);
    }

    public static FileSystemAccessFileHandleCreateFileWriterResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessFileHandleCreateFileWriterResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessFileHandleCreateFileWriterResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessFileHandleCreateFileWriterResponseParams result =
            new FileSystemAccessFileHandleCreateFileWriterResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.result = FileSystemAccessError.decode(decoder1);
        result.writer =
            (FileSystemAccessFileWriter)
                decoder0.readServiceInterface(16, true, FileSystemAccessFileWriter.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.result, 8, false);
      encoder0.encode(this.writer, 16, true, FileSystemAccessFileWriter.MANAGER);
    }
  }

  static class FileSystemAccessFileHandleCreateFileWriterResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FileSystemAccessFileHandle.CreateFileWriter_Response mCallback;

    FileSystemAccessFileHandleCreateFileWriterResponseParamsForwardToCallback(
        FileSystemAccessFileHandle.CreateFileWriter_Response callback) {
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
        FileSystemAccessFileHandleCreateFileWriterResponseParams response =
            FileSystemAccessFileHandleCreateFileWriterResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result, response.writer);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FileSystemAccessFileHandleCreateFileWriterResponseParamsProxyToResponder
      implements FileSystemAccessFileHandle.CreateFileWriter_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FileSystemAccessFileHandleCreateFileWriterResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(FileSystemAccessError result, FileSystemAccessFileWriter writer) {
      FileSystemAccessFileHandleCreateFileWriterResponseParams _response =
          new FileSystemAccessFileHandleCreateFileWriterResponseParams();
      _response.result = result;
      _response.writer = writer;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FileSystemAccessFileHandleRenameParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String newEntryName;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessFileHandleRenameParams(int version) {
      super(16, version);
    }

    public FileSystemAccessFileHandleRenameParams() {
      this(0);
    }

    public static FileSystemAccessFileHandleRenameParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessFileHandleRenameParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessFileHandleRenameParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessFileHandleRenameParams result =
            new FileSystemAccessFileHandleRenameParams(elementsOrVersion);
        result.newEntryName = decoder0.readString(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.newEntryName, 8, false);
    }
  }

  static final class FileSystemAccessFileHandleRenameResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public FileSystemAccessError result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessFileHandleRenameResponseParams(int version) {
      super(16, version);
    }

    public FileSystemAccessFileHandleRenameResponseParams() {
      this(0);
    }

    public static FileSystemAccessFileHandleRenameResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessFileHandleRenameResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessFileHandleRenameResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessFileHandleRenameResponseParams result =
            new FileSystemAccessFileHandleRenameResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.result = FileSystemAccessError.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.result, 8, false);
    }
  }

  static class FileSystemAccessFileHandleRenameResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FileSystemAccessFileHandle.Rename_Response mCallback;

    FileSystemAccessFileHandleRenameResponseParamsForwardToCallback(
        FileSystemAccessFileHandle.Rename_Response callback) {
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
        FileSystemAccessFileHandleRenameResponseParams response =
            FileSystemAccessFileHandleRenameResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FileSystemAccessFileHandleRenameResponseParamsProxyToResponder
      implements FileSystemAccessFileHandle.Rename_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FileSystemAccessFileHandleRenameResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(FileSystemAccessError result) {
      FileSystemAccessFileHandleRenameResponseParams _response =
          new FileSystemAccessFileHandleRenameResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FileSystemAccessFileHandleMoveParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public FileSystemAccessTransferToken destinationDirectory;
    public String newEntryName;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessFileHandleMoveParams(int version) {
      super(24, version);
    }

    public FileSystemAccessFileHandleMoveParams() {
      this(0);
    }

    public static FileSystemAccessFileHandleMoveParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessFileHandleMoveParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessFileHandleMoveParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessFileHandleMoveParams result =
            new FileSystemAccessFileHandleMoveParams(elementsOrVersion);
        result.destinationDirectory =
            (FileSystemAccessTransferToken)
                decoder0.readServiceInterface(8, false, FileSystemAccessTransferToken.MANAGER);
        result.newEntryName = decoder0.readString(16, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.destinationDirectory, 8, false, FileSystemAccessTransferToken.MANAGER);
      encoder0.encode(this.newEntryName, 16, false);
    }
  }

  static final class FileSystemAccessFileHandleMoveResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public FileSystemAccessError result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessFileHandleMoveResponseParams(int version) {
      super(16, version);
    }

    public FileSystemAccessFileHandleMoveResponseParams() {
      this(0);
    }

    public static FileSystemAccessFileHandleMoveResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessFileHandleMoveResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessFileHandleMoveResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessFileHandleMoveResponseParams result =
            new FileSystemAccessFileHandleMoveResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.result = FileSystemAccessError.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.result, 8, false);
    }
  }

  static class FileSystemAccessFileHandleMoveResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FileSystemAccessFileHandle.Move_Response mCallback;

    FileSystemAccessFileHandleMoveResponseParamsForwardToCallback(
        FileSystemAccessFileHandle.Move_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(5, 2)) {
          return false;
        }
        FileSystemAccessFileHandleMoveResponseParams response =
            FileSystemAccessFileHandleMoveResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FileSystemAccessFileHandleMoveResponseParamsProxyToResponder
      implements FileSystemAccessFileHandle.Move_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FileSystemAccessFileHandleMoveResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(FileSystemAccessError result) {
      FileSystemAccessFileHandleMoveResponseParams _response =
          new FileSystemAccessFileHandleMoveResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(5, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FileSystemAccessFileHandleRemoveParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessFileHandleRemoveParams(int version) {
      super(8, version);
    }

    public FileSystemAccessFileHandleRemoveParams() {
      this(0);
    }

    public static FileSystemAccessFileHandleRemoveParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessFileHandleRemoveParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessFileHandleRemoveParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessFileHandleRemoveParams result =
            new FileSystemAccessFileHandleRemoveParams(elementsOrVersion);
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

  static final class FileSystemAccessFileHandleRemoveResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public FileSystemAccessError result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessFileHandleRemoveResponseParams(int version) {
      super(16, version);
    }

    public FileSystemAccessFileHandleRemoveResponseParams() {
      this(0);
    }

    public static FileSystemAccessFileHandleRemoveResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessFileHandleRemoveResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessFileHandleRemoveResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessFileHandleRemoveResponseParams result =
            new FileSystemAccessFileHandleRemoveResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.result = FileSystemAccessError.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.result, 8, false);
    }
  }

  static class FileSystemAccessFileHandleRemoveResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FileSystemAccessFileHandle.Remove_Response mCallback;

    FileSystemAccessFileHandleRemoveResponseParamsForwardToCallback(
        FileSystemAccessFileHandle.Remove_Response callback) {
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
        FileSystemAccessFileHandleRemoveResponseParams response =
            FileSystemAccessFileHandleRemoveResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FileSystemAccessFileHandleRemoveResponseParamsProxyToResponder
      implements FileSystemAccessFileHandle.Remove_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FileSystemAccessFileHandleRemoveResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(FileSystemAccessError result) {
      FileSystemAccessFileHandleRemoveResponseParams _response =
          new FileSystemAccessFileHandleRemoveResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(6, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FileSystemAccessFileHandleOpenAccessHandleParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int mode;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessFileHandleOpenAccessHandleParams(int version) {
      super(16, version);
    }

    public FileSystemAccessFileHandleOpenAccessHandleParams() {
      this(0);
    }

    public static FileSystemAccessFileHandleOpenAccessHandleParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessFileHandleOpenAccessHandleParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessFileHandleOpenAccessHandleParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessFileHandleOpenAccessHandleParams result =
            new FileSystemAccessFileHandleOpenAccessHandleParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.mode = readInt;
        FileSystemAccessAccessHandleLockMode.validate(readInt);
        result.mode = FileSystemAccessAccessHandleLockMode.toKnownValue(result.mode);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.mode, 8);
    }
  }

  static final class FileSystemAccessFileHandleOpenAccessHandleResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public FileSystemAccessAccessHandleHost accessHandleHost;
    public FileSystemAccessAccessHandleFile file;
    public FileSystemAccessError result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessFileHandleOpenAccessHandleResponseParams(int version) {
      super(40, version);
    }

    public FileSystemAccessFileHandleOpenAccessHandleResponseParams() {
      this(0);
    }

    public static FileSystemAccessFileHandleOpenAccessHandleResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessFileHandleOpenAccessHandleResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessFileHandleOpenAccessHandleResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessFileHandleOpenAccessHandleResponseParams result =
            new FileSystemAccessFileHandleOpenAccessHandleResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.result = FileSystemAccessError.decode(decoder1);
        result.file = FileSystemAccessAccessHandleFile.decode(decoder0, 16);
        result.accessHandleHost =
            (FileSystemAccessAccessHandleHost)
                decoder0.readServiceInterface(32, true, FileSystemAccessAccessHandleHost.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.result, 8, false);
      encoder0.encode((Union) this.file, 16, true);
      encoder0.encode(this.accessHandleHost, 32, true, FileSystemAccessAccessHandleHost.MANAGER);
    }
  }

  static class FileSystemAccessFileHandleOpenAccessHandleResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FileSystemAccessFileHandle.OpenAccessHandle_Response mCallback;

    FileSystemAccessFileHandleOpenAccessHandleResponseParamsForwardToCallback(
        FileSystemAccessFileHandle.OpenAccessHandle_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(7, 2)) {
          return false;
        }
        FileSystemAccessFileHandleOpenAccessHandleResponseParams response =
            FileSystemAccessFileHandleOpenAccessHandleResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result, response.file, response.accessHandleHost);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FileSystemAccessFileHandleOpenAccessHandleResponseParamsProxyToResponder
      implements FileSystemAccessFileHandle.OpenAccessHandle_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FileSystemAccessFileHandleOpenAccessHandleResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(
        FileSystemAccessError result,
        FileSystemAccessAccessHandleFile file,
        FileSystemAccessAccessHandleHost accessHandleHost) {
      FileSystemAccessFileHandleOpenAccessHandleResponseParams _response =
          new FileSystemAccessFileHandleOpenAccessHandleResponseParams();
      _response.result = result;
      _response.file = file;
      _response.accessHandleHost = accessHandleHost;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(7, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FileSystemAccessFileHandleIsSameEntryParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public FileSystemAccessTransferToken other;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessFileHandleIsSameEntryParams(int version) {
      super(16, version);
    }

    public FileSystemAccessFileHandleIsSameEntryParams() {
      this(0);
    }

    public static FileSystemAccessFileHandleIsSameEntryParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessFileHandleIsSameEntryParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessFileHandleIsSameEntryParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessFileHandleIsSameEntryParams result =
            new FileSystemAccessFileHandleIsSameEntryParams(elementsOrVersion);
        result.other =
            (FileSystemAccessTransferToken)
                decoder0.readServiceInterface(8, false, FileSystemAccessTransferToken.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.other, 8, false, FileSystemAccessTransferToken.MANAGER);
    }
  }

  static final class FileSystemAccessFileHandleIsSameEntryResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean isSame;
    public FileSystemAccessError result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessFileHandleIsSameEntryResponseParams(int version) {
      super(24, version);
    }

    public FileSystemAccessFileHandleIsSameEntryResponseParams() {
      this(0);
    }

    public static FileSystemAccessFileHandleIsSameEntryResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessFileHandleIsSameEntryResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessFileHandleIsSameEntryResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessFileHandleIsSameEntryResponseParams result =
            new FileSystemAccessFileHandleIsSameEntryResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.result = FileSystemAccessError.decode(decoder1);
        result.isSame = decoder0.readBoolean(16, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.result, 8, false);
      encoder0.encode(this.isSame, 16, 0);
    }
  }

  static class FileSystemAccessFileHandleIsSameEntryResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FileSystemAccessFileHandle.IsSameEntry_Response mCallback;

    FileSystemAccessFileHandleIsSameEntryResponseParamsForwardToCallback(
        FileSystemAccessFileHandle.IsSameEntry_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(8, 2)) {
          return false;
        }
        FileSystemAccessFileHandleIsSameEntryResponseParams response =
            FileSystemAccessFileHandleIsSameEntryResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result, response.isSame);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FileSystemAccessFileHandleIsSameEntryResponseParamsProxyToResponder
      implements FileSystemAccessFileHandle.IsSameEntry_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FileSystemAccessFileHandleIsSameEntryResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(FileSystemAccessError result, boolean isSame) {
      FileSystemAccessFileHandleIsSameEntryResponseParams _response =
          new FileSystemAccessFileHandleIsSameEntryResponseParams();
      _response.result = result;
      _response.isSame = isSame;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(8, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FileSystemAccessFileHandleTransferParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<FileSystemAccessTransferToken> token;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessFileHandleTransferParams(int version) {
      super(16, version);
    }

    public FileSystemAccessFileHandleTransferParams() {
      this(0);
    }

    public static FileSystemAccessFileHandleTransferParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessFileHandleTransferParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessFileHandleTransferParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessFileHandleTransferParams result =
            new FileSystemAccessFileHandleTransferParams(elementsOrVersion);
        result.token = decoder0.readInterfaceRequest(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.token, 8, false);
    }
  }

  static final class FileSystemAccessFileHandleGetUniqueIdParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessFileHandleGetUniqueIdParams(int version) {
      super(8, version);
    }

    public FileSystemAccessFileHandleGetUniqueIdParams() {
      this(0);
    }

    public static FileSystemAccessFileHandleGetUniqueIdParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessFileHandleGetUniqueIdParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessFileHandleGetUniqueIdParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessFileHandleGetUniqueIdParams result =
            new FileSystemAccessFileHandleGetUniqueIdParams(elementsOrVersion);
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

  static final class FileSystemAccessFileHandleGetUniqueIdResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public String id;
    public FileSystemAccessError result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessFileHandleGetUniqueIdResponseParams(int version) {
      super(24, version);
    }

    public FileSystemAccessFileHandleGetUniqueIdResponseParams() {
      this(0);
    }

    public static FileSystemAccessFileHandleGetUniqueIdResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessFileHandleGetUniqueIdResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessFileHandleGetUniqueIdResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessFileHandleGetUniqueIdResponseParams result =
            new FileSystemAccessFileHandleGetUniqueIdResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.result = FileSystemAccessError.decode(decoder1);
        result.id = decoder0.readString(16, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.result, 8, false);
      encoder0.encode(this.id, 16, false);
    }
  }

  static class FileSystemAccessFileHandleGetUniqueIdResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FileSystemAccessFileHandle.GetUniqueId_Response mCallback;

    FileSystemAccessFileHandleGetUniqueIdResponseParamsForwardToCallback(
        FileSystemAccessFileHandle.GetUniqueId_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(10, 2)) {
          return false;
        }
        FileSystemAccessFileHandleGetUniqueIdResponseParams response =
            FileSystemAccessFileHandleGetUniqueIdResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result, response.id);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FileSystemAccessFileHandleGetUniqueIdResponseParamsProxyToResponder
      implements FileSystemAccessFileHandle.GetUniqueId_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FileSystemAccessFileHandleGetUniqueIdResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(FileSystemAccessError result, String id) {
      FileSystemAccessFileHandleGetUniqueIdResponseParams _response =
          new FileSystemAccessFileHandleGetUniqueIdResponseParams();
      _response.result = result;
      _response.id = id;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(10, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FileSystemAccessFileHandleGetCloudIdentifiersParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessFileHandleGetCloudIdentifiersParams(int version) {
      super(8, version);
    }

    public FileSystemAccessFileHandleGetCloudIdentifiersParams() {
      this(0);
    }

    public static FileSystemAccessFileHandleGetCloudIdentifiersParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessFileHandleGetCloudIdentifiersParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessFileHandleGetCloudIdentifiersParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessFileHandleGetCloudIdentifiersParams result =
            new FileSystemAccessFileHandleGetCloudIdentifiersParams(elementsOrVersion);
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

  static final class FileSystemAccessFileHandleGetCloudIdentifiersResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public FileSystemAccessCloudIdentifier[] cloudIdentifiers;
    public FileSystemAccessError result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessFileHandleGetCloudIdentifiersResponseParams(int version) {
      super(24, version);
    }

    public FileSystemAccessFileHandleGetCloudIdentifiersResponseParams() {
      this(0);
    }

    public static FileSystemAccessFileHandleGetCloudIdentifiersResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessFileHandleGetCloudIdentifiersResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessFileHandleGetCloudIdentifiersResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessFileHandleGetCloudIdentifiersResponseParams result =
            new FileSystemAccessFileHandleGetCloudIdentifiersResponseParams(elementsOrVersion);
        result.result = FileSystemAccessError.decode(decoder0.readPointer(8, false));
        Decoder decoder1 = decoder0.readPointer(16, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.cloudIdentifiers = new FileSystemAccessCloudIdentifier[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.cloudIdentifiers[i1] = FileSystemAccessCloudIdentifier.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.result, 8, false);
      FileSystemAccessCloudIdentifier[] fileSystemAccessCloudIdentifierArr = this.cloudIdentifiers;
      if (fileSystemAccessCloudIdentifierArr == null) {
        encoder0.encodeNullPointer(16, false);
        return;
      }
      Encoder encoder1 =
          encoder0.encodePointerArray(fileSystemAccessCloudIdentifierArr.length, 16, -1);
      int i0 = 0;
      while (true) {
        FileSystemAccessCloudIdentifier[] fileSystemAccessCloudIdentifierArr2 =
            this.cloudIdentifiers;
        if (i0 < fileSystemAccessCloudIdentifierArr2.length) {
          encoder1.encode((Struct) fileSystemAccessCloudIdentifierArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static class FileSystemAccessFileHandleGetCloudIdentifiersResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FileSystemAccessFileHandle.GetCloudIdentifiers_Response mCallback;

    FileSystemAccessFileHandleGetCloudIdentifiersResponseParamsForwardToCallback(
        FileSystemAccessFileHandle.GetCloudIdentifiers_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(11, 2)) {
          return false;
        }
        FileSystemAccessFileHandleGetCloudIdentifiersResponseParams response =
            FileSystemAccessFileHandleGetCloudIdentifiersResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result, response.cloudIdentifiers);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FileSystemAccessFileHandleGetCloudIdentifiersResponseParamsProxyToResponder
      implements FileSystemAccessFileHandle.GetCloudIdentifiers_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FileSystemAccessFileHandleGetCloudIdentifiersResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(
        FileSystemAccessError result, FileSystemAccessCloudIdentifier[] cloudIdentifiers) {
      FileSystemAccessFileHandleGetCloudIdentifiersResponseParams _response =
          new FileSystemAccessFileHandleGetCloudIdentifiersResponseParams();
      _response.result = result;
      _response.cloudIdentifiers = cloudIdentifiers;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(11, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
