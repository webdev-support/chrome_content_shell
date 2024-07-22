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

class RemoteObjectGateway_Internal {
  private static final int ADD_NAMED_OBJECT_ORDINAL = 0;
  public static final Interface.Manager<RemoteObjectGateway, RemoteObjectGateway.Proxy> MANAGER =
      new Interface.Manager<RemoteObjectGateway, RemoteObjectGateway.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.RemoteObjectGateway";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public RemoteObjectGateway.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, RemoteObjectGateway impl) {
          return new Stub(core, impl);
        }

        @Override
        public RemoteObjectGateway[] buildArray(int size) {
          return new RemoteObjectGateway[size];
        }
      };
  private static final int REMOVE_NAMED_OBJECT_ORDINAL = 1;

  RemoteObjectGateway_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements RemoteObjectGateway.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void addNamedObject(String name, int objectId) {
      RemoteObjectGatewayAddNamedObjectParams _message =
          new RemoteObjectGatewayAddNamedObjectParams();
      _message.name = name;
      _message.objectId = objectId;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void removeNamedObject(String name) {
      RemoteObjectGatewayRemoveNamedObjectParams _message =
          new RemoteObjectGatewayRemoveNamedObjectParams();
      _message.name = name;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }
  }

  public static final class Stub extends Interface.Stub<RemoteObjectGateway> {
    Stub(Core core, RemoteObjectGateway impl) {
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
                RemoteObjectGateway_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            RemoteObjectGatewayAddNamedObjectParams data =
                RemoteObjectGatewayAddNamedObjectParams.deserialize(messageWithHeader.getPayload());
            getImpl().addNamedObject(data.name, data.objectId);
            return true;
          case 1:
            getImpl()
                .removeNamedObject(
                    RemoteObjectGatewayRemoveNamedObjectParams.deserialize(
                            messageWithHeader.getPayload())
                        .name);
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
                getCore(), RemoteObjectGateway_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class RemoteObjectGatewayAddNamedObjectParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public String name;
    public int objectId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private RemoteObjectGatewayAddNamedObjectParams(int version) {
      super(24, version);
    }

    public RemoteObjectGatewayAddNamedObjectParams() {
      this(0);
    }

    public static RemoteObjectGatewayAddNamedObjectParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static RemoteObjectGatewayAddNamedObjectParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static RemoteObjectGatewayAddNamedObjectParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        RemoteObjectGatewayAddNamedObjectParams result =
            new RemoteObjectGatewayAddNamedObjectParams(elementsOrVersion);
        result.name = decoder0.readString(8, false);
        result.objectId = decoder0.readInt(16);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.name, 8, false);
      encoder0.encode(this.objectId, 16);
    }
  }

  static final class RemoteObjectGatewayRemoveNamedObjectParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String name;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private RemoteObjectGatewayRemoveNamedObjectParams(int version) {
      super(16, version);
    }

    public RemoteObjectGatewayRemoveNamedObjectParams() {
      this(0);
    }

    public static RemoteObjectGatewayRemoveNamedObjectParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static RemoteObjectGatewayRemoveNamedObjectParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static RemoteObjectGatewayRemoveNamedObjectParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        RemoteObjectGatewayRemoveNamedObjectParams result =
            new RemoteObjectGatewayRemoveNamedObjectParams(elementsOrVersion);
        result.name = decoder0.readString(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.name, 8, false);
    }
  }
}
