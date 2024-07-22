package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class SpeechSynthesisUtterance extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 56;
  private static final DataHeader[] VERSION_ARRAY;
  public String lang;
  public double pitch;
  public double rate;
  public String text;
  public String voice;
  public double volume;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(56, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private SpeechSynthesisUtterance(int version) {
    super(56, version);
  }

  public SpeechSynthesisUtterance() {
    this(0);
  }

  public static SpeechSynthesisUtterance deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static SpeechSynthesisUtterance deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static SpeechSynthesisUtterance decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      SpeechSynthesisUtterance result = new SpeechSynthesisUtterance(elementsOrVersion);
      result.text = decoder0.readString(8, false);
      result.lang = decoder0.readString(16, false);
      result.voice = decoder0.readString(24, false);
      result.volume = decoder0.readDouble(32);
      result.rate = decoder0.readDouble(40);
      result.pitch = decoder0.readDouble(48);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.text, 8, false);
    encoder0.encode(this.lang, 16, false);
    encoder0.encode(this.voice, 24, false);
    encoder0.encode(this.volume, 32);
    encoder0.encode(this.rate, 40);
    encoder0.encode(this.pitch, 48);
  }
}
