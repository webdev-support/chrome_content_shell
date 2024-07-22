package org.chromium.network.mojom;

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

class SocketObserver_Internal {
  public static final Interface.Manager<SocketObserver, SocketObserver.Proxy> MANAGER =
      new Interface.Manager<SocketObserver, SocketObserver.Proxy>() {
        @Override
        public String getName() {
          return "network.mojom.SocketObserver";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public SocketObserver.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, SocketObserver impl) {
          return new Stub(core, impl);
        }

        @Override
        public SocketObserver[] buildArray(int size) {
          return new SocketObserver[size];
        }
      };
  private static final int ON_READ_ERROR_ORDINAL = 0;
  private static final int ON_WRITE_ERROR_ORDINAL = 1;

  SocketObserver_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements SocketObserver.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onReadError(int netError) {
      SocketObserverOnReadErrorParams _message = new SocketObserverOnReadErrorParams();
      _message.netError = netError;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void onWriteError(int netError) {
      SocketObserverOnWriteErrorParams _message = new SocketObserverOnWriteErrorParams();
      _message.netError = netError;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }
  }

  public static final class Stub extends Interface.Stub<SocketObserver> {
    Stub(Core core, SocketObserver impl) {
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
                SocketObserver_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            SocketObserverOnReadErrorParams data =
                SocketObserverOnReadErrorParams.deserialize(messageWithHeader.getPayload());
            getImpl().onReadError(data.netError);
            return true;
          case 1:
            SocketObserverOnWriteErrorParams data2 =
                SocketObserverOnWriteErrorParams.deserialize(messageWithHeader.getPayload());
            getImpl().onWriteError(data2.netError);
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
                getCore(), SocketObserver_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class SocketObserverOnReadErrorParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int netError;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SocketObserverOnReadErrorParams(int version) {
      super(16, version);
    }

    public SocketObserverOnReadErrorParams() {
      this(0);
    }

    public static SocketObserverOnReadErrorParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SocketObserverOnReadErrorParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SocketObserverOnReadErrorParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SocketObserverOnReadErrorParams result =
            new SocketObserverOnReadErrorParams(elementsOrVersion);
        result.netError = decoder0.readInt(8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.netError, 8);
    }
  }

  static final class SocketObserverOnWriteErrorParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int netError;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SocketObserverOnWriteErrorParams(int version) {
      super(16, version);
    }

    public SocketObserverOnWriteErrorParams() {
      this(0);
    }

    public static SocketObserverOnWriteErrorParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SocketObserverOnWriteErrorParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SocketObserverOnWriteErrorParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SocketObserverOnWriteErrorParams result =
            new SocketObserverOnWriteErrorParams(elementsOrVersion);
        result.netError = decoder0.readInt(8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.netError, 8);
    }
  }
}
