package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.url.mojom.Url;

public final class ManifestShareTarget extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public Url action;
  public int enctype;
  public int method;
  public ManifestShareTargetParams params;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  public static final class Method {
    public static final int GET = 0;
    private static final boolean IS_EXTENSIBLE = false;
    public static final int MAX_VALUE = 1;
    public static final int MIN_VALUE = 0;
    public static final int POST = 1;

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

    private Method() {}
  }

  public static final class Enctype {
    public static final int FORM_URL_ENCODED = 0;
    private static final boolean IS_EXTENSIBLE = false;
    public static final int MAX_VALUE = 1;
    public static final int MIN_VALUE = 0;
    public static final int MULTIPART_FORM_DATA = 1;

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

    private Enctype() {}
  }

  private ManifestShareTarget(int version) {
    super(32, version);
  }

  public ManifestShareTarget() {
    this(0);
  }

  public static ManifestShareTarget deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static ManifestShareTarget deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static ManifestShareTarget decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      ManifestShareTarget result = new ManifestShareTarget(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.action = Url.decode(decoder1);
      int readInt = decoder0.readInt(16);
      result.method = readInt;
      Method.validate(readInt);
      result.method = Method.toKnownValue(result.method);
      int readInt2 = decoder0.readInt(20);
      result.enctype = readInt2;
      Enctype.validate(readInt2);
      result.enctype = Enctype.toKnownValue(result.enctype);
      Decoder decoder12 = decoder0.readPointer(24, false);
      result.params = ManifestShareTargetParams.decode(decoder12);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.action, 8, false);
    encoder0.encode(this.method, 16);
    encoder0.encode(this.enctype, 20);
    encoder0.encode((Struct) this.params, 24, false);
  }
}
