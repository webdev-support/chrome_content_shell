package org.chromium.shape_detection.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.skia.mojom.BitmapN32;

public interface FaceDetection extends Interface {
  public static final Interface.Manager<FaceDetection, Proxy> MANAGER =
      FaceDetection_Internal.MANAGER;

  public interface Detect_Response {
    void call(FaceDetectionResult[] faceDetectionResultArr);
  }

  public interface Proxy extends FaceDetection, Interface.Proxy {}

  void detect(BitmapN32 bitmapN32, Detect_Response detect_Response);
}
