package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.url.internal.mojom.Origin;

public final class TrustTokenOperationResult extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public int issuedTokenCount;
  public Origin issuer;
  public int operation;
  public int status;
  public Origin topLevelOrigin;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private TrustTokenOperationResult(int version) {
    super(40, version);
    this.issuedTokenCount = 0;
  }

  public TrustTokenOperationResult() {
    this(0);
  }

  public static TrustTokenOperationResult deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static TrustTokenOperationResult deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static TrustTokenOperationResult decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      TrustTokenOperationResult result = new TrustTokenOperationResult(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.operation = readInt;
      TrustTokenOperationType.validate(readInt);
      result.operation = TrustTokenOperationType.toKnownValue(result.operation);
      int readInt2 = decoder0.readInt(12);
      result.status = readInt2;
      TrustTokenOperationStatus.validate(readInt2);
      result.status = TrustTokenOperationStatus.toKnownValue(result.status);
      Decoder decoder1 = decoder0.readPointer(16, true);
      result.issuer = Origin.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(24, true);
      result.topLevelOrigin = Origin.decode(decoder12);
      result.issuedTokenCount = decoder0.readInt(32);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.operation, 8);
    encoder0.encode(this.status, 12);
    encoder0.encode((Struct) this.issuer, 16, true);
    encoder0.encode((Struct) this.topLevelOrigin, 24, true);
    encoder0.encode(this.issuedTokenCount, 32);
  }
}
