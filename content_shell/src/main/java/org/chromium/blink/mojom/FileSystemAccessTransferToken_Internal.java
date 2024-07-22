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
import org.chromium.mojo_base.mojom.UnguessableToken;

class FileSystemAccessTransferToken_Internal {
  private static final int CLONE_ORDINAL = 1;
  private static final int GET_INTERNAL_ID_ORDINAL = 0;
  public static final Interface.Manager<
          FileSystemAccessTransferToken, FileSystemAccessTransferToken.Proxy>
      MANAGER =
          new Interface.Manager<
              FileSystemAccessTransferToken, FileSystemAccessTransferToken.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.FileSystemAccessTransferToken";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public FileSystemAccessTransferToken.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, FileSystemAccessTransferToken impl) {
              return new Stub(core, impl);
            }

            @Override
            public FileSystemAccessTransferToken[] buildArray(int size) {
              return new FileSystemAccessTransferToken[size];
            }
          };

  FileSystemAccessTransferToken_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements FileSystemAccessTransferToken.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void getInternalId(GetInternalId_Response callback) {
      FileSystemAccessTransferTokenGetInternalIdParams _message =
          new FileSystemAccessTransferTokenGetInternalIdParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new FileSystemAccessTransferTokenGetInternalIdResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void clone(InterfaceRequest<FileSystemAccessTransferToken> tokenClone) {
      FileSystemAccessTransferTokenCloneParams _message =
          new FileSystemAccessTransferTokenCloneParams();
      _message.tokenClone = tokenClone;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }
  }

  public static final class Stub extends Interface.Stub<FileSystemAccessTransferToken> {
    Stub(Core core, FileSystemAccessTransferToken impl) {
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
                FileSystemAccessTransferToken_Internal.MANAGER, messageWithHeader);
          case 1:
            FileSystemAccessTransferTokenCloneParams data =
                FileSystemAccessTransferTokenCloneParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().clone(data.tokenClone);
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
                FileSystemAccessTransferToken_Internal.MANAGER,
                messageWithHeader,
                receiver);
          case 0:
            FileSystemAccessTransferTokenGetInternalIdParams.deserialize(
                messageWithHeader.getPayload());
            getImpl()
                .getInternalId(
                    new FileSystemAccessTransferTokenGetInternalIdResponseParamsProxyToResponder(
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

  static final class FileSystemAccessTransferTokenGetInternalIdParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessTransferTokenGetInternalIdParams(int version) {
      super(8, version);
    }

    public FileSystemAccessTransferTokenGetInternalIdParams() {
      this(0);
    }

    public static FileSystemAccessTransferTokenGetInternalIdParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessTransferTokenGetInternalIdParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessTransferTokenGetInternalIdParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessTransferTokenGetInternalIdParams result =
            new FileSystemAccessTransferTokenGetInternalIdParams(elementsOrVersion);
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

  static final class FileSystemAccessTransferTokenGetInternalIdResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public UnguessableToken id;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessTransferTokenGetInternalIdResponseParams(int version) {
      super(16, version);
    }

    public FileSystemAccessTransferTokenGetInternalIdResponseParams() {
      this(0);
    }

    public static FileSystemAccessTransferTokenGetInternalIdResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessTransferTokenGetInternalIdResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessTransferTokenGetInternalIdResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessTransferTokenGetInternalIdResponseParams result =
            new FileSystemAccessTransferTokenGetInternalIdResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.id = UnguessableToken.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.id, 8, false);
    }
  }

  static class FileSystemAccessTransferTokenGetInternalIdResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FileSystemAccessTransferToken.GetInternalId_Response mCallback;

    FileSystemAccessTransferTokenGetInternalIdResponseParamsForwardToCallback(
        FileSystemAccessTransferToken.GetInternalId_Response callback) {
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
        FileSystemAccessTransferTokenGetInternalIdResponseParams response =
            FileSystemAccessTransferTokenGetInternalIdResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.id);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FileSystemAccessTransferTokenGetInternalIdResponseParamsProxyToResponder
      implements FileSystemAccessTransferToken.GetInternalId_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FileSystemAccessTransferTokenGetInternalIdResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(UnguessableToken id) {
      FileSystemAccessTransferTokenGetInternalIdResponseParams _response =
          new FileSystemAccessTransferTokenGetInternalIdResponseParams();
      _response.id = id;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FileSystemAccessTransferTokenCloneParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<FileSystemAccessTransferToken> tokenClone;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessTransferTokenCloneParams(int version) {
      super(16, version);
    }

    public FileSystemAccessTransferTokenCloneParams() {
      this(0);
    }

    public static FileSystemAccessTransferTokenCloneParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessTransferTokenCloneParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessTransferTokenCloneParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessTransferTokenCloneParams result =
            new FileSystemAccessTransferTokenCloneParams(elementsOrVersion);
        result.tokenClone = decoder0.readInterfaceRequest(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.tokenClone, 8, false);
    }
  }
}
