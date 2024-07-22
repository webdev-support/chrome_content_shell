package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.Time;
import org.chromium.url.mojom.Url;

public final class CookieDeletionFilter extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 80;
  private static final DataHeader[] VERSION_ARRAY;
  public String cookieName;
  public CookiePartitionKeyCollection cookiePartitionKeyCollection;
  public Time createdAfterTime;
  public Time createdBeforeTime;
  public String[] excludingDomains;
  public String hostName;
  public String[] includingDomains;
  public boolean partitionedStateOnly;
  public int sessionControl;
  public Url url;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(80, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private CookieDeletionFilter(int version) {
    super(80, version);
    this.sessionControl = 0;
  }

  public CookieDeletionFilter() {
    this(0);
  }

  public static CookieDeletionFilter deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static CookieDeletionFilter deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static CookieDeletionFilter decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      CookieDeletionFilter result = new CookieDeletionFilter(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, true);
      result.createdAfterTime = Time.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, true);
      result.createdBeforeTime = Time.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(24, true);
      if (decoder13 == null) {
        result.excludingDomains = null;
      } else {
        DataHeader si1 = decoder13.readDataHeaderForPointerArray(-1);
        result.excludingDomains = new String[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          result.excludingDomains[i1] = decoder13.readString((i1 * 8) + 8, false);
        }
      }
      Decoder decoder14 = decoder0.readPointer(32, true);
      if (decoder14 == null) {
        result.includingDomains = null;
      } else {
        DataHeader si12 = decoder14.readDataHeaderForPointerArray(-1);
        result.includingDomains = new String[si12.elementsOrVersion];
        for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
          result.includingDomains[i12] = decoder14.readString((i12 * 8) + 8, false);
        }
      }
      result.cookieName = decoder0.readString(40, true);
      result.hostName = decoder0.readString(48, true);
      Decoder decoder15 = decoder0.readPointer(56, true);
      result.url = Url.decode(decoder15);
      int readInt = decoder0.readInt(64);
      result.sessionControl = readInt;
      CookieDeletionSessionControl.validate(readInt);
      result.sessionControl = CookieDeletionSessionControl.toKnownValue(result.sessionControl);
      result.partitionedStateOnly = decoder0.readBoolean(68, 0);
      Decoder decoder16 = decoder0.readPointer(72, true);
      result.cookiePartitionKeyCollection = CookiePartitionKeyCollection.decode(decoder16);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.createdAfterTime, 8, true);
    encoder0.encode((Struct) this.createdBeforeTime, 16, true);
    String[] strArr = this.excludingDomains;
    if (strArr == null) {
      encoder0.encodeNullPointer(24, true);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(strArr.length, 24, -1);
      int i0 = 0;
      while (true) {
        String[] strArr2 = this.excludingDomains;
        if (i0 >= strArr2.length) {
          break;
        }
        encoder1.encode(strArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    String[] strArr3 = this.includingDomains;
    if (strArr3 == null) {
      encoder0.encodeNullPointer(32, true);
    } else {
      Encoder encoder12 = encoder0.encodePointerArray(strArr3.length, 32, -1);
      int i02 = 0;
      while (true) {
        String[] strArr4 = this.includingDomains;
        if (i02 >= strArr4.length) {
          break;
        }
        encoder12.encode(strArr4[i02], (i02 * 8) + 8, false);
        i02++;
      }
    }
    encoder0.encode(this.cookieName, 40, true);
    encoder0.encode(this.hostName, 48, true);
    encoder0.encode((Struct) this.url, 56, true);
    encoder0.encode(this.sessionControl, 64);
    encoder0.encode(this.partitionedStateOnly, 68, 0);
    encoder0.encode((Struct) this.cookiePartitionKeyCollection, 72, true);
  }
}
