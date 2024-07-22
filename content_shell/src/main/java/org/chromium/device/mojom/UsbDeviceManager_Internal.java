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

class UsbDeviceManager_Internal {
  private static final int ENUMERATE_DEVICES_AND_SET_CLIENT_ORDINAL = 0;
  private static final int GET_DEVICES_ORDINAL = 1;
  private static final int GET_DEVICE_ORDINAL = 2;
  private static final int GET_SECURITY_KEY_DEVICE_ORDINAL = 3;
  public static final Interface.Manager<UsbDeviceManager, UsbDeviceManager.Proxy> MANAGER =
      new Interface.Manager<UsbDeviceManager, UsbDeviceManager.Proxy>() {
        @Override
        public String getName() {
          return "device.mojom.UsbDeviceManager";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public UsbDeviceManager.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, UsbDeviceManager impl) {
          return new Stub(core, impl);
        }

        @Override
        public UsbDeviceManager[] buildArray(int size) {
          return new UsbDeviceManager[size];
        }
      };
  private static final int REFRESH_DEVICE_INFO_ORDINAL = 4;
  private static final int SET_CLIENT_ORDINAL = 5;

  UsbDeviceManager_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements UsbDeviceManager.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void enumerateDevicesAndSetClient(
        AssociatedInterfaceNotSupported client, EnumerateDevicesAndSetClient_Response callback) {
      UsbDeviceManagerEnumerateDevicesAndSetClientParams _message =
          new UsbDeviceManagerEnumerateDevicesAndSetClientParams();
      _message.client = client;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new UsbDeviceManagerEnumerateDevicesAndSetClientResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void getDevices(UsbEnumerationOptions options, GetDevices_Response callback) {
      UsbDeviceManagerGetDevicesParams _message = new UsbDeviceManagerGetDevicesParams();
      _message.options = options;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new UsbDeviceManagerGetDevicesResponseParamsForwardToCallback(callback));
    }

