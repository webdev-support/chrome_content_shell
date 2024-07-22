package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Union;

public final class AuctionAdConfigMaybePromiseJson extends Union {

  private int mPromise;
  private String mValue;

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

  public void setValue(String value) {
    this.mTag = 1;
    this.mValue = value;
  }

  public String getValue() {
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
        encoder0.encode(this.mValue, offset + 8, true);
        return;
      default:
        return;
    }
  }

  public static AuctionAdConfigMaybePromiseJson deserialize(Message message) {
    return decode(new Decoder(message).decoderForSerializedUnion(), 0);
  }

  public static final AuctionAdConfigMaybePromiseJson decode(Decoder decoder0, int offset) {
    DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
    if (dataHeader.size == 0) {
      return null;
    }
    AuctionAdConfigMaybePromiseJson result = new AuctionAdConfigMaybePromiseJson();
    switch (dataHeader.elementsOrVersion) {
      case 0:
        result.mPromise = decoder0.readInt(offset + 8);
        result.mTag = 0;
        break;
      case 1:
        result.mValue = decoder0.readString(offset + 8, true);
        result.mTag = 1;
        break;
    }
    return result;
  }
}
