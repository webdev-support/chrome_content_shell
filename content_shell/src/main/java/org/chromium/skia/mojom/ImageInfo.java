package org.chromium.skia.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class ImageInfo extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public int alphaType;
  public float[] colorToXyzMatrix;
  public float[] colorTransferFunction;
  public int colorType;
  public int height;
  public int width;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private ImageInfo(int version) {
    super(40, version);
  }

  public ImageInfo() {
    this(0);
  }

  public static ImageInfo deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static ImageInfo deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static ImageInfo decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      ImageInfo result = new ImageInfo(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.colorType = readInt;
      ColorType.validate(readInt);
      result.colorType = ColorType.toKnownValue(result.colorType);
      int readInt2 = decoder0.readInt(12);
      result.alphaType = readInt2;
      AlphaType.validate(readInt2);
      result.alphaType = AlphaType.toKnownValue(result.alphaType);
      result.width = decoder0.readInt(16);
      result.height = decoder0.readInt(20);
      result.colorTransferFunction = decoder0.readFloats(24, 1, 7);
      result.colorToXyzMatrix = decoder0.readFloats(32, 1, 9);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.colorType, 8);
    encoder0.encode(this.alphaType, 12);
    encoder0.encode(this.width, 16);
    encoder0.encode(this.height, 20);
    encoder0.encode(this.colorTransferFunction, 24, 1, 7);
    encoder0.encode(this.colorToXyzMatrix, 32, 1, 9);
  }
}
