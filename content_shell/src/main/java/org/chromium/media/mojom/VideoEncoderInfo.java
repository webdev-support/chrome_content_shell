package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class VideoEncoderInfo extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 48;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean applyAlignmentToAllSimulcastLayers;
  public byte[][] fpsAllocation;
  public int frameDelay;
  public boolean hasFrameDelay;
  public boolean hasInputCapacity;
  public boolean hasTrustedRateController;
  public String implementationName;
  public int inputCapacity;
  public boolean isHardwareAccelerated;
  public boolean reportsAverageQp;
  public int requestedResolutionAlignment;
  public ResolutionBitrateLimit[] resolutionBitrateLimits;
  public boolean supportsFrameSizeChange;
  public boolean supportsNativeHandle;
  public boolean supportsSimulcast;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(48, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private VideoEncoderInfo(int version) {
    super(48, version);
    this.hasFrameDelay = false;
    this.hasInputCapacity = false;
    this.supportsFrameSizeChange = false;
  }

  public VideoEncoderInfo() {
    this(0);
  }

  public static VideoEncoderInfo deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static VideoEncoderInfo deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static VideoEncoderInfo decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      VideoEncoderInfo result = new VideoEncoderInfo(elementsOrVersion);
      result.implementationName = decoder0.readString(8, false);
      result.hasFrameDelay = decoder0.readBoolean(16, 0);
      result.hasInputCapacity = decoder0.readBoolean(16, 1);
      result.supportsNativeHandle = decoder0.readBoolean(16, 2);
      result.hasTrustedRateController = decoder0.readBoolean(16, 3);
      result.isHardwareAccelerated = decoder0.readBoolean(16, 4);
      result.supportsSimulcast = decoder0.readBoolean(16, 5);
      result.reportsAverageQp = decoder0.readBoolean(16, 6);
      result.applyAlignmentToAllSimulcastLayers = decoder0.readBoolean(16, 7);
      result.supportsFrameSizeChange = decoder0.readBoolean(17, 0);
      result.frameDelay = decoder0.readInt(20);
      result.inputCapacity = decoder0.readInt(24);
      result.requestedResolutionAlignment = decoder0.readInt(28);
      Decoder decoder1 = decoder0.readPointer(32, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(5);
      result.fpsAllocation = new byte[si1.elementsOrVersion][];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        result.fpsAllocation[i1] = decoder1.readBytes((i1 * 8) + 8, 0, -1);
      }
      Decoder decoder12 = decoder0.readPointer(40, false);
      DataHeader si12 = decoder12.readDataHeaderForPointerArray(-1);
      result.resolutionBitrateLimits = new ResolutionBitrateLimit[si12.elementsOrVersion];
      for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
        Decoder decoder2 = decoder12.readPointer((i12 * 8) + 8, false);
        result.resolutionBitrateLimits[i12] = ResolutionBitrateLimit.decode(decoder2);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.implementationName, 8, false);
    encoder0.encode(this.hasFrameDelay, 16, 0);
    encoder0.encode(this.hasInputCapacity, 16, 1);
    encoder0.encode(this.supportsNativeHandle, 16, 2);
    encoder0.encode(this.hasTrustedRateController, 16, 3);
    encoder0.encode(this.isHardwareAccelerated, 16, 4);
    encoder0.encode(this.supportsSimulcast, 16, 5);
    encoder0.encode(this.reportsAverageQp, 16, 6);
    encoder0.encode(this.applyAlignmentToAllSimulcastLayers, 16, 7);
    encoder0.encode(this.supportsFrameSizeChange, 17, 0);
    encoder0.encode(this.frameDelay, 20);
    encoder0.encode(this.inputCapacity, 24);
    encoder0.encode(this.requestedResolutionAlignment, 28);
    byte[][] bArr = this.fpsAllocation;
    if (bArr == null) {
      encoder0.encodeNullPointer(32, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(bArr.length, 32, 5);
      int i0 = 0;
      while (true) {
        byte[][] bArr2 = this.fpsAllocation;
        if (i0 >= bArr2.length) {
          break;
        }
        encoder1.encode(bArr2[i0], (i0 * 8) + 8, 0, -1);
        i0++;
      }
    }
    ResolutionBitrateLimit[] resolutionBitrateLimitArr = this.resolutionBitrateLimits;
    if (resolutionBitrateLimitArr == null) {
      encoder0.encodeNullPointer(40, false);
      return;
    }
    Encoder encoder12 = encoder0.encodePointerArray(resolutionBitrateLimitArr.length, 40, -1);
    int i02 = 0;
    while (true) {
      ResolutionBitrateLimit[] resolutionBitrateLimitArr2 = this.resolutionBitrateLimits;
      if (i02 < resolutionBitrateLimitArr2.length) {
        encoder12.encode((Struct) resolutionBitrateLimitArr2[i02], (i02 * 8) + 8, false);
        i02++;
      } else {
        return;
      }
    }
  }
}
