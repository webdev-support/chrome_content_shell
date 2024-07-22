package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class DetectionArgs extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public long blinkWorkloadThreshold;
  public long privateFootprintThreshold;
  public long swapThreshold;
  public long virtualMemoryThresold;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private DetectionArgs(int version) {
    super(40, version);
  }

  public DetectionArgs() {
    this(0);
  }

  public static DetectionArgs deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static DetectionArgs deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static DetectionArgs decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      DetectionArgs result = new DetectionArgs(elementsOrVersion);
      result.blinkWorkloadThreshold = decoder0.readLong(8);
      result.privateFootprintThreshold = decoder0.readLong(16);
      result.swapThreshold = decoder0.readLong(24);
      result.virtualMemoryThresold = decoder0.readLong(32);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.blinkWorkloadThreshold, 8);
    encoder0.encode(this.privateFootprintThreshold, 16);
    encoder0.encode(this.swapThreshold, 24);
    encoder0.encode(this.virtualMemoryThresold, 32);
  }
}
