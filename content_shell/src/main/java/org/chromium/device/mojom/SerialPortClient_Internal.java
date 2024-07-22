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

class SerialPortClient_Internal {
  public static final Interface.Manager<SerialPortClient, SerialPortClient.Proxy> MANAGER =
      new Interface.Manager<SerialPortClient, SerialPortClient.Proxy>() {
        @Override
        public String getName() {
          return "device.mojom.SerialPortClient";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public SerialPortClient.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, SerialPortClient impl) {
          return new Stub(core, impl);
        }

        @Override
        public SerialPortClient[] buildArray(int size) {
          return new SerialPortClient[size];
        }
      };
  private static final int ON_READ_ERROR_ORDINAL = 0;
  private static final int ON_SEND_ERROR_ORDINAL = 1;

  SerialPortClient_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements SerialPortClient.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onReadError(int error) {
      SerialPortClientOnReadErrorParams _message = new SerialPortClientOnReadErrorParams();
      _message.error = error;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void onSendError(int error) {
      SerialPortClientOnSendErrorParams _message = new SerialPortClientOnSendErrorParams();
      _message.error = error;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }
  }

  public static final class Stub extends Interface.Stub<SerialPortClient> {
    Stub(Core core, SerialPortClient impl) {
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
                SerialPortClient_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            SerialPortClientOnReadErrorParams data =
                SerialPortClientOnReadErrorParams.deserialize(messageWithHeader.getPayload());
            getImpl().onReadError(data.error);
            return true;
          case 1:
            SerialPortClientOnSendErrorParams data2 =
                SerialPortClientOnSendErrorParams.deserialize(messageWithHeader.getPayload());
            getImpl().onSendError(data2.error);
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
                getCore(), SerialPortClient_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class SerialPortClientOnReadErrorParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int error;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SerialPortClientOnReadErrorParams(int version) {
      super(16, version);
    }

    public SerialPortClientOnReadErrorParams() {
      this(0);
    }

    public static SerialPortClientOnReadErrorParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SerialPortClientOnReadErrorParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SerialPortClientOnReadErrorParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SerialPortClientOnReadErrorParams result =
            new SerialPortClientOnReadErrorParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.error = readInt;
        SerialReceiveError.validate(readInt);
        result.error = SerialReceiveError.toKnownValue(result.error);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.error, 8);
    }
  }

  static final class SerialPortClientOnSendErrorParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int error;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SerialPortClientOnSendErrorParams(int version) {
      super(16, version);
    }

    public SerialPortClientOnSendErrorParams() {
      this(0);
    }

    public static SerialPortClientOnSendErrorParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SerialPortClientOnSendErrorParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SerialPortClientOnSendErrorParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SerialPortClientOnSendErrorParams result =
            new SerialPortClientOnSendErrorParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.error = readInt;
        SerialSendError.validate(readInt);
        result.error = SerialSendError.toKnownValue(result.error);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.error, 8);
    }
  }
}
