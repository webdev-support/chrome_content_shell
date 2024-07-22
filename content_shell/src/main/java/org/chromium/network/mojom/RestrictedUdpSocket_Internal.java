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

class RestrictedUdpSocket_Internal {
  public static final Interface.Manager<RestrictedUdpSocket, RestrictedUdpSocket.Proxy> MANAGER =
      new Interface.Manager<RestrictedUdpSocket, RestrictedUdpSocket.Proxy>() {
        @Override
        public String getName() {
          return "network.mojom.RestrictedUDPSocket";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public RestrictedUdpSocket.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, RestrictedUdpSocket impl) {
          return new Stub(core, impl);
        }

        @Override
        public RestrictedUdpSocket[] buildArray(int size) {
          return new RestrictedUdpSocket[size];
        }
      };
  private static final int RECEIVE_MORE_ORDINAL = 0;
  private static final int SEND_ORDINAL = 1;
  private static final int SEND_TO_ORDINAL = 2;

  RestrictedUdpSocket_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements RestrictedUdpSocket.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void receiveMore(int numAdditionalDatagrams) {
      RestrictedUdpSocketReceiveMoreParams _message = new RestrictedUdpSocketReceiveMoreParams();
      _message.numAdditionalDatagrams = numAdditionalDatagrams;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void send(ReadOnlyBuffer data, RestrictedUdpSocket.Send_Response callback) {
      RestrictedUdpSocketSendParams _message = new RestrictedUdpSocketSendParams();
      _message.data = data;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new RestrictedUdpSocketSendResponseParamsForwardToCallback(callback));
    }

    @Override
    public void sendTo(
        ReadOnlyBuffer data,
        HostPortPair destAddr,
        int dnsQueryType,
        RestrictedUdpSocket.SendTo_Response callback) {
      RestrictedUdpSocketSendToParams _message = new RestrictedUdpSocketSendToParams();
      _message.data = data;
      _message.destAddr = destAddr;
      _message.dnsQueryType = dnsQueryType;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new RestrictedUdpSocketSendToResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<RestrictedUdpSocket> {
    Stub(Core core, RestrictedUdpSocket impl) {
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
                RestrictedUdpSocket_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            RestrictedUdpSocketReceiveMoreParams data =
                RestrictedUdpSocketReceiveMoreParams.deserialize(messageWithHeader.getPayload());
            getImpl().receiveMore(data.numAdditionalDatagrams);
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
                getCore(), RestrictedUdpSocket_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
          default:
            return false;
          case 1:
            getImpl()
                .send(
                    RestrictedUdpSocketSendParams.deserialize(messageWithHeader.getPayload()).data,
                    new RestrictedUdpSocketSendResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 2:
            RestrictedUdpSocketSendToParams data =
                RestrictedUdpSocketSendToParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .sendTo(
                    data.data,
                    data.destAddr,
                    data.dnsQueryType,
                    new RestrictedUdpSocketSendToResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class RestrictedUdpSocketReceiveMoreParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int numAdditionalDatagrams;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private RestrictedUdpSocketReceiveMoreParams(int version) {
      super(16, version);
    }

    public RestrictedUdpSocketReceiveMoreParams() {
      this(0);
    }

    public static RestrictedUdpSocketReceiveMoreParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static RestrictedUdpSocketReceiveMoreParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static RestrictedUdpSocketReceiveMoreParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        RestrictedUdpSocketReceiveMoreParams result =
            new RestrictedUdpSocketReceiveMoreParams(elementsOrVersion);
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

  static final class RestrictedUdpSocketSendParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public ReadOnlyBuffer data;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private RestrictedUdpSocketSendParams(int version) {
      super(16, version);
    }

    public RestrictedUdpSocketSendParams() {
      this(0);
    }

    public static RestrictedUdpSocketSendParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static RestrictedUdpSocketSendParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static RestrictedUdpSocketSendParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        RestrictedUdpSocketSendParams result = new RestrictedUdpSocketSendParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.data = ReadOnlyBuffer.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.data, 8, false);
    }
  }

  static final class RestrictedUdpSocketSendResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private RestrictedUdpSocketSendResponseParams(int version) {
      super(16, version);
    }

    public RestrictedUdpSocketSendResponseParams() {
      this(0);
    }

    public static RestrictedUdpSocketSendResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static RestrictedUdpSocketSendResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static RestrictedUdpSocketSendResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        RestrictedUdpSocketSendResponseParams result =
            new RestrictedUdpSocketSendResponseParams(elementsOrVersion);
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

  static class RestrictedUdpSocketSendResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final RestrictedUdpSocket.Send_Response mCallback;

    RestrictedUdpSocketSendResponseParamsForwardToCallback(
        RestrictedUdpSocket.Send_Response callback) {
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
        RestrictedUdpSocketSendResponseParams response =
            RestrictedUdpSocketSendResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class RestrictedUdpSocketSendResponseParamsProxyToResponder
      implements RestrictedUdpSocket.Send_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    RestrictedUdpSocketSendResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int result) {
      RestrictedUdpSocketSendResponseParams _response = new RestrictedUdpSocketSendResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class RestrictedUdpSocketSendToParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public ReadOnlyBuffer data;
    public HostPortPair destAddr;
    public int dnsQueryType;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private RestrictedUdpSocketSendToParams(int version) {
      super(32, version);
    }

    public RestrictedUdpSocketSendToParams() {
      this(0);
    }

    public static RestrictedUdpSocketSendToParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static RestrictedUdpSocketSendToParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static RestrictedUdpSocketSendToParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        RestrictedUdpSocketSendToParams result =
            new RestrictedUdpSocketSendToParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.data = ReadOnlyBuffer.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.destAddr = HostPortPair.decode(decoder12);
        int readInt = decoder0.readInt(24);
        result.dnsQueryType = readInt;
        DnsQueryType.validate(readInt);
        result.dnsQueryType = DnsQueryType.toKnownValue(result.dnsQueryType);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.data, 8, false);
      encoder0.encode((Struct) this.destAddr, 16, false);
      encoder0.encode(this.dnsQueryType, 24);
    }
  }

  static final class RestrictedUdpSocketSendToResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private RestrictedUdpSocketSendToResponseParams(int version) {
      super(16, version);
    }

    public RestrictedUdpSocketSendToResponseParams() {
      this(0);
    }

    public static RestrictedUdpSocketSendToResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static RestrictedUdpSocketSendToResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static RestrictedUdpSocketSendToResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        RestrictedUdpSocketSendToResponseParams result =
            new RestrictedUdpSocketSendToResponseParams(elementsOrVersion);
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

  static class RestrictedUdpSocketSendToResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final RestrictedUdpSocket.SendTo_Response mCallback;

    RestrictedUdpSocketSendToResponseParamsForwardToCallback(
        RestrictedUdpSocket.SendTo_Response callback) {
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
        RestrictedUdpSocketSendToResponseParams response =
            RestrictedUdpSocketSendToResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class RestrictedUdpSocketSendToResponseParamsProxyToResponder
      implements RestrictedUdpSocket.SendTo_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    RestrictedUdpSocketSendToResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int result) {
      RestrictedUdpSocketSendToResponseParams _response =
          new RestrictedUdpSocketSendToResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
