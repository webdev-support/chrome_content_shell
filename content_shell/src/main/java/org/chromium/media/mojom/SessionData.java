package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class SessionData extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public byte[] keySetId;
  public int keyType;
  public String mimeType;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  public static final class KeyType {
    private static final boolean IS_EXTENSIBLE = false;

    public @interface EnumType {}

    public static boolean isKnownValue(int value) {
      return false;
    }

    public static void validate(int value) {
      if (!isKnownValue(value)) {
        throw new DeserializationException("Invalid enum value.");
      }
    }

    public static int toKnownValue(int value) {
      return value;
    }

    private KeyType() {}
  }

  private SessionData(int version) {
    super(32, version);
  }

  public SessionData() {
    this(0);
  }

  public static SessionData deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static SessionData deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static SessionData decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      SessionData result = new SessionData(elementsOrVersion);
      result.keySetId = decoder0.readBytes(8, 0, -1);
      result.mimeType = decoder0.readString(16, false);
      int readInt = decoder0.readInt(24);
      result.keyType = readInt;
      KeyType.validate(readInt);
      result.keyType = KeyType.toKnownValue(result.keyType);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.keySetId, 8, 0, -1);
    encoder0.encode(this.mimeType, 16, false);
    encoder0.encode(this.keyType, 24);
  }
}
