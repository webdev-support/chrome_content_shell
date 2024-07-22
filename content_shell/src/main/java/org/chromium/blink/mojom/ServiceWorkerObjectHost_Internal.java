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
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;

class ServiceWorkerObjectHost_Internal {
  public static final Interface.Manager<ServiceWorkerObjectHost, ServiceWorkerObjectHost.Proxy>
      MANAGER =
          new Interface.Manager<ServiceWorkerObjectHost, ServiceWorkerObjectHost.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.ServiceWorkerObjectHost";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public ServiceWorkerObjectHost.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, ServiceWorkerObjectHost impl) {
              return new Stub(core, impl);
            }

            @Override
            public ServiceWorkerObjectHost[] buildArray(int size) {
              return new ServiceWorkerObjectHost[size];
            }
          };
  private static final int POST_MESSAGE_TO_SERVICE_WORKER_ORDINAL = 0;
  private static final int TERMINATE_FOR_TESTING_ORDINAL = 1;

  ServiceWorkerObjectHost_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements ServiceWorkerObjectHost.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void postMessageToServiceWorker(TransferableMessage message) {
      ServiceWorkerObjectHostPostMessageToServiceWorkerParams _message =
          new ServiceWorkerObjectHostPostMessageToServiceWorkerParams();
      _message.message = message;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void terminateForTesting(TerminateForTesting_Response callback) {
      ServiceWorkerObjectHostTerminateForTestingParams _message =
          new ServiceWorkerObjectHostTerminateForTestingParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new ServiceWorkerObjectHostTerminateForTestingResponseParamsForwardToCallback(
                  callback));
    }
  }

  public static final class Stub extends Interface.Stub<ServiceWorkerObjectHost> {
    Stub(Core core, ServiceWorkerObjectHost impl) {
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
                ServiceWorkerObjectHost_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            ServiceWorkerObjectHostPostMessageToServiceWorkerParams data =
                ServiceWorkerObjectHostPostMessageToServiceWorkerParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().postMessageToServiceWorker(data.message);
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
                getCore(), ServiceWorkerObjectHost_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
          default:
            return false;
          case 1:
            ServiceWorkerObjectHostTerminateForTestingParams.deserialize(
                messageWithHeader.getPayload());
            getImpl()
                .terminateForTesting(
                    new ServiceWorkerObjectHostTerminateForTestingResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class ServiceWorkerObjectHostPostMessageToServiceWorkerParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public TransferableMessage message;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerObjectHostPostMessageToServiceWorkerParams(int version) {
      super(16, version);
    }

    public ServiceWorkerObjectHostPostMessageToServiceWorkerParams() {
      this(0);
    }

    public static ServiceWorkerObjectHostPostMessageToServiceWorkerParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerObjectHostPostMessageToServiceWorkerParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerObjectHostPostMessageToServiceWorkerParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerObjectHostPostMessageToServiceWorkerParams result =
            new ServiceWorkerObjectHostPostMessageToServiceWorkerParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.message = TransferableMessage.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.message, 8, false);
    }
  }

  static final class ServiceWorkerObjectHostTerminateForTestingParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerObjectHostTerminateForTestingParams(int version) {
      super(8, version);
    }

    public ServiceWorkerObjectHostTerminateForTestingParams() {
      this(0);
    }

    public static ServiceWorkerObjectHostTerminateForTestingParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerObjectHostTerminateForTestingParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerObjectHostTerminateForTestingParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerObjectHostTerminateForTestingParams result =
            new ServiceWorkerObjectHostTerminateForTestingParams(elementsOrVersion);
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

  static final class ServiceWorkerObjectHostTerminateForTestingResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerObjectHostTerminateForTestingResponseParams(int version) {
      super(8, version);
    }

    public ServiceWorkerObjectHostTerminateForTestingResponseParams() {
      this(0);
    }

    public static ServiceWorkerObjectHostTerminateForTestingResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerObjectHostTerminateForTestingResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerObjectHostTerminateForTestingResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerObjectHostTerminateForTestingResponseParams result =
            new ServiceWorkerObjectHostTerminateForTestingResponseParams(elementsOrVersion);
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

  static class ServiceWorkerObjectHostTerminateForTestingResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ServiceWorkerObjectHost.TerminateForTesting_Response mCallback;

    ServiceWorkerObjectHostTerminateForTestingResponseParamsForwardToCallback(
        ServiceWorkerObjectHost.TerminateForTesting_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(1, 2)) {
          return false;
        }
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ServiceWorkerObjectHostTerminateForTestingResponseParamsProxyToResponder
      implements ServiceWorkerObjectHost.TerminateForTesting_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ServiceWorkerObjectHostTerminateForTestingResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      ServiceWorkerObjectHostTerminateForTestingResponseParams _response =
          new ServiceWorkerObjectHostTerminateForTestingResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
