package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class BlockingReasonSourceLocation extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public long columnNumber;
  public long lineNumber;
  public String url;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private BlockingReasonSourceLocation(int version) {
    super(32, version);
  }

  public BlockingReasonSourceLocation() {
    this(0);
  }

  public static BlockingReasonSourceLocation deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static BlockingReasonSourceLocation deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static BlockingReasonSourceLocation decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      BlockingReasonSourceLocation result = new BlockingReasonSourceLocation(elementsOrVersion);
      result.url = decoder0.readString(8, false);
      result.lineNumber = decoder0.readLong(16);
      result.columnNumber = decoder0.readLong(24);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.url, 8, false);
    encoder0.encode(this.lineNumber, 16);
    encoder0.encode(this.columnNumber, 24);
  }
}
