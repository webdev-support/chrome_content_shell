package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
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

class AssociatedInterfaceProvider_Internal {
  private static final int GET_ASSOCIATED_INTERFACE_ORDINAL = 0;
  public static final Interface.Manager<
          AssociatedInterfaceProvider, AssociatedInterfaceProvider.Proxy>
      MANAGER =
          new Interface.Manager<AssociatedInterfaceProvider, AssociatedInterfaceProvider.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.AssociatedInterfaceProvider";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public AssociatedInterfaceProvider.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, AssociatedInterfaceProvider impl) {
              return new Stub(core, impl);
            }

            @Override
            public AssociatedInterfaceProvider[] buildArray(int size) {
              return new AssociatedInterfaceProvider[size];
            }
          };

  AssociatedInterfaceProvider_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements AssociatedInterfaceProvider.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void getAssociatedInterface(
        String name, AssociatedInterfaceRequestNotSupported receiver) {
      AssociatedInterfaceProviderGetAssociatedInterfaceParams _message =
          new AssociatedInterfaceProviderGetAssociatedInterfaceParams();
      _message.name = name;
      _message.receiver = receiver;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }
  }

  public static final class Stub extends Interface.Stub<AssociatedInterfaceProvider> {
    Stub(Core core, AssociatedInterfaceProvider impl) {
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
                AssociatedInterfaceProvider_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            AssociatedInterfaceProviderGetAssociatedInterfaceParams data =
                AssociatedInterfaceProviderGetAssociatedInterfaceParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().getAssociatedInterface(data.name, data.receiver);
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
                AssociatedInterfaceProvider_Internal.MANAGER,
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

  static final class AssociatedInterfaceProviderGetAssociatedInterfaceParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public String name;
    public AssociatedInterfaceRequestNotSupported receiver;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AssociatedInterfaceProviderGetAssociatedInterfaceParams(int version) {
      super(24, version);
    }

    public AssociatedInterfaceProviderGetAssociatedInterfaceParams() {
      this(0);
    }

    public static AssociatedInterfaceProviderGetAssociatedInterfaceParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static AssociatedInterfaceProviderGetAssociatedInterfaceParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AssociatedInterfaceProviderGetAssociatedInterfaceParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AssociatedInterfaceProviderGetAssociatedInterfaceParams result =
            new AssociatedInterfaceProviderGetAssociatedInterfaceParams(elementsOrVersion);
        result.name = decoder0.readString(8, false);
        result.receiver = decoder0.readAssociatedInterfaceRequestNotSupported(16, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.name, 8, false);
      encoder0.encode(this.receiver, 16, false);
    }
  }
}
