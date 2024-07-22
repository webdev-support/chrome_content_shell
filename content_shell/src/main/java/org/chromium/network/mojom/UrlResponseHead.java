package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.blink.mojom.CssSampleId;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.Time;
import org.chromium.mojo_base.mojom.TimeTicks;
import org.chromium.mojo_base.mojom.UnguessableToken;
import org.chromium.url.mojom.Url;

public final class UrlResponseHead extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 248;
  private static final DataHeader[] VERSION_ARRAY;
  public String alpnNegotiatedProtocol;
  public int alternateProtocolUsage;
  public boolean asyncRevalidationRequested;
  public AuthChallengeInfo authChallengeInfo;
  public String cacheStorageCacheName;
  public int certStatus;
  public String charset;
  public int clientAddressSpace;
  public int connectionInfo;
  public long contentLength;
  public String[] corsExposedHeaderNames;
  public boolean didMimeSniff;
  public boolean didServiceWorkerNavigationPreload;
  public boolean didUseSharedDictionary;
  public String[] dnsAliases;
  public boolean emittedExtraInfo;
  public EncodedBodyLength encodedBodyLength;
  public long encodedDataLength;
  public boolean hasAuthorizationCoveredByWildcardOnPreflight;
  public boolean hasRangeRequested;
  public HttpResponseHeaders headers;
  public boolean interceptedByPlugin;
  public boolean isPrefetchWithCrossSiteContamination;
  public boolean isSignedExchangeInnerResponse;
  public boolean isValidated;
  public boolean isWebBundleInnerResponse;
  public LoadTimingInfo loadTiming;
  public String mimeType;
  public int navigationDeliveryType;
  public boolean networkAccessed;
  public long padding;
  public ParsedHeaders parsedHeaders;
  public int privateNetworkAccessPreflightResult;
  public ProxyChain proxyChain;
  public UnguessableToken recursivePrefetchToken;
  public IpEndPoint remoteEndpoint;
  public boolean requestIncludeCredentials;
  public TimeTicks requestStart;
  public Time requestTime;
  public int responseAddressSpace;
  public TimeTicks responseStart;
  public Time responseTime;
  public int responseType;
  public int serviceWorkerResponseSource;
  public ServiceWorkerRouterInfo serviceWorkerRouterInfo;
  public boolean shouldUseSourceHashForJsCodeCache;
  public SslInfo sslInfo;
  public boolean timingAllowPassed;
  public TriggerVerification[] triggerVerifications;
  public Url[] urlListViaServiceWorker;
  public boolean wasAlpnNegotiated;
  public boolean wasAlternateProtocolAvailable;
  public boolean wasCookieInRequest;
  public boolean wasFetchedViaCache;
  public boolean wasFetchedViaServiceWorker;
  public boolean wasFetchedViaSpdy;
  public boolean wasInPrefetchCache;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(248, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private UrlResponseHead(int version) {
    super(248, version);
    this.contentLength = -1L;
    this.encodedDataLength = -1L;
    this.networkAccessed = false;
    this.emittedExtraInfo = false;
    this.wasFetchedViaSpdy = false;
    this.wasAlpnNegotiated = false;
    this.wasAlternateProtocolAvailable = false;
    this.clientAddressSpace = 3;
    this.responseAddressSpace = 3;
    this.isValidated = false;
    this.wasFetchedViaCache = false;
    this.navigationDeliveryType = 0;
    this.wasFetchedViaServiceWorker = false;
    this.serviceWorkerResponseSource = 0;
    this.responseType = 2;
    this.padding = 0L;
    this.certStatus = 0;
    this.didServiceWorkerNavigationPreload = false;
    this.asyncRevalidationRequested = false;
    this.didMimeSniff = false;
    this.isSignedExchangeInnerResponse = false;
    this.isWebBundleInnerResponse = false;
    this.wasInPrefetchCache = false;
    this.isPrefetchWithCrossSiteContamination = false;
    this.wasCookieInRequest = false;
    this.interceptedByPlugin = false;
    this.hasRangeRequested = false;
    this.timingAllowPassed = false;
    this.hasAuthorizationCoveredByWildcardOnPreflight = false;
    this.requestIncludeCredentials = true;
    this.shouldUseSourceHashForJsCodeCache = false;
    this.privateNetworkAccessPreflightResult = 0;
    this.didUseSharedDictionary = false;
  }

  public UrlResponseHead() {
    this(0);
  }

  public static UrlResponseHead deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static UrlResponseHead deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static UrlResponseHead decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      UrlResponseHead result = new UrlResponseHead(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.requestTime = Time.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.responseTime = Time.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(24, false);
      result.headers = HttpResponseHeaders.decode(decoder13);
      result.mimeType = decoder0.readString(32, false);
      result.charset = decoder0.readString(40, false);
      result.contentLength = decoder0.readLong(48);
      result.encodedDataLength = decoder0.readLong(56);
      Decoder decoder14 = decoder0.readPointer(64, true);
      result.encodedBodyLength = EncodedBodyLength.decode(decoder14);
      result.networkAccessed = decoder0.readBoolean(72, 0);
      result.emittedExtraInfo = decoder0.readBoolean(72, 1);
      result.wasFetchedViaSpdy = decoder0.readBoolean(72, 2);
      result.wasAlpnNegotiated = decoder0.readBoolean(72, 3);
      result.wasAlternateProtocolAvailable = decoder0.readBoolean(72, 4);
      result.isValidated = decoder0.readBoolean(72, 5);
      result.wasFetchedViaCache = decoder0.readBoolean(72, 6);
      result.wasFetchedViaServiceWorker = decoder0.readBoolean(72, 7);
      result.didServiceWorkerNavigationPreload = decoder0.readBoolean(73, 0);
      result.asyncRevalidationRequested = decoder0.readBoolean(73, 1);
      result.didMimeSniff = decoder0.readBoolean(73, 2);
      result.isSignedExchangeInnerResponse = decoder0.readBoolean(73, 3);
      result.isWebBundleInnerResponse = decoder0.readBoolean(73, 4);
      result.wasInPrefetchCache = decoder0.readBoolean(73, 5);
      result.isPrefetchWithCrossSiteContamination = decoder0.readBoolean(73, 6);
      result.wasCookieInRequest = decoder0.readBoolean(73, 7);
      result.interceptedByPlugin = decoder0.readBoolean(74, 0);
      result.hasRangeRequested = decoder0.readBoolean(74, 1);
      result.timingAllowPassed = decoder0.readBoolean(74, 2);
      result.hasAuthorizationCoveredByWildcardOnPreflight = decoder0.readBoolean(74, 3);
      result.requestIncludeCredentials = decoder0.readBoolean(74, 4);
      result.shouldUseSourceHashForJsCodeCache = decoder0.readBoolean(74, 5);
      result.didUseSharedDictionary = decoder0.readBoolean(74, 6);
      int readInt = decoder0.readInt(76);
      result.connectionInfo = readInt;
      ConnectionInfo.validate(readInt);
      result.connectionInfo = ConnectionInfo.toKnownValue(result.connectionInfo);
      Decoder decoder15 = decoder0.readPointer(80, false);
      result.loadTiming = LoadTimingInfo.decode(decoder15);
      result.alpnNegotiatedProtocol = decoder0.readString(88, false);
      int readInt2 = decoder0.readInt(96);
      result.alternateProtocolUsage = readInt2;
      AlternateProtocolUsage.validate(readInt2);
      result.alternateProtocolUsage =
          AlternateProtocolUsage.toKnownValue(result.alternateProtocolUsage);
      int readInt3 = decoder0.readInt(100);
      result.clientAddressSpace = readInt3;
      IpAddressSpace.validate(readInt3);
      result.clientAddressSpace = IpAddressSpace.toKnownValue(result.clientAddressSpace);
      Decoder decoder16 = decoder0.readPointer(104, false);
      result.remoteEndpoint = IpEndPoint.decode(decoder16);
      int readInt4 = decoder0.readInt(112);
      result.responseAddressSpace = readInt4;
      IpAddressSpace.validate(readInt4);
      result.responseAddressSpace = IpAddressSpace.toKnownValue(result.responseAddressSpace);
      int readInt5 = decoder0.readInt(116);
      result.navigationDeliveryType = readInt5;
      NavigationDeliveryType.validate(readInt5);
      result.navigationDeliveryType =
          NavigationDeliveryType.toKnownValue(result.navigationDeliveryType);
      Decoder decoder17 = decoder0.readPointer(120, false);
      result.proxyChain = ProxyChain.decode(decoder17);
      int readInt6 = decoder0.readInt(128);
      result.serviceWorkerResponseSource = readInt6;
      FetchResponseSource.validate(readInt6);
      result.serviceWorkerResponseSource =
          FetchResponseSource.toKnownValue(result.serviceWorkerResponseSource);
      int readInt7 = decoder0.readInt(132);
      result.responseType = readInt7;
      FetchResponseType.validate(readInt7);
      result.responseType = FetchResponseType.toKnownValue(result.responseType);
      Decoder decoder18 = decoder0.readPointer(136, false);
      DataHeader si1 = decoder18.readDataHeaderForPointerArray(-1);
      result.urlListViaServiceWorker = new Url[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder18.readPointer((i1 * 8) + 8, false);
        result.urlListViaServiceWorker[i1] = Url.decode(decoder2);
      }
      Decoder decoder19 = decoder0.readPointer(144, true);
      result.serviceWorkerRouterInfo = ServiceWorkerRouterInfo.decode(decoder19);
      result.padding = decoder0.readLong(152);
      result.cacheStorageCacheName = decoder0.readString(160, false);
      result.certStatus = decoder0.readInt(168);
      int readInt8 = decoder0.readInt(172);
      result.privateNetworkAccessPreflightResult = readInt8;
      PrivateNetworkAccessPreflightResult.validate(readInt8);
      result.privateNetworkAccessPreflightResult =
          PrivateNetworkAccessPreflightResult.toKnownValue(
              result.privateNetworkAccessPreflightResult);
      Decoder decoder110 = decoder0.readPointer(176, true);
      result.sslInfo = SslInfo.decode(decoder110);
      Decoder decoder111 = decoder0.readPointer(184, false);
      DataHeader si12 = decoder111.readDataHeaderForPointerArray(-1);
      result.corsExposedHeaderNames = new String[si12.elementsOrVersion];
      for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
        result.corsExposedHeaderNames[i12] = decoder111.readString((i12 * 8) + 8, false);
      }
      Decoder decoder112 = decoder0.readPointer(192, true);
      result.authChallengeInfo = AuthChallengeInfo.decode(decoder112);
      Decoder decoder113 = decoder0.readPointer(200, false);
      result.requestStart = TimeTicks.decode(decoder113);
      Decoder decoder114 = decoder0.readPointer(208, false);
      result.responseStart = TimeTicks.decode(decoder114);
      Decoder decoder115 = decoder0.readPointer(216, true);
      result.parsedHeaders = ParsedHeaders.decode(decoder115);
      Decoder decoder116 = decoder0.readPointer(CssSampleId.ALIAS_WEBKIT_COLUMN_RULE_WIDTH, true);
      result.recursivePrefetchToken = UnguessableToken.decode(decoder116);
      Decoder decoder117 = decoder0.readPointer(232, false);
      DataHeader si13 = decoder117.readDataHeaderForPointerArray(-1);
      result.dnsAliases = new String[si13.elementsOrVersion];
      for (int i13 = 0; i13 < si13.elementsOrVersion; i13++) {
        result.dnsAliases[i13] = decoder117.readString((i13 * 8) + 8, false);
      }
      Decoder decoder118 = decoder0.readPointer(240, false);
      DataHeader si14 = decoder118.readDataHeaderForPointerArray(-1);
      result.triggerVerifications = new TriggerVerification[si14.elementsOrVersion];
      for (int i14 = 0; i14 < si14.elementsOrVersion; i14++) {
        Decoder decoder22 = decoder118.readPointer((i14 * 8) + 8, false);
        result.triggerVerifications[i14] = TriggerVerification.decode(decoder22);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.requestTime, 8, false);
    encoder0.encode((Struct) this.responseTime, 16, false);
    encoder0.encode((Struct) this.headers, 24, false);
    encoder0.encode(this.mimeType, 32, false);
    encoder0.encode(this.charset, 40, false);
    encoder0.encode(this.contentLength, 48);
    encoder0.encode(this.encodedDataLength, 56);
    encoder0.encode((Struct) this.encodedBodyLength, 64, true);
    encoder0.encode(this.networkAccessed, 72, 0);
    encoder0.encode(this.emittedExtraInfo, 72, 1);
    encoder0.encode(this.wasFetchedViaSpdy, 72, 2);
    encoder0.encode(this.wasAlpnNegotiated, 72, 3);
    encoder0.encode(this.wasAlternateProtocolAvailable, 72, 4);
    encoder0.encode(this.isValidated, 72, 5);
    encoder0.encode(this.wasFetchedViaCache, 72, 6);
    encoder0.encode(this.wasFetchedViaServiceWorker, 72, 7);
    encoder0.encode(this.didServiceWorkerNavigationPreload, 73, 0);
    encoder0.encode(this.asyncRevalidationRequested, 73, 1);
    encoder0.encode(this.didMimeSniff, 73, 2);
    encoder0.encode(this.isSignedExchangeInnerResponse, 73, 3);
    encoder0.encode(this.isWebBundleInnerResponse, 73, 4);
    encoder0.encode(this.wasInPrefetchCache, 73, 5);
    encoder0.encode(this.isPrefetchWithCrossSiteContamination, 73, 6);
    encoder0.encode(this.wasCookieInRequest, 73, 7);
    encoder0.encode(this.interceptedByPlugin, 74, 0);
    encoder0.encode(this.hasRangeRequested, 74, 1);
    encoder0.encode(this.timingAllowPassed, 74, 2);
    encoder0.encode(this.hasAuthorizationCoveredByWildcardOnPreflight, 74, 3);
    encoder0.encode(this.requestIncludeCredentials, 74, 4);
    encoder0.encode(this.shouldUseSourceHashForJsCodeCache, 74, 5);
    encoder0.encode(this.didUseSharedDictionary, 74, 6);
    encoder0.encode(this.connectionInfo, 76);
    encoder0.encode((Struct) this.loadTiming, 80, false);
    encoder0.encode(this.alpnNegotiatedProtocol, 88, false);
    encoder0.encode(this.alternateProtocolUsage, 96);
    encoder0.encode(this.clientAddressSpace, 100);
    encoder0.encode((Struct) this.remoteEndpoint, 104, false);
    encoder0.encode(this.responseAddressSpace, 112);
    encoder0.encode(this.navigationDeliveryType, 116);
    encoder0.encode((Struct) this.proxyChain, 120, false);
    encoder0.encode(this.serviceWorkerResponseSource, 128);
    encoder0.encode(this.responseType, 132);
    Url[] urlArr = this.urlListViaServiceWorker;
    if (urlArr == null) {
      encoder0.encodeNullPointer(136, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(urlArr.length, 136, -1);
      int i0 = 0;
      while (true) {
        Url[] urlArr2 = this.urlListViaServiceWorker;
        if (i0 >= urlArr2.length) {
          break;
        }
        encoder1.encode((Struct) urlArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    encoder0.encode((Struct) this.serviceWorkerRouterInfo, 144, true);
    encoder0.encode(this.padding, 152);
    encoder0.encode(this.cacheStorageCacheName, 160, false);
    encoder0.encode(this.certStatus, 168);
    encoder0.encode(this.privateNetworkAccessPreflightResult, 172);
    encoder0.encode((Struct) this.sslInfo, 176, true);
    String[] strArr = this.corsExposedHeaderNames;
    if (strArr == null) {
      encoder0.encodeNullPointer(184, false);
    } else {
      Encoder encoder12 = encoder0.encodePointerArray(strArr.length, 184, -1);
      int i02 = 0;
      while (true) {
        String[] strArr2 = this.corsExposedHeaderNames;
        if (i02 >= strArr2.length) {
          break;
        }
        encoder12.encode(strArr2[i02], (i02 * 8) + 8, false);
        i02++;
      }
    }
    encoder0.encode((Struct) this.authChallengeInfo, 192, true);
    encoder0.encode((Struct) this.requestStart, 200, false);
    encoder0.encode((Struct) this.responseStart, 208, false);
    encoder0.encode((Struct) this.parsedHeaders, 216, true);
    encoder0.encode(
        (Struct) this.recursivePrefetchToken, CssSampleId.ALIAS_WEBKIT_COLUMN_RULE_WIDTH, true);
    String[] strArr3 = this.dnsAliases;
    if (strArr3 == null) {
      encoder0.encodeNullPointer(232, false);
    } else {
      Encoder encoder13 = encoder0.encodePointerArray(strArr3.length, 232, -1);
      int i03 = 0;
      while (true) {
        String[] strArr4 = this.dnsAliases;
        if (i03 >= strArr4.length) {
          break;
        }
        encoder13.encode(strArr4[i03], (i03 * 8) + 8, false);
        i03++;
      }
    }
    TriggerVerification[] triggerVerificationArr = this.triggerVerifications;
    if (triggerVerificationArr == null) {
      encoder0.encodeNullPointer(240, false);
      return;
    }
    Encoder encoder14 = encoder0.encodePointerArray(triggerVerificationArr.length, 240, -1);
    int i04 = 0;
    while (true) {
      TriggerVerification[] triggerVerificationArr2 = this.triggerVerifications;
      if (i04 < triggerVerificationArr2.length) {
        encoder14.encode((Struct) triggerVerificationArr2[i04], (i04 * 8) + 8, false);
        i04++;
      } else {
        return;
      }
    }
  }
}
