package org.chromium.device.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.Time;

public final class PressureUpdate extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public int source;
  public int state;
  public Time timestamp;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private PressureUpdate(int version) {
    super(24, version);
  }

  public PressureUpdate() {
    this(0);
  }

  public static PressureUpdate deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static PressureUpdate deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static PressureUpdate decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      PressureUpdate result = new PressureUpdate(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.source = readInt;
      PressureSource.validate(readInt);
      result.source = PressureSource.toKnownValue(result.source);
      int readInt2 = decoder0.readInt(12);
      result.state = readInt2;
      PressureState.validate(readInt2);
      result.state = PressureState.toKnownValue(result.state);
      Decoder decoder1 = decoder0.readPointer(16, false);
      result.timestamp = Time.decode(decoder1);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.source, 8);
    encoder0.encode(this.state, 12);
    encoder0.encode((Struct) this.timestamp, 16, false);
  }
}
