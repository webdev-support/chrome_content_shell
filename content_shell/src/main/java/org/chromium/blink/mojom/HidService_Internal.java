package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.device.mojom.HidConnection;
import org.chromium.device.mojom.HidConnectionClient;
import org.chromium.device.mojom.HidDeviceInfo;
import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
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

class HidService_Internal {
  private static final int CONNECT_ORDINAL = 3;
  private static final int FORGET_ORDINAL = 4;
  private static final int GET_DEVICES_ORDINAL = 1;
  public static final Interface.Manager<HidService, HidService.Proxy> MANAGER =
      new Interface.Manager<HidService, HidService.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.HidService";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public HidService.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, HidService impl) {
          return new Stub(core, impl);
        }

        @Override
        public HidService[] buildArray(int size) {
          return new HidService[size];
        }
      };
  private static final int REGISTER_CLIENT_ORDINAL = 0;
  private static final int REQUEST_DEVICE_ORDINAL = 2;

  HidService_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements HidService.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void registerClient(AssociatedInterfaceNotSupported client) {
      HidServiceRegisterClientParams _message = new HidServiceRegisterClientParams();
      _message.client = client;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void getDevices(GetDevices_Response callback) {
      HidServiceGetDevicesParams _message = new HidServiceGetDevicesParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new HidServiceGetDevicesResponseParamsForwardToCallback(callback));
    }

    @Override
    public void requestDevice(
        HidDeviceFilter[] filters,
        HidDeviceFilter[] exclusionFilters,
        RequestDevice_Response callback) {
      HidServiceRequestDeviceParams _message = new HidServiceRequestDeviceParams();
      _message.filters = filters;
      _message.exclusionFilters = exclusionFilters;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new HidServiceRequestDeviceResponseParamsForwardToCallback(callback));
    }

    @Override
    public void connect(String deviceGuid, HidConnectionClient client, Connect_Response callback) {
      HidServiceConnectParams _message = new HidServiceConnectParams();
      _message.deviceGuid = deviceGuid;
      _message.client = client;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)),
              new HidServiceConnectResponseParamsForwardToCallback(callback));
    }

    @Override
    public void forget(HidDeviceInfo deviceInfo, Forget_Response callback) {
      HidServiceForgetParams _message = new HidServiceForgetParams();
      _message.deviceInfo = deviceInfo;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)),
              new HidServiceForgetResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<HidService> {
    Stub(Core core, HidService impl) {
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
                HidService_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            HidServiceRegisterClientParams data =
                HidServiceRegisterClientParams.deserialize(messageWithHeader.getPayload());
            getImpl().registerClient(data.client);
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
                getCore(), HidService_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
          default:
            return false;
          case 1:
            HidServiceGetDevicesParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .getDevices(
                    new HidServiceGetDevicesResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 2:
            HidServiceRequestDeviceParams data =
                HidServiceRequestDeviceParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .requestDevice(
                    data.filters,
                    data.exclusionFilters,
                    new HidServiceRequestDeviceResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 3:
            HidServiceConnectParams data2 =
                HidServiceConnectParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .connect(
                    data2.deviceGuid,
                    data2.client,
                    new HidServiceConnectResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 4:
            getImpl()
                .forget(
                    HidServiceForgetParams.deserialize(messageWithHeader.getPayload()).deviceInfo,
                    new HidServiceForgetResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class HidServiceRegisterClientParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public AssociatedInterfaceNotSupported client;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private HidServiceRegisterClientParams(int version) {
      super(16, version);
    }

    public HidServiceRegisterClientParams() {
      this(0);
    }

    public static HidServiceRegisterClientParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static HidServiceRegisterClientParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static HidServiceRegisterClientParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        HidServiceRegisterClientParams result =
            new HidServiceRegisterClientParams(elementsOrVersion);
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

  static final class HidServiceGetDevicesParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private HidServiceGetDevicesParams(int version) {
      super(8, version);
    }

    public HidServiceGetDevicesParams() {
      this(0);
    }

    public static HidServiceGetDevicesParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static HidServiceGetDevicesParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static HidServiceGetDevicesParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        HidServiceGetDevicesParams result = new HidServiceGetDevicesParams(elementsOrVersion);
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

  static final class HidServiceGetDevicesResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public HidDeviceInfo[] devices;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private HidServiceGetDevicesResponseParams(int version) {
      super(16, version);
    }

    public HidServiceGetDevicesResponseParams() {
      this(0);
    }

    public static HidServiceGetDevicesResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static HidServiceGetDevicesResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static HidServiceGetDevicesResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        HidServiceGetDevicesResponseParams result =
            new HidServiceGetDevicesResponseParams(elementsOrVersion);
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

  static class HidServiceGetDevicesResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final HidService.GetDevices_Response mCallback;

    HidServiceGetDevicesResponseParamsForwardToCallback(HidService.GetDevices_Response callback) {
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
        HidServiceGetDevicesResponseParams response =
            HidServiceGetDevicesResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.devices);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class HidServiceGetDevicesResponseParamsProxyToResponder
      implements HidService.GetDevices_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    HidServiceGetDevicesResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(HidDeviceInfo[] devices) {
      HidServiceGetDevicesResponseParams _response = new HidServiceGetDevicesResponseParams();
      _response.devices = devices;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class HidServiceRequestDeviceParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public HidDeviceFilter[] exclusionFilters;
    public HidDeviceFilter[] filters;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private HidServiceRequestDeviceParams(int version) {
      super(24, version);
    }

    public HidServiceRequestDeviceParams() {
      this(0);
    }

    public static HidServiceRequestDeviceParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static HidServiceRequestDeviceParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static HidServiceRequestDeviceParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        HidServiceRequestDeviceParams result = new HidServiceRequestDeviceParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.filters = new HidDeviceFilter[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.filters[i1] = HidDeviceFilter.decode(decoder2);
        }
        Decoder decoder12 = decoder0.readPointer(16, false);
        DataHeader si12 = decoder12.readDataHeaderForPointerArray(-1);
        result.exclusionFilters = new HidDeviceFilter[si12.elementsOrVersion];
        for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
          Decoder decoder22 = decoder12.readPointer((i12 * 8) + 8, false);
          result.exclusionFilters[i12] = HidDeviceFilter.decode(decoder22);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      HidDeviceFilter[] hidDeviceFilterArr = this.filters;
      if (hidDeviceFilterArr == null) {
        encoder0.encodeNullPointer(8, false);
      } else {
        Encoder encoder1 = encoder0.encodePointerArray(hidDeviceFilterArr.length, 8, -1);
        int i0 = 0;
        while (true) {
          HidDeviceFilter[] hidDeviceFilterArr2 = this.filters;
          if (i0 >= hidDeviceFilterArr2.length) {
            break;
          }
          encoder1.encode((Struct) hidDeviceFilterArr2[i0], (i0 * 8) + 8, false);
          i0++;
        }
      }
      HidDeviceFilter[] hidDeviceFilterArr3 = this.exclusionFilters;
      if (hidDeviceFilterArr3 == null) {
        encoder0.encodeNullPointer(16, false);
        return;
      }
      Encoder encoder12 = encoder0.encodePointerArray(hidDeviceFilterArr3.length, 16, -1);
      int i02 = 0;
      while (true) {
        HidDeviceFilter[] hidDeviceFilterArr4 = this.exclusionFilters;
        if (i02 < hidDeviceFilterArr4.length) {
          encoder12.encode((Struct) hidDeviceFilterArr4[i02], (i02 * 8) + 8, false);
          i02++;
        } else {
          return;
        }
      }
    }
  }

  static final class HidServiceRequestDeviceResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public HidDeviceInfo[] devices;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private HidServiceRequestDeviceResponseParams(int version) {
      super(16, version);
    }

    public HidServiceRequestDeviceResponseParams() {
      this(0);
    }

    public static HidServiceRequestDeviceResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static HidServiceRequestDeviceResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static HidServiceRequestDeviceResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        HidServiceRequestDeviceResponseParams result =
            new HidServiceRequestDeviceResponseParams(elementsOrVersion);
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

  static class HidServiceRequestDeviceResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final HidService.RequestDevice_Response mCallback;

    HidServiceRequestDeviceResponseParamsForwardToCallback(
        HidService.RequestDevice_Response callback) {
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
        HidServiceRequestDeviceResponseParams response =
            HidServiceRequestDeviceResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.devices);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class HidServiceRequestDeviceResponseParamsProxyToResponder
      implements HidService.RequestDevice_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    HidServiceRequestDeviceResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(HidDeviceInfo[] devices) {
      HidServiceRequestDeviceResponseParams _response = new HidServiceRequestDeviceResponseParams();
      _response.devices = devices;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class HidServiceConnectParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public HidConnectionClient client;
    public String deviceGuid;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private HidServiceConnectParams(int version) {
      super(24, version);
    }

    public HidServiceConnectParams() {
      this(0);
    }

    public static HidServiceConnectParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static HidServiceConnectParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static HidServiceConnectParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        HidServiceConnectParams result = new HidServiceConnectParams(elementsOrVersion);
        result.deviceGuid = decoder0.readString(8, false);
        result.client =
            (HidConnectionClient)
                decoder0.readServiceInterface(16, false, HidConnectionClient.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.deviceGuid, 8, false);
      encoder0.encode(this.client, 16, false, HidConnectionClient.MANAGER);
    }
  }

  static final class HidServiceConnectResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public HidConnection connection;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private HidServiceConnectResponseParams(int version) {
      super(16, version);
    }

    public HidServiceConnectResponseParams() {
      this(0);
    }

    public static HidServiceConnectResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static HidServiceConnectResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static HidServiceConnectResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        HidServiceConnectResponseParams result =
            new HidServiceConnectResponseParams(elementsOrVersion);
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

  static class HidServiceConnectResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final HidService.Connect_Response mCallback;

    HidServiceConnectResponseParamsForwardToCallback(HidService.Connect_Response callback) {
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
        HidServiceConnectResponseParams response =
            HidServiceConnectResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.connection);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class HidServiceConnectResponseParamsProxyToResponder
      implements HidService.Connect_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    HidServiceConnectResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(HidConnection connection) {
      HidServiceConnectResponseParams _response = new HidServiceConnectResponseParams();
      _response.connection = connection;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class HidServiceForgetParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public HidDeviceInfo deviceInfo;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private HidServiceForgetParams(int version) {
      super(16, version);
    }

    public HidServiceForgetParams() {
      this(0);
    }

    public static HidServiceForgetParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static HidServiceForgetParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static HidServiceForgetParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        HidServiceForgetParams result = new HidServiceForgetParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.deviceInfo = HidDeviceInfo.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.deviceInfo, 8, false);
    }
  }

  static final class HidServiceForgetResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private HidServiceForgetResponseParams(int version) {
      super(8, version);
    }

    public HidServiceForgetResponseParams() {
      this(0);
    }

    public static HidServiceForgetResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static HidServiceForgetResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static HidServiceForgetResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        HidServiceForgetResponseParams result =
            new HidServiceForgetResponseParams(elementsOrVersion);
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

  static class HidServiceForgetResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final HidService.Forget_Response mCallback;

    HidServiceForgetResponseParamsForwardToCallback(HidService.Forget_Response callback) {
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
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class HidServiceForgetResponseParamsProxyToResponder
      implements HidService.Forget_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    HidServiceForgetResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      HidServiceForgetResponseParams _response = new HidServiceForgetResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
