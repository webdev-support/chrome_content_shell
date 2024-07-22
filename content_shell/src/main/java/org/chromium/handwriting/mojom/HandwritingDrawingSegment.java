package org.chromium.handwriting.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class HandwritingDrawingSegment extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public int beginPointIndex;
  public int endPointIndex;
  public int strokeIndex;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private HandwritingDrawingSegment(int version) {
    super(24, version);
  }

  public HandwritingDrawingSegment() {
    this(0);
  }

  public static HandwritingDrawingSegment deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static HandwritingDrawingSegment deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static HandwritingDrawingSegment decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      HandwritingDrawingSegment result = new HandwritingDrawingSegment(elementsOrVersion);
      result.strokeIndex = decoder0.readInt(8);
      result.beginPointIndex = decoder0.readInt(12);
      result.endPointIndex = decoder0.readInt(16);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.strokeIndex, 8);
    encoder0.encode(this.beginPointIndex, 12);
    encoder0.encode(this.endPointIndex, 16);
  }
}
