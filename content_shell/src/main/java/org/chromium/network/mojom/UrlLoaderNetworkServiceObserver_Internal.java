package org.chromium.network.mojom;

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
import org.chromium.mojo_base.mojom.UnguessableToken;
import org.chromium.url.internal.mojom.Origin;
import org.chromium.url.mojom.Url;

class UrlLoaderNetworkServiceObserver_Internal {
  private static final int CLONE_ORDINAL = 8;
  public static final Interface.Manager<
          UrlLoaderNetworkServiceObserver, UrlLoaderNetworkServiceObserver.Proxy>
      MANAGER =
          new Interface.Manager<
              UrlLoaderNetworkServiceObserver, UrlLoaderNetworkServiceObserver.Proxy>() {
            @Override
            public String getName() {
              return "network.mojom.URLLoaderNetworkServiceObserver";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public UrlLoaderNetworkServiceObserver.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, UrlLoaderNetworkServiceObserver impl) {
              return new Stub(core, impl);
            }

            @Override
            public UrlLoaderNetworkServiceObserver[] buildArray(int size) {
              return new UrlLoaderNetworkServiceObserver[size];
            }
          };
  private static final int ON_AUTH_REQUIRED_ORDINAL = 2;
  private static final int ON_CERTIFICATE_REQUESTED_ORDINAL = 1;
  private static final int ON_CLEAR_SITE_DATA_ORDINAL = 4;
  private static final int ON_DATA_USE_UPDATE_ORDINAL = 6;
  private static final int ON_LOADING_STATE_UPDATE_ORDINAL = 5;
  private static final int ON_PRIVATE_NETWORK_ACCESS_PERMISSION_REQUIRED_ORDINAL = 3;
  private static final int ON_SHARED_STORAGE_HEADER_RECEIVED_ORDINAL = 7;
  private static final int ON_SSL_CERTIFICATE_ERROR_ORDINAL = 0;

