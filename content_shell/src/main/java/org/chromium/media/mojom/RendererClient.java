package org.chromium.media.mojom;

import org.chromium.gfx.mojom.Size;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.TimeDelta;
import org.chromium.mojo_base.mojom.TimeTicks;

public interface RendererClient extends Interface {
  public static final Interface.Manager<RendererClient, Proxy> MANAGER =
      RendererClient_Internal.MANAGER;

  public interface Proxy extends RendererClient, Interface.Proxy {}

  void onAudioConfigChange(AudioDecoderConfig audioDecoderConfig);

  void onBufferingStateChange(int i, int i2);

  void onEnded();

  void onError(PipelineStatus pipelineStatus);

  void onStatisticsUpdate(PipelineStatistics pipelineStatistics);

  void onTimeUpdate(TimeDelta timeDelta, TimeDelta timeDelta2, TimeTicks timeTicks);

  void onVideoConfigChange(VideoDecoderConfig videoDecoderConfig);

  void onVideoNaturalSizeChange(Size size);

  void onVideoOpacityChange(boolean z);

  void onWaiting(int i);
}
