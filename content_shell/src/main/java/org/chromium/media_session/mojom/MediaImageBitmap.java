package org.chromium.media_session.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class MediaImageBitmap extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public int colorType;
  public int height;
  public byte[] pixelData;
  public int width;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0), new DataHeader(32, 5)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[1];
  }

  private MediaImageBitmap(int version) {
    super(32, version);
  }

  public MediaImageBitmap() {
    this(5);
  }

  public static MediaImageBitmap deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static MediaImageBitmap deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static MediaImageBitmap decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      MediaImageBitmap result = new MediaImageBitmap(elementsOrVersion);
      result.width = decoder0.readInt(8);
      result.height = decoder0.readInt(12);
      result.pixelData = decoder0.readBytes(16, 0, -1);
      if (elementsOrVersion >= 5) {
        int readInt = decoder0.readInt(24);
        result.colorType = readInt;
        MediaImageBitmapColorType.validate(readInt);
        result.colorType = MediaImageBitmapColorType.toKnownValue(result.colorType);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.width, 8);
    encoder0.encode(this.height, 12);
    encoder0.encode(this.pixelData, 16, 0, -1);
    encoder0.encode(this.colorType, 24);
  }
}
