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

class EmbeddedWorkerInstanceClient_Internal {
  public static final Interface.Manager<
          EmbeddedWorkerInstanceClient, EmbeddedWorkerInstanceClient.Proxy>
      MANAGER =
          new Interface.Manager<
              EmbeddedWorkerInstanceClient, EmbeddedWorkerInstanceClient.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.EmbeddedWorkerInstanceClient";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public EmbeddedWorkerInstanceClient.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, EmbeddedWorkerInstanceClient impl) {
              return new Stub(core, impl);
            }

            @Override
            public EmbeddedWorkerInstanceClient[] buildArray(int size) {
              return new EmbeddedWorkerInstanceClient[size];
            }
          };
  private static final int START_WORKER_ORDINAL = 0;
  private static final int STOP_WORKER_ORDINAL = 1;

  EmbeddedWorkerInstanceClient_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements EmbeddedWorkerInstanceClient.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void startWorker(EmbeddedWorkerStartParams params) {
      EmbeddedWorkerInstanceClientStartWorkerParams _message =
          new EmbeddedWorkerInstanceClientStartWorkerParams();
      _message.params = params;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void stopWorker() {
      EmbeddedWorkerInstanceClientStopWorkerParams _message =
          new EmbeddedWorkerInstanceClientStopWorkerParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }
  }

  public static final class Stub extends Interface.Stub<EmbeddedWorkerInstanceClient> {
    Stub(Core core, EmbeddedWorkerInstanceClient impl) {
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
                EmbeddedWorkerInstanceClient_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            EmbeddedWorkerInstanceClientStartWorkerParams data =
                EmbeddedWorkerInstanceClientStartWorkerParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().startWorker(data.params);
            return true;
          case 1:
            EmbeddedWorkerInstanceClientStopWorkerParams.deserialize(
                messageWithHeader.getPayload());
            getImpl().stopWorker();
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
                getCore(),
                EmbeddedWorkerInstanceClient_Internal.MANAGER,
                messageWithHeader,
                receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class EmbeddedWorkerInstanceClientStartWorkerParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public EmbeddedWorkerStartParams params;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private EmbeddedWorkerInstanceClientStartWorkerParams(int version) {
      super(16, version);
    }

    public EmbeddedWorkerInstanceClientStartWorkerParams() {
      this(0);
    }

    public static EmbeddedWorkerInstanceClientStartWorkerParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static EmbeddedWorkerInstanceClientStartWorkerParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static EmbeddedWorkerInstanceClientStartWorkerParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        EmbeddedWorkerInstanceClientStartWorkerParams result =
            new EmbeddedWorkerInstanceClientStartWorkerParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.params = EmbeddedWorkerStartParams.decode(decoder1);
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

  static final class EmbeddedWorkerInstanceClientStopWorkerParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private EmbeddedWorkerInstanceClientStopWorkerParams(int version) {
      super(8, version);
    }

    public EmbeddedWorkerInstanceClientStopWorkerParams() {
      this(0);
    }

    public static EmbeddedWorkerInstanceClientStopWorkerParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static EmbeddedWorkerInstanceClientStopWorkerParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static EmbeddedWorkerInstanceClientStopWorkerParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        EmbeddedWorkerInstanceClientStopWorkerParams result =
            new EmbeddedWorkerInstanceClientStopWorkerParams(elementsOrVersion);
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
