package org.chromium.viz.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.HdrMetadata;
import org.chromium.gfx.mojom.PointF;
import org.chromium.gfx.mojom.Rect;
import org.chromium.gfx.mojom.Size;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.skia.mojom.SkColor4f;

public final class TextureQuadState extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 96;
  private static final DataHeader[] VERSION_ARRAY;
  public SkColor4f backgroundColor;
  public Rect damageRect;
  public boolean forceRgbx;
  public HdrMetadata hdrMetadata;
  public boolean isStreamVideo;
  public boolean isVideoFrame;
  public boolean nearestNeighbor;
  public int overlayPriorityHint;
  public boolean premultipliedAlpha;
  public int protectedVideoType;
  public ResourceId resourceId;
  public Size resourceSizeInPixels;
  public RoundedDisplayMasksInfo roundedDisplayMasksInfo;
  public boolean secureOutputOnly;
  public PointF uvBottomRight;
  public PointF uvTopLeft;
  public float[] vertexOpacity;
  public boolean yFlipped;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(96, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private TextureQuadState(int version) {
    super(96, version);
  }

  public TextureQuadState() {
    this(0);
  }

  public static TextureQuadState deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static TextureQuadState deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static TextureQuadState decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      TextureQuadState result = new TextureQuadState(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.resourceId = ResourceId.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.resourceSizeInPixels = Size.decode(decoder12);
      result.premultipliedAlpha = decoder0.readBoolean(24, 0);
      result.yFlipped = decoder0.readBoolean(24, 1);
      result.nearestNeighbor = decoder0.readBoolean(24, 2);
      result.secureOutputOnly = decoder0.readBoolean(24, 3);
      result.isStreamVideo = decoder0.readBoolean(24, 4);
      result.isVideoFrame = decoder0.readBoolean(24, 5);
      result.forceRgbx = decoder0.readBoolean(24, 6);
      int readInt = decoder0.readInt(28);
      result.protectedVideoType = readInt;
      ProtectedVideoState.validate(readInt);
      result.protectedVideoType = ProtectedVideoState.toKnownValue(result.protectedVideoType);
      Decoder decoder13 = decoder0.readPointer(32, false);
      result.uvTopLeft = PointF.decode(decoder13);
      Decoder decoder14 = decoder0.readPointer(40, false);
      result.uvBottomRight = PointF.decode(decoder14);
      Decoder decoder15 = decoder0.readPointer(48, false);
      result.backgroundColor = SkColor4f.decode(decoder15);
      result.vertexOpacity = decoder0.readFloats(56, 0, 4);
      Decoder decoder16 = decoder0.readPointer(64, false);
      result.hdrMetadata = HdrMetadata.decode(decoder16);
      Decoder decoder17 = decoder0.readPointer(72, true);
      result.damageRect = Rect.decode(decoder17);
      int readInt2 = decoder0.readInt(80);
      result.overlayPriorityHint = readInt2;
      OverlayPriority.validate(readInt2);
      result.overlayPriorityHint = OverlayPriority.toKnownValue(result.overlayPriorityHint);
      Decoder decoder18 = decoder0.readPointer(88, false);
      result.roundedDisplayMasksInfo = RoundedDisplayMasksInfo.decode(decoder18);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.resourceId, 8, false);
    encoder0.encode((Struct) this.resourceSizeInPixels, 16, false);
    encoder0.encode(this.premultipliedAlpha, 24, 0);
    encoder0.encode(this.yFlipped, 24, 1);
    encoder0.encode(this.nearestNeighbor, 24, 2);
    encoder0.encode(this.secureOutputOnly, 24, 3);
    encoder0.encode(this.isStreamVideo, 24, 4);
    encoder0.encode(this.isVideoFrame, 24, 5);
    encoder0.encode(this.forceRgbx, 24, 6);
    encoder0.encode(this.protectedVideoType, 28);
    encoder0.encode((Struct) this.uvTopLeft, 32, false);
    encoder0.encode((Struct) this.uvBottomRight, 40, false);
    encoder0.encode((Struct) this.backgroundColor, 48, false);
    encoder0.encode(this.vertexOpacity, 56, 0, 4);
    encoder0.encode((Struct) this.hdrMetadata, 64, false);
    encoder0.encode((Struct) this.damageRect, 72, true);
    encoder0.encode(this.overlayPriorityHint, 80);
    encoder0.encode((Struct) this.roundedDisplayMasksInfo, 88, false);
  }
}
