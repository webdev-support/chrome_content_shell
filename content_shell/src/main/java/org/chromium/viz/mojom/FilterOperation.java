package org.chromium.viz.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Point;
import org.chromium.gfx.mojom.Rect;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.skia.mojom.SkColor4f;
import org.chromium.skia.mojom.TileMode;

public final class FilterOperation extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 64;
  private static final DataHeader[] VERSION_ARRAY;
  public float amount;
  public int blurTileMode;
  public SkColor4f dropShadowColor;
  public PaintFilter imageFilter;
  public float[] matrix;
  public Point offset;
  public Rect[] shape;
  public int type;
  public int zoomInset;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(64, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private FilterOperation(int version) {
    super(64, version);
  }

  public FilterOperation() {
    this(0);
  }

  public static FilterOperation deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static FilterOperation deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static FilterOperation decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      FilterOperation result = new FilterOperation(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.type = readInt;
      FilterType.validate(readInt);
      result.type = FilterType.toKnownValue(result.type);
      result.amount = decoder0.readFloat(12);
      Decoder decoder1 = decoder0.readPointer(16, false);
      result.offset = Point.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(24, false);
      result.dropShadowColor = SkColor4f.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(32, false);
      result.imageFilter = PaintFilter.decode(decoder13);
      result.matrix = decoder0.readFloats(40, 1, 20);
      result.zoomInset = decoder0.readInt(48);
      int readInt2 = decoder0.readInt(52);
      result.blurTileMode = readInt2;
      TileMode.validate(readInt2);
      result.blurTileMode = TileMode.toKnownValue(result.blurTileMode);
      Decoder decoder14 = decoder0.readPointer(56, true);
      if (decoder14 == null) {
        result.shape = null;
      } else {
        DataHeader si1 = decoder14.readDataHeaderForPointerArray(-1);
        result.shape = new Rect[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder14.readPointer((i1 * 8) + 8, false);
          result.shape[i1] = Rect.decode(decoder2);
        }
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.type, 8);
    encoder0.encode(this.amount, 12);
    encoder0.encode((Struct) this.offset, 16, false);
    encoder0.encode((Struct) this.dropShadowColor, 24, false);
    encoder0.encode((Struct) this.imageFilter, 32, false);
    encoder0.encode(this.matrix, 40, 1, 20);
    encoder0.encode(this.zoomInset, 48);
    encoder0.encode(this.blurTileMode, 52);
    Rect[] rectArr = this.shape;
    if (rectArr == null) {
      encoder0.encodeNullPointer(56, true);
      return;
    }
    Encoder encoder1 = encoder0.encodePointerArray(rectArr.length, 56, -1);
    int i0 = 0;
    while (true) {
      Rect[] rectArr2 = this.shape;
      if (i0 < rectArr2.length) {
        encoder1.encode((Struct) rectArr2[i0], (i0 * 8) + 8, false);
        i0++;
      } else {
        return;
      }
    }
  }
}
