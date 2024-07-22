package org.chromium.viz.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.MaskFilterInfo;
import org.chromium.gfx.mojom.Rect;
import org.chromium.gfx.mojom.Transform;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class SharedQuadState extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 72;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean areContentsOpaque;
  public int blendMode;
  public Rect clipRect;
  public boolean isFastRoundedCorner;
  public int layerId;
  public MaskFilterInfo maskFilterInfo;
  public float opacity;
  public Rect quadLayerRect;
  public Transform quadToTargetTransform;
  public int sortingContextId;
  public Rect visibleQuadLayerRect;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(72, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private SharedQuadState(int version) {
    super(72, version);
  }

  public SharedQuadState() {
    this(0);
  }

  public static SharedQuadState deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static SharedQuadState deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static SharedQuadState decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      SharedQuadState result = new SharedQuadState(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.quadToTargetTransform = Transform.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.quadLayerRect = Rect.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(24, false);
      result.visibleQuadLayerRect = Rect.decode(decoder13);
      Decoder decoder14 = decoder0.readPointer(32, true);
      result.maskFilterInfo = MaskFilterInfo.decode(decoder14);
      Decoder decoder15 = decoder0.readPointer(40, true);
      result.clipRect = Rect.decode(decoder15);
      result.areContentsOpaque = decoder0.readBoolean(48, 0);
      result.isFastRoundedCorner = decoder0.readBoolean(48, 1);
      result.opacity = decoder0.readFloat(52);
      result.blendMode = decoder0.readInt(56);
      result.sortingContextId = decoder0.readInt(60);
      result.layerId = decoder0.readInt(64);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.quadToTargetTransform, 8, false);
    encoder0.encode((Struct) this.quadLayerRect, 16, false);
    encoder0.encode((Struct) this.visibleQuadLayerRect, 24, false);
    encoder0.encode((Struct) this.maskFilterInfo, 32, true);
    encoder0.encode((Struct) this.clipRect, 40, true);
    encoder0.encode(this.areContentsOpaque, 48, 0);
    encoder0.encode(this.isFastRoundedCorner, 48, 1);
    encoder0.encode(this.opacity, 52);
    encoder0.encode(this.blendMode, 56);
    encoder0.encode(this.sortingContextId, 60);
    encoder0.encode(this.layerId, 64);
  }
}
