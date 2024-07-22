package org.chromium.skia.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class SkColor4f extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;

  public float f714a;

  public float f715b;

  public float f716g;

  public float f717r;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private SkColor4f(int version) {
    super(24, version);
  }

  public SkColor4f() {
    this(0);
  }

  public static SkColor4f deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static SkColor4f deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static SkColor4f decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      SkColor4f result = new SkColor4f(elementsOrVersion);
      result.f717r = decoder0.readFloat(8);
      result.f716g = decoder0.readFloat(12);
      result.f715b = decoder0.readFloat(16);
      result.f714a = decoder0.readFloat(20);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.f717r, 8);
    encoder0.encode(this.f716g, 12);
    encoder0.encode(this.f715b, 16);
    encoder0.encode(this.f714a, 20);
  }
}
