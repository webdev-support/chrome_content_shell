package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class ContentIconDefinition extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public String sizes;
  public String src;
  public String type;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private ContentIconDefinition(int version) {
    super(32, version);
  }

  public ContentIconDefinition() {
    this(0);
  }

  public static ContentIconDefinition deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static ContentIconDefinition deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static ContentIconDefinition decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      ContentIconDefinition result = new ContentIconDefinition(elementsOrVersion);
      result.src = decoder0.readString(8, false);
      result.sizes = decoder0.readString(16, true);
      result.type = decoder0.readString(24, true);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.src, 8, false);
    encoder0.encode(this.sizes, 16, true);
    encoder0.encode(this.type, 24, true);
  }
}
