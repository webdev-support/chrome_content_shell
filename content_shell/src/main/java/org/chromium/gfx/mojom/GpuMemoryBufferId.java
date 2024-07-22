package org.chromium.gfx.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class GpuMemoryBufferId extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 16;
  private static final DataHeader[] VERSION_ARRAY;

  public int f621id;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private GpuMemoryBufferId(int version) {
    super(16, version);
  }

  public GpuMemoryBufferId() {
    this(0);
  }

  public static GpuMemoryBufferId deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static GpuMemoryBufferId deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static GpuMemoryBufferId decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      GpuMemoryBufferId result = new GpuMemoryBufferId(elementsOrVersion);
      result.f621id = decoder0.readInt(8);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.f621id, 8);
  }
}
