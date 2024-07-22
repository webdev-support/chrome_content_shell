package org.chromium.viz.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.PointF;
import org.chromium.gfx.mojom.RectF;
import org.chromium.gfx.mojom.Size;
import org.chromium.gfx.mojom.Vector2dF;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class CompositorRenderPassQuadState extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 72;
  private static final DataHeader[] VERSION_ARRAY;
  public float backdropFilterQuality;
  public PointF filtersOrigin;
  public Vector2dF filtersScale;
  public boolean forceAntiAliasingOff;
  public boolean intersectsDamageUnder;
  public ResourceId maskResourceId;
  public Size maskTextureSize;
  public RectF maskUvRect;
  public CompositorRenderPassId renderPassId;
  public RectF texCoordRect;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(72, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private CompositorRenderPassQuadState(int version) {
    super(72, version);
  }

  public CompositorRenderPassQuadState() {
    this(0);
  }

  public static CompositorRenderPassQuadState deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static CompositorRenderPassQuadState deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static CompositorRenderPassQuadState decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      CompositorRenderPassQuadState result = new CompositorRenderPassQuadState(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.renderPassId = CompositorRenderPassId.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.maskResourceId = ResourceId.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(24, false);
      result.maskUvRect = RectF.decode(decoder13);
      Decoder decoder14 = decoder0.readPointer(32, false);
      result.maskTextureSize = Size.decode(decoder14);
      Decoder decoder15 = decoder0.readPointer(40, false);
      result.filtersScale = Vector2dF.decode(decoder15);
      Decoder decoder16 = decoder0.readPointer(48, false);
      result.filtersOrigin = PointF.decode(decoder16);
      Decoder decoder17 = decoder0.readPointer(56, false);
      result.texCoordRect = RectF.decode(decoder17);
      result.forceAntiAliasingOff = decoder0.readBoolean(64, 0);
      result.intersectsDamageUnder = decoder0.readBoolean(64, 1);
      result.backdropFilterQuality = decoder0.readFloat(68);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.renderPassId, 8, false);
    encoder0.encode((Struct) this.maskResourceId, 16, false);
    encoder0.encode((Struct) this.maskUvRect, 24, false);
    encoder0.encode((Struct) this.maskTextureSize, 32, false);
    encoder0.encode((Struct) this.filtersScale, 40, false);
    encoder0.encode((Struct) this.filtersOrigin, 48, false);
    encoder0.encode((Struct) this.texCoordRect, 56, false);
    encoder0.encode(this.forceAntiAliasingOff, 64, 0);
    encoder0.encode(this.intersectsDamageUnder, 64, 1);
    encoder0.encode(this.backdropFilterQuality, 68);
  }
}
