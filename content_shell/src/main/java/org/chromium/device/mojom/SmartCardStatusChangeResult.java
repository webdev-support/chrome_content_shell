package org.chromium.device.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

public final class SmartCardStatusChangeResult extends Union {

  private int mError;
  private SmartCardReaderStateOut[] mReaderStates;

  public static final class Tag {
    public static final int Error = 1;
    public static final int ReaderStates = 0;
  }

  public void setReaderStates(SmartCardReaderStateOut[] readerStates) {
    this.mTag = 0;
    this.mReaderStates = readerStates;
  }

  public SmartCardReaderStateOut[] getReaderStates() {
    if (this.mTag != 0) {
      throw new AssertionError();
    }
    return this.mReaderStates;
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
        SmartCardReaderStateOut[] smartCardReaderStateOutArr = this.mReaderStates;
        if (smartCardReaderStateOutArr == null) {
          encoder0.encodeNullPointer(offset + 8, false);
          return;
        }
        Encoder encoder1 =
            encoder0.encodePointerArray(smartCardReaderStateOutArr.length, offset + 8, -1);
        int i0 = 0;
        while (true) {
          SmartCardReaderStateOut[] smartCardReaderStateOutArr2 = this.mReaderStates;
          if (i0 < smartCardReaderStateOutArr2.length) {
            encoder1.encode((Struct) smartCardReaderStateOutArr2[i0], (i0 * 8) + 8, false);
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

  public static SmartCardStatusChangeResult deserialize(Message message) {
    return decode(new Decoder(message).decoderForSerializedUnion(), 0);
  }

  public static final SmartCardStatusChangeResult decode(Decoder decoder0, int offset) {
    DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
    if (dataHeader.size == 0) {
      return null;
    }
    SmartCardStatusChangeResult result = new SmartCardStatusChangeResult();
    switch (dataHeader.elementsOrVersion) {
      case 0:
        Decoder decoder1 = decoder0.readPointer(offset + 8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.mReaderStates = new SmartCardReaderStateOut[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.mReaderStates[i1] = SmartCardReaderStateOut.decode(decoder2);
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
