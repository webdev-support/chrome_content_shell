package org.chromium.payments.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.blink.mojom.ManifestImageResource;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class PaymentInstrument extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 48;
  private static final DataHeader[] VERSION_ARRAY;
  public ManifestImageResource[] icons;
  public String method;
  public String name;
  public String stringifiedCapabilities;
  public int[] supportedNetworks;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(48, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private PaymentInstrument(int version) {
    super(48, version);
  }

  public PaymentInstrument() {
    this(0);
  }

  public static PaymentInstrument deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static PaymentInstrument deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static PaymentInstrument decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      PaymentInstrument result = new PaymentInstrument(elementsOrVersion);
      result.name = decoder0.readString(8, false);
      Decoder decoder1 = decoder0.readPointer(16, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.icons = new ManifestImageResource[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.icons[i1] = ManifestImageResource.decode(decoder2);
      }
      result.method = decoder0.readString(24, false);
      result.stringifiedCapabilities = decoder0.readString(32, false);
      result.supportedNetworks = decoder0.readInts(40, 0, -1);
      int i12 = 0;
      while (true) {
        int[] iArr = result.supportedNetworks;
        if (i12 < iArr.length) {
          BasicCardNetwork.validate(iArr[i12]);
          i12++;
        } else {
          return result;
        }
      }
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.name, 8, false);
    ManifestImageResource[] manifestImageResourceArr = this.icons;
    if (manifestImageResourceArr == null) {
      encoder0.encodeNullPointer(16, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(manifestImageResourceArr.length, 16, -1);
      int i0 = 0;
      while (true) {
        ManifestImageResource[] manifestImageResourceArr2 = this.icons;
        if (i0 >= manifestImageResourceArr2.length) {
          break;
        }
        encoder1.encode((Struct) manifestImageResourceArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    encoder0.encode(this.method, 24, false);
    encoder0.encode(this.stringifiedCapabilities, 32, false);
    encoder0.encode(this.supportedNetworks, 40, 0, -1);
  }
}
