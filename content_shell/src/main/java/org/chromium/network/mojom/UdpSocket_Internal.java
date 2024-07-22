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
import org.chromium.mojo_base.mojom.ReadOnlyBuffer;

class UdpSocket_Internal {
  private static final int BIND_ORDINAL = 0;
  private static final int CLOSE_ORDINAL = 11;
  private static final int CONNECT_ORDINAL = 1;
  private static final int JOIN_GROUP_ORDINAL = 5;
  private static final int LEAVE_GROUP_ORDINAL = 6;
  public static final Interface.Manager<UdpSocket, UdpSocket.Proxy> MANAGER =
      new Interface.Manager<UdpSocket, UdpSocket.Proxy>() {
        @Override
        public String getName() {
          return "network.mojom.UDPSocket";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public UdpSocket.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, UdpSocket impl) {
          return new Stub(core, impl);
        }

        @Override
        public UdpSocket[] buildArray(int size) {
          return new UdpSocket[size];
        }
      };
  private static final int RECEIVE_MORE_ORDINAL = 7;
  private static final int RECEIVE_MORE_WITH_BUFFER_SIZE_ORDINAL = 8;
  private static final int SEND_ORDINAL = 10;
  private static final int SEND_TO_ORDINAL = 9;
  private static final int SET_BROADCAST_ORDINAL = 2;
  private static final int SET_RECEIVE_BUFFER_SIZE_ORDINAL = 4;
  private static final int SET_SEND_BUFFER_SIZE_ORDINAL = 3;

