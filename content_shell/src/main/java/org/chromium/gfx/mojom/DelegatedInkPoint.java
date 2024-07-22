package org.chromium.gfx.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.TimeTicks;

public final class DelegatedInkPoint extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public PointF point;
  public int pointerId;
  public TimeTicks timestamp;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private DelegatedInkPoint(int version) {
    super(32, version);
  }

  public DelegatedInkPoint() {
    this(0);
  }

  public static DelegatedInkPoint deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static DelegatedInkPoint deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static DelegatedInkPoint decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      DelegatedInkPoint result = new DelegatedInkPoint(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.point = PointF.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.timestamp = TimeTicks.decode(decoder12);
      result.pointerId = decoder0.readInt(24);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.point, 8, false);
    encoder0.encode((Struct) this.timestamp, 16, false);
    encoder0.encode(this.pointerId, 24);
  }
}
