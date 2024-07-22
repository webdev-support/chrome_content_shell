package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.ReadOnlySharedMemoryRegion;

public final class SharedMemoryVideoFrameData extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public ReadOnlySharedMemoryRegion frameData;
  public int[] offsets;
  public int[] strides;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private SharedMemoryVideoFrameData(int version) {
    super(32, version);
  }

  public SharedMemoryVideoFrameData() {
    this(0);
  }

  public static SharedMemoryVideoFrameData deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static SharedMemoryVideoFrameData deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static SharedMemoryVideoFrameData decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      SharedMemoryVideoFrameData result = new SharedMemoryVideoFrameData(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.frameData = ReadOnlySharedMemoryRegion.decode(decoder1);
      result.strides = decoder0.readInts(16, 0, -1);
      result.offsets = decoder0.readInts(24, 0, -1);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.frameData, 8, false);
    encoder0.encode(this.strides, 16, 0, -1);
    encoder0.encode(this.offsets, 24, 0, -1);
  }
}