  UdpSocket_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements UdpSocket.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void bind(
        IpEndPoint localAddr, UdpSocketOptions socketOptions, UdpSocket.Bind_Response callback) {
      UdpSocketBindParams _message = new UdpSocketBindParams();
      _message.localAddr = localAddr;
      _message.socketOptions = socketOptions;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new UdpSocketBindResponseParamsForwardToCallback(callback));
    }

    @Override
    public void connect(
        IpEndPoint remoteAddr,
        UdpSocketOptions socketOptions,
        UdpSocket.Connect_Response callback) {
      UdpSocketConnectParams _message = new UdpSocketConnectParams();
      _message.remoteAddr = remoteAddr;
      _message.socketOptions = socketOptions;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new UdpSocketConnectResponseParamsForwardToCallback(callback));
    }

    @Override
    public void setBroadcast(boolean broadcast, UdpSocket.SetBroadcast_Response callback) {
      UdpSocketSetBroadcastParams _message = new UdpSocketSetBroadcastParams();
      _message.broadcast = broadcast;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new UdpSocketSetBroadcastResponseParamsForwardToCallback(callback));
    }

    @Override
    public void setSendBufferSize(
        int sendBufferSize, UdpSocket.SetSendBufferSize_Response callback) {
      UdpSocketSetSendBufferSizeParams _message = new UdpSocketSetSendBufferSizeParams();
      _message.sendBufferSize = sendBufferSize;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)),
              new UdpSocketSetSendBufferSizeResponseParamsForwardToCallback(callback));
    }

    @Override
    public void setReceiveBufferSize(
        int receiveBufferSize, UdpSocket.SetReceiveBufferSize_Response callback) {
      UdpSocketSetReceiveBufferSizeParams _message = new UdpSocketSetReceiveBufferSizeParams();
      _message.receiveBufferSize = receiveBufferSize;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)),
              new UdpSocketSetReceiveBufferSizeResponseParamsForwardToCallback(callback));
    }

    @Override
    public void joinGroup(IpAddress groupAddress, UdpSocket.JoinGroup_Response callback) {
      UdpSocketJoinGroupParams _message = new UdpSocketJoinGroupParams();
      _message.groupAddress = groupAddress;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(5, 1, 0L)),
              new UdpSocketJoinGroupResponseParamsForwardToCallback(callback));
    }

    @Override
    public void leaveGroup(IpAddress groupAddress, UdpSocket.LeaveGroup_Response callback) {
      UdpSocketLeaveGroupParams _message = new UdpSocketLeaveGroupParams();
      _message.groupAddress = groupAddress;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(6, 1, 0L)),
              new UdpSocketLeaveGroupResponseParamsForwardToCallback(callback));
    }

    @Override
    public void receiveMore(int numAdditionalDatagrams) {
      UdpSocketReceiveMoreParams _message = new UdpSocketReceiveMoreParams();
      _message.numAdditionalDatagrams = numAdditionalDatagrams;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(7)));
    }

    @Override
    public void receiveMoreWithBufferSize(int numAdditionalDatagrams, int bufferSize) {
      UdpSocketReceiveMoreWithBufferSizeParams _message =
          new UdpSocketReceiveMoreWithBufferSizeParams();
      _message.numAdditionalDatagrams = numAdditionalDatagrams;
      _message.bufferSize = bufferSize;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(8)));
    }

    @Override
    public void sendTo(
        IpEndPoint destAddr,
        ReadOnlyBuffer data,
        MutableNetworkTrafficAnnotationTag trafficAnnotation,
        UdpSocket.SendTo_Response callback) {
      UdpSocketSendToParams _message = new UdpSocketSendToParams();
      _message.destAddr = destAddr;
      _message.data = data;
      _message.trafficAnnotation = trafficAnnotation;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(9, 1, 0L)),
              new UdpSocketSendToResponseParamsForwardToCallback(callback));
    }

    @Override
    public void send(
        ReadOnlyBuffer data,
        MutableNetworkTrafficAnnotationTag trafficAnnotation,
        UdpSocket.Send_Response callback) {
      UdpSocketSendParams _message = new UdpSocketSendParams();
      _message.data = data;
      _message.trafficAnnotation = trafficAnnotation;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(10, 1, 0L)),
              new UdpSocketSendResponseParamsForwardToCallback(callback));
    }

    @Override
    public void close() {
      UdpSocketCloseParams _message = new UdpSocketCloseParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(11)));
    }
  }

  public static final class Stub extends Interface.Stub<UdpSocket> {
    Stub(Core core, UdpSocket impl) {
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
                UdpSocket_Internal.MANAGER, messageWithHeader);
          case 7:
            getImpl()
                .receiveMore(
                    UdpSocketReceiveMoreParams.deserialize(messageWithHeader.getPayload())
                        .numAdditionalDatagrams);
            return true;
          case 8:
            UdpSocketReceiveMoreWithBufferSizeParams data =
                UdpSocketReceiveMoreWithBufferSizeParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().receiveMoreWithBufferSize(data.numAdditionalDatagrams, data.bufferSize);
            return true;
          case 11:
            UdpSocketCloseParams.deserialize(messageWithHeader.getPayload());
            getImpl().close();
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
                getCore(), UdpSocket_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            UdpSocketBindParams data =
                UdpSocketBindParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .bind(
                    data.localAddr,
                    data.socketOptions,
                    new UdpSocketBindResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
            UdpSocketConnectParams data2 =
                UdpSocketConnectParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .connect(
                    data2.remoteAddr,
                    data2.socketOptions,
                    new UdpSocketConnectResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 2:
            getImpl()
                .setBroadcast(
                    UdpSocketSetBroadcastParams.deserialize(messageWithHeader.getPayload())
                        .broadcast,
                    new UdpSocketSetBroadcastResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 3:
            getImpl()
                .setSendBufferSize(
                    UdpSocketSetSendBufferSizeParams.deserialize(messageWithHeader.getPayload())
                        .sendBufferSize,
                    new UdpSocketSetSendBufferSizeResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 4:
            getImpl()
                .setReceiveBufferSize(
                    UdpSocketSetReceiveBufferSizeParams.deserialize(messageWithHeader.getPayload())
                        .receiveBufferSize,
                    new UdpSocketSetReceiveBufferSizeResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 5:
            getImpl()
                .joinGroup(
                    UdpSocketJoinGroupParams.deserialize(messageWithHeader.getPayload())
                        .groupAddress,
                    new UdpSocketJoinGroupResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 6:
            getImpl()
                .leaveGroup(
                    UdpSocketLeaveGroupParams.deserialize(messageWithHeader.getPayload())
                        .groupAddress,
                    new UdpSocketLeaveGroupResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 7:
          case 8:
          default:
            return false;
          case 9:
            UdpSocketSendToParams data3 =
                UdpSocketSendToParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .sendTo(
                    data3.destAddr,
                    data3.data,
                    data3.trafficAnnotation,
                    new UdpSocketSendToResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 10:
            UdpSocketSendParams data4 =
                UdpSocketSendParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .send(
                    data4.data,
                    data4.trafficAnnotation,
                    new UdpSocketSendResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class UdpSocketBindParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public IpEndPoint localAddr;
    public UdpSocketOptions socketOptions;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private UdpSocketBindParams(int version) {
      super(24, version);
    }

    public UdpSocketBindParams() {
      this(0);
    }

    public static UdpSocketBindParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static UdpSocketBindParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static UdpSocketBindParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        UdpSocketBindParams result = new UdpSocketBindParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.localAddr = IpEndPoint.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, true);
        result.socketOptions = UdpSocketOptions.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.localAddr, 8, false);
      encoder0.encode((Struct) this.socketOptions, 16, true);
    }
  }

  static final class UdpSocketBindResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public IpEndPoint localAddrOut;
    public int result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private UdpSocketBindResponseParams(int version) {
      super(24, version);
    }

    public UdpSocketBindResponseParams() {
      this(0);
    }

    public static UdpSocketBindResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static UdpSocketBindResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static UdpSocketBindResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        UdpSocketBindResponseParams result = new UdpSocketBindResponseParams(elementsOrVersion);
        result.result = decoder0.readInt(8);
        Decoder decoder1 = decoder0.readPointer(16, true);
        result.localAddrOut = IpEndPoint.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.result, 8);
      encoder0.encode((Struct) this.localAddrOut, 16, true);
    }
  }

  static class UdpSocketBindResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final UdpSocket.Bind_Response mCallback;

    UdpSocketBindResponseParamsForwardToCallback(UdpSocket.Bind_Response callback) {
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
        UdpSocketBindResponseParams response =
            UdpSocketBindResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.result, response.localAddrOut);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class UdpSocketBindResponseParamsProxyToResponder implements UdpSocket.Bind_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    UdpSocketBindResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int result, IpEndPoint localAddrOut) {
      UdpSocketBindResponseParams _response = new UdpSocketBindResponseParams();
      _response.result = result;
      _response.localAddrOut = localAddrOut;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class UdpSocketConnectParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public IpEndPoint remoteAddr;
    public UdpSocketOptions socketOptions;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private UdpSocketConnectParams(int version) {
      super(24, version);
    }

    public UdpSocketConnectParams() {
      this(0);
    }

    public static UdpSocketConnectParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static UdpSocketConnectParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static UdpSocketConnectParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        UdpSocketConnectParams result = new UdpSocketConnectParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.remoteAddr = IpEndPoint.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, true);
        result.socketOptions = UdpSocketOptions.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.remoteAddr, 8, false);
      encoder0.encode((Struct) this.socketOptions, 16, true);
    }
  }

  static final class UdpSocketConnectResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public IpEndPoint localAddrOut;
    public int result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private UdpSocketConnectResponseParams(int version) {
      super(24, version);
    }

    public UdpSocketConnectResponseParams() {
      this(0);
    }

    public static UdpSocketConnectResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static UdpSocketConnectResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static UdpSocketConnectResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        UdpSocketConnectResponseParams result =
            new UdpSocketConnectResponseParams(elementsOrVersion);
        result.result = decoder0.readInt(8);
        Decoder decoder1 = decoder0.readPointer(16, true);
        result.localAddrOut = IpEndPoint.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.result, 8);
      encoder0.encode((Struct) this.localAddrOut, 16, true);
    }
  }

  static class UdpSocketConnectResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final UdpSocket.Connect_Response mCallback;

    UdpSocketConnectResponseParamsForwardToCallback(UdpSocket.Connect_Response callback) {
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
        UdpSocketConnectResponseParams response =
            UdpSocketConnectResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.result, response.localAddrOut);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class UdpSocketConnectResponseParamsProxyToResponder
      implements UdpSocket.Connect_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    UdpSocketConnectResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int result, IpEndPoint localAddrOut) {
      UdpSocketConnectResponseParams _response = new UdpSocketConnectResponseParams();
      _response.result = result;
      _response.localAddrOut = localAddrOut;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class UdpSocketSetBroadcastParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean broadcast;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private UdpSocketSetBroadcastParams(int version) {
      super(16, version);
    }

    public UdpSocketSetBroadcastParams() {
      this(0);
    }

    public static UdpSocketSetBroadcastParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static UdpSocketSetBroadcastParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static UdpSocketSetBroadcastParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        UdpSocketSetBroadcastParams result = new UdpSocketSetBroadcastParams(elementsOrVersion);
        result.broadcast = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.broadcast, 8, 0);
    }
  }

  static final class UdpSocketSetBroadcastResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private UdpSocketSetBroadcastResponseParams(int version) {
      super(16, version);
    }

    public UdpSocketSetBroadcastResponseParams() {
      this(0);
    }

    public static UdpSocketSetBroadcastResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static UdpSocketSetBroadcastResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static UdpSocketSetBroadcastResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        UdpSocketSetBroadcastResponseParams result =
            new UdpSocketSetBroadcastResponseParams(elementsOrVersion);
        result.result = decoder0.readInt(8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.result, 8);
    }
  }

  static class UdpSocketSetBroadcastResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final UdpSocket.SetBroadcast_Response mCallback;

    UdpSocketSetBroadcastResponseParamsForwardToCallback(UdpSocket.SetBroadcast_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(2, 2)) {
          return false;
        }
        UdpSocketSetBroadcastResponseParams response =
            UdpSocketSetBroadcastResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class UdpSocketSetBroadcastResponseParamsProxyToResponder
      implements UdpSocket.SetBroadcast_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    UdpSocketSetBroadcastResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int result) {
      UdpSocketSetBroadcastResponseParams _response = new UdpSocketSetBroadcastResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class UdpSocketSetSendBufferSizeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int sendBufferSize;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private UdpSocketSetSendBufferSizeParams(int version) {
      super(16, version);
    }

    public UdpSocketSetSendBufferSizeParams() {
      this(0);
    }

    public static UdpSocketSetSendBufferSizeParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static UdpSocketSetSendBufferSizeParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static UdpSocketSetSendBufferSizeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        UdpSocketSetSendBufferSizeParams result =
            new UdpSocketSetSendBufferSizeParams(elementsOrVersion);
        result.sendBufferSize = decoder0.readInt(8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.sendBufferSize, 8);
    }
  }

  static final class UdpSocketSetSendBufferSizeResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private UdpSocketSetSendBufferSizeResponseParams(int version) {
      super(16, version);
    }

    public UdpSocketSetSendBufferSizeResponseParams() {
      this(0);
    }

    public static UdpSocketSetSendBufferSizeResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static UdpSocketSetSendBufferSizeResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static UdpSocketSetSendBufferSizeResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        UdpSocketSetSendBufferSizeResponseParams result =
            new UdpSocketSetSendBufferSizeResponseParams(elementsOrVersion);
        result.result = decoder0.readInt(8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.result, 8);
    }
  }

  static class UdpSocketSetSendBufferSizeResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final UdpSocket.SetSendBufferSize_Response mCallback;

    UdpSocketSetSendBufferSizeResponseParamsForwardToCallback(
        UdpSocket.SetSendBufferSize_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(3, 2)) {
          return false;
        }
        UdpSocketSetSendBufferSizeResponseParams response =
            UdpSocketSetSendBufferSizeResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class UdpSocketSetSendBufferSizeResponseParamsProxyToResponder
      implements UdpSocket.SetSendBufferSize_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    UdpSocketSetSendBufferSizeResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int result) {
      UdpSocketSetSendBufferSizeResponseParams _response =
          new UdpSocketSetSendBufferSizeResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class UdpSocketSetReceiveBufferSizeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int receiveBufferSize;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private UdpSocketSetReceiveBufferSizeParams(int version) {
      super(16, version);
    }

    public UdpSocketSetReceiveBufferSizeParams() {
      this(0);
    }

    public static UdpSocketSetReceiveBufferSizeParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static UdpSocketSetReceiveBufferSizeParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static UdpSocketSetReceiveBufferSizeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        UdpSocketSetReceiveBufferSizeParams result =
            new UdpSocketSetReceiveBufferSizeParams(elementsOrVersion);
        result.receiveBufferSize = decoder0.readInt(8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.receiveBufferSize, 8);
    }
  }

  static final class UdpSocketSetReceiveBufferSizeResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private UdpSocketSetReceiveBufferSizeResponseParams(int version) {
      super(16, version);
    }

    public UdpSocketSetReceiveBufferSizeResponseParams() {
      this(0);
    }

    public static UdpSocketSetReceiveBufferSizeResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static UdpSocketSetReceiveBufferSizeResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static UdpSocketSetReceiveBufferSizeResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        UdpSocketSetReceiveBufferSizeResponseParams result =
            new UdpSocketSetReceiveBufferSizeResponseParams(elementsOrVersion);
        result.result = decoder0.readInt(8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.result, 8);
    }
  }

  static class UdpSocketSetReceiveBufferSizeResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final UdpSocket.SetReceiveBufferSize_Response mCallback;

    UdpSocketSetReceiveBufferSizeResponseParamsForwardToCallback(
        UdpSocket.SetReceiveBufferSize_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(4, 2)) {
          return false;
        }
        UdpSocketSetReceiveBufferSizeResponseParams response =
            UdpSocketSetReceiveBufferSizeResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class UdpSocketSetReceiveBufferSizeResponseParamsProxyToResponder
      implements UdpSocket.SetReceiveBufferSize_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    UdpSocketSetReceiveBufferSizeResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int result) {
      UdpSocketSetReceiveBufferSizeResponseParams _response =
          new UdpSocketSetReceiveBufferSizeResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class UdpSocketJoinGroupParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public IpAddress groupAddress;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private UdpSocketJoinGroupParams(int version) {
      super(16, version);
    }

    public UdpSocketJoinGroupParams() {
      this(0);
    }

    public static UdpSocketJoinGroupParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static UdpSocketJoinGroupParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static UdpSocketJoinGroupParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        UdpSocketJoinGroupParams result = new UdpSocketJoinGroupParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.groupAddress = IpAddress.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.groupAddress, 8, false);
    }
  }

  static final class UdpSocketJoinGroupResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private UdpSocketJoinGroupResponseParams(int version) {
      super(16, version);
    }

    public UdpSocketJoinGroupResponseParams() {
      this(0);
    }

    public static UdpSocketJoinGroupResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static UdpSocketJoinGroupResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static UdpSocketJoinGroupResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        UdpSocketJoinGroupResponseParams result =
            new UdpSocketJoinGroupResponseParams(elementsOrVersion);
        result.result = decoder0.readInt(8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.result, 8);
    }
  }

  static class UdpSocketJoinGroupResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final UdpSocket.JoinGroup_Response mCallback;

    UdpSocketJoinGroupResponseParamsForwardToCallback(UdpSocket.JoinGroup_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(5, 2)) {
          return false;
        }
        UdpSocketJoinGroupResponseParams response =
            UdpSocketJoinGroupResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class UdpSocketJoinGroupResponseParamsProxyToResponder
      implements UdpSocket.JoinGroup_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    UdpSocketJoinGroupResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int result) {
      UdpSocketJoinGroupResponseParams _response = new UdpSocketJoinGroupResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(5, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class UdpSocketLeaveGroupParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public IpAddress groupAddress;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private UdpSocketLeaveGroupParams(int version) {
      super(16, version);
    }

    public UdpSocketLeaveGroupParams() {
      this(0);
    }

    public static UdpSocketLeaveGroupParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static UdpSocketLeaveGroupParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static UdpSocketLeaveGroupParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        UdpSocketLeaveGroupParams result = new UdpSocketLeaveGroupParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.groupAddress = IpAddress.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.groupAddress, 8, false);
    }
  }

  static final class UdpSocketLeaveGroupResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private UdpSocketLeaveGroupResponseParams(int version) {
      super(16, version);
    }

    public UdpSocketLeaveGroupResponseParams() {
      this(0);
    }

    public static UdpSocketLeaveGroupResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static UdpSocketLeaveGroupResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static UdpSocketLeaveGroupResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        UdpSocketLeaveGroupResponseParams result =
            new UdpSocketLeaveGroupResponseParams(elementsOrVersion);
        result.result = decoder0.readInt(8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.result, 8);
    }
  }

  static class UdpSocketLeaveGroupResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final UdpSocket.LeaveGroup_Response mCallback;

    UdpSocketLeaveGroupResponseParamsForwardToCallback(UdpSocket.LeaveGroup_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(6, 2)) {
          return false;
        }
        UdpSocketLeaveGroupResponseParams response =
            UdpSocketLeaveGroupResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class UdpSocketLeaveGroupResponseParamsProxyToResponder
      implements UdpSocket.LeaveGroup_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    UdpSocketLeaveGroupResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int result) {
      UdpSocketLeaveGroupResponseParams _response = new UdpSocketLeaveGroupResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(6, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class UdpSocketReceiveMoreParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int numAdditionalDatagrams;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private UdpSocketReceiveMoreParams(int version) {
      super(16, version);
    }

    public UdpSocketReceiveMoreParams() {
      this(0);
    }

    public static UdpSocketReceiveMoreParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static UdpSocketReceiveMoreParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static UdpSocketReceiveMoreParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        UdpSocketReceiveMoreParams result = new UdpSocketReceiveMoreParams(elementsOrVersion);
        result.numAdditionalDatagrams = decoder0.readInt(8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.numAdditionalDatagrams, 8);
    }
  }

  static final class UdpSocketReceiveMoreWithBufferSizeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int bufferSize;
    public int numAdditionalDatagrams;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private UdpSocketReceiveMoreWithBufferSizeParams(int version) {
      super(16, version);
    }

    public UdpSocketReceiveMoreWithBufferSizeParams() {
      this(0);
    }

    public static UdpSocketReceiveMoreWithBufferSizeParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static UdpSocketReceiveMoreWithBufferSizeParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static UdpSocketReceiveMoreWithBufferSizeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        UdpSocketReceiveMoreWithBufferSizeParams result =
            new UdpSocketReceiveMoreWithBufferSizeParams(elementsOrVersion);
        result.numAdditionalDatagrams = decoder0.readInt(8);
        result.bufferSize = decoder0.readInt(12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.numAdditionalDatagrams, 8);
      encoder0.encode(this.bufferSize, 12);
    }
  }

  static final class UdpSocketSendToParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public ReadOnlyBuffer data;
    public IpEndPoint destAddr;
    public MutableNetworkTrafficAnnotationTag trafficAnnotation;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private UdpSocketSendToParams(int version) {
      super(32, version);
    }

    public UdpSocketSendToParams() {
      this(0);
    }

    public static UdpSocketSendToParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static UdpSocketSendToParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static UdpSocketSendToParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        UdpSocketSendToParams result = new UdpSocketSendToParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.destAddr = IpEndPoint.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.data = ReadOnlyBuffer.decode(decoder12);
        Decoder decoder13 = decoder0.readPointer(24, false);
        result.trafficAnnotation = MutableNetworkTrafficAnnotationTag.decode(decoder13);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.destAddr, 8, false);
      encoder0.encode((Struct) this.data, 16, false);
      encoder0.encode((Struct) this.trafficAnnotation, 24, false);
    }
  }

  static final class UdpSocketSendToResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private UdpSocketSendToResponseParams(int version) {
      super(16, version);
    }

    public UdpSocketSendToResponseParams() {
      this(0);
    }

    public static UdpSocketSendToResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static UdpSocketSendToResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static UdpSocketSendToResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        UdpSocketSendToResponseParams result = new UdpSocketSendToResponseParams(elementsOrVersion);
        result.result = decoder0.readInt(8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.result, 8);
    }
  }

  static class UdpSocketSendToResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final UdpSocket.SendTo_Response mCallback;

    UdpSocketSendToResponseParamsForwardToCallback(UdpSocket.SendTo_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(9, 2)) {
          return false;
        }
        UdpSocketSendToResponseParams response =
            UdpSocketSendToResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class UdpSocketSendToResponseParamsProxyToResponder implements UdpSocket.SendTo_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    UdpSocketSendToResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int result) {
      UdpSocketSendToResponseParams _response = new UdpSocketSendToResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(9, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class UdpSocketSendParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public ReadOnlyBuffer data;
    public MutableNetworkTrafficAnnotationTag trafficAnnotation;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private UdpSocketSendParams(int version) {
      super(24, version);
    }

    public UdpSocketSendParams() {
      this(0);
    }

    public static UdpSocketSendParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static UdpSocketSendParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static UdpSocketSendParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        UdpSocketSendParams result = new UdpSocketSendParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.data = ReadOnlyBuffer.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.trafficAnnotation = MutableNetworkTrafficAnnotationTag.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.data, 8, false);
      encoder0.encode((Struct) this.trafficAnnotation, 16, false);
    }
  }

  static final class UdpSocketSendResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private UdpSocketSendResponseParams(int version) {
      super(16, version);
    }

    public UdpSocketSendResponseParams() {
      this(0);
    }

    public static UdpSocketSendResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static UdpSocketSendResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static UdpSocketSendResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        UdpSocketSendResponseParams result = new UdpSocketSendResponseParams(elementsOrVersion);
        result.result = decoder0.readInt(8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.result, 8);
    }
  }

  static class UdpSocketSendResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final UdpSocket.Send_Response mCallback;

    UdpSocketSendResponseParamsForwardToCallback(UdpSocket.Send_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(10, 2)) {
          return false;
        }
        UdpSocketSendResponseParams response =
            UdpSocketSendResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class UdpSocketSendResponseParamsProxyToResponder implements UdpSocket.Send_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    UdpSocketSendResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int result) {
      UdpSocketSendResponseParams _response = new UdpSocketSendResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(10, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class UdpSocketCloseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private UdpSocketCloseParams(int version) {
      super(8, version);
    }

    public UdpSocketCloseParams() {
      this(0);
    }

    public static UdpSocketCloseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static UdpSocketCloseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static UdpSocketCloseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        UdpSocketCloseParams result = new UdpSocketCloseParams(elementsOrVersion);
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
