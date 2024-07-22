package org.chromium.gpu.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class VulkanPhysicalDeviceInfo extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 48;
  private static final DataHeader[] VERSION_ARRAY;
  public VkExtensionProperties[] extensions;
  public boolean featureProtectedMemory;
  public boolean featureSamplerYcbcrConversion;
  public VkPhysicalDeviceFeatures features;
  public VkPhysicalDeviceProperties properties;
  public VkQueueFamilyProperties[] queueFamilies;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(48, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private VulkanPhysicalDeviceInfo(int version) {
    super(48, version);
  }

  public VulkanPhysicalDeviceInfo() {
    this(0);
  }

  public static VulkanPhysicalDeviceInfo deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static VulkanPhysicalDeviceInfo deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static VulkanPhysicalDeviceInfo decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      VulkanPhysicalDeviceInfo result = new VulkanPhysicalDeviceInfo(elementsOrVersion);
      result.properties = VkPhysicalDeviceProperties.decode(decoder0.readPointer(8, false));
      Decoder decoder1 = decoder0.readPointer(16, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.extensions = new VkExtensionProperties[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.extensions[i1] = VkExtensionProperties.decode(decoder2);
      }
      result.features = VkPhysicalDeviceFeatures.decode(decoder0.readPointer(24, false));
      result.featureSamplerYcbcrConversion = decoder0.readBoolean(32, 0);
      result.featureProtectedMemory = decoder0.readBoolean(32, 1);
      Decoder decoder12 = decoder0.readPointer(40, false);
      DataHeader si12 = decoder12.readDataHeaderForPointerArray(-1);
      result.queueFamilies = new VkQueueFamilyProperties[si12.elementsOrVersion];
      for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
        Decoder decoder22 = decoder12.readPointer((i12 * 8) + 8, false);
        result.queueFamilies[i12] = VkQueueFamilyProperties.decode(decoder22);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.properties, 8, false);
    VkExtensionProperties[] vkExtensionPropertiesArr = this.extensions;
    if (vkExtensionPropertiesArr == null) {
      encoder0.encodeNullPointer(16, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(vkExtensionPropertiesArr.length, 16, -1);
      int i0 = 0;
      while (true) {
        VkExtensionProperties[] vkExtensionPropertiesArr2 = this.extensions;
        if (i0 >= vkExtensionPropertiesArr2.length) {
          break;
        }
        encoder1.encode((Struct) vkExtensionPropertiesArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    encoder0.encode((Struct) this.features, 24, false);
    encoder0.encode(this.featureSamplerYcbcrConversion, 32, 0);
    encoder0.encode(this.featureProtectedMemory, 32, 1);
    VkQueueFamilyProperties[] vkQueueFamilyPropertiesArr = this.queueFamilies;
    if (vkQueueFamilyPropertiesArr == null) {
      encoder0.encodeNullPointer(40, false);
      return;
    }
    Encoder encoder12 = encoder0.encodePointerArray(vkQueueFamilyPropertiesArr.length, 40, -1);
    int i02 = 0;
    while (true) {
      VkQueueFamilyProperties[] vkQueueFamilyPropertiesArr2 = this.queueFamilies;
      if (i02 < vkQueueFamilyPropertiesArr2.length) {
        encoder12.encode((Struct) vkQueueFamilyPropertiesArr2[i02], (i02 * 8) + 8, false);
        i02++;
      } else {
        return;
      }
    }
  }
}
