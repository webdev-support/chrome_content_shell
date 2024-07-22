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

class FileSystemAccessAccessHandleHost_Internal {
  private static final int CLOSE_ORDINAL = 0;
  public static final Interface.Manager<
          FileSystemAccessAccessHandleHost, FileSystemAccessAccessHandleHost.Proxy>
      MANAGER =
          new Interface.Manager<
              FileSystemAccessAccessHandleHost, FileSystemAccessAccessHandleHost.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.FileSystemAccessAccessHandleHost";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public FileSystemAccessAccessHandleHost.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, FileSystemAccessAccessHandleHost impl) {
              return new Stub(core, impl);
            }

            @Override
            public FileSystemAccessAccessHandleHost[] buildArray(int size) {
              return new FileSystemAccessAccessHandleHost[size];
            }
          };

  FileSystemAccessAccessHandleHost_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements FileSystemAccessAccessHandleHost.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void close(Close_Response callback) {
      FileSystemAccessAccessHandleHostCloseParams _message =
          new FileSystemAccessAccessHandleHostCloseParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new FileSystemAccessAccessHandleHostCloseResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<FileSystemAccessAccessHandleHost> {
    Stub(Core core, FileSystemAccessAccessHandleHost impl) {
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
                FileSystemAccessAccessHandleHost_Internal.MANAGER, messageWithHeader);
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
                FileSystemAccessAccessHandleHost_Internal.MANAGER,
                messageWithHeader,
                receiver);
          case 0:
            FileSystemAccessAccessHandleHostCloseParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .close(
                    new FileSystemAccessAccessHandleHostCloseResponseParamsProxyToResponder(
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

  static final class FileSystemAccessAccessHandleHostCloseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessAccessHandleHostCloseParams(int version) {
      super(8, version);
    }

    public FileSystemAccessAccessHandleHostCloseParams() {
      this(0);
    }

    public static FileSystemAccessAccessHandleHostCloseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessAccessHandleHostCloseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessAccessHandleHostCloseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessAccessHandleHostCloseParams result =
            new FileSystemAccessAccessHandleHostCloseParams(elementsOrVersion);
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

  static final class FileSystemAccessAccessHandleHostCloseResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessAccessHandleHostCloseResponseParams(int version) {
      super(8, version);
    }

    public FileSystemAccessAccessHandleHostCloseResponseParams() {
      this(0);
    }

    public static FileSystemAccessAccessHandleHostCloseResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessAccessHandleHostCloseResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessAccessHandleHostCloseResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessAccessHandleHostCloseResponseParams result =
            new FileSystemAccessAccessHandleHostCloseResponseParams(elementsOrVersion);
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

  static class FileSystemAccessAccessHandleHostCloseResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FileSystemAccessAccessHandleHost.Close_Response mCallback;

    FileSystemAccessAccessHandleHostCloseResponseParamsForwardToCallback(
        FileSystemAccessAccessHandleHost.Close_Response callback) {
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
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FileSystemAccessAccessHandleHostCloseResponseParamsProxyToResponder
      implements FileSystemAccessAccessHandleHost.Close_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FileSystemAccessAccessHandleHostCloseResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      FileSystemAccessAccessHandleHostCloseResponseParams _response =
          new FileSystemAccessAccessHandleHostCloseResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
