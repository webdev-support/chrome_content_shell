package org.chromium.viz.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.TimeDelta;
import org.chromium.mojo_base.mojom.TimeTicks;

public final class FrameDeadline extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public int deadlineInFrames;
  public TimeDelta frameInterval;
  public TimeTicks frameStartTime;
  public boolean useDefaultLowerBoundDeadline;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private FrameDeadline(int version) {
    super(32, version);
  }

  public FrameDeadline() {
    this(0);
  }

  public static FrameDeadline deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static FrameDeadline deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static FrameDeadline decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      FrameDeadline result = new FrameDeadline(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.frameStartTime = TimeTicks.decode(decoder1);
      result.deadlineInFrames = decoder0.readInt(16);
      result.useDefaultLowerBoundDeadline = decoder0.readBoolean(20, 0);
      Decoder decoder12 = decoder0.readPointer(24, false);
      result.frameInterval = TimeDelta.decode(decoder12);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.frameStartTime, 8, false);
    encoder0.encode(this.deadlineInFrames, 16);
    encoder0.encode(this.useDefaultLowerBoundDeadline, 20, 0);
    encoder0.encode((Struct) this.frameInterval, 24, false);
  }
}
