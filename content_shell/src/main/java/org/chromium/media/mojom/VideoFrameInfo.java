package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.ColorSpace;
import org.chromium.gfx.mojom.Rect;
import org.chromium.gfx.mojom.Size;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.TimeDelta;

public final class VideoFrameInfo extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 64;
  private static final DataHeader[] VERSION_ARRAY;
  public Size codedSize;
  public ColorSpace colorSpace;
  public boolean isPremapped;
  public VideoFrameMetadata metadata;
  public int pixelFormat;
  public PlaneStrides strides;
  public TimeDelta timestamp;
  public Rect visibleRect;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(64, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private VideoFrameInfo(int version) {
    super(64, version);
  }

  public VideoFrameInfo() {
    this(0);
  }

  public static VideoFrameInfo deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static VideoFrameInfo deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static VideoFrameInfo decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      VideoFrameInfo result = new VideoFrameInfo(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.timestamp = TimeDelta.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.metadata = VideoFrameMetadata.decode(decoder12);
      int readInt = decoder0.readInt(24);
      result.pixelFormat = readInt;
      VideoCapturePixelFormat.validate(readInt);
      result.pixelFormat = VideoCapturePixelFormat.toKnownValue(result.pixelFormat);
      result.isPremapped = decoder0.readBoolean(28, 0);
      Decoder decoder13 = decoder0.readPointer(32, false);
      result.codedSize = Size.decode(decoder13);
      Decoder decoder14 = decoder0.readPointer(40, false);
      result.visibleRect = Rect.decode(decoder14);
      Decoder decoder15 = decoder0.readPointer(48, false);
      result.colorSpace = ColorSpace.decode(decoder15);
      Decoder decoder16 = decoder0.readPointer(56, true);
      result.strides = PlaneStrides.decode(decoder16);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.timestamp, 8, false);
    encoder0.encode((Struct) this.metadata, 16, false);
    encoder0.encode(this.pixelFormat, 24);
    encoder0.encode(this.isPremapped, 28, 0);
    encoder0.encode((Struct) this.codedSize, 32, false);
    encoder0.encode((Struct) this.visibleRect, 40, false);
    encoder0.encode((Struct) this.colorSpace, 48, false);
    encoder0.encode((Struct) this.strides, 56, true);
  }
}
