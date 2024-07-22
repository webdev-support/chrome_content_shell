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

class ServiceWorkerRegistrationObject_Internal {
  public static final Interface.Manager<
          ServiceWorkerRegistrationObject, ServiceWorkerRegistrationObject.Proxy>
      MANAGER =
          new Interface.Manager<
              ServiceWorkerRegistrationObject, ServiceWorkerRegistrationObject.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.ServiceWorkerRegistrationObject";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public ServiceWorkerRegistrationObject.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, ServiceWorkerRegistrationObject impl) {
              return new Stub(core, impl);
            }

            @Override
            public ServiceWorkerRegistrationObject[] buildArray(int size) {
              return new ServiceWorkerRegistrationObject[size];
            }
          };
  private static final int SET_SERVICE_WORKER_OBJECTS_ORDINAL = 0;
  private static final int SET_UPDATE_VIA_CACHE_ORDINAL = 1;
  private static final int UPDATE_FOUND_ORDINAL = 2;

  ServiceWorkerRegistrationObject_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements ServiceWorkerRegistrationObject.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void setServiceWorkerObjects(
        ChangedServiceWorkerObjectsMask changedMask,
        ServiceWorkerObjectInfo installing,
        ServiceWorkerObjectInfo waiting,
        ServiceWorkerObjectInfo active) {
      ServiceWorkerRegistrationObjectSetServiceWorkerObjectsParams _message =
          new ServiceWorkerRegistrationObjectSetServiceWorkerObjectsParams();
      _message.changedMask = changedMask;
      _message.installing = installing;
      _message.waiting = waiting;
      _message.active = active;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void setUpdateViaCache(int updateViaCache) {
      ServiceWorkerRegistrationObjectSetUpdateViaCacheParams _message =
          new ServiceWorkerRegistrationObjectSetUpdateViaCacheParams();
      _message.updateViaCache = updateViaCache;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void updateFound() {
      ServiceWorkerRegistrationObjectUpdateFoundParams _message =
          new ServiceWorkerRegistrationObjectUpdateFoundParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }
  }

  public static final class Stub extends Interface.Stub<ServiceWorkerRegistrationObject> {
    Stub(Core core, ServiceWorkerRegistrationObject impl) {
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
                ServiceWorkerRegistrationObject_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            ServiceWorkerRegistrationObjectSetServiceWorkerObjectsParams data =
                ServiceWorkerRegistrationObjectSetServiceWorkerObjectsParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .setServiceWorkerObjects(
                    data.changedMask, data.installing, data.waiting, data.active);
            return true;
          case 1:
            getImpl()
                .setUpdateViaCache(
                    ServiceWorkerRegistrationObjectSetUpdateViaCacheParams.deserialize(
                            messageWithHeader.getPayload())
                        .updateViaCache);
            return true;
          case 2:
            ServiceWorkerRegistrationObjectUpdateFoundParams.deserialize(
                messageWithHeader.getPayload());
            getImpl().updateFound();
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
                ServiceWorkerRegistrationObject_Internal.MANAGER,
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

  static final class ServiceWorkerRegistrationObjectSetServiceWorkerObjectsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public ServiceWorkerObjectInfo active;
    public ChangedServiceWorkerObjectsMask changedMask;
    public ServiceWorkerObjectInfo installing;
    public ServiceWorkerObjectInfo waiting;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerRegistrationObjectSetServiceWorkerObjectsParams(int version) {
      super(40, version);
    }

    public ServiceWorkerRegistrationObjectSetServiceWorkerObjectsParams() {
      this(0);
    }

    public static ServiceWorkerRegistrationObjectSetServiceWorkerObjectsParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerRegistrationObjectSetServiceWorkerObjectsParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerRegistrationObjectSetServiceWorkerObjectsParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerRegistrationObjectSetServiceWorkerObjectsParams result =
            new ServiceWorkerRegistrationObjectSetServiceWorkerObjectsParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.changedMask = ChangedServiceWorkerObjectsMask.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, true);
        result.installing = ServiceWorkerObjectInfo.decode(decoder12);
        Decoder decoder13 = decoder0.readPointer(24, true);
        result.waiting = ServiceWorkerObjectInfo.decode(decoder13);
        Decoder decoder14 = decoder0.readPointer(32, true);
        result.active = ServiceWorkerObjectInfo.decode(decoder14);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.changedMask, 8, false);
      encoder0.encode((Struct) this.installing, 16, true);
      encoder0.encode((Struct) this.waiting, 24, true);
      encoder0.encode((Struct) this.active, 32, true);
    }
  }

  static final class ServiceWorkerRegistrationObjectSetUpdateViaCacheParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int updateViaCache;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerRegistrationObjectSetUpdateViaCacheParams(int version) {
      super(16, version);
    }

    public ServiceWorkerRegistrationObjectSetUpdateViaCacheParams() {
      this(0);
    }

    public static ServiceWorkerRegistrationObjectSetUpdateViaCacheParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerRegistrationObjectSetUpdateViaCacheParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerRegistrationObjectSetUpdateViaCacheParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerRegistrationObjectSetUpdateViaCacheParams result =
            new ServiceWorkerRegistrationObjectSetUpdateViaCacheParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.updateViaCache = readInt;
        ServiceWorkerUpdateViaCache.validate(readInt);
        result.updateViaCache = ServiceWorkerUpdateViaCache.toKnownValue(result.updateViaCache);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.updateViaCache, 8);
    }
  }

  static final class ServiceWorkerRegistrationObjectUpdateFoundParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerRegistrationObjectUpdateFoundParams(int version) {
      super(8, version);
    }

    public ServiceWorkerRegistrationObjectUpdateFoundParams() {
      this(0);
    }

    public static ServiceWorkerRegistrationObjectUpdateFoundParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerRegistrationObjectUpdateFoundParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerRegistrationObjectUpdateFoundParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerRegistrationObjectUpdateFoundParams result =
            new ServiceWorkerRegistrationObjectUpdateFoundParams(elementsOrVersion);
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
