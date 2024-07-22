package org.chromium.skia.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class SkColorSpace extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public SkcmsTransferFunction toLinear;
  public SkcmsMatrix3x3 toXyzd50;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private SkColorSpace(int version) {
    super(24, version);
  }

  public SkColorSpace() {
    this(0);
  }

  public static SkColorSpace deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static SkColorSpace deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static SkColorSpace decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      SkColorSpace result = new SkColorSpace(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, true);
      result.toLinear = SkcmsTransferFunction.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, true);
      result.toXyzd50 = SkcmsMatrix3x3.decode(decoder12);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.toLinear, 8, true);
    encoder0.encode((Struct) this.toXyzd50, 16, true);
  }
}
