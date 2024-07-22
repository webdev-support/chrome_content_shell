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
import org.chromium.mojo.system.Core;

class AecDumpAgent_Internal {
  public static final Interface.Manager<AecDumpAgent, AecDumpAgent.Proxy> MANAGER =
      new Interface.Manager<AecDumpAgent, AecDumpAgent.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.AecDumpAgent";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public AecDumpAgent.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, AecDumpAgent impl) {
          return new Stub(core, impl);
        }

        @Override
        public AecDumpAgent[] buildArray(int size) {
          return new AecDumpAgent[size];
        }
      };
  private static final int START_ORDINAL = 0;
  private static final int STOP_ORDINAL = 1;

  AecDumpAgent_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements AecDumpAgent.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void start(org.chromium.mojo_base.mojom.File file) {
      AecDumpAgentStartParams _message = new AecDumpAgentStartParams();
      _message.file = file;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void stop() {
      AecDumpAgentStopParams _message = new AecDumpAgentStopParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }
  }

  public static final class Stub extends Interface.Stub<AecDumpAgent> {
    Stub(Core core, AecDumpAgent impl) {
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
                AecDumpAgent_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            AecDumpAgentStartParams data =
                AecDumpAgentStartParams.deserialize(messageWithHeader.getPayload());
            getImpl().start(data.file);
            return true;
          case 1:
            AecDumpAgentStopParams.deserialize(messageWithHeader.getPayload());
            getImpl().stop();
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
                getCore(), AecDumpAgent_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class AecDumpAgentStartParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public org.chromium.mojo_base.mojom.File file;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AecDumpAgentStartParams(int version) {
      super(16, version);
    }

    public AecDumpAgentStartParams() {
      this(0);
    }

    public static AecDumpAgentStartParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AecDumpAgentStartParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AecDumpAgentStartParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AecDumpAgentStartParams result = new AecDumpAgentStartParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.file = org.chromium.mojo_base.mojom.File.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.file, 8, false);
    }
  }

  static final class AecDumpAgentStopParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AecDumpAgentStopParams(int version) {
      super(8, version);
    }

    public AecDumpAgentStopParams() {
      this(0);
    }

    public static AecDumpAgentStopParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AecDumpAgentStopParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AecDumpAgentStopParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AecDumpAgentStopParams result = new AecDumpAgentStopParams(elementsOrVersion);
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
