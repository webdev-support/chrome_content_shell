package org.chromium.media.stable.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.DictionaryValue;
import org.chromium.mojo_base.mojom.TimeTicks;

public final class MediaLogRecord extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;

  public int f676id;
  public DictionaryValue params;
  public TimeTicks time;
  public int type;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  public static final class Type {
    public static final int DEFAULT_VALUE = 0;
    private static final boolean IS_EXTENSIBLE = true;
    public static final int MAX_VALUE = 3;
    public static final int MEDIA_EVENT_TRIGGERED = 2;
    public static final int MEDIA_PROPERTY_CHANGE = 1;
    public static final int MEDIA_STATUS = 3;
    public static final int MESSAGE = 0;
    public static final int MIN_VALUE = 0;

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

    private Type() {}
  }

  private MediaLogRecord(int version) {
    super(32, version);
  }

  public MediaLogRecord() {
    this(0);
  }

  public static MediaLogRecord deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static MediaLogRecord deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static MediaLogRecord decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      MediaLogRecord result = new MediaLogRecord(elementsOrVersion);
      result.f676id = decoder0.readInt(8);
      int readInt = decoder0.readInt(12);
      result.type = readInt;
      Type.validate(readInt);
      result.type = Type.toKnownValue(result.type);
      Decoder decoder1 = decoder0.readPointer(16, false);
      result.params = DictionaryValue.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(24, false);
      result.time = TimeTicks.decode(decoder12);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.f676id, 8);
    encoder0.encode(this.type, 12);
    encoder0.encode((Struct) this.params, 16, false);
    encoder0.encode((Struct) this.time, 24, false);
  }
}
