package org.chromium.media.mojom;

import org.chromium.media.learning.mojom.LearningTaskController;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo_base.mojom.TimeDelta;

public interface MediaMetricsProvider extends Interface {
  public static final Interface.Manager<MediaMetricsProvider, Proxy> MANAGER =
      MediaMetricsProvider_Internal.MANAGER;

  public interface Proxy extends MediaMetricsProvider, Interface.Proxy {}

  void acquireLearningTaskController(
      String str, InterfaceRequest<LearningTaskController> interfaceRequest);

  void acquirePlaybackEventsRecorder(InterfaceRequest<PlaybackEventsRecorder> interfaceRequest);

  void acquireVideoDecodeStatsRecorder(InterfaceRequest<VideoDecodeStatsRecorder> interfaceRequest);

  void acquireWatchTimeRecorder(
      PlaybackProperties playbackProperties, InterfaceRequest<WatchTimeRecorder> interfaceRequest);

  void initialize(boolean z, int i, int i2);

  void onError(PipelineStatus pipelineStatus);

  void onFallback(PipelineStatus pipelineStatus);

  void onStarted(PipelineStatus pipelineStatus);

  void setAudioPipelineInfo(AudioPipelineInfo audioPipelineInfo);

  void setContainerName(int i);

  void setHasAudio(int i);

  void setHasPlayed();

  void setHasVideo(int i);

  void setHasWaitingForKey();

  void setHaveEnough();

  void setIsEme();

  void setIsHardwareSecure();

  void setKeySystem(String str);

  void setRendererType(int i);

  void setTimeToFirstFrame(TimeDelta timeDelta);

  void setTimeToMetadata(TimeDelta timeDelta);

  void setTimeToPlayReady(TimeDelta timeDelta);

  void setVideoPipelineInfo(VideoPipelineInfo videoPipelineInfo);
}
