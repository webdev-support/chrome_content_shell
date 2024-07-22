package org.chromium.shape_detection.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

public interface BarcodeDetectionProvider extends Interface {
  public static final Interface.Manager<BarcodeDetectionProvider, Proxy> MANAGER =
      BarcodeDetectionProvider_Internal.MANAGER;

  public interface EnumerateSupportedFormats_Response {
    void call(int[] iArr);
  }

  public interface Proxy extends BarcodeDetectionProvider, Interface.Proxy {}

  void createBarcodeDetection(
      InterfaceRequest<BarcodeDetection> interfaceRequest,
      BarcodeDetectorOptions barcodeDetectorOptions);

  void enumerateSupportedFormats(
      EnumerateSupportedFormats_Response enumerateSupportedFormats_Response);
}
