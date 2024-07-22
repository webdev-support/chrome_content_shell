package org.chromium.viz.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.RectF;
import org.chromium.gfx.mojom.Size;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class TileQuadState extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean forceAntiAliasingOff;
  public boolean isPremultiplied;
  public boolean nearestNeighbor;
  public ResourceId resourceId;
  public RectF texCoordRect;
  public Size textureSize;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private TileQuadState(int version) {
    super(40, version);
  }

  public TileQuadState() {
    this(0);
  }

  public static TileQuadState deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static TileQuadState deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static TileQuadState decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      TileQuadState result = new TileQuadState(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.texCoordRect = RectF.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.textureSize = Size.decode(decoder12);
      result.isPremultiplied = decoder0.readBoolean(24, 0);
      result.nearestNeighbor = decoder0.readBoolean(24, 1);
      result.forceAntiAliasingOff = decoder0.readBoolean(24, 2);
      Decoder decoder13 = decoder0.readPointer(32, false);
      result.resourceId = ResourceId.decode(decoder13);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.texCoordRect, 8, false);
    encoder0.encode((Struct) this.textureSize, 16, false);
    encoder0.encode(this.isPremultiplied, 24, 0);
    encoder0.encode(this.nearestNeighbor, 24, 1);
    encoder0.encode(this.forceAntiAliasingOff, 24, 2);
    encoder0.encode((Struct) this.resourceId, 32, false);
  }
}
