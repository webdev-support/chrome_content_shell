package org.chromium.mojo_base.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.InvalidHandle;
import org.chromium.mojo.system.SharedBufferHandle;

public final class UnsafeSharedMemoryRegion extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 16;
  private static final DataHeader[] VERSION_ARRAY;
  public SharedBufferHandle buffer;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private UnsafeSharedMemoryRegion(int version) {
    super(16, version);
    this.buffer = InvalidHandle.INSTANCE;
  }

  public UnsafeSharedMemoryRegion() {
    this(0);
  }

  public static UnsafeSharedMemoryRegion deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static UnsafeSharedMemoryRegion deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static UnsafeSharedMemoryRegion decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      UnsafeSharedMemoryRegion result = new UnsafeSharedMemoryRegion(elementsOrVersion);
      result.buffer = decoder0.readSharedBufferHandle(8, false);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Handle) this.buffer, 8, false);
  }
}
