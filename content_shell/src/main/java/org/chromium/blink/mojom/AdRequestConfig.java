package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.url.mojom.Url;

public final class AdRequestConfig extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 56;
  private static final DataHeader[] VERSION_ARRAY;
  public AdProperties[] adProperties;
  public Url adRequestUrl;
  public int[] anonymizedProxiedSignals;
  public Url fallbackSource;
  public String publisherCode;
  public AdTargeting targeting;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(56, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private AdRequestConfig(int version) {
    super(56, version);
  }

  public AdRequestConfig() {
    this(0);
  }

  public static AdRequestConfig deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static AdRequestConfig deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static AdRequestConfig decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      AdRequestConfig result = new AdRequestConfig(elementsOrVersion);
      result.adRequestUrl = Url.decode(decoder0.readPointer(8, false));
      Decoder decoder1 = decoder0.readPointer(16, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.adProperties = new AdProperties[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.adProperties[i1] = AdProperties.decode(decoder2);
      }
      result.publisherCode = decoder0.readString(24, true);
      result.targeting = AdTargeting.decode(decoder0.readPointer(32, true));
      int[] readInts = decoder0.readInts(40, 1, -1);
      result.anonymizedProxiedSignals = readInts;
      if (readInts != null) {
        int i12 = 0;
        while (true) {
          int[] iArr = result.anonymizedProxiedSignals;
          if (i12 >= iArr.length) {
            break;
          }
          AdSignals.validate(iArr[i12]);
          i12++;
        }
      }
      result.fallbackSource = Url.decode(decoder0.readPointer(48, true));
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.adRequestUrl, 8, false);
    AdProperties[] adPropertiesArr = this.adProperties;
    if (adPropertiesArr == null) {
      encoder0.encodeNullPointer(16, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(adPropertiesArr.length, 16, -1);
      int i0 = 0;
      while (true) {
        AdProperties[] adPropertiesArr2 = this.adProperties;
        if (i0 >= adPropertiesArr2.length) {
          break;
        }
        encoder1.encode((Struct) adPropertiesArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    encoder0.encode(this.publisherCode, 24, true);
    encoder0.encode((Struct) this.targeting, 32, true);
    encoder0.encode(this.anonymizedProxiedSignals, 40, 1, -1);
    encoder0.encode((Struct) this.fallbackSource, 48, true);
  }
}
