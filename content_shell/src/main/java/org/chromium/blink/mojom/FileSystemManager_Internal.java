package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.filesystem.mojom.DirectoryEntry;
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
import org.chromium.mojo_base.mojom.FileError;
import org.chromium.mojo_base.mojom.FileInfo;
import org.chromium.mojo_base.mojom.FilePath;
import org.chromium.mojo_base.mojom.Time;
import org.chromium.url.internal.mojom.Origin;
import org.chromium.url.mojom.Url;

class FileSystemManager_Internal {
  private static final int COPY_ORDINAL = 3;
  private static final int CREATE_ORDINAL = 6;
  private static final int CREATE_SNAPSHOT_FILE_ORDINAL = 14;
  private static final int EXISTS_ORDINAL = 7;
  private static final int GET_PLATFORM_PATH_ORDINAL = 15;
  public static final Interface.Manager<FileSystemManager, FileSystemManager.Proxy> MANAGER =
      new Interface.Manager<FileSystemManager, FileSystemManager.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.FileSystemManager";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public FileSystemManager.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, FileSystemManager impl) {
          return new Stub(core, impl);
        }

        @Override
        public FileSystemManager[] buildArray(int size) {
          return new FileSystemManager[size];
        }
      };
  private static final int MOVE_ORDINAL = 2;
  private static final int OPEN_ORDINAL = 0;
  private static final int READ_DIRECTORY_ORDINAL = 8;
  private static final int READ_DIRECTORY_SYNC_ORDINAL = 9;
  private static final int READ_METADATA_ORDINAL = 5;
  private static final int REGISTER_BLOB_ORDINAL = 16;
  private static final int REMOVE_ORDINAL = 4;
  private static final int RESOLVE_URL_ORDINAL = 1;
  private static final int TRUNCATE_ORDINAL = 12;
  private static final int TRUNCATE_SYNC_ORDINAL = 13;
  private static final int WRITE_ORDINAL = 10;
  private static final int WRITE_SYNC_ORDINAL = 11;

  FileSystemManager_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements FileSystemManager.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void open(Origin origin, int fileSystemType, Open_Response callback) {
      FileSystemManagerOpenParams _message = new FileSystemManagerOpenParams();
      _message.origin = origin;
      _message.fileSystemType = fileSystemType;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new FileSystemManagerOpenResponseParamsForwardToCallback(callback));
    }

    @Override
    public void resolveUrl(Url filesystemUrl, ResolveUrl_Response callback) {
      FileSystemManagerResolveUrlParams _message = new FileSystemManagerResolveUrlParams();
      _message.filesystemUrl = filesystemUrl;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new FileSystemManagerResolveUrlResponseParamsForwardToCallback(callback));
    }

    @Override
    public void move(Url srcPath, Url destPath, Move_Response callback) {
      FileSystemManagerMoveParams _message = new FileSystemManagerMoveParams();
      _message.srcPath = srcPath;
      _message.destPath = destPath;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new FileSystemManagerMoveResponseParamsForwardToCallback(callback));
    }

    @Override
    public void copy(Url srcPath, Url destPath, Copy_Response callback) {
      FileSystemManagerCopyParams _message = new FileSystemManagerCopyParams();
      _message.srcPath = srcPath;
      _message.destPath = destPath;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)),
              new FileSystemManagerCopyResponseParamsForwardToCallback(callback));
    }

    @Override
    public void remove(Url path, boolean recursive, Remove_Response callback) {
      FileSystemManagerRemoveParams _message = new FileSystemManagerRemoveParams();
      _message.path = path;
      _message.recursive = recursive;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)),
              new FileSystemManagerRemoveResponseParamsForwardToCallback(callback));
    }

    @Override
    public void readMetadata(Url path, ReadMetadata_Response callback) {
      FileSystemManagerReadMetadataParams _message = new FileSystemManagerReadMetadataParams();
      _message.path = path;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(5, 1, 0L)),
              new FileSystemManagerReadMetadataResponseParamsForwardToCallback(callback));
    }

    @Override
    public void create(
        Url path,
        boolean exclusive,
        boolean isDirectory,
        boolean recursive,
        Create_Response callback) {
      FileSystemManagerCreateParams _message = new FileSystemManagerCreateParams();
      _message.path = path;
      _message.exclusive = exclusive;
      _message.isDirectory = isDirectory;
      _message.recursive = recursive;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(6, 1, 0L)),
              new FileSystemManagerCreateResponseParamsForwardToCallback(callback));
    }

    @Override
    public void exists(Url path, boolean isDirectory, Exists_Response callback) {
      FileSystemManagerExistsParams _message = new FileSystemManagerExistsParams();
      _message.path = path;
      _message.isDirectory = isDirectory;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(7, 1, 0L)),
              new FileSystemManagerExistsResponseParamsForwardToCallback(callback));
    }

    @Override
    public void readDirectory(Url path, FileSystemOperationListener listener) {
      FileSystemManagerReadDirectoryParams _message = new FileSystemManagerReadDirectoryParams();
      _message.path = path;
      _message.listener = listener;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(8)));
    }

    @Override
    public void readDirectorySync(Url path, ReadDirectorySync_Response callback) {
      FileSystemManagerReadDirectorySyncParams _message =
          new FileSystemManagerReadDirectorySyncParams();
      _message.path = path;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(9, 1, 0L)),
              new FileSystemManagerReadDirectorySyncResponseParamsForwardToCallback(callback));
    }

    @Override
    public void write(
        Url filePath,
        Blob blob,
        long position,
        InterfaceRequest<FileSystemCancellableOperation> opReceiver,
        FileSystemOperationListener listener) {
      FileSystemManagerWriteParams _message = new FileSystemManagerWriteParams();
      _message.filePath = filePath;
      _message.blob = blob;
      _message.position = position;
      _message.opReceiver = opReceiver;
      _message.listener = listener;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(10)));
    }

    @Override
    public void writeSync(Url filePath, Blob blob, long position, WriteSync_Response callback) {
      FileSystemManagerWriteSyncParams _message = new FileSystemManagerWriteSyncParams();
      _message.filePath = filePath;
      _message.blob = blob;
      _message.position = position;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(11, 1, 0L)),
              new FileSystemManagerWriteSyncResponseParamsForwardToCallback(callback));
    }

    @Override
    public void truncate(
        Url filePath,
        long length,
        InterfaceRequest<FileSystemCancellableOperation> opReceiver,
        Truncate_Response callback) {
      FileSystemManagerTruncateParams _message = new FileSystemManagerTruncateParams();
      _message.filePath = filePath;
      _message.length = length;
      _message.opReceiver = opReceiver;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(12, 1, 0L)),
              new FileSystemManagerTruncateResponseParamsForwardToCallback(callback));
    }

    @Override
    public void truncateSync(Url filePath, long length, TruncateSync_Response callback) {
      FileSystemManagerTruncateSyncParams _message = new FileSystemManagerTruncateSyncParams();
      _message.filePath = filePath;
      _message.length = length;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(13, 1, 0L)),
              new FileSystemManagerTruncateSyncResponseParamsForwardToCallback(callback));
    }

    @Override
    public void createSnapshotFile(Url filePath, CreateSnapshotFile_Response callback) {
      FileSystemManagerCreateSnapshotFileParams _message =
          new FileSystemManagerCreateSnapshotFileParams();
      _message.filePath = filePath;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(14, 1, 0L)),
              new FileSystemManagerCreateSnapshotFileResponseParamsForwardToCallback(callback));
    }

    @Override
    public void getPlatformPath(Url filePath, GetPlatformPath_Response callback) {
      FileSystemManagerGetPlatformPathParams _message =
          new FileSystemManagerGetPlatformPathParams();
      _message.filePath = filePath;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(15, 1, 0L)),
              new FileSystemManagerGetPlatformPathResponseParamsForwardToCallback(callback));
    }

    @Override
    public void registerBlob(
        String contentType,
        Url url,
        long length,
        Time expectedModificationTime,
        RegisterBlob_Response callback) {
      FileSystemManagerRegisterBlobParams _message = new FileSystemManagerRegisterBlobParams();
      _message.contentType = contentType;
      _message.url = url;
      _message.length = length;
      _message.expectedModificationTime = expectedModificationTime;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(16, 1, 0L)),
              new FileSystemManagerRegisterBlobResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<FileSystemManager> {
    Stub(Core core, FileSystemManager impl) {
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
                FileSystemManager_Internal.MANAGER, messageWithHeader);
          case 8:
            FileSystemManagerReadDirectoryParams data =
                FileSystemManagerReadDirectoryParams.deserialize(messageWithHeader.getPayload());
            getImpl().readDirectory(data.path, data.listener);
            return true;
          case 10:
            FileSystemManagerWriteParams data2 =
                FileSystemManagerWriteParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .write(
                    data2.filePath, data2.blob, data2.position, data2.opReceiver, data2.listener);
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
                getCore(), FileSystemManager_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            FileSystemManagerOpenParams data =
                FileSystemManagerOpenParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .open(
                    data.origin,
                    data.fileSystemType,
                    new FileSystemManagerOpenResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
            getImpl()
                .resolveUrl(
                    FileSystemManagerResolveUrlParams.deserialize(messageWithHeader.getPayload())
                        .filesystemUrl,
                    new FileSystemManagerResolveUrlResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 2:
            FileSystemManagerMoveParams data2 =
                FileSystemManagerMoveParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .move(
                    data2.srcPath,
                    data2.destPath,
                    new FileSystemManagerMoveResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 3:
            FileSystemManagerCopyParams data3 =
                FileSystemManagerCopyParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .copy(
                    data3.srcPath,
                    data3.destPath,
                    new FileSystemManagerCopyResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 4:
            FileSystemManagerRemoveParams data4 =
                FileSystemManagerRemoveParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .remove(
                    data4.path,
                    data4.recursive,
                    new FileSystemManagerRemoveResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 5:
            getImpl()
                .readMetadata(
                    FileSystemManagerReadMetadataParams.deserialize(messageWithHeader.getPayload())
                        .path,
                    new FileSystemManagerReadMetadataResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 6:
            FileSystemManagerCreateParams data5 =
                FileSystemManagerCreateParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .create(
                    data5.path,
                    data5.exclusive,
                    data5.isDirectory,
                    data5.recursive,
                    new FileSystemManagerCreateResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 7:
            FileSystemManagerExistsParams data6 =
                FileSystemManagerExistsParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .exists(
                    data6.path,
                    data6.isDirectory,
                    new FileSystemManagerExistsResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 8:
          case 10:
          default:
            return false;
          case 9:
            getImpl()
                .readDirectorySync(
                    FileSystemManagerReadDirectorySyncParams.deserialize(
                            messageWithHeader.getPayload())
                        .path,
                    new FileSystemManagerReadDirectorySyncResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 11:
            FileSystemManagerWriteSyncParams data7 =
                FileSystemManagerWriteSyncParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .writeSync(
                    data7.filePath,
                    data7.blob,
                    data7.position,
                    new FileSystemManagerWriteSyncResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 12:
            FileSystemManagerTruncateParams data8 =
                FileSystemManagerTruncateParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .truncate(
                    data8.filePath,
                    data8.length,
                    data8.opReceiver,
                    new FileSystemManagerTruncateResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 13:
            FileSystemManagerTruncateSyncParams data9 =
                FileSystemManagerTruncateSyncParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .truncateSync(
                    data9.filePath,
                    data9.length,
                    new FileSystemManagerTruncateSyncResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 14:
            getImpl()
                .createSnapshotFile(
                    FileSystemManagerCreateSnapshotFileParams.deserialize(
                            messageWithHeader.getPayload())
                        .filePath,
                    new FileSystemManagerCreateSnapshotFileResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 15:
            getImpl()
                .getPlatformPath(
                    FileSystemManagerGetPlatformPathParams.deserialize(
                            messageWithHeader.getPayload())
                        .filePath,
                    new FileSystemManagerGetPlatformPathResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 16:
            FileSystemManagerRegisterBlobParams data10 =
                FileSystemManagerRegisterBlobParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .registerBlob(
                    data10.contentType,
                    data10.url,
                    data10.length,
                    data10.expectedModificationTime,
                    new FileSystemManagerRegisterBlobResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class FileSystemManagerOpenParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int fileSystemType;
    public Origin origin;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemManagerOpenParams(int version) {
      super(24, version);
    }

    public FileSystemManagerOpenParams() {
      this(0);
    }

    public static FileSystemManagerOpenParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemManagerOpenParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemManagerOpenParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemManagerOpenParams result = new FileSystemManagerOpenParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.origin = Origin.decode(decoder1);
        int readInt = decoder0.readInt(16);
        result.fileSystemType = readInt;
        FileSystemType.validate(readInt);
        result.fileSystemType = FileSystemType.toKnownValue(result.fileSystemType);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.origin, 8, false);
      encoder0.encode(this.fileSystemType, 16);
    }
  }

  static final class FileSystemManagerOpenResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public int errorCode;
    public String name;
    public Url rootUrl;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemManagerOpenResponseParams(int version) {
      super(32, version);
    }

    public FileSystemManagerOpenResponseParams() {
      this(0);
    }

    public static FileSystemManagerOpenResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemManagerOpenResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemManagerOpenResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemManagerOpenResponseParams result =
            new FileSystemManagerOpenResponseParams(elementsOrVersion);
        result.name = decoder0.readString(8, false);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.rootUrl = Url.decode(decoder1);
        int readInt = decoder0.readInt(24);
        result.errorCode = readInt;
        FileError.validate(readInt);
        result.errorCode = FileError.toKnownValue(result.errorCode);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.name, 8, false);
      encoder0.encode((Struct) this.rootUrl, 16, false);
      encoder0.encode(this.errorCode, 24);
    }
  }

  static class FileSystemManagerOpenResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final FileSystemManager.Open_Response mCallback;

    FileSystemManagerOpenResponseParamsForwardToCallback(FileSystemManager.Open_Response callback) {
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
        FileSystemManagerOpenResponseParams response =
            FileSystemManagerOpenResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.name, response.rootUrl, response.errorCode);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FileSystemManagerOpenResponseParamsProxyToResponder
      implements FileSystemManager.Open_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FileSystemManagerOpenResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(String name, Url rootUrl, int errorCode) {
      FileSystemManagerOpenResponseParams _response = new FileSystemManagerOpenResponseParams();
      _response.name = name;
      _response.rootUrl = rootUrl;
      _response.errorCode = errorCode;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FileSystemManagerResolveUrlParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Url filesystemUrl;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemManagerResolveUrlParams(int version) {
      super(16, version);
    }

    public FileSystemManagerResolveUrlParams() {
      this(0);
    }

    public static FileSystemManagerResolveUrlParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemManagerResolveUrlParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemManagerResolveUrlParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemManagerResolveUrlParams result =
            new FileSystemManagerResolveUrlParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.filesystemUrl = Url.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.filesystemUrl, 8, false);
    }
  }

  static final class FileSystemManagerResolveUrlResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public int errorCode;
    public FilePath filePath;
    public FileSystemInfo info;
    public boolean isDirectory;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemManagerResolveUrlResponseParams(int version) {
      super(32, version);
    }

    public FileSystemManagerResolveUrlResponseParams() {
      this(0);
    }

    public static FileSystemManagerResolveUrlResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemManagerResolveUrlResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemManagerResolveUrlResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemManagerResolveUrlResponseParams result =
            new FileSystemManagerResolveUrlResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.info = FileSystemInfo.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.filePath = FilePath.decode(decoder12);
        result.isDirectory = decoder0.readBoolean(24, 0);
        int readInt = decoder0.readInt(28);
        result.errorCode = readInt;
        FileError.validate(readInt);
        result.errorCode = FileError.toKnownValue(result.errorCode);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.info, 8, false);
      encoder0.encode((Struct) this.filePath, 16, false);
      encoder0.encode(this.isDirectory, 24, 0);
      encoder0.encode(this.errorCode, 28);
    }
  }

  static class FileSystemManagerResolveUrlResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FileSystemManager.ResolveUrl_Response mCallback;

    FileSystemManagerResolveUrlResponseParamsForwardToCallback(
        FileSystemManager.ResolveUrl_Response callback) {
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
        FileSystemManagerResolveUrlResponseParams response =
            FileSystemManagerResolveUrlResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(
            response.info, response.filePath, response.isDirectory, response.errorCode);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FileSystemManagerResolveUrlResponseParamsProxyToResponder
      implements FileSystemManager.ResolveUrl_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FileSystemManagerResolveUrlResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(FileSystemInfo info, FilePath filePath, boolean isDirectory, int errorCode) {
      FileSystemManagerResolveUrlResponseParams _response =
          new FileSystemManagerResolveUrlResponseParams();
      _response.info = info;
      _response.filePath = filePath;
      _response.isDirectory = isDirectory;
      _response.errorCode = errorCode;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FileSystemManagerMoveParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public Url destPath;
    public Url srcPath;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemManagerMoveParams(int version) {
      super(24, version);
    }

    public FileSystemManagerMoveParams() {
      this(0);
    }

    public static FileSystemManagerMoveParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemManagerMoveParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemManagerMoveParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemManagerMoveParams result = new FileSystemManagerMoveParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.srcPath = Url.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.destPath = Url.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.srcPath, 8, false);
      encoder0.encode((Struct) this.destPath, 16, false);
    }
  }

  static final class FileSystemManagerMoveResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int errorCode;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemManagerMoveResponseParams(int version) {
      super(16, version);
    }

    public FileSystemManagerMoveResponseParams() {
      this(0);
    }

    public static FileSystemManagerMoveResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemManagerMoveResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemManagerMoveResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemManagerMoveResponseParams result =
            new FileSystemManagerMoveResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.errorCode = readInt;
        FileError.validate(readInt);
        result.errorCode = FileError.toKnownValue(result.errorCode);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.errorCode, 8);
    }
  }

  static class FileSystemManagerMoveResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final FileSystemManager.Move_Response mCallback;

    FileSystemManagerMoveResponseParamsForwardToCallback(FileSystemManager.Move_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(2, 6)) {
          return false;
        }
        FileSystemManagerMoveResponseParams response =
            FileSystemManagerMoveResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.errorCode);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FileSystemManagerMoveResponseParamsProxyToResponder
      implements FileSystemManager.Move_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FileSystemManagerMoveResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int errorCode) {
      FileSystemManagerMoveResponseParams _response = new FileSystemManagerMoveResponseParams();
      _response.errorCode = errorCode;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FileSystemManagerCopyParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public Url destPath;
    public Url srcPath;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemManagerCopyParams(int version) {
      super(24, version);
    }

    public FileSystemManagerCopyParams() {
      this(0);
    }

    public static FileSystemManagerCopyParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemManagerCopyParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemManagerCopyParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemManagerCopyParams result = new FileSystemManagerCopyParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.srcPath = Url.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.destPath = Url.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.srcPath, 8, false);
      encoder0.encode((Struct) this.destPath, 16, false);
    }
  }

  static final class FileSystemManagerCopyResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int errorCode;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemManagerCopyResponseParams(int version) {
      super(16, version);
    }

    public FileSystemManagerCopyResponseParams() {
      this(0);
    }

    public static FileSystemManagerCopyResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemManagerCopyResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemManagerCopyResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemManagerCopyResponseParams result =
            new FileSystemManagerCopyResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.errorCode = readInt;
        FileError.validate(readInt);
        result.errorCode = FileError.toKnownValue(result.errorCode);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.errorCode, 8);
    }
  }

  static class FileSystemManagerCopyResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final FileSystemManager.Copy_Response mCallback;

    FileSystemManagerCopyResponseParamsForwardToCallback(FileSystemManager.Copy_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(3, 6)) {
          return false;
        }
        FileSystemManagerCopyResponseParams response =
            FileSystemManagerCopyResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.errorCode);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FileSystemManagerCopyResponseParamsProxyToResponder
      implements FileSystemManager.Copy_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FileSystemManagerCopyResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int errorCode) {
      FileSystemManagerCopyResponseParams _response = new FileSystemManagerCopyResponseParams();
      _response.errorCode = errorCode;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(3, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FileSystemManagerRemoveParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public Url path;
    public boolean recursive;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemManagerRemoveParams(int version) {
      super(24, version);
    }

    public FileSystemManagerRemoveParams() {
      this(0);
    }

    public static FileSystemManagerRemoveParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemManagerRemoveParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemManagerRemoveParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemManagerRemoveParams result = new FileSystemManagerRemoveParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.path = Url.decode(decoder1);
        result.recursive = decoder0.readBoolean(16, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.path, 8, false);
      encoder0.encode(this.recursive, 16, 0);
    }
  }

  static final class FileSystemManagerRemoveResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int errorCode;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemManagerRemoveResponseParams(int version) {
      super(16, version);
    }

    public FileSystemManagerRemoveResponseParams() {
      this(0);
    }

    public static FileSystemManagerRemoveResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemManagerRemoveResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemManagerRemoveResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemManagerRemoveResponseParams result =
            new FileSystemManagerRemoveResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.errorCode = readInt;
        FileError.validate(readInt);
        result.errorCode = FileError.toKnownValue(result.errorCode);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.errorCode, 8);
    }
  }

  static class FileSystemManagerRemoveResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FileSystemManager.Remove_Response mCallback;

    FileSystemManagerRemoveResponseParamsForwardToCallback(
        FileSystemManager.Remove_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(4, 6)) {
          return false;
        }
        FileSystemManagerRemoveResponseParams response =
            FileSystemManagerRemoveResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.errorCode);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FileSystemManagerRemoveResponseParamsProxyToResponder
      implements FileSystemManager.Remove_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FileSystemManagerRemoveResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int errorCode) {
      FileSystemManagerRemoveResponseParams _response = new FileSystemManagerRemoveResponseParams();
      _response.errorCode = errorCode;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(4, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FileSystemManagerReadMetadataParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Url path;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemManagerReadMetadataParams(int version) {
      super(16, version);
    }

    public FileSystemManagerReadMetadataParams() {
      this(0);
    }

    public static FileSystemManagerReadMetadataParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemManagerReadMetadataParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemManagerReadMetadataParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemManagerReadMetadataParams result =
            new FileSystemManagerReadMetadataParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.path = Url.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.path, 8, false);
    }
  }

  static final class FileSystemManagerReadMetadataResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int errorCode;
    public FileInfo fileInfo;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemManagerReadMetadataResponseParams(int version) {
      super(24, version);
    }

    public FileSystemManagerReadMetadataResponseParams() {
      this(0);
    }

    public static FileSystemManagerReadMetadataResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemManagerReadMetadataResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemManagerReadMetadataResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemManagerReadMetadataResponseParams result =
            new FileSystemManagerReadMetadataResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.fileInfo = FileInfo.decode(decoder1);
        int readInt = decoder0.readInt(16);
        result.errorCode = readInt;
        FileError.validate(readInt);
        result.errorCode = FileError.toKnownValue(result.errorCode);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.fileInfo, 8, false);
      encoder0.encode(this.errorCode, 16);
    }
  }

  static class FileSystemManagerReadMetadataResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FileSystemManager.ReadMetadata_Response mCallback;

    FileSystemManagerReadMetadataResponseParamsForwardToCallback(
        FileSystemManager.ReadMetadata_Response callback) {
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
        FileSystemManagerReadMetadataResponseParams response =
            FileSystemManagerReadMetadataResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.fileInfo, response.errorCode);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FileSystemManagerReadMetadataResponseParamsProxyToResponder
      implements FileSystemManager.ReadMetadata_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FileSystemManagerReadMetadataResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(FileInfo fileInfo, int errorCode) {
      FileSystemManagerReadMetadataResponseParams _response =
          new FileSystemManagerReadMetadataResponseParams();
      _response.fileInfo = fileInfo;
      _response.errorCode = errorCode;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(5, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FileSystemManagerCreateParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean exclusive;
    public boolean isDirectory;
    public Url path;
    public boolean recursive;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemManagerCreateParams(int version) {
      super(24, version);
    }

    public FileSystemManagerCreateParams() {
      this(0);
    }

    public static FileSystemManagerCreateParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemManagerCreateParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemManagerCreateParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemManagerCreateParams result = new FileSystemManagerCreateParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.path = Url.decode(decoder1);
        result.exclusive = decoder0.readBoolean(16, 0);
        result.isDirectory = decoder0.readBoolean(16, 1);
        result.recursive = decoder0.readBoolean(16, 2);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.path, 8, false);
      encoder0.encode(this.exclusive, 16, 0);
      encoder0.encode(this.isDirectory, 16, 1);
      encoder0.encode(this.recursive, 16, 2);
    }
  }

  static final class FileSystemManagerCreateResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int errorCode;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemManagerCreateResponseParams(int version) {
      super(16, version);
    }

    public FileSystemManagerCreateResponseParams() {
      this(0);
    }

    public static FileSystemManagerCreateResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemManagerCreateResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemManagerCreateResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemManagerCreateResponseParams result =
            new FileSystemManagerCreateResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.errorCode = readInt;
        FileError.validate(readInt);
        result.errorCode = FileError.toKnownValue(result.errorCode);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.errorCode, 8);
    }
  }

  static class FileSystemManagerCreateResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FileSystemManager.Create_Response mCallback;

    FileSystemManagerCreateResponseParamsForwardToCallback(
        FileSystemManager.Create_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(6, 6)) {
          return false;
        }
        FileSystemManagerCreateResponseParams response =
            FileSystemManagerCreateResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.errorCode);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FileSystemManagerCreateResponseParamsProxyToResponder
      implements FileSystemManager.Create_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FileSystemManagerCreateResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int errorCode) {
      FileSystemManagerCreateResponseParams _response = new FileSystemManagerCreateResponseParams();
      _response.errorCode = errorCode;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(6, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FileSystemManagerExistsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean isDirectory;
    public Url path;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemManagerExistsParams(int version) {
      super(24, version);
    }

    public FileSystemManagerExistsParams() {
      this(0);
    }

    public static FileSystemManagerExistsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemManagerExistsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemManagerExistsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemManagerExistsParams result = new FileSystemManagerExistsParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.path = Url.decode(decoder1);
        result.isDirectory = decoder0.readBoolean(16, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.path, 8, false);
      encoder0.encode(this.isDirectory, 16, 0);
    }
  }

  static final class FileSystemManagerExistsResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int errorCode;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemManagerExistsResponseParams(int version) {
      super(16, version);
    }

    public FileSystemManagerExistsResponseParams() {
      this(0);
    }

    public static FileSystemManagerExistsResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemManagerExistsResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemManagerExistsResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemManagerExistsResponseParams result =
            new FileSystemManagerExistsResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.errorCode = readInt;
        FileError.validate(readInt);
        result.errorCode = FileError.toKnownValue(result.errorCode);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.errorCode, 8);
    }
  }

  static class FileSystemManagerExistsResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FileSystemManager.Exists_Response mCallback;

    FileSystemManagerExistsResponseParamsForwardToCallback(
        FileSystemManager.Exists_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(7, 6)) {
          return false;
        }
        FileSystemManagerExistsResponseParams response =
            FileSystemManagerExistsResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.errorCode);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FileSystemManagerExistsResponseParamsProxyToResponder
      implements FileSystemManager.Exists_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FileSystemManagerExistsResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int errorCode) {
      FileSystemManagerExistsResponseParams _response = new FileSystemManagerExistsResponseParams();
      _response.errorCode = errorCode;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(7, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FileSystemManagerReadDirectoryParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public FileSystemOperationListener listener;
    public Url path;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemManagerReadDirectoryParams(int version) {
      super(24, version);
    }

    public FileSystemManagerReadDirectoryParams() {
      this(0);
    }

    public static FileSystemManagerReadDirectoryParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemManagerReadDirectoryParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemManagerReadDirectoryParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemManagerReadDirectoryParams result =
            new FileSystemManagerReadDirectoryParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.path = Url.decode(decoder1);
        result.listener =
            (FileSystemOperationListener)
                decoder0.readServiceInterface(16, false, FileSystemOperationListener.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.path, 8, false);
      encoder0.encode(this.listener, 16, false, FileSystemOperationListener.MANAGER);
    }
  }

  static final class FileSystemManagerReadDirectorySyncParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Url path;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemManagerReadDirectorySyncParams(int version) {
      super(16, version);
    }

    public FileSystemManagerReadDirectorySyncParams() {
      this(0);
    }

    public static FileSystemManagerReadDirectorySyncParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemManagerReadDirectorySyncParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemManagerReadDirectorySyncParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemManagerReadDirectorySyncParams result =
            new FileSystemManagerReadDirectorySyncParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.path = Url.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.path, 8, false);
    }
  }

  static final class FileSystemManagerReadDirectorySyncResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public DirectoryEntry[] entries;
    public int errorCode;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemManagerReadDirectorySyncResponseParams(int version) {
      super(24, version);
    }

    public FileSystemManagerReadDirectorySyncResponseParams() {
      this(0);
    }

    public static FileSystemManagerReadDirectorySyncResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemManagerReadDirectorySyncResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemManagerReadDirectorySyncResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemManagerReadDirectorySyncResponseParams result =
            new FileSystemManagerReadDirectorySyncResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.entries = new DirectoryEntry[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.entries[i1] = DirectoryEntry.decode(decoder2);
        }
        int readInt = decoder0.readInt(16);
        result.errorCode = readInt;
        FileError.validate(readInt);
        result.errorCode = FileError.toKnownValue(result.errorCode);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      DirectoryEntry[] directoryEntryArr = this.entries;
      if (directoryEntryArr == null) {
        encoder0.encodeNullPointer(8, false);
      } else {
        Encoder encoder1 = encoder0.encodePointerArray(directoryEntryArr.length, 8, -1);
        int i0 = 0;
        while (true) {
          DirectoryEntry[] directoryEntryArr2 = this.entries;
          if (i0 >= directoryEntryArr2.length) {
            break;
          }
          encoder1.encode((Struct) directoryEntryArr2[i0], (i0 * 8) + 8, false);
          i0++;
        }
      }
      encoder0.encode(this.errorCode, 16);
    }
  }

  static class FileSystemManagerReadDirectorySyncResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FileSystemManager.ReadDirectorySync_Response mCallback;

    FileSystemManagerReadDirectorySyncResponseParamsForwardToCallback(
        FileSystemManager.ReadDirectorySync_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(9, 6)) {
          return false;
        }
        FileSystemManagerReadDirectorySyncResponseParams response =
            FileSystemManagerReadDirectorySyncResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.entries, response.errorCode);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FileSystemManagerReadDirectorySyncResponseParamsProxyToResponder
      implements FileSystemManager.ReadDirectorySync_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FileSystemManagerReadDirectorySyncResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(DirectoryEntry[] entries, int errorCode) {
      FileSystemManagerReadDirectorySyncResponseParams _response =
          new FileSystemManagerReadDirectorySyncResponseParams();
      _response.entries = entries;
      _response.errorCode = errorCode;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(9, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FileSystemManagerWriteParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 48;
    private static final DataHeader[] VERSION_ARRAY;
    public Blob blob;
    public Url filePath;
    public FileSystemOperationListener listener;
    public InterfaceRequest<FileSystemCancellableOperation> opReceiver;
    public long position;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(48, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemManagerWriteParams(int version) {
      super(48, version);
    }

    public FileSystemManagerWriteParams() {
      this(0);
    }

    public static FileSystemManagerWriteParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemManagerWriteParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemManagerWriteParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemManagerWriteParams result = new FileSystemManagerWriteParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.filePath = Url.decode(decoder1);
        result.blob = (Blob) decoder0.readServiceInterface(16, false, Blob.MANAGER);
        result.position = decoder0.readLong(24);
        result.opReceiver = decoder0.readInterfaceRequest(32, false);
        result.listener =
            (FileSystemOperationListener)
                decoder0.readServiceInterface(36, false, FileSystemOperationListener.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.filePath, 8, false);
      encoder0.encode(this.blob, 16, false, Blob.MANAGER);
      encoder0.encode(this.position, 24);
      encoder0.encode((InterfaceRequest) this.opReceiver, 32, false);
      encoder0.encode(this.listener, 36, false, FileSystemOperationListener.MANAGER);
    }
  }

  static final class FileSystemManagerWriteSyncParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public Blob blob;
    public Url filePath;
    public long position;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemManagerWriteSyncParams(int version) {
      super(32, version);
    }

    public FileSystemManagerWriteSyncParams() {
      this(0);
    }

    public static FileSystemManagerWriteSyncParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemManagerWriteSyncParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemManagerWriteSyncParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemManagerWriteSyncParams result =
            new FileSystemManagerWriteSyncParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.filePath = Url.decode(decoder1);
        result.blob = (Blob) decoder0.readServiceInterface(16, false, Blob.MANAGER);
        result.position = decoder0.readLong(24);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.filePath, 8, false);
      encoder0.encode(this.blob, 16, false, Blob.MANAGER);
      encoder0.encode(this.position, 24);
    }
  }

  static final class FileSystemManagerWriteSyncResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public long byteCount;
    public int errorCode;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemManagerWriteSyncResponseParams(int version) {
      super(24, version);
    }

    public FileSystemManagerWriteSyncResponseParams() {
      this(0);
    }

    public static FileSystemManagerWriteSyncResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemManagerWriteSyncResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemManagerWriteSyncResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemManagerWriteSyncResponseParams result =
            new FileSystemManagerWriteSyncResponseParams(elementsOrVersion);
        result.byteCount = decoder0.readLong(8);
        int readInt = decoder0.readInt(16);
        result.errorCode = readInt;
        FileError.validate(readInt);
        result.errorCode = FileError.toKnownValue(result.errorCode);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.byteCount, 8);
      encoder0.encode(this.errorCode, 16);
    }
  }

  static class FileSystemManagerWriteSyncResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FileSystemManager.WriteSync_Response mCallback;

    FileSystemManagerWriteSyncResponseParamsForwardToCallback(
        FileSystemManager.WriteSync_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(11, 6)) {
          return false;
        }
        FileSystemManagerWriteSyncResponseParams response =
            FileSystemManagerWriteSyncResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.byteCount, response.errorCode);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FileSystemManagerWriteSyncResponseParamsProxyToResponder
      implements FileSystemManager.WriteSync_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FileSystemManagerWriteSyncResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(long byteCount, int errorCode) {
      FileSystemManagerWriteSyncResponseParams _response =
          new FileSystemManagerWriteSyncResponseParams();
      _response.byteCount = byteCount;
      _response.errorCode = errorCode;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(11, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FileSystemManagerTruncateParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public Url filePath;
    public long length;
    public InterfaceRequest<FileSystemCancellableOperation> opReceiver;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemManagerTruncateParams(int version) {
      super(32, version);
    }

    public FileSystemManagerTruncateParams() {
      this(0);
    }

    public static FileSystemManagerTruncateParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemManagerTruncateParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemManagerTruncateParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemManagerTruncateParams result =
            new FileSystemManagerTruncateParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.filePath = Url.decode(decoder1);
        result.length = decoder0.readLong(16);
        result.opReceiver = decoder0.readInterfaceRequest(24, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.filePath, 8, false);
      encoder0.encode(this.length, 16);
      encoder0.encode((InterfaceRequest) this.opReceiver, 24, false);
    }
  }

  static final class FileSystemManagerTruncateResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int errorCode;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemManagerTruncateResponseParams(int version) {
      super(16, version);
    }

    public FileSystemManagerTruncateResponseParams() {
      this(0);
    }

    public static FileSystemManagerTruncateResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemManagerTruncateResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemManagerTruncateResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemManagerTruncateResponseParams result =
            new FileSystemManagerTruncateResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.errorCode = readInt;
        FileError.validate(readInt);
        result.errorCode = FileError.toKnownValue(result.errorCode);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.errorCode, 8);
    }
  }

  static class FileSystemManagerTruncateResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FileSystemManager.Truncate_Response mCallback;

    FileSystemManagerTruncateResponseParamsForwardToCallback(
        FileSystemManager.Truncate_Response callback) {
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
        FileSystemManagerTruncateResponseParams response =
            FileSystemManagerTruncateResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.errorCode);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FileSystemManagerTruncateResponseParamsProxyToResponder
      implements FileSystemManager.Truncate_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FileSystemManagerTruncateResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int errorCode) {
      FileSystemManagerTruncateResponseParams _response =
          new FileSystemManagerTruncateResponseParams();
      _response.errorCode = errorCode;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(12, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FileSystemManagerTruncateSyncParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public Url filePath;
    public long length;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemManagerTruncateSyncParams(int version) {
      super(24, version);
    }

    public FileSystemManagerTruncateSyncParams() {
      this(0);
    }

    public static FileSystemManagerTruncateSyncParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemManagerTruncateSyncParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemManagerTruncateSyncParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemManagerTruncateSyncParams result =
            new FileSystemManagerTruncateSyncParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.filePath = Url.decode(decoder1);
        result.length = decoder0.readLong(16);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.filePath, 8, false);
      encoder0.encode(this.length, 16);
    }
  }

  static final class FileSystemManagerTruncateSyncResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int errorCode;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemManagerTruncateSyncResponseParams(int version) {
      super(16, version);
    }

    public FileSystemManagerTruncateSyncResponseParams() {
      this(0);
    }

    public static FileSystemManagerTruncateSyncResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemManagerTruncateSyncResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemManagerTruncateSyncResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemManagerTruncateSyncResponseParams result =
            new FileSystemManagerTruncateSyncResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.errorCode = readInt;
        FileError.validate(readInt);
        result.errorCode = FileError.toKnownValue(result.errorCode);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.errorCode, 8);
    }
  }

  static class FileSystemManagerTruncateSyncResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FileSystemManager.TruncateSync_Response mCallback;

    FileSystemManagerTruncateSyncResponseParamsForwardToCallback(
        FileSystemManager.TruncateSync_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(13, 6)) {
          return false;
        }
        FileSystemManagerTruncateSyncResponseParams response =
            FileSystemManagerTruncateSyncResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.errorCode);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FileSystemManagerTruncateSyncResponseParamsProxyToResponder
      implements FileSystemManager.TruncateSync_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FileSystemManagerTruncateSyncResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int errorCode) {
      FileSystemManagerTruncateSyncResponseParams _response =
          new FileSystemManagerTruncateSyncResponseParams();
      _response.errorCode = errorCode;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(13, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FileSystemManagerCreateSnapshotFileParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Url filePath;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemManagerCreateSnapshotFileParams(int version) {
      super(16, version);
    }

    public FileSystemManagerCreateSnapshotFileParams() {
      this(0);
    }

    public static FileSystemManagerCreateSnapshotFileParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemManagerCreateSnapshotFileParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemManagerCreateSnapshotFileParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemManagerCreateSnapshotFileParams result =
            new FileSystemManagerCreateSnapshotFileParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.filePath = Url.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.filePath, 8, false);
    }
  }

  static final class FileSystemManagerCreateSnapshotFileResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public int errorCode;
    public FileInfo fileInfo;
    public FilePath platformPath;
    public ReceivedSnapshotListener snapshotListener;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemManagerCreateSnapshotFileResponseParams(int version) {
      super(40, version);
    }

    public FileSystemManagerCreateSnapshotFileResponseParams() {
      this(0);
    }

    public static FileSystemManagerCreateSnapshotFileResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemManagerCreateSnapshotFileResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemManagerCreateSnapshotFileResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemManagerCreateSnapshotFileResponseParams result =
            new FileSystemManagerCreateSnapshotFileResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.fileInfo = FileInfo.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.platformPath = FilePath.decode(decoder12);
        int readInt = decoder0.readInt(24);
        result.errorCode = readInt;
        FileError.validate(readInt);
        result.errorCode = FileError.toKnownValue(result.errorCode);
        result.snapshotListener =
            (ReceivedSnapshotListener)
                decoder0.readServiceInterface(28, true, ReceivedSnapshotListener.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.fileInfo, 8, false);
      encoder0.encode((Struct) this.platformPath, 16, false);
      encoder0.encode(this.errorCode, 24);
      encoder0.encode(this.snapshotListener, 28, true, ReceivedSnapshotListener.MANAGER);
    }
  }

  static class FileSystemManagerCreateSnapshotFileResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FileSystemManager.CreateSnapshotFile_Response mCallback;

    FileSystemManagerCreateSnapshotFileResponseParamsForwardToCallback(
        FileSystemManager.CreateSnapshotFile_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(14, 6)) {
          return false;
        }
        FileSystemManagerCreateSnapshotFileResponseParams response =
            FileSystemManagerCreateSnapshotFileResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(
            response.fileInfo,
            response.platformPath,
            response.errorCode,
            response.snapshotListener);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FileSystemManagerCreateSnapshotFileResponseParamsProxyToResponder
      implements FileSystemManager.CreateSnapshotFile_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FileSystemManagerCreateSnapshotFileResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(
        FileInfo fileInfo,
        FilePath platformPath,
        int errorCode,
        ReceivedSnapshotListener snapshotListener) {
      FileSystemManagerCreateSnapshotFileResponseParams _response =
          new FileSystemManagerCreateSnapshotFileResponseParams();
      _response.fileInfo = fileInfo;
      _response.platformPath = platformPath;
      _response.errorCode = errorCode;
      _response.snapshotListener = snapshotListener;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(14, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FileSystemManagerGetPlatformPathParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Url filePath;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemManagerGetPlatformPathParams(int version) {
      super(16, version);
    }

    public FileSystemManagerGetPlatformPathParams() {
      this(0);
    }

    public static FileSystemManagerGetPlatformPathParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemManagerGetPlatformPathParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemManagerGetPlatformPathParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemManagerGetPlatformPathParams result =
            new FileSystemManagerGetPlatformPathParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.filePath = Url.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.filePath, 8, false);
    }
  }

  static final class FileSystemManagerGetPlatformPathResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public FilePath platformPath;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemManagerGetPlatformPathResponseParams(int version) {
      super(16, version);
    }

    public FileSystemManagerGetPlatformPathResponseParams() {
      this(0);
    }

    public static FileSystemManagerGetPlatformPathResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemManagerGetPlatformPathResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemManagerGetPlatformPathResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemManagerGetPlatformPathResponseParams result =
            new FileSystemManagerGetPlatformPathResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.platformPath = FilePath.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.platformPath, 8, false);
    }
  }

  static class FileSystemManagerGetPlatformPathResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FileSystemManager.GetPlatformPath_Response mCallback;

    FileSystemManagerGetPlatformPathResponseParamsForwardToCallback(
        FileSystemManager.GetPlatformPath_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(15, 6)) {
          return false;
        }
        FileSystemManagerGetPlatformPathResponseParams response =
            FileSystemManagerGetPlatformPathResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.platformPath);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FileSystemManagerGetPlatformPathResponseParamsProxyToResponder
      implements FileSystemManager.GetPlatformPath_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FileSystemManagerGetPlatformPathResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(FilePath platformPath) {
      FileSystemManagerGetPlatformPathResponseParams _response =
          new FileSystemManagerGetPlatformPathResponseParams();
      _response.platformPath = platformPath;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(15, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FileSystemManagerRegisterBlobParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public String contentType;
    public Time expectedModificationTime;
    public long length;
    public Url url;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemManagerRegisterBlobParams(int version) {
      super(40, version);
    }

    public FileSystemManagerRegisterBlobParams() {
      this(0);
    }

    public static FileSystemManagerRegisterBlobParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemManagerRegisterBlobParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemManagerRegisterBlobParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemManagerRegisterBlobParams result =
            new FileSystemManagerRegisterBlobParams(elementsOrVersion);
        result.contentType = decoder0.readString(8, false);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.url = Url.decode(decoder1);
        result.length = decoder0.readLong(24);
        Decoder decoder12 = decoder0.readPointer(32, true);
        result.expectedModificationTime = Time.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.contentType, 8, false);
      encoder0.encode((Struct) this.url, 16, false);
      encoder0.encode(this.length, 24);
      encoder0.encode((Struct) this.expectedModificationTime, 32, true);
    }
  }

  static final class FileSystemManagerRegisterBlobResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public SerializedBlob blob;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemManagerRegisterBlobResponseParams(int version) {
      super(16, version);
    }

    public FileSystemManagerRegisterBlobResponseParams() {
      this(0);
    }

    public static FileSystemManagerRegisterBlobResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemManagerRegisterBlobResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemManagerRegisterBlobResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemManagerRegisterBlobResponseParams result =
            new FileSystemManagerRegisterBlobResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.blob = SerializedBlob.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.blob, 8, false);
    }
  }

  static class FileSystemManagerRegisterBlobResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FileSystemManager.RegisterBlob_Response mCallback;

    FileSystemManagerRegisterBlobResponseParamsForwardToCallback(
        FileSystemManager.RegisterBlob_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(16, 6)) {
          return false;
        }
        FileSystemManagerRegisterBlobResponseParams response =
            FileSystemManagerRegisterBlobResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.blob);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FileSystemManagerRegisterBlobResponseParamsProxyToResponder
      implements FileSystemManager.RegisterBlob_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FileSystemManagerRegisterBlobResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(SerializedBlob blob) {
      FileSystemManagerRegisterBlobResponseParams _response =
          new FileSystemManagerRegisterBlobResponseParams();
      _response.blob = blob;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(16, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
