package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
import org.chromium.mojo.bindings.Union;
import org.chromium.mojo.system.Core;
import org.chromium.mojo.system.DataPipe;
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.InvalidHandle;
import org.chromium.mojo_base.mojom.DictionaryValue;
import org.chromium.mojo_base.mojom.Time;
import org.chromium.mojo_base.mojom.UnguessableToken;
import org.chromium.url.internal.mojom.Origin;
import org.chromium.url.mojom.Url;

class NetworkContext_Internal {
  private static final int ADD_AUTH_CACHE_ENTRY_ORDINAL = 61;
  private static final int ADD_DOMAIN_RELIABILITY_CONTEXT_FOR_TESTING_ORDINAL = 66;
  private static final int ADD_HSTS_ORDINAL = 53;
  private static final int ADD_REPORTING_API_OBSERVER_ORDINAL = 69;
  private static final int CLEAR_BAD_PROXIES_CACHE_ORDINAL = 43;
  private static final int CLEAR_CORS_PREFLIGHT_CACHE_ORDINAL = 18;
  private static final int CLEAR_DOMAIN_RELIABILITY_ORDINAL = 22;
  private static final int CLEAR_HOST_CACHE_ORDINAL = 16;
  private static final int CLEAR_HTTP_AUTH_CACHE_ORDINAL = 17;
  private static final int CLEAR_HTTP_CACHE_ORDINAL = 13;
  private static final int CLEAR_NETWORKING_HISTORY_BETWEEN_ORDINAL = 12;
  private static final int CLEAR_NETWORK_ERROR_LOGGING_ORDINAL = 21;
  private static final int CLEAR_REPORTING_CACHE_CLIENTS_ORDINAL = 20;
  private static final int CLEAR_REPORTING_CACHE_REPORTS_ORDINAL = 19;
  private static final int CLEAR_SHARED_DICTIONARY_CACHE_FOR_ISOLATION_KEY_ORDINAL = 24;
  private static final int CLEAR_SHARED_DICTIONARY_CACHE_ORDINAL = 23;
  private static final int CLEAR_TRUST_TOKEN_DATA_ORDINAL = 7;
  private static final int CLEAR_TRUST_TOKEN_SESSION_ONLY_DATA_ORDINAL = 8;
  private static final int CLOSE_ALL_CONNECTIONS_ORDINAL = 29;
  private static final int CLOSE_IDLE_CONNECTIONS_ORDINAL = 30;
  private static final int COMPUTE_HTTP_CACHE_SIZE_ORDINAL = 14;
  private static final int CREATE_HOST_RESOLVER_ORDINAL = 51;
  private static final int CREATE_MDNS_RESPONDER_ORDINAL = 49;
  private static final int CREATE_NET_LOG_EXPORTER_ORDINAL = 46;
  private static final int CREATE_P2P_SOCKET_MANAGER_ORDINAL = 48;
  private static final int CREATE_PROXY_RESOLVING_SOCKET_FACTORY_ORDINAL = 40;
  private static final int CREATE_RESTRICTED_UDP_SOCKET_ORDINAL = 36;
  private static final int CREATE_TCP_BOUND_SOCKET_ORDINAL = 39;
  private static final int CREATE_TCP_CONNECTED_SOCKET_ORDINAL = 38;
  private static final int CREATE_TCP_SERVER_SOCKET_ORDINAL = 37;
  private static final int CREATE_UDP_SOCKET_ORDINAL = 35;
  private static final int CREATE_URL_LOADER_FACTORY_ORDINAL = 1;
  private static final int CREATE_WEB_SOCKET_ORDINAL = 44;
  private static final int CREATE_WEB_TRANSPORT_ORDINAL = 45;
  private static final int DELETE_DYNAMIC_DATA_FOR_HOST_ORDINAL = 57;
  private static final int DELETE_STORED_TRUST_TOKENS_ORDINAL = 10;
  private static final int ENABLE_STATIC_KEY_PINNING_FOR_TESTING_ORDINAL = 64;
  private static final int FLUSH_CACHED_CLIENT_CERT_IF_NEEDED_ORDINAL = 75;
  private static final int FORCE_DOMAIN_RELIABILITY_UPLOADS_FOR_TESTING_ORDINAL = 67;
  private static final int FORCE_RELOAD_PROXY_CONFIG_ORDINAL = 42;
  private static final int GET_COOKIE_MANAGER_ORDINAL = 4;
  private static final int GET_HSTS_STATE_ORDINAL = 55;
  private static final int GET_RESTRICTED_COOKIE_MANAGER_ORDINAL = 5;
  private static final int GET_SHARED_DICTIONARY_INFO_ORDINAL = 71;
  private static final int GET_SHARED_DICTIONARY_ORIGINS_BETWEEN_ORDINAL = 72;
  private static final int GET_SHARED_DICTIONARY_USAGE_INFO_ORDINAL = 70;
  private static final int GET_STORED_TRUST_TOKEN_COUNTS_ORDINAL = 9;
  private static final int GET_TRUST_TOKEN_QUERY_ANSWERER_ORDINAL = 6;
  private static final int GET_VIA_OBLIVIOUS_HTTP_ORDINAL = 3;
  private static final int IS_HSTS_ACTIVE_FOR_HOST_ORDINAL = 54;
  private static final int LOAD_HTTP_AUTH_CACHE_PROXY_ENTRIES_ORDINAL = 60;
  private static final int LOOKUP_SERVER_BASIC_AUTH_CREDENTIALS_ORDINAL = 63;
  private static final int LOOK_UP_PROXY_FOR_URL_ORDINAL = 41;
  public static final Interface.Manager<NetworkContext, NetworkContext.Proxy> MANAGER =
      new Interface.Manager<NetworkContext, NetworkContext.Proxy>() {
        @Override
        public String getName() {
          return "network.mojom.NetworkContext";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public NetworkContext.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, NetworkContext impl) {
          return new Stub(core, impl);
        }

        @Override
        public NetworkContext[] buildArray(int size) {
          return new NetworkContext[size];
        }
      };
  private static final int NOTIFY_EXTERNAL_CACHE_HIT_ORDINAL = 15;
  private static final int PRECONNECT_SOCKETS_ORDINAL = 47;
  private static final int QUEUE_REPORT_ORDINAL = 27;
  private static final int QUEUE_SIGNED_EXCHANGE_REPORT_ORDINAL = 28;
  private static final int RESET_URL_LOADER_FACTORIES_ORDINAL = 2;
  private static final int RESOLVE_HOST_ORDINAL = 50;
  private static final int RESOURCE_SCHEDULER_CLIENT_VISIBILITY_CHANGED_ORDINAL = 74;
  private static final int SAVE_HTTP_AUTH_CACHE_PROXY_ENTRIES_ORDINAL = 59;
  private static final int SEND_REPORTS_AND_REMOVE_SOURCE_ORDINAL = 26;
  private static final int SET_ACCEPT_LANGUAGE_ORDINAL = 32;
  private static final int SET_BLOCK_TRUST_TOKENS_ORDINAL = 11;
  private static final int SET_CLIENT_ORDINAL = 0;
  private static final int SET_COOKIE_DEPRECATION_LABEL_ORDINAL = 76;
  private static final int SET_CORS_NON_WILDCARD_REQUEST_HEADERS_SUPPORT_ORDINAL = 62;
  private static final int SET_CORS_ORIGIN_ACCESS_LISTS_FOR_ORIGIN_ORDINAL = 56;
  private static final int SET_CT_POLICY_ORDINAL = 34;
  private static final int SET_DOCUMENT_REPORTING_ENDPOINTS_ORDINAL = 25;
  private static final int SET_ENABLE_REFERRERS_ORDINAL = 33;
  private static final int SET_NETWORK_CONDITIONS_ORDINAL = 31;
  private static final int SET_SCT_AUDITING_MODE_ORDINAL = 68;
  private static final int SET_SHARED_DICTIONARY_CACHE_MAX_SIZE_ORDINAL = 73;
  private static final int SET_SPLIT_AUTH_CACHE_BY_NETWORK_ANONYMIZATION_KEY_ORDINAL = 58;
  private static final int VERIFY_CERTIFICATE_FOR_TESTING_ORDINAL = 65;
  private static final int VERIFY_CERT_FOR_SIGNED_EXCHANGE_ORDINAL = 52;

  NetworkContext_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements NetworkContext.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void setClient(NetworkContextClient client) {
      NetworkContextSetClientParams _message = new NetworkContextSetClientParams();
      _message.client = client;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void createUrlLoaderFactory(
        InterfaceRequest<UrlLoaderFactory> urlLoaderFactory, UrlLoaderFactoryParams params) {
      NetworkContextCreateUrlLoaderFactoryParams _message =
          new NetworkContextCreateUrlLoaderFactoryParams();
      _message.urlLoaderFactory = urlLoaderFactory;
      _message.params = params;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void resetUrlLoaderFactories() {
      NetworkContextResetUrlLoaderFactoriesParams _message =
          new NetworkContextResetUrlLoaderFactoriesParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void getViaObliviousHttp(ObliviousHttpRequest request, ObliviousHttpClient client) {
      NetworkContextGetViaObliviousHttpParams _message =
          new NetworkContextGetViaObliviousHttpParams();
      _message.request = request;
      _message.client = client;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }

    @Override
    public void getCookieManager(InterfaceRequest<CookieManager> cookieManager) {
      NetworkContextGetCookieManagerParams _message = new NetworkContextGetCookieManagerParams();
      _message.cookieManager = cookieManager;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
    }

    @Override
    public void getRestrictedCookieManager(
        InterfaceRequest<RestrictedCookieManager> restrictedCookieManager,
        int role,
        Origin origin,
        IsolationInfo isolationInfo,
        CookieSettingOverrides cookieSettingOverrides,
        CookieAccessObserver cookieObserver) {
      NetworkContextGetRestrictedCookieManagerParams _message =
          new NetworkContextGetRestrictedCookieManagerParams();
      _message.restrictedCookieManager = restrictedCookieManager;
      _message.role = role;
      _message.origin = origin;
      _message.isolationInfo = isolationInfo;
      _message.cookieSettingOverrides = cookieSettingOverrides;
      _message.cookieObserver = cookieObserver;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5)));
    }

