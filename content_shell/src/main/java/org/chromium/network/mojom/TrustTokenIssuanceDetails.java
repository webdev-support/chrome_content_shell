package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.url.internal.mojom.Origin;

public final class TrustTokenIssuanceDetails extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean blocked;
  public Origin issuer;
  public Origin origin;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private TrustTokenIssuanceDetails(int version) {
    super(32, version);
    this.blocked = false;
  }

  public TrustTokenIssuanceDetails() {
    this(0);
  }

  public static TrustTokenIssuanceDetails deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static TrustTokenIssuanceDetails deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static TrustTokenIssuanceDetails decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      TrustTokenIssuanceDetails result = new TrustTokenIssuanceDetails(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.origin = Origin.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, true);
      result.issuer = Origin.decode(decoder12);
      result.blocked = decoder0.readBoolean(24, 0);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.origin, 8, false);
    encoder0.encode((Struct) this.issuer, 16, true);
    encoder0.encode(this.blocked, 24, 0);
  }
}