  UrlLoaderNetworkServiceObserver_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements UrlLoaderNetworkServiceObserver.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onSslCertificateError(
        Url url,
        int netError,
        SslInfo sslInfo,
        boolean fatal,
        UrlLoaderNetworkServiceObserver.OnSslCertificateError_Response callback) {
      UrlLoaderNetworkServiceObserverOnSslCertificateErrorParams _message =
          new UrlLoaderNetworkServiceObserverOnSslCertificateErrorParams();
      _message.url = url;
      _message.netError = netError;
      _message.sslInfo = sslInfo;
      _message.fatal = fatal;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new UrlLoaderNetworkServiceObserverOnSslCertificateErrorResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void onCertificateRequested(
        UnguessableToken windowId,
        SslCertRequestInfo certInfo,
        ClientCertificateResponder certResponder) {
      UrlLoaderNetworkServiceObserverOnCertificateRequestedParams _message =
          new UrlLoaderNetworkServiceObserverOnCertificateRequestedParams();
      _message.windowId = windowId;
      _message.certInfo = certInfo;
      _message.certResponder = certResponder;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void onAuthRequired(
        UnguessableToken windowId,
        int requestId,
        Url url,
        boolean firstAuthAttempt,
        AuthChallengeInfo authInfo,
        HttpResponseHeaders headHeaders,
        AuthChallengeResponder authChallengeResponder) {
      UrlLoaderNetworkServiceObserverOnAuthRequiredParams _message =
          new UrlLoaderNetworkServiceObserverOnAuthRequiredParams();
      _message.windowId = windowId;
      _message.requestId = requestId;
      _message.url = url;
      _message.firstAuthAttempt = firstAuthAttempt;
      _message.authInfo = authInfo;
      _message.headHeaders = headHeaders;
      _message.authChallengeResponder = authChallengeResponder;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void onPrivateNetworkAccessPermissionRequired(
        Url url,
        IpAddress ipAddress,
        String privateNetworkDeviceId,
        String privateNetworkDeviceName,
        UrlLoaderNetworkServiceObserver.OnPrivateNetworkAccessPermissionRequired_Response
            callback) {
      UrlLoaderNetworkServiceObserverOnPrivateNetworkAccessPermissionRequiredParams _message =
          new UrlLoaderNetworkServiceObserverOnPrivateNetworkAccessPermissionRequiredParams();
      _message.url = url;
      _message.ipAddress = ipAddress;
      _message.privateNetworkDeviceId = privateNetworkDeviceId;
      _message.privateNetworkDeviceName = privateNetworkDeviceName;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)),
              new UrlLoaderNetworkServiceObserverOnPrivateNetworkAccessPermissionRequiredResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void onClearSiteData(
        Url url,
        String headerValue,
        int loadFlags,
        CookiePartitionKey cookiePartitionKey,
        boolean partitionedStateAllowedOnly,
        UrlLoaderNetworkServiceObserver.OnClearSiteData_Response callback) {
      UrlLoaderNetworkServiceObserverOnClearSiteDataParams _message =
          new UrlLoaderNetworkServiceObserverOnClearSiteDataParams();
      _message.url = url;
      _message.headerValue = headerValue;
      _message.loadFlags = loadFlags;
      _message.cookiePartitionKey = cookiePartitionKey;
      _message.partitionedStateAllowedOnly = partitionedStateAllowedOnly;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)),
              new UrlLoaderNetworkServiceObserverOnClearSiteDataResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void onLoadingStateUpdate(
        LoadInfo info, UrlLoaderNetworkServiceObserver.OnLoadingStateUpdate_Response callback) {
      UrlLoaderNetworkServiceObserverOnLoadingStateUpdateParams _message =
          new UrlLoaderNetworkServiceObserverOnLoadingStateUpdateParams();
      _message.info = info;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(5, 1, 0L)),
              new UrlLoaderNetworkServiceObserverOnLoadingStateUpdateResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void onDataUseUpdate(
        int networkTrafficAnnotationIdHash, long recvBytes, long sentBytes) {
      UrlLoaderNetworkServiceObserverOnDataUseUpdateParams _message =
          new UrlLoaderNetworkServiceObserverOnDataUseUpdateParams();
      _message.networkTrafficAnnotationIdHash = networkTrafficAnnotationIdHash;
      _message.recvBytes = recvBytes;
      _message.sentBytes = sentBytes;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(6)));
    }

    @Override
    public void onSharedStorageHeaderReceived(
        Origin requestOrigin,
        SharedStorageOperation[] operations,
        UrlLoaderNetworkServiceObserver.OnSharedStorageHeaderReceived_Response callback) {
      UrlLoaderNetworkServiceObserverOnSharedStorageHeaderReceivedParams _message =
          new UrlLoaderNetworkServiceObserverOnSharedStorageHeaderReceivedParams();
      _message.requestOrigin = requestOrigin;
      _message.operations = operations;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(7, 1, 0L)),
              new UrlLoaderNetworkServiceObserverOnSharedStorageHeaderReceivedResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void clone(InterfaceRequest<UrlLoaderNetworkServiceObserver> listener) {
      UrlLoaderNetworkServiceObserverCloneParams _message =
          new UrlLoaderNetworkServiceObserverCloneParams();
      _message.listener = listener;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(8)));
    }
  }

  public static final class Stub extends Interface.Stub<UrlLoaderNetworkServiceObserver> {
    Stub(Core core, UrlLoaderNetworkServiceObserver impl) {
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
                UrlLoaderNetworkServiceObserver_Internal.MANAGER, messageWithHeader);
          case 1:
            UrlLoaderNetworkServiceObserverOnCertificateRequestedParams data =
                UrlLoaderNetworkServiceObserverOnCertificateRequestedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onCertificateRequested(data.windowId, data.certInfo, data.certResponder);
            return true;
          case 2:
            UrlLoaderNetworkServiceObserverOnAuthRequiredParams data2 =
                UrlLoaderNetworkServiceObserverOnAuthRequiredParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .onAuthRequired(
                    data2.windowId,
                    data2.requestId,
                    data2.url,
                    data2.firstAuthAttempt,
                    data2.authInfo,
                    data2.headHeaders,
                    data2.authChallengeResponder);
            return true;
          case 6:
            UrlLoaderNetworkServiceObserverOnDataUseUpdateParams data3 =
                UrlLoaderNetworkServiceObserverOnDataUseUpdateParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .onDataUseUpdate(
                    data3.networkTrafficAnnotationIdHash, data3.recvBytes, data3.sentBytes);
            return true;
          case 8:
            getImpl()
                .clone(
                    UrlLoaderNetworkServiceObserverCloneParams.deserialize(
                            messageWithHeader.getPayload())
                        .listener);
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
                UrlLoaderNetworkServiceObserver_Internal.MANAGER,
                messageWithHeader,
                receiver);
          case 0:
            UrlLoaderNetworkServiceObserverOnSslCertificateErrorParams data =
                UrlLoaderNetworkServiceObserverOnSslCertificateErrorParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .onSslCertificateError(
                    data.url,
                    data.netError,
                    data.sslInfo,
                    data.fatal,
                    new UrlLoaderNetworkServiceObserverOnSslCertificateErrorResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
          case 2:
          case 6:
          default:
            return false;
          case 3:
            UrlLoaderNetworkServiceObserverOnPrivateNetworkAccessPermissionRequiredParams data2 =
                UrlLoaderNetworkServiceObserverOnPrivateNetworkAccessPermissionRequiredParams
                    .deserialize(messageWithHeader.getPayload());
            getImpl()
                .onPrivateNetworkAccessPermissionRequired(
                    data2.url,
                    data2.ipAddress,
                    data2.privateNetworkDeviceId,
                    data2.privateNetworkDeviceName,
                    new UrlLoaderNetworkServiceObserverOnPrivateNetworkAccessPermissionRequiredResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 4:
            UrlLoaderNetworkServiceObserverOnClearSiteDataParams data3 =
                UrlLoaderNetworkServiceObserverOnClearSiteDataParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .onClearSiteData(
                    data3.url,
                    data3.headerValue,
                    data3.loadFlags,
                    data3.cookiePartitionKey,
                    data3.partitionedStateAllowedOnly,
                    new UrlLoaderNetworkServiceObserverOnClearSiteDataResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 5:
            getImpl()
                .onLoadingStateUpdate(
                    UrlLoaderNetworkServiceObserverOnLoadingStateUpdateParams.deserialize(
                            messageWithHeader.getPayload())
                        .info,
                    new UrlLoaderNetworkServiceObserverOnLoadingStateUpdateResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 7:
            UrlLoaderNetworkServiceObserverOnSharedStorageHeaderReceivedParams data4 =
                UrlLoaderNetworkServiceObserverOnSharedStorageHeaderReceivedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .onSharedStorageHeaderReceived(
                    data4.requestOrigin,
                    data4.operations,
                    new UrlLoaderNetworkServiceObserverOnSharedStorageHeaderReceivedResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class UrlLoaderNetworkServiceObserverOnSslCertificateErrorParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean fatal;
    public int netError;
    public SslInfo sslInfo;
    public Url url;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private UrlLoaderNetworkServiceObserverOnSslCertificateErrorParams(int version) {
      super(32, version);
    }

    public UrlLoaderNetworkServiceObserverOnSslCertificateErrorParams() {
      this(0);
    }

    public static UrlLoaderNetworkServiceObserverOnSslCertificateErrorParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static UrlLoaderNetworkServiceObserverOnSslCertificateErrorParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static UrlLoaderNetworkServiceObserverOnSslCertificateErrorParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        UrlLoaderNetworkServiceObserverOnSslCertificateErrorParams result =
            new UrlLoaderNetworkServiceObserverOnSslCertificateErrorParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.url = Url.decode(decoder1);
        result.netError = decoder0.readInt(16);
        result.fatal = decoder0.readBoolean(20, 0);
        Decoder decoder12 = decoder0.readPointer(24, false);
        result.sslInfo = SslInfo.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.url, 8, false);
      encoder0.encode(this.netError, 16);
      encoder0.encode(this.fatal, 20, 0);
      encoder0.encode((Struct) this.sslInfo, 24, false);
    }
  }

  static final class UrlLoaderNetworkServiceObserverOnSslCertificateErrorResponseParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int netError;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private UrlLoaderNetworkServiceObserverOnSslCertificateErrorResponseParams(int version) {
      super(16, version);
    }

    public UrlLoaderNetworkServiceObserverOnSslCertificateErrorResponseParams() {
      this(0);
    }

    public static UrlLoaderNetworkServiceObserverOnSslCertificateErrorResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static UrlLoaderNetworkServiceObserverOnSslCertificateErrorResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static UrlLoaderNetworkServiceObserverOnSslCertificateErrorResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        UrlLoaderNetworkServiceObserverOnSslCertificateErrorResponseParams result =
            new UrlLoaderNetworkServiceObserverOnSslCertificateErrorResponseParams(
                elementsOrVersion);
        result.netError = decoder0.readInt(8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.netError, 8);
    }
  }

  static class UrlLoaderNetworkServiceObserverOnSslCertificateErrorResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final UrlLoaderNetworkServiceObserver.OnSslCertificateError_Response mCallback;

    UrlLoaderNetworkServiceObserverOnSslCertificateErrorResponseParamsForwardToCallback(
        UrlLoaderNetworkServiceObserver.OnSslCertificateError_Response callback) {
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
        UrlLoaderNetworkServiceObserverOnSslCertificateErrorResponseParams response =
            UrlLoaderNetworkServiceObserverOnSslCertificateErrorResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.netError);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class UrlLoaderNetworkServiceObserverOnSslCertificateErrorResponseParamsProxyToResponder
      implements UrlLoaderNetworkServiceObserver.OnSslCertificateError_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    UrlLoaderNetworkServiceObserverOnSslCertificateErrorResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int netError) {
      UrlLoaderNetworkServiceObserverOnSslCertificateErrorResponseParams _response =
          new UrlLoaderNetworkServiceObserverOnSslCertificateErrorResponseParams();
      _response.netError = netError;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class UrlLoaderNetworkServiceObserverOnCertificateRequestedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public SslCertRequestInfo certInfo;
    public ClientCertificateResponder certResponder;
    public UnguessableToken windowId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private UrlLoaderNetworkServiceObserverOnCertificateRequestedParams(int version) {
      super(32, version);
    }

    public UrlLoaderNetworkServiceObserverOnCertificateRequestedParams() {
      this(0);
    }

    public static UrlLoaderNetworkServiceObserverOnCertificateRequestedParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static UrlLoaderNetworkServiceObserverOnCertificateRequestedParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static UrlLoaderNetworkServiceObserverOnCertificateRequestedParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        UrlLoaderNetworkServiceObserverOnCertificateRequestedParams result =
            new UrlLoaderNetworkServiceObserverOnCertificateRequestedParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.windowId = UnguessableToken.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.certInfo = SslCertRequestInfo.decode(decoder12);
        result.certResponder =
            (ClientCertificateResponder)
                decoder0.readServiceInterface(24, false, ClientCertificateResponder.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.windowId, 8, true);
      encoder0.encode((Struct) this.certInfo, 16, false);
      encoder0.encode(this.certResponder, 24, false, ClientCertificateResponder.MANAGER);
    }
  }

  static final class UrlLoaderNetworkServiceObserverOnAuthRequiredParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 56;
    private static final DataHeader[] VERSION_ARRAY;
    public AuthChallengeResponder authChallengeResponder;
    public AuthChallengeInfo authInfo;
    public boolean firstAuthAttempt;
    public HttpResponseHeaders headHeaders;
    public int requestId;
    public Url url;
    public UnguessableToken windowId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(56, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private UrlLoaderNetworkServiceObserverOnAuthRequiredParams(int version) {
      super(56, version);
    }

    public UrlLoaderNetworkServiceObserverOnAuthRequiredParams() {
      this(0);
    }

    public static UrlLoaderNetworkServiceObserverOnAuthRequiredParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static UrlLoaderNetworkServiceObserverOnAuthRequiredParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static UrlLoaderNetworkServiceObserverOnAuthRequiredParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        UrlLoaderNetworkServiceObserverOnAuthRequiredParams result =
            new UrlLoaderNetworkServiceObserverOnAuthRequiredParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.windowId = UnguessableToken.decode(decoder1);
        result.requestId = decoder0.readInt(16);
        result.firstAuthAttempt = decoder0.readBoolean(20, 0);
        Decoder decoder12 = decoder0.readPointer(24, false);
        result.url = Url.decode(decoder12);
        Decoder decoder13 = decoder0.readPointer(32, false);
        result.authInfo = AuthChallengeInfo.decode(decoder13);
        Decoder decoder14 = decoder0.readPointer(40, true);
        result.headHeaders = HttpResponseHeaders.decode(decoder14);
        result.authChallengeResponder =
            (AuthChallengeResponder)
                decoder0.readServiceInterface(48, false, AuthChallengeResponder.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.windowId, 8, true);
      encoder0.encode(this.requestId, 16);
      encoder0.encode(this.firstAuthAttempt, 20, 0);
      encoder0.encode((Struct) this.url, 24, false);
      encoder0.encode((Struct) this.authInfo, 32, false);
      encoder0.encode((Struct) this.headHeaders, 40, true);
      encoder0.encode(this.authChallengeResponder, 48, false, AuthChallengeResponder.MANAGER);
    }
  }

  static final class UrlLoaderNetworkServiceObserverOnPrivateNetworkAccessPermissionRequiredParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public IpAddress ipAddress;
    public String privateNetworkDeviceId;
    public String privateNetworkDeviceName;
    public Url url;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private UrlLoaderNetworkServiceObserverOnPrivateNetworkAccessPermissionRequiredParams(
        int version) {
      super(40, version);
    }

    public UrlLoaderNetworkServiceObserverOnPrivateNetworkAccessPermissionRequiredParams() {
      this(0);
    }

    public static UrlLoaderNetworkServiceObserverOnPrivateNetworkAccessPermissionRequiredParams
        deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static UrlLoaderNetworkServiceObserverOnPrivateNetworkAccessPermissionRequiredParams
        deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static UrlLoaderNetworkServiceObserverOnPrivateNetworkAccessPermissionRequiredParams
        decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        UrlLoaderNetworkServiceObserverOnPrivateNetworkAccessPermissionRequiredParams result =
            new UrlLoaderNetworkServiceObserverOnPrivateNetworkAccessPermissionRequiredParams(
                elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.url = Url.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.ipAddress = IpAddress.decode(decoder12);
        result.privateNetworkDeviceId = decoder0.readString(24, true);
        result.privateNetworkDeviceName = decoder0.readString(32, true);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.url, 8, false);
      encoder0.encode((Struct) this.ipAddress, 16, false);
      encoder0.encode(this.privateNetworkDeviceId, 24, true);
      encoder0.encode(this.privateNetworkDeviceName, 32, true);
    }
  }

  static final
  class UrlLoaderNetworkServiceObserverOnPrivateNetworkAccessPermissionRequiredResponseParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean permissionGranted;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private UrlLoaderNetworkServiceObserverOnPrivateNetworkAccessPermissionRequiredResponseParams(
        int version) {
      super(16, version);
    }

    public UrlLoaderNetworkServiceObserverOnPrivateNetworkAccessPermissionRequiredResponseParams() {
      this(0);
    }

    public static
    UrlLoaderNetworkServiceObserverOnPrivateNetworkAccessPermissionRequiredResponseParams
        deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static
    UrlLoaderNetworkServiceObserverOnPrivateNetworkAccessPermissionRequiredResponseParams
        deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static
    UrlLoaderNetworkServiceObserverOnPrivateNetworkAccessPermissionRequiredResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        UrlLoaderNetworkServiceObserverOnPrivateNetworkAccessPermissionRequiredResponseParams
            result =
                new UrlLoaderNetworkServiceObserverOnPrivateNetworkAccessPermissionRequiredResponseParams(
                    elementsOrVersion);
        result.permissionGranted = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.permissionGranted, 8, 0);
    }
  }

  static
  class UrlLoaderNetworkServiceObserverOnPrivateNetworkAccessPermissionRequiredResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final UrlLoaderNetworkServiceObserver.OnPrivateNetworkAccessPermissionRequired_Response
        mCallback;

    UrlLoaderNetworkServiceObserverOnPrivateNetworkAccessPermissionRequiredResponseParamsForwardToCallback(
        UrlLoaderNetworkServiceObserver.OnPrivateNetworkAccessPermissionRequired_Response
            callback) {
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
        UrlLoaderNetworkServiceObserverOnPrivateNetworkAccessPermissionRequiredResponseParams
            response =
                UrlLoaderNetworkServiceObserverOnPrivateNetworkAccessPermissionRequiredResponseParams
                    .deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.permissionGranted);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static
  class UrlLoaderNetworkServiceObserverOnPrivateNetworkAccessPermissionRequiredResponseParamsProxyToResponder
      implements UrlLoaderNetworkServiceObserver.OnPrivateNetworkAccessPermissionRequired_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    UrlLoaderNetworkServiceObserverOnPrivateNetworkAccessPermissionRequiredResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean permissionGranted) {
      UrlLoaderNetworkServiceObserverOnPrivateNetworkAccessPermissionRequiredResponseParams
          _response =
              new UrlLoaderNetworkServiceObserverOnPrivateNetworkAccessPermissionRequiredResponseParams();
      _response.permissionGranted = permissionGranted;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class UrlLoaderNetworkServiceObserverOnClearSiteDataParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public CookiePartitionKey cookiePartitionKey;
    public String headerValue;
    public int loadFlags;
    public boolean partitionedStateAllowedOnly;
    public Url url;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private UrlLoaderNetworkServiceObserverOnClearSiteDataParams(int version) {
      super(40, version);
    }

    public UrlLoaderNetworkServiceObserverOnClearSiteDataParams() {
      this(0);
    }

    public static UrlLoaderNetworkServiceObserverOnClearSiteDataParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static UrlLoaderNetworkServiceObserverOnClearSiteDataParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static UrlLoaderNetworkServiceObserverOnClearSiteDataParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        UrlLoaderNetworkServiceObserverOnClearSiteDataParams result =
            new UrlLoaderNetworkServiceObserverOnClearSiteDataParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.url = Url.decode(decoder1);
        result.headerValue = decoder0.readString(16, false);
        result.loadFlags = decoder0.readInt(24);
        result.partitionedStateAllowedOnly = decoder0.readBoolean(28, 0);
        Decoder decoder12 = decoder0.readPointer(32, true);
        result.cookiePartitionKey = CookiePartitionKey.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.url, 8, false);
      encoder0.encode(this.headerValue, 16, false);
      encoder0.encode(this.loadFlags, 24);
      encoder0.encode(this.partitionedStateAllowedOnly, 28, 0);
      encoder0.encode((Struct) this.cookiePartitionKey, 32, true);
    }
  }

  static final class UrlLoaderNetworkServiceObserverOnClearSiteDataResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private UrlLoaderNetworkServiceObserverOnClearSiteDataResponseParams(int version) {
      super(8, version);
    }

    public UrlLoaderNetworkServiceObserverOnClearSiteDataResponseParams() {
      this(0);
    }

    public static UrlLoaderNetworkServiceObserverOnClearSiteDataResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static UrlLoaderNetworkServiceObserverOnClearSiteDataResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static UrlLoaderNetworkServiceObserverOnClearSiteDataResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        UrlLoaderNetworkServiceObserverOnClearSiteDataResponseParams result =
            new UrlLoaderNetworkServiceObserverOnClearSiteDataResponseParams(elementsOrVersion);
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

  static class UrlLoaderNetworkServiceObserverOnClearSiteDataResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final UrlLoaderNetworkServiceObserver.OnClearSiteData_Response mCallback;

    UrlLoaderNetworkServiceObserverOnClearSiteDataResponseParamsForwardToCallback(
        UrlLoaderNetworkServiceObserver.OnClearSiteData_Response callback) {
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
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class UrlLoaderNetworkServiceObserverOnClearSiteDataResponseParamsProxyToResponder
      implements UrlLoaderNetworkServiceObserver.OnClearSiteData_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    UrlLoaderNetworkServiceObserverOnClearSiteDataResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      UrlLoaderNetworkServiceObserverOnClearSiteDataResponseParams _response =
          new UrlLoaderNetworkServiceObserverOnClearSiteDataResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class UrlLoaderNetworkServiceObserverOnLoadingStateUpdateParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public LoadInfo info;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private UrlLoaderNetworkServiceObserverOnLoadingStateUpdateParams(int version) {
      super(16, version);
    }

    public UrlLoaderNetworkServiceObserverOnLoadingStateUpdateParams() {
      this(0);
    }

    public static UrlLoaderNetworkServiceObserverOnLoadingStateUpdateParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static UrlLoaderNetworkServiceObserverOnLoadingStateUpdateParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static UrlLoaderNetworkServiceObserverOnLoadingStateUpdateParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        UrlLoaderNetworkServiceObserverOnLoadingStateUpdateParams result =
            new UrlLoaderNetworkServiceObserverOnLoadingStateUpdateParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.info = LoadInfo.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.info, 8, false);
    }
  }

  static final class UrlLoaderNetworkServiceObserverOnLoadingStateUpdateResponseParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private UrlLoaderNetworkServiceObserverOnLoadingStateUpdateResponseParams(int version) {
      super(8, version);
    }

    public UrlLoaderNetworkServiceObserverOnLoadingStateUpdateResponseParams() {
      this(0);
    }

    public static UrlLoaderNetworkServiceObserverOnLoadingStateUpdateResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static UrlLoaderNetworkServiceObserverOnLoadingStateUpdateResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static UrlLoaderNetworkServiceObserverOnLoadingStateUpdateResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        UrlLoaderNetworkServiceObserverOnLoadingStateUpdateResponseParams result =
            new UrlLoaderNetworkServiceObserverOnLoadingStateUpdateResponseParams(
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

  static class UrlLoaderNetworkServiceObserverOnLoadingStateUpdateResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final UrlLoaderNetworkServiceObserver.OnLoadingStateUpdate_Response mCallback;

    UrlLoaderNetworkServiceObserverOnLoadingStateUpdateResponseParamsForwardToCallback(
        UrlLoaderNetworkServiceObserver.OnLoadingStateUpdate_Response callback) {
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
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class UrlLoaderNetworkServiceObserverOnLoadingStateUpdateResponseParamsProxyToResponder
      implements UrlLoaderNetworkServiceObserver.OnLoadingStateUpdate_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    UrlLoaderNetworkServiceObserverOnLoadingStateUpdateResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      UrlLoaderNetworkServiceObserverOnLoadingStateUpdateResponseParams _response =
          new UrlLoaderNetworkServiceObserverOnLoadingStateUpdateResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(5, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class UrlLoaderNetworkServiceObserverOnDataUseUpdateParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public int networkTrafficAnnotationIdHash;
    public long recvBytes;
    public long sentBytes;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private UrlLoaderNetworkServiceObserverOnDataUseUpdateParams(int version) {
      super(32, version);
    }

    public UrlLoaderNetworkServiceObserverOnDataUseUpdateParams() {
      this(0);
    }

    public static UrlLoaderNetworkServiceObserverOnDataUseUpdateParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static UrlLoaderNetworkServiceObserverOnDataUseUpdateParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static UrlLoaderNetworkServiceObserverOnDataUseUpdateParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        UrlLoaderNetworkServiceObserverOnDataUseUpdateParams result =
            new UrlLoaderNetworkServiceObserverOnDataUseUpdateParams(elementsOrVersion);
        result.networkTrafficAnnotationIdHash = decoder0.readInt(8);
        result.recvBytes = decoder0.readLong(16);
        result.sentBytes = decoder0.readLong(24);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.networkTrafficAnnotationIdHash, 8);
      encoder0.encode(this.recvBytes, 16);
      encoder0.encode(this.sentBytes, 24);
    }
  }

  static final class UrlLoaderNetworkServiceObserverOnSharedStorageHeaderReceivedParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public SharedStorageOperation[] operations;
    public Origin requestOrigin;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private UrlLoaderNetworkServiceObserverOnSharedStorageHeaderReceivedParams(int version) {
      super(24, version);
    }

    public UrlLoaderNetworkServiceObserverOnSharedStorageHeaderReceivedParams() {
      this(0);
    }

    public static UrlLoaderNetworkServiceObserverOnSharedStorageHeaderReceivedParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static UrlLoaderNetworkServiceObserverOnSharedStorageHeaderReceivedParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static UrlLoaderNetworkServiceObserverOnSharedStorageHeaderReceivedParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        UrlLoaderNetworkServiceObserverOnSharedStorageHeaderReceivedParams result =
            new UrlLoaderNetworkServiceObserverOnSharedStorageHeaderReceivedParams(
                elementsOrVersion);
        result.requestOrigin = Origin.decode(decoder0.readPointer(8, false));
        Decoder decoder1 = decoder0.readPointer(16, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.operations = new SharedStorageOperation[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.operations[i1] = SharedStorageOperation.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.requestOrigin, 8, false);
      SharedStorageOperation[] sharedStorageOperationArr = this.operations;
      if (sharedStorageOperationArr == null) {
        encoder0.encodeNullPointer(16, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(sharedStorageOperationArr.length, 16, -1);
      int i0 = 0;
      while (true) {
        SharedStorageOperation[] sharedStorageOperationArr2 = this.operations;
        if (i0 < sharedStorageOperationArr2.length) {
          encoder1.encode((Struct) sharedStorageOperationArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static final class UrlLoaderNetworkServiceObserverOnSharedStorageHeaderReceivedResponseParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private UrlLoaderNetworkServiceObserverOnSharedStorageHeaderReceivedResponseParams(
        int version) {
      super(8, version);
    }

    public UrlLoaderNetworkServiceObserverOnSharedStorageHeaderReceivedResponseParams() {
      this(0);
    }

    public static UrlLoaderNetworkServiceObserverOnSharedStorageHeaderReceivedResponseParams
        deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static UrlLoaderNetworkServiceObserverOnSharedStorageHeaderReceivedResponseParams
        deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static UrlLoaderNetworkServiceObserverOnSharedStorageHeaderReceivedResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        UrlLoaderNetworkServiceObserverOnSharedStorageHeaderReceivedResponseParams result =
            new UrlLoaderNetworkServiceObserverOnSharedStorageHeaderReceivedResponseParams(
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

  static
  class UrlLoaderNetworkServiceObserverOnSharedStorageHeaderReceivedResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final UrlLoaderNetworkServiceObserver.OnSharedStorageHeaderReceived_Response mCallback;

    UrlLoaderNetworkServiceObserverOnSharedStorageHeaderReceivedResponseParamsForwardToCallback(
        UrlLoaderNetworkServiceObserver.OnSharedStorageHeaderReceived_Response callback) {
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

  static
  class UrlLoaderNetworkServiceObserverOnSharedStorageHeaderReceivedResponseParamsProxyToResponder
      implements UrlLoaderNetworkServiceObserver.OnSharedStorageHeaderReceived_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    UrlLoaderNetworkServiceObserverOnSharedStorageHeaderReceivedResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      UrlLoaderNetworkServiceObserverOnSharedStorageHeaderReceivedResponseParams _response =
          new UrlLoaderNetworkServiceObserverOnSharedStorageHeaderReceivedResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(7, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class UrlLoaderNetworkServiceObserverCloneParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<UrlLoaderNetworkServiceObserver> listener;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private UrlLoaderNetworkServiceObserverCloneParams(int version) {
      super(16, version);
    }

    public UrlLoaderNetworkServiceObserverCloneParams() {
      this(0);
    }

    public static UrlLoaderNetworkServiceObserverCloneParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static UrlLoaderNetworkServiceObserverCloneParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static UrlLoaderNetworkServiceObserverCloneParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        UrlLoaderNetworkServiceObserverCloneParams result =
            new UrlLoaderNetworkServiceObserverCloneParams(elementsOrVersion);
        result.listener = decoder0.readInterfaceRequest(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.listener, 8, false);
    }
  }
}
