package org.chromium.media.stable.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class VideoFrameMetadata extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 16;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean hwProtected;
  public boolean needsDetiling;
  public boolean protectedVideo;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(16, 0), new DataHeader(16, 1)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[1];
  }

  private VideoFrameMetadata(int version) {
    super(16, version);
  }

  public VideoFrameMetadata() {
    this(1);
  }

  public static VideoFrameMetadata deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static VideoFrameMetadata deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static VideoFrameMetadata decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      VideoFrameMetadata result = new VideoFrameMetadata(elementsOrVersion);
      result.protectedVideo = decoder0.readBoolean(8, 0);
      result.hwProtected = decoder0.readBoolean(8, 1);
      if (elementsOrVersion >= 1) {
        result.needsDetiling = decoder0.readBoolean(8, 2);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.protectedVideo, 8, 0);
    encoder0.encode(this.hwProtected, 8, 1);
    encoder0.encode(this.needsDetiling, 8, 2);
  }
}
