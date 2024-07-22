package org.chromium.ui.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.TimeTicks;

public final class EventLatencyMetadata extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public TimeTicks arrivedInBrowserMainTimestamp;
  public TimeTicks dispatchedToRenderer;
  public TimeTicks scrollsBlockingTouchDispatchedToRenderer;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private EventLatencyMetadata(int version) {
    super(32, version);
  }

  public EventLatencyMetadata() {
    this(0);
  }

  public static EventLatencyMetadata deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static EventLatencyMetadata deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static EventLatencyMetadata decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      EventLatencyMetadata result = new EventLatencyMetadata(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.arrivedInBrowserMainTimestamp = TimeTicks.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.scrollsBlockingTouchDispatchedToRenderer = TimeTicks.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(24, false);
      result.dispatchedToRenderer = TimeTicks.decode(decoder13);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.arrivedInBrowserMainTimestamp, 8, false);
    encoder0.encode((Struct) this.scrollsBlockingTouchDispatchedToRenderer, 16, false);
    encoder0.encode((Struct) this.dispatchedToRenderer, 24, false);
  }
}
