package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class PinSet extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public byte[][] badStaticSpkiHashes;
  public String name;
  public String reportUri;
  public byte[][] staticSpkiHashes;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private PinSet(int version) {
    super(40, version);
  }

  public PinSet() {
    this(0);
  }

  public static PinSet deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static PinSet deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static PinSet decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      PinSet result = new PinSet(elementsOrVersion);
      result.name = decoder0.readString(8, false);
      Decoder decoder1 = decoder0.readPointer(16, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.staticSpkiHashes = new byte[si1.elementsOrVersion][];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        result.staticSpkiHashes[i1] = decoder1.readBytes((i1 * 8) + 8, 0, -1);
      }
      Decoder decoder12 = decoder0.readPointer(24, false);
      DataHeader si12 = decoder12.readDataHeaderForPointerArray(-1);
      result.badStaticSpkiHashes = new byte[si12.elementsOrVersion][];
      for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
        result.badStaticSpkiHashes[i12] = decoder12.readBytes((i12 * 8) + 8, 0, -1);
      }
      result.reportUri = decoder0.readString(32, false);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.name, 8, false);
    byte[][] bArr = this.staticSpkiHashes;
    if (bArr == null) {
      encoder0.encodeNullPointer(16, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(bArr.length, 16, -1);
      int i0 = 0;
      while (true) {
        byte[][] bArr2 = this.staticSpkiHashes;
        if (i0 >= bArr2.length) {
          break;
        }
        encoder1.encode(bArr2[i0], (i0 * 8) + 8, 0, -1);
        i0++;
      }
    }
    byte[][] bArr3 = this.badStaticSpkiHashes;
    if (bArr3 == null) {
      encoder0.encodeNullPointer(24, false);
    } else {
      Encoder encoder12 = encoder0.encodePointerArray(bArr3.length, 24, -1);
      int i02 = 0;
      while (true) {
        byte[][] bArr4 = this.badStaticSpkiHashes;
        if (i02 >= bArr4.length) {
          break;
        }
        encoder12.encode(bArr4[i02], (i02 * 8) + 8, 0, -1);
        i02++;
      }
    }
    encoder0.encode(this.reportUri, 32, false);
  }
}
