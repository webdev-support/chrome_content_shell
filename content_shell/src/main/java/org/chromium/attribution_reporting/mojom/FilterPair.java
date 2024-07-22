package org.chromium.attribution_reporting.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class FilterPair extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public FilterConfig[] negative;
  public FilterConfig[] positive;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private FilterPair(int version) {
    super(24, version);
  }

  public FilterPair() {
    this(0);
  }

  public static FilterPair deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static FilterPair deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static FilterPair decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      FilterPair result = new FilterPair(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.positive = new FilterConfig[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.positive[i1] = FilterConfig.decode(decoder2);
      }
      Decoder decoder12 = decoder0.readPointer(16, false);
      DataHeader si12 = decoder12.readDataHeaderForPointerArray(-1);
      result.negative = new FilterConfig[si12.elementsOrVersion];
      for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
        Decoder decoder22 = decoder12.readPointer((i12 * 8) + 8, false);
        result.negative[i12] = FilterConfig.decode(decoder22);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    FilterConfig[] filterConfigArr = this.positive;
    if (filterConfigArr == null) {
      encoder0.encodeNullPointer(8, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(filterConfigArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        FilterConfig[] filterConfigArr2 = this.positive;
        if (i0 >= filterConfigArr2.length) {
          break;
        }
        encoder1.encode((Struct) filterConfigArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    FilterConfig[] filterConfigArr3 = this.negative;
    if (filterConfigArr3 == null) {
      encoder0.encodeNullPointer(16, false);
      return;
    }
    Encoder encoder12 = encoder0.encodePointerArray(filterConfigArr3.length, 16, -1);
    int i02 = 0;
    while (true) {
      FilterConfig[] filterConfigArr4 = this.negative;
      if (i02 < filterConfigArr4.length) {
        encoder12.encode((Struct) filterConfigArr4[i02], (i02 * 8) + 8, false);
        i02++;
      } else {
        return;
      }
    }
  }
}
