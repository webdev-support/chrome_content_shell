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

class PermissionObserver_Internal {
  public static final Interface.Manager<PermissionObserver, PermissionObserver.Proxy> MANAGER =
      new Interface.Manager<PermissionObserver, PermissionObserver.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.PermissionObserver";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public PermissionObserver.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, PermissionObserver impl) {
          return new Stub(core, impl);
        }

        @Override
        public PermissionObserver[] buildArray(int size) {
          return new PermissionObserver[size];
        }
      };
  private static final int ON_PERMISSION_STATUS_CHANGE_ORDINAL = 0;

  PermissionObserver_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements PermissionObserver.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onPermissionStatusChange(int status) {
      PermissionObserverOnPermissionStatusChangeParams _message =
          new PermissionObserverOnPermissionStatusChangeParams();
      _message.status = status;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }
  }

  public static final class Stub extends Interface.Stub<PermissionObserver> {
    Stub(Core core, PermissionObserver impl) {
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
                PermissionObserver_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            PermissionObserverOnPermissionStatusChangeParams data =
                PermissionObserverOnPermissionStatusChangeParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onPermissionStatusChange(data.status);
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
                getCore(), PermissionObserver_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class PermissionObserverOnPermissionStatusChangeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int status;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PermissionObserverOnPermissionStatusChangeParams(int version) {
      super(16, version);
    }

    public PermissionObserverOnPermissionStatusChangeParams() {
      this(0);
    }

    public static PermissionObserverOnPermissionStatusChangeParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PermissionObserverOnPermissionStatusChangeParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PermissionObserverOnPermissionStatusChangeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PermissionObserverOnPermissionStatusChangeParams result =
            new PermissionObserverOnPermissionStatusChangeParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.status = readInt;
        PermissionStatus.validate(readInt);
        result.status = PermissionStatus.toKnownValue(result.status);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.status, 8);
    }
  }
}
