package org.chromium.handwriting.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class HandwritingModelConstraint extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 16;
  private static final DataHeader[] VERSION_ARRAY;
  public String[] languages;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private HandwritingModelConstraint(int version) {
    super(16, version);
  }

  public HandwritingModelConstraint() {
    this(0);
  }

  public static HandwritingModelConstraint deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static HandwritingModelConstraint deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static HandwritingModelConstraint decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      HandwritingModelConstraint result = new HandwritingModelConstraint(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.languages = new String[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        result.languages[i1] = decoder1.readString((i1 * 8) + 8, false);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    String[] strArr = this.languages;
    if (strArr == null) {
      encoder0.encodeNullPointer(8, false);
      return;
    }
    Encoder encoder1 = encoder0.encodePointerArray(strArr.length, 8, -1);
    int i0 = 0;
    while (true) {
      String[] strArr2 = this.languages;
      if (i0 < strArr2.length) {
        encoder1.encode(strArr2[i0], (i0 * 8) + 8, false);
        i0++;
      } else {
        return;
      }
    }
  }
}
