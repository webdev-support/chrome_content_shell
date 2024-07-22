package org.chromium.viz.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Rect;
import org.chromium.gfx.mojom.Transform;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class HitTestRegion extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public int asyncHitTestReasons;
  public int flags;
  public FrameSinkId frameSinkId;
  public Rect rect;
  public Transform transform;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private HitTestRegion(int version) {
    super(40, version);
  }

  public HitTestRegion() {
    this(0);
  }

  public static HitTestRegion deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static HitTestRegion deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static HitTestRegion decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      HitTestRegion result = new HitTestRegion(elementsOrVersion);
      result.flags = decoder0.readInt(8);
      result.asyncHitTestReasons = decoder0.readInt(12);
      Decoder decoder1 = decoder0.readPointer(16, false);
      result.frameSinkId = FrameSinkId.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(24, false);
      result.rect = Rect.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(32, false);
      result.transform = Transform.decode(decoder13);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.flags, 8);
    encoder0.encode(this.asyncHitTestReasons, 12);
    encoder0.encode((Struct) this.frameSinkId, 16, false);
    encoder0.encode((Struct) this.rect, 24, false);
    encoder0.encode((Struct) this.transform, 32, false);
  }
}
