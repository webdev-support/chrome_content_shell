package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class FindInPageResultAxParams extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public int endId;
  public int endOffset;
  public int matchIndex;
  public int requestId;
  public int startId;
  public int startOffset;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private FindInPageResultAxParams(int version) {
    super(32, version);
  }

  public FindInPageResultAxParams() {
    this(0);
  }

  public static FindInPageResultAxParams deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static FindInPageResultAxParams deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static FindInPageResultAxParams decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      FindInPageResultAxParams result = new FindInPageResultAxParams(elementsOrVersion);
      result.requestId = decoder0.readInt(8);
      result.matchIndex = decoder0.readInt(12);
      result.startId = decoder0.readInt(16);
      result.startOffset = decoder0.readInt(20);
      result.endId = decoder0.readInt(24);
      result.endOffset = decoder0.readInt(28);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.requestId, 8);
    encoder0.encode(this.matchIndex, 12);
    encoder0.encode(this.startId, 16);
    encoder0.encode(this.startOffset, 20);
    encoder0.encode(this.endId, 24);
    encoder0.encode(this.endOffset, 28);
  }
}
