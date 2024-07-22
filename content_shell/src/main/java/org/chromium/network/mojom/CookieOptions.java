package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class CookieOptions extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean excludeHttponly;
  public boolean returnExcludedCookies;
  public CookieSameSiteContext sameSiteCookieContext;
  public boolean updateAccessTime;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private CookieOptions(int version) {
    super(24, version);
    this.excludeHttponly = true;
    this.updateAccessTime = true;
    this.returnExcludedCookies = false;
  }

  public CookieOptions() {
    this(0);
  }

  public static CookieOptions deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static CookieOptions deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static CookieOptions decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      CookieOptions result = new CookieOptions(elementsOrVersion);
      result.excludeHttponly = decoder0.readBoolean(8, 0);
      result.updateAccessTime = decoder0.readBoolean(8, 1);
      result.returnExcludedCookies = decoder0.readBoolean(8, 2);
      Decoder decoder1 = decoder0.readPointer(16, false);
      result.sameSiteCookieContext = CookieSameSiteContext.decode(decoder1);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.excludeHttponly, 8, 0);
    encoder0.encode(this.updateAccessTime, 8, 1);
    encoder0.encode(this.returnExcludedCookies, 8, 2);
    encoder0.encode((Struct) this.sameSiteCookieContext, 16, false);
  }
}
