package org.chromium.handwriting.mojom;

import org.chromium.mojo.bindings.Interface;

public interface HandwritingRecognizer extends Interface {
  public static final Interface.Manager<HandwritingRecognizer, Proxy> MANAGER =
      HandwritingRecognizer_Internal.MANAGER;

  public interface GetPrediction_Response {
    void call(HandwritingPrediction[] handwritingPredictionArr);
  }

  public interface Proxy extends HandwritingRecognizer, Interface.Proxy {}

  void getPrediction(
      HandwritingStroke[] handwritingStrokeArr,
      HandwritingHints handwritingHints,
      GetPrediction_Response getPrediction_Response);
}
