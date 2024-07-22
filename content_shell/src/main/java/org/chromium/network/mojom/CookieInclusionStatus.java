package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class CookieInclusionStatus extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public int exclusionReasons;
  public int exemptionReason;
  public int warningReasons;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private CookieInclusionStatus(int version) {
    super(24, version);
  }

  public CookieInclusionStatus() {
    this(0);
  }

  public static CookieInclusionStatus deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static CookieInclusionStatus deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static CookieInclusionStatus decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      CookieInclusionStatus result = new CookieInclusionStatus(elementsOrVersion);
      result.exclusionReasons = decoder0.readInt(8);
      result.warningReasons = decoder0.readInt(12);
      int readInt = decoder0.readInt(16);
      result.exemptionReason = readInt;
      CookieExemptionReason.validate(readInt);
      result.exemptionReason = CookieExemptionReason.toKnownValue(result.exemptionReason);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.exclusionReasons, 8);
    encoder0.encode(this.warningReasons, 12);
    encoder0.encode(this.exemptionReason, 16);
  }
}
