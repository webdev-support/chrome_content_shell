package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class AffectedLocation extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public int column;
  public int line;
  public String scriptId;
  public String url;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private AffectedLocation(int version) {
    super(32, version);
    this.line = 0;
    this.column = 0;
  }

  public AffectedLocation() {
    this(0);
  }

  public static AffectedLocation deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static AffectedLocation deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static AffectedLocation decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      AffectedLocation result = new AffectedLocation(elementsOrVersion);
      result.scriptId = decoder0.readString(8, true);
      result.url = decoder0.readString(16, true);
      result.line = decoder0.readInt(24);
      result.column = decoder0.readInt(28);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.scriptId, 8, true);
    encoder0.encode(this.url, 16, true);
    encoder0.encode(this.line, 24);
    encoder0.encode(this.column, 28);
  }
}
