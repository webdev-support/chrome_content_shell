package org.chromium.media.stable.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Rect;
import org.chromium.gfx.mojom.Size;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.TimeDelta;

public final class VideoFrame extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 80;
  private static final DataHeader[] VERSION_ARRAY;
  public Size codedSize;
  public ColorSpace colorSpace;
  public int format;
  public NativeGpuMemoryBufferHandle gpuMemoryBufferHandle;
  public HdrMetadata hdrMetadata;
  public VideoFrameMetadata metadata;
  public Size naturalSize;
  public TimeDelta timestamp;
  public Rect visibleRect;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(80, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private VideoFrame(int version) {
    super(80, version);
  }

  public VideoFrame() {
    this(0);
  }

  public static VideoFrame deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static VideoFrame deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static VideoFrame decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      VideoFrame result = new VideoFrame(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.format = readInt;
      VideoPixelFormat.validate(readInt);
      result.format = VideoPixelFormat.toKnownValue(result.format);
      Decoder decoder1 = decoder0.readPointer(16, false);
      result.codedSize = Size.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(24, false);
      result.visibleRect = Rect.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(32, false);
      result.naturalSize = Size.decode(decoder13);
      Decoder decoder14 = decoder0.readPointer(40, false);
      result.timestamp = TimeDelta.decode(decoder14);
      Decoder decoder15 = decoder0.readPointer(48, false);
      result.gpuMemoryBufferHandle = NativeGpuMemoryBufferHandle.decode(decoder15);
      Decoder decoder16 = decoder0.readPointer(56, false);
      result.metadata = VideoFrameMetadata.decode(decoder16);
      Decoder decoder17 = decoder0.readPointer(64, false);
      result.colorSpace = ColorSpace.decode(decoder17);
      Decoder decoder18 = decoder0.readPointer(72, true);
      result.hdrMetadata = HdrMetadata.decode(decoder18);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.format, 8);
    encoder0.encode((Struct) this.codedSize, 16, false);
    encoder0.encode((Struct) this.visibleRect, 24, false);
    encoder0.encode((Struct) this.naturalSize, 32, false);
    encoder0.encode((Struct) this.timestamp, 40, false);
    encoder0.encode((Struct) this.gpuMemoryBufferHandle, 48, false);
    encoder0.encode((Struct) this.metadata, 56, false);
    encoder0.encode((Struct) this.colorSpace, 64, false);
    encoder0.encode((Struct) this.hdrMetadata, 72, true);
  }
}
