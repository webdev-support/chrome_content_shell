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
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;

class SharedWorker_Internal {
  private static final int CONNECT_ORDINAL = 0;
  public static final Interface.Manager<SharedWorker, SharedWorker.Proxy> MANAGER =
      new Interface.Manager<SharedWorker, SharedWorker.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.SharedWorker";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public SharedWorker.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, SharedWorker impl) {
          return new Stub(core, impl);
        }

        @Override
        public SharedWorker[] buildArray(int size) {
          return new SharedWorker[size];
        }
      };
  private static final int TERMINATE_ORDINAL = 1;

  SharedWorker_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements SharedWorker.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void connect(int connectionId, MessagePortDescriptor messagePort) {
      SharedWorkerConnectParams _message = new SharedWorkerConnectParams();
      _message.connectionId = connectionId;
      _message.messagePort = messagePort;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void terminate() {
      SharedWorkerTerminateParams _message = new SharedWorkerTerminateParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }
  }

  public static final class Stub extends Interface.Stub<SharedWorker> {
    Stub(Core core, SharedWorker impl) {
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
                SharedWorker_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            SharedWorkerConnectParams data =
                SharedWorkerConnectParams.deserialize(messageWithHeader.getPayload());
            getImpl().connect(data.connectionId, data.messagePort);
            return true;
          case 1:
            SharedWorkerTerminateParams.deserialize(messageWithHeader.getPayload());
            getImpl().terminate();
            return true;
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
                getCore(), SharedWorker_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class SharedWorkerConnectParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int connectionId;
    public MessagePortDescriptor messagePort;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SharedWorkerConnectParams(int version) {
      super(24, version);
    }

    public SharedWorkerConnectParams() {
      this(0);
    }

    public static SharedWorkerConnectParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SharedWorkerConnectParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SharedWorkerConnectParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SharedWorkerConnectParams result = new SharedWorkerConnectParams(elementsOrVersion);
        result.connectionId = decoder0.readInt(8);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.messagePort = MessagePortDescriptor.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.connectionId, 8);
      encoder0.encode((Struct) this.messagePort, 16, false);
    }
  }

  static final class SharedWorkerTerminateParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SharedWorkerTerminateParams(int version) {
      super(8, version);
    }

    public SharedWorkerTerminateParams() {
      this(0);
    }

    public static SharedWorkerTerminateParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SharedWorkerTerminateParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SharedWorkerTerminateParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SharedWorkerTerminateParams result = new SharedWorkerTerminateParams(elementsOrVersion);
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
