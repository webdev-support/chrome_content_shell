package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class CookieAccessResult extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public int accessSemantics;
  public int effectiveSameSite;
  public boolean isAllowedToAccessSecureCookies;
  public CookieInclusionStatus status;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private CookieAccessResult(int version) {
    super(32, version);
  }

  public CookieAccessResult() {
    this(0);
  }

  public static CookieAccessResult deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static CookieAccessResult deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static CookieAccessResult decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      CookieAccessResult result = new CookieAccessResult(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.effectiveSameSite = readInt;
      CookieEffectiveSameSite.validate(readInt);
      result.effectiveSameSite = CookieEffectiveSameSite.toKnownValue(result.effectiveSameSite);
      int readInt2 = decoder0.readInt(12);
      result.accessSemantics = readInt2;
      CookieAccessSemantics.validate(readInt2);
      result.accessSemantics = CookieAccessSemantics.toKnownValue(result.accessSemantics);
      Decoder decoder1 = decoder0.readPointer(16, false);
      result.status = CookieInclusionStatus.decode(decoder1);
      result.isAllowedToAccessSecureCookies = decoder0.readBoolean(24, 0);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.effectiveSameSite, 8);
    encoder0.encode(this.accessSemantics, 12);
    encoder0.encode((Struct) this.status, 16, false);
    encoder0.encode(this.isAllowedToAccessSecureCookies, 24, 0);
  }
}
