package org.chromium.gfx.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class SelectionBound extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 48;
  private static final DataHeader[] VERSION_ARRAY;
  public PointF edgeEnd;
  public PointF edgeStart;
  public int type;
  public boolean visible;
  public PointF visibleEdgeEnd;
  public PointF visibleEdgeStart;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(48, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private SelectionBound(int version) {
    super(48, version);
  }

  public SelectionBound() {
    this(0);
  }

  public static SelectionBound deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static SelectionBound deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static SelectionBound decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      SelectionBound result = new SelectionBound(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.type = readInt;
      SelectionBoundType.validate(readInt);
      result.type = SelectionBoundType.toKnownValue(result.type);
      result.visible = decoder0.readBoolean(12, 0);
      Decoder decoder1 = decoder0.readPointer(16, false);
      result.edgeStart = PointF.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(24, false);
      result.edgeEnd = PointF.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(32, false);
      result.visibleEdgeStart = PointF.decode(decoder13);
      Decoder decoder14 = decoder0.readPointer(40, false);
      result.visibleEdgeEnd = PointF.decode(decoder14);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.type, 8);
    encoder0.encode(this.visible, 12, 0);
    encoder0.encode((Struct) this.edgeStart, 16, false);
    encoder0.encode((Struct) this.edgeEnd, 24, false);
    encoder0.encode((Struct) this.visibleEdgeStart, 32, false);
    encoder0.encode((Struct) this.visibleEdgeEnd, 40, false);
  }
}
