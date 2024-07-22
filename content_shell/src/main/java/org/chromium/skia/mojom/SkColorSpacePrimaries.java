package org.chromium.skia.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class SkColorSpacePrimaries extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;

  public float f718bX;

  public float f719bY;

  public float f720gX;

  public float f721gY;

  public float f722rX;

  public float f723rY;

  public float f724wX;

  public float f725wY;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private SkColorSpacePrimaries(int version) {
    super(40, version);
  }

  public SkColorSpacePrimaries() {
    this(0);
  }

  public static SkColorSpacePrimaries deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static SkColorSpacePrimaries deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static SkColorSpacePrimaries decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      SkColorSpacePrimaries result = new SkColorSpacePrimaries(elementsOrVersion);
      result.f722rX = decoder0.readFloat(8);
      result.f723rY = decoder0.readFloat(12);
      result.f720gX = decoder0.readFloat(16);
      result.f721gY = decoder0.readFloat(20);
      result.f718bX = decoder0.readFloat(24);
      result.f719bY = decoder0.readFloat(28);
      result.f724wX = decoder0.readFloat(32);
      result.f725wY = decoder0.readFloat(36);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.f722rX, 8);
    encoder0.encode(this.f723rY, 12);
    encoder0.encode(this.f720gX, 16);
    encoder0.encode(this.f721gY, 20);
    encoder0.encode(this.f718bX, 24);
    encoder0.encode(this.f719bY, 28);
    encoder0.encode(this.f724wX, 32);
    encoder0.encode(this.f725wY, 36);
  }
}
