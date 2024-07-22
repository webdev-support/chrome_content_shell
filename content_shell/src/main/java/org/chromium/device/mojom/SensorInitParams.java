package org.chromium.device.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.ReadOnlySharedMemoryRegion;

public final class SensorInitParams extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  public static final long READ_BUFFER_SIZE_FOR_TESTS = 48;
  private static final int STRUCT_SIZE = 64;
  private static final DataHeader[] VERSION_ARRAY;
  public long bufferOffset;
  public InterfaceRequest<SensorClient> clientReceiver;
  public SensorConfiguration defaultConfiguration;
  public double maximumFrequency;
  public ReadOnlySharedMemoryRegion memory;
  public double minimumFrequency;
  public int mode;
  public Sensor sensor;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(64, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private SensorInitParams(int version) {
    super(64, version);
  }

  public SensorInitParams() {
    this(0);
  }

  public static SensorInitParams deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static SensorInitParams deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static SensorInitParams decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      SensorInitParams result = new SensorInitParams(elementsOrVersion);
      result.sensor = (Sensor) decoder0.readServiceInterface(8, false, Sensor.MANAGER);
      result.clientReceiver = decoder0.readInterfaceRequest(16, false);
      int readInt = decoder0.readInt(20);
      result.mode = readInt;
      ReportingMode.validate(readInt);
      result.mode = ReportingMode.toKnownValue(result.mode);
      Decoder decoder1 = decoder0.readPointer(24, false);
      result.memory = ReadOnlySharedMemoryRegion.decode(decoder1);
      result.bufferOffset = decoder0.readLong(32);
      Decoder decoder12 = decoder0.readPointer(40, false);
      result.defaultConfiguration = SensorConfiguration.decode(decoder12);
      result.maximumFrequency = decoder0.readDouble(48);
      result.minimumFrequency = decoder0.readDouble(56);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.sensor, 8, false, Sensor.MANAGER);
    encoder0.encode((InterfaceRequest) this.clientReceiver, 16, false);
    encoder0.encode(this.mode, 20);
    encoder0.encode((Struct) this.memory, 24, false);
    encoder0.encode(this.bufferOffset, 32);
    encoder0.encode((Struct) this.defaultConfiguration, 40, false);
    encoder0.encode(this.maximumFrequency, 48);
    encoder0.encode(this.minimumFrequency, 56);
  }
}
