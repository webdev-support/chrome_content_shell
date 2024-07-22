package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;

public interface VideoCaptureObserver extends Interface {
  public static final Interface.Manager<VideoCaptureObserver, Proxy> MANAGER =
      VideoCaptureObserver_Internal.MANAGER;

  public interface Proxy extends VideoCaptureObserver, Interface.Proxy {}

  void onBufferDestroyed(int i);

  void onBufferReady(ReadyBuffer readyBuffer);

  void onFrameDropped(int i);

  void onNewBuffer(int i, VideoBufferHandle videoBufferHandle);

  void onNewSubCaptureTargetVersion(int i);

  void onStateChanged(VideoCaptureResult videoCaptureResult);
}
