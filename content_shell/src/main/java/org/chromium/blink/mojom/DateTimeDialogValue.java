package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.ui.mojom.TextInputType;

public final class DateTimeDialogValue extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 56;
  private static final DataHeader[] VERSION_ARRAY;
  public int dialogType;
  public double dialogValue;
  public double maximum;
  public double minimum;
  public double step;
  public DateTimeSuggestion[] suggestions;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(56, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private DateTimeDialogValue(int version) {
    super(56, version);
  }

  public DateTimeDialogValue() {
    this(0);
  }

  public static DateTimeDialogValue deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static DateTimeDialogValue deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static DateTimeDialogValue decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      DateTimeDialogValue result = new DateTimeDialogValue(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.dialogType = readInt;
      TextInputType.validate(readInt);
      result.dialogType = TextInputType.toKnownValue(result.dialogType);
      result.dialogValue = decoder0.readDouble(16);
      result.minimum = decoder0.readDouble(24);
      result.maximum = decoder0.readDouble(32);
      result.step = decoder0.readDouble(40);
      Decoder decoder1 = decoder0.readPointer(48, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.suggestions = new DateTimeSuggestion[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.suggestions[i1] = DateTimeSuggestion.decode(decoder2);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.dialogType, 8);
    encoder0.encode(this.dialogValue, 16);
    encoder0.encode(this.minimum, 24);
    encoder0.encode(this.maximum, 32);
    encoder0.encode(this.step, 40);
    DateTimeSuggestion[] dateTimeSuggestionArr = this.suggestions;
    if (dateTimeSuggestionArr == null) {
      encoder0.encodeNullPointer(48, false);
      return;
    }
    Encoder encoder1 = encoder0.encodePointerArray(dateTimeSuggestionArr.length, 48, -1);
    int i0 = 0;
    while (true) {
      DateTimeSuggestion[] dateTimeSuggestionArr2 = this.suggestions;
      if (i0 < dateTimeSuggestionArr2.length) {
        encoder1.encode((Struct) dateTimeSuggestionArr2[i0], (i0 * 8) + 8, false);
        i0++;
      } else {
        return;
      }
    }
  }
}
