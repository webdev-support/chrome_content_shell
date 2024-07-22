package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.network.mojom.SourceLocation;
import org.chromium.network.mojom.UrlRequestBody;
import org.chromium.ui.mojom.WindowOpenDisposition;
import org.chromium.url.internal.mojom.Origin;
import org.chromium.url.mojom.Url;

public final class OpenUrlParams extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 128;
  private static final DataHeader[] VERSION_ARRAY;
  public BlobUrlToken blobUrlToken;
  public int disposition;
  public NavigationDownloadPolicy downloadPolicy;
  public String extraHeaders;
  public String hrefTranslate;
  public Impression impression;
  public int initiatorActivationAndAdStatus;
  public Url initiatorBaseUrl;
  public LocalFrameToken initiatorFrameToken;
  public Origin initiatorOrigin;
  public PolicyContainerHostKeepAliveHandle initiatorPolicyContainerKeepAliveHandle;
  public boolean isContainerInitiated;
  public boolean isFormSubmission;
  public boolean isUnfencedTopNavigation;
  public UrlRequestBody postBody;
  public Referrer referrer;
  public boolean shouldReplaceCurrentEntry;
  public SourceLocation sourceLocation;
  public int triggeringEventInfo;
  public Url url;
  public boolean userGesture;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(128, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private OpenUrlParams(int version) {
    super(128, version);
    this.isUnfencedTopNavigation = false;
    this.isContainerInitiated = false;
  }

  public OpenUrlParams() {
    this(0);
  }

  public static OpenUrlParams deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static OpenUrlParams deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static OpenUrlParams decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      OpenUrlParams result = new OpenUrlParams(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.url = Url.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.initiatorOrigin = Origin.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(24, true);
      result.initiatorBaseUrl = Url.decode(decoder13);
      Decoder decoder14 = decoder0.readPointer(32, true);
      result.initiatorFrameToken = LocalFrameToken.decode(decoder14);
      Decoder decoder15 = decoder0.readPointer(40, true);
      result.postBody = UrlRequestBody.decode(decoder15);
      result.extraHeaders = decoder0.readString(48, false);
      Decoder decoder16 = decoder0.readPointer(56, false);
      result.referrer = Referrer.decode(decoder16);
      result.isFormSubmission = decoder0.readBoolean(64, 0);
      result.shouldReplaceCurrentEntry = decoder0.readBoolean(64, 1);
      result.userGesture = decoder0.readBoolean(64, 2);
      result.isUnfencedTopNavigation = decoder0.readBoolean(64, 3);
      result.isContainerInitiated = decoder0.readBoolean(64, 4);
      int readInt = decoder0.readInt(68);
      result.disposition = readInt;
      WindowOpenDisposition.validate(readInt);
      result.disposition = WindowOpenDisposition.toKnownValue(result.disposition);
      int readInt2 = decoder0.readInt(72);
      result.triggeringEventInfo = readInt2;
      TriggeringEventInfo.validate(readInt2);
      result.triggeringEventInfo = TriggeringEventInfo.toKnownValue(result.triggeringEventInfo);
      result.blobUrlToken =
          (BlobUrlToken) decoder0.readServiceInterface(76, true, BlobUrlToken.MANAGER);
      int readInt3 = decoder0.readInt(84);
      result.initiatorActivationAndAdStatus = readInt3;
      NavigationInitiatorActivationAndAdStatus.validate(readInt3);
      result.initiatorActivationAndAdStatus =
          NavigationInitiatorActivationAndAdStatus.toKnownValue(
              result.initiatorActivationAndAdStatus);
      result.hrefTranslate = decoder0.readString(88, false);
      Decoder decoder17 = decoder0.readPointer(96, true);
      result.impression = Impression.decode(decoder17);
      Decoder decoder18 = decoder0.readPointer(104, false);
      result.downloadPolicy = NavigationDownloadPolicy.decode(decoder18);
      Decoder decoder19 = decoder0.readPointer(112, false);
      result.sourceLocation = SourceLocation.decode(decoder19);
      result.initiatorPolicyContainerKeepAliveHandle =
          (PolicyContainerHostKeepAliveHandle)
              decoder0.readServiceInterface(120, true, PolicyContainerHostKeepAliveHandle.MANAGER);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.url, 8, false);
    encoder0.encode((Struct) this.initiatorOrigin, 16, false);
    encoder0.encode((Struct) this.initiatorBaseUrl, 24, true);
    encoder0.encode((Struct) this.initiatorFrameToken, 32, true);
    encoder0.encode((Struct) this.postBody, 40, true);
    encoder0.encode(this.extraHeaders, 48, false);
    encoder0.encode((Struct) this.referrer, 56, false);
    encoder0.encode(this.isFormSubmission, 64, 0);
    encoder0.encode(this.shouldReplaceCurrentEntry, 64, 1);
    encoder0.encode(this.userGesture, 64, 2);
    encoder0.encode(this.isUnfencedTopNavigation, 64, 3);
    encoder0.encode(this.isContainerInitiated, 64, 4);
    encoder0.encode(this.disposition, 68);
    encoder0.encode(this.triggeringEventInfo, 72);
    encoder0.encode(this.blobUrlToken, 76, true, BlobUrlToken.MANAGER);
    encoder0.encode(this.initiatorActivationAndAdStatus, 84);
    encoder0.encode(this.hrefTranslate, 88, false);
    encoder0.encode((Struct) this.impression, 96, true);
    encoder0.encode((Struct) this.downloadPolicy, 104, false);
    encoder0.encode((Struct) this.sourceLocation, 112, false);
    encoder0.encode(
        this.initiatorPolicyContainerKeepAliveHandle,
        120,
        true,
        PolicyContainerHostKeepAliveHandle.MANAGER);
  }
}
