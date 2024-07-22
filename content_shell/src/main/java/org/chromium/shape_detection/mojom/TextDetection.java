package org.chromium.shape_detection.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.skia.mojom.BitmapN32;

public interface TextDetection extends Interface {
  public static final Interface.Manager<TextDetection, Proxy> MANAGER =
      TextDetection_Internal.MANAGER;

  public interface Detect_Response {
    void call(TextDetectionResult[] textDetectionResultArr);
  }

  public interface Proxy extends TextDetection, Interface.Proxy {}

  void detect(BitmapN32 bitmapN32, Detect_Response detect_Response);
}
