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

class IdleMonitor_Internal {
  public static final Interface.Manager<IdleMonitor, IdleMonitor.Proxy> MANAGER =
      new Interface.Manager<IdleMonitor, IdleMonitor.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.IdleMonitor";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public IdleMonitor.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, IdleMonitor impl) {
          return new Stub(core, impl);
        }

        @Override
        public IdleMonitor[] buildArray(int size) {
          return new IdleMonitor[size];
        }
      };
  private static final int UPDATE_ORDINAL = 0;

  IdleMonitor_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements IdleMonitor.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void update(IdleState state, boolean isOverriddenByDevtools) {
      IdleMonitorUpdateParams _message = new IdleMonitorUpdateParams();
      _message.state = state;
      _message.isOverriddenByDevtools = isOverriddenByDevtools;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }
  }

  public static final class Stub extends Interface.Stub<IdleMonitor> {
    Stub(Core core, IdleMonitor impl) {
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
                IdleMonitor_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            IdleMonitorUpdateParams data =
                IdleMonitorUpdateParams.deserialize(messageWithHeader.getPayload());
            getImpl().update(data.state, data.isOverriddenByDevtools);
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
                getCore(), IdleMonitor_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class IdleMonitorUpdateParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean isOverriddenByDevtools;
    public IdleState state;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private IdleMonitorUpdateParams(int version) {
      super(24, version);
    }

    public IdleMonitorUpdateParams() {
      this(0);
    }

    public static IdleMonitorUpdateParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static IdleMonitorUpdateParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static IdleMonitorUpdateParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        IdleMonitorUpdateParams result = new IdleMonitorUpdateParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.state = IdleState.decode(decoder1);
        result.isOverriddenByDevtools = decoder0.readBoolean(16, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.state, 8, false);
      encoder0.encode(this.isOverriddenByDevtools, 16, 0);
    }
  }
}
