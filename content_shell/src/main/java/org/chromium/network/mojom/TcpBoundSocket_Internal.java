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

class TcpBoundSocket_Internal {
  private static final int CONNECT_ORDINAL = 1;
  private static final int LISTEN_ORDINAL = 0;
  public static final Interface.Manager<TcpBoundSocket, TcpBoundSocket.Proxy> MANAGER =
      new Interface.Manager<TcpBoundSocket, TcpBoundSocket.Proxy>() {
        @Override
        public String getName() {
          return "network.mojom.TCPBoundSocket";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public TcpBoundSocket.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, TcpBoundSocket impl) {
          return new Stub(core, impl);
        }

        @Override
        public TcpBoundSocket[] buildArray(int size) {
          return new TcpBoundSocket[size];
        }
      };

  TcpBoundSocket_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements TcpBoundSocket.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void listen(
        int backlog,
        InterfaceRequest<TcpServerSocket> socket,
        TcpBoundSocket.Listen_Response callback) {
      TcpBoundSocketListenParams _message = new TcpBoundSocketListenParams();
      _message.backlog = backlog;
      _message.socket = socket;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new TcpBoundSocketListenResponseParamsForwardToCallback(callback));
    }

    @Override
    public void connect(
        AddressList remoteAddrList,
        TcpConnectedSocketOptions tcpConnectedSocketOptions,
        InterfaceRequest<TcpConnectedSocket> socket,
        SocketObserver observer,
        TcpBoundSocket.Connect_Response callback) {
      TcpBoundSocketConnectParams _message = new TcpBoundSocketConnectParams();
      _message.remoteAddrList = remoteAddrList;
      _message.tcpConnectedSocketOptions = tcpConnectedSocketOptions;
      _message.socket = socket;
      _message.observer = observer;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new TcpBoundSocketConnectResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<TcpBoundSocket> {
    Stub(Core core, TcpBoundSocket impl) {
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
                TcpBoundSocket_Internal.MANAGER, messageWithHeader);
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
                getCore(), TcpBoundSocket_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            TcpBoundSocketListenParams data =
                TcpBoundSocketListenParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .listen(
                    data.backlog,
                    data.socket,
                    new TcpBoundSocketListenResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
            TcpBoundSocketConnectParams data2 =
                TcpBoundSocketConnectParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .connect(
                    data2.remoteAddrList,
                    data2.tcpConnectedSocketOptions,
                    data2.socket,
                    data2.observer,
                    new TcpBoundSocketConnectResponseParamsProxyToResponder(
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

  static final class TcpBoundSocketListenParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int backlog;
    public InterfaceRequest<TcpServerSocket> socket;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private TcpBoundSocketListenParams(int version) {
      super(16, version);
    }

    public TcpBoundSocketListenParams() {
      this(0);
    }

    public static TcpBoundSocketListenParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static TcpBoundSocketListenParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static TcpBoundSocketListenParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        TcpBoundSocketListenParams result = new TcpBoundSocketListenParams(elementsOrVersion);
        result.backlog = decoder0.readInt(8);
        result.socket = decoder0.readInterfaceRequest(12, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.backlog, 8);
      encoder0.encode((InterfaceRequest) this.socket, 12, false);
    }
  }

  static final class TcpBoundSocketListenResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int netError;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private TcpBoundSocketListenResponseParams(int version) {
      super(16, version);
    }

    public TcpBoundSocketListenResponseParams() {
      this(0);
    }

    public static TcpBoundSocketListenResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static TcpBoundSocketListenResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static TcpBoundSocketListenResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        TcpBoundSocketListenResponseParams result =
            new TcpBoundSocketListenResponseParams(elementsOrVersion);
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

  static class TcpBoundSocketListenResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final TcpBoundSocket.Listen_Response mCallback;

    TcpBoundSocketListenResponseParamsForwardToCallback(TcpBoundSocket.Listen_Response callback) {
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
        TcpBoundSocketListenResponseParams response =
            TcpBoundSocketListenResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.netError);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class TcpBoundSocketListenResponseParamsProxyToResponder
      implements TcpBoundSocket.Listen_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    TcpBoundSocketListenResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int netError) {
      TcpBoundSocketListenResponseParams _response = new TcpBoundSocketListenResponseParams();
      _response.netError = netError;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class TcpBoundSocketConnectParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public SocketObserver observer;
    public AddressList remoteAddrList;
    public InterfaceRequest<TcpConnectedSocket> socket;
    public TcpConnectedSocketOptions tcpConnectedSocketOptions;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private TcpBoundSocketConnectParams(int version) {
      super(40, version);
    }

    public TcpBoundSocketConnectParams() {
      this(0);
    }

    public static TcpBoundSocketConnectParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static TcpBoundSocketConnectParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static TcpBoundSocketConnectParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        TcpBoundSocketConnectParams result = new TcpBoundSocketConnectParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.remoteAddrList = AddressList.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, true);
        result.tcpConnectedSocketOptions = TcpConnectedSocketOptions.decode(decoder12);
        result.socket = decoder0.readInterfaceRequest(24, false);
        result.observer =
            (SocketObserver) decoder0.readServiceInterface(28, true, SocketObserver.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.remoteAddrList, 8, false);
      encoder0.encode((Struct) this.tcpConnectedSocketOptions, 16, true);
      encoder0.encode((InterfaceRequest) this.socket, 24, false);
      encoder0.encode(this.observer, 28, true, SocketObserver.MANAGER);
    }
  }

  static final class TcpBoundSocketConnectResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public IpEndPoint localAddr;
    public int netError;
    public IpEndPoint peerAddr;
    public DataPipe.ConsumerHandle receiveStream;
    public DataPipe.ProducerHandle sendStream;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private TcpBoundSocketConnectResponseParams(int version) {
      super(40, version);
      this.receiveStream = InvalidHandle.INSTANCE;
      this.sendStream = InvalidHandle.INSTANCE;
    }

    public TcpBoundSocketConnectResponseParams() {
      this(0);
    }

    public static TcpBoundSocketConnectResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static TcpBoundSocketConnectResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static TcpBoundSocketConnectResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        TcpBoundSocketConnectResponseParams result =
            new TcpBoundSocketConnectResponseParams(elementsOrVersion);
        result.netError = decoder0.readInt(8);
        result.receiveStream = decoder0.readConsumerHandle(12, true);
        Decoder decoder1 = decoder0.readPointer(16, true);
        result.localAddr = IpEndPoint.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(24, true);
        result.peerAddr = IpEndPoint.decode(decoder12);
        result.sendStream = decoder0.readProducerHandle(32, true);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.netError, 8);
      encoder0.encode((Handle) this.receiveStream, 12, true);
      encoder0.encode((Struct) this.localAddr, 16, true);
      encoder0.encode((Struct) this.peerAddr, 24, true);
      encoder0.encode((Handle) this.sendStream, 32, true);
    }
  }

  static class TcpBoundSocketConnectResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final TcpBoundSocket.Connect_Response mCallback;

    TcpBoundSocketConnectResponseParamsForwardToCallback(TcpBoundSocket.Connect_Response callback) {
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
        TcpBoundSocketConnectResponseParams response =
            TcpBoundSocketConnectResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(
            response.netError,
            response.localAddr,
            response.peerAddr,
            response.receiveStream,
            response.sendStream);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class TcpBoundSocketConnectResponseParamsProxyToResponder
      implements TcpBoundSocket.Connect_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    TcpBoundSocketConnectResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(
        int netError,
        IpEndPoint localAddr,
        IpEndPoint peerAddr,
        DataPipe.ConsumerHandle receiveStream,
        DataPipe.ProducerHandle sendStream) {
      TcpBoundSocketConnectResponseParams _response = new TcpBoundSocketConnectResponseParams();
      _response.netError = netError;
      _response.localAddr = localAddr;
      _response.peerAddr = peerAddr;
      _response.receiveStream = receiveStream;
      _response.sendStream = sendStream;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
