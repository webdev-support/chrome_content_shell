package org.chromium.media.mojom;

import org.chromium.gfx.mojom.Size;
import org.chromium.mojo.bindings.Interface;

public interface VideoEncoderMetricsProvider extends Interface {
  public static final Interface.Manager<VideoEncoderMetricsProvider, Proxy> MANAGER =
      VideoEncoderMetricsProvider_Internal.MANAGER;

  public interface Proxy extends VideoEncoderMetricsProvider, Interface.Proxy {}

  void complete(long j);

  void initialize(long j, int i, int i2, Size size, boolean z, int i3);

  void setEncodedFrameCount(long j, long j2);

  void setError(long j, EncoderStatus encoderStatus);
}
