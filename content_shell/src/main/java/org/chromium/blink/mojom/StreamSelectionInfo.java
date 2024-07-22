package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.UnguessableToken;

public final class StreamSelectionInfo extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public UnguessableToken sessionId;
  public int strategy;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private StreamSelectionInfo(int version) {
    super(24, version);
  }

  public StreamSelectionInfo() {
    this(0);
  }

  public static StreamSelectionInfo deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static StreamSelectionInfo deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static StreamSelectionInfo decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      StreamSelectionInfo result = new StreamSelectionInfo(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.strategy = readInt;
      StreamSelectionStrategy.validate(readInt);
      result.strategy = StreamSelectionStrategy.toKnownValue(result.strategy);
      Decoder decoder1 = decoder0.readPointer(16, true);
      result.sessionId = UnguessableToken.decode(decoder1);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.strategy, 8);
    encoder0.encode((Struct) this.sessionId, 16, true);
  }
}
