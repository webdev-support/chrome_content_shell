package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

public final class CookieOrLineWithAccessResult extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public CookieAccessResult accessResult;
  public CookieOrLine cookieOrLine;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private CookieOrLineWithAccessResult(int version) {
    super(32, version);
  }

  public CookieOrLineWithAccessResult() {
    this(0);
  }

  public static CookieOrLineWithAccessResult deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static CookieOrLineWithAccessResult deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static CookieOrLineWithAccessResult decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      CookieOrLineWithAccessResult result = new CookieOrLineWithAccessResult(elementsOrVersion);
      result.cookieOrLine = CookieOrLine.decode(decoder0, 8);
      Decoder decoder1 = decoder0.readPointer(24, false);
      result.accessResult = CookieAccessResult.decode(decoder1);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Union) this.cookieOrLine, 8, false);
    encoder0.encode((Struct) this.accessResult, 24, false);
  }
}
