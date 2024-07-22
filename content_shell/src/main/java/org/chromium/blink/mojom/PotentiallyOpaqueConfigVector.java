package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

public final class PotentiallyOpaqueConfigVector extends Union {

  private int mOpaque;
  private FencedFrameConfig[] mTransparent;

  public static final class Tag {
    public static final int Opaque = 1;
    public static final int Transparent = 0;
  }

  public void setTransparent(FencedFrameConfig[] transparent) {
    this.mTag = 0;
    this.mTransparent = transparent;
  }

  public FencedFrameConfig[] getTransparent() {
    if (this.mTag != 0) {
      throw new AssertionError();
    }
    return this.mTransparent;
  }

  public void setOpaque(int opaque) {
    this.mTag = 1;
    this.mOpaque = opaque;
  }

  public int getOpaque() {
    if (this.mTag != 1) {
      throw new AssertionError();
    }
    return this.mOpaque;
  }

  @Override
  public final void encode(Encoder encoder0, int offset) {
    encoder0.encode(16, offset);
    encoder0.encode(this.mTag, offset + 4);
    switch (this.mTag) {
      case 0:
        FencedFrameConfig[] fencedFrameConfigArr = this.mTransparent;
        if (fencedFrameConfigArr == null) {
          encoder0.encodeNullPointer(offset + 8, false);
          return;
        }
        Encoder encoder1 = encoder0.encodePointerArray(fencedFrameConfigArr.length, offset + 8, -1);
        int i0 = 0;
        while (true) {
          FencedFrameConfig[] fencedFrameConfigArr2 = this.mTransparent;
          if (i0 < fencedFrameConfigArr2.length) {
            encoder1.encode((Struct) fencedFrameConfigArr2[i0], (i0 * 8) + 8, false);
            i0++;
          } else {
            return;
          }
        }
      case 1:
        encoder0.encode(this.mOpaque, offset + 8);
        return;
      default:
        return;
    }
  }

  public static PotentiallyOpaqueConfigVector deserialize(Message message) {
    return decode(new Decoder(message).decoderForSerializedUnion(), 0);
  }

  public static final PotentiallyOpaqueConfigVector decode(Decoder decoder0, int offset) {
    DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
    if (dataHeader.size == 0) {
      return null;
    }
    PotentiallyOpaqueConfigVector result = new PotentiallyOpaqueConfigVector();
    switch (dataHeader.elementsOrVersion) {
      case 0:
        Decoder decoder1 = decoder0.readPointer(offset + 8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.mTransparent = new FencedFrameConfig[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.mTransparent[i1] = FencedFrameConfig.decode(decoder2);
        }
        result.mTag = 0;
        break;
      case 1:
        int readInt = decoder0.readInt(offset + 8);
        result.mOpaque = readInt;
        Opaque.validate(readInt);
        result.mOpaque = Opaque.toKnownValue(result.mOpaque);
        result.mTag = 1;
        break;
    }
    return result;
  }
}
