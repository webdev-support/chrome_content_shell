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

class ServiceWorkerContainer_Internal {
  private static final int COUNT_FEATURE_ORDINAL = 2;
  public static final Interface.Manager<ServiceWorkerContainer, ServiceWorkerContainer.Proxy>
      MANAGER =
          new Interface.Manager<ServiceWorkerContainer, ServiceWorkerContainer.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.ServiceWorkerContainer";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public ServiceWorkerContainer.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, ServiceWorkerContainer impl) {
              return new Stub(core, impl);
            }

            @Override
            public ServiceWorkerContainer[] buildArray(int size) {
              return new ServiceWorkerContainer[size];
            }
          };
  private static final int POST_MESSAGE_TO_CLIENT_ORDINAL = 1;
  private static final int SET_CONTROLLER_ORDINAL = 0;

  ServiceWorkerContainer_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements ServiceWorkerContainer.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void setController(
        ControllerServiceWorkerInfo controllerInfo, boolean shouldNotifyControllerchange) {
      ServiceWorkerContainerSetControllerParams _message =
          new ServiceWorkerContainerSetControllerParams();
      _message.controllerInfo = controllerInfo;
      _message.shouldNotifyControllerchange = shouldNotifyControllerchange;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void postMessageToClient(ServiceWorkerObjectInfo source, TransferableMessage message) {
      ServiceWorkerContainerPostMessageToClientParams _message =
          new ServiceWorkerContainerPostMessageToClientParams();
      _message.source = source;
      _message.message = message;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void countFeature(int feature) {
      ServiceWorkerContainerCountFeatureParams _message =
          new ServiceWorkerContainerCountFeatureParams();
      _message.feature = feature;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }
  }

  public static final class Stub extends Interface.Stub<ServiceWorkerContainer> {
    Stub(Core core, ServiceWorkerContainer impl) {
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
                ServiceWorkerContainer_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            ServiceWorkerContainerSetControllerParams data =
                ServiceWorkerContainerSetControllerParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().setController(data.controllerInfo, data.shouldNotifyControllerchange);
            return true;
          case 1:
            ServiceWorkerContainerPostMessageToClientParams data2 =
                ServiceWorkerContainerPostMessageToClientParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().postMessageToClient(data2.source, data2.message);
            return true;
          case 2:
            getImpl()
                .countFeature(
                    ServiceWorkerContainerCountFeatureParams.deserialize(
                            messageWithHeader.getPayload())
                        .feature);
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
                getCore(), ServiceWorkerContainer_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class ServiceWorkerContainerSetControllerParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public ControllerServiceWorkerInfo controllerInfo;
    public boolean shouldNotifyControllerchange;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerContainerSetControllerParams(int version) {
      super(24, version);
    }

    public ServiceWorkerContainerSetControllerParams() {
      this(0);
    }

    public static ServiceWorkerContainerSetControllerParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerContainerSetControllerParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerContainerSetControllerParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerContainerSetControllerParams result =
            new ServiceWorkerContainerSetControllerParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.controllerInfo = ControllerServiceWorkerInfo.decode(decoder1);
        result.shouldNotifyControllerchange = decoder0.readBoolean(16, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.controllerInfo, 8, false);
      encoder0.encode(this.shouldNotifyControllerchange, 16, 0);
    }
  }

  static final class ServiceWorkerContainerPostMessageToClientParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public TransferableMessage message;
    public ServiceWorkerObjectInfo source;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerContainerPostMessageToClientParams(int version) {
      super(24, version);
    }

    public ServiceWorkerContainerPostMessageToClientParams() {
      this(0);
    }

    public static ServiceWorkerContainerPostMessageToClientParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerContainerPostMessageToClientParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerContainerPostMessageToClientParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerContainerPostMessageToClientParams result =
            new ServiceWorkerContainerPostMessageToClientParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.source = ServiceWorkerObjectInfo.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.message = TransferableMessage.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.source, 8, false);
      encoder0.encode((Struct) this.message, 16, false);
    }
  }

  static final class ServiceWorkerContainerCountFeatureParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int feature;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerContainerCountFeatureParams(int version) {
      super(16, version);
    }

    public ServiceWorkerContainerCountFeatureParams() {
      this(0);
    }

    public static ServiceWorkerContainerCountFeatureParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerContainerCountFeatureParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerContainerCountFeatureParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerContainerCountFeatureParams result =
            new ServiceWorkerContainerCountFeatureParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.feature = readInt;
        WebFeature.validate(readInt);
        result.feature = WebFeature.toKnownValue(result.feature);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.feature, 8);
    }
  }
}
