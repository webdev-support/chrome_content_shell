package org.chromium.gfx.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class BufferUsageAndFormat extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 16;
  private static final DataHeader[] VERSION_ARRAY;
  public int format;
  public int usage;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private BufferUsageAndFormat(int version) {
    super(16, version);
  }

  public BufferUsageAndFormat() {
    this(0);
  }

  public static BufferUsageAndFormat deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static BufferUsageAndFormat deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static BufferUsageAndFormat decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      BufferUsageAndFormat result = new BufferUsageAndFormat(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.usage = readInt;
      BufferUsage.validate(readInt);
      result.usage = BufferUsage.toKnownValue(result.usage);
      int readInt2 = decoder0.readInt(12);
      result.format = readInt2;
      BufferFormat.validate(readInt2);
      result.format = BufferFormat.toKnownValue(result.format);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.usage, 8);
    encoder0.encode(this.format, 12);
  }
}
