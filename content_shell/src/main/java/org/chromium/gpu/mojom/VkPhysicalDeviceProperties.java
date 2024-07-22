package org.chromium.gpu.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class VkPhysicalDeviceProperties extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 64;
  private static final DataHeader[] VERSION_ARRAY;
  public int apiVersion;
  public int deviceId;
  public String deviceName;
  public int deviceType;
  public int driverVersion;
  public VkPhysicalDeviceLimits limits;
  public byte[] pipelineCacheUuid;
  public VkPhysicalDeviceSparseProperties sparseProperties;
  public int vendorId;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(64, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private VkPhysicalDeviceProperties(int version) {
    super(64, version);
  }

  public VkPhysicalDeviceProperties() {
    this(0);
  }

  public static VkPhysicalDeviceProperties deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static VkPhysicalDeviceProperties deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static VkPhysicalDeviceProperties decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      VkPhysicalDeviceProperties result = new VkPhysicalDeviceProperties(elementsOrVersion);
      result.apiVersion = decoder0.readInt(8);
      result.driverVersion = decoder0.readInt(12);
      result.vendorId = decoder0.readInt(16);
      result.deviceId = decoder0.readInt(20);
      int readInt = decoder0.readInt(24);
      result.deviceType = readInt;
      VkPhysicalDeviceType.validate(readInt);
      result.deviceType = VkPhysicalDeviceType.toKnownValue(result.deviceType);
      result.deviceName = decoder0.readString(32, false);
      result.pipelineCacheUuid = decoder0.readBytes(40, 0, 16);
      Decoder decoder1 = decoder0.readPointer(48, false);
      result.limits = VkPhysicalDeviceLimits.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(56, false);
      result.sparseProperties = VkPhysicalDeviceSparseProperties.decode(decoder12);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.apiVersion, 8);
    encoder0.encode(this.driverVersion, 12);
    encoder0.encode(this.vendorId, 16);
    encoder0.encode(this.deviceId, 20);
    encoder0.encode(this.deviceType, 24);
    encoder0.encode(this.deviceName, 32, false);
    encoder0.encode(this.pipelineCacheUuid, 40, 0, 16);
    encoder0.encode((Struct) this.limits, 48, false);
    encoder0.encode((Struct) this.sparseProperties, 56, false);
  }
}
