package org.chromium.viz.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.PresentationFeedback;
import org.chromium.gfx.mojom.SwapTimings;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.TimeTicks;

public final class FrameTimingDetails extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public TimeTicks drawStartTimestamp;
  public PresentationFeedback presentationFeedback;
  public TimeTicks receivedCompositorFrameTimestamp;
  public SwapTimings swapTimings;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private FrameTimingDetails(int version) {
    super(40, version);
  }

  public FrameTimingDetails() {
    this(0);
  }

  public static FrameTimingDetails deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static FrameTimingDetails deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static FrameTimingDetails decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      FrameTimingDetails result = new FrameTimingDetails(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.receivedCompositorFrameTimestamp = TimeTicks.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.drawStartTimestamp = TimeTicks.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(24, false);
      result.swapTimings = SwapTimings.decode(decoder13);
      Decoder decoder14 = decoder0.readPointer(32, false);
      result.presentationFeedback = PresentationFeedback.decode(decoder14);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.receivedCompositorFrameTimestamp, 8, false);
    encoder0.encode((Struct) this.drawStartTimestamp, 16, false);
    encoder0.encode((Struct) this.swapTimings, 24, false);
    encoder0.encode((Struct) this.presentationFeedback, 32, false);
  }
}
