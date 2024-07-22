package org.chromium.gfx.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;
import org.chromium.mojo_base.mojom.UnsafeSharedMemoryRegion;

public final class GpuMemoryBufferPlatformHandle extends Union {

  private AHardwareBufferHandle mAndroidHardwareBufferHandle;
  private UnsafeSharedMemoryRegion mSharedMemoryHandle;

  public static final class Tag {
    public static final int AndroidHardwareBufferHandle = 1;
    public static final int SharedMemoryHandle = 0;
  }

  public void setSharedMemoryHandle(UnsafeSharedMemoryRegion sharedMemoryHandle) {
    this.mTag = 0;
    this.mSharedMemoryHandle = sharedMemoryHandle;
  }

  public UnsafeSharedMemoryRegion getSharedMemoryHandle() {
    if (this.mTag != 0) {
      throw new AssertionError();
    }
    return this.mSharedMemoryHandle;
  }

  public void setAndroidHardwareBufferHandle(AHardwareBufferHandle androidHardwareBufferHandle) {
    this.mTag = 1;
    this.mAndroidHardwareBufferHandle = androidHardwareBufferHandle;
  }

  public AHardwareBufferHandle getAndroidHardwareBufferHandle() {
    if (this.mTag != 1) {
      throw new AssertionError();
    }
    return this.mAndroidHardwareBufferHandle;
  }

  @Override
  public final void encode(Encoder encoder0, int offset) {
    encoder0.encode(16, offset);
    encoder0.encode(this.mTag, offset + 4);
    switch (this.mTag) {
      case 0:
        encoder0.encode((Struct) this.mSharedMemoryHandle, offset + 8, false);
        return;
      case 1:
        encoder0.encode((Struct) this.mAndroidHardwareBufferHandle, offset + 8, false);
        return;
      default:
        return;
    }
  }

  public static GpuMemoryBufferPlatformHandle deserialize(Message message) {
    return decode(new Decoder(message).decoderForSerializedUnion(), 0);
  }

  public static final GpuMemoryBufferPlatformHandle decode(Decoder decoder0, int offset) {
    DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
    if (dataHeader.size == 0) {
      return null;
    }
    GpuMemoryBufferPlatformHandle result = new GpuMemoryBufferPlatformHandle();
    switch (dataHeader.elementsOrVersion) {
      case 0:
        Decoder decoder1 = decoder0.readPointer(offset + 8, false);
        result.mSharedMemoryHandle = UnsafeSharedMemoryRegion.decode(decoder1);
        result.mTag = 0;
        break;
      case 1:
        Decoder decoder12 = decoder0.readPointer(offset + 8, false);
        result.mAndroidHardwareBufferHandle = AHardwareBufferHandle.decode(decoder12);
        result.mTag = 1;
        break;
    }
    return result;
  }
}
