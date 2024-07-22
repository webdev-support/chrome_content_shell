package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class CookieSameSiteContextMetadata extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public int crossSiteRedirectDowngrade;
  public int httpMethodBug1221316;
  public int redirectTypeBug1221316;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private CookieSameSiteContextMetadata(int version) {
    super(24, version);
    this.crossSiteRedirectDowngrade = 0;
    this.redirectTypeBug1221316 = 0;
    this.httpMethodBug1221316 = 0;
  }

  public CookieSameSiteContextMetadata() {
    this(0);
  }

  public static CookieSameSiteContextMetadata deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static CookieSameSiteContextMetadata deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static CookieSameSiteContextMetadata decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      CookieSameSiteContextMetadata result = new CookieSameSiteContextMetadata(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.crossSiteRedirectDowngrade = readInt;
      CookieSameSiteContextMetadataDowngradeType.validate(readInt);
      result.crossSiteRedirectDowngrade =
          CookieSameSiteContextMetadataDowngradeType.toKnownValue(
              result.crossSiteRedirectDowngrade);
      int readInt2 = decoder0.readInt(12);
      result.redirectTypeBug1221316 = readInt2;
      ContextRedirectTypeBug1221316.validate(readInt2);
      result.redirectTypeBug1221316 =
          ContextRedirectTypeBug1221316.toKnownValue(result.redirectTypeBug1221316);
      int readInt3 = decoder0.readInt(16);
      result.httpMethodBug1221316 = readInt3;
      HttpMethod.validate(readInt3);
      result.httpMethodBug1221316 = HttpMethod.toKnownValue(result.httpMethodBug1221316);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.crossSiteRedirectDowngrade, 8);
    encoder0.encode(this.redirectTypeBug1221316, 12);
    encoder0.encode(this.httpMethodBug1221316, 16);
  }
}
