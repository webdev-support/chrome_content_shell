package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class HasTrustTokensResult extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 16;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean hasTrustTokens;
  public int status;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private HasTrustTokensResult(int version) {
    super(16, version);
  }

  public HasTrustTokensResult() {
    this(0);
  }

  public static HasTrustTokensResult deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static HasTrustTokensResult deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static HasTrustTokensResult decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      HasTrustTokensResult result = new HasTrustTokensResult(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.status = readInt;
      TrustTokenOperationStatus.validate(readInt);
      result.status = TrustTokenOperationStatus.toKnownValue(result.status);
      result.hasTrustTokens = decoder0.readBoolean(12, 0);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.status, 8);
    encoder0.encode(this.hasTrustTokens, 12, 0);
  }
}
