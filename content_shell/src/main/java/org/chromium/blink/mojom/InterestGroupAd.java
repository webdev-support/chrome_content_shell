package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.url.internal.mojom.Origin;

public final class InterestGroupAd extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 64;
  private static final DataHeader[] VERSION_ARRAY;
  public String adRenderId;
  public Origin[] allowedReportingOrigins;
  public String buyerAndSellerReportingId;
  public String buyerReportingId;
  public String metadata;
  public String renderUrl;
  public String sizeGroup;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(64, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private InterestGroupAd(int version) {
    super(64, version);
  }

  public InterestGroupAd() {
    this(0);
  }

  public static InterestGroupAd deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static InterestGroupAd deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static InterestGroupAd decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      InterestGroupAd result = new InterestGroupAd(elementsOrVersion);
      result.renderUrl = decoder0.readString(8, false);
      result.sizeGroup = decoder0.readString(16, true);
      result.buyerReportingId = decoder0.readString(24, true);
      result.buyerAndSellerReportingId = decoder0.readString(32, true);
      result.metadata = decoder0.readString(40, true);
      result.adRenderId = decoder0.readString(48, true);
      Decoder decoder1 = decoder0.readPointer(56, true);
      if (decoder1 == null) {
        result.allowedReportingOrigins = null;
      } else {
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.allowedReportingOrigins = new Origin[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.allowedReportingOrigins[i1] = Origin.decode(decoder2);
        }
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.renderUrl, 8, false);
    encoder0.encode(this.sizeGroup, 16, true);
    encoder0.encode(this.buyerReportingId, 24, true);
    encoder0.encode(this.buyerAndSellerReportingId, 32, true);
    encoder0.encode(this.metadata, 40, true);
    encoder0.encode(this.adRenderId, 48, true);
    Origin[] originArr = this.allowedReportingOrigins;
    if (originArr == null) {
      encoder0.encodeNullPointer(56, true);
      return;
    }
    Encoder encoder1 = encoder0.encodePointerArray(originArr.length, 56, -1);
    int i0 = 0;
    while (true) {
      Origin[] originArr2 = this.allowedReportingOrigins;
      if (i0 < originArr2.length) {
        encoder1.encode((Struct) originArr2[i0], (i0 * 8) + 8, false);
        i0++;
      } else {
        return;
      }
    }
  }
}
