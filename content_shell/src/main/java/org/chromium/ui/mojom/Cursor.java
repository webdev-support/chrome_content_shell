package org.chromium.ui.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Point;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.skia.mojom.BitmapN32;

public final class Cursor extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public BitmapN32 bitmap;
  public Point hotspot;
  public float imageScaleFactor;
  public int type;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private Cursor(int version) {
    super(32, version);
  }

  public Cursor() {
    this(0);
  }

  public static Cursor deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static Cursor deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static Cursor decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      Cursor result = new Cursor(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.type = readInt;
      CursorType.validate(readInt);
      result.type = CursorType.toKnownValue(result.type);
      result.imageScaleFactor = decoder0.readFloat(12);
      Decoder decoder1 = decoder0.readPointer(16, false);
      result.hotspot = Point.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(24, true);
      result.bitmap = BitmapN32.decode(decoder12);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.type, 8);
    encoder0.encode(this.imageScaleFactor, 12);
    encoder0.encode((Struct) this.hotspot, 16, false);
    encoder0.encode((Struct) this.bitmap, 24, true);
  }
}
