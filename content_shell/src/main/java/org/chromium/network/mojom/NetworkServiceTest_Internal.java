package org.chromium.network.mojom;

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
import org.chromium.mojo_base.mojom.FilePath;
import org.chromium.mojo_base.mojom.MemoryPressureLevel;
import org.chromium.mojo_base.mojom.TimeDelta;

class NetworkServiceTest_Internal {
  private static final int ACTIVATE_FIELD_TRIAL_ORDINAL = 18;
  private static final int ADD_RULES_ORDINAL = 0;
  private static final int ALLOWS_GSSAPI_LIBRARY_LOAD_ORDINAL = 26;
  private static final int CRASH_ON_GET_COOKIE_LIST_ORDINAL = 13;
  private static final int CRASH_ON_RESOLVE_HOST_ORDINAL = 12;
  private static final int CREATE_SIMPLE_CACHE_ORDINAL = 22;
  private static final int ENUMERATE_FILES_ORDINAL = 21;
  private static final int FORCE_NETWORK_QUALITY_ESTIMATOR_REPORT_WIFI_AS_SLOW2_G_ORDINAL = 3;
  private static final int GET_ENVIRONMENT_VARIABLE_VALUE_ORDINAL = 16;
  private static final int GET_LATEST_MEMORY_PRESSURE_LEVEL_ORDINAL = 14;
  private static final int GET_PEER_TO_PEER_CONNECTIONS_COUNT_CHANGE_ORDINAL = 15;
  private static final int LOG_ORDINAL = 17;
  private static final int MAKE_REQUEST_TO_SERVER_ORDINAL = 23;
  public static final Interface.Manager<NetworkServiceTest, NetworkServiceTest.Proxy> MANAGER =
      new Interface.Manager<NetworkServiceTest, NetworkServiceTest.Proxy>() {
        @Override
        public String getName() {
          return "network.mojom.NetworkServiceTest";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public NetworkServiceTest.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, NetworkServiceTest impl) {
          return new Stub(core, impl);
        }

        @Override
        public NetworkServiceTest[] buildArray(int size) {
          return new NetworkServiceTest[size];
        }
      };
  private static final int MOCK_CERT_VERIFIER_ADD_RESULT_FOR_CERT_AND_HOST_ORDINAL = 6;
  private static final int MOCK_CERT_VERIFIER_SET_DEFAULT_RESULT_ORDINAL = 5;
  private static final int OPEN_FILE_ORDINAL = 20;
  private static final int REPLACE_SYSTEM_DNS_CONFIG_ORDINAL = 10;
  private static final int RESOLVE_OWN_HOSTNAME_WITH_SYSTEM_DNS_ORDINAL = 24;
  private static final int SET_ALLOW_NETWORK_ACCESS_TO_HOST_RESOLUTIONS_ORDINAL = 9;
  private static final int SET_I_PV6_PROBE_RESULT_ORDINAL = 25;
  private static final int SET_REQUIRE_CT_ORDINAL = 7;
  private static final int SET_SCT_AUDITING_RETRY_DELAY_ORDINAL = 19;
  private static final int SET_TEST_DOH_CONFIG_ORDINAL = 11;
  private static final int SET_TRANSPORT_SECURITY_STATE_SOURCE_ORDINAL = 8;
  private static final int SIMULATE_CRASH_ORDINAL = 4;
  private static final int SIMULATE_NETWORK_CHANGE_ORDINAL = 1;
  private static final int SIMULATE_NETWORK_QUALITY_CHANGE_ORDINAL = 2;

