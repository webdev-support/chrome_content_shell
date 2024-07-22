package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.Uint128;

public final class AggregatableReportHistogramContribution extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public Uint128 bucket;
  public int value;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private AggregatableReportHistogramContribution(int version) {
    super(24, version);
  }

  public AggregatableReportHistogramContribution() {
    this(0);
  }

  public static AggregatableReportHistogramContribution deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static AggregatableReportHistogramContribution deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static AggregatableReportHistogramContribution decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      AggregatableReportHistogramContribution result =
          new AggregatableReportHistogramContribution(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.bucket = Uint128.decode(decoder1);
      result.value = decoder0.readInt(16);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.bucket, 8, false);
    encoder0.encode(this.value, 16);
  }
}