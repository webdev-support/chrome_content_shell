package org.chromium.handwriting.mojom;

import org.chromium.mojo.bindings.Interface;

public interface HandwritingRecognitionService extends Interface {
  public static final Interface.Manager<HandwritingRecognitionService, Proxy> MANAGER =
      HandwritingRecognitionService_Internal.MANAGER;

  public interface CreateHandwritingRecognizer_Response {
    void call(int i, HandwritingRecognizer handwritingRecognizer);
  }

  public interface Proxy extends HandwritingRecognitionService, Interface.Proxy {}

  public interface QueryHandwritingRecognizer_Response {
    void call(QueryHandwritingRecognizerResult queryHandwritingRecognizerResult);
  }

  void createHandwritingRecognizer(
      HandwritingModelConstraint handwritingModelConstraint,
      CreateHandwritingRecognizer_Response createHandwritingRecognizer_Response);

  void queryHandwritingRecognizer(
      HandwritingModelConstraint handwritingModelConstraint,
      QueryHandwritingRecognizer_Response queryHandwritingRecognizer_Response);
}
