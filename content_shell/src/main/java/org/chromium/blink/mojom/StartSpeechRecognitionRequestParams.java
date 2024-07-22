package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class StartSpeechRecognitionRequestParams extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 48;
  private static final DataHeader[] VERSION_ARRAY;
  public SpeechRecognitionSessionClient client;
  public boolean continuous;
  public SpeechRecognitionGrammar[] grammars;
  public boolean interimResults;
  public String language;
  public int maxHypotheses;
  public InterfaceRequest<SpeechRecognitionSession> sessionReceiver;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(48, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private StartSpeechRecognitionRequestParams(int version) {
    super(48, version);
  }

  public StartSpeechRecognitionRequestParams() {
    this(0);
  }

  public static StartSpeechRecognitionRequestParams deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static StartSpeechRecognitionRequestParams deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static StartSpeechRecognitionRequestParams decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      StartSpeechRecognitionRequestParams result =
          new StartSpeechRecognitionRequestParams(elementsOrVersion);
      result.sessionReceiver = decoder0.readInterfaceRequest(8, false);
      result.client =
          (SpeechRecognitionSessionClient)
              decoder0.readServiceInterface(12, false, SpeechRecognitionSessionClient.MANAGER);
      result.maxHypotheses = decoder0.readInt(20);
      result.language = decoder0.readString(24, false);
      Decoder decoder1 = decoder0.readPointer(32, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.grammars = new SpeechRecognitionGrammar[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.grammars[i1] = SpeechRecognitionGrammar.decode(decoder2);
      }
      result.continuous = decoder0.readBoolean(40, 0);
      result.interimResults = decoder0.readBoolean(40, 1);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((InterfaceRequest) this.sessionReceiver, 8, false);
    encoder0.encode(this.client, 12, false, SpeechRecognitionSessionClient.MANAGER);
    encoder0.encode(this.maxHypotheses, 20);
    encoder0.encode(this.language, 24, false);
    SpeechRecognitionGrammar[] speechRecognitionGrammarArr = this.grammars;
    if (speechRecognitionGrammarArr == null) {
      encoder0.encodeNullPointer(32, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(speechRecognitionGrammarArr.length, 32, -1);
      int i0 = 0;
      while (true) {
        SpeechRecognitionGrammar[] speechRecognitionGrammarArr2 = this.grammars;
        if (i0 >= speechRecognitionGrammarArr2.length) {
          break;
        }
        encoder1.encode((Struct) speechRecognitionGrammarArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    encoder0.encode(this.continuous, 40, 0);
    encoder0.encode(this.interimResults, 40, 1);
  }
}
