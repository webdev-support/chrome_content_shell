package org.chromium.viz.mojom;

import org.chromium.gpu.mojom.ClientGmbInterface;
import org.chromium.gpu.mojom.GpuFeatureInfo;
import org.chromium.gpu.mojom.GpuInfo;
import org.chromium.gpu.mojom.SharedImageCapabilities;
import org.chromium.media.mojom.VideoEncodeAcceleratorProvider;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.system.MessagePipeHandle;

public interface Gpu extends Interface {
  public static final Interface.Manager<Gpu, Proxy> MANAGER = Gpu_Internal.MANAGER;

  public interface EstablishGpuChannel_Response {
    void call(
        int i,
        MessagePipeHandle messagePipeHandle,
        GpuInfo gpuInfo,
        GpuFeatureInfo gpuFeatureInfo,
        SharedImageCapabilities sharedImageCapabilities);
  }

  public interface Proxy extends Gpu, Interface.Proxy {}

  void createClientGpuMemoryBufferFactory(InterfaceRequest<ClientGmbInterface> interfaceRequest);

  void createGpuMemoryBufferFactory(InterfaceRequest<GpuMemoryBufferFactory> interfaceRequest);

  void createVideoEncodeAcceleratorProvider(
      InterfaceRequest<VideoEncodeAcceleratorProvider> interfaceRequest);

  void establishGpuChannel(EstablishGpuChannel_Response establishGpuChannel_Response);
}
