package org.chromium.device.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class GeopositionError extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public int errorCode;
  public String errorMessage;
  public String errorTechnical;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private GeopositionError(int version) {
    super(32, version);
  }

  public GeopositionError() {
    this(0);
  }

  public static GeopositionError deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static GeopositionError deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static GeopositionError decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      GeopositionError result = new GeopositionError(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.errorCode = readInt;
      GeopositionErrorCode.validate(readInt);
      result.errorCode = GeopositionErrorCode.toKnownValue(result.errorCode);
      result.errorMessage = decoder0.readString(16, false);
      result.errorTechnical = decoder0.readString(24, false);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.errorCode, 8);
    encoder0.encode(this.errorMessage, 16, false);
    encoder0.encode(this.errorTechnical, 24, false);
  }
}
