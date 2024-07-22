package org.chromium.viz.mojom;

import org.chromium.gfx.mojom.GpuMemoryBufferHandle;
import org.chromium.gfx.mojom.GpuMemoryBufferId;
import org.chromium.gfx.mojom.Size;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.UnsafeSharedMemoryRegion;

public interface GpuMemoryBufferFactory extends Interface {
  public static final Interface.Manager<GpuMemoryBufferFactory, Proxy> MANAGER =
      GpuMemoryBufferFactory_Internal.MANAGER;

  public interface CopyGpuMemoryBuffer_Response {
    void call(boolean z);
  }

  public interface CreateGpuMemoryBuffer_Response {
    void call(GpuMemoryBufferHandle gpuMemoryBufferHandle);
  }

  public interface Proxy extends GpuMemoryBufferFactory, Interface.Proxy {}

  void copyGpuMemoryBuffer(
      GpuMemoryBufferHandle gpuMemoryBufferHandle,
      UnsafeSharedMemoryRegion unsafeSharedMemoryRegion,
      CopyGpuMemoryBuffer_Response copyGpuMemoryBuffer_Response);

  void createGpuMemoryBuffer(
      GpuMemoryBufferId gpuMemoryBufferId,
      Size size,
      int i,
      int i2,
      CreateGpuMemoryBuffer_Response createGpuMemoryBuffer_Response);

  void destroyGpuMemoryBuffer(GpuMemoryBufferId gpuMemoryBufferId);
}
