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
import org.chromium.mojo_base.mojom.ReadOnlyBuffer;

class P2pSocket_Internal {
  public static final Interface.Manager<P2pSocket, P2pSocket.Proxy> MANAGER =
      new Interface.Manager<P2pSocket, P2pSocket.Proxy>() {
        @Override
        public String getName() {
          return "network.mojom.P2PSocket";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public P2pSocket.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, P2pSocket impl) {
          return new Stub(core, impl);
        }

        @Override
        public P2pSocket[] buildArray(int size) {
          return new P2pSocket[size];
        }
      };
  private static final int SEND_BATCH_ORDINAL = 1;
  private static final int SEND_ORDINAL = 0;
  private static final int SET_OPTION_ORDINAL = 2;

  P2pSocket_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements P2pSocket.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void send(ReadOnlyBuffer data, P2pPacketInfo packetInfo) {
      P2pSocketSendParams _message = new P2pSocketSendParams();
      _message.data = data;
      _message.packetInfo = packetInfo;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void sendBatch(P2pSendPacket[] packetBatch) {
      P2pSocketSendBatchParams _message = new P2pSocketSendBatchParams();
      _message.packetBatch = packetBatch;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void setOption(int option, int value) {
      P2pSocketSetOptionParams _message = new P2pSocketSetOptionParams();
      _message.option = option;
      _message.value = value;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }
  }

  public static final class Stub extends Interface.Stub<P2pSocket> {
    Stub(Core core, P2pSocket impl) {
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
                P2pSocket_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            P2pSocketSendParams data =
                P2pSocketSendParams.deserialize(messageWithHeader.getPayload());
            getImpl().send(data.data, data.packetInfo);
            return true;
          case 1:
            getImpl()
                .sendBatch(
                    P2pSocketSendBatchParams.deserialize(messageWithHeader.getPayload())
                        .packetBatch);
            return true;
          case 2:
            P2pSocketSetOptionParams data2 =
                P2pSocketSetOptionParams.deserialize(messageWithHeader.getPayload());
            getImpl().setOption(data2.option, data2.value);
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
                getCore(), P2pSocket_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class P2pSocketSendParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public ReadOnlyBuffer data;
    public P2pPacketInfo packetInfo;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private P2pSocketSendParams(int version) {
      super(24, version);
    }

    public P2pSocketSendParams() {
      this(0);
    }

    public static P2pSocketSendParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static P2pSocketSendParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static P2pSocketSendParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        P2pSocketSendParams result = new P2pSocketSendParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.data = ReadOnlyBuffer.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.packetInfo = P2pPacketInfo.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.data, 8, false);
      encoder0.encode((Struct) this.packetInfo, 16, false);
    }
  }

  static final class P2pSocketSendBatchParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public P2pSendPacket[] packetBatch;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private P2pSocketSendBatchParams(int version) {
      super(16, version);
    }

    public P2pSocketSendBatchParams() {
      this(0);
    }

    public static P2pSocketSendBatchParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static P2pSocketSendBatchParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static P2pSocketSendBatchParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        P2pSocketSendBatchParams result = new P2pSocketSendBatchParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.packetBatch = new P2pSendPacket[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.packetBatch[i1] = P2pSendPacket.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      P2pSendPacket[] p2pSendPacketArr = this.packetBatch;
      if (p2pSendPacketArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(p2pSendPacketArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        P2pSendPacket[] p2pSendPacketArr2 = this.packetBatch;
        if (i0 < p2pSendPacketArr2.length) {
          encoder1.encode((Struct) p2pSendPacketArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static final class P2pSocketSetOptionParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int option;
    public int value;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private P2pSocketSetOptionParams(int version) {
      super(16, version);
    }

    public P2pSocketSetOptionParams() {
      this(0);
    }

    public static P2pSocketSetOptionParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static P2pSocketSetOptionParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static P2pSocketSetOptionParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        P2pSocketSetOptionParams result = new P2pSocketSetOptionParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.option = readInt;
        P2pSocketOption.validate(readInt);
        result.option = P2pSocketOption.toKnownValue(result.option);
        result.value = decoder0.readInt(12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.option, 8);
      encoder0.encode(this.value, 12);
    }
  }
}
