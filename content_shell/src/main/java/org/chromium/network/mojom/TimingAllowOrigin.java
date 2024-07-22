package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Union;

public final class TimingAllowOrigin extends Union {

  private byte mAll;
  private String[] mSerializedOrigins;

  public static final class Tag {
    public static final int All = 1;
    public static final int SerializedOrigins = 0;
  }

  public void setSerializedOrigins(String[] serializedOrigins) {
    this.mTag = 0;
    this.mSerializedOrigins = serializedOrigins;
  }

  public String[] getSerializedOrigins() {
    if (this.mTag != 0) {
      throw new AssertionError();
    }
    return this.mSerializedOrigins;
  }

  public void setAll(byte all) {
    this.mTag = 1;
    this.mAll = all;
  }

  public byte getAll() {
    if (this.mTag != 1) {
      throw new AssertionError();
    }
    return this.mAll;
  }

  @Override
  public final void encode(Encoder encoder0, int offset) {
    encoder0.encode(16, offset);
    encoder0.encode(this.mTag, offset + 4);
    switch (this.mTag) {
      case 0:
        String[] strArr = this.mSerializedOrigins;
        if (strArr == null) {
          encoder0.encodeNullPointer(offset + 8, false);
          return;
        }
        Encoder encoder1 = encoder0.encodePointerArray(strArr.length, offset + 8, -1);
        int i0 = 0;
        while (true) {
          String[] strArr2 = this.mSerializedOrigins;
          if (i0 < strArr2.length) {
            encoder1.encode(strArr2[i0], (i0 * 8) + 8, false);
            i0++;
          } else {
            return;
          }
        }
      case 1:
        encoder0.encode(this.mAll, offset + 8);
        return;
      default:
        return;
    }
  }

  public static TimingAllowOrigin deserialize(Message message) {
    return decode(new Decoder(message).decoderForSerializedUnion(), 0);
  }

  public static final TimingAllowOrigin decode(Decoder decoder0, int offset) {
    DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
    if (dataHeader.size == 0) {
      return null;
    }
    TimingAllowOrigin result = new TimingAllowOrigin();
    switch (dataHeader.elementsOrVersion) {
      case 0:
        Decoder decoder1 = decoder0.readPointer(offset + 8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.mSerializedOrigins = new String[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          result.mSerializedOrigins[i1] = decoder1.readString((i1 * 8) + 8, false);
        }
        result.mTag = 0;
        break;
      case 1:
        result.mAll = decoder0.readByte(offset + 8);
        result.mTag = 1;
        break;
    }
    return result;
  }
}