    @Override
    public void getTrustTokenQueryAnswerer(
        InterfaceRequest<TrustTokenQueryAnswerer> trustTokenQueryAnswerer, Origin topFrameOrigin) {
      NetworkContextGetTrustTokenQueryAnswererParams _message =
          new NetworkContextGetTrustTokenQueryAnswererParams();
      _message.trustTokenQueryAnswerer = trustTokenQueryAnswerer;
      _message.topFrameOrigin = topFrameOrigin;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(6)));
    }

    @Override
    public void clearTrustTokenData(
        ClearDataFilter filter, NetworkContext.ClearTrustTokenData_Response callback) {
      NetworkContextClearTrustTokenDataParams _message =
          new NetworkContextClearTrustTokenDataParams();
      _message.filter = filter;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(7, 1, 0L)),
              new NetworkContextClearTrustTokenDataResponseParamsForwardToCallback(callback));
    }

    @Override
    public void clearTrustTokenSessionOnlyData(
        NetworkContext.ClearTrustTokenSessionOnlyData_Response callback) {
      NetworkContextClearTrustTokenSessionOnlyDataParams _message =
          new NetworkContextClearTrustTokenSessionOnlyDataParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(8, 1, 0L)),
              new NetworkContextClearTrustTokenSessionOnlyDataResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void getStoredTrustTokenCounts(
        NetworkContext.GetStoredTrustTokenCounts_Response callback) {
      NetworkContextGetStoredTrustTokenCountsParams _message =
          new NetworkContextGetStoredTrustTokenCountsParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(9, 1, 0L)),
              new NetworkContextGetStoredTrustTokenCountsResponseParamsForwardToCallback(callback));
    }

    @Override
    public void deleteStoredTrustTokens(
        Origin issuer, NetworkContext.DeleteStoredTrustTokens_Response callback) {
      NetworkContextDeleteStoredTrustTokensParams _message =
          new NetworkContextDeleteStoredTrustTokensParams();
      _message.issuer = issuer;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(10, 1, 0L)),
              new NetworkContextDeleteStoredTrustTokensResponseParamsForwardToCallback(callback));
    }

    @Override
    public void setBlockTrustTokens(boolean block) {
      NetworkContextSetBlockTrustTokensParams _message =
          new NetworkContextSetBlockTrustTokensParams();
      _message.block = block;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(11)));
    }

    @Override
    public void clearNetworkingHistoryBetween(
        Time startTime,
        Time endTime,
        NetworkContext.ClearNetworkingHistoryBetween_Response callback) {
      NetworkContextClearNetworkingHistoryBetweenParams _message =
          new NetworkContextClearNetworkingHistoryBetweenParams();
      _message.startTime = startTime;
      _message.endTime = endTime;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(12, 1, 0L)),
              new NetworkContextClearNetworkingHistoryBetweenResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void clearHttpCache(
        Time startTime,
        Time endTime,
        ClearDataFilter filter,
        NetworkContext.ClearHttpCache_Response callback) {
      NetworkContextClearHttpCacheParams _message = new NetworkContextClearHttpCacheParams();
      _message.startTime = startTime;
      _message.endTime = endTime;
      _message.filter = filter;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(13, 1, 0L)),
              new NetworkContextClearHttpCacheResponseParamsForwardToCallback(callback));
    }

    @Override
    public void computeHttpCacheSize(
        Time startTime, Time endTime, NetworkContext.ComputeHttpCacheSize_Response callback) {
      NetworkContextComputeHttpCacheSizeParams _message =
          new NetworkContextComputeHttpCacheSizeParams();
      _message.startTime = startTime;
      _message.endTime = endTime;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(14, 1, 0L)),
              new NetworkContextComputeHttpCacheSizeResponseParamsForwardToCallback(callback));
    }

    @Override
    public void notifyExternalCacheHit(
        Url url,
        String httpMethod,
        NetworkIsolationKey key,
        boolean isSubframeDocumentResource,
        boolean includeCredentials) {
      NetworkContextNotifyExternalCacheHitParams _message =
          new NetworkContextNotifyExternalCacheHitParams();
      _message.url = url;
      _message.httpMethod = httpMethod;
      _message.key = key;
      _message.isSubframeDocumentResource = isSubframeDocumentResource;
      _message.includeCredentials = includeCredentials;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(15)));
    }

    @Override
    public void clearHostCache(
        ClearDataFilter filter, NetworkContext.ClearHostCache_Response callback) {
      NetworkContextClearHostCacheParams _message = new NetworkContextClearHostCacheParams();
      _message.filter = filter;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(16, 1, 0L)),
              new NetworkContextClearHostCacheResponseParamsForwardToCallback(callback));
    }

    @Override
    public void clearHttpAuthCache(
        Time startTime,
        Time endTime,
        ClearDataFilter filter,
        NetworkContext.ClearHttpAuthCache_Response callback) {
      NetworkContextClearHttpAuthCacheParams _message =
          new NetworkContextClearHttpAuthCacheParams();
      _message.startTime = startTime;
      _message.endTime = endTime;
      _message.filter = filter;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(17, 1, 0L)),
              new NetworkContextClearHttpAuthCacheResponseParamsForwardToCallback(callback));
    }

    @Override
    public void clearCorsPreflightCache(
        ClearDataFilter filter, NetworkContext.ClearCorsPreflightCache_Response callback) {
      NetworkContextClearCorsPreflightCacheParams _message =
          new NetworkContextClearCorsPreflightCacheParams();
      _message.filter = filter;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(18, 1, 0L)),
              new NetworkContextClearCorsPreflightCacheResponseParamsForwardToCallback(callback));
    }

    @Override
    public void clearReportingCacheReports(
        ClearDataFilter filter, NetworkContext.ClearReportingCacheReports_Response callback) {
      NetworkContextClearReportingCacheReportsParams _message =
          new NetworkContextClearReportingCacheReportsParams();
      _message.filter = filter;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(19, 1, 0L)),
              new NetworkContextClearReportingCacheReportsResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void clearReportingCacheClients(
        ClearDataFilter filter, NetworkContext.ClearReportingCacheClients_Response callback) {
      NetworkContextClearReportingCacheClientsParams _message =
          new NetworkContextClearReportingCacheClientsParams();
      _message.filter = filter;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(20, 1, 0L)),
              new NetworkContextClearReportingCacheClientsResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void clearNetworkErrorLogging(
        ClearDataFilter filter, NetworkContext.ClearNetworkErrorLogging_Response callback) {
      NetworkContextClearNetworkErrorLoggingParams _message =
          new NetworkContextClearNetworkErrorLoggingParams();
      _message.filter = filter;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(21, 1, 0L)),
              new NetworkContextClearNetworkErrorLoggingResponseParamsForwardToCallback(callback));
    }

    @Override
    public void clearDomainReliability(
        ClearDataFilter filter, int mode, NetworkContext.ClearDomainReliability_Response callback) {
      NetworkContextClearDomainReliabilityParams _message =
          new NetworkContextClearDomainReliabilityParams();
      _message.filter = filter;
      _message.mode = mode;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(22, 1, 0L)),
              new NetworkContextClearDomainReliabilityResponseParamsForwardToCallback(callback));
    }

    @Override
    public void clearSharedDictionaryCache(
        Time startTime,
        Time endTime,
        ClearDataFilter filter,
        NetworkContext.ClearSharedDictionaryCache_Response callback) {
      NetworkContextClearSharedDictionaryCacheParams _message =
          new NetworkContextClearSharedDictionaryCacheParams();
      _message.startTime = startTime;
      _message.endTime = endTime;
      _message.filter = filter;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(23, 1, 0L)),
              new NetworkContextClearSharedDictionaryCacheResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void clearSharedDictionaryCacheForIsolationKey(
        SharedDictionaryIsolationKey isolationKey,
        NetworkContext.ClearSharedDictionaryCacheForIsolationKey_Response callback) {
      NetworkContextClearSharedDictionaryCacheForIsolationKeyParams _message =
          new NetworkContextClearSharedDictionaryCacheForIsolationKeyParams();
      _message.isolationKey = isolationKey;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(24, 1, 0L)),
              new NetworkContextClearSharedDictionaryCacheForIsolationKeyResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void setDocumentReportingEndpoints(
        UnguessableToken reportingSource,
        Origin origin,
        IsolationInfo isolationInfo,
        Map<String, String> endpoints) {
      NetworkContextSetDocumentReportingEndpointsParams _message =
          new NetworkContextSetDocumentReportingEndpointsParams();
      _message.reportingSource = reportingSource;
      _message.origin = origin;
      _message.isolationInfo = isolationInfo;
      _message.endpoints = endpoints;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(25)));
    }

    @Override
    public void sendReportsAndRemoveSource(UnguessableToken reportingSource) {
      NetworkContextSendReportsAndRemoveSourceParams _message =
          new NetworkContextSendReportsAndRemoveSourceParams();
      _message.reportingSource = reportingSource;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(26)));
    }

    @Override
    public void queueReport(
        String type,
        String group,
        Url url,
        UnguessableToken reportingSource,
        NetworkAnonymizationKey networkAnonymizationKey,
        String userAgent,
        DictionaryValue body) {
      NetworkContextQueueReportParams _message = new NetworkContextQueueReportParams();
      _message.type = type;
      _message.group = group;
      _message.url = url;
      _message.reportingSource = reportingSource;
      _message.networkAnonymizationKey = networkAnonymizationKey;
      _message.userAgent = userAgent;
      _message.body = body;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(27)));
    }

    @Override
    public void queueSignedExchangeReport(
        SignedExchangeReport report, NetworkAnonymizationKey networkAnonymizationKey) {
      NetworkContextQueueSignedExchangeReportParams _message =
          new NetworkContextQueueSignedExchangeReportParams();
      _message.report = report;
      _message.networkAnonymizationKey = networkAnonymizationKey;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(28)));
    }

    @Override
    public void closeAllConnections(NetworkContext.CloseAllConnections_Response callback) {
      NetworkContextCloseAllConnectionsParams _message =
          new NetworkContextCloseAllConnectionsParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(29, 1, 0L)),
              new NetworkContextCloseAllConnectionsResponseParamsForwardToCallback(callback));
    }

    @Override
    public void closeIdleConnections(NetworkContext.CloseIdleConnections_Response callback) {
      NetworkContextCloseIdleConnectionsParams _message =
          new NetworkContextCloseIdleConnectionsParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(30, 1, 0L)),
              new NetworkContextCloseIdleConnectionsResponseParamsForwardToCallback(callback));
    }

    @Override
    public void setNetworkConditions(
        UnguessableToken throttlingProfileId, NetworkConditions conditions) {
      NetworkContextSetNetworkConditionsParams _message =
          new NetworkContextSetNetworkConditionsParams();
      _message.throttlingProfileId = throttlingProfileId;
      _message.conditions = conditions;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(31)));
    }

    @Override
    public void setAcceptLanguage(String newAcceptLanguage) {
      NetworkContextSetAcceptLanguageParams _message = new NetworkContextSetAcceptLanguageParams();
      _message.newAcceptLanguage = newAcceptLanguage;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(32)));
    }

    @Override
    public void setEnableReferrers(boolean enableReferrers) {
      NetworkContextSetEnableReferrersParams _message =
          new NetworkContextSetEnableReferrersParams();
      _message.enableReferrers = enableReferrers;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(33)));
    }

    @Override
    public void setCtPolicy(CtPolicy ctPolicy) {
      NetworkContextSetCtPolicyParams _message = new NetworkContextSetCtPolicyParams();
      _message.ctPolicy = ctPolicy;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(34)));
    }

    @Override
    public void createUdpSocket(InterfaceRequest<UdpSocket> receiver, UdpSocketListener listener) {
      NetworkContextCreateUdpSocketParams _message = new NetworkContextCreateUdpSocketParams();
      _message.receiver = receiver;
      _message.listener = listener;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(35)));
    }

    @Override
    public void createRestrictedUdpSocket(
        IpEndPoint addr,
        int mode,
        MutableNetworkTrafficAnnotationTag trafficAnnotation,
        RestrictedUdpSocketParams params,
        InterfaceRequest<RestrictedUdpSocket> receiver,
        UdpSocketListener listener,
        NetworkContext.CreateRestrictedUdpSocket_Response callback) {
      NetworkContextCreateRestrictedUdpSocketParams _message =
          new NetworkContextCreateRestrictedUdpSocketParams();
      _message.addr = addr;
      _message.mode = mode;
      _message.trafficAnnotation = trafficAnnotation;
      _message.params = params;
      _message.receiver = receiver;
      _message.listener = listener;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(36, 1, 0L)),
              new NetworkContextCreateRestrictedUdpSocketResponseParamsForwardToCallback(callback));
    }

    @Override
    public void createTcpServerSocket(
        IpEndPoint localAddr,
        TcpServerSocketOptions options,
        MutableNetworkTrafficAnnotationTag trafficAnnotation,
        InterfaceRequest<TcpServerSocket> socket,
        NetworkContext.CreateTcpServerSocket_Response callback) {
      NetworkContextCreateTcpServerSocketParams _message =
          new NetworkContextCreateTcpServerSocketParams();
      _message.localAddr = localAddr;
      _message.options = options;
      _message.trafficAnnotation = trafficAnnotation;
      _message.socket = socket;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(37, 1, 0L)),
              new NetworkContextCreateTcpServerSocketResponseParamsForwardToCallback(callback));
    }

    @Override
    public void createTcpConnectedSocket(
        IpEndPoint localAddr,
        AddressList remoteAddrList,
        TcpConnectedSocketOptions tcpConnectedSocketOptions,
        MutableNetworkTrafficAnnotationTag trafficAnnotation,
        InterfaceRequest<TcpConnectedSocket> socket,
        SocketObserver observer,
        NetworkContext.CreateTcpConnectedSocket_Response callback) {
      NetworkContextCreateTcpConnectedSocketParams _message =
          new NetworkContextCreateTcpConnectedSocketParams();
      _message.localAddr = localAddr;
      _message.remoteAddrList = remoteAddrList;
      _message.tcpConnectedSocketOptions = tcpConnectedSocketOptions;
      _message.trafficAnnotation = trafficAnnotation;
      _message.socket = socket;
      _message.observer = observer;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(38, 1, 0L)),
              new NetworkContextCreateTcpConnectedSocketResponseParamsForwardToCallback(callback));
    }

    @Override
    public void createTcpBoundSocket(
        IpEndPoint localAddr,
        MutableNetworkTrafficAnnotationTag trafficAnnotation,
        InterfaceRequest<TcpBoundSocket> socket,
        NetworkContext.CreateTcpBoundSocket_Response callback) {
      NetworkContextCreateTcpBoundSocketParams _message =
          new NetworkContextCreateTcpBoundSocketParams();
      _message.localAddr = localAddr;
      _message.trafficAnnotation = trafficAnnotation;
      _message.socket = socket;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(39, 1, 0L)),
              new NetworkContextCreateTcpBoundSocketResponseParamsForwardToCallback(callback));
    }

    @Override
    public void createProxyResolvingSocketFactory(
        InterfaceRequest<ProxyResolvingSocketFactory> factory) {
      NetworkContextCreateProxyResolvingSocketFactoryParams _message =
          new NetworkContextCreateProxyResolvingSocketFactoryParams();
      _message.factory = factory;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(40)));
    }

    @Override
    public void lookUpProxyForUrl(
        Url url,
        NetworkAnonymizationKey networkAnonymizationKey,
        ProxyLookupClient proxyLookupClient) {
      NetworkContextLookUpProxyForUrlParams _message = new NetworkContextLookUpProxyForUrlParams();
      _message.url = url;
      _message.networkAnonymizationKey = networkAnonymizationKey;
      _message.proxyLookupClient = proxyLookupClient;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(41)));
    }

    @Override
    public void forceReloadProxyConfig(NetworkContext.ForceReloadProxyConfig_Response callback) {
      NetworkContextForceReloadProxyConfigParams _message =
          new NetworkContextForceReloadProxyConfigParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(42, 1, 0L)),
              new NetworkContextForceReloadProxyConfigResponseParamsForwardToCallback(callback));
    }

    @Override
    public void clearBadProxiesCache(NetworkContext.ClearBadProxiesCache_Response callback) {
      NetworkContextClearBadProxiesCacheParams _message =
          new NetworkContextClearBadProxiesCacheParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(43, 1, 0L)),
              new NetworkContextClearBadProxiesCacheResponseParamsForwardToCallback(callback));
    }

    @Override
    public void createWebSocket(
        Url url,
        String[] requestedProtocols,
        SiteForCookies siteForCookies,
        boolean hasStorageAccess,
        IsolationInfo isolationInfo,
        HttpHeader[] additionalHeaders,
        int processId,
        Origin origin,
        int options,
        MutableNetworkTrafficAnnotationTag trafficAnnotation,
        WebSocketHandshakeClient handshakeClient,
        UrlLoaderNetworkServiceObserver urlLoaderNetworkObserver,
        WebSocketAuthenticationHandler authHandler,
        TrustedHeaderClient headerClient,
        UnguessableToken throttlingProfileId) {
      NetworkContextCreateWebSocketParams _message = new NetworkContextCreateWebSocketParams();
      _message.url = url;
      _message.requestedProtocols = requestedProtocols;
      _message.siteForCookies = siteForCookies;
      _message.hasStorageAccess = hasStorageAccess;
      _message.isolationInfo = isolationInfo;
      _message.additionalHeaders = additionalHeaders;
      _message.processId = processId;
      _message.origin = origin;
      _message.options = options;
      _message.trafficAnnotation = trafficAnnotation;
      _message.handshakeClient = handshakeClient;
      _message.urlLoaderNetworkObserver = urlLoaderNetworkObserver;
      _message.authHandler = authHandler;
      _message.headerClient = headerClient;
      _message.throttlingProfileId = throttlingProfileId;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(44)));
    }

    @Override
    public void createWebTransport(
        Url url,
        Origin origin,
        NetworkAnonymizationKey networkAnonymizationKey,
        WebTransportCertificateFingerprint[] fingerprints,
        WebTransportHandshakeClient handshakeClient) {
      NetworkContextCreateWebTransportParams _message =
          new NetworkContextCreateWebTransportParams();
      _message.url = url;
      _message.origin = origin;
      _message.networkAnonymizationKey = networkAnonymizationKey;
      _message.fingerprints = fingerprints;
      _message.handshakeClient = handshakeClient;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(45)));
    }

    @Override
    public void createNetLogExporter(InterfaceRequest<NetLogExporter> receiver) {
      NetworkContextCreateNetLogExporterParams _message =
          new NetworkContextCreateNetLogExporterParams();
      _message.receiver = receiver;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(46)));
    }

    @Override
    public void preconnectSockets(
        int numStreams,
        Url url,
        int credentialsMode,
        NetworkAnonymizationKey networkAnonymizationKey) {
      NetworkContextPreconnectSocketsParams _message = new NetworkContextPreconnectSocketsParams();
      _message.numStreams = numStreams;
      _message.url = url;
      _message.credentialsMode = credentialsMode;
      _message.networkAnonymizationKey = networkAnonymizationKey;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(47)));
    }

    @Override
    public void createP2pSocketManager(
        NetworkAnonymizationKey networkAnonymizationKey,
        P2pTrustedSocketManagerClient client,
        InterfaceRequest<P2pTrustedSocketManager> trustedSocketManager,
        InterfaceRequest<P2pSocketManager> socketManager) {
      NetworkContextCreateP2pSocketManagerParams _message =
          new NetworkContextCreateP2pSocketManagerParams();
      _message.networkAnonymizationKey = networkAnonymizationKey;
      _message.client = client;
      _message.trustedSocketManager = trustedSocketManager;
      _message.socketManager = socketManager;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(48)));
    }

    @Override
    public void createMdnsResponder(InterfaceRequest<MdnsResponder> responderReceiver) {
      NetworkContextCreateMdnsResponderParams _message =
          new NetworkContextCreateMdnsResponderParams();
      _message.responderReceiver = responderReceiver;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(49)));
    }

    @Override
    public void resolveHost(
        HostResolverHost host,
        NetworkAnonymizationKey networkAnonymizationKey,
        ResolveHostParameters optionalParameters,
        ResolveHostClient responseClient) {
      NetworkContextResolveHostParams _message = new NetworkContextResolveHostParams();
      _message.host = host;
      _message.networkAnonymizationKey = networkAnonymizationKey;
      _message.optionalParameters = optionalParameters;
      _message.responseClient = responseClient;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(50)));
    }

    @Override
    public void createHostResolver(
        DnsConfigOverrides configOverrides, InterfaceRequest<HostResolver> hostResolver) {
      NetworkContextCreateHostResolverParams _message =
          new NetworkContextCreateHostResolverParams();
      _message.configOverrides = configOverrides;
      _message.hostResolver = hostResolver;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(51)));
    }

    @Override
    public void verifyCertForSignedExchange(
        X509Certificate certificate,
        Url url,
        String ocspResponse,
        String sctList,
        NetworkContext.VerifyCertForSignedExchange_Response callback) {
      NetworkContextVerifyCertForSignedExchangeParams _message =
          new NetworkContextVerifyCertForSignedExchangeParams();
      _message.certificate = certificate;
      _message.url = url;
      _message.ocspResponse = ocspResponse;
      _message.sctList = sctList;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(52, 1, 0L)),
              new NetworkContextVerifyCertForSignedExchangeResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void addHsts(
        String host,
        Time expiry,
        boolean includeSubdomains,
        NetworkContext.AddHsts_Response callback) {
      NetworkContextAddHstsParams _message = new NetworkContextAddHstsParams();
      _message.host = host;
      _message.expiry = expiry;
      _message.includeSubdomains = includeSubdomains;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(53, 1, 0L)),
              new NetworkContextAddHstsResponseParamsForwardToCallback(callback));
    }

    @Override
    public void isHstsActiveForHost(
        String host, NetworkContext.IsHstsActiveForHost_Response callback) {
      NetworkContextIsHstsActiveForHostParams _message =
          new NetworkContextIsHstsActiveForHostParams();
      _message.host = host;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(54, 1, 0L)),
              new NetworkContextIsHstsActiveForHostResponseParamsForwardToCallback(callback));
    }

    @Override
    public void getHstsState(String domain, NetworkContext.GetHstsState_Response callback) {
      NetworkContextGetHstsStateParams _message = new NetworkContextGetHstsStateParams();
      _message.domain = domain;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(55, 1, 0L)),
              new NetworkContextGetHstsStateResponseParamsForwardToCallback(callback));
    }

    @Override
    public void setCorsOriginAccessListsForOrigin(
        Origin sourceOrigin,
        CorsOriginPattern[] allowPatterns,
        CorsOriginPattern[] blockPatterns,
        NetworkContext.SetCorsOriginAccessListsForOrigin_Response callback) {
      NetworkContextSetCorsOriginAccessListsForOriginParams _message =
          new NetworkContextSetCorsOriginAccessListsForOriginParams();
      _message.sourceOrigin = sourceOrigin;
      _message.allowPatterns = allowPatterns;
      _message.blockPatterns = blockPatterns;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(56, 1, 0L)),
              new NetworkContextSetCorsOriginAccessListsForOriginResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void deleteDynamicDataForHost(
        String host, NetworkContext.DeleteDynamicDataForHost_Response callback) {
      NetworkContextDeleteDynamicDataForHostParams _message =
          new NetworkContextDeleteDynamicDataForHostParams();
      _message.host = host;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(57, 1, 0L)),
              new NetworkContextDeleteDynamicDataForHostResponseParamsForwardToCallback(callback));
    }

    @Override
    public void setSplitAuthCacheByNetworkAnonymizationKey(
        boolean splitAuthCacheByNetworkAnonymizationKey) {
      NetworkContextSetSplitAuthCacheByNetworkAnonymizationKeyParams _message =
          new NetworkContextSetSplitAuthCacheByNetworkAnonymizationKeyParams();
      _message.splitAuthCacheByNetworkAnonymizationKey = splitAuthCacheByNetworkAnonymizationKey;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(58)));
    }

    @Override
    public void saveHttpAuthCacheProxyEntries(
        NetworkContext.SaveHttpAuthCacheProxyEntries_Response callback) {
      NetworkContextSaveHttpAuthCacheProxyEntriesParams _message =
          new NetworkContextSaveHttpAuthCacheProxyEntriesParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(59, 1, 0L)),
              new NetworkContextSaveHttpAuthCacheProxyEntriesResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void loadHttpAuthCacheProxyEntries(
        UnguessableToken cacheKey, NetworkContext.LoadHttpAuthCacheProxyEntries_Response callback) {
      NetworkContextLoadHttpAuthCacheProxyEntriesParams _message =
          new NetworkContextLoadHttpAuthCacheProxyEntriesParams();
      _message.cacheKey = cacheKey;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(60, 1, 0L)),
              new NetworkContextLoadHttpAuthCacheProxyEntriesResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void addAuthCacheEntry(
        AuthChallengeInfo challenge,
        NetworkAnonymizationKey networkAnonymizationKey,
        AuthCredentials credentials,
        NetworkContext.AddAuthCacheEntry_Response callback) {
      NetworkContextAddAuthCacheEntryParams _message = new NetworkContextAddAuthCacheEntryParams();
      _message.challenge = challenge;
      _message.networkAnonymizationKey = networkAnonymizationKey;
      _message.credentials = credentials;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(61, 1, 0L)),
              new NetworkContextAddAuthCacheEntryResponseParamsForwardToCallback(callback));
    }

    @Override
    public void setCorsNonWildcardRequestHeadersSupport(boolean value) {
      NetworkContextSetCorsNonWildcardRequestHeadersSupportParams _message =
          new NetworkContextSetCorsNonWildcardRequestHeadersSupportParams();
      _message.value = value;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(62)));
    }

    @Override
    public void lookupServerBasicAuthCredentials(
        Url url,
        NetworkAnonymizationKey networkAnonymizationKey,
        NetworkContext.LookupServerBasicAuthCredentials_Response callback) {
      NetworkContextLookupServerBasicAuthCredentialsParams _message =
          new NetworkContextLookupServerBasicAuthCredentialsParams();
      _message.url = url;
      _message.networkAnonymizationKey = networkAnonymizationKey;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(63, 1, 0L)),
              new NetworkContextLookupServerBasicAuthCredentialsResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void enableStaticKeyPinningForTesting(
        NetworkContext.EnableStaticKeyPinningForTesting_Response callback) {
      NetworkContextEnableStaticKeyPinningForTestingParams _message =
          new NetworkContextEnableStaticKeyPinningForTestingParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(64, 1, 0L)),
              new NetworkContextEnableStaticKeyPinningForTestingResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void verifyCertificateForTesting(
        X509Certificate certificate,
        String hostname,
        String ocspResponse,
        String sctList,
        NetworkContext.VerifyCertificateForTesting_Response callback) {
      NetworkContextVerifyCertificateForTestingParams _message =
          new NetworkContextVerifyCertificateForTestingParams();
      _message.certificate = certificate;
      _message.hostname = hostname;
      _message.ocspResponse = ocspResponse;
      _message.sctList = sctList;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(65, 1, 0L)),
              new NetworkContextVerifyCertificateForTestingResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void addDomainReliabilityContextForTesting(
        Origin origin,
        Url uploadUrl,
        NetworkContext.AddDomainReliabilityContextForTesting_Response callback) {
      NetworkContextAddDomainReliabilityContextForTestingParams _message =
          new NetworkContextAddDomainReliabilityContextForTestingParams();
      _message.origin = origin;
      _message.uploadUrl = uploadUrl;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(66, 1, 0L)),
              new NetworkContextAddDomainReliabilityContextForTestingResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void forceDomainReliabilityUploadsForTesting(
        NetworkContext.ForceDomainReliabilityUploadsForTesting_Response callback) {
      NetworkContextForceDomainReliabilityUploadsForTestingParams _message =
          new NetworkContextForceDomainReliabilityUploadsForTestingParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(67, 1, 0L)),
              new NetworkContextForceDomainReliabilityUploadsForTestingResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void setSctAuditingMode(int mode) {
      NetworkContextSetSctAuditingModeParams _message =
          new NetworkContextSetSctAuditingModeParams();
      _message.mode = mode;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(68)));
    }

    @Override
    public void addReportingApiObserver(ReportingApiObserver observer) {
      NetworkContextAddReportingApiObserverParams _message =
          new NetworkContextAddReportingApiObserverParams();
      _message.observer = observer;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(69)));
    }

    @Override
    public void getSharedDictionaryUsageInfo(
        NetworkContext.GetSharedDictionaryUsageInfo_Response callback) {
      NetworkContextGetSharedDictionaryUsageInfoParams _message =
          new NetworkContextGetSharedDictionaryUsageInfoParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(70, 1, 0L)),
              new NetworkContextGetSharedDictionaryUsageInfoResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void getSharedDictionaryInfo(
        SharedDictionaryIsolationKey isolationKey,
        NetworkContext.GetSharedDictionaryInfo_Response callback) {
      NetworkContextGetSharedDictionaryInfoParams _message =
          new NetworkContextGetSharedDictionaryInfoParams();
      _message.isolationKey = isolationKey;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(71, 1, 0L)),
              new NetworkContextGetSharedDictionaryInfoResponseParamsForwardToCallback(callback));
    }

    @Override
    public void getSharedDictionaryOriginsBetween(
        Time startTime,
        Time endTime,
        NetworkContext.GetSharedDictionaryOriginsBetween_Response callback) {
      NetworkContextGetSharedDictionaryOriginsBetweenParams _message =
          new NetworkContextGetSharedDictionaryOriginsBetweenParams();
      _message.startTime = startTime;
      _message.endTime = endTime;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(72, 1, 0L)),
              new NetworkContextGetSharedDictionaryOriginsBetweenResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void setSharedDictionaryCacheMaxSize(long cacheMaxSize) {
      NetworkContextSetSharedDictionaryCacheMaxSizeParams _message =
          new NetworkContextSetSharedDictionaryCacheMaxSizeParams();
      _message.cacheMaxSize = cacheMaxSize;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(73)));
    }

    @Override
    public void resourceSchedulerClientVisibilityChanged(
        UnguessableToken clientToken, boolean visible) {
      NetworkContextResourceSchedulerClientVisibilityChangedParams _message =
          new NetworkContextResourceSchedulerClientVisibilityChangedParams();
      _message.clientToken = clientToken;
      _message.visible = visible;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(74)));
    }

    @Override
    public void flushCachedClientCertIfNeeded(HostPortPair host, X509Certificate certificate) {
      NetworkContextFlushCachedClientCertIfNeededParams _message =
          new NetworkContextFlushCachedClientCertIfNeededParams();
      _message.host = host;
      _message.certificate = certificate;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(75)));
    }

    @Override
    public void setCookieDeprecationLabel(String label) {
      NetworkContextSetCookieDeprecationLabelParams _message =
          new NetworkContextSetCookieDeprecationLabelParams();
      _message.label = label;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(76)));
    }
  }

  public static final class Stub extends Interface.Stub<NetworkContext> {
    Stub(Core core, NetworkContext impl) {
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
                NetworkContext_Internal.MANAGER, messageWithHeader);
          case 0:
            getImpl()
                .setClient(
                    NetworkContextSetClientParams.deserialize(messageWithHeader.getPayload())
                        .client);
            return true;
          case 1:
            NetworkContextCreateUrlLoaderFactoryParams data =
                NetworkContextCreateUrlLoaderFactoryParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().createUrlLoaderFactory(data.urlLoaderFactory, data.params);
            return true;
          case 2:
            NetworkContextResetUrlLoaderFactoriesParams.deserialize(messageWithHeader.getPayload());
            getImpl().resetUrlLoaderFactories();
            return true;
          case 3:
            NetworkContextGetViaObliviousHttpParams data2 =
                NetworkContextGetViaObliviousHttpParams.deserialize(messageWithHeader.getPayload());
            getImpl().getViaObliviousHttp(data2.request, data2.client);
            return true;
          case 4:
            NetworkContextGetCookieManagerParams data3 =
                NetworkContextGetCookieManagerParams.deserialize(messageWithHeader.getPayload());
            getImpl().getCookieManager(data3.cookieManager);
            return true;
          case 5:
            NetworkContextGetRestrictedCookieManagerParams data4 =
                NetworkContextGetRestrictedCookieManagerParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .getRestrictedCookieManager(
                    data4.restrictedCookieManager,
                    data4.role,
                    data4.origin,
                    data4.isolationInfo,
                    data4.cookieSettingOverrides,
                    data4.cookieObserver);
            return true;
          case 6:
            NetworkContextGetTrustTokenQueryAnswererParams data5 =
                NetworkContextGetTrustTokenQueryAnswererParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .getTrustTokenQueryAnswerer(data5.trustTokenQueryAnswerer, data5.topFrameOrigin);
            return true;
          case 11:
            NetworkContextSetBlockTrustTokensParams data6 =
                NetworkContextSetBlockTrustTokensParams.deserialize(messageWithHeader.getPayload());
            getImpl().setBlockTrustTokens(data6.block);
            return true;
          case 15:
            NetworkContextNotifyExternalCacheHitParams data7 =
                NetworkContextNotifyExternalCacheHitParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .notifyExternalCacheHit(
                    data7.url,
                    data7.httpMethod,
                    data7.key,
                    data7.isSubframeDocumentResource,
                    data7.includeCredentials);
            return true;
          case 25:
            NetworkContextSetDocumentReportingEndpointsParams data8 =
                NetworkContextSetDocumentReportingEndpointsParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .setDocumentReportingEndpoints(
                    data8.reportingSource, data8.origin, data8.isolationInfo, data8.endpoints);
            return true;
          case 26:
            NetworkContextSendReportsAndRemoveSourceParams data9 =
                NetworkContextSendReportsAndRemoveSourceParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().sendReportsAndRemoveSource(data9.reportingSource);
            return true;
          case 27:
            NetworkContextQueueReportParams data10 =
                NetworkContextQueueReportParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .queueReport(
                    data10.type,
                    data10.group,
                    data10.url,
                    data10.reportingSource,
                    data10.networkAnonymizationKey,
                    data10.userAgent,
                    data10.body);
            return true;
          case 28:
            NetworkContextQueueSignedExchangeReportParams data11 =
                NetworkContextQueueSignedExchangeReportParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().queueSignedExchangeReport(data11.report, data11.networkAnonymizationKey);
            return true;
          case 31:
            NetworkContextSetNetworkConditionsParams data12 =
                NetworkContextSetNetworkConditionsParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().setNetworkConditions(data12.throttlingProfileId, data12.conditions);
            return true;
          case 32:
            NetworkContextSetAcceptLanguageParams data13 =
                NetworkContextSetAcceptLanguageParams.deserialize(messageWithHeader.getPayload());
            getImpl().setAcceptLanguage(data13.newAcceptLanguage);
            return true;
          case 33:
            NetworkContextSetEnableReferrersParams data14 =
                NetworkContextSetEnableReferrersParams.deserialize(messageWithHeader.getPayload());
            getImpl().setEnableReferrers(data14.enableReferrers);
            return true;
          case 34:
            NetworkContextSetCtPolicyParams data15 =
                NetworkContextSetCtPolicyParams.deserialize(messageWithHeader.getPayload());
            getImpl().setCtPolicy(data15.ctPolicy);
            return true;
          case 35:
            NetworkContextCreateUdpSocketParams data16 =
                NetworkContextCreateUdpSocketParams.deserialize(messageWithHeader.getPayload());
            getImpl().createUdpSocket(data16.receiver, data16.listener);
            return true;
          case 40:
            NetworkContextCreateProxyResolvingSocketFactoryParams data17 =
                NetworkContextCreateProxyResolvingSocketFactoryParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().createProxyResolvingSocketFactory(data17.factory);
            return true;
          case 41:
            NetworkContextLookUpProxyForUrlParams data18 =
                NetworkContextLookUpProxyForUrlParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .lookUpProxyForUrl(
                    data18.url, data18.networkAnonymizationKey, data18.proxyLookupClient);
            return true;
          case 44:
            NetworkContextCreateWebSocketParams data19 =
                NetworkContextCreateWebSocketParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .createWebSocket(
                    data19.url,
                    data19.requestedProtocols,
                    data19.siteForCookies,
                    data19.hasStorageAccess,
                    data19.isolationInfo,
                    data19.additionalHeaders,
                    data19.processId,
                    data19.origin,
                    data19.options,
                    data19.trafficAnnotation,
                    data19.handshakeClient,
                    data19.urlLoaderNetworkObserver,
                    data19.authHandler,
                    data19.headerClient,
                    data19.throttlingProfileId);
            return true;
          case 45:
            NetworkContextCreateWebTransportParams data20 =
                NetworkContextCreateWebTransportParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .createWebTransport(
                    data20.url,
                    data20.origin,
                    data20.networkAnonymizationKey,
                    data20.fingerprints,
                    data20.handshakeClient);
            return true;
          case 46:
            NetworkContextCreateNetLogExporterParams data21 =
                NetworkContextCreateNetLogExporterParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().createNetLogExporter(data21.receiver);
            return true;
          case 47:
            NetworkContextPreconnectSocketsParams data22 =
                NetworkContextPreconnectSocketsParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .preconnectSockets(
                    data22.numStreams,
                    data22.url,
                    data22.credentialsMode,
                    data22.networkAnonymizationKey);
            return true;
          case 48:
            NetworkContextCreateP2pSocketManagerParams data23 =
                NetworkContextCreateP2pSocketManagerParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .createP2pSocketManager(
                    data23.networkAnonymizationKey,
                    data23.client,
                    data23.trustedSocketManager,
                    data23.socketManager);
            return true;
          case 49:
            NetworkContextCreateMdnsResponderParams data24 =
                NetworkContextCreateMdnsResponderParams.deserialize(messageWithHeader.getPayload());
            getImpl().createMdnsResponder(data24.responderReceiver);
            return true;
          case 50:
            NetworkContextResolveHostParams data25 =
                NetworkContextResolveHostParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .resolveHost(
                    data25.host,
                    data25.networkAnonymizationKey,
                    data25.optionalParameters,
                    data25.responseClient);
            return true;
          case 51:
            NetworkContextCreateHostResolverParams data26 =
                NetworkContextCreateHostResolverParams.deserialize(messageWithHeader.getPayload());
            getImpl().createHostResolver(data26.configOverrides, data26.hostResolver);
            return true;
          case 58:
            NetworkContextSetSplitAuthCacheByNetworkAnonymizationKeyParams data27 =
                NetworkContextSetSplitAuthCacheByNetworkAnonymizationKeyParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .setSplitAuthCacheByNetworkAnonymizationKey(
                    data27.splitAuthCacheByNetworkAnonymizationKey);
            return true;
          case 62:
            NetworkContextSetCorsNonWildcardRequestHeadersSupportParams data28 =
                NetworkContextSetCorsNonWildcardRequestHeadersSupportParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().setCorsNonWildcardRequestHeadersSupport(data28.value);
            return true;
          case 68:
            NetworkContextSetSctAuditingModeParams data29 =
                NetworkContextSetSctAuditingModeParams.deserialize(messageWithHeader.getPayload());
            getImpl().setSctAuditingMode(data29.mode);
            return true;
          case 69:
            NetworkContextAddReportingApiObserverParams data30 =
                NetworkContextAddReportingApiObserverParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().addReportingApiObserver(data30.observer);
            return true;
          case 73:
            NetworkContextSetSharedDictionaryCacheMaxSizeParams data31 =
                NetworkContextSetSharedDictionaryCacheMaxSizeParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().setSharedDictionaryCacheMaxSize(data31.cacheMaxSize);
            return true;
          case 74:
            NetworkContextResourceSchedulerClientVisibilityChangedParams data32 =
                NetworkContextResourceSchedulerClientVisibilityChangedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().resourceSchedulerClientVisibilityChanged(data32.clientToken, data32.visible);
            return true;
          case 75:
            NetworkContextFlushCachedClientCertIfNeededParams data33 =
                NetworkContextFlushCachedClientCertIfNeededParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().flushCachedClientCertIfNeeded(data33.host, data33.certificate);
            return true;
          case 76:
            NetworkContextSetCookieDeprecationLabelParams data34 =
                NetworkContextSetCookieDeprecationLabelParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().setCookieDeprecationLabel(data34.label);
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
                getCore(), NetworkContext_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
          case 1:
          case 2:
          case 3:
          case 4:
          case 5:
          case 6:
          case 11:
          case 15:
          case 25:
          case 26:
          case 27:
          case 28:
          case 31:
          case 32:
          case 33:
          case 34:
          case 35:
          case 40:
          case 41:
          case 44:
          case 45:
          case 46:
          case 47:
          case 48:
          case 49:
          case 50:
          case 51:
          case 58:
          case 62:
          case 68:
          case 69:
          default:
            return false;
          case 7:
            NetworkContextClearTrustTokenDataParams data =
                NetworkContextClearTrustTokenDataParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .clearTrustTokenData(
                    data.filter,
                    new NetworkContextClearTrustTokenDataResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 8:
            NetworkContextClearTrustTokenSessionOnlyDataParams.deserialize(
                messageWithHeader.getPayload());
            getImpl()
                .clearTrustTokenSessionOnlyData(
                    new NetworkContextClearTrustTokenSessionOnlyDataResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 9:
            NetworkContextGetStoredTrustTokenCountsParams.deserialize(
                messageWithHeader.getPayload());
            getImpl()
                .getStoredTrustTokenCounts(
                    new NetworkContextGetStoredTrustTokenCountsResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 10:
            NetworkContextDeleteStoredTrustTokensParams data2 =
                NetworkContextDeleteStoredTrustTokensParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .deleteStoredTrustTokens(
                    data2.issuer,
                    new NetworkContextDeleteStoredTrustTokensResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 12:
            NetworkContextClearNetworkingHistoryBetweenParams data3 =
                NetworkContextClearNetworkingHistoryBetweenParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .clearNetworkingHistoryBetween(
                    data3.startTime,
                    data3.endTime,
                    new NetworkContextClearNetworkingHistoryBetweenResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 13:
            NetworkContextClearHttpCacheParams data4 =
                NetworkContextClearHttpCacheParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .clearHttpCache(
                    data4.startTime,
                    data4.endTime,
                    data4.filter,
                    new NetworkContextClearHttpCacheResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 14:
            NetworkContextComputeHttpCacheSizeParams data5 =
                NetworkContextComputeHttpCacheSizeParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .computeHttpCacheSize(
                    data5.startTime,
                    data5.endTime,
                    new NetworkContextComputeHttpCacheSizeResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 16:
            NetworkContextClearHostCacheParams data6 =
                NetworkContextClearHostCacheParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .clearHostCache(
                    data6.filter,
                    new NetworkContextClearHostCacheResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 17:
            NetworkContextClearHttpAuthCacheParams data7 =
                NetworkContextClearHttpAuthCacheParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .clearHttpAuthCache(
                    data7.startTime,
                    data7.endTime,
                    data7.filter,
                    new NetworkContextClearHttpAuthCacheResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 18:
            NetworkContextClearCorsPreflightCacheParams data8 =
                NetworkContextClearCorsPreflightCacheParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .clearCorsPreflightCache(
                    data8.filter,
                    new NetworkContextClearCorsPreflightCacheResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 19:
            NetworkContextClearReportingCacheReportsParams data9 =
                NetworkContextClearReportingCacheReportsParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .clearReportingCacheReports(
                    data9.filter,
                    new NetworkContextClearReportingCacheReportsResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 20:
            NetworkContextClearReportingCacheClientsParams data10 =
                NetworkContextClearReportingCacheClientsParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .clearReportingCacheClients(
                    data10.filter,
                    new NetworkContextClearReportingCacheClientsResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 21:
            NetworkContextClearNetworkErrorLoggingParams data11 =
                NetworkContextClearNetworkErrorLoggingParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .clearNetworkErrorLogging(
                    data11.filter,
                    new NetworkContextClearNetworkErrorLoggingResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 22:
            NetworkContextClearDomainReliabilityParams data12 =
                NetworkContextClearDomainReliabilityParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .clearDomainReliability(
                    data12.filter,
                    data12.mode,
                    new NetworkContextClearDomainReliabilityResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 23:
            NetworkContextClearSharedDictionaryCacheParams data13 =
                NetworkContextClearSharedDictionaryCacheParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .clearSharedDictionaryCache(
                    data13.startTime,
                    data13.endTime,
                    data13.filter,
                    new NetworkContextClearSharedDictionaryCacheResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 24:
            NetworkContextClearSharedDictionaryCacheForIsolationKeyParams data14 =
                NetworkContextClearSharedDictionaryCacheForIsolationKeyParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .clearSharedDictionaryCacheForIsolationKey(
                    data14.isolationKey,
                    new NetworkContextClearSharedDictionaryCacheForIsolationKeyResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 29:
            NetworkContextCloseAllConnectionsParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .closeAllConnections(
                    new NetworkContextCloseAllConnectionsResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 30:
            NetworkContextCloseIdleConnectionsParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .closeIdleConnections(
                    new NetworkContextCloseIdleConnectionsResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 36:
            NetworkContextCreateRestrictedUdpSocketParams data15 =
                NetworkContextCreateRestrictedUdpSocketParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .createRestrictedUdpSocket(
                    data15.addr,
                    data15.mode,
                    data15.trafficAnnotation,
                    data15.params,
                    data15.receiver,
                    data15.listener,
                    new NetworkContextCreateRestrictedUdpSocketResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 37:
            NetworkContextCreateTcpServerSocketParams data16 =
                NetworkContextCreateTcpServerSocketParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .createTcpServerSocket(
                    data16.localAddr,
                    data16.options,
                    data16.trafficAnnotation,
                    data16.socket,
                    new NetworkContextCreateTcpServerSocketResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 38:
            NetworkContextCreateTcpConnectedSocketParams data17 =
                NetworkContextCreateTcpConnectedSocketParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .createTcpConnectedSocket(
                    data17.localAddr,
                    data17.remoteAddrList,
                    data17.tcpConnectedSocketOptions,
                    data17.trafficAnnotation,
                    data17.socket,
                    data17.observer,
                    new NetworkContextCreateTcpConnectedSocketResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 39:
            NetworkContextCreateTcpBoundSocketParams data18 =
                NetworkContextCreateTcpBoundSocketParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .createTcpBoundSocket(
                    data18.localAddr,
                    data18.trafficAnnotation,
                    data18.socket,
                    new NetworkContextCreateTcpBoundSocketResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 42:
            NetworkContextForceReloadProxyConfigParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .forceReloadProxyConfig(
                    new NetworkContextForceReloadProxyConfigResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 43:
            NetworkContextClearBadProxiesCacheParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .clearBadProxiesCache(
                    new NetworkContextClearBadProxiesCacheResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 52:
            NetworkContextVerifyCertForSignedExchangeParams data19 =
                NetworkContextVerifyCertForSignedExchangeParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .verifyCertForSignedExchange(
                    data19.certificate,
                    data19.url,
                    data19.ocspResponse,
                    data19.sctList,
                    new NetworkContextVerifyCertForSignedExchangeResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 53:
            NetworkContextAddHstsParams data20 =
                NetworkContextAddHstsParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .addHsts(
                    data20.host,
                    data20.expiry,
                    data20.includeSubdomains,
                    new NetworkContextAddHstsResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 54:
            NetworkContextIsHstsActiveForHostParams data21 =
                NetworkContextIsHstsActiveForHostParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .isHstsActiveForHost(
                    data21.host,
                    new NetworkContextIsHstsActiveForHostResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 55:
            NetworkContextGetHstsStateParams data22 =
                NetworkContextGetHstsStateParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .getHstsState(
                    data22.domain,
                    new NetworkContextGetHstsStateResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 56:
            NetworkContextSetCorsOriginAccessListsForOriginParams data23 =
                NetworkContextSetCorsOriginAccessListsForOriginParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .setCorsOriginAccessListsForOrigin(
                    data23.sourceOrigin,
                    data23.allowPatterns,
                    data23.blockPatterns,
                    new NetworkContextSetCorsOriginAccessListsForOriginResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 57:
            NetworkContextDeleteDynamicDataForHostParams data24 =
                NetworkContextDeleteDynamicDataForHostParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .deleteDynamicDataForHost(
                    data24.host,
                    new NetworkContextDeleteDynamicDataForHostResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 59:
            NetworkContextSaveHttpAuthCacheProxyEntriesParams.deserialize(
                messageWithHeader.getPayload());
            getImpl()
                .saveHttpAuthCacheProxyEntries(
                    new NetworkContextSaveHttpAuthCacheProxyEntriesResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 60:
            NetworkContextLoadHttpAuthCacheProxyEntriesParams data25 =
                NetworkContextLoadHttpAuthCacheProxyEntriesParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .loadHttpAuthCacheProxyEntries(
                    data25.cacheKey,
                    new NetworkContextLoadHttpAuthCacheProxyEntriesResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 61:
            NetworkContextAddAuthCacheEntryParams data26 =
                NetworkContextAddAuthCacheEntryParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .addAuthCacheEntry(
                    data26.challenge,
                    data26.networkAnonymizationKey,
                    data26.credentials,
                    new NetworkContextAddAuthCacheEntryResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 63:
            NetworkContextLookupServerBasicAuthCredentialsParams data27 =
                NetworkContextLookupServerBasicAuthCredentialsParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .lookupServerBasicAuthCredentials(
                    data27.url,
                    data27.networkAnonymizationKey,
                    new NetworkContextLookupServerBasicAuthCredentialsResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 64:
            NetworkContextEnableStaticKeyPinningForTestingParams.deserialize(
                messageWithHeader.getPayload());
            getImpl()
                .enableStaticKeyPinningForTesting(
                    new NetworkContextEnableStaticKeyPinningForTestingResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 65:
            NetworkContextVerifyCertificateForTestingParams data28 =
                NetworkContextVerifyCertificateForTestingParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .verifyCertificateForTesting(
                    data28.certificate,
                    data28.hostname,
                    data28.ocspResponse,
                    data28.sctList,
                    new NetworkContextVerifyCertificateForTestingResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 66:
            NetworkContextAddDomainReliabilityContextForTestingParams data29 =
                NetworkContextAddDomainReliabilityContextForTestingParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .addDomainReliabilityContextForTesting(
                    data29.origin,
                    data29.uploadUrl,
                    new NetworkContextAddDomainReliabilityContextForTestingResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 67:
            NetworkContextForceDomainReliabilityUploadsForTestingParams.deserialize(
                messageWithHeader.getPayload());
            getImpl()
                .forceDomainReliabilityUploadsForTesting(
                    new NetworkContextForceDomainReliabilityUploadsForTestingResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 70:
            NetworkContextGetSharedDictionaryUsageInfoParams.deserialize(
                messageWithHeader.getPayload());
            getImpl()
                .getSharedDictionaryUsageInfo(
                    new NetworkContextGetSharedDictionaryUsageInfoResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 71:
            NetworkContextGetSharedDictionaryInfoParams data30 =
                NetworkContextGetSharedDictionaryInfoParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .getSharedDictionaryInfo(
                    data30.isolationKey,
                    new NetworkContextGetSharedDictionaryInfoResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 72:
            NetworkContextGetSharedDictionaryOriginsBetweenParams data31 =
                NetworkContextGetSharedDictionaryOriginsBetweenParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .getSharedDictionaryOriginsBetween(
                    data31.startTime,
                    data31.endTime,
                    new NetworkContextGetSharedDictionaryOriginsBetweenResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class NetworkContextSetClientParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public NetworkContextClient client;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextSetClientParams(int version) {
      super(16, version);
    }

    public NetworkContextSetClientParams() {
      this(0);
    }

    public static NetworkContextSetClientParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextSetClientParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextSetClientParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextSetClientParams result = new NetworkContextSetClientParams(elementsOrVersion);
        result.client =
            (NetworkContextClient)
                decoder0.readServiceInterface(8, false, NetworkContextClient.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.client, 8, false, NetworkContextClient.MANAGER);
    }
  }

  static final class NetworkContextCreateUrlLoaderFactoryParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public UrlLoaderFactoryParams params;
    public InterfaceRequest<UrlLoaderFactory> urlLoaderFactory;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextCreateUrlLoaderFactoryParams(int version) {
      super(24, version);
    }

    public NetworkContextCreateUrlLoaderFactoryParams() {
      this(0);
    }

    public static NetworkContextCreateUrlLoaderFactoryParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextCreateUrlLoaderFactoryParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextCreateUrlLoaderFactoryParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextCreateUrlLoaderFactoryParams result =
            new NetworkContextCreateUrlLoaderFactoryParams(elementsOrVersion);
        result.urlLoaderFactory = decoder0.readInterfaceRequest(8, false);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.params = UrlLoaderFactoryParams.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.urlLoaderFactory, 8, false);
      encoder0.encode((Struct) this.params, 16, false);
    }
  }

  static final class NetworkContextResetUrlLoaderFactoriesParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextResetUrlLoaderFactoriesParams(int version) {
      super(8, version);
    }

    public NetworkContextResetUrlLoaderFactoriesParams() {
      this(0);
    }

    public static NetworkContextResetUrlLoaderFactoriesParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextResetUrlLoaderFactoriesParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextResetUrlLoaderFactoriesParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextResetUrlLoaderFactoriesParams result =
            new NetworkContextResetUrlLoaderFactoriesParams(elementsOrVersion);
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

  static final class NetworkContextGetViaObliviousHttpParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public ObliviousHttpClient client;
    public ObliviousHttpRequest request;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextGetViaObliviousHttpParams(int version) {
      super(24, version);
    }

    public NetworkContextGetViaObliviousHttpParams() {
      this(0);
    }

    public static NetworkContextGetViaObliviousHttpParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextGetViaObliviousHttpParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextGetViaObliviousHttpParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextGetViaObliviousHttpParams result =
            new NetworkContextGetViaObliviousHttpParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.request = ObliviousHttpRequest.decode(decoder1);
        result.client =
            (ObliviousHttpClient)
                decoder0.readServiceInterface(16, false, ObliviousHttpClient.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.request, 8, false);
      encoder0.encode(this.client, 16, false, ObliviousHttpClient.MANAGER);
    }
  }

  static final class NetworkContextGetCookieManagerParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<CookieManager> cookieManager;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextGetCookieManagerParams(int version) {
      super(16, version);
    }

    public NetworkContextGetCookieManagerParams() {
      this(0);
    }

    public static NetworkContextGetCookieManagerParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextGetCookieManagerParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextGetCookieManagerParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextGetCookieManagerParams result =
            new NetworkContextGetCookieManagerParams(elementsOrVersion);
        result.cookieManager = decoder0.readInterfaceRequest(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.cookieManager, 8, false);
    }
  }

  static final class NetworkContextGetRestrictedCookieManagerParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 48;
    private static final DataHeader[] VERSION_ARRAY;
    public CookieAccessObserver cookieObserver;
    public CookieSettingOverrides cookieSettingOverrides;
    public IsolationInfo isolationInfo;
    public Origin origin;
    public InterfaceRequest<RestrictedCookieManager> restrictedCookieManager;
    public int role;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(48, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextGetRestrictedCookieManagerParams(int version) {
      super(48, version);
    }

    public NetworkContextGetRestrictedCookieManagerParams() {
      this(0);
    }

    public static NetworkContextGetRestrictedCookieManagerParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextGetRestrictedCookieManagerParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextGetRestrictedCookieManagerParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextGetRestrictedCookieManagerParams result =
            new NetworkContextGetRestrictedCookieManagerParams(elementsOrVersion);
        result.restrictedCookieManager = decoder0.readInterfaceRequest(8, false);
        int readInt = decoder0.readInt(12);
        result.role = readInt;
        RestrictedCookieManagerRole.validate(readInt);
        result.role = RestrictedCookieManagerRole.toKnownValue(result.role);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.origin = Origin.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(24, false);
        result.isolationInfo = IsolationInfo.decode(decoder12);
        Decoder decoder13 = decoder0.readPointer(32, false);
        result.cookieSettingOverrides = CookieSettingOverrides.decode(decoder13);
        result.cookieObserver =
            (CookieAccessObserver)
                decoder0.readServiceInterface(40, true, CookieAccessObserver.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.restrictedCookieManager, 8, false);
      encoder0.encode(this.role, 12);
      encoder0.encode((Struct) this.origin, 16, false);
      encoder0.encode((Struct) this.isolationInfo, 24, false);
      encoder0.encode((Struct) this.cookieSettingOverrides, 32, false);
      encoder0.encode(this.cookieObserver, 40, true, CookieAccessObserver.MANAGER);
    }
  }

  static final class NetworkContextGetTrustTokenQueryAnswererParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public Origin topFrameOrigin;
    public InterfaceRequest<TrustTokenQueryAnswerer> trustTokenQueryAnswerer;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextGetTrustTokenQueryAnswererParams(int version) {
      super(24, version);
    }

    public NetworkContextGetTrustTokenQueryAnswererParams() {
      this(0);
    }

    public static NetworkContextGetTrustTokenQueryAnswererParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextGetTrustTokenQueryAnswererParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextGetTrustTokenQueryAnswererParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextGetTrustTokenQueryAnswererParams result =
            new NetworkContextGetTrustTokenQueryAnswererParams(elementsOrVersion);
        result.trustTokenQueryAnswerer = decoder0.readInterfaceRequest(8, false);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.topFrameOrigin = Origin.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.trustTokenQueryAnswerer, 8, false);
      encoder0.encode((Struct) this.topFrameOrigin, 16, false);
    }
  }

  static final class NetworkContextClearTrustTokenDataParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public ClearDataFilter filter;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextClearTrustTokenDataParams(int version) {
      super(16, version);
    }

    public NetworkContextClearTrustTokenDataParams() {
      this(0);
    }

    public static NetworkContextClearTrustTokenDataParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextClearTrustTokenDataParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextClearTrustTokenDataParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextClearTrustTokenDataParams result =
            new NetworkContextClearTrustTokenDataParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.filter = ClearDataFilter.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.filter, 8, true);
    }
  }

  static final class NetworkContextClearTrustTokenDataResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextClearTrustTokenDataResponseParams(int version) {
      super(8, version);
    }

    public NetworkContextClearTrustTokenDataResponseParams() {
      this(0);
    }

    public static NetworkContextClearTrustTokenDataResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextClearTrustTokenDataResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextClearTrustTokenDataResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextClearTrustTokenDataResponseParams result =
            new NetworkContextClearTrustTokenDataResponseParams(elementsOrVersion);
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

  static class NetworkContextClearTrustTokenDataResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NetworkContext.ClearTrustTokenData_Response mCallback;

    NetworkContextClearTrustTokenDataResponseParamsForwardToCallback(
        NetworkContext.ClearTrustTokenData_Response callback) {
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

  static class NetworkContextClearTrustTokenDataResponseParamsProxyToResponder
      implements NetworkContext.ClearTrustTokenData_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkContextClearTrustTokenDataResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      NetworkContextClearTrustTokenDataResponseParams _response =
          new NetworkContextClearTrustTokenDataResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(7, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkContextClearTrustTokenSessionOnlyDataParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextClearTrustTokenSessionOnlyDataParams(int version) {
      super(8, version);
    }

    public NetworkContextClearTrustTokenSessionOnlyDataParams() {
      this(0);
    }

    public static NetworkContextClearTrustTokenSessionOnlyDataParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextClearTrustTokenSessionOnlyDataParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextClearTrustTokenSessionOnlyDataParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextClearTrustTokenSessionOnlyDataParams result =
            new NetworkContextClearTrustTokenSessionOnlyDataParams(elementsOrVersion);
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

  static final class NetworkContextClearTrustTokenSessionOnlyDataResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean anyDataDeleted;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextClearTrustTokenSessionOnlyDataResponseParams(int version) {
      super(16, version);
    }

    public NetworkContextClearTrustTokenSessionOnlyDataResponseParams() {
      this(0);
    }

    public static NetworkContextClearTrustTokenSessionOnlyDataResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextClearTrustTokenSessionOnlyDataResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextClearTrustTokenSessionOnlyDataResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextClearTrustTokenSessionOnlyDataResponseParams result =
            new NetworkContextClearTrustTokenSessionOnlyDataResponseParams(elementsOrVersion);
        result.anyDataDeleted = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.anyDataDeleted, 8, 0);
    }
  }

  static class NetworkContextClearTrustTokenSessionOnlyDataResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NetworkContext.ClearTrustTokenSessionOnlyData_Response mCallback;

    NetworkContextClearTrustTokenSessionOnlyDataResponseParamsForwardToCallback(
        NetworkContext.ClearTrustTokenSessionOnlyData_Response callback) {
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
        NetworkContextClearTrustTokenSessionOnlyDataResponseParams response =
            NetworkContextClearTrustTokenSessionOnlyDataResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.anyDataDeleted);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NetworkContextClearTrustTokenSessionOnlyDataResponseParamsProxyToResponder
      implements NetworkContext.ClearTrustTokenSessionOnlyData_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkContextClearTrustTokenSessionOnlyDataResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean anyDataDeleted) {
      NetworkContextClearTrustTokenSessionOnlyDataResponseParams _response =
          new NetworkContextClearTrustTokenSessionOnlyDataResponseParams();
      _response.anyDataDeleted = anyDataDeleted;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(8, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkContextGetStoredTrustTokenCountsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextGetStoredTrustTokenCountsParams(int version) {
      super(8, version);
    }

    public NetworkContextGetStoredTrustTokenCountsParams() {
      this(0);
    }

    public static NetworkContextGetStoredTrustTokenCountsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextGetStoredTrustTokenCountsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextGetStoredTrustTokenCountsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextGetStoredTrustTokenCountsParams result =
            new NetworkContextGetStoredTrustTokenCountsParams(elementsOrVersion);
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

  static final class NetworkContextGetStoredTrustTokenCountsResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public StoredTrustTokensForIssuer[] tokens;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextGetStoredTrustTokenCountsResponseParams(int version) {
      super(16, version);
    }

    public NetworkContextGetStoredTrustTokenCountsResponseParams() {
      this(0);
    }

    public static NetworkContextGetStoredTrustTokenCountsResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextGetStoredTrustTokenCountsResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextGetStoredTrustTokenCountsResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextGetStoredTrustTokenCountsResponseParams result =
            new NetworkContextGetStoredTrustTokenCountsResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.tokens = new StoredTrustTokensForIssuer[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.tokens[i1] = StoredTrustTokensForIssuer.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      StoredTrustTokensForIssuer[] storedTrustTokensForIssuerArr = this.tokens;
      if (storedTrustTokensForIssuerArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(storedTrustTokensForIssuerArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        StoredTrustTokensForIssuer[] storedTrustTokensForIssuerArr2 = this.tokens;
        if (i0 < storedTrustTokensForIssuerArr2.length) {
          encoder1.encode((Struct) storedTrustTokensForIssuerArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static class NetworkContextGetStoredTrustTokenCountsResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NetworkContext.GetStoredTrustTokenCounts_Response mCallback;

    NetworkContextGetStoredTrustTokenCountsResponseParamsForwardToCallback(
        NetworkContext.GetStoredTrustTokenCounts_Response callback) {
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
        NetworkContextGetStoredTrustTokenCountsResponseParams response =
            NetworkContextGetStoredTrustTokenCountsResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.tokens);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NetworkContextGetStoredTrustTokenCountsResponseParamsProxyToResponder
      implements NetworkContext.GetStoredTrustTokenCounts_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkContextGetStoredTrustTokenCountsResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(StoredTrustTokensForIssuer[] tokens) {
      NetworkContextGetStoredTrustTokenCountsResponseParams _response =
          new NetworkContextGetStoredTrustTokenCountsResponseParams();
      _response.tokens = tokens;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(9, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkContextDeleteStoredTrustTokensParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Origin issuer;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextDeleteStoredTrustTokensParams(int version) {
      super(16, version);
    }

    public NetworkContextDeleteStoredTrustTokensParams() {
      this(0);
    }

    public static NetworkContextDeleteStoredTrustTokensParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextDeleteStoredTrustTokensParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextDeleteStoredTrustTokensParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextDeleteStoredTrustTokensParams result =
            new NetworkContextDeleteStoredTrustTokensParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.issuer = Origin.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.issuer, 8, false);
    }
  }

  static final class NetworkContextDeleteStoredTrustTokensResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int status;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextDeleteStoredTrustTokensResponseParams(int version) {
      super(16, version);
    }

    public NetworkContextDeleteStoredTrustTokensResponseParams() {
      this(0);
    }

    public static NetworkContextDeleteStoredTrustTokensResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextDeleteStoredTrustTokensResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextDeleteStoredTrustTokensResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextDeleteStoredTrustTokensResponseParams result =
            new NetworkContextDeleteStoredTrustTokensResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.status = readInt;
        DeleteStoredTrustTokensStatus.validate(readInt);
        result.status = DeleteStoredTrustTokensStatus.toKnownValue(result.status);
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

  static class NetworkContextDeleteStoredTrustTokensResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NetworkContext.DeleteStoredTrustTokens_Response mCallback;

    NetworkContextDeleteStoredTrustTokensResponseParamsForwardToCallback(
        NetworkContext.DeleteStoredTrustTokens_Response callback) {
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
        NetworkContextDeleteStoredTrustTokensResponseParams response =
            NetworkContextDeleteStoredTrustTokensResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.status);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NetworkContextDeleteStoredTrustTokensResponseParamsProxyToResponder
      implements NetworkContext.DeleteStoredTrustTokens_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkContextDeleteStoredTrustTokensResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int status) {
      NetworkContextDeleteStoredTrustTokensResponseParams _response =
          new NetworkContextDeleteStoredTrustTokensResponseParams();
      _response.status = status;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(10, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkContextSetBlockTrustTokensParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean block;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextSetBlockTrustTokensParams(int version) {
      super(16, version);
    }

    public NetworkContextSetBlockTrustTokensParams() {
      this(0);
    }

    public static NetworkContextSetBlockTrustTokensParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextSetBlockTrustTokensParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextSetBlockTrustTokensParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextSetBlockTrustTokensParams result =
            new NetworkContextSetBlockTrustTokensParams(elementsOrVersion);
        result.block = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.block, 8, 0);
    }
  }

  static final class NetworkContextClearNetworkingHistoryBetweenParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public Time endTime;
    public Time startTime;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextClearNetworkingHistoryBetweenParams(int version) {
      super(24, version);
    }

    public NetworkContextClearNetworkingHistoryBetweenParams() {
      this(0);
    }

    public static NetworkContextClearNetworkingHistoryBetweenParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextClearNetworkingHistoryBetweenParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextClearNetworkingHistoryBetweenParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextClearNetworkingHistoryBetweenParams result =
            new NetworkContextClearNetworkingHistoryBetweenParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.startTime = Time.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.endTime = Time.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.startTime, 8, false);
      encoder0.encode((Struct) this.endTime, 16, false);
    }
  }

  static final class NetworkContextClearNetworkingHistoryBetweenResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextClearNetworkingHistoryBetweenResponseParams(int version) {
      super(8, version);
    }

    public NetworkContextClearNetworkingHistoryBetweenResponseParams() {
      this(0);
    }

    public static NetworkContextClearNetworkingHistoryBetweenResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextClearNetworkingHistoryBetweenResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextClearNetworkingHistoryBetweenResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextClearNetworkingHistoryBetweenResponseParams result =
            new NetworkContextClearNetworkingHistoryBetweenResponseParams(elementsOrVersion);
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

  static class NetworkContextClearNetworkingHistoryBetweenResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NetworkContext.ClearNetworkingHistoryBetween_Response mCallback;

    NetworkContextClearNetworkingHistoryBetweenResponseParamsForwardToCallback(
        NetworkContext.ClearNetworkingHistoryBetween_Response callback) {
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

  static class NetworkContextClearNetworkingHistoryBetweenResponseParamsProxyToResponder
      implements NetworkContext.ClearNetworkingHistoryBetween_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkContextClearNetworkingHistoryBetweenResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      NetworkContextClearNetworkingHistoryBetweenResponseParams _response =
          new NetworkContextClearNetworkingHistoryBetweenResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(12, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkContextClearHttpCacheParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public Time endTime;
    public ClearDataFilter filter;
    public Time startTime;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextClearHttpCacheParams(int version) {
      super(32, version);
    }

    public NetworkContextClearHttpCacheParams() {
      this(0);
    }

    public static NetworkContextClearHttpCacheParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextClearHttpCacheParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextClearHttpCacheParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextClearHttpCacheParams result =
            new NetworkContextClearHttpCacheParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.startTime = Time.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.endTime = Time.decode(decoder12);
        Decoder decoder13 = decoder0.readPointer(24, true);
        result.filter = ClearDataFilter.decode(decoder13);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.startTime, 8, false);
      encoder0.encode((Struct) this.endTime, 16, false);
      encoder0.encode((Struct) this.filter, 24, true);
    }
  }

  static final class NetworkContextClearHttpCacheResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextClearHttpCacheResponseParams(int version) {
      super(8, version);
    }

    public NetworkContextClearHttpCacheResponseParams() {
      this(0);
    }

    public static NetworkContextClearHttpCacheResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextClearHttpCacheResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextClearHttpCacheResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextClearHttpCacheResponseParams result =
            new NetworkContextClearHttpCacheResponseParams(elementsOrVersion);
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

  static class NetworkContextClearHttpCacheResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NetworkContext.ClearHttpCache_Response mCallback;

    NetworkContextClearHttpCacheResponseParamsForwardToCallback(
        NetworkContext.ClearHttpCache_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(13, 2)) {
          return false;
        }
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NetworkContextClearHttpCacheResponseParamsProxyToResponder
      implements NetworkContext.ClearHttpCache_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkContextClearHttpCacheResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      NetworkContextClearHttpCacheResponseParams _response =
          new NetworkContextClearHttpCacheResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(13, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkContextComputeHttpCacheSizeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public Time endTime;
    public Time startTime;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextComputeHttpCacheSizeParams(int version) {
      super(24, version);
    }

    public NetworkContextComputeHttpCacheSizeParams() {
      this(0);
    }

    public static NetworkContextComputeHttpCacheSizeParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextComputeHttpCacheSizeParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextComputeHttpCacheSizeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextComputeHttpCacheSizeParams result =
            new NetworkContextComputeHttpCacheSizeParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.startTime = Time.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.endTime = Time.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.startTime, 8, false);
      encoder0.encode((Struct) this.endTime, 16, false);
    }
  }

  static final class NetworkContextComputeHttpCacheSizeResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean isUpperBound;
    public long sizeOrError;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextComputeHttpCacheSizeResponseParams(int version) {
      super(24, version);
    }

    public NetworkContextComputeHttpCacheSizeResponseParams() {
      this(0);
    }

    public static NetworkContextComputeHttpCacheSizeResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextComputeHttpCacheSizeResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextComputeHttpCacheSizeResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextComputeHttpCacheSizeResponseParams result =
            new NetworkContextComputeHttpCacheSizeResponseParams(elementsOrVersion);
        result.isUpperBound = decoder0.readBoolean(8, 0);
        result.sizeOrError = decoder0.readLong(16);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.isUpperBound, 8, 0);
      encoder0.encode(this.sizeOrError, 16);
    }
  }

  static class NetworkContextComputeHttpCacheSizeResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NetworkContext.ComputeHttpCacheSize_Response mCallback;

    NetworkContextComputeHttpCacheSizeResponseParamsForwardToCallback(
        NetworkContext.ComputeHttpCacheSize_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(14, 2)) {
          return false;
        }
        NetworkContextComputeHttpCacheSizeResponseParams response =
            NetworkContextComputeHttpCacheSizeResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.isUpperBound, response.sizeOrError);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NetworkContextComputeHttpCacheSizeResponseParamsProxyToResponder
      implements NetworkContext.ComputeHttpCacheSize_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkContextComputeHttpCacheSizeResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean isUpperBound, long sizeOrError) {
      NetworkContextComputeHttpCacheSizeResponseParams _response =
          new NetworkContextComputeHttpCacheSizeResponseParams();
      _response.isUpperBound = isUpperBound;
      _response.sizeOrError = sizeOrError;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(14, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkContextNotifyExternalCacheHitParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 48;
    private static final DataHeader[] VERSION_ARRAY;
    public String httpMethod;
    public boolean includeCredentials;
    public boolean isSubframeDocumentResource;
    public NetworkIsolationKey key;
    public Url url;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(48, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextNotifyExternalCacheHitParams(int version) {
      super(48, version);
    }

    public NetworkContextNotifyExternalCacheHitParams() {
      this(0);
    }

    public static NetworkContextNotifyExternalCacheHitParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextNotifyExternalCacheHitParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextNotifyExternalCacheHitParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextNotifyExternalCacheHitParams result =
            new NetworkContextNotifyExternalCacheHitParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.url = Url.decode(decoder1);
        result.httpMethod = decoder0.readString(16, false);
        result.key = NetworkIsolationKey.decode(decoder0, 24);
        result.isSubframeDocumentResource = decoder0.readBoolean(40, 0);
        result.includeCredentials = decoder0.readBoolean(40, 1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.url, 8, false);
      encoder0.encode(this.httpMethod, 16, false);
      encoder0.encode((Union) this.key, 24, false);
      encoder0.encode(this.isSubframeDocumentResource, 40, 0);
      encoder0.encode(this.includeCredentials, 40, 1);
    }
  }

  static final class NetworkContextClearHostCacheParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public ClearDataFilter filter;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextClearHostCacheParams(int version) {
      super(16, version);
    }

    public NetworkContextClearHostCacheParams() {
      this(0);
    }

    public static NetworkContextClearHostCacheParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextClearHostCacheParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextClearHostCacheParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextClearHostCacheParams result =
            new NetworkContextClearHostCacheParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.filter = ClearDataFilter.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.filter, 8, true);
    }
  }

  static final class NetworkContextClearHostCacheResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextClearHostCacheResponseParams(int version) {
      super(8, version);
    }

    public NetworkContextClearHostCacheResponseParams() {
      this(0);
    }

    public static NetworkContextClearHostCacheResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextClearHostCacheResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextClearHostCacheResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextClearHostCacheResponseParams result =
            new NetworkContextClearHostCacheResponseParams(elementsOrVersion);
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

  static class NetworkContextClearHostCacheResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NetworkContext.ClearHostCache_Response mCallback;

    NetworkContextClearHostCacheResponseParamsForwardToCallback(
        NetworkContext.ClearHostCache_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(16, 2)) {
          return false;
        }
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NetworkContextClearHostCacheResponseParamsProxyToResponder
      implements NetworkContext.ClearHostCache_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkContextClearHostCacheResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      NetworkContextClearHostCacheResponseParams _response =
          new NetworkContextClearHostCacheResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(16, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkContextClearHttpAuthCacheParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public Time endTime;
    public ClearDataFilter filter;
    public Time startTime;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextClearHttpAuthCacheParams(int version) {
      super(32, version);
    }

    public NetworkContextClearHttpAuthCacheParams() {
      this(0);
    }

    public static NetworkContextClearHttpAuthCacheParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextClearHttpAuthCacheParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextClearHttpAuthCacheParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextClearHttpAuthCacheParams result =
            new NetworkContextClearHttpAuthCacheParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.startTime = Time.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.endTime = Time.decode(decoder12);
        Decoder decoder13 = decoder0.readPointer(24, true);
        result.filter = ClearDataFilter.decode(decoder13);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.startTime, 8, false);
      encoder0.encode((Struct) this.endTime, 16, false);
      encoder0.encode((Struct) this.filter, 24, true);
    }
  }

  static final class NetworkContextClearHttpAuthCacheResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextClearHttpAuthCacheResponseParams(int version) {
      super(8, version);
    }

    public NetworkContextClearHttpAuthCacheResponseParams() {
      this(0);
    }

    public static NetworkContextClearHttpAuthCacheResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextClearHttpAuthCacheResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextClearHttpAuthCacheResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextClearHttpAuthCacheResponseParams result =
            new NetworkContextClearHttpAuthCacheResponseParams(elementsOrVersion);
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

  static class NetworkContextClearHttpAuthCacheResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NetworkContext.ClearHttpAuthCache_Response mCallback;

    NetworkContextClearHttpAuthCacheResponseParamsForwardToCallback(
        NetworkContext.ClearHttpAuthCache_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(17, 2)) {
          return false;
        }
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NetworkContextClearHttpAuthCacheResponseParamsProxyToResponder
      implements NetworkContext.ClearHttpAuthCache_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkContextClearHttpAuthCacheResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      NetworkContextClearHttpAuthCacheResponseParams _response =
          new NetworkContextClearHttpAuthCacheResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(17, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkContextClearCorsPreflightCacheParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public ClearDataFilter filter;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextClearCorsPreflightCacheParams(int version) {
      super(16, version);
    }

    public NetworkContextClearCorsPreflightCacheParams() {
      this(0);
    }

    public static NetworkContextClearCorsPreflightCacheParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextClearCorsPreflightCacheParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextClearCorsPreflightCacheParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextClearCorsPreflightCacheParams result =
            new NetworkContextClearCorsPreflightCacheParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.filter = ClearDataFilter.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.filter, 8, true);
    }
  }

  static final class NetworkContextClearCorsPreflightCacheResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextClearCorsPreflightCacheResponseParams(int version) {
      super(8, version);
    }

    public NetworkContextClearCorsPreflightCacheResponseParams() {
      this(0);
    }

    public static NetworkContextClearCorsPreflightCacheResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextClearCorsPreflightCacheResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextClearCorsPreflightCacheResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextClearCorsPreflightCacheResponseParams result =
            new NetworkContextClearCorsPreflightCacheResponseParams(elementsOrVersion);
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

  static class NetworkContextClearCorsPreflightCacheResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NetworkContext.ClearCorsPreflightCache_Response mCallback;

    NetworkContextClearCorsPreflightCacheResponseParamsForwardToCallback(
        NetworkContext.ClearCorsPreflightCache_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(18, 2)) {
          return false;
        }
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NetworkContextClearCorsPreflightCacheResponseParamsProxyToResponder
      implements NetworkContext.ClearCorsPreflightCache_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkContextClearCorsPreflightCacheResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      NetworkContextClearCorsPreflightCacheResponseParams _response =
          new NetworkContextClearCorsPreflightCacheResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(18, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkContextClearReportingCacheReportsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public ClearDataFilter filter;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextClearReportingCacheReportsParams(int version) {
      super(16, version);
    }

    public NetworkContextClearReportingCacheReportsParams() {
      this(0);
    }

    public static NetworkContextClearReportingCacheReportsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextClearReportingCacheReportsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextClearReportingCacheReportsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextClearReportingCacheReportsParams result =
            new NetworkContextClearReportingCacheReportsParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.filter = ClearDataFilter.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.filter, 8, true);
    }
  }

  static final class NetworkContextClearReportingCacheReportsResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextClearReportingCacheReportsResponseParams(int version) {
      super(8, version);
    }

    public NetworkContextClearReportingCacheReportsResponseParams() {
      this(0);
    }

    public static NetworkContextClearReportingCacheReportsResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextClearReportingCacheReportsResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextClearReportingCacheReportsResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextClearReportingCacheReportsResponseParams result =
            new NetworkContextClearReportingCacheReportsResponseParams(elementsOrVersion);
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

  static class NetworkContextClearReportingCacheReportsResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NetworkContext.ClearReportingCacheReports_Response mCallback;

    NetworkContextClearReportingCacheReportsResponseParamsForwardToCallback(
        NetworkContext.ClearReportingCacheReports_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(19, 2)) {
          return false;
        }
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NetworkContextClearReportingCacheReportsResponseParamsProxyToResponder
      implements NetworkContext.ClearReportingCacheReports_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkContextClearReportingCacheReportsResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      NetworkContextClearReportingCacheReportsResponseParams _response =
          new NetworkContextClearReportingCacheReportsResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(19, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkContextClearReportingCacheClientsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public ClearDataFilter filter;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextClearReportingCacheClientsParams(int version) {
      super(16, version);
    }

    public NetworkContextClearReportingCacheClientsParams() {
      this(0);
    }

    public static NetworkContextClearReportingCacheClientsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextClearReportingCacheClientsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextClearReportingCacheClientsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextClearReportingCacheClientsParams result =
            new NetworkContextClearReportingCacheClientsParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.filter = ClearDataFilter.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.filter, 8, true);
    }
  }

  static final class NetworkContextClearReportingCacheClientsResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextClearReportingCacheClientsResponseParams(int version) {
      super(8, version);
    }

    public NetworkContextClearReportingCacheClientsResponseParams() {
      this(0);
    }

    public static NetworkContextClearReportingCacheClientsResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextClearReportingCacheClientsResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextClearReportingCacheClientsResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextClearReportingCacheClientsResponseParams result =
            new NetworkContextClearReportingCacheClientsResponseParams(elementsOrVersion);
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

  static class NetworkContextClearReportingCacheClientsResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NetworkContext.ClearReportingCacheClients_Response mCallback;

    NetworkContextClearReportingCacheClientsResponseParamsForwardToCallback(
        NetworkContext.ClearReportingCacheClients_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(20, 2)) {
          return false;
        }
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NetworkContextClearReportingCacheClientsResponseParamsProxyToResponder
      implements NetworkContext.ClearReportingCacheClients_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkContextClearReportingCacheClientsResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      NetworkContextClearReportingCacheClientsResponseParams _response =
          new NetworkContextClearReportingCacheClientsResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(20, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkContextClearNetworkErrorLoggingParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public ClearDataFilter filter;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextClearNetworkErrorLoggingParams(int version) {
      super(16, version);
    }

    public NetworkContextClearNetworkErrorLoggingParams() {
      this(0);
    }

    public static NetworkContextClearNetworkErrorLoggingParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextClearNetworkErrorLoggingParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextClearNetworkErrorLoggingParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextClearNetworkErrorLoggingParams result =
            new NetworkContextClearNetworkErrorLoggingParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.filter = ClearDataFilter.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.filter, 8, true);
    }
  }

  static final class NetworkContextClearNetworkErrorLoggingResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextClearNetworkErrorLoggingResponseParams(int version) {
      super(8, version);
    }

    public NetworkContextClearNetworkErrorLoggingResponseParams() {
      this(0);
    }

    public static NetworkContextClearNetworkErrorLoggingResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextClearNetworkErrorLoggingResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextClearNetworkErrorLoggingResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextClearNetworkErrorLoggingResponseParams result =
            new NetworkContextClearNetworkErrorLoggingResponseParams(elementsOrVersion);
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

  static class NetworkContextClearNetworkErrorLoggingResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NetworkContext.ClearNetworkErrorLogging_Response mCallback;

    NetworkContextClearNetworkErrorLoggingResponseParamsForwardToCallback(
        NetworkContext.ClearNetworkErrorLogging_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(21, 2)) {
          return false;
        }
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NetworkContextClearNetworkErrorLoggingResponseParamsProxyToResponder
      implements NetworkContext.ClearNetworkErrorLogging_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkContextClearNetworkErrorLoggingResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      NetworkContextClearNetworkErrorLoggingResponseParams _response =
          new NetworkContextClearNetworkErrorLoggingResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(21, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkContextClearDomainReliabilityParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public ClearDataFilter filter;
    public int mode;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextClearDomainReliabilityParams(int version) {
      super(24, version);
    }

    public NetworkContextClearDomainReliabilityParams() {
      this(0);
    }

    public static NetworkContextClearDomainReliabilityParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextClearDomainReliabilityParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextClearDomainReliabilityParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextClearDomainReliabilityParams result =
            new NetworkContextClearDomainReliabilityParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.filter = ClearDataFilter.decode(decoder1);
        int readInt = decoder0.readInt(16);
        result.mode = readInt;
        NetworkContext.DomainReliabilityClearMode.validate(readInt);
        result.mode = NetworkContext.DomainReliabilityClearMode.toKnownValue(result.mode);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.filter, 8, true);
      encoder0.encode(this.mode, 16);
    }
  }

  static final class NetworkContextClearDomainReliabilityResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextClearDomainReliabilityResponseParams(int version) {
      super(8, version);
    }

    public NetworkContextClearDomainReliabilityResponseParams() {
      this(0);
    }

    public static NetworkContextClearDomainReliabilityResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextClearDomainReliabilityResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextClearDomainReliabilityResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextClearDomainReliabilityResponseParams result =
            new NetworkContextClearDomainReliabilityResponseParams(elementsOrVersion);
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

  static class NetworkContextClearDomainReliabilityResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NetworkContext.ClearDomainReliability_Response mCallback;

    NetworkContextClearDomainReliabilityResponseParamsForwardToCallback(
        NetworkContext.ClearDomainReliability_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(22, 2)) {
          return false;
        }
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NetworkContextClearDomainReliabilityResponseParamsProxyToResponder
      implements NetworkContext.ClearDomainReliability_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkContextClearDomainReliabilityResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      NetworkContextClearDomainReliabilityResponseParams _response =
          new NetworkContextClearDomainReliabilityResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(22, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkContextClearSharedDictionaryCacheParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public Time endTime;
    public ClearDataFilter filter;
    public Time startTime;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextClearSharedDictionaryCacheParams(int version) {
      super(32, version);
    }

    public NetworkContextClearSharedDictionaryCacheParams() {
      this(0);
    }

    public static NetworkContextClearSharedDictionaryCacheParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextClearSharedDictionaryCacheParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextClearSharedDictionaryCacheParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextClearSharedDictionaryCacheParams result =
            new NetworkContextClearSharedDictionaryCacheParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.startTime = Time.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.endTime = Time.decode(decoder12);
        Decoder decoder13 = decoder0.readPointer(24, true);
        result.filter = ClearDataFilter.decode(decoder13);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.startTime, 8, false);
      encoder0.encode((Struct) this.endTime, 16, false);
      encoder0.encode((Struct) this.filter, 24, true);
    }
  }

  static final class NetworkContextClearSharedDictionaryCacheResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextClearSharedDictionaryCacheResponseParams(int version) {
      super(8, version);
    }

    public NetworkContextClearSharedDictionaryCacheResponseParams() {
      this(0);
    }

    public static NetworkContextClearSharedDictionaryCacheResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextClearSharedDictionaryCacheResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextClearSharedDictionaryCacheResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextClearSharedDictionaryCacheResponseParams result =
            new NetworkContextClearSharedDictionaryCacheResponseParams(elementsOrVersion);
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

  static class NetworkContextClearSharedDictionaryCacheResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NetworkContext.ClearSharedDictionaryCache_Response mCallback;

    NetworkContextClearSharedDictionaryCacheResponseParamsForwardToCallback(
        NetworkContext.ClearSharedDictionaryCache_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(23, 2)) {
          return false;
        }
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NetworkContextClearSharedDictionaryCacheResponseParamsProxyToResponder
      implements NetworkContext.ClearSharedDictionaryCache_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkContextClearSharedDictionaryCacheResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      NetworkContextClearSharedDictionaryCacheResponseParams _response =
          new NetworkContextClearSharedDictionaryCacheResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(23, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkContextClearSharedDictionaryCacheForIsolationKeyParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public SharedDictionaryIsolationKey isolationKey;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextClearSharedDictionaryCacheForIsolationKeyParams(int version) {
      super(16, version);
    }

    public NetworkContextClearSharedDictionaryCacheForIsolationKeyParams() {
      this(0);
    }

    public static NetworkContextClearSharedDictionaryCacheForIsolationKeyParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextClearSharedDictionaryCacheForIsolationKeyParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextClearSharedDictionaryCacheForIsolationKeyParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextClearSharedDictionaryCacheForIsolationKeyParams result =
            new NetworkContextClearSharedDictionaryCacheForIsolationKeyParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.isolationKey = SharedDictionaryIsolationKey.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.isolationKey, 8, false);
    }
  }

  static final class NetworkContextClearSharedDictionaryCacheForIsolationKeyResponseParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextClearSharedDictionaryCacheForIsolationKeyResponseParams(int version) {
      super(8, version);
    }

    public NetworkContextClearSharedDictionaryCacheForIsolationKeyResponseParams() {
      this(0);
    }

    public static NetworkContextClearSharedDictionaryCacheForIsolationKeyResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextClearSharedDictionaryCacheForIsolationKeyResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextClearSharedDictionaryCacheForIsolationKeyResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextClearSharedDictionaryCacheForIsolationKeyResponseParams result =
            new NetworkContextClearSharedDictionaryCacheForIsolationKeyResponseParams(
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
  class NetworkContextClearSharedDictionaryCacheForIsolationKeyResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NetworkContext.ClearSharedDictionaryCacheForIsolationKey_Response mCallback;

    NetworkContextClearSharedDictionaryCacheForIsolationKeyResponseParamsForwardToCallback(
        NetworkContext.ClearSharedDictionaryCacheForIsolationKey_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(24, 2)) {
          return false;
        }
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NetworkContextClearSharedDictionaryCacheForIsolationKeyResponseParamsProxyToResponder
      implements NetworkContext.ClearSharedDictionaryCacheForIsolationKey_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkContextClearSharedDictionaryCacheForIsolationKeyResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      NetworkContextClearSharedDictionaryCacheForIsolationKeyResponseParams _response =
          new NetworkContextClearSharedDictionaryCacheForIsolationKeyResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(24, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkContextSetDocumentReportingEndpointsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public Map<String, String> endpoints;
    public IsolationInfo isolationInfo;
    public Origin origin;
    public UnguessableToken reportingSource;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextSetDocumentReportingEndpointsParams(int version) {
      super(40, version);
    }

    public NetworkContextSetDocumentReportingEndpointsParams() {
      this(0);
    }

    public static NetworkContextSetDocumentReportingEndpointsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextSetDocumentReportingEndpointsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextSetDocumentReportingEndpointsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextSetDocumentReportingEndpointsParams result =
            new NetworkContextSetDocumentReportingEndpointsParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.reportingSource = UnguessableToken.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.origin = Origin.decode(decoder12);
        Decoder decoder13 = decoder0.readPointer(24, false);
        result.isolationInfo = IsolationInfo.decode(decoder13);
        Decoder decoder14 = decoder0.readPointer(32, false);
        decoder14.readDataHeaderForMap();
        Decoder decoder2 = decoder14.readPointer(8, false);
        DataHeader si2 = decoder2.readDataHeaderForPointerArray(-1);
        String[] keys0 = new String[si2.elementsOrVersion];
        for (int i2 = 0; i2 < si2.elementsOrVersion; i2++) {
          keys0[i2] = decoder2.readString((i2 * 8) + 8, false);
        }
        Decoder decoder22 = decoder14.readPointer(16, false);
        DataHeader si22 = decoder22.readDataHeaderForPointerArray(keys0.length);
        String[] values0 = new String[si22.elementsOrVersion];
        for (int i22 = 0; i22 < si22.elementsOrVersion; i22++) {
          values0[i22] = decoder22.readString((i22 * 8) + 8, false);
        }
        result.endpoints = new HashMap();
        for (int index0 = 0; index0 < keys0.length; index0++) {
          result.endpoints.put(keys0[index0], values0[index0]);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.reportingSource, 8, false);
      encoder0.encode((Struct) this.origin, 16, false);
      encoder0.encode((Struct) this.isolationInfo, 24, false);
      if (this.endpoints == null) {
        encoder0.encodeNullPointer(32, false);
        return;
      }
      Encoder encoder1 = encoder0.encoderForMap(32);
      int size0 = this.endpoints.size();
      String[] keys0 = new String[size0];
      String[] values0 = new String[size0];
      int index0 = 0;
      for (Map.Entry<String, String> entry0 : this.endpoints.entrySet()) {
        keys0[index0] = entry0.getKey();
        values0[index0] = entry0.getValue();
        index0++;
      }
      Encoder encoder2 = encoder1.encodePointerArray(keys0.length, 8, -1);
      for (int i1 = 0; i1 < keys0.length; i1++) {
        encoder2.encode(keys0[i1], (i1 * 8) + 8, false);
      }
      Encoder encoder22 = encoder1.encodePointerArray(values0.length, 16, -1);
      for (int i12 = 0; i12 < values0.length; i12++) {
        encoder22.encode(values0[i12], (i12 * 8) + 8, false);
      }
    }
  }

  static final class NetworkContextSendReportsAndRemoveSourceParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public UnguessableToken reportingSource;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextSendReportsAndRemoveSourceParams(int version) {
      super(16, version);
    }

    public NetworkContextSendReportsAndRemoveSourceParams() {
      this(0);
    }

    public static NetworkContextSendReportsAndRemoveSourceParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextSendReportsAndRemoveSourceParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextSendReportsAndRemoveSourceParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextSendReportsAndRemoveSourceParams result =
            new NetworkContextSendReportsAndRemoveSourceParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.reportingSource = UnguessableToken.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.reportingSource, 8, false);
    }
  }

  static final class NetworkContextQueueReportParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 72;
    private static final DataHeader[] VERSION_ARRAY;
    public DictionaryValue body;
    public String group;
    public NetworkAnonymizationKey networkAnonymizationKey;
    public UnguessableToken reportingSource;
    public String type;
    public Url url;
    public String userAgent;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(72, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextQueueReportParams(int version) {
      super(72, version);
    }

    public NetworkContextQueueReportParams() {
      this(0);
    }

    public static NetworkContextQueueReportParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextQueueReportParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextQueueReportParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextQueueReportParams result =
            new NetworkContextQueueReportParams(elementsOrVersion);
        result.type = decoder0.readString(8, false);
        result.group = decoder0.readString(16, false);
        Decoder decoder1 = decoder0.readPointer(24, false);
        result.url = Url.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(32, true);
        result.reportingSource = UnguessableToken.decode(decoder12);
        result.networkAnonymizationKey = NetworkAnonymizationKey.decode(decoder0, 40);
        result.userAgent = decoder0.readString(56, true);
        Decoder decoder13 = decoder0.readPointer(64, false);
        result.body = DictionaryValue.decode(decoder13);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.type, 8, false);
      encoder0.encode(this.group, 16, false);
      encoder0.encode((Struct) this.url, 24, false);
      encoder0.encode((Struct) this.reportingSource, 32, true);
      encoder0.encode((Union) this.networkAnonymizationKey, 40, false);
      encoder0.encode(this.userAgent, 56, true);
      encoder0.encode((Struct) this.body, 64, false);
    }
  }

  static final class NetworkContextQueueSignedExchangeReportParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public NetworkAnonymizationKey networkAnonymizationKey;
    public SignedExchangeReport report;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextQueueSignedExchangeReportParams(int version) {
      super(32, version);
    }

    public NetworkContextQueueSignedExchangeReportParams() {
      this(0);
    }

    public static NetworkContextQueueSignedExchangeReportParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextQueueSignedExchangeReportParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextQueueSignedExchangeReportParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextQueueSignedExchangeReportParams result =
            new NetworkContextQueueSignedExchangeReportParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.report = SignedExchangeReport.decode(decoder1);
        result.networkAnonymizationKey = NetworkAnonymizationKey.decode(decoder0, 16);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.report, 8, false);
      encoder0.encode((Union) this.networkAnonymizationKey, 16, false);
    }
  }

  static final class NetworkContextCloseAllConnectionsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextCloseAllConnectionsParams(int version) {
      super(8, version);
    }

    public NetworkContextCloseAllConnectionsParams() {
      this(0);
    }

    public static NetworkContextCloseAllConnectionsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextCloseAllConnectionsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextCloseAllConnectionsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextCloseAllConnectionsParams result =
            new NetworkContextCloseAllConnectionsParams(elementsOrVersion);
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

  static final class NetworkContextCloseAllConnectionsResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextCloseAllConnectionsResponseParams(int version) {
      super(8, version);
    }

    public NetworkContextCloseAllConnectionsResponseParams() {
      this(0);
    }

    public static NetworkContextCloseAllConnectionsResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextCloseAllConnectionsResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextCloseAllConnectionsResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextCloseAllConnectionsResponseParams result =
            new NetworkContextCloseAllConnectionsResponseParams(elementsOrVersion);
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

  static class NetworkContextCloseAllConnectionsResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NetworkContext.CloseAllConnections_Response mCallback;

    NetworkContextCloseAllConnectionsResponseParamsForwardToCallback(
        NetworkContext.CloseAllConnections_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(29, 2)) {
          return false;
        }
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NetworkContextCloseAllConnectionsResponseParamsProxyToResponder
      implements NetworkContext.CloseAllConnections_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkContextCloseAllConnectionsResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      NetworkContextCloseAllConnectionsResponseParams _response =
          new NetworkContextCloseAllConnectionsResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(29, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkContextCloseIdleConnectionsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextCloseIdleConnectionsParams(int version) {
      super(8, version);
    }

    public NetworkContextCloseIdleConnectionsParams() {
      this(0);
    }

    public static NetworkContextCloseIdleConnectionsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextCloseIdleConnectionsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextCloseIdleConnectionsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextCloseIdleConnectionsParams result =
            new NetworkContextCloseIdleConnectionsParams(elementsOrVersion);
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

  static final class NetworkContextCloseIdleConnectionsResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextCloseIdleConnectionsResponseParams(int version) {
      super(8, version);
    }

    public NetworkContextCloseIdleConnectionsResponseParams() {
      this(0);
    }

    public static NetworkContextCloseIdleConnectionsResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextCloseIdleConnectionsResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextCloseIdleConnectionsResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextCloseIdleConnectionsResponseParams result =
            new NetworkContextCloseIdleConnectionsResponseParams(elementsOrVersion);
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

  static class NetworkContextCloseIdleConnectionsResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NetworkContext.CloseIdleConnections_Response mCallback;

    NetworkContextCloseIdleConnectionsResponseParamsForwardToCallback(
        NetworkContext.CloseIdleConnections_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(30, 2)) {
          return false;
        }
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NetworkContextCloseIdleConnectionsResponseParamsProxyToResponder
      implements NetworkContext.CloseIdleConnections_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkContextCloseIdleConnectionsResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      NetworkContextCloseIdleConnectionsResponseParams _response =
          new NetworkContextCloseIdleConnectionsResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(30, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkContextSetNetworkConditionsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public NetworkConditions conditions;
    public UnguessableToken throttlingProfileId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextSetNetworkConditionsParams(int version) {
      super(24, version);
    }

    public NetworkContextSetNetworkConditionsParams() {
      this(0);
    }

    public static NetworkContextSetNetworkConditionsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextSetNetworkConditionsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextSetNetworkConditionsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextSetNetworkConditionsParams result =
            new NetworkContextSetNetworkConditionsParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.throttlingProfileId = UnguessableToken.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, true);
        result.conditions = NetworkConditions.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.throttlingProfileId, 8, false);
      encoder0.encode((Struct) this.conditions, 16, true);
    }
  }

  static final class NetworkContextSetAcceptLanguageParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String newAcceptLanguage;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextSetAcceptLanguageParams(int version) {
      super(16, version);
    }

    public NetworkContextSetAcceptLanguageParams() {
      this(0);
    }

    public static NetworkContextSetAcceptLanguageParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextSetAcceptLanguageParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextSetAcceptLanguageParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextSetAcceptLanguageParams result =
            new NetworkContextSetAcceptLanguageParams(elementsOrVersion);
        result.newAcceptLanguage = decoder0.readString(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.newAcceptLanguage, 8, false);
    }
  }

  static final class NetworkContextSetEnableReferrersParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean enableReferrers;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextSetEnableReferrersParams(int version) {
      super(16, version);
    }

    public NetworkContextSetEnableReferrersParams() {
      this(0);
    }

    public static NetworkContextSetEnableReferrersParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextSetEnableReferrersParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextSetEnableReferrersParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextSetEnableReferrersParams result =
            new NetworkContextSetEnableReferrersParams(elementsOrVersion);
        result.enableReferrers = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.enableReferrers, 8, 0);
    }
  }

  static final class NetworkContextSetCtPolicyParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public CtPolicy ctPolicy;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextSetCtPolicyParams(int version) {
      super(16, version);
    }

    public NetworkContextSetCtPolicyParams() {
      this(0);
    }

    public static NetworkContextSetCtPolicyParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextSetCtPolicyParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextSetCtPolicyParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextSetCtPolicyParams result =
            new NetworkContextSetCtPolicyParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.ctPolicy = CtPolicy.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.ctPolicy, 8, false);
    }
  }

  static final class NetworkContextCreateUdpSocketParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public UdpSocketListener listener;
    public InterfaceRequest<UdpSocket> receiver;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextCreateUdpSocketParams(int version) {
      super(24, version);
    }

    public NetworkContextCreateUdpSocketParams() {
      this(0);
    }

    public static NetworkContextCreateUdpSocketParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextCreateUdpSocketParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextCreateUdpSocketParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextCreateUdpSocketParams result =
            new NetworkContextCreateUdpSocketParams(elementsOrVersion);
        result.receiver = decoder0.readInterfaceRequest(8, false);
        result.listener =
            (UdpSocketListener) decoder0.readServiceInterface(12, true, UdpSocketListener.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.receiver, 8, false);
      encoder0.encode(this.listener, 12, true, UdpSocketListener.MANAGER);
    }
  }

  static final class NetworkContextCreateRestrictedUdpSocketParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 48;
    private static final DataHeader[] VERSION_ARRAY;
    public IpEndPoint addr;
    public UdpSocketListener listener;
    public int mode;
    public RestrictedUdpSocketParams params;
    public InterfaceRequest<RestrictedUdpSocket> receiver;
    public MutableNetworkTrafficAnnotationTag trafficAnnotation;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(48, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextCreateRestrictedUdpSocketParams(int version) {
      super(48, version);
    }

    public NetworkContextCreateRestrictedUdpSocketParams() {
      this(0);
    }

    public static NetworkContextCreateRestrictedUdpSocketParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextCreateRestrictedUdpSocketParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextCreateRestrictedUdpSocketParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextCreateRestrictedUdpSocketParams result =
            new NetworkContextCreateRestrictedUdpSocketParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.addr = IpEndPoint.decode(decoder1);
        int readInt = decoder0.readInt(16);
        result.mode = readInt;
        RestrictedUdpSocketMode.validate(readInt);
        result.mode = RestrictedUdpSocketMode.toKnownValue(result.mode);
        result.receiver = decoder0.readInterfaceRequest(20, false);
        Decoder decoder12 = decoder0.readPointer(24, false);
        result.trafficAnnotation = MutableNetworkTrafficAnnotationTag.decode(decoder12);
        Decoder decoder13 = decoder0.readPointer(32, true);
        result.params = RestrictedUdpSocketParams.decode(decoder13);
        result.listener =
            (UdpSocketListener) decoder0.readServiceInterface(40, true, UdpSocketListener.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.addr, 8, false);
      encoder0.encode(this.mode, 16);
      encoder0.encode((InterfaceRequest) this.receiver, 20, false);
      encoder0.encode((Struct) this.trafficAnnotation, 24, false);
      encoder0.encode((Struct) this.params, 32, true);
      encoder0.encode(this.listener, 40, true, UdpSocketListener.MANAGER);
    }
  }

  static final class NetworkContextCreateRestrictedUdpSocketResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public IpEndPoint localAddrOut;
    public int result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextCreateRestrictedUdpSocketResponseParams(int version) {
      super(24, version);
    }

    public NetworkContextCreateRestrictedUdpSocketResponseParams() {
      this(0);
    }

    public static NetworkContextCreateRestrictedUdpSocketResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextCreateRestrictedUdpSocketResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextCreateRestrictedUdpSocketResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextCreateRestrictedUdpSocketResponseParams result =
            new NetworkContextCreateRestrictedUdpSocketResponseParams(elementsOrVersion);
        result.result = decoder0.readInt(8);
        Decoder decoder1 = decoder0.readPointer(16, true);
        result.localAddrOut = IpEndPoint.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.result, 8);
      encoder0.encode((Struct) this.localAddrOut, 16, true);
    }
  }

  static class NetworkContextCreateRestrictedUdpSocketResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NetworkContext.CreateRestrictedUdpSocket_Response mCallback;

    NetworkContextCreateRestrictedUdpSocketResponseParamsForwardToCallback(
        NetworkContext.CreateRestrictedUdpSocket_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(36, 2)) {
          return false;
        }
        NetworkContextCreateRestrictedUdpSocketResponseParams response =
            NetworkContextCreateRestrictedUdpSocketResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result, response.localAddrOut);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NetworkContextCreateRestrictedUdpSocketResponseParamsProxyToResponder
      implements NetworkContext.CreateRestrictedUdpSocket_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkContextCreateRestrictedUdpSocketResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int result, IpEndPoint localAddrOut) {
      NetworkContextCreateRestrictedUdpSocketResponseParams _response =
          new NetworkContextCreateRestrictedUdpSocketResponseParams();
      _response.result = result;
      _response.localAddrOut = localAddrOut;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(36, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkContextCreateTcpServerSocketParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public IpEndPoint localAddr;
    public TcpServerSocketOptions options;
    public InterfaceRequest<TcpServerSocket> socket;
    public MutableNetworkTrafficAnnotationTag trafficAnnotation;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextCreateTcpServerSocketParams(int version) {
      super(40, version);
    }

    public NetworkContextCreateTcpServerSocketParams() {
      this(0);
    }

    public static NetworkContextCreateTcpServerSocketParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextCreateTcpServerSocketParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextCreateTcpServerSocketParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextCreateTcpServerSocketParams result =
            new NetworkContextCreateTcpServerSocketParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.localAddr = IpEndPoint.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.options = TcpServerSocketOptions.decode(decoder12);
        Decoder decoder13 = decoder0.readPointer(24, false);
        result.trafficAnnotation = MutableNetworkTrafficAnnotationTag.decode(decoder13);
        result.socket = decoder0.readInterfaceRequest(32, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.localAddr, 8, false);
      encoder0.encode((Struct) this.options, 16, false);
      encoder0.encode((Struct) this.trafficAnnotation, 24, false);
      encoder0.encode((InterfaceRequest) this.socket, 32, false);
    }
  }

  static final class NetworkContextCreateTcpServerSocketResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public IpEndPoint localAddrOut;
    public int result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextCreateTcpServerSocketResponseParams(int version) {
      super(24, version);
    }

    public NetworkContextCreateTcpServerSocketResponseParams() {
      this(0);
    }

    public static NetworkContextCreateTcpServerSocketResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextCreateTcpServerSocketResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextCreateTcpServerSocketResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextCreateTcpServerSocketResponseParams result =
            new NetworkContextCreateTcpServerSocketResponseParams(elementsOrVersion);
        result.result = decoder0.readInt(8);
        Decoder decoder1 = decoder0.readPointer(16, true);
        result.localAddrOut = IpEndPoint.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.result, 8);
      encoder0.encode((Struct) this.localAddrOut, 16, true);
    }
  }

  static class NetworkContextCreateTcpServerSocketResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NetworkContext.CreateTcpServerSocket_Response mCallback;

    NetworkContextCreateTcpServerSocketResponseParamsForwardToCallback(
        NetworkContext.CreateTcpServerSocket_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(37, 2)) {
          return false;
        }
        NetworkContextCreateTcpServerSocketResponseParams response =
            NetworkContextCreateTcpServerSocketResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result, response.localAddrOut);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NetworkContextCreateTcpServerSocketResponseParamsProxyToResponder
      implements NetworkContext.CreateTcpServerSocket_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkContextCreateTcpServerSocketResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int result, IpEndPoint localAddrOut) {
      NetworkContextCreateTcpServerSocketResponseParams _response =
          new NetworkContextCreateTcpServerSocketResponseParams();
      _response.result = result;
      _response.localAddrOut = localAddrOut;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(37, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkContextCreateTcpConnectedSocketParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 56;
    private static final DataHeader[] VERSION_ARRAY;
    public IpEndPoint localAddr;
    public SocketObserver observer;
    public AddressList remoteAddrList;
    public InterfaceRequest<TcpConnectedSocket> socket;
    public TcpConnectedSocketOptions tcpConnectedSocketOptions;
    public MutableNetworkTrafficAnnotationTag trafficAnnotation;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(56, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextCreateTcpConnectedSocketParams(int version) {
      super(56, version);
    }

    public NetworkContextCreateTcpConnectedSocketParams() {
      this(0);
    }

    public static NetworkContextCreateTcpConnectedSocketParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextCreateTcpConnectedSocketParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextCreateTcpConnectedSocketParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextCreateTcpConnectedSocketParams result =
            new NetworkContextCreateTcpConnectedSocketParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.localAddr = IpEndPoint.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.remoteAddrList = AddressList.decode(decoder12);
        Decoder decoder13 = decoder0.readPointer(24, true);
        result.tcpConnectedSocketOptions = TcpConnectedSocketOptions.decode(decoder13);
        Decoder decoder14 = decoder0.readPointer(32, false);
        result.trafficAnnotation = MutableNetworkTrafficAnnotationTag.decode(decoder14);
        result.socket = decoder0.readInterfaceRequest(40, false);
        result.observer =
            (SocketObserver) decoder0.readServiceInterface(44, true, SocketObserver.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.localAddr, 8, true);
      encoder0.encode((Struct) this.remoteAddrList, 16, false);
      encoder0.encode((Struct) this.tcpConnectedSocketOptions, 24, true);
      encoder0.encode((Struct) this.trafficAnnotation, 32, false);
      encoder0.encode((InterfaceRequest) this.socket, 40, false);
      encoder0.encode(this.observer, 44, true, SocketObserver.MANAGER);
    }
  }

  static final class NetworkContextCreateTcpConnectedSocketResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public IpEndPoint localAddr;
    public IpEndPoint peerAddr;
    public DataPipe.ConsumerHandle receiveStream;
    public int result;
    public DataPipe.ProducerHandle sendStream;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextCreateTcpConnectedSocketResponseParams(int version) {
      super(40, version);
      this.receiveStream = InvalidHandle.INSTANCE;
      this.sendStream = InvalidHandle.INSTANCE;
    }

    public NetworkContextCreateTcpConnectedSocketResponseParams() {
      this(0);
    }

    public static NetworkContextCreateTcpConnectedSocketResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextCreateTcpConnectedSocketResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextCreateTcpConnectedSocketResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextCreateTcpConnectedSocketResponseParams result =
            new NetworkContextCreateTcpConnectedSocketResponseParams(elementsOrVersion);
        result.result = decoder0.readInt(8);
        result.receiveStream = decoder0.readConsumerHandle(12, true);
        Decoder decoder1 = decoder0.readPointer(16, true);
        result.localAddr = IpEndPoint.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(24, true);
        result.peerAddr = IpEndPoint.decode(decoder12);
        result.sendStream = decoder0.readProducerHandle(32, true);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.result, 8);
      encoder0.encode((Handle) this.receiveStream, 12, true);
      encoder0.encode((Struct) this.localAddr, 16, true);
      encoder0.encode((Struct) this.peerAddr, 24, true);
      encoder0.encode((Handle) this.sendStream, 32, true);
    }
  }

  static class NetworkContextCreateTcpConnectedSocketResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NetworkContext.CreateTcpConnectedSocket_Response mCallback;

    NetworkContextCreateTcpConnectedSocketResponseParamsForwardToCallback(
        NetworkContext.CreateTcpConnectedSocket_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(38, 2)) {
          return false;
        }
        NetworkContextCreateTcpConnectedSocketResponseParams response =
            NetworkContextCreateTcpConnectedSocketResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(
            response.result,
            response.localAddr,
            response.peerAddr,
            response.receiveStream,
            response.sendStream);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NetworkContextCreateTcpConnectedSocketResponseParamsProxyToResponder
      implements NetworkContext.CreateTcpConnectedSocket_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkContextCreateTcpConnectedSocketResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(
        int result,
        IpEndPoint localAddr,
        IpEndPoint peerAddr,
        DataPipe.ConsumerHandle receiveStream,
        DataPipe.ProducerHandle sendStream) {
      NetworkContextCreateTcpConnectedSocketResponseParams _response =
          new NetworkContextCreateTcpConnectedSocketResponseParams();
      _response.result = result;
      _response.localAddr = localAddr;
      _response.peerAddr = peerAddr;
      _response.receiveStream = receiveStream;
      _response.sendStream = sendStream;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(38, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkContextCreateTcpBoundSocketParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public IpEndPoint localAddr;
    public InterfaceRequest<TcpBoundSocket> socket;
    public MutableNetworkTrafficAnnotationTag trafficAnnotation;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextCreateTcpBoundSocketParams(int version) {
      super(32, version);
    }

    public NetworkContextCreateTcpBoundSocketParams() {
      this(0);
    }

    public static NetworkContextCreateTcpBoundSocketParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextCreateTcpBoundSocketParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextCreateTcpBoundSocketParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextCreateTcpBoundSocketParams result =
            new NetworkContextCreateTcpBoundSocketParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.localAddr = IpEndPoint.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.trafficAnnotation = MutableNetworkTrafficAnnotationTag.decode(decoder12);
        result.socket = decoder0.readInterfaceRequest(24, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.localAddr, 8, false);
      encoder0.encode((Struct) this.trafficAnnotation, 16, false);
      encoder0.encode((InterfaceRequest) this.socket, 24, false);
    }
  }

  static final class NetworkContextCreateTcpBoundSocketResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public IpEndPoint localAddr;
    public int result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextCreateTcpBoundSocketResponseParams(int version) {
      super(24, version);
    }

    public NetworkContextCreateTcpBoundSocketResponseParams() {
      this(0);
    }

    public static NetworkContextCreateTcpBoundSocketResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextCreateTcpBoundSocketResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextCreateTcpBoundSocketResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextCreateTcpBoundSocketResponseParams result =
            new NetworkContextCreateTcpBoundSocketResponseParams(elementsOrVersion);
        result.result = decoder0.readInt(8);
        Decoder decoder1 = decoder0.readPointer(16, true);
        result.localAddr = IpEndPoint.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.result, 8);
      encoder0.encode((Struct) this.localAddr, 16, true);
    }
  }

  static class NetworkContextCreateTcpBoundSocketResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NetworkContext.CreateTcpBoundSocket_Response mCallback;

    NetworkContextCreateTcpBoundSocketResponseParamsForwardToCallback(
        NetworkContext.CreateTcpBoundSocket_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(39, 2)) {
          return false;
        }
        NetworkContextCreateTcpBoundSocketResponseParams response =
            NetworkContextCreateTcpBoundSocketResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result, response.localAddr);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NetworkContextCreateTcpBoundSocketResponseParamsProxyToResponder
      implements NetworkContext.CreateTcpBoundSocket_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkContextCreateTcpBoundSocketResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int result, IpEndPoint localAddr) {
      NetworkContextCreateTcpBoundSocketResponseParams _response =
          new NetworkContextCreateTcpBoundSocketResponseParams();
      _response.result = result;
      _response.localAddr = localAddr;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(39, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkContextCreateProxyResolvingSocketFactoryParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<ProxyResolvingSocketFactory> factory;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextCreateProxyResolvingSocketFactoryParams(int version) {
      super(16, version);
    }

    public NetworkContextCreateProxyResolvingSocketFactoryParams() {
      this(0);
    }

    public static NetworkContextCreateProxyResolvingSocketFactoryParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextCreateProxyResolvingSocketFactoryParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextCreateProxyResolvingSocketFactoryParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextCreateProxyResolvingSocketFactoryParams result =
            new NetworkContextCreateProxyResolvingSocketFactoryParams(elementsOrVersion);
        result.factory = decoder0.readInterfaceRequest(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.factory, 8, false);
    }
  }

  static final class NetworkContextLookUpProxyForUrlParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public NetworkAnonymizationKey networkAnonymizationKey;
    public ProxyLookupClient proxyLookupClient;
    public Url url;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextLookUpProxyForUrlParams(int version) {
      super(40, version);
    }

    public NetworkContextLookUpProxyForUrlParams() {
      this(0);
    }

    public static NetworkContextLookUpProxyForUrlParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextLookUpProxyForUrlParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextLookUpProxyForUrlParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextLookUpProxyForUrlParams result =
            new NetworkContextLookUpProxyForUrlParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.url = Url.decode(decoder1);
        result.networkAnonymizationKey = NetworkAnonymizationKey.decode(decoder0, 16);
        result.proxyLookupClient =
            (ProxyLookupClient) decoder0.readServiceInterface(32, false, ProxyLookupClient.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.url, 8, false);
      encoder0.encode((Union) this.networkAnonymizationKey, 16, false);
      encoder0.encode(this.proxyLookupClient, 32, false, ProxyLookupClient.MANAGER);
    }
  }

  static final class NetworkContextForceReloadProxyConfigParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextForceReloadProxyConfigParams(int version) {
      super(8, version);
    }

    public NetworkContextForceReloadProxyConfigParams() {
      this(0);
    }

    public static NetworkContextForceReloadProxyConfigParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextForceReloadProxyConfigParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextForceReloadProxyConfigParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextForceReloadProxyConfigParams result =
            new NetworkContextForceReloadProxyConfigParams(elementsOrVersion);
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

  static final class NetworkContextForceReloadProxyConfigResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextForceReloadProxyConfigResponseParams(int version) {
      super(8, version);
    }

    public NetworkContextForceReloadProxyConfigResponseParams() {
      this(0);
    }

    public static NetworkContextForceReloadProxyConfigResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextForceReloadProxyConfigResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextForceReloadProxyConfigResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextForceReloadProxyConfigResponseParams result =
            new NetworkContextForceReloadProxyConfigResponseParams(elementsOrVersion);
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

  static class NetworkContextForceReloadProxyConfigResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NetworkContext.ForceReloadProxyConfig_Response mCallback;

    NetworkContextForceReloadProxyConfigResponseParamsForwardToCallback(
        NetworkContext.ForceReloadProxyConfig_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(42, 2)) {
          return false;
        }
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NetworkContextForceReloadProxyConfigResponseParamsProxyToResponder
      implements NetworkContext.ForceReloadProxyConfig_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkContextForceReloadProxyConfigResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      NetworkContextForceReloadProxyConfigResponseParams _response =
          new NetworkContextForceReloadProxyConfigResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(42, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkContextClearBadProxiesCacheParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextClearBadProxiesCacheParams(int version) {
      super(8, version);
    }

    public NetworkContextClearBadProxiesCacheParams() {
      this(0);
    }

    public static NetworkContextClearBadProxiesCacheParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextClearBadProxiesCacheParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextClearBadProxiesCacheParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextClearBadProxiesCacheParams result =
            new NetworkContextClearBadProxiesCacheParams(elementsOrVersion);
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

  static final class NetworkContextClearBadProxiesCacheResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextClearBadProxiesCacheResponseParams(int version) {
      super(8, version);
    }

    public NetworkContextClearBadProxiesCacheResponseParams() {
      this(0);
    }

    public static NetworkContextClearBadProxiesCacheResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextClearBadProxiesCacheResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextClearBadProxiesCacheResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextClearBadProxiesCacheResponseParams result =
            new NetworkContextClearBadProxiesCacheResponseParams(elementsOrVersion);
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

  static class NetworkContextClearBadProxiesCacheResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NetworkContext.ClearBadProxiesCache_Response mCallback;

    NetworkContextClearBadProxiesCacheResponseParamsForwardToCallback(
        NetworkContext.ClearBadProxiesCache_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(43, 2)) {
          return false;
        }
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NetworkContextClearBadProxiesCacheResponseParamsProxyToResponder
      implements NetworkContext.ClearBadProxiesCache_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkContextClearBadProxiesCacheResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      NetworkContextClearBadProxiesCacheResponseParams _response =
          new NetworkContextClearBadProxiesCacheResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(43, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkContextCreateWebSocketParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 120;
    private static final DataHeader[] VERSION_ARRAY;
    public HttpHeader[] additionalHeaders;
    public WebSocketAuthenticationHandler authHandler;
    public WebSocketHandshakeClient handshakeClient;
    public boolean hasStorageAccess;
    public TrustedHeaderClient headerClient;
    public IsolationInfo isolationInfo;
    public int options;
    public Origin origin;
    public int processId;
    public String[] requestedProtocols;
    public SiteForCookies siteForCookies;
    public UnguessableToken throttlingProfileId;
    public MutableNetworkTrafficAnnotationTag trafficAnnotation;
    public Url url;
    public UrlLoaderNetworkServiceObserver urlLoaderNetworkObserver;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(120, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextCreateWebSocketParams(int version) {
      super(120, version);
    }

    public NetworkContextCreateWebSocketParams() {
      this(0);
    }

    public static NetworkContextCreateWebSocketParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextCreateWebSocketParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextCreateWebSocketParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextCreateWebSocketParams result =
            new NetworkContextCreateWebSocketParams(elementsOrVersion);
        result.url = Url.decode(decoder0.readPointer(8, false));
        Decoder decoder1 = decoder0.readPointer(16, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.requestedProtocols = new String[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          result.requestedProtocols[i1] = decoder1.readString((i1 * 8) + 8, false);
        }
        result.siteForCookies = SiteForCookies.decode(decoder0.readPointer(24, false));
        result.hasStorageAccess = decoder0.readBoolean(32, 0);
        result.processId = decoder0.readInt(36);
        result.isolationInfo = IsolationInfo.decode(decoder0.readPointer(40, false));
        Decoder decoder12 = decoder0.readPointer(48, false);
        DataHeader si12 = decoder12.readDataHeaderForPointerArray(-1);
        result.additionalHeaders = new HttpHeader[si12.elementsOrVersion];
        for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
          Decoder decoder2 = decoder12.readPointer((i12 * 8) + 8, false);
          result.additionalHeaders[i12] = HttpHeader.decode(decoder2);
        }
        result.origin = Origin.decode(decoder0.readPointer(56, false));
        result.options = decoder0.readInt(64);
        result.trafficAnnotation =
            MutableNetworkTrafficAnnotationTag.decode(decoder0.readPointer(72, false));
        result.handshakeClient =
            (WebSocketHandshakeClient)
                decoder0.readServiceInterface(80, false, WebSocketHandshakeClient.MANAGER);
        result.urlLoaderNetworkObserver =
            (UrlLoaderNetworkServiceObserver)
                decoder0.readServiceInterface(88, true, UrlLoaderNetworkServiceObserver.MANAGER);
        result.authHandler =
            (WebSocketAuthenticationHandler)
                decoder0.readServiceInterface(96, true, WebSocketAuthenticationHandler.MANAGER);
        result.headerClient =
            (TrustedHeaderClient)
                decoder0.readServiceInterface(104, true, TrustedHeaderClient.MANAGER);
        result.throttlingProfileId = UnguessableToken.decode(decoder0.readPointer(112, true));
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.url, 8, false);
      String[] strArr = this.requestedProtocols;
      if (strArr == null) {
        encoder0.encodeNullPointer(16, false);
      } else {
        Encoder encoder1 = encoder0.encodePointerArray(strArr.length, 16, -1);
        int i0 = 0;
        while (true) {
          String[] strArr2 = this.requestedProtocols;
          if (i0 >= strArr2.length) {
            break;
          }
          encoder1.encode(strArr2[i0], (i0 * 8) + 8, false);
          i0++;
        }
      }
      encoder0.encode((Struct) this.siteForCookies, 24, false);
      encoder0.encode(this.hasStorageAccess, 32, 0);
      encoder0.encode(this.processId, 36);
      encoder0.encode((Struct) this.isolationInfo, 40, false);
      HttpHeader[] httpHeaderArr = this.additionalHeaders;
      if (httpHeaderArr == null) {
        encoder0.encodeNullPointer(48, false);
      } else {
        Encoder encoder12 = encoder0.encodePointerArray(httpHeaderArr.length, 48, -1);
        int i02 = 0;
        while (true) {
          HttpHeader[] httpHeaderArr2 = this.additionalHeaders;
          if (i02 >= httpHeaderArr2.length) {
            break;
          }
          encoder12.encode((Struct) httpHeaderArr2[i02], (i02 * 8) + 8, false);
          i02++;
        }
      }
      encoder0.encode((Struct) this.origin, 56, false);
      encoder0.encode(this.options, 64);
      encoder0.encode((Struct) this.trafficAnnotation, 72, false);
      encoder0.encode(this.handshakeClient, 80, false, WebSocketHandshakeClient.MANAGER);
      encoder0.encode(
          this.urlLoaderNetworkObserver, 88, true, UrlLoaderNetworkServiceObserver.MANAGER);
      encoder0.encode(this.authHandler, 96, true, WebSocketAuthenticationHandler.MANAGER);
      encoder0.encode(this.headerClient, 104, true, TrustedHeaderClient.MANAGER);
      encoder0.encode((Struct) this.throttlingProfileId, 112, true);
    }
  }

  static final class NetworkContextCreateWebTransportParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 56;
    private static final DataHeader[] VERSION_ARRAY;
    public WebTransportCertificateFingerprint[] fingerprints;
    public WebTransportHandshakeClient handshakeClient;
    public NetworkAnonymizationKey networkAnonymizationKey;
    public Origin origin;
    public Url url;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(56, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextCreateWebTransportParams(int version) {
      super(56, version);
    }

    public NetworkContextCreateWebTransportParams() {
      this(0);
    }

    public static NetworkContextCreateWebTransportParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextCreateWebTransportParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextCreateWebTransportParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextCreateWebTransportParams result =
            new NetworkContextCreateWebTransportParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.url = Url.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.origin = Origin.decode(decoder12);
        result.networkAnonymizationKey = NetworkAnonymizationKey.decode(decoder0, 24);
        Decoder decoder13 = decoder0.readPointer(40, false);
        DataHeader si1 = decoder13.readDataHeaderForPointerArray(-1);
        result.fingerprints = new WebTransportCertificateFingerprint[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder13.readPointer((i1 * 8) + 8, false);
          result.fingerprints[i1] = WebTransportCertificateFingerprint.decode(decoder2);
        }
        result.handshakeClient =
            (WebTransportHandshakeClient)
                decoder0.readServiceInterface(48, false, WebTransportHandshakeClient.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.url, 8, false);
      encoder0.encode((Struct) this.origin, 16, false);
      encoder0.encode((Union) this.networkAnonymizationKey, 24, false);
      WebTransportCertificateFingerprint[] webTransportCertificateFingerprintArr =
          this.fingerprints;
      if (webTransportCertificateFingerprintArr == null) {
        encoder0.encodeNullPointer(40, false);
      } else {
        Encoder encoder1 =
            encoder0.encodePointerArray(webTransportCertificateFingerprintArr.length, 40, -1);
        int i0 = 0;
        while (true) {
          WebTransportCertificateFingerprint[] webTransportCertificateFingerprintArr2 =
              this.fingerprints;
          if (i0 >= webTransportCertificateFingerprintArr2.length) {
            break;
          }
          encoder1.encode((Struct) webTransportCertificateFingerprintArr2[i0], (i0 * 8) + 8, false);
          i0++;
        }
      }
      encoder0.encode(this.handshakeClient, 48, false, WebTransportHandshakeClient.MANAGER);
    }
  }

  static final class NetworkContextCreateNetLogExporterParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<NetLogExporter> receiver;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextCreateNetLogExporterParams(int version) {
      super(16, version);
    }

    public NetworkContextCreateNetLogExporterParams() {
      this(0);
    }

    public static NetworkContextCreateNetLogExporterParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextCreateNetLogExporterParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextCreateNetLogExporterParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextCreateNetLogExporterParams result =
            new NetworkContextCreateNetLogExporterParams(elementsOrVersion);
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

  static final class NetworkContextPreconnectSocketsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public int credentialsMode;
    public NetworkAnonymizationKey networkAnonymizationKey;
    public int numStreams;
    public Url url;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextPreconnectSocketsParams(int version) {
      super(40, version);
    }

    public NetworkContextPreconnectSocketsParams() {
      this(0);
    }

    public static NetworkContextPreconnectSocketsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextPreconnectSocketsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextPreconnectSocketsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextPreconnectSocketsParams result =
            new NetworkContextPreconnectSocketsParams(elementsOrVersion);
        result.numStreams = decoder0.readInt(8);
        int readInt = decoder0.readInt(12);
        result.credentialsMode = readInt;
        CredentialsMode.validate(readInt);
        result.credentialsMode = CredentialsMode.toKnownValue(result.credentialsMode);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.url = Url.decode(decoder1);
        result.networkAnonymizationKey = NetworkAnonymizationKey.decode(decoder0, 24);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.numStreams, 8);
      encoder0.encode(this.credentialsMode, 12);
      encoder0.encode((Struct) this.url, 16, false);
      encoder0.encode((Union) this.networkAnonymizationKey, 24, false);
    }
  }

  static final class NetworkContextCreateP2pSocketManagerParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public P2pTrustedSocketManagerClient client;
    public NetworkAnonymizationKey networkAnonymizationKey;
    public InterfaceRequest<P2pSocketManager> socketManager;
    public InterfaceRequest<P2pTrustedSocketManager> trustedSocketManager;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextCreateP2pSocketManagerParams(int version) {
      super(40, version);
    }

    public NetworkContextCreateP2pSocketManagerParams() {
      this(0);
    }

    public static NetworkContextCreateP2pSocketManagerParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextCreateP2pSocketManagerParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextCreateP2pSocketManagerParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextCreateP2pSocketManagerParams result =
            new NetworkContextCreateP2pSocketManagerParams(elementsOrVersion);
        result.networkAnonymizationKey = NetworkAnonymizationKey.decode(decoder0, 8);
        result.client =
            (P2pTrustedSocketManagerClient)
                decoder0.readServiceInterface(24, false, P2pTrustedSocketManagerClient.MANAGER);
        result.trustedSocketManager = decoder0.readInterfaceRequest(32, false);
        result.socketManager = decoder0.readInterfaceRequest(36, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Union) this.networkAnonymizationKey, 8, false);
      encoder0.encode(this.client, 24, false, P2pTrustedSocketManagerClient.MANAGER);
      encoder0.encode((InterfaceRequest) this.trustedSocketManager, 32, false);
      encoder0.encode((InterfaceRequest) this.socketManager, 36, false);
    }
  }

  static final class NetworkContextCreateMdnsResponderParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<MdnsResponder> responderReceiver;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextCreateMdnsResponderParams(int version) {
      super(16, version);
    }

    public NetworkContextCreateMdnsResponderParams() {
      this(0);
    }

    public static NetworkContextCreateMdnsResponderParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextCreateMdnsResponderParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextCreateMdnsResponderParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextCreateMdnsResponderParams result =
            new NetworkContextCreateMdnsResponderParams(elementsOrVersion);
        result.responderReceiver = decoder0.readInterfaceRequest(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.responderReceiver, 8, false);
    }
  }

  static final class NetworkContextResolveHostParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 56;
    private static final DataHeader[] VERSION_ARRAY;
    public HostResolverHost host;
    public NetworkAnonymizationKey networkAnonymizationKey;
    public ResolveHostParameters optionalParameters;
    public ResolveHostClient responseClient;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(56, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextResolveHostParams(int version) {
      super(56, version);
    }

    public NetworkContextResolveHostParams() {
      this(0);
    }

    public static NetworkContextResolveHostParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextResolveHostParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextResolveHostParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextResolveHostParams result =
            new NetworkContextResolveHostParams(elementsOrVersion);
        result.host = HostResolverHost.decode(decoder0, 8);
        result.networkAnonymizationKey = NetworkAnonymizationKey.decode(decoder0, 24);
        Decoder decoder1 = decoder0.readPointer(40, true);
        result.optionalParameters = ResolveHostParameters.decode(decoder1);
        result.responseClient =
            (ResolveHostClient) decoder0.readServiceInterface(48, false, ResolveHostClient.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Union) this.host, 8, false);
      encoder0.encode((Union) this.networkAnonymizationKey, 24, false);
      encoder0.encode((Struct) this.optionalParameters, 40, true);
      encoder0.encode(this.responseClient, 48, false, ResolveHostClient.MANAGER);
    }
  }

  static final class NetworkContextCreateHostResolverParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public DnsConfigOverrides configOverrides;
    public InterfaceRequest<HostResolver> hostResolver;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextCreateHostResolverParams(int version) {
      super(24, version);
    }

    public NetworkContextCreateHostResolverParams() {
      this(0);
    }

    public static NetworkContextCreateHostResolverParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextCreateHostResolverParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextCreateHostResolverParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextCreateHostResolverParams result =
            new NetworkContextCreateHostResolverParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.configOverrides = DnsConfigOverrides.decode(decoder1);
        result.hostResolver = decoder0.readInterfaceRequest(16, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.configOverrides, 8, true);
      encoder0.encode((InterfaceRequest) this.hostResolver, 16, false);
    }
  }

  static final class NetworkContextVerifyCertForSignedExchangeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public X509Certificate certificate;
    public String ocspResponse;
    public String sctList;
    public Url url;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextVerifyCertForSignedExchangeParams(int version) {
      super(40, version);
    }

    public NetworkContextVerifyCertForSignedExchangeParams() {
      this(0);
    }

    public static NetworkContextVerifyCertForSignedExchangeParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextVerifyCertForSignedExchangeParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextVerifyCertForSignedExchangeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextVerifyCertForSignedExchangeParams result =
            new NetworkContextVerifyCertForSignedExchangeParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.certificate = X509Certificate.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.url = Url.decode(decoder12);
        result.ocspResponse = decoder0.readString(24, false);
        result.sctList = decoder0.readString(32, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.certificate, 8, false);
      encoder0.encode((Struct) this.url, 16, false);
      encoder0.encode(this.ocspResponse, 24, false);
      encoder0.encode(this.sctList, 32, false);
    }
  }

  static final class NetworkContextVerifyCertForSignedExchangeResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public CertVerifyResult cvResult;
    public int errorCode;
    public boolean pkpBypassed;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextVerifyCertForSignedExchangeResponseParams(int version) {
      super(24, version);
    }

    public NetworkContextVerifyCertForSignedExchangeResponseParams() {
      this(0);
    }

    public static NetworkContextVerifyCertForSignedExchangeResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextVerifyCertForSignedExchangeResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextVerifyCertForSignedExchangeResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextVerifyCertForSignedExchangeResponseParams result =
            new NetworkContextVerifyCertForSignedExchangeResponseParams(elementsOrVersion);
        result.errorCode = decoder0.readInt(8);
        result.pkpBypassed = decoder0.readBoolean(12, 0);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.cvResult = CertVerifyResult.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.errorCode, 8);
      encoder0.encode(this.pkpBypassed, 12, 0);
      encoder0.encode((Struct) this.cvResult, 16, false);
    }
  }

  static class NetworkContextVerifyCertForSignedExchangeResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NetworkContext.VerifyCertForSignedExchange_Response mCallback;

    NetworkContextVerifyCertForSignedExchangeResponseParamsForwardToCallback(
        NetworkContext.VerifyCertForSignedExchange_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(52, 2)) {
          return false;
        }
        NetworkContextVerifyCertForSignedExchangeResponseParams response =
            NetworkContextVerifyCertForSignedExchangeResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.errorCode, response.cvResult, response.pkpBypassed);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NetworkContextVerifyCertForSignedExchangeResponseParamsProxyToResponder
      implements NetworkContext.VerifyCertForSignedExchange_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkContextVerifyCertForSignedExchangeResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int errorCode, CertVerifyResult cvResult, boolean pkpBypassed) {
      NetworkContextVerifyCertForSignedExchangeResponseParams _response =
          new NetworkContextVerifyCertForSignedExchangeResponseParams();
      _response.errorCode = errorCode;
      _response.cvResult = cvResult;
      _response.pkpBypassed = pkpBypassed;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(52, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkContextAddHstsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public Time expiry;
    public String host;
    public boolean includeSubdomains;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextAddHstsParams(int version) {
      super(32, version);
    }

    public NetworkContextAddHstsParams() {
      this(0);
    }

    public static NetworkContextAddHstsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextAddHstsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextAddHstsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextAddHstsParams result = new NetworkContextAddHstsParams(elementsOrVersion);
        result.host = decoder0.readString(8, false);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.expiry = Time.decode(decoder1);
        result.includeSubdomains = decoder0.readBoolean(24, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.host, 8, false);
      encoder0.encode((Struct) this.expiry, 16, false);
      encoder0.encode(this.includeSubdomains, 24, 0);
    }
  }

  static final class NetworkContextAddHstsResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextAddHstsResponseParams(int version) {
      super(8, version);
    }

    public NetworkContextAddHstsResponseParams() {
      this(0);
    }

    public static NetworkContextAddHstsResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextAddHstsResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextAddHstsResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextAddHstsResponseParams result =
            new NetworkContextAddHstsResponseParams(elementsOrVersion);
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

  static class NetworkContextAddHstsResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final NetworkContext.AddHsts_Response mCallback;

    NetworkContextAddHstsResponseParamsForwardToCallback(NetworkContext.AddHsts_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(53, 2)) {
          return false;
        }
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NetworkContextAddHstsResponseParamsProxyToResponder
      implements NetworkContext.AddHsts_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkContextAddHstsResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      NetworkContextAddHstsResponseParams _response = new NetworkContextAddHstsResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(53, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkContextIsHstsActiveForHostParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String host;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextIsHstsActiveForHostParams(int version) {
      super(16, version);
    }

    public NetworkContextIsHstsActiveForHostParams() {
      this(0);
    }

    public static NetworkContextIsHstsActiveForHostParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextIsHstsActiveForHostParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextIsHstsActiveForHostParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextIsHstsActiveForHostParams result =
            new NetworkContextIsHstsActiveForHostParams(elementsOrVersion);
        result.host = decoder0.readString(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.host, 8, false);
    }
  }

  static final class NetworkContextIsHstsActiveForHostResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextIsHstsActiveForHostResponseParams(int version) {
      super(16, version);
    }

    public NetworkContextIsHstsActiveForHostResponseParams() {
      this(0);
    }

    public static NetworkContextIsHstsActiveForHostResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextIsHstsActiveForHostResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextIsHstsActiveForHostResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextIsHstsActiveForHostResponseParams result =
            new NetworkContextIsHstsActiveForHostResponseParams(elementsOrVersion);
        result.result = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.result, 8, 0);
    }
  }

  static class NetworkContextIsHstsActiveForHostResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NetworkContext.IsHstsActiveForHost_Response mCallback;

    NetworkContextIsHstsActiveForHostResponseParamsForwardToCallback(
        NetworkContext.IsHstsActiveForHost_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(54, 2)) {
          return false;
        }
        NetworkContextIsHstsActiveForHostResponseParams response =
            NetworkContextIsHstsActiveForHostResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NetworkContextIsHstsActiveForHostResponseParamsProxyToResponder
      implements NetworkContext.IsHstsActiveForHost_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkContextIsHstsActiveForHostResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean result) {
      NetworkContextIsHstsActiveForHostResponseParams _response =
          new NetworkContextIsHstsActiveForHostResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(54, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkContextGetHstsStateParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String domain;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextGetHstsStateParams(int version) {
      super(16, version);
    }

    public NetworkContextGetHstsStateParams() {
      this(0);
    }

    public static NetworkContextGetHstsStateParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextGetHstsStateParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextGetHstsStateParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextGetHstsStateParams result =
            new NetworkContextGetHstsStateParams(elementsOrVersion);
        result.domain = decoder0.readString(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.domain, 8, false);
    }
  }

  static final class NetworkContextGetHstsStateResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public DictionaryValue state;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextGetHstsStateResponseParams(int version) {
      super(16, version);
    }

    public NetworkContextGetHstsStateResponseParams() {
      this(0);
    }

    public static NetworkContextGetHstsStateResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextGetHstsStateResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextGetHstsStateResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextGetHstsStateResponseParams result =
            new NetworkContextGetHstsStateResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.state = DictionaryValue.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.state, 8, false);
    }
  }

  static class NetworkContextGetHstsStateResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NetworkContext.GetHstsState_Response mCallback;

    NetworkContextGetHstsStateResponseParamsForwardToCallback(
        NetworkContext.GetHstsState_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(55, 2)) {
          return false;
        }
        NetworkContextGetHstsStateResponseParams response =
            NetworkContextGetHstsStateResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.state);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NetworkContextGetHstsStateResponseParamsProxyToResponder
      implements NetworkContext.GetHstsState_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkContextGetHstsStateResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(DictionaryValue state) {
      NetworkContextGetHstsStateResponseParams _response =
          new NetworkContextGetHstsStateResponseParams();
      _response.state = state;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(55, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkContextSetCorsOriginAccessListsForOriginParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public CorsOriginPattern[] allowPatterns;
    public CorsOriginPattern[] blockPatterns;
    public Origin sourceOrigin;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextSetCorsOriginAccessListsForOriginParams(int version) {
      super(32, version);
    }

    public NetworkContextSetCorsOriginAccessListsForOriginParams() {
      this(0);
    }

    public static NetworkContextSetCorsOriginAccessListsForOriginParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextSetCorsOriginAccessListsForOriginParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextSetCorsOriginAccessListsForOriginParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextSetCorsOriginAccessListsForOriginParams result =
            new NetworkContextSetCorsOriginAccessListsForOriginParams(elementsOrVersion);
        result.sourceOrigin = Origin.decode(decoder0.readPointer(8, false));
        Decoder decoder1 = decoder0.readPointer(16, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.allowPatterns = new CorsOriginPattern[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.allowPatterns[i1] = CorsOriginPattern.decode(decoder2);
        }
        Decoder decoder12 = decoder0.readPointer(24, false);
        DataHeader si12 = decoder12.readDataHeaderForPointerArray(-1);
        result.blockPatterns = new CorsOriginPattern[si12.elementsOrVersion];
        for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
          Decoder decoder22 = decoder12.readPointer((i12 * 8) + 8, false);
          result.blockPatterns[i12] = CorsOriginPattern.decode(decoder22);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.sourceOrigin, 8, false);
      CorsOriginPattern[] corsOriginPatternArr = this.allowPatterns;
      if (corsOriginPatternArr == null) {
        encoder0.encodeNullPointer(16, false);
      } else {
        Encoder encoder1 = encoder0.encodePointerArray(corsOriginPatternArr.length, 16, -1);
        int i0 = 0;
        while (true) {
          CorsOriginPattern[] corsOriginPatternArr2 = this.allowPatterns;
          if (i0 >= corsOriginPatternArr2.length) {
            break;
          }
          encoder1.encode((Struct) corsOriginPatternArr2[i0], (i0 * 8) + 8, false);
          i0++;
        }
      }
      CorsOriginPattern[] corsOriginPatternArr3 = this.blockPatterns;
      if (corsOriginPatternArr3 == null) {
        encoder0.encodeNullPointer(24, false);
        return;
      }
      Encoder encoder12 = encoder0.encodePointerArray(corsOriginPatternArr3.length, 24, -1);
      int i02 = 0;
      while (true) {
        CorsOriginPattern[] corsOriginPatternArr4 = this.blockPatterns;
        if (i02 < corsOriginPatternArr4.length) {
          encoder12.encode((Struct) corsOriginPatternArr4[i02], (i02 * 8) + 8, false);
          i02++;
        } else {
          return;
        }
      }
    }
  }

  static final class NetworkContextSetCorsOriginAccessListsForOriginResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextSetCorsOriginAccessListsForOriginResponseParams(int version) {
      super(8, version);
    }

    public NetworkContextSetCorsOriginAccessListsForOriginResponseParams() {
      this(0);
    }

    public static NetworkContextSetCorsOriginAccessListsForOriginResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextSetCorsOriginAccessListsForOriginResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextSetCorsOriginAccessListsForOriginResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextSetCorsOriginAccessListsForOriginResponseParams result =
            new NetworkContextSetCorsOriginAccessListsForOriginResponseParams(elementsOrVersion);
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

  static class NetworkContextSetCorsOriginAccessListsForOriginResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NetworkContext.SetCorsOriginAccessListsForOrigin_Response mCallback;

    NetworkContextSetCorsOriginAccessListsForOriginResponseParamsForwardToCallback(
        NetworkContext.SetCorsOriginAccessListsForOrigin_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(56, 2)) {
          return false;
        }
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NetworkContextSetCorsOriginAccessListsForOriginResponseParamsProxyToResponder
      implements NetworkContext.SetCorsOriginAccessListsForOrigin_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkContextSetCorsOriginAccessListsForOriginResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      NetworkContextSetCorsOriginAccessListsForOriginResponseParams _response =
          new NetworkContextSetCorsOriginAccessListsForOriginResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(56, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkContextDeleteDynamicDataForHostParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String host;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextDeleteDynamicDataForHostParams(int version) {
      super(16, version);
    }

    public NetworkContextDeleteDynamicDataForHostParams() {
      this(0);
    }

    public static NetworkContextDeleteDynamicDataForHostParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextDeleteDynamicDataForHostParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextDeleteDynamicDataForHostParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextDeleteDynamicDataForHostParams result =
            new NetworkContextDeleteDynamicDataForHostParams(elementsOrVersion);
        result.host = decoder0.readString(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.host, 8, false);
    }
  }

  static final class NetworkContextDeleteDynamicDataForHostResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextDeleteDynamicDataForHostResponseParams(int version) {
      super(16, version);
    }

    public NetworkContextDeleteDynamicDataForHostResponseParams() {
      this(0);
    }

    public static NetworkContextDeleteDynamicDataForHostResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextDeleteDynamicDataForHostResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextDeleteDynamicDataForHostResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextDeleteDynamicDataForHostResponseParams result =
            new NetworkContextDeleteDynamicDataForHostResponseParams(elementsOrVersion);
        result.result = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.result, 8, 0);
    }
  }

  static class NetworkContextDeleteDynamicDataForHostResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NetworkContext.DeleteDynamicDataForHost_Response mCallback;

    NetworkContextDeleteDynamicDataForHostResponseParamsForwardToCallback(
        NetworkContext.DeleteDynamicDataForHost_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(57, 2)) {
          return false;
        }
        NetworkContextDeleteDynamicDataForHostResponseParams response =
            NetworkContextDeleteDynamicDataForHostResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NetworkContextDeleteDynamicDataForHostResponseParamsProxyToResponder
      implements NetworkContext.DeleteDynamicDataForHost_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkContextDeleteDynamicDataForHostResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean result) {
      NetworkContextDeleteDynamicDataForHostResponseParams _response =
          new NetworkContextDeleteDynamicDataForHostResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(57, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkContextSetSplitAuthCacheByNetworkAnonymizationKeyParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean splitAuthCacheByNetworkAnonymizationKey;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextSetSplitAuthCacheByNetworkAnonymizationKeyParams(int version) {
      super(16, version);
    }

    public NetworkContextSetSplitAuthCacheByNetworkAnonymizationKeyParams() {
      this(0);
    }

    public static NetworkContextSetSplitAuthCacheByNetworkAnonymizationKeyParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextSetSplitAuthCacheByNetworkAnonymizationKeyParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextSetSplitAuthCacheByNetworkAnonymizationKeyParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextSetSplitAuthCacheByNetworkAnonymizationKeyParams result =
            new NetworkContextSetSplitAuthCacheByNetworkAnonymizationKeyParams(elementsOrVersion);
        result.splitAuthCacheByNetworkAnonymizationKey = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.splitAuthCacheByNetworkAnonymizationKey, 8, 0);
    }
  }

  static final class NetworkContextSaveHttpAuthCacheProxyEntriesParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextSaveHttpAuthCacheProxyEntriesParams(int version) {
      super(8, version);
    }

    public NetworkContextSaveHttpAuthCacheProxyEntriesParams() {
      this(0);
    }

    public static NetworkContextSaveHttpAuthCacheProxyEntriesParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextSaveHttpAuthCacheProxyEntriesParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextSaveHttpAuthCacheProxyEntriesParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextSaveHttpAuthCacheProxyEntriesParams result =
            new NetworkContextSaveHttpAuthCacheProxyEntriesParams(elementsOrVersion);
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

  static final class NetworkContextSaveHttpAuthCacheProxyEntriesResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public UnguessableToken cacheKey;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextSaveHttpAuthCacheProxyEntriesResponseParams(int version) {
      super(16, version);
    }

    public NetworkContextSaveHttpAuthCacheProxyEntriesResponseParams() {
      this(0);
    }

    public static NetworkContextSaveHttpAuthCacheProxyEntriesResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextSaveHttpAuthCacheProxyEntriesResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextSaveHttpAuthCacheProxyEntriesResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextSaveHttpAuthCacheProxyEntriesResponseParams result =
            new NetworkContextSaveHttpAuthCacheProxyEntriesResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.cacheKey = UnguessableToken.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.cacheKey, 8, false);
    }
  }

  static class NetworkContextSaveHttpAuthCacheProxyEntriesResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NetworkContext.SaveHttpAuthCacheProxyEntries_Response mCallback;

    NetworkContextSaveHttpAuthCacheProxyEntriesResponseParamsForwardToCallback(
        NetworkContext.SaveHttpAuthCacheProxyEntries_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(59, 2)) {
          return false;
        }
        NetworkContextSaveHttpAuthCacheProxyEntriesResponseParams response =
            NetworkContextSaveHttpAuthCacheProxyEntriesResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.cacheKey);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NetworkContextSaveHttpAuthCacheProxyEntriesResponseParamsProxyToResponder
      implements NetworkContext.SaveHttpAuthCacheProxyEntries_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkContextSaveHttpAuthCacheProxyEntriesResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(UnguessableToken cacheKey) {
      NetworkContextSaveHttpAuthCacheProxyEntriesResponseParams _response =
          new NetworkContextSaveHttpAuthCacheProxyEntriesResponseParams();
      _response.cacheKey = cacheKey;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(59, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkContextLoadHttpAuthCacheProxyEntriesParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public UnguessableToken cacheKey;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextLoadHttpAuthCacheProxyEntriesParams(int version) {
      super(16, version);
    }

    public NetworkContextLoadHttpAuthCacheProxyEntriesParams() {
      this(0);
    }

    public static NetworkContextLoadHttpAuthCacheProxyEntriesParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextLoadHttpAuthCacheProxyEntriesParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextLoadHttpAuthCacheProxyEntriesParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextLoadHttpAuthCacheProxyEntriesParams result =
            new NetworkContextLoadHttpAuthCacheProxyEntriesParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.cacheKey = UnguessableToken.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.cacheKey, 8, false);
    }
  }

  static final class NetworkContextLoadHttpAuthCacheProxyEntriesResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextLoadHttpAuthCacheProxyEntriesResponseParams(int version) {
      super(8, version);
    }

    public NetworkContextLoadHttpAuthCacheProxyEntriesResponseParams() {
      this(0);
    }

    public static NetworkContextLoadHttpAuthCacheProxyEntriesResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextLoadHttpAuthCacheProxyEntriesResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextLoadHttpAuthCacheProxyEntriesResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextLoadHttpAuthCacheProxyEntriesResponseParams result =
            new NetworkContextLoadHttpAuthCacheProxyEntriesResponseParams(elementsOrVersion);
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

  static class NetworkContextLoadHttpAuthCacheProxyEntriesResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NetworkContext.LoadHttpAuthCacheProxyEntries_Response mCallback;

    NetworkContextLoadHttpAuthCacheProxyEntriesResponseParamsForwardToCallback(
        NetworkContext.LoadHttpAuthCacheProxyEntries_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(60, 2)) {
          return false;
        }
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NetworkContextLoadHttpAuthCacheProxyEntriesResponseParamsProxyToResponder
      implements NetworkContext.LoadHttpAuthCacheProxyEntries_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkContextLoadHttpAuthCacheProxyEntriesResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      NetworkContextLoadHttpAuthCacheProxyEntriesResponseParams _response =
          new NetworkContextLoadHttpAuthCacheProxyEntriesResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(60, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkContextAddAuthCacheEntryParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public AuthChallengeInfo challenge;
    public AuthCredentials credentials;
    public NetworkAnonymizationKey networkAnonymizationKey;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextAddAuthCacheEntryParams(int version) {
      super(40, version);
    }

    public NetworkContextAddAuthCacheEntryParams() {
      this(0);
    }

    public static NetworkContextAddAuthCacheEntryParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextAddAuthCacheEntryParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextAddAuthCacheEntryParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextAddAuthCacheEntryParams result =
            new NetworkContextAddAuthCacheEntryParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.challenge = AuthChallengeInfo.decode(decoder1);
        result.networkAnonymizationKey = NetworkAnonymizationKey.decode(decoder0, 16);
        Decoder decoder12 = decoder0.readPointer(32, false);
        result.credentials = AuthCredentials.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.challenge, 8, false);
      encoder0.encode((Union) this.networkAnonymizationKey, 16, false);
      encoder0.encode((Struct) this.credentials, 32, false);
    }
  }

  static final class NetworkContextAddAuthCacheEntryResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextAddAuthCacheEntryResponseParams(int version) {
      super(8, version);
    }

    public NetworkContextAddAuthCacheEntryResponseParams() {
      this(0);
    }

    public static NetworkContextAddAuthCacheEntryResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextAddAuthCacheEntryResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextAddAuthCacheEntryResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextAddAuthCacheEntryResponseParams result =
            new NetworkContextAddAuthCacheEntryResponseParams(elementsOrVersion);
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

  static class NetworkContextAddAuthCacheEntryResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NetworkContext.AddAuthCacheEntry_Response mCallback;

    NetworkContextAddAuthCacheEntryResponseParamsForwardToCallback(
        NetworkContext.AddAuthCacheEntry_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(61, 2)) {
          return false;
        }
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NetworkContextAddAuthCacheEntryResponseParamsProxyToResponder
      implements NetworkContext.AddAuthCacheEntry_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkContextAddAuthCacheEntryResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      NetworkContextAddAuthCacheEntryResponseParams _response =
          new NetworkContextAddAuthCacheEntryResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(61, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkContextSetCorsNonWildcardRequestHeadersSupportParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean value;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextSetCorsNonWildcardRequestHeadersSupportParams(int version) {
      super(16, version);
    }

    public NetworkContextSetCorsNonWildcardRequestHeadersSupportParams() {
      this(0);
    }

    public static NetworkContextSetCorsNonWildcardRequestHeadersSupportParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextSetCorsNonWildcardRequestHeadersSupportParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextSetCorsNonWildcardRequestHeadersSupportParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextSetCorsNonWildcardRequestHeadersSupportParams result =
            new NetworkContextSetCorsNonWildcardRequestHeadersSupportParams(elementsOrVersion);
        result.value = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.value, 8, 0);
    }
  }

  static final class NetworkContextLookupServerBasicAuthCredentialsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public NetworkAnonymizationKey networkAnonymizationKey;
    public Url url;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextLookupServerBasicAuthCredentialsParams(int version) {
      super(32, version);
    }

    public NetworkContextLookupServerBasicAuthCredentialsParams() {
      this(0);
    }

    public static NetworkContextLookupServerBasicAuthCredentialsParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextLookupServerBasicAuthCredentialsParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextLookupServerBasicAuthCredentialsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextLookupServerBasicAuthCredentialsParams result =
            new NetworkContextLookupServerBasicAuthCredentialsParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.url = Url.decode(decoder1);
        result.networkAnonymizationKey = NetworkAnonymizationKey.decode(decoder0, 16);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.url, 8, false);
      encoder0.encode((Union) this.networkAnonymizationKey, 16, false);
    }
  }

  static final class NetworkContextLookupServerBasicAuthCredentialsResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public AuthCredentials credentials;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextLookupServerBasicAuthCredentialsResponseParams(int version) {
      super(16, version);
    }

    public NetworkContextLookupServerBasicAuthCredentialsResponseParams() {
      this(0);
    }

    public static NetworkContextLookupServerBasicAuthCredentialsResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextLookupServerBasicAuthCredentialsResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextLookupServerBasicAuthCredentialsResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextLookupServerBasicAuthCredentialsResponseParams result =
            new NetworkContextLookupServerBasicAuthCredentialsResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.credentials = AuthCredentials.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.credentials, 8, true);
    }
  }

  static class NetworkContextLookupServerBasicAuthCredentialsResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NetworkContext.LookupServerBasicAuthCredentials_Response mCallback;

    NetworkContextLookupServerBasicAuthCredentialsResponseParamsForwardToCallback(
        NetworkContext.LookupServerBasicAuthCredentials_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(63, 2)) {
          return false;
        }
        NetworkContextLookupServerBasicAuthCredentialsResponseParams response =
            NetworkContextLookupServerBasicAuthCredentialsResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.credentials);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NetworkContextLookupServerBasicAuthCredentialsResponseParamsProxyToResponder
      implements NetworkContext.LookupServerBasicAuthCredentials_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkContextLookupServerBasicAuthCredentialsResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(AuthCredentials credentials) {
      NetworkContextLookupServerBasicAuthCredentialsResponseParams _response =
          new NetworkContextLookupServerBasicAuthCredentialsResponseParams();
      _response.credentials = credentials;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(63, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkContextEnableStaticKeyPinningForTestingParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextEnableStaticKeyPinningForTestingParams(int version) {
      super(8, version);
    }

    public NetworkContextEnableStaticKeyPinningForTestingParams() {
      this(0);
    }

    public static NetworkContextEnableStaticKeyPinningForTestingParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextEnableStaticKeyPinningForTestingParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextEnableStaticKeyPinningForTestingParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextEnableStaticKeyPinningForTestingParams result =
            new NetworkContextEnableStaticKeyPinningForTestingParams(elementsOrVersion);
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

  static final class NetworkContextEnableStaticKeyPinningForTestingResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextEnableStaticKeyPinningForTestingResponseParams(int version) {
      super(8, version);
    }

    public NetworkContextEnableStaticKeyPinningForTestingResponseParams() {
      this(0);
    }

    public static NetworkContextEnableStaticKeyPinningForTestingResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextEnableStaticKeyPinningForTestingResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextEnableStaticKeyPinningForTestingResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextEnableStaticKeyPinningForTestingResponseParams result =
            new NetworkContextEnableStaticKeyPinningForTestingResponseParams(elementsOrVersion);
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

  static class NetworkContextEnableStaticKeyPinningForTestingResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NetworkContext.EnableStaticKeyPinningForTesting_Response mCallback;

    NetworkContextEnableStaticKeyPinningForTestingResponseParamsForwardToCallback(
        NetworkContext.EnableStaticKeyPinningForTesting_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(64, 6)) {
          return false;
        }
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NetworkContextEnableStaticKeyPinningForTestingResponseParamsProxyToResponder
      implements NetworkContext.EnableStaticKeyPinningForTesting_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkContextEnableStaticKeyPinningForTestingResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      NetworkContextEnableStaticKeyPinningForTestingResponseParams _response =
          new NetworkContextEnableStaticKeyPinningForTestingResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(64, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkContextVerifyCertificateForTestingParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public X509Certificate certificate;
    public String hostname;
    public String ocspResponse;
    public String sctList;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextVerifyCertificateForTestingParams(int version) {
      super(40, version);
    }

    public NetworkContextVerifyCertificateForTestingParams() {
      this(0);
    }

    public static NetworkContextVerifyCertificateForTestingParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextVerifyCertificateForTestingParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextVerifyCertificateForTestingParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextVerifyCertificateForTestingParams result =
            new NetworkContextVerifyCertificateForTestingParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.certificate = X509Certificate.decode(decoder1);
        result.hostname = decoder0.readString(16, false);
        result.ocspResponse = decoder0.readString(24, false);
        result.sctList = decoder0.readString(32, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.certificate, 8, false);
      encoder0.encode(this.hostname, 16, false);
      encoder0.encode(this.ocspResponse, 24, false);
      encoder0.encode(this.sctList, 32, false);
    }
  }

  static final class NetworkContextVerifyCertificateForTestingResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int errorCode;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextVerifyCertificateForTestingResponseParams(int version) {
      super(16, version);
    }

    public NetworkContextVerifyCertificateForTestingResponseParams() {
      this(0);
    }

    public static NetworkContextVerifyCertificateForTestingResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextVerifyCertificateForTestingResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextVerifyCertificateForTestingResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextVerifyCertificateForTestingResponseParams result =
            new NetworkContextVerifyCertificateForTestingResponseParams(elementsOrVersion);
        result.errorCode = decoder0.readInt(8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.errorCode, 8);
    }
  }

  static class NetworkContextVerifyCertificateForTestingResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NetworkContext.VerifyCertificateForTesting_Response mCallback;

    NetworkContextVerifyCertificateForTestingResponseParamsForwardToCallback(
        NetworkContext.VerifyCertificateForTesting_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(65, 2)) {
          return false;
        }
        NetworkContextVerifyCertificateForTestingResponseParams response =
            NetworkContextVerifyCertificateForTestingResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.errorCode);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NetworkContextVerifyCertificateForTestingResponseParamsProxyToResponder
      implements NetworkContext.VerifyCertificateForTesting_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkContextVerifyCertificateForTestingResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int errorCode) {
      NetworkContextVerifyCertificateForTestingResponseParams _response =
          new NetworkContextVerifyCertificateForTestingResponseParams();
      _response.errorCode = errorCode;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(65, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkContextAddDomainReliabilityContextForTestingParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public Origin origin;
    public Url uploadUrl;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextAddDomainReliabilityContextForTestingParams(int version) {
      super(24, version);
    }

    public NetworkContextAddDomainReliabilityContextForTestingParams() {
      this(0);
    }

    public static NetworkContextAddDomainReliabilityContextForTestingParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextAddDomainReliabilityContextForTestingParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextAddDomainReliabilityContextForTestingParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextAddDomainReliabilityContextForTestingParams result =
            new NetworkContextAddDomainReliabilityContextForTestingParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.origin = Origin.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.uploadUrl = Url.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.origin, 8, false);
      encoder0.encode((Struct) this.uploadUrl, 16, false);
    }
  }

  static final class NetworkContextAddDomainReliabilityContextForTestingResponseParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextAddDomainReliabilityContextForTestingResponseParams(int version) {
      super(8, version);
    }

    public NetworkContextAddDomainReliabilityContextForTestingResponseParams() {
      this(0);
    }

    public static NetworkContextAddDomainReliabilityContextForTestingResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextAddDomainReliabilityContextForTestingResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextAddDomainReliabilityContextForTestingResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextAddDomainReliabilityContextForTestingResponseParams result =
            new NetworkContextAddDomainReliabilityContextForTestingResponseParams(
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

  static class NetworkContextAddDomainReliabilityContextForTestingResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NetworkContext.AddDomainReliabilityContextForTesting_Response mCallback;

    NetworkContextAddDomainReliabilityContextForTestingResponseParamsForwardToCallback(
        NetworkContext.AddDomainReliabilityContextForTesting_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(66, 6)) {
          return false;
        }
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NetworkContextAddDomainReliabilityContextForTestingResponseParamsProxyToResponder
      implements NetworkContext.AddDomainReliabilityContextForTesting_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkContextAddDomainReliabilityContextForTestingResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      NetworkContextAddDomainReliabilityContextForTestingResponseParams _response =
          new NetworkContextAddDomainReliabilityContextForTestingResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(66, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkContextForceDomainReliabilityUploadsForTestingParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextForceDomainReliabilityUploadsForTestingParams(int version) {
      super(8, version);
    }

    public NetworkContextForceDomainReliabilityUploadsForTestingParams() {
      this(0);
    }

    public static NetworkContextForceDomainReliabilityUploadsForTestingParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextForceDomainReliabilityUploadsForTestingParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextForceDomainReliabilityUploadsForTestingParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextForceDomainReliabilityUploadsForTestingParams result =
            new NetworkContextForceDomainReliabilityUploadsForTestingParams(elementsOrVersion);
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

  static final class NetworkContextForceDomainReliabilityUploadsForTestingResponseParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextForceDomainReliabilityUploadsForTestingResponseParams(int version) {
      super(8, version);
    }

    public NetworkContextForceDomainReliabilityUploadsForTestingResponseParams() {
      this(0);
    }

    public static NetworkContextForceDomainReliabilityUploadsForTestingResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextForceDomainReliabilityUploadsForTestingResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextForceDomainReliabilityUploadsForTestingResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextForceDomainReliabilityUploadsForTestingResponseParams result =
            new NetworkContextForceDomainReliabilityUploadsForTestingResponseParams(
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

  static class NetworkContextForceDomainReliabilityUploadsForTestingResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NetworkContext.ForceDomainReliabilityUploadsForTesting_Response mCallback;

    NetworkContextForceDomainReliabilityUploadsForTestingResponseParamsForwardToCallback(
        NetworkContext.ForceDomainReliabilityUploadsForTesting_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(67, 6)) {
          return false;
        }
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NetworkContextForceDomainReliabilityUploadsForTestingResponseParamsProxyToResponder
      implements NetworkContext.ForceDomainReliabilityUploadsForTesting_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkContextForceDomainReliabilityUploadsForTestingResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      NetworkContextForceDomainReliabilityUploadsForTestingResponseParams _response =
          new NetworkContextForceDomainReliabilityUploadsForTestingResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(67, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkContextSetSctAuditingModeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int mode;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextSetSctAuditingModeParams(int version) {
      super(16, version);
    }

    public NetworkContextSetSctAuditingModeParams() {
      this(0);
    }

    public static NetworkContextSetSctAuditingModeParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextSetSctAuditingModeParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextSetSctAuditingModeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextSetSctAuditingModeParams result =
            new NetworkContextSetSctAuditingModeParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.mode = readInt;
        SctAuditingMode.validate(readInt);
        result.mode = SctAuditingMode.toKnownValue(result.mode);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.mode, 8);
    }
  }

  static final class NetworkContextAddReportingApiObserverParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public ReportingApiObserver observer;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextAddReportingApiObserverParams(int version) {
      super(16, version);
    }

    public NetworkContextAddReportingApiObserverParams() {
      this(0);
    }

    public static NetworkContextAddReportingApiObserverParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextAddReportingApiObserverParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextAddReportingApiObserverParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextAddReportingApiObserverParams result =
            new NetworkContextAddReportingApiObserverParams(elementsOrVersion);
        result.observer =
            (ReportingApiObserver)
                decoder0.readServiceInterface(8, false, ReportingApiObserver.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.observer, 8, false, ReportingApiObserver.MANAGER);
    }
  }

  static final class NetworkContextGetSharedDictionaryUsageInfoParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextGetSharedDictionaryUsageInfoParams(int version) {
      super(8, version);
    }

    public NetworkContextGetSharedDictionaryUsageInfoParams() {
      this(0);
    }

    public static NetworkContextGetSharedDictionaryUsageInfoParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextGetSharedDictionaryUsageInfoParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextGetSharedDictionaryUsageInfoParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextGetSharedDictionaryUsageInfoParams result =
            new NetworkContextGetSharedDictionaryUsageInfoParams(elementsOrVersion);
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

  static final class NetworkContextGetSharedDictionaryUsageInfoResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public SharedDictionaryUsageInfo[] usageInfo;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextGetSharedDictionaryUsageInfoResponseParams(int version) {
      super(16, version);
    }

    public NetworkContextGetSharedDictionaryUsageInfoResponseParams() {
      this(0);
    }

    public static NetworkContextGetSharedDictionaryUsageInfoResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextGetSharedDictionaryUsageInfoResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextGetSharedDictionaryUsageInfoResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextGetSharedDictionaryUsageInfoResponseParams result =
            new NetworkContextGetSharedDictionaryUsageInfoResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.usageInfo = new SharedDictionaryUsageInfo[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.usageInfo[i1] = SharedDictionaryUsageInfo.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      SharedDictionaryUsageInfo[] sharedDictionaryUsageInfoArr = this.usageInfo;
      if (sharedDictionaryUsageInfoArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(sharedDictionaryUsageInfoArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        SharedDictionaryUsageInfo[] sharedDictionaryUsageInfoArr2 = this.usageInfo;
        if (i0 < sharedDictionaryUsageInfoArr2.length) {
          encoder1.encode((Struct) sharedDictionaryUsageInfoArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static class NetworkContextGetSharedDictionaryUsageInfoResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NetworkContext.GetSharedDictionaryUsageInfo_Response mCallback;

    NetworkContextGetSharedDictionaryUsageInfoResponseParamsForwardToCallback(
        NetworkContext.GetSharedDictionaryUsageInfo_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(70, 2)) {
          return false;
        }
        NetworkContextGetSharedDictionaryUsageInfoResponseParams response =
            NetworkContextGetSharedDictionaryUsageInfoResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.usageInfo);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NetworkContextGetSharedDictionaryUsageInfoResponseParamsProxyToResponder
      implements NetworkContext.GetSharedDictionaryUsageInfo_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkContextGetSharedDictionaryUsageInfoResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(SharedDictionaryUsageInfo[] usageInfo) {
      NetworkContextGetSharedDictionaryUsageInfoResponseParams _response =
          new NetworkContextGetSharedDictionaryUsageInfoResponseParams();
      _response.usageInfo = usageInfo;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(70, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkContextGetSharedDictionaryInfoParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public SharedDictionaryIsolationKey isolationKey;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextGetSharedDictionaryInfoParams(int version) {
      super(16, version);
    }

    public NetworkContextGetSharedDictionaryInfoParams() {
      this(0);
    }

    public static NetworkContextGetSharedDictionaryInfoParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextGetSharedDictionaryInfoParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextGetSharedDictionaryInfoParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextGetSharedDictionaryInfoParams result =
            new NetworkContextGetSharedDictionaryInfoParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.isolationKey = SharedDictionaryIsolationKey.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.isolationKey, 8, false);
    }
  }

  static final class NetworkContextGetSharedDictionaryInfoResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public SharedDictionaryInfo[] dictionaries;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextGetSharedDictionaryInfoResponseParams(int version) {
      super(16, version);
    }

    public NetworkContextGetSharedDictionaryInfoResponseParams() {
      this(0);
    }

    public static NetworkContextGetSharedDictionaryInfoResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextGetSharedDictionaryInfoResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextGetSharedDictionaryInfoResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextGetSharedDictionaryInfoResponseParams result =
            new NetworkContextGetSharedDictionaryInfoResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.dictionaries = new SharedDictionaryInfo[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.dictionaries[i1] = SharedDictionaryInfo.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      SharedDictionaryInfo[] sharedDictionaryInfoArr = this.dictionaries;
      if (sharedDictionaryInfoArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(sharedDictionaryInfoArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        SharedDictionaryInfo[] sharedDictionaryInfoArr2 = this.dictionaries;
        if (i0 < sharedDictionaryInfoArr2.length) {
          encoder1.encode((Struct) sharedDictionaryInfoArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static class NetworkContextGetSharedDictionaryInfoResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NetworkContext.GetSharedDictionaryInfo_Response mCallback;

    NetworkContextGetSharedDictionaryInfoResponseParamsForwardToCallback(
        NetworkContext.GetSharedDictionaryInfo_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(71, 2)) {
          return false;
        }
        NetworkContextGetSharedDictionaryInfoResponseParams response =
            NetworkContextGetSharedDictionaryInfoResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.dictionaries);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NetworkContextGetSharedDictionaryInfoResponseParamsProxyToResponder
      implements NetworkContext.GetSharedDictionaryInfo_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkContextGetSharedDictionaryInfoResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(SharedDictionaryInfo[] dictionaries) {
      NetworkContextGetSharedDictionaryInfoResponseParams _response =
          new NetworkContextGetSharedDictionaryInfoResponseParams();
      _response.dictionaries = dictionaries;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(71, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkContextGetSharedDictionaryOriginsBetweenParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public Time endTime;
    public Time startTime;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextGetSharedDictionaryOriginsBetweenParams(int version) {
      super(24, version);
    }

    public NetworkContextGetSharedDictionaryOriginsBetweenParams() {
      this(0);
    }

    public static NetworkContextGetSharedDictionaryOriginsBetweenParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextGetSharedDictionaryOriginsBetweenParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextGetSharedDictionaryOriginsBetweenParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextGetSharedDictionaryOriginsBetweenParams result =
            new NetworkContextGetSharedDictionaryOriginsBetweenParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.startTime = Time.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.endTime = Time.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.startTime, 8, false);
      encoder0.encode((Struct) this.endTime, 16, false);
    }
  }

  static final class NetworkContextGetSharedDictionaryOriginsBetweenResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Origin[] origins;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextGetSharedDictionaryOriginsBetweenResponseParams(int version) {
      super(16, version);
    }

    public NetworkContextGetSharedDictionaryOriginsBetweenResponseParams() {
      this(0);
    }

    public static NetworkContextGetSharedDictionaryOriginsBetweenResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextGetSharedDictionaryOriginsBetweenResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextGetSharedDictionaryOriginsBetweenResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextGetSharedDictionaryOriginsBetweenResponseParams result =
            new NetworkContextGetSharedDictionaryOriginsBetweenResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.origins = new Origin[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.origins[i1] = Origin.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      Origin[] originArr = this.origins;
      if (originArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(originArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        Origin[] originArr2 = this.origins;
        if (i0 < originArr2.length) {
          encoder1.encode((Struct) originArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static class NetworkContextGetSharedDictionaryOriginsBetweenResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NetworkContext.GetSharedDictionaryOriginsBetween_Response mCallback;

    NetworkContextGetSharedDictionaryOriginsBetweenResponseParamsForwardToCallback(
        NetworkContext.GetSharedDictionaryOriginsBetween_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(72, 2)) {
          return false;
        }
        NetworkContextGetSharedDictionaryOriginsBetweenResponseParams response =
            NetworkContextGetSharedDictionaryOriginsBetweenResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.origins);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NetworkContextGetSharedDictionaryOriginsBetweenResponseParamsProxyToResponder
      implements NetworkContext.GetSharedDictionaryOriginsBetween_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkContextGetSharedDictionaryOriginsBetweenResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(Origin[] origins) {
      NetworkContextGetSharedDictionaryOriginsBetweenResponseParams _response =
          new NetworkContextGetSharedDictionaryOriginsBetweenResponseParams();
      _response.origins = origins;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(72, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkContextSetSharedDictionaryCacheMaxSizeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public long cacheMaxSize;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextSetSharedDictionaryCacheMaxSizeParams(int version) {
      super(16, version);
    }

    public NetworkContextSetSharedDictionaryCacheMaxSizeParams() {
      this(0);
    }

    public static NetworkContextSetSharedDictionaryCacheMaxSizeParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextSetSharedDictionaryCacheMaxSizeParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextSetSharedDictionaryCacheMaxSizeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextSetSharedDictionaryCacheMaxSizeParams result =
            new NetworkContextSetSharedDictionaryCacheMaxSizeParams(elementsOrVersion);
        result.cacheMaxSize = decoder0.readLong(8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.cacheMaxSize, 8);
    }
  }

  static final class NetworkContextResourceSchedulerClientVisibilityChangedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public UnguessableToken clientToken;
    public boolean visible;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextResourceSchedulerClientVisibilityChangedParams(int version) {
      super(24, version);
    }

    public NetworkContextResourceSchedulerClientVisibilityChangedParams() {
      this(0);
    }

    public static NetworkContextResourceSchedulerClientVisibilityChangedParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextResourceSchedulerClientVisibilityChangedParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextResourceSchedulerClientVisibilityChangedParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextResourceSchedulerClientVisibilityChangedParams result =
            new NetworkContextResourceSchedulerClientVisibilityChangedParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.clientToken = UnguessableToken.decode(decoder1);
        result.visible = decoder0.readBoolean(16, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.clientToken, 8, false);
      encoder0.encode(this.visible, 16, 0);
    }
  }

  static final class NetworkContextFlushCachedClientCertIfNeededParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public X509Certificate certificate;
    public HostPortPair host;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextFlushCachedClientCertIfNeededParams(int version) {
      super(24, version);
    }

    public NetworkContextFlushCachedClientCertIfNeededParams() {
      this(0);
    }

    public static NetworkContextFlushCachedClientCertIfNeededParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextFlushCachedClientCertIfNeededParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextFlushCachedClientCertIfNeededParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextFlushCachedClientCertIfNeededParams result =
            new NetworkContextFlushCachedClientCertIfNeededParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.host = HostPortPair.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.certificate = X509Certificate.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.host, 8, false);
      encoder0.encode((Struct) this.certificate, 16, false);
    }
  }

  static final class NetworkContextSetCookieDeprecationLabelParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String label;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkContextSetCookieDeprecationLabelParams(int version) {
      super(16, version);
    }

    public NetworkContextSetCookieDeprecationLabelParams() {
      this(0);
    }

    public static NetworkContextSetCookieDeprecationLabelParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkContextSetCookieDeprecationLabelParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextSetCookieDeprecationLabelParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkContextSetCookieDeprecationLabelParams result =
            new NetworkContextSetCookieDeprecationLabelParams(elementsOrVersion);
        result.label = decoder0.readString(8, true);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.label, 8, true);
    }
  }
}
