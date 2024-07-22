package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.blink.mojom.CssSampleId;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.UnguessableToken;
import org.chromium.url.internal.mojom.Origin;
import org.chromium.url.mojom.Url;

public final class UrlRequest extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 280;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean adAuctionHeaders;
  public int attributionReportingEligibility;
  public AttributionReportingRuntimeFeatures attributionReportingRuntimeFeatures;
  public UnguessableToken attributionReportingSrcToken;
  public int attributionReportingSupport;
  public boolean browsingTopics;
  public HttpRequestHeaders corsExemptHeaders;
  public int corsPreflightPolicy;
  public String createdLocation;
  public int credentialsMode;
  public int destination;
  public int[] devtoolsAcceptedStreamTypes;
  public String devtoolsRequestId;
  public String devtoolsStackId;
  public boolean doNotPromptForLogin;
  public boolean enableLoadTiming;
  public boolean enableUploadProgress;
  public String fetchIntegrity;
  public UnguessableToken fetchWindowId;
  public boolean hasStorageAccess;
  public boolean hasUserGesture;
  public HttpRequestHeaders headers;
  public boolean isAdTagged;
  public boolean isFavicon;
  public boolean isFetchLaterApi;
  public boolean isFetchLikeApi;
  public boolean isOutermostMainFrame;
  public boolean isRevalidating;
  public Origin isolatedWorldOrigin;
  public boolean keepalive;
  public int loadFlags;
  public String method;
  public int mode;
  public Url[] navigationRedirectChain;
  public NetLogSource netLogCreateInfo;
  public NetLogSource netLogReferenceInfo;
  public int originalDestination;
  public boolean originatedFromServiceWorker;
  public int previewsState;
  public int priority;
  public boolean priorityIncremental;
  public UnguessableToken recursivePrefetchToken;
  public int redirectMode;
  public Url referrer;
  public int referrerPolicy;
  public UrlRequestBody requestBody;
  public Origin requestInitiator;
  public int requiredIpAddressSpace;
  public int resourceType;
  public boolean sharedDictionaryWriterEnabled;
  public boolean sharedStorageWritableEligible;
  public SiteForCookies siteForCookies;
  public boolean skipServiceWorker;
  public int targetIpAddressSpace;
  public UnguessableToken throttlingProfileId;
  public int transitionType;
  public TrustTokenParams trustTokenParams;
  public TrustedUrlRequestParams trustedParams;
  public boolean updateFirstPartyUrlOnRedirect;
  public boolean upgradeIfInsecure;
  public Url url;
  public WebBundleTokenParams webBundleTokenParams;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(280, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private UrlRequest(int version) {
    super(280, version);
    this.attributionReportingEligibility = 0;
    this.isAdTagged = false;
    this.sharedDictionaryWriterEnabled = false;
  }

  public UrlRequest() {
    this(0);
  }

  public static UrlRequest deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static UrlRequest deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static UrlRequest decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      UrlRequest result = new UrlRequest(elementsOrVersion);
      result.method = decoder0.readString(8, false);
      Decoder decoder1 = decoder0.readPointer(16, false);
      result.url = Url.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(24, false);
      result.siteForCookies = SiteForCookies.decode(decoder12);
      result.updateFirstPartyUrlOnRedirect = decoder0.readBoolean(32, 0);
      result.priorityIncremental = decoder0.readBoolean(32, 1);
      result.originatedFromServiceWorker = decoder0.readBoolean(32, 2);
      result.skipServiceWorker = decoder0.readBoolean(32, 3);
      result.keepalive = decoder0.readBoolean(32, 4);
      result.browsingTopics = decoder0.readBoolean(32, 5);
      result.adAuctionHeaders = decoder0.readBoolean(32, 6);
      result.sharedStorageWritableEligible = decoder0.readBoolean(32, 7);
      result.hasUserGesture = decoder0.readBoolean(33, 0);
      result.enableLoadTiming = decoder0.readBoolean(33, 1);
      result.enableUploadProgress = decoder0.readBoolean(33, 2);
      result.doNotPromptForLogin = decoder0.readBoolean(33, 3);
      result.isOutermostMainFrame = decoder0.readBoolean(33, 4);
      result.upgradeIfInsecure = decoder0.readBoolean(33, 5);
      result.isRevalidating = decoder0.readBoolean(33, 6);
      result.isFetchLikeApi = decoder0.readBoolean(33, 7);
      result.isFetchLaterApi = decoder0.readBoolean(34, 0);
      result.isFavicon = decoder0.readBoolean(34, 1);
      result.hasStorageAccess = decoder0.readBoolean(34, 2);
      result.isAdTagged = decoder0.readBoolean(34, 3);
      result.sharedDictionaryWriterEnabled = decoder0.readBoolean(34, 4);
      int readInt = decoder0.readInt(36);
      result.referrerPolicy = readInt;
      UrlRequestReferrerPolicy.validate(readInt);
      result.referrerPolicy = UrlRequestReferrerPolicy.toKnownValue(result.referrerPolicy);
      Decoder decoder13 = decoder0.readPointer(40, true);
      result.requestInitiator = Origin.decode(decoder13);
      Decoder decoder14 = decoder0.readPointer(48, false);
      DataHeader si1 = decoder14.readDataHeaderForPointerArray(-1);
      result.navigationRedirectChain = new Url[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder14.readPointer((i1 * 8) + 8, false);
        result.navigationRedirectChain[i1] = Url.decode(decoder2);
      }
      Decoder decoder15 = decoder0.readPointer(56, true);
      result.isolatedWorldOrigin = Origin.decode(decoder15);
      Decoder decoder16 = decoder0.readPointer(64, false);
      result.referrer = Url.decode(decoder16);
      Decoder decoder17 = decoder0.readPointer(72, false);
      result.headers = HttpRequestHeaders.decode(decoder17);
      Decoder decoder18 = decoder0.readPointer(80, false);
      result.corsExemptHeaders = HttpRequestHeaders.decode(decoder18);
      result.loadFlags = decoder0.readInt(88);
      result.resourceType = decoder0.readInt(92);
      int readInt2 = decoder0.readInt(96);
      result.priority = readInt2;
      RequestPriority.validate(readInt2);
      result.priority = RequestPriority.toKnownValue(result.priority);
      int readInt3 = decoder0.readInt(100);
      result.corsPreflightPolicy = readInt3;
      CorsPreflightPolicy.validate(readInt3);
      result.corsPreflightPolicy = CorsPreflightPolicy.toKnownValue(result.corsPreflightPolicy);
      int readInt4 = decoder0.readInt(104);
      result.mode = readInt4;
      RequestMode.validate(readInt4);
      result.mode = RequestMode.toKnownValue(result.mode);
      int readInt5 = decoder0.readInt(108);
      result.credentialsMode = readInt5;
      CredentialsMode.validate(readInt5);
      result.credentialsMode = CredentialsMode.toKnownValue(result.credentialsMode);
      int readInt6 = decoder0.readInt(112);
      result.redirectMode = readInt6;
      RedirectMode.validate(readInt6);
      result.redirectMode = RedirectMode.toKnownValue(result.redirectMode);
      int readInt7 = decoder0.readInt(116);
      result.destination = readInt7;
      RequestDestination.validate(readInt7);
      result.destination = RequestDestination.toKnownValue(result.destination);
      result.fetchIntegrity = decoder0.readString(120, false);
      Decoder decoder19 = decoder0.readPointer(128, true);
      result.requestBody = UrlRequestBody.decode(decoder19);
      result.transitionType = decoder0.readInt(136);
      result.previewsState = decoder0.readInt(140);
      Decoder decoder110 = decoder0.readPointer(144, true);
      result.throttlingProfileId = UnguessableToken.decode(decoder110);
      Decoder decoder111 = decoder0.readPointer(152, true);
      result.fetchWindowId = UnguessableToken.decode(decoder111);
      result.devtoolsRequestId = decoder0.readString(160, true);
      result.devtoolsStackId = decoder0.readString(168, true);
      int readInt8 = decoder0.readInt(176);
      result.originalDestination = readInt8;
      RequestDestination.validate(readInt8);
      result.originalDestination = RequestDestination.toKnownValue(result.originalDestination);
      int readInt9 = decoder0.readInt(180);
      result.targetIpAddressSpace = readInt9;
      IpAddressSpace.validate(readInt9);
      result.targetIpAddressSpace = IpAddressSpace.toKnownValue(result.targetIpAddressSpace);
      Decoder decoder112 = decoder0.readPointer(184, true);
      result.trustedParams = TrustedUrlRequestParams.decode(decoder112);
      Decoder decoder113 = decoder0.readPointer(192, true);
      result.recursivePrefetchToken = UnguessableToken.decode(decoder113);
      Decoder decoder114 = decoder0.readPointer(200, true);
      result.trustTokenParams = TrustTokenParams.decode(decoder114);
      Decoder decoder115 = decoder0.readPointer(208, true);
      result.webBundleTokenParams = WebBundleTokenParams.decode(decoder115);
      int[] readInts = decoder0.readInts(216, 1, -1);
      result.devtoolsAcceptedStreamTypes = readInts;
      if (readInts != null) {
        int i12 = 0;
        while (true) {
          int[] iArr = result.devtoolsAcceptedStreamTypes;
          if (i12 >= iArr.length) {
            break;
          }
          SourceType.validate(iArr[i12]);
          i12++;
        }
      }
      Decoder decoder116 = decoder0.readPointer(CssSampleId.ALIAS_WEBKIT_COLUMN_RULE_WIDTH, true);
      result.netLogCreateInfo = NetLogSource.decode(decoder116);
      Decoder decoder117 = decoder0.readPointer(232, true);
      result.netLogReferenceInfo = NetLogSource.decode(decoder117);
      int readInt10 = decoder0.readInt(240);
      result.requiredIpAddressSpace = readInt10;
      IpAddressSpace.validate(readInt10);
      result.requiredIpAddressSpace = IpAddressSpace.toKnownValue(result.requiredIpAddressSpace);
      int readInt11 = decoder0.readInt(244);
      result.attributionReportingSupport = readInt11;
      AttributionSupport.validate(readInt11);
      result.attributionReportingSupport =
          AttributionSupport.toKnownValue(result.attributionReportingSupport);
      int readInt12 = decoder0.readInt(248);
      result.attributionReportingEligibility = readInt12;
      AttributionReportingEligibility.validate(readInt12);
      result.attributionReportingEligibility =
          AttributionReportingEligibility.toKnownValue(result.attributionReportingEligibility);
      Decoder decoder118 = decoder0.readPointer(256, false);
      result.attributionReportingRuntimeFeatures =
          AttributionReportingRuntimeFeatures.decode(decoder118);
      Decoder decoder119 = decoder0.readPointer(264, true);
      result.attributionReportingSrcToken = UnguessableToken.decode(decoder119);
      result.createdLocation = decoder0.readString(CssSampleId.ALIAS_WEBKIT_MARGIN_END, false);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.method, 8, false);
    encoder0.encode((Struct) this.url, 16, false);
    encoder0.encode((Struct) this.siteForCookies, 24, false);
    encoder0.encode(this.updateFirstPartyUrlOnRedirect, 32, 0);
    encoder0.encode(this.priorityIncremental, 32, 1);
    encoder0.encode(this.originatedFromServiceWorker, 32, 2);
    encoder0.encode(this.skipServiceWorker, 32, 3);
    encoder0.encode(this.keepalive, 32, 4);
    encoder0.encode(this.browsingTopics, 32, 5);
    encoder0.encode(this.adAuctionHeaders, 32, 6);
    encoder0.encode(this.sharedStorageWritableEligible, 32, 7);
    encoder0.encode(this.hasUserGesture, 33, 0);
    encoder0.encode(this.enableLoadTiming, 33, 1);
    encoder0.encode(this.enableUploadProgress, 33, 2);
    encoder0.encode(this.doNotPromptForLogin, 33, 3);
    encoder0.encode(this.isOutermostMainFrame, 33, 4);
    encoder0.encode(this.upgradeIfInsecure, 33, 5);
    encoder0.encode(this.isRevalidating, 33, 6);
    encoder0.encode(this.isFetchLikeApi, 33, 7);
    encoder0.encode(this.isFetchLaterApi, 34, 0);
    encoder0.encode(this.isFavicon, 34, 1);
    encoder0.encode(this.hasStorageAccess, 34, 2);
    encoder0.encode(this.isAdTagged, 34, 3);
    encoder0.encode(this.sharedDictionaryWriterEnabled, 34, 4);
    encoder0.encode(this.referrerPolicy, 36);
    encoder0.encode((Struct) this.requestInitiator, 40, true);
    Url[] urlArr = this.navigationRedirectChain;
    if (urlArr == null) {
      encoder0.encodeNullPointer(48, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(urlArr.length, 48, -1);
      int i0 = 0;
      while (true) {
        Url[] urlArr2 = this.navigationRedirectChain;
        if (i0 >= urlArr2.length) {
          break;
        }
        encoder1.encode((Struct) urlArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    encoder0.encode((Struct) this.isolatedWorldOrigin, 56, true);
    encoder0.encode((Struct) this.referrer, 64, false);
    encoder0.encode((Struct) this.headers, 72, false);
    encoder0.encode((Struct) this.corsExemptHeaders, 80, false);
    encoder0.encode(this.loadFlags, 88);
    encoder0.encode(this.resourceType, 92);
    encoder0.encode(this.priority, 96);
    encoder0.encode(this.corsPreflightPolicy, 100);
    encoder0.encode(this.mode, 104);
    encoder0.encode(this.credentialsMode, 108);
    encoder0.encode(this.redirectMode, 112);
    encoder0.encode(this.destination, 116);
    encoder0.encode(this.fetchIntegrity, 120, false);
    encoder0.encode((Struct) this.requestBody, 128, true);
    encoder0.encode(this.transitionType, 136);
    encoder0.encode(this.previewsState, 140);
    encoder0.encode((Struct) this.throttlingProfileId, 144, true);
    encoder0.encode((Struct) this.fetchWindowId, 152, true);
    encoder0.encode(this.devtoolsRequestId, 160, true);
    encoder0.encode(this.devtoolsStackId, 168, true);
    encoder0.encode(this.originalDestination, 176);
    encoder0.encode(this.targetIpAddressSpace, 180);
    encoder0.encode((Struct) this.trustedParams, 184, true);
    encoder0.encode((Struct) this.recursivePrefetchToken, 192, true);
    encoder0.encode((Struct) this.trustTokenParams, 200, true);
    encoder0.encode((Struct) this.webBundleTokenParams, 208, true);
    encoder0.encode(this.devtoolsAcceptedStreamTypes, 216, 1, -1);
    encoder0.encode(
        (Struct) this.netLogCreateInfo, CssSampleId.ALIAS_WEBKIT_COLUMN_RULE_WIDTH, true);
    encoder0.encode((Struct) this.netLogReferenceInfo, 232, true);
    encoder0.encode(this.requiredIpAddressSpace, 240);
    encoder0.encode(this.attributionReportingSupport, 244);
    encoder0.encode(this.attributionReportingEligibility, 248);
    encoder0.encode((Struct) this.attributionReportingRuntimeFeatures, 256, false);
    encoder0.encode((Struct) this.attributionReportingSrcToken, 264, true);
    encoder0.encode(this.createdLocation, CssSampleId.ALIAS_WEBKIT_MARGIN_END, false);
  }
}
