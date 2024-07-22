package org.chromium.shape_detection.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.skia.mojom.BitmapN32;

public interface BarcodeDetection extends Interface {
  public static final Interface.Manager<BarcodeDetection, Proxy> MANAGER =
      BarcodeDetection_Internal.MANAGER;

  public interface Detect_Response {
    void call(BarcodeDetectionResult[] barcodeDetectionResultArr);
  }

  public interface Proxy extends BarcodeDetection, Interface.Proxy {}

  void detect(BitmapN32 bitmapN32, Detect_Response detect_Response);
}
