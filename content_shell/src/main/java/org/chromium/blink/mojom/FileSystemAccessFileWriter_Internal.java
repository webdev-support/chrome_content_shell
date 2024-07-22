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
import org.chromium.mojo.system.DataPipe;
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.InvalidHandle;

class FileSystemAccessFileWriter_Internal {
  private static final int ABORT_ORDINAL = 3;
  private static final int CLOSE_ORDINAL = 2;
  public static final Interface.Manager<
          FileSystemAccessFileWriter, FileSystemAccessFileWriter.Proxy>
      MANAGER =
          new Interface.Manager<FileSystemAccessFileWriter, FileSystemAccessFileWriter.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.FileSystemAccessFileWriter";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public FileSystemAccessFileWriter.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, FileSystemAccessFileWriter impl) {
              return new Stub(core, impl);
            }

            @Override
            public FileSystemAccessFileWriter[] buildArray(int size) {
              return new FileSystemAccessFileWriter[size];
            }
          };
  private static final int TRUNCATE_ORDINAL = 1;
  private static final int WRITE_ORDINAL = 0;

  FileSystemAccessFileWriter_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements FileSystemAccessFileWriter.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void write(long offset, DataPipe.ConsumerHandle stream, Write_Response callback) {
      FileSystemAccessFileWriterWriteParams _message = new FileSystemAccessFileWriterWriteParams();
      _message.offset = offset;
      _message.stream = stream;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new FileSystemAccessFileWriterWriteResponseParamsForwardToCallback(callback));
    }

    @Override
    public void truncate(long length, Truncate_Response callback) {
      FileSystemAccessFileWriterTruncateParams _message =
          new FileSystemAccessFileWriterTruncateParams();
      _message.length = length;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new FileSystemAccessFileWriterTruncateResponseParamsForwardToCallback(callback));
    }

    @Override
    public void close(Close_Response callback) {
      FileSystemAccessFileWriterCloseParams _message = new FileSystemAccessFileWriterCloseParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new FileSystemAccessFileWriterCloseResponseParamsForwardToCallback(callback));
    }

    @Override
    public void abort(Abort_Response callback) {
      FileSystemAccessFileWriterAbortParams _message = new FileSystemAccessFileWriterAbortParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)),
              new FileSystemAccessFileWriterAbortResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<FileSystemAccessFileWriter> {
    Stub(Core core, FileSystemAccessFileWriter impl) {
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
                FileSystemAccessFileWriter_Internal.MANAGER, messageWithHeader);
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
                FileSystemAccessFileWriter_Internal.MANAGER,
                messageWithHeader,
                receiver);
          case 0:
            FileSystemAccessFileWriterWriteParams data =
                FileSystemAccessFileWriterWriteParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .write(
                    data.offset,
                    data.stream,
                    new FileSystemAccessFileWriterWriteResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
            getImpl()
                .truncate(
                    FileSystemAccessFileWriterTruncateParams.deserialize(
                            messageWithHeader.getPayload())
                        .length,
                    new FileSystemAccessFileWriterTruncateResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 2:
            FileSystemAccessFileWriterCloseParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .close(
                    new FileSystemAccessFileWriterCloseResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 3:
            FileSystemAccessFileWriterAbortParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .abort(
                    new FileSystemAccessFileWriterAbortResponseParamsProxyToResponder(
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

  static final class FileSystemAccessFileWriterWriteParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public long offset;
    public DataPipe.ConsumerHandle stream;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessFileWriterWriteParams(int version) {
      super(24, version);
      this.stream = InvalidHandle.INSTANCE;
    }

    public FileSystemAccessFileWriterWriteParams() {
      this(0);
    }

    public static FileSystemAccessFileWriterWriteParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessFileWriterWriteParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessFileWriterWriteParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessFileWriterWriteParams result =
            new FileSystemAccessFileWriterWriteParams(elementsOrVersion);
        result.offset = decoder0.readLong(8);
        result.stream = decoder0.readConsumerHandle(16, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.offset, 8);
      encoder0.encode((Handle) this.stream, 16, false);
    }
  }

  static final class FileSystemAccessFileWriterWriteResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public long bytesWritten;
    public FileSystemAccessError result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessFileWriterWriteResponseParams(int version) {
      super(24, version);
    }

    public FileSystemAccessFileWriterWriteResponseParams() {
      this(0);
    }

    public static FileSystemAccessFileWriterWriteResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessFileWriterWriteResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessFileWriterWriteResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessFileWriterWriteResponseParams result =
            new FileSystemAccessFileWriterWriteResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.result = FileSystemAccessError.decode(decoder1);
        result.bytesWritten = decoder0.readLong(16);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.result, 8, false);
      encoder0.encode(this.bytesWritten, 16);
    }
  }

  static class FileSystemAccessFileWriterWriteResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FileSystemAccessFileWriter.Write_Response mCallback;

    FileSystemAccessFileWriterWriteResponseParamsForwardToCallback(
        FileSystemAccessFileWriter.Write_Response callback) {
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
        FileSystemAccessFileWriterWriteResponseParams response =
            FileSystemAccessFileWriterWriteResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result, response.bytesWritten);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FileSystemAccessFileWriterWriteResponseParamsProxyToResponder
      implements FileSystemAccessFileWriter.Write_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FileSystemAccessFileWriterWriteResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(FileSystemAccessError result, long bytesWritten) {
      FileSystemAccessFileWriterWriteResponseParams _response =
          new FileSystemAccessFileWriterWriteResponseParams();
      _response.result = result;
      _response.bytesWritten = bytesWritten;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FileSystemAccessFileWriterTruncateParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public long length;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessFileWriterTruncateParams(int version) {
      super(16, version);
    }

    public FileSystemAccessFileWriterTruncateParams() {
      this(0);
    }

    public static FileSystemAccessFileWriterTruncateParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessFileWriterTruncateParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessFileWriterTruncateParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessFileWriterTruncateParams result =
            new FileSystemAccessFileWriterTruncateParams(elementsOrVersion);
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

  static final class FileSystemAccessFileWriterTruncateResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public FileSystemAccessError result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessFileWriterTruncateResponseParams(int version) {
      super(16, version);
    }

    public FileSystemAccessFileWriterTruncateResponseParams() {
      this(0);
    }

    public static FileSystemAccessFileWriterTruncateResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessFileWriterTruncateResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessFileWriterTruncateResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessFileWriterTruncateResponseParams result =
            new FileSystemAccessFileWriterTruncateResponseParams(elementsOrVersion);
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

  static class FileSystemAccessFileWriterTruncateResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FileSystemAccessFileWriter.Truncate_Response mCallback;

    FileSystemAccessFileWriterTruncateResponseParamsForwardToCallback(
        FileSystemAccessFileWriter.Truncate_Response callback) {
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
        FileSystemAccessFileWriterTruncateResponseParams response =
            FileSystemAccessFileWriterTruncateResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FileSystemAccessFileWriterTruncateResponseParamsProxyToResponder
      implements FileSystemAccessFileWriter.Truncate_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FileSystemAccessFileWriterTruncateResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(FileSystemAccessError result) {
      FileSystemAccessFileWriterTruncateResponseParams _response =
          new FileSystemAccessFileWriterTruncateResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FileSystemAccessFileWriterCloseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessFileWriterCloseParams(int version) {
      super(8, version);
    }

    public FileSystemAccessFileWriterCloseParams() {
      this(0);
    }

    public static FileSystemAccessFileWriterCloseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessFileWriterCloseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessFileWriterCloseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessFileWriterCloseParams result =
            new FileSystemAccessFileWriterCloseParams(elementsOrVersion);
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

  static final class FileSystemAccessFileWriterCloseResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public FileSystemAccessError result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessFileWriterCloseResponseParams(int version) {
      super(16, version);
    }

    public FileSystemAccessFileWriterCloseResponseParams() {
      this(0);
    }

    public static FileSystemAccessFileWriterCloseResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessFileWriterCloseResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessFileWriterCloseResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessFileWriterCloseResponseParams result =
            new FileSystemAccessFileWriterCloseResponseParams(elementsOrVersion);
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

  static class FileSystemAccessFileWriterCloseResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FileSystemAccessFileWriter.Close_Response mCallback;

    FileSystemAccessFileWriterCloseResponseParamsForwardToCallback(
        FileSystemAccessFileWriter.Close_Response callback) {
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
        FileSystemAccessFileWriterCloseResponseParams response =
            FileSystemAccessFileWriterCloseResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FileSystemAccessFileWriterCloseResponseParamsProxyToResponder
      implements FileSystemAccessFileWriter.Close_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FileSystemAccessFileWriterCloseResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(FileSystemAccessError result) {
      FileSystemAccessFileWriterCloseResponseParams _response =
          new FileSystemAccessFileWriterCloseResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FileSystemAccessFileWriterAbortParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessFileWriterAbortParams(int version) {
      super(8, version);
    }

    public FileSystemAccessFileWriterAbortParams() {
      this(0);
    }

    public static FileSystemAccessFileWriterAbortParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessFileWriterAbortParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessFileWriterAbortParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessFileWriterAbortParams result =
            new FileSystemAccessFileWriterAbortParams(elementsOrVersion);
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

  static final class FileSystemAccessFileWriterAbortResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public FileSystemAccessError result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessFileWriterAbortResponseParams(int version) {
      super(16, version);
    }

    public FileSystemAccessFileWriterAbortResponseParams() {
      this(0);
    }

    public static FileSystemAccessFileWriterAbortResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessFileWriterAbortResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessFileWriterAbortResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessFileWriterAbortResponseParams result =
            new FileSystemAccessFileWriterAbortResponseParams(elementsOrVersion);
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

  static class FileSystemAccessFileWriterAbortResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FileSystemAccessFileWriter.Abort_Response mCallback;

    FileSystemAccessFileWriterAbortResponseParamsForwardToCallback(
        FileSystemAccessFileWriter.Abort_Response callback) {
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
        FileSystemAccessFileWriterAbortResponseParams response =
            FileSystemAccessFileWriterAbortResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FileSystemAccessFileWriterAbortResponseParamsProxyToResponder
      implements FileSystemAccessFileWriter.Abort_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FileSystemAccessFileWriterAbortResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(FileSystemAccessError result) {
      FileSystemAccessFileWriterAbortResponseParams _response =
          new FileSystemAccessFileWriterAbortResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
