package org.chromium.shape_detection.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

public interface FaceDetectionProvider extends Interface {
  public static final Interface.Manager<FaceDetectionProvider, Proxy> MANAGER =
      FaceDetectionProvider_Internal.MANAGER;

  public interface Proxy extends FaceDetectionProvider, Interface.Proxy {}

  void createFaceDetection(
      InterfaceRequest<FaceDetection> interfaceRequest, FaceDetectorOptions faceDetectorOptions);
}
