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

class FileSystemAccessObserverHost_Internal {
  public static final Interface.Manager<
          FileSystemAccessObserverHost, FileSystemAccessObserverHost.Proxy>
      MANAGER =
          new Interface.Manager<
              FileSystemAccessObserverHost, FileSystemAccessObserverHost.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.FileSystemAccessObserverHost";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public FileSystemAccessObserverHost.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, FileSystemAccessObserverHost impl) {
              return new Stub(core, impl);
            }

            @Override
            public FileSystemAccessObserverHost[] buildArray(int size) {
              return new FileSystemAccessObserverHost[size];
            }
          };
  private static final int OBSERVE_ORDINAL = 0;
  private static final int UNOBSERVE_ORDINAL = 1;

  FileSystemAccessObserverHost_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements FileSystemAccessObserverHost.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void observe(
        FileSystemAccessTransferToken token, boolean isRecursive, Observe_Response callback) {
      FileSystemAccessObserverHostObserveParams _message =
          new FileSystemAccessObserverHostObserveParams();
      _message.token = token;
      _message.isRecursive = isRecursive;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new FileSystemAccessObserverHostObserveResponseParamsForwardToCallback(callback));
    }

    @Override
    public void unobserve(FileSystemAccessTransferToken token) {
      FileSystemAccessObserverHostUnobserveParams _message =
          new FileSystemAccessObserverHostUnobserveParams();
      _message.token = token;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }
  }

  public static final class Stub extends Interface.Stub<FileSystemAccessObserverHost> {
    Stub(Core core, FileSystemAccessObserverHost impl) {
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
                FileSystemAccessObserverHost_Internal.MANAGER, messageWithHeader);
          case 1:
            FileSystemAccessObserverHostUnobserveParams data =
                FileSystemAccessObserverHostUnobserveParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().unobserve(data.token);
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
                FileSystemAccessObserverHost_Internal.MANAGER,
                messageWithHeader,
                receiver);
          case 0:
            FileSystemAccessObserverHostObserveParams data =
                FileSystemAccessObserverHostObserveParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .observe(
                    data.token,
                    data.isRecursive,
                    new FileSystemAccessObserverHostObserveResponseParamsProxyToResponder(
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

  static final class FileSystemAccessObserverHostObserveParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean isRecursive;
    public FileSystemAccessTransferToken token;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessObserverHostObserveParams(int version) {
      super(24, version);
    }

    public FileSystemAccessObserverHostObserveParams() {
      this(0);
    }

    public static FileSystemAccessObserverHostObserveParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessObserverHostObserveParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessObserverHostObserveParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessObserverHostObserveParams result =
            new FileSystemAccessObserverHostObserveParams(elementsOrVersion);
        result.token =
            (FileSystemAccessTransferToken)
                decoder0.readServiceInterface(8, false, FileSystemAccessTransferToken.MANAGER);
        result.isRecursive = decoder0.readBoolean(16, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.token, 8, false, FileSystemAccessTransferToken.MANAGER);
      encoder0.encode(this.isRecursive, 16, 0);
    }
  }

  static final class FileSystemAccessObserverHostObserveResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<FileSystemAccessObserver> observerReceiver;
    public FileSystemAccessError result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessObserverHostObserveResponseParams(int version) {
      super(24, version);
    }

    public FileSystemAccessObserverHostObserveResponseParams() {
      this(0);
    }

    public static FileSystemAccessObserverHostObserveResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessObserverHostObserveResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessObserverHostObserveResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessObserverHostObserveResponseParams result =
            new FileSystemAccessObserverHostObserveResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.result = FileSystemAccessError.decode(decoder1);
        result.observerReceiver = decoder0.readInterfaceRequest(16, true);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.result, 8, false);
      encoder0.encode((InterfaceRequest) this.observerReceiver, 16, true);
    }
  }

  static class FileSystemAccessObserverHostObserveResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FileSystemAccessObserverHost.Observe_Response mCallback;

    FileSystemAccessObserverHostObserveResponseParamsForwardToCallback(
        FileSystemAccessObserverHost.Observe_Response callback) {
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
        FileSystemAccessObserverHostObserveResponseParams response =
            FileSystemAccessObserverHostObserveResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result, response.observerReceiver);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FileSystemAccessObserverHostObserveResponseParamsProxyToResponder
      implements FileSystemAccessObserverHost.Observe_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FileSystemAccessObserverHostObserveResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(
        FileSystemAccessError result, InterfaceRequest<FileSystemAccessObserver> observerReceiver) {
      FileSystemAccessObserverHostObserveResponseParams _response =
          new FileSystemAccessObserverHostObserveResponseParams();
      _response.result = result;
      _response.observerReceiver = observerReceiver;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FileSystemAccessObserverHostUnobserveParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public FileSystemAccessTransferToken token;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessObserverHostUnobserveParams(int version) {
      super(16, version);
    }

    public FileSystemAccessObserverHostUnobserveParams() {
      this(0);
    }

    public static FileSystemAccessObserverHostUnobserveParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessObserverHostUnobserveParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessObserverHostUnobserveParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessObserverHostUnobserveParams result =
            new FileSystemAccessObserverHostUnobserveParams(elementsOrVersion);
        result.token =
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
      encoder0.encode(this.token, 8, false, FileSystemAccessTransferToken.MANAGER);
    }
  }
}
