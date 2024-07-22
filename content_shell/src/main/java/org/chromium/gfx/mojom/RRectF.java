package org.chromium.gfx.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class RRectF extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 56;
  private static final DataHeader[] VERSION_ARRAY;
  public Vector2dF lowerLeft;
  public Vector2dF lowerRight;
  public RectF rect;
  public int type;
  public Vector2dF upperLeft;
  public Vector2dF upperRight;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(56, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private RRectF(int version) {
    super(56, version);
  }

  public RRectF() {
    this(0);
  }

  public static RRectF deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static RRectF deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static RRectF decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      RRectF result = new RRectF(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.type = readInt;
      RRectFType.validate(readInt);
      result.type = RRectFType.toKnownValue(result.type);
      Decoder decoder1 = decoder0.readPointer(16, false);
      result.rect = RectF.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(24, false);
      result.upperLeft = Vector2dF.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(32, false);
      result.upperRight = Vector2dF.decode(decoder13);
      Decoder decoder14 = decoder0.readPointer(40, false);
      result.lowerRight = Vector2dF.decode(decoder14);
      Decoder decoder15 = decoder0.readPointer(48, false);
      result.lowerLeft = Vector2dF.decode(decoder15);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.type, 8);
    encoder0.encode((Struct) this.rect, 16, false);
    encoder0.encode((Struct) this.upperLeft, 24, false);
    encoder0.encode((Struct) this.upperRight, 32, false);
    encoder0.encode((Struct) this.lowerRight, 40, false);
    encoder0.encode((Struct) this.lowerLeft, 48, false);
  }
}
