package org.chromium.ax.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.RectF;
import org.chromium.gfx.mojom.Transform;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class AxRelativeBounds extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public RectF bounds;
  public int offsetContainerId;
  public Transform transform;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private AxRelativeBounds(int version) {
    super(32, version);
  }

  public AxRelativeBounds() {
    this(0);
  }

  public static AxRelativeBounds deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static AxRelativeBounds deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static AxRelativeBounds decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      AxRelativeBounds result = new AxRelativeBounds(elementsOrVersion);
      result.offsetContainerId = decoder0.readInt(8);
      Decoder decoder1 = decoder0.readPointer(16, false);
      result.bounds = RectF.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(24, false);
      result.transform = Transform.decode(decoder12);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.offsetContainerId, 8);
    encoder0.encode((Struct) this.bounds, 16, false);
    encoder0.encode((Struct) this.transform, 24, false);
  }
}
