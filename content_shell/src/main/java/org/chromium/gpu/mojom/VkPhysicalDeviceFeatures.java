package org.chromium.gpu.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class VkPhysicalDeviceFeatures extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 16;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean alphaToOne;
  public boolean depthBiasClamp;
  public boolean depthBounds;
  public boolean depthClamp;
  public boolean drawIndirectFirstInstance;
  public boolean dualSrcBlend;
  public boolean fillModeNonSolid;
  public boolean fragmentStoresAndAtomics;
  public boolean fullDrawIndexUint32;
  public boolean geometryShader;
  public boolean imageCubeArray;
  public boolean independentBlend;
  public boolean inheritedQueries;
  public boolean largePoints;
  public boolean logicOp;
  public boolean multiDrawIndirect;
  public boolean multiViewport;
  public boolean occlusionQueryPrecise;
  public boolean pipelineStatisticsQuery;
  public boolean robustBufferAccess;
  public boolean sampleRateShading;
  public boolean samplerAnisotropy;
  public boolean shaderClipDistance;
  public boolean shaderCullDistance;
  public boolean shaderFloat64;
  public boolean shaderImageGatherExtended;
  public boolean shaderInt16;
  public boolean shaderInt64;
  public boolean shaderResourceMinLod;
  public boolean shaderResourceResidency;
  public boolean shaderSampledImageArrayDynamicIndexing;
  public boolean shaderStorageBufferArrayDynamicIndexing;
  public boolean shaderStorageImageArrayDynamicIndexing;
  public boolean shaderStorageImageExtendedFormats;
  public boolean shaderStorageImageMultisample;
  public boolean shaderStorageImageReadWithoutFormat;
  public boolean shaderStorageImageWriteWithoutFormat;
  public boolean shaderTessellationAndGeometryPointSize;
  public boolean shaderUniformBufferArrayDynamicIndexing;
  public boolean sparseBinding;
  public boolean sparseResidency16Samples;
  public boolean sparseResidency2Samples;
  public boolean sparseResidency4Samples;
  public boolean sparseResidency8Samples;
  public boolean sparseResidencyAliased;
  public boolean sparseResidencyBuffer;
  public boolean sparseResidencyImage2D;
  public boolean sparseResidencyImage3D;
  public boolean tessellationShader;
  public boolean textureCompressionAstcLdr;
  public boolean textureCompressionBc;
  public boolean textureCompressionEtc2;
  public boolean variableMultisampleRate;
  public boolean vertexPipelineStoresAndAtomics;
  public boolean wideLines;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private VkPhysicalDeviceFeatures(int version) {
    super(16, version);
  }

  public VkPhysicalDeviceFeatures() {
    this(0);
  }

  public static VkPhysicalDeviceFeatures deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static VkPhysicalDeviceFeatures deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static VkPhysicalDeviceFeatures decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      VkPhysicalDeviceFeatures result = new VkPhysicalDeviceFeatures(elementsOrVersion);
      result.robustBufferAccess = decoder0.readBoolean(8, 0);
      result.fullDrawIndexUint32 = decoder0.readBoolean(8, 1);
      result.imageCubeArray = decoder0.readBoolean(8, 2);
      result.independentBlend = decoder0.readBoolean(8, 3);
      result.geometryShader = decoder0.readBoolean(8, 4);
      result.tessellationShader = decoder0.readBoolean(8, 5);
      result.sampleRateShading = decoder0.readBoolean(8, 6);
      result.dualSrcBlend = decoder0.readBoolean(8, 7);
      result.logicOp = decoder0.readBoolean(9, 0);
      result.multiDrawIndirect = decoder0.readBoolean(9, 1);
      result.drawIndirectFirstInstance = decoder0.readBoolean(9, 2);
      result.depthClamp = decoder0.readBoolean(9, 3);
      result.depthBiasClamp = decoder0.readBoolean(9, 4);
      result.fillModeNonSolid = decoder0.readBoolean(9, 5);
      result.depthBounds = decoder0.readBoolean(9, 6);
      result.wideLines = decoder0.readBoolean(9, 7);
      result.largePoints = decoder0.readBoolean(10, 0);
      result.alphaToOne = decoder0.readBoolean(10, 1);
      result.multiViewport = decoder0.readBoolean(10, 2);
      result.samplerAnisotropy = decoder0.readBoolean(10, 3);
      result.textureCompressionEtc2 = decoder0.readBoolean(10, 4);
      result.textureCompressionAstcLdr = decoder0.readBoolean(10, 5);
      result.textureCompressionBc = decoder0.readBoolean(10, 6);
      result.occlusionQueryPrecise = decoder0.readBoolean(10, 7);
      result.pipelineStatisticsQuery = decoder0.readBoolean(11, 0);
      result.vertexPipelineStoresAndAtomics = decoder0.readBoolean(11, 1);
      result.fragmentStoresAndAtomics = decoder0.readBoolean(11, 2);
      result.shaderTessellationAndGeometryPointSize = decoder0.readBoolean(11, 3);
      result.shaderImageGatherExtended = decoder0.readBoolean(11, 4);
      result.shaderStorageImageExtendedFormats = decoder0.readBoolean(11, 5);
      result.shaderStorageImageMultisample = decoder0.readBoolean(11, 6);
      result.shaderStorageImageReadWithoutFormat = decoder0.readBoolean(11, 7);
      result.shaderStorageImageWriteWithoutFormat = decoder0.readBoolean(12, 0);
      result.shaderUniformBufferArrayDynamicIndexing = decoder0.readBoolean(12, 1);
      result.shaderSampledImageArrayDynamicIndexing = decoder0.readBoolean(12, 2);
      result.shaderStorageBufferArrayDynamicIndexing = decoder0.readBoolean(12, 3);
      result.shaderStorageImageArrayDynamicIndexing = decoder0.readBoolean(12, 4);
      result.shaderClipDistance = decoder0.readBoolean(12, 5);
      result.shaderCullDistance = decoder0.readBoolean(12, 6);
      result.shaderFloat64 = decoder0.readBoolean(12, 7);
      result.shaderInt64 = decoder0.readBoolean(13, 0);
      result.shaderInt16 = decoder0.readBoolean(13, 1);
      result.shaderResourceResidency = decoder0.readBoolean(13, 2);
      result.shaderResourceMinLod = decoder0.readBoolean(13, 3);
      result.sparseBinding = decoder0.readBoolean(13, 4);
      result.sparseResidencyBuffer = decoder0.readBoolean(13, 5);
      result.sparseResidencyImage2D = decoder0.readBoolean(13, 6);
      result.sparseResidencyImage3D = decoder0.readBoolean(13, 7);
      result.sparseResidency2Samples = decoder0.readBoolean(14, 0);
      result.sparseResidency4Samples = decoder0.readBoolean(14, 1);
      result.sparseResidency8Samples = decoder0.readBoolean(14, 2);
      result.sparseResidency16Samples = decoder0.readBoolean(14, 3);
      result.sparseResidencyAliased = decoder0.readBoolean(14, 4);
      result.variableMultisampleRate = decoder0.readBoolean(14, 5);
      result.inheritedQueries = decoder0.readBoolean(14, 6);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.robustBufferAccess, 8, 0);
    encoder0.encode(this.fullDrawIndexUint32, 8, 1);
    encoder0.encode(this.imageCubeArray, 8, 2);
    encoder0.encode(this.independentBlend, 8, 3);
    encoder0.encode(this.geometryShader, 8, 4);
    encoder0.encode(this.tessellationShader, 8, 5);
    encoder0.encode(this.sampleRateShading, 8, 6);
    encoder0.encode(this.dualSrcBlend, 8, 7);
    encoder0.encode(this.logicOp, 9, 0);
    encoder0.encode(this.multiDrawIndirect, 9, 1);
    encoder0.encode(this.drawIndirectFirstInstance, 9, 2);
    encoder0.encode(this.depthClamp, 9, 3);
    encoder0.encode(this.depthBiasClamp, 9, 4);
    encoder0.encode(this.fillModeNonSolid, 9, 5);
    encoder0.encode(this.depthBounds, 9, 6);
    encoder0.encode(this.wideLines, 9, 7);
    encoder0.encode(this.largePoints, 10, 0);
    encoder0.encode(this.alphaToOne, 10, 1);
    encoder0.encode(this.multiViewport, 10, 2);
    encoder0.encode(this.samplerAnisotropy, 10, 3);
    encoder0.encode(this.textureCompressionEtc2, 10, 4);
    encoder0.encode(this.textureCompressionAstcLdr, 10, 5);
    encoder0.encode(this.textureCompressionBc, 10, 6);
    encoder0.encode(this.occlusionQueryPrecise, 10, 7);
    encoder0.encode(this.pipelineStatisticsQuery, 11, 0);
    encoder0.encode(this.vertexPipelineStoresAndAtomics, 11, 1);
    encoder0.encode(this.fragmentStoresAndAtomics, 11, 2);
    encoder0.encode(this.shaderTessellationAndGeometryPointSize, 11, 3);
    encoder0.encode(this.shaderImageGatherExtended, 11, 4);
    encoder0.encode(this.shaderStorageImageExtendedFormats, 11, 5);
    encoder0.encode(this.shaderStorageImageMultisample, 11, 6);
    encoder0.encode(this.shaderStorageImageReadWithoutFormat, 11, 7);
    encoder0.encode(this.shaderStorageImageWriteWithoutFormat, 12, 0);
    encoder0.encode(this.shaderUniformBufferArrayDynamicIndexing, 12, 1);
    encoder0.encode(this.shaderSampledImageArrayDynamicIndexing, 12, 2);
    encoder0.encode(this.shaderStorageBufferArrayDynamicIndexing, 12, 3);
    encoder0.encode(this.shaderStorageImageArrayDynamicIndexing, 12, 4);
    encoder0.encode(this.shaderClipDistance, 12, 5);
    encoder0.encode(this.shaderCullDistance, 12, 6);
    encoder0.encode(this.shaderFloat64, 12, 7);
    encoder0.encode(this.shaderInt64, 13, 0);
    encoder0.encode(this.shaderInt16, 13, 1);
    encoder0.encode(this.shaderResourceResidency, 13, 2);
    encoder0.encode(this.shaderResourceMinLod, 13, 3);
    encoder0.encode(this.sparseBinding, 13, 4);
    encoder0.encode(this.sparseResidencyBuffer, 13, 5);
    encoder0.encode(this.sparseResidencyImage2D, 13, 6);
    encoder0.encode(this.sparseResidencyImage3D, 13, 7);
    encoder0.encode(this.sparseResidency2Samples, 14, 0);
    encoder0.encode(this.sparseResidency4Samples, 14, 1);
    encoder0.encode(this.sparseResidency8Samples, 14, 2);
    encoder0.encode(this.sparseResidency16Samples, 14, 3);
    encoder0.encode(this.sparseResidencyAliased, 14, 4);
    encoder0.encode(this.variableMultisampleRate, 14, 5);
    encoder0.encode(this.inheritedQueries, 14, 6);
  }
}
