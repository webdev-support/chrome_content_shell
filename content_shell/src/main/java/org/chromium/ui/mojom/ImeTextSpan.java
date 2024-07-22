package org.chromium.ui.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class ImeTextSpan extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 56;
  private static final DataHeader[] VERSION_ARRAY;
  public int backgroundColor;
  public int endOffset;
  public boolean interimCharSelection;
  public boolean removeOnFinishComposing;
  public int startOffset;
  public int suggestionHighlightColor;
  public String[] suggestions;
  public int textColor;
  public int thickness;
  public int type;
  public int underlineColor;
  public int underlineStyle;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(56, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private ImeTextSpan(int version) {
    super(56, version);
  }

  public ImeTextSpan() {
    this(0);
  }

  public static ImeTextSpan deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static ImeTextSpan deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static ImeTextSpan decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      ImeTextSpan result = new ImeTextSpan(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.type = readInt;
      ImeTextSpanType.validate(readInt);
      result.type = ImeTextSpanType.toKnownValue(result.type);
      result.startOffset = decoder0.readInt(12);
      result.endOffset = decoder0.readInt(16);
      result.underlineColor = decoder0.readInt(20);
      int readInt2 = decoder0.readInt(24);
      result.thickness = readInt2;
      ImeTextSpanThickness.validate(readInt2);
      result.thickness = ImeTextSpanThickness.toKnownValue(result.thickness);
      int readInt3 = decoder0.readInt(28);
      result.underlineStyle = readInt3;
      ImeTextSpanUnderlineStyle.validate(readInt3);
      result.underlineStyle = ImeTextSpanUnderlineStyle.toKnownValue(result.underlineStyle);
      result.textColor = decoder0.readInt(32);
      result.backgroundColor = decoder0.readInt(36);
      result.suggestionHighlightColor = decoder0.readInt(40);
      result.removeOnFinishComposing = decoder0.readBoolean(44, 0);
      result.interimCharSelection = decoder0.readBoolean(44, 1);
      Decoder decoder1 = decoder0.readPointer(48, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.suggestions = new String[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        result.suggestions[i1] = decoder1.readString((i1 * 8) + 8, false);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.type, 8);
    encoder0.encode(this.startOffset, 12);
    encoder0.encode(this.endOffset, 16);
    encoder0.encode(this.underlineColor, 20);
    encoder0.encode(this.thickness, 24);
    encoder0.encode(this.underlineStyle, 28);
    encoder0.encode(this.textColor, 32);
    encoder0.encode(this.backgroundColor, 36);
    encoder0.encode(this.suggestionHighlightColor, 40);
    encoder0.encode(this.removeOnFinishComposing, 44, 0);
    encoder0.encode(this.interimCharSelection, 44, 1);
    String[] strArr = this.suggestions;
    if (strArr == null) {
      encoder0.encodeNullPointer(48, false);
      return;
    }
    Encoder encoder1 = encoder0.encodePointerArray(strArr.length, 48, -1);
    int i0 = 0;
    while (true) {
      String[] strArr2 = this.suggestions;
      if (i0 < strArr2.length) {
        encoder1.encode(strArr2[i0], (i0 * 8) + 8, false);
        i0++;
      } else {
        return;
      }
    }
  }
}
