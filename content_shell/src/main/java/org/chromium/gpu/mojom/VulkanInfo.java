package org.chromium.gpu.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class VulkanInfo extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 48;
  private static final DataHeader[] VERSION_ARRAY;
  public int apiVersion;
  public String[] enabledInstanceExtensions;
  public VkExtensionProperties[] instanceExtensions;
  public VkLayerProperties[] instanceLayers;
  public VulkanPhysicalDeviceInfo[] physicalDevices;
  public int usedApiVersion;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(48, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private VulkanInfo(int version) {
    super(48, version);
  }

  public VulkanInfo() {
    this(0);
  }

  public static VulkanInfo deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static VulkanInfo deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static VulkanInfo decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      VulkanInfo result = new VulkanInfo(elementsOrVersion);
      result.apiVersion = decoder0.readInt(8);
      result.usedApiVersion = decoder0.readInt(12);
      Decoder decoder1 = decoder0.readPointer(16, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.instanceExtensions = new VkExtensionProperties[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.instanceExtensions[i1] = VkExtensionProperties.decode(decoder2);
      }
      Decoder decoder12 = decoder0.readPointer(24, false);
      DataHeader si12 = decoder12.readDataHeaderForPointerArray(-1);
      result.enabledInstanceExtensions = new String[si12.elementsOrVersion];
      for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
        result.enabledInstanceExtensions[i12] = decoder12.readString((i12 * 8) + 8, false);
      }
      Decoder decoder13 = decoder0.readPointer(32, false);
      DataHeader si13 = decoder13.readDataHeaderForPointerArray(-1);
      result.instanceLayers = new VkLayerProperties[si13.elementsOrVersion];
      for (int i13 = 0; i13 < si13.elementsOrVersion; i13++) {
        Decoder decoder22 = decoder13.readPointer((i13 * 8) + 8, false);
        result.instanceLayers[i13] = VkLayerProperties.decode(decoder22);
      }
      Decoder decoder14 = decoder0.readPointer(40, false);
      DataHeader si14 = decoder14.readDataHeaderForPointerArray(-1);
      result.physicalDevices = new VulkanPhysicalDeviceInfo[si14.elementsOrVersion];
      for (int i14 = 0; i14 < si14.elementsOrVersion; i14++) {
        Decoder decoder23 = decoder14.readPointer((i14 * 8) + 8, false);
        result.physicalDevices[i14] = VulkanPhysicalDeviceInfo.decode(decoder23);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.apiVersion, 8);
    encoder0.encode(this.usedApiVersion, 12);
    VkExtensionProperties[] vkExtensionPropertiesArr = this.instanceExtensions;
    if (vkExtensionPropertiesArr == null) {
      encoder0.encodeNullPointer(16, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(vkExtensionPropertiesArr.length, 16, -1);
      int i0 = 0;
      while (true) {
        VkExtensionProperties[] vkExtensionPropertiesArr2 = this.instanceExtensions;
        if (i0 >= vkExtensionPropertiesArr2.length) {
          break;
        }
        encoder1.encode((Struct) vkExtensionPropertiesArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    String[] strArr = this.enabledInstanceExtensions;
    if (strArr == null) {
      encoder0.encodeNullPointer(24, false);
    } else {
      Encoder encoder12 = encoder0.encodePointerArray(strArr.length, 24, -1);
      int i02 = 0;
      while (true) {
        String[] strArr2 = this.enabledInstanceExtensions;
        if (i02 >= strArr2.length) {
          break;
        }
        encoder12.encode(strArr2[i02], (i02 * 8) + 8, false);
        i02++;
      }
    }
    VkLayerProperties[] vkLayerPropertiesArr = this.instanceLayers;
    if (vkLayerPropertiesArr == null) {
      encoder0.encodeNullPointer(32, false);
    } else {
      Encoder encoder13 = encoder0.encodePointerArray(vkLayerPropertiesArr.length, 32, -1);
      int i03 = 0;
      while (true) {
        VkLayerProperties[] vkLayerPropertiesArr2 = this.instanceLayers;
        if (i03 >= vkLayerPropertiesArr2.length) {
          break;
        }
        encoder13.encode((Struct) vkLayerPropertiesArr2[i03], (i03 * 8) + 8, false);
        i03++;
      }
    }
    VulkanPhysicalDeviceInfo[] vulkanPhysicalDeviceInfoArr = this.physicalDevices;
    if (vulkanPhysicalDeviceInfoArr == null) {
      encoder0.encodeNullPointer(40, false);
      return;
    }
    Encoder encoder14 = encoder0.encodePointerArray(vulkanPhysicalDeviceInfoArr.length, 40, -1);
    int i04 = 0;
    while (true) {
      VulkanPhysicalDeviceInfo[] vulkanPhysicalDeviceInfoArr2 = this.physicalDevices;
      if (i04 < vulkanPhysicalDeviceInfoArr2.length) {
        encoder14.encode((Struct) vulkanPhysicalDeviceInfoArr2[i04], (i04 * 8) + 8, false);
        i04++;
      } else {
        return;
      }
    }
  }
}
