package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.TimeTicks;
import org.chromium.mojo_base.mojom.UnguessableToken;
import org.chromium.network.mojom.NavigationDeliveryType;
import org.chromium.network.mojom.UrlRequestRedirectInfo;
import org.chromium.network.mojom.UrlResponseHead;
import org.chromium.network.mojom.WebClientHintsType;
import org.chromium.url.internal.mojom.Origin;
import org.chromium.url.mojom.Url;

public final class CommitNavigationParams extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 312;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean ancestorOrSelfHasCspee;
  public BrowsingContextGroupInfo browsingContextGroupInfo;
  public boolean canLoadLocalResources;
  public TimeTicks commitSent;
  public RendererContentSettings contentSettings;
  public String cookieDeprecationLabel;
  public int currentHistoryListLength;
  public int currentHistoryListOffset;
  public String dataUrlAsString;
  public long documentUkmSourceId;
  public Url[] earlyHintsPreloadedResources;
  public int[] enabledClientHints;
  public FencedFrameProperties fencedFrameProperties;
  public String[] forceEnabledOriginTrials;
  public FramePolicy framePolicy;
  public int httpResponseCode;
  public boolean intendedAsNewEntry;
  public boolean isBrowserInitiated;
  public boolean isCrossSiteCrossBrowsingContextGroup;
  public boolean isLoadDataWithBaseUrl;
  public boolean isOverridingUserAgent;
  public boolean isViewSource;
  public LcpCriticalPathPredictorNavigationTimeHint lcppHint;
  public boolean loadWithStorageAccess;
  public Map<Integer, Boolean> modifiedRuntimeFeatures;
  public int navEntryId;
  public NavigationApiHistoryEntryArrays navigationApiHistoryEntryArrays;
  public int navigationDeliveryType;
  public NavigationTiming navigationTiming;
  public UnguessableToken navigationToken;
  public BackForwardCacheNotRestoredReasons notRestoredReasons;
  public OldPageInfo oldPageInfo;
  public boolean originAgentCluster;
  public boolean originAgentClusterLeftAsDefault;
  public Origin originToCommit;
  public String originalMethod;
  public Url originalUrl;
  public String pageState;
  public int pendingHistoryListOffset;
  public String postContentType;
  public PrefetchedSignedExchangeInfo[] prefetchedSignedExchanges;
  public UrlRequestRedirectInfo[] redirectInfos;
  public UrlResponseHead[] redirectResponse;
  public Url[] redirects;
  public String reducedAcceptLanguage;
  public StorageKey sessionStorageKey;
  public boolean shouldClearHistoryList;
  public TaskAttributionId softNavigationHeuristicsTaskId;
  public String srcdocValue;
  public StorageKey storageKey;
  public Map<String, Boolean> subframeUniqueNames;
  public ViewTransitionState viewTransitionState;
  public int wasActivated;
  public boolean wasDiscarded;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(312, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private CommitNavigationParams(int version) {
    super(312, version);
    this.isOverridingUserAgent = false;
    this.canLoadLocalResources = false;
    this.navEntryId = 0;
    this.intendedAsNewEntry = false;
    this.pendingHistoryListOffset = -1;
    this.currentHistoryListOffset = -1;
    this.currentHistoryListLength = 0;
    this.wasDiscarded = false;
    this.isViewSource = false;
    this.shouldClearHistoryList = false;
    this.wasActivated = 0;
    this.isBrowserInitiated = false;
    this.originAgentCluster = false;
    this.originAgentClusterLeftAsDefault = true;
    this.isCrossSiteCrossBrowsingContextGroup = false;
    this.httpResponseCode = -1;
    this.isLoadDataWithBaseUrl = false;
    this.ancestorOrSelfHasCspee = false;
    this.navigationDeliveryType = 0;
    this.loadWithStorageAccess = false;
  }

  public CommitNavigationParams() {
    this(0);
  }

  public static CommitNavigationParams deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static CommitNavigationParams deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static CommitNavigationParams decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      CommitNavigationParams result = new CommitNavigationParams(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, true);
      result.originToCommit = Origin.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.storageKey = StorageKey.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(24, false);
      result.sessionStorageKey = StorageKey.decode(decoder13);
      result.isOverridingUserAgent = decoder0.readBoolean(32, 0);
      result.canLoadLocalResources = decoder0.readBoolean(32, 1);
      result.intendedAsNewEntry = decoder0.readBoolean(32, 2);
      result.wasDiscarded = decoder0.readBoolean(32, 3);
      result.isViewSource = decoder0.readBoolean(32, 4);
      result.shouldClearHistoryList = decoder0.readBoolean(32, 5);
      result.isBrowserInitiated = decoder0.readBoolean(32, 6);
      result.originAgentCluster = decoder0.readBoolean(32, 7);
      result.originAgentClusterLeftAsDefault = decoder0.readBoolean(33, 0);
      result.isCrossSiteCrossBrowsingContextGroup = decoder0.readBoolean(33, 1);
      result.isLoadDataWithBaseUrl = decoder0.readBoolean(33, 2);
      result.ancestorOrSelfHasCspee = decoder0.readBoolean(33, 3);
      result.loadWithStorageAccess = decoder0.readBoolean(33, 4);
      result.navEntryId = decoder0.readInt(36);
      Decoder decoder14 = decoder0.readPointer(40, false);
      DataHeader si1 = decoder14.readDataHeaderForPointerArray(-1);
      result.redirects = new Url[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        result.redirects[i1] = Url.decode(decoder14.readPointer((i1 * 8) + 8, false));
      }
      Decoder decoder15 = decoder0.readPointer(48, false);
      DataHeader si12 = decoder15.readDataHeaderForPointerArray(-1);
      result.redirectResponse = new UrlResponseHead[si12.elementsOrVersion];
      for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
        result.redirectResponse[i12] =
            UrlResponseHead.decode(decoder15.readPointer((i12 * 8) + 8, false));
      }
      Decoder decoder16 = decoder0.readPointer(56, false);
      DataHeader si13 = decoder16.readDataHeaderForPointerArray(-1);
      result.redirectInfos = new UrlRequestRedirectInfo[si13.elementsOrVersion];
      for (int i13 = 0; i13 < si13.elementsOrVersion; i13++) {
        result.redirectInfos[i13] =
            UrlRequestRedirectInfo.decode(decoder16.readPointer((i13 * 8) + 8, false));
      }
      result.postContentType = decoder0.readString(64, false);
      Decoder decoder17 = decoder0.readPointer(72, false);
      result.originalUrl = Url.decode(decoder17);
      result.originalMethod = decoder0.readString(80, false);
      result.pageState = decoder0.readString(88, false);
      Decoder decoder18 = decoder0.readPointer(96, false);
      decoder18.readDataHeaderForMap();
      Decoder decoder2 = decoder18.readPointer(8, false);
      DataHeader si2 = decoder2.readDataHeaderForPointerArray(-1);
      String[] keys0 = new String[si2.elementsOrVersion];
      for (int i2 = 0; i2 < si2.elementsOrVersion; i2++) {
        keys0[i2] = decoder2.readString((i2 * 8) + 8, false);
      }
      boolean[] values0 = decoder18.readBooleans(16, 0, keys0.length);
      result.subframeUniqueNames = new HashMap();
      for (int index0 = 0; index0 < keys0.length; index0++) {
        result.subframeUniqueNames.put(keys0[index0], Boolean.valueOf(values0[index0]));
      }
      result.pendingHistoryListOffset = decoder0.readInt(104);
      result.currentHistoryListOffset = decoder0.readInt(108);
      result.currentHistoryListLength = decoder0.readInt(112);
      int readInt = decoder0.readInt(116);
      result.wasActivated = readInt;
      WasActivatedOption.validate(readInt);
      result.wasActivated = WasActivatedOption.toKnownValue(result.wasActivated);
      Decoder decoder19 = decoder0.readPointer(120, false);
      result.navigationTiming = NavigationTiming.decode(decoder19);
      Decoder decoder110 = decoder0.readPointer(128, false);
      result.navigationToken = UnguessableToken.decode(decoder110);
      Decoder decoder111 = decoder0.readPointer(136, false);
      DataHeader si14 = decoder111.readDataHeaderForPointerArray(-1);
      result.prefetchedSignedExchanges = new PrefetchedSignedExchangeInfo[si14.elementsOrVersion];
      for (int i14 = 0; i14 < si14.elementsOrVersion; i14++) {
        result.prefetchedSignedExchanges[i14] =
            PrefetchedSignedExchangeInfo.decode(decoder111.readPointer((i14 * 8) + 8, false));
      }
      result.dataUrlAsString = decoder0.readString(144, false);
      result.documentUkmSourceId = decoder0.readLong(152);
      Decoder decoder112 = decoder0.readPointer(160, false);
      result.framePolicy = FramePolicy.decode(decoder112);
      Decoder decoder113 = decoder0.readPointer(168, false);
      DataHeader si15 = decoder113.readDataHeaderForPointerArray(-1);
      result.forceEnabledOriginTrials = new String[si15.elementsOrVersion];
      for (int i15 = 0; i15 < si15.elementsOrVersion; i15++) {
        result.forceEnabledOriginTrials[i15] = decoder113.readString((i15 * 8) + 8, false);
      }
      result.enabledClientHints = decoder0.readInts(176, 0, -1);
      int i16 = 0;
      while (true) {
        int[] iArr = result.enabledClientHints;
        if (i16 >= iArr.length) {
          break;
        }
        WebClientHintsType.validate(iArr[i16]);
        i16++;
      }
      Decoder decoder114 = decoder0.readPointer(184, true);
      result.oldPageInfo = OldPageInfo.decode(decoder114);
      result.httpResponseCode = decoder0.readInt(192);
      int readInt2 = decoder0.readInt(196);
      result.navigationDeliveryType = readInt2;
      NavigationDeliveryType.validate(readInt2);
      result.navigationDeliveryType =
          NavigationDeliveryType.toKnownValue(result.navigationDeliveryType);
      Decoder decoder115 = decoder0.readPointer(200, false);
      result.navigationApiHistoryEntryArrays = NavigationApiHistoryEntryArrays.decode(decoder115);
      Decoder decoder116 = decoder0.readPointer(208, false);
      DataHeader si16 = decoder116.readDataHeaderForPointerArray(-1);
      result.earlyHintsPreloadedResources = new Url[si16.elementsOrVersion];
      for (int i17 = 0; i17 < si16.elementsOrVersion; i17++) {
        result.earlyHintsPreloadedResources[i17] =
            Url.decode(decoder116.readPointer((i17 * 8) + 8, false));
      }
      Decoder decoder117 = decoder0.readPointer(216, false);
      result.commitSent = TimeTicks.decode(decoder117);
      result.srcdocValue = decoder0.readString(CssSampleId.ALIAS_WEBKIT_COLUMN_RULE_WIDTH, false);
      result.reducedAcceptLanguage = decoder0.readString(232, false);
      Decoder decoder118 = decoder0.readPointer(240, true);
      result.viewTransitionState = ViewTransitionState.decode(decoder118);
      Decoder decoder119 = decoder0.readPointer(248, true);
      result.softNavigationHeuristicsTaskId = TaskAttributionId.decode(decoder119);
      Decoder decoder120 = decoder0.readPointer(256, false);
      decoder120.readDataHeaderForMap();
      int[] keys02 = decoder120.readInts(8, 0, -1);
      for (int i : keys02) {
        RuntimeFeature.validate(i);
      }
      int i22 = keys02.length;
      boolean[] values02 = decoder120.readBooleans(16, 0, i22);
      result.modifiedRuntimeFeatures = new HashMap();
      for (int index02 = 0; index02 < keys02.length; index02++) {
        result.modifiedRuntimeFeatures.put(
            Integer.valueOf(keys02[index02]), Boolean.valueOf(values02[index02]));
      }
      Decoder decoder121 = decoder0.readPointer(264, true);
      result.fencedFrameProperties = FencedFrameProperties.decode(decoder121);
      Decoder decoder122 = decoder0.readPointer(CssSampleId.ALIAS_WEBKIT_MARGIN_END, true);
      result.notRestoredReasons = BackForwardCacheNotRestoredReasons.decode(decoder122);
      Decoder decoder123 = decoder0.readPointer(CssSampleId.WEBKIT_MASK, true);
      result.browsingContextGroupInfo = BrowsingContextGroupInfo.decode(decoder123);
      Decoder decoder124 = decoder0.readPointer(288, true);
      result.lcppHint = LcpCriticalPathPredictorNavigationTimeHint.decode(decoder124);
      Decoder decoder125 =
          decoder0.readPointer(WebFeature.DOCUMENT_X_PATH_CREATE_NS_RESOLVER, false);
      result.contentSettings = RendererContentSettings.decode(decoder125);
      result.cookieDeprecationLabel = decoder0.readString(304, true);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.originToCommit, 8, true);
    encoder0.encode((Struct) this.storageKey, 16, false);
    encoder0.encode((Struct) this.sessionStorageKey, 24, false);
    encoder0.encode(this.isOverridingUserAgent, 32, 0);
    encoder0.encode(this.canLoadLocalResources, 32, 1);
    encoder0.encode(this.intendedAsNewEntry, 32, 2);
    encoder0.encode(this.wasDiscarded, 32, 3);
    encoder0.encode(this.isViewSource, 32, 4);
    encoder0.encode(this.shouldClearHistoryList, 32, 5);
    encoder0.encode(this.isBrowserInitiated, 32, 6);
    encoder0.encode(this.originAgentCluster, 32, 7);
    encoder0.encode(this.originAgentClusterLeftAsDefault, 33, 0);
    encoder0.encode(this.isCrossSiteCrossBrowsingContextGroup, 33, 1);
    encoder0.encode(this.isLoadDataWithBaseUrl, 33, 2);
    encoder0.encode(this.ancestorOrSelfHasCspee, 33, 3);
    encoder0.encode(this.loadWithStorageAccess, 33, 4);
    encoder0.encode(this.navEntryId, 36);
    Url[] urlArr = this.redirects;
    if (urlArr == null) {
      encoder0.encodeNullPointer(40, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(urlArr.length, 40, -1);
      int i0 = 0;
      while (true) {
        Url[] urlArr2 = this.redirects;
        if (i0 >= urlArr2.length) {
          break;
        }
        encoder1.encode((Struct) urlArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    UrlResponseHead[] urlResponseHeadArr = this.redirectResponse;
    if (urlResponseHeadArr == null) {
      encoder0.encodeNullPointer(48, false);
    } else {
      Encoder encoder12 = encoder0.encodePointerArray(urlResponseHeadArr.length, 48, -1);
      int i02 = 0;
      while (true) {
        UrlResponseHead[] urlResponseHeadArr2 = this.redirectResponse;
        if (i02 >= urlResponseHeadArr2.length) {
          break;
        }
        encoder12.encode((Struct) urlResponseHeadArr2[i02], (i02 * 8) + 8, false);
        i02++;
      }
    }
    UrlRequestRedirectInfo[] urlRequestRedirectInfoArr = this.redirectInfos;
    if (urlRequestRedirectInfoArr == null) {
      encoder0.encodeNullPointer(56, false);
    } else {
      Encoder encoder13 = encoder0.encodePointerArray(urlRequestRedirectInfoArr.length, 56, -1);
      int i03 = 0;
      while (true) {
        UrlRequestRedirectInfo[] urlRequestRedirectInfoArr2 = this.redirectInfos;
        if (i03 >= urlRequestRedirectInfoArr2.length) {
          break;
        }
        encoder13.encode((Struct) urlRequestRedirectInfoArr2[i03], (i03 * 8) + 8, false);
        i03++;
      }
    }
    encoder0.encode(this.postContentType, 64, false);
    encoder0.encode((Struct) this.originalUrl, 72, false);
    encoder0.encode(this.originalMethod, 80, false);
    encoder0.encode(this.pageState, 88, false);
    if (this.subframeUniqueNames == null) {
      encoder0.encodeNullPointer(96, false);
    } else {
      Encoder encoder14 = encoder0.encoderForMap(96);
      int size0 = this.subframeUniqueNames.size();
      String[] keys0 = new String[size0];
      boolean[] values0 = new boolean[size0];
      int index0 = 0;
      for (Map.Entry<String, Boolean> entry0 : this.subframeUniqueNames.entrySet()) {
        keys0[index0] = entry0.getKey();
        values0[index0] = entry0.getValue().booleanValue();
        index0++;
      }
      Encoder encoder2 = encoder14.encodePointerArray(keys0.length, 8, -1);
      for (int i1 = 0; i1 < keys0.length; i1++) {
        encoder2.encode(keys0[i1], (i1 * 8) + 8, false);
      }
      encoder14.encode(values0, 16, 0, -1);
    }
    encoder0.encode(this.pendingHistoryListOffset, 104);
    encoder0.encode(this.currentHistoryListOffset, 108);
    encoder0.encode(this.currentHistoryListLength, 112);
    encoder0.encode(this.wasActivated, 116);
    encoder0.encode((Struct) this.navigationTiming, 120, false);
    encoder0.encode((Struct) this.navigationToken, 128, false);
    PrefetchedSignedExchangeInfo[] prefetchedSignedExchangeInfoArr = this.prefetchedSignedExchanges;
    if (prefetchedSignedExchangeInfoArr == null) {
      encoder0.encodeNullPointer(136, false);
    } else {
      Encoder encoder15 =
          encoder0.encodePointerArray(prefetchedSignedExchangeInfoArr.length, 136, -1);
      int i04 = 0;
      while (true) {
        PrefetchedSignedExchangeInfo[] prefetchedSignedExchangeInfoArr2 =
            this.prefetchedSignedExchanges;
        if (i04 >= prefetchedSignedExchangeInfoArr2.length) {
          break;
        }
        encoder15.encode((Struct) prefetchedSignedExchangeInfoArr2[i04], (i04 * 8) + 8, false);
        i04++;
      }
    }
    encoder0.encode(this.dataUrlAsString, 144, false);
    encoder0.encode(this.documentUkmSourceId, 152);
    encoder0.encode((Struct) this.framePolicy, 160, false);
    String[] strArr = this.forceEnabledOriginTrials;
    if (strArr == null) {
      encoder0.encodeNullPointer(168, false);
    } else {
      Encoder encoder16 = encoder0.encodePointerArray(strArr.length, 168, -1);
      int i05 = 0;
      while (true) {
        String[] strArr2 = this.forceEnabledOriginTrials;
        if (i05 >= strArr2.length) {
          break;
        }
        encoder16.encode(strArr2[i05], (i05 * 8) + 8, false);
        i05++;
      }
    }
    encoder0.encode(this.enabledClientHints, 176, 0, -1);
    encoder0.encode((Struct) this.oldPageInfo, 184, true);
    encoder0.encode(this.httpResponseCode, 192);
    encoder0.encode(this.navigationDeliveryType, 196);
    encoder0.encode((Struct) this.navigationApiHistoryEntryArrays, 200, false);
    Url[] urlArr3 = this.earlyHintsPreloadedResources;
    if (urlArr3 == null) {
      encoder0.encodeNullPointer(208, false);
    } else {
      Encoder encoder17 = encoder0.encodePointerArray(urlArr3.length, 208, -1);
      int i06 = 0;
      while (true) {
        Url[] urlArr4 = this.earlyHintsPreloadedResources;
        if (i06 >= urlArr4.length) {
          break;
        }
        encoder17.encode((Struct) urlArr4[i06], (i06 * 8) + 8, false);
        i06++;
      }
    }
    encoder0.encode((Struct) this.commitSent, 216, false);
    encoder0.encode(this.srcdocValue, CssSampleId.ALIAS_WEBKIT_COLUMN_RULE_WIDTH, false);
    encoder0.encode(this.reducedAcceptLanguage, 232, false);
    encoder0.encode((Struct) this.viewTransitionState, 240, true);
    encoder0.encode((Struct) this.softNavigationHeuristicsTaskId, 248, true);
    if (this.modifiedRuntimeFeatures == null) {
      encoder0.encodeNullPointer(256, false);
    } else {
      Encoder encoder18 = encoder0.encoderForMap(256);
      int size02 = this.modifiedRuntimeFeatures.size();
      int[] keys02 = new int[size02];
      boolean[] values02 = new boolean[size02];
      int index02 = 0;
      for (Map.Entry<Integer, Boolean> entry02 : this.modifiedRuntimeFeatures.entrySet()) {
        keys02[index02] = entry02.getKey().intValue();
        values02[index02] = entry02.getValue().booleanValue();
        index02++;
      }
      encoder18.encode(keys02, 8, 0, -1);
      encoder18.encode(values02, 16, 0, -1);
    }
    encoder0.encode((Struct) this.fencedFrameProperties, 264, true);
    encoder0.encode((Struct) this.notRestoredReasons, CssSampleId.ALIAS_WEBKIT_MARGIN_END, true);
    encoder0.encode((Struct) this.browsingContextGroupInfo, CssSampleId.WEBKIT_MASK, true);
    encoder0.encode((Struct) this.lcppHint, 288, true);
    encoder0.encode(
        (Struct) this.contentSettings, WebFeature.DOCUMENT_X_PATH_CREATE_NS_RESOLVER, false);
    encoder0.encode(this.cookieDeprecationLabel, 304, true);
  }
}
