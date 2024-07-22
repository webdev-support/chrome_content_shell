package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.TimeTicks;

public final class RecordContentToVisibleTimeRequest extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean destinationIsLoaded;
  public TimeTicks eventStartTime;
  public boolean showReasonBfcacheRestore;
  public boolean showReasonTabSwitching;
  public boolean showReasonUnfolding;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private RecordContentToVisibleTimeRequest(int version) {
    super(24, version);
    this.showReasonTabSwitching = false;
    this.showReasonBfcacheRestore = false;
    this.showReasonUnfolding = false;
  }

  public RecordContentToVisibleTimeRequest() {
    this(0);
  }

  public static RecordContentToVisibleTimeRequest deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static RecordContentToVisibleTimeRequest deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static RecordContentToVisibleTimeRequest decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      RecordContentToVisibleTimeRequest result =
          new RecordContentToVisibleTimeRequest(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.eventStartTime = TimeTicks.decode(decoder1);
      result.destinationIsLoaded = decoder0.readBoolean(16, 0);
      result.showReasonTabSwitching = decoder0.readBoolean(16, 1);
      result.showReasonBfcacheRestore = decoder0.readBoolean(16, 2);
      result.showReasonUnfolding = decoder0.readBoolean(16, 3);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.eventStartTime, 8, false);
    encoder0.encode(this.destinationIsLoaded, 16, 0);
    encoder0.encode(this.showReasonTabSwitching, 16, 1);
    encoder0.encode(this.showReasonBfcacheRestore, 16, 2);
    encoder0.encode(this.showReasonUnfolding, 16, 3);
  }
}
