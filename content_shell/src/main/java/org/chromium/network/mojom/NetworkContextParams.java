package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.blink.mojom.CssSampleId;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.TimeDelta;
import org.chromium.proxy_resolver.mojom.ProxyResolverFactory;

public final class NetworkContextParams extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 248;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean acamPreflightSpecConformant;
  public String acceptLanguage;
  public boolean afpBlockListExperimentEnabled;
  public boolean allowAnyCorsExemptHeaderForBrowser;
  public boolean blockTrustTokens;
  public CertVerifierServiceRemoteParams certVerifierParams;
  public boolean checkClearTextPermitted;
  public String cookieDeprecationLabel;
  public CookieEncryptionProvider cookieEncryptionProvider;
  public InterfaceRequest<CookieManager> cookieManager;
  public CookieManagerParams cookieManagerParams;
  public String[] corsExemptHeaderList;
  public CorsOriginAccessPatterns[] corsOriginAccessList;
  public CtPolicy ctPolicy;
  public InterfaceRequest<CustomProxyConfigClient> customProxyConfigClientReceiver;
  public CustomProxyConnectionObserver customProxyConnectionObserverRemote;
  public boolean disableIdleSocketsCloseOnMemoryPressure;
  public boolean discardDomainReliablityUploads;
  public String domainReliabilityUploadReporter;
  public boolean enableBrotli;
  public boolean enableCertificateReporting;
  public boolean enableDomainReliability;
  public boolean enableEncryptedCookies;
  public boolean enableIpProtection;
  public boolean enableReferrers;
  public boolean enableZstd;
  public boolean enforceChromeCtPolicy;
  public NetworkContextFilePaths filePaths;
  public FirstPartySetsAccessDelegateParams firstPartySetsAccessDelegateParams;
  public InterfaceRequest<FirstPartySetsAccessDelegate> firstPartySetsAccessDelegateReceiver;
  public String[] hstsPolicyBypassList;
  public HttpAuthStaticNetworkContextParams httpAuthStaticNetworkContextParams;
  public boolean httpCacheEnabled;
  public HttpCacheBackendFileOperationsFactory httpCacheFileOperationsFactory;
  public int httpCacheMaxSize;
  public CustomProxyConfig initialCustomProxyConfig;
  public ProxyConfigWithAnnotation initialProxyConfig;
  public SslConfig initialSslConfig;
  public IpProtectionConfigGetter ipProtectionConfigGetter;
  public InterfaceRequest<IpProtectionProxyDelegate> ipProtectionProxyDelegate;
  public boolean pacQuickCheckEnabled;
  public boolean persistSessionCookies;
  public InterfaceRequest<ProxyConfigClient> proxyConfigClientReceiver;
  public ProxyConfigPollerClient proxyConfigPollerClient;
  public ProxyErrorClient proxyErrorClient;
  public ProxyResolverFactory proxyResolverFactory;
  public TimeDelta reportingDeliveryInterval;
  public boolean requireNetworkAnonymizationKey;
  public boolean resetHttpCacheBackend;
  public boolean restoreOldSessionCookies;
  public int sctAuditingMode;
  public long sharedDictionaryCacheMaxSize;
  public boolean sharedDictionaryEnabled;
  public boolean skipReportingSendPermissionCheck;
  public boolean splitAuthCacheByNetworkAnonymizationKey;
  public InterfaceRequest<SslConfigClient> sslConfigClientReceiver;
  public String userAgent;
  public boolean validateReferrerPolicyOnInitialRequest;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(248, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private NetworkContextParams(int version) {
    super(248, version);
    this.enableBrotli = true;
    this.enableZstd = false;
    this.enableReferrers = true;
    this.validateReferrerPolicyOnInitialRequest = true;
    this.enableEncryptedCookies = true;
    this.restoreOldSessionCookies = false;
    this.persistSessionCookies = false;
    this.httpCacheEnabled = true;
    this.httpCacheMaxSize = 0;
    this.checkClearTextPermitted = false;
    this.disableIdleSocketsCloseOnMemoryPressure = false;
    this.enableIpProtection = false;
    this.pacQuickCheckEnabled = true;
    this.enableCertificateReporting = false;
    this.enforceChromeCtPolicy = false;
    this.sctAuditingMode = 0;
    this.enableDomainReliability = false;
    this.discardDomainReliablityUploads = false;
    this.skipReportingSendPermissionCheck = false;
    this.allowAnyCorsExemptHeaderForBrowser = false;
    this.resetHttpCacheBackend = false;
    this.splitAuthCacheByNetworkAnonymizationKey = false;
    this.requireNetworkAnonymizationKey = false;
    this.sharedDictionaryEnabled = false;
    this.sharedDictionaryCacheMaxSize = 0L;
    this.acamPreflightSpecConformant = true;
    this.afpBlockListExperimentEnabled = false;
  }

  public NetworkContextParams() {
    this(0);
  }

  public static NetworkContextParams deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static NetworkContextParams deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static NetworkContextParams decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      NetworkContextParams result = new NetworkContextParams(elementsOrVersion);
      result.userAgent = decoder0.readString(8, false);
      result.acceptLanguage = decoder0.readString(16, false);
      result.enableBrotli = decoder0.readBoolean(24, 0);
      result.enableZstd = decoder0.readBoolean(24, 1);
      result.enableReferrers = decoder0.readBoolean(24, 2);
      result.validateReferrerPolicyOnInitialRequest = decoder0.readBoolean(24, 3);
      result.enableEncryptedCookies = decoder0.readBoolean(24, 4);
      result.restoreOldSessionCookies = decoder0.readBoolean(24, 5);
      result.persistSessionCookies = decoder0.readBoolean(24, 6);
      result.httpCacheEnabled = decoder0.readBoolean(24, 7);
      result.checkClearTextPermitted = decoder0.readBoolean(25, 0);
      result.disableIdleSocketsCloseOnMemoryPressure = decoder0.readBoolean(25, 1);
      result.enableIpProtection = decoder0.readBoolean(25, 2);
      result.pacQuickCheckEnabled = decoder0.readBoolean(25, 3);
      result.enableCertificateReporting = decoder0.readBoolean(25, 4);
      result.enforceChromeCtPolicy = decoder0.readBoolean(25, 5);
      result.enableDomainReliability = decoder0.readBoolean(25, 6);
      result.discardDomainReliablityUploads = decoder0.readBoolean(25, 7);
      result.skipReportingSendPermissionCheck = decoder0.readBoolean(26, 0);
      result.allowAnyCorsExemptHeaderForBrowser = decoder0.readBoolean(26, 1);
      result.resetHttpCacheBackend = decoder0.readBoolean(26, 2);
      result.splitAuthCacheByNetworkAnonymizationKey = decoder0.readBoolean(26, 3);
      result.requireNetworkAnonymizationKey = decoder0.readBoolean(26, 4);
      result.blockTrustTokens = decoder0.readBoolean(26, 5);
      result.sharedDictionaryEnabled = decoder0.readBoolean(26, 6);
      result.acamPreflightSpecConformant = decoder0.readBoolean(26, 7);
      result.afpBlockListExperimentEnabled = decoder0.readBoolean(27, 0);
      result.proxyResolverFactory =
          (ProxyResolverFactory)
              decoder0.readServiceInterface(28, true, ProxyResolverFactory.MANAGER);
      result.httpCacheMaxSize = decoder0.readInt(36);
      result.httpCacheFileOperationsFactory =
          (HttpCacheBackendFileOperationsFactory)
              decoder0.readServiceInterface(
                  40, true, HttpCacheBackendFileOperationsFactory.MANAGER);
      Decoder decoder1 = decoder0.readPointer(48, true);
      result.initialSslConfig = SslConfig.decode(decoder1);
      result.sslConfigClientReceiver = decoder0.readInterfaceRequest(56, true);
      result.proxyConfigClientReceiver = decoder0.readInterfaceRequest(60, true);
      Decoder decoder12 = decoder0.readPointer(64, true);
      result.initialProxyConfig = ProxyConfigWithAnnotation.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(72, true);
      result.initialCustomProxyConfig = CustomProxyConfig.decode(decoder13);
      result.customProxyConfigClientReceiver = decoder0.readInterfaceRequest(80, true);
      result.customProxyConnectionObserverRemote =
          (CustomProxyConnectionObserver)
              decoder0.readServiceInterface(84, true, CustomProxyConnectionObserver.MANAGER);
      result.proxyConfigPollerClient =
          (ProxyConfigPollerClient)
              decoder0.readServiceInterface(92, true, ProxyConfigPollerClient.MANAGER);
      result.proxyErrorClient =
          (ProxyErrorClient) decoder0.readServiceInterface(100, true, ProxyErrorClient.MANAGER);
      result.ipProtectionConfigGetter =
          (IpProtectionConfigGetter)
              decoder0.readServiceInterface(108, true, IpProtectionConfigGetter.MANAGER);
      result.ipProtectionProxyDelegate = decoder0.readInterfaceRequest(116, true);
      int readInt = decoder0.readInt(120);
      result.sctAuditingMode = readInt;
      SctAuditingMode.validate(readInt);
      result.sctAuditingMode = SctAuditingMode.toKnownValue(result.sctAuditingMode);
      result.cookieManager = decoder0.readInterfaceRequest(124, true);
      Decoder decoder14 = decoder0.readPointer(128, true);
      result.ctPolicy = CtPolicy.decode(decoder14);
      Decoder decoder15 = decoder0.readPointer(136, false);
      result.certVerifierParams = CertVerifierServiceRemoteParams.decode(decoder15);
      Decoder decoder16 = decoder0.readPointer(144, true);
      result.cookieManagerParams = CookieManagerParams.decode(decoder16);
      result.domainReliabilityUploadReporter = decoder0.readString(152, false);
      Decoder decoder17 = decoder0.readPointer(160, true);
      result.reportingDeliveryInterval = TimeDelta.decode(decoder17);
      Decoder decoder18 = decoder0.readPointer(168, false);
      DataHeader si1 = decoder18.readDataHeaderForPointerArray(-1);
      result.corsOriginAccessList = new CorsOriginAccessPatterns[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder18.readPointer((i1 * 8) + 8, false);
        result.corsOriginAccessList[i1] = CorsOriginAccessPatterns.decode(decoder2);
      }
      Decoder decoder19 = decoder0.readPointer(176, false);
      DataHeader si12 = decoder19.readDataHeaderForPointerArray(-1);
      result.corsExemptHeaderList = new String[si12.elementsOrVersion];
      for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
        result.corsExemptHeaderList[i12] = decoder19.readString((i12 * 8) + 8, false);
      }
      Decoder decoder110 = decoder0.readPointer(184, false);
      DataHeader si13 = decoder110.readDataHeaderForPointerArray(-1);
      result.hstsPolicyBypassList = new String[si13.elementsOrVersion];
      for (int i13 = 0; i13 < si13.elementsOrVersion; i13++) {
        result.hstsPolicyBypassList[i13] = decoder110.readString((i13 * 8) + 8, false);
      }
      Decoder decoder111 = decoder0.readPointer(192, true);
      result.httpAuthStaticNetworkContextParams =
          HttpAuthStaticNetworkContextParams.decode(decoder111);
      Decoder decoder112 = decoder0.readPointer(200, true);
      result.filePaths = NetworkContextFilePaths.decode(decoder112);
      result.sharedDictionaryCacheMaxSize = decoder0.readLong(208);
      Decoder decoder113 = decoder0.readPointer(216, true);
      result.firstPartySetsAccessDelegateParams =
          FirstPartySetsAccessDelegateParams.decode(decoder113);
      result.firstPartySetsAccessDelegateReceiver =
          decoder0.readInterfaceRequest(CssSampleId.ALIAS_WEBKIT_COLUMN_RULE_WIDTH, true);
      result.cookieDeprecationLabel = decoder0.readString(232, true);
      result.cookieEncryptionProvider =
          (CookieEncryptionProvider)
              decoder0.readServiceInterface(240, true, CookieEncryptionProvider.MANAGER);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.userAgent, 8, false);
    encoder0.encode(this.acceptLanguage, 16, false);
    encoder0.encode(this.enableBrotli, 24, 0);
    encoder0.encode(this.enableZstd, 24, 1);
    encoder0.encode(this.enableReferrers, 24, 2);
    encoder0.encode(this.validateReferrerPolicyOnInitialRequest, 24, 3);
    encoder0.encode(this.enableEncryptedCookies, 24, 4);
    encoder0.encode(this.restoreOldSessionCookies, 24, 5);
    encoder0.encode(this.persistSessionCookies, 24, 6);
    encoder0.encode(this.httpCacheEnabled, 24, 7);
    encoder0.encode(this.checkClearTextPermitted, 25, 0);
    encoder0.encode(this.disableIdleSocketsCloseOnMemoryPressure, 25, 1);
    encoder0.encode(this.enableIpProtection, 25, 2);
    encoder0.encode(this.pacQuickCheckEnabled, 25, 3);
    encoder0.encode(this.enableCertificateReporting, 25, 4);
    encoder0.encode(this.enforceChromeCtPolicy, 25, 5);
    encoder0.encode(this.enableDomainReliability, 25, 6);
    encoder0.encode(this.discardDomainReliablityUploads, 25, 7);
    encoder0.encode(this.skipReportingSendPermissionCheck, 26, 0);
    encoder0.encode(this.allowAnyCorsExemptHeaderForBrowser, 26, 1);
    encoder0.encode(this.resetHttpCacheBackend, 26, 2);
    encoder0.encode(this.splitAuthCacheByNetworkAnonymizationKey, 26, 3);
    encoder0.encode(this.requireNetworkAnonymizationKey, 26, 4);
    encoder0.encode(this.blockTrustTokens, 26, 5);
    encoder0.encode(this.sharedDictionaryEnabled, 26, 6);
    encoder0.encode(this.acamPreflightSpecConformant, 26, 7);
    encoder0.encode(this.afpBlockListExperimentEnabled, 27, 0);
    encoder0.encode(this.proxyResolverFactory, 28, true, ProxyResolverFactory.MANAGER);
    encoder0.encode(this.httpCacheMaxSize, 36);
    encoder0.encode(
        this.httpCacheFileOperationsFactory,
        40,
        true,
        HttpCacheBackendFileOperationsFactory.MANAGER);
    encoder0.encode((Struct) this.initialSslConfig, 48, true);
    encoder0.encode((InterfaceRequest) this.sslConfigClientReceiver, 56, true);
    encoder0.encode((InterfaceRequest) this.proxyConfigClientReceiver, 60, true);
    encoder0.encode((Struct) this.initialProxyConfig, 64, true);
    encoder0.encode((Struct) this.initialCustomProxyConfig, 72, true);
    encoder0.encode((InterfaceRequest) this.customProxyConfigClientReceiver, 80, true);
    encoder0.encode(
        this.customProxyConnectionObserverRemote, 84, true, CustomProxyConnectionObserver.MANAGER);
    encoder0.encode(this.proxyConfigPollerClient, 92, true, ProxyConfigPollerClient.MANAGER);
    encoder0.encode(this.proxyErrorClient, 100, true, ProxyErrorClient.MANAGER);
    encoder0.encode(this.ipProtectionConfigGetter, 108, true, IpProtectionConfigGetter.MANAGER);
    encoder0.encode((InterfaceRequest) this.ipProtectionProxyDelegate, 116, true);
    encoder0.encode(this.sctAuditingMode, 120);
    encoder0.encode((InterfaceRequest) this.cookieManager, 124, true);
    encoder0.encode((Struct) this.ctPolicy, 128, true);
    encoder0.encode((Struct) this.certVerifierParams, 136, false);
    encoder0.encode((Struct) this.cookieManagerParams, 144, true);
    encoder0.encode(this.domainReliabilityUploadReporter, 152, false);
    encoder0.encode((Struct) this.reportingDeliveryInterval, 160, true);
    CorsOriginAccessPatterns[] corsOriginAccessPatternsArr = this.corsOriginAccessList;
    if (corsOriginAccessPatternsArr == null) {
      encoder0.encodeNullPointer(168, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(corsOriginAccessPatternsArr.length, 168, -1);
      int i0 = 0;
      while (true) {
        CorsOriginAccessPatterns[] corsOriginAccessPatternsArr2 = this.corsOriginAccessList;
        if (i0 >= corsOriginAccessPatternsArr2.length) {
          break;
        }
        encoder1.encode((Struct) corsOriginAccessPatternsArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    String[] strArr = this.corsExemptHeaderList;
    if (strArr == null) {
      encoder0.encodeNullPointer(176, false);
    } else {
      Encoder encoder12 = encoder0.encodePointerArray(strArr.length, 176, -1);
      int i02 = 0;
      while (true) {
        String[] strArr2 = this.corsExemptHeaderList;
        if (i02 >= strArr2.length) {
          break;
        }
        encoder12.encode(strArr2[i02], (i02 * 8) + 8, false);
        i02++;
      }
    }
    String[] strArr3 = this.hstsPolicyBypassList;
    if (strArr3 == null) {
      encoder0.encodeNullPointer(184, false);
    } else {
      Encoder encoder13 = encoder0.encodePointerArray(strArr3.length, 184, -1);
      int i03 = 0;
      while (true) {
        String[] strArr4 = this.hstsPolicyBypassList;
        if (i03 >= strArr4.length) {
          break;
        }
        encoder13.encode(strArr4[i03], (i03 * 8) + 8, false);
        i03++;
      }
    }
    encoder0.encode((Struct) this.httpAuthStaticNetworkContextParams, 192, true);
    encoder0.encode((Struct) this.filePaths, 200, true);
    encoder0.encode(this.sharedDictionaryCacheMaxSize, 208);
    encoder0.encode((Struct) this.firstPartySetsAccessDelegateParams, 216, true);
    encoder0.encode(
        (InterfaceRequest) this.firstPartySetsAccessDelegateReceiver,
        CssSampleId.ALIAS_WEBKIT_COLUMN_RULE_WIDTH,
        true);
    encoder0.encode(this.cookieDeprecationLabel, 232, true);
    encoder0.encode(this.cookieEncryptionProvider, 240, true, CookieEncryptionProvider.MANAGER);
  }
}
