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

class P2pNetworkNotificationClient_Internal {
  public static final Interface.Manager<
          P2pNetworkNotificationClient, P2pNetworkNotificationClient.Proxy>
      MANAGER =
          new Interface.Manager<
              P2pNetworkNotificationClient, P2pNetworkNotificationClient.Proxy>() {
            @Override
            public String getName() {
              return "network.mojom.P2PNetworkNotificationClient";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public P2pNetworkNotificationClient.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, P2pNetworkNotificationClient impl) {
              return new Stub(core, impl);
            }

            @Override
            public P2pNetworkNotificationClient[] buildArray(int size) {
              return new P2pNetworkNotificationClient[size];
            }
          };
  private static final int NETWORK_LIST_CHANGED_ORDINAL = 0;

  P2pNetworkNotificationClient_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements P2pNetworkNotificationClient.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void networkListChanged(
        NetworkInterface[] networks,
        IpAddress defaultIpv4LocalAddress,
        IpAddress defaultIpv6LocalAddress) {
      P2pNetworkNotificationClientNetworkListChangedParams _message =
          new P2pNetworkNotificationClientNetworkListChangedParams();
      _message.networks = networks;
      _message.defaultIpv4LocalAddress = defaultIpv4LocalAddress;
      _message.defaultIpv6LocalAddress = defaultIpv6LocalAddress;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }
  }

  public static final class Stub extends Interface.Stub<P2pNetworkNotificationClient> {
    Stub(Core core, P2pNetworkNotificationClient impl) {
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
                P2pNetworkNotificationClient_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            P2pNetworkNotificationClientNetworkListChangedParams data =
                P2pNetworkNotificationClientNetworkListChangedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .networkListChanged(
                    data.networks, data.defaultIpv4LocalAddress, data.defaultIpv6LocalAddress);
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
                P2pNetworkNotificationClient_Internal.MANAGER,
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

  static final class P2pNetworkNotificationClientNetworkListChangedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public IpAddress defaultIpv4LocalAddress;
    public IpAddress defaultIpv6LocalAddress;
    public NetworkInterface[] networks;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private P2pNetworkNotificationClientNetworkListChangedParams(int version) {
      super(32, version);
    }

    public P2pNetworkNotificationClientNetworkListChangedParams() {
      this(0);
    }

    public static P2pNetworkNotificationClientNetworkListChangedParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static P2pNetworkNotificationClientNetworkListChangedParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static P2pNetworkNotificationClientNetworkListChangedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        P2pNetworkNotificationClientNetworkListChangedParams result =
            new P2pNetworkNotificationClientNetworkListChangedParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.networks = new NetworkInterface[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.networks[i1] = NetworkInterface.decode(decoder2);
        }
        result.defaultIpv4LocalAddress = IpAddress.decode(decoder0.readPointer(16, false));
        result.defaultIpv6LocalAddress = IpAddress.decode(decoder0.readPointer(24, false));
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      NetworkInterface[] networkInterfaceArr = this.networks;
      if (networkInterfaceArr == null) {
        encoder0.encodeNullPointer(8, false);
      } else {
        Encoder encoder1 = encoder0.encodePointerArray(networkInterfaceArr.length, 8, -1);
        int i0 = 0;
        while (true) {
          NetworkInterface[] networkInterfaceArr2 = this.networks;
          if (i0 >= networkInterfaceArr2.length) {
            break;
          }
          encoder1.encode((Struct) networkInterfaceArr2[i0], (i0 * 8) + 8, false);
          i0++;
        }
      }
      encoder0.encode((Struct) this.defaultIpv4LocalAddress, 16, false);
      encoder0.encode((Struct) this.defaultIpv6LocalAddress, 24, false);
    }
  }
}