    @Override
    public void getDevice(
        String guid,
        byte[] blockedInterfaceClasses,
        InterfaceRequest<UsbDevice> deviceReceiver,
        UsbDeviceClient deviceClient) {
      UsbDeviceManagerGetDeviceParams _message = new UsbDeviceManagerGetDeviceParams();
      _message.guid = guid;
      _message.blockedInterfaceClasses = blockedInterfaceClasses;
      _message.deviceReceiver = deviceReceiver;
      _message.deviceClient = deviceClient;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void getSecurityKeyDevice(
        String guid, InterfaceRequest<UsbDevice> deviceReceiver, UsbDeviceClient deviceClient) {
      UsbDeviceManagerGetSecurityKeyDeviceParams _message =
          new UsbDeviceManagerGetSecurityKeyDeviceParams();
      _message.guid = guid;
      _message.deviceReceiver = deviceReceiver;
      _message.deviceClient = deviceClient;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }

    @Override
    public void refreshDeviceInfo(String guid, RefreshDeviceInfo_Response callback) {
      UsbDeviceManagerRefreshDeviceInfoParams _message =
          new UsbDeviceManagerRefreshDeviceInfoParams();
      _message.guid = guid;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)),
              new UsbDeviceManagerRefreshDeviceInfoResponseParamsForwardToCallback(callback));
    }

    @Override
    public void setClient(AssociatedInterfaceNotSupported client) {
      UsbDeviceManagerSetClientParams _message = new UsbDeviceManagerSetClientParams();
      _message.client = client;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5)));
    }
  }

  public static final class Stub extends Interface.Stub<UsbDeviceManager> {
    Stub(Core core, UsbDeviceManager impl) {
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
                UsbDeviceManager_Internal.MANAGER, messageWithHeader);
          case 2:
            UsbDeviceManagerGetDeviceParams data =
                UsbDeviceManagerGetDeviceParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .getDevice(
                    data.guid,
                    data.blockedInterfaceClasses,
                    data.deviceReceiver,
                    data.deviceClient);
            return true;
          case 3:
            UsbDeviceManagerGetSecurityKeyDeviceParams data2 =
                UsbDeviceManagerGetSecurityKeyDeviceParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().getSecurityKeyDevice(data2.guid, data2.deviceReceiver, data2.deviceClient);
            return true;
          case 5:
            getImpl()
                .setClient(
                    UsbDeviceManagerSetClientParams.deserialize(messageWithHeader.getPayload())
                        .client);
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
                getCore(), UsbDeviceManager_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            UsbDeviceManagerEnumerateDevicesAndSetClientParams data =
                UsbDeviceManagerEnumerateDevicesAndSetClientParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .enumerateDevicesAndSetClient(
                    data.client,
                    new UsbDeviceManagerEnumerateDevicesAndSetClientResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
            UsbDeviceManagerGetDevicesParams data2 =
                UsbDeviceManagerGetDevicesParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .getDevices(
                    data2.options,
                    new UsbDeviceManagerGetDevicesResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 2:
          case 3:
          default:
            return false;
          case 4:
            UsbDeviceManagerRefreshDeviceInfoParams data3 =
                UsbDeviceManagerRefreshDeviceInfoParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .refreshDeviceInfo(
                    data3.guid,
                    new UsbDeviceManagerRefreshDeviceInfoResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class UsbDeviceManagerEnumerateDevicesAndSetClientParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public AssociatedInterfaceNotSupported client;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private UsbDeviceManagerEnumerateDevicesAndSetClientParams(int version) {
      super(16, version);
    }

    public UsbDeviceManagerEnumerateDevicesAndSetClientParams() {
      this(0);
    }

    public static UsbDeviceManagerEnumerateDevicesAndSetClientParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static UsbDeviceManagerEnumerateDevicesAndSetClientParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static UsbDeviceManagerEnumerateDevicesAndSetClientParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        UsbDeviceManagerEnumerateDevicesAndSetClientParams result =
            new UsbDeviceManagerEnumerateDevicesAndSetClientParams(elementsOrVersion);
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

  static final class UsbDeviceManagerEnumerateDevicesAndSetClientResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public UsbDeviceInfo[] results;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private UsbDeviceManagerEnumerateDevicesAndSetClientResponseParams(int version) {
      super(16, version);
    }

    public UsbDeviceManagerEnumerateDevicesAndSetClientResponseParams() {
      this(0);
    }

    public static UsbDeviceManagerEnumerateDevicesAndSetClientResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static UsbDeviceManagerEnumerateDevicesAndSetClientResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static UsbDeviceManagerEnumerateDevicesAndSetClientResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        UsbDeviceManagerEnumerateDevicesAndSetClientResponseParams result =
            new UsbDeviceManagerEnumerateDevicesAndSetClientResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.results = new UsbDeviceInfo[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.results[i1] = UsbDeviceInfo.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      UsbDeviceInfo[] usbDeviceInfoArr = this.results;
      if (usbDeviceInfoArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(usbDeviceInfoArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        UsbDeviceInfo[] usbDeviceInfoArr2 = this.results;
        if (i0 < usbDeviceInfoArr2.length) {
          encoder1.encode((Struct) usbDeviceInfoArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static class UsbDeviceManagerEnumerateDevicesAndSetClientResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final UsbDeviceManager.EnumerateDevicesAndSetClient_Response mCallback;

    UsbDeviceManagerEnumerateDevicesAndSetClientResponseParamsForwardToCallback(
        UsbDeviceManager.EnumerateDevicesAndSetClient_Response callback) {
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
        UsbDeviceManagerEnumerateDevicesAndSetClientResponseParams response =
            UsbDeviceManagerEnumerateDevicesAndSetClientResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.results);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class UsbDeviceManagerEnumerateDevicesAndSetClientResponseParamsProxyToResponder
      implements UsbDeviceManager.EnumerateDevicesAndSetClient_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    UsbDeviceManagerEnumerateDevicesAndSetClientResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(UsbDeviceInfo[] results) {
      UsbDeviceManagerEnumerateDevicesAndSetClientResponseParams _response =
          new UsbDeviceManagerEnumerateDevicesAndSetClientResponseParams();
      _response.results = results;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class UsbDeviceManagerGetDevicesParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public UsbEnumerationOptions options;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private UsbDeviceManagerGetDevicesParams(int version) {
      super(16, version);
    }

    public UsbDeviceManagerGetDevicesParams() {
      this(0);
    }

    public static UsbDeviceManagerGetDevicesParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static UsbDeviceManagerGetDevicesParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static UsbDeviceManagerGetDevicesParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        UsbDeviceManagerGetDevicesParams result =
            new UsbDeviceManagerGetDevicesParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.options = UsbEnumerationOptions.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.options, 8, true);
    }
  }

  static final class UsbDeviceManagerGetDevicesResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public UsbDeviceInfo[] results;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private UsbDeviceManagerGetDevicesResponseParams(int version) {
      super(16, version);
    }

    public UsbDeviceManagerGetDevicesResponseParams() {
      this(0);
    }

    public static UsbDeviceManagerGetDevicesResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static UsbDeviceManagerGetDevicesResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static UsbDeviceManagerGetDevicesResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        UsbDeviceManagerGetDevicesResponseParams result =
            new UsbDeviceManagerGetDevicesResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.results = new UsbDeviceInfo[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.results[i1] = UsbDeviceInfo.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      UsbDeviceInfo[] usbDeviceInfoArr = this.results;
      if (usbDeviceInfoArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(usbDeviceInfoArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        UsbDeviceInfo[] usbDeviceInfoArr2 = this.results;
        if (i0 < usbDeviceInfoArr2.length) {
          encoder1.encode((Struct) usbDeviceInfoArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static class UsbDeviceManagerGetDevicesResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final UsbDeviceManager.GetDevices_Response mCallback;

    UsbDeviceManagerGetDevicesResponseParamsForwardToCallback(
        UsbDeviceManager.GetDevices_Response callback) {
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
        UsbDeviceManagerGetDevicesResponseParams response =
            UsbDeviceManagerGetDevicesResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.results);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class UsbDeviceManagerGetDevicesResponseParamsProxyToResponder
      implements UsbDeviceManager.GetDevices_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    UsbDeviceManagerGetDevicesResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(UsbDeviceInfo[] results) {
      UsbDeviceManagerGetDevicesResponseParams _response =
          new UsbDeviceManagerGetDevicesResponseParams();
      _response.results = results;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class UsbDeviceManagerGetDeviceParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public byte[] blockedInterfaceClasses;
    public UsbDeviceClient deviceClient;
    public InterfaceRequest<UsbDevice> deviceReceiver;
    public String guid;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private UsbDeviceManagerGetDeviceParams(int version) {
      super(40, version);
    }

    public UsbDeviceManagerGetDeviceParams() {
      this(0);
    }

    public static UsbDeviceManagerGetDeviceParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static UsbDeviceManagerGetDeviceParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static UsbDeviceManagerGetDeviceParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        UsbDeviceManagerGetDeviceParams result =
            new UsbDeviceManagerGetDeviceParams(elementsOrVersion);
        result.guid = decoder0.readString(8, false);
        result.blockedInterfaceClasses = decoder0.readBytes(16, 0, -1);
        result.deviceReceiver = decoder0.readInterfaceRequest(24, false);
        result.deviceClient =
            (UsbDeviceClient) decoder0.readServiceInterface(28, true, UsbDeviceClient.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.guid, 8, false);
      encoder0.encode(this.blockedInterfaceClasses, 16, 0, -1);
      encoder0.encode((InterfaceRequest) this.deviceReceiver, 24, false);
      encoder0.encode(this.deviceClient, 28, true, UsbDeviceClient.MANAGER);
    }
  }

  static final class UsbDeviceManagerGetSecurityKeyDeviceParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public UsbDeviceClient deviceClient;
    public InterfaceRequest<UsbDevice> deviceReceiver;
    public String guid;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private UsbDeviceManagerGetSecurityKeyDeviceParams(int version) {
      super(32, version);
    }

    public UsbDeviceManagerGetSecurityKeyDeviceParams() {
      this(0);
    }

    public static UsbDeviceManagerGetSecurityKeyDeviceParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static UsbDeviceManagerGetSecurityKeyDeviceParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static UsbDeviceManagerGetSecurityKeyDeviceParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        UsbDeviceManagerGetSecurityKeyDeviceParams result =
            new UsbDeviceManagerGetSecurityKeyDeviceParams(elementsOrVersion);
        result.guid = decoder0.readString(8, false);
        result.deviceReceiver = decoder0.readInterfaceRequest(16, false);
        result.deviceClient =
            (UsbDeviceClient) decoder0.readServiceInterface(20, true, UsbDeviceClient.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.guid, 8, false);
      encoder0.encode((InterfaceRequest) this.deviceReceiver, 16, false);
      encoder0.encode(this.deviceClient, 20, true, UsbDeviceClient.MANAGER);
    }
  }

  static final class UsbDeviceManagerRefreshDeviceInfoParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String guid;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private UsbDeviceManagerRefreshDeviceInfoParams(int version) {
      super(16, version);
    }

    public UsbDeviceManagerRefreshDeviceInfoParams() {
      this(0);
    }

    public static UsbDeviceManagerRefreshDeviceInfoParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static UsbDeviceManagerRefreshDeviceInfoParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static UsbDeviceManagerRefreshDeviceInfoParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        UsbDeviceManagerRefreshDeviceInfoParams result =
            new UsbDeviceManagerRefreshDeviceInfoParams(elementsOrVersion);
        result.guid = decoder0.readString(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.guid, 8, false);
    }
  }

  static final class UsbDeviceManagerRefreshDeviceInfoResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public UsbDeviceInfo deviceInfo;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private UsbDeviceManagerRefreshDeviceInfoResponseParams(int version) {
      super(16, version);
    }

    public UsbDeviceManagerRefreshDeviceInfoResponseParams() {
      this(0);
    }

    public static UsbDeviceManagerRefreshDeviceInfoResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static UsbDeviceManagerRefreshDeviceInfoResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static UsbDeviceManagerRefreshDeviceInfoResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        UsbDeviceManagerRefreshDeviceInfoResponseParams result =
            new UsbDeviceManagerRefreshDeviceInfoResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.deviceInfo = UsbDeviceInfo.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.deviceInfo, 8, true);
    }
  }

  static class UsbDeviceManagerRefreshDeviceInfoResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final UsbDeviceManager.RefreshDeviceInfo_Response mCallback;

    UsbDeviceManagerRefreshDeviceInfoResponseParamsForwardToCallback(
        UsbDeviceManager.RefreshDeviceInfo_Response callback) {
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
        UsbDeviceManagerRefreshDeviceInfoResponseParams response =
            UsbDeviceManagerRefreshDeviceInfoResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.deviceInfo);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class UsbDeviceManagerRefreshDeviceInfoResponseParamsProxyToResponder
      implements UsbDeviceManager.RefreshDeviceInfo_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    UsbDeviceManagerRefreshDeviceInfoResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(UsbDeviceInfo deviceInfo) {
      UsbDeviceManagerRefreshDeviceInfoResponseParams _response =
          new UsbDeviceManagerRefreshDeviceInfoResponseParams();
      _response.deviceInfo = deviceInfo;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class UsbDeviceManagerSetClientParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public AssociatedInterfaceNotSupported client;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private UsbDeviceManagerSetClientParams(int version) {
      super(16, version);
    }

    public UsbDeviceManagerSetClientParams() {
      this(0);
    }

    public static UsbDeviceManagerSetClientParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static UsbDeviceManagerSetClientParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static UsbDeviceManagerSetClientParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        UsbDeviceManagerSetClientParams result =
            new UsbDeviceManagerSetClientParams(elementsOrVersion);
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
}
