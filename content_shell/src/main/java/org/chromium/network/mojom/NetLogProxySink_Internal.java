package org.chromium.network.mojom;

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
import org.chromium.mojo_base.mojom.DictionaryValue;
import org.chromium.mojo_base.mojom.TimeTicks;

class NetLogProxySink_Internal {
  private static final int ADD_ENTRY_ORDINAL = 0;
  public static final Interface.Manager<NetLogProxySink, NetLogProxySink.Proxy> MANAGER =
      new Interface.Manager<NetLogProxySink, NetLogProxySink.Proxy>() {
        @Override
        public String getName() {
          return "network.mojom.NetLogProxySink";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public NetLogProxySink.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, NetLogProxySink impl) {
          return new Stub(core, impl);
        }

        @Override
        public NetLogProxySink[] buildArray(int size) {
          return new NetLogProxySink[size];
        }
      };

  NetLogProxySink_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements NetLogProxySink.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void addEntry(
        int type, NetLogSource netLogSource, int phase, TimeTicks time, DictionaryValue params) {
      NetLogProxySinkAddEntryParams _message = new NetLogProxySinkAddEntryParams();
      _message.type = type;
      _message.netLogSource = netLogSource;
      _message.phase = phase;
      _message.time = time;
      _message.params = params;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }
  }

  public static final class Stub extends Interface.Stub<NetLogProxySink> {
    Stub(Core core, NetLogProxySink impl) {
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
                NetLogProxySink_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            NetLogProxySinkAddEntryParams data =
                NetLogProxySinkAddEntryParams.deserialize(messageWithHeader.getPayload());
            getImpl().addEntry(data.type, data.netLogSource, data.phase, data.time, data.params);
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
                getCore(), NetLogProxySink_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class NetLogProxySinkAddEntryParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public NetLogSource netLogSource;
    public DictionaryValue params;
    public int phase;
    public TimeTicks time;
    public int type;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetLogProxySinkAddEntryParams(int version) {
      super(40, version);
    }

    public NetLogProxySinkAddEntryParams() {
      this(0);
    }

    public static NetLogProxySinkAddEntryParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetLogProxySinkAddEntryParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetLogProxySinkAddEntryParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetLogProxySinkAddEntryParams result = new NetLogProxySinkAddEntryParams(elementsOrVersion);
        result.type = decoder0.readInt(8);
        int readInt = decoder0.readInt(12);
        result.phase = readInt;
        NetLogEventPhase.validate(readInt);
        result.phase = NetLogEventPhase.toKnownValue(result.phase);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.netLogSource = NetLogSource.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(24, false);
        result.time = TimeTicks.decode(decoder12);
        Decoder decoder13 = decoder0.readPointer(32, false);
        result.params = DictionaryValue.decode(decoder13);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.type, 8);
      encoder0.encode(this.phase, 12);
      encoder0.encode((Struct) this.netLogSource, 16, false);
      encoder0.encode((Struct) this.time, 24, false);
      encoder0.encode((Struct) this.params, 32, false);
    }
  }
}
