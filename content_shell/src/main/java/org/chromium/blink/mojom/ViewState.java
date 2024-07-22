package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Point;
import org.chromium.gfx.mojom.PointF;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.String16;

public final class ViewState extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 56;
  private static final DataHeader[] VERSION_ARRAY;
  public double pageScaleFactor;
  public PointF scrollAnchorOffset;
  public String16 scrollAnchorSelector;
  public long scrollAnchorSimhash;
  public Point scrollOffset;
  public PointF visualViewportScrollOffset;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0), new DataHeader(56, 1)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[1];
  }

  private ViewState(int version) {
    super(56, version);
    this.scrollAnchorSimhash = 0L;
  }

  public ViewState() {
    this(1);
  }

  public static ViewState deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static ViewState deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static ViewState decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      ViewState result = new ViewState(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.visualViewportScrollOffset = PointF.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.scrollOffset = Point.decode(decoder12);
      result.pageScaleFactor = decoder0.readDouble(24);
      if (elementsOrVersion >= 1) {
        Decoder decoder13 = decoder0.readPointer(32, true);
        result.scrollAnchorSelector = String16.decode(decoder13);
        Decoder decoder14 = decoder0.readPointer(40, true);
        result.scrollAnchorOffset = PointF.decode(decoder14);
        result.scrollAnchorSimhash = decoder0.readLong(48);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.visualViewportScrollOffset, 8, false);
    encoder0.encode((Struct) this.scrollOffset, 16, false);
    encoder0.encode(this.pageScaleFactor, 24);
    encoder0.encode((Struct) this.scrollAnchorSelector, 32, true);
    encoder0.encode((Struct) this.scrollAnchorOffset, 40, true);
    encoder0.encode(this.scrollAnchorSimhash, 48);
  }
}
