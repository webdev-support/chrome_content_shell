package org.chromium.mojo_base.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class Time extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 16;
  private static final DataHeader[] VERSION_ARRAY;
  public long internalValue;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private Time(int version) {
    super(16, version);
  }

  public Time() {
    this(0);
  }

  public static Time deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static Time deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static Time decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      Time result = new Time(elementsOrVersion);
      result.internalValue = decoder0.readLong(8);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.internalValue, 8);
  }
}