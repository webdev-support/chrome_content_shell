package org.chromium.media.stable.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.GpuMemoryBufferId;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class NativeGpuMemoryBufferHandle extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;

  public GpuMemoryBufferId f677id;
  public NativePixmapHandle platformHandle;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private NativeGpuMemoryBufferHandle(int version) {
    super(24, version);
  }

  public NativeGpuMemoryBufferHandle() {
    this(0);
  }

  public static NativeGpuMemoryBufferHandle deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static NativeGpuMemoryBufferHandle deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static NativeGpuMemoryBufferHandle decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      NativeGpuMemoryBufferHandle result = new NativeGpuMemoryBufferHandle(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.f677id = GpuMemoryBufferId.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.platformHandle = NativePixmapHandle.decode(decoder12);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.f677id, 8, false);
    encoder0.encode((Struct) this.platformHandle, 16, false);
  }
}
