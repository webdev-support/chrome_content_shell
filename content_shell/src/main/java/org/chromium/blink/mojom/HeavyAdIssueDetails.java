package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class HeavyAdIssueDetails extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public AffectedFrame frame;
  public int reason;
  public int resolution;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private HeavyAdIssueDetails(int version) {
    super(24, version);
  }

  public HeavyAdIssueDetails() {
    this(0);
  }

  public static HeavyAdIssueDetails deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static HeavyAdIssueDetails deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static HeavyAdIssueDetails decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      HeavyAdIssueDetails result = new HeavyAdIssueDetails(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.resolution = readInt;
      HeavyAdResolutionStatus.validate(readInt);
      result.resolution = HeavyAdResolutionStatus.toKnownValue(result.resolution);
      int readInt2 = decoder0.readInt(12);
      result.reason = readInt2;
      HeavyAdReason.validate(readInt2);
      result.reason = HeavyAdReason.toKnownValue(result.reason);
      Decoder decoder1 = decoder0.readPointer(16, false);
      result.frame = AffectedFrame.decode(decoder1);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.resolution, 8);
    encoder0.encode(this.reason, 12);
    encoder0.encode((Struct) this.frame, 16, false);
  }
}
