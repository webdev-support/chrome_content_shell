package org.chromium.network.mojom;

import java.util.Map;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.system.DataPipe;
import org.chromium.mojo_base.mojom.DictionaryValue;
import org.chromium.mojo_base.mojom.Time;
import org.chromium.mojo_base.mojom.UnguessableToken;
import org.chromium.url.internal.mojom.Origin;
import org.chromium.url.mojom.Url;

public interface NetworkContext extends Interface {
  public static final Interface.Manager<NetworkContext, Proxy> MANAGER =
      NetworkContext_Internal.MANAGER;

  public interface AddAuthCacheEntry_Response {
    void call();
  }

  public interface AddDomainReliabilityContextForTesting_Response {
    void call();
  }

  public interface AddHsts_Response {
    void call();
  }

  public interface ClearBadProxiesCache_Response {
    void call();
  }

  public interface ClearCorsPreflightCache_Response {
    void call();
  }

  public interface ClearDomainReliability_Response {
    void call();
  }

  public interface ClearHostCache_Response {
    void call();
  }

  public interface ClearHttpAuthCache_Response {
    void call();
  }

  public interface ClearHttpCache_Response {
    void call();
  }

  public interface ClearNetworkErrorLogging_Response {
    void call();
  }

  public interface ClearNetworkingHistoryBetween_Response {
    void call();
  }

  public interface ClearReportingCacheClients_Response {
    void call();
  }

  public interface ClearReportingCacheReports_Response {
    void call();
  }

  public interface ClearSharedDictionaryCacheForIsolationKey_Response {
    void call();
  }

  public interface ClearSharedDictionaryCache_Response {
    void call();
  }

  public interface ClearTrustTokenData_Response {
    void call();
  }

  public interface ClearTrustTokenSessionOnlyData_Response {
    void call(boolean z);
  }

  public interface CloseAllConnections_Response {
    void call();
  }

  public interface CloseIdleConnections_Response {
    void call();
  }

  public interface ComputeHttpCacheSize_Response {
    void call(boolean z, long j);
  }

  public interface CreateRestrictedUdpSocket_Response {
    void call(int i, IpEndPoint ipEndPoint);
  }

  public interface CreateTcpBoundSocket_Response {
    void call(int i, IpEndPoint ipEndPoint);
  }

  public interface CreateTcpConnectedSocket_Response {
    void call(
        int i,
        IpEndPoint ipEndPoint,
        IpEndPoint ipEndPoint2,
        DataPipe.ConsumerHandle consumerHandle,
        DataPipe.ProducerHandle producerHandle);
  }

  public interface CreateTcpServerSocket_Response {
    void call(int i, IpEndPoint ipEndPoint);
  }

  public interface DeleteDynamicDataForHost_Response {
    void call(boolean z);
  }

  public interface DeleteStoredTrustTokens_Response {
    void call(int i);
  }

  public interface EnableStaticKeyPinningForTesting_Response {
    void call();
  }

  public interface ForceDomainReliabilityUploadsForTesting_Response {
    void call();
  }

  public interface ForceReloadProxyConfig_Response {
    void call();
  }

  public interface GetHstsState_Response {
    void call(DictionaryValue dictionaryValue);
  }

  public interface GetSharedDictionaryInfo_Response {
    void call(SharedDictionaryInfo[] sharedDictionaryInfoArr);
  }

  public interface GetSharedDictionaryOriginsBetween_Response {
    void call(Origin[] originArr);
  }

  public interface GetSharedDictionaryUsageInfo_Response {
    void call(SharedDictionaryUsageInfo[] sharedDictionaryUsageInfoArr);
  }

  public interface GetStoredTrustTokenCounts_Response {
    void call(StoredTrustTokensForIssuer[] storedTrustTokensForIssuerArr);
  }

  public interface IsHstsActiveForHost_Response {
    void call(boolean z);
  }

  public interface LoadHttpAuthCacheProxyEntries_Response {
    void call();
  }

  public interface LookupServerBasicAuthCredentials_Response {
    void call(AuthCredentials authCredentials);
  }

  public interface Proxy extends NetworkContext, Interface.Proxy {}

  public interface SaveHttpAuthCacheProxyEntries_Response {
    void call(UnguessableToken unguessableToken);
  }

  public interface SetCorsOriginAccessListsForOrigin_Response {
    void call();
  }

  public interface VerifyCertForSignedExchange_Response {
    void call(int i, CertVerifyResult certVerifyResult, boolean z);
  }

