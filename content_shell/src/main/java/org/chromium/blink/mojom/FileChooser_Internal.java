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
import org.chromium.mojo_base.mojom.FilePath;

class FileChooser_Internal {
  private static final int ENUMERATE_CHOSEN_DIRECTORY_ORDINAL = 1;
  public static final Interface.Manager<FileChooser, FileChooser.Proxy> MANAGER =
      new Interface.Manager<FileChooser, FileChooser.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.FileChooser";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public FileChooser.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, FileChooser impl) {
          return new Stub(core, impl);
        }

        @Override
        public FileChooser[] buildArray(int size) {
          return new FileChooser[size];
        }
      };
  private static final int OPEN_FILE_CHOOSER_ORDINAL = 0;

  FileChooser_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements FileChooser.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void openFileChooser(FileChooserParams params, OpenFileChooser_Response callback) {
      FileChooserOpenFileChooserParams _message = new FileChooserOpenFileChooserParams();
      _message.params = params;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new FileChooserOpenFileChooserResponseParamsForwardToCallback(callback));
    }

    @Override
    public void enumerateChosenDirectory(
        FilePath directoryPath, EnumerateChosenDirectory_Response callback) {
      FileChooserEnumerateChosenDirectoryParams _message =
          new FileChooserEnumerateChosenDirectoryParams();
      _message.directoryPath = directoryPath;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new FileChooserEnumerateChosenDirectoryResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<FileChooser> {
    Stub(Core core, FileChooser impl) {
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
                FileChooser_Internal.MANAGER, messageWithHeader);
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
                getCore(), FileChooser_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            FileChooserOpenFileChooserParams data =
                FileChooserOpenFileChooserParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .openFileChooser(
                    data.params,
                    new FileChooserOpenFileChooserResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
            FileChooserEnumerateChosenDirectoryParams data2 =
                FileChooserEnumerateChosenDirectoryParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .enumerateChosenDirectory(
                    data2.directoryPath,
                    new FileChooserEnumerateChosenDirectoryResponseParamsProxyToResponder(
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

  static final class FileChooserOpenFileChooserParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public FileChooserParams params;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileChooserOpenFileChooserParams(int version) {
      super(16, version);
    }

    public FileChooserOpenFileChooserParams() {
      this(0);
    }

    public static FileChooserOpenFileChooserParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileChooserOpenFileChooserParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileChooserOpenFileChooserParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileChooserOpenFileChooserParams result =
            new FileChooserOpenFileChooserParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.params = FileChooserParams.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.params, 8, false);
    }
  }

  static final class FileChooserOpenFileChooserResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public FileChooserResult result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileChooserOpenFileChooserResponseParams(int version) {
      super(16, version);
    }

    public FileChooserOpenFileChooserResponseParams() {
      this(0);
    }

    public static FileChooserOpenFileChooserResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileChooserOpenFileChooserResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileChooserOpenFileChooserResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileChooserOpenFileChooserResponseParams result =
            new FileChooserOpenFileChooserResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.result = FileChooserResult.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.result, 8, true);
    }
  }

  static class FileChooserOpenFileChooserResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FileChooser.OpenFileChooser_Response mCallback;

    FileChooserOpenFileChooserResponseParamsForwardToCallback(
        FileChooser.OpenFileChooser_Response callback) {
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
        FileChooserOpenFileChooserResponseParams response =
            FileChooserOpenFileChooserResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FileChooserOpenFileChooserResponseParamsProxyToResponder
      implements FileChooser.OpenFileChooser_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FileChooserOpenFileChooserResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(FileChooserResult result) {
      FileChooserOpenFileChooserResponseParams _response =
          new FileChooserOpenFileChooserResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FileChooserEnumerateChosenDirectoryParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public FilePath directoryPath;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileChooserEnumerateChosenDirectoryParams(int version) {
      super(16, version);
    }

    public FileChooserEnumerateChosenDirectoryParams() {
      this(0);
    }

    public static FileChooserEnumerateChosenDirectoryParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileChooserEnumerateChosenDirectoryParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileChooserEnumerateChosenDirectoryParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileChooserEnumerateChosenDirectoryParams result =
            new FileChooserEnumerateChosenDirectoryParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.directoryPath = FilePath.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.directoryPath, 8, false);
    }
  }

  static final class FileChooserEnumerateChosenDirectoryResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public FileChooserResult result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileChooserEnumerateChosenDirectoryResponseParams(int version) {
      super(16, version);
    }

    public FileChooserEnumerateChosenDirectoryResponseParams() {
      this(0);
    }

    public static FileChooserEnumerateChosenDirectoryResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileChooserEnumerateChosenDirectoryResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileChooserEnumerateChosenDirectoryResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileChooserEnumerateChosenDirectoryResponseParams result =
            new FileChooserEnumerateChosenDirectoryResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.result = FileChooserResult.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.result, 8, true);
    }
  }

  static class FileChooserEnumerateChosenDirectoryResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FileChooser.EnumerateChosenDirectory_Response mCallback;

    FileChooserEnumerateChosenDirectoryResponseParamsForwardToCallback(
        FileChooser.EnumerateChosenDirectory_Response callback) {
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
        FileChooserEnumerateChosenDirectoryResponseParams response =
            FileChooserEnumerateChosenDirectoryResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FileChooserEnumerateChosenDirectoryResponseParamsProxyToResponder
      implements FileChooser.EnumerateChosenDirectory_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FileChooserEnumerateChosenDirectoryResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(FileChooserResult result) {
      FileChooserEnumerateChosenDirectoryResponseParams _response =
          new FileChooserEnumerateChosenDirectoryResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
