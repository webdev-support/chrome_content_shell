package org.chromium.service_manager.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.AssociatedInterfaceRequestNotSupported;
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
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.InvalidHandle;
import org.chromium.mojo.system.MessagePipeHandle;

class Service_Internal {
  private static final int CREATE_PACKAGED_SERVICE_INSTANCE_ORDINAL = 2;
  public static final Interface.Manager<Service, Service.Proxy> MANAGER =
      new Interface.Manager<Service, Service.Proxy>() {
        @Override
        public String getName() {
          return "service_manager.mojom.Service";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public Service.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, Service impl) {
          return new Stub(core, impl);
        }

        @Override
        public Service[] buildArray(int size) {
          return new Service[size];
        }
      };
  private static final int ON_BIND_INTERFACE_ORDINAL = 1;
  private static final int ON_START_ORDINAL = 0;

  Service_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements Service.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onStart(Identity identity, OnStart_Response callback) {
      ServiceOnStartParams _message = new ServiceOnStartParams();
      _message.identity = identity;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new ServiceOnStartResponseParamsForwardToCallback(callback));
    }

    @Override
    public void onBindInterface(
        BindSourceInfo source,
        String interfaceName,
        MessagePipeHandle interfacePipe,
        OnBindInterface_Response callback) {
      ServiceOnBindInterfaceParams _message = new ServiceOnBindInterfaceParams();
      _message.source = source;
      _message.interfaceName = interfaceName;
      _message.interfacePipe = interfacePipe;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new ServiceOnBindInterfaceResponseParamsForwardToCallback(callback));
    }

    @Override
    public void createPackagedServiceInstance(
        Identity identity, InterfaceRequest<Service> receiver, ProcessMetadata metadata) {
      ServiceCreatePackagedServiceInstanceParams _message =
          new ServiceCreatePackagedServiceInstanceParams();
      _message.identity = identity;
      _message.receiver = receiver;
      _message.metadata = metadata;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }
  }

  public static final class Stub extends Interface.Stub<Service> {
    Stub(Core core, Service impl) {
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
                Service_Internal.MANAGER, messageWithHeader);
          case 2:
            ServiceCreatePackagedServiceInstanceParams data =
                ServiceCreatePackagedServiceInstanceParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().createPackagedServiceInstance(data.identity, data.receiver, data.metadata);
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
                getCore(), Service_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            getImpl()
                .onStart(
                    ServiceOnStartParams.deserialize(messageWithHeader.getPayload()).identity,
                    new ServiceOnStartResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
            ServiceOnBindInterfaceParams data =
                ServiceOnBindInterfaceParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .onBindInterface(
                    data.source,
                    data.interfaceName,
                    data.interfacePipe,
                    new ServiceOnBindInterfaceResponseParamsProxyToResponder(
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

  static final class ServiceOnStartParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Identity identity;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceOnStartParams(int version) {
      super(16, version);
    }

    public ServiceOnStartParams() {
      this(0);
    }

    public static ServiceOnStartParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceOnStartParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceOnStartParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceOnStartParams result = new ServiceOnStartParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.identity = Identity.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.identity, 8, false);
    }
  }

  static final class ServiceOnStartResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<Connector> connectorReceiver;
    public AssociatedInterfaceRequestNotSupported controlReceiver;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceOnStartResponseParams(int version) {
      super(16, version);
    }

    public ServiceOnStartResponseParams() {
      this(0);
    }

    public static ServiceOnStartResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceOnStartResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceOnStartResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceOnStartResponseParams result = new ServiceOnStartResponseParams(elementsOrVersion);
        result.connectorReceiver = decoder0.readInterfaceRequest(8, false);
        result.controlReceiver = decoder0.readAssociatedInterfaceRequestNotSupported(12, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.connectorReceiver, 8, false);
      encoder0.encode(this.controlReceiver, 12, false);
    }
  }

  static class ServiceOnStartResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final Service.OnStart_Response mCallback;

    ServiceOnStartResponseParamsForwardToCallback(Service.OnStart_Response callback) {
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
        ServiceOnStartResponseParams response =
            ServiceOnStartResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.connectorReceiver, response.controlReceiver);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ServiceOnStartResponseParamsProxyToResponder implements Service.OnStart_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ServiceOnStartResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(
        InterfaceRequest<Connector> connectorReceiver,
        AssociatedInterfaceRequestNotSupported controlReceiver) {
      ServiceOnStartResponseParams _response = new ServiceOnStartResponseParams();
      _response.connectorReceiver = connectorReceiver;
      _response.controlReceiver = controlReceiver;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ServiceOnBindInterfaceParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public String interfaceName;
    public MessagePipeHandle interfacePipe;
    public BindSourceInfo source;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceOnBindInterfaceParams(int version) {
      super(32, version);
      this.interfacePipe = InvalidHandle.INSTANCE;
    }

    public ServiceOnBindInterfaceParams() {
      this(0);
    }

    public static ServiceOnBindInterfaceParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceOnBindInterfaceParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceOnBindInterfaceParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceOnBindInterfaceParams result = new ServiceOnBindInterfaceParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.source = BindSourceInfo.decode(decoder1);
        result.interfaceName = decoder0.readString(16, false);
        result.interfacePipe = decoder0.readMessagePipeHandle(24, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.source, 8, false);
      encoder0.encode(this.interfaceName, 16, false);
      encoder0.encode((Handle) this.interfacePipe, 24, false);
    }
  }

  static final class ServiceOnBindInterfaceResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceOnBindInterfaceResponseParams(int version) {
      super(8, version);
    }

    public ServiceOnBindInterfaceResponseParams() {
      this(0);
    }

    public static ServiceOnBindInterfaceResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceOnBindInterfaceResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceOnBindInterfaceResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceOnBindInterfaceResponseParams result =
            new ServiceOnBindInterfaceResponseParams(elementsOrVersion);
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

  static class ServiceOnBindInterfaceResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final Service.OnBindInterface_Response mCallback;

    ServiceOnBindInterfaceResponseParamsForwardToCallback(
        Service.OnBindInterface_Response callback) {
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

  static class ServiceOnBindInterfaceResponseParamsProxyToResponder
      implements Service.OnBindInterface_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ServiceOnBindInterfaceResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      ServiceOnBindInterfaceResponseParams _response = new ServiceOnBindInterfaceResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ServiceCreatePackagedServiceInstanceParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public Identity identity;
    public ProcessMetadata metadata;
    public InterfaceRequest<Service> receiver;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceCreatePackagedServiceInstanceParams(int version) {
      super(32, version);
    }

    public ServiceCreatePackagedServiceInstanceParams() {
      this(0);
    }

    public static ServiceCreatePackagedServiceInstanceParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceCreatePackagedServiceInstanceParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceCreatePackagedServiceInstanceParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceCreatePackagedServiceInstanceParams result =
            new ServiceCreatePackagedServiceInstanceParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.identity = Identity.decode(decoder1);
        result.receiver = decoder0.readInterfaceRequest(16, false);
        result.metadata =
            (ProcessMetadata) decoder0.readServiceInterface(20, false, ProcessMetadata.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.identity, 8, false);
      encoder0.encode((InterfaceRequest) this.receiver, 16, false);
      encoder0.encode(this.metadata, 20, false, ProcessMetadata.MANAGER);
    }
  }
}
