package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.ColorSpace;
import org.chromium.gfx.mojom.HdrMetadata;
import org.chromium.gfx.mojom.Rect;
import org.chromium.gfx.mojom.Size;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;
import org.chromium.mojo_base.mojom.TimeDelta;

public final class VideoFrame extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 88;
  private static final DataHeader[] VERSION_ARRAY;
  public Size codedSize;
  public ColorSpace colorSpace;
  public VideoFrameData data;
  public int format;
  public HdrMetadata hdrMetadata;
  public VideoFrameMetadata metadata;
  public Size naturalSize;
  public int sharedImageFormatType;
  public TimeDelta timestamp;
  public Rect visibleRect;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(88, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private VideoFrame(int version) {
    super(88, version);
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
      int readInt2 = decoder0.readInt(12);
      result.sharedImageFormatType = readInt2;
      SharedImageFormatType.validate(readInt2);
      result.sharedImageFormatType =
          SharedImageFormatType.toKnownValue(result.sharedImageFormatType);
      Decoder decoder1 = decoder0.readPointer(16, false);
      result.codedSize = Size.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(24, false);
      result.visibleRect = Rect.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(32, false);
      result.naturalSize = Size.decode(decoder13);
      Decoder decoder14 = decoder0.readPointer(40, false);
      result.timestamp = TimeDelta.decode(decoder14);
      result.data = VideoFrameData.decode(decoder0, 48);
      Decoder decoder15 = decoder0.readPointer(64, false);
      result.metadata = VideoFrameMetadata.decode(decoder15);
      Decoder decoder16 = decoder0.readPointer(72, false);
      result.colorSpace = ColorSpace.decode(decoder16);
      Decoder decoder17 = decoder0.readPointer(80, true);
      result.hdrMetadata = HdrMetadata.decode(decoder17);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.format, 8);
    encoder0.encode(this.sharedImageFormatType, 12);
    encoder0.encode((Struct) this.codedSize, 16, false);
    encoder0.encode((Struct) this.visibleRect, 24, false);
    encoder0.encode((Struct) this.naturalSize, 32, false);
    encoder0.encode((Struct) this.timestamp, 40, false);
    encoder0.encode((Union) this.data, 48, false);
    encoder0.encode((Struct) this.metadata, 64, false);
    encoder0.encode((Struct) this.colorSpace, 72, false);
    encoder0.encode((Struct) this.hdrMetadata, 80, true);
  }
}
