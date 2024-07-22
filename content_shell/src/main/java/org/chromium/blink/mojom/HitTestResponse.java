package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Point;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

public final class HitTestResponse extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public FrameToken hitFrameToken;
  public Point hitFrameTransformedPoint;
  public int hitNodeId;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private HitTestResponse(int version) {
    super(40, version);
  }

  public HitTestResponse() {
    this(0);
  }

  public static HitTestResponse deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static HitTestResponse deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static HitTestResponse decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      HitTestResponse result = new HitTestResponse(elementsOrVersion);
      result.hitFrameToken = FrameToken.decode(decoder0, 8);
      Decoder decoder1 = decoder0.readPointer(24, false);
      result.hitFrameTransformedPoint = Point.decode(decoder1);
      result.hitNodeId = decoder0.readInt(32);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Union) this.hitFrameToken, 8, false);
    encoder0.encode((Struct) this.hitFrameTransformedPoint, 24, false);
    encoder0.encode(this.hitNodeId, 32);
  }
}
