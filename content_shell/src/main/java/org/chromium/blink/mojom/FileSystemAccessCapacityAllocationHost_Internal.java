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

class FileSystemAccessCapacityAllocationHost_Internal {
  public static final Interface.Manager<
          FileSystemAccessCapacityAllocationHost, FileSystemAccessCapacityAllocationHost.Proxy>
      MANAGER =
          new Interface.Manager<
              FileSystemAccessCapacityAllocationHost,
              FileSystemAccessCapacityAllocationHost.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.FileSystemAccessCapacityAllocationHost";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public FileSystemAccessCapacityAllocationHost.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, FileSystemAccessCapacityAllocationHost impl) {
              return new Stub(core, impl);
            }

            @Override
            public FileSystemAccessCapacityAllocationHost[] buildArray(int size) {
              return new FileSystemAccessCapacityAllocationHost[size];
            }
          };
  private static final int ON_CONTENTS_MODIFIED_ORDINAL = 1;
  private static final int REQUEST_CAPACITY_CHANGE_ORDINAL = 0;

  FileSystemAccessCapacityAllocationHost_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements FileSystemAccessCapacityAllocationHost.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void requestCapacityChange(long capacityDelta, RequestCapacityChange_Response callback) {
      FileSystemAccessCapacityAllocationHostRequestCapacityChangeParams _message =
          new FileSystemAccessCapacityAllocationHostRequestCapacityChangeParams();
      _message.capacityDelta = capacityDelta;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new FileSystemAccessCapacityAllocationHostRequestCapacityChangeResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void onContentsModified() {
      FileSystemAccessCapacityAllocationHostOnContentsModifiedParams _message =
          new FileSystemAccessCapacityAllocationHostOnContentsModifiedParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }
  }

  public static final class Stub extends Interface.Stub<FileSystemAccessCapacityAllocationHost> {
    Stub(Core core, FileSystemAccessCapacityAllocationHost impl) {
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
                FileSystemAccessCapacityAllocationHost_Internal.MANAGER, messageWithHeader);
          case 1:
            FileSystemAccessCapacityAllocationHostOnContentsModifiedParams.deserialize(
                messageWithHeader.getPayload());
            getImpl().onContentsModified();
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
                FileSystemAccessCapacityAllocationHost_Internal.MANAGER,
                messageWithHeader,
                receiver);
          case 0:
            FileSystemAccessCapacityAllocationHostRequestCapacityChangeParams data =
                FileSystemAccessCapacityAllocationHostRequestCapacityChangeParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .requestCapacityChange(
                    data.capacityDelta,
                    new FileSystemAccessCapacityAllocationHostRequestCapacityChangeResponseParamsProxyToResponder(
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

  static final class FileSystemAccessCapacityAllocationHostRequestCapacityChangeParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public long capacityDelta;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessCapacityAllocationHostRequestCapacityChangeParams(int version) {
      super(16, version);
    }

    public FileSystemAccessCapacityAllocationHostRequestCapacityChangeParams() {
      this(0);
    }

    public static FileSystemAccessCapacityAllocationHostRequestCapacityChangeParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessCapacityAllocationHostRequestCapacityChangeParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessCapacityAllocationHostRequestCapacityChangeParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessCapacityAllocationHostRequestCapacityChangeParams result =
            new FileSystemAccessCapacityAllocationHostRequestCapacityChangeParams(
                elementsOrVersion);
        result.capacityDelta = decoder0.readLong(8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.capacityDelta, 8);
    }
  }

  static final class FileSystemAccessCapacityAllocationHostRequestCapacityChangeResponseParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public long grantedCapacityDelta;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessCapacityAllocationHostRequestCapacityChangeResponseParams(int version) {
      super(16, version);
    }

    public FileSystemAccessCapacityAllocationHostRequestCapacityChangeResponseParams() {
      this(0);
    }

    public static FileSystemAccessCapacityAllocationHostRequestCapacityChangeResponseParams
        deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessCapacityAllocationHostRequestCapacityChangeResponseParams
        deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessCapacityAllocationHostRequestCapacityChangeResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessCapacityAllocationHostRequestCapacityChangeResponseParams result =
            new FileSystemAccessCapacityAllocationHostRequestCapacityChangeResponseParams(
                elementsOrVersion);
        result.grantedCapacityDelta = decoder0.readLong(8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.grantedCapacityDelta, 8);
    }
  }

  static
  class FileSystemAccessCapacityAllocationHostRequestCapacityChangeResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FileSystemAccessCapacityAllocationHost.RequestCapacityChange_Response mCallback;

    FileSystemAccessCapacityAllocationHostRequestCapacityChangeResponseParamsForwardToCallback(
        FileSystemAccessCapacityAllocationHost.RequestCapacityChange_Response callback) {
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
        FileSystemAccessCapacityAllocationHostRequestCapacityChangeResponseParams response =
            FileSystemAccessCapacityAllocationHostRequestCapacityChangeResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.grantedCapacityDelta);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static
  class FileSystemAccessCapacityAllocationHostRequestCapacityChangeResponseParamsProxyToResponder
      implements FileSystemAccessCapacityAllocationHost.RequestCapacityChange_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FileSystemAccessCapacityAllocationHostRequestCapacityChangeResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(long grantedCapacityDelta) {
      FileSystemAccessCapacityAllocationHostRequestCapacityChangeResponseParams _response =
          new FileSystemAccessCapacityAllocationHostRequestCapacityChangeResponseParams();
      _response.grantedCapacityDelta = grantedCapacityDelta;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FileSystemAccessCapacityAllocationHostOnContentsModifiedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FileSystemAccessCapacityAllocationHostOnContentsModifiedParams(int version) {
      super(8, version);
    }

    public FileSystemAccessCapacityAllocationHostOnContentsModifiedParams() {
      this(0);
    }

    public static FileSystemAccessCapacityAllocationHostOnContentsModifiedParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static FileSystemAccessCapacityAllocationHostOnContentsModifiedParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FileSystemAccessCapacityAllocationHostOnContentsModifiedParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FileSystemAccessCapacityAllocationHostOnContentsModifiedParams result =
            new FileSystemAccessCapacityAllocationHostOnContentsModifiedParams(elementsOrVersion);
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
}
