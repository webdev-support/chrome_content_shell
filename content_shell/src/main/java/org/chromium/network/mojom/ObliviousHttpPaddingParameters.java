package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class ObliviousHttpPaddingParameters extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 16;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean addExponentialPad;
  public short exponentialMean;
  public boolean padToNextPowerOfTwo;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private ObliviousHttpPaddingParameters(int version) {
    super(16, version);
  }

  public ObliviousHttpPaddingParameters() {
    this(0);
  }

  public static ObliviousHttpPaddingParameters deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static ObliviousHttpPaddingParameters deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static ObliviousHttpPaddingParameters decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      ObliviousHttpPaddingParameters result = new ObliviousHttpPaddingParameters(elementsOrVersion);
      result.addExponentialPad = decoder0.readBoolean(8, 0);
      result.padToNextPowerOfTwo = decoder0.readBoolean(8, 1);
      result.exponentialMean = decoder0.readShort(10);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.addExponentialPad, 8, 0);
    encoder0.encode(this.padToNextPowerOfTwo, 8, 1);
    encoder0.encode(this.exponentialMean, 10);
  }
}
