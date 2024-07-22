package org.chromium.network.mojom;

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
import org.chromium.mojo_base.mojom.File;
import org.chromium.mojo_base.mojom.FileError;
import org.chromium.mojo_base.mojom.FileInfo;
import org.chromium.mojo_base.mojom.FilePath;

class HttpCacheBackendFileOperations_Internal {
  private static final int CLEANUP_DIRECTORY_ORDINAL = 8;
  private static final int CREATE_DIRECTORY_ORDINAL = 0;
  private static final int DELETE_FILE_ORDINAL = 4;
  private static final int DIRECTORY_EXISTS_ORDINAL = 2;
  private static final int ENUMERATE_FILES_ORDINAL = 7;
  private static final int GET_FILE_INFO_ORDINAL = 6;
  public static final Interface.Manager<
          HttpCacheBackendFileOperations, HttpCacheBackendFileOperations.Proxy>
      MANAGER =
          new Interface.Manager<
              HttpCacheBackendFileOperations, HttpCacheBackendFileOperations.Proxy>() {
            @Override
            public String getName() {
              return "network.mojom.HttpCacheBackendFileOperations";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public HttpCacheBackendFileOperations.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, HttpCacheBackendFileOperations impl) {
              return new Stub(core, impl);
            }

            @Override
            public HttpCacheBackendFileOperations[] buildArray(int size) {
              return new HttpCacheBackendFileOperations[size];
            }
          };
  private static final int OPEN_FILE_ORDINAL = 3;
  private static final int PATH_EXISTS_ORDINAL = 1;
  private static final int RENAME_FILE_ORDINAL = 5;

  HttpCacheBackendFileOperations_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements HttpCacheBackendFileOperations.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void createDirectory(
        FilePath path, HttpCacheBackendFileOperations.CreateDirectory_Response callback) {
      HttpCacheBackendFileOperationsCreateDirectoryParams _message =
          new HttpCacheBackendFileOperationsCreateDirectoryParams();
      _message.path = path;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new HttpCacheBackendFileOperationsCreateDirectoryResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void pathExists(
        FilePath path, HttpCacheBackendFileOperations.PathExists_Response callback) {
      HttpCacheBackendFileOperationsPathExistsParams _message =
          new HttpCacheBackendFileOperationsPathExistsParams();
      _message.path = path;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new HttpCacheBackendFileOperationsPathExistsResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void directoryExists(
        FilePath path, HttpCacheBackendFileOperations.DirectoryExists_Response callback) {
      HttpCacheBackendFileOperationsDirectoryExistsParams _message =
          new HttpCacheBackendFileOperationsDirectoryExistsParams();
      _message.path = path;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new HttpCacheBackendFileOperationsDirectoryExistsResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void openFile(
        FilePath path, int flags, HttpCacheBackendFileOperations.OpenFile_Response callback) {
      HttpCacheBackendFileOperationsOpenFileParams _message =
          new HttpCacheBackendFileOperationsOpenFileParams();
      _message.path = path;
      _message.flags = flags;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)),
              new HttpCacheBackendFileOperationsOpenFileResponseParamsForwardToCallback(callback));
    }

