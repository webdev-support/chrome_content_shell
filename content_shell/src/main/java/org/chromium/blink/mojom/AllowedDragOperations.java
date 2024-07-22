package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class AllowedDragOperations extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 16;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean allowCopy;
  public boolean allowLink;
  public boolean allowMove;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private AllowedDragOperations(int version) {
    super(16, version);
  }

  public AllowedDragOperations() {
    this(0);
  }

  public static AllowedDragOperations deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static AllowedDragOperations deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static AllowedDragOperations decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      AllowedDragOperations result = new AllowedDragOperations(elementsOrVersion);
      result.allowCopy = decoder0.readBoolean(8, 0);
      result.allowLink = decoder0.readBoolean(8, 1);
      result.allowMove = decoder0.readBoolean(8, 2);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.allowCopy, 8, 0);
    encoder0.encode(this.allowLink, 8, 1);
    encoder0.encode(this.allowMove, 8, 2);
  }
}
