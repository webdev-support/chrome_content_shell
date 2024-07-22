package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class AdTargeting extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public AdGeolocation geolocation;
  public String[] interests;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private AdTargeting(int version) {
    super(24, version);
  }

  public AdTargeting() {
    this(0);
  }

  public static AdTargeting deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static AdTargeting deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static AdTargeting decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      AdTargeting result = new AdTargeting(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, true);
      if (decoder1 == null) {
        result.interests = null;
      } else {
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.interests = new String[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          result.interests[i1] = decoder1.readString((i1 * 8) + 8, false);
        }
      }
      result.geolocation = AdGeolocation.decode(decoder0.readPointer(16, true));
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    String[] strArr = this.interests;
    if (strArr == null) {
      encoder0.encodeNullPointer(8, true);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(strArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        String[] strArr2 = this.interests;
        if (i0 >= strArr2.length) {
          break;
        }
        encoder1.encode(strArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    encoder0.encode((Struct) this.geolocation, 16, true);
  }
}
