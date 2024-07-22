package org.chromium.gpu.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class VideoMemoryProcessStats extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean hasDuplicates;
  public long videoMemoryBytes;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private VideoMemoryProcessStats(int version) {
    super(24, version);
  }

  public VideoMemoryProcessStats() {
    this(0);
  }

  public static VideoMemoryProcessStats deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static VideoMemoryProcessStats deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static VideoMemoryProcessStats decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      VideoMemoryProcessStats result = new VideoMemoryProcessStats(elementsOrVersion);
      result.videoMemoryBytes = decoder0.readLong(8);
      result.hasDuplicates = decoder0.readBoolean(16, 0);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.videoMemoryBytes, 8);
    encoder0.encode(this.hasDuplicates, 16, 0);
  }
}