  public interface VerifyCertificateForTesting_Response {
    void call(int i);
  }

  void addAuthCacheEntry(
      AuthChallengeInfo authChallengeInfo,
      NetworkAnonymizationKey networkAnonymizationKey,
      AuthCredentials authCredentials,
      AddAuthCacheEntry_Response addAuthCacheEntry_Response);

  void addDomainReliabilityContextForTesting(
      Origin origin,
      Url url,
      AddDomainReliabilityContextForTesting_Response
          addDomainReliabilityContextForTesting_Response);

  void addHsts(String str, Time time, boolean z, AddHsts_Response addHsts_Response);

  void addReportingApiObserver(ReportingApiObserver reportingApiObserver);

  void clearBadProxiesCache(ClearBadProxiesCache_Response clearBadProxiesCache_Response);

  void clearCorsPreflightCache(
      ClearDataFilter clearDataFilter,
      ClearCorsPreflightCache_Response clearCorsPreflightCache_Response);

  void clearDomainReliability(
      ClearDataFilter clearDataFilter,
      int i,
      ClearDomainReliability_Response clearDomainReliability_Response);

  void clearHostCache(
      ClearDataFilter clearDataFilter, ClearHostCache_Response clearHostCache_Response);

  void clearHttpAuthCache(
      Time time,
      Time time2,
      ClearDataFilter clearDataFilter,
      ClearHttpAuthCache_Response clearHttpAuthCache_Response);

  void clearHttpCache(
      Time time,
      Time time2,
      ClearDataFilter clearDataFilter,
      ClearHttpCache_Response clearHttpCache_Response);

  void clearNetworkErrorLogging(
      ClearDataFilter clearDataFilter,
      ClearNetworkErrorLogging_Response clearNetworkErrorLogging_Response);

  void clearNetworkingHistoryBetween(
      Time time,
      Time time2,
      ClearNetworkingHistoryBetween_Response clearNetworkingHistoryBetween_Response);

  void clearReportingCacheClients(
      ClearDataFilter clearDataFilter,
      ClearReportingCacheClients_Response clearReportingCacheClients_Response);

  void clearReportingCacheReports(
      ClearDataFilter clearDataFilter,
      ClearReportingCacheReports_Response clearReportingCacheReports_Response);

  void clearSharedDictionaryCache(
      Time time,
      Time time2,
      ClearDataFilter clearDataFilter,
      ClearSharedDictionaryCache_Response clearSharedDictionaryCache_Response);

  void clearSharedDictionaryCacheForIsolationKey(
      SharedDictionaryIsolationKey sharedDictionaryIsolationKey,
      ClearSharedDictionaryCacheForIsolationKey_Response
          clearSharedDictionaryCacheForIsolationKey_Response);

  void clearTrustTokenData(
      ClearDataFilter clearDataFilter, ClearTrustTokenData_Response clearTrustTokenData_Response);

  void clearTrustTokenSessionOnlyData(
      ClearTrustTokenSessionOnlyData_Response clearTrustTokenSessionOnlyData_Response);

  void closeAllConnections(CloseAllConnections_Response closeAllConnections_Response);

  void closeIdleConnections(CloseIdleConnections_Response closeIdleConnections_Response);

  void computeHttpCacheSize(
      Time time, Time time2, ComputeHttpCacheSize_Response computeHttpCacheSize_Response);

  void createHostResolver(
      DnsConfigOverrides dnsConfigOverrides, InterfaceRequest<HostResolver> interfaceRequest);

  void createMdnsResponder(InterfaceRequest<MdnsResponder> interfaceRequest);

  void createNetLogExporter(InterfaceRequest<NetLogExporter> interfaceRequest);

  void createP2pSocketManager(
      NetworkAnonymizationKey networkAnonymizationKey,
      P2pTrustedSocketManagerClient p2pTrustedSocketManagerClient,
      InterfaceRequest<P2pTrustedSocketManager> interfaceRequest,
      InterfaceRequest<P2pSocketManager> interfaceRequest2);

  void createProxyResolvingSocketFactory(
      InterfaceRequest<ProxyResolvingSocketFactory> interfaceRequest);

  void createRestrictedUdpSocket(
      IpEndPoint ipEndPoint,
      int i,
      MutableNetworkTrafficAnnotationTag mutableNetworkTrafficAnnotationTag,
      RestrictedUdpSocketParams restrictedUdpSocketParams,
      InterfaceRequest<RestrictedUdpSocket> interfaceRequest,
      UdpSocketListener udpSocketListener,
      CreateRestrictedUdpSocket_Response createRestrictedUdpSocket_Response);

