package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class SafeUrlPattern extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 80;
  private static final DataHeader[] VERSION_ARRAY;
  public SafeUrlPatternPart[] hash;
  public SafeUrlPatternPart[] hostname;
  public SafeUrlPatternOptions options;
  public SafeUrlPatternPart[] password;
  public SafeUrlPatternPart[] pathname;
  public SafeUrlPatternPart[] port;
  public SafeUrlPatternPart[] protocol;
  public SafeUrlPatternPart[] search;
  public SafeUrlPatternPart[] username;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(80, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private SafeUrlPattern(int version) {
    super(80, version);
  }

  public SafeUrlPattern() {
    this(0);
  }

  public static SafeUrlPattern deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static SafeUrlPattern deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static SafeUrlPattern decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      SafeUrlPattern result = new SafeUrlPattern(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.protocol = new SafeUrlPatternPart[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.protocol[i1] = SafeUrlPatternPart.decode(decoder2);
      }
      Decoder decoder12 = decoder0.readPointer(16, false);
      DataHeader si12 = decoder12.readDataHeaderForPointerArray(-1);
      result.username = new SafeUrlPatternPart[si12.elementsOrVersion];
      for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
        Decoder decoder22 = decoder12.readPointer((i12 * 8) + 8, false);
        result.username[i12] = SafeUrlPatternPart.decode(decoder22);
      }
      Decoder decoder13 = decoder0.readPointer(24, false);
      DataHeader si13 = decoder13.readDataHeaderForPointerArray(-1);
      result.password = new SafeUrlPatternPart[si13.elementsOrVersion];
      for (int i13 = 0; i13 < si13.elementsOrVersion; i13++) {
        Decoder decoder23 = decoder13.readPointer((i13 * 8) + 8, false);
        result.password[i13] = SafeUrlPatternPart.decode(decoder23);
      }
      Decoder decoder14 = decoder0.readPointer(32, false);
      DataHeader si14 = decoder14.readDataHeaderForPointerArray(-1);
      result.hostname = new SafeUrlPatternPart[si14.elementsOrVersion];
      for (int i14 = 0; i14 < si14.elementsOrVersion; i14++) {
        Decoder decoder24 = decoder14.readPointer((i14 * 8) + 8, false);
        result.hostname[i14] = SafeUrlPatternPart.decode(decoder24);
      }
      Decoder decoder15 = decoder0.readPointer(40, false);
      DataHeader si15 = decoder15.readDataHeaderForPointerArray(-1);
      result.port = new SafeUrlPatternPart[si15.elementsOrVersion];
      for (int i15 = 0; i15 < si15.elementsOrVersion; i15++) {
        Decoder decoder25 = decoder15.readPointer((i15 * 8) + 8, false);
        result.port[i15] = SafeUrlPatternPart.decode(decoder25);
      }
      Decoder decoder16 = decoder0.readPointer(48, false);
      DataHeader si16 = decoder16.readDataHeaderForPointerArray(-1);
      result.pathname = new SafeUrlPatternPart[si16.elementsOrVersion];
      for (int i16 = 0; i16 < si16.elementsOrVersion; i16++) {
        Decoder decoder26 = decoder16.readPointer((i16 * 8) + 8, false);
        result.pathname[i16] = SafeUrlPatternPart.decode(decoder26);
      }
      Decoder decoder17 = decoder0.readPointer(56, false);
      DataHeader si17 = decoder17.readDataHeaderForPointerArray(-1);
      result.search = new SafeUrlPatternPart[si17.elementsOrVersion];
      for (int i17 = 0; i17 < si17.elementsOrVersion; i17++) {
        Decoder decoder27 = decoder17.readPointer((i17 * 8) + 8, false);
        result.search[i17] = SafeUrlPatternPart.decode(decoder27);
      }
      Decoder decoder18 = decoder0.readPointer(64, false);
      DataHeader si18 = decoder18.readDataHeaderForPointerArray(-1);
      result.hash = new SafeUrlPatternPart[si18.elementsOrVersion];
      for (int i18 = 0; i18 < si18.elementsOrVersion; i18++) {
        Decoder decoder28 = decoder18.readPointer((i18 * 8) + 8, false);
        result.hash[i18] = SafeUrlPatternPart.decode(decoder28);
      }
      result.options = SafeUrlPatternOptions.decode(decoder0.readPointer(72, false));
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    SafeUrlPatternPart[] safeUrlPatternPartArr = this.protocol;
    if (safeUrlPatternPartArr == null) {
      encoder0.encodeNullPointer(8, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(safeUrlPatternPartArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        SafeUrlPatternPart[] safeUrlPatternPartArr2 = this.protocol;
        if (i0 >= safeUrlPatternPartArr2.length) {
          break;
        }
        encoder1.encode((Struct) safeUrlPatternPartArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    SafeUrlPatternPart[] safeUrlPatternPartArr3 = this.username;
    if (safeUrlPatternPartArr3 == null) {
      encoder0.encodeNullPointer(16, false);
    } else {
      Encoder encoder12 = encoder0.encodePointerArray(safeUrlPatternPartArr3.length, 16, -1);
      int i02 = 0;
      while (true) {
        SafeUrlPatternPart[] safeUrlPatternPartArr4 = this.username;
        if (i02 >= safeUrlPatternPartArr4.length) {
          break;
        }
        encoder12.encode((Struct) safeUrlPatternPartArr4[i02], (i02 * 8) + 8, false);
        i02++;
      }
    }
    SafeUrlPatternPart[] safeUrlPatternPartArr5 = this.password;
    if (safeUrlPatternPartArr5 == null) {
      encoder0.encodeNullPointer(24, false);
    } else {
      Encoder encoder13 = encoder0.encodePointerArray(safeUrlPatternPartArr5.length, 24, -1);
      int i03 = 0;
      while (true) {
        SafeUrlPatternPart[] safeUrlPatternPartArr6 = this.password;
        if (i03 >= safeUrlPatternPartArr6.length) {
          break;
        }
        encoder13.encode((Struct) safeUrlPatternPartArr6[i03], (i03 * 8) + 8, false);
        i03++;
      }
    }
    SafeUrlPatternPart[] safeUrlPatternPartArr7 = this.hostname;
    if (safeUrlPatternPartArr7 == null) {
      encoder0.encodeNullPointer(32, false);
    } else {
      Encoder encoder14 = encoder0.encodePointerArray(safeUrlPatternPartArr7.length, 32, -1);
      int i04 = 0;
      while (true) {
        SafeUrlPatternPart[] safeUrlPatternPartArr8 = this.hostname;
        if (i04 >= safeUrlPatternPartArr8.length) {
          break;
        }
        encoder14.encode((Struct) safeUrlPatternPartArr8[i04], (i04 * 8) + 8, false);
        i04++;
      }
    }
    SafeUrlPatternPart[] safeUrlPatternPartArr9 = this.port;
    if (safeUrlPatternPartArr9 == null) {
      encoder0.encodeNullPointer(40, false);
    } else {
      Encoder encoder15 = encoder0.encodePointerArray(safeUrlPatternPartArr9.length, 40, -1);
      int i05 = 0;
      while (true) {
        SafeUrlPatternPart[] safeUrlPatternPartArr10 = this.port;
        if (i05 >= safeUrlPatternPartArr10.length) {
          break;
        }
        encoder15.encode((Struct) safeUrlPatternPartArr10[i05], (i05 * 8) + 8, false);
        i05++;
      }
    }
    SafeUrlPatternPart[] safeUrlPatternPartArr11 = this.pathname;
    if (safeUrlPatternPartArr11 == null) {
      encoder0.encodeNullPointer(48, false);
    } else {
      Encoder encoder16 = encoder0.encodePointerArray(safeUrlPatternPartArr11.length, 48, -1);
      int i06 = 0;
      while (true) {
        SafeUrlPatternPart[] safeUrlPatternPartArr12 = this.pathname;
        if (i06 >= safeUrlPatternPartArr12.length) {
          break;
        }
        encoder16.encode((Struct) safeUrlPatternPartArr12[i06], (i06 * 8) + 8, false);
        i06++;
      }
    }
    SafeUrlPatternPart[] safeUrlPatternPartArr13 = this.search;
    if (safeUrlPatternPartArr13 == null) {
      encoder0.encodeNullPointer(56, false);
    } else {
      Encoder encoder17 = encoder0.encodePointerArray(safeUrlPatternPartArr13.length, 56, -1);
      int i07 = 0;
      while (true) {
        SafeUrlPatternPart[] safeUrlPatternPartArr14 = this.search;
        if (i07 >= safeUrlPatternPartArr14.length) {
          break;
        }
        encoder17.encode((Struct) safeUrlPatternPartArr14[i07], (i07 * 8) + 8, false);
        i07++;
      }
    }
    SafeUrlPatternPart[] safeUrlPatternPartArr15 = this.hash;
    if (safeUrlPatternPartArr15 == null) {
      encoder0.encodeNullPointer(64, false);
    } else {
      Encoder encoder18 = encoder0.encodePointerArray(safeUrlPatternPartArr15.length, 64, -1);
      int i08 = 0;
      while (true) {
        SafeUrlPatternPart[] safeUrlPatternPartArr16 = this.hash;
        if (i08 >= safeUrlPatternPartArr16.length) {
          break;
        }
        encoder18.encode((Struct) safeUrlPatternPartArr16[i08], (i08 * 8) + 8, false);
        i08++;
      }
    }
    encoder0.encode((Struct) this.options, 72, false);
  }
}
