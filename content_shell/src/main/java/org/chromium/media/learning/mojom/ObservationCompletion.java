package org.chromium.media.learning.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class ObservationCompletion extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public TargetValue targetValue;
  public long weight;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private ObservationCompletion(int version) {
    super(24, version);
    this.weight = 1L;
  }

  public ObservationCompletion() {
    this(0);
  }

  public static ObservationCompletion deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static ObservationCompletion deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static ObservationCompletion decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      ObservationCompletion result = new ObservationCompletion(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.targetValue = TargetValue.decode(decoder1);
      result.weight = decoder0.readLong(16);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.targetValue, 8, false);
    encoder0.encode(this.weight, 16);
  }
}