  void createTcpBoundSocket(
      IpEndPoint ipEndPoint,
      MutableNetworkTrafficAnnotationTag mutableNetworkTrafficAnnotationTag,
      InterfaceRequest<TcpBoundSocket> interfaceRequest,
      CreateTcpBoundSocket_Response createTcpBoundSocket_Response);

  void createTcpConnectedSocket(
      IpEndPoint ipEndPoint,
      AddressList addressList,
      TcpConnectedSocketOptions tcpConnectedSocketOptions,
      MutableNetworkTrafficAnnotationTag mutableNetworkTrafficAnnotationTag,
      InterfaceRequest<TcpConnectedSocket> interfaceRequest,
      SocketObserver socketObserver,
      CreateTcpConnectedSocket_Response createTcpConnectedSocket_Response);

  void createTcpServerSocket(
      IpEndPoint ipEndPoint,
      TcpServerSocketOptions tcpServerSocketOptions,
      MutableNetworkTrafficAnnotationTag mutableNetworkTrafficAnnotationTag,
      InterfaceRequest<TcpServerSocket> interfaceRequest,
      CreateTcpServerSocket_Response createTcpServerSocket_Response);

  void createUdpSocket(
      InterfaceRequest<UdpSocket> interfaceRequest, UdpSocketListener udpSocketListener);

  void createUrlLoaderFactory(
      InterfaceRequest<UrlLoaderFactory> interfaceRequest,
      UrlLoaderFactoryParams urlLoaderFactoryParams);

  void createWebSocket(
      Url url,
      String[] strArr,
      SiteForCookies siteForCookies,
      boolean z,
      IsolationInfo isolationInfo,
      HttpHeader[] httpHeaderArr,
      int i,
      Origin origin,
      int i2,
      MutableNetworkTrafficAnnotationTag mutableNetworkTrafficAnnotationTag,
      WebSocketHandshakeClient webSocketHandshakeClient,
      UrlLoaderNetworkServiceObserver urlLoaderNetworkServiceObserver,
      WebSocketAuthenticationHandler webSocketAuthenticationHandler,
      TrustedHeaderClient trustedHeaderClient,
      UnguessableToken unguessableToken);

  void createWebTransport(
      Url url,
      Origin origin,
      NetworkAnonymizationKey networkAnonymizationKey,
      WebTransportCertificateFingerprint[] webTransportCertificateFingerprintArr,
      WebTransportHandshakeClient webTransportHandshakeClient);

  void deleteDynamicDataForHost(
      String str, DeleteDynamicDataForHost_Response deleteDynamicDataForHost_Response);

  void deleteStoredTrustTokens(
      Origin origin, DeleteStoredTrustTokens_Response deleteStoredTrustTokens_Response);

  void enableStaticKeyPinningForTesting(
      EnableStaticKeyPinningForTesting_Response enableStaticKeyPinningForTesting_Response);

  void flushCachedClientCertIfNeeded(HostPortPair hostPortPair, X509Certificate x509Certificate);

  void forceDomainReliabilityUploadsForTesting(
      ForceDomainReliabilityUploadsForTesting_Response
          forceDomainReliabilityUploadsForTesting_Response);

  void forceReloadProxyConfig(ForceReloadProxyConfig_Response forceReloadProxyConfig_Response);

  void getCookieManager(InterfaceRequest<CookieManager> interfaceRequest);

  void getHstsState(String str, GetHstsState_Response getHstsState_Response);

  void getRestrictedCookieManager(
      InterfaceRequest<RestrictedCookieManager> interfaceRequest,
      int i,
      Origin origin,
      IsolationInfo isolationInfo,
      CookieSettingOverrides cookieSettingOverrides,
      CookieAccessObserver cookieAccessObserver);

  void getSharedDictionaryInfo(
      SharedDictionaryIsolationKey sharedDictionaryIsolationKey,
      GetSharedDictionaryInfo_Response getSharedDictionaryInfo_Response);

  void getSharedDictionaryOriginsBetween(
      Time time,
      Time time2,
      GetSharedDictionaryOriginsBetween_Response getSharedDictionaryOriginsBetween_Response);

  void getSharedDictionaryUsageInfo(
      GetSharedDictionaryUsageInfo_Response getSharedDictionaryUsageInfo_Response);

  void getStoredTrustTokenCounts(
      GetStoredTrustTokenCounts_Response getStoredTrustTokenCounts_Response);

