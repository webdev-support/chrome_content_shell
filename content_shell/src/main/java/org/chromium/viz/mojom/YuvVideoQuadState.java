package org.chromium.viz.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.ColorSpace;
import org.chromium.gfx.mojom.HdrMetadata;
import org.chromium.gfx.mojom.Rect;
import org.chromium.gfx.mojom.Size;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class YuvVideoQuadState extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 104;
  private static final DataHeader[] VERSION_ARRAY;
  public ResourceId aPlaneResourceId;
  public int bitsPerChannel;
  public Size codedSize;
  public Rect damageRect;
  public HdrMetadata hdrMetadata;
  public int protectedVideoType;
  public float resourceMultiplier;
  public float resourceOffset;
  public ResourceId uPlaneResourceId;
  public byte uScale;
  public ResourceId vPlaneResourceId;
  public byte vScale;
  public ColorSpace videoColorSpace;
  public Rect videoVisibleRect;
  public ResourceId yPlaneResourceId;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(104, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private YuvVideoQuadState(int version) {
    super(104, version);
  }

  public YuvVideoQuadState() {
    this(0);
  }

  public static YuvVideoQuadState deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static YuvVideoQuadState deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static YuvVideoQuadState decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      YuvVideoQuadState result = new YuvVideoQuadState(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.codedSize = Size.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.videoVisibleRect = Rect.decode(decoder12);
      result.uScale = decoder0.readByte(24);
      result.vScale = decoder0.readByte(25);
      result.resourceOffset = decoder0.readFloat(28);
      Decoder decoder13 = decoder0.readPointer(32, false);
      result.yPlaneResourceId = ResourceId.decode(decoder13);
      Decoder decoder14 = decoder0.readPointer(40, false);
      result.uPlaneResourceId = ResourceId.decode(decoder14);
      Decoder decoder15 = decoder0.readPointer(48, false);
      result.vPlaneResourceId = ResourceId.decode(decoder15);
      Decoder decoder16 = decoder0.readPointer(56, false);
      result.aPlaneResourceId = ResourceId.decode(decoder16);
      result.resourceMultiplier = decoder0.readFloat(64);
      result.bitsPerChannel = decoder0.readInt(68);
      Decoder decoder17 = decoder0.readPointer(72, false);
      result.videoColorSpace = ColorSpace.decode(decoder17);
      int readInt = decoder0.readInt(80);
      result.protectedVideoType = readInt;
      ProtectedVideoState.validate(readInt);
      result.protectedVideoType = ProtectedVideoState.toKnownValue(result.protectedVideoType);
      Decoder decoder18 = decoder0.readPointer(88, false);
      result.hdrMetadata = HdrMetadata.decode(decoder18);
      Decoder decoder19 = decoder0.readPointer(96, true);
      result.damageRect = Rect.decode(decoder19);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.codedSize, 8, false);
    encoder0.encode((Struct) this.videoVisibleRect, 16, false);
    encoder0.encode(this.uScale, 24);
    encoder0.encode(this.vScale, 25);
    encoder0.encode(this.resourceOffset, 28);
    encoder0.encode((Struct) this.yPlaneResourceId, 32, false);
    encoder0.encode((Struct) this.uPlaneResourceId, 40, false);
    encoder0.encode((Struct) this.vPlaneResourceId, 48, false);
    encoder0.encode((Struct) this.aPlaneResourceId, 56, false);
    encoder0.encode(this.resourceMultiplier, 64);
    encoder0.encode(this.bitsPerChannel, 68);
    encoder0.encode((Struct) this.videoColorSpace, 72, false);
    encoder0.encode(this.protectedVideoType, 80);
    encoder0.encode((Struct) this.hdrMetadata, 88, false);
    encoder0.encode((Struct) this.damageRect, 96, true);
  }
}
