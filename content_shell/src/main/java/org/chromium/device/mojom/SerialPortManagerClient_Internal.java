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

class SerialPortManagerClient_Internal {
  public static final Interface.Manager<SerialPortManagerClient, SerialPortManagerClient.Proxy>
      MANAGER =
          new Interface.Manager<SerialPortManagerClient, SerialPortManagerClient.Proxy>() {
            @Override
            public String getName() {
              return "device.mojom.SerialPortManagerClient";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public SerialPortManagerClient.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, SerialPortManagerClient impl) {
              return new Stub(core, impl);
            }

            @Override
            public SerialPortManagerClient[] buildArray(int size) {
              return new SerialPortManagerClient[size];
            }
          };
  private static final int ON_PORT_ADDED_ORDINAL = 0;
  private static final int ON_PORT_REMOVED_ORDINAL = 1;

  SerialPortManagerClient_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements SerialPortManagerClient.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onPortAdded(SerialPortInfo portInfo) {
      SerialPortManagerClientOnPortAddedParams _message =
          new SerialPortManagerClientOnPortAddedParams();
      _message.portInfo = portInfo;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void onPortRemoved(SerialPortInfo portInfo) {
      SerialPortManagerClientOnPortRemovedParams _message =
          new SerialPortManagerClientOnPortRemovedParams();
      _message.portInfo = portInfo;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }
  }

  public static final class Stub extends Interface.Stub<SerialPortManagerClient> {
    Stub(Core core, SerialPortManagerClient impl) {
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
                SerialPortManagerClient_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            SerialPortManagerClientOnPortAddedParams data =
                SerialPortManagerClientOnPortAddedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onPortAdded(data.portInfo);
            return true;
          case 1:
            SerialPortManagerClientOnPortRemovedParams data2 =
                SerialPortManagerClientOnPortRemovedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onPortRemoved(data2.portInfo);
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
                getCore(), SerialPortManagerClient_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class SerialPortManagerClientOnPortAddedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public SerialPortInfo portInfo;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SerialPortManagerClientOnPortAddedParams(int version) {
      super(16, version);
    }

    public SerialPortManagerClientOnPortAddedParams() {
      this(0);
    }

    public static SerialPortManagerClientOnPortAddedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SerialPortManagerClientOnPortAddedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SerialPortManagerClientOnPortAddedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SerialPortManagerClientOnPortAddedParams result =
            new SerialPortManagerClientOnPortAddedParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.portInfo = SerialPortInfo.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.portInfo, 8, false);
    }
  }

  static final class SerialPortManagerClientOnPortRemovedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public SerialPortInfo portInfo;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SerialPortManagerClientOnPortRemovedParams(int version) {
      super(16, version);
    }

    public SerialPortManagerClientOnPortRemovedParams() {
      this(0);
    }

    public static SerialPortManagerClientOnPortRemovedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SerialPortManagerClientOnPortRemovedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SerialPortManagerClientOnPortRemovedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SerialPortManagerClientOnPortRemovedParams result =
            new SerialPortManagerClientOnPortRemovedParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.portInfo = SerialPortInfo.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.portInfo, 8, false);
    }
  }
}
