package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class VideoBitrateAllocation extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public int[] bitrates;
  public VariableBitratePeak variableBitratePeak;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private VideoBitrateAllocation(int version) {
    super(24, version);
  }

  public VideoBitrateAllocation() {
    this(0);
  }

  public static VideoBitrateAllocation deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static VideoBitrateAllocation deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static VideoBitrateAllocation decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      VideoBitrateAllocation result = new VideoBitrateAllocation(elementsOrVersion);
      result.bitrates = decoder0.readInts(8, 0, -1);
      Decoder decoder1 = decoder0.readPointer(16, true);
      result.variableBitratePeak = VariableBitratePeak.decode(decoder1);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.bitrates, 8, 0, -1);
    encoder0.encode((Struct) this.variableBitratePeak, 16, true);
  }
}
