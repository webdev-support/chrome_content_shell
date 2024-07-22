package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.url.internal.mojom.Origin;

public final class CorsOriginAccessPatterns extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public CorsOriginPattern[] allowPatterns;
  public CorsOriginPattern[] blockPatterns;
  public Origin sourceOrigin;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private CorsOriginAccessPatterns(int version) {
    super(32, version);
  }

  public CorsOriginAccessPatterns() {
    this(0);
  }

  public static CorsOriginAccessPatterns deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static CorsOriginAccessPatterns deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static CorsOriginAccessPatterns decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      CorsOriginAccessPatterns result = new CorsOriginAccessPatterns(elementsOrVersion);
      result.sourceOrigin = Origin.decode(decoder0.readPointer(8, false));
      Decoder decoder1 = decoder0.readPointer(16, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.allowPatterns = new CorsOriginPattern[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.allowPatterns[i1] = CorsOriginPattern.decode(decoder2);
      }
      Decoder decoder12 = decoder0.readPointer(24, false);
      DataHeader si12 = decoder12.readDataHeaderForPointerArray(-1);
      result.blockPatterns = new CorsOriginPattern[si12.elementsOrVersion];
      for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
        Decoder decoder22 = decoder12.readPointer((i12 * 8) + 8, false);
        result.blockPatterns[i12] = CorsOriginPattern.decode(decoder22);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.sourceOrigin, 8, false);
    CorsOriginPattern[] corsOriginPatternArr = this.allowPatterns;
    if (corsOriginPatternArr == null) {
      encoder0.encodeNullPointer(16, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(corsOriginPatternArr.length, 16, -1);
      int i0 = 0;
      while (true) {
        CorsOriginPattern[] corsOriginPatternArr2 = this.allowPatterns;
        if (i0 >= corsOriginPatternArr2.length) {
          break;
        }
        encoder1.encode((Struct) corsOriginPatternArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    CorsOriginPattern[] corsOriginPatternArr3 = this.blockPatterns;
    if (corsOriginPatternArr3 == null) {
      encoder0.encodeNullPointer(24, false);
      return;
    }
    Encoder encoder12 = encoder0.encodePointerArray(corsOriginPatternArr3.length, 24, -1);
    int i02 = 0;
    while (true) {
      CorsOriginPattern[] corsOriginPatternArr4 = this.blockPatterns;
      if (i02 < corsOriginPatternArr4.length) {
        encoder12.encode((Struct) corsOriginPatternArr4[i02], (i02 * 8) + 8, false);
        i02++;
      } else {
        return;
      }
    }
  }
}
