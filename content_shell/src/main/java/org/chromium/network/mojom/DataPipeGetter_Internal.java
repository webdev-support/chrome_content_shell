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
import org.chromium.mojo.system.DataPipe;
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.InvalidHandle;

class DataPipeGetter_Internal {
  private static final int CLONE_ORDINAL = 1;
  public static final Interface.Manager<DataPipeGetter, DataPipeGetter.Proxy> MANAGER =
      new Interface.Manager<DataPipeGetter, DataPipeGetter.Proxy>() {
        @Override
        public String getName() {
          return "network.mojom.DataPipeGetter";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public DataPipeGetter.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, DataPipeGetter impl) {
          return new Stub(core, impl);
        }

        @Override
        public DataPipeGetter[] buildArray(int size) {
          return new DataPipeGetter[size];
        }
      };
  private static final int READ_ORDINAL = 0;

  DataPipeGetter_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements DataPipeGetter.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void read(DataPipe.ProducerHandle pipe, DataPipeGetter.Read_Response callback) {
      DataPipeGetterReadParams _message = new DataPipeGetterReadParams();
      _message.pipe = pipe;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new DataPipeGetterReadResponseParamsForwardToCallback(callback));
    }

    @Override
    public void clone(InterfaceRequest<DataPipeGetter> receiver) {
      DataPipeGetterCloneParams _message = new DataPipeGetterCloneParams();
      _message.receiver = receiver;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }
  }

  public static final class Stub extends Interface.Stub<DataPipeGetter> {
    Stub(Core core, DataPipeGetter impl) {
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
                DataPipeGetter_Internal.MANAGER, messageWithHeader);
          case 1:
            DataPipeGetterCloneParams data =
                DataPipeGetterCloneParams.deserialize(messageWithHeader.getPayload());
            getImpl().clone(data.receiver);
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
                getCore(), DataPipeGetter_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            DataPipeGetterReadParams data =
                DataPipeGetterReadParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .read(
                    data.pipe,
                    new DataPipeGetterReadResponseParamsProxyToResponder(
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

  static final class DataPipeGetterReadParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public DataPipe.ProducerHandle pipe;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DataPipeGetterReadParams(int version) {
      super(16, version);
      this.pipe = InvalidHandle.INSTANCE;
    }

    public DataPipeGetterReadParams() {
      this(0);
    }

    public static DataPipeGetterReadParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static DataPipeGetterReadParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DataPipeGetterReadParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DataPipeGetterReadParams result = new DataPipeGetterReadParams(elementsOrVersion);
        result.pipe = decoder0.readProducerHandle(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Handle) this.pipe, 8, false);
    }
  }

  static final class DataPipeGetterReadResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public long size;
    public int status;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DataPipeGetterReadResponseParams(int version) {
      super(24, version);
    }

    public DataPipeGetterReadResponseParams() {
      this(0);
    }

    public static DataPipeGetterReadResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static DataPipeGetterReadResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DataPipeGetterReadResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DataPipeGetterReadResponseParams result =
            new DataPipeGetterReadResponseParams(elementsOrVersion);
        result.status = decoder0.readInt(8);
        result.size = decoder0.readLong(16);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.status, 8);
      encoder0.encode(this.size, 16);
    }
  }

  static class DataPipeGetterReadResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final DataPipeGetter.Read_Response mCallback;

    DataPipeGetterReadResponseParamsForwardToCallback(DataPipeGetter.Read_Response callback) {
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
        DataPipeGetterReadResponseParams response =
            DataPipeGetterReadResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.status, response.size);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class DataPipeGetterReadResponseParamsProxyToResponder
      implements DataPipeGetter.Read_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    DataPipeGetterReadResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int status, long size) {
      DataPipeGetterReadResponseParams _response = new DataPipeGetterReadResponseParams();
      _response.status = status;
      _response.size = size;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class DataPipeGetterCloneParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<DataPipeGetter> receiver;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DataPipeGetterCloneParams(int version) {
      super(16, version);
    }

    public DataPipeGetterCloneParams() {
      this(0);
    }

    public static DataPipeGetterCloneParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static DataPipeGetterCloneParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DataPipeGetterCloneParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DataPipeGetterCloneParams result = new DataPipeGetterCloneParams(elementsOrVersion);
        result.receiver = decoder0.readInterfaceRequest(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.receiver, 8, false);
    }
  }
}
