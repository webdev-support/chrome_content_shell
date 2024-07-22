package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.TimeTicks;

public final class EmbeddedWorkerStartTiming extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public TimeTicks scriptEvaluationEndTime;
  public TimeTicks scriptEvaluationStartTime;
  public TimeTicks startWorkerReceivedTime;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private EmbeddedWorkerStartTiming(int version) {
    super(32, version);
  }

  public EmbeddedWorkerStartTiming() {
    this(0);
  }

  public static EmbeddedWorkerStartTiming deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static EmbeddedWorkerStartTiming deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static EmbeddedWorkerStartTiming decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      EmbeddedWorkerStartTiming result = new EmbeddedWorkerStartTiming(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.startWorkerReceivedTime = TimeTicks.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.scriptEvaluationStartTime = TimeTicks.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(24, false);
      result.scriptEvaluationEndTime = TimeTicks.decode(decoder13);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.startWorkerReceivedTime, 8, false);
    encoder0.encode((Struct) this.scriptEvaluationStartTime, 16, false);
    encoder0.encode((Struct) this.scriptEvaluationEndTime, 24, false);
  }
}
