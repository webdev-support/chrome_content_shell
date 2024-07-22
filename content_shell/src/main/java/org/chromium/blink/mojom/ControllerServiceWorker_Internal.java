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
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;
import org.chromium.network.mojom.CrossOriginEmbedderPolicy;
import org.chromium.network.mojom.CrossOriginEmbedderPolicyReporter;

class ControllerServiceWorker_Internal {
  private static final int CLONE_ORDINAL = 1;
  private static final int DISPATCH_FETCH_EVENT_FOR_SUBRESOURCE_ORDINAL = 0;
  public static final Interface.Manager<ControllerServiceWorker, ControllerServiceWorker.Proxy>
      MANAGER =
          new Interface.Manager<ControllerServiceWorker, ControllerServiceWorker.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.ControllerServiceWorker";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public ControllerServiceWorker.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, ControllerServiceWorker impl) {
              return new Stub(core, impl);
            }

            @Override
            public ControllerServiceWorker[] buildArray(int size) {
              return new ControllerServiceWorker[size];
            }
          };

  ControllerServiceWorker_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements ControllerServiceWorker.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void dispatchFetchEventForSubresource(
        DispatchFetchEventParams params,
        ServiceWorkerFetchResponseCallback responseCallback,
        DispatchFetchEventForSubresource_Response callback) {
      ControllerServiceWorkerDispatchFetchEventForSubresourceParams _message =
          new ControllerServiceWorkerDispatchFetchEventForSubresourceParams();
      _message.params = params;
      _message.responseCallback = responseCallback;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new ControllerServiceWorkerDispatchFetchEventForSubresourceResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void clone(
        InterfaceRequest<ControllerServiceWorker> receiver,
        CrossOriginEmbedderPolicy crossOriginEmbedderPolicy,
        CrossOriginEmbedderPolicyReporter coepReporter) {
      ControllerServiceWorkerCloneParams _message = new ControllerServiceWorkerCloneParams();
      _message.receiver = receiver;
      _message.crossOriginEmbedderPolicy = crossOriginEmbedderPolicy;
      _message.coepReporter = coepReporter;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }
  }

  public static final class Stub extends Interface.Stub<ControllerServiceWorker> {
    Stub(Core core, ControllerServiceWorker impl) {
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
                ControllerServiceWorker_Internal.MANAGER, messageWithHeader);
          case 1:
            ControllerServiceWorkerCloneParams data =
                ControllerServiceWorkerCloneParams.deserialize(messageWithHeader.getPayload());
            getImpl().clone(data.receiver, data.crossOriginEmbedderPolicy, data.coepReporter);
            return true;
          default:
            return false;
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
                getCore(), ControllerServiceWorker_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            ControllerServiceWorkerDispatchFetchEventForSubresourceParams data =
                ControllerServiceWorkerDispatchFetchEventForSubresourceParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .dispatchFetchEventForSubresource(
                    data.params,
                    data.responseCallback,
                    new ControllerServiceWorkerDispatchFetchEventForSubresourceResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class ControllerServiceWorkerDispatchFetchEventForSubresourceParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public DispatchFetchEventParams params;
    public ServiceWorkerFetchResponseCallback responseCallback;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ControllerServiceWorkerDispatchFetchEventForSubresourceParams(int version) {
      super(24, version);
    }

    public ControllerServiceWorkerDispatchFetchEventForSubresourceParams() {
      this(0);
    }

    public static ControllerServiceWorkerDispatchFetchEventForSubresourceParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ControllerServiceWorkerDispatchFetchEventForSubresourceParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ControllerServiceWorkerDispatchFetchEventForSubresourceParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ControllerServiceWorkerDispatchFetchEventForSubresourceParams result =
            new ControllerServiceWorkerDispatchFetchEventForSubresourceParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.params = DispatchFetchEventParams.decode(decoder1);
        result.responseCallback =
            (ServiceWorkerFetchResponseCallback)
                decoder0.readServiceInterface(
                    16, false, ServiceWorkerFetchResponseCallback.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.params, 8, false);
      encoder0.encode(this.responseCallback, 16, false, ServiceWorkerFetchResponseCallback.MANAGER);
    }
  }

  static final class ControllerServiceWorkerDispatchFetchEventForSubresourceResponseParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int status;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ControllerServiceWorkerDispatchFetchEventForSubresourceResponseParams(int version) {
      super(16, version);
    }

    public ControllerServiceWorkerDispatchFetchEventForSubresourceResponseParams() {
      this(0);
    }

    public static ControllerServiceWorkerDispatchFetchEventForSubresourceResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ControllerServiceWorkerDispatchFetchEventForSubresourceResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ControllerServiceWorkerDispatchFetchEventForSubresourceResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ControllerServiceWorkerDispatchFetchEventForSubresourceResponseParams result =
            new ControllerServiceWorkerDispatchFetchEventForSubresourceResponseParams(
                elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.status = readInt;
        ServiceWorkerEventStatus.validate(readInt);
        result.status = ServiceWorkerEventStatus.toKnownValue(result.status);
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

  static
  class ControllerServiceWorkerDispatchFetchEventForSubresourceResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ControllerServiceWorker.DispatchFetchEventForSubresource_Response mCallback;

    ControllerServiceWorkerDispatchFetchEventForSubresourceResponseParamsForwardToCallback(
        ControllerServiceWorker.DispatchFetchEventForSubresource_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(0, 2)) {
          return false;
        }
        ControllerServiceWorkerDispatchFetchEventForSubresourceResponseParams response =
            ControllerServiceWorkerDispatchFetchEventForSubresourceResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.status);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ControllerServiceWorkerDispatchFetchEventForSubresourceResponseParamsProxyToResponder
      implements ControllerServiceWorker.DispatchFetchEventForSubresource_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ControllerServiceWorkerDispatchFetchEventForSubresourceResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int status) {
      ControllerServiceWorkerDispatchFetchEventForSubresourceResponseParams _response =
          new ControllerServiceWorkerDispatchFetchEventForSubresourceResponseParams();
      _response.status = status;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ControllerServiceWorkerCloneParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public CrossOriginEmbedderPolicyReporter coepReporter;
    public CrossOriginEmbedderPolicy crossOriginEmbedderPolicy;
    public InterfaceRequest<ControllerServiceWorker> receiver;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ControllerServiceWorkerCloneParams(int version) {
      super(32, version);
    }

    public ControllerServiceWorkerCloneParams() {
      this(0);
    }

    public static ControllerServiceWorkerCloneParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ControllerServiceWorkerCloneParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ControllerServiceWorkerCloneParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ControllerServiceWorkerCloneParams result =
            new ControllerServiceWorkerCloneParams(elementsOrVersion);
        result.receiver = decoder0.readInterfaceRequest(8, false);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.crossOriginEmbedderPolicy = CrossOriginEmbedderPolicy.decode(decoder1);
        result.coepReporter =
            (CrossOriginEmbedderPolicyReporter)
                decoder0.readServiceInterface(24, true, CrossOriginEmbedderPolicyReporter.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.receiver, 8, false);
      encoder0.encode((Struct) this.crossOriginEmbedderPolicy, 16, false);
      encoder0.encode(this.coepReporter, 24, true, CrossOriginEmbedderPolicyReporter.MANAGER);
    }
  }
}
