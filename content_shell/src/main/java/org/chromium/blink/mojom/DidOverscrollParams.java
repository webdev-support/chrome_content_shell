package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.cc.mojom.OverscrollBehavior;
import org.chromium.gfx.mojom.PointF;
import org.chromium.gfx.mojom.Vector2dF;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class DidOverscrollParams extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 48;
  private static final DataHeader[] VERSION_ARRAY;
  public Vector2dF accumulatedOverscroll;
  public PointF causalEventViewportPoint;
  public Vector2dF currentFlingVelocity;
  public Vector2dF latestOverscrollDelta;
  public OverscrollBehavior overscrollBehavior;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(48, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private DidOverscrollParams(int version) {
    super(48, version);
  }

  public DidOverscrollParams() {
    this(0);
  }

  public static DidOverscrollParams deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static DidOverscrollParams deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static DidOverscrollParams decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      DidOverscrollParams result = new DidOverscrollParams(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.accumulatedOverscroll = Vector2dF.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.latestOverscrollDelta = Vector2dF.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(24, false);
      result.currentFlingVelocity = Vector2dF.decode(decoder13);
      Decoder decoder14 = decoder0.readPointer(32, false);
      result.causalEventViewportPoint = PointF.decode(decoder14);
      Decoder decoder15 = decoder0.readPointer(40, false);
      result.overscrollBehavior = OverscrollBehavior.decode(decoder15);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.accumulatedOverscroll, 8, false);
    encoder0.encode((Struct) this.latestOverscrollDelta, 16, false);
    encoder0.encode((Struct) this.currentFlingVelocity, 24, false);
    encoder0.encode((Struct) this.causalEventViewportPoint, 32, false);
    encoder0.encode((Struct) this.overscrollBehavior, 40, false);
  }
}
