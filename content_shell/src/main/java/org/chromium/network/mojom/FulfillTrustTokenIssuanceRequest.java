package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.url.internal.mojom.Origin;

public final class FulfillTrustTokenIssuanceRequest extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public Origin issuer;
  public String request;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private FulfillTrustTokenIssuanceRequest(int version) {
    super(24, version);
  }

  public FulfillTrustTokenIssuanceRequest() {
    this(0);
  }

  public static FulfillTrustTokenIssuanceRequest deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static FulfillTrustTokenIssuanceRequest deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static FulfillTrustTokenIssuanceRequest decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      FulfillTrustTokenIssuanceRequest result =
          new FulfillTrustTokenIssuanceRequest(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.issuer = Origin.decode(decoder1);
      result.request = decoder0.readString(16, false);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.issuer, 8, false);
    encoder0.encode(this.request, 16, false);
  }
}
