package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class AudioProcessingStats extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public double echoReturnLoss;
  public double echoReturnLossEnhancement;
  public boolean hasEchoReturnLoss;
  public boolean hasEchoReturnLossEnhancement;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private AudioProcessingStats(int version) {
    super(32, version);
  }

  public AudioProcessingStats() {
    this(0);
  }

  public static AudioProcessingStats deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static AudioProcessingStats deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static AudioProcessingStats decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      AudioProcessingStats result = new AudioProcessingStats(elementsOrVersion);
      result.hasEchoReturnLoss = decoder0.readBoolean(8, 0);
      result.hasEchoReturnLossEnhancement = decoder0.readBoolean(8, 1);
      result.echoReturnLoss = decoder0.readDouble(16);
      result.echoReturnLossEnhancement = decoder0.readDouble(24);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.hasEchoReturnLoss, 8, 0);
    encoder0.encode(this.hasEchoReturnLossEnhancement, 8, 1);
    encoder0.encode(this.echoReturnLoss, 16);
    encoder0.encode(this.echoReturnLossEnhancement, 24);
  }
}
