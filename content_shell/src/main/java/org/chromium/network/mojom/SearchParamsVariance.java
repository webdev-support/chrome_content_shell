package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Union;

public final class SearchParamsVariance extends Union {

  private String[] mNoVaryParams;
  private String[] mVaryParams;

  public static final class Tag {
    public static final int NoVaryParams = 0;
    public static final int VaryParams = 1;
  }

  public void setNoVaryParams(String[] noVaryParams) {
    this.mTag = 0;
    this.mNoVaryParams = noVaryParams;
  }

  public String[] getNoVaryParams() {
    if (this.mTag != 0) {
      throw new AssertionError();
    }
    return this.mNoVaryParams;
  }

  public void setVaryParams(String[] varyParams) {
    this.mTag = 1;
    this.mVaryParams = varyParams;
  }

  public String[] getVaryParams() {
    if (this.mTag != 1) {
      throw new AssertionError();
    }
    return this.mVaryParams;
  }

  @Override
  public final void encode(Encoder encoder0, int offset) {
    encoder0.encode(16, offset);
    encoder0.encode(this.mTag, offset + 4);
    switch (this.mTag) {
      case 0:
        String[] strArr = this.mNoVaryParams;
        if (strArr == null) {
          encoder0.encodeNullPointer(offset + 8, false);
          return;
        }
        Encoder encoder1 = encoder0.encodePointerArray(strArr.length, offset + 8, -1);
        int i0 = 0;
        while (true) {
          String[] strArr2 = this.mNoVaryParams;
          if (i0 < strArr2.length) {
            encoder1.encode(strArr2[i0], (i0 * 8) + 8, false);
            i0++;
          } else {
            return;
          }
        }
      case 1:
        String[] strArr3 = this.mVaryParams;
        if (strArr3 == null) {
          encoder0.encodeNullPointer(offset + 8, false);
          return;
        }
        Encoder encoder12 = encoder0.encodePointerArray(strArr3.length, offset + 8, -1);
        int i02 = 0;
        while (true) {
          String[] strArr4 = this.mVaryParams;
          if (i02 < strArr4.length) {
            encoder12.encode(strArr4[i02], (i02 * 8) + 8, false);
            i02++;
          } else {
            return;
          }
        }
      default:
        return;
    }
  }

  public static SearchParamsVariance deserialize(Message message) {
    return decode(new Decoder(message).decoderForSerializedUnion(), 0);
  }

  public static final SearchParamsVariance decode(Decoder decoder0, int offset) {
    DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
    if (dataHeader.size == 0) {
      return null;
    }
    SearchParamsVariance result = new SearchParamsVariance();
    switch (dataHeader.elementsOrVersion) {
      case 0:
        Decoder decoder1 = decoder0.readPointer(offset + 8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.mNoVaryParams = new String[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          result.mNoVaryParams[i1] = decoder1.readString((i1 * 8) + 8, false);
        }
        result.mTag = 0;
        break;
      case 1:
        Decoder decoder12 = decoder0.readPointer(offset + 8, false);
        DataHeader si12 = decoder12.readDataHeaderForPointerArray(-1);
        result.mVaryParams = new String[si12.elementsOrVersion];
        for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
          result.mVaryParams[i12] = decoder12.readString((i12 * 8) + 8, false);
        }
        result.mTag = 1;
        break;
    }
    return result;
  }
}
