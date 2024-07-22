package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.String16;

public final class ManifestScreenshot extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public int formFactor;
  public ManifestImageResource image;
  public String16 label;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  public static final class FormFactor {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int MAX_VALUE = 2;
    public static final int MIN_VALUE = 0;
    public static final int NARROW = 2;
    public static final int UNKNOWN = 0;
    public static final int WIDE = 1;

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

    private FormFactor() {}
  }

  private ManifestScreenshot(int version) {
    super(32, version);
  }

  public ManifestScreenshot() {
    this(0);
  }

  public static ManifestScreenshot deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static ManifestScreenshot deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static ManifestScreenshot decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      ManifestScreenshot result = new ManifestScreenshot(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.image = ManifestImageResource.decode(decoder1);
      int readInt = decoder0.readInt(16);
      result.formFactor = readInt;
      FormFactor.validate(readInt);
      result.formFactor = FormFactor.toKnownValue(result.formFactor);
      Decoder decoder12 = decoder0.readPointer(24, true);
      result.label = String16.decode(decoder12);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.image, 8, false);
    encoder0.encode(this.formFactor, 16);
    encoder0.encode((Struct) this.label, 24, true);
  }
}
