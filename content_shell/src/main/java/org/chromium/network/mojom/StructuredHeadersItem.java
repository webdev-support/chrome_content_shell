package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;
import org.chromium.mojo_base.mojom.ByteString;

public final class StructuredHeadersItem extends Union {

  private boolean mBooleanValue;
  private ByteString mByteSequenceValue;
  private double mDecimalValue;
  private long mIntegerValue;
  private byte mNullValue;
  private String mStringValue;
  private String mTokenValue;

  public static final class Tag {
    public static final int BooleanValue = 6;
    public static final int ByteSequenceValue = 5;
    public static final int DecimalValue = 2;
    public static final int IntegerValue = 1;
    public static final int NullValue = 0;
    public static final int StringValue = 3;
    public static final int TokenValue = 4;
  }

  public void setNullValue(byte nullValue) {
    this.mTag = 0;
    this.mNullValue = nullValue;
  }

  public byte getNullValue() {
    if (this.mTag != 0) {
      throw new AssertionError();
    }
    return this.mNullValue;
  }

  public void setIntegerValue(long integerValue) {
    this.mTag = 1;
    this.mIntegerValue = integerValue;
  }

  public long getIntegerValue() {
    if (this.mTag != 1) {
      throw new AssertionError();
    }
    return this.mIntegerValue;
  }

  public void setDecimalValue(double decimalValue) {
    this.mTag = 2;
    this.mDecimalValue = decimalValue;
  }

  public double getDecimalValue() {
    if (this.mTag != 2) {
      throw new AssertionError();
    }
    return this.mDecimalValue;
  }

  public void setStringValue(String stringValue) {
    this.mTag = 3;
    this.mStringValue = stringValue;
  }

  public String getStringValue() {
    if (this.mTag != 3) {
      throw new AssertionError();
    }
    return this.mStringValue;
  }

  public void setTokenValue(String tokenValue) {
    this.mTag = 4;
    this.mTokenValue = tokenValue;
  }

  public String getTokenValue() {
    if (this.mTag != 4) {
      throw new AssertionError();
    }
    return this.mTokenValue;
  }

  public void setByteSequenceValue(ByteString byteSequenceValue) {
    this.mTag = 5;
    this.mByteSequenceValue = byteSequenceValue;
  }

  public ByteString getByteSequenceValue() {
    if (this.mTag != 5) {
      throw new AssertionError();
    }
    return this.mByteSequenceValue;
  }

  public void setBooleanValue(boolean booleanValue) {
    this.mTag = 6;
    this.mBooleanValue = booleanValue;
  }

  public boolean getBooleanValue() {
    if (this.mTag != 6) {
      throw new AssertionError();
    }
    return this.mBooleanValue;
  }

  @Override
  public final void encode(Encoder encoder0, int offset) {
    encoder0.encode(16, offset);
    encoder0.encode(this.mTag, offset + 4);
    switch (this.mTag) {
      case 0:
        encoder0.encode(this.mNullValue, offset + 8);
        return;
      case 1:
        encoder0.encode(this.mIntegerValue, offset + 8);
        return;
      case 2:
        encoder0.encode(this.mDecimalValue, offset + 8);
        return;
      case 3:
        encoder0.encode(this.mStringValue, offset + 8, false);
        return;
      case 4:
        encoder0.encode(this.mTokenValue, offset + 8, false);
        return;
      case 5:
        encoder0.encode((Struct) this.mByteSequenceValue, offset + 8, false);
        return;
      case 6:
        encoder0.encode(this.mBooleanValue, offset + 8, 0);
        return;
      default:
        return;
    }
  }

  public static StructuredHeadersItem deserialize(Message message) {
    return decode(new Decoder(message).decoderForSerializedUnion(), 0);
  }

  public static final StructuredHeadersItem decode(Decoder decoder0, int offset) {
    DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
    if (dataHeader.size == 0) {
      return null;
    }
    StructuredHeadersItem result = new StructuredHeadersItem();
    switch (dataHeader.elementsOrVersion) {
      case 0:
        result.mNullValue = decoder0.readByte(offset + 8);
        result.mTag = 0;
        break;
      case 1:
        result.mIntegerValue = decoder0.readLong(offset + 8);
        result.mTag = 1;
        break;
      case 2:
        result.mDecimalValue = decoder0.readDouble(offset + 8);
        result.mTag = 2;
        break;
      case 3:
        result.mStringValue = decoder0.readString(offset + 8, false);
        result.mTag = 3;
        break;
      case 4:
        result.mTokenValue = decoder0.readString(offset + 8, false);
        result.mTag = 4;
        break;
      case 5:
        Decoder decoder1 = decoder0.readPointer(offset + 8, false);
        result.mByteSequenceValue = ByteString.decode(decoder1);
        result.mTag = 5;
        break;
      case 6:
        result.mBooleanValue = decoder0.readBoolean(offset + 8, 0);
        result.mTag = 6;
        break;
    }
    return result;
  }
}
