package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class SpeechRecognitionError extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 16;
  private static final DataHeader[] VERSION_ARRAY;
  public int code;
  public int details;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private SpeechRecognitionError(int version) {
    super(16, version);
  }

  public SpeechRecognitionError() {
    this(0);
  }

  public static SpeechRecognitionError deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static SpeechRecognitionError deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static SpeechRecognitionError decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      SpeechRecognitionError result = new SpeechRecognitionError(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.code = readInt;
      SpeechRecognitionErrorCode.validate(readInt);
      result.code = SpeechRecognitionErrorCode.toKnownValue(result.code);
      int readInt2 = decoder0.readInt(12);
      result.details = readInt2;
      SpeechAudioErrorDetails.validate(readInt2);
      result.details = SpeechAudioErrorDetails.toKnownValue(result.details);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.code, 8);
    encoder0.encode(this.details, 12);
  }
}
