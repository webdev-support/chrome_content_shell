package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.url.mojom.Url;

public final class SharedDictionaryAccessDetails extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean isBlocked;
  public SharedDictionaryIsolationKey isolationKey;
  public int type;
  public Url url;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  public static final class Type {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int MAX_VALUE = 1;
    public static final int MIN_VALUE = 0;
    public static final int READ = 0;
    public static final int WRITE = 1;

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

  private SharedDictionaryAccessDetails(int version) {
    super(32, version);
    this.isBlocked = false;
  }

  public SharedDictionaryAccessDetails() {
    this(0);
  }

  public static SharedDictionaryAccessDetails deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static SharedDictionaryAccessDetails deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static SharedDictionaryAccessDetails decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      SharedDictionaryAccessDetails result = new SharedDictionaryAccessDetails(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.type = readInt;
      Type.validate(readInt);
      result.type = Type.toKnownValue(result.type);
      result.isBlocked = decoder0.readBoolean(12, 0);
      Decoder decoder1 = decoder0.readPointer(16, false);
      result.url = Url.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(24, false);
      result.isolationKey = SharedDictionaryIsolationKey.decode(decoder12);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.type, 8);
    encoder0.encode(this.isBlocked, 12, 0);
    encoder0.encode((Struct) this.url, 16, false);
    encoder0.encode((Struct) this.isolationKey, 24, false);
  }
}
