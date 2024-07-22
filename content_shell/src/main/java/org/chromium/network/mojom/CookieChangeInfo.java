package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class CookieChangeInfo extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public CookieAccessResult accessResult;
  public int cause;
  public CanonicalCookie cookie;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private CookieChangeInfo(int version) {
    super(32, version);
  }

  public CookieChangeInfo() {
    this(0);
  }

  public static CookieChangeInfo deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static CookieChangeInfo deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static CookieChangeInfo decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      CookieChangeInfo result = new CookieChangeInfo(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.cookie = CanonicalCookie.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.accessResult = CookieAccessResult.decode(decoder12);
      int readInt = decoder0.readInt(24);
      result.cause = readInt;
      CookieChangeCause.validate(readInt);
      result.cause = CookieChangeCause.toKnownValue(result.cause);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.cookie, 8, false);
    encoder0.encode((Struct) this.accessResult, 16, false);
    encoder0.encode(this.cause, 24);
  }
}
