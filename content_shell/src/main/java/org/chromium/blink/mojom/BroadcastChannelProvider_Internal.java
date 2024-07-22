package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
import org.chromium.mojo.bindings.AssociatedInterfaceRequestNotSupported;
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

class BroadcastChannelProvider_Internal {
  private static final int CONNECT_TO_CHANNEL_ORDINAL = 0;
  public static final Interface.Manager<BroadcastChannelProvider, BroadcastChannelProvider.Proxy>
      MANAGER =
          new Interface.Manager<BroadcastChannelProvider, BroadcastChannelProvider.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.BroadcastChannelProvider";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public BroadcastChannelProvider.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, BroadcastChannelProvider impl) {
              return new Stub(core, impl);
            }

            @Override
            public BroadcastChannelProvider[] buildArray(int size) {
              return new BroadcastChannelProvider[size];
            }
          };

  BroadcastChannelProvider_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements BroadcastChannelProvider.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void connectToChannel(
        String name,
        AssociatedInterfaceNotSupported client,
        AssociatedInterfaceRequestNotSupported connection) {
      BroadcastChannelProviderConnectToChannelParams _message =
          new BroadcastChannelProviderConnectToChannelParams();
      _message.name = name;
      _message.client = client;
      _message.connection = connection;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }
  }

  public static final class Stub extends Interface.Stub<BroadcastChannelProvider> {
    Stub(Core core, BroadcastChannelProvider impl) {
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
                BroadcastChannelProvider_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            BroadcastChannelProviderConnectToChannelParams data =
                BroadcastChannelProviderConnectToChannelParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().connectToChannel(data.name, data.client, data.connection);
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
                getCore(), BroadcastChannelProvider_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class BroadcastChannelProviderConnectToChannelParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public AssociatedInterfaceNotSupported client;
    public AssociatedInterfaceRequestNotSupported connection;
    public String name;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private BroadcastChannelProviderConnectToChannelParams(int version) {
      super(32, version);
    }

    public BroadcastChannelProviderConnectToChannelParams() {
      this(0);
    }

    public static BroadcastChannelProviderConnectToChannelParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static BroadcastChannelProviderConnectToChannelParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static BroadcastChannelProviderConnectToChannelParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        BroadcastChannelProviderConnectToChannelParams result =
            new BroadcastChannelProviderConnectToChannelParams(elementsOrVersion);
        result.name = decoder0.readString(8, false);
        result.client = decoder0.readAssociatedServiceInterfaceNotSupported(16, false);
        result.connection = decoder0.readAssociatedInterfaceRequestNotSupported(24, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.name, 8, false);
      encoder0.encode(this.client, 16, false);
      encoder0.encode(this.connection, 24, false);
    }
  }
}
