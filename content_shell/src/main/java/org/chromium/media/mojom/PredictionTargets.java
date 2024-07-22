package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class PredictionTargets extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public int framesDecoded;
  public int framesDropped;
  public int framesPowerEfficient;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private PredictionTargets(int version) {
    super(24, version);
    this.framesDecoded = 0;
    this.framesDropped = 0;
    this.framesPowerEfficient = 0;
  }

  public PredictionTargets() {
    this(0);
  }

  public static PredictionTargets deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static PredictionTargets deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static PredictionTargets decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      PredictionTargets result = new PredictionTargets(elementsOrVersion);
      result.framesDecoded = decoder0.readInt(8);
      result.framesDropped = decoder0.readInt(12);
      result.framesPowerEfficient = decoder0.readInt(16);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.framesDecoded, 8);
    encoder0.encode(this.framesDropped, 12);
    encoder0.encode(this.framesPowerEfficient, 16);
  }
}
