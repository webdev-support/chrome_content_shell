package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;

public interface VideoDecodePerfHistory extends Interface {
  public static final Interface.Manager<VideoDecodePerfHistory, Proxy> MANAGER =
      VideoDecodePerfHistory_Internal.MANAGER;

  public interface GetPerfInfo_Response {
    void call(boolean z, boolean z2);
  }

  public interface Proxy extends VideoDecodePerfHistory, Interface.Proxy {}

  void getPerfInfo(
      PredictionFeatures predictionFeatures, GetPerfInfo_Response getPerfInfo_Response);
}
