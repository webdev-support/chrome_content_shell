package org.chromium.gpu.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class VkQueueFamilyProperties extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public VkExtent3D minImageTransferGranularity;
  public int queueCount;
  public int queueFlags;
  public int timestampValidBits;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private VkQueueFamilyProperties(int version) {
    super(32, version);
  }

  public VkQueueFamilyProperties() {
    this(0);
  }

  public static VkQueueFamilyProperties deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static VkQueueFamilyProperties deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static VkQueueFamilyProperties decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      VkQueueFamilyProperties result = new VkQueueFamilyProperties(elementsOrVersion);
      result.queueFlags = decoder0.readInt(8);
      result.queueCount = decoder0.readInt(12);
      result.timestampValidBits = decoder0.readInt(16);
      Decoder decoder1 = decoder0.readPointer(24, false);
      result.minImageTransferGranularity = VkExtent3D.decode(decoder1);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.queueFlags, 8);
    encoder0.encode(this.queueCount, 12);
    encoder0.encode(this.timestampValidBits, 16);
    encoder0.encode((Struct) this.minImageTransferGranularity, 24, false);
  }
}
