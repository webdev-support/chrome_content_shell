package org.chromium.media.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

public final class CodecMetadata extends Union {

  private Av1Metadata mAv1;
  private H264Metadata mH264;
  private H265Metadata mH265;
  private Vp8Metadata mVp8;
  private Vp9Metadata mVp9;

  public static final class Tag {
    public static final int Av1 = 4;
    public static final int H264 = 0;
    public static final int H265 = 1;
    public static final int Vp8 = 2;
    public static final int Vp9 = 3;
  }

  public void setH264(H264Metadata h264) {
    this.mTag = 0;
    this.mH264 = h264;
  }

  public H264Metadata getH264() {
    if (this.mTag != 0) {
      throw new AssertionError();
    }
    return this.mH264;
  }

  public void setH265(H265Metadata h265) {
    this.mTag = 1;
    this.mH265 = h265;
  }

  public H265Metadata getH265() {
    if (this.mTag != 1) {
      throw new AssertionError();
    }
    return this.mH265;
  }

  public void setVp8(Vp8Metadata vp8) {
    this.mTag = 2;
    this.mVp8 = vp8;
  }

  public Vp8Metadata getVp8() {
    if (this.mTag != 2) {
      throw new AssertionError();
    }
    return this.mVp8;
  }

  public void setVp9(Vp9Metadata vp9) {
    this.mTag = 3;
    this.mVp9 = vp9;
  }

  public Vp9Metadata getVp9() {
    if (this.mTag != 3) {
      throw new AssertionError();
    }
    return this.mVp9;
  }

  public void setAv1(Av1Metadata av1) {
    this.mTag = 4;
    this.mAv1 = av1;
  }

  public Av1Metadata getAv1() {
    if (this.mTag != 4) {
      throw new AssertionError();
    }
    return this.mAv1;
  }

  @Override
  public final void encode(Encoder encoder0, int offset) {
    encoder0.encode(16, offset);
    encoder0.encode(this.mTag, offset + 4);
    switch (this.mTag) {
      case 0:
        encoder0.encode((Struct) this.mH264, offset + 8, false);
        return;
      case 1:
        encoder0.encode((Struct) this.mH265, offset + 8, false);
        return;
      case 2:
        encoder0.encode((Struct) this.mVp8, offset + 8, false);
        return;
      case 3:
        encoder0.encode((Struct) this.mVp9, offset + 8, false);
        return;
      case 4:
        encoder0.encode((Struct) this.mAv1, offset + 8, false);
        return;
      default:
        return;
    }
  }

  public static CodecMetadata deserialize(Message message) {
    return decode(new Decoder(message).decoderForSerializedUnion(), 0);
  }

  public static final CodecMetadata decode(Decoder decoder0, int offset) {
    DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
    if (dataHeader.size == 0) {
      return null;
    }
    CodecMetadata result = new CodecMetadata();
    switch (dataHeader.elementsOrVersion) {
      case 0:
        Decoder decoder1 = decoder0.readPointer(offset + 8, false);
        result.mH264 = H264Metadata.decode(decoder1);
        result.mTag = 0;
        break;
      case 1:
        Decoder decoder12 = decoder0.readPointer(offset + 8, false);
        result.mH265 = H265Metadata.decode(decoder12);
        result.mTag = 1;
        break;
      case 2:
        Decoder decoder13 = decoder0.readPointer(offset + 8, false);
        result.mVp8 = Vp8Metadata.decode(decoder13);
        result.mTag = 2;
        break;
      case 3:
        Decoder decoder14 = decoder0.readPointer(offset + 8, false);
        result.mVp9 = Vp9Metadata.decode(decoder14);
        result.mTag = 3;
        break;
      case 4:
        Decoder decoder15 = decoder0.readPointer(offset + 8, false);
        result.mAv1 = Av1Metadata.decode(decoder15);
        result.mTag = 4;
        break;
    }
    return result;
  }
}
