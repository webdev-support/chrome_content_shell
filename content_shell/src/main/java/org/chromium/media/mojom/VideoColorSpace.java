package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class VideoColorSpace extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public int matrix;
  public int primaries;
  public int range;
  public int transfer;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  public static final class PrimaryId {
    private static final boolean IS_EXTENSIBLE = false;

    public @interface EnumType {}

    public static boolean isKnownValue(int value) {
      return false;
    }

    public static void validate(int value) {
      if (!isKnownValue(value)) {
        throw new DeserializationException("Invalid enum value.");
      }
    }

    public static int toKnownValue(int value) {
      return value;
    }

    private PrimaryId() {}
  }

  public static final class TransferId {
    private static final boolean IS_EXTENSIBLE = false;

    public @interface EnumType {}

    public static boolean isKnownValue(int value) {
      return false;
    }

    public static void validate(int value) {
      if (!isKnownValue(value)) {
        throw new DeserializationException("Invalid enum value.");
      }
    }

    public static int toKnownValue(int value) {
      return value;
    }

    private TransferId() {}
  }

  public static final class MatrixId {
    private static final boolean IS_EXTENSIBLE = false;

    public @interface EnumType {}

    public static boolean isKnownValue(int value) {
      return false;
    }

    public static void validate(int value) {
      if (!isKnownValue(value)) {
        throw new DeserializationException("Invalid enum value.");
      }
    }

    public static int toKnownValue(int value) {
      return value;
    }

    private MatrixId() {}
  }

  public static final class RangeId {
    private static final boolean IS_EXTENSIBLE = false;

    public @interface EnumType {}

    public static boolean isKnownValue(int value) {
      return false;
    }

    public static void validate(int value) {
      if (!isKnownValue(value)) {
        throw new DeserializationException("Invalid enum value.");
      }
    }

    public static int toKnownValue(int value) {
      return value;
    }

    private RangeId() {}
  }

  private VideoColorSpace(int version) {
    super(24, version);
  }

  public VideoColorSpace() {
    this(0);
  }

  public static VideoColorSpace deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static VideoColorSpace deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static VideoColorSpace decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      VideoColorSpace result = new VideoColorSpace(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.primaries = readInt;
      PrimaryId.validate(readInt);
      result.primaries = PrimaryId.toKnownValue(result.primaries);
      int readInt2 = decoder0.readInt(12);
      result.transfer = readInt2;
      TransferId.validate(readInt2);
      result.transfer = TransferId.toKnownValue(result.transfer);
      int readInt3 = decoder0.readInt(16);
      result.matrix = readInt3;
      MatrixId.validate(readInt3);
      result.matrix = MatrixId.toKnownValue(result.matrix);
      int readInt4 = decoder0.readInt(20);
      result.range = readInt4;
      RangeId.validate(readInt4);
      result.range = RangeId.toKnownValue(result.range);
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
  }
}
