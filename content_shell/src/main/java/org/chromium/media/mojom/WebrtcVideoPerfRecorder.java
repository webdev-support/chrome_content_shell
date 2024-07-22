package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;

public interface WebrtcVideoPerfRecorder extends Interface {
  public static final Manager<WebrtcVideoPerfRecorder, Proxy> MANAGER =
      WebrtcVideoPerfRecorder_Internal.MANAGER;

  public interface Proxy extends WebrtcVideoPerfRecorder, Interface.Proxy {}

  void updateRecord(
      WebrtcPredictionFeatures webrtcPredictionFeatures, WebrtcVideoStats webrtcVideoStats);
}
