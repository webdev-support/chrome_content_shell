package org.chromium.handwriting.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class HandwritingHints extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public int alternatives;
  public String inputType;
  public String recognitionType;
  public String textContext;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private HandwritingHints(int version) {
    super(40, version);
  }

  public HandwritingHints() {
    this(0);
  }

  public static HandwritingHints deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static HandwritingHints deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static HandwritingHints decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      HandwritingHints result = new HandwritingHints(elementsOrVersion);
      result.recognitionType = decoder0.readString(8, false);
      result.inputType = decoder0.readString(16, false);
      result.textContext = decoder0.readString(24, true);
      result.alternatives = decoder0.readInt(32);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.recognitionType, 8, false);
    encoder0.encode(this.inputType, 16, false);
    encoder0.encode(this.textContext, 24, true);
    encoder0.encode(this.alternatives, 32);
  }
}
