package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class WebrtcVideoStats extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public int framesProcessed;
  public int keyFramesProcessed;
  public float p99ProcessingTimeMs;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private WebrtcVideoStats(int version) {
    super(24, version);
    this.framesProcessed = 0;
    this.keyFramesProcessed = 0;
    this.p99ProcessingTimeMs = 0.0f;
  }

  public WebrtcVideoStats() {
    this(0);
  }

  public static WebrtcVideoStats deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static WebrtcVideoStats deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static WebrtcVideoStats decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      WebrtcVideoStats result = new WebrtcVideoStats(elementsOrVersion);
      result.framesProcessed = decoder0.readInt(8);
      result.keyFramesProcessed = decoder0.readInt(12);
      result.p99ProcessingTimeMs = decoder0.readFloat(16);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.framesProcessed, 8);
    encoder0.encode(this.keyFramesProcessed, 12);
    encoder0.encode(this.p99ProcessingTimeMs, 16);
  }
}
