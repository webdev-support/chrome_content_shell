package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.ColorSpace;
import org.chromium.gfx.mojom.Size;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;
import org.chromium.mojo_base.mojom.TimeDelta;

public final class BitstreamBufferMetadata extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 64;
  private static final DataHeader[] VERSION_ARRAY;
  public CodecMetadata codecMetadata;
  public ColorSpace encodedColorSpace;
  public Size encodedSize;
  public boolean endOfPicture;
  public boolean keyFrame;
  public int payloadSizeBytes;

  public int f662qp;
  public TimeDelta timestamp;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(64, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private BitstreamBufferMetadata(int version) {
    super(64, version);
  }

  public BitstreamBufferMetadata() {
    this(0);
  }

  public static BitstreamBufferMetadata deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static BitstreamBufferMetadata deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static BitstreamBufferMetadata decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      BitstreamBufferMetadata result = new BitstreamBufferMetadata(elementsOrVersion);
      result.payloadSizeBytes = decoder0.readInt(8);
      result.keyFrame = decoder0.readBoolean(12, 0);
      result.endOfPicture = decoder0.readBoolean(12, 1);
      Decoder decoder1 = decoder0.readPointer(16, false);
      result.timestamp = TimeDelta.decode(decoder1);
      result.f662qp = decoder0.readInt(24);
      result.codecMetadata = CodecMetadata.decode(decoder0, 32);
      Decoder decoder12 = decoder0.readPointer(48, true);
      result.encodedSize = Size.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(56, true);
      result.encodedColorSpace = ColorSpace.decode(decoder13);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.payloadSizeBytes, 8);
    encoder0.encode(this.keyFrame, 12, 0);
    encoder0.encode(this.endOfPicture, 12, 1);
    encoder0.encode((Struct) this.timestamp, 16, false);
    encoder0.encode(this.f662qp, 24);
    encoder0.encode((Union) this.codecMetadata, 32, true);
    encoder0.encode((Struct) this.encodedSize, 48, true);
    encoder0.encode((Struct) this.encodedColorSpace, 56, true);
  }
}
