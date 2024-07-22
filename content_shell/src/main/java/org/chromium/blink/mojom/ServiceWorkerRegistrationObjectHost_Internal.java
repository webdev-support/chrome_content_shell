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

class ServiceWorkerRegistrationObjectHost_Internal {
  private static final int ENABLE_NAVIGATION_PRELOAD_ORDINAL = 2;
  private static final int GET_NAVIGATION_PRELOAD_STATE_ORDINAL = 3;
  public static final Interface.Manager<
          ServiceWorkerRegistrationObjectHost, ServiceWorkerRegistrationObjectHost.Proxy>
      MANAGER =
          new Interface.Manager<
              ServiceWorkerRegistrationObjectHost, ServiceWorkerRegistrationObjectHost.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.ServiceWorkerRegistrationObjectHost";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public ServiceWorkerRegistrationObjectHost.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, ServiceWorkerRegistrationObjectHost impl) {
              return new Stub(core, impl);
            }

            @Override
            public ServiceWorkerRegistrationObjectHost[] buildArray(int size) {
              return new ServiceWorkerRegistrationObjectHost[size];
            }
          };
  private static final int SET_NAVIGATION_PRELOAD_HEADER_ORDINAL = 4;
  private static final int UNREGISTER_ORDINAL = 1;
  private static final int UPDATE_ORDINAL = 0;

  ServiceWorkerRegistrationObjectHost_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements ServiceWorkerRegistrationObjectHost.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void update(
        FetchClientSettingsObject outsideFetchClientSettingsObject, Update_Response callback) {
      ServiceWorkerRegistrationObjectHostUpdateParams _message =
          new ServiceWorkerRegistrationObjectHostUpdateParams();
      _message.outsideFetchClientSettingsObject = outsideFetchClientSettingsObject;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new ServiceWorkerRegistrationObjectHostUpdateResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void unregister(Unregister_Response callback) {
      ServiceWorkerRegistrationObjectHostUnregisterParams _message =
          new ServiceWorkerRegistrationObjectHostUnregisterParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new ServiceWorkerRegistrationObjectHostUnregisterResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void enableNavigationPreload(boolean enable, EnableNavigationPreload_Response callback) {
      ServiceWorkerRegistrationObjectHostEnableNavigationPreloadParams _message =
          new ServiceWorkerRegistrationObjectHostEnableNavigationPreloadParams();
      _message.enable = enable;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new ServiceWorkerRegistrationObjectHostEnableNavigationPreloadResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void getNavigationPreloadState(GetNavigationPreloadState_Response callback) {
      ServiceWorkerRegistrationObjectHostGetNavigationPreloadStateParams _message =
          new ServiceWorkerRegistrationObjectHostGetNavigationPreloadStateParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)),
              new ServiceWorkerRegistrationObjectHostGetNavigationPreloadStateResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void setNavigationPreloadHeader(
        String value, SetNavigationPreloadHeader_Response callback) {
      ServiceWorkerRegistrationObjectHostSetNavigationPreloadHeaderParams _message =
          new ServiceWorkerRegistrationObjectHostSetNavigationPreloadHeaderParams();
      _message.value = value;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)),
              new ServiceWorkerRegistrationObjectHostSetNavigationPreloadHeaderResponseParamsForwardToCallback(
                  callback));
    }
  }

  public static final class Stub extends Interface.Stub<ServiceWorkerRegistrationObjectHost> {
    Stub(Core core, ServiceWorkerRegistrationObjectHost impl) {
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
                ServiceWorkerRegistrationObjectHost_Internal.MANAGER, messageWithHeader);
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
                getCore(),
                ServiceWorkerRegistrationObjectHost_Internal.MANAGER,
                messageWithHeader,
                receiver);
          case 0:
            ServiceWorkerRegistrationObjectHostUpdateParams data =
                ServiceWorkerRegistrationObjectHostUpdateParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .update(
                    data.outsideFetchClientSettingsObject,
                    new ServiceWorkerRegistrationObjectHostUpdateResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
            ServiceWorkerRegistrationObjectHostUnregisterParams.deserialize(
                messageWithHeader.getPayload());
            getImpl()
                .unregister(
                    new ServiceWorkerRegistrationObjectHostUnregisterResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 2:
            ServiceWorkerRegistrationObjectHostEnableNavigationPreloadParams data2 =
                ServiceWorkerRegistrationObjectHostEnableNavigationPreloadParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .enableNavigationPreload(
                    data2.enable,
                    new ServiceWorkerRegistrationObjectHostEnableNavigationPreloadResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 3:
            ServiceWorkerRegistrationObjectHostGetNavigationPreloadStateParams.deserialize(
                messageWithHeader.getPayload());
            getImpl()
                .getNavigationPreloadState(
                    new ServiceWorkerRegistrationObjectHostGetNavigationPreloadStateResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 4:
            ServiceWorkerRegistrationObjectHostSetNavigationPreloadHeaderParams data3 =
                ServiceWorkerRegistrationObjectHostSetNavigationPreloadHeaderParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .setNavigationPreloadHeader(
                    data3.value,
                    new ServiceWorkerRegistrationObjectHostSetNavigationPreloadHeaderResponseParamsProxyToResponder(
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

  static final class ServiceWorkerRegistrationObjectHostUpdateParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public FetchClientSettingsObject outsideFetchClientSettingsObject;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerRegistrationObjectHostUpdateParams(int version) {
      super(16, version);
    }

    public ServiceWorkerRegistrationObjectHostUpdateParams() {
      this(0);
    }

    public static ServiceWorkerRegistrationObjectHostUpdateParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerRegistrationObjectHostUpdateParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerRegistrationObjectHostUpdateParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerRegistrationObjectHostUpdateParams result =
            new ServiceWorkerRegistrationObjectHostUpdateParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.outsideFetchClientSettingsObject = FetchClientSettingsObject.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.outsideFetchClientSettingsObject, 8, false);
    }
  }

  static final class ServiceWorkerRegistrationObjectHostUpdateResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int error;
    public String errorMsg;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerRegistrationObjectHostUpdateResponseParams(int version) {
      super(24, version);
    }

    public ServiceWorkerRegistrationObjectHostUpdateResponseParams() {
      this(0);
    }

    public static ServiceWorkerRegistrationObjectHostUpdateResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerRegistrationObjectHostUpdateResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerRegistrationObjectHostUpdateResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerRegistrationObjectHostUpdateResponseParams result =
            new ServiceWorkerRegistrationObjectHostUpdateResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.error = readInt;
        ServiceWorkerErrorType.validate(readInt);
        result.error = ServiceWorkerErrorType.toKnownValue(result.error);
        result.errorMsg = decoder0.readString(16, true);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.error, 8);
      encoder0.encode(this.errorMsg, 16, true);
    }
  }

  static class ServiceWorkerRegistrationObjectHostUpdateResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ServiceWorkerRegistrationObjectHost.Update_Response mCallback;

    ServiceWorkerRegistrationObjectHostUpdateResponseParamsForwardToCallback(
        ServiceWorkerRegistrationObjectHost.Update_Response callback) {
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
        ServiceWorkerRegistrationObjectHostUpdateResponseParams response =
            ServiceWorkerRegistrationObjectHostUpdateResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.error, response.errorMsg);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ServiceWorkerRegistrationObjectHostUpdateResponseParamsProxyToResponder
      implements ServiceWorkerRegistrationObjectHost.Update_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ServiceWorkerRegistrationObjectHostUpdateResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int error, String errorMsg) {
      ServiceWorkerRegistrationObjectHostUpdateResponseParams _response =
          new ServiceWorkerRegistrationObjectHostUpdateResponseParams();
      _response.error = error;
      _response.errorMsg = errorMsg;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ServiceWorkerRegistrationObjectHostUnregisterParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerRegistrationObjectHostUnregisterParams(int version) {
      super(8, version);
    }

    public ServiceWorkerRegistrationObjectHostUnregisterParams() {
      this(0);
    }

    public static ServiceWorkerRegistrationObjectHostUnregisterParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerRegistrationObjectHostUnregisterParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerRegistrationObjectHostUnregisterParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerRegistrationObjectHostUnregisterParams result =
            new ServiceWorkerRegistrationObjectHostUnregisterParams(elementsOrVersion);
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

  static final class ServiceWorkerRegistrationObjectHostUnregisterResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int error;
    public String errorMsg;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerRegistrationObjectHostUnregisterResponseParams(int version) {
      super(24, version);
    }

    public ServiceWorkerRegistrationObjectHostUnregisterResponseParams() {
      this(0);
    }

    public static ServiceWorkerRegistrationObjectHostUnregisterResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerRegistrationObjectHostUnregisterResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerRegistrationObjectHostUnregisterResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerRegistrationObjectHostUnregisterResponseParams result =
            new ServiceWorkerRegistrationObjectHostUnregisterResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.error = readInt;
        ServiceWorkerErrorType.validate(readInt);
        result.error = ServiceWorkerErrorType.toKnownValue(result.error);
        result.errorMsg = decoder0.readString(16, true);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.error, 8);
      encoder0.encode(this.errorMsg, 16, true);
    }
  }

  static class ServiceWorkerRegistrationObjectHostUnregisterResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ServiceWorkerRegistrationObjectHost.Unregister_Response mCallback;

    ServiceWorkerRegistrationObjectHostUnregisterResponseParamsForwardToCallback(
        ServiceWorkerRegistrationObjectHost.Unregister_Response callback) {
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
        ServiceWorkerRegistrationObjectHostUnregisterResponseParams response =
            ServiceWorkerRegistrationObjectHostUnregisterResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.error, response.errorMsg);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ServiceWorkerRegistrationObjectHostUnregisterResponseParamsProxyToResponder
      implements ServiceWorkerRegistrationObjectHost.Unregister_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ServiceWorkerRegistrationObjectHostUnregisterResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int error, String errorMsg) {
      ServiceWorkerRegistrationObjectHostUnregisterResponseParams _response =
          new ServiceWorkerRegistrationObjectHostUnregisterResponseParams();
      _response.error = error;
      _response.errorMsg = errorMsg;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ServiceWorkerRegistrationObjectHostEnableNavigationPreloadParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean enable;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerRegistrationObjectHostEnableNavigationPreloadParams(int version) {
      super(16, version);
    }

    public ServiceWorkerRegistrationObjectHostEnableNavigationPreloadParams() {
      this(0);
    }

    public static ServiceWorkerRegistrationObjectHostEnableNavigationPreloadParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerRegistrationObjectHostEnableNavigationPreloadParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerRegistrationObjectHostEnableNavigationPreloadParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerRegistrationObjectHostEnableNavigationPreloadParams result =
            new ServiceWorkerRegistrationObjectHostEnableNavigationPreloadParams(elementsOrVersion);
        result.enable = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.enable, 8, 0);
    }
  }

  static final class ServiceWorkerRegistrationObjectHostEnableNavigationPreloadResponseParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int error;
    public String errorMsg;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerRegistrationObjectHostEnableNavigationPreloadResponseParams(int version) {
      super(24, version);
    }

    public ServiceWorkerRegistrationObjectHostEnableNavigationPreloadResponseParams() {
      this(0);
    }

    public static ServiceWorkerRegistrationObjectHostEnableNavigationPreloadResponseParams
        deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerRegistrationObjectHostEnableNavigationPreloadResponseParams
        deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerRegistrationObjectHostEnableNavigationPreloadResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerRegistrationObjectHostEnableNavigationPreloadResponseParams result =
            new ServiceWorkerRegistrationObjectHostEnableNavigationPreloadResponseParams(
                elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.error = readInt;
        ServiceWorkerErrorType.validate(readInt);
        result.error = ServiceWorkerErrorType.toKnownValue(result.error);
        result.errorMsg = decoder0.readString(16, true);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.error, 8);
      encoder0.encode(this.errorMsg, 16, true);
    }
  }

  static
  class ServiceWorkerRegistrationObjectHostEnableNavigationPreloadResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ServiceWorkerRegistrationObjectHost.EnableNavigationPreload_Response mCallback;

    ServiceWorkerRegistrationObjectHostEnableNavigationPreloadResponseParamsForwardToCallback(
        ServiceWorkerRegistrationObjectHost.EnableNavigationPreload_Response callback) {
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
        ServiceWorkerRegistrationObjectHostEnableNavigationPreloadResponseParams response =
            ServiceWorkerRegistrationObjectHostEnableNavigationPreloadResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.error, response.errorMsg);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static
  class ServiceWorkerRegistrationObjectHostEnableNavigationPreloadResponseParamsProxyToResponder
      implements ServiceWorkerRegistrationObjectHost.EnableNavigationPreload_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ServiceWorkerRegistrationObjectHostEnableNavigationPreloadResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int error, String errorMsg) {
      ServiceWorkerRegistrationObjectHostEnableNavigationPreloadResponseParams _response =
          new ServiceWorkerRegistrationObjectHostEnableNavigationPreloadResponseParams();
      _response.error = error;
      _response.errorMsg = errorMsg;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ServiceWorkerRegistrationObjectHostGetNavigationPreloadStateParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerRegistrationObjectHostGetNavigationPreloadStateParams(int version) {
      super(8, version);
    }

    public ServiceWorkerRegistrationObjectHostGetNavigationPreloadStateParams() {
      this(0);
    }

    public static ServiceWorkerRegistrationObjectHostGetNavigationPreloadStateParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerRegistrationObjectHostGetNavigationPreloadStateParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerRegistrationObjectHostGetNavigationPreloadStateParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerRegistrationObjectHostGetNavigationPreloadStateParams result =
            new ServiceWorkerRegistrationObjectHostGetNavigationPreloadStateParams(
                elementsOrVersion);
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

  static final class ServiceWorkerRegistrationObjectHostGetNavigationPreloadStateResponseParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public int error;
    public String errorMsg;
    public NavigationPreloadState state;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerRegistrationObjectHostGetNavigationPreloadStateResponseParams(
        int version) {
      super(32, version);
    }

    public ServiceWorkerRegistrationObjectHostGetNavigationPreloadStateResponseParams() {
      this(0);
    }

    public static ServiceWorkerRegistrationObjectHostGetNavigationPreloadStateResponseParams
        deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerRegistrationObjectHostGetNavigationPreloadStateResponseParams
        deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerRegistrationObjectHostGetNavigationPreloadStateResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerRegistrationObjectHostGetNavigationPreloadStateResponseParams result =
            new ServiceWorkerRegistrationObjectHostGetNavigationPreloadStateResponseParams(
                elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.error = readInt;
        ServiceWorkerErrorType.validate(readInt);
        result.error = ServiceWorkerErrorType.toKnownValue(result.error);
        result.errorMsg = decoder0.readString(16, true);
        Decoder decoder1 = decoder0.readPointer(24, true);
        result.state = NavigationPreloadState.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.error, 8);
      encoder0.encode(this.errorMsg, 16, true);
      encoder0.encode((Struct) this.state, 24, true);
    }
  }

  static
  class ServiceWorkerRegistrationObjectHostGetNavigationPreloadStateResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ServiceWorkerRegistrationObjectHost.GetNavigationPreloadState_Response mCallback;

    ServiceWorkerRegistrationObjectHostGetNavigationPreloadStateResponseParamsForwardToCallback(
        ServiceWorkerRegistrationObjectHost.GetNavigationPreloadState_Response callback) {
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
        ServiceWorkerRegistrationObjectHostGetNavigationPreloadStateResponseParams response =
            ServiceWorkerRegistrationObjectHostGetNavigationPreloadStateResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.error, response.errorMsg, response.state);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static
  class ServiceWorkerRegistrationObjectHostGetNavigationPreloadStateResponseParamsProxyToResponder
      implements ServiceWorkerRegistrationObjectHost.GetNavigationPreloadState_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ServiceWorkerRegistrationObjectHostGetNavigationPreloadStateResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int error, String errorMsg, NavigationPreloadState state) {
      ServiceWorkerRegistrationObjectHostGetNavigationPreloadStateResponseParams _response =
          new ServiceWorkerRegistrationObjectHostGetNavigationPreloadStateResponseParams();
      _response.error = error;
      _response.errorMsg = errorMsg;
      _response.state = state;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ServiceWorkerRegistrationObjectHostSetNavigationPreloadHeaderParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String value;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerRegistrationObjectHostSetNavigationPreloadHeaderParams(int version) {
      super(16, version);
    }

    public ServiceWorkerRegistrationObjectHostSetNavigationPreloadHeaderParams() {
      this(0);
    }

    public static ServiceWorkerRegistrationObjectHostSetNavigationPreloadHeaderParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerRegistrationObjectHostSetNavigationPreloadHeaderParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerRegistrationObjectHostSetNavigationPreloadHeaderParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerRegistrationObjectHostSetNavigationPreloadHeaderParams result =
            new ServiceWorkerRegistrationObjectHostSetNavigationPreloadHeaderParams(
                elementsOrVersion);
        result.value = decoder0.readString(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.value, 8, false);
    }
  }

  static final class ServiceWorkerRegistrationObjectHostSetNavigationPreloadHeaderResponseParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int error;
    public String errorMsg;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerRegistrationObjectHostSetNavigationPreloadHeaderResponseParams(
        int version) {
      super(24, version);
    }

    public ServiceWorkerRegistrationObjectHostSetNavigationPreloadHeaderResponseParams() {
      this(0);
    }

    public static ServiceWorkerRegistrationObjectHostSetNavigationPreloadHeaderResponseParams
        deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerRegistrationObjectHostSetNavigationPreloadHeaderResponseParams
        deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerRegistrationObjectHostSetNavigationPreloadHeaderResponseParams
        decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerRegistrationObjectHostSetNavigationPreloadHeaderResponseParams result =
            new ServiceWorkerRegistrationObjectHostSetNavigationPreloadHeaderResponseParams(
                elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.error = readInt;
        ServiceWorkerErrorType.validate(readInt);
        result.error = ServiceWorkerErrorType.toKnownValue(result.error);
        result.errorMsg = decoder0.readString(16, true);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.error, 8);
      encoder0.encode(this.errorMsg, 16, true);
    }
  }

  static
  class ServiceWorkerRegistrationObjectHostSetNavigationPreloadHeaderResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ServiceWorkerRegistrationObjectHost.SetNavigationPreloadHeader_Response mCallback;

    ServiceWorkerRegistrationObjectHostSetNavigationPreloadHeaderResponseParamsForwardToCallback(
        ServiceWorkerRegistrationObjectHost.SetNavigationPreloadHeader_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(4, 2)) {
          return false;
        }
        ServiceWorkerRegistrationObjectHostSetNavigationPreloadHeaderResponseParams response =
            ServiceWorkerRegistrationObjectHostSetNavigationPreloadHeaderResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.error, response.errorMsg);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static
  class ServiceWorkerRegistrationObjectHostSetNavigationPreloadHeaderResponseParamsProxyToResponder
      implements ServiceWorkerRegistrationObjectHost.SetNavigationPreloadHeader_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ServiceWorkerRegistrationObjectHostSetNavigationPreloadHeaderResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int error, String errorMsg) {
      ServiceWorkerRegistrationObjectHostSetNavigationPreloadHeaderResponseParams _response =
          new ServiceWorkerRegistrationObjectHostSetNavigationPreloadHeaderResponseParams();
      _response.error = error;
      _response.errorMsg = errorMsg;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
