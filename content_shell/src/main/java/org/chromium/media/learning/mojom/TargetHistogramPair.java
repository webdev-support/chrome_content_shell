package org.chromium.media.learning.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class TargetHistogramPair extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public double count;
  public TargetValue targetValue;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private TargetHistogramPair(int version) {
    super(24, version);
  }

  public TargetHistogramPair() {
    this(0);
  }

  public static TargetHistogramPair deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static TargetHistogramPair deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static TargetHistogramPair decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      TargetHistogramPair result = new TargetHistogramPair(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.targetValue = TargetValue.decode(decoder1);
      result.count = decoder0.readDouble(16);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.targetValue, 8, false);
    encoder0.encode(this.count, 16);
  }
}
