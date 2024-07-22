package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Size;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.String16;
import org.chromium.url.mojom.Url;

public final class ManifestImageResource extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public int[] purpose;
  public Size[] sizes;
  public Url src;
  public String16 type;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  public static final class Purpose {
    public static final int ANY = 0;
    private static final boolean IS_EXTENSIBLE = false;
    public static final int MASKABLE = 2;
    public static final int MAX_VALUE = 2;
    public static final int MIN_VALUE = 0;
    public static final int MONOCHROME = 1;

    public @interface EnumType {}

    public static boolean isKnownValue(int value) {
      return value >= 0 && value <= 2;
    }

    public static void validate(int value) {
      if (!isKnownValue(value)) {
        throw new DeserializationException("Invalid enum value.");
      }
    }

    public static int toKnownValue(int value) {
      return value;
    }

    private Purpose() {}
  }

  private ManifestImageResource(int version) {
    super(40, version);
  }

  public ManifestImageResource() {
    this(0);
  }

  public static ManifestImageResource deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static ManifestImageResource deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static ManifestImageResource decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      ManifestImageResource result = new ManifestImageResource(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.src = Url.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, true);
      result.type = String16.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(24, false);
      DataHeader si1 = decoder13.readDataHeaderForPointerArray(-1);
      result.sizes = new Size[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder13.readPointer((i1 * 8) + 8, false);
        result.sizes[i1] = Size.decode(decoder2);
      }
      result.purpose = decoder0.readInts(32, 0, -1);
      int i12 = 0;
      while (true) {
        int[] iArr = result.purpose;
        if (i12 < iArr.length) {
          Purpose.validate(iArr[i12]);
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
    encoder0.encode((Struct) this.src, 8, false);
    encoder0.encode((Struct) this.type, 16, true);
    Size[] sizeArr = this.sizes;
    if (sizeArr == null) {
      encoder0.encodeNullPointer(24, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(sizeArr.length, 24, -1);
      int i0 = 0;
      while (true) {
        Size[] sizeArr2 = this.sizes;
        if (i0 >= sizeArr2.length) {
          break;
        }
        encoder1.encode((Struct) sizeArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    encoder0.encode(this.purpose, 32, 0, -1);
  }
}
