package org.chromium.media.mojom;

import org.chromium.gfx.mojom.Size;
import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.UnsafeSharedMemoryRegion;

public interface VideoEncodeAccelerator extends Interface {
  public static final Interface.Manager<VideoEncodeAccelerator, Proxy> MANAGER =
      VideoEncodeAccelerator_Internal.MANAGER;

  public interface Encode_Response {
    void call();
  }

  public interface Flush_Response {
    void call(boolean z);
  }

  public interface Initialize_Response {
    void call(boolean z);
  }

  public interface IsFlushSupported_Response {
    void call(boolean z);
  }

  public interface Proxy extends VideoEncodeAccelerator, Interface.Proxy {}

  void encode(
      VideoFrame videoFrame,
      VideoEncodeOptions videoEncodeOptions,
      Encode_Response encode_Response);

  void flush(Flush_Response flush_Response);

  void initialize(
      VideoEncodeAcceleratorConfig videoEncodeAcceleratorConfig,
      AssociatedInterfaceNotSupported associatedInterfaceNotSupported,
      MediaLog mediaLog,
      Initialize_Response initialize_Response);

  void isFlushSupported(IsFlushSupported_Response isFlushSupported_Response);

  void requestEncodingParametersChangeWithBitrate(Bitrate bitrate, int i, Size size);

  void requestEncodingParametersChangeWithLayers(
      VideoBitrateAllocation videoBitrateAllocation, int i, Size size);

  void useOutputBitstreamBuffer(int i, UnsafeSharedMemoryRegion unsafeSharedMemoryRegion);
}
