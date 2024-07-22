package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
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
import org.chromium.mojo_base.mojom.String16;
import org.chromium.url.internal.mojom.Origin;

class WebDatabaseHost_Internal {
  private static final int CLOSED_ORDINAL = 7;
  private static final int DELETE_FILE_ORDINAL = 1;
  private static final int GET_FILE_ATTRIBUTES_ORDINAL = 2;
  private static final int GET_SPACE_AVAILABLE_ORDINAL = 4;
  private static final int HANDLE_SQLITE_ERROR_ORDINAL = 8;
  public static final Interface.Manager<WebDatabaseHost, WebDatabaseHost.Proxy> MANAGER =
      new Interface.Manager<WebDatabaseHost, WebDatabaseHost.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.WebDatabaseHost";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public WebDatabaseHost.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, WebDatabaseHost impl) {
          return new Stub(core, impl);
        }

        @Override
        public WebDatabaseHost[] buildArray(int size) {
          return new WebDatabaseHost[size];
        }
      };
  private static final int MODIFIED_ORDINAL = 6;
  private static final int OPENED_ORDINAL = 5;
  private static final int OPEN_FILE_ORDINAL = 0;
  private static final int SET_FILE_SIZE_ORDINAL = 3;

  WebDatabaseHost_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements WebDatabaseHost.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void openFile(String16 vfsFileName, int desiredFlags, OpenFile_Response callback) {
      WebDatabaseHostOpenFileParams _message = new WebDatabaseHostOpenFileParams();
      _message.vfsFileName = vfsFileName;
      _message.desiredFlags = desiredFlags;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new WebDatabaseHostOpenFileResponseParamsForwardToCallback(callback));
    }

    @Override
    public void deleteFile(String16 vfsFileName, boolean syncDir, DeleteFile_Response callback) {
      WebDatabaseHostDeleteFileParams _message = new WebDatabaseHostDeleteFileParams();
      _message.vfsFileName = vfsFileName;
      _message.syncDir = syncDir;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new WebDatabaseHostDeleteFileResponseParamsForwardToCallback(callback));
    }

    @Override
    public void getFileAttributes(String16 vfsFileName, GetFileAttributes_Response callback) {
      WebDatabaseHostGetFileAttributesParams _message =
          new WebDatabaseHostGetFileAttributesParams();
      _message.vfsFileName = vfsFileName;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new WebDatabaseHostGetFileAttributesResponseParamsForwardToCallback(callback));
    }

    @Override
    public void setFileSize(
        String16 vfsFileName, long expectedSize, SetFileSize_Response callback) {
      WebDatabaseHostSetFileSizeParams _message = new WebDatabaseHostSetFileSizeParams();
      _message.vfsFileName = vfsFileName;
      _message.expectedSize = expectedSize;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)),
              new WebDatabaseHostSetFileSizeResponseParamsForwardToCallback(callback));
    }

    @Override
    public void getSpaceAvailable(Origin origin, GetSpaceAvailable_Response callback) {
      WebDatabaseHostGetSpaceAvailableParams _message =
          new WebDatabaseHostGetSpaceAvailableParams();
      _message.origin = origin;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)),
              new WebDatabaseHostGetSpaceAvailableResponseParamsForwardToCallback(callback));
    }

    @Override
    public void opened(Origin origin, String16 databaseName, String16 databaseDescription) {
      WebDatabaseHostOpenedParams _message = new WebDatabaseHostOpenedParams();
      _message.origin = origin;
      _message.databaseName = databaseName;
      _message.databaseDescription = databaseDescription;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5)));
    }

    @Override
    public void modified(Origin origin, String16 databaseName) {
      WebDatabaseHostModifiedParams _message = new WebDatabaseHostModifiedParams();
      _message.origin = origin;
      _message.databaseName = databaseName;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(6)));
    }

    @Override
    public void closed(Origin origin, String16 databaseName) {
      WebDatabaseHostClosedParams _message = new WebDatabaseHostClosedParams();
      _message.origin = origin;
      _message.databaseName = databaseName;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(7)));
    }

    @Override
    public void handleSqliteError(Origin origin, String16 databaseName, int error) {
      WebDatabaseHostHandleSqliteErrorParams _message =
          new WebDatabaseHostHandleSqliteErrorParams();
      _message.origin = origin;
      _message.databaseName = databaseName;
      _message.error = error;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(8)));
    }
  }

  public static final class Stub extends Interface.Stub<WebDatabaseHost> {
    Stub(Core core, WebDatabaseHost impl) {
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
                WebDatabaseHost_Internal.MANAGER, messageWithHeader);
          case 5:
            WebDatabaseHostOpenedParams data =
                WebDatabaseHostOpenedParams.deserialize(messageWithHeader.getPayload());
            getImpl().opened(data.origin, data.databaseName, data.databaseDescription);
            return true;
          case 6:
            WebDatabaseHostModifiedParams data2 =
                WebDatabaseHostModifiedParams.deserialize(messageWithHeader.getPayload());
            getImpl().modified(data2.origin, data2.databaseName);
            return true;
          case 7:
            WebDatabaseHostClosedParams data3 =
                WebDatabaseHostClosedParams.deserialize(messageWithHeader.getPayload());
            getImpl().closed(data3.origin, data3.databaseName);
            return true;
          case 8:
            WebDatabaseHostHandleSqliteErrorParams data4 =
                WebDatabaseHostHandleSqliteErrorParams.deserialize(messageWithHeader.getPayload());
            getImpl().handleSqliteError(data4.origin, data4.databaseName, data4.error);
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
                getCore(), WebDatabaseHost_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            WebDatabaseHostOpenFileParams data =
                WebDatabaseHostOpenFileParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .openFile(
                    data.vfsFileName,
                    data.desiredFlags,
                    new WebDatabaseHostOpenFileResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
            WebDatabaseHostDeleteFileParams data2 =
                WebDatabaseHostDeleteFileParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .deleteFile(
                    data2.vfsFileName,
                    data2.syncDir,
                    new WebDatabaseHostDeleteFileResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 2:
            getImpl()
                .getFileAttributes(
                    WebDatabaseHostGetFileAttributesParams.deserialize(
                            messageWithHeader.getPayload())
                        .vfsFileName,
                    new WebDatabaseHostGetFileAttributesResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 3:
            WebDatabaseHostSetFileSizeParams data3 =
                WebDatabaseHostSetFileSizeParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .setFileSize(
                    data3.vfsFileName,
                    data3.expectedSize,
                    new WebDatabaseHostSetFileSizeResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 4:
            getImpl()
                .getSpaceAvailable(
                    WebDatabaseHostGetSpaceAvailableParams.deserialize(
                            messageWithHeader.getPayload())
                        .origin,
                    new WebDatabaseHostGetSpaceAvailableResponseParamsProxyToResponder(
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

  static final class WebDatabaseHostOpenFileParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int desiredFlags;
    public String16 vfsFileName;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebDatabaseHostOpenFileParams(int version) {
      super(24, version);
    }

    public WebDatabaseHostOpenFileParams() {
      this(0);
    }

    public static WebDatabaseHostOpenFileParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WebDatabaseHostOpenFileParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebDatabaseHostOpenFileParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebDatabaseHostOpenFileParams result = new WebDatabaseHostOpenFileParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.vfsFileName = String16.decode(decoder1);
        result.desiredFlags = decoder0.readInt(16);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.vfsFileName, 8, false);
      encoder0.encode(this.desiredFlags, 16);
    }
  }

  static final class WebDatabaseHostOpenFileResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public org.chromium.mojo_base.mojom.File file;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebDatabaseHostOpenFileResponseParams(int version) {
      super(16, version);
    }

    public WebDatabaseHostOpenFileResponseParams() {
      this(0);
    }

    public static WebDatabaseHostOpenFileResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WebDatabaseHostOpenFileResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebDatabaseHostOpenFileResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebDatabaseHostOpenFileResponseParams result =
            new WebDatabaseHostOpenFileResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.file = org.chromium.mojo_base.mojom.File.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.file, 8, true);
    }
  }

  static class WebDatabaseHostOpenFileResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final WebDatabaseHost.OpenFile_Response mCallback;

    WebDatabaseHostOpenFileResponseParamsForwardToCallback(
        WebDatabaseHost.OpenFile_Response callback) {
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
        WebDatabaseHostOpenFileResponseParams response =
            WebDatabaseHostOpenFileResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.file);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class WebDatabaseHostOpenFileResponseParamsProxyToResponder
      implements WebDatabaseHost.OpenFile_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    WebDatabaseHostOpenFileResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(org.chromium.mojo_base.mojom.File file) {
      WebDatabaseHostOpenFileResponseParams _response = new WebDatabaseHostOpenFileResponseParams();
      _response.file = file;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class WebDatabaseHostDeleteFileParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean syncDir;
    public String16 vfsFileName;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebDatabaseHostDeleteFileParams(int version) {
      super(24, version);
    }

    public WebDatabaseHostDeleteFileParams() {
      this(0);
    }

    public static WebDatabaseHostDeleteFileParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WebDatabaseHostDeleteFileParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebDatabaseHostDeleteFileParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebDatabaseHostDeleteFileParams result =
            new WebDatabaseHostDeleteFileParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.vfsFileName = String16.decode(decoder1);
        result.syncDir = decoder0.readBoolean(16, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.vfsFileName, 8, false);
      encoder0.encode(this.syncDir, 16, 0);
    }
  }

  static final class WebDatabaseHostDeleteFileResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int sqliteErrorCode;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebDatabaseHostDeleteFileResponseParams(int version) {
      super(16, version);
    }

    public WebDatabaseHostDeleteFileResponseParams() {
      this(0);
    }

    public static WebDatabaseHostDeleteFileResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WebDatabaseHostDeleteFileResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebDatabaseHostDeleteFileResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebDatabaseHostDeleteFileResponseParams result =
            new WebDatabaseHostDeleteFileResponseParams(elementsOrVersion);
        result.sqliteErrorCode = decoder0.readInt(8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.sqliteErrorCode, 8);
    }
  }

  static class WebDatabaseHostDeleteFileResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final WebDatabaseHost.DeleteFile_Response mCallback;

    WebDatabaseHostDeleteFileResponseParamsForwardToCallback(
        WebDatabaseHost.DeleteFile_Response callback) {
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
        WebDatabaseHostDeleteFileResponseParams response =
            WebDatabaseHostDeleteFileResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.sqliteErrorCode);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class WebDatabaseHostDeleteFileResponseParamsProxyToResponder
      implements WebDatabaseHost.DeleteFile_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    WebDatabaseHostDeleteFileResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int sqliteErrorCode) {
      WebDatabaseHostDeleteFileResponseParams _response =
          new WebDatabaseHostDeleteFileResponseParams();
      _response.sqliteErrorCode = sqliteErrorCode;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class WebDatabaseHostGetFileAttributesParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String16 vfsFileName;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebDatabaseHostGetFileAttributesParams(int version) {
      super(16, version);
    }

    public WebDatabaseHostGetFileAttributesParams() {
      this(0);
    }

    public static WebDatabaseHostGetFileAttributesParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WebDatabaseHostGetFileAttributesParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebDatabaseHostGetFileAttributesParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebDatabaseHostGetFileAttributesParams result =
            new WebDatabaseHostGetFileAttributesParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.vfsFileName = String16.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.vfsFileName, 8, false);
    }
  }

  static final class WebDatabaseHostGetFileAttributesResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int attributes;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebDatabaseHostGetFileAttributesResponseParams(int version) {
      super(16, version);
    }

    public WebDatabaseHostGetFileAttributesResponseParams() {
      this(0);
    }

    public static WebDatabaseHostGetFileAttributesResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WebDatabaseHostGetFileAttributesResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebDatabaseHostGetFileAttributesResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebDatabaseHostGetFileAttributesResponseParams result =
            new WebDatabaseHostGetFileAttributesResponseParams(elementsOrVersion);
        result.attributes = decoder0.readInt(8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.attributes, 8);
    }
  }

  static class WebDatabaseHostGetFileAttributesResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final WebDatabaseHost.GetFileAttributes_Response mCallback;

    WebDatabaseHostGetFileAttributesResponseParamsForwardToCallback(
        WebDatabaseHost.GetFileAttributes_Response callback) {
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
        WebDatabaseHostGetFileAttributesResponseParams response =
            WebDatabaseHostGetFileAttributesResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.attributes);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class WebDatabaseHostGetFileAttributesResponseParamsProxyToResponder
      implements WebDatabaseHost.GetFileAttributes_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    WebDatabaseHostGetFileAttributesResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int attributes) {
      WebDatabaseHostGetFileAttributesResponseParams _response =
          new WebDatabaseHostGetFileAttributesResponseParams();
      _response.attributes = attributes;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class WebDatabaseHostSetFileSizeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public long expectedSize;
    public String16 vfsFileName;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebDatabaseHostSetFileSizeParams(int version) {
      super(24, version);
    }

    public WebDatabaseHostSetFileSizeParams() {
      this(0);
    }

    public static WebDatabaseHostSetFileSizeParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WebDatabaseHostSetFileSizeParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebDatabaseHostSetFileSizeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebDatabaseHostSetFileSizeParams result =
            new WebDatabaseHostSetFileSizeParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.vfsFileName = String16.decode(decoder1);
        result.expectedSize = decoder0.readLong(16);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.vfsFileName, 8, false);
      encoder0.encode(this.expectedSize, 16);
    }
  }

  static final class WebDatabaseHostSetFileSizeResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean success;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebDatabaseHostSetFileSizeResponseParams(int version) {
      super(16, version);
    }

    public WebDatabaseHostSetFileSizeResponseParams() {
      this(0);
    }

    public static WebDatabaseHostSetFileSizeResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WebDatabaseHostSetFileSizeResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebDatabaseHostSetFileSizeResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebDatabaseHostSetFileSizeResponseParams result =
            new WebDatabaseHostSetFileSizeResponseParams(elementsOrVersion);
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

  static class WebDatabaseHostSetFileSizeResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final WebDatabaseHost.SetFileSize_Response mCallback;

    WebDatabaseHostSetFileSizeResponseParamsForwardToCallback(
        WebDatabaseHost.SetFileSize_Response callback) {
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
        WebDatabaseHostSetFileSizeResponseParams response =
            WebDatabaseHostSetFileSizeResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.success);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class WebDatabaseHostSetFileSizeResponseParamsProxyToResponder
      implements WebDatabaseHost.SetFileSize_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    WebDatabaseHostSetFileSizeResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean success) {
      WebDatabaseHostSetFileSizeResponseParams _response =
          new WebDatabaseHostSetFileSizeResponseParams();
      _response.success = success;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(3, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class WebDatabaseHostGetSpaceAvailableParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Origin origin;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebDatabaseHostGetSpaceAvailableParams(int version) {
      super(16, version);
    }

    public WebDatabaseHostGetSpaceAvailableParams() {
      this(0);
    }

    public static WebDatabaseHostGetSpaceAvailableParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WebDatabaseHostGetSpaceAvailableParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebDatabaseHostGetSpaceAvailableParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebDatabaseHostGetSpaceAvailableParams result =
            new WebDatabaseHostGetSpaceAvailableParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.origin = Origin.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.origin, 8, false);
    }
  }

  static final class WebDatabaseHostGetSpaceAvailableResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public long spaceAvailable;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebDatabaseHostGetSpaceAvailableResponseParams(int version) {
      super(16, version);
    }

    public WebDatabaseHostGetSpaceAvailableResponseParams() {
      this(0);
    }

    public static WebDatabaseHostGetSpaceAvailableResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WebDatabaseHostGetSpaceAvailableResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebDatabaseHostGetSpaceAvailableResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebDatabaseHostGetSpaceAvailableResponseParams result =
            new WebDatabaseHostGetSpaceAvailableResponseParams(elementsOrVersion);
        result.spaceAvailable = decoder0.readLong(8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.spaceAvailable, 8);
    }
  }

  static class WebDatabaseHostGetSpaceAvailableResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final WebDatabaseHost.GetSpaceAvailable_Response mCallback;

    WebDatabaseHostGetSpaceAvailableResponseParamsForwardToCallback(
        WebDatabaseHost.GetSpaceAvailable_Response callback) {
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
        WebDatabaseHostGetSpaceAvailableResponseParams response =
            WebDatabaseHostGetSpaceAvailableResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.spaceAvailable);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class WebDatabaseHostGetSpaceAvailableResponseParamsProxyToResponder
      implements WebDatabaseHost.GetSpaceAvailable_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    WebDatabaseHostGetSpaceAvailableResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(long spaceAvailable) {
      WebDatabaseHostGetSpaceAvailableResponseParams _response =
          new WebDatabaseHostGetSpaceAvailableResponseParams();
      _response.spaceAvailable = spaceAvailable;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(4, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class WebDatabaseHostOpenedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public String16 databaseDescription;
    public String16 databaseName;
    public Origin origin;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebDatabaseHostOpenedParams(int version) {
      super(32, version);
    }

    public WebDatabaseHostOpenedParams() {
      this(0);
    }

    public static WebDatabaseHostOpenedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WebDatabaseHostOpenedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebDatabaseHostOpenedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebDatabaseHostOpenedParams result = new WebDatabaseHostOpenedParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.origin = Origin.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.databaseName = String16.decode(decoder12);
        Decoder decoder13 = decoder0.readPointer(24, false);
        result.databaseDescription = String16.decode(decoder13);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.origin, 8, false);
      encoder0.encode((Struct) this.databaseName, 16, false);
      encoder0.encode((Struct) this.databaseDescription, 24, false);
    }
  }

  static final class WebDatabaseHostModifiedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public String16 databaseName;
    public Origin origin;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebDatabaseHostModifiedParams(int version) {
      super(24, version);
    }

    public WebDatabaseHostModifiedParams() {
      this(0);
    }

    public static WebDatabaseHostModifiedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WebDatabaseHostModifiedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebDatabaseHostModifiedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebDatabaseHostModifiedParams result = new WebDatabaseHostModifiedParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.origin = Origin.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.databaseName = String16.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.origin, 8, false);
      encoder0.encode((Struct) this.databaseName, 16, false);
    }
  }

  static final class WebDatabaseHostClosedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public String16 databaseName;
    public Origin origin;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebDatabaseHostClosedParams(int version) {
      super(24, version);
    }

    public WebDatabaseHostClosedParams() {
      this(0);
    }

    public static WebDatabaseHostClosedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WebDatabaseHostClosedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebDatabaseHostClosedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebDatabaseHostClosedParams result = new WebDatabaseHostClosedParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.origin = Origin.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.databaseName = String16.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.origin, 8, false);
      encoder0.encode((Struct) this.databaseName, 16, false);
    }
  }

  static final class WebDatabaseHostHandleSqliteErrorParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public String16 databaseName;
    public int error;
    public Origin origin;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebDatabaseHostHandleSqliteErrorParams(int version) {
      super(32, version);
    }

    public WebDatabaseHostHandleSqliteErrorParams() {
      this(0);
    }

    public static WebDatabaseHostHandleSqliteErrorParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WebDatabaseHostHandleSqliteErrorParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebDatabaseHostHandleSqliteErrorParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebDatabaseHostHandleSqliteErrorParams result =
            new WebDatabaseHostHandleSqliteErrorParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.origin = Origin.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.databaseName = String16.decode(decoder12);
        result.error = decoder0.readInt(24);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.origin, 8, false);
      encoder0.encode((Struct) this.databaseName, 16, false);
      encoder0.encode(this.error, 24);
    }
  }
}
