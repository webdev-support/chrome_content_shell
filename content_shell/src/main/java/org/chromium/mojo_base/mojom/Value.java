package org.chromium.mojo_base.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

public final class Value extends Union {

  private byte[] mBinaryValue;
  private boolean mBoolValue;
  private DictionaryValue mDictionaryValue;
  private double mDoubleValue;
  private int mIntValue;
  private ListValue mListValue;
  private byte mNullValue;
  private String mStringValue;

  public static final class Tag {
    public static final int BinaryValue = 5;
    public static final int BoolValue = 1;
    public static final int DictionaryValue = 6;
    public static final int DoubleValue = 3;
    public static final int IntValue = 2;
    public static final int ListValue = 7;
    public static final int NullValue = 0;
    public static final int StringValue = 4;
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

  public void setIntValue(int intValue) {
    this.mTag = 2;
    this.mIntValue = intValue;
  }

  public int getIntValue() {
    if (this.mTag != 2) {
      throw new AssertionError();
    }
    return this.mIntValue;
  }

  public void setDoubleValue(double doubleValue) {
    this.mTag = 3;
    this.mDoubleValue = doubleValue;
  }

  public double getDoubleValue() {
    if (this.mTag != 3) {
      throw new AssertionError();
    }
    return this.mDoubleValue;
  }

  public void setStringValue(String stringValue) {
    this.mTag = 4;
    this.mStringValue = stringValue;
  }

  public String getStringValue() {
    if (this.mTag != 4) {
      throw new AssertionError();
    }
    return this.mStringValue;
  }

  public void setBinaryValue(byte[] binaryValue) {
    this.mTag = 5;
    this.mBinaryValue = binaryValue;
  }

  public byte[] getBinaryValue() {
    if (this.mTag != 5) {
      throw new AssertionError();
    }
    return this.mBinaryValue;
  }

  public void setDictionaryValue(DictionaryValue dictionaryValue) {
    this.mTag = 6;
    this.mDictionaryValue = dictionaryValue;
  }

  public DictionaryValue getDictionaryValue() {
    if (this.mTag != 6) {
      throw new AssertionError();
    }
    return this.mDictionaryValue;
  }

  public void setListValue(ListValue listValue) {
    this.mTag = 7;
    this.mListValue = listValue;
  }

  public ListValue getListValue() {
    if (this.mTag != 7) {
      throw new AssertionError();
    }
    return this.mListValue;
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
        encoder0.encode(this.mBoolValue, offset + 8, 0);
        return;
      case 2:
        encoder0.encode(this.mIntValue, offset + 8);
        return;
      case 3:
        encoder0.encode(this.mDoubleValue, offset + 8);
        return;
      case 4:
        encoder0.encode(this.mStringValue, offset + 8, false);
        return;
      case 5:
        encoder0.encode(this.mBinaryValue, offset + 8, 0, -1);
        return;
      case 6:
        encoder0.encode((Struct) this.mDictionaryValue, offset + 8, false);
        return;
      case 7:
        encoder0.encode((Struct) this.mListValue, offset + 8, false);
        return;
      default:
        return;
    }
  }

  public static Value deserialize(Message message) {
    return decode(new Decoder(message).decoderForSerializedUnion(), 0);
  }

  public static final Value decode(Decoder decoder0, int offset) {
    DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
    if (dataHeader.size == 0) {
      return null;
    }
    Value result = new Value();
    switch (dataHeader.elementsOrVersion) {
      case 0:
        result.mNullValue = decoder0.readByte(offset + 8);
        result.mTag = 0;
        break;
      case 1:
        result.mBoolValue = decoder0.readBoolean(offset + 8, 0);
        result.mTag = 1;
        break;
      case 2:
        result.mIntValue = decoder0.readInt(offset + 8);
        result.mTag = 2;
        break;
      case 3:
        result.mDoubleValue = decoder0.readDouble(offset + 8);
        result.mTag = 3;
        break;
      case 4:
        result.mStringValue = decoder0.readString(offset + 8, false);
        result.mTag = 4;
        break;
      case 5:
        result.mBinaryValue = decoder0.readBytes(offset + 8, 0, -1);
        result.mTag = 5;
        break;
      case 6:
        Decoder decoder1 = decoder0.readPointer(offset + 8, false);
        result.mDictionaryValue = DictionaryValue.decode(decoder1);
        result.mTag = 6;
        break;
      case 7:
        Decoder decoder12 = decoder0.readPointer(offset + 8, false);
        result.mListValue = ListValue.decode(decoder12);
        result.mTag = 7;
        break;
    }
    return result;
  }
}
