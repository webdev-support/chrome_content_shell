package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class CookieAndLineWithAccessResult extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public CookieAccessResult accessResult;
  public CanonicalCookie cookie;
  public String cookieString;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private CookieAndLineWithAccessResult(int version) {
    super(32, version);
  }

  public CookieAndLineWithAccessResult() {
    this(0);
  }

  public static CookieAndLineWithAccessResult deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static CookieAndLineWithAccessResult deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static CookieAndLineWithAccessResult decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      CookieAndLineWithAccessResult result = new CookieAndLineWithAccessResult(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, true);
      result.cookie = CanonicalCookie.decode(decoder1);
      result.cookieString = decoder0.readString(16, false);
      Decoder decoder12 = decoder0.readPointer(24, false);
      result.accessResult = CookieAccessResult.decode(decoder12);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.cookie, 8, true);
    encoder0.encode(this.cookieString, 16, false);
    encoder0.encode((Struct) this.accessResult, 24, false);
  }
}
