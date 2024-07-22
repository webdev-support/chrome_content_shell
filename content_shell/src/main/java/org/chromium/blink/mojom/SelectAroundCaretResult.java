package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class SelectAroundCaretResult extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public int extendedEndAdjust;
  public int extendedStartAdjust;
  public int wordEndAdjust;
  public int wordStartAdjust;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private SelectAroundCaretResult(int version) {
    super(24, version);
  }

  public SelectAroundCaretResult() {
    this(0);
  }

  public static SelectAroundCaretResult deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static SelectAroundCaretResult deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static SelectAroundCaretResult decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      SelectAroundCaretResult result = new SelectAroundCaretResult(elementsOrVersion);
      result.extendedStartAdjust = decoder0.readInt(8);
      result.extendedEndAdjust = decoder0.readInt(12);
      result.wordStartAdjust = decoder0.readInt(16);
      result.wordEndAdjust = decoder0.readInt(20);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.extendedStartAdjust, 8);
    encoder0.encode(this.extendedEndAdjust, 12);
    encoder0.encode(this.wordStartAdjust, 16);
    encoder0.encode(this.wordEndAdjust, 20);
  }
}
