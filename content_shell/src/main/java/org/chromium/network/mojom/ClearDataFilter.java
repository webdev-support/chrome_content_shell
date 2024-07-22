package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.url.internal.mojom.Origin;

public final class ClearDataFilter extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public String[] domains;
  public Origin[] origins;
  public int type;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  public static final class Type {
    public static final int DELETE_MATCHES = 0;
    private static final boolean IS_EXTENSIBLE = false;
    public static final int KEEP_MATCHES = 1;
    public static final int MAX_VALUE = 1;
    public static final int MIN_VALUE = 0;

    public @interface EnumType {}

    public static boolean isKnownValue(int value) {
      return value >= 0 && value <= 1;
    }

    public static void validate(int value) {
      if (!isKnownValue(value)) {
        throw new DeserializationException("Invalid enum value.");
      }
    }

    public static int toKnownValue(int value) {
      return value;
    }

    private Type() {}
  }

  private ClearDataFilter(int version) {
    super(32, version);
  }

  public ClearDataFilter() {
    this(0);
  }

  public static ClearDataFilter deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static ClearDataFilter deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static ClearDataFilter decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      ClearDataFilter result = new ClearDataFilter(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.type = readInt;
      Type.validate(readInt);
      result.type = Type.toKnownValue(result.type);
      Decoder decoder1 = decoder0.readPointer(16, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.domains = new String[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        result.domains[i1] = decoder1.readString((i1 * 8) + 8, false);
      }
      Decoder decoder12 = decoder0.readPointer(24, false);
      DataHeader si12 = decoder12.readDataHeaderForPointerArray(-1);
      result.origins = new Origin[si12.elementsOrVersion];
      for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
        Decoder decoder2 = decoder12.readPointer((i12 * 8) + 8, false);
        result.origins[i12] = Origin.decode(decoder2);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.type, 8);
    String[] strArr = this.domains;
    if (strArr == null) {
      encoder0.encodeNullPointer(16, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(strArr.length, 16, -1);
      int i0 = 0;
      while (true) {
        String[] strArr2 = this.domains;
        if (i0 >= strArr2.length) {
          break;
        }
        encoder1.encode(strArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    Origin[] originArr = this.origins;
    if (originArr == null) {
      encoder0.encodeNullPointer(24, false);
      return;
    }
    Encoder encoder12 = encoder0.encodePointerArray(originArr.length, 24, -1);
    int i02 = 0;
    while (true) {
      Origin[] originArr2 = this.origins;
      if (i02 < originArr2.length) {
        encoder12.encode((Struct) originArr2[i02], (i02 * 8) + 8, false);
        i02++;
      } else {
        return;
      }
    }
  }
}
