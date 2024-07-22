package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class WebrtcPredictionFeatures extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean hardwareAccelerated;
  public boolean isDecodeStats;
  public int profile;
  public int videoPixels;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private WebrtcPredictionFeatures(int version) {
    super(24, version);
    this.isDecodeStats = true;
    this.videoPixels = 0;
    this.hardwareAccelerated = false;
  }

  public WebrtcPredictionFeatures() {
    this(0);
  }

  public static WebrtcPredictionFeatures deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static WebrtcPredictionFeatures deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static WebrtcPredictionFeatures decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      WebrtcPredictionFeatures result = new WebrtcPredictionFeatures(elementsOrVersion);
      result.isDecodeStats = decoder0.readBoolean(8, 0);
      result.hardwareAccelerated = decoder0.readBoolean(8, 1);
      int readInt = decoder0.readInt(12);
      result.profile = readInt;
      VideoCodecProfile.validate(readInt);
      result.profile = VideoCodecProfile.toKnownValue(result.profile);
      result.videoPixels = decoder0.readInt(16);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.isDecodeStats, 8, 0);
    encoder0.encode(this.hardwareAccelerated, 8, 1);
    encoder0.encode(this.profile, 12);
    encoder0.encode(this.videoPixels, 16);
  }
}
