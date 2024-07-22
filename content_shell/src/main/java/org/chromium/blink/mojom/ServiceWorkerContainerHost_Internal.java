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
import org.chromium.mojo_base.mojom.FilePath;
import org.chromium.url.mojom.Url;

class ServiceWorkerContainerHost_Internal {
  private static final int CLONE_CONTAINER_HOST_ORDINAL = 5;
  private static final int ENSURE_CONTROLLER_SERVICE_WORKER_ORDINAL = 4;
  private static final int ENSURE_FILE_ACCESS_ORDINAL = 7;
  private static final int GET_REGISTRATIONS_ORDINAL = 2;
  private static final int GET_REGISTRATION_FOR_READY_ORDINAL = 3;
  private static final int GET_REGISTRATION_ORDINAL = 1;
  private static final int HINT_TO_UPDATE_SERVICE_WORKER_ORDINAL = 6;
  public static final Interface.Manager<
          ServiceWorkerContainerHost, ServiceWorkerContainerHost.Proxy>
      MANAGER =
          new Interface.Manager<ServiceWorkerContainerHost, ServiceWorkerContainerHost.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.ServiceWorkerContainerHost";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public ServiceWorkerContainerHost.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, ServiceWorkerContainerHost impl) {
              return new Stub(core, impl);
            }

            @Override
            public ServiceWorkerContainerHost[] buildArray(int size) {
              return new ServiceWorkerContainerHost[size];
            }
          };
  private static final int ON_EXECUTION_READY_ORDINAL = 8;
  private static final int REGISTER_ORDINAL = 0;

  ServiceWorkerContainerHost_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements ServiceWorkerContainerHost.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void register(
        Url scriptUrl,
        ServiceWorkerRegistrationOptions options,
        FetchClientSettingsObject outsideFetchClientSettingsObject,
        Register_Response callback) {
      ServiceWorkerContainerHostRegisterParams _message =
          new ServiceWorkerContainerHostRegisterParams();
      _message.scriptUrl = scriptUrl;
      _message.options = options;
      _message.outsideFetchClientSettingsObject = outsideFetchClientSettingsObject;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new ServiceWorkerContainerHostRegisterResponseParamsForwardToCallback(callback));
    }

    @Override
    public void getRegistration(Url clientUrl, GetRegistration_Response callback) {
      ServiceWorkerContainerHostGetRegistrationParams _message =
          new ServiceWorkerContainerHostGetRegistrationParams();
      _message.clientUrl = clientUrl;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new ServiceWorkerContainerHostGetRegistrationResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void getRegistrations(GetRegistrations_Response callback) {
      ServiceWorkerContainerHostGetRegistrationsParams _message =
          new ServiceWorkerContainerHostGetRegistrationsParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new ServiceWorkerContainerHostGetRegistrationsResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void getRegistrationForReady(GetRegistrationForReady_Response callback) {
      ServiceWorkerContainerHostGetRegistrationForReadyParams _message =
          new ServiceWorkerContainerHostGetRegistrationForReadyParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)),
              new ServiceWorkerContainerHostGetRegistrationForReadyResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void ensureControllerServiceWorker(
        InterfaceRequest<ControllerServiceWorker> receiver, int purpose) {
      ServiceWorkerContainerHostEnsureControllerServiceWorkerParams _message =
          new ServiceWorkerContainerHostEnsureControllerServiceWorkerParams();
      _message.receiver = receiver;
      _message.purpose = purpose;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
    }

    @Override
    public void cloneContainerHost(InterfaceRequest<ServiceWorkerContainerHost> containerHost) {
      ServiceWorkerContainerHostCloneContainerHostParams _message =
          new ServiceWorkerContainerHostCloneContainerHostParams();
      _message.containerHost = containerHost;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5)));
    }

    @Override
    public void hintToUpdateServiceWorker() {
      ServiceWorkerContainerHostHintToUpdateServiceWorkerParams _message =
          new ServiceWorkerContainerHostHintToUpdateServiceWorkerParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(6)));
    }

    @Override
    public void ensureFileAccess(FilePath[] files, EnsureFileAccess_Response callback) {
      ServiceWorkerContainerHostEnsureFileAccessParams _message =
          new ServiceWorkerContainerHostEnsureFileAccessParams();
      _message.files = files;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(7, 1, 0L)),
              new ServiceWorkerContainerHostEnsureFileAccessResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void onExecutionReady() {
      ServiceWorkerContainerHostOnExecutionReadyParams _message =
          new ServiceWorkerContainerHostOnExecutionReadyParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(8)));
    }
  }

  public static final class Stub extends Interface.Stub<ServiceWorkerContainerHost> {
    Stub(Core core, ServiceWorkerContainerHost impl) {
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
                ServiceWorkerContainerHost_Internal.MANAGER, messageWithHeader);
          case 4:
            ServiceWorkerContainerHostEnsureControllerServiceWorkerParams data =
                ServiceWorkerContainerHostEnsureControllerServiceWorkerParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().ensureControllerServiceWorker(data.receiver, data.purpose);
            return true;
          case 5:
            getImpl()
                .cloneContainerHost(
                    ServiceWorkerContainerHostCloneContainerHostParams.deserialize(
                            messageWithHeader.getPayload())
                        .containerHost);
            return true;
          case 6:
            ServiceWorkerContainerHostHintToUpdateServiceWorkerParams.deserialize(
                messageWithHeader.getPayload());
            getImpl().hintToUpdateServiceWorker();
            return true;
          case 8:
            ServiceWorkerContainerHostOnExecutionReadyParams.deserialize(
                messageWithHeader.getPayload());
            getImpl().onExecutionReady();
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
                getCore(),
                ServiceWorkerContainerHost_Internal.MANAGER,
                messageWithHeader,
                receiver);
          case 0:
            ServiceWorkerContainerHostRegisterParams data =
                ServiceWorkerContainerHostRegisterParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .register(
                    data.scriptUrl,
                    data.options,
                    data.outsideFetchClientSettingsObject,
                    new ServiceWorkerContainerHostRegisterResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
            getImpl()
                .getRegistration(
                    ServiceWorkerContainerHostGetRegistrationParams.deserialize(
                            messageWithHeader.getPayload())
                        .clientUrl,
                    new ServiceWorkerContainerHostGetRegistrationResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 2:
            ServiceWorkerContainerHostGetRegistrationsParams.deserialize(
                messageWithHeader.getPayload());
            getImpl()
                .getRegistrations(
                    new ServiceWorkerContainerHostGetRegistrationsResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 3:
            ServiceWorkerContainerHostGetRegistrationForReadyParams.deserialize(
                messageWithHeader.getPayload());
            getImpl()
                .getRegistrationForReady(
                    new ServiceWorkerContainerHostGetRegistrationForReadyResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 4:
          case 5:
          case 6:
          default:
            return false;
          case 7:
            getImpl()
                .ensureFileAccess(
                    ServiceWorkerContainerHostEnsureFileAccessParams.deserialize(
                            messageWithHeader.getPayload())
                        .files,
                    new ServiceWorkerContainerHostEnsureFileAccessResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class ServiceWorkerContainerHostRegisterParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public ServiceWorkerRegistrationOptions options;
    public FetchClientSettingsObject outsideFetchClientSettingsObject;
    public Url scriptUrl;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerContainerHostRegisterParams(int version) {
      super(32, version);
    }

    public ServiceWorkerContainerHostRegisterParams() {
      this(0);
    }

    public static ServiceWorkerContainerHostRegisterParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerContainerHostRegisterParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerContainerHostRegisterParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerContainerHostRegisterParams result =
            new ServiceWorkerContainerHostRegisterParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.scriptUrl = Url.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.options = ServiceWorkerRegistrationOptions.decode(decoder12);
        Decoder decoder13 = decoder0.readPointer(24, false);
        result.outsideFetchClientSettingsObject = FetchClientSettingsObject.decode(decoder13);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.scriptUrl, 8, false);
      encoder0.encode((Struct) this.options, 16, false);
      encoder0.encode((Struct) this.outsideFetchClientSettingsObject, 24, false);
    }
  }

  static final class ServiceWorkerContainerHostRegisterResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public int error;
    public String errorMsg;
    public ServiceWorkerRegistrationObjectInfo registration;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerContainerHostRegisterResponseParams(int version) {
      super(32, version);
    }

    public ServiceWorkerContainerHostRegisterResponseParams() {
      this(0);
    }

    public static ServiceWorkerContainerHostRegisterResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerContainerHostRegisterResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerContainerHostRegisterResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerContainerHostRegisterResponseParams result =
            new ServiceWorkerContainerHostRegisterResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.error = readInt;
        ServiceWorkerErrorType.validate(readInt);
        result.error = ServiceWorkerErrorType.toKnownValue(result.error);
        result.errorMsg = decoder0.readString(16, true);
        Decoder decoder1 = decoder0.readPointer(24, true);
        result.registration = ServiceWorkerRegistrationObjectInfo.decode(decoder1);
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
      encoder0.encode((Struct) this.registration, 24, true);
    }
  }

  static class ServiceWorkerContainerHostRegisterResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ServiceWorkerContainerHost.Register_Response mCallback;

    ServiceWorkerContainerHostRegisterResponseParamsForwardToCallback(
        ServiceWorkerContainerHost.Register_Response callback) {
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
        ServiceWorkerContainerHostRegisterResponseParams response =
            ServiceWorkerContainerHostRegisterResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.error, response.errorMsg, response.registration);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ServiceWorkerContainerHostRegisterResponseParamsProxyToResponder
      implements ServiceWorkerContainerHost.Register_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ServiceWorkerContainerHostRegisterResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int error, String errorMsg, ServiceWorkerRegistrationObjectInfo registration) {
      ServiceWorkerContainerHostRegisterResponseParams _response =
          new ServiceWorkerContainerHostRegisterResponseParams();
      _response.error = error;
      _response.errorMsg = errorMsg;
      _response.registration = registration;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ServiceWorkerContainerHostGetRegistrationParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Url clientUrl;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerContainerHostGetRegistrationParams(int version) {
      super(16, version);
    }

    public ServiceWorkerContainerHostGetRegistrationParams() {
      this(0);
    }

    public static ServiceWorkerContainerHostGetRegistrationParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerContainerHostGetRegistrationParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerContainerHostGetRegistrationParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerContainerHostGetRegistrationParams result =
            new ServiceWorkerContainerHostGetRegistrationParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.clientUrl = Url.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.clientUrl, 8, false);
    }
  }

  static final class ServiceWorkerContainerHostGetRegistrationResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public int error;
    public String errorMsg;
    public ServiceWorkerRegistrationObjectInfo registration;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerContainerHostGetRegistrationResponseParams(int version) {
      super(32, version);
    }

    public ServiceWorkerContainerHostGetRegistrationResponseParams() {
      this(0);
    }

    public static ServiceWorkerContainerHostGetRegistrationResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerContainerHostGetRegistrationResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerContainerHostGetRegistrationResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerContainerHostGetRegistrationResponseParams result =
            new ServiceWorkerContainerHostGetRegistrationResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.error = readInt;
        ServiceWorkerErrorType.validate(readInt);
        result.error = ServiceWorkerErrorType.toKnownValue(result.error);
        result.errorMsg = decoder0.readString(16, true);
        Decoder decoder1 = decoder0.readPointer(24, true);
        result.registration = ServiceWorkerRegistrationObjectInfo.decode(decoder1);
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
      encoder0.encode((Struct) this.registration, 24, true);
    }
  }

  static class ServiceWorkerContainerHostGetRegistrationResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ServiceWorkerContainerHost.GetRegistration_Response mCallback;

    ServiceWorkerContainerHostGetRegistrationResponseParamsForwardToCallback(
        ServiceWorkerContainerHost.GetRegistration_Response callback) {
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
        ServiceWorkerContainerHostGetRegistrationResponseParams response =
            ServiceWorkerContainerHostGetRegistrationResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.error, response.errorMsg, response.registration);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ServiceWorkerContainerHostGetRegistrationResponseParamsProxyToResponder
      implements ServiceWorkerContainerHost.GetRegistration_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ServiceWorkerContainerHostGetRegistrationResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int error, String errorMsg, ServiceWorkerRegistrationObjectInfo registration) {
      ServiceWorkerContainerHostGetRegistrationResponseParams _response =
          new ServiceWorkerContainerHostGetRegistrationResponseParams();
      _response.error = error;
      _response.errorMsg = errorMsg;
      _response.registration = registration;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ServiceWorkerContainerHostGetRegistrationsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerContainerHostGetRegistrationsParams(int version) {
      super(8, version);
    }

    public ServiceWorkerContainerHostGetRegistrationsParams() {
      this(0);
    }

    public static ServiceWorkerContainerHostGetRegistrationsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerContainerHostGetRegistrationsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerContainerHostGetRegistrationsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerContainerHostGetRegistrationsParams result =
            new ServiceWorkerContainerHostGetRegistrationsParams(elementsOrVersion);
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

  static final class ServiceWorkerContainerHostGetRegistrationsResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public int error;
    public String errorMsg;
    public ServiceWorkerRegistrationObjectInfo[] infos;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerContainerHostGetRegistrationsResponseParams(int version) {
      super(32, version);
    }

    public ServiceWorkerContainerHostGetRegistrationsResponseParams() {
      this(0);
    }

    public static ServiceWorkerContainerHostGetRegistrationsResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerContainerHostGetRegistrationsResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerContainerHostGetRegistrationsResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerContainerHostGetRegistrationsResponseParams result =
            new ServiceWorkerContainerHostGetRegistrationsResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.error = readInt;
        ServiceWorkerErrorType.validate(readInt);
        result.error = ServiceWorkerErrorType.toKnownValue(result.error);
        result.errorMsg = decoder0.readString(16, true);
        Decoder decoder1 = decoder0.readPointer(24, true);
        if (decoder1 == null) {
          result.infos = null;
        } else {
          DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
          result.infos = new ServiceWorkerRegistrationObjectInfo[si1.elementsOrVersion];
          for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
            Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
            result.infos[i1] = ServiceWorkerRegistrationObjectInfo.decode(decoder2);
          }
        }
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
      ServiceWorkerRegistrationObjectInfo[] serviceWorkerRegistrationObjectInfoArr = this.infos;
      if (serviceWorkerRegistrationObjectInfoArr == null) {
        encoder0.encodeNullPointer(24, true);
        return;
      }
      Encoder encoder1 =
          encoder0.encodePointerArray(serviceWorkerRegistrationObjectInfoArr.length, 24, -1);
      int i0 = 0;
      while (true) {
        ServiceWorkerRegistrationObjectInfo[] serviceWorkerRegistrationObjectInfoArr2 = this.infos;
        if (i0 < serviceWorkerRegistrationObjectInfoArr2.length) {
          encoder1.encode(
              (Struct) serviceWorkerRegistrationObjectInfoArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static class ServiceWorkerContainerHostGetRegistrationsResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ServiceWorkerContainerHost.GetRegistrations_Response mCallback;

    ServiceWorkerContainerHostGetRegistrationsResponseParamsForwardToCallback(
        ServiceWorkerContainerHost.GetRegistrations_Response callback) {
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
        ServiceWorkerContainerHostGetRegistrationsResponseParams response =
            ServiceWorkerContainerHostGetRegistrationsResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.error, response.errorMsg, response.infos);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ServiceWorkerContainerHostGetRegistrationsResponseParamsProxyToResponder
      implements ServiceWorkerContainerHost.GetRegistrations_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ServiceWorkerContainerHostGetRegistrationsResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int error, String errorMsg, ServiceWorkerRegistrationObjectInfo[] infos) {
      ServiceWorkerContainerHostGetRegistrationsResponseParams _response =
          new ServiceWorkerContainerHostGetRegistrationsResponseParams();
      _response.error = error;
      _response.errorMsg = errorMsg;
      _response.infos = infos;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ServiceWorkerContainerHostGetRegistrationForReadyParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerContainerHostGetRegistrationForReadyParams(int version) {
      super(8, version);
    }

    public ServiceWorkerContainerHostGetRegistrationForReadyParams() {
      this(0);
    }

    public static ServiceWorkerContainerHostGetRegistrationForReadyParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerContainerHostGetRegistrationForReadyParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerContainerHostGetRegistrationForReadyParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerContainerHostGetRegistrationForReadyParams result =
            new ServiceWorkerContainerHostGetRegistrationForReadyParams(elementsOrVersion);
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

  static final class ServiceWorkerContainerHostGetRegistrationForReadyResponseParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public ServiceWorkerRegistrationObjectInfo registration;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerContainerHostGetRegistrationForReadyResponseParams(int version) {
      super(16, version);
    }

    public ServiceWorkerContainerHostGetRegistrationForReadyResponseParams() {
      this(0);
    }

    public static ServiceWorkerContainerHostGetRegistrationForReadyResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerContainerHostGetRegistrationForReadyResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerContainerHostGetRegistrationForReadyResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerContainerHostGetRegistrationForReadyResponseParams result =
            new ServiceWorkerContainerHostGetRegistrationForReadyResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.registration = ServiceWorkerRegistrationObjectInfo.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.registration, 8, true);
    }
  }

  static class ServiceWorkerContainerHostGetRegistrationForReadyResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ServiceWorkerContainerHost.GetRegistrationForReady_Response mCallback;

    ServiceWorkerContainerHostGetRegistrationForReadyResponseParamsForwardToCallback(
        ServiceWorkerContainerHost.GetRegistrationForReady_Response callback) {
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
        ServiceWorkerContainerHostGetRegistrationForReadyResponseParams response =
            ServiceWorkerContainerHostGetRegistrationForReadyResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.registration);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ServiceWorkerContainerHostGetRegistrationForReadyResponseParamsProxyToResponder
      implements ServiceWorkerContainerHost.GetRegistrationForReady_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ServiceWorkerContainerHostGetRegistrationForReadyResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(ServiceWorkerRegistrationObjectInfo registration) {
      ServiceWorkerContainerHostGetRegistrationForReadyResponseParams _response =
          new ServiceWorkerContainerHostGetRegistrationForReadyResponseParams();
      _response.registration = registration;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ServiceWorkerContainerHostEnsureControllerServiceWorkerParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int purpose;
    public InterfaceRequest<ControllerServiceWorker> receiver;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerContainerHostEnsureControllerServiceWorkerParams(int version) {
      super(16, version);
    }

    public ServiceWorkerContainerHostEnsureControllerServiceWorkerParams() {
      this(0);
    }

    public static ServiceWorkerContainerHostEnsureControllerServiceWorkerParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerContainerHostEnsureControllerServiceWorkerParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerContainerHostEnsureControllerServiceWorkerParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerContainerHostEnsureControllerServiceWorkerParams result =
            new ServiceWorkerContainerHostEnsureControllerServiceWorkerParams(elementsOrVersion);
        result.receiver = decoder0.readInterfaceRequest(8, false);
        int readInt = decoder0.readInt(12);
        result.purpose = readInt;
        ControllerServiceWorkerPurpose.validate(readInt);
        result.purpose = ControllerServiceWorkerPurpose.toKnownValue(result.purpose);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.receiver, 8, false);
      encoder0.encode(this.purpose, 12);
    }
  }

  static final class ServiceWorkerContainerHostCloneContainerHostParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<ServiceWorkerContainerHost> containerHost;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerContainerHostCloneContainerHostParams(int version) {
      super(16, version);
    }

    public ServiceWorkerContainerHostCloneContainerHostParams() {
      this(0);
    }

    public static ServiceWorkerContainerHostCloneContainerHostParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerContainerHostCloneContainerHostParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerContainerHostCloneContainerHostParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerContainerHostCloneContainerHostParams result =
            new ServiceWorkerContainerHostCloneContainerHostParams(elementsOrVersion);
        result.containerHost = decoder0.readInterfaceRequest(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.containerHost, 8, false);
    }
  }

  static final class ServiceWorkerContainerHostHintToUpdateServiceWorkerParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerContainerHostHintToUpdateServiceWorkerParams(int version) {
      super(8, version);
    }

    public ServiceWorkerContainerHostHintToUpdateServiceWorkerParams() {
      this(0);
    }

    public static ServiceWorkerContainerHostHintToUpdateServiceWorkerParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerContainerHostHintToUpdateServiceWorkerParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerContainerHostHintToUpdateServiceWorkerParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerContainerHostHintToUpdateServiceWorkerParams result =
            new ServiceWorkerContainerHostHintToUpdateServiceWorkerParams(elementsOrVersion);
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

  static final class ServiceWorkerContainerHostEnsureFileAccessParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public FilePath[] files;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerContainerHostEnsureFileAccessParams(int version) {
      super(16, version);
    }

    public ServiceWorkerContainerHostEnsureFileAccessParams() {
      this(0);
    }

    public static ServiceWorkerContainerHostEnsureFileAccessParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerContainerHostEnsureFileAccessParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerContainerHostEnsureFileAccessParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerContainerHostEnsureFileAccessParams result =
            new ServiceWorkerContainerHostEnsureFileAccessParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.files = new FilePath[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.files[i1] = FilePath.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      FilePath[] filePathArr = this.files;
      if (filePathArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(filePathArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        FilePath[] filePathArr2 = this.files;
        if (i0 < filePathArr2.length) {
          encoder1.encode((Struct) filePathArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static final class ServiceWorkerContainerHostEnsureFileAccessResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerContainerHostEnsureFileAccessResponseParams(int version) {
      super(8, version);
    }

    public ServiceWorkerContainerHostEnsureFileAccessResponseParams() {
      this(0);
    }

    public static ServiceWorkerContainerHostEnsureFileAccessResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerContainerHostEnsureFileAccessResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerContainerHostEnsureFileAccessResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerContainerHostEnsureFileAccessResponseParams result =
            new ServiceWorkerContainerHostEnsureFileAccessResponseParams(elementsOrVersion);
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

  static class ServiceWorkerContainerHostEnsureFileAccessResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ServiceWorkerContainerHost.EnsureFileAccess_Response mCallback;

    ServiceWorkerContainerHostEnsureFileAccessResponseParamsForwardToCallback(
        ServiceWorkerContainerHost.EnsureFileAccess_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(7, 2)) {
          return false;
        }
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ServiceWorkerContainerHostEnsureFileAccessResponseParamsProxyToResponder
      implements ServiceWorkerContainerHost.EnsureFileAccess_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ServiceWorkerContainerHostEnsureFileAccessResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      ServiceWorkerContainerHostEnsureFileAccessResponseParams _response =
          new ServiceWorkerContainerHostEnsureFileAccessResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(7, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ServiceWorkerContainerHostOnExecutionReadyParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerContainerHostOnExecutionReadyParams(int version) {
      super(8, version);
    }

    public ServiceWorkerContainerHostOnExecutionReadyParams() {
      this(0);
    }

    public static ServiceWorkerContainerHostOnExecutionReadyParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerContainerHostOnExecutionReadyParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerContainerHostOnExecutionReadyParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerContainerHostOnExecutionReadyParams result =
            new ServiceWorkerContainerHostOnExecutionReadyParams(elementsOrVersion);
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
