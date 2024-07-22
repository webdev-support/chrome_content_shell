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

public final class HitTestRegionList extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public int asyncHitTestReasons;
  public Rect bounds;
  public int flags;
  public HitTestRegion[] regions;
  public Transform transform;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private HitTestRegionList(int version) {
    super(40, version);
  }

  public HitTestRegionList() {
    this(0);
  }

  public static HitTestRegionList deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static HitTestRegionList deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static HitTestRegionList decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      HitTestRegionList result = new HitTestRegionList(elementsOrVersion);
      result.flags = decoder0.readInt(8);
      result.asyncHitTestReasons = decoder0.readInt(12);
      Decoder decoder1 = decoder0.readPointer(16, false);
      result.bounds = Rect.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(24, false);
      result.transform = Transform.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(32, false);
      DataHeader si1 = decoder13.readDataHeaderForPointerArray(-1);
      result.regions = new HitTestRegion[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder13.readPointer((i1 * 8) + 8, false);
        result.regions[i1] = HitTestRegion.decode(decoder2);
      }
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
    encoder0.encode((Struct) this.bounds, 16, false);
    encoder0.encode((Struct) this.transform, 24, false);
    HitTestRegion[] hitTestRegionArr = this.regions;
    if (hitTestRegionArr == null) {
      encoder0.encodeNullPointer(32, false);
      return;
    }
    Encoder encoder1 = encoder0.encodePointerArray(hitTestRegionArr.length, 32, -1);
    int i0 = 0;
    while (true) {
      HitTestRegion[] hitTestRegionArr2 = this.regions;
      if (i0 < hitTestRegionArr2.length) {
        encoder1.encode((Struct) hitTestRegionArr2[i0], (i0 * 8) + 8, false);
        i0++;
      } else {
        return;
      }
    }
  }
}
