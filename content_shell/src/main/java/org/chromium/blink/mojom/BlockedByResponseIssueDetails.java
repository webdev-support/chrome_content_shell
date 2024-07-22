package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.network.mojom.BlockedByResponseReason;

public final class BlockedByResponseIssueDetails extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public AffectedFrame blockedFrame;
  public AffectedFrame parentFrame;
  public int reason;
  public AffectedRequest request;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private BlockedByResponseIssueDetails(int version) {
    super(40, version);
  }

  public BlockedByResponseIssueDetails() {
    this(0);
  }

  public static BlockedByResponseIssueDetails deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static BlockedByResponseIssueDetails deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static BlockedByResponseIssueDetails decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      BlockedByResponseIssueDetails result = new BlockedByResponseIssueDetails(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.request = AffectedRequest.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, true);
      result.parentFrame = AffectedFrame.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(24, true);
      result.blockedFrame = AffectedFrame.decode(decoder13);
      int readInt = decoder0.readInt(32);
      result.reason = readInt;
      BlockedByResponseReason.validate(readInt);
      result.reason = BlockedByResponseReason.toKnownValue(result.reason);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.request, 8, false);
    encoder0.encode((Struct) this.parentFrame, 16, true);
    encoder0.encode((Struct) this.blockedFrame, 24, true);
    encoder0.encode(this.reason, 32);
  }
}
