package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Union;

public final class BadgeValue extends Union {

  private byte mFlag;
  private long mNumber;

  public static final class Tag {
    public static final int Flag = 0;
    public static final int Number = 1;
  }

  public void setFlag(byte flag) {
    this.mTag = 0;
    this.mFlag = flag;
  }

  public byte getFlag() {
    if (this.mTag != 0) {
      throw new AssertionError();
    }
    return this.mFlag;
  }

  public void setNumber(long number) {
    this.mTag = 1;
    this.mNumber = number;
  }

  public long getNumber() {
    if (this.mTag != 1) {
      throw new AssertionError();
    }
    return this.mNumber;
  }

  @Override
  public final void encode(Encoder encoder0, int offset) {
    encoder0.encode(16, offset);
    encoder0.encode(this.mTag, offset + 4);
    switch (this.mTag) {
      case 0:
        encoder0.encode(this.mFlag, offset + 8);
        return;
      case 1:
        encoder0.encode(this.mNumber, offset + 8);
        return;
      default:
        return;
    }
  }

  public static BadgeValue deserialize(Message message) {
    return decode(new Decoder(message).decoderForSerializedUnion(), 0);
  }

  public static final BadgeValue decode(Decoder decoder0, int offset) {
    DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
    if (dataHeader.size == 0) {
      return null;
    }
    BadgeValue result = new BadgeValue();
    switch (dataHeader.elementsOrVersion) {
      case 0:
        result.mFlag = decoder0.readByte(offset + 8);
        result.mTag = 0;
        break;
      case 1:
        result.mNumber = decoder0.readLong(offset + 8);
        result.mTag = 1;
        break;
    }
    return result;
  }
}
