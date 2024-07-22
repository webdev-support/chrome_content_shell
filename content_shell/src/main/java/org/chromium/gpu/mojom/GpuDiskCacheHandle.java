package org.chromium.gpu.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

public final class GpuDiskCacheHandle extends Union {

  private GpuDiskCacheDawnWebGpuHandle mDawnWebgpuHandle;
  private GpuDiskCacheGlShaderHandle mGlShaderHandle;

  public static final class Tag {
    public static final int DawnWebgpuHandle = 1;
    public static final int GlShaderHandle = 0;
  }

  public void setGlShaderHandle(GpuDiskCacheGlShaderHandle glShaderHandle) {
    this.mTag = 0;
    this.mGlShaderHandle = glShaderHandle;
  }

  public GpuDiskCacheGlShaderHandle getGlShaderHandle() {
    if (this.mTag != 0) {
      throw new AssertionError();
    }
    return this.mGlShaderHandle;
  }

  public void setDawnWebgpuHandle(GpuDiskCacheDawnWebGpuHandle dawnWebgpuHandle) {
    this.mTag = 1;
    this.mDawnWebgpuHandle = dawnWebgpuHandle;
  }

  public GpuDiskCacheDawnWebGpuHandle getDawnWebgpuHandle() {
    if (this.mTag != 1) {
      throw new AssertionError();
    }
    return this.mDawnWebgpuHandle;
  }

  @Override
  public final void encode(Encoder encoder0, int offset) {
    encoder0.encode(16, offset);
    encoder0.encode(this.mTag, offset + 4);
    switch (this.mTag) {
      case 0:
        encoder0.encode((Struct) this.mGlShaderHandle, offset + 8, false);
        return;
      case 1:
        encoder0.encode((Struct) this.mDawnWebgpuHandle, offset + 8, false);
        return;
      default:
        return;
    }
  }

  public static GpuDiskCacheHandle deserialize(Message message) {
    return decode(new Decoder(message).decoderForSerializedUnion(), 0);
  }

  public static final GpuDiskCacheHandle decode(Decoder decoder0, int offset) {
    DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
    if (dataHeader.size == 0) {
      return null;
    }
    GpuDiskCacheHandle result = new GpuDiskCacheHandle();
    switch (dataHeader.elementsOrVersion) {
      case 0:
        Decoder decoder1 = decoder0.readPointer(offset + 8, false);
        result.mGlShaderHandle = GpuDiskCacheGlShaderHandle.decode(decoder1);
        result.mTag = 0;
        break;
      case 1:
        Decoder decoder12 = decoder0.readPointer(offset + 8, false);
        result.mDawnWebgpuHandle = GpuDiskCacheDawnWebGpuHandle.decode(decoder12);
        result.mTag = 1;
        break;
    }
    return result;
  }
}
