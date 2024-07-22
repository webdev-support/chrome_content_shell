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
import org.chromium.mojo.bindings.Union;
import org.chromium.mojo.system.Core;
import org.chromium.mojo.system.DataPipe;
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.InvalidHandle;
import org.chromium.mojo_base.mojom.BigBuffer;
import org.chromium.mojo_base.mojom.FileError;

class FileSystemAccessFileDelegateHost_Internal {
  private static final int GET_LENGTH_ORDINAL = 2;
  public static final Interface.Manager<
          FileSystemAccessFileDelegateHost, FileSystemAccessFileDelegateHost.Proxy>
      MANAGER =
          new Interface.Manager<
              FileSystemAccessFileDelegateHost, FileSystemAccessFileDelegateHost.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.FileSystemAccessFileDelegateHost";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public FileSystemAccessFileDelegateHost.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, FileSystemAccessFileDelegateHost impl) {
              return new Stub(core, impl);
            }

            @Override
            public FileSystemAccessFileDelegateHost[] buildArray(int size) {
              return new FileSystemAccessFileDelegateHost[size];
            }
          };
  private static final int READ_ORDINAL = 0;
  private static final int SET_LENGTH_ORDINAL = 3;
  private static final int WRITE_ORDINAL = 1;

  FileSystemAccessFileDelegateHost_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements FileSystemAccessFileDelegateHost.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void read(long offset, int bytesToRead, Read_Response callback) {
      FileSystemAccessFileDelegateHostReadParams _message =
          new FileSystemAccessFileDelegateHostReadParams();
      _message.offset = offset;
      _message.bytesToRead = bytesToRead;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new FileSystemAccessFileDelegateHostReadResponseParamsForwardToCallback(callback));
    }

    @Override
    public void write(long offset, DataPipe.ConsumerHandle data, Write_Response callback) {
      FileSystemAccessFileDelegateHostWriteParams _message =
          new FileSystemAccessFileDelegateHostWriteParams();
      _message.offset = offset;
      _message.data = data;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new FileSystemAccessFileDelegateHostWriteResponseParamsForwardToCallback(callback));
    }

    @Override
    public void getLength(GetLength_Response callback) {
      FileSystemAccessFileDelegateHostGetLengthParams _message =
          new FileSystemAccessFileDelegateHostGetLengthParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new FileSystemAccessFileDelegateHostGetLengthResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void setLength(long length, SetLength_Response callback) {
      FileSystemAccessFileDelegateHostSetLengthParams _message =
          new FileSystemAccessFileDelegateHostSetLengthParams();
      _message.length = length;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)),
              new FileSystemAccessFileDelegateHostSetLengthResponseParamsForwardToCallback(
                  callback));
    }
  }

  public static final class Stub extends Interface.Stub<FileSystemAccessFileDelegateHost> {
    Stub(Core core, FileSystemAccessFileDelegateHost impl) {
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
                FileSystemAccessFileDelegateHost_Internal.MANAGER, messageWithHeader);
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
                FileSystemAccessFileDelegateHost_Internal.MANAGER,
                messageWithHeader,
                receiver);
          case 0:
            FileSystemAccessFileDelegateHostReadParams data =
                FileSystemAccessFileDelegateHostReadParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .read(
                    data.offset,
                    data.bytesToRead,
                    new FileSystemAccessFileDelegateHostReadResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
            FileSystemAccessFileDelegateHostWriteParams data2 =
                FileSystemAccessFileDelegateHostWriteParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .write(
                    data2.offset,
                    data2.data,
                    new FileSystemAccessFileDelegateHostWriteResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 2:
            FileSystemAccessFileDelegateHostGetLengthParams.deserialize(
                messageWithHeader.getPayload());
            getImpl()
                .getLength(
                    new FileSystemAccessFileDelegateHostGetLengthResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 3:
            getImpl()
                .setLength(
                    FileSystemAccessFileDelegateHostSetLengthParams.deserialize(
                            messageWithHeader.getPayload())
                        .length,
                    new FileSystemAccessFileDelegateHostSetLengthResponseParamsProxyToResponder(
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

  static final class FileSystemAccessFileDelegateHostReadParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int bytesToRead;
    public long offset;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessFileDelegateHostReadParams(int version) {
      super(24, version);
    }

    public FileSystemAccessFileDelegateHostReadParams() {
      this(0);
    }

    public static FileSystemAccessFileDelegateHostReadParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessFileDelegateHostReadParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessFileDelegateHostReadParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessFileDelegateHostReadParams result =
            new FileSystemAccessFileDelegateHostReadParams(elementsOrVersion);
        result.offset = decoder0.readLong(8);
        result.bytesToRead = decoder0.readInt(16);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.offset, 8);
      encoder0.encode(this.bytesToRead, 16);
    }
  }

  static final class FileSystemAccessFileDelegateHostReadResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public int bytesRead;
    public BigBuffer data;
    public int error;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessFileDelegateHostReadResponseParams(int version) {
      super(32, version);
    }

    public FileSystemAccessFileDelegateHostReadResponseParams() {
      this(0);
    }

    public static FileSystemAccessFileDelegateHostReadResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessFileDelegateHostReadResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessFileDelegateHostReadResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessFileDelegateHostReadResponseParams result =
            new FileSystemAccessFileDelegateHostReadResponseParams(elementsOrVersion);
        result.data = BigBuffer.decode(decoder0, 8);
        int readInt = decoder0.readInt(24);
        result.error = readInt;
        FileError.validate(readInt);
        result.error = FileError.toKnownValue(result.error);
        result.bytesRead = decoder0.readInt(28);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Union) this.data, 8, true);
      encoder0.encode(this.error, 24);
      encoder0.encode(this.bytesRead, 28);
    }
  }

  static class FileSystemAccessFileDelegateHostReadResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FileSystemAccessFileDelegateHost.Read_Response mCallback;

    FileSystemAccessFileDelegateHostReadResponseParamsForwardToCallback(
        FileSystemAccessFileDelegateHost.Read_Response callback) {
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
        FileSystemAccessFileDelegateHostReadResponseParams response =
            FileSystemAccessFileDelegateHostReadResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.data, response.error, response.bytesRead);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FileSystemAccessFileDelegateHostReadResponseParamsProxyToResponder
      implements FileSystemAccessFileDelegateHost.Read_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FileSystemAccessFileDelegateHostReadResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(BigBuffer data, int error, int bytesRead) {
      FileSystemAccessFileDelegateHostReadResponseParams _response =
          new FileSystemAccessFileDelegateHostReadResponseParams();
      _response.data = data;
      _response.error = error;
      _response.bytesRead = bytesRead;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FileSystemAccessFileDelegateHostWriteParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public DataPipe.ConsumerHandle data;
    public long offset;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessFileDelegateHostWriteParams(int version) {
      super(24, version);
      this.data = InvalidHandle.INSTANCE;
    }

    public FileSystemAccessFileDelegateHostWriteParams() {
      this(0);
    }

    public static FileSystemAccessFileDelegateHostWriteParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessFileDelegateHostWriteParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessFileDelegateHostWriteParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessFileDelegateHostWriteParams result =
            new FileSystemAccessFileDelegateHostWriteParams(elementsOrVersion);
        result.offset = decoder0.readLong(8);
        result.data = decoder0.readConsumerHandle(16, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.offset, 8);
      encoder0.encode((Handle) this.data, 16, false);
    }
  }

  static final class FileSystemAccessFileDelegateHostWriteResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int bytesWritten;
    public int error;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessFileDelegateHostWriteResponseParams(int version) {
      super(16, version);
    }

    public FileSystemAccessFileDelegateHostWriteResponseParams() {
      this(0);
    }

    public static FileSystemAccessFileDelegateHostWriteResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessFileDelegateHostWriteResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessFileDelegateHostWriteResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessFileDelegateHostWriteResponseParams result =
            new FileSystemAccessFileDelegateHostWriteResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.error = readInt;
        FileError.validate(readInt);
        result.error = FileError.toKnownValue(result.error);
        result.bytesWritten = decoder0.readInt(12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.error, 8);
      encoder0.encode(this.bytesWritten, 12);
    }
  }

  static class FileSystemAccessFileDelegateHostWriteResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FileSystemAccessFileDelegateHost.Write_Response mCallback;

    FileSystemAccessFileDelegateHostWriteResponseParamsForwardToCallback(
        FileSystemAccessFileDelegateHost.Write_Response callback) {
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
        FileSystemAccessFileDelegateHostWriteResponseParams response =
            FileSystemAccessFileDelegateHostWriteResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.error, response.bytesWritten);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FileSystemAccessFileDelegateHostWriteResponseParamsProxyToResponder
      implements FileSystemAccessFileDelegateHost.Write_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FileSystemAccessFileDelegateHostWriteResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int error, int bytesWritten) {
      FileSystemAccessFileDelegateHostWriteResponseParams _response =
          new FileSystemAccessFileDelegateHostWriteResponseParams();
      _response.error = error;
      _response.bytesWritten = bytesWritten;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FileSystemAccessFileDelegateHostGetLengthParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessFileDelegateHostGetLengthParams(int version) {
      super(8, version);
    }

    public FileSystemAccessFileDelegateHostGetLengthParams() {
      this(0);
    }

    public static FileSystemAccessFileDelegateHostGetLengthParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessFileDelegateHostGetLengthParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessFileDelegateHostGetLengthParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessFileDelegateHostGetLengthParams result =
            new FileSystemAccessFileDelegateHostGetLengthParams(elementsOrVersion);
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

  static final class FileSystemAccessFileDelegateHostGetLengthResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int error;
    public long length;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessFileDelegateHostGetLengthResponseParams(int version) {
      super(24, version);
    }

    public FileSystemAccessFileDelegateHostGetLengthResponseParams() {
      this(0);
    }

    public static FileSystemAccessFileDelegateHostGetLengthResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessFileDelegateHostGetLengthResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessFileDelegateHostGetLengthResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessFileDelegateHostGetLengthResponseParams result =
            new FileSystemAccessFileDelegateHostGetLengthResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.error = readInt;
        FileError.validate(readInt);
        result.error = FileError.toKnownValue(result.error);
        result.length = decoder0.readLong(16);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.error, 8);
      encoder0.encode(this.length, 16);
    }
  }

  static class FileSystemAccessFileDelegateHostGetLengthResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FileSystemAccessFileDelegateHost.GetLength_Response mCallback;

    FileSystemAccessFileDelegateHostGetLengthResponseParamsForwardToCallback(
        FileSystemAccessFileDelegateHost.GetLength_Response callback) {
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
        FileSystemAccessFileDelegateHostGetLengthResponseParams response =
            FileSystemAccessFileDelegateHostGetLengthResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.error, response.length);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FileSystemAccessFileDelegateHostGetLengthResponseParamsProxyToResponder
      implements FileSystemAccessFileDelegateHost.GetLength_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FileSystemAccessFileDelegateHostGetLengthResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int error, long length) {
      FileSystemAccessFileDelegateHostGetLengthResponseParams _response =
          new FileSystemAccessFileDelegateHostGetLengthResponseParams();
      _response.error = error;
      _response.length = length;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FileSystemAccessFileDelegateHostSetLengthParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public long length;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessFileDelegateHostSetLengthParams(int version) {
      super(16, version);
    }

    public FileSystemAccessFileDelegateHostSetLengthParams() {
      this(0);
    }

    public static FileSystemAccessFileDelegateHostSetLengthParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessFileDelegateHostSetLengthParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessFileDelegateHostSetLengthParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessFileDelegateHostSetLengthParams result =
            new FileSystemAccessFileDelegateHostSetLengthParams(elementsOrVersion);
        result.length = decoder0.readLong(8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.length, 8);
    }
  }

  static final class FileSystemAccessFileDelegateHostSetLengthResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int error;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessFileDelegateHostSetLengthResponseParams(int version) {
      super(16, version);
    }

    public FileSystemAccessFileDelegateHostSetLengthResponseParams() {
      this(0);
    }

    public static FileSystemAccessFileDelegateHostSetLengthResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessFileDelegateHostSetLengthResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessFileDelegateHostSetLengthResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessFileDelegateHostSetLengthResponseParams result =
            new FileSystemAccessFileDelegateHostSetLengthResponseParams(elementsOrVersion);
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

  static class FileSystemAccessFileDelegateHostSetLengthResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FileSystemAccessFileDelegateHost.SetLength_Response mCallback;

    FileSystemAccessFileDelegateHostSetLengthResponseParamsForwardToCallback(
        FileSystemAccessFileDelegateHost.SetLength_Response callback) {
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
        FileSystemAccessFileDelegateHostSetLengthResponseParams response =
            FileSystemAccessFileDelegateHostSetLengthResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.error);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FileSystemAccessFileDelegateHostSetLengthResponseParamsProxyToResponder
      implements FileSystemAccessFileDelegateHost.SetLength_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FileSystemAccessFileDelegateHostSetLengthResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int error) {
      FileSystemAccessFileDelegateHostSetLengthResponseParams _response =
          new FileSystemAccessFileDelegateHostSetLengthResponseParams();
      _response.error = error;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(3, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
