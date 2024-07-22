package org.chromium.device.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class VirtualSensorMetadata extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean available;
  public Double maximumFrequency;
  public Double minimumFrequency;
  public Integer reportingMode;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private VirtualSensorMetadata(int version) {
    super(32, version);
    this.available = true;
  }

  public VirtualSensorMetadata() {
    this(0);
  }

  public static VirtualSensorMetadata deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static VirtualSensorMetadata deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static VirtualSensorMetadata decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      VirtualSensorMetadata result = new VirtualSensorMetadata(elementsOrVersion);
      result.available = decoder0.readBoolean(8, 0);
      if (decoder0.readBoolean(8, 1)) {
        result.maximumFrequency = new Double(decoder0.readDouble(16));
      } else {
        result.maximumFrequency = null;
      }
      if (decoder0.readBoolean(8, 2)) {
        result.minimumFrequency = new Double(decoder0.readDouble(24));
      } else {
        result.minimumFrequency = null;
      }
      if (decoder0.readBoolean(8, 3)) {
        result.reportingMode = new Integer(decoder0.readInt(12));
      } else {
        result.reportingMode = null;
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    double maximumFrequency$value;
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.available, 8, 0);
    Double d = this.maximumFrequency;
    boolean maximumFrequency$flag = d != null;
    double minimumFrequency$value = 0.0d;
    if (maximumFrequency$flag) {
      maximumFrequency$value = d.doubleValue();
    } else {
      maximumFrequency$value = 0.0d;
    }
    encoder0.encode(maximumFrequency$flag, 8, 1);
    encoder0.encode(maximumFrequency$value, 16);
    Double d2 = this.minimumFrequency;
    boolean minimumFrequency$flag = d2 != null;
    if (minimumFrequency$flag) {
      minimumFrequency$value = d2.doubleValue();
    }
    encoder0.encode(minimumFrequency$flag, 8, 2);
    encoder0.encode(minimumFrequency$value, 24);
    Integer num = this.reportingMode;
    boolean reportingMode$flag = num != null;
    int reportingMode$value = reportingMode$flag ? num.intValue() : 0;
    encoder0.encode(reportingMode$flag, 8, 3);
    encoder0.encode(reportingMode$value, 12);
  }
}
