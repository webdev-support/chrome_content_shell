package org.chromium.device.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
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

class HidManager_Internal {
  private static final int ADD_RECEIVER_ORDINAL = 3;
  private static final int CONNECT_ORDINAL = 2;
  private static final int GET_DEVICES_AND_SET_CLIENT_ORDINAL = 0;
  private static final int GET_DEVICES_ORDINAL = 1;
  public static final Interface.Manager<HidManager, HidManager.Proxy> MANAGER =
      new Interface.Manager<HidManager, HidManager.Proxy>() {
        @Override
        public String getName() {
          return "device.mojom.HidManager";
        }

        @Override
        public int getVersion() {
          return 2;
        }

        @Override
        public HidManager.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, HidManager impl) {
          return new Stub(core, impl);
        }

        @Override
        public HidManager[] buildArray(int size) {
          return new HidManager[size];
        }
      };

  HidManager_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements HidManager.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void getDevicesAndSetClient(
        AssociatedInterfaceNotSupported client, GetDevicesAndSetClient_Response callback) {
      HidManagerGetDevicesAndSetClientParams _message =
          new HidManagerGetDevicesAndSetClientParams();
      _message.client = client;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new HidManagerGetDevicesAndSetClientResponseParamsForwardToCallback(callback));
    }

    @Override
    public void getDevices(GetDevices_Response callback) {
      HidManagerGetDevicesParams _message = new HidManagerGetDevicesParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new HidManagerGetDevicesResponseParamsForwardToCallback(callback));
    }

    @Override
    public void connect(
        String deviceGuid,
        HidConnectionClient connectionClient,
        HidConnectionWatcher watcher,
        boolean allowProtectedReports,
        boolean allowFidoReports,
        Connect_Response callback) {
      HidManagerConnectParams _message = new HidManagerConnectParams();
      _message.deviceGuid = deviceGuid;
      _message.connectionClient = connectionClient;
      _message.watcher = watcher;
      _message.allowProtectedReports = allowProtectedReports;
      _message.allowFidoReports = allowFidoReports;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new HidManagerConnectResponseParamsForwardToCallback(callback));
    }

    @Override
    public void addReceiver(InterfaceRequest<HidManager> receiver) {
      HidManagerAddReceiverParams _message = new HidManagerAddReceiverParams();
      _message.receiver = receiver;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }
  }

  public static final class Stub extends Interface.Stub<HidManager> {
    Stub(Core core, HidManager impl) {
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
                HidManager_Internal.MANAGER, messageWithHeader);
          case 3:
            HidManagerAddReceiverParams data =
                HidManagerAddReceiverParams.deserialize(messageWithHeader.getPayload());
            getImpl().addReceiver(data.receiver);
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
                getCore(), HidManager_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            getImpl()
                .getDevicesAndSetClient(
                    HidManagerGetDevicesAndSetClientParams.deserialize(
                            messageWithHeader.getPayload())
                        .client,
                    new HidManagerGetDevicesAndSetClientResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
            HidManagerGetDevicesParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .getDevices(
                    new HidManagerGetDevicesResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 2:
            HidManagerConnectParams data =
                HidManagerConnectParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .connect(
                    data.deviceGuid,
                    data.connectionClient,
                    data.watcher,
                    data.allowProtectedReports,
                    data.allowFidoReports,
                    new HidManagerConnectResponseParamsProxyToResponder(
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

  static final class HidManagerGetDevicesAndSetClientParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public AssociatedInterfaceNotSupported client;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private HidManagerGetDevicesAndSetClientParams(int version) {
      super(16, version);
    }

    public HidManagerGetDevicesAndSetClientParams() {
      this(0);
    }

    public static HidManagerGetDevicesAndSetClientParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static HidManagerGetDevicesAndSetClientParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static HidManagerGetDevicesAndSetClientParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        HidManagerGetDevicesAndSetClientParams result =
            new HidManagerGetDevicesAndSetClientParams(elementsOrVersion);
        result.client = decoder0.readAssociatedServiceInterfaceNotSupported(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.client, 8, false);
    }
  }

  static final class HidManagerGetDevicesAndSetClientResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public HidDeviceInfo[] devices;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private HidManagerGetDevicesAndSetClientResponseParams(int version) {
      super(16, version);
    }

    public HidManagerGetDevicesAndSetClientResponseParams() {
      this(0);
    }

    public static HidManagerGetDevicesAndSetClientResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static HidManagerGetDevicesAndSetClientResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static HidManagerGetDevicesAndSetClientResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        HidManagerGetDevicesAndSetClientResponseParams result =
            new HidManagerGetDevicesAndSetClientResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.devices = new HidDeviceInfo[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.devices[i1] = HidDeviceInfo.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      HidDeviceInfo[] hidDeviceInfoArr = this.devices;
      if (hidDeviceInfoArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(hidDeviceInfoArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        HidDeviceInfo[] hidDeviceInfoArr2 = this.devices;
        if (i0 < hidDeviceInfoArr2.length) {
          encoder1.encode((Struct) hidDeviceInfoArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static class HidManagerGetDevicesAndSetClientResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final HidManager.GetDevicesAndSetClient_Response mCallback;

    HidManagerGetDevicesAndSetClientResponseParamsForwardToCallback(
        HidManager.GetDevicesAndSetClient_Response callback) {
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
        HidManagerGetDevicesAndSetClientResponseParams response =
            HidManagerGetDevicesAndSetClientResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.devices);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class HidManagerGetDevicesAndSetClientResponseParamsProxyToResponder
      implements HidManager.GetDevicesAndSetClient_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    HidManagerGetDevicesAndSetClientResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(HidDeviceInfo[] devices) {
      HidManagerGetDevicesAndSetClientResponseParams _response =
          new HidManagerGetDevicesAndSetClientResponseParams();
      _response.devices = devices;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class HidManagerGetDevicesParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private HidManagerGetDevicesParams(int version) {
      super(8, version);
    }

    public HidManagerGetDevicesParams() {
      this(0);
    }

    public static HidManagerGetDevicesParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static HidManagerGetDevicesParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static HidManagerGetDevicesParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        HidManagerGetDevicesParams result = new HidManagerGetDevicesParams(elementsOrVersion);
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

  static final class HidManagerGetDevicesResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public HidDeviceInfo[] devices;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private HidManagerGetDevicesResponseParams(int version) {
      super(16, version);
    }

    public HidManagerGetDevicesResponseParams() {
      this(0);
    }

    public static HidManagerGetDevicesResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static HidManagerGetDevicesResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static HidManagerGetDevicesResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        HidManagerGetDevicesResponseParams result =
            new HidManagerGetDevicesResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.devices = new HidDeviceInfo[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.devices[i1] = HidDeviceInfo.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      HidDeviceInfo[] hidDeviceInfoArr = this.devices;
      if (hidDeviceInfoArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(hidDeviceInfoArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        HidDeviceInfo[] hidDeviceInfoArr2 = this.devices;
        if (i0 < hidDeviceInfoArr2.length) {
          encoder1.encode((Struct) hidDeviceInfoArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static class HidManagerGetDevicesResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final HidManager.GetDevices_Response mCallback;

    HidManagerGetDevicesResponseParamsForwardToCallback(HidManager.GetDevices_Response callback) {
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
        HidManagerGetDevicesResponseParams response =
            HidManagerGetDevicesResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.devices);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class HidManagerGetDevicesResponseParamsProxyToResponder
      implements HidManager.GetDevices_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    HidManagerGetDevicesResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(HidDeviceInfo[] devices) {
      HidManagerGetDevicesResponseParams _response = new HidManagerGetDevicesResponseParams();
      _response.devices = devices;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class HidManagerConnectParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean allowFidoReports;
    public boolean allowProtectedReports;
    public HidConnectionClient connectionClient;
    public String deviceGuid;
    public HidConnectionWatcher watcher;

    static {
      DataHeader[] dataHeaderArr = {
        new DataHeader(32, 0), new DataHeader(40, 1), new DataHeader(40, 2)
      };
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[2];
    }

    private HidManagerConnectParams(int version) {
      super(40, version);
    }

    public HidManagerConnectParams() {
      this(2);
    }

    public static HidManagerConnectParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static HidManagerConnectParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static HidManagerConnectParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        HidManagerConnectParams result = new HidManagerConnectParams(elementsOrVersion);
        result.deviceGuid = decoder0.readString(8, false);
        result.connectionClient =
            (HidConnectionClient)
                decoder0.readServiceInterface(16, true, HidConnectionClient.MANAGER);
        result.watcher =
            (HidConnectionWatcher)
                decoder0.readServiceInterface(24, true, HidConnectionWatcher.MANAGER);
        if (elementsOrVersion >= 1) {
          result.allowProtectedReports = decoder0.readBoolean(32, 0);
        }
        if (elementsOrVersion >= 2) {
          result.allowFidoReports = decoder0.readBoolean(32, 1);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.deviceGuid, 8, false);
      encoder0.encode(this.connectionClient, 16, true, HidConnectionClient.MANAGER);
      encoder0.encode(this.watcher, 24, true, HidConnectionWatcher.MANAGER);
      encoder0.encode(this.allowProtectedReports, 32, 0);
      encoder0.encode(this.allowFidoReports, 32, 1);
    }
  }

  static final class HidManagerConnectResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public HidConnection connection;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private HidManagerConnectResponseParams(int version) {
      super(16, version);
    }

    public HidManagerConnectResponseParams() {
      this(0);
    }

    public static HidManagerConnectResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static HidManagerConnectResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static HidManagerConnectResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        HidManagerConnectResponseParams result =
            new HidManagerConnectResponseParams(elementsOrVersion);
        result.connection =
            (HidConnection) decoder0.readServiceInterface(8, true, HidConnection.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.connection, 8, true, HidConnection.MANAGER);
    }
  }

  static class HidManagerConnectResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final HidManager.Connect_Response mCallback;

    HidManagerConnectResponseParamsForwardToCallback(HidManager.Connect_Response callback) {
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
        HidManagerConnectResponseParams response =
            HidManagerConnectResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.connection);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class HidManagerConnectResponseParamsProxyToResponder
      implements HidManager.Connect_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    HidManagerConnectResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(HidConnection connection) {
      HidManagerConnectResponseParams _response = new HidManagerConnectResponseParams();
      _response.connection = connection;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class HidManagerAddReceiverParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<HidManager> receiver;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private HidManagerAddReceiverParams(int version) {
      super(16, version);
    }

    public HidManagerAddReceiverParams() {
      this(0);
    }

    public static HidManagerAddReceiverParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static HidManagerAddReceiverParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static HidManagerAddReceiverParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        HidManagerAddReceiverParams result = new HidManagerAddReceiverParams(elementsOrVersion);
        result.receiver = decoder0.readInterfaceRequest(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.receiver, 8, false);
    }
  }
}
