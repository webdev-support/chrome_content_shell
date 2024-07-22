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
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;

class SocketBroker_Internal {
  private static final int CREATE_TCP_SOCKET_ORDINAL = 0;
  private static final int CREATE_UDP_SOCKET_ORDINAL = 1;
  public static final Interface.Manager<SocketBroker, SocketBroker.Proxy> MANAGER =
      new Interface.Manager<SocketBroker, SocketBroker.Proxy>() {
        @Override
        public String getName() {
          return "network.mojom.SocketBroker";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public SocketBroker.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, SocketBroker impl) {
          return new Stub(core, impl);
        }

        @Override
        public SocketBroker[] buildArray(int size) {
          return new SocketBroker[size];
        }
      };

  SocketBroker_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements SocketBroker.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void createTcpSocket(int addressFamily, SocketBroker.CreateTcpSocket_Response callback) {
      SocketBrokerCreateTcpSocketParams _message = new SocketBrokerCreateTcpSocketParams();
      _message.addressFamily = addressFamily;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new SocketBrokerCreateTcpSocketResponseParamsForwardToCallback(callback));
    }

    @Override
    public void createUdpSocket(int addressFamily, SocketBroker.CreateUdpSocket_Response callback) {
      SocketBrokerCreateUdpSocketParams _message = new SocketBrokerCreateUdpSocketParams();
      _message.addressFamily = addressFamily;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new SocketBrokerCreateUdpSocketResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<SocketBroker> {
    Stub(Core core, SocketBroker impl) {
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
                SocketBroker_Internal.MANAGER, messageWithHeader);
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
                getCore(), SocketBroker_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            SocketBrokerCreateTcpSocketParams data =
                SocketBrokerCreateTcpSocketParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .createTcpSocket(
                    data.addressFamily,
                    new SocketBrokerCreateTcpSocketResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
            SocketBrokerCreateUdpSocketParams data2 =
                SocketBrokerCreateUdpSocketParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .createUdpSocket(
                    data2.addressFamily,
                    new SocketBrokerCreateUdpSocketResponseParamsProxyToResponder(
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

  static final class SocketBrokerCreateTcpSocketParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int addressFamily;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SocketBrokerCreateTcpSocketParams(int version) {
      super(16, version);
    }

    public SocketBrokerCreateTcpSocketParams() {
      this(0);
    }

    public static SocketBrokerCreateTcpSocketParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SocketBrokerCreateTcpSocketParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SocketBrokerCreateTcpSocketParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SocketBrokerCreateTcpSocketParams result =
            new SocketBrokerCreateTcpSocketParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.addressFamily = readInt;
        AddressFamily.validate(readInt);
        result.addressFamily = AddressFamily.toKnownValue(result.addressFamily);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.addressFamily, 8);
    }
  }

  static final class SocketBrokerCreateTcpSocketResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public TransferableSocket createdSocket;
    public int rv;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SocketBrokerCreateTcpSocketResponseParams(int version) {
      super(24, version);
    }

    public SocketBrokerCreateTcpSocketResponseParams() {
      this(0);
    }

    public static SocketBrokerCreateTcpSocketResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SocketBrokerCreateTcpSocketResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SocketBrokerCreateTcpSocketResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SocketBrokerCreateTcpSocketResponseParams result =
            new SocketBrokerCreateTcpSocketResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.createdSocket = TransferableSocket.decode(decoder1);
        result.rv = decoder0.readInt(16);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.createdSocket, 8, false);
      encoder0.encode(this.rv, 16);
    }
  }

  static class SocketBrokerCreateTcpSocketResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final SocketBroker.CreateTcpSocket_Response mCallback;

    SocketBrokerCreateTcpSocketResponseParamsForwardToCallback(
        SocketBroker.CreateTcpSocket_Response callback) {
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
        SocketBrokerCreateTcpSocketResponseParams response =
            SocketBrokerCreateTcpSocketResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.createdSocket, response.rv);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class SocketBrokerCreateTcpSocketResponseParamsProxyToResponder
      implements SocketBroker.CreateTcpSocket_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    SocketBrokerCreateTcpSocketResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(TransferableSocket createdSocket, int rv) {
      SocketBrokerCreateTcpSocketResponseParams _response =
          new SocketBrokerCreateTcpSocketResponseParams();
      _response.createdSocket = createdSocket;
      _response.rv = rv;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class SocketBrokerCreateUdpSocketParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int addressFamily;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SocketBrokerCreateUdpSocketParams(int version) {
      super(16, version);
    }

    public SocketBrokerCreateUdpSocketParams() {
      this(0);
    }

    public static SocketBrokerCreateUdpSocketParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SocketBrokerCreateUdpSocketParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SocketBrokerCreateUdpSocketParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SocketBrokerCreateUdpSocketParams result =
            new SocketBrokerCreateUdpSocketParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.addressFamily = readInt;
        AddressFamily.validate(readInt);
        result.addressFamily = AddressFamily.toKnownValue(result.addressFamily);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.addressFamily, 8);
    }
  }

  static final class SocketBrokerCreateUdpSocketResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public TransferableSocket createdSocket;
    public int rv;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SocketBrokerCreateUdpSocketResponseParams(int version) {
      super(24, version);
    }

    public SocketBrokerCreateUdpSocketResponseParams() {
      this(0);
    }

    public static SocketBrokerCreateUdpSocketResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SocketBrokerCreateUdpSocketResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SocketBrokerCreateUdpSocketResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SocketBrokerCreateUdpSocketResponseParams result =
            new SocketBrokerCreateUdpSocketResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.createdSocket = TransferableSocket.decode(decoder1);
        result.rv = decoder0.readInt(16);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.createdSocket, 8, false);
      encoder0.encode(this.rv, 16);
    }
  }

  static class SocketBrokerCreateUdpSocketResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final SocketBroker.CreateUdpSocket_Response mCallback;

    SocketBrokerCreateUdpSocketResponseParamsForwardToCallback(
        SocketBroker.CreateUdpSocket_Response callback) {
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
        SocketBrokerCreateUdpSocketResponseParams response =
            SocketBrokerCreateUdpSocketResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.createdSocket, response.rv);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class SocketBrokerCreateUdpSocketResponseParamsProxyToResponder
      implements SocketBroker.CreateUdpSocket_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    SocketBrokerCreateUdpSocketResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(TransferableSocket createdSocket, int rv) {
      SocketBrokerCreateUdpSocketResponseParams _response =
          new SocketBrokerCreateUdpSocketResponseParams();
      _response.createdSocket = createdSocket;
      _response.rv = rv;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
