package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class CookieManagerGetOptions extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public int matchType;
  public String name;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private CookieManagerGetOptions(int version) {
    super(24, version);
  }

  public CookieManagerGetOptions() {
    this(0);
  }

  public static CookieManagerGetOptions deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static CookieManagerGetOptions deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static CookieManagerGetOptions decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      CookieManagerGetOptions result = new CookieManagerGetOptions(elementsOrVersion);
      result.name = decoder0.readString(8, false);
      int readInt = decoder0.readInt(16);
      result.matchType = readInt;
      CookieMatchType.validate(readInt);
      result.matchType = CookieMatchType.toKnownValue(result.matchType);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.name, 8, false);
    encoder0.encode(this.matchType, 16);
  }
}