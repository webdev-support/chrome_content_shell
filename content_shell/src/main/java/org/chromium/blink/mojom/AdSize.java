package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class AdSize extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public double height;
  public int heightUnits;
  public double width;
  public int widthUnits;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  public static final class LengthUnit {
    public static final int DEFAULT_VALUE = 0;
    public static final int INVALID = 0;
    private static final boolean IS_EXTENSIBLE = true;
    public static final int MAX_VALUE = 3;
    public static final int MIN_VALUE = 0;
    public static final int PIXELS = 1;
    public static final int SCREEN_HEIGHT = 3;
    public static final int SCREEN_WIDTH = 2;

    public @interface EnumType {}

    public static boolean isKnownValue(int value) {
      return value >= 0 && value <= 3;
    }

    public static void validate(int value) {}

    public static int toKnownValue(int value) {
      if (isKnownValue(value)) {
        return value;
      }
      return 0;
    }

    private LengthUnit() {}
  }

  private AdSize(int version) {
    super(32, version);
  }

  public AdSize() {
    this(0);
  }

  public static AdSize deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static AdSize deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static AdSize decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      AdSize result = new AdSize(elementsOrVersion);
      result.width = decoder0.readDouble(8);
      int readInt = decoder0.readInt(16);
      result.widthUnits = readInt;
      LengthUnit.validate(readInt);
      result.widthUnits = LengthUnit.toKnownValue(result.widthUnits);
      int readInt2 = decoder0.readInt(20);
      result.heightUnits = readInt2;
      LengthUnit.validate(readInt2);
      result.heightUnits = LengthUnit.toKnownValue(result.heightUnits);
      result.height = decoder0.readDouble(24);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.width, 8);
    encoder0.encode(this.widthUnits, 16);
    encoder0.encode(this.heightUnits, 20);
    encoder0.encode(this.height, 24);
  }
}
