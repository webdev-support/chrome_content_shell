package org.chromium.media.mojom;

import org.chromium.gfx.mojom.Size;
import org.chromium.mojo.bindings.Interface;

public interface VideoEncodeAcceleratorClient extends Interface {
  public static final Interface.Manager<VideoEncodeAcceleratorClient, Proxy> MANAGER =
      VideoEncodeAcceleratorClient_Internal.MANAGER;

  public interface Proxy extends VideoEncodeAcceleratorClient, Interface.Proxy {}

  void bitstreamBufferReady(int i, BitstreamBufferMetadata bitstreamBufferMetadata);

  void notifyEncoderInfoChange(VideoEncoderInfo videoEncoderInfo);

  void notifyErrorStatus(EncoderStatus encoderStatus);

  void requireBitstreamBuffers(int i, Size size, int i2);
}