  void getTrustTokenQueryAnswerer(
      InterfaceRequest<TrustTokenQueryAnswerer> interfaceRequest, Origin origin);

  void getViaObliviousHttp(
      ObliviousHttpRequest obliviousHttpRequest, ObliviousHttpClient obliviousHttpClient);

  void isHstsActiveForHost(String str, IsHstsActiveForHost_Response isHstsActiveForHost_Response);

  void loadHttpAuthCacheProxyEntries(
      UnguessableToken unguessableToken,
      LoadHttpAuthCacheProxyEntries_Response loadHttpAuthCacheProxyEntries_Response);

  void lookUpProxyForUrl(
      Url url,
      NetworkAnonymizationKey networkAnonymizationKey,
      ProxyLookupClient proxyLookupClient);

  void lookupServerBasicAuthCredentials(
      Url url,
      NetworkAnonymizationKey networkAnonymizationKey,
      LookupServerBasicAuthCredentials_Response lookupServerBasicAuthCredentials_Response);

  void notifyExternalCacheHit(
      Url url, String str, NetworkIsolationKey networkIsolationKey, boolean z, boolean z2);

  void preconnectSockets(int i, Url url, int i2, NetworkAnonymizationKey networkAnonymizationKey);

  void queueReport(
      String str,
      String str2,
      Url url,
      UnguessableToken unguessableToken,
      NetworkAnonymizationKey networkAnonymizationKey,
      String str3,
      DictionaryValue dictionaryValue);

  void queueSignedExchangeReport(
      SignedExchangeReport signedExchangeReport, NetworkAnonymizationKey networkAnonymizationKey);

  void resetUrlLoaderFactories();

  void resolveHost(
      HostResolverHost hostResolverHost,
      NetworkAnonymizationKey networkAnonymizationKey,
      ResolveHostParameters resolveHostParameters,
      ResolveHostClient resolveHostClient);

  void resourceSchedulerClientVisibilityChanged(UnguessableToken unguessableToken, boolean z);

  void saveHttpAuthCacheProxyEntries(
      SaveHttpAuthCacheProxyEntries_Response saveHttpAuthCacheProxyEntries_Response);

  void sendReportsAndRemoveSource(UnguessableToken unguessableToken);

  void setAcceptLanguage(String str);

  void setBlockTrustTokens(boolean z);

  void setClient(NetworkContextClient networkContextClient);

  void setCookieDeprecationLabel(String str);

  void setCorsNonWildcardRequestHeadersSupport(boolean z);

  void setCorsOriginAccessListsForOrigin(
      Origin origin,
      CorsOriginPattern[] corsOriginPatternArr,
      CorsOriginPattern[] corsOriginPatternArr2,
      SetCorsOriginAccessListsForOrigin_Response setCorsOriginAccessListsForOrigin_Response);

  void setCtPolicy(CtPolicy ctPolicy);

  void setDocumentReportingEndpoints(
      UnguessableToken unguessableToken,
      Origin origin,
      IsolationInfo isolationInfo,
      Map<String, String> map);

  void setEnableReferrers(boolean z);

  void setNetworkConditions(UnguessableToken unguessableToken, NetworkConditions networkConditions);

  void setSctAuditingMode(int i);

  void setSharedDictionaryCacheMaxSize(long j);

  void setSplitAuthCacheByNetworkAnonymizationKey(boolean z);

  void verifyCertForSignedExchange(
      X509Certificate x509Certificate,
      Url url,
      String str,
      String str2,
      VerifyCertForSignedExchange_Response verifyCertForSignedExchange_Response);

  void verifyCertificateForTesting(
      X509Certificate x509Certificate,
      String str,
      String str2,
      String str3,
      VerifyCertificateForTesting_Response verifyCertificateForTesting_Response);

  public static final class DomainReliabilityClearMode {
    public static final int CLEAR_BEACONS = 1;
    public static final int CLEAR_CONTEXTS = 0;
    private static final boolean IS_EXTENSIBLE = false;
    public static final int MAX_VALUE = 1;
    public static final int MIN_VALUE = 0;

    public @interface EnumType {}

    public static boolean isKnownValue(int value) {
      return value >= 0 && value <= 1;
    }

    public static void validate(int value) {
      if (!isKnownValue(value)) {
        throw new DeserializationException("Invalid enum value.");
      }
    }

    public static int toKnownValue(int value) {
      return value;
    }

    private DomainReliabilityClearMode() {}
  }
}
