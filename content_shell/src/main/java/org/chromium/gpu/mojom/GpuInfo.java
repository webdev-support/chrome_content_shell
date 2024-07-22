package org.chromium.gpu.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gl.mojom.GlImplementationParts;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.TimeDelta;

public final class GpuInfo extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 200;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean amdSwitchable;
  public boolean canSupportThreadedTextureMailbox;
  public String directRenderingVersion;
  public String displayType;
  public String glExtensions;
  public GlImplementationParts glImplementationParts;
  public String glRenderer;
  public int glResetNotificationStrategy;
  public String glVendor;
  public String glVersion;
  public String glWsExtensions;
  public String glWsVendor;
  public String glWsVersion;
  public GpuDevice gpu;
  public ImageDecodeAcceleratorSupportedProfile[] imageDecodeAcceleratorSupportedProfiles;
  public boolean inProcessGpu;
  public TimeDelta initializationTime;
  public boolean jpegDecodeAcceleratorSupported;
  public String machineModelName;
  public String machineModelVersion;
  public String maxMsaaSamples;
  public boolean optimus;
  public boolean passthroughCmdDecoder;
  public String pixelShaderVersion;
  public boolean sandboxed;
  public GpuDevice[] secondaryGpus;
  public boolean subpixelFontRendering;
  public String vertexShaderVersion;
  public VideoDecodeAcceleratorSupportedProfile[] videoDecodeAcceleratorSupportedProfiles;
  public VideoEncodeAcceleratorSupportedProfile[] videoEncodeAcceleratorSupportedProfiles;
  public int visibilityCallbackCallCount;
  public VulkanInfo vulkanInfo;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(200, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private GpuInfo(int version) {
    super(200, version);
  }

  public GpuInfo() {
    this(0);
  }

  public static GpuInfo deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static GpuInfo deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static GpuInfo decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      GpuInfo result = new GpuInfo(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.initializationTime = TimeDelta.decode(decoder1);
      result.optimus = decoder0.readBoolean(16, 0);
      result.amdSwitchable = decoder0.readBoolean(16, 1);
      result.sandboxed = decoder0.readBoolean(16, 2);
      result.inProcessGpu = decoder0.readBoolean(16, 3);
      result.passthroughCmdDecoder = decoder0.readBoolean(16, 4);
      result.canSupportThreadedTextureMailbox = decoder0.readBoolean(16, 5);
      result.jpegDecodeAcceleratorSupported = decoder0.readBoolean(16, 6);
      result.subpixelFontRendering = decoder0.readBoolean(16, 7);
      result.glResetNotificationStrategy = decoder0.readInt(20);
      Decoder decoder12 = decoder0.readPointer(24, false);
      result.gpu = GpuDevice.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(32, false);
      DataHeader si1 = decoder13.readDataHeaderForPointerArray(-1);
      result.secondaryGpus = new GpuDevice[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder13.readPointer((i1 * 8) + 8, false);
        result.secondaryGpus[i1] = GpuDevice.decode(decoder2);
      }
      result.pixelShaderVersion = decoder0.readString(40, false);
      result.vertexShaderVersion = decoder0.readString(48, false);
      result.maxMsaaSamples = decoder0.readString(56, false);
      result.machineModelName = decoder0.readString(64, false);
      result.machineModelVersion = decoder0.readString(72, false);
      result.displayType = decoder0.readString(80, false);
      result.glVersion = decoder0.readString(88, false);
      result.glVendor = decoder0.readString(96, false);
      result.glRenderer = decoder0.readString(104, false);
      result.glExtensions = decoder0.readString(112, false);
      result.glWsVendor = decoder0.readString(120, false);
      result.glWsVersion = decoder0.readString(128, false);
      result.glWsExtensions = decoder0.readString(136, false);
      Decoder decoder14 = decoder0.readPointer(144, false);
      result.glImplementationParts = GlImplementationParts.decode(decoder14);
      result.directRenderingVersion = decoder0.readString(152, false);
      Decoder decoder15 = decoder0.readPointer(160, false);
      DataHeader si12 = decoder15.readDataHeaderForPointerArray(-1);
      result.videoDecodeAcceleratorSupportedProfiles =
          new VideoDecodeAcceleratorSupportedProfile[si12.elementsOrVersion];
      for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
        Decoder decoder22 = decoder15.readPointer((i12 * 8) + 8, false);
        result.videoDecodeAcceleratorSupportedProfiles[i12] =
            VideoDecodeAcceleratorSupportedProfile.decode(decoder22);
      }
      Decoder decoder16 = decoder0.readPointer(168, false);
      DataHeader si13 = decoder16.readDataHeaderForPointerArray(-1);
      result.videoEncodeAcceleratorSupportedProfiles =
          new VideoEncodeAcceleratorSupportedProfile[si13.elementsOrVersion];
      for (int i13 = 0; i13 < si13.elementsOrVersion; i13++) {
        Decoder decoder23 = decoder16.readPointer((i13 * 8) + 8, false);
        result.videoEncodeAcceleratorSupportedProfiles[i13] =
            VideoEncodeAcceleratorSupportedProfile.decode(decoder23);
      }
      Decoder decoder17 = decoder0.readPointer(176, false);
      DataHeader si14 = decoder17.readDataHeaderForPointerArray(-1);
      result.imageDecodeAcceleratorSupportedProfiles =
          new ImageDecodeAcceleratorSupportedProfile[si14.elementsOrVersion];
      for (int i14 = 0; i14 < si14.elementsOrVersion; i14++) {
        Decoder decoder24 = decoder17.readPointer((i14 * 8) + 8, false);
        result.imageDecodeAcceleratorSupportedProfiles[i14] =
            ImageDecodeAcceleratorSupportedProfile.decode(decoder24);
      }
      result.visibilityCallbackCallCount = decoder0.readInt(184);
      Decoder decoder18 = decoder0.readPointer(192, true);
      result.vulkanInfo = VulkanInfo.decode(decoder18);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.initializationTime, 8, false);
    encoder0.encode(this.optimus, 16, 0);
    encoder0.encode(this.amdSwitchable, 16, 1);
    encoder0.encode(this.sandboxed, 16, 2);
    encoder0.encode(this.inProcessGpu, 16, 3);
    encoder0.encode(this.passthroughCmdDecoder, 16, 4);
    encoder0.encode(this.canSupportThreadedTextureMailbox, 16, 5);
    encoder0.encode(this.jpegDecodeAcceleratorSupported, 16, 6);
    encoder0.encode(this.subpixelFontRendering, 16, 7);
    encoder0.encode(this.glResetNotificationStrategy, 20);
    encoder0.encode((Struct) this.gpu, 24, false);
    GpuDevice[] gpuDeviceArr = this.secondaryGpus;
    if (gpuDeviceArr == null) {
      encoder0.encodeNullPointer(32, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(gpuDeviceArr.length, 32, -1);
      int i0 = 0;
      while (true) {
        GpuDevice[] gpuDeviceArr2 = this.secondaryGpus;
        if (i0 >= gpuDeviceArr2.length) {
          break;
        }
        encoder1.encode((Struct) gpuDeviceArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    encoder0.encode(this.pixelShaderVersion, 40, false);
    encoder0.encode(this.vertexShaderVersion, 48, false);
    encoder0.encode(this.maxMsaaSamples, 56, false);
    encoder0.encode(this.machineModelName, 64, false);
    encoder0.encode(this.machineModelVersion, 72, false);
    encoder0.encode(this.displayType, 80, false);
    encoder0.encode(this.glVersion, 88, false);
    encoder0.encode(this.glVendor, 96, false);
    encoder0.encode(this.glRenderer, 104, false);
    encoder0.encode(this.glExtensions, 112, false);
    encoder0.encode(this.glWsVendor, 120, false);
    encoder0.encode(this.glWsVersion, 128, false);
    encoder0.encode(this.glWsExtensions, 136, false);
    encoder0.encode((Struct) this.glImplementationParts, 144, false);
    encoder0.encode(this.directRenderingVersion, 152, false);
    VideoDecodeAcceleratorSupportedProfile[] videoDecodeAcceleratorSupportedProfileArr =
        this.videoDecodeAcceleratorSupportedProfiles;
    if (videoDecodeAcceleratorSupportedProfileArr == null) {
      encoder0.encodeNullPointer(160, false);
    } else {
      Encoder encoder12 =
          encoder0.encodePointerArray(videoDecodeAcceleratorSupportedProfileArr.length, 160, -1);
      int i02 = 0;
      while (true) {
        VideoDecodeAcceleratorSupportedProfile[] videoDecodeAcceleratorSupportedProfileArr2 =
            this.videoDecodeAcceleratorSupportedProfiles;
        if (i02 >= videoDecodeAcceleratorSupportedProfileArr2.length) {
          break;
        }
        encoder12.encode(
            (Struct) videoDecodeAcceleratorSupportedProfileArr2[i02], (i02 * 8) + 8, false);
        i02++;
      }
    }
    VideoEncodeAcceleratorSupportedProfile[] videoEncodeAcceleratorSupportedProfileArr =
        this.videoEncodeAcceleratorSupportedProfiles;
    if (videoEncodeAcceleratorSupportedProfileArr == null) {
      encoder0.encodeNullPointer(168, false);
    } else {
      Encoder encoder13 =
          encoder0.encodePointerArray(videoEncodeAcceleratorSupportedProfileArr.length, 168, -1);
      int i03 = 0;
      while (true) {
        VideoEncodeAcceleratorSupportedProfile[] videoEncodeAcceleratorSupportedProfileArr2 =
            this.videoEncodeAcceleratorSupportedProfiles;
        if (i03 >= videoEncodeAcceleratorSupportedProfileArr2.length) {
          break;
        }
        encoder13.encode(
            (Struct) videoEncodeAcceleratorSupportedProfileArr2[i03], (i03 * 8) + 8, false);
        i03++;
      }
    }
    ImageDecodeAcceleratorSupportedProfile[] imageDecodeAcceleratorSupportedProfileArr =
        this.imageDecodeAcceleratorSupportedProfiles;
    if (imageDecodeAcceleratorSupportedProfileArr == null) {
      encoder0.encodeNullPointer(176, false);
    } else {
      Encoder encoder14 =
          encoder0.encodePointerArray(imageDecodeAcceleratorSupportedProfileArr.length, 176, -1);
      int i04 = 0;
      while (true) {
        ImageDecodeAcceleratorSupportedProfile[] imageDecodeAcceleratorSupportedProfileArr2 =
            this.imageDecodeAcceleratorSupportedProfiles;
        if (i04 >= imageDecodeAcceleratorSupportedProfileArr2.length) {
          break;
        }
        encoder14.encode(
            (Struct) imageDecodeAcceleratorSupportedProfileArr2[i04], (i04 * 8) + 8, false);
        i04++;
      }
    }
    encoder0.encode(this.visibilityCallbackCallCount, 184);
    encoder0.encode((Struct) this.vulkanInfo, 192, true);
  }
}
