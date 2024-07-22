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
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;

class UsbDeviceClient_Internal {
  public static final Interface.Manager<UsbDeviceClient, UsbDeviceClient.Proxy> MANAGER =
      new Interface.Manager<UsbDeviceClient, UsbDeviceClient.Proxy>() {
        @Override
        public String getName() {
          return "device.mojom.UsbDeviceClient";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public UsbDeviceClient.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, UsbDeviceClient impl) {
          return new Stub(core, impl);
        }

        @Override
        public UsbDeviceClient[] buildArray(int size) {
          return new UsbDeviceClient[size];
        }
      };
  private static final int ON_DEVICE_CLOSED_ORDINAL = 1;
  private static final int ON_DEVICE_OPENED_ORDINAL = 0;

  UsbDeviceClient_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements UsbDeviceClient.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onDeviceOpened() {
      UsbDeviceClientOnDeviceOpenedParams _message = new UsbDeviceClientOnDeviceOpenedParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void onDeviceClosed() {
      UsbDeviceClientOnDeviceClosedParams _message = new UsbDeviceClientOnDeviceClosedParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }
  }

  public static final class Stub extends Interface.Stub<UsbDeviceClient> {
    Stub(Core core, UsbDeviceClient impl) {
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
                UsbDeviceClient_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            UsbDeviceClientOnDeviceOpenedParams.deserialize(messageWithHeader.getPayload());
            getImpl().onDeviceOpened();
            return true;
          case 1:
            UsbDeviceClientOnDeviceClosedParams.deserialize(messageWithHeader.getPayload());
            getImpl().onDeviceClosed();
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
                getCore(), UsbDeviceClient_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class UsbDeviceClientOnDeviceOpenedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private UsbDeviceClientOnDeviceOpenedParams(int version) {
      super(8, version);
    }

    public UsbDeviceClientOnDeviceOpenedParams() {
      this(0);
    }

    public static UsbDeviceClientOnDeviceOpenedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static UsbDeviceClientOnDeviceOpenedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static UsbDeviceClientOnDeviceOpenedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        UsbDeviceClientOnDeviceOpenedParams result =
            new UsbDeviceClientOnDeviceOpenedParams(elementsOrVersion);
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

  static final class UsbDeviceClientOnDeviceClosedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private UsbDeviceClientOnDeviceClosedParams(int version) {
      super(8, version);
    }

    public UsbDeviceClientOnDeviceClosedParams() {
      this(0);
    }

    public static UsbDeviceClientOnDeviceClosedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static UsbDeviceClientOnDeviceClosedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static UsbDeviceClientOnDeviceClosedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        UsbDeviceClientOnDeviceClosedParams result =
            new UsbDeviceClientOnDeviceClosedParams(elementsOrVersion);
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
}
