package org.chromium.gfx.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.skia.mojom.SkColorSpacePrimaries;

public final class DisplayColorSpaces extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public int[] bufferFormats;
  public ColorSpace[] colorSpaces;
  public float hdrMaxLuminanceRelative;
  public SkColorSpacePrimaries primaries;
  public float sdrMaxLuminanceNits;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private DisplayColorSpaces(int version) {
    super(40, version);
  }

  public DisplayColorSpaces() {
    this(0);
  }

  public static DisplayColorSpaces deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static DisplayColorSpaces deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static DisplayColorSpaces decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      DisplayColorSpaces result = new DisplayColorSpaces(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(6);
      result.colorSpaces = new ColorSpace[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.colorSpaces[i1] = ColorSpace.decode(decoder2);
      }
      result.bufferFormats = decoder0.readInts(16, 0, 6);
      int i12 = 0;
      while (true) {
        int[] iArr = result.bufferFormats;
        if (i12 < iArr.length) {
          BufferFormat.validate(iArr[i12]);
          i12++;
        } else {
          result.primaries = SkColorSpacePrimaries.decode(decoder0.readPointer(24, false));
          result.sdrMaxLuminanceNits = decoder0.readFloat(32);
          result.hdrMaxLuminanceRelative = decoder0.readFloat(36);
          return result;
        }
      }
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    ColorSpace[] colorSpaceArr = this.colorSpaces;
    if (colorSpaceArr == null) {
      encoder0.encodeNullPointer(8, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(colorSpaceArr.length, 8, 6);
      int i0 = 0;
      while (true) {
        ColorSpace[] colorSpaceArr2 = this.colorSpaces;
        if (i0 >= colorSpaceArr2.length) {
          break;
        }
        encoder1.encode((Struct) colorSpaceArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    encoder0.encode(this.bufferFormats, 16, 0, 6);
    encoder0.encode((Struct) this.primaries, 24, false);
    encoder0.encode(this.sdrMaxLuminanceNits, 32);
    encoder0.encode(this.hdrMaxLuminanceRelative, 36);
  }
}
