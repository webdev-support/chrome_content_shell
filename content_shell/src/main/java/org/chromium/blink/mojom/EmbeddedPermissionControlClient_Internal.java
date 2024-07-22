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

class EmbeddedPermissionControlClient_Internal {
  public static final Interface.Manager<
          EmbeddedPermissionControlClient, EmbeddedPermissionControlClient.Proxy>
      MANAGER =
          new Interface.Manager<
              EmbeddedPermissionControlClient, EmbeddedPermissionControlClient.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.EmbeddedPermissionControlClient";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public EmbeddedPermissionControlClient.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, EmbeddedPermissionControlClient impl) {
              return new Stub(core, impl);
            }

            @Override
            public EmbeddedPermissionControlClient[] buildArray(int size) {
              return new EmbeddedPermissionControlClient[size];
            }
          };
  private static final int ON_EMBEDDED_PERMISSION_CONTROL_REGISTERED_ORDINAL = 0;

  EmbeddedPermissionControlClient_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements EmbeddedPermissionControlClient.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onEmbeddedPermissionControlRegistered(boolean allow, int[] statuses) {
      EmbeddedPermissionControlClientOnEmbeddedPermissionControlRegisteredParams _message =
          new EmbeddedPermissionControlClientOnEmbeddedPermissionControlRegisteredParams();
      _message.allow = allow;
      _message.statuses = statuses;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }
  }

  public static final class Stub extends Interface.Stub<EmbeddedPermissionControlClient> {
    Stub(Core core, EmbeddedPermissionControlClient impl) {
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
                EmbeddedPermissionControlClient_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            EmbeddedPermissionControlClientOnEmbeddedPermissionControlRegisteredParams data =
                EmbeddedPermissionControlClientOnEmbeddedPermissionControlRegisteredParams
                    .deserialize(messageWithHeader.getPayload());
            getImpl().onEmbeddedPermissionControlRegistered(data.allow, data.statuses);
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
                getCore(),
                EmbeddedPermissionControlClient_Internal.MANAGER,
                messageWithHeader,
                receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class EmbeddedPermissionControlClientOnEmbeddedPermissionControlRegisteredParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean allow;
    public int[] statuses;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private EmbeddedPermissionControlClientOnEmbeddedPermissionControlRegisteredParams(
        int version) {
      super(24, version);
    }

    public EmbeddedPermissionControlClientOnEmbeddedPermissionControlRegisteredParams() {
      this(0);
    }

    public static EmbeddedPermissionControlClientOnEmbeddedPermissionControlRegisteredParams
        deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static EmbeddedPermissionControlClientOnEmbeddedPermissionControlRegisteredParams
        deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static EmbeddedPermissionControlClientOnEmbeddedPermissionControlRegisteredParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        EmbeddedPermissionControlClientOnEmbeddedPermissionControlRegisteredParams result =
            new EmbeddedPermissionControlClientOnEmbeddedPermissionControlRegisteredParams(
                elementsOrVersion);
        result.allow = decoder0.readBoolean(8, 0);
        int[] readInts = decoder0.readInts(16, 1, -1);
        result.statuses = readInts;
        if (readInts != null) {
          int i1 = 0;
          while (true) {
            int[] iArr = result.statuses;
            if (i1 >= iArr.length) {
              break;
            }
            PermissionStatus.validate(iArr[i1]);
            i1++;
          }
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.allow, 8, 0);
      encoder0.encode(this.statuses, 16, 1, -1);
    }
  }
}
