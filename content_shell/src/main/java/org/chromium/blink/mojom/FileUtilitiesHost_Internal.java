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
import org.chromium.mojo_base.mojom.FileInfo;
import org.chromium.mojo_base.mojom.FilePath;

class FileUtilitiesHost_Internal {
  private static final int GET_FILE_INFO_ORDINAL = 0;
  public static final Interface.Manager<FileUtilitiesHost, FileUtilitiesHost.Proxy> MANAGER =
      new Interface.Manager<FileUtilitiesHost, FileUtilitiesHost.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.FileUtilitiesHost";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public FileUtilitiesHost.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, FileUtilitiesHost impl) {
          return new Stub(core, impl);
        }

        @Override
        public FileUtilitiesHost[] buildArray(int size) {
          return new FileUtilitiesHost[size];
        }
      };

  FileUtilitiesHost_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements FileUtilitiesHost.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void getFileInfo(FilePath path, GetFileInfo_Response callback) {
      FileUtilitiesHostGetFileInfoParams _message = new FileUtilitiesHostGetFileInfoParams();
      _message.path = path;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new FileUtilitiesHostGetFileInfoResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<FileUtilitiesHost> {
    Stub(Core core, FileUtilitiesHost impl) {
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
                FileUtilitiesHost_Internal.MANAGER, messageWithHeader);
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
                getCore(), FileUtilitiesHost_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            FileUtilitiesHostGetFileInfoParams data =
                FileUtilitiesHostGetFileInfoParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .getFileInfo(
                    data.path,
                    new FileUtilitiesHostGetFileInfoResponseParamsProxyToResponder(
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

  static final class FileUtilitiesHostGetFileInfoParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public FilePath path;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileUtilitiesHostGetFileInfoParams(int version) {
      super(16, version);
    }

    public FileUtilitiesHostGetFileInfoParams() {
      this(0);
    }

    public static FileUtilitiesHostGetFileInfoParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileUtilitiesHostGetFileInfoParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileUtilitiesHostGetFileInfoParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileUtilitiesHostGetFileInfoParams result =
            new FileUtilitiesHostGetFileInfoParams(elementsOrVersion);
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

  static final class FileUtilitiesHostGetFileInfoResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public FileInfo result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileUtilitiesHostGetFileInfoResponseParams(int version) {
      super(16, version);
    }

    public FileUtilitiesHostGetFileInfoResponseParams() {
      this(0);
    }

    public static FileUtilitiesHostGetFileInfoResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileUtilitiesHostGetFileInfoResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileUtilitiesHostGetFileInfoResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileUtilitiesHostGetFileInfoResponseParams result =
            new FileUtilitiesHostGetFileInfoResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.result = FileInfo.decode(decoder1);
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

  static class FileUtilitiesHostGetFileInfoResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FileUtilitiesHost.GetFileInfo_Response mCallback;

    FileUtilitiesHostGetFileInfoResponseParamsForwardToCallback(
        FileUtilitiesHost.GetFileInfo_Response callback) {
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
        FileUtilitiesHostGetFileInfoResponseParams response =
            FileUtilitiesHostGetFileInfoResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FileUtilitiesHostGetFileInfoResponseParamsProxyToResponder
      implements FileUtilitiesHost.GetFileInfo_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FileUtilitiesHostGetFileInfoResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(FileInfo result) {
      FileUtilitiesHostGetFileInfoResponseParams _response =
          new FileUtilitiesHostGetFileInfoResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
