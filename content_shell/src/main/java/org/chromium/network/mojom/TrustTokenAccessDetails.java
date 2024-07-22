package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

public final class TrustTokenAccessDetails extends Union {

  private TrustTokenIssuanceDetails mIssuance;
  private TrustTokenRedemptionDetails mRedemption;
  private TrustTokenSigningDetails mSigning;

  public static final class Tag {
    public static final int Issuance = 0;
    public static final int Redemption = 1;
    public static final int Signing = 2;
  }

  public void setIssuance(TrustTokenIssuanceDetails issuance) {
    this.mTag = 0;
    this.mIssuance = issuance;
  }

  public TrustTokenIssuanceDetails getIssuance() {
    if (this.mTag != 0) {
      throw new AssertionError();
    }
    return this.mIssuance;
  }

  public void setRedemption(TrustTokenRedemptionDetails redemption) {
    this.mTag = 1;
    this.mRedemption = redemption;
  }

  public TrustTokenRedemptionDetails getRedemption() {
    if (this.mTag != 1) {
      throw new AssertionError();
    }
    return this.mRedemption;
  }

  public void setSigning(TrustTokenSigningDetails signing) {
    this.mTag = 2;
    this.mSigning = signing;
  }

  public TrustTokenSigningDetails getSigning() {
    if (this.mTag != 2) {
      throw new AssertionError();
    }
    return this.mSigning;
  }

  @Override
  public final void encode(Encoder encoder0, int offset) {
    encoder0.encode(16, offset);
    encoder0.encode(this.mTag, offset + 4);
    switch (this.mTag) {
      case 0:
        encoder0.encode((Struct) this.mIssuance, offset + 8, false);
        return;
      case 1:
        encoder0.encode((Struct) this.mRedemption, offset + 8, false);
        return;
      case 2:
        encoder0.encode((Struct) this.mSigning, offset + 8, false);
        return;
      default:
        return;
    }
  }

  public static TrustTokenAccessDetails deserialize(Message message) {
    return decode(new Decoder(message).decoderForSerializedUnion(), 0);
  }

  public static final TrustTokenAccessDetails decode(Decoder decoder0, int offset) {
    DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
    if (dataHeader.size == 0) {
      return null;
    }
    TrustTokenAccessDetails result = new TrustTokenAccessDetails();
    switch (dataHeader.elementsOrVersion) {
      case 0:
        Decoder decoder1 = decoder0.readPointer(offset + 8, false);
        result.mIssuance = TrustTokenIssuanceDetails.decode(decoder1);
        result.mTag = 0;
        break;
      case 1:
        Decoder decoder12 = decoder0.readPointer(offset + 8, false);
        result.mRedemption = TrustTokenRedemptionDetails.decode(decoder12);
        result.mTag = 1;
        break;
      case 2:
        Decoder decoder13 = decoder0.readPointer(offset + 8, false);
        result.mSigning = TrustTokenSigningDetails.decode(decoder13);
        result.mTag = 2;
        break;
    }
    return result;
  }
}
