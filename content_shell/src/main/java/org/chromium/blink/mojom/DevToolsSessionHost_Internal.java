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

class DevToolsSessionHost_Internal {
  private static final int DISPATCH_PROTOCOL_NOTIFICATION_ORDINAL = 1;
  private static final int DISPATCH_PROTOCOL_RESPONSE_ORDINAL = 0;
  public static final Interface.Manager<DevToolsSessionHost, DevToolsSessionHost.Proxy> MANAGER =
      new Interface.Manager<DevToolsSessionHost, DevToolsSessionHost.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.DevToolsSessionHost";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public DevToolsSessionHost.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, DevToolsSessionHost impl) {
          return new Stub(core, impl);
        }

        @Override
        public DevToolsSessionHost[] buildArray(int size) {
          return new DevToolsSessionHost[size];
        }
      };

  DevToolsSessionHost_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements DevToolsSessionHost.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void dispatchProtocolResponse(
        DevToolsMessage message, int callId, DevToolsSessionState updates) {
      DevToolsSessionHostDispatchProtocolResponseParams _message =
          new DevToolsSessionHostDispatchProtocolResponseParams();
      _message.message = message;
      _message.callId = callId;
      _message.updates = updates;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void dispatchProtocolNotification(
        DevToolsMessage message, DevToolsSessionState updates) {
      DevToolsSessionHostDispatchProtocolNotificationParams _message =
          new DevToolsSessionHostDispatchProtocolNotificationParams();
      _message.message = message;
      _message.updates = updates;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }
  }

  public static final class Stub extends Interface.Stub<DevToolsSessionHost> {
    Stub(Core core, DevToolsSessionHost impl) {
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
                DevToolsSessionHost_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            DevToolsSessionHostDispatchProtocolResponseParams data =
                DevToolsSessionHostDispatchProtocolResponseParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().dispatchProtocolResponse(data.message, data.callId, data.updates);
            return true;
          case 1:
            DevToolsSessionHostDispatchProtocolNotificationParams data2 =
                DevToolsSessionHostDispatchProtocolNotificationParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().dispatchProtocolNotification(data2.message, data2.updates);
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
                getCore(), DevToolsSessionHost_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class DevToolsSessionHostDispatchProtocolResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public int callId;
    public DevToolsMessage message;
    public DevToolsSessionState updates;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DevToolsSessionHostDispatchProtocolResponseParams(int version) {
      super(32, version);
    }

    public DevToolsSessionHostDispatchProtocolResponseParams() {
      this(0);
    }

    public static DevToolsSessionHostDispatchProtocolResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static DevToolsSessionHostDispatchProtocolResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DevToolsSessionHostDispatchProtocolResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DevToolsSessionHostDispatchProtocolResponseParams result =
            new DevToolsSessionHostDispatchProtocolResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.message = DevToolsMessage.decode(decoder1);
        result.callId = decoder0.readInt(16);
        Decoder decoder12 = decoder0.readPointer(24, true);
        result.updates = DevToolsSessionState.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.message, 8, false);
      encoder0.encode(this.callId, 16);
      encoder0.encode((Struct) this.updates, 24, true);
    }
  }

  static final class DevToolsSessionHostDispatchProtocolNotificationParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public DevToolsMessage message;
    public DevToolsSessionState updates;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DevToolsSessionHostDispatchProtocolNotificationParams(int version) {
      super(24, version);
    }

    public DevToolsSessionHostDispatchProtocolNotificationParams() {
      this(0);
    }

    public static DevToolsSessionHostDispatchProtocolNotificationParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static DevToolsSessionHostDispatchProtocolNotificationParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DevToolsSessionHostDispatchProtocolNotificationParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DevToolsSessionHostDispatchProtocolNotificationParams result =
            new DevToolsSessionHostDispatchProtocolNotificationParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.message = DevToolsMessage.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, true);
        result.updates = DevToolsSessionState.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.message, 8, false);
      encoder0.encode((Struct) this.updates, 16, true);
    }
  }
}
