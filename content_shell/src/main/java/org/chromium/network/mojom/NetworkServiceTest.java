package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.FilePath;
import org.chromium.mojo_base.mojom.TimeDelta;

public interface NetworkServiceTest extends Interface {
  public static final Interface.Manager<NetworkServiceTest, Proxy> MANAGER =
      NetworkServiceTest_Internal.MANAGER;

  public interface AddRules_Response {
    void call();
  }

  public interface AllowsGssapiLibraryLoad_Response {
    void call(boolean z);
  }

  public interface CreateSimpleCache_Response {
    void call(SimpleCache simpleCache);
  }

  public interface EnumerateFiles_Response {
    void call(FileEnumerationEntry[] fileEnumerationEntryArr, boolean z);
  }

  public interface ForceNetworkQualityEstimatorReportWifiAsSlow2G_Response {
    void call();
  }

  public interface GetEnvironmentVariableValue_Response {
    void call(String str);
  }

  public interface GetLatestMemoryPressureLevel_Response {
    void call(int i);
  }

  public interface GetPeerToPeerConnectionsCountChange_Response {
    void call(int i);
  }

  public interface Log_Response {
    void call();
  }

  public interface MakeRequestToServer_Response {
    void call(boolean z);
  }

  public interface MockCertVerifierAddResultForCertAndHost_Response {
    void call();
  }

  public interface MockCertVerifierSetDefaultResult_Response {
    void call();
  }

  public interface OpenFile_Response {
    void call(boolean z);
  }

  public interface Proxy extends NetworkServiceTest, Interface.Proxy {}

  public interface ReplaceSystemDnsConfig_Response {
    void call();
  }

  public interface ResolveOwnHostnameWithSystemDns_Response {
    void call(AddressList addressList, int i, int i2);
  }

  public interface SetAllowNetworkAccessToHostResolutions_Response {
    void call();
  }

  public interface SetIPv6ProbeResult_Response {
    void call();
  }

  public interface SetRequireCt_Response {
    void call();
  }

  public interface SetSctAuditingRetryDelay_Response {
    void call();
  }

  public interface SetTestDohConfig_Response {
    void call();
  }

  public interface SetTransportSecurityStateSource_Response {
    void call();
  }

  public interface SimulateNetworkChange_Response {
    void call();
  }

  public interface SimulateNetworkQualityChange_Response {
    void call();
  }

  void activateFieldTrial(String str);

  void addRules(Rule[] ruleArr, AddRules_Response addRules_Response);

  void allowsGssapiLibraryLoad(AllowsGssapiLibraryLoad_Response allowsGssapiLibraryLoad_Response);

  void crashOnGetCookieList();

  void crashOnResolveHost(String str);

  void createSimpleCache(
      HttpCacheBackendFileOperationsFactory httpCacheBackendFileOperationsFactory,
      FilePath filePath,
      boolean z,
      CreateSimpleCache_Response createSimpleCache_Response);

  void enumerateFiles(
      FilePath filePath,
      HttpCacheBackendFileOperationsFactory httpCacheBackendFileOperationsFactory,
      EnumerateFiles_Response enumerateFiles_Response);

  void forceNetworkQualityEstimatorReportWifiAsSlow2G(
      ForceNetworkQualityEstimatorReportWifiAsSlow2G_Response
          forceNetworkQualityEstimatorReportWifiAsSlow2G_Response);

  void getEnvironmentVariableValue(
      String str, GetEnvironmentVariableValue_Response getEnvironmentVariableValue_Response);

  void getLatestMemoryPressureLevel(
      GetLatestMemoryPressureLevel_Response getLatestMemoryPressureLevel_Response);

  void getPeerToPeerConnectionsCountChange(
      GetPeerToPeerConnectionsCountChange_Response getPeerToPeerConnectionsCountChange_Response);

  void log(String str, Log_Response log_Response);

  void makeRequestToServer(
      TransferableSocket transferableSocket,
      IpEndPoint ipEndPoint,
      MakeRequestToServer_Response makeRequestToServer_Response);

  void mockCertVerifierAddResultForCertAndHost(
      X509Certificate x509Certificate,
      String str,
      CertVerifyResult certVerifyResult,
      int i,
      MockCertVerifierAddResultForCertAndHost_Response
          mockCertVerifierAddResultForCertAndHost_Response);

  void mockCertVerifierSetDefaultResult(
      int i, MockCertVerifierSetDefaultResult_Response mockCertVerifierSetDefaultResult_Response);

  void openFile(FilePath filePath, OpenFile_Response openFile_Response);

  void replaceSystemDnsConfig(ReplaceSystemDnsConfig_Response replaceSystemDnsConfig_Response);

  void resolveOwnHostnameWithSystemDns(
      ResolveOwnHostnameWithSystemDns_Response resolveOwnHostnameWithSystemDns_Response);

  void setAllowNetworkAccessToHostResolutions(
      SetAllowNetworkAccessToHostResolutions_Response
          setAllowNetworkAccessToHostResolutions_Response);

  void setIPv6ProbeResult(boolean z, SetIPv6ProbeResult_Response setIPv6ProbeResult_Response);

  void setRequireCt(int i, SetRequireCt_Response setRequireCt_Response);

  void setSctAuditingRetryDelay(
      TimeDelta timeDelta, SetSctAuditingRetryDelay_Response setSctAuditingRetryDelay_Response);

  void setTestDohConfig(
      int i,
      DnsOverHttpsConfig dnsOverHttpsConfig,
      SetTestDohConfig_Response setTestDohConfig_Response);

  void setTransportSecurityStateSource(
      short s, SetTransportSecurityStateSource_Response setTransportSecurityStateSource_Response);

  void simulateCrash();

  void simulateNetworkChange(int i, SimulateNetworkChange_Response simulateNetworkChange_Response);

  void simulateNetworkQualityChange(
      int i, SimulateNetworkQualityChange_Response simulateNetworkQualityChange_Response);

  public static final class RequireCt {
    public static final int DEFAULT = 0;
    private static final boolean IS_EXTENSIBLE = false;
    public static final int MAX_VALUE = 1;
    public static final int MIN_VALUE = 0;
    public static final int REQUIRE = 1;

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

    private RequireCt() {}
  }
}
