package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.PointF;
import org.chromium.gfx.mojom.SizeF;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class SyncCompositorCommonRendererParams extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 64;
  private static final DataHeader[] VERSION_ARRAY;
  public int didActivatePendingTreeCount;
  public boolean invalidateNeedsDraw;
  public float maxPageScaleFactor;
  public PointF maxScrollOffset;
  public float minPageScaleFactor;
  public int needInvalidateCount;
  public float pageScaleFactor;
  public SizeF scrollableSize;
  public PointF totalScrollOffset;
  public int version;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(64, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private SyncCompositorCommonRendererParams(int version) {
    super(64, version);
    this.version = 0;
    this.pageScaleFactor = 0.0f;
    this.minPageScaleFactor = 0.0f;
    this.maxPageScaleFactor = 0.0f;
    this.needInvalidateCount = 0;
    this.invalidateNeedsDraw = true;
    this.didActivatePendingTreeCount = 0;
  }

  public SyncCompositorCommonRendererParams() {
    this(0);
  }

  public static SyncCompositorCommonRendererParams deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static SyncCompositorCommonRendererParams deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static SyncCompositorCommonRendererParams decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      SyncCompositorCommonRendererParams result =
          new SyncCompositorCommonRendererParams(elementsOrVersion);
      result.version = decoder0.readInt(8);
      result.pageScaleFactor = decoder0.readFloat(12);
      Decoder decoder1 = decoder0.readPointer(16, false);
      result.totalScrollOffset = PointF.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(24, false);
      result.maxScrollOffset = PointF.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(32, false);
      result.scrollableSize = SizeF.decode(decoder13);
      result.minPageScaleFactor = decoder0.readFloat(40);
      result.maxPageScaleFactor = decoder0.readFloat(44);
      result.needInvalidateCount = decoder0.readInt(48);
      result.invalidateNeedsDraw = decoder0.readBoolean(52, 0);
      result.didActivatePendingTreeCount = decoder0.readInt(56);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.version, 8);
    encoder0.encode(this.pageScaleFactor, 12);
    encoder0.encode((Struct) this.totalScrollOffset, 16, false);
    encoder0.encode((Struct) this.maxScrollOffset, 24, false);
    encoder0.encode((Struct) this.scrollableSize, 32, false);
    encoder0.encode(this.minPageScaleFactor, 40);
    encoder0.encode(this.maxPageScaleFactor, 44);
    encoder0.encode(this.needInvalidateCount, 48);
    encoder0.encode(this.invalidateNeedsDraw, 52, 0);
    encoder0.encode(this.didActivatePendingTreeCount, 56);
  }
}
