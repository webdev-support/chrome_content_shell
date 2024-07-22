package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

public final class CookieOrLine extends Union {

  private CanonicalCookie mCookie;
  private String mCookieString;

  public static final class Tag {
    public static final int Cookie = 0;
    public static final int CookieString = 1;
  }

  public void setCookie(CanonicalCookie cookie) {
    this.mTag = 0;
    this.mCookie = cookie;
  }

  public CanonicalCookie getCookie() {
    if (this.mTag != 0) {
      throw new AssertionError();
    }
    return this.mCookie;
  }

  public void setCookieString(String cookieString) {
    this.mTag = 1;
    this.mCookieString = cookieString;
  }

  public String getCookieString() {
    if (this.mTag != 1) {
      throw new AssertionError();
    }
    return this.mCookieString;
  }

  @Override
  public final void encode(Encoder encoder0, int offset) {
    encoder0.encode(16, offset);
    encoder0.encode(this.mTag, offset + 4);
    switch (this.mTag) {
      case 0:
        encoder0.encode((Struct) this.mCookie, offset + 8, false);
        return;
      case 1:
        encoder0.encode(this.mCookieString, offset + 8, false);
        return;
      default:
        return;
    }
  }

  public static CookieOrLine deserialize(Message message) {
    return decode(new Decoder(message).decoderForSerializedUnion(), 0);
  }

  public static final CookieOrLine decode(Decoder decoder0, int offset) {
    DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
    if (dataHeader.size == 0) {
      return null;
    }
    CookieOrLine result = new CookieOrLine();
    switch (dataHeader.elementsOrVersion) {
      case 0:
        Decoder decoder1 = decoder0.readPointer(offset + 8, false);
        result.mCookie = CanonicalCookie.decode(decoder1);
        result.mTag = 0;
        break;
      case 1:
        result.mCookieString = decoder0.readString(offset + 8, false);
        result.mTag = 1;
        break;
    }
    return result;
  }
}
