package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Size;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class PredictionFeatures extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public double framesPerSec;
  public String keySystem;
  public int profile;
  public boolean useHwSecureCodecs;
  public Size videoSize;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private PredictionFeatures(int version) {
    super(40, version);
    this.framesPerSec = 0.0d;
    this.useHwSecureCodecs = false;
  }

  public PredictionFeatures() {
    this(0);
  }

  public static PredictionFeatures deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static PredictionFeatures deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static PredictionFeatures decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      PredictionFeatures result = new PredictionFeatures(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.profile = readInt;
      VideoCodecProfile.validate(readInt);
      result.profile = VideoCodecProfile.toKnownValue(result.profile);
      result.useHwSecureCodecs = decoder0.readBoolean(12, 0);
      Decoder decoder1 = decoder0.readPointer(16, false);
      result.videoSize = Size.decode(decoder1);
      result.framesPerSec = decoder0.readDouble(24);
      result.keySystem = decoder0.readString(32, false);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.profile, 8);
    encoder0.encode(this.useHwSecureCodecs, 12, 0);
    encoder0.encode((Struct) this.videoSize, 16, false);
    encoder0.encode(this.framesPerSec, 24);
    encoder0.encode(this.keySystem, 32, false);
  }
}
