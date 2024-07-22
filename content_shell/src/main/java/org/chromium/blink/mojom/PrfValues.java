package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class PrfValues extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public byte[] first;

  public byte[] f448id;
  public byte[] second;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private PrfValues(int version) {
    super(32, version);
  }

  public PrfValues() {
    this(0);
  }

  public static PrfValues deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static PrfValues deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static PrfValues decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      PrfValues result = new PrfValues(elementsOrVersion);
      result.f448id = decoder0.readBytes(8, 1, -1);
      result.first = decoder0.readBytes(16, 0, -1);
      result.second = decoder0.readBytes(24, 1, -1);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.f448id, 8, 1, -1);
    encoder0.encode(this.first, 16, 0, -1);
    encoder0.encode(this.second, 24, 1, -1);
  }
}
