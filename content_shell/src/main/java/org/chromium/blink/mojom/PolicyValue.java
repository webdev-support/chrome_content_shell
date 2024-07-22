package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Union;

public final class PolicyValue extends Union {

  private boolean mBoolValue;
  private double mDecDoubleValue;
  private int mEnumValue;
  private boolean mNullValue;

  public static final class Tag {
    public static final int BoolValue = 1;
    public static final int DecDoubleValue = 2;
    public static final int EnumValue = 3;
    public static final int NullValue = 0;
  }

  public void setNullValue(boolean nullValue) {
    this.mTag = 0;
    this.mNullValue = nullValue;
  }

  public boolean getNullValue() {
    if (this.mTag != 0) {
      throw new AssertionError();
    }
    return this.mNullValue;
  }

  public void setBoolValue(boolean boolValue) {
    this.mTag = 1;
    this.mBoolValue = boolValue;
  }

  public boolean getBoolValue() {
    if (this.mTag != 1) {
      throw new AssertionError();
    }
    return this.mBoolValue;
  }

  public void setDecDoubleValue(double decDoubleValue) {
    this.mTag = 2;
    this.mDecDoubleValue = decDoubleValue;
  }

  public double getDecDoubleValue() {
    if (this.mTag != 2) {
      throw new AssertionError();
    }
    return this.mDecDoubleValue;
  }

  public void setEnumValue(int enumValue) {
    this.mTag = 3;
    this.mEnumValue = enumValue;
  }

  public int getEnumValue() {
    if (this.mTag != 3) {
      throw new AssertionError();
    }
    return this.mEnumValue;
  }

  @Override
  public final void encode(Encoder encoder0, int offset) {
    encoder0.encode(16, offset);
    encoder0.encode(this.mTag, offset + 4);
    switch (this.mTag) {
      case 0:
        encoder0.encode(this.mNullValue, offset + 8, 0);
        return;
      case 1:
        encoder0.encode(this.mBoolValue, offset + 8, 0);
        return;
      case 2:
        encoder0.encode(this.mDecDoubleValue, offset + 8);
        return;
      case 3:
        encoder0.encode(this.mEnumValue, offset + 8);
        return;
      default:
        return;
    }
  }

  public static PolicyValue deserialize(Message message) {
    return decode(new Decoder(message).decoderForSerializedUnion(), 0);
  }

  public static final PolicyValue decode(Decoder decoder0, int offset) {
    DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
    if (dataHeader.size == 0) {
      return null;
    }
    PolicyValue result = new PolicyValue();
    switch (dataHeader.elementsOrVersion) {
      case 0:
        result.mNullValue = decoder0.readBoolean(offset + 8, 0);
        result.mTag = 0;
        break;
      case 1:
        result.mBoolValue = decoder0.readBoolean(offset + 8, 0);
        result.mTag = 1;
        break;
      case 2:
        result.mDecDoubleValue = decoder0.readDouble(offset + 8);
        result.mTag = 2;
        break;
      case 3:
        result.mEnumValue = decoder0.readInt(offset + 8);
        result.mTag = 3;
        break;
    }
    return result;
  }
}
