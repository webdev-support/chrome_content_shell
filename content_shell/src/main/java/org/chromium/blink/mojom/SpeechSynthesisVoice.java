package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class SpeechSynthesisVoice extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean isDefault;
  public boolean isLocalService;
  public String lang;
  public String name;
  public String voiceUri;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private SpeechSynthesisVoice(int version) {
    super(40, version);
  }

  public SpeechSynthesisVoice() {
    this(0);
  }

  public static SpeechSynthesisVoice deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static SpeechSynthesisVoice deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static SpeechSynthesisVoice decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      SpeechSynthesisVoice result = new SpeechSynthesisVoice(elementsOrVersion);
      result.voiceUri = decoder0.readString(8, false);
      result.name = decoder0.readString(16, false);
      result.lang = decoder0.readString(24, false);
      result.isLocalService = decoder0.readBoolean(32, 0);
      result.isDefault = decoder0.readBoolean(32, 1);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.voiceUri, 8, false);
    encoder0.encode(this.name, 16, false);
    encoder0.encode(this.lang, 24, false);
    encoder0.encode(this.isLocalService, 32, 0);
    encoder0.encode(this.isDefault, 32, 1);
  }
}