    @Override
    public void deleteFile(
        FilePath path, int mode, HttpCacheBackendFileOperations.DeleteFile_Response callback) {
      HttpCacheBackendFileOperationsDeleteFileParams _message =
          new HttpCacheBackendFileOperationsDeleteFileParams();
      _message.path = path;
      _message.mode = mode;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)),
              new HttpCacheBackendFileOperationsDeleteFileResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void renameFile(
        FilePath fromPath,
        FilePath toPath,
        HttpCacheBackendFileOperations.RenameFile_Response callback) {
      HttpCacheBackendFileOperationsRenameFileParams _message =
          new HttpCacheBackendFileOperationsRenameFileParams();
      _message.fromPath = fromPath;
      _message.toPath = toPath;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(5, 1, 0L)),
              new HttpCacheBackendFileOperationsRenameFileResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void getFileInfo(
        FilePath path, HttpCacheBackendFileOperations.GetFileInfo_Response callback) {
      HttpCacheBackendFileOperationsGetFileInfoParams _message =
          new HttpCacheBackendFileOperationsGetFileInfoParams();
      _message.path = path;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(6, 1, 0L)),
              new HttpCacheBackendFileOperationsGetFileInfoResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void enumerateFiles(FilePath path, InterfaceRequest<FileEnumerator> receiver) {
      HttpCacheBackendFileOperationsEnumerateFilesParams _message =
          new HttpCacheBackendFileOperationsEnumerateFilesParams();
      _message.path = path;
      _message.receiver = receiver;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(7)));
    }

    @Override
    public void cleanupDirectory(
        FilePath path, HttpCacheBackendFileOperations.CleanupDirectory_Response callback) {
      HttpCacheBackendFileOperationsCleanupDirectoryParams _message =
          new HttpCacheBackendFileOperationsCleanupDirectoryParams();
      _message.path = path;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(8, 1, 0L)),
              new HttpCacheBackendFileOperationsCleanupDirectoryResponseParamsForwardToCallback(
                  callback));
    }
  }

  public static final class Stub extends Interface.Stub<HttpCacheBackendFileOperations> {
    Stub(Core core, HttpCacheBackendFileOperations impl) {
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
                HttpCacheBackendFileOperations_Internal.MANAGER, messageWithHeader);
          case 7:
            HttpCacheBackendFileOperationsEnumerateFilesParams data =
                HttpCacheBackendFileOperationsEnumerateFilesParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().enumerateFiles(data.path, data.receiver);
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
                HttpCacheBackendFileOperations_Internal.MANAGER,
                messageWithHeader,
                receiver);
          case 0:
            HttpCacheBackendFileOperationsCreateDirectoryParams data =
                HttpCacheBackendFileOperationsCreateDirectoryParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .createDirectory(
                    data.path,
                    new HttpCacheBackendFileOperationsCreateDirectoryResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
            HttpCacheBackendFileOperationsPathExistsParams data2 =
                HttpCacheBackendFileOperationsPathExistsParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .pathExists(
                    data2.path,
                    new HttpCacheBackendFileOperationsPathExistsResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 2:
            HttpCacheBackendFileOperationsDirectoryExistsParams data3 =
                HttpCacheBackendFileOperationsDirectoryExistsParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .directoryExists(
                    data3.path,
                    new HttpCacheBackendFileOperationsDirectoryExistsResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 3:
            HttpCacheBackendFileOperationsOpenFileParams data4 =
                HttpCacheBackendFileOperationsOpenFileParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .openFile(
                    data4.path,
                    data4.flags,
                    new HttpCacheBackendFileOperationsOpenFileResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 4:
            HttpCacheBackendFileOperationsDeleteFileParams data5 =
                HttpCacheBackendFileOperationsDeleteFileParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .deleteFile(
                    data5.path,
                    data5.mode,
                    new HttpCacheBackendFileOperationsDeleteFileResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 5:
            HttpCacheBackendFileOperationsRenameFileParams data6 =
                HttpCacheBackendFileOperationsRenameFileParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .renameFile(
                    data6.fromPath,
                    data6.toPath,
                    new HttpCacheBackendFileOperationsRenameFileResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 6:
            HttpCacheBackendFileOperationsGetFileInfoParams data7 =
                HttpCacheBackendFileOperationsGetFileInfoParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .getFileInfo(
                    data7.path,
                    new HttpCacheBackendFileOperationsGetFileInfoResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 7:
          default:
            return false;
          case 8:
            HttpCacheBackendFileOperationsCleanupDirectoryParams data8 =
                HttpCacheBackendFileOperationsCleanupDirectoryParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .cleanupDirectory(
                    data8.path,
                    new HttpCacheBackendFileOperationsCleanupDirectoryResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class HttpCacheBackendFileOperationsCreateDirectoryParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public FilePath path;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private HttpCacheBackendFileOperationsCreateDirectoryParams(int version) {
      super(16, version);
    }

    public HttpCacheBackendFileOperationsCreateDirectoryParams() {
      this(0);
    }

    public static HttpCacheBackendFileOperationsCreateDirectoryParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static HttpCacheBackendFileOperationsCreateDirectoryParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static HttpCacheBackendFileOperationsCreateDirectoryParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        HttpCacheBackendFileOperationsCreateDirectoryParams result =
            new HttpCacheBackendFileOperationsCreateDirectoryParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.path = FilePath.decode(decoder1);
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

  static final class HttpCacheBackendFileOperationsCreateDirectoryResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private HttpCacheBackendFileOperationsCreateDirectoryResponseParams(int version) {
      super(16, version);
    }

    public HttpCacheBackendFileOperationsCreateDirectoryResponseParams() {
      this(0);
    }

    public static HttpCacheBackendFileOperationsCreateDirectoryResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static HttpCacheBackendFileOperationsCreateDirectoryResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static HttpCacheBackendFileOperationsCreateDirectoryResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        HttpCacheBackendFileOperationsCreateDirectoryResponseParams result =
            new HttpCacheBackendFileOperationsCreateDirectoryResponseParams(elementsOrVersion);
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

  static class HttpCacheBackendFileOperationsCreateDirectoryResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final HttpCacheBackendFileOperations.CreateDirectory_Response mCallback;

    HttpCacheBackendFileOperationsCreateDirectoryResponseParamsForwardToCallback(
        HttpCacheBackendFileOperations.CreateDirectory_Response callback) {
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
        HttpCacheBackendFileOperationsCreateDirectoryResponseParams response =
            HttpCacheBackendFileOperationsCreateDirectoryResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class HttpCacheBackendFileOperationsCreateDirectoryResponseParamsProxyToResponder
      implements HttpCacheBackendFileOperations.CreateDirectory_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    HttpCacheBackendFileOperationsCreateDirectoryResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean result) {
      HttpCacheBackendFileOperationsCreateDirectoryResponseParams _response =
          new HttpCacheBackendFileOperationsCreateDirectoryResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class HttpCacheBackendFileOperationsPathExistsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public FilePath path;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private HttpCacheBackendFileOperationsPathExistsParams(int version) {
      super(16, version);
    }

    public HttpCacheBackendFileOperationsPathExistsParams() {
      this(0);
    }

    public static HttpCacheBackendFileOperationsPathExistsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static HttpCacheBackendFileOperationsPathExistsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static HttpCacheBackendFileOperationsPathExistsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        HttpCacheBackendFileOperationsPathExistsParams result =
            new HttpCacheBackendFileOperationsPathExistsParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.path = FilePath.decode(decoder1);
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

  static final class HttpCacheBackendFileOperationsPathExistsResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private HttpCacheBackendFileOperationsPathExistsResponseParams(int version) {
      super(16, version);
    }

    public HttpCacheBackendFileOperationsPathExistsResponseParams() {
      this(0);
    }

    public static HttpCacheBackendFileOperationsPathExistsResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static HttpCacheBackendFileOperationsPathExistsResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static HttpCacheBackendFileOperationsPathExistsResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        HttpCacheBackendFileOperationsPathExistsResponseParams result =
            new HttpCacheBackendFileOperationsPathExistsResponseParams(elementsOrVersion);
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

  static class HttpCacheBackendFileOperationsPathExistsResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final HttpCacheBackendFileOperations.PathExists_Response mCallback;

    HttpCacheBackendFileOperationsPathExistsResponseParamsForwardToCallback(
        HttpCacheBackendFileOperations.PathExists_Response callback) {
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
        HttpCacheBackendFileOperationsPathExistsResponseParams response =
            HttpCacheBackendFileOperationsPathExistsResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class HttpCacheBackendFileOperationsPathExistsResponseParamsProxyToResponder
      implements HttpCacheBackendFileOperations.PathExists_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    HttpCacheBackendFileOperationsPathExistsResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean result) {
      HttpCacheBackendFileOperationsPathExistsResponseParams _response =
          new HttpCacheBackendFileOperationsPathExistsResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class HttpCacheBackendFileOperationsDirectoryExistsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public FilePath path;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private HttpCacheBackendFileOperationsDirectoryExistsParams(int version) {
      super(16, version);
    }

    public HttpCacheBackendFileOperationsDirectoryExistsParams() {
      this(0);
    }

    public static HttpCacheBackendFileOperationsDirectoryExistsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static HttpCacheBackendFileOperationsDirectoryExistsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static HttpCacheBackendFileOperationsDirectoryExistsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        HttpCacheBackendFileOperationsDirectoryExistsParams result =
            new HttpCacheBackendFileOperationsDirectoryExistsParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.path = FilePath.decode(decoder1);
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

  static final class HttpCacheBackendFileOperationsDirectoryExistsResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private HttpCacheBackendFileOperationsDirectoryExistsResponseParams(int version) {
      super(16, version);
    }

    public HttpCacheBackendFileOperationsDirectoryExistsResponseParams() {
      this(0);
    }

    public static HttpCacheBackendFileOperationsDirectoryExistsResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static HttpCacheBackendFileOperationsDirectoryExistsResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static HttpCacheBackendFileOperationsDirectoryExistsResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        HttpCacheBackendFileOperationsDirectoryExistsResponseParams result =
            new HttpCacheBackendFileOperationsDirectoryExistsResponseParams(elementsOrVersion);
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

  static class HttpCacheBackendFileOperationsDirectoryExistsResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final HttpCacheBackendFileOperations.DirectoryExists_Response mCallback;

    HttpCacheBackendFileOperationsDirectoryExistsResponseParamsForwardToCallback(
        HttpCacheBackendFileOperations.DirectoryExists_Response callback) {
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
        HttpCacheBackendFileOperationsDirectoryExistsResponseParams response =
            HttpCacheBackendFileOperationsDirectoryExistsResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class HttpCacheBackendFileOperationsDirectoryExistsResponseParamsProxyToResponder
      implements HttpCacheBackendFileOperations.DirectoryExists_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    HttpCacheBackendFileOperationsDirectoryExistsResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean result) {
      HttpCacheBackendFileOperationsDirectoryExistsResponseParams _response =
          new HttpCacheBackendFileOperationsDirectoryExistsResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class HttpCacheBackendFileOperationsOpenFileParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int flags;
    public FilePath path;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private HttpCacheBackendFileOperationsOpenFileParams(int version) {
      super(24, version);
    }

    public HttpCacheBackendFileOperationsOpenFileParams() {
      this(0);
    }

    public static HttpCacheBackendFileOperationsOpenFileParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static HttpCacheBackendFileOperationsOpenFileParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static HttpCacheBackendFileOperationsOpenFileParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        HttpCacheBackendFileOperationsOpenFileParams result =
            new HttpCacheBackendFileOperationsOpenFileParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.path = FilePath.decode(decoder1);
        int readInt = decoder0.readInt(16);
        result.flags = readInt;
        HttpCacheBackendOpenFileFlags.validate(readInt);
        result.flags = HttpCacheBackendOpenFileFlags.toKnownValue(result.flags);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.path, 8, false);
      encoder0.encode(this.flags, 16);
    }
  }

  static final class HttpCacheBackendFileOperationsOpenFileResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int error;
    public File file;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private HttpCacheBackendFileOperationsOpenFileResponseParams(int version) {
      super(24, version);
    }

    public HttpCacheBackendFileOperationsOpenFileResponseParams() {
      this(0);
    }

    public static HttpCacheBackendFileOperationsOpenFileResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static HttpCacheBackendFileOperationsOpenFileResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static HttpCacheBackendFileOperationsOpenFileResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        HttpCacheBackendFileOperationsOpenFileResponseParams result =
            new HttpCacheBackendFileOperationsOpenFileResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.file = File.decode(decoder1);
        int readInt = decoder0.readInt(16);
        result.error = readInt;
        FileError.validate(readInt);
        result.error = FileError.toKnownValue(result.error);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.file, 8, true);
      encoder0.encode(this.error, 16);
    }
  }

  static class HttpCacheBackendFileOperationsOpenFileResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final HttpCacheBackendFileOperations.OpenFile_Response mCallback;

    HttpCacheBackendFileOperationsOpenFileResponseParamsForwardToCallback(
        HttpCacheBackendFileOperations.OpenFile_Response callback) {
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
        HttpCacheBackendFileOperationsOpenFileResponseParams response =
            HttpCacheBackendFileOperationsOpenFileResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.file, response.error);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class HttpCacheBackendFileOperationsOpenFileResponseParamsProxyToResponder
      implements HttpCacheBackendFileOperations.OpenFile_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    HttpCacheBackendFileOperationsOpenFileResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(File file, int error) {
      HttpCacheBackendFileOperationsOpenFileResponseParams _response =
          new HttpCacheBackendFileOperationsOpenFileResponseParams();
      _response.file = file;
      _response.error = error;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(3, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class HttpCacheBackendFileOperationsDeleteFileParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int mode;
    public FilePath path;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private HttpCacheBackendFileOperationsDeleteFileParams(int version) {
      super(24, version);
    }

    public HttpCacheBackendFileOperationsDeleteFileParams() {
      this(0);
    }

    public static HttpCacheBackendFileOperationsDeleteFileParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static HttpCacheBackendFileOperationsDeleteFileParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static HttpCacheBackendFileOperationsDeleteFileParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        HttpCacheBackendFileOperationsDeleteFileParams result =
            new HttpCacheBackendFileOperationsDeleteFileParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.path = FilePath.decode(decoder1);
        int readInt = decoder0.readInt(16);
        result.mode = readInt;
        HttpCacheBackendDeleteFileMode.validate(readInt);
        result.mode = HttpCacheBackendDeleteFileMode.toKnownValue(result.mode);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.path, 8, false);
      encoder0.encode(this.mode, 16);
    }
  }

  static final class HttpCacheBackendFileOperationsDeleteFileResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private HttpCacheBackendFileOperationsDeleteFileResponseParams(int version) {
      super(16, version);
    }

    public HttpCacheBackendFileOperationsDeleteFileResponseParams() {
      this(0);
    }

    public static HttpCacheBackendFileOperationsDeleteFileResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static HttpCacheBackendFileOperationsDeleteFileResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static HttpCacheBackendFileOperationsDeleteFileResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        HttpCacheBackendFileOperationsDeleteFileResponseParams result =
            new HttpCacheBackendFileOperationsDeleteFileResponseParams(elementsOrVersion);
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

  static class HttpCacheBackendFileOperationsDeleteFileResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final HttpCacheBackendFileOperations.DeleteFile_Response mCallback;

    HttpCacheBackendFileOperationsDeleteFileResponseParamsForwardToCallback(
        HttpCacheBackendFileOperations.DeleteFile_Response callback) {
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
        HttpCacheBackendFileOperationsDeleteFileResponseParams response =
            HttpCacheBackendFileOperationsDeleteFileResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class HttpCacheBackendFileOperationsDeleteFileResponseParamsProxyToResponder
      implements HttpCacheBackendFileOperations.DeleteFile_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    HttpCacheBackendFileOperationsDeleteFileResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean result) {
      HttpCacheBackendFileOperationsDeleteFileResponseParams _response =
          new HttpCacheBackendFileOperationsDeleteFileResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(4, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class HttpCacheBackendFileOperationsRenameFileParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public FilePath fromPath;
    public FilePath toPath;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private HttpCacheBackendFileOperationsRenameFileParams(int version) {
      super(24, version);
    }

    public HttpCacheBackendFileOperationsRenameFileParams() {
      this(0);
    }

    public static HttpCacheBackendFileOperationsRenameFileParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static HttpCacheBackendFileOperationsRenameFileParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static HttpCacheBackendFileOperationsRenameFileParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        HttpCacheBackendFileOperationsRenameFileParams result =
            new HttpCacheBackendFileOperationsRenameFileParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.fromPath = FilePath.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.toPath = FilePath.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.fromPath, 8, false);
      encoder0.encode((Struct) this.toPath, 16, false);
    }
  }

  static final class HttpCacheBackendFileOperationsRenameFileResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int error;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private HttpCacheBackendFileOperationsRenameFileResponseParams(int version) {
      super(16, version);
    }

    public HttpCacheBackendFileOperationsRenameFileResponseParams() {
      this(0);
    }

    public static HttpCacheBackendFileOperationsRenameFileResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static HttpCacheBackendFileOperationsRenameFileResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static HttpCacheBackendFileOperationsRenameFileResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        HttpCacheBackendFileOperationsRenameFileResponseParams result =
            new HttpCacheBackendFileOperationsRenameFileResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.error = readInt;
        FileError.validate(readInt);
        result.error = FileError.toKnownValue(result.error);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.error, 8);
    }
  }

  static class HttpCacheBackendFileOperationsRenameFileResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final HttpCacheBackendFileOperations.RenameFile_Response mCallback;

    HttpCacheBackendFileOperationsRenameFileResponseParamsForwardToCallback(
        HttpCacheBackendFileOperations.RenameFile_Response callback) {
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
        HttpCacheBackendFileOperationsRenameFileResponseParams response =
            HttpCacheBackendFileOperationsRenameFileResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.error);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class HttpCacheBackendFileOperationsRenameFileResponseParamsProxyToResponder
      implements HttpCacheBackendFileOperations.RenameFile_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    HttpCacheBackendFileOperationsRenameFileResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int error) {
      HttpCacheBackendFileOperationsRenameFileResponseParams _response =
          new HttpCacheBackendFileOperationsRenameFileResponseParams();
      _response.error = error;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(5, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class HttpCacheBackendFileOperationsGetFileInfoParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public FilePath path;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private HttpCacheBackendFileOperationsGetFileInfoParams(int version) {
      super(16, version);
    }

    public HttpCacheBackendFileOperationsGetFileInfoParams() {
      this(0);
    }

    public static HttpCacheBackendFileOperationsGetFileInfoParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static HttpCacheBackendFileOperationsGetFileInfoParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static HttpCacheBackendFileOperationsGetFileInfoParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        HttpCacheBackendFileOperationsGetFileInfoParams result =
            new HttpCacheBackendFileOperationsGetFileInfoParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.path = FilePath.decode(decoder1);
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

  static final class HttpCacheBackendFileOperationsGetFileInfoResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public FileInfo info;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private HttpCacheBackendFileOperationsGetFileInfoResponseParams(int version) {
      super(16, version);
    }

    public HttpCacheBackendFileOperationsGetFileInfoResponseParams() {
      this(0);
    }

    public static HttpCacheBackendFileOperationsGetFileInfoResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static HttpCacheBackendFileOperationsGetFileInfoResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static HttpCacheBackendFileOperationsGetFileInfoResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        HttpCacheBackendFileOperationsGetFileInfoResponseParams result =
            new HttpCacheBackendFileOperationsGetFileInfoResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.info = FileInfo.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.info, 8, true);
    }
  }

  static class HttpCacheBackendFileOperationsGetFileInfoResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final HttpCacheBackendFileOperations.GetFileInfo_Response mCallback;

    HttpCacheBackendFileOperationsGetFileInfoResponseParamsForwardToCallback(
        HttpCacheBackendFileOperations.GetFileInfo_Response callback) {
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
        HttpCacheBackendFileOperationsGetFileInfoResponseParams response =
            HttpCacheBackendFileOperationsGetFileInfoResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.info);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class HttpCacheBackendFileOperationsGetFileInfoResponseParamsProxyToResponder
      implements HttpCacheBackendFileOperations.GetFileInfo_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    HttpCacheBackendFileOperationsGetFileInfoResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(FileInfo info) {
      HttpCacheBackendFileOperationsGetFileInfoResponseParams _response =
          new HttpCacheBackendFileOperationsGetFileInfoResponseParams();
      _response.info = info;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(6, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class HttpCacheBackendFileOperationsEnumerateFilesParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public FilePath path;
    public InterfaceRequest<FileEnumerator> receiver;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private HttpCacheBackendFileOperationsEnumerateFilesParams(int version) {
      super(24, version);
    }

    public HttpCacheBackendFileOperationsEnumerateFilesParams() {
      this(0);
    }

    public static HttpCacheBackendFileOperationsEnumerateFilesParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static HttpCacheBackendFileOperationsEnumerateFilesParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static HttpCacheBackendFileOperationsEnumerateFilesParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        HttpCacheBackendFileOperationsEnumerateFilesParams result =
            new HttpCacheBackendFileOperationsEnumerateFilesParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.path = FilePath.decode(decoder1);
        result.receiver = decoder0.readInterfaceRequest(16, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.path, 8, false);
      encoder0.encode((InterfaceRequest) this.receiver, 16, false);
    }
  }

  static final class HttpCacheBackendFileOperationsCleanupDirectoryParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public FilePath path;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private HttpCacheBackendFileOperationsCleanupDirectoryParams(int version) {
      super(16, version);
    }

    public HttpCacheBackendFileOperationsCleanupDirectoryParams() {
      this(0);
    }

    public static HttpCacheBackendFileOperationsCleanupDirectoryParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static HttpCacheBackendFileOperationsCleanupDirectoryParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static HttpCacheBackendFileOperationsCleanupDirectoryParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        HttpCacheBackendFileOperationsCleanupDirectoryParams result =
            new HttpCacheBackendFileOperationsCleanupDirectoryParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.path = FilePath.decode(decoder1);
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

  static final class HttpCacheBackendFileOperationsCleanupDirectoryResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private HttpCacheBackendFileOperationsCleanupDirectoryResponseParams(int version) {
      super(16, version);
    }

    public HttpCacheBackendFileOperationsCleanupDirectoryResponseParams() {
      this(0);
    }

    public static HttpCacheBackendFileOperationsCleanupDirectoryResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static HttpCacheBackendFileOperationsCleanupDirectoryResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static HttpCacheBackendFileOperationsCleanupDirectoryResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        HttpCacheBackendFileOperationsCleanupDirectoryResponseParams result =
            new HttpCacheBackendFileOperationsCleanupDirectoryResponseParams(elementsOrVersion);
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

  static class HttpCacheBackendFileOperationsCleanupDirectoryResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final HttpCacheBackendFileOperations.CleanupDirectory_Response mCallback;

    HttpCacheBackendFileOperationsCleanupDirectoryResponseParamsForwardToCallback(
        HttpCacheBackendFileOperations.CleanupDirectory_Response callback) {
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
        HttpCacheBackendFileOperationsCleanupDirectoryResponseParams response =
            HttpCacheBackendFileOperationsCleanupDirectoryResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class HttpCacheBackendFileOperationsCleanupDirectoryResponseParamsProxyToResponder
      implements HttpCacheBackendFileOperations.CleanupDirectory_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    HttpCacheBackendFileOperationsCleanupDirectoryResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean result) {
      HttpCacheBackendFileOperationsCleanupDirectoryResponseParams _response =
          new HttpCacheBackendFileOperationsCleanupDirectoryResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(8, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
