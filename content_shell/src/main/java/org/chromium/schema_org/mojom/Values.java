package org.chromium.schema_org.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

public final class Values extends Union {

  private boolean[] mBoolValues;
  private Entity[] mEntityValues;
  private long[] mLongValues;
  private String[] mStringValues;

  public static final class Tag {
    public static final int BoolValues = 0;
    public static final int EntityValues = 3;
    public static final int LongValues = 1;
    public static final int StringValues = 2;
  }

  public void setBoolValues(boolean[] boolValues) {
    this.mTag = 0;
    this.mBoolValues = boolValues;
  }

  public boolean[] getBoolValues() {
    if (this.mTag != 0) {
      throw new AssertionError();
    }
    return this.mBoolValues;
  }

  public void setLongValues(long[] longValues) {
    this.mTag = 1;
    this.mLongValues = longValues;
  }

  public long[] getLongValues() {
    if (this.mTag != 1) {
      throw new AssertionError();
    }
    return this.mLongValues;
  }

  public void setStringValues(String[] stringValues) {
    this.mTag = 2;
    this.mStringValues = stringValues;
  }

  public String[] getStringValues() {
    if (this.mTag != 2) {
      throw new AssertionError();
    }
    return this.mStringValues;
  }

  public void setEntityValues(Entity[] entityValues) {
    this.mTag = 3;
    this.mEntityValues = entityValues;
  }

  public Entity[] getEntityValues() {
    if (this.mTag != 3) {
      throw new AssertionError();
    }
    return this.mEntityValues;
  }

  @Override
  public final void encode(Encoder encoder0, int offset) {
    encoder0.encode(16, offset);
    encoder0.encode(this.mTag, offset + 4);
    switch (this.mTag) {
      case 0:
        encoder0.encode(this.mBoolValues, offset + 8, 0, -1);
        return;
      case 1:
        encoder0.encode(this.mLongValues, offset + 8, 0, -1);
        return;
      case 2:
        String[] strArr = this.mStringValues;
        if (strArr == null) {
          encoder0.encodeNullPointer(offset + 8, false);
          return;
        }
        Encoder encoder1 = encoder0.encodePointerArray(strArr.length, offset + 8, -1);
        int i0 = 0;
        while (true) {
          String[] strArr2 = this.mStringValues;
          if (i0 < strArr2.length) {
            encoder1.encode(strArr2[i0], (i0 * 8) + 8, false);
            i0++;
          } else {
            return;
          }
        }
      case 3:
        Entity[] entityArr = this.mEntityValues;
        if (entityArr == null) {
          encoder0.encodeNullPointer(offset + 8, false);
          return;
        }
        Encoder encoder12 = encoder0.encodePointerArray(entityArr.length, offset + 8, -1);
        int i02 = 0;
        while (true) {
          Entity[] entityArr2 = this.mEntityValues;
          if (i02 < entityArr2.length) {
            encoder12.encode((Struct) entityArr2[i02], (i02 * 8) + 8, false);
            i02++;
          } else {
            return;
          }
        }
      default:
        return;
    }
  }

  public static Values deserialize(Message message) {
    return decode(new Decoder(message).decoderForSerializedUnion(), 0);
  }

  public static final Values decode(Decoder decoder0, int offset) {
    DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
    if (dataHeader.size == 0) {
      return null;
    }
    Values result = new Values();
    switch (dataHeader.elementsOrVersion) {
      case 0:
        result.mBoolValues = decoder0.readBooleans(offset + 8, 0, -1);
        result.mTag = 0;
        break;
      case 1:
        result.mLongValues = decoder0.readLongs(offset + 8, 0, -1);
        result.mTag = 1;
        break;
      case 2:
        Decoder decoder1 = decoder0.readPointer(offset + 8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.mStringValues = new String[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          result.mStringValues[i1] = decoder1.readString((i1 * 8) + 8, false);
        }
        result.mTag = 2;
        break;
      case 3:
        Decoder decoder12 = decoder0.readPointer(offset + 8, false);
        DataHeader si12 = decoder12.readDataHeaderForPointerArray(-1);
        result.mEntityValues = new Entity[si12.elementsOrVersion];
        for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
          Decoder decoder2 = decoder12.readPointer((i12 * 8) + 8, false);
          result.mEntityValues[i12] = Entity.decode(decoder2);
        }
        result.mTag = 3;
        break;
    }
    return result;
  }
}
