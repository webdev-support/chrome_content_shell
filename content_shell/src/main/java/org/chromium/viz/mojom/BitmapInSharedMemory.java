package org.chromium.viz.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.WritableSharedMemoryRegion;
import org.chromium.skia.mojom.ImageInfo;

public final class BitmapInSharedMemory extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public ImageInfo imageInfo;
  public WritableSharedMemoryRegion pixels;
  public long rowBytes;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private BitmapInSharedMemory(int version) {
    super(32, version);
  }

  public BitmapInSharedMemory() {
    this(0);
  }

  public static BitmapInSharedMemory deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static BitmapInSharedMemory deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static BitmapInSharedMemory decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      BitmapInSharedMemory result = new BitmapInSharedMemory(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.imageInfo = ImageInfo.decode(decoder1);
      result.rowBytes = decoder0.readLong(16);
      Decoder decoder12 = decoder0.readPointer(24, true);
      result.pixels = WritableSharedMemoryRegion.decode(decoder12);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.imageInfo, 8, false);
    encoder0.encode(this.rowBytes, 16);
    encoder0.encode((Struct) this.pixels, 24, true);
  }
}
