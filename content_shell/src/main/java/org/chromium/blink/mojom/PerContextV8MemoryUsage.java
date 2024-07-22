package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

public final class PerContextV8MemoryUsage extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public long bytesUsed;
  public ExecutionContextToken token;
  public String url;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private PerContextV8MemoryUsage(int version) {
    super(40, version);
    this.bytesUsed = 0L;
  }

  public PerContextV8MemoryUsage() {
    this(0);
  }

  public static PerContextV8MemoryUsage deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static PerContextV8MemoryUsage deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static PerContextV8MemoryUsage decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      PerContextV8MemoryUsage result = new PerContextV8MemoryUsage(elementsOrVersion);
      result.token = ExecutionContextToken.decode(decoder0, 8);
      result.bytesUsed = decoder0.readLong(24);
      result.url = decoder0.readString(32, true);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Union) this.token, 8, false);
    encoder0.encode(this.bytesUsed, 24);
    encoder0.encode(this.url, 32, true);
  }
}
