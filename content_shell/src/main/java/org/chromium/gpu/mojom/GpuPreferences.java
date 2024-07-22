package org.chromium.gpu.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.BufferUsageAndFormat;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class GpuPreferences extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 88;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean compileShaderAlwaysSucceeds;
  public boolean disableAcceleratedVideoDecode;
  public boolean disableAcceleratedVideoEncode;
  public boolean disableBiplanarGpuMemoryBuffersForVideoFrames;
  public boolean disableGlErrorLimit;
  public boolean disableGlslTranslator;
  public boolean disableGpuProgramCache;
  public boolean disableGpuShaderDiskCache;
  public boolean disableGpuWatchdog;
  public boolean disableShaderNameHashing;
  public boolean disableSoftwareRasterizer;
  public boolean disableVulkanFallbackToGlForTesting;
  public boolean disableVulkanSurface;
  public String[] disabledDawnFeaturesList;
  public boolean enableAndroidSurfaceControl;
  public int enableDawnBackendValidation;
  public boolean enableGpuBenchmarkingExtension;
  public boolean enableGpuCommandLogging;
  public boolean enableGpuDebugging;
  public boolean enableGpuDriverDebugLogging;
  public boolean enableGpuServiceLogging;
  public boolean enableGpuServiceLoggingGpu;
  public boolean enableGpuServiceTracing;
  public boolean enableLowLatencyDxva;
  public boolean enableNativeGpuMemoryBuffers;
  public boolean enableNv12DxgiVideo;
  public boolean enablePerfDataCollection;
  public boolean enableThreadedTextureMailboxes;
  public boolean enableUnsafeWebgpu;
  public boolean enableVulkanProtectedMemory;
  public boolean enableWebgpu;
  public boolean enableWebgpuDeveloperFeatures;
  public boolean enableWebgpuExperimentalFeatures;
  public boolean enableZeroCopyDxgiVideo;
  public String[] enabledDawnFeaturesList;
  public boolean enforceGlMinimums;
  public int forceGpuMemAvailableBytes;
  public int forceGpuMemDiscardableLimitBytes;
  public int forceMaxTextureSize;
  public boolean forceSeparateEglDisplayForWebglTesting;
  public boolean forceWebgpuCompat;
  public boolean glShaderIntermOutput;
  public int gpuProgramCacheSize;
  public boolean gpuSandboxStartEarly;
  public boolean gpuStartupDialog;
  public int grContextType;
  public boolean ignoreGpuBlocklist;
  public boolean logGpuControlListDecisions;
  public BufferUsageAndFormat[] textureTargetExceptionList;
  public boolean usePassthroughCmdDecoder;
  public int useVulkan;
  public int useWebgpuAdapter;
  public int useWebgpuPowerPreference;
  public int vulkanHeapMemoryLimit;
  public int vulkanSyncCpuMemoryLimit;
  public boolean watchdogStartsBackgrounded;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(88, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private GpuPreferences(int version) {
    super(88, version);
  }

  public GpuPreferences() {
    this(0);
  }

  public static GpuPreferences deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static GpuPreferences deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static GpuPreferences decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      GpuPreferences result = new GpuPreferences(elementsOrVersion);
      int i = 8;
      result.disableAcceleratedVideoDecode = decoder0.readBoolean(8, 0);
      result.disableAcceleratedVideoEncode = decoder0.readBoolean(8, 1);
      result.gpuStartupDialog = decoder0.readBoolean(8, 2);
      result.disableGpuWatchdog = decoder0.readBoolean(8, 3);
      result.gpuSandboxStartEarly = decoder0.readBoolean(8, 4);
      result.enableLowLatencyDxva = decoder0.readBoolean(8, 5);
      result.enableZeroCopyDxgiVideo = decoder0.readBoolean(8, 6);
      result.enableNv12DxgiVideo = decoder0.readBoolean(8, 7);
      result.disableSoftwareRasterizer = decoder0.readBoolean(9, 0);
      result.logGpuControlListDecisions = decoder0.readBoolean(9, 1);
      result.compileShaderAlwaysSucceeds = decoder0.readBoolean(9, 2);
      result.disableGlErrorLimit = decoder0.readBoolean(9, 3);
      result.disableGlslTranslator = decoder0.readBoolean(9, 4);
      result.disableShaderNameHashing = decoder0.readBoolean(9, 5);
      result.enableGpuCommandLogging = decoder0.readBoolean(9, 6);
      result.enableGpuDebugging = decoder0.readBoolean(9, 7);
      result.enableGpuServiceLoggingGpu = decoder0.readBoolean(10, 0);
      result.enableGpuDriverDebugLogging = decoder0.readBoolean(10, 1);
      result.disableGpuProgramCache = decoder0.readBoolean(10, 2);
      result.enforceGlMinimums = decoder0.readBoolean(10, 3);
      result.disableGpuShaderDiskCache = decoder0.readBoolean(10, 4);
      result.enableThreadedTextureMailboxes = decoder0.readBoolean(10, 5);
      result.glShaderIntermOutput = decoder0.readBoolean(10, 6);
      result.enableAndroidSurfaceControl = decoder0.readBoolean(10, 7);
      result.enableGpuServiceLogging = decoder0.readBoolean(11, 0);
      result.enableGpuServiceTracing = decoder0.readBoolean(11, 1);
      result.usePassthroughCmdDecoder = decoder0.readBoolean(11, 2);
      result.disableBiplanarGpuMemoryBuffersForVideoFrames = decoder0.readBoolean(11, 3);
      result.ignoreGpuBlocklist = decoder0.readBoolean(11, 4);
      result.watchdogStartsBackgrounded = decoder0.readBoolean(11, 5);
      result.enableVulkanProtectedMemory = decoder0.readBoolean(11, 6);
      result.disableVulkanSurface = decoder0.readBoolean(11, 7);
      result.forceGpuMemAvailableBytes = decoder0.readInt(12);
      result.forceGpuMemDiscardableLimitBytes = decoder0.readInt(16);
      result.forceMaxTextureSize = decoder0.readInt(20);
      result.gpuProgramCacheSize = decoder0.readInt(24);
      int readInt = decoder0.readInt(28);
      result.grContextType = readInt;
      GrContextType.validate(readInt);
      result.grContextType = GrContextType.toKnownValue(result.grContextType);
      Decoder decoder1 = decoder0.readPointer(32, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.textureTargetExceptionList = new BufferUsageAndFormat[si1.elementsOrVersion];
      int i1 = 0;
      while (i1 < si1.elementsOrVersion) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + i, false);
        result.textureTargetExceptionList[i1] = BufferUsageAndFormat.decode(decoder2);
        i1++;
        i = 8;
      }
      int readInt2 = decoder0.readInt(40);
      result.useVulkan = readInt2;
      VulkanImplementationName.validate(readInt2);
      result.useVulkan = VulkanImplementationName.toKnownValue(result.useVulkan);
      result.disableVulkanFallbackToGlForTesting = decoder0.readBoolean(44, 0);
      result.enableGpuBenchmarkingExtension = decoder0.readBoolean(44, 1);
      result.enableWebgpu = decoder0.readBoolean(44, 2);
      result.enableUnsafeWebgpu = decoder0.readBoolean(44, 3);
      result.enableWebgpuDeveloperFeatures = decoder0.readBoolean(44, 4);
      result.enableWebgpuExperimentalFeatures = decoder0.readBoolean(44, 5);
      result.forceWebgpuCompat = decoder0.readBoolean(44, 6);
      result.enablePerfDataCollection = decoder0.readBoolean(44, 7);
      result.enableNativeGpuMemoryBuffers = decoder0.readBoolean(45, 0);
      result.forceSeparateEglDisplayForWebglTesting = decoder0.readBoolean(45, 1);
      result.vulkanHeapMemoryLimit = decoder0.readInt(48);
      result.vulkanSyncCpuMemoryLimit = decoder0.readInt(52);
      int readInt3 = decoder0.readInt(56);
      result.useWebgpuAdapter = readInt3;
      WebGpuAdapterName.validate(readInt3);
      result.useWebgpuAdapter = WebGpuAdapterName.toKnownValue(result.useWebgpuAdapter);
      int readInt4 = decoder0.readInt(60);
      result.useWebgpuPowerPreference = readInt4;
      WebGpuPowerPreference.validate(readInt4);
      result.useWebgpuPowerPreference =
          WebGpuPowerPreference.toKnownValue(result.useWebgpuPowerPreference);
      int readInt5 = decoder0.readInt(64);
      result.enableDawnBackendValidation = readInt5;
      DawnBackendValidationLevel.validate(readInt5);
      result.enableDawnBackendValidation =
          DawnBackendValidationLevel.toKnownValue(result.enableDawnBackendValidation);
      Decoder decoder12 = decoder0.readPointer(72, false);
      DataHeader si12 = decoder12.readDataHeaderForPointerArray(-1);
      result.enabledDawnFeaturesList = new String[si12.elementsOrVersion];
      for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
        result.enabledDawnFeaturesList[i12] = decoder12.readString((i12 * 8) + 8, false);
      }
      Decoder decoder13 = decoder0.readPointer(80, false);
      DataHeader si13 = decoder13.readDataHeaderForPointerArray(-1);
      result.disabledDawnFeaturesList = new String[si13.elementsOrVersion];
      for (int i13 = 0; i13 < si13.elementsOrVersion; i13++) {
        result.disabledDawnFeaturesList[i13] = decoder13.readString((i13 * 8) + 8, false);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.disableAcceleratedVideoDecode, 8, 0);
    encoder0.encode(this.disableAcceleratedVideoEncode, 8, 1);
    encoder0.encode(this.gpuStartupDialog, 8, 2);
    encoder0.encode(this.disableGpuWatchdog, 8, 3);
    encoder0.encode(this.gpuSandboxStartEarly, 8, 4);
    encoder0.encode(this.enableLowLatencyDxva, 8, 5);
    encoder0.encode(this.enableZeroCopyDxgiVideo, 8, 6);
    encoder0.encode(this.enableNv12DxgiVideo, 8, 7);
    encoder0.encode(this.disableSoftwareRasterizer, 9, 0);
    encoder0.encode(this.logGpuControlListDecisions, 9, 1);
    encoder0.encode(this.compileShaderAlwaysSucceeds, 9, 2);
    encoder0.encode(this.disableGlErrorLimit, 9, 3);
    encoder0.encode(this.disableGlslTranslator, 9, 4);
    encoder0.encode(this.disableShaderNameHashing, 9, 5);
    encoder0.encode(this.enableGpuCommandLogging, 9, 6);
    encoder0.encode(this.enableGpuDebugging, 9, 7);
    encoder0.encode(this.enableGpuServiceLoggingGpu, 10, 0);
    encoder0.encode(this.enableGpuDriverDebugLogging, 10, 1);
    encoder0.encode(this.disableGpuProgramCache, 10, 2);
    encoder0.encode(this.enforceGlMinimums, 10, 3);
    encoder0.encode(this.disableGpuShaderDiskCache, 10, 4);
    encoder0.encode(this.enableThreadedTextureMailboxes, 10, 5);
    encoder0.encode(this.glShaderIntermOutput, 10, 6);
    encoder0.encode(this.enableAndroidSurfaceControl, 10, 7);
    encoder0.encode(this.enableGpuServiceLogging, 11, 0);
    encoder0.encode(this.enableGpuServiceTracing, 11, 1);
    encoder0.encode(this.usePassthroughCmdDecoder, 11, 2);
    encoder0.encode(this.disableBiplanarGpuMemoryBuffersForVideoFrames, 11, 3);
    encoder0.encode(this.ignoreGpuBlocklist, 11, 4);
    encoder0.encode(this.watchdogStartsBackgrounded, 11, 5);
    encoder0.encode(this.enableVulkanProtectedMemory, 11, 6);
    encoder0.encode(this.disableVulkanSurface, 11, 7);
    encoder0.encode(this.forceGpuMemAvailableBytes, 12);
    encoder0.encode(this.forceGpuMemDiscardableLimitBytes, 16);
    encoder0.encode(this.forceMaxTextureSize, 20);
    encoder0.encode(this.gpuProgramCacheSize, 24);
    encoder0.encode(this.grContextType, 28);
    BufferUsageAndFormat[] bufferUsageAndFormatArr = this.textureTargetExceptionList;
    if (bufferUsageAndFormatArr == null) {
      encoder0.encodeNullPointer(32, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(bufferUsageAndFormatArr.length, 32, -1);
      int i0 = 0;
      while (true) {
        BufferUsageAndFormat[] bufferUsageAndFormatArr2 = this.textureTargetExceptionList;
        if (i0 >= bufferUsageAndFormatArr2.length) {
          break;
        }
        encoder1.encode((Struct) bufferUsageAndFormatArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    encoder0.encode(this.useVulkan, 40);
    encoder0.encode(this.disableVulkanFallbackToGlForTesting, 44, 0);
    encoder0.encode(this.enableGpuBenchmarkingExtension, 44, 1);
    encoder0.encode(this.enableWebgpu, 44, 2);
    encoder0.encode(this.enableUnsafeWebgpu, 44, 3);
    encoder0.encode(this.enableWebgpuDeveloperFeatures, 44, 4);
    encoder0.encode(this.enableWebgpuExperimentalFeatures, 44, 5);
    encoder0.encode(this.forceWebgpuCompat, 44, 6);
    encoder0.encode(this.enablePerfDataCollection, 44, 7);
    encoder0.encode(this.enableNativeGpuMemoryBuffers, 45, 0);
    encoder0.encode(this.forceSeparateEglDisplayForWebglTesting, 45, 1);
    encoder0.encode(this.vulkanHeapMemoryLimit, 48);
    encoder0.encode(this.vulkanSyncCpuMemoryLimit, 52);
    encoder0.encode(this.useWebgpuAdapter, 56);
    encoder0.encode(this.useWebgpuPowerPreference, 60);
    encoder0.encode(this.enableDawnBackendValidation, 64);
    String[] strArr = this.enabledDawnFeaturesList;
    if (strArr == null) {
      encoder0.encodeNullPointer(72, false);
    } else {
      Encoder encoder12 = encoder0.encodePointerArray(strArr.length, 72, -1);
      int i02 = 0;
      while (true) {
        String[] strArr2 = this.enabledDawnFeaturesList;
        if (i02 >= strArr2.length) {
          break;
        }
        encoder12.encode(strArr2[i02], (i02 * 8) + 8, false);
        i02++;
      }
    }
    String[] strArr3 = this.disabledDawnFeaturesList;
    if (strArr3 == null) {
      encoder0.encodeNullPointer(80, false);
      return;
    }
    Encoder encoder13 = encoder0.encodePointerArray(strArr3.length, 80, -1);
    int i03 = 0;
    while (true) {
      String[] strArr4 = this.disabledDawnFeaturesList;
      if (i03 < strArr4.length) {
        encoder13.encode(strArr4[i03], (i03 * 8) + 8, false);
        i03++;
      } else {
        return;
      }
    }
  }
}
