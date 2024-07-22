package org.chromium.service_manager.mojom;

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
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.InvalidHandle;
import org.chromium.mojo.system.MessagePipeHandle;

class Connector_Internal {
  private static final int BIND_INTERFACE_ORDINAL = 0;
  private static final int CLONE_ORDINAL = 4;
  public static final Interface.Manager<Connector, Connector.Proxy> MANAGER =
      new Interface.Manager<Connector, Connector.Proxy>() {
        @Override
        public String getName() {
          return "service_manager.mojom.Connector";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public Connector.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, Connector impl) {
          return new Stub(core, impl);
        }

        @Override
        public Connector[] buildArray(int size) {
          return new Connector[size];
        }
      };
  private static final int QUERY_SERVICE_ORDINAL = 1;
  private static final int REGISTER_SERVICE_INSTANCE_ORDINAL = 3;
  private static final int WARM_SERVICE_ORDINAL = 2;

  Connector_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements Connector.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void bindInterface(
        ServiceFilter filter,
        String interfaceName,
        MessagePipeHandle interfacePipe,
        int priority,
        BindInterface_Response callback) {
      ConnectorBindInterfaceParams _message = new ConnectorBindInterfaceParams();
      _message.filter = filter;
      _message.interfaceName = interfaceName;
      _message.interfacePipe = interfacePipe;
      _message.priority = priority;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new ConnectorBindInterfaceResponseParamsForwardToCallback(callback));
    }

    @Override
    public void queryService(String serviceName, QueryService_Response callback) {
      ConnectorQueryServiceParams _message = new ConnectorQueryServiceParams();
      _message.serviceName = serviceName;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new ConnectorQueryServiceResponseParamsForwardToCallback(callback));
    }

    @Override
    public void warmService(ServiceFilter filter, WarmService_Response callback) {
      ConnectorWarmServiceParams _message = new ConnectorWarmServiceParams();
      _message.filter = filter;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new ConnectorWarmServiceResponseParamsForwardToCallback(callback));
    }

    @Override
    public void registerServiceInstance(
        Identity identity,
        MessagePipeHandle service,
        InterfaceRequest<ProcessMetadata> metadataReceiver,
        RegisterServiceInstance_Response callback) {
      ConnectorRegisterServiceInstanceParams _message =
          new ConnectorRegisterServiceInstanceParams();
      _message.identity = identity;
      _message.service = service;
      _message.metadataReceiver = metadataReceiver;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)),
              new ConnectorRegisterServiceInstanceResponseParamsForwardToCallback(callback));
    }

    @Override
    public void clone(InterfaceRequest<Connector> receiver) {
      ConnectorCloneParams _message = new ConnectorCloneParams();
      _message.receiver = receiver;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
    }
  }

  public static final class Stub extends Interface.Stub<Connector> {
    Stub(Core core, Connector impl) {
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
                Connector_Internal.MANAGER, messageWithHeader);
          case 4:
            ConnectorCloneParams data =
                ConnectorCloneParams.deserialize(messageWithHeader.getPayload());
            getImpl().clone(data.receiver);
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
                getCore(), Connector_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            ConnectorBindInterfaceParams data =
                ConnectorBindInterfaceParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .bindInterface(
                    data.filter,
                    data.interfaceName,
                    data.interfacePipe,
                    data.priority,
                    new ConnectorBindInterfaceResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
            getImpl()
                .queryService(
                    ConnectorQueryServiceParams.deserialize(messageWithHeader.getPayload())
                        .serviceName,
                    new ConnectorQueryServiceResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 2:
            getImpl()
                .warmService(
                    ConnectorWarmServiceParams.deserialize(messageWithHeader.getPayload()).filter,
                    new ConnectorWarmServiceResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 3:
            ConnectorRegisterServiceInstanceParams data2 =
                ConnectorRegisterServiceInstanceParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .registerServiceInstance(
                    data2.identity,
                    data2.service,
                    data2.metadataReceiver,
                    new ConnectorRegisterServiceInstanceResponseParamsProxyToResponder(
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

  static final class ConnectorBindInterfaceParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public ServiceFilter filter;
    public String interfaceName;
    public MessagePipeHandle interfacePipe;
    public int priority;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ConnectorBindInterfaceParams(int version) {
      super(32, version);
      this.interfacePipe = InvalidHandle.INSTANCE;
    }

    public ConnectorBindInterfaceParams() {
      this(0);
    }

    public static ConnectorBindInterfaceParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ConnectorBindInterfaceParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ConnectorBindInterfaceParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ConnectorBindInterfaceParams result = new ConnectorBindInterfaceParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.filter = ServiceFilter.decode(decoder1);
        result.interfaceName = decoder0.readString(16, false);
        result.interfacePipe = decoder0.readMessagePipeHandle(24, false);
        int readInt = decoder0.readInt(28);
        result.priority = readInt;
        BindInterfacePriority.validate(readInt);
        result.priority = BindInterfacePriority.toKnownValue(result.priority);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.filter, 8, false);
      encoder0.encode(this.interfaceName, 16, false);
      encoder0.encode((Handle) this.interfacePipe, 24, false);
      encoder0.encode(this.priority, 28);
    }
  }

  static final class ConnectorBindInterfaceResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public Identity identity;
    public int result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ConnectorBindInterfaceResponseParams(int version) {
      super(24, version);
    }

    public ConnectorBindInterfaceResponseParams() {
      this(0);
    }

    public static ConnectorBindInterfaceResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ConnectorBindInterfaceResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ConnectorBindInterfaceResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ConnectorBindInterfaceResponseParams result =
            new ConnectorBindInterfaceResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.result = readInt;
        ConnectResult.validate(readInt);
        result.result = ConnectResult.toKnownValue(result.result);
        Decoder decoder1 = decoder0.readPointer(16, true);
        result.identity = Identity.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.result, 8);
      encoder0.encode((Struct) this.identity, 16, true);
    }
  }

  static class ConnectorBindInterfaceResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final Connector.BindInterface_Response mCallback;

    ConnectorBindInterfaceResponseParamsForwardToCallback(
        Connector.BindInterface_Response callback) {
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
        ConnectorBindInterfaceResponseParams response =
            ConnectorBindInterfaceResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.result, response.identity);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ConnectorBindInterfaceResponseParamsProxyToResponder
      implements Connector.BindInterface_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ConnectorBindInterfaceResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int result, Identity identity) {
      ConnectorBindInterfaceResponseParams _response = new ConnectorBindInterfaceResponseParams();
      _response.result = result;
      _response.identity = identity;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ConnectorQueryServiceParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String serviceName;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ConnectorQueryServiceParams(int version) {
      super(16, version);
    }

    public ConnectorQueryServiceParams() {
      this(0);
    }

    public static ConnectorQueryServiceParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ConnectorQueryServiceParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ConnectorQueryServiceParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ConnectorQueryServiceParams result = new ConnectorQueryServiceParams(elementsOrVersion);
        result.serviceName = decoder0.readString(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.serviceName, 8, false);
    }
  }

  static final class ConnectorQueryServiceResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public ServiceInfo info;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ConnectorQueryServiceResponseParams(int version) {
      super(16, version);
    }

    public ConnectorQueryServiceResponseParams() {
      this(0);
    }

    public static ConnectorQueryServiceResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ConnectorQueryServiceResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ConnectorQueryServiceResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ConnectorQueryServiceResponseParams result =
            new ConnectorQueryServiceResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.info = ServiceInfo.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.info, 8, true);
    }
  }

  static class ConnectorQueryServiceResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final Connector.QueryService_Response mCallback;

    ConnectorQueryServiceResponseParamsForwardToCallback(Connector.QueryService_Response callback) {
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
        ConnectorQueryServiceResponseParams response =
            ConnectorQueryServiceResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.info);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ConnectorQueryServiceResponseParamsProxyToResponder
      implements Connector.QueryService_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ConnectorQueryServiceResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(ServiceInfo info) {
      ConnectorQueryServiceResponseParams _response = new ConnectorQueryServiceResponseParams();
      _response.info = info;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ConnectorWarmServiceParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public ServiceFilter filter;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ConnectorWarmServiceParams(int version) {
      super(16, version);
    }

    public ConnectorWarmServiceParams() {
      this(0);
    }

    public static ConnectorWarmServiceParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ConnectorWarmServiceParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ConnectorWarmServiceParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ConnectorWarmServiceParams result = new ConnectorWarmServiceParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.filter = ServiceFilter.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.filter, 8, false);
    }
  }

  static final class ConnectorWarmServiceResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public Identity identity;
    public int result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ConnectorWarmServiceResponseParams(int version) {
      super(24, version);
    }

    public ConnectorWarmServiceResponseParams() {
      this(0);
    }

    public static ConnectorWarmServiceResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ConnectorWarmServiceResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ConnectorWarmServiceResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ConnectorWarmServiceResponseParams result =
            new ConnectorWarmServiceResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.result = readInt;
        ConnectResult.validate(readInt);
        result.result = ConnectResult.toKnownValue(result.result);
        Decoder decoder1 = decoder0.readPointer(16, true);
        result.identity = Identity.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.result, 8);
      encoder0.encode((Struct) this.identity, 16, true);
    }
  }

  static class ConnectorWarmServiceResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final Connector.WarmService_Response mCallback;

    ConnectorWarmServiceResponseParamsForwardToCallback(Connector.WarmService_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(2, 2)) {
          return false;
        }
        ConnectorWarmServiceResponseParams response =
            ConnectorWarmServiceResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.result, response.identity);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ConnectorWarmServiceResponseParamsProxyToResponder
      implements Connector.WarmService_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ConnectorWarmServiceResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int result, Identity identity) {
      ConnectorWarmServiceResponseParams _response = new ConnectorWarmServiceResponseParams();
      _response.result = result;
      _response.identity = identity;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ConnectorRegisterServiceInstanceParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public Identity identity;
    public InterfaceRequest<ProcessMetadata> metadataReceiver;
    public MessagePipeHandle service;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ConnectorRegisterServiceInstanceParams(int version) {
      super(24, version);
      this.service = InvalidHandle.INSTANCE;
    }

    public ConnectorRegisterServiceInstanceParams() {
      this(0);
    }

    public static ConnectorRegisterServiceInstanceParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ConnectorRegisterServiceInstanceParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ConnectorRegisterServiceInstanceParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ConnectorRegisterServiceInstanceParams result =
            new ConnectorRegisterServiceInstanceParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.identity = Identity.decode(decoder1);
        result.service = decoder0.readMessagePipeHandle(16, false);
        result.metadataReceiver = decoder0.readInterfaceRequest(20, true);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.identity, 8, false);
      encoder0.encode((Handle) this.service, 16, false);
      encoder0.encode((InterfaceRequest) this.metadataReceiver, 20, true);
    }
  }

  static final class ConnectorRegisterServiceInstanceResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ConnectorRegisterServiceInstanceResponseParams(int version) {
      super(16, version);
    }

    public ConnectorRegisterServiceInstanceResponseParams() {
      this(0);
    }

    public static ConnectorRegisterServiceInstanceResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ConnectorRegisterServiceInstanceResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ConnectorRegisterServiceInstanceResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ConnectorRegisterServiceInstanceResponseParams result =
            new ConnectorRegisterServiceInstanceResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.result = readInt;
        ConnectResult.validate(readInt);
        result.result = ConnectResult.toKnownValue(result.result);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.result, 8);
    }
  }

  static class ConnectorRegisterServiceInstanceResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final Connector.RegisterServiceInstance_Response mCallback;

    ConnectorRegisterServiceInstanceResponseParamsForwardToCallback(
        Connector.RegisterServiceInstance_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(3, 2)) {
          return false;
        }
        ConnectorRegisterServiceInstanceResponseParams response =
            ConnectorRegisterServiceInstanceResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ConnectorRegisterServiceInstanceResponseParamsProxyToResponder
      implements Connector.RegisterServiceInstance_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ConnectorRegisterServiceInstanceResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int result) {
      ConnectorRegisterServiceInstanceResponseParams _response =
          new ConnectorRegisterServiceInstanceResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ConnectorCloneParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<Connector> receiver;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ConnectorCloneParams(int version) {
      super(16, version);
    }

    public ConnectorCloneParams() {
      this(0);
    }

    public static ConnectorCloneParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ConnectorCloneParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ConnectorCloneParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ConnectorCloneParams result = new ConnectorCloneParams(elementsOrVersion);
        result.receiver = decoder0.readInterfaceRequest(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.receiver, 8, false);
    }
  }
}
