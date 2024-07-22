package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class FulfillTrustTokenIssuanceAnswer extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public String response;
  public int status;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  public static final class Status {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int MAX_VALUE = 2;
    public static final int MIN_VALUE = 0;
    public static final int NOT_FOUND = 1;

    public static final int f697OK = 0;
    public static final int UNKNOWN_ERROR = 2;

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

    private Status() {}
  }

  private FulfillTrustTokenIssuanceAnswer(int version) {
    super(24, version);
  }

  public FulfillTrustTokenIssuanceAnswer() {
    this(0);
  }

  public static FulfillTrustTokenIssuanceAnswer deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static FulfillTrustTokenIssuanceAnswer deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static FulfillTrustTokenIssuanceAnswer decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      FulfillTrustTokenIssuanceAnswer result =
          new FulfillTrustTokenIssuanceAnswer(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.status = readInt;
      Status.validate(readInt);
      result.status = Status.toKnownValue(result.status);
      result.response = decoder0.readString(16, false);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.status, 8);
    encoder0.encode(this.response, 16, false);
  }
}