  NetworkServiceTest_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements NetworkServiceTest.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void addRules(Rule[] rules, NetworkServiceTest.AddRules_Response callback) {
      NetworkServiceTestAddRulesParams _message = new NetworkServiceTestAddRulesParams();
      _message.rules = rules;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new NetworkServiceTestAddRulesResponseParamsForwardToCallback(callback));
    }

    @Override
    public void simulateNetworkChange(
        int type, NetworkServiceTest.SimulateNetworkChange_Response callback) {
      NetworkServiceTestSimulateNetworkChangeParams _message =
          new NetworkServiceTestSimulateNetworkChangeParams();
      _message.type = type;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new NetworkServiceTestSimulateNetworkChangeResponseParamsForwardToCallback(callback));
    }

    @Override
    public void simulateNetworkQualityChange(
        int type, NetworkServiceTest.SimulateNetworkQualityChange_Response callback) {
      NetworkServiceTestSimulateNetworkQualityChangeParams _message =
          new NetworkServiceTestSimulateNetworkQualityChangeParams();
      _message.type = type;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new NetworkServiceTestSimulateNetworkQualityChangeResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void forceNetworkQualityEstimatorReportWifiAsSlow2G(
        NetworkServiceTest.ForceNetworkQualityEstimatorReportWifiAsSlow2G_Response callback) {
      NetworkServiceTestForceNetworkQualityEstimatorReportWifiAsSlow2GParams _message =
          new NetworkServiceTestForceNetworkQualityEstimatorReportWifiAsSlow2GParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)),
              new NetworkServiceTestForceNetworkQualityEstimatorReportWifiAsSlow2GResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void simulateCrash() {
      NetworkServiceTestSimulateCrashParams _message = new NetworkServiceTestSimulateCrashParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
    }

    @Override
    public void mockCertVerifierSetDefaultResult(
        int defaultResult, NetworkServiceTest.MockCertVerifierSetDefaultResult_Response callback) {
      NetworkServiceTestMockCertVerifierSetDefaultResultParams _message =
          new NetworkServiceTestMockCertVerifierSetDefaultResultParams();
      _message.defaultResult = defaultResult;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(5, 1, 0L)),
              new NetworkServiceTestMockCertVerifierSetDefaultResultResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void mockCertVerifierAddResultForCertAndHost(
        X509Certificate cert,
        String hostPattern,
        CertVerifyResult verifyResult,
        int rv,
        NetworkServiceTest.MockCertVerifierAddResultForCertAndHost_Response callback) {
      NetworkServiceTestMockCertVerifierAddResultForCertAndHostParams _message =
          new NetworkServiceTestMockCertVerifierAddResultForCertAndHostParams();
      _message.cert = cert;
      _message.hostPattern = hostPattern;
      _message.verifyResult = verifyResult;
      _message.rv = rv;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(6, 1, 0L)),
              new NetworkServiceTestMockCertVerifierAddResultForCertAndHostResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void setRequireCt(int required, NetworkServiceTest.SetRequireCt_Response callback) {
      NetworkServiceTestSetRequireCtParams _message = new NetworkServiceTestSetRequireCtParams();
      _message.required = required;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(7, 1, 0L)),
              new NetworkServiceTestSetRequireCtResponseParamsForwardToCallback(callback));
    }

    @Override
    public void setTransportSecurityStateSource(
        short reportingPort, NetworkServiceTest.SetTransportSecurityStateSource_Response callback) {
      NetworkServiceTestSetTransportSecurityStateSourceParams _message =
          new NetworkServiceTestSetTransportSecurityStateSourceParams();
      _message.reportingPort = reportingPort;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(8, 1, 0L)),
              new NetworkServiceTestSetTransportSecurityStateSourceResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void setAllowNetworkAccessToHostResolutions(
        NetworkServiceTest.SetAllowNetworkAccessToHostResolutions_Response callback) {
      NetworkServiceTestSetAllowNetworkAccessToHostResolutionsParams _message =
          new NetworkServiceTestSetAllowNetworkAccessToHostResolutionsParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(9, 1, 0L)),
              new NetworkServiceTestSetAllowNetworkAccessToHostResolutionsResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void replaceSystemDnsConfig(
        NetworkServiceTest.ReplaceSystemDnsConfig_Response callback) {
      NetworkServiceTestReplaceSystemDnsConfigParams _message =
          new NetworkServiceTestReplaceSystemDnsConfigParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(10, 1, 0L)),
              new NetworkServiceTestReplaceSystemDnsConfigResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void setTestDohConfig(
        int secureDnsMode,
        DnsOverHttpsConfig dohConfig,
        NetworkServiceTest.SetTestDohConfig_Response callback) {
      NetworkServiceTestSetTestDohConfigParams _message =
          new NetworkServiceTestSetTestDohConfigParams();
      _message.secureDnsMode = secureDnsMode;
      _message.dohConfig = dohConfig;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(11, 1, 0L)),
              new NetworkServiceTestSetTestDohConfigResponseParamsForwardToCallback(callback));
    }

    @Override
    public void crashOnResolveHost(String host) {
      NetworkServiceTestCrashOnResolveHostParams _message =
          new NetworkServiceTestCrashOnResolveHostParams();
      _message.host = host;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(12)));
    }

    @Override
    public void crashOnGetCookieList() {
      NetworkServiceTestCrashOnGetCookieListParams _message =
          new NetworkServiceTestCrashOnGetCookieListParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(13)));
    }

    @Override
    public void getLatestMemoryPressureLevel(
        NetworkServiceTest.GetLatestMemoryPressureLevel_Response callback) {
      NetworkServiceTestGetLatestMemoryPressureLevelParams _message =
          new NetworkServiceTestGetLatestMemoryPressureLevelParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(14, 1, 0L)),
              new NetworkServiceTestGetLatestMemoryPressureLevelResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void getPeerToPeerConnectionsCountChange(
        NetworkServiceTest.GetPeerToPeerConnectionsCountChange_Response callback) {
      NetworkServiceTestGetPeerToPeerConnectionsCountChangeParams _message =
          new NetworkServiceTestGetPeerToPeerConnectionsCountChangeParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(15, 1, 0L)),
              new NetworkServiceTestGetPeerToPeerConnectionsCountChangeResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void getEnvironmentVariableValue(
        String name, NetworkServiceTest.GetEnvironmentVariableValue_Response callback) {
      NetworkServiceTestGetEnvironmentVariableValueParams _message =
          new NetworkServiceTestGetEnvironmentVariableValueParams();
      _message.name = name;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(16, 1, 0L)),
              new NetworkServiceTestGetEnvironmentVariableValueResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void log(String message, NetworkServiceTest.Log_Response callback) {
      NetworkServiceTestLogParams _message = new NetworkServiceTestLogParams();
      _message.message = message;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(17, 1, 0L)),
              new NetworkServiceTestLogResponseParamsForwardToCallback(callback));
    }

    @Override
    public void activateFieldTrial(String fieldTrialName) {
      NetworkServiceTestActivateFieldTrialParams _message =
          new NetworkServiceTestActivateFieldTrialParams();
      _message.fieldTrialName = fieldTrialName;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(18)));
    }

    @Override
    public void setSctAuditingRetryDelay(
        TimeDelta delay, NetworkServiceTest.SetSctAuditingRetryDelay_Response callback) {
      NetworkServiceTestSetSctAuditingRetryDelayParams _message =
          new NetworkServiceTestSetSctAuditingRetryDelayParams();
      _message.delay = delay;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(19, 1, 0L)),
              new NetworkServiceTestSetSctAuditingRetryDelayResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void openFile(FilePath path, NetworkServiceTest.OpenFile_Response callback) {
      NetworkServiceTestOpenFileParams _message = new NetworkServiceTestOpenFileParams();
      _message.path = path;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(20, 1, 0L)),
              new NetworkServiceTestOpenFileResponseParamsForwardToCallback(callback));
    }

    @Override
    public void enumerateFiles(
        FilePath path,
        HttpCacheBackendFileOperationsFactory factory,
        NetworkServiceTest.EnumerateFiles_Response callback) {
      NetworkServiceTestEnumerateFilesParams _message =
          new NetworkServiceTestEnumerateFilesParams();
      _message.path = path;
      _message.factory = factory;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(21, 1, 0L)),
              new NetworkServiceTestEnumerateFilesResponseParamsForwardToCallback(callback));
    }

    @Override
    public void createSimpleCache(
        HttpCacheBackendFileOperationsFactory factory,
        FilePath path,
        boolean reset,
        NetworkServiceTest.CreateSimpleCache_Response callback) {
      NetworkServiceTestCreateSimpleCacheParams _message =
          new NetworkServiceTestCreateSimpleCacheParams();
      _message.factory = factory;
      _message.path = path;
      _message.reset = reset;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(22, 1, 0L)),
              new NetworkServiceTestCreateSimpleCacheResponseParamsForwardToCallback(callback));
    }

    @Override
    public void makeRequestToServer(
        TransferableSocket s,
        IpEndPoint endpoint,
        NetworkServiceTest.MakeRequestToServer_Response callback) {
      NetworkServiceTestMakeRequestToServerParams _message =
          new NetworkServiceTestMakeRequestToServerParams();
      _message.s = s;
      _message.endpoint = endpoint;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(23, 1, 0L)),
              new NetworkServiceTestMakeRequestToServerResponseParamsForwardToCallback(callback));
    }

    @Override
    public void resolveOwnHostnameWithSystemDns(
        NetworkServiceTest.ResolveOwnHostnameWithSystemDns_Response callback) {
      NetworkServiceTestResolveOwnHostnameWithSystemDnsParams _message =
          new NetworkServiceTestResolveOwnHostnameWithSystemDnsParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(24, 1, 0L)),
              new NetworkServiceTestResolveOwnHostnameWithSystemDnsResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void setIPv6ProbeResult(
        boolean success, NetworkServiceTest.SetIPv6ProbeResult_Response callback) {
      NetworkServiceTestSetIPv6ProbeResultParams _message =
          new NetworkServiceTestSetIPv6ProbeResultParams();
      _message.success = success;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(25, 1, 0L)),
              new NetworkServiceTestSetIPv6ProbeResultResponseParamsForwardToCallback(callback));
    }

    @Override
    public void allowsGssapiLibraryLoad(
        NetworkServiceTest.AllowsGssapiLibraryLoad_Response callback) {
      NetworkServiceTestAllowsGssapiLibraryLoadParams _message =
          new NetworkServiceTestAllowsGssapiLibraryLoadParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(26, 1, 0L)),
              new NetworkServiceTestAllowsGssapiLibraryLoadResponseParamsForwardToCallback(
                  callback));
    }
  }

  public static final class Stub extends Interface.Stub<NetworkServiceTest> {
    Stub(Core core, NetworkServiceTest impl) {
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
                NetworkServiceTest_Internal.MANAGER, messageWithHeader);
          case 4:
            NetworkServiceTestSimulateCrashParams.deserialize(messageWithHeader.getPayload());
            getImpl().simulateCrash();
            return true;
          case 12:
            NetworkServiceTestCrashOnResolveHostParams data =
                NetworkServiceTestCrashOnResolveHostParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().crashOnResolveHost(data.host);
            return true;
          case 13:
            NetworkServiceTestCrashOnGetCookieListParams.deserialize(
                messageWithHeader.getPayload());
            getImpl().crashOnGetCookieList();
            return true;
          case 18:
            NetworkServiceTestActivateFieldTrialParams data2 =
                NetworkServiceTestActivateFieldTrialParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().activateFieldTrial(data2.fieldTrialName);
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
                getCore(), NetworkServiceTest_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            NetworkServiceTestAddRulesParams data =
                NetworkServiceTestAddRulesParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .addRules(
                    data.rules,
                    new NetworkServiceTestAddRulesResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
            NetworkServiceTestSimulateNetworkChangeParams data2 =
                NetworkServiceTestSimulateNetworkChangeParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .simulateNetworkChange(
                    data2.type,
                    new NetworkServiceTestSimulateNetworkChangeResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 2:
            NetworkServiceTestSimulateNetworkQualityChangeParams data3 =
                NetworkServiceTestSimulateNetworkQualityChangeParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .simulateNetworkQualityChange(
                    data3.type,
                    new NetworkServiceTestSimulateNetworkQualityChangeResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 3:
            NetworkServiceTestForceNetworkQualityEstimatorReportWifiAsSlow2GParams.deserialize(
                messageWithHeader.getPayload());
            getImpl()
                .forceNetworkQualityEstimatorReportWifiAsSlow2G(
                    new NetworkServiceTestForceNetworkQualityEstimatorReportWifiAsSlow2GResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 4:
          case 12:
          case 13:
          case 18:
          default:
            return false;
          case 5:
            NetworkServiceTestMockCertVerifierSetDefaultResultParams data4 =
                NetworkServiceTestMockCertVerifierSetDefaultResultParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .mockCertVerifierSetDefaultResult(
                    data4.defaultResult,
                    new NetworkServiceTestMockCertVerifierSetDefaultResultResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 6:
            NetworkServiceTestMockCertVerifierAddResultForCertAndHostParams data5 =
                NetworkServiceTestMockCertVerifierAddResultForCertAndHostParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .mockCertVerifierAddResultForCertAndHost(
                    data5.cert,
                    data5.hostPattern,
                    data5.verifyResult,
                    data5.rv,
                    new NetworkServiceTestMockCertVerifierAddResultForCertAndHostResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 7:
            NetworkServiceTestSetRequireCtParams data6 =
                NetworkServiceTestSetRequireCtParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .setRequireCt(
                    data6.required,
                    new NetworkServiceTestSetRequireCtResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 8:
            NetworkServiceTestSetTransportSecurityStateSourceParams data7 =
                NetworkServiceTestSetTransportSecurityStateSourceParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .setTransportSecurityStateSource(
                    data7.reportingPort,
                    new NetworkServiceTestSetTransportSecurityStateSourceResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 9:
            NetworkServiceTestSetAllowNetworkAccessToHostResolutionsParams.deserialize(
                messageWithHeader.getPayload());
            getImpl()
                .setAllowNetworkAccessToHostResolutions(
                    new NetworkServiceTestSetAllowNetworkAccessToHostResolutionsResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 10:
            NetworkServiceTestReplaceSystemDnsConfigParams.deserialize(
                messageWithHeader.getPayload());
            getImpl()
                .replaceSystemDnsConfig(
                    new NetworkServiceTestReplaceSystemDnsConfigResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 11:
            NetworkServiceTestSetTestDohConfigParams data8 =
                NetworkServiceTestSetTestDohConfigParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .setTestDohConfig(
                    data8.secureDnsMode,
                    data8.dohConfig,
                    new NetworkServiceTestSetTestDohConfigResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 14:
            NetworkServiceTestGetLatestMemoryPressureLevelParams.deserialize(
                messageWithHeader.getPayload());
            getImpl()
                .getLatestMemoryPressureLevel(
                    new NetworkServiceTestGetLatestMemoryPressureLevelResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 15:
            NetworkServiceTestGetPeerToPeerConnectionsCountChangeParams.deserialize(
                messageWithHeader.getPayload());
            getImpl()
                .getPeerToPeerConnectionsCountChange(
                    new NetworkServiceTestGetPeerToPeerConnectionsCountChangeResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 16:
            NetworkServiceTestGetEnvironmentVariableValueParams data9 =
                NetworkServiceTestGetEnvironmentVariableValueParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .getEnvironmentVariableValue(
                    data9.name,
                    new NetworkServiceTestGetEnvironmentVariableValueResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 17:
            NetworkServiceTestLogParams data10 =
                NetworkServiceTestLogParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .log(
                    data10.message,
                    new NetworkServiceTestLogResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 19:
            NetworkServiceTestSetSctAuditingRetryDelayParams data11 =
                NetworkServiceTestSetSctAuditingRetryDelayParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .setSctAuditingRetryDelay(
                    data11.delay,
                    new NetworkServiceTestSetSctAuditingRetryDelayResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 20:
            NetworkServiceTestOpenFileParams data12 =
                NetworkServiceTestOpenFileParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .openFile(
                    data12.path,
                    new NetworkServiceTestOpenFileResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 21:
            NetworkServiceTestEnumerateFilesParams data13 =
                NetworkServiceTestEnumerateFilesParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .enumerateFiles(
                    data13.path,
                    data13.factory,
                    new NetworkServiceTestEnumerateFilesResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 22:
            NetworkServiceTestCreateSimpleCacheParams data14 =
                NetworkServiceTestCreateSimpleCacheParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .createSimpleCache(
                    data14.factory,
                    data14.path,
                    data14.reset,
                    new NetworkServiceTestCreateSimpleCacheResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 23:
            NetworkServiceTestMakeRequestToServerParams data15 =
                NetworkServiceTestMakeRequestToServerParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .makeRequestToServer(
                    data15.s,
                    data15.endpoint,
                    new NetworkServiceTestMakeRequestToServerResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 24:
            NetworkServiceTestResolveOwnHostnameWithSystemDnsParams.deserialize(
                messageWithHeader.getPayload());
            getImpl()
                .resolveOwnHostnameWithSystemDns(
                    new NetworkServiceTestResolveOwnHostnameWithSystemDnsResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 25:
            NetworkServiceTestSetIPv6ProbeResultParams data16 =
                NetworkServiceTestSetIPv6ProbeResultParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .setIPv6ProbeResult(
                    data16.success,
                    new NetworkServiceTestSetIPv6ProbeResultResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 26:
            NetworkServiceTestAllowsGssapiLibraryLoadParams.deserialize(
                messageWithHeader.getPayload());
            getImpl()
                .allowsGssapiLibraryLoad(
                    new NetworkServiceTestAllowsGssapiLibraryLoadResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class NetworkServiceTestAddRulesParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Rule[] rules;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkServiceTestAddRulesParams(int version) {
      super(16, version);
    }

    public NetworkServiceTestAddRulesParams() {
      this(0);
    }

    public static NetworkServiceTestAddRulesParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkServiceTestAddRulesParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkServiceTestAddRulesParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkServiceTestAddRulesParams result =
            new NetworkServiceTestAddRulesParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.rules = new Rule[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.rules[i1] = Rule.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      Rule[] ruleArr = this.rules;
      if (ruleArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(ruleArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        Rule[] ruleArr2 = this.rules;
        if (i0 < ruleArr2.length) {
          encoder1.encode((Struct) ruleArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static final class NetworkServiceTestAddRulesResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkServiceTestAddRulesResponseParams(int version) {
      super(8, version);
    }

    public NetworkServiceTestAddRulesResponseParams() {
      this(0);
    }

    public static NetworkServiceTestAddRulesResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkServiceTestAddRulesResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkServiceTestAddRulesResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkServiceTestAddRulesResponseParams result =
            new NetworkServiceTestAddRulesResponseParams(elementsOrVersion);
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

  static class NetworkServiceTestAddRulesResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NetworkServiceTest.AddRules_Response mCallback;

    NetworkServiceTestAddRulesResponseParamsForwardToCallback(
        NetworkServiceTest.AddRules_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(0, 6)) {
          return false;
        }
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NetworkServiceTestAddRulesResponseParamsProxyToResponder
      implements NetworkServiceTest.AddRules_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkServiceTestAddRulesResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      NetworkServiceTestAddRulesResponseParams _response =
          new NetworkServiceTestAddRulesResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkServiceTestSimulateNetworkChangeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int type;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkServiceTestSimulateNetworkChangeParams(int version) {
      super(16, version);
    }

    public NetworkServiceTestSimulateNetworkChangeParams() {
      this(0);
    }

    public static NetworkServiceTestSimulateNetworkChangeParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkServiceTestSimulateNetworkChangeParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkServiceTestSimulateNetworkChangeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkServiceTestSimulateNetworkChangeParams result =
            new NetworkServiceTestSimulateNetworkChangeParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.type = readInt;
        ConnectionType.validate(readInt);
        result.type = ConnectionType.toKnownValue(result.type);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.type, 8);
    }
  }

  static final class NetworkServiceTestSimulateNetworkChangeResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkServiceTestSimulateNetworkChangeResponseParams(int version) {
      super(8, version);
    }

    public NetworkServiceTestSimulateNetworkChangeResponseParams() {
      this(0);
    }

    public static NetworkServiceTestSimulateNetworkChangeResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkServiceTestSimulateNetworkChangeResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkServiceTestSimulateNetworkChangeResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkServiceTestSimulateNetworkChangeResponseParams result =
            new NetworkServiceTestSimulateNetworkChangeResponseParams(elementsOrVersion);
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

  static class NetworkServiceTestSimulateNetworkChangeResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NetworkServiceTest.SimulateNetworkChange_Response mCallback;

    NetworkServiceTestSimulateNetworkChangeResponseParamsForwardToCallback(
        NetworkServiceTest.SimulateNetworkChange_Response callback) {
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
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NetworkServiceTestSimulateNetworkChangeResponseParamsProxyToResponder
      implements NetworkServiceTest.SimulateNetworkChange_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkServiceTestSimulateNetworkChangeResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      NetworkServiceTestSimulateNetworkChangeResponseParams _response =
          new NetworkServiceTestSimulateNetworkChangeResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkServiceTestSimulateNetworkQualityChangeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int type;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkServiceTestSimulateNetworkQualityChangeParams(int version) {
      super(16, version);
    }

    public NetworkServiceTestSimulateNetworkQualityChangeParams() {
      this(0);
    }

    public static NetworkServiceTestSimulateNetworkQualityChangeParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkServiceTestSimulateNetworkQualityChangeParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkServiceTestSimulateNetworkQualityChangeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkServiceTestSimulateNetworkQualityChangeParams result =
            new NetworkServiceTestSimulateNetworkQualityChangeParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.type = readInt;
        EffectiveConnectionType.validate(readInt);
        result.type = EffectiveConnectionType.toKnownValue(result.type);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.type, 8);
    }
  }

  static final class NetworkServiceTestSimulateNetworkQualityChangeResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkServiceTestSimulateNetworkQualityChangeResponseParams(int version) {
      super(8, version);
    }

    public NetworkServiceTestSimulateNetworkQualityChangeResponseParams() {
      this(0);
    }

    public static NetworkServiceTestSimulateNetworkQualityChangeResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkServiceTestSimulateNetworkQualityChangeResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkServiceTestSimulateNetworkQualityChangeResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkServiceTestSimulateNetworkQualityChangeResponseParams result =
            new NetworkServiceTestSimulateNetworkQualityChangeResponseParams(elementsOrVersion);
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

  static class NetworkServiceTestSimulateNetworkQualityChangeResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NetworkServiceTest.SimulateNetworkQualityChange_Response mCallback;

    NetworkServiceTestSimulateNetworkQualityChangeResponseParamsForwardToCallback(
        NetworkServiceTest.SimulateNetworkQualityChange_Response callback) {
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
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NetworkServiceTestSimulateNetworkQualityChangeResponseParamsProxyToResponder
      implements NetworkServiceTest.SimulateNetworkQualityChange_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkServiceTestSimulateNetworkQualityChangeResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      NetworkServiceTestSimulateNetworkQualityChangeResponseParams _response =
          new NetworkServiceTestSimulateNetworkQualityChangeResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkServiceTestForceNetworkQualityEstimatorReportWifiAsSlow2GParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkServiceTestForceNetworkQualityEstimatorReportWifiAsSlow2GParams(int version) {
      super(8, version);
    }

    public NetworkServiceTestForceNetworkQualityEstimatorReportWifiAsSlow2GParams() {
      this(0);
    }

    public static NetworkServiceTestForceNetworkQualityEstimatorReportWifiAsSlow2GParams
        deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkServiceTestForceNetworkQualityEstimatorReportWifiAsSlow2GParams
        deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkServiceTestForceNetworkQualityEstimatorReportWifiAsSlow2GParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkServiceTestForceNetworkQualityEstimatorReportWifiAsSlow2GParams result =
            new NetworkServiceTestForceNetworkQualityEstimatorReportWifiAsSlow2GParams(
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

  static final class NetworkServiceTestForceNetworkQualityEstimatorReportWifiAsSlow2GResponseParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkServiceTestForceNetworkQualityEstimatorReportWifiAsSlow2GResponseParams(
        int version) {
      super(8, version);
    }

    public NetworkServiceTestForceNetworkQualityEstimatorReportWifiAsSlow2GResponseParams() {
      this(0);
    }

    public static NetworkServiceTestForceNetworkQualityEstimatorReportWifiAsSlow2GResponseParams
        deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkServiceTestForceNetworkQualityEstimatorReportWifiAsSlow2GResponseParams
        deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkServiceTestForceNetworkQualityEstimatorReportWifiAsSlow2GResponseParams
        decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkServiceTestForceNetworkQualityEstimatorReportWifiAsSlow2GResponseParams result =
            new NetworkServiceTestForceNetworkQualityEstimatorReportWifiAsSlow2GResponseParams(
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
  class NetworkServiceTestForceNetworkQualityEstimatorReportWifiAsSlow2GResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NetworkServiceTest.ForceNetworkQualityEstimatorReportWifiAsSlow2G_Response
        mCallback;

    NetworkServiceTestForceNetworkQualityEstimatorReportWifiAsSlow2GResponseParamsForwardToCallback(
        NetworkServiceTest.ForceNetworkQualityEstimatorReportWifiAsSlow2G_Response callback) {
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
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static
  class NetworkServiceTestForceNetworkQualityEstimatorReportWifiAsSlow2GResponseParamsProxyToResponder
      implements NetworkServiceTest.ForceNetworkQualityEstimatorReportWifiAsSlow2G_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkServiceTestForceNetworkQualityEstimatorReportWifiAsSlow2GResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      NetworkServiceTestForceNetworkQualityEstimatorReportWifiAsSlow2GResponseParams _response =
          new NetworkServiceTestForceNetworkQualityEstimatorReportWifiAsSlow2GResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkServiceTestSimulateCrashParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkServiceTestSimulateCrashParams(int version) {
      super(8, version);
    }

    public NetworkServiceTestSimulateCrashParams() {
      this(0);
    }

    public static NetworkServiceTestSimulateCrashParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkServiceTestSimulateCrashParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkServiceTestSimulateCrashParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkServiceTestSimulateCrashParams result =
            new NetworkServiceTestSimulateCrashParams(elementsOrVersion);
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

  static final class NetworkServiceTestMockCertVerifierSetDefaultResultParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int defaultResult;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkServiceTestMockCertVerifierSetDefaultResultParams(int version) {
      super(16, version);
    }

    public NetworkServiceTestMockCertVerifierSetDefaultResultParams() {
      this(0);
    }

    public static NetworkServiceTestMockCertVerifierSetDefaultResultParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkServiceTestMockCertVerifierSetDefaultResultParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkServiceTestMockCertVerifierSetDefaultResultParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkServiceTestMockCertVerifierSetDefaultResultParams result =
            new NetworkServiceTestMockCertVerifierSetDefaultResultParams(elementsOrVersion);
        result.defaultResult = decoder0.readInt(8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.defaultResult, 8);
    }
  }

  static final class NetworkServiceTestMockCertVerifierSetDefaultResultResponseParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkServiceTestMockCertVerifierSetDefaultResultResponseParams(int version) {
      super(8, version);
    }

    public NetworkServiceTestMockCertVerifierSetDefaultResultResponseParams() {
      this(0);
    }

    public static NetworkServiceTestMockCertVerifierSetDefaultResultResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkServiceTestMockCertVerifierSetDefaultResultResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkServiceTestMockCertVerifierSetDefaultResultResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkServiceTestMockCertVerifierSetDefaultResultResponseParams result =
            new NetworkServiceTestMockCertVerifierSetDefaultResultResponseParams(elementsOrVersion);
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

  static class NetworkServiceTestMockCertVerifierSetDefaultResultResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NetworkServiceTest.MockCertVerifierSetDefaultResult_Response mCallback;

    NetworkServiceTestMockCertVerifierSetDefaultResultResponseParamsForwardToCallback(
        NetworkServiceTest.MockCertVerifierSetDefaultResult_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(5, 6)) {
          return false;
        }
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NetworkServiceTestMockCertVerifierSetDefaultResultResponseParamsProxyToResponder
      implements NetworkServiceTest.MockCertVerifierSetDefaultResult_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkServiceTestMockCertVerifierSetDefaultResultResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      NetworkServiceTestMockCertVerifierSetDefaultResultResponseParams _response =
          new NetworkServiceTestMockCertVerifierSetDefaultResultResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(5, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkServiceTestMockCertVerifierAddResultForCertAndHostParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public X509Certificate cert;
    public String hostPattern;
    public int rv;
    public CertVerifyResult verifyResult;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkServiceTestMockCertVerifierAddResultForCertAndHostParams(int version) {
      super(40, version);
    }

    public NetworkServiceTestMockCertVerifierAddResultForCertAndHostParams() {
      this(0);
    }

    public static NetworkServiceTestMockCertVerifierAddResultForCertAndHostParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkServiceTestMockCertVerifierAddResultForCertAndHostParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkServiceTestMockCertVerifierAddResultForCertAndHostParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkServiceTestMockCertVerifierAddResultForCertAndHostParams result =
            new NetworkServiceTestMockCertVerifierAddResultForCertAndHostParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.cert = X509Certificate.decode(decoder1);
        result.hostPattern = decoder0.readString(16, false);
        Decoder decoder12 = decoder0.readPointer(24, false);
        result.verifyResult = CertVerifyResult.decode(decoder12);
        result.rv = decoder0.readInt(32);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.cert, 8, false);
      encoder0.encode(this.hostPattern, 16, false);
      encoder0.encode((Struct) this.verifyResult, 24, false);
      encoder0.encode(this.rv, 32);
    }
  }

  static final class NetworkServiceTestMockCertVerifierAddResultForCertAndHostResponseParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkServiceTestMockCertVerifierAddResultForCertAndHostResponseParams(int version) {
      super(8, version);
    }

    public NetworkServiceTestMockCertVerifierAddResultForCertAndHostResponseParams() {
      this(0);
    }

    public static NetworkServiceTestMockCertVerifierAddResultForCertAndHostResponseParams
        deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkServiceTestMockCertVerifierAddResultForCertAndHostResponseParams
        deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkServiceTestMockCertVerifierAddResultForCertAndHostResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkServiceTestMockCertVerifierAddResultForCertAndHostResponseParams result =
            new NetworkServiceTestMockCertVerifierAddResultForCertAndHostResponseParams(
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
  class NetworkServiceTestMockCertVerifierAddResultForCertAndHostResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NetworkServiceTest.MockCertVerifierAddResultForCertAndHost_Response mCallback;

    NetworkServiceTestMockCertVerifierAddResultForCertAndHostResponseParamsForwardToCallback(
        NetworkServiceTest.MockCertVerifierAddResultForCertAndHost_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(6, 6)) {
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
  class NetworkServiceTestMockCertVerifierAddResultForCertAndHostResponseParamsProxyToResponder
      implements NetworkServiceTest.MockCertVerifierAddResultForCertAndHost_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkServiceTestMockCertVerifierAddResultForCertAndHostResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      NetworkServiceTestMockCertVerifierAddResultForCertAndHostResponseParams _response =
          new NetworkServiceTestMockCertVerifierAddResultForCertAndHostResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(6, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkServiceTestSetRequireCtParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int required;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkServiceTestSetRequireCtParams(int version) {
      super(16, version);
    }

    public NetworkServiceTestSetRequireCtParams() {
      this(0);
    }

    public static NetworkServiceTestSetRequireCtParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkServiceTestSetRequireCtParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkServiceTestSetRequireCtParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkServiceTestSetRequireCtParams result =
            new NetworkServiceTestSetRequireCtParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.required = readInt;
        NetworkServiceTest.RequireCt.validate(readInt);
        result.required = NetworkServiceTest.RequireCt.toKnownValue(result.required);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.required, 8);
    }
  }

  static final class NetworkServiceTestSetRequireCtResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkServiceTestSetRequireCtResponseParams(int version) {
      super(8, version);
    }

    public NetworkServiceTestSetRequireCtResponseParams() {
      this(0);
    }

    public static NetworkServiceTestSetRequireCtResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkServiceTestSetRequireCtResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkServiceTestSetRequireCtResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkServiceTestSetRequireCtResponseParams result =
            new NetworkServiceTestSetRequireCtResponseParams(elementsOrVersion);
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

  static class NetworkServiceTestSetRequireCtResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NetworkServiceTest.SetRequireCt_Response mCallback;

    NetworkServiceTestSetRequireCtResponseParamsForwardToCallback(
        NetworkServiceTest.SetRequireCt_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(7, 6)) {
          return false;
        }
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NetworkServiceTestSetRequireCtResponseParamsProxyToResponder
      implements NetworkServiceTest.SetRequireCt_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkServiceTestSetRequireCtResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      NetworkServiceTestSetRequireCtResponseParams _response =
          new NetworkServiceTestSetRequireCtResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(7, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkServiceTestSetTransportSecurityStateSourceParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public short reportingPort;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkServiceTestSetTransportSecurityStateSourceParams(int version) {
      super(16, version);
    }

    public NetworkServiceTestSetTransportSecurityStateSourceParams() {
      this(0);
    }

    public static NetworkServiceTestSetTransportSecurityStateSourceParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkServiceTestSetTransportSecurityStateSourceParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkServiceTestSetTransportSecurityStateSourceParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkServiceTestSetTransportSecurityStateSourceParams result =
            new NetworkServiceTestSetTransportSecurityStateSourceParams(elementsOrVersion);
        result.reportingPort = decoder0.readShort(8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.reportingPort, 8);
    }
  }

  static final class NetworkServiceTestSetTransportSecurityStateSourceResponseParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkServiceTestSetTransportSecurityStateSourceResponseParams(int version) {
      super(8, version);
    }

    public NetworkServiceTestSetTransportSecurityStateSourceResponseParams() {
      this(0);
    }

    public static NetworkServiceTestSetTransportSecurityStateSourceResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkServiceTestSetTransportSecurityStateSourceResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkServiceTestSetTransportSecurityStateSourceResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkServiceTestSetTransportSecurityStateSourceResponseParams result =
            new NetworkServiceTestSetTransportSecurityStateSourceResponseParams(elementsOrVersion);
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

  static class NetworkServiceTestSetTransportSecurityStateSourceResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NetworkServiceTest.SetTransportSecurityStateSource_Response mCallback;

    NetworkServiceTestSetTransportSecurityStateSourceResponseParamsForwardToCallback(
        NetworkServiceTest.SetTransportSecurityStateSource_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(8, 6)) {
          return false;
        }
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NetworkServiceTestSetTransportSecurityStateSourceResponseParamsProxyToResponder
      implements NetworkServiceTest.SetTransportSecurityStateSource_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkServiceTestSetTransportSecurityStateSourceResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      NetworkServiceTestSetTransportSecurityStateSourceResponseParams _response =
          new NetworkServiceTestSetTransportSecurityStateSourceResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(8, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkServiceTestSetAllowNetworkAccessToHostResolutionsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkServiceTestSetAllowNetworkAccessToHostResolutionsParams(int version) {
      super(8, version);
    }

    public NetworkServiceTestSetAllowNetworkAccessToHostResolutionsParams() {
      this(0);
    }

    public static NetworkServiceTestSetAllowNetworkAccessToHostResolutionsParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkServiceTestSetAllowNetworkAccessToHostResolutionsParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkServiceTestSetAllowNetworkAccessToHostResolutionsParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkServiceTestSetAllowNetworkAccessToHostResolutionsParams result =
            new NetworkServiceTestSetAllowNetworkAccessToHostResolutionsParams(elementsOrVersion);
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

  static final class NetworkServiceTestSetAllowNetworkAccessToHostResolutionsResponseParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkServiceTestSetAllowNetworkAccessToHostResolutionsResponseParams(int version) {
      super(8, version);
    }

    public NetworkServiceTestSetAllowNetworkAccessToHostResolutionsResponseParams() {
      this(0);
    }

    public static NetworkServiceTestSetAllowNetworkAccessToHostResolutionsResponseParams
        deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkServiceTestSetAllowNetworkAccessToHostResolutionsResponseParams
        deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkServiceTestSetAllowNetworkAccessToHostResolutionsResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkServiceTestSetAllowNetworkAccessToHostResolutionsResponseParams result =
            new NetworkServiceTestSetAllowNetworkAccessToHostResolutionsResponseParams(
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
  class NetworkServiceTestSetAllowNetworkAccessToHostResolutionsResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NetworkServiceTest.SetAllowNetworkAccessToHostResolutions_Response mCallback;

    NetworkServiceTestSetAllowNetworkAccessToHostResolutionsResponseParamsForwardToCallback(
        NetworkServiceTest.SetAllowNetworkAccessToHostResolutions_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(9, 6)) {
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
  class NetworkServiceTestSetAllowNetworkAccessToHostResolutionsResponseParamsProxyToResponder
      implements NetworkServiceTest.SetAllowNetworkAccessToHostResolutions_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkServiceTestSetAllowNetworkAccessToHostResolutionsResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      NetworkServiceTestSetAllowNetworkAccessToHostResolutionsResponseParams _response =
          new NetworkServiceTestSetAllowNetworkAccessToHostResolutionsResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(9, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkServiceTestReplaceSystemDnsConfigParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkServiceTestReplaceSystemDnsConfigParams(int version) {
      super(8, version);
    }

    public NetworkServiceTestReplaceSystemDnsConfigParams() {
      this(0);
    }

    public static NetworkServiceTestReplaceSystemDnsConfigParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkServiceTestReplaceSystemDnsConfigParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkServiceTestReplaceSystemDnsConfigParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkServiceTestReplaceSystemDnsConfigParams result =
            new NetworkServiceTestReplaceSystemDnsConfigParams(elementsOrVersion);
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

  static final class NetworkServiceTestReplaceSystemDnsConfigResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkServiceTestReplaceSystemDnsConfigResponseParams(int version) {
      super(8, version);
    }

    public NetworkServiceTestReplaceSystemDnsConfigResponseParams() {
      this(0);
    }

    public static NetworkServiceTestReplaceSystemDnsConfigResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkServiceTestReplaceSystemDnsConfigResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkServiceTestReplaceSystemDnsConfigResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkServiceTestReplaceSystemDnsConfigResponseParams result =
            new NetworkServiceTestReplaceSystemDnsConfigResponseParams(elementsOrVersion);
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

  static class NetworkServiceTestReplaceSystemDnsConfigResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NetworkServiceTest.ReplaceSystemDnsConfig_Response mCallback;

    NetworkServiceTestReplaceSystemDnsConfigResponseParamsForwardToCallback(
        NetworkServiceTest.ReplaceSystemDnsConfig_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(10, 6)) {
          return false;
        }
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NetworkServiceTestReplaceSystemDnsConfigResponseParamsProxyToResponder
      implements NetworkServiceTest.ReplaceSystemDnsConfig_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkServiceTestReplaceSystemDnsConfigResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      NetworkServiceTestReplaceSystemDnsConfigResponseParams _response =
          new NetworkServiceTestReplaceSystemDnsConfigResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(10, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkServiceTestSetTestDohConfigParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public DnsOverHttpsConfig dohConfig;
    public int secureDnsMode;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkServiceTestSetTestDohConfigParams(int version) {
      super(24, version);
    }

    public NetworkServiceTestSetTestDohConfigParams() {
      this(0);
    }

    public static NetworkServiceTestSetTestDohConfigParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkServiceTestSetTestDohConfigParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkServiceTestSetTestDohConfigParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkServiceTestSetTestDohConfigParams result =
            new NetworkServiceTestSetTestDohConfigParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.secureDnsMode = readInt;
        SecureDnsMode.validate(readInt);
        result.secureDnsMode = SecureDnsMode.toKnownValue(result.secureDnsMode);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.dohConfig = DnsOverHttpsConfig.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.secureDnsMode, 8);
      encoder0.encode((Struct) this.dohConfig, 16, false);
    }
  }

  static final class NetworkServiceTestSetTestDohConfigResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkServiceTestSetTestDohConfigResponseParams(int version) {
      super(8, version);
    }

    public NetworkServiceTestSetTestDohConfigResponseParams() {
      this(0);
    }

    public static NetworkServiceTestSetTestDohConfigResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkServiceTestSetTestDohConfigResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkServiceTestSetTestDohConfigResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkServiceTestSetTestDohConfigResponseParams result =
            new NetworkServiceTestSetTestDohConfigResponseParams(elementsOrVersion);
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

  static class NetworkServiceTestSetTestDohConfigResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NetworkServiceTest.SetTestDohConfig_Response mCallback;

    NetworkServiceTestSetTestDohConfigResponseParamsForwardToCallback(
        NetworkServiceTest.SetTestDohConfig_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(11, 6)) {
          return false;
        }
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NetworkServiceTestSetTestDohConfigResponseParamsProxyToResponder
      implements NetworkServiceTest.SetTestDohConfig_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkServiceTestSetTestDohConfigResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      NetworkServiceTestSetTestDohConfigResponseParams _response =
          new NetworkServiceTestSetTestDohConfigResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(11, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkServiceTestCrashOnResolveHostParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String host;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkServiceTestCrashOnResolveHostParams(int version) {
      super(16, version);
    }

    public NetworkServiceTestCrashOnResolveHostParams() {
      this(0);
    }

    public static NetworkServiceTestCrashOnResolveHostParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkServiceTestCrashOnResolveHostParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkServiceTestCrashOnResolveHostParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkServiceTestCrashOnResolveHostParams result =
            new NetworkServiceTestCrashOnResolveHostParams(elementsOrVersion);
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

  static final class NetworkServiceTestCrashOnGetCookieListParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkServiceTestCrashOnGetCookieListParams(int version) {
      super(8, version);
    }

    public NetworkServiceTestCrashOnGetCookieListParams() {
      this(0);
    }

    public static NetworkServiceTestCrashOnGetCookieListParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkServiceTestCrashOnGetCookieListParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkServiceTestCrashOnGetCookieListParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkServiceTestCrashOnGetCookieListParams result =
            new NetworkServiceTestCrashOnGetCookieListParams(elementsOrVersion);
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

  static final class NetworkServiceTestGetLatestMemoryPressureLevelParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkServiceTestGetLatestMemoryPressureLevelParams(int version) {
      super(8, version);
    }

    public NetworkServiceTestGetLatestMemoryPressureLevelParams() {
      this(0);
    }

    public static NetworkServiceTestGetLatestMemoryPressureLevelParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkServiceTestGetLatestMemoryPressureLevelParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkServiceTestGetLatestMemoryPressureLevelParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkServiceTestGetLatestMemoryPressureLevelParams result =
            new NetworkServiceTestGetLatestMemoryPressureLevelParams(elementsOrVersion);
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

  static final class NetworkServiceTestGetLatestMemoryPressureLevelResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int memoryPressureLevel;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkServiceTestGetLatestMemoryPressureLevelResponseParams(int version) {
      super(16, version);
    }

    public NetworkServiceTestGetLatestMemoryPressureLevelResponseParams() {
      this(0);
    }

    public static NetworkServiceTestGetLatestMemoryPressureLevelResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkServiceTestGetLatestMemoryPressureLevelResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkServiceTestGetLatestMemoryPressureLevelResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkServiceTestGetLatestMemoryPressureLevelResponseParams result =
            new NetworkServiceTestGetLatestMemoryPressureLevelResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.memoryPressureLevel = readInt;
        MemoryPressureLevel.validate(readInt);
        result.memoryPressureLevel = MemoryPressureLevel.toKnownValue(result.memoryPressureLevel);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.memoryPressureLevel, 8);
    }
  }

  static class NetworkServiceTestGetLatestMemoryPressureLevelResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NetworkServiceTest.GetLatestMemoryPressureLevel_Response mCallback;

    NetworkServiceTestGetLatestMemoryPressureLevelResponseParamsForwardToCallback(
        NetworkServiceTest.GetLatestMemoryPressureLevel_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(14, 6)) {
          return false;
        }
        NetworkServiceTestGetLatestMemoryPressureLevelResponseParams response =
            NetworkServiceTestGetLatestMemoryPressureLevelResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.memoryPressureLevel);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NetworkServiceTestGetLatestMemoryPressureLevelResponseParamsProxyToResponder
      implements NetworkServiceTest.GetLatestMemoryPressureLevel_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkServiceTestGetLatestMemoryPressureLevelResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int memoryPressureLevel) {
      NetworkServiceTestGetLatestMemoryPressureLevelResponseParams _response =
          new NetworkServiceTestGetLatestMemoryPressureLevelResponseParams();
      _response.memoryPressureLevel = memoryPressureLevel;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(14, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkServiceTestGetPeerToPeerConnectionsCountChangeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkServiceTestGetPeerToPeerConnectionsCountChangeParams(int version) {
      super(8, version);
    }

    public NetworkServiceTestGetPeerToPeerConnectionsCountChangeParams() {
      this(0);
    }

    public static NetworkServiceTestGetPeerToPeerConnectionsCountChangeParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkServiceTestGetPeerToPeerConnectionsCountChangeParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkServiceTestGetPeerToPeerConnectionsCountChangeParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkServiceTestGetPeerToPeerConnectionsCountChangeParams result =
            new NetworkServiceTestGetPeerToPeerConnectionsCountChangeParams(elementsOrVersion);
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

  static final class NetworkServiceTestGetPeerToPeerConnectionsCountChangeResponseParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int connectionCount;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkServiceTestGetPeerToPeerConnectionsCountChangeResponseParams(int version) {
      super(16, version);
    }

    public NetworkServiceTestGetPeerToPeerConnectionsCountChangeResponseParams() {
      this(0);
    }

    public static NetworkServiceTestGetPeerToPeerConnectionsCountChangeResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkServiceTestGetPeerToPeerConnectionsCountChangeResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkServiceTestGetPeerToPeerConnectionsCountChangeResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkServiceTestGetPeerToPeerConnectionsCountChangeResponseParams result =
            new NetworkServiceTestGetPeerToPeerConnectionsCountChangeResponseParams(
                elementsOrVersion);
        result.connectionCount = decoder0.readInt(8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.connectionCount, 8);
    }
  }

  static class NetworkServiceTestGetPeerToPeerConnectionsCountChangeResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NetworkServiceTest.GetPeerToPeerConnectionsCountChange_Response mCallback;

    NetworkServiceTestGetPeerToPeerConnectionsCountChangeResponseParamsForwardToCallback(
        NetworkServiceTest.GetPeerToPeerConnectionsCountChange_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(15, 6)) {
          return false;
        }
        NetworkServiceTestGetPeerToPeerConnectionsCountChangeResponseParams response =
            NetworkServiceTestGetPeerToPeerConnectionsCountChangeResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.connectionCount);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NetworkServiceTestGetPeerToPeerConnectionsCountChangeResponseParamsProxyToResponder
      implements NetworkServiceTest.GetPeerToPeerConnectionsCountChange_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkServiceTestGetPeerToPeerConnectionsCountChangeResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int connectionCount) {
      NetworkServiceTestGetPeerToPeerConnectionsCountChangeResponseParams _response =
          new NetworkServiceTestGetPeerToPeerConnectionsCountChangeResponseParams();
      _response.connectionCount = connectionCount;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(15, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkServiceTestGetEnvironmentVariableValueParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String name;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkServiceTestGetEnvironmentVariableValueParams(int version) {
      super(16, version);
    }

    public NetworkServiceTestGetEnvironmentVariableValueParams() {
      this(0);
    }

    public static NetworkServiceTestGetEnvironmentVariableValueParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkServiceTestGetEnvironmentVariableValueParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkServiceTestGetEnvironmentVariableValueParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkServiceTestGetEnvironmentVariableValueParams result =
            new NetworkServiceTestGetEnvironmentVariableValueParams(elementsOrVersion);
        result.name = decoder0.readString(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.name, 8, false);
    }
  }

  static final class NetworkServiceTestGetEnvironmentVariableValueResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String value;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkServiceTestGetEnvironmentVariableValueResponseParams(int version) {
      super(16, version);
    }

    public NetworkServiceTestGetEnvironmentVariableValueResponseParams() {
      this(0);
    }

    public static NetworkServiceTestGetEnvironmentVariableValueResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkServiceTestGetEnvironmentVariableValueResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkServiceTestGetEnvironmentVariableValueResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkServiceTestGetEnvironmentVariableValueResponseParams result =
            new NetworkServiceTestGetEnvironmentVariableValueResponseParams(elementsOrVersion);
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

  static class NetworkServiceTestGetEnvironmentVariableValueResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NetworkServiceTest.GetEnvironmentVariableValue_Response mCallback;

    NetworkServiceTestGetEnvironmentVariableValueResponseParamsForwardToCallback(
        NetworkServiceTest.GetEnvironmentVariableValue_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(16, 6)) {
          return false;
        }
        NetworkServiceTestGetEnvironmentVariableValueResponseParams response =
            NetworkServiceTestGetEnvironmentVariableValueResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.value);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NetworkServiceTestGetEnvironmentVariableValueResponseParamsProxyToResponder
      implements NetworkServiceTest.GetEnvironmentVariableValue_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkServiceTestGetEnvironmentVariableValueResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(String value) {
      NetworkServiceTestGetEnvironmentVariableValueResponseParams _response =
          new NetworkServiceTestGetEnvironmentVariableValueResponseParams();
      _response.value = value;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(16, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkServiceTestLogParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String message;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkServiceTestLogParams(int version) {
      super(16, version);
    }

    public NetworkServiceTestLogParams() {
      this(0);
    }

    public static NetworkServiceTestLogParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkServiceTestLogParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkServiceTestLogParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkServiceTestLogParams result = new NetworkServiceTestLogParams(elementsOrVersion);
        result.message = decoder0.readString(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.message, 8, false);
    }
  }

  static final class NetworkServiceTestLogResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkServiceTestLogResponseParams(int version) {
      super(8, version);
    }

    public NetworkServiceTestLogResponseParams() {
      this(0);
    }

    public static NetworkServiceTestLogResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkServiceTestLogResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkServiceTestLogResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkServiceTestLogResponseParams result =
            new NetworkServiceTestLogResponseParams(elementsOrVersion);
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

  static class NetworkServiceTestLogResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final NetworkServiceTest.Log_Response mCallback;

    NetworkServiceTestLogResponseParamsForwardToCallback(NetworkServiceTest.Log_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(17, 6)) {
          return false;
        }
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NetworkServiceTestLogResponseParamsProxyToResponder
      implements NetworkServiceTest.Log_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkServiceTestLogResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      NetworkServiceTestLogResponseParams _response = new NetworkServiceTestLogResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(17, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkServiceTestActivateFieldTrialParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String fieldTrialName;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkServiceTestActivateFieldTrialParams(int version) {
      super(16, version);
    }

    public NetworkServiceTestActivateFieldTrialParams() {
      this(0);
    }

    public static NetworkServiceTestActivateFieldTrialParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkServiceTestActivateFieldTrialParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkServiceTestActivateFieldTrialParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkServiceTestActivateFieldTrialParams result =
            new NetworkServiceTestActivateFieldTrialParams(elementsOrVersion);
        result.fieldTrialName = decoder0.readString(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.fieldTrialName, 8, false);
    }
  }

  static final class NetworkServiceTestSetSctAuditingRetryDelayParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public TimeDelta delay;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkServiceTestSetSctAuditingRetryDelayParams(int version) {
      super(16, version);
    }

    public NetworkServiceTestSetSctAuditingRetryDelayParams() {
      this(0);
    }

    public static NetworkServiceTestSetSctAuditingRetryDelayParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkServiceTestSetSctAuditingRetryDelayParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkServiceTestSetSctAuditingRetryDelayParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkServiceTestSetSctAuditingRetryDelayParams result =
            new NetworkServiceTestSetSctAuditingRetryDelayParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.delay = TimeDelta.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.delay, 8, true);
    }
  }

  static final class NetworkServiceTestSetSctAuditingRetryDelayResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkServiceTestSetSctAuditingRetryDelayResponseParams(int version) {
      super(8, version);
    }

    public NetworkServiceTestSetSctAuditingRetryDelayResponseParams() {
      this(0);
    }

    public static NetworkServiceTestSetSctAuditingRetryDelayResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkServiceTestSetSctAuditingRetryDelayResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkServiceTestSetSctAuditingRetryDelayResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkServiceTestSetSctAuditingRetryDelayResponseParams result =
            new NetworkServiceTestSetSctAuditingRetryDelayResponseParams(elementsOrVersion);
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

  static class NetworkServiceTestSetSctAuditingRetryDelayResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NetworkServiceTest.SetSctAuditingRetryDelay_Response mCallback;

    NetworkServiceTestSetSctAuditingRetryDelayResponseParamsForwardToCallback(
        NetworkServiceTest.SetSctAuditingRetryDelay_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(19, 6)) {
          return false;
        }
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NetworkServiceTestSetSctAuditingRetryDelayResponseParamsProxyToResponder
      implements NetworkServiceTest.SetSctAuditingRetryDelay_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkServiceTestSetSctAuditingRetryDelayResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      NetworkServiceTestSetSctAuditingRetryDelayResponseParams _response =
          new NetworkServiceTestSetSctAuditingRetryDelayResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(19, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkServiceTestOpenFileParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public FilePath path;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkServiceTestOpenFileParams(int version) {
      super(16, version);
    }

    public NetworkServiceTestOpenFileParams() {
      this(0);
    }

    public static NetworkServiceTestOpenFileParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkServiceTestOpenFileParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkServiceTestOpenFileParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkServiceTestOpenFileParams result =
            new NetworkServiceTestOpenFileParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.path = FilePath.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.path, 8, false);
    }
  }

  static final class NetworkServiceTestOpenFileResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkServiceTestOpenFileResponseParams(int version) {
      super(16, version);
    }

    public NetworkServiceTestOpenFileResponseParams() {
      this(0);
    }

    public static NetworkServiceTestOpenFileResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkServiceTestOpenFileResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkServiceTestOpenFileResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkServiceTestOpenFileResponseParams result =
            new NetworkServiceTestOpenFileResponseParams(elementsOrVersion);
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

  static class NetworkServiceTestOpenFileResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NetworkServiceTest.OpenFile_Response mCallback;

    NetworkServiceTestOpenFileResponseParamsForwardToCallback(
        NetworkServiceTest.OpenFile_Response callback) {
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
        NetworkServiceTestOpenFileResponseParams response =
            NetworkServiceTestOpenFileResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NetworkServiceTestOpenFileResponseParamsProxyToResponder
      implements NetworkServiceTest.OpenFile_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkServiceTestOpenFileResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean result) {
      NetworkServiceTestOpenFileResponseParams _response =
          new NetworkServiceTestOpenFileResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(20, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkServiceTestEnumerateFilesParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public HttpCacheBackendFileOperationsFactory factory;
    public FilePath path;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkServiceTestEnumerateFilesParams(int version) {
      super(24, version);
    }

    public NetworkServiceTestEnumerateFilesParams() {
      this(0);
    }

    public static NetworkServiceTestEnumerateFilesParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkServiceTestEnumerateFilesParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkServiceTestEnumerateFilesParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkServiceTestEnumerateFilesParams result =
            new NetworkServiceTestEnumerateFilesParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.path = FilePath.decode(decoder1);
        result.factory =
            (HttpCacheBackendFileOperationsFactory)
                decoder0.readServiceInterface(
                    16, false, HttpCacheBackendFileOperationsFactory.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.path, 8, false);
      encoder0.encode(this.factory, 16, false, HttpCacheBackendFileOperationsFactory.MANAGER);
    }
  }

  static final class NetworkServiceTestEnumerateFilesResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public FileEnumerationEntry[] entries;
    public boolean error;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkServiceTestEnumerateFilesResponseParams(int version) {
      super(24, version);
    }

    public NetworkServiceTestEnumerateFilesResponseParams() {
      this(0);
    }

    public static NetworkServiceTestEnumerateFilesResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkServiceTestEnumerateFilesResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkServiceTestEnumerateFilesResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkServiceTestEnumerateFilesResponseParams result =
            new NetworkServiceTestEnumerateFilesResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.entries = new FileEnumerationEntry[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.entries[i1] = FileEnumerationEntry.decode(decoder2);
        }
        result.error = decoder0.readBoolean(16, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      FileEnumerationEntry[] fileEnumerationEntryArr = this.entries;
      if (fileEnumerationEntryArr == null) {
        encoder0.encodeNullPointer(8, false);
      } else {
        Encoder encoder1 = encoder0.encodePointerArray(fileEnumerationEntryArr.length, 8, -1);
        int i0 = 0;
        while (true) {
          FileEnumerationEntry[] fileEnumerationEntryArr2 = this.entries;
          if (i0 >= fileEnumerationEntryArr2.length) {
            break;
          }
          encoder1.encode((Struct) fileEnumerationEntryArr2[i0], (i0 * 8) + 8, false);
          i0++;
        }
      }
      encoder0.encode(this.error, 16, 0);
    }
  }

  static class NetworkServiceTestEnumerateFilesResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NetworkServiceTest.EnumerateFiles_Response mCallback;

    NetworkServiceTestEnumerateFilesResponseParamsForwardToCallback(
        NetworkServiceTest.EnumerateFiles_Response callback) {
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
        NetworkServiceTestEnumerateFilesResponseParams response =
            NetworkServiceTestEnumerateFilesResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.entries, response.error);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NetworkServiceTestEnumerateFilesResponseParamsProxyToResponder
      implements NetworkServiceTest.EnumerateFiles_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkServiceTestEnumerateFilesResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(FileEnumerationEntry[] entries, boolean error) {
      NetworkServiceTestEnumerateFilesResponseParams _response =
          new NetworkServiceTestEnumerateFilesResponseParams();
      _response.entries = entries;
      _response.error = error;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(21, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkServiceTestCreateSimpleCacheParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public HttpCacheBackendFileOperationsFactory factory;
    public FilePath path;
    public boolean reset;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkServiceTestCreateSimpleCacheParams(int version) {
      super(32, version);
    }

    public NetworkServiceTestCreateSimpleCacheParams() {
      this(0);
    }

    public static NetworkServiceTestCreateSimpleCacheParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkServiceTestCreateSimpleCacheParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkServiceTestCreateSimpleCacheParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkServiceTestCreateSimpleCacheParams result =
            new NetworkServiceTestCreateSimpleCacheParams(elementsOrVersion);
        result.factory =
            (HttpCacheBackendFileOperationsFactory)
                decoder0.readServiceInterface(
                    8, false, HttpCacheBackendFileOperationsFactory.MANAGER);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.path = FilePath.decode(decoder1);
        result.reset = decoder0.readBoolean(24, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.factory, 8, false, HttpCacheBackendFileOperationsFactory.MANAGER);
      encoder0.encode((Struct) this.path, 16, false);
      encoder0.encode(this.reset, 24, 0);
    }
  }

  static final class NetworkServiceTestCreateSimpleCacheResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public SimpleCache backend;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkServiceTestCreateSimpleCacheResponseParams(int version) {
      super(16, version);
    }

    public NetworkServiceTestCreateSimpleCacheResponseParams() {
      this(0);
    }

    public static NetworkServiceTestCreateSimpleCacheResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkServiceTestCreateSimpleCacheResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkServiceTestCreateSimpleCacheResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkServiceTestCreateSimpleCacheResponseParams result =
            new NetworkServiceTestCreateSimpleCacheResponseParams(elementsOrVersion);
        result.backend = (SimpleCache) decoder0.readServiceInterface(8, true, SimpleCache.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.backend, 8, true, SimpleCache.MANAGER);
    }
  }

  static class NetworkServiceTestCreateSimpleCacheResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NetworkServiceTest.CreateSimpleCache_Response mCallback;

    NetworkServiceTestCreateSimpleCacheResponseParamsForwardToCallback(
        NetworkServiceTest.CreateSimpleCache_Response callback) {
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
        NetworkServiceTestCreateSimpleCacheResponseParams response =
            NetworkServiceTestCreateSimpleCacheResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.backend);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NetworkServiceTestCreateSimpleCacheResponseParamsProxyToResponder
      implements NetworkServiceTest.CreateSimpleCache_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkServiceTestCreateSimpleCacheResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(SimpleCache backend) {
      NetworkServiceTestCreateSimpleCacheResponseParams _response =
          new NetworkServiceTestCreateSimpleCacheResponseParams();
      _response.backend = backend;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(22, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkServiceTestMakeRequestToServerParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public IpEndPoint endpoint;
    public TransferableSocket s;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkServiceTestMakeRequestToServerParams(int version) {
      super(24, version);
    }

    public NetworkServiceTestMakeRequestToServerParams() {
      this(0);
    }

    public static NetworkServiceTestMakeRequestToServerParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkServiceTestMakeRequestToServerParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkServiceTestMakeRequestToServerParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkServiceTestMakeRequestToServerParams result =
            new NetworkServiceTestMakeRequestToServerParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.s = TransferableSocket.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.endpoint = IpEndPoint.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.s, 8, false);
      encoder0.encode((Struct) this.endpoint, 16, false);
    }
  }

  static final class NetworkServiceTestMakeRequestToServerResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkServiceTestMakeRequestToServerResponseParams(int version) {
      super(16, version);
    }

    public NetworkServiceTestMakeRequestToServerResponseParams() {
      this(0);
    }

    public static NetworkServiceTestMakeRequestToServerResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkServiceTestMakeRequestToServerResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkServiceTestMakeRequestToServerResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkServiceTestMakeRequestToServerResponseParams result =
            new NetworkServiceTestMakeRequestToServerResponseParams(elementsOrVersion);
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

  static class NetworkServiceTestMakeRequestToServerResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NetworkServiceTest.MakeRequestToServer_Response mCallback;

    NetworkServiceTestMakeRequestToServerResponseParamsForwardToCallback(
        NetworkServiceTest.MakeRequestToServer_Response callback) {
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
        NetworkServiceTestMakeRequestToServerResponseParams response =
            NetworkServiceTestMakeRequestToServerResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NetworkServiceTestMakeRequestToServerResponseParamsProxyToResponder
      implements NetworkServiceTest.MakeRequestToServer_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkServiceTestMakeRequestToServerResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean result) {
      NetworkServiceTestMakeRequestToServerResponseParams _response =
          new NetworkServiceTestMakeRequestToServerResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(23, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkServiceTestResolveOwnHostnameWithSystemDnsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkServiceTestResolveOwnHostnameWithSystemDnsParams(int version) {
      super(8, version);
    }

    public NetworkServiceTestResolveOwnHostnameWithSystemDnsParams() {
      this(0);
    }

    public static NetworkServiceTestResolveOwnHostnameWithSystemDnsParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkServiceTestResolveOwnHostnameWithSystemDnsParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkServiceTestResolveOwnHostnameWithSystemDnsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkServiceTestResolveOwnHostnameWithSystemDnsParams result =
            new NetworkServiceTestResolveOwnHostnameWithSystemDnsParams(elementsOrVersion);
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

  static final class NetworkServiceTestResolveOwnHostnameWithSystemDnsResponseParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public AddressList addrList;
    public int netError;
    public int osError;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkServiceTestResolveOwnHostnameWithSystemDnsResponseParams(int version) {
      super(24, version);
    }

    public NetworkServiceTestResolveOwnHostnameWithSystemDnsResponseParams() {
      this(0);
    }

    public static NetworkServiceTestResolveOwnHostnameWithSystemDnsResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkServiceTestResolveOwnHostnameWithSystemDnsResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkServiceTestResolveOwnHostnameWithSystemDnsResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkServiceTestResolveOwnHostnameWithSystemDnsResponseParams result =
            new NetworkServiceTestResolveOwnHostnameWithSystemDnsResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.addrList = AddressList.decode(decoder1);
        result.osError = decoder0.readInt(16);
        result.netError = decoder0.readInt(20);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.addrList, 8, false);
      encoder0.encode(this.osError, 16);
      encoder0.encode(this.netError, 20);
    }
  }

  static class NetworkServiceTestResolveOwnHostnameWithSystemDnsResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NetworkServiceTest.ResolveOwnHostnameWithSystemDns_Response mCallback;

    NetworkServiceTestResolveOwnHostnameWithSystemDnsResponseParamsForwardToCallback(
        NetworkServiceTest.ResolveOwnHostnameWithSystemDns_Response callback) {
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
        NetworkServiceTestResolveOwnHostnameWithSystemDnsResponseParams response =
            NetworkServiceTestResolveOwnHostnameWithSystemDnsResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.addrList, response.osError, response.netError);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NetworkServiceTestResolveOwnHostnameWithSystemDnsResponseParamsProxyToResponder
      implements NetworkServiceTest.ResolveOwnHostnameWithSystemDns_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkServiceTestResolveOwnHostnameWithSystemDnsResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(AddressList addrList, int osError, int netError) {
      NetworkServiceTestResolveOwnHostnameWithSystemDnsResponseParams _response =
          new NetworkServiceTestResolveOwnHostnameWithSystemDnsResponseParams();
      _response.addrList = addrList;
      _response.osError = osError;
      _response.netError = netError;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(24, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkServiceTestSetIPv6ProbeResultParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean success;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkServiceTestSetIPv6ProbeResultParams(int version) {
      super(16, version);
    }

    public NetworkServiceTestSetIPv6ProbeResultParams() {
      this(0);
    }

    public static NetworkServiceTestSetIPv6ProbeResultParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkServiceTestSetIPv6ProbeResultParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkServiceTestSetIPv6ProbeResultParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkServiceTestSetIPv6ProbeResultParams result =
            new NetworkServiceTestSetIPv6ProbeResultParams(elementsOrVersion);
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

  static final class NetworkServiceTestSetIPv6ProbeResultResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkServiceTestSetIPv6ProbeResultResponseParams(int version) {
      super(8, version);
    }

    public NetworkServiceTestSetIPv6ProbeResultResponseParams() {
      this(0);
    }

    public static NetworkServiceTestSetIPv6ProbeResultResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkServiceTestSetIPv6ProbeResultResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkServiceTestSetIPv6ProbeResultResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkServiceTestSetIPv6ProbeResultResponseParams result =
            new NetworkServiceTestSetIPv6ProbeResultResponseParams(elementsOrVersion);
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

  static class NetworkServiceTestSetIPv6ProbeResultResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NetworkServiceTest.SetIPv6ProbeResult_Response mCallback;

    NetworkServiceTestSetIPv6ProbeResultResponseParamsForwardToCallback(
        NetworkServiceTest.SetIPv6ProbeResult_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(25, 2)) {
          return false;
        }
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NetworkServiceTestSetIPv6ProbeResultResponseParamsProxyToResponder
      implements NetworkServiceTest.SetIPv6ProbeResult_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkServiceTestSetIPv6ProbeResultResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      NetworkServiceTestSetIPv6ProbeResultResponseParams _response =
          new NetworkServiceTestSetIPv6ProbeResultResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(25, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class NetworkServiceTestAllowsGssapiLibraryLoadParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkServiceTestAllowsGssapiLibraryLoadParams(int version) {
      super(8, version);
    }

    public NetworkServiceTestAllowsGssapiLibraryLoadParams() {
      this(0);
    }

    public static NetworkServiceTestAllowsGssapiLibraryLoadParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkServiceTestAllowsGssapiLibraryLoadParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkServiceTestAllowsGssapiLibraryLoadParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkServiceTestAllowsGssapiLibraryLoadParams result =
            new NetworkServiceTestAllowsGssapiLibraryLoadParams(elementsOrVersion);
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

  static final class NetworkServiceTestAllowsGssapiLibraryLoadResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean allowGssapiLibraryLoad;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NetworkServiceTestAllowsGssapiLibraryLoadResponseParams(int version) {
      super(16, version);
    }

    public NetworkServiceTestAllowsGssapiLibraryLoadResponseParams() {
      this(0);
    }

    public static NetworkServiceTestAllowsGssapiLibraryLoadResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static NetworkServiceTestAllowsGssapiLibraryLoadResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkServiceTestAllowsGssapiLibraryLoadResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NetworkServiceTestAllowsGssapiLibraryLoadResponseParams result =
            new NetworkServiceTestAllowsGssapiLibraryLoadResponseParams(elementsOrVersion);
        result.allowGssapiLibraryLoad = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.allowGssapiLibraryLoad, 8, 0);
    }
  }

  static class NetworkServiceTestAllowsGssapiLibraryLoadResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final NetworkServiceTest.AllowsGssapiLibraryLoad_Response mCallback;

    NetworkServiceTestAllowsGssapiLibraryLoadResponseParamsForwardToCallback(
        NetworkServiceTest.AllowsGssapiLibraryLoad_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(26, 6)) {
          return false;
        }
        NetworkServiceTestAllowsGssapiLibraryLoadResponseParams response =
            NetworkServiceTestAllowsGssapiLibraryLoadResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.allowGssapiLibraryLoad);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class NetworkServiceTestAllowsGssapiLibraryLoadResponseParamsProxyToResponder
      implements NetworkServiceTest.AllowsGssapiLibraryLoad_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    NetworkServiceTestAllowsGssapiLibraryLoadResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean allowGssapiLibraryLoad) {
      NetworkServiceTestAllowsGssapiLibraryLoadResponseParams _response =
          new NetworkServiceTestAllowsGssapiLibraryLoadResponseParams();
      _response.allowGssapiLibraryLoad = allowGssapiLibraryLoad;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(26, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
