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

class NetworkChangeManager_Internal {
  public static final Interface.Manager<NetworkChangeManager, NetworkChangeManager.Proxy> MANAGER =
      new Interface.Manager<NetworkChangeManager, NetworkChangeManager.Proxy>() {
        @Override
        public String getName() {
          return "network.mojom.NetworkChangeManager";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public NetworkChangeManager.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, NetworkChangeManager impl) {
          return new Stub(core, impl);
        }

        @Override
        public NetworkChangeManager[] buildArray(int size) {
          return new NetworkChangeManager[size];
        }
      };
  private static final int ON_NETWORK_CHANGED_ORDINAL = 1;
  private static final int REQUEST_NOTIFICATIONS_ORDINAL = 0;

  NetworkChangeManager_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements NetworkChangeManager.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void requestNotifications(NetworkChangeManagerClient clientRemote) {
      NetworkChangeManagerRequestNotificationsParams _message =
          new NetworkChangeManagerRequestNotificationsParams();
      _message.clientRemote = clientRemote;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void onNetworkChanged(
        boolean dnsChanged,
        boolean ipAddressChanged,
        boolean connectionTypeChanged,
        int newConnectionType,
        boolean connectionSubtypeChanged,
        int newConnectionSubtype) {
      NetworkChangeManagerOnNetworkChangedParams _message =
          new NetworkChangeManagerOnNetworkChangedParams();
      _message.dnsChanged = dnsChanged;
      _message.ipAddressChanged = ipAddressChanged;
      _message.connectionTypeChanged = connectionTypeChanged;
      _message.newConnectionType = newConnectionType;
      _message.connectionSubtypeChanged = connectionSubtypeChanged;
      _message.newConnectionSubtype = newConnectionSubtype;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }
  }

  public static final class Stub extends Interface.Stub<NetworkChangeManager> {
    Stub(Core core, NetworkChangeManager impl) {
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
                NetworkChangeManager_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            getImpl()
                .requestNotifications(
                    NetworkChangeManagerRequestNotificationsParams.deserialize(
                            messageWithHeader.getPayload())
                        .clientRemote);
            return true;
          case 1:
            NetworkChangeManagerOnNetworkChangedParams data =
                NetworkChangeManagerOnNetworkChangedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .onNetworkChanged(
                    data.dnsChanged,
                    data.ipAddressChanged,
                    data.connectionTypeChanged,
                    data.newConnectionType,
                    data.connectionSubtypeChanged,
                    data.newConnectionSubtype);
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
                getCore(), NetworkChangeManager_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class NetworkChangeManagerRequestNotificationsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public NetworkChangeManagerClient clientRemote;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkChangeManagerRequestNotificationsParams(int version) {
      super(16, version);
    }

    public NetworkChangeManagerRequestNotificationsParams() {
      this(0);
    }

    public static NetworkChangeManagerRequestNotificationsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkChangeManagerRequestNotificationsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkChangeManagerRequestNotificationsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkChangeManagerRequestNotificationsParams result =
            new NetworkChangeManagerRequestNotificationsParams(elementsOrVersion);
        result.clientRemote =
            (NetworkChangeManagerClient)
                decoder0.readServiceInterface(8, false, NetworkChangeManagerClient.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.clientRemote, 8, false, NetworkChangeManagerClient.MANAGER);
    }
  }

  static final class NetworkChangeManagerOnNetworkChangedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean connectionSubtypeChanged;
    public boolean connectionTypeChanged;
    public boolean dnsChanged;
    public boolean ipAddressChanged;
    public int newConnectionSubtype;
    public int newConnectionType;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkChangeManagerOnNetworkChangedParams(int version) {
      super(24, version);
    }

    public NetworkChangeManagerOnNetworkChangedParams() {
      this(0);
    }

    public static NetworkChangeManagerOnNetworkChangedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkChangeManagerOnNetworkChangedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkChangeManagerOnNetworkChangedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkChangeManagerOnNetworkChangedParams result =
            new NetworkChangeManagerOnNetworkChangedParams(elementsOrVersion);
        result.dnsChanged = decoder0.readBoolean(8, 0);
        result.ipAddressChanged = decoder0.readBoolean(8, 1);
        result.connectionTypeChanged = decoder0.readBoolean(8, 2);
        result.connectionSubtypeChanged = decoder0.readBoolean(8, 3);
        int readInt = decoder0.readInt(12);
        result.newConnectionType = readInt;
        ConnectionType.validate(readInt);
        result.newConnectionType = ConnectionType.toKnownValue(result.newConnectionType);
        int readInt2 = decoder0.readInt(16);
        result.newConnectionSubtype = readInt2;
        ConnectionSubtype.validate(readInt2);
        result.newConnectionSubtype = ConnectionSubtype.toKnownValue(result.newConnectionSubtype);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.dnsChanged, 8, 0);
      encoder0.encode(this.ipAddressChanged, 8, 1);
      encoder0.encode(this.connectionTypeChanged, 8, 2);
      encoder0.encode(this.connectionSubtypeChanged, 8, 3);
      encoder0.encode(this.newConnectionType, 12);
      encoder0.encode(this.newConnectionSubtype, 16);
    }
  }
}
