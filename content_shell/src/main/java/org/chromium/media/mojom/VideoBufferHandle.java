package org.chromium.media.mojom;

import org.chromium.gfx.mojom.GpuMemoryBufferHandle;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;
import org.chromium.mojo_base.mojom.ReadOnlySharedMemoryRegion;
import org.chromium.mojo_base.mojom.UnsafeSharedMemoryRegion;

public final class VideoBufferHandle extends Union {

  private GpuMemoryBufferHandle mGpuMemoryBufferHandle;
  private MailboxBufferHandleSet mMailboxHandles;
  private ReadOnlySharedMemoryRegion mReadOnlyShmemRegion;
  private UnsafeSharedMemoryRegion mUnsafeShmemRegion;

  public static final class Tag {
    public static final int GpuMemoryBufferHandle = 3;
    public static final int MailboxHandles = 2;
    public static final int ReadOnlyShmemRegion = 1;
    public static final int UnsafeShmemRegion = 0;
  }

  public void setUnsafeShmemRegion(UnsafeSharedMemoryRegion unsafeShmemRegion) {
    this.mTag = 0;
    this.mUnsafeShmemRegion = unsafeShmemRegion;
  }

  public UnsafeSharedMemoryRegion getUnsafeShmemRegion() {
    if (this.mTag != 0) {
      throw new AssertionError();
    }
    return this.mUnsafeShmemRegion;
  }

  public void setReadOnlyShmemRegion(ReadOnlySharedMemoryRegion readOnlyShmemRegion) {
    this.mTag = 1;
    this.mReadOnlyShmemRegion = readOnlyShmemRegion;
  }

  public ReadOnlySharedMemoryRegion getReadOnlyShmemRegion() {
    if (this.mTag != 1) {
      throw new AssertionError();
    }
    return this.mReadOnlyShmemRegion;
  }

  public void setMailboxHandles(MailboxBufferHandleSet mailboxHandles) {
    this.mTag = 2;
    this.mMailboxHandles = mailboxHandles;
  }

  public MailboxBufferHandleSet getMailboxHandles() {
    if (this.mTag != 2) {
      throw new AssertionError();
    }
    return this.mMailboxHandles;
  }

  public void setGpuMemoryBufferHandle(GpuMemoryBufferHandle gpuMemoryBufferHandle) {
    this.mTag = 3;
    this.mGpuMemoryBufferHandle = gpuMemoryBufferHandle;
  }

  public GpuMemoryBufferHandle getGpuMemoryBufferHandle() {
    if (this.mTag != 3) {
      throw new AssertionError();
    }
    return this.mGpuMemoryBufferHandle;
  }

  @Override
  public final void encode(Encoder encoder0, int offset) {
    encoder0.encode(16, offset);
    encoder0.encode(this.mTag, offset + 4);
    switch (this.mTag) {
      case 0:
        encoder0.encode((Struct) this.mUnsafeShmemRegion, offset + 8, false);
        return;
      case 1:
        encoder0.encode((Struct) this.mReadOnlyShmemRegion, offset + 8, false);
        return;
      case 2:
        encoder0.encode((Struct) this.mMailboxHandles, offset + 8, false);
        return;
      case 3:
        encoder0.encode((Struct) this.mGpuMemoryBufferHandle, offset + 8, false);
        return;
      default:
        return;
    }
  }

  public static VideoBufferHandle deserialize(Message message) {
    return decode(new Decoder(message).decoderForSerializedUnion(), 0);
  }

  public static final VideoBufferHandle decode(Decoder decoder0, int offset) {
    DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
    if (dataHeader.size == 0) {
      return null;
    }
    VideoBufferHandle result = new VideoBufferHandle();
    switch (dataHeader.elementsOrVersion) {
      case 0:
        Decoder decoder1 = decoder0.readPointer(offset + 8, false);
        result.mUnsafeShmemRegion = UnsafeSharedMemoryRegion.decode(decoder1);
        result.mTag = 0;
        break;
      case 1:
        Decoder decoder12 = decoder0.readPointer(offset + 8, false);
        result.mReadOnlyShmemRegion = ReadOnlySharedMemoryRegion.decode(decoder12);
        result.mTag = 1;
        break;
      case 2:
        Decoder decoder13 = decoder0.readPointer(offset + 8, false);
        result.mMailboxHandles = MailboxBufferHandleSet.decode(decoder13);
        result.mTag = 2;
        break;
      case 3:
        Decoder decoder14 = decoder0.readPointer(offset + 8, false);
        result.mGpuMemoryBufferHandle = GpuMemoryBufferHandle.decode(decoder14);
        result.mTag = 3;
        break;
    }
    return result;
  }
}
