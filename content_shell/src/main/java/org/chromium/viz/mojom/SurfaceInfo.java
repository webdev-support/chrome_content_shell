package org.chromium.viz.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Size;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class SurfaceInfo extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public float deviceScaleFactor;
  public Size sizeInPixels;
  public SurfaceId surfaceId;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private SurfaceInfo(int version) {
    super(32, version);
  }

  public SurfaceInfo() {
    this(0);
  }

  public static SurfaceInfo deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static SurfaceInfo deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static SurfaceInfo decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      SurfaceInfo result = new SurfaceInfo(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.surfaceId = SurfaceId.decode(decoder1);
      result.deviceScaleFactor = decoder0.readFloat(16);
      Decoder decoder12 = decoder0.readPointer(24, false);
      result.sizeInPixels = Size.decode(decoder12);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.surfaceId, 8, false);
    encoder0.encode(this.deviceScaleFactor, 16);
    encoder0.encode((Struct) this.sizeInPixels, 24, false);
  }
}
