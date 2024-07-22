package org.chromium.handwriting.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class HandwritingHintsQueryResult extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean alternatives;
  public int[] inputType;
  public int[] recognitionType;
  public boolean textContext;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private HandwritingHintsQueryResult(int version) {
    super(32, version);
  }

  public HandwritingHintsQueryResult() {
    this(0);
  }

  public static HandwritingHintsQueryResult deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static HandwritingHintsQueryResult deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static HandwritingHintsQueryResult decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      HandwritingHintsQueryResult result = new HandwritingHintsQueryResult(elementsOrVersion);
      result.recognitionType = decoder0.readInts(8, 0, -1);
      int i1 = 0;
      while (true) {
        int[] iArr = result.recognitionType;
        if (i1 >= iArr.length) {
          break;
        }
        HandwritingRecognitionType.validate(iArr[i1]);
        i1++;
      }
      result.inputType = decoder0.readInts(16, 0, -1);
      int i12 = 0;
      while (true) {
        int[] iArr2 = result.inputType;
        if (i12 < iArr2.length) {
          HandwritingInputType.validate(iArr2[i12]);
          i12++;
        } else {
          result.textContext = decoder0.readBoolean(24, 0);
          result.alternatives = decoder0.readBoolean(24, 1);
          return result;
        }
      }
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.recognitionType, 8, 0, -1);
    encoder0.encode(this.inputType, 16, 0, -1);
    encoder0.encode(this.textContext, 24, 0);
    encoder0.encode(this.alternatives, 24, 1);
  }
}
