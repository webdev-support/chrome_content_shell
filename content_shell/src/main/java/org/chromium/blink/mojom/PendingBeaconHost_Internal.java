package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceControlMessagesHelper;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.MessageReceiverWithResponder;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;
import org.chromium.url.mojom.Url;

class PendingBeaconHost_Internal {
  private static final int CREATE_BEACON_ORDINAL = 0;
  public static final Interface.Manager<PendingBeaconHost, PendingBeaconHost.Proxy> MANAGER =
      new Interface.Manager<PendingBeaconHost, PendingBeaconHost.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.PendingBeaconHost";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public PendingBeaconHost.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, PendingBeaconHost impl) {
          return new Stub(core, impl);
        }

        @Override
        public PendingBeaconHost[] buildArray(int size) {
          return new PendingBeaconHost[size];
        }
      };

  PendingBeaconHost_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements PendingBeaconHost.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void createBeacon(InterfaceRequest<PendingBeacon> receiver, Url url, int method) {
      PendingBeaconHostCreateBeaconParams _message = new PendingBeaconHostCreateBeaconParams();
      _message.receiver = receiver;
      _message.url = url;
      _message.method = method;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }
  }

  public static final class Stub extends Interface.Stub<PendingBeaconHost> {
    Stub(Core core, PendingBeaconHost impl) {
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
                PendingBeaconHost_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            PendingBeaconHostCreateBeaconParams data =
                PendingBeaconHostCreateBeaconParams.deserialize(messageWithHeader.getPayload());
            getImpl().createBeacon(data.receiver, data.url, data.method);
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
                getCore(), PendingBeaconHost_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class PendingBeaconHostCreateBeaconParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int method;
    public InterfaceRequest<PendingBeacon> receiver;
    public Url url;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PendingBeaconHostCreateBeaconParams(int version) {
      super(24, version);
    }

    public PendingBeaconHostCreateBeaconParams() {
      this(0);
    }

    public static PendingBeaconHostCreateBeaconParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PendingBeaconHostCreateBeaconParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PendingBeaconHostCreateBeaconParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PendingBeaconHostCreateBeaconParams result =
            new PendingBeaconHostCreateBeaconParams(elementsOrVersion);
        result.receiver = decoder0.readInterfaceRequest(8, false);
        int readInt = decoder0.readInt(12);
        result.method = readInt;
        BeaconMethod.validate(readInt);
        result.method = BeaconMethod.toKnownValue(result.method);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.url = Url.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.receiver, 8, false);
      encoder0.encode(this.method, 12);
      encoder0.encode((Struct) this.url, 16, false);
    }
  }
}
