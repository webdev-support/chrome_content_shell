package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class CspTrustedTypes extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean allowAny;
  public boolean allowDuplicates;
  public String[] list;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private CspTrustedTypes(int version) {
    super(24, version);
    this.allowAny = false;
    this.allowDuplicates = false;
  }

  public CspTrustedTypes() {
    this(0);
  }

  public static CspTrustedTypes deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static CspTrustedTypes deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static CspTrustedTypes decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      CspTrustedTypes result = new CspTrustedTypes(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.list = new String[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        result.list[i1] = decoder1.readString((i1 * 8) + 8, false);
      }
      result.allowAny = decoder0.readBoolean(16, 0);
      result.allowDuplicates = decoder0.readBoolean(16, 1);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    String[] strArr = this.list;
    if (strArr == null) {
      encoder0.encodeNullPointer(8, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(strArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        String[] strArr2 = this.list;
        if (i0 >= strArr2.length) {
          break;
        }
        encoder1.encode(strArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    encoder0.encode(this.allowAny, 16, 0);
    encoder0.encode(this.allowDuplicates, 16, 1);
  }
}
