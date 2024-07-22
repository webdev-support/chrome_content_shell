package org.chromium.gpu.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class DevicePerfInfo extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public int hardwareConcurrency;
  public int totalDiskSpaceMb;
  public int totalPhysicalMemoryMb;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private DevicePerfInfo(int version) {
    super(24, version);
  }

  public DevicePerfInfo() {
    this(0);
  }

  public static DevicePerfInfo deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static DevicePerfInfo deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static DevicePerfInfo decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      DevicePerfInfo result = new DevicePerfInfo(elementsOrVersion);
      result.totalPhysicalMemoryMb = decoder0.readInt(8);
      result.totalDiskSpaceMb = decoder0.readInt(12);
      result.hardwareConcurrency = decoder0.readInt(16);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.totalPhysicalMemoryMb, 8);
    encoder0.encode(this.totalDiskSpaceMb, 12);
    encoder0.encode(this.hardwareConcurrency, 16);
  }
}
