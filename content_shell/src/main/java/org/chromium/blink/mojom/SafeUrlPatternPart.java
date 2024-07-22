package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

public final class SafeUrlPatternPart extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public int modifier;
  public PatternTemplate pattern;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private SafeUrlPatternPart(int version) {
    super(32, version);
  }

  public SafeUrlPatternPart() {
    this(0);
  }

  public static SafeUrlPatternPart deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static SafeUrlPatternPart deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static SafeUrlPatternPart decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      SafeUrlPatternPart result = new SafeUrlPatternPart(elementsOrVersion);
      result.pattern = PatternTemplate.decode(decoder0, 8);
      int readInt = decoder0.readInt(24);
      result.modifier = readInt;
      Modifier.validate(readInt);
      result.modifier = Modifier.toKnownValue(result.modifier);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Union) this.pattern, 8, false);
    encoder0.encode(this.modifier, 24);
  }
}
