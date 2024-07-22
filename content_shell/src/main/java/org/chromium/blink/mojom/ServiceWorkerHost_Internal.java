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
import org.chromium.mojo_base.mojom.ReadOnlyBuffer;
import org.chromium.url.mojom.Url;

class ServiceWorkerHost_Internal {
  private static final int ADD_ROUTES_ORDINAL = 12;
  private static final int CLAIM_CLIENTS_ORDINAL = 10;
  private static final int CLEAR_CACHED_METADATA_ORDINAL = 1;
  private static final int FOCUS_CLIENT_ORDINAL = 7;
  private static final int GET_CLIENTS_ORDINAL = 2;
  private static final int GET_CLIENT_ORDINAL = 3;
  public static final Interface.Manager<ServiceWorkerHost, ServiceWorkerHost.Proxy> MANAGER =
      new Interface.Manager<ServiceWorkerHost, ServiceWorkerHost.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.ServiceWorkerHost";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public ServiceWorkerHost.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, ServiceWorkerHost impl) {
          return new Stub(core, impl);
        }

        @Override
        public ServiceWorkerHost[] buildArray(int size) {
          return new ServiceWorkerHost[size];
        }
      };
  private static final int NAVIGATE_CLIENT_ORDINAL = 8;
  private static final int OPEN_NEW_TAB_ORDINAL = 4;
  private static final int OPEN_PAYMENT_HANDLER_WINDOW_ORDINAL = 5;
  private static final int POST_MESSAGE_TO_CLIENT_ORDINAL = 6;
  private static final int REGISTER_ROUTER_ORDINAL = 11;
  private static final int SET_CACHED_METADATA_ORDINAL = 0;
  private static final int SKIP_WAITING_ORDINAL = 9;

  ServiceWorkerHost_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements ServiceWorkerHost.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void setCachedMetadata(Url url, ReadOnlyBuffer data) {
      ServiceWorkerHostSetCachedMetadataParams _message =
          new ServiceWorkerHostSetCachedMetadataParams();
      _message.url = url;
      _message.data = data;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void clearCachedMetadata(Url url) {
      ServiceWorkerHostClearCachedMetadataParams _message =
          new ServiceWorkerHostClearCachedMetadataParams();
      _message.url = url;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void getClients(ServiceWorkerClientQueryOptions options, GetClients_Response callback) {
      ServiceWorkerHostGetClientsParams _message = new ServiceWorkerHostGetClientsParams();
      _message.options = options;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new ServiceWorkerHostGetClientsResponseParamsForwardToCallback(callback));
    }

    @Override
    public void getClient(String clientUuid, GetClient_Response callback) {
      ServiceWorkerHostGetClientParams _message = new ServiceWorkerHostGetClientParams();
      _message.clientUuid = clientUuid;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)),
              new ServiceWorkerHostGetClientResponseParamsForwardToCallback(callback));
    }

    @Override
    public void openNewTab(Url url, OpenNewTab_Response callback) {
      ServiceWorkerHostOpenNewTabParams _message = new ServiceWorkerHostOpenNewTabParams();
      _message.url = url;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)),
              new ServiceWorkerHostOpenNewTabResponseParamsForwardToCallback(callback));
    }

    @Override
    public void openPaymentHandlerWindow(Url url, OpenPaymentHandlerWindow_Response callback) {
      ServiceWorkerHostOpenPaymentHandlerWindowParams _message =
          new ServiceWorkerHostOpenPaymentHandlerWindowParams();
      _message.url = url;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(5, 1, 0L)),
              new ServiceWorkerHostOpenPaymentHandlerWindowResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void postMessageToClient(String clientUuid, TransferableMessage message) {
      ServiceWorkerHostPostMessageToClientParams _message =
          new ServiceWorkerHostPostMessageToClientParams();
      _message.clientUuid = clientUuid;
      _message.message = message;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(6)));
    }

    @Override
    public void focusClient(String clientUuid, FocusClient_Response callback) {
      ServiceWorkerHostFocusClientParams _message = new ServiceWorkerHostFocusClientParams();
      _message.clientUuid = clientUuid;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(7, 1, 0L)),
              new ServiceWorkerHostFocusClientResponseParamsForwardToCallback(callback));
    }

    @Override
    public void navigateClient(String clientUuid, Url url, NavigateClient_Response callback) {
      ServiceWorkerHostNavigateClientParams _message = new ServiceWorkerHostNavigateClientParams();
      _message.clientUuid = clientUuid;
      _message.url = url;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(8, 1, 0L)),
              new ServiceWorkerHostNavigateClientResponseParamsForwardToCallback(callback));
    }

    @Override
    public void skipWaiting(SkipWaiting_Response callback) {
      ServiceWorkerHostSkipWaitingParams _message = new ServiceWorkerHostSkipWaitingParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(9, 1, 0L)),
              new ServiceWorkerHostSkipWaitingResponseParamsForwardToCallback(callback));
    }

    @Override
    public void claimClients(ClaimClients_Response callback) {
      ServiceWorkerHostClaimClientsParams _message = new ServiceWorkerHostClaimClientsParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(10, 1, 0L)),
              new ServiceWorkerHostClaimClientsResponseParamsForwardToCallback(callback));
    }

    @Override
    public void registerRouter(ServiceWorkerRouterRules rules, RegisterRouter_Response callback) {
      ServiceWorkerHostRegisterRouterParams _message = new ServiceWorkerHostRegisterRouterParams();
      _message.rules = rules;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(11, 1, 0L)),
              new ServiceWorkerHostRegisterRouterResponseParamsForwardToCallback(callback));
    }

    @Override
    public void addRoutes(ServiceWorkerRouterRules rules, AddRoutes_Response callback) {
      ServiceWorkerHostAddRoutesParams _message = new ServiceWorkerHostAddRoutesParams();
      _message.rules = rules;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(12, 1, 0L)),
              new ServiceWorkerHostAddRoutesResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<ServiceWorkerHost> {
    Stub(Core core, ServiceWorkerHost impl) {
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
                ServiceWorkerHost_Internal.MANAGER, messageWithHeader);
          case 0:
            ServiceWorkerHostSetCachedMetadataParams data =
                ServiceWorkerHostSetCachedMetadataParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().setCachedMetadata(data.url, data.data);
            return true;
          case 1:
            getImpl()
                .clearCachedMetadata(
                    ServiceWorkerHostClearCachedMetadataParams.deserialize(
                            messageWithHeader.getPayload())
                        .url);
            return true;
          case 6:
            ServiceWorkerHostPostMessageToClientParams data2 =
                ServiceWorkerHostPostMessageToClientParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().postMessageToClient(data2.clientUuid, data2.message);
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
                getCore(), ServiceWorkerHost_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
          case 1:
          case 6:
          default:
            return false;
          case 2:
            ServiceWorkerHostGetClientsParams data =
                ServiceWorkerHostGetClientsParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .getClients(
                    data.options,
                    new ServiceWorkerHostGetClientsResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 3:
            ServiceWorkerHostGetClientParams data2 =
                ServiceWorkerHostGetClientParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .getClient(
                    data2.clientUuid,
                    new ServiceWorkerHostGetClientResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 4:
            ServiceWorkerHostOpenNewTabParams data3 =
                ServiceWorkerHostOpenNewTabParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .openNewTab(
                    data3.url,
                    new ServiceWorkerHostOpenNewTabResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 5:
            ServiceWorkerHostOpenPaymentHandlerWindowParams data4 =
                ServiceWorkerHostOpenPaymentHandlerWindowParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .openPaymentHandlerWindow(
                    data4.url,
                    new ServiceWorkerHostOpenPaymentHandlerWindowResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 7:
            ServiceWorkerHostFocusClientParams data5 =
                ServiceWorkerHostFocusClientParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .focusClient(
                    data5.clientUuid,
                    new ServiceWorkerHostFocusClientResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 8:
            ServiceWorkerHostNavigateClientParams data6 =
                ServiceWorkerHostNavigateClientParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .navigateClient(
                    data6.clientUuid,
                    data6.url,
                    new ServiceWorkerHostNavigateClientResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 9:
            ServiceWorkerHostSkipWaitingParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .skipWaiting(
                    new ServiceWorkerHostSkipWaitingResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 10:
            ServiceWorkerHostClaimClientsParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .claimClients(
                    new ServiceWorkerHostClaimClientsResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 11:
            ServiceWorkerHostRegisterRouterParams data7 =
                ServiceWorkerHostRegisterRouterParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .registerRouter(
                    data7.rules,
                    new ServiceWorkerHostRegisterRouterResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 12:
            ServiceWorkerHostAddRoutesParams data8 =
                ServiceWorkerHostAddRoutesParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .addRoutes(
                    data8.rules,
                    new ServiceWorkerHostAddRoutesResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class ServiceWorkerHostSetCachedMetadataParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public ReadOnlyBuffer data;
    public Url url;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerHostSetCachedMetadataParams(int version) {
      super(24, version);
    }

    public ServiceWorkerHostSetCachedMetadataParams() {
      this(0);
    }

    public static ServiceWorkerHostSetCachedMetadataParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerHostSetCachedMetadataParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerHostSetCachedMetadataParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerHostSetCachedMetadataParams result =
            new ServiceWorkerHostSetCachedMetadataParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.url = Url.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.data = ReadOnlyBuffer.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.url, 8, false);
      encoder0.encode((Struct) this.data, 16, false);
    }
  }

  static final class ServiceWorkerHostClearCachedMetadataParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Url url;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerHostClearCachedMetadataParams(int version) {
      super(16, version);
    }

    public ServiceWorkerHostClearCachedMetadataParams() {
      this(0);
    }

    public static ServiceWorkerHostClearCachedMetadataParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerHostClearCachedMetadataParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerHostClearCachedMetadataParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerHostClearCachedMetadataParams result =
            new ServiceWorkerHostClearCachedMetadataParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.url = Url.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.url, 8, false);
    }
  }

  static final class ServiceWorkerHostGetClientsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public ServiceWorkerClientQueryOptions options;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerHostGetClientsParams(int version) {
      super(16, version);
    }

    public ServiceWorkerHostGetClientsParams() {
      this(0);
    }

    public static ServiceWorkerHostGetClientsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerHostGetClientsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerHostGetClientsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerHostGetClientsParams result =
            new ServiceWorkerHostGetClientsParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.options = ServiceWorkerClientQueryOptions.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.options, 8, false);
    }
  }

  static final class ServiceWorkerHostGetClientsResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public ServiceWorkerClientInfo[] clients;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerHostGetClientsResponseParams(int version) {
      super(16, version);
    }

    public ServiceWorkerHostGetClientsResponseParams() {
      this(0);
    }

    public static ServiceWorkerHostGetClientsResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerHostGetClientsResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerHostGetClientsResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerHostGetClientsResponseParams result =
            new ServiceWorkerHostGetClientsResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.clients = new ServiceWorkerClientInfo[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.clients[i1] = ServiceWorkerClientInfo.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      ServiceWorkerClientInfo[] serviceWorkerClientInfoArr = this.clients;
      if (serviceWorkerClientInfoArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(serviceWorkerClientInfoArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        ServiceWorkerClientInfo[] serviceWorkerClientInfoArr2 = this.clients;
        if (i0 < serviceWorkerClientInfoArr2.length) {
          encoder1.encode((Struct) serviceWorkerClientInfoArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static class ServiceWorkerHostGetClientsResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ServiceWorkerHost.GetClients_Response mCallback;

    ServiceWorkerHostGetClientsResponseParamsForwardToCallback(
        ServiceWorkerHost.GetClients_Response callback) {
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
        ServiceWorkerHostGetClientsResponseParams response =
            ServiceWorkerHostGetClientsResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.clients);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ServiceWorkerHostGetClientsResponseParamsProxyToResponder
      implements ServiceWorkerHost.GetClients_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ServiceWorkerHostGetClientsResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(ServiceWorkerClientInfo[] clients) {
      ServiceWorkerHostGetClientsResponseParams _response =
          new ServiceWorkerHostGetClientsResponseParams();
      _response.clients = clients;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ServiceWorkerHostGetClientParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String clientUuid;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerHostGetClientParams(int version) {
      super(16, version);
    }

    public ServiceWorkerHostGetClientParams() {
      this(0);
    }

    public static ServiceWorkerHostGetClientParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerHostGetClientParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerHostGetClientParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerHostGetClientParams result =
            new ServiceWorkerHostGetClientParams(elementsOrVersion);
        result.clientUuid = decoder0.readString(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.clientUuid, 8, false);
    }
  }

  static final class ServiceWorkerHostGetClientResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public ServiceWorkerClientInfo client;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerHostGetClientResponseParams(int version) {
      super(16, version);
    }

    public ServiceWorkerHostGetClientResponseParams() {
      this(0);
    }

    public static ServiceWorkerHostGetClientResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerHostGetClientResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerHostGetClientResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerHostGetClientResponseParams result =
            new ServiceWorkerHostGetClientResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.client = ServiceWorkerClientInfo.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.client, 8, true);
    }
  }

  static class ServiceWorkerHostGetClientResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ServiceWorkerHost.GetClient_Response mCallback;

    ServiceWorkerHostGetClientResponseParamsForwardToCallback(
        ServiceWorkerHost.GetClient_Response callback) {
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
        ServiceWorkerHostGetClientResponseParams response =
            ServiceWorkerHostGetClientResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.client);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ServiceWorkerHostGetClientResponseParamsProxyToResponder
      implements ServiceWorkerHost.GetClient_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ServiceWorkerHostGetClientResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(ServiceWorkerClientInfo client) {
      ServiceWorkerHostGetClientResponseParams _response =
          new ServiceWorkerHostGetClientResponseParams();
      _response.client = client;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ServiceWorkerHostOpenNewTabParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Url url;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerHostOpenNewTabParams(int version) {
      super(16, version);
    }

    public ServiceWorkerHostOpenNewTabParams() {
      this(0);
    }

    public static ServiceWorkerHostOpenNewTabParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerHostOpenNewTabParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerHostOpenNewTabParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerHostOpenNewTabParams result =
            new ServiceWorkerHostOpenNewTabParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.url = Url.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.url, 8, false);
    }
  }

  static final class ServiceWorkerHostOpenNewTabResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public ServiceWorkerClientInfo client;
    public String errorMsg;
    public boolean success;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerHostOpenNewTabResponseParams(int version) {
      super(32, version);
    }

    public ServiceWorkerHostOpenNewTabResponseParams() {
      this(0);
    }

    public static ServiceWorkerHostOpenNewTabResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerHostOpenNewTabResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerHostOpenNewTabResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerHostOpenNewTabResponseParams result =
            new ServiceWorkerHostOpenNewTabResponseParams(elementsOrVersion);
        result.success = decoder0.readBoolean(8, 0);
        Decoder decoder1 = decoder0.readPointer(16, true);
        result.client = ServiceWorkerClientInfo.decode(decoder1);
        result.errorMsg = decoder0.readString(24, true);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.success, 8, 0);
      encoder0.encode((Struct) this.client, 16, true);
      encoder0.encode(this.errorMsg, 24, true);
    }
  }

  static class ServiceWorkerHostOpenNewTabResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ServiceWorkerHost.OpenNewTab_Response mCallback;

    ServiceWorkerHostOpenNewTabResponseParamsForwardToCallback(
        ServiceWorkerHost.OpenNewTab_Response callback) {
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
        ServiceWorkerHostOpenNewTabResponseParams response =
            ServiceWorkerHostOpenNewTabResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.success, response.client, response.errorMsg);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ServiceWorkerHostOpenNewTabResponseParamsProxyToResponder
      implements ServiceWorkerHost.OpenNewTab_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ServiceWorkerHostOpenNewTabResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean success, ServiceWorkerClientInfo client, String errorMsg) {
      ServiceWorkerHostOpenNewTabResponseParams _response =
          new ServiceWorkerHostOpenNewTabResponseParams();
      _response.success = success;
      _response.client = client;
      _response.errorMsg = errorMsg;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ServiceWorkerHostOpenPaymentHandlerWindowParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Url url;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerHostOpenPaymentHandlerWindowParams(int version) {
      super(16, version);
    }

    public ServiceWorkerHostOpenPaymentHandlerWindowParams() {
      this(0);
    }

    public static ServiceWorkerHostOpenPaymentHandlerWindowParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerHostOpenPaymentHandlerWindowParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerHostOpenPaymentHandlerWindowParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerHostOpenPaymentHandlerWindowParams result =
            new ServiceWorkerHostOpenPaymentHandlerWindowParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.url = Url.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.url, 8, false);
    }
  }

  static final class ServiceWorkerHostOpenPaymentHandlerWindowResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public ServiceWorkerClientInfo client;
    public String errorMsg;
    public boolean success;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerHostOpenPaymentHandlerWindowResponseParams(int version) {
      super(32, version);
    }

    public ServiceWorkerHostOpenPaymentHandlerWindowResponseParams() {
      this(0);
    }

    public static ServiceWorkerHostOpenPaymentHandlerWindowResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerHostOpenPaymentHandlerWindowResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerHostOpenPaymentHandlerWindowResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerHostOpenPaymentHandlerWindowResponseParams result =
            new ServiceWorkerHostOpenPaymentHandlerWindowResponseParams(elementsOrVersion);
        result.success = decoder0.readBoolean(8, 0);
        Decoder decoder1 = decoder0.readPointer(16, true);
        result.client = ServiceWorkerClientInfo.decode(decoder1);
        result.errorMsg = decoder0.readString(24, true);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.success, 8, 0);
      encoder0.encode((Struct) this.client, 16, true);
      encoder0.encode(this.errorMsg, 24, true);
    }
  }

  static class ServiceWorkerHostOpenPaymentHandlerWindowResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ServiceWorkerHost.OpenPaymentHandlerWindow_Response mCallback;

    ServiceWorkerHostOpenPaymentHandlerWindowResponseParamsForwardToCallback(
        ServiceWorkerHost.OpenPaymentHandlerWindow_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(5, 2)) {
          return false;
        }
        ServiceWorkerHostOpenPaymentHandlerWindowResponseParams response =
            ServiceWorkerHostOpenPaymentHandlerWindowResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.success, response.client, response.errorMsg);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ServiceWorkerHostOpenPaymentHandlerWindowResponseParamsProxyToResponder
      implements ServiceWorkerHost.OpenPaymentHandlerWindow_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ServiceWorkerHostOpenPaymentHandlerWindowResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean success, ServiceWorkerClientInfo client, String errorMsg) {
      ServiceWorkerHostOpenPaymentHandlerWindowResponseParams _response =
          new ServiceWorkerHostOpenPaymentHandlerWindowResponseParams();
      _response.success = success;
      _response.client = client;
      _response.errorMsg = errorMsg;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(5, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ServiceWorkerHostPostMessageToClientParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public String clientUuid;
    public TransferableMessage message;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerHostPostMessageToClientParams(int version) {
      super(24, version);
    }

    public ServiceWorkerHostPostMessageToClientParams() {
      this(0);
    }

    public static ServiceWorkerHostPostMessageToClientParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerHostPostMessageToClientParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerHostPostMessageToClientParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerHostPostMessageToClientParams result =
            new ServiceWorkerHostPostMessageToClientParams(elementsOrVersion);
        result.clientUuid = decoder0.readString(8, false);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.message = TransferableMessage.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.clientUuid, 8, false);
      encoder0.encode((Struct) this.message, 16, false);
    }
  }

  static final class ServiceWorkerHostFocusClientParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String clientUuid;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerHostFocusClientParams(int version) {
      super(16, version);
    }

    public ServiceWorkerHostFocusClientParams() {
      this(0);
    }

    public static ServiceWorkerHostFocusClientParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerHostFocusClientParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerHostFocusClientParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerHostFocusClientParams result =
            new ServiceWorkerHostFocusClientParams(elementsOrVersion);
        result.clientUuid = decoder0.readString(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.clientUuid, 8, false);
    }
  }

  static final class ServiceWorkerHostFocusClientResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public ServiceWorkerClientInfo client;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerHostFocusClientResponseParams(int version) {
      super(16, version);
    }

    public ServiceWorkerHostFocusClientResponseParams() {
      this(0);
    }

    public static ServiceWorkerHostFocusClientResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerHostFocusClientResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerHostFocusClientResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerHostFocusClientResponseParams result =
            new ServiceWorkerHostFocusClientResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.client = ServiceWorkerClientInfo.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.client, 8, true);
    }
  }

  static class ServiceWorkerHostFocusClientResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ServiceWorkerHost.FocusClient_Response mCallback;

    ServiceWorkerHostFocusClientResponseParamsForwardToCallback(
        ServiceWorkerHost.FocusClient_Response callback) {
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
        ServiceWorkerHostFocusClientResponseParams response =
            ServiceWorkerHostFocusClientResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.client);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ServiceWorkerHostFocusClientResponseParamsProxyToResponder
      implements ServiceWorkerHost.FocusClient_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ServiceWorkerHostFocusClientResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(ServiceWorkerClientInfo client) {
      ServiceWorkerHostFocusClientResponseParams _response =
          new ServiceWorkerHostFocusClientResponseParams();
      _response.client = client;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(7, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ServiceWorkerHostNavigateClientParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public String clientUuid;
    public Url url;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerHostNavigateClientParams(int version) {
      super(24, version);
    }

    public ServiceWorkerHostNavigateClientParams() {
      this(0);
    }

    public static ServiceWorkerHostNavigateClientParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerHostNavigateClientParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerHostNavigateClientParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerHostNavigateClientParams result =
            new ServiceWorkerHostNavigateClientParams(elementsOrVersion);
        result.clientUuid = decoder0.readString(8, false);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.url = Url.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.clientUuid, 8, false);
      encoder0.encode((Struct) this.url, 16, false);
    }
  }

  static final class ServiceWorkerHostNavigateClientResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public ServiceWorkerClientInfo client;
    public String errorMsg;
    public boolean success;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerHostNavigateClientResponseParams(int version) {
      super(32, version);
    }

    public ServiceWorkerHostNavigateClientResponseParams() {
      this(0);
    }

    public static ServiceWorkerHostNavigateClientResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerHostNavigateClientResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerHostNavigateClientResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerHostNavigateClientResponseParams result =
            new ServiceWorkerHostNavigateClientResponseParams(elementsOrVersion);
        result.success = decoder0.readBoolean(8, 0);
        Decoder decoder1 = decoder0.readPointer(16, true);
        result.client = ServiceWorkerClientInfo.decode(decoder1);
        result.errorMsg = decoder0.readString(24, true);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.success, 8, 0);
      encoder0.encode((Struct) this.client, 16, true);
      encoder0.encode(this.errorMsg, 24, true);
    }
  }

  static class ServiceWorkerHostNavigateClientResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ServiceWorkerHost.NavigateClient_Response mCallback;

    ServiceWorkerHostNavigateClientResponseParamsForwardToCallback(
        ServiceWorkerHost.NavigateClient_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(8, 2)) {
          return false;
        }
        ServiceWorkerHostNavigateClientResponseParams response =
            ServiceWorkerHostNavigateClientResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.success, response.client, response.errorMsg);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ServiceWorkerHostNavigateClientResponseParamsProxyToResponder
      implements ServiceWorkerHost.NavigateClient_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ServiceWorkerHostNavigateClientResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean success, ServiceWorkerClientInfo client, String errorMsg) {
      ServiceWorkerHostNavigateClientResponseParams _response =
          new ServiceWorkerHostNavigateClientResponseParams();
      _response.success = success;
      _response.client = client;
      _response.errorMsg = errorMsg;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(8, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ServiceWorkerHostSkipWaitingParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerHostSkipWaitingParams(int version) {
      super(8, version);
    }

    public ServiceWorkerHostSkipWaitingParams() {
      this(0);
    }

    public static ServiceWorkerHostSkipWaitingParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerHostSkipWaitingParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerHostSkipWaitingParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerHostSkipWaitingParams result =
            new ServiceWorkerHostSkipWaitingParams(elementsOrVersion);
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

  static final class ServiceWorkerHostSkipWaitingResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean success;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerHostSkipWaitingResponseParams(int version) {
      super(16, version);
    }

    public ServiceWorkerHostSkipWaitingResponseParams() {
      this(0);
    }

    public static ServiceWorkerHostSkipWaitingResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerHostSkipWaitingResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerHostSkipWaitingResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerHostSkipWaitingResponseParams result =
            new ServiceWorkerHostSkipWaitingResponseParams(elementsOrVersion);
        result.success = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.success, 8, 0);
    }
  }

  static class ServiceWorkerHostSkipWaitingResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ServiceWorkerHost.SkipWaiting_Response mCallback;

    ServiceWorkerHostSkipWaitingResponseParamsForwardToCallback(
        ServiceWorkerHost.SkipWaiting_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(9, 2)) {
          return false;
        }
        ServiceWorkerHostSkipWaitingResponseParams response =
            ServiceWorkerHostSkipWaitingResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.success);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ServiceWorkerHostSkipWaitingResponseParamsProxyToResponder
      implements ServiceWorkerHost.SkipWaiting_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ServiceWorkerHostSkipWaitingResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean success) {
      ServiceWorkerHostSkipWaitingResponseParams _response =
          new ServiceWorkerHostSkipWaitingResponseParams();
      _response.success = success;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(9, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ServiceWorkerHostClaimClientsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerHostClaimClientsParams(int version) {
      super(8, version);
    }

    public ServiceWorkerHostClaimClientsParams() {
      this(0);
    }

    public static ServiceWorkerHostClaimClientsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerHostClaimClientsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerHostClaimClientsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerHostClaimClientsParams result =
            new ServiceWorkerHostClaimClientsParams(elementsOrVersion);
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

  static final class ServiceWorkerHostClaimClientsResponseParams extends Struct {
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

    private ServiceWorkerHostClaimClientsResponseParams(int version) {
      super(24, version);
    }

    public ServiceWorkerHostClaimClientsResponseParams() {
      this(0);
    }

    public static ServiceWorkerHostClaimClientsResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerHostClaimClientsResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerHostClaimClientsResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerHostClaimClientsResponseParams result =
            new ServiceWorkerHostClaimClientsResponseParams(elementsOrVersion);
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

  static class ServiceWorkerHostClaimClientsResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ServiceWorkerHost.ClaimClients_Response mCallback;

    ServiceWorkerHostClaimClientsResponseParamsForwardToCallback(
        ServiceWorkerHost.ClaimClients_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(10, 2)) {
          return false;
        }
        ServiceWorkerHostClaimClientsResponseParams response =
            ServiceWorkerHostClaimClientsResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.error, response.errorMsg);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ServiceWorkerHostClaimClientsResponseParamsProxyToResponder
      implements ServiceWorkerHost.ClaimClients_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ServiceWorkerHostClaimClientsResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int error, String errorMsg) {
      ServiceWorkerHostClaimClientsResponseParams _response =
          new ServiceWorkerHostClaimClientsResponseParams();
      _response.error = error;
      _response.errorMsg = errorMsg;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(10, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ServiceWorkerHostRegisterRouterParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public ServiceWorkerRouterRules rules;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerHostRegisterRouterParams(int version) {
      super(16, version);
    }

    public ServiceWorkerHostRegisterRouterParams() {
      this(0);
    }

    public static ServiceWorkerHostRegisterRouterParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerHostRegisterRouterParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerHostRegisterRouterParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerHostRegisterRouterParams result =
            new ServiceWorkerHostRegisterRouterParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.rules = ServiceWorkerRouterRules.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.rules, 8, false);
    }
  }

  static final class ServiceWorkerHostRegisterRouterResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerHostRegisterRouterResponseParams(int version) {
      super(8, version);
    }

    public ServiceWorkerHostRegisterRouterResponseParams() {
      this(0);
    }

    public static ServiceWorkerHostRegisterRouterResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerHostRegisterRouterResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerHostRegisterRouterResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerHostRegisterRouterResponseParams result =
            new ServiceWorkerHostRegisterRouterResponseParams(elementsOrVersion);
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

  static class ServiceWorkerHostRegisterRouterResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ServiceWorkerHost.RegisterRouter_Response mCallback;

    ServiceWorkerHostRegisterRouterResponseParamsForwardToCallback(
        ServiceWorkerHost.RegisterRouter_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(11, 2)) {
          return false;
        }
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ServiceWorkerHostRegisterRouterResponseParamsProxyToResponder
      implements ServiceWorkerHost.RegisterRouter_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ServiceWorkerHostRegisterRouterResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      ServiceWorkerHostRegisterRouterResponseParams _response =
          new ServiceWorkerHostRegisterRouterResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(11, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ServiceWorkerHostAddRoutesParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public ServiceWorkerRouterRules rules;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerHostAddRoutesParams(int version) {
      super(16, version);
    }

    public ServiceWorkerHostAddRoutesParams() {
      this(0);
    }

    public static ServiceWorkerHostAddRoutesParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerHostAddRoutesParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerHostAddRoutesParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerHostAddRoutesParams result =
            new ServiceWorkerHostAddRoutesParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.rules = ServiceWorkerRouterRules.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.rules, 8, false);
    }
  }

  static final class ServiceWorkerHostAddRoutesResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerHostAddRoutesResponseParams(int version) {
      super(8, version);
    }

    public ServiceWorkerHostAddRoutesResponseParams() {
      this(0);
    }

    public static ServiceWorkerHostAddRoutesResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerHostAddRoutesResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerHostAddRoutesResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerHostAddRoutesResponseParams result =
            new ServiceWorkerHostAddRoutesResponseParams(elementsOrVersion);
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

  static class ServiceWorkerHostAddRoutesResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ServiceWorkerHost.AddRoutes_Response mCallback;

    ServiceWorkerHostAddRoutesResponseParamsForwardToCallback(
        ServiceWorkerHost.AddRoutes_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(12, 2)) {
          return false;
        }
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ServiceWorkerHostAddRoutesResponseParamsProxyToResponder
      implements ServiceWorkerHost.AddRoutes_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ServiceWorkerHostAddRoutesResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      ServiceWorkerHostAddRoutesResponseParams _response =
          new ServiceWorkerHostAddRoutesResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(12, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
