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

class FileSystemAccessManager_Internal {
  private static final int BIND_OBSERVER_HOST_ORDINAL = 5;
  private static final int CHOOSE_ENTRIES_ORDINAL = 1;
  private static final int GET_DIRECTORY_HANDLE_FROM_TOKEN_ORDINAL = 3;
  private static final int GET_ENTRY_FROM_DATA_TRANSFER_TOKEN_ORDINAL = 4;
  private static final int GET_FILE_HANDLE_FROM_TOKEN_ORDINAL = 2;
  private static final int GET_SANDBOXED_FILE_SYSTEM_ORDINAL = 0;
  public static final Interface.Manager<FileSystemAccessManager, FileSystemAccessManager.Proxy>
      MANAGER =
          new Interface.Manager<FileSystemAccessManager, FileSystemAccessManager.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.FileSystemAccessManager";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public FileSystemAccessManager.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, FileSystemAccessManager impl) {
              return new Stub(core, impl);
            }

            @Override
            public FileSystemAccessManager[] buildArray(int size) {
              return new FileSystemAccessManager[size];
            }
          };

  FileSystemAccessManager_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements FileSystemAccessManager.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void getSandboxedFileSystem(GetSandboxedFileSystem_Response callback) {
      FileSystemAccessManagerGetSandboxedFileSystemParams _message =
          new FileSystemAccessManagerGetSandboxedFileSystemParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new FileSystemAccessManagerGetSandboxedFileSystemResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void chooseEntries(FilePickerOptions options, ChooseEntries_Response callback) {
      FileSystemAccessManagerChooseEntriesParams _message =
          new FileSystemAccessManagerChooseEntriesParams();
      _message.options = options;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new FileSystemAccessManagerChooseEntriesResponseParamsForwardToCallback(callback));
    }

    @Override
    public void getFileHandleFromToken(
        FileSystemAccessTransferToken token,
        InterfaceRequest<FileSystemAccessFileHandle> fileHandle) {
      FileSystemAccessManagerGetFileHandleFromTokenParams _message =
          new FileSystemAccessManagerGetFileHandleFromTokenParams();
      _message.token = token;
      _message.fileHandle = fileHandle;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void getDirectoryHandleFromToken(
        FileSystemAccessTransferToken token,
        InterfaceRequest<FileSystemAccessDirectoryHandle> directoryHandle) {
      FileSystemAccessManagerGetDirectoryHandleFromTokenParams _message =
          new FileSystemAccessManagerGetDirectoryHandleFromTokenParams();
      _message.token = token;
      _message.directoryHandle = directoryHandle;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }

    @Override
    public void getEntryFromDataTransferToken(
        FileSystemAccessDataTransferToken token, GetEntryFromDataTransferToken_Response callback) {
      FileSystemAccessManagerGetEntryFromDataTransferTokenParams _message =
          new FileSystemAccessManagerGetEntryFromDataTransferTokenParams();
      _message.token = token;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)),
              new FileSystemAccessManagerGetEntryFromDataTransferTokenResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void bindObserverHost(InterfaceRequest<FileSystemAccessObserverHost> observerHost) {
      FileSystemAccessManagerBindObserverHostParams _message =
          new FileSystemAccessManagerBindObserverHostParams();
      _message.observerHost = observerHost;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5)));
    }
  }

  public static final class Stub extends Interface.Stub<FileSystemAccessManager> {
    Stub(Core core, FileSystemAccessManager impl) {
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
                FileSystemAccessManager_Internal.MANAGER, messageWithHeader);
          case 2:
            FileSystemAccessManagerGetFileHandleFromTokenParams data =
                FileSystemAccessManagerGetFileHandleFromTokenParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().getFileHandleFromToken(data.token, data.fileHandle);
            return true;
          case 3:
            FileSystemAccessManagerGetDirectoryHandleFromTokenParams data2 =
                FileSystemAccessManagerGetDirectoryHandleFromTokenParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().getDirectoryHandleFromToken(data2.token, data2.directoryHandle);
            return true;
          case 5:
            getImpl()
                .bindObserverHost(
                    FileSystemAccessManagerBindObserverHostParams.deserialize(
                            messageWithHeader.getPayload())
                        .observerHost);
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
                getCore(), FileSystemAccessManager_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            FileSystemAccessManagerGetSandboxedFileSystemParams.deserialize(
                messageWithHeader.getPayload());
            getImpl()
                .getSandboxedFileSystem(
                    new FileSystemAccessManagerGetSandboxedFileSystemResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
            FileSystemAccessManagerChooseEntriesParams data =
                FileSystemAccessManagerChooseEntriesParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .chooseEntries(
                    data.options,
                    new FileSystemAccessManagerChooseEntriesResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 2:
          case 3:
          default:
            return false;
          case 4:
            FileSystemAccessManagerGetEntryFromDataTransferTokenParams data2 =
                FileSystemAccessManagerGetEntryFromDataTransferTokenParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .getEntryFromDataTransferToken(
                    data2.token,
                    new FileSystemAccessManagerGetEntryFromDataTransferTokenResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class FileSystemAccessManagerGetSandboxedFileSystemParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessManagerGetSandboxedFileSystemParams(int version) {
      super(8, version);
    }

    public FileSystemAccessManagerGetSandboxedFileSystemParams() {
      this(0);
    }

    public static FileSystemAccessManagerGetSandboxedFileSystemParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessManagerGetSandboxedFileSystemParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessManagerGetSandboxedFileSystemParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessManagerGetSandboxedFileSystemParams result =
            new FileSystemAccessManagerGetSandboxedFileSystemParams(elementsOrVersion);
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

  static final class FileSystemAccessManagerGetSandboxedFileSystemResponseParams extends Struct {
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

    private FileSystemAccessManagerGetSandboxedFileSystemResponseParams(int version) {
      super(24, version);
    }

    public FileSystemAccessManagerGetSandboxedFileSystemResponseParams() {
      this(0);
    }

    public static FileSystemAccessManagerGetSandboxedFileSystemResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessManagerGetSandboxedFileSystemResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessManagerGetSandboxedFileSystemResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessManagerGetSandboxedFileSystemResponseParams result =
            new FileSystemAccessManagerGetSandboxedFileSystemResponseParams(elementsOrVersion);
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

  static class FileSystemAccessManagerGetSandboxedFileSystemResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FileSystemAccessManager.GetSandboxedFileSystem_Response mCallback;

    FileSystemAccessManagerGetSandboxedFileSystemResponseParamsForwardToCallback(
        FileSystemAccessManager.GetSandboxedFileSystem_Response callback) {
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
        FileSystemAccessManagerGetSandboxedFileSystemResponseParams response =
            FileSystemAccessManagerGetSandboxedFileSystemResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result, response.directory);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FileSystemAccessManagerGetSandboxedFileSystemResponseParamsProxyToResponder
      implements FileSystemAccessManager.GetSandboxedFileSystem_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FileSystemAccessManagerGetSandboxedFileSystemResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(FileSystemAccessError result, FileSystemAccessDirectoryHandle directory) {
      FileSystemAccessManagerGetSandboxedFileSystemResponseParams _response =
          new FileSystemAccessManagerGetSandboxedFileSystemResponseParams();
      _response.result = result;
      _response.directory = directory;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FileSystemAccessManagerChooseEntriesParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public FilePickerOptions options;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessManagerChooseEntriesParams(int version) {
      super(16, version);
    }

    public FileSystemAccessManagerChooseEntriesParams() {
      this(0);
    }

    public static FileSystemAccessManagerChooseEntriesParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessManagerChooseEntriesParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessManagerChooseEntriesParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessManagerChooseEntriesParams result =
            new FileSystemAccessManagerChooseEntriesParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.options = FilePickerOptions.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.options, 8, false);
    }
  }

  static final class FileSystemAccessManagerChooseEntriesResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public FileSystemAccessEntry[] entries;
    public FileSystemAccessError result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessManagerChooseEntriesResponseParams(int version) {
      super(24, version);
    }

    public FileSystemAccessManagerChooseEntriesResponseParams() {
      this(0);
    }

    public static FileSystemAccessManagerChooseEntriesResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessManagerChooseEntriesResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessManagerChooseEntriesResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessManagerChooseEntriesResponseParams result =
            new FileSystemAccessManagerChooseEntriesResponseParams(elementsOrVersion);
        result.result = FileSystemAccessError.decode(decoder0.readPointer(8, false));
        Decoder decoder1 = decoder0.readPointer(16, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.entries = new FileSystemAccessEntry[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.entries[i1] = FileSystemAccessEntry.decode(decoder2);
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
      FileSystemAccessEntry[] fileSystemAccessEntryArr = this.entries;
      if (fileSystemAccessEntryArr == null) {
        encoder0.encodeNullPointer(16, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(fileSystemAccessEntryArr.length, 16, -1);
      int i0 = 0;
      while (true) {
        FileSystemAccessEntry[] fileSystemAccessEntryArr2 = this.entries;
        if (i0 < fileSystemAccessEntryArr2.length) {
          encoder1.encode((Struct) fileSystemAccessEntryArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static class FileSystemAccessManagerChooseEntriesResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FileSystemAccessManager.ChooseEntries_Response mCallback;

    FileSystemAccessManagerChooseEntriesResponseParamsForwardToCallback(
        FileSystemAccessManager.ChooseEntries_Response callback) {
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
        FileSystemAccessManagerChooseEntriesResponseParams response =
            FileSystemAccessManagerChooseEntriesResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result, response.entries);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FileSystemAccessManagerChooseEntriesResponseParamsProxyToResponder
      implements FileSystemAccessManager.ChooseEntries_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FileSystemAccessManagerChooseEntriesResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(FileSystemAccessError result, FileSystemAccessEntry[] entries) {
      FileSystemAccessManagerChooseEntriesResponseParams _response =
          new FileSystemAccessManagerChooseEntriesResponseParams();
      _response.result = result;
      _response.entries = entries;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FileSystemAccessManagerGetFileHandleFromTokenParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<FileSystemAccessFileHandle> fileHandle;
    public FileSystemAccessTransferToken token;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessManagerGetFileHandleFromTokenParams(int version) {
      super(24, version);
    }

    public FileSystemAccessManagerGetFileHandleFromTokenParams() {
      this(0);
    }

    public static FileSystemAccessManagerGetFileHandleFromTokenParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessManagerGetFileHandleFromTokenParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessManagerGetFileHandleFromTokenParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessManagerGetFileHandleFromTokenParams result =
            new FileSystemAccessManagerGetFileHandleFromTokenParams(elementsOrVersion);
        result.token =
            (FileSystemAccessTransferToken)
                decoder0.readServiceInterface(8, false, FileSystemAccessTransferToken.MANAGER);
        result.fileHandle = decoder0.readInterfaceRequest(16, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.token, 8, false, FileSystemAccessTransferToken.MANAGER);
      encoder0.encode((InterfaceRequest) this.fileHandle, 16, false);
    }
  }

  static final class FileSystemAccessManagerGetDirectoryHandleFromTokenParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<FileSystemAccessDirectoryHandle> directoryHandle;
    public FileSystemAccessTransferToken token;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessManagerGetDirectoryHandleFromTokenParams(int version) {
      super(24, version);
    }

    public FileSystemAccessManagerGetDirectoryHandleFromTokenParams() {
      this(0);
    }

    public static FileSystemAccessManagerGetDirectoryHandleFromTokenParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessManagerGetDirectoryHandleFromTokenParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessManagerGetDirectoryHandleFromTokenParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessManagerGetDirectoryHandleFromTokenParams result =
            new FileSystemAccessManagerGetDirectoryHandleFromTokenParams(elementsOrVersion);
        result.token =
            (FileSystemAccessTransferToken)
                decoder0.readServiceInterface(8, false, FileSystemAccessTransferToken.MANAGER);
        result.directoryHandle = decoder0.readInterfaceRequest(16, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.token, 8, false, FileSystemAccessTransferToken.MANAGER);
      encoder0.encode((InterfaceRequest) this.directoryHandle, 16, false);
    }
  }

  static final class FileSystemAccessManagerGetEntryFromDataTransferTokenParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public FileSystemAccessDataTransferToken token;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessManagerGetEntryFromDataTransferTokenParams(int version) {
      super(16, version);
    }

    public FileSystemAccessManagerGetEntryFromDataTransferTokenParams() {
      this(0);
    }

    public static FileSystemAccessManagerGetEntryFromDataTransferTokenParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessManagerGetEntryFromDataTransferTokenParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessManagerGetEntryFromDataTransferTokenParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessManagerGetEntryFromDataTransferTokenParams result =
            new FileSystemAccessManagerGetEntryFromDataTransferTokenParams(elementsOrVersion);
        result.token =
            (FileSystemAccessDataTransferToken)
                decoder0.readServiceInterface(8, false, FileSystemAccessDataTransferToken.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.token, 8, false, FileSystemAccessDataTransferToken.MANAGER);
    }
  }

  static final class FileSystemAccessManagerGetEntryFromDataTransferTokenResponseParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public FileSystemAccessEntry entry;
    public FileSystemAccessError result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessManagerGetEntryFromDataTransferTokenResponseParams(int version) {
      super(24, version);
    }

    public FileSystemAccessManagerGetEntryFromDataTransferTokenResponseParams() {
      this(0);
    }

    public static FileSystemAccessManagerGetEntryFromDataTransferTokenResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessManagerGetEntryFromDataTransferTokenResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessManagerGetEntryFromDataTransferTokenResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessManagerGetEntryFromDataTransferTokenResponseParams result =
            new FileSystemAccessManagerGetEntryFromDataTransferTokenResponseParams(
                elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.result = FileSystemAccessError.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, true);
        result.entry = FileSystemAccessEntry.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.result, 8, false);
      encoder0.encode((Struct) this.entry, 16, true);
    }
  }

  static class FileSystemAccessManagerGetEntryFromDataTransferTokenResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FileSystemAccessManager.GetEntryFromDataTransferToken_Response mCallback;

    FileSystemAccessManagerGetEntryFromDataTransferTokenResponseParamsForwardToCallback(
        FileSystemAccessManager.GetEntryFromDataTransferToken_Response callback) {
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
        FileSystemAccessManagerGetEntryFromDataTransferTokenResponseParams response =
            FileSystemAccessManagerGetEntryFromDataTransferTokenResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result, response.entry);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FileSystemAccessManagerGetEntryFromDataTransferTokenResponseParamsProxyToResponder
      implements FileSystemAccessManager.GetEntryFromDataTransferToken_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FileSystemAccessManagerGetEntryFromDataTransferTokenResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(FileSystemAccessError result, FileSystemAccessEntry entry) {
      FileSystemAccessManagerGetEntryFromDataTransferTokenResponseParams _response =
          new FileSystemAccessManagerGetEntryFromDataTransferTokenResponseParams();
      _response.result = result;
      _response.entry = entry;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FileSystemAccessManagerBindObserverHostParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<FileSystemAccessObserverHost> observerHost;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessManagerBindObserverHostParams(int version) {
      super(16, version);
    }

    public FileSystemAccessManagerBindObserverHostParams() {
      this(0);
    }

    public static FileSystemAccessManagerBindObserverHostParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessManagerBindObserverHostParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessManagerBindObserverHostParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessManagerBindObserverHostParams result =
            new FileSystemAccessManagerBindObserverHostParams(elementsOrVersion);
        result.observerHost = decoder0.readInterfaceRequest(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.observerHost, 8, false);
    }
  }
}
