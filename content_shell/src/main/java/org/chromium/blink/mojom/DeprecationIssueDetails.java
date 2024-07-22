package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class DeprecationIssueDetails extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public AffectedLocation affectedLocation;
  public int type;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private DeprecationIssueDetails(int version) {
    super(24, version);
  }

  public DeprecationIssueDetails() {
    this(0);
  }

  public static DeprecationIssueDetails deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static DeprecationIssueDetails deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static DeprecationIssueDetails decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      DeprecationIssueDetails result = new DeprecationIssueDetails(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.type = readInt;
      DeprecationIssueType.validate(readInt);
      result.type = DeprecationIssueType.toKnownValue(result.type);
      Decoder decoder1 = decoder0.readPointer(16, false);
      result.affectedLocation = AffectedLocation.decode(decoder1);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.type, 8);
    encoder0.encode((Struct) this.affectedLocation, 16, false);
  }
}
