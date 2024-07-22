package org.chromium.viz.mojom;

import org.chromium.mojo.bindings.Interface;

public interface VideoDetectorObserver extends Interface {
  public static final Interface.Manager<VideoDetectorObserver, Proxy> MANAGER =
      VideoDetectorObserver_Internal.MANAGER;

  public interface Proxy extends VideoDetectorObserver, Interface.Proxy {}

  void onVideoActivityEnded();

  void onVideoActivityStarted();
}
