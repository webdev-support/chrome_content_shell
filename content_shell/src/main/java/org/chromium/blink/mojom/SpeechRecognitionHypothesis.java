package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.String16;

public final class SpeechRecognitionHypothesis extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public double confidence;
  public String16 utterance;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private SpeechRecognitionHypothesis(int version) {
    super(24, version);
  }

  public SpeechRecognitionHypothesis() {
    this(0);
  }

  public static SpeechRecognitionHypothesis deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static SpeechRecognitionHypothesis deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static SpeechRecognitionHypothesis decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      SpeechRecognitionHypothesis result = new SpeechRecognitionHypothesis(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.utterance = String16.decode(decoder1);
      result.confidence = decoder0.readDouble(16);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.utterance, 8, false);
    encoder0.encode(this.confidence, 16);
  }
}
