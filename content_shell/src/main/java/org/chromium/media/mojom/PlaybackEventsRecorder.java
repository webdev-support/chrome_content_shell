package org.chromium.media.mojom;

import org.chromium.gfx.mojom.Size;
import org.chromium.mojo.bindings.Interface;

public interface PlaybackEventsRecorder extends Interface {
  public static final Interface.Manager<PlaybackEventsRecorder, Proxy> MANAGER =
      PlaybackEventsRecorder_Internal.MANAGER;

  public interface Proxy extends PlaybackEventsRecorder, Interface.Proxy {}

  void onBuffering();

  void onBufferingComplete();

  void onEnded();

  void onError(PipelineStatus pipelineStatus);

  void onNaturalSizeChanged(Size size);

  void onPaused();

  void onPipelineStatistics(PipelineStatistics pipelineStatistics);

  void onPlaying();

  void onSeeking();
}
