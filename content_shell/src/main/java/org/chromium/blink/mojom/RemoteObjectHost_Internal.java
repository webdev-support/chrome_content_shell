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

class RemoteObjectHost_Internal {
  private static final int ACQUIRE_OBJECT_ORDINAL = 1;
  private static final int GET_OBJECT_ORDINAL = 0;
  public static final Interface.Manager<RemoteObjectHost, RemoteObjectHost.Proxy> MANAGER =
      new Interface.Manager<RemoteObjectHost, RemoteObjectHost.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.RemoteObjectHost";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public RemoteObjectHost.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, RemoteObjectHost impl) {
          return new Stub(core, impl);
        }

        @Override
        public RemoteObjectHost[] buildArray(int size) {
          return new RemoteObjectHost[size];
        }
      };
  private static final int RELEASE_OBJECT_ORDINAL = 2;

  RemoteObjectHost_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements RemoteObjectHost.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void getObject(int objectId, InterfaceRequest<RemoteObject> receiver) {
      RemoteObjectHostGetObjectParams _message = new RemoteObjectHostGetObjectParams();
      _message.objectId = objectId;
      _message.receiver = receiver;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void acquireObject(int objectId) {
      RemoteObjectHostAcquireObjectParams _message = new RemoteObjectHostAcquireObjectParams();
      _message.objectId = objectId;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void releaseObject(int objectId) {
      RemoteObjectHostReleaseObjectParams _message = new RemoteObjectHostReleaseObjectParams();
      _message.objectId = objectId;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }
  }

  public static final class Stub extends Interface.Stub<RemoteObjectHost> {
    Stub(Core core, RemoteObjectHost impl) {
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
                RemoteObjectHost_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            RemoteObjectHostGetObjectParams data =
                RemoteObjectHostGetObjectParams.deserialize(messageWithHeader.getPayload());
            getImpl().getObject(data.objectId, data.receiver);
            return true;
          case 1:
            getImpl()
                .acquireObject(
                    RemoteObjectHostAcquireObjectParams.deserialize(messageWithHeader.getPayload())
                        .objectId);
            return true;
          case 2:
            getImpl()
                .releaseObject(
                    RemoteObjectHostReleaseObjectParams.deserialize(messageWithHeader.getPayload())
                        .objectId);
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
                getCore(), RemoteObjectHost_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class RemoteObjectHostGetObjectParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int objectId;
    public InterfaceRequest<RemoteObject> receiver;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private RemoteObjectHostGetObjectParams(int version) {
      super(16, version);
    }

    public RemoteObjectHostGetObjectParams() {
      this(0);
    }

    public static RemoteObjectHostGetObjectParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static RemoteObjectHostGetObjectParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static RemoteObjectHostGetObjectParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        RemoteObjectHostGetObjectParams result =
            new RemoteObjectHostGetObjectParams(elementsOrVersion);
        result.objectId = decoder0.readInt(8);
        result.receiver = decoder0.readInterfaceRequest(12, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.objectId, 8);
      encoder0.encode((InterfaceRequest) this.receiver, 12, false);
    }
  }

  static final class RemoteObjectHostAcquireObjectParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int objectId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private RemoteObjectHostAcquireObjectParams(int version) {
      super(16, version);
    }

    public RemoteObjectHostAcquireObjectParams() {
      this(0);
    }

    public static RemoteObjectHostAcquireObjectParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static RemoteObjectHostAcquireObjectParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static RemoteObjectHostAcquireObjectParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        RemoteObjectHostAcquireObjectParams result =
            new RemoteObjectHostAcquireObjectParams(elementsOrVersion);
        result.objectId = decoder0.readInt(8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.objectId, 8);
    }
  }

  static final class RemoteObjectHostReleaseObjectParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int objectId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private RemoteObjectHostReleaseObjectParams(int version) {
      super(16, version);
    }

    public RemoteObjectHostReleaseObjectParams() {
      this(0);
    }

    public static RemoteObjectHostReleaseObjectParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static RemoteObjectHostReleaseObjectParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static RemoteObjectHostReleaseObjectParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        RemoteObjectHostReleaseObjectParams result =
            new RemoteObjectHostReleaseObjectParams(elementsOrVersion);
        result.objectId = decoder0.readInt(8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.objectId, 8);
    }
  }
}
