package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class FederatedAuthRequestIssueDetails extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 16;
  private static final DataHeader[] VERSION_ARRAY;
  public int status;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private FederatedAuthRequestIssueDetails(int version) {
    super(16, version);
  }

  public FederatedAuthRequestIssueDetails() {
    this(0);
  }

  public static FederatedAuthRequestIssueDetails deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static FederatedAuthRequestIssueDetails deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static FederatedAuthRequestIssueDetails decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      FederatedAuthRequestIssueDetails result =
          new FederatedAuthRequestIssueDetails(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.status = readInt;
      FederatedAuthRequestResult.validate(readInt);
      result.status = FederatedAuthRequestResult.toKnownValue(result.status);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.status, 8);
  }
}
