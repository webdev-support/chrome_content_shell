package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.ByteString;
import org.chromium.url.mojom.Url;

public final class LcpCriticalPathPredictorNavigationTimeHint extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public Url[] fetchedFonts;
  public ByteString[] lcpElementLocators;
  public Url[] lcpInfluencerScripts;
  public Url[] preconnectOrigins;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private LcpCriticalPathPredictorNavigationTimeHint(int version) {
    super(40, version);
  }

  public LcpCriticalPathPredictorNavigationTimeHint() {
    this(0);
  }

  public static LcpCriticalPathPredictorNavigationTimeHint deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static LcpCriticalPathPredictorNavigationTimeHint deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static LcpCriticalPathPredictorNavigationTimeHint decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      LcpCriticalPathPredictorNavigationTimeHint result =
          new LcpCriticalPathPredictorNavigationTimeHint(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.lcpElementLocators = new ByteString[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.lcpElementLocators[i1] = ByteString.decode(decoder2);
      }
      Decoder decoder12 = decoder0.readPointer(16, false);
      DataHeader si12 = decoder12.readDataHeaderForPointerArray(-1);
      result.lcpInfluencerScripts = new Url[si12.elementsOrVersion];
      for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
        Decoder decoder22 = decoder12.readPointer((i12 * 8) + 8, false);
        result.lcpInfluencerScripts[i12] = Url.decode(decoder22);
      }
      Decoder decoder13 = decoder0.readPointer(24, false);
      DataHeader si13 = decoder13.readDataHeaderForPointerArray(-1);
      result.fetchedFonts = new Url[si13.elementsOrVersion];
      for (int i13 = 0; i13 < si13.elementsOrVersion; i13++) {
        Decoder decoder23 = decoder13.readPointer((i13 * 8) + 8, false);
        result.fetchedFonts[i13] = Url.decode(decoder23);
      }
      Decoder decoder14 = decoder0.readPointer(32, false);
      DataHeader si14 = decoder14.readDataHeaderForPointerArray(-1);
      result.preconnectOrigins = new Url[si14.elementsOrVersion];
      for (int i14 = 0; i14 < si14.elementsOrVersion; i14++) {
        Decoder decoder24 = decoder14.readPointer((i14 * 8) + 8, false);
        result.preconnectOrigins[i14] = Url.decode(decoder24);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    ByteString[] byteStringArr = this.lcpElementLocators;
    if (byteStringArr == null) {
      encoder0.encodeNullPointer(8, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(byteStringArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        ByteString[] byteStringArr2 = this.lcpElementLocators;
        if (i0 >= byteStringArr2.length) {
          break;
        }
        encoder1.encode((Struct) byteStringArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    Url[] urlArr = this.lcpInfluencerScripts;
    if (urlArr == null) {
      encoder0.encodeNullPointer(16, false);
    } else {
      Encoder encoder12 = encoder0.encodePointerArray(urlArr.length, 16, -1);
      int i02 = 0;
      while (true) {
        Url[] urlArr2 = this.lcpInfluencerScripts;
        if (i02 >= urlArr2.length) {
          break;
        }
        encoder12.encode((Struct) urlArr2[i02], (i02 * 8) + 8, false);
        i02++;
      }
    }
    Url[] urlArr3 = this.fetchedFonts;
    if (urlArr3 == null) {
      encoder0.encodeNullPointer(24, false);
    } else {
      Encoder encoder13 = encoder0.encodePointerArray(urlArr3.length, 24, -1);
      int i03 = 0;
      while (true) {
        Url[] urlArr4 = this.fetchedFonts;
        if (i03 >= urlArr4.length) {
          break;
        }
        encoder13.encode((Struct) urlArr4[i03], (i03 * 8) + 8, false);
        i03++;
      }
    }
    Url[] urlArr5 = this.preconnectOrigins;
    if (urlArr5 == null) {
      encoder0.encodeNullPointer(32, false);
      return;
    }
    Encoder encoder14 = encoder0.encodePointerArray(urlArr5.length, 32, -1);
    int i04 = 0;
    while (true) {
      Url[] urlArr6 = this.preconnectOrigins;
      if (i04 < urlArr6.length) {
        encoder14.encode((Struct) urlArr6[i04], (i04 * 8) + 8, false);
        i04++;
      } else {
        return;
      }
    }
  }
}
