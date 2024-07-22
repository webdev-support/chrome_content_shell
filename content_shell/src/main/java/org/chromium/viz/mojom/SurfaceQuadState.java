package org.chromium.viz.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.skia.mojom.SkColor4f;

public final class SurfaceQuadState extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean allowMerge;
  public SkColor4f defaultBackgroundColor;
  public boolean isReflection;
  public boolean stretchContentToFillBounds;
  public SurfaceRange surfaceRange;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private SurfaceQuadState(int version) {
    super(32, version);
  }

  public SurfaceQuadState() {
    this(0);
  }

  public static SurfaceQuadState deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static SurfaceQuadState deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static SurfaceQuadState decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      SurfaceQuadState result = new SurfaceQuadState(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.surfaceRange = SurfaceRange.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.defaultBackgroundColor = SkColor4f.decode(decoder12);
      result.stretchContentToFillBounds = decoder0.readBoolean(24, 0);
      result.isReflection = decoder0.readBoolean(24, 1);
      result.allowMerge = decoder0.readBoolean(24, 2);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.surfaceRange, 8, false);
    encoder0.encode((Struct) this.defaultBackgroundColor, 16, false);
    encoder0.encode(this.stretchContentToFillBounds, 24, 0);
    encoder0.encode(this.isReflection, 24, 1);
    encoder0.encode(this.allowMerge, 24, 2);
  }
}
