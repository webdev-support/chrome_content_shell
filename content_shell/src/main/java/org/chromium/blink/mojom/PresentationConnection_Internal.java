package org.chromium.blink.mojom;

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
import org.chromium.mojo.bindings.Union;
import org.chromium.mojo.system.Core;

class PresentationConnection_Internal {
  private static final int DID_CHANGE_STATE_ORDINAL = 1;
  private static final int DID_CLOSE_ORDINAL = 2;
  public static final Interface.Manager<PresentationConnection, PresentationConnection.Proxy>
      MANAGER =
          new Interface.Manager<PresentationConnection, PresentationConnection.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.PresentationConnection";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public PresentationConnection.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, PresentationConnection impl) {
              return new Stub(core, impl);
            }

            @Override
            public PresentationConnection[] buildArray(int size) {
              return new PresentationConnection[size];
            }
          };
  private static final int ON_MESSAGE_ORDINAL = 0;

  PresentationConnection_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements PresentationConnection.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onMessage(PresentationConnectionMessage message) {
      PresentationConnectionOnMessageParams _message = new PresentationConnectionOnMessageParams();
      _message.message = message;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void didChangeState(int state) {
      PresentationConnectionDidChangeStateParams _message =
          new PresentationConnectionDidChangeStateParams();
      _message.state = state;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void didClose(int reason) {
      PresentationConnectionDidCloseParams _message = new PresentationConnectionDidCloseParams();
      _message.reason = reason;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }
  }

  public static final class Stub extends Interface.Stub<PresentationConnection> {
    Stub(Core core, PresentationConnection impl) {
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
                PresentationConnection_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            PresentationConnectionOnMessageParams data =
                PresentationConnectionOnMessageParams.deserialize(messageWithHeader.getPayload());
            getImpl().onMessage(data.message);
            return true;
          case 1:
            PresentationConnectionDidChangeStateParams data2 =
                PresentationConnectionDidChangeStateParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().didChangeState(data2.state);
            return true;
          case 2:
            PresentationConnectionDidCloseParams data3 =
                PresentationConnectionDidCloseParams.deserialize(messageWithHeader.getPayload());
            getImpl().didClose(data3.reason);
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
                getCore(), PresentationConnection_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class PresentationConnectionOnMessageParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public PresentationConnectionMessage message;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PresentationConnectionOnMessageParams(int version) {
      super(24, version);
    }

    public PresentationConnectionOnMessageParams() {
      this(0);
    }

    public static PresentationConnectionOnMessageParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PresentationConnectionOnMessageParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PresentationConnectionOnMessageParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PresentationConnectionOnMessageParams result =
            new PresentationConnectionOnMessageParams(elementsOrVersion);
        result.message = PresentationConnectionMessage.decode(decoder0, 8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Union) this.message, 8, false);
    }
  }

  static final class PresentationConnectionDidChangeStateParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int state;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PresentationConnectionDidChangeStateParams(int version) {
      super(16, version);
    }

    public PresentationConnectionDidChangeStateParams() {
      this(0);
    }

    public static PresentationConnectionDidChangeStateParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PresentationConnectionDidChangeStateParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PresentationConnectionDidChangeStateParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PresentationConnectionDidChangeStateParams result =
            new PresentationConnectionDidChangeStateParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.state = readInt;
        PresentationConnectionState.validate(readInt);
        result.state = PresentationConnectionState.toKnownValue(result.state);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.state, 8);
    }
  }

  static final class PresentationConnectionDidCloseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int reason;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PresentationConnectionDidCloseParams(int version) {
      super(16, version);
    }

    public PresentationConnectionDidCloseParams() {
      this(0);
    }

    public static PresentationConnectionDidCloseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PresentationConnectionDidCloseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PresentationConnectionDidCloseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PresentationConnectionDidCloseParams result =
            new PresentationConnectionDidCloseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.reason = readInt;
        PresentationConnectionCloseReason.validate(readInt);
        result.reason = PresentationConnectionCloseReason.toKnownValue(result.reason);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.reason, 8);
    }
  }
}
