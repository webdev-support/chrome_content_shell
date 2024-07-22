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

class P2pSocketClient_Internal {
  private static final int DATA_RECEIVED_ORDINAL = 3;
  public static final Interface.Manager<P2pSocketClient, P2pSocketClient.Proxy> MANAGER =
      new Interface.Manager<P2pSocketClient, P2pSocketClient.Proxy>() {
        @Override
        public String getName() {
          return "network.mojom.P2PSocketClient";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public P2pSocketClient.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, P2pSocketClient impl) {
          return new Stub(core, impl);
        }

        @Override
        public P2pSocketClient[] buildArray(int size) {
          return new P2pSocketClient[size];
        }
      };
  private static final int SEND_BATCH_COMPLETE_ORDINAL = 2;
  private static final int SEND_COMPLETE_ORDINAL = 1;
  private static final int SOCKET_CREATED_ORDINAL = 0;

  P2pSocketClient_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements P2pSocketClient.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void socketCreated(IpEndPoint localAddress, IpEndPoint remoteAddress) {
      P2pSocketClientSocketCreatedParams _message = new P2pSocketClientSocketCreatedParams();
      _message.localAddress = localAddress;
      _message.remoteAddress = remoteAddress;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void sendComplete(P2pSendPacketMetrics sendMetrics) {
      P2pSocketClientSendCompleteParams _message = new P2pSocketClientSendCompleteParams();
      _message.sendMetrics = sendMetrics;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void sendBatchComplete(P2pSendPacketMetrics[] sendMetricsBatch) {
      P2pSocketClientSendBatchCompleteParams _message =
          new P2pSocketClientSendBatchCompleteParams();
      _message.sendMetricsBatch = sendMetricsBatch;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void dataReceived(P2pReceivedPacket[] packets) {
      P2pSocketClientDataReceivedParams _message = new P2pSocketClientDataReceivedParams();
      _message.packets = packets;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }
  }

  public static final class Stub extends Interface.Stub<P2pSocketClient> {
    Stub(Core core, P2pSocketClient impl) {
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
                P2pSocketClient_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            P2pSocketClientSocketCreatedParams data =
                P2pSocketClientSocketCreatedParams.deserialize(messageWithHeader.getPayload());
            getImpl().socketCreated(data.localAddress, data.remoteAddress);
            return true;
          case 1:
            getImpl()
                .sendComplete(
                    P2pSocketClientSendCompleteParams.deserialize(messageWithHeader.getPayload())
                        .sendMetrics);
            return true;
          case 2:
            getImpl()
                .sendBatchComplete(
                    P2pSocketClientSendBatchCompleteParams.deserialize(
                            messageWithHeader.getPayload())
                        .sendMetricsBatch);
            return true;
          case 3:
            getImpl()
                .dataReceived(
                    P2pSocketClientDataReceivedParams.deserialize(messageWithHeader.getPayload())
                        .packets);
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
                getCore(), P2pSocketClient_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class P2pSocketClientSocketCreatedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public IpEndPoint localAddress;
    public IpEndPoint remoteAddress;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private P2pSocketClientSocketCreatedParams(int version) {
      super(24, version);
    }

    public P2pSocketClientSocketCreatedParams() {
      this(0);
    }

    public static P2pSocketClientSocketCreatedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static P2pSocketClientSocketCreatedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static P2pSocketClientSocketCreatedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        P2pSocketClientSocketCreatedParams result =
            new P2pSocketClientSocketCreatedParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.localAddress = IpEndPoint.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.remoteAddress = IpEndPoint.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.localAddress, 8, false);
      encoder0.encode((Struct) this.remoteAddress, 16, false);
    }
  }

  static final class P2pSocketClientSendCompleteParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public P2pSendPacketMetrics sendMetrics;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private P2pSocketClientSendCompleteParams(int version) {
      super(16, version);
    }

    public P2pSocketClientSendCompleteParams() {
      this(0);
    }

    public static P2pSocketClientSendCompleteParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static P2pSocketClientSendCompleteParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static P2pSocketClientSendCompleteParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        P2pSocketClientSendCompleteParams result =
            new P2pSocketClientSendCompleteParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.sendMetrics = P2pSendPacketMetrics.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.sendMetrics, 8, false);
    }
  }

  static final class P2pSocketClientSendBatchCompleteParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public P2pSendPacketMetrics[] sendMetricsBatch;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private P2pSocketClientSendBatchCompleteParams(int version) {
      super(16, version);
    }

    public P2pSocketClientSendBatchCompleteParams() {
      this(0);
    }

    public static P2pSocketClientSendBatchCompleteParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static P2pSocketClientSendBatchCompleteParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static P2pSocketClientSendBatchCompleteParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        P2pSocketClientSendBatchCompleteParams result =
            new P2pSocketClientSendBatchCompleteParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.sendMetricsBatch = new P2pSendPacketMetrics[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.sendMetricsBatch[i1] = P2pSendPacketMetrics.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      P2pSendPacketMetrics[] p2pSendPacketMetricsArr = this.sendMetricsBatch;
      if (p2pSendPacketMetricsArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(p2pSendPacketMetricsArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        P2pSendPacketMetrics[] p2pSendPacketMetricsArr2 = this.sendMetricsBatch;
        if (i0 < p2pSendPacketMetricsArr2.length) {
          encoder1.encode((Struct) p2pSendPacketMetricsArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static final class P2pSocketClientDataReceivedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public P2pReceivedPacket[] packets;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private P2pSocketClientDataReceivedParams(int version) {
      super(16, version);
    }

    public P2pSocketClientDataReceivedParams() {
      this(0);
    }

    public static P2pSocketClientDataReceivedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static P2pSocketClientDataReceivedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static P2pSocketClientDataReceivedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        P2pSocketClientDataReceivedParams result =
            new P2pSocketClientDataReceivedParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.packets = new P2pReceivedPacket[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.packets[i1] = P2pReceivedPacket.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      P2pReceivedPacket[] p2pReceivedPacketArr = this.packets;
      if (p2pReceivedPacketArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(p2pReceivedPacketArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        P2pReceivedPacket[] p2pReceivedPacketArr2 = this.packets;
        if (i0 < p2pReceivedPacketArr2.length) {
          encoder1.encode((Struct) p2pReceivedPacketArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }
}
