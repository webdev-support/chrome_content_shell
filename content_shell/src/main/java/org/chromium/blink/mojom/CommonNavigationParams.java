package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.TimeTicks;
import org.chromium.network.mojom.CspDisposition;
import org.chromium.network.mojom.RequestDestination;
import org.chromium.network.mojom.SourceLocation;
import org.chromium.network.mojom.UrlRequestBody;
import org.chromium.url.internal.mojom.Origin;
import org.chromium.url.mojom.Url;

public final class CommonNavigationParams extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 136;
  private static final DataHeader[] VERSION_ARRAY;
  public Url baseUrlForDataUrl;
  public NavigationDownloadPolicy downloadPolicy;
  public boolean hasUserGesture;
  public String hrefTranslate;
  public Url initiatorBaseUrl;
  public Origin initiatorOrigin;
  public int[] initiatorOriginTrialFeatures;
  public TimeTicks inputStart;
  public boolean isHistoryNavigationInNewChildFrame;
  public String method;
  public TimeTicks navigationStart;
  public int navigationType;
  public UrlRequestBody postData;
  public Referrer referrer;
  public int requestDestination;
  public int shouldCheckMainWorldCsp;
  public boolean shouldReplaceCurrentEntry;
  public SourceLocation sourceLocation;
  public boolean startedFromContextMenu;
  public boolean textFragmentToken;
  public int transition;
  public Url url;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(136, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private CommonNavigationParams(int version) {
    super(136, version);
    this.navigationType = 7;
    this.shouldReplaceCurrentEntry = false;
    this.method = "GET";
    this.startedFromContextMenu = false;
    this.hasUserGesture = false;
    this.textFragmentToken = false;
    this.shouldCheckMainWorldCsp = 0;
    this.isHistoryNavigationInNewChildFrame = false;
    this.requestDestination = 0;
  }

  public CommonNavigationParams() {
    this(0);
  }

  public static CommonNavigationParams deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static CommonNavigationParams deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static CommonNavigationParams decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      CommonNavigationParams result = new CommonNavigationParams(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.url = Url.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, true);
      result.initiatorOrigin = Origin.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(24, true);
      result.initiatorBaseUrl = Url.decode(decoder13);
      Decoder decoder14 = decoder0.readPointer(32, false);
      result.referrer = Referrer.decode(decoder14);
      result.transition = decoder0.readInt(40);
      int readInt = decoder0.readInt(44);
      result.navigationType = readInt;
      NavigationType.validate(readInt);
      result.navigationType = NavigationType.toKnownValue(result.navigationType);
      Decoder decoder15 = decoder0.readPointer(48, false);
      result.downloadPolicy = NavigationDownloadPolicy.decode(decoder15);
      result.shouldReplaceCurrentEntry = decoder0.readBoolean(56, 0);
      result.startedFromContextMenu = decoder0.readBoolean(56, 1);
      result.hasUserGesture = decoder0.readBoolean(56, 2);
      result.textFragmentToken = decoder0.readBoolean(56, 3);
      result.isHistoryNavigationInNewChildFrame = decoder0.readBoolean(56, 4);
      int readInt2 = decoder0.readInt(60);
      result.shouldCheckMainWorldCsp = readInt2;
      CspDisposition.validate(readInt2);
      result.shouldCheckMainWorldCsp = CspDisposition.toKnownValue(result.shouldCheckMainWorldCsp);
      Decoder decoder16 = decoder0.readPointer(64, false);
      result.baseUrlForDataUrl = Url.decode(decoder16);
      Decoder decoder17 = decoder0.readPointer(72, false);
      result.navigationStart = TimeTicks.decode(decoder17);
      result.method = decoder0.readString(80, false);
      Decoder decoder18 = decoder0.readPointer(88, true);
      result.postData = UrlRequestBody.decode(decoder18);
      Decoder decoder19 = decoder0.readPointer(96, false);
      result.sourceLocation = SourceLocation.decode(decoder19);
      result.initiatorOriginTrialFeatures = decoder0.readInts(104, 0, -1);
      result.hrefTranslate = decoder0.readString(112, false);
      Decoder decoder110 = decoder0.readPointer(120, false);
      result.inputStart = TimeTicks.decode(decoder110);
      int readInt3 = decoder0.readInt(128);
      result.requestDestination = readInt3;
      RequestDestination.validate(readInt3);
      result.requestDestination = RequestDestination.toKnownValue(result.requestDestination);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.url, 8, false);
    encoder0.encode((Struct) this.initiatorOrigin, 16, true);
    encoder0.encode((Struct) this.initiatorBaseUrl, 24, true);
    encoder0.encode((Struct) this.referrer, 32, false);
    encoder0.encode(this.transition, 40);
    encoder0.encode(this.navigationType, 44);
    encoder0.encode((Struct) this.downloadPolicy, 48, false);
    encoder0.encode(this.shouldReplaceCurrentEntry, 56, 0);
    encoder0.encode(this.startedFromContextMenu, 56, 1);
    encoder0.encode(this.hasUserGesture, 56, 2);
    encoder0.encode(this.textFragmentToken, 56, 3);
    encoder0.encode(this.isHistoryNavigationInNewChildFrame, 56, 4);
    encoder0.encode(this.shouldCheckMainWorldCsp, 60);
    encoder0.encode((Struct) this.baseUrlForDataUrl, 64, false);
    encoder0.encode((Struct) this.navigationStart, 72, false);
    encoder0.encode(this.method, 80, false);
    encoder0.encode((Struct) this.postData, 88, true);
    encoder0.encode((Struct) this.sourceLocation, 96, false);
    encoder0.encode(this.initiatorOriginTrialFeatures, 104, 0, -1);
    encoder0.encode(this.hrefTranslate, 112, false);
    encoder0.encode((Struct) this.inputStart, 120, false);
    encoder0.encode(this.requestDestination, 128);
  }
}
