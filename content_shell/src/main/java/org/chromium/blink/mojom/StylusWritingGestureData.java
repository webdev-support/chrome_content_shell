package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Rect;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.String16;

public final class StylusWritingGestureData extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 48;
  private static final DataHeader[] VERSION_ARRAY;
  public int action;
  public Rect endRect;
  public int granularity;
  public Rect startRect;
  public String16 textAlternative;
  public String16 textToInsert;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(48, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private StylusWritingGestureData(int version) {
    super(48, version);
  }

  public StylusWritingGestureData() {
    this(0);
  }

  public static StylusWritingGestureData deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static StylusWritingGestureData deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static StylusWritingGestureData decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      StylusWritingGestureData result = new StylusWritingGestureData(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.action = readInt;
      StylusWritingGestureAction.validate(readInt);
      result.action = StylusWritingGestureAction.toKnownValue(result.action);
      int readInt2 = decoder0.readInt(12);
      result.granularity = readInt2;
      StylusWritingGestureGranularity.validate(readInt2);
      result.granularity = StylusWritingGestureGranularity.toKnownValue(result.granularity);
      Decoder decoder1 = decoder0.readPointer(16, false);
      result.startRect = Rect.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(24, true);
      result.endRect = Rect.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(32, false);
      result.textAlternative = String16.decode(decoder13);
      Decoder decoder14 = decoder0.readPointer(40, true);
      result.textToInsert = String16.decode(decoder14);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.action, 8);
    encoder0.encode(this.granularity, 12);
    encoder0.encode((Struct) this.startRect, 16, false);
    encoder0.encode((Struct) this.endRect, 24, true);
    encoder0.encode((Struct) this.textAlternative, 32, false);
    encoder0.encode((Struct) this.textToInsert, 40, true);
  }
}
