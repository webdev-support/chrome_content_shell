package org.chromium.device.mojom;

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
import org.chromium.mojo_base.mojom.UnguessableToken;

class SerialPortManager_Internal {
  private static final int GET_DEVICES_ORDINAL = 1;
  public static final Interface.Manager<SerialPortManager, SerialPortManager.Proxy> MANAGER =
      new Interface.Manager<SerialPortManager, SerialPortManager.Proxy>() {
        @Override
        public String getName() {
          return "device.mojom.SerialPortManager";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public SerialPortManager.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, SerialPortManager impl) {
          return new Stub(core, impl);
        }

        @Override
        public SerialPortManager[] buildArray(int size) {
          return new SerialPortManager[size];
        }
      };
  private static final int OPEN_PORT_ORDINAL = 2;
  private static final int SET_CLIENT_ORDINAL = 0;

  SerialPortManager_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements SerialPortManager.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void setClient(SerialPortManagerClient client) {
      SerialPortManagerSetClientParams _message = new SerialPortManagerSetClientParams();
      _message.client = client;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void getDevices(GetDevices_Response callback) {
      SerialPortManagerGetDevicesParams _message = new SerialPortManagerGetDevicesParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new SerialPortManagerGetDevicesResponseParamsForwardToCallback(callback));
    }

