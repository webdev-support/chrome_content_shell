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
import org.chromium.url.internal.mojom.Origin;

class AutoplayConfigurationClient_Internal {
  private static final int ADD_AUTOPLAY_FLAGS_ORDINAL = 0;
  public static final Interface.Manager<
          AutoplayConfigurationClient, AutoplayConfigurationClient.Proxy>
      MANAGER =
          new Interface.Manager<AutoplayConfigurationClient, AutoplayConfigurationClient.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.AutoplayConfigurationClient";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public AutoplayConfigurationClient.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, AutoplayConfigurationClient impl) {
              return new Stub(core, impl);
            }

            @Override
            public AutoplayConfigurationClient[] buildArray(int size) {
              return new AutoplayConfigurationClient[size];
            }
          };

  AutoplayConfigurationClient_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements AutoplayConfigurationClient.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void addAutoplayFlags(Origin origin, int flags) {
      AutoplayConfigurationClientAddAutoplayFlagsParams _message =
          new AutoplayConfigurationClientAddAutoplayFlagsParams();
      _message.origin = origin;
      _message.flags = flags;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }
  }

  public static final class Stub extends Interface.Stub<AutoplayConfigurationClient> {
    Stub(Core core, AutoplayConfigurationClient impl) {
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
                AutoplayConfigurationClient_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            AutoplayConfigurationClientAddAutoplayFlagsParams data =
                AutoplayConfigurationClientAddAutoplayFlagsParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().addAutoplayFlags(data.origin, data.flags);
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
                AutoplayConfigurationClient_Internal.MANAGER,
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

  static final class AutoplayConfigurationClientAddAutoplayFlagsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int flags;
    public Origin origin;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AutoplayConfigurationClientAddAutoplayFlagsParams(int version) {
      super(24, version);
    }

    public AutoplayConfigurationClientAddAutoplayFlagsParams() {
      this(0);
    }

    public static AutoplayConfigurationClientAddAutoplayFlagsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AutoplayConfigurationClientAddAutoplayFlagsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AutoplayConfigurationClientAddAutoplayFlagsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AutoplayConfigurationClientAddAutoplayFlagsParams result =
            new AutoplayConfigurationClientAddAutoplayFlagsParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.origin = Origin.decode(decoder1);
        result.flags = decoder0.readInt(16);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.origin, 8, false);
      encoder0.encode(this.flags, 16);
    }
  }
}
