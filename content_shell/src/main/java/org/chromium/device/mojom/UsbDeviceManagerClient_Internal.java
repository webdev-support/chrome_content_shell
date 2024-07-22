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

class UsbDeviceManagerClient_Internal {
  public static final Interface.Manager<UsbDeviceManagerClient, UsbDeviceManagerClient.Proxy>
      MANAGER =
          new Interface.Manager<UsbDeviceManagerClient, UsbDeviceManagerClient.Proxy>() {
            @Override
            public String getName() {
              return "device.mojom.UsbDeviceManagerClient";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public UsbDeviceManagerClient.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, UsbDeviceManagerClient impl) {
              return new Stub(core, impl);
            }

            @Override
            public UsbDeviceManagerClient[] buildArray(int size) {
              return new UsbDeviceManagerClient[size];
            }
          };
  private static final int ON_DEVICE_ADDED_ORDINAL = 0;
  private static final int ON_DEVICE_REMOVED_ORDINAL = 1;

  UsbDeviceManagerClient_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements UsbDeviceManagerClient.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onDeviceAdded(UsbDeviceInfo deviceInfo) {
      UsbDeviceManagerClientOnDeviceAddedParams _message =
          new UsbDeviceManagerClientOnDeviceAddedParams();
      _message.deviceInfo = deviceInfo;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void onDeviceRemoved(UsbDeviceInfo deviceInfo) {
      UsbDeviceManagerClientOnDeviceRemovedParams _message =
          new UsbDeviceManagerClientOnDeviceRemovedParams();
      _message.deviceInfo = deviceInfo;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }
  }

  public static final class Stub extends Interface.Stub<UsbDeviceManagerClient> {
    Stub(Core core, UsbDeviceManagerClient impl) {
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
                UsbDeviceManagerClient_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            UsbDeviceManagerClientOnDeviceAddedParams data =
                UsbDeviceManagerClientOnDeviceAddedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onDeviceAdded(data.deviceInfo);
            return true;
          case 1:
            UsbDeviceManagerClientOnDeviceRemovedParams data2 =
                UsbDeviceManagerClientOnDeviceRemovedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onDeviceRemoved(data2.deviceInfo);
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
                getCore(), UsbDeviceManagerClient_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class UsbDeviceManagerClientOnDeviceAddedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public UsbDeviceInfo deviceInfo;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private UsbDeviceManagerClientOnDeviceAddedParams(int version) {
      super(16, version);
    }

    public UsbDeviceManagerClientOnDeviceAddedParams() {
      this(0);
    }

    public static UsbDeviceManagerClientOnDeviceAddedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static UsbDeviceManagerClientOnDeviceAddedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static UsbDeviceManagerClientOnDeviceAddedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        UsbDeviceManagerClientOnDeviceAddedParams result =
            new UsbDeviceManagerClientOnDeviceAddedParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.deviceInfo = UsbDeviceInfo.decode(decoder1);
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

  static final class UsbDeviceManagerClientOnDeviceRemovedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public UsbDeviceInfo deviceInfo;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private UsbDeviceManagerClientOnDeviceRemovedParams(int version) {
      super(16, version);
    }

    public UsbDeviceManagerClientOnDeviceRemovedParams() {
      this(0);
    }

    public static UsbDeviceManagerClientOnDeviceRemovedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static UsbDeviceManagerClientOnDeviceRemovedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static UsbDeviceManagerClientOnDeviceRemovedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        UsbDeviceManagerClientOnDeviceRemovedParams result =
            new UsbDeviceManagerClientOnDeviceRemovedParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.deviceInfo = UsbDeviceInfo.decode(decoder1);
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
}
