package org.chromium.skia.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;
import org.chromium.mojo_base.mojom.BigBuffer;

public final class BitmapN32 extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public BitmapN32ImageInfo imageInfo;
  public BigBuffer pixelData;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private BitmapN32(int version) {
    super(32, version);
  }

  public BitmapN32() {
    this(0);
  }

  public static BitmapN32 deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static BitmapN32 deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static BitmapN32 decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      BitmapN32 result = new BitmapN32(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.imageInfo = BitmapN32ImageInfo.decode(decoder1);
      result.pixelData = BigBuffer.decode(decoder0, 16);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.imageInfo, 8, false);
    encoder0.encode((Union) this.pixelData, 16, false);
  }
}