    @Override
    public void openPort(
        UnguessableToken token,
        boolean useAlternatePath,
        SerialConnectionOptions options,
        SerialPortClient client,
        SerialPortConnectionWatcher watcher,
        OpenPort_Response callback) {
      SerialPortManagerOpenPortParams _message = new SerialPortManagerOpenPortParams();
      _message.token = token;
      _message.useAlternatePath = useAlternatePath;
      _message.options = options;
      _message.client = client;
      _message.watcher = watcher;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new SerialPortManagerOpenPortResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<SerialPortManager> {
    Stub(Core core, SerialPortManager impl) {
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
                SerialPortManager_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            SerialPortManagerSetClientParams data =
                SerialPortManagerSetClientParams.deserialize(messageWithHeader.getPayload());
            getImpl().setClient(data.client);
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
                getCore(), SerialPortManager_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
          default:
            return false;
          case 1:
            SerialPortManagerGetDevicesParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .getDevices(
                    new SerialPortManagerGetDevicesResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 2:
            SerialPortManagerOpenPortParams data =
                SerialPortManagerOpenPortParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .openPort(
                    data.token,
                    data.useAlternatePath,
                    data.options,
                    data.client,
                    data.watcher,
                    new SerialPortManagerOpenPortResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class SerialPortManagerSetClientParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public SerialPortManagerClient client;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SerialPortManagerSetClientParams(int version) {
      super(16, version);
    }

    public SerialPortManagerSetClientParams() {
      this(0);
    }

    public static SerialPortManagerSetClientParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SerialPortManagerSetClientParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SerialPortManagerSetClientParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SerialPortManagerSetClientParams result =
            new SerialPortManagerSetClientParams(elementsOrVersion);
        result.client =
            (SerialPortManagerClient)
                decoder0.readServiceInterface(8, false, SerialPortManagerClient.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.client, 8, false, SerialPortManagerClient.MANAGER);
    }
  }

  static final class SerialPortManagerGetDevicesParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SerialPortManagerGetDevicesParams(int version) {
      super(8, version);
    }

    public SerialPortManagerGetDevicesParams() {
      this(0);
    }

    public static SerialPortManagerGetDevicesParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SerialPortManagerGetDevicesParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SerialPortManagerGetDevicesParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SerialPortManagerGetDevicesParams result =
            new SerialPortManagerGetDevicesParams(elementsOrVersion);
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

  static final class SerialPortManagerGetDevicesResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public SerialPortInfo[] devices;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SerialPortManagerGetDevicesResponseParams(int version) {
      super(16, version);
    }

    public SerialPortManagerGetDevicesResponseParams() {
      this(0);
    }

    public static SerialPortManagerGetDevicesResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SerialPortManagerGetDevicesResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SerialPortManagerGetDevicesResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SerialPortManagerGetDevicesResponseParams result =
            new SerialPortManagerGetDevicesResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.devices = new SerialPortInfo[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.devices[i1] = SerialPortInfo.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      SerialPortInfo[] serialPortInfoArr = this.devices;
      if (serialPortInfoArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(serialPortInfoArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        SerialPortInfo[] serialPortInfoArr2 = this.devices;
        if (i0 < serialPortInfoArr2.length) {
          encoder1.encode((Struct) serialPortInfoArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static class SerialPortManagerGetDevicesResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final SerialPortManager.GetDevices_Response mCallback;

    SerialPortManagerGetDevicesResponseParamsForwardToCallback(
        SerialPortManager.GetDevices_Response callback) {
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
        SerialPortManagerGetDevicesResponseParams response =
            SerialPortManagerGetDevicesResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.devices);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class SerialPortManagerGetDevicesResponseParamsProxyToResponder
      implements SerialPortManager.GetDevices_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    SerialPortManagerGetDevicesResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(SerialPortInfo[] devices) {
      SerialPortManagerGetDevicesResponseParams _response =
          new SerialPortManagerGetDevicesResponseParams();
      _response.devices = devices;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class SerialPortManagerOpenPortParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 48;
    private static final DataHeader[] VERSION_ARRAY;
    public SerialPortClient client;
    public SerialConnectionOptions options;
    public UnguessableToken token;
    public boolean useAlternatePath;
    public SerialPortConnectionWatcher watcher;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(48, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SerialPortManagerOpenPortParams(int version) {
      super(48, version);
    }

    public SerialPortManagerOpenPortParams() {
      this(0);
    }

    public static SerialPortManagerOpenPortParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SerialPortManagerOpenPortParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SerialPortManagerOpenPortParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SerialPortManagerOpenPortParams result =
            new SerialPortManagerOpenPortParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.token = UnguessableToken.decode(decoder1);
        result.useAlternatePath = decoder0.readBoolean(16, 0);
        Decoder decoder12 = decoder0.readPointer(24, false);
        result.options = SerialConnectionOptions.decode(decoder12);
        result.client =
            (SerialPortClient) decoder0.readServiceInterface(32, false, SerialPortClient.MANAGER);
        result.watcher =
            (SerialPortConnectionWatcher)
                decoder0.readServiceInterface(40, true, SerialPortConnectionWatcher.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.token, 8, false);
      encoder0.encode(this.useAlternatePath, 16, 0);
      encoder0.encode((Struct) this.options, 24, false);
      encoder0.encode(this.client, 32, false, SerialPortClient.MANAGER);
      encoder0.encode(this.watcher, 40, true, SerialPortConnectionWatcher.MANAGER);
    }
  }

  static final class SerialPortManagerOpenPortResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public SerialPort port;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SerialPortManagerOpenPortResponseParams(int version) {
      super(16, version);
    }

    public SerialPortManagerOpenPortResponseParams() {
      this(0);
    }

    public static SerialPortManagerOpenPortResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SerialPortManagerOpenPortResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SerialPortManagerOpenPortResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SerialPortManagerOpenPortResponseParams result =
            new SerialPortManagerOpenPortResponseParams(elementsOrVersion);
        result.port = (SerialPort) decoder0.readServiceInterface(8, true, SerialPort.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.port, 8, true, SerialPort.MANAGER);
    }
  }

  static class SerialPortManagerOpenPortResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final SerialPortManager.OpenPort_Response mCallback;

    SerialPortManagerOpenPortResponseParamsForwardToCallback(
        SerialPortManager.OpenPort_Response callback) {
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
        SerialPortManagerOpenPortResponseParams response =
            SerialPortManagerOpenPortResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.port);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class SerialPortManagerOpenPortResponseParamsProxyToResponder
      implements SerialPortManager.OpenPort_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    SerialPortManagerOpenPortResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(SerialPort port) {
      SerialPortManagerOpenPortResponseParams _response =
          new SerialPortManagerOpenPortResponseParams();
      _response.port = port;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
