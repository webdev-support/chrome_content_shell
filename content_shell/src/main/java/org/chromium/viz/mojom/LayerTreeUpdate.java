package org.chromium.viz.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Rect;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class LayerTreeUpdate extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public float deviceScaleFactor;
  public Rect deviceViewport;
  public LocalSurfaceId localSurfaceIdFromParent;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private LayerTreeUpdate(int version) {
    super(32, version);
  }

  public LayerTreeUpdate() {
    this(0);
  }

  public static LayerTreeUpdate deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static LayerTreeUpdate deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static LayerTreeUpdate decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      LayerTreeUpdate result = new LayerTreeUpdate(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.deviceViewport = Rect.decode(decoder1);
      result.deviceScaleFactor = decoder0.readFloat(16);
      Decoder decoder12 = decoder0.readPointer(24, false);
      result.localSurfaceIdFromParent = LocalSurfaceId.decode(decoder12);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.deviceViewport, 8, false);
    encoder0.encode(this.deviceScaleFactor, 16);
    encoder0.encode((Struct) this.localSurfaceIdFromParent, 24, false);
  }
}
