package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Rect;
import org.chromium.gfx.mojom.Size;
import org.chromium.gfx.mojom.Transform;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class SyncCompositorDemandDrawHwParams extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean needNewLocalSurfaceId;
  public Transform transformForTilePriority;
  public Rect viewportRectForTilePriority;
  public Size viewportSize;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private SyncCompositorDemandDrawHwParams(int version) {
    super(40, version);
  }

  public SyncCompositorDemandDrawHwParams() {
    this(0);
  }

  public static SyncCompositorDemandDrawHwParams deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static SyncCompositorDemandDrawHwParams deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static SyncCompositorDemandDrawHwParams decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      SyncCompositorDemandDrawHwParams result =
          new SyncCompositorDemandDrawHwParams(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.viewportSize = Size.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.viewportRectForTilePriority = Rect.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(24, false);
      result.transformForTilePriority = Transform.decode(decoder13);
      result.needNewLocalSurfaceId = decoder0.readBoolean(32, 0);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.viewportSize, 8, false);
    encoder0.encode((Struct) this.viewportRectForTilePriority, 16, false);
    encoder0.encode((Struct) this.transformForTilePriority, 24, false);
    encoder0.encode(this.needNewLocalSurfaceId, 32, 0);
  }
}
