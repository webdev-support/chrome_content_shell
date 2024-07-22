package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Size;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class VideoCaptureFormat extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public float frameRate;
  public Size frameSize;
  public int pixelFormat;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private VideoCaptureFormat(int version) {
    super(24, version);
  }

  public VideoCaptureFormat() {
    this(0);
  }

  public static VideoCaptureFormat deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static VideoCaptureFormat deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static VideoCaptureFormat decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      VideoCaptureFormat result = new VideoCaptureFormat(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.frameSize = Size.decode(decoder1);
      result.frameRate = decoder0.readFloat(16);
      int readInt = decoder0.readInt(20);
      result.pixelFormat = readInt;
      VideoCapturePixelFormat.validate(readInt);
      result.pixelFormat = VideoCapturePixelFormat.toKnownValue(result.pixelFormat);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.frameSize, 8, false);
    encoder0.encode(this.frameRate, 16);
    encoder0.encode(this.pixelFormat, 20);
  }
}
