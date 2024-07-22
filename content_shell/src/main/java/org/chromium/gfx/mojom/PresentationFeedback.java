package org.chromium.gfx.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.TimeDelta;
import org.chromium.mojo_base.mojom.TimeTicks;

public final class PresentationFeedback extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 64;
  private static final DataHeader[] VERSION_ARRAY;
  public TimeTicks availableTimestamp;
  public int flags;
  public TimeDelta interval;
  public TimeTicks latchTimestamp;
  public TimeTicks readyTimestamp;
  public TimeTicks timestamp;
  public TimeTicks writesDoneTimestamp;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(64, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private PresentationFeedback(int version) {
    super(64, version);
  }

  public PresentationFeedback() {
    this(0);
  }

  public static PresentationFeedback deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static PresentationFeedback deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static PresentationFeedback decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      PresentationFeedback result = new PresentationFeedback(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.timestamp = TimeTicks.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.interval = TimeDelta.decode(decoder12);
      result.flags = decoder0.readInt(24);
      Decoder decoder13 = decoder0.readPointer(32, false);
      result.availableTimestamp = TimeTicks.decode(decoder13);
      Decoder decoder14 = decoder0.readPointer(40, false);
      result.readyTimestamp = TimeTicks.decode(decoder14);
      Decoder decoder15 = decoder0.readPointer(48, false);
      result.latchTimestamp = TimeTicks.decode(decoder15);
      Decoder decoder16 = decoder0.readPointer(56, false);
      result.writesDoneTimestamp = TimeTicks.decode(decoder16);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.timestamp, 8, false);
    encoder0.encode((Struct) this.interval, 16, false);
    encoder0.encode(this.flags, 24);
    encoder0.encode((Struct) this.availableTimestamp, 32, false);
    encoder0.encode((Struct) this.readyTimestamp, 40, false);
    encoder0.encode((Struct) this.latchTimestamp, 48, false);
    encoder0.encode((Struct) this.writesDoneTimestamp, 56, false);
  }
}
