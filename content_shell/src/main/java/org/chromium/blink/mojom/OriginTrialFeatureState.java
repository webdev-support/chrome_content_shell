package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class OriginTrialFeatureState extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean isEnabled;
  public String[] tokens;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private OriginTrialFeatureState(int version) {
    super(24, version);
  }

  public OriginTrialFeatureState() {
    this(0);
  }

  public static OriginTrialFeatureState deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static OriginTrialFeatureState deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static OriginTrialFeatureState decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      OriginTrialFeatureState result = new OriginTrialFeatureState(elementsOrVersion);
      result.isEnabled = decoder0.readBoolean(8, 0);
      Decoder decoder1 = decoder0.readPointer(16, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.tokens = new String[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        result.tokens[i1] = decoder1.readString((i1 * 8) + 8, false);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.isEnabled, 8, 0);
    String[] strArr = this.tokens;
    if (strArr == null) {
      encoder0.encodeNullPointer(16, false);
      return;
    }
    Encoder encoder1 = encoder0.encodePointerArray(strArr.length, 16, -1);
    int i0 = 0;
    while (true) {
      String[] strArr2 = this.tokens;
      if (i0 < strArr2.length) {
        encoder1.encode(strArr2[i0], (i0 * 8) + 8, false);
        i0++;
      } else {
        return;
      }
    }
  }
}