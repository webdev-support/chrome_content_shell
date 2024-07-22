package org.chromium.shape_detection.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

public interface ShapeDetectionService extends Interface {
  public static final Interface.Manager<ShapeDetectionService, Proxy> MANAGER =
      ShapeDetectionService_Internal.MANAGER;

  public interface Proxy extends ShapeDetectionService, Interface.Proxy {}

  void bindBarcodeDetectionProvider(InterfaceRequest<BarcodeDetectionProvider> interfaceRequest);

  void bindFaceDetectionProvider(InterfaceRequest<FaceDetectionProvider> interfaceRequest);

  void bindTextDetection(InterfaceRequest<TextDetection> interfaceRequest);
}
