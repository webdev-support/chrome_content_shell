package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;

public interface WebrtcVideoPerfHistory extends Interface {
  public static final Manager<WebrtcVideoPerfHistory, Proxy> MANAGER =
      WebrtcVideoPerfHistory_Internal.MANAGER;

  public interface GetPerfInfo_Response {
    void call(boolean z);
  }

  public interface Proxy extends WebrtcVideoPerfHistory, Interface.Proxy {}

  void getPerfInfo(
      WebrtcPredictionFeatures webrtcPredictionFeatures,
      int i,
      GetPerfInfo_Response getPerfInfo_Response);
}
