package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class SharedStorageOperation extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public int ignoreIfPresent;
  public String key;
  public int type;
  public String value;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private SharedStorageOperation(int version) {
    super(32, version);
    this.ignoreIfPresent = 0;
  }

  public SharedStorageOperation() {
    this(0);
  }

  public static SharedStorageOperation deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static SharedStorageOperation deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static SharedStorageOperation decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      SharedStorageOperation result = new SharedStorageOperation(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.type = readInt;
      SharedStorageOperationType.validate(readInt);
      result.type = SharedStorageOperationType.toKnownValue(result.type);
      int readInt2 = decoder0.readInt(12);
      result.ignoreIfPresent = readInt2;
      OptionalBool.validate(readInt2);
      result.ignoreIfPresent = OptionalBool.toKnownValue(result.ignoreIfPresent);
      result.key = decoder0.readString(16, true);
      result.value = decoder0.readString(24, true);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.type, 8);
    encoder0.encode(this.ignoreIfPresent, 12);
    encoder0.encode(this.key, 16, true);
    encoder0.encode(this.value, 24, true);
  }
}
