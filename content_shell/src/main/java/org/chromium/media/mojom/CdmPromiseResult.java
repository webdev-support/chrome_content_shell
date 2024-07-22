package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class CdmPromiseResult extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public String errorMessage;
  public int exception;
  public boolean success;
  public int systemCode;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  public static final class Exception {
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

    private Exception() {}
  }

  private CdmPromiseResult(int version) {
    super(32, version);
  }

  public CdmPromiseResult() {
    this(0);
  }

  public static CdmPromiseResult deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static CdmPromiseResult deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static CdmPromiseResult decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      CdmPromiseResult result = new CdmPromiseResult(elementsOrVersion);
      result.success = decoder0.readBoolean(8, 0);
      int readInt = decoder0.readInt(12);
      result.exception = readInt;
      Exception.validate(readInt);
      result.exception = Exception.toKnownValue(result.exception);
      result.systemCode = decoder0.readInt(16);
      result.errorMessage = decoder0.readString(24, false);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.success, 8, 0);
    encoder0.encode(this.exception, 12);
    encoder0.encode(this.systemCode, 16);
    encoder0.encode(this.errorMessage, 24, false);
  }
}
