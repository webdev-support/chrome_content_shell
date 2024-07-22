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

class FileSystemAccessDirectoryHandle_Internal {
  private static final int GET_CLOUD_IDENTIFIERS_ORDINAL = 12;
  private static final int GET_DIRECTORY_ORDINAL = 3;
  private static final int GET_ENTRIES_ORDINAL = 4;
  private static final int GET_FILE_ORDINAL = 2;
  private static final int GET_PERMISSION_STATUS_ORDINAL = 0;
  private static final int GET_UNIQUE_ID_ORDINAL = 11;
  public static final Interface.Manager<
          FileSystemAccessDirectoryHandle, FileSystemAccessDirectoryHandle.Proxy>
      MANAGER =
          new Interface.Manager<
              FileSystemAccessDirectoryHandle, FileSystemAccessDirectoryHandle.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.FileSystemAccessDirectoryHandle";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public FileSystemAccessDirectoryHandle.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, FileSystemAccessDirectoryHandle impl) {
              return new Stub(core, impl);
            }

            @Override
            public FileSystemAccessDirectoryHandle[] buildArray(int size) {
              return new FileSystemAccessDirectoryHandle[size];
            }
          };
  private static final int MOVE_ORDINAL = 6;
  private static final int REMOVE_ENTRY_ORDINAL = 8;
  private static final int REMOVE_ORDINAL = 7;
  private static final int RENAME_ORDINAL = 5;
  private static final int REQUEST_PERMISSION_ORDINAL = 1;
  private static final int RESOLVE_ORDINAL = 9;
  private static final int TRANSFER_ORDINAL = 10;

  FileSystemAccessDirectoryHandle_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements FileSystemAccessDirectoryHandle.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void getPermissionStatus(boolean writable, GetPermissionStatus_Response callback) {
      FileSystemAccessDirectoryHandleGetPermissionStatusParams _message =
          new FileSystemAccessDirectoryHandleGetPermissionStatusParams();
      _message.writable = writable;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new FileSystemAccessDirectoryHandleGetPermissionStatusResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void requestPermission(boolean writable, RequestPermission_Response callback) {
      FileSystemAccessDirectoryHandleRequestPermissionParams _message =
          new FileSystemAccessDirectoryHandleRequestPermissionParams();
      _message.writable = writable;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new FileSystemAccessDirectoryHandleRequestPermissionResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void getFile(String basename, boolean create, GetFile_Response callback) {
      FileSystemAccessDirectoryHandleGetFileParams _message =
          new FileSystemAccessDirectoryHandleGetFileParams();
      _message.basename = basename;
      _message.create = create;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new FileSystemAccessDirectoryHandleGetFileResponseParamsForwardToCallback(callback));
    }

    @Override
    public void getDirectory(String basename, boolean create, GetDirectory_Response callback) {
      FileSystemAccessDirectoryHandleGetDirectoryParams _message =
          new FileSystemAccessDirectoryHandleGetDirectoryParams();
      _message.basename = basename;
      _message.create = create;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)),
              new FileSystemAccessDirectoryHandleGetDirectoryResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void getEntries(FileSystemAccessDirectoryEntriesListener listener) {
      FileSystemAccessDirectoryHandleGetEntriesParams _message =
          new FileSystemAccessDirectoryHandleGetEntriesParams();
      _message.listener = listener;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
    }

    @Override
    public void rename(String newEntryName, Rename_Response callback) {
      FileSystemAccessDirectoryHandleRenameParams _message =
          new FileSystemAccessDirectoryHandleRenameParams();
      _message.newEntryName = newEntryName;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(5, 1, 0L)),
              new FileSystemAccessDirectoryHandleRenameResponseParamsForwardToCallback(callback));
    }

    @Override
    public void move(
        FileSystemAccessTransferToken destinationDirectory,
        String newEntryName,
        Move_Response callback) {
      FileSystemAccessDirectoryHandleMoveParams _message =
          new FileSystemAccessDirectoryHandleMoveParams();
      _message.destinationDirectory = destinationDirectory;
      _message.newEntryName = newEntryName;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(6, 1, 0L)),
              new FileSystemAccessDirectoryHandleMoveResponseParamsForwardToCallback(callback));
    }

    @Override
    public void remove(boolean recurse, Remove_Response callback) {
      FileSystemAccessDirectoryHandleRemoveParams _message =
          new FileSystemAccessDirectoryHandleRemoveParams();
      _message.recurse = recurse;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(7, 1, 0L)),
              new FileSystemAccessDirectoryHandleRemoveResponseParamsForwardToCallback(callback));
    }

    @Override
    public void removeEntry(String basename, boolean recurse, RemoveEntry_Response callback) {
      FileSystemAccessDirectoryHandleRemoveEntryParams _message =
          new FileSystemAccessDirectoryHandleRemoveEntryParams();
      _message.basename = basename;
      _message.recurse = recurse;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(8, 1, 0L)),
              new FileSystemAccessDirectoryHandleRemoveEntryResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void resolve(FileSystemAccessTransferToken possibleChild, Resolve_Response callback) {
      FileSystemAccessDirectoryHandleResolveParams _message =
          new FileSystemAccessDirectoryHandleResolveParams();
      _message.possibleChild = possibleChild;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(9, 1, 0L)),
              new FileSystemAccessDirectoryHandleResolveResponseParamsForwardToCallback(callback));
    }

    @Override
    public void transfer(InterfaceRequest<FileSystemAccessTransferToken> token) {
      FileSystemAccessDirectoryHandleTransferParams _message =
          new FileSystemAccessDirectoryHandleTransferParams();
      _message.token = token;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(10)));
    }

    @Override
    public void getUniqueId(GetUniqueId_Response callback) {
      FileSystemAccessDirectoryHandleGetUniqueIdParams _message =
          new FileSystemAccessDirectoryHandleGetUniqueIdParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(11, 1, 0L)),
              new FileSystemAccessDirectoryHandleGetUniqueIdResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void getCloudIdentifiers(GetCloudIdentifiers_Response callback) {
      FileSystemAccessDirectoryHandleGetCloudIdentifiersParams _message =
          new FileSystemAccessDirectoryHandleGetCloudIdentifiersParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(12, 1, 0L)),
              new FileSystemAccessDirectoryHandleGetCloudIdentifiersResponseParamsForwardToCallback(
                  callback));
    }
  }

  public static final class Stub extends Interface.Stub<FileSystemAccessDirectoryHandle> {
    Stub(Core core, FileSystemAccessDirectoryHandle impl) {
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
                FileSystemAccessDirectoryHandle_Internal.MANAGER, messageWithHeader);
          case 4:
            FileSystemAccessDirectoryHandleGetEntriesParams data =
                FileSystemAccessDirectoryHandleGetEntriesParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().getEntries(data.listener);
            return true;
          case 10:
            FileSystemAccessDirectoryHandleTransferParams data2 =
                FileSystemAccessDirectoryHandleTransferParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().transfer(data2.token);
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
                FileSystemAccessDirectoryHandle_Internal.MANAGER,
                messageWithHeader,
                receiver);
          case 0:
            FileSystemAccessDirectoryHandleGetPermissionStatusParams data =
                FileSystemAccessDirectoryHandleGetPermissionStatusParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .getPermissionStatus(
                    data.writable,
                    new FileSystemAccessDirectoryHandleGetPermissionStatusResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
            FileSystemAccessDirectoryHandleRequestPermissionParams data2 =
                FileSystemAccessDirectoryHandleRequestPermissionParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .requestPermission(
                    data2.writable,
                    new FileSystemAccessDirectoryHandleRequestPermissionResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 2:
            FileSystemAccessDirectoryHandleGetFileParams data3 =
                FileSystemAccessDirectoryHandleGetFileParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .getFile(
                    data3.basename,
                    data3.create,
                    new FileSystemAccessDirectoryHandleGetFileResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 3:
            FileSystemAccessDirectoryHandleGetDirectoryParams data4 =
                FileSystemAccessDirectoryHandleGetDirectoryParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .getDirectory(
                    data4.basename,
                    data4.create,
                    new FileSystemAccessDirectoryHandleGetDirectoryResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 4:
          case 10:
          default:
            return false;
          case 5:
            FileSystemAccessDirectoryHandleRenameParams data5 =
                FileSystemAccessDirectoryHandleRenameParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .rename(
                    data5.newEntryName,
                    new FileSystemAccessDirectoryHandleRenameResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 6:
            FileSystemAccessDirectoryHandleMoveParams data6 =
                FileSystemAccessDirectoryHandleMoveParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .move(
                    data6.destinationDirectory,
                    data6.newEntryName,
                    new FileSystemAccessDirectoryHandleMoveResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 7:
            FileSystemAccessDirectoryHandleRemoveParams data7 =
                FileSystemAccessDirectoryHandleRemoveParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .remove(
                    data7.recurse,
                    new FileSystemAccessDirectoryHandleRemoveResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 8:
            FileSystemAccessDirectoryHandleRemoveEntryParams data8 =
                FileSystemAccessDirectoryHandleRemoveEntryParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .removeEntry(
                    data8.basename,
                    data8.recurse,
                    new FileSystemAccessDirectoryHandleRemoveEntryResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 9:
            FileSystemAccessDirectoryHandleResolveParams data9 =
                FileSystemAccessDirectoryHandleResolveParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .resolve(
                    data9.possibleChild,
                    new FileSystemAccessDirectoryHandleResolveResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 11:
            FileSystemAccessDirectoryHandleGetUniqueIdParams.deserialize(
                messageWithHeader.getPayload());
            getImpl()
                .getUniqueId(
                    new FileSystemAccessDirectoryHandleGetUniqueIdResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 12:
            FileSystemAccessDirectoryHandleGetCloudIdentifiersParams.deserialize(
                messageWithHeader.getPayload());
            getImpl()
                .getCloudIdentifiers(
                    new FileSystemAccessDirectoryHandleGetCloudIdentifiersResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class FileSystemAccessDirectoryHandleGetPermissionStatusParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean writable;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessDirectoryHandleGetPermissionStatusParams(int version) {
      super(16, version);
    }

    public FileSystemAccessDirectoryHandleGetPermissionStatusParams() {
      this(0);
    }

    public static FileSystemAccessDirectoryHandleGetPermissionStatusParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessDirectoryHandleGetPermissionStatusParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessDirectoryHandleGetPermissionStatusParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessDirectoryHandleGetPermissionStatusParams result =
            new FileSystemAccessDirectoryHandleGetPermissionStatusParams(elementsOrVersion);
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

  static final class FileSystemAccessDirectoryHandleGetPermissionStatusResponseParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int status;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessDirectoryHandleGetPermissionStatusResponseParams(int version) {
      super(16, version);
    }

    public FileSystemAccessDirectoryHandleGetPermissionStatusResponseParams() {
      this(0);
    }

    public static FileSystemAccessDirectoryHandleGetPermissionStatusResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessDirectoryHandleGetPermissionStatusResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessDirectoryHandleGetPermissionStatusResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessDirectoryHandleGetPermissionStatusResponseParams result =
            new FileSystemAccessDirectoryHandleGetPermissionStatusResponseParams(elementsOrVersion);
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

  static class FileSystemAccessDirectoryHandleGetPermissionStatusResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FileSystemAccessDirectoryHandle.GetPermissionStatus_Response mCallback;

    FileSystemAccessDirectoryHandleGetPermissionStatusResponseParamsForwardToCallback(
        FileSystemAccessDirectoryHandle.GetPermissionStatus_Response callback) {
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
        FileSystemAccessDirectoryHandleGetPermissionStatusResponseParams response =
            FileSystemAccessDirectoryHandleGetPermissionStatusResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.status);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FileSystemAccessDirectoryHandleGetPermissionStatusResponseParamsProxyToResponder
      implements FileSystemAccessDirectoryHandle.GetPermissionStatus_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FileSystemAccessDirectoryHandleGetPermissionStatusResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int status) {
      FileSystemAccessDirectoryHandleGetPermissionStatusResponseParams _response =
          new FileSystemAccessDirectoryHandleGetPermissionStatusResponseParams();
      _response.status = status;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FileSystemAccessDirectoryHandleRequestPermissionParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean writable;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessDirectoryHandleRequestPermissionParams(int version) {
      super(16, version);
    }

    public FileSystemAccessDirectoryHandleRequestPermissionParams() {
      this(0);
    }

    public static FileSystemAccessDirectoryHandleRequestPermissionParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessDirectoryHandleRequestPermissionParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessDirectoryHandleRequestPermissionParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessDirectoryHandleRequestPermissionParams result =
            new FileSystemAccessDirectoryHandleRequestPermissionParams(elementsOrVersion);
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

  static final class FileSystemAccessDirectoryHandleRequestPermissionResponseParams extends Struct {
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

    private FileSystemAccessDirectoryHandleRequestPermissionResponseParams(int version) {
      super(24, version);
    }

    public FileSystemAccessDirectoryHandleRequestPermissionResponseParams() {
      this(0);
    }

    public static FileSystemAccessDirectoryHandleRequestPermissionResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessDirectoryHandleRequestPermissionResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessDirectoryHandleRequestPermissionResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessDirectoryHandleRequestPermissionResponseParams result =
            new FileSystemAccessDirectoryHandleRequestPermissionResponseParams(elementsOrVersion);
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

  static class FileSystemAccessDirectoryHandleRequestPermissionResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FileSystemAccessDirectoryHandle.RequestPermission_Response mCallback;

    FileSystemAccessDirectoryHandleRequestPermissionResponseParamsForwardToCallback(
        FileSystemAccessDirectoryHandle.RequestPermission_Response callback) {
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
        FileSystemAccessDirectoryHandleRequestPermissionResponseParams response =
            FileSystemAccessDirectoryHandleRequestPermissionResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result, response.status);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FileSystemAccessDirectoryHandleRequestPermissionResponseParamsProxyToResponder
      implements FileSystemAccessDirectoryHandle.RequestPermission_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FileSystemAccessDirectoryHandleRequestPermissionResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(FileSystemAccessError result, int status) {
      FileSystemAccessDirectoryHandleRequestPermissionResponseParams _response =
          new FileSystemAccessDirectoryHandleRequestPermissionResponseParams();
      _response.result = result;
      _response.status = status;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FileSystemAccessDirectoryHandleGetFileParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public String basename;
    public boolean create;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessDirectoryHandleGetFileParams(int version) {
      super(24, version);
    }

    public FileSystemAccessDirectoryHandleGetFileParams() {
      this(0);
    }

    public static FileSystemAccessDirectoryHandleGetFileParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessDirectoryHandleGetFileParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessDirectoryHandleGetFileParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessDirectoryHandleGetFileParams result =
            new FileSystemAccessDirectoryHandleGetFileParams(elementsOrVersion);
        result.basename = decoder0.readString(8, false);
        result.create = decoder0.readBoolean(16, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.basename, 8, false);
      encoder0.encode(this.create, 16, 0);
    }
  }

  static final class FileSystemAccessDirectoryHandleGetFileResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public FileSystemAccessFileHandle file;
    public FileSystemAccessError result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessDirectoryHandleGetFileResponseParams(int version) {
      super(24, version);
    }

    public FileSystemAccessDirectoryHandleGetFileResponseParams() {
      this(0);
    }

    public static FileSystemAccessDirectoryHandleGetFileResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessDirectoryHandleGetFileResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessDirectoryHandleGetFileResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessDirectoryHandleGetFileResponseParams result =
            new FileSystemAccessDirectoryHandleGetFileResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.result = FileSystemAccessError.decode(decoder1);
        result.file =
            (FileSystemAccessFileHandle)
                decoder0.readServiceInterface(16, true, FileSystemAccessFileHandle.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.result, 8, false);
      encoder0.encode(this.file, 16, true, FileSystemAccessFileHandle.MANAGER);
    }
  }

  static class FileSystemAccessDirectoryHandleGetFileResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FileSystemAccessDirectoryHandle.GetFile_Response mCallback;

    FileSystemAccessDirectoryHandleGetFileResponseParamsForwardToCallback(
        FileSystemAccessDirectoryHandle.GetFile_Response callback) {
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
        FileSystemAccessDirectoryHandleGetFileResponseParams response =
            FileSystemAccessDirectoryHandleGetFileResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result, response.file);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FileSystemAccessDirectoryHandleGetFileResponseParamsProxyToResponder
      implements FileSystemAccessDirectoryHandle.GetFile_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FileSystemAccessDirectoryHandleGetFileResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(FileSystemAccessError result, FileSystemAccessFileHandle file) {
      FileSystemAccessDirectoryHandleGetFileResponseParams _response =
          new FileSystemAccessDirectoryHandleGetFileResponseParams();
      _response.result = result;
      _response.file = file;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FileSystemAccessDirectoryHandleGetDirectoryParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public String basename;
    public boolean create;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessDirectoryHandleGetDirectoryParams(int version) {
      super(24, version);
    }

    public FileSystemAccessDirectoryHandleGetDirectoryParams() {
      this(0);
    }

    public static FileSystemAccessDirectoryHandleGetDirectoryParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessDirectoryHandleGetDirectoryParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessDirectoryHandleGetDirectoryParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessDirectoryHandleGetDirectoryParams result =
            new FileSystemAccessDirectoryHandleGetDirectoryParams(elementsOrVersion);
        result.basename = decoder0.readString(8, false);
        result.create = decoder0.readBoolean(16, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.basename, 8, false);
      encoder0.encode(this.create, 16, 0);
    }
  }

  static final class FileSystemAccessDirectoryHandleGetDirectoryResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public FileSystemAccessDirectoryHandle directory;
    public FileSystemAccessError result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessDirectoryHandleGetDirectoryResponseParams(int version) {
      super(24, version);
    }

    public FileSystemAccessDirectoryHandleGetDirectoryResponseParams() {
      this(0);
    }

    public static FileSystemAccessDirectoryHandleGetDirectoryResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessDirectoryHandleGetDirectoryResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessDirectoryHandleGetDirectoryResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessDirectoryHandleGetDirectoryResponseParams result =
            new FileSystemAccessDirectoryHandleGetDirectoryResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.result = FileSystemAccessError.decode(decoder1);
        result.directory =
            (FileSystemAccessDirectoryHandle)
                decoder0.readServiceInterface(16, true, FileSystemAccessDirectoryHandle.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.result, 8, false);
      encoder0.encode(this.directory, 16, true, FileSystemAccessDirectoryHandle.MANAGER);
    }
  }

  static class FileSystemAccessDirectoryHandleGetDirectoryResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FileSystemAccessDirectoryHandle.GetDirectory_Response mCallback;

    FileSystemAccessDirectoryHandleGetDirectoryResponseParamsForwardToCallback(
        FileSystemAccessDirectoryHandle.GetDirectory_Response callback) {
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
        FileSystemAccessDirectoryHandleGetDirectoryResponseParams response =
            FileSystemAccessDirectoryHandleGetDirectoryResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result, response.directory);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FileSystemAccessDirectoryHandleGetDirectoryResponseParamsProxyToResponder
      implements FileSystemAccessDirectoryHandle.GetDirectory_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FileSystemAccessDirectoryHandleGetDirectoryResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(FileSystemAccessError result, FileSystemAccessDirectoryHandle directory) {
      FileSystemAccessDirectoryHandleGetDirectoryResponseParams _response =
          new FileSystemAccessDirectoryHandleGetDirectoryResponseParams();
      _response.result = result;
      _response.directory = directory;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FileSystemAccessDirectoryHandleGetEntriesParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public FileSystemAccessDirectoryEntriesListener listener;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessDirectoryHandleGetEntriesParams(int version) {
      super(16, version);
    }

    public FileSystemAccessDirectoryHandleGetEntriesParams() {
      this(0);
    }

    public static FileSystemAccessDirectoryHandleGetEntriesParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessDirectoryHandleGetEntriesParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessDirectoryHandleGetEntriesParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessDirectoryHandleGetEntriesParams result =
            new FileSystemAccessDirectoryHandleGetEntriesParams(elementsOrVersion);
        result.listener =
            (FileSystemAccessDirectoryEntriesListener)
                decoder0.readServiceInterface(
                    8, false, FileSystemAccessDirectoryEntriesListener.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.listener, 8, false, FileSystemAccessDirectoryEntriesListener.MANAGER);
    }
  }

  static final class FileSystemAccessDirectoryHandleRenameParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String newEntryName;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessDirectoryHandleRenameParams(int version) {
      super(16, version);
    }

    public FileSystemAccessDirectoryHandleRenameParams() {
      this(0);
    }

    public static FileSystemAccessDirectoryHandleRenameParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessDirectoryHandleRenameParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessDirectoryHandleRenameParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessDirectoryHandleRenameParams result =
            new FileSystemAccessDirectoryHandleRenameParams(elementsOrVersion);
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

  static final class FileSystemAccessDirectoryHandleRenameResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public FileSystemAccessError result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessDirectoryHandleRenameResponseParams(int version) {
      super(16, version);
    }

    public FileSystemAccessDirectoryHandleRenameResponseParams() {
      this(0);
    }

    public static FileSystemAccessDirectoryHandleRenameResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessDirectoryHandleRenameResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessDirectoryHandleRenameResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessDirectoryHandleRenameResponseParams result =
            new FileSystemAccessDirectoryHandleRenameResponseParams(elementsOrVersion);
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

  static class FileSystemAccessDirectoryHandleRenameResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FileSystemAccessDirectoryHandle.Rename_Response mCallback;

    FileSystemAccessDirectoryHandleRenameResponseParamsForwardToCallback(
        FileSystemAccessDirectoryHandle.Rename_Response callback) {
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
        FileSystemAccessDirectoryHandleRenameResponseParams response =
            FileSystemAccessDirectoryHandleRenameResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FileSystemAccessDirectoryHandleRenameResponseParamsProxyToResponder
      implements FileSystemAccessDirectoryHandle.Rename_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FileSystemAccessDirectoryHandleRenameResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(FileSystemAccessError result) {
      FileSystemAccessDirectoryHandleRenameResponseParams _response =
          new FileSystemAccessDirectoryHandleRenameResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(5, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FileSystemAccessDirectoryHandleMoveParams extends Struct {
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

    private FileSystemAccessDirectoryHandleMoveParams(int version) {
      super(24, version);
    }

    public FileSystemAccessDirectoryHandleMoveParams() {
      this(0);
    }

    public static FileSystemAccessDirectoryHandleMoveParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessDirectoryHandleMoveParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessDirectoryHandleMoveParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessDirectoryHandleMoveParams result =
            new FileSystemAccessDirectoryHandleMoveParams(elementsOrVersion);
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

  static final class FileSystemAccessDirectoryHandleMoveResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public FileSystemAccessError result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessDirectoryHandleMoveResponseParams(int version) {
      super(16, version);
    }

    public FileSystemAccessDirectoryHandleMoveResponseParams() {
      this(0);
    }

    public static FileSystemAccessDirectoryHandleMoveResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessDirectoryHandleMoveResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessDirectoryHandleMoveResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessDirectoryHandleMoveResponseParams result =
            new FileSystemAccessDirectoryHandleMoveResponseParams(elementsOrVersion);
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

  static class FileSystemAccessDirectoryHandleMoveResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FileSystemAccessDirectoryHandle.Move_Response mCallback;

    FileSystemAccessDirectoryHandleMoveResponseParamsForwardToCallback(
        FileSystemAccessDirectoryHandle.Move_Response callback) {
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
        FileSystemAccessDirectoryHandleMoveResponseParams response =
            FileSystemAccessDirectoryHandleMoveResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FileSystemAccessDirectoryHandleMoveResponseParamsProxyToResponder
      implements FileSystemAccessDirectoryHandle.Move_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FileSystemAccessDirectoryHandleMoveResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(FileSystemAccessError result) {
      FileSystemAccessDirectoryHandleMoveResponseParams _response =
          new FileSystemAccessDirectoryHandleMoveResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(6, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FileSystemAccessDirectoryHandleRemoveParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean recurse;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessDirectoryHandleRemoveParams(int version) {
      super(16, version);
    }

    public FileSystemAccessDirectoryHandleRemoveParams() {
      this(0);
    }

    public static FileSystemAccessDirectoryHandleRemoveParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessDirectoryHandleRemoveParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessDirectoryHandleRemoveParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessDirectoryHandleRemoveParams result =
            new FileSystemAccessDirectoryHandleRemoveParams(elementsOrVersion);
        result.recurse = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.recurse, 8, 0);
    }
  }

  static final class FileSystemAccessDirectoryHandleRemoveResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public FileSystemAccessError result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessDirectoryHandleRemoveResponseParams(int version) {
      super(16, version);
    }

    public FileSystemAccessDirectoryHandleRemoveResponseParams() {
      this(0);
    }

    public static FileSystemAccessDirectoryHandleRemoveResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessDirectoryHandleRemoveResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessDirectoryHandleRemoveResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessDirectoryHandleRemoveResponseParams result =
            new FileSystemAccessDirectoryHandleRemoveResponseParams(elementsOrVersion);
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

  static class FileSystemAccessDirectoryHandleRemoveResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FileSystemAccessDirectoryHandle.Remove_Response mCallback;

    FileSystemAccessDirectoryHandleRemoveResponseParamsForwardToCallback(
        FileSystemAccessDirectoryHandle.Remove_Response callback) {
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
        FileSystemAccessDirectoryHandleRemoveResponseParams response =
            FileSystemAccessDirectoryHandleRemoveResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FileSystemAccessDirectoryHandleRemoveResponseParamsProxyToResponder
      implements FileSystemAccessDirectoryHandle.Remove_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FileSystemAccessDirectoryHandleRemoveResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(FileSystemAccessError result) {
      FileSystemAccessDirectoryHandleRemoveResponseParams _response =
          new FileSystemAccessDirectoryHandleRemoveResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(7, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FileSystemAccessDirectoryHandleRemoveEntryParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public String basename;
    public boolean recurse;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessDirectoryHandleRemoveEntryParams(int version) {
      super(24, version);
    }

    public FileSystemAccessDirectoryHandleRemoveEntryParams() {
      this(0);
    }

    public static FileSystemAccessDirectoryHandleRemoveEntryParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessDirectoryHandleRemoveEntryParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessDirectoryHandleRemoveEntryParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessDirectoryHandleRemoveEntryParams result =
            new FileSystemAccessDirectoryHandleRemoveEntryParams(elementsOrVersion);
        result.basename = decoder0.readString(8, false);
        result.recurse = decoder0.readBoolean(16, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.basename, 8, false);
      encoder0.encode(this.recurse, 16, 0);
    }
  }

  static final class FileSystemAccessDirectoryHandleRemoveEntryResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public FileSystemAccessError result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessDirectoryHandleRemoveEntryResponseParams(int version) {
      super(16, version);
    }

    public FileSystemAccessDirectoryHandleRemoveEntryResponseParams() {
      this(0);
    }

    public static FileSystemAccessDirectoryHandleRemoveEntryResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessDirectoryHandleRemoveEntryResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessDirectoryHandleRemoveEntryResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessDirectoryHandleRemoveEntryResponseParams result =
            new FileSystemAccessDirectoryHandleRemoveEntryResponseParams(elementsOrVersion);
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

  static class FileSystemAccessDirectoryHandleRemoveEntryResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FileSystemAccessDirectoryHandle.RemoveEntry_Response mCallback;

    FileSystemAccessDirectoryHandleRemoveEntryResponseParamsForwardToCallback(
        FileSystemAccessDirectoryHandle.RemoveEntry_Response callback) {
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
        FileSystemAccessDirectoryHandleRemoveEntryResponseParams response =
            FileSystemAccessDirectoryHandleRemoveEntryResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FileSystemAccessDirectoryHandleRemoveEntryResponseParamsProxyToResponder
      implements FileSystemAccessDirectoryHandle.RemoveEntry_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FileSystemAccessDirectoryHandleRemoveEntryResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(FileSystemAccessError result) {
      FileSystemAccessDirectoryHandleRemoveEntryResponseParams _response =
          new FileSystemAccessDirectoryHandleRemoveEntryResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(8, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FileSystemAccessDirectoryHandleResolveParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public FileSystemAccessTransferToken possibleChild;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessDirectoryHandleResolveParams(int version) {
      super(16, version);
    }

    public FileSystemAccessDirectoryHandleResolveParams() {
      this(0);
    }

    public static FileSystemAccessDirectoryHandleResolveParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessDirectoryHandleResolveParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessDirectoryHandleResolveParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessDirectoryHandleResolveParams result =
            new FileSystemAccessDirectoryHandleResolveParams(elementsOrVersion);
        result.possibleChild =
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
      encoder0.encode(this.possibleChild, 8, false, FileSystemAccessTransferToken.MANAGER);
    }
  }

  static final class FileSystemAccessDirectoryHandleResolveResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public String[] path;
    public FileSystemAccessError result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessDirectoryHandleResolveResponseParams(int version) {
      super(24, version);
    }

    public FileSystemAccessDirectoryHandleResolveResponseParams() {
      this(0);
    }

    public static FileSystemAccessDirectoryHandleResolveResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessDirectoryHandleResolveResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessDirectoryHandleResolveResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessDirectoryHandleResolveResponseParams result =
            new FileSystemAccessDirectoryHandleResolveResponseParams(elementsOrVersion);
        result.result = FileSystemAccessError.decode(decoder0.readPointer(8, false));
        Decoder decoder1 = decoder0.readPointer(16, true);
        if (decoder1 == null) {
          result.path = null;
        } else {
          DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
          result.path = new String[si1.elementsOrVersion];
          for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
            result.path[i1] = decoder1.readString((i1 * 8) + 8, false);
          }
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
      String[] strArr = this.path;
      if (strArr == null) {
        encoder0.encodeNullPointer(16, true);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(strArr.length, 16, -1);
      int i0 = 0;
      while (true) {
        String[] strArr2 = this.path;
        if (i0 < strArr2.length) {
          encoder1.encode(strArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static class FileSystemAccessDirectoryHandleResolveResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FileSystemAccessDirectoryHandle.Resolve_Response mCallback;

    FileSystemAccessDirectoryHandleResolveResponseParamsForwardToCallback(
        FileSystemAccessDirectoryHandle.Resolve_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(9, 2)) {
          return false;
        }
        FileSystemAccessDirectoryHandleResolveResponseParams response =
            FileSystemAccessDirectoryHandleResolveResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result, response.path);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FileSystemAccessDirectoryHandleResolveResponseParamsProxyToResponder
      implements FileSystemAccessDirectoryHandle.Resolve_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FileSystemAccessDirectoryHandleResolveResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(FileSystemAccessError result, String[] path) {
      FileSystemAccessDirectoryHandleResolveResponseParams _response =
          new FileSystemAccessDirectoryHandleResolveResponseParams();
      _response.result = result;
      _response.path = path;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(9, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FileSystemAccessDirectoryHandleTransferParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<FileSystemAccessTransferToken> token;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessDirectoryHandleTransferParams(int version) {
      super(16, version);
    }

    public FileSystemAccessDirectoryHandleTransferParams() {
      this(0);
    }

    public static FileSystemAccessDirectoryHandleTransferParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessDirectoryHandleTransferParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessDirectoryHandleTransferParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessDirectoryHandleTransferParams result =
            new FileSystemAccessDirectoryHandleTransferParams(elementsOrVersion);
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

  static final class FileSystemAccessDirectoryHandleGetUniqueIdParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessDirectoryHandleGetUniqueIdParams(int version) {
      super(8, version);
    }

    public FileSystemAccessDirectoryHandleGetUniqueIdParams() {
      this(0);
    }

    public static FileSystemAccessDirectoryHandleGetUniqueIdParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessDirectoryHandleGetUniqueIdParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessDirectoryHandleGetUniqueIdParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessDirectoryHandleGetUniqueIdParams result =
            new FileSystemAccessDirectoryHandleGetUniqueIdParams(elementsOrVersion);
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

  static final class FileSystemAccessDirectoryHandleGetUniqueIdResponseParams extends Struct {
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

    private FileSystemAccessDirectoryHandleGetUniqueIdResponseParams(int version) {
      super(24, version);
    }

    public FileSystemAccessDirectoryHandleGetUniqueIdResponseParams() {
      this(0);
    }

    public static FileSystemAccessDirectoryHandleGetUniqueIdResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessDirectoryHandleGetUniqueIdResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessDirectoryHandleGetUniqueIdResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessDirectoryHandleGetUniqueIdResponseParams result =
            new FileSystemAccessDirectoryHandleGetUniqueIdResponseParams(elementsOrVersion);
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

  static class FileSystemAccessDirectoryHandleGetUniqueIdResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FileSystemAccessDirectoryHandle.GetUniqueId_Response mCallback;

    FileSystemAccessDirectoryHandleGetUniqueIdResponseParamsForwardToCallback(
        FileSystemAccessDirectoryHandle.GetUniqueId_Response callback) {
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
        FileSystemAccessDirectoryHandleGetUniqueIdResponseParams response =
            FileSystemAccessDirectoryHandleGetUniqueIdResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result, response.id);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FileSystemAccessDirectoryHandleGetUniqueIdResponseParamsProxyToResponder
      implements FileSystemAccessDirectoryHandle.GetUniqueId_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FileSystemAccessDirectoryHandleGetUniqueIdResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(FileSystemAccessError result, String id) {
      FileSystemAccessDirectoryHandleGetUniqueIdResponseParams _response =
          new FileSystemAccessDirectoryHandleGetUniqueIdResponseParams();
      _response.result = result;
      _response.id = id;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(11, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FileSystemAccessDirectoryHandleGetCloudIdentifiersParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessDirectoryHandleGetCloudIdentifiersParams(int version) {
      super(8, version);
    }

    public FileSystemAccessDirectoryHandleGetCloudIdentifiersParams() {
      this(0);
    }

    public static FileSystemAccessDirectoryHandleGetCloudIdentifiersParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessDirectoryHandleGetCloudIdentifiersParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessDirectoryHandleGetCloudIdentifiersParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessDirectoryHandleGetCloudIdentifiersParams result =
            new FileSystemAccessDirectoryHandleGetCloudIdentifiersParams(elementsOrVersion);
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

  static final class FileSystemAccessDirectoryHandleGetCloudIdentifiersResponseParams
      extends Struct {
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

    private FileSystemAccessDirectoryHandleGetCloudIdentifiersResponseParams(int version) {
      super(24, version);
    }

    public FileSystemAccessDirectoryHandleGetCloudIdentifiersResponseParams() {
      this(0);
    }

    public static FileSystemAccessDirectoryHandleGetCloudIdentifiersResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessDirectoryHandleGetCloudIdentifiersResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessDirectoryHandleGetCloudIdentifiersResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessDirectoryHandleGetCloudIdentifiersResponseParams result =
            new FileSystemAccessDirectoryHandleGetCloudIdentifiersResponseParams(elementsOrVersion);
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

  static class FileSystemAccessDirectoryHandleGetCloudIdentifiersResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FileSystemAccessDirectoryHandle.GetCloudIdentifiers_Response mCallback;

    FileSystemAccessDirectoryHandleGetCloudIdentifiersResponseParamsForwardToCallback(
        FileSystemAccessDirectoryHandle.GetCloudIdentifiers_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(12, 2)) {
          return false;
        }
        FileSystemAccessDirectoryHandleGetCloudIdentifiersResponseParams response =
            FileSystemAccessDirectoryHandleGetCloudIdentifiersResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result, response.cloudIdentifiers);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FileSystemAccessDirectoryHandleGetCloudIdentifiersResponseParamsProxyToResponder
      implements FileSystemAccessDirectoryHandle.GetCloudIdentifiers_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FileSystemAccessDirectoryHandleGetCloudIdentifiersResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(
        FileSystemAccessError result, FileSystemAccessCloudIdentifier[] cloudIdentifiers) {
      FileSystemAccessDirectoryHandleGetCloudIdentifiersResponseParams _response =
          new FileSystemAccessDirectoryHandleGetCloudIdentifiersResponseParams();
      _response.result = result;
      _response.cloudIdentifiers = cloudIdentifiers;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(12, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
