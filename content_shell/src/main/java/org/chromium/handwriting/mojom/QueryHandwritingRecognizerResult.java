package org.chromium.handwriting.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class QueryHandwritingRecognizerResult extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public HandwritingHintsQueryResult hints;
  public boolean textAlternatives;
  public boolean textSegmentation;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private QueryHandwritingRecognizerResult(int version) {
    super(24, version);
  }

  public QueryHandwritingRecognizerResult() {
    this(0);
  }

  public static QueryHandwritingRecognizerResult deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static QueryHandwritingRecognizerResult deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static QueryHandwritingRecognizerResult decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      QueryHandwritingRecognizerResult result =
          new QueryHandwritingRecognizerResult(elementsOrVersion);
      result.textAlternatives = decoder0.readBoolean(8, 0);
      result.textSegmentation = decoder0.readBoolean(8, 1);
      Decoder decoder1 = decoder0.readPointer(16, false);
      result.hints = HandwritingHintsQueryResult.decode(decoder1);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.textAlternatives, 8, 0);
    encoder0.encode(this.textSegmentation, 8, 1);
    encoder0.encode((Struct) this.hints, 16, false);
  }
}
