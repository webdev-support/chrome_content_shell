package org.chromium.gfx.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

public final class GpuMemoryBufferHandle extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;

  public GpuMemoryBufferId f620id;
  public int offset;
  public GpuMemoryBufferPlatformHandle platformHandle;
  public int stride;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private GpuMemoryBufferHandle(int version) {
    super(40, version);
  }

  public GpuMemoryBufferHandle() {
    this(0);
  }

  public static GpuMemoryBufferHandle deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static GpuMemoryBufferHandle deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static GpuMemoryBufferHandle decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      GpuMemoryBufferHandle result = new GpuMemoryBufferHandle(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.f620id = GpuMemoryBufferId.decode(decoder1);
      result.offset = decoder0.readInt(16);
      result.stride = decoder0.readInt(20);
      result.platformHandle = GpuMemoryBufferPlatformHandle.decode(decoder0, 24);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.f620id, 8, false);
    encoder0.encode(this.offset, 16);
    encoder0.encode(this.stride, 20);
    encoder0.encode((Union) this.platformHandle, 24, true);
  }
}
