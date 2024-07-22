package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class FrameAdEvidence extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public int createdByAdScript;
  public boolean isComplete;
  public int latestFilterListResult;
  public int mostRestrictiveFilterListResult;
  public boolean parentIsAd;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private FrameAdEvidence(int version) {
    super(24, version);
    this.latestFilterListResult = 0;
    this.mostRestrictiveFilterListResult = 0;
    this.createdByAdScript = 0;
  }

  public FrameAdEvidence() {
    this(0);
  }

  public static FrameAdEvidence deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static FrameAdEvidence deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static FrameAdEvidence decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      FrameAdEvidence result = new FrameAdEvidence(elementsOrVersion);
      result.isComplete = decoder0.readBoolean(8, 0);
      result.parentIsAd = decoder0.readBoolean(8, 1);
      int readInt = decoder0.readInt(12);
      result.latestFilterListResult = readInt;
      FilterListResult.validate(readInt);
      result.latestFilterListResult = FilterListResult.toKnownValue(result.latestFilterListResult);
      int readInt2 = decoder0.readInt(16);
      result.mostRestrictiveFilterListResult = readInt2;
      FilterListResult.validate(readInt2);
      result.mostRestrictiveFilterListResult =
          FilterListResult.toKnownValue(result.mostRestrictiveFilterListResult);
      int readInt3 = decoder0.readInt(20);
      result.createdByAdScript = readInt3;
      FrameCreationStackEvidence.validate(readInt3);
      result.createdByAdScript = FrameCreationStackEvidence.toKnownValue(result.createdByAdScript);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.isComplete, 8, 0);
    encoder0.encode(this.parentIsAd, 8, 1);
    encoder0.encode(this.latestFilterListResult, 12);
    encoder0.encode(this.mostRestrictiveFilterListResult, 16);
    encoder0.encode(this.createdByAdScript, 20);
  }
}
