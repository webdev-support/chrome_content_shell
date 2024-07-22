package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class OriginWithPossibleWildcards extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public String host;
  public boolean isHostWildcard;
  public boolean isPortWildcard;
  public int port;
  public String scheme;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private OriginWithPossibleWildcards(int version) {
    super(32, version);
    this.port = -1;
    this.isHostWildcard = false;
    this.isPortWildcard = false;
  }

  public OriginWithPossibleWildcards() {
    this(0);
  }

  public static OriginWithPossibleWildcards deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static OriginWithPossibleWildcards deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static OriginWithPossibleWildcards decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      OriginWithPossibleWildcards result = new OriginWithPossibleWildcards(elementsOrVersion);
      result.scheme = decoder0.readString(8, false);
      result.host = decoder0.readString(16, false);
      result.port = decoder0.readInt(24);
      result.isHostWildcard = decoder0.readBoolean(28, 0);
      result.isPortWildcard = decoder0.readBoolean(28, 1);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.scheme, 8, false);
    encoder0.encode(this.host, 16, false);
    encoder0.encode(this.port, 24);
    encoder0.encode(this.isHostWildcard, 28, 0);
    encoder0.encode(this.isPortWildcard, 28, 1);
  }
}
