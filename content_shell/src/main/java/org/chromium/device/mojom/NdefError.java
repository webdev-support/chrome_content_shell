package org.chromium.device.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class NdefError extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public String errorMessage;
  public int errorType;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private NdefError(int version) {
    super(24, version);
  }

  public NdefError() {
    this(0);
  }

  public static NdefError deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static NdefError deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static NdefError decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      NdefError result = new NdefError(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.errorType = readInt;
      NdefErrorType.validate(readInt);
      result.errorType = NdefErrorType.toKnownValue(result.errorType);
      result.errorMessage = decoder0.readString(16, false);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.errorType, 8);
    encoder0.encode(this.errorMessage, 16, false);
  }
}
