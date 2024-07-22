package org.chromium.url.internal.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.UnguessableToken;

public final class Origin extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public String host;
  public UnguessableToken nonceIfOpaque;
  public short port;
  public String scheme;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private Origin(int version) {
    super(40, version);
  }

  public Origin() {
    this(0);
  }

  public static Origin deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static Origin deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static Origin decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      Origin result = new Origin(elementsOrVersion);
      result.scheme = decoder0.readString(8, false);
      result.host = decoder0.readString(16, false);
      result.port = decoder0.readShort(24);
      Decoder decoder1 = decoder0.readPointer(32, true);
      result.nonceIfOpaque = UnguessableToken.decode(decoder1);
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
    encoder0.encode((Struct) this.nonceIfOpaque, 32, true);
  }
}
