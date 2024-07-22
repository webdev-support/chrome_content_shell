package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Union;

public final class AuctionAdConfigAuctionId extends Union {

  private int mComponentAuction;
  private int mMainAuction;

  public static final class Tag {
    public static final int ComponentAuction = 1;
    public static final int MainAuction = 0;
  }

  public void setMainAuction(int mainAuction) {
    this.mTag = 0;
    this.mMainAuction = mainAuction;
  }

  public int getMainAuction() {
    if (this.mTag != 0) {
      throw new AssertionError();
    }
    return this.mMainAuction;
  }

  public void setComponentAuction(int componentAuction) {
    this.mTag = 1;
    this.mComponentAuction = componentAuction;
  }

  public int getComponentAuction() {
    if (this.mTag != 1) {
      throw new AssertionError();
    }
    return this.mComponentAuction;
  }

  @Override
  public final void encode(Encoder encoder0, int offset) {
    encoder0.encode(16, offset);
    encoder0.encode(this.mTag, offset + 4);
    switch (this.mTag) {
      case 0:
        encoder0.encode(this.mMainAuction, offset + 8);
        return;
      case 1:
        encoder0.encode(this.mComponentAuction, offset + 8);
        return;
      default:
        return;
    }
  }

  public static AuctionAdConfigAuctionId deserialize(Message message) {
    return decode(new Decoder(message).decoderForSerializedUnion(), 0);
  }

  public static final AuctionAdConfigAuctionId decode(Decoder decoder0, int offset) {
    DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
    if (dataHeader.size == 0) {
      return null;
    }
    AuctionAdConfigAuctionId result = new AuctionAdConfigAuctionId();
    switch (dataHeader.elementsOrVersion) {
      case 0:
        result.mMainAuction = decoder0.readInt(offset + 8);
        result.mTag = 0;
        break;
      case 1:
        result.mComponentAuction = decoder0.readInt(offset + 8);
        result.mTag = 1;
        break;
    }
    return result;
  }
}
