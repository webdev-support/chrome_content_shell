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

class ServiceWorkerStreamCallback_Internal {
  public static final Interface.Manager<
          ServiceWorkerStreamCallback, ServiceWorkerStreamCallback.Proxy>
      MANAGER =
          new Interface.Manager<ServiceWorkerStreamCallback, ServiceWorkerStreamCallback.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.ServiceWorkerStreamCallback";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public ServiceWorkerStreamCallback.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, ServiceWorkerStreamCallback impl) {
              return new Stub(core, impl);
            }

            @Override
            public ServiceWorkerStreamCallback[] buildArray(int size) {
              return new ServiceWorkerStreamCallback[size];
            }
          };
  private static final int ON_ABORTED_ORDINAL = 1;
  private static final int ON_COMPLETED_ORDINAL = 0;

  ServiceWorkerStreamCallback_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements ServiceWorkerStreamCallback.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onCompleted() {
      ServiceWorkerStreamCallbackOnCompletedParams _message =
          new ServiceWorkerStreamCallbackOnCompletedParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void onAborted() {
      ServiceWorkerStreamCallbackOnAbortedParams _message =
          new ServiceWorkerStreamCallbackOnAbortedParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }
  }

  public static final class Stub extends Interface.Stub<ServiceWorkerStreamCallback> {
    Stub(Core core, ServiceWorkerStreamCallback impl) {
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
                ServiceWorkerStreamCallback_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            ServiceWorkerStreamCallbackOnCompletedParams.deserialize(
                messageWithHeader.getPayload());
            getImpl().onCompleted();
            return true;
          case 1:
            ServiceWorkerStreamCallbackOnAbortedParams.deserialize(messageWithHeader.getPayload());
            getImpl().onAborted();
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
                ServiceWorkerStreamCallback_Internal.MANAGER,
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

  static final class ServiceWorkerStreamCallbackOnCompletedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerStreamCallbackOnCompletedParams(int version) {
      super(8, version);
    }

    public ServiceWorkerStreamCallbackOnCompletedParams() {
      this(0);
    }

    public static ServiceWorkerStreamCallbackOnCompletedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerStreamCallbackOnCompletedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerStreamCallbackOnCompletedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerStreamCallbackOnCompletedParams result =
            new ServiceWorkerStreamCallbackOnCompletedParams(elementsOrVersion);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    }
  }

  static final class ServiceWorkerStreamCallbackOnAbortedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerStreamCallbackOnAbortedParams(int version) {
      super(8, version);
    }

    public ServiceWorkerStreamCallbackOnAbortedParams() {
      this(0);
    }

    public static ServiceWorkerStreamCallbackOnAbortedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerStreamCallbackOnAbortedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerStreamCallbackOnAbortedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerStreamCallbackOnAbortedParams result =
            new ServiceWorkerStreamCallbackOnAbortedParams(elementsOrVersion);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    }
  }
}
