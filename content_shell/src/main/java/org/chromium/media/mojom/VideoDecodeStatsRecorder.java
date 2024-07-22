package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;

public interface VideoDecodeStatsRecorder extends Interface {
  public static final Interface.Manager<VideoDecodeStatsRecorder, Proxy> MANAGER =
      VideoDecodeStatsRecorder_Internal.MANAGER;

  public interface Proxy extends VideoDecodeStatsRecorder, Interface.Proxy {}

  void startNewRecord(PredictionFeatures predictionFeatures);

  void updateRecord(PredictionTargets predictionTargets);
}
