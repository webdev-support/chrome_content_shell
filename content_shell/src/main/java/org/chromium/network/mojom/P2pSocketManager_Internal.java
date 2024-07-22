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
import org.chromium.mojo_base.mojom.UnguessableToken;

class P2pSocketManager_Internal {
  private static final int CREATE_SOCKET_ORDINAL = 3;
  private static final int GET_HOST_ADDRESS_ORDINAL = 1;
  private static final int GET_HOST_ADDRESS_WITH_FAMILY_ORDINAL = 2;
  public static final Interface.Manager<P2pSocketManager, P2pSocketManager.Proxy> MANAGER =
      new Interface.Manager<P2pSocketManager, P2pSocketManager.Proxy>() {
        @Override
        public String getName() {
          return "network.mojom.P2PSocketManager";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public P2pSocketManager.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, P2pSocketManager impl) {
          return new Stub(core, impl);
        }

        @Override
        public P2pSocketManager[] buildArray(int size) {
          return new P2pSocketManager[size];
        }
      };
  private static final int START_NETWORK_NOTIFICATIONS_ORDINAL = 0;

  P2pSocketManager_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements P2pSocketManager.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void startNetworkNotifications(P2pNetworkNotificationClient client) {
      P2pSocketManagerStartNetworkNotificationsParams _message =
          new P2pSocketManagerStartNetworkNotificationsParams();
      _message.client = client;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void getHostAddress(
        String hostName, boolean enableMdns, P2pSocketManager.GetHostAddress_Response callback) {
      P2pSocketManagerGetHostAddressParams _message = new P2pSocketManagerGetHostAddressParams();
      _message.hostName = hostName;
      _message.enableMdns = enableMdns;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new P2pSocketManagerGetHostAddressResponseParamsForwardToCallback(callback));
    }

    @Override
    public void getHostAddressWithFamily(
        String hostName,
        int addressFamily,
        boolean enableMdns,
        P2pSocketManager.GetHostAddressWithFamily_Response callback) {
      P2pSocketManagerGetHostAddressWithFamilyParams _message =
          new P2pSocketManagerGetHostAddressWithFamilyParams();
      _message.hostName = hostName;
      _message.addressFamily = addressFamily;
      _message.enableMdns = enableMdns;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new P2pSocketManagerGetHostAddressWithFamilyResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void createSocket(
        int type,
        IpEndPoint localAddress,
        P2pPortRange portRange,
        P2pHostAndIpEndPoint remoteAddress,
        MutableNetworkTrafficAnnotationTag trafficAnnotation,
        UnguessableToken devtoolsToken,
        P2pSocketClient client,
        InterfaceRequest<P2pSocket> socket) {
      P2pSocketManagerCreateSocketParams _message = new P2pSocketManagerCreateSocketParams();
      _message.type = type;
      _message.localAddress = localAddress;
      _message.portRange = portRange;
      _message.remoteAddress = remoteAddress;
      _message.trafficAnnotation = trafficAnnotation;
      _message.devtoolsToken = devtoolsToken;
      _message.client = client;
      _message.socket = socket;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }
  }

  public static final class Stub extends Interface.Stub<P2pSocketManager> {
    Stub(Core core, P2pSocketManager impl) {
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
                P2pSocketManager_Internal.MANAGER, messageWithHeader);
          case 0:
            getImpl()
                .startNetworkNotifications(
                    P2pSocketManagerStartNetworkNotificationsParams.deserialize(
                            messageWithHeader.getPayload())
                        .client);
            return true;
          case 3:
            P2pSocketManagerCreateSocketParams data =
                P2pSocketManagerCreateSocketParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .createSocket(
                    data.type,
                    data.localAddress,
                    data.portRange,
                    data.remoteAddress,
                    data.trafficAnnotation,
                    data.devtoolsToken,
                    data.client,
                    data.socket);
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
                getCore(), P2pSocketManager_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
          default:
            return false;
          case 1:
            P2pSocketManagerGetHostAddressParams data =
                P2pSocketManagerGetHostAddressParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .getHostAddress(
                    data.hostName,
                    data.enableMdns,
                    new P2pSocketManagerGetHostAddressResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 2:
            P2pSocketManagerGetHostAddressWithFamilyParams data2 =
                P2pSocketManagerGetHostAddressWithFamilyParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .getHostAddressWithFamily(
                    data2.hostName,
                    data2.addressFamily,
                    data2.enableMdns,
                    new P2pSocketManagerGetHostAddressWithFamilyResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class P2pSocketManagerStartNetworkNotificationsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public P2pNetworkNotificationClient client;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private P2pSocketManagerStartNetworkNotificationsParams(int version) {
      super(16, version);
    }

    public P2pSocketManagerStartNetworkNotificationsParams() {
      this(0);
    }

    public static P2pSocketManagerStartNetworkNotificationsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static P2pSocketManagerStartNetworkNotificationsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static P2pSocketManagerStartNetworkNotificationsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        P2pSocketManagerStartNetworkNotificationsParams result =
            new P2pSocketManagerStartNetworkNotificationsParams(elementsOrVersion);
        result.client =
            (P2pNetworkNotificationClient)
                decoder0.readServiceInterface(8, false, P2pNetworkNotificationClient.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.client, 8, false, P2pNetworkNotificationClient.MANAGER);
    }
  }

  static final class P2pSocketManagerGetHostAddressParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean enableMdns;
    public String hostName;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private P2pSocketManagerGetHostAddressParams(int version) {
      super(24, version);
    }

    public P2pSocketManagerGetHostAddressParams() {
      this(0);
    }

    public static P2pSocketManagerGetHostAddressParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static P2pSocketManagerGetHostAddressParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static P2pSocketManagerGetHostAddressParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        P2pSocketManagerGetHostAddressParams result =
            new P2pSocketManagerGetHostAddressParams(elementsOrVersion);
        result.hostName = decoder0.readString(8, false);
        result.enableMdns = decoder0.readBoolean(16, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.hostName, 8, false);
      encoder0.encode(this.enableMdns, 16, 0);
    }
  }

  static final class P2pSocketManagerGetHostAddressResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public IpAddress[] addresses;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private P2pSocketManagerGetHostAddressResponseParams(int version) {
      super(16, version);
    }

    public P2pSocketManagerGetHostAddressResponseParams() {
      this(0);
    }

    public static P2pSocketManagerGetHostAddressResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static P2pSocketManagerGetHostAddressResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static P2pSocketManagerGetHostAddressResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        P2pSocketManagerGetHostAddressResponseParams result =
            new P2pSocketManagerGetHostAddressResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.addresses = new IpAddress[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.addresses[i1] = IpAddress.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      IpAddress[] ipAddressArr = this.addresses;
      if (ipAddressArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(ipAddressArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        IpAddress[] ipAddressArr2 = this.addresses;
        if (i0 < ipAddressArr2.length) {
          encoder1.encode((Struct) ipAddressArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static class P2pSocketManagerGetHostAddressResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final P2pSocketManager.GetHostAddress_Response mCallback;

    P2pSocketManagerGetHostAddressResponseParamsForwardToCallback(
        P2pSocketManager.GetHostAddress_Response callback) {
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
        P2pSocketManagerGetHostAddressResponseParams response =
            P2pSocketManagerGetHostAddressResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.addresses);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class P2pSocketManagerGetHostAddressResponseParamsProxyToResponder
      implements P2pSocketManager.GetHostAddress_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    P2pSocketManagerGetHostAddressResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(IpAddress[] addresses) {
      P2pSocketManagerGetHostAddressResponseParams _response =
          new P2pSocketManagerGetHostAddressResponseParams();
      _response.addresses = addresses;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class P2pSocketManagerGetHostAddressWithFamilyParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int addressFamily;
    public boolean enableMdns;
    public String hostName;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private P2pSocketManagerGetHostAddressWithFamilyParams(int version) {
      super(24, version);
    }

    public P2pSocketManagerGetHostAddressWithFamilyParams() {
      this(0);
    }

    public static P2pSocketManagerGetHostAddressWithFamilyParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static P2pSocketManagerGetHostAddressWithFamilyParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static P2pSocketManagerGetHostAddressWithFamilyParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        P2pSocketManagerGetHostAddressWithFamilyParams result =
            new P2pSocketManagerGetHostAddressWithFamilyParams(elementsOrVersion);
        result.hostName = decoder0.readString(8, false);
        result.addressFamily = decoder0.readInt(16);
        result.enableMdns = decoder0.readBoolean(20, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.hostName, 8, false);
      encoder0.encode(this.addressFamily, 16);
      encoder0.encode(this.enableMdns, 20, 0);
    }
  }

  static final class P2pSocketManagerGetHostAddressWithFamilyResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public IpAddress[] addresses;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private P2pSocketManagerGetHostAddressWithFamilyResponseParams(int version) {
      super(16, version);
    }

    public P2pSocketManagerGetHostAddressWithFamilyResponseParams() {
      this(0);
    }

    public static P2pSocketManagerGetHostAddressWithFamilyResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static P2pSocketManagerGetHostAddressWithFamilyResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static P2pSocketManagerGetHostAddressWithFamilyResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        P2pSocketManagerGetHostAddressWithFamilyResponseParams result =
            new P2pSocketManagerGetHostAddressWithFamilyResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.addresses = new IpAddress[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.addresses[i1] = IpAddress.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      IpAddress[] ipAddressArr = this.addresses;
      if (ipAddressArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(ipAddressArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        IpAddress[] ipAddressArr2 = this.addresses;
        if (i0 < ipAddressArr2.length) {
          encoder1.encode((Struct) ipAddressArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static class P2pSocketManagerGetHostAddressWithFamilyResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final P2pSocketManager.GetHostAddressWithFamily_Response mCallback;

    P2pSocketManagerGetHostAddressWithFamilyResponseParamsForwardToCallback(
        P2pSocketManager.GetHostAddressWithFamily_Response callback) {
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
        P2pSocketManagerGetHostAddressWithFamilyResponseParams response =
            P2pSocketManagerGetHostAddressWithFamilyResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.addresses);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class P2pSocketManagerGetHostAddressWithFamilyResponseParamsProxyToResponder
      implements P2pSocketManager.GetHostAddressWithFamily_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    P2pSocketManagerGetHostAddressWithFamilyResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(IpAddress[] addresses) {
      P2pSocketManagerGetHostAddressWithFamilyResponseParams _response =
          new P2pSocketManagerGetHostAddressWithFamilyResponseParams();
      _response.addresses = addresses;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class P2pSocketManagerCreateSocketParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 64;
    private static final DataHeader[] VERSION_ARRAY;
    public P2pSocketClient client;
    public UnguessableToken devtoolsToken;
    public IpEndPoint localAddress;
    public P2pPortRange portRange;
    public P2pHostAndIpEndPoint remoteAddress;
    public InterfaceRequest<P2pSocket> socket;
    public MutableNetworkTrafficAnnotationTag trafficAnnotation;
    public int type;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(64, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private P2pSocketManagerCreateSocketParams(int version) {
      super(64, version);
    }

    public P2pSocketManagerCreateSocketParams() {
      this(0);
    }

    public static P2pSocketManagerCreateSocketParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static P2pSocketManagerCreateSocketParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static P2pSocketManagerCreateSocketParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        P2pSocketManagerCreateSocketParams result =
            new P2pSocketManagerCreateSocketParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.type = readInt;
        P2pSocketType.validate(readInt);
        result.type = P2pSocketType.toKnownValue(result.type);
        result.socket = decoder0.readInterfaceRequest(12, false);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.localAddress = IpEndPoint.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(24, false);
        result.portRange = P2pPortRange.decode(decoder12);
        Decoder decoder13 = decoder0.readPointer(32, false);
        result.remoteAddress = P2pHostAndIpEndPoint.decode(decoder13);
        Decoder decoder14 = decoder0.readPointer(40, false);
        result.trafficAnnotation = MutableNetworkTrafficAnnotationTag.decode(decoder14);
        Decoder decoder15 = decoder0.readPointer(48, true);
        result.devtoolsToken = UnguessableToken.decode(decoder15);
        result.client =
            (P2pSocketClient) decoder0.readServiceInterface(56, false, P2pSocketClient.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.type, 8);
      encoder0.encode((InterfaceRequest) this.socket, 12, false);
      encoder0.encode((Struct) this.localAddress, 16, false);
      encoder0.encode((Struct) this.portRange, 24, false);
      encoder0.encode((Struct) this.remoteAddress, 32, false);
      encoder0.encode((Struct) this.trafficAnnotation, 40, false);
      encoder0.encode((Struct) this.devtoolsToken, 48, true);
      encoder0.encode(this.client, 56, false, P2pSocketClient.MANAGER);
    }
  }
}
