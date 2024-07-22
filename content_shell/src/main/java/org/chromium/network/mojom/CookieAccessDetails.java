package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.url.internal.mojom.Origin;
import org.chromium.url.mojom.Url;

public final class CookieAccessDetails extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 72;
  private static final DataHeader[] VERSION_ARRAY;
  public CookieOrLineWithAccessResult[] cookieList;
  public CookieSettingOverrides cookieSettingOverrides;
  public int count;
  public String devtoolsRequestId;
  public boolean isAdTagged;
  public SiteForCookies siteForCookies;
  public Origin topFrameOrigin;
  public int type;
  public Url url;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(72, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  public static final class Type {
    public static final int CHANGE = 1;
    private static final boolean IS_EXTENSIBLE = false;
    public static final int MAX_VALUE = 1;
    public static final int MIN_VALUE = 0;
    public static final int READ = 0;

    public @interface EnumType {}

    public static boolean isKnownValue(int value) {
      return value >= 0 && value <= 1;
    }

    public static void validate(int value) {
      if (!isKnownValue(value)) {
        throw new DeserializationException("Invalid enum value.");
      }
    }

    public static int toKnownValue(int value) {
      return value;
    }

    private Type() {}
  }

  private CookieAccessDetails(int version) {
    super(72, version);
    this.count = 1;
  }

  public CookieAccessDetails() {
    this(0);
  }

  public static CookieAccessDetails deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static CookieAccessDetails deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static CookieAccessDetails decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      CookieAccessDetails result = new CookieAccessDetails(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.type = readInt;
      Type.validate(readInt);
      result.type = Type.toKnownValue(result.type);
      result.count = decoder0.readInt(12);
      Decoder decoder1 = decoder0.readPointer(16, false);
      result.url = Url.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(24, false);
      result.topFrameOrigin = Origin.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(32, false);
      result.siteForCookies = SiteForCookies.decode(decoder13);
      Decoder decoder14 = decoder0.readPointer(40, false);
      DataHeader si1 = decoder14.readDataHeaderForPointerArray(-1);
      result.cookieList = new CookieOrLineWithAccessResult[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder14.readPointer((i1 * 8) + 8, false);
        result.cookieList[i1] = CookieOrLineWithAccessResult.decode(decoder2);
      }
      result.devtoolsRequestId = decoder0.readString(48, true);
      result.isAdTagged = decoder0.readBoolean(56, 0);
      Decoder decoder15 = decoder0.readPointer(64, false);
      result.cookieSettingOverrides = CookieSettingOverrides.decode(decoder15);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.type, 8);
    encoder0.encode(this.count, 12);
    encoder0.encode((Struct) this.url, 16, false);
    encoder0.encode((Struct) this.topFrameOrigin, 24, false);
    encoder0.encode((Struct) this.siteForCookies, 32, false);
    CookieOrLineWithAccessResult[] cookieOrLineWithAccessResultArr = this.cookieList;
    if (cookieOrLineWithAccessResultArr == null) {
      encoder0.encodeNullPointer(40, false);
    } else {
      Encoder encoder1 =
          encoder0.encodePointerArray(cookieOrLineWithAccessResultArr.length, 40, -1);
      int i0 = 0;
      while (true) {
        CookieOrLineWithAccessResult[] cookieOrLineWithAccessResultArr2 = this.cookieList;
        if (i0 >= cookieOrLineWithAccessResultArr2.length) {
          break;
        }
        encoder1.encode((Struct) cookieOrLineWithAccessResultArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    encoder0.encode(this.devtoolsRequestId, 48, true);
    encoder0.encode(this.isAdTagged, 56, 0);
    encoder0.encode((Struct) this.cookieSettingOverrides, 64, false);
  }
}
