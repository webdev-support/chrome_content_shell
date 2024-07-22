package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class ScrollAlignment extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public int rectHidden;
  public int rectPartial;
  public int rectVisible;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  public static final class Behavior {
    public static final int BOTTOM = 3;
    public static final int CENTER = 1;
    public static final int CLOSEST_EDGE = 6;
    private static final boolean IS_EXTENSIBLE = false;
    public static final int LEFT = 4;
    public static final int MAX_VALUE = 6;
    public static final int MIN_VALUE = 0;
    public static final int NO_SCROLL = 0;
    public static final int RIGHT = 5;
    public static final int TOP = 2;

    public @interface EnumType {}

    public static boolean isKnownValue(int value) {
      return value >= 0 && value <= 6;
    }

    public static void validate(int value) {
      if (!isKnownValue(value)) {
        throw new DeserializationException("Invalid enum value.");
      }
    }

    public static int toKnownValue(int value) {
      return value;
    }

    private Behavior() {}
  }

  private ScrollAlignment(int version) {
    super(24, version);
    this.rectVisible = 0;
    this.rectHidden = 1;
    this.rectPartial = 6;
  }

  public ScrollAlignment() {
    this(0);
  }

  public static ScrollAlignment deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static ScrollAlignment deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static ScrollAlignment decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      ScrollAlignment result = new ScrollAlignment(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.rectVisible = readInt;
      Behavior.validate(readInt);
      result.rectVisible = Behavior.toKnownValue(result.rectVisible);
      int readInt2 = decoder0.readInt(12);
      result.rectHidden = readInt2;
      Behavior.validate(readInt2);
      result.rectHidden = Behavior.toKnownValue(result.rectHidden);
      int readInt3 = decoder0.readInt(16);
      result.rectPartial = readInt3;
      Behavior.validate(readInt3);
      result.rectPartial = Behavior.toKnownValue(result.rectPartial);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.rectVisible, 8);
    encoder0.encode(this.rectHidden, 12);
    encoder0.encode(this.rectPartial, 16);
  }
}
