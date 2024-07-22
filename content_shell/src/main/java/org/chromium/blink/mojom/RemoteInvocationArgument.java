package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;
import org.chromium.mojo_base.mojom.String16;

public final class RemoteInvocationArgument extends Union {

  private RemoteInvocationArgument[] mArrayValue;
  private boolean mBooleanValue;
  private double mNumberValue;
  private int mObjectIdValue;
  private int mSingletonValue;
  private String16 mStringValue;
  private RemoteTypedArray mTypedArrayValue;

  public static final class Tag {
    public static final int ArrayValue = 4;
    public static final int BooleanValue = 1;
    public static final int NumberValue = 0;
    public static final int ObjectIdValue = 6;
    public static final int SingletonValue = 3;
    public static final int StringValue = 2;
    public static final int TypedArrayValue = 5;
  }

  public void setNumberValue(double numberValue) {
    this.mTag = 0;
    this.mNumberValue = numberValue;
  }

  public double getNumberValue() {
    if (this.mTag != 0) {
      throw new AssertionError();
    }
    return this.mNumberValue;
  }

  public void setBooleanValue(boolean booleanValue) {
    this.mTag = 1;
    this.mBooleanValue = booleanValue;
  }

  public boolean getBooleanValue() {
    if (this.mTag != 1) {
      throw new AssertionError();
    }
    return this.mBooleanValue;
  }

  public void setStringValue(String16 stringValue) {
    this.mTag = 2;
    this.mStringValue = stringValue;
  }

  public String16 getStringValue() {
    if (this.mTag != 2) {
      throw new AssertionError();
    }
    return this.mStringValue;
  }

  public void setSingletonValue(int singletonValue) {
    this.mTag = 3;
    this.mSingletonValue = singletonValue;
  }

  public int getSingletonValue() {
    if (this.mTag != 3) {
      throw new AssertionError();
    }
    return this.mSingletonValue;
  }

  public void setArrayValue(RemoteInvocationArgument[] arrayValue) {
    this.mTag = 4;
    this.mArrayValue = arrayValue;
  }

  public RemoteInvocationArgument[] getArrayValue() {
    if (this.mTag != 4) {
      throw new AssertionError();
    }
    return this.mArrayValue;
  }

  public void setTypedArrayValue(RemoteTypedArray typedArrayValue) {
    this.mTag = 5;
    this.mTypedArrayValue = typedArrayValue;
  }

  public RemoteTypedArray getTypedArrayValue() {
    if (this.mTag != 5) {
      throw new AssertionError();
    }
    return this.mTypedArrayValue;
  }

  public void setObjectIdValue(int objectIdValue) {
    this.mTag = 6;
    this.mObjectIdValue = objectIdValue;
  }

  public int getObjectIdValue() {
    if (this.mTag != 6) {
      throw new AssertionError();
    }
    return this.mObjectIdValue;
  }

  @Override
  protected final void encode(Encoder encoder0, int offset) {
    encoder0.encode(16, offset);
    encoder0.encode(this.mTag, offset + 4);
    switch (this.mTag) {
      case 0:
        encoder0.encode(this.mNumberValue, offset + 8);
        return;
      case 1:
        encoder0.encode(this.mBooleanValue, offset + 8, 0);
        return;
      case 2:
        encoder0.encode((Struct) this.mStringValue, offset + 8, false);
        return;
      case 3:
        encoder0.encode(this.mSingletonValue, offset + 8);
        return;
      case 4:
        RemoteInvocationArgument[] remoteInvocationArgumentArr = this.mArrayValue;
        if (remoteInvocationArgumentArr == null) {
          encoder0.encodeNullPointer(offset + 8, false);
          return;
        }
        Encoder encoder1 =
            encoder0.encodeUnionArray(remoteInvocationArgumentArr.length, offset + 8, -1);
        int i0 = 0;
        while (true) {
          RemoteInvocationArgument[] remoteInvocationArgumentArr2 = this.mArrayValue;
          if (i0 < remoteInvocationArgumentArr2.length) {
            encoder1.encode((Union) remoteInvocationArgumentArr2[i0], (i0 * 16) + 8, false);
            i0++;
          } else {
            return;
          }
        }
      case 5:
        encoder0.encode((Struct) this.mTypedArrayValue, offset + 8, false);
        return;
      case 6:
        encoder0.encode(this.mObjectIdValue, offset + 8);
        return;
      default:
        return;
    }
  }

  public static RemoteInvocationArgument deserialize(Message message) {
    return decode(new Decoder(message).decoderForSerializedUnion(), 0);
  }

  public static final RemoteInvocationArgument decode(Decoder decoder0, int offset) {
    DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
    if (dataHeader.size == 0) {
      return null;
    }
    RemoteInvocationArgument result = new RemoteInvocationArgument();
    switch (dataHeader.elementsOrVersion) {
      case 0:
        result.mNumberValue = decoder0.readDouble(offset + 8);
        result.mTag = 0;
        break;
      case 1:
        result.mBooleanValue = decoder0.readBoolean(offset + 8, 0);
        result.mTag = 1;
        break;
      case 2:
        result.mStringValue = String16.decode(decoder0.readPointer(offset + 8, false));
        result.mTag = 2;
        break;
      case 3:
        int readInt = decoder0.readInt(offset + 8);
        result.mSingletonValue = readInt;
        SingletonJavaScriptValue.validate(readInt);
        result.mSingletonValue = SingletonJavaScriptValue.toKnownValue(result.mSingletonValue);
        result.mTag = 3;
        break;
      case 4:
        Decoder decoder1 = decoder0.readPointer(offset + 8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.mArrayValue = new RemoteInvocationArgument[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          result.mArrayValue[i1] = decode(decoder1, (i1 * 16) + 8);
        }
        result.mTag = 4;
        break;
      case 5:
        result.mTypedArrayValue = RemoteTypedArray.decode(decoder0.readPointer(offset + 8, false));
        result.mTag = 5;
        break;
      case 6:
        result.mObjectIdValue = decoder0.readInt(offset + 8);
        result.mTag = 6;
        break;
    }
    return result;
  }
}
