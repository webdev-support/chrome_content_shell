package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class GenericIssueDetails extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public int errorType;
  public String frameId;
  public String violatingNodeAttribute;
  public int violatingNodeId;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private GenericIssueDetails(int version) {
    super(32, version);
    this.violatingNodeId = 0;
  }

  public GenericIssueDetails() {
    this(0);
  }

  public static GenericIssueDetails deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static GenericIssueDetails deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static GenericIssueDetails decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      GenericIssueDetails result = new GenericIssueDetails(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.errorType = readInt;
      GenericIssueErrorType.validate(readInt);
      result.errorType = GenericIssueErrorType.toKnownValue(result.errorType);
      result.violatingNodeId = decoder0.readInt(12);
      result.frameId = decoder0.readString(16, true);
      result.violatingNodeAttribute = decoder0.readString(24, true);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.errorType, 8);
    encoder0.encode(this.violatingNodeId, 12);
    encoder0.encode(this.frameId, 16, true);
    encoder0.encode(this.violatingNodeAttribute, 24, true);
  }
}
