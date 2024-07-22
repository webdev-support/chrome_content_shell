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

class RemoteObjectGatewayFactory_Internal {
  private static final int CREATE_REMOTE_OBJECT_GATEWAY_ORDINAL = 0;
  public static final Interface.Manager<
          RemoteObjectGatewayFactory, RemoteObjectGatewayFactory.Proxy>
      MANAGER =
          new Interface.Manager<RemoteObjectGatewayFactory, RemoteObjectGatewayFactory.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.RemoteObjectGatewayFactory";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public RemoteObjectGatewayFactory.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, RemoteObjectGatewayFactory impl) {
              return new Stub(core, impl);
            }

            @Override
            public RemoteObjectGatewayFactory[] buildArray(int size) {
              return new RemoteObjectGatewayFactory[size];
            }
          };

  RemoteObjectGatewayFactory_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements RemoteObjectGatewayFactory.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void createRemoteObjectGateway(
        RemoteObjectHost host, InterfaceRequest<RemoteObjectGateway> gateway) {
      RemoteObjectGatewayFactoryCreateRemoteObjectGatewayParams _message =
          new RemoteObjectGatewayFactoryCreateRemoteObjectGatewayParams();
      _message.host = host;
      _message.gateway = gateway;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }
  }

  public static final class Stub extends Interface.Stub<RemoteObjectGatewayFactory> {
    Stub(Core core, RemoteObjectGatewayFactory impl) {
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
                RemoteObjectGatewayFactory_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            RemoteObjectGatewayFactoryCreateRemoteObjectGatewayParams data =
                RemoteObjectGatewayFactoryCreateRemoteObjectGatewayParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().createRemoteObjectGateway(data.host, data.gateway);
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
                RemoteObjectGatewayFactory_Internal.MANAGER,
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

  static final class RemoteObjectGatewayFactoryCreateRemoteObjectGatewayParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<RemoteObjectGateway> gateway;
    public RemoteObjectHost host;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private RemoteObjectGatewayFactoryCreateRemoteObjectGatewayParams(int version) {
      super(24, version);
    }

    public RemoteObjectGatewayFactoryCreateRemoteObjectGatewayParams() {
      this(0);
    }

    public static RemoteObjectGatewayFactoryCreateRemoteObjectGatewayParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static RemoteObjectGatewayFactoryCreateRemoteObjectGatewayParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static RemoteObjectGatewayFactoryCreateRemoteObjectGatewayParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        RemoteObjectGatewayFactoryCreateRemoteObjectGatewayParams result =
            new RemoteObjectGatewayFactoryCreateRemoteObjectGatewayParams(elementsOrVersion);
        result.host =
            (RemoteObjectHost) decoder0.readServiceInterface(8, false, RemoteObjectHost.MANAGER);
        result.gateway = decoder0.readInterfaceRequest(16, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.host, 8, false, RemoteObjectHost.MANAGER);
      encoder0.encode((InterfaceRequest) this.gateway, 16, false);
    }
  }
}
