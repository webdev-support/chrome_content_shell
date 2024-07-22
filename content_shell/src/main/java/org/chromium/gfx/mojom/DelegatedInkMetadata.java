package org.chromium.gfx.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.TimeTicks;
import org.chromium.skia.mojom.SkColor;

public final class DelegatedInkMetadata extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 64;
  private static final DataHeader[] VERSION_ARRAY;
  public SkColor color;
  public double diameter;
  public TimeTicks frameTime;
  public boolean isHovering;
  public PointF point;
  public RectF presentationArea;
  public TimeTicks timestamp;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(64, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private DelegatedInkMetadata(int version) {
    super(64, version);
  }

  public DelegatedInkMetadata() {
    this(0);
  }

  public static DelegatedInkMetadata deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static DelegatedInkMetadata deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static DelegatedInkMetadata decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      DelegatedInkMetadata result = new DelegatedInkMetadata(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.point = PointF.decode(decoder1);
      result.diameter = decoder0.readDouble(16);
      Decoder decoder12 = decoder0.readPointer(24, false);
      result.color = SkColor.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(32, false);
      result.timestamp = TimeTicks.decode(decoder13);
      Decoder decoder14 = decoder0.readPointer(40, false);
      result.presentationArea = RectF.decode(decoder14);
      Decoder decoder15 = decoder0.readPointer(48, false);
      result.frameTime = TimeTicks.decode(decoder15);
      result.isHovering = decoder0.readBoolean(56, 0);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.point, 8, false);
    encoder0.encode(this.diameter, 16);
    encoder0.encode((Struct) this.color, 24, false);
    encoder0.encode((Struct) this.timestamp, 32, false);
    encoder0.encode((Struct) this.presentationArea, 40, false);
    encoder0.encode((Struct) this.frameTime, 48, false);
    encoder0.encode(this.isHovering, 56, 0);
  }
}
