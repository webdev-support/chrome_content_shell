package org.chromium.device.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Union;

public final class SmartCardListReadersResult extends Union {

  private int mError;
  private String[] mReaders;

  public static final class Tag {
    public static final int Error = 1;
    public static final int Readers = 0;
  }

  public void setReaders(String[] readers) {
    this.mTag = 0;
    this.mReaders = readers;
  }

  public String[] getReaders() {
    if (this.mTag != 0) {
      throw new AssertionError();
    }
    return this.mReaders;
  }

  public void setError(int error) {
    this.mTag = 1;
    this.mError = error;
  }

  public int getError() {
    if (this.mTag != 1) {
      throw new AssertionError();
    }
    return this.mError;
  }

  @Override
  public final void encode(Encoder encoder0, int offset) {
    encoder0.encode(16, offset);
    encoder0.encode(this.mTag, offset + 4);
    switch (this.mTag) {
      case 0:
        String[] strArr = this.mReaders;
        if (strArr == null) {
          encoder0.encodeNullPointer(offset + 8, false);
          return;
        }
        Encoder encoder1 = encoder0.encodePointerArray(strArr.length, offset + 8, -1);
        int i0 = 0;
        while (true) {
          String[] strArr2 = this.mReaders;
          if (i0 < strArr2.length) {
            encoder1.encode(strArr2[i0], (i0 * 8) + 8, false);
            i0++;
          } else {
            return;
          }
        }
      case 1:
        encoder0.encode(this.mError, offset + 8);
        return;
      default:
        return;
    }
  }

  public static SmartCardListReadersResult deserialize(Message message) {
    return decode(new Decoder(message).decoderForSerializedUnion(), 0);
  }

  public static final SmartCardListReadersResult decode(Decoder decoder0, int offset) {
    DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
    if (dataHeader.size == 0) {
      return null;
    }
    SmartCardListReadersResult result = new SmartCardListReadersResult();
    switch (dataHeader.elementsOrVersion) {
      case 0:
        Decoder decoder1 = decoder0.readPointer(offset + 8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.mReaders = new String[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          result.mReaders[i1] = decoder1.readString((i1 * 8) + 8, false);
        }
        result.mTag = 0;
        break;
      case 1:
        int readInt = decoder0.readInt(offset + 8);
        result.mError = readInt;
        SmartCardError.validate(readInt);
        result.mError = SmartCardError.toKnownValue(result.mError);
        result.mTag = 1;
        break;
    }
    return result;
  }
}
