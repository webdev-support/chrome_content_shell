package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface MediaStreamTrackMetricsHost extends Interface {
  public static final Interface.Manager<MediaStreamTrackMetricsHost, Proxy> MANAGER =
      MediaStreamTrackMetricsHost_Internal.MANAGER;

  public interface Proxy extends MediaStreamTrackMetricsHost, Interface.Proxy {}

  void addTrack(long j, boolean z, boolean z2);

  void removeTrack(long j);
}
