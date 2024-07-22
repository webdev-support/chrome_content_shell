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

class WakeLockObserver_Internal {
  public static final Interface.Manager<WakeLockObserver, WakeLockObserver.Proxy> MANAGER =
      new Interface.Manager<WakeLockObserver, WakeLockObserver.Proxy>() {
        @Override
        public String getName() {
          return "device.mojom.WakeLockObserver";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public WakeLockObserver.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, WakeLockObserver impl) {
          return new Stub(core, impl);
        }

        @Override
        public WakeLockObserver[] buildArray(int size) {
          return new WakeLockObserver[size];
        }
      };
  private static final int ON_WAKE_LOCK_DEACTIVATED_ORDINAL = 0;

  WakeLockObserver_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements WakeLockObserver.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onWakeLockDeactivated(int type) {
      WakeLockObserverOnWakeLockDeactivatedParams _message =
          new WakeLockObserverOnWakeLockDeactivatedParams();
      _message.type = type;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }
  }

  public static final class Stub extends Interface.Stub<WakeLockObserver> {
    Stub(Core core, WakeLockObserver impl) {
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
                WakeLockObserver_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            WakeLockObserverOnWakeLockDeactivatedParams data =
                WakeLockObserverOnWakeLockDeactivatedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onWakeLockDeactivated(data.type);
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
                getCore(), WakeLockObserver_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class WakeLockObserverOnWakeLockDeactivatedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int type;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WakeLockObserverOnWakeLockDeactivatedParams(int version) {
      super(16, version);
    }

    public WakeLockObserverOnWakeLockDeactivatedParams() {
      this(0);
    }

    public static WakeLockObserverOnWakeLockDeactivatedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WakeLockObserverOnWakeLockDeactivatedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WakeLockObserverOnWakeLockDeactivatedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WakeLockObserverOnWakeLockDeactivatedParams result =
            new WakeLockObserverOnWakeLockDeactivatedParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.type = readInt;
        WakeLockType.validate(readInt);
        result.type = WakeLockType.toKnownValue(result.type);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.type, 8);
    }
  }
}
