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

class ServiceWorkerObject_Internal {
  public static final Interface.Manager<ServiceWorkerObject, ServiceWorkerObject.Proxy> MANAGER =
      new Interface.Manager<ServiceWorkerObject, ServiceWorkerObject.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.ServiceWorkerObject";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public ServiceWorkerObject.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, ServiceWorkerObject impl) {
          return new Stub(core, impl);
        }

        @Override
        public ServiceWorkerObject[] buildArray(int size) {
          return new ServiceWorkerObject[size];
        }
      };
  private static final int STATE_CHANGED_ORDINAL = 0;

  ServiceWorkerObject_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements ServiceWorkerObject.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void stateChanged(int state) {
      ServiceWorkerObjectStateChangedParams _message = new ServiceWorkerObjectStateChangedParams();
      _message.state = state;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }
  }

  public static final class Stub extends Interface.Stub<ServiceWorkerObject> {
    Stub(Core core, ServiceWorkerObject impl) {
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
                ServiceWorkerObject_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            ServiceWorkerObjectStateChangedParams data =
                ServiceWorkerObjectStateChangedParams.deserialize(messageWithHeader.getPayload());
            getImpl().stateChanged(data.state);
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
                getCore(), ServiceWorkerObject_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class ServiceWorkerObjectStateChangedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int state;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerObjectStateChangedParams(int version) {
      super(16, version);
    }

    public ServiceWorkerObjectStateChangedParams() {
      this(0);
    }

    public static ServiceWorkerObjectStateChangedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerObjectStateChangedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerObjectStateChangedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerObjectStateChangedParams result =
            new ServiceWorkerObjectStateChangedParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.state = readInt;
        ServiceWorkerState.validate(readInt);
        result.state = ServiceWorkerState.toKnownValue(result.state);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.state, 8);
    }
  }
}
