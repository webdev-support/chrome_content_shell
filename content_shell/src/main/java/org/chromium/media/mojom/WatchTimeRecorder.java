package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.TimeDelta;

public interface WatchTimeRecorder extends Interface {
  public static final Interface.Manager<WatchTimeRecorder, Proxy> MANAGER =
      WatchTimeRecorder_Internal.MANAGER;

  public interface Proxy extends WatchTimeRecorder, Interface.Proxy {}

  void finalizeWatchTime(int[] iArr);

  void onDurationChanged(TimeDelta timeDelta);

  void onError(PipelineStatus pipelineStatus);

  void recordWatchTime(int i, TimeDelta timeDelta);

  void setAutoplayInitiated(boolean z);

  void updateSecondaryProperties(SecondaryPlaybackProperties secondaryPlaybackProperties);

  void updateUnderflowCount(int i);

  void updateUnderflowDuration(int i, TimeDelta timeDelta);

  void updateVideoDecodeStats(int i, int i2);
}
