package org.chromium.gfx.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class HdrStaticMetadata extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public float max;
  public float maxAvg;
  public float min;
  public byte supportedEotfMask;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private HdrStaticMetadata(int version) {
    super(24, version);
  }

  public HdrStaticMetadata() {
    this(0);
  }

  public static HdrStaticMetadata deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static HdrStaticMetadata deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static HdrStaticMetadata decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      HdrStaticMetadata result = new HdrStaticMetadata(elementsOrVersion);
      result.max = decoder0.readFloat(8);
      result.maxAvg = decoder0.readFloat(12);
      result.min = decoder0.readFloat(16);
      result.supportedEotfMask = decoder0.readByte(20);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.max, 8);
    encoder0.encode(this.maxAvg, 12);
    encoder0.encode(this.min, 16);
    encoder0.encode(this.supportedEotfMask, 20);
  }
}
