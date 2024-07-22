package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo_base.mojom.ByteString;
import org.chromium.mojo_base.mojom.DictionaryValue;
import org.chromium.mojo_base.mojom.File;
import org.chromium.mojo_base.mojom.Time;
import org.chromium.url.internal.mojom.Origin;
import org.chromium.url.mojom.Url;

public interface NetworkService extends Interface {
  public static final Interface.Manager<NetworkService, Proxy> MANAGER =
      NetworkService_Internal.MANAGER;

  public interface GetNetworkList_Response {
    void call(NetworkInterface[] networkInterfaceArr);
  }

  public interface ParseHeaders_Response {
    void call(ParsedHeaders parsedHeaders);
  }

  public interface Proxy extends NetworkService, Interface.Proxy {}

  public interface SetCtEnforcementEnabled_Response {
    void call();
  }

  public interface SetTrustTokenKeyCommitments_Response {
    void call();
  }

  public interface UpdateCtKnownPopularScTs_Response {
    void call();
  }

  public interface UpdateCtLogList_Response {
    void call();
  }

  void attachNetLogProxy(
      NetLogProxySource netLogProxySource, InterfaceRequest<NetLogProxySink> interfaceRequest);

  void bindTestInterfaceForTesting(InterfaceRequest<NetworkServiceTest> interfaceRequest);

  void clearSctAuditingCache();

  void configureHttpAuthPrefs(HttpAuthDynamicParams httpAuthDynamicParams);

  void configureSctAuditing(SctAuditingConfiguration sctAuditingConfiguration);

  void configureStubHostResolver(
      boolean z, int i, DnsOverHttpsConfig dnsOverHttpsConfig, boolean z2);

  void createNetworkContext(
      InterfaceRequest<NetworkContext> interfaceRequest, NetworkContextParams networkContextParams);

  void disableQuic();

  void dumpWithoutCrashing(Time time);

  void enableDataUseUpdates(boolean z);

  void getDnsConfigChangeManager(InterfaceRequest<DnsConfigChangeManager> interfaceRequest);

  void getNetworkChangeManager(InterfaceRequest<NetworkChangeManager> interfaceRequest);

  void getNetworkList(int i, GetNetworkList_Response getNetworkList_Response);

  void getNetworkQualityEstimatorManager(
      InterfaceRequest<NetworkQualityEstimatorManager> interfaceRequest);

  void onApplicationStateChange(int i);

  void onClientCertStoreChanged();

  void onMemoryPressure(int i);

  void onPeerToPeerConnectionsCountChange(int i);

  void onTrustStoreChanged();

  void parseHeaders(
      Url url,
      HttpResponseHeaders httpResponseHeaders,
      ParseHeaders_Response parseHeaders_Response);

  void setCtEnforcementEnabled(
      boolean z, SetCtEnforcementEnabled_Response setCtEnforcementEnabled_Response);

  void setEncryptionKey(ByteString byteString);

  void setExplicitlyAllowedPorts(short[] sArr);

  void setFirstPartySets(GlobalFirstPartySets globalFirstPartySets);

  void setIPv6ReachabilityOverride(boolean z);

  void setMaxConnectionsPerProxyChain(int i);

  void setNetworkAnnotationMonitor(NetworkAnnotationMonitor networkAnnotationMonitor);

  void setParams(NetworkServiceParams networkServiceParams);

  void setRawHeadersAccess(int i, Origin[] originArr);

  void setSslKeyLogFile(File file);

  void setTrustTokenKeyCommitments(
      String str, SetTrustTokenKeyCommitments_Response setTrustTokenKeyCommitments_Response);

  void setUpHttpAuth(HttpAuthStaticParams httpAuthStaticParams);

  void startNetLog(File file, long j, int i, DictionaryValue dictionaryValue);

  void updateCtKnownPopularScTs(
      byte[][] bArr, UpdateCtKnownPopularScTs_Response updateCtKnownPopularScTs_Response);

  void updateCtLogList(CtLogInfo[] ctLogInfoArr, UpdateCtLogList_Response updateCtLogList_Response);

  void updateKeyPinsList(PinList pinList, Time time);

  void updateMaskedDomainList(ByteString byteString, String[] strArr);
}
