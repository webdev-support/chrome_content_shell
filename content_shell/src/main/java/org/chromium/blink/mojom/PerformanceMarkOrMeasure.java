package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;
import org.chromium.mojo_base.mojom.BigBuffer;

public final class PerformanceMarkOrMeasure extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 56;
  private static final DataHeader[] VERSION_ARRAY;
  public BigBuffer detail;
  public double duration;
  public int entryType;
  public String name;
  public double startTime;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(56, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  public static final class EntryType {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int MARK = 0;
    public static final int MAX_VALUE = 1;
    public static final int MEASURE = 1;
    public static final int MIN_VALUE = 0;

    public @interface EnumType {}

    public static boolean isKnownValue(int value) {
      return value >= 0 && value <= 1;
    }

    public static void validate(int value) {
      if (!isKnownValue(value)) {
        throw new DeserializationException("Invalid enum value.");
      }
    }

    public static int toKnownValue(int value) {
      return value;
    }

    private EntryType() {}
  }

  private PerformanceMarkOrMeasure(int version) {
    super(56, version);
  }

  public PerformanceMarkOrMeasure() {
    this(0);
  }

  public static PerformanceMarkOrMeasure deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static PerformanceMarkOrMeasure deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static PerformanceMarkOrMeasure decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      PerformanceMarkOrMeasure result = new PerformanceMarkOrMeasure(elementsOrVersion);
      result.name = decoder0.readString(8, false);
      int readInt = decoder0.readInt(16);
      result.entryType = readInt;
      EntryType.validate(readInt);
      result.entryType = EntryType.toKnownValue(result.entryType);
      result.startTime = decoder0.readDouble(24);
      result.duration = decoder0.readDouble(32);
      result.detail = BigBuffer.decode(decoder0, 40);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.name, 8, false);
    encoder0.encode(this.entryType, 16);
    encoder0.encode(this.startTime, 24);
    encoder0.encode(this.duration, 32);
    encoder0.encode((Union) this.detail, 40, true);
  }
}
