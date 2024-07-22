package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

public final class AuctionAdConfigMaybePromiseDeprecatedRenderUrlReplacements extends Union {

  private int mPromise;
  private AdKeywordReplacement[] mValue;

  public static final class Tag {
    public static final int Promise = 0;
    public static final int Value = 1;
  }

  public void setPromise(int promise) {
    this.mTag = 0;
    this.mPromise = promise;
  }

  public int getPromise() {
    if (this.mTag != 0) {
      throw new AssertionError();
    }
    return this.mPromise;
  }

  public void setValue(AdKeywordReplacement[] value) {
    this.mTag = 1;
    this.mValue = value;
  }

  public AdKeywordReplacement[] getValue() {
    if (this.mTag != 1) {
      throw new AssertionError();
    }
    return this.mValue;
  }

  @Override
  public final void encode(Encoder encoder0, int offset) {
    encoder0.encode(16, offset);
    encoder0.encode(this.mTag, offset + 4);
    switch (this.mTag) {
      case 0:
        encoder0.encode(this.mPromise, offset + 8);
        return;
      case 1:
        AdKeywordReplacement[] adKeywordReplacementArr = this.mValue;
        if (adKeywordReplacementArr == null) {
          encoder0.encodeNullPointer(offset + 8, false);
          return;
        }
        Encoder encoder1 =
            encoder0.encodePointerArray(adKeywordReplacementArr.length, offset + 8, -1);
        int i0 = 0;
        while (true) {
          AdKeywordReplacement[] adKeywordReplacementArr2 = this.mValue;
          if (i0 < adKeywordReplacementArr2.length) {
            encoder1.encode((Struct) adKeywordReplacementArr2[i0], (i0 * 8) + 8, false);
            i0++;
          } else {
            return;
          }
        }
      default:
        return;
    }
  }

  public static AuctionAdConfigMaybePromiseDeprecatedRenderUrlReplacements deserialize(
      Message message) {
    return decode(new Decoder(message).decoderForSerializedUnion(), 0);
  }

  public static final AuctionAdConfigMaybePromiseDeprecatedRenderUrlReplacements decode(
      Decoder decoder0, int offset) {
    DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
    if (dataHeader.size == 0) {
      return null;
    }
    AuctionAdConfigMaybePromiseDeprecatedRenderUrlReplacements result =
        new AuctionAdConfigMaybePromiseDeprecatedRenderUrlReplacements();
    switch (dataHeader.elementsOrVersion) {
      case 0:
        result.mPromise = decoder0.readInt(offset + 8);
        result.mTag = 0;
        break;
      case 1:
        Decoder decoder1 = decoder0.readPointer(offset + 8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.mValue = new AdKeywordReplacement[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.mValue[i1] = AdKeywordReplacement.decode(decoder2);
        }
        result.mTag = 1;
        break;
    }
    return result;
  }
}
