package org.chromium.gl.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class GlImplementationParts extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 16;
  private static final DataHeader[] VERSION_ARRAY;
  public int angle;
  public int gl;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private GlImplementationParts(int version) {
    super(16, version);
  }

  public GlImplementationParts() {
    this(0);
  }

  public static GlImplementationParts deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static GlImplementationParts deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static GlImplementationParts decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      GlImplementationParts result = new GlImplementationParts(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.gl = readInt;
      GlImplementation.validate(readInt);
      result.gl = GlImplementation.toKnownValue(result.gl);
      int readInt2 = decoder0.readInt(12);
      result.angle = readInt2;
      AngleImplementation.validate(readInt2);
      result.angle = AngleImplementation.toKnownValue(result.angle);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.gl, 8);
    encoder0.encode(this.angle, 12);
  }
}
