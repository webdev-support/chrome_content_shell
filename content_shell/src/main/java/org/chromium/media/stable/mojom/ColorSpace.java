package org.chromium.media.stable.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class ColorSpace extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public float[] customPrimaryMatrix;
  public int matrix;
  public int primaries;
  public int range;
  public int transfer;
  public float[] transferParams;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private ColorSpace(int version) {
    super(40, version);
  }

  public ColorSpace() {
    this(0);
  }

  public static ColorSpace deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static ColorSpace deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static ColorSpace decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      ColorSpace result = new ColorSpace(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.primaries = readInt;
      ColorSpacePrimaryId.validate(readInt);
      result.primaries = ColorSpacePrimaryId.toKnownValue(result.primaries);
      int readInt2 = decoder0.readInt(12);
      result.transfer = readInt2;
      ColorSpaceTransferId.validate(readInt2);
      result.transfer = ColorSpaceTransferId.toKnownValue(result.transfer);
      int readInt3 = decoder0.readInt(16);
      result.matrix = readInt3;
      ColorSpaceMatrixId.validate(readInt3);
      result.matrix = ColorSpaceMatrixId.toKnownValue(result.matrix);
      int readInt4 = decoder0.readInt(20);
      result.range = readInt4;
      ColorSpaceRangeId.validate(readInt4);
      result.range = ColorSpaceRangeId.toKnownValue(result.range);
      result.customPrimaryMatrix = decoder0.readFloats(24, 0, 9);
      result.transferParams = decoder0.readFloats(32, 0, 7);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.primaries, 8);
    encoder0.encode(this.transfer, 12);
    encoder0.encode(this.matrix, 16);
    encoder0.encode(this.range, 20);
    encoder0.encode(this.customPrimaryMatrix, 24, 0, 9);
    encoder0.encode(this.transferParams, 32, 0, 7);
  }
}
