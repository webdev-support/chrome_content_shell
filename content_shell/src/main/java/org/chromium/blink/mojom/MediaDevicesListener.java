package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface MediaDevicesListener extends Interface {
  public static final Interface.Manager<MediaDevicesListener, Proxy> MANAGER =
      MediaDevicesListener_Internal.MANAGER;

  public interface Proxy extends MediaDevicesListener, Interface.Proxy {}

  void onDevicesChanged(int i, MediaDeviceInfo[] mediaDeviceInfoArr);
}